package com.tencent.mobileqq.guild.media.pic.api.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* loaded from: classes14.dex */
public class GuildPicAIOImpl implements IGuildPicAIO {
    protected static final int AIO_IMAGE_DYNAMIC_MAX;
    protected static final int AIO_IMAGE_MAX_SIZE_H;
    protected static final int AIO_IMAGE_MAX_SIZE_W;
    protected static final int AIO_IMAGE_MIN_SIZE_H;
    protected static final int AIO_IMAGE_MIN_SIZE_W;
    private static final String TAG = "GuildPicAIOImpl";
    protected static float density = -1.0f;
    protected static int densityDpi = -1;

    static {
        int contentview_max_width_size = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getCONTENTVIEW_MAX_WIDTH_SIZE();
        AIO_IMAGE_MAX_SIZE_W = contentview_max_width_size;
        AIO_IMAGE_MAX_SIZE_H = (int) (contentview_max_width_size * 1.52f);
        AIO_IMAGE_MIN_SIZE_W = (int) (contentview_max_width_size * 0.3f);
        AIO_IMAGE_MIN_SIZE_H = (int) (contentview_max_width_size * 0.3f);
        AIO_IMAGE_DYNAMIC_MAX = (int) (getDensity() * 129.0f);
    }

    private int[] fixPicSize(long j3, long j16) {
        int i3 = (int) j3;
        int i16 = (int) j16;
        float f16 = (float) j3;
        float f17 = (float) j16;
        if (f16 >= f17 * 3.0f) {
            i3 = (int) ((i16 * 16.0f) / 9.0f);
        } else if (f17 >= f16 * 3.0f) {
            i16 = (int) ((i3 * 7.0f) / 3.0f);
        }
        return new int[]{i3, i16};
    }

    public static float getDensity() {
        if (density == -1.0f) {
            float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
            density = f16;
            if (f16 <= 0.0f) {
                density = 1.0f;
            }
        }
        return density;
    }

    private static int getDensityDpi() {
        if (densityDpi == -1) {
            int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
            densityDpi = i3;
            if (i3 <= 0) {
                densityDpi = 1;
            }
        }
        return densityDpi;
    }

    @Override // com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO
    public long getGroupPicSizeLimit() {
        return ((IPicBus) QRoute.api(IPicBus.class)).getGroupPicSizeLimit();
    }

    @Override // com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO
    public File getGuildChatImageFile(Object obj) {
        if (obj instanceof DownloadParams) {
            Object obj2 = ((DownloadParams) obj).tag;
            if (obj2 instanceof MessageForPic) {
                MessageForPic messageForPic = (MessageForPic) obj2;
                File file = AbsDownloader.getFile(((IPicHelper) QRoute.api(IPicHelper.class)).getURL(messageForPic, 1, (String) null).toString());
                if (file == null && messageForPic.isSendFromLocal()) {
                    v picUploadInfo = messageForPic.getPicUploadInfo();
                    if (FileUtils.fileExists(picUploadInfo.K)) {
                        CompressInfo compressInfo = new CompressInfo(picUploadInfo.K, 0);
                        compressInfo.f258514d = picUploadInfo.f258711e;
                        ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
                        return new File(compressInfo.H);
                    }
                    return file;
                }
                return file;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO
    public Bitmap getThumbBitmap(Bitmap bitmap, int i3, int i16) {
        if (bitmap.getWidth() > bitmap.getHeight() && i3 < i16) {
            i16 = i3;
            i3 = i16;
        }
        if (i3 <= 0 || i16 <= 0) {
            i16 = bitmap.getHeight();
            i3 = bitmap.getWidth();
        }
        int[] fixPicSize = fixPicSize(bitmap.getWidth(), bitmap.getHeight());
        int i17 = fixPicSize[0];
        int i18 = fixPicSize[1];
        int[] thumbSize = getThumbSize(i3, i16, false);
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        Bitmap createBitmap = Bitmap.createBitmap(thumbSize[0], thumbSize[1], bitmap.getConfig());
        createBitmap.setDensity(getDensityDpi());
        new Canvas(createBitmap).drawBitmap(bitmap, new Rect(0, 0, i17, i18), new Rect(0, 0, thumbSize[0], thumbSize[1]), paint);
        return createBitmap;
    }

    @Override // com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO
    public int[] getThumbMaxDp(boolean z16) {
        int[] thumbMaxPx = getThumbMaxPx(z16);
        return new int[]{(int) (thumbMaxPx[0] / getDensity()), (int) (thumbMaxPx[1] / getDensity())};
    }

    @Override // com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO
    public int[] getThumbMaxPx(boolean z16) {
        if (z16) {
            int i3 = AIO_IMAGE_DYNAMIC_MAX;
            return new int[]{i3, i3};
        }
        return new int[]{AIO_IMAGE_MAX_SIZE_W, AIO_IMAGE_MAX_SIZE_H};
    }

    @Override // com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO
    public int[] getThumbMinDp(boolean z16) {
        int[] thumbMaxPx = getThumbMaxPx(z16);
        return new int[]{(int) (thumbMaxPx[0] / getDensity()), (int) (thumbMaxPx[1] / getDensity())};
    }

    @Override // com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO
    public int[] getThumbMinPx(boolean z16) {
        if (z16) {
            int i3 = AIO_IMAGE_DYNAMIC_MAX;
            return new int[]{i3, i3};
        }
        return new int[]{AIO_IMAGE_MIN_SIZE_W, AIO_IMAGE_MIN_SIZE_H};
    }

    @Override // com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO
    public int[] getThumbSize(long j3, long j16, boolean z16) {
        return getThumbSize(j3, j16, z16, null);
    }

    @Override // com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO
    public ThumbWidthHeightDP getThumbWidthHeightDPForGuildPicMsg() {
        ThumbWidthHeightDP thumbWidthHeightDP = new ThumbWidthHeightDP((int) (AIO_IMAGE_MIN_SIZE_W / getDensity()), (int) (AIO_IMAGE_MIN_SIZE_H / getDensity()), (int) (AIO_IMAGE_MAX_SIZE_W / getDensity()), (int) (AIO_IMAGE_MAX_SIZE_H / getDensity()));
        thumbWidthHeightDP.setmLimitSizeByGuild(true);
        return thumbWidthHeightDP;
    }

    @Override // com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO
    public boolean limitByGuild(Object obj) {
        if (!(obj instanceof DownloadParams)) {
            return false;
        }
        DownloadParams downloadParams = (DownloadParams) obj;
        if (!"chatthumb".equals(downloadParams.url.getProtocol())) {
            return false;
        }
        Object obj2 = downloadParams.tag;
        if (!(obj2 instanceof MessageForPic) || ((MessageRecord) obj2).istroop != 10014 || ((IPicHelper) QRoute.api(IPicHelper.class)).isEmotion((MessageForPic) downloadParams.tag)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO
    public int[] getThumbSize(long j3, long j16, boolean z16, @Nullable int[] iArr) {
        ThumbWidthHeightDP thumbWidthHeightDPForGuildPicMsg;
        if (iArr != null && iArr.length >= 4) {
            thumbWidthHeightDPForGuildPicMsg = new ThumbWidthHeightDP(iArr[0], iArr[1], iArr[2], iArr[3]);
        } else if (z16) {
            thumbWidthHeightDPForGuildPicMsg = CommonImgThumbHelper.getThumbWidthHeightDP(false);
        } else {
            thumbWidthHeightDPForGuildPicMsg = getThumbWidthHeightDPForGuildPicMsg();
        }
        float density2 = z16 ? 1.0f : getDensity();
        int i3 = (int) (thumbWidthHeightDPForGuildPicMsg.mMinWidth * density2);
        int i16 = (int) (thumbWidthHeightDPForGuildPicMsg.mMinHeight * density2);
        int i17 = (int) (thumbWidthHeightDPForGuildPicMsg.mMaxWidth * density2);
        int i18 = (int) (thumbWidthHeightDPForGuildPicMsg.mMaxHeight * density2);
        int[] fixPicSize = fixPicSize(j3, j16);
        int i19 = fixPicSize[0];
        float f16 = i19;
        int i26 = fixPicSize[1];
        float f17 = i26;
        if (f16 <= 0.0f || f17 <= 0.0f) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "MessageForPic without width/height of thumb, width = " + f16 + ", height = " + f17);
            }
            i3 = AIO_IMAGE_MIN_SIZE_W;
            i16 = AIO_IMAGE_MIN_SIZE_H;
        } else {
            float f18 = i3;
            if (f16 < f18 || f17 < i16) {
                if (!z16) {
                    int density3 = (int) (getDensity() * f16);
                    int density4 = (int) (getDensity() * f17);
                    if (density3 < i3 && density4 < i16) {
                        return new int[]{density3, density4};
                    }
                }
                if (f16 < f17) {
                    i16 = Math.min((int) (((f17 / f16) * f18) + 0.5f), i18);
                } else {
                    i3 = Math.min((int) (((f16 / f17) * i16) + 0.5f), i17);
                }
            } else {
                float f19 = i17;
                if (f16 >= f19 || f17 >= i18) {
                    float f26 = f16 / f19;
                    float f27 = f17 / i18;
                    if (f26 > f27) {
                        i16 = Math.max((int) ((f17 / f26) + 0.5f), i16);
                        i3 = i17;
                    } else {
                        i16 = i18;
                        i3 = Math.max((int) ((f16 / f27) + 0.5f), i3);
                    }
                } else {
                    i16 = i26;
                    i3 = i19;
                }
            }
        }
        float density5 = z16 ? getDensity() : 1.0f;
        return new int[]{(int) ((i3 * density5) + 0.5f), (int) ((i16 * density5) + 0.5f)};
    }
}
