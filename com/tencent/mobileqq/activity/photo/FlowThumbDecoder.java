package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FlowThumbDecoder extends BaseThumbDecoder implements BitmapDecoder {
    static IPatchRedirector $redirector_ = null;
    static final int SCALE_MODE_BY_HEIGHT = 2;
    static final int SCALE_MODE_BY_WIDTH = 1;
    static final int SCALE_MODE_DEFAULT = 0;
    static final int SCALE_MODE_ERROR = -1;
    static final String TAG = "QQAlbum";
    public static float sFlowItemHeight;
    public static float sFlowItemMaxWidth;
    public static float sFlowItemMinWidth;
    public static float sRatioMax;
    public static float sRatioMin;
    private Context mContext;
    private float mDensity;
    LocalMediaInfo mInfo;

    public FlowThumbDecoder(Context context, LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) localMediaInfo);
            return;
        }
        Resources resources = context.getResources();
        this.mDensity = resources.getDisplayMetrics().density;
        sFlowItemHeight = resources.getDimension(R.dimen.f158877re);
        sFlowItemMaxWidth = resources.getDimension(R.dimen.f158875rc);
        float dimension = resources.getDimension(R.dimen.f158876rd);
        sFlowItemMinWidth = dimension;
        float f16 = sFlowItemMaxWidth;
        float f17 = sFlowItemHeight;
        sRatioMax = f16 / f17;
        sRatioMin = dimension / f17;
        if (f17 != 0.0f) {
            this.mInfo = localMediaInfo;
            this.mContext = context;
            return;
        }
        throw new RuntimeException("Not init item size...");
    }

    private static int calcSampleSizeByShortSide(int i3, int i16) {
        int i17 = 1;
        while (i3 > i16 * 1.2f) {
            i17 *= 2;
            i3 /= 2;
        }
        return i17;
    }

    public static void determineThumbSize(LocalMediaInfo localMediaInfo, int i3, int i16) {
        int scaleMode = getScaleMode(localMediaInfo, i3, i16);
        if (scaleMode == 0) {
            int i17 = localMediaInfo.thumbWidth;
            if (i17 <= 0) {
                localMediaInfo.thumbWidth = (localMediaInfo.thumbHeight * i3) / i16;
                return;
            } else {
                if (localMediaInfo.thumbHeight <= 0) {
                    localMediaInfo.thumbHeight = (i17 * i16) / i3;
                    return;
                }
                return;
            }
        }
        if (scaleMode == 1) {
            if (localMediaInfo.thumbWidth <= 0) {
                localMediaInfo.thumbWidth = (int) sFlowItemMinWidth;
                return;
            } else {
                if (localMediaInfo.thumbHeight <= 0) {
                    localMediaInfo.thumbHeight = (int) sFlowItemMinWidth;
                    return;
                }
                return;
            }
        }
        if (scaleMode == 2) {
            if (localMediaInfo.thumbWidth <= 0) {
                localMediaInfo.thumbWidth = (int) sFlowItemMaxWidth;
            } else if (localMediaInfo.thumbHeight <= 0) {
                localMediaInfo.thumbHeight = (int) sFlowItemMaxWidth;
            }
        }
    }

    private static Rect getRect(LocalMediaInfo localMediaInfo, int i3, int i16, int i17, int i18) {
        if (i3 == 1) {
            if (i18 != 90 && i18 != 270) {
                int i19 = (localMediaInfo.thumbHeight * i16) / localMediaInfo.thumbWidth;
                int i26 = (i17 - i19) / 2;
                return new Rect(0, i26, i16, i19 + i26);
            }
            int i27 = (localMediaInfo.thumbWidth * i17) / localMediaInfo.thumbHeight;
            int i28 = (i16 - i27) / 2;
            return new Rect(i28, 0, i27 + i28, i17);
        }
        if (i3 == 2) {
            if (i18 != 90 && i18 != 270) {
                int i29 = (localMediaInfo.thumbWidth * i17) / localMediaInfo.thumbHeight;
                int i36 = (i16 - i29) / 2;
                return new Rect(i36, 0, i29 + i36, i17);
            }
            int i37 = (localMediaInfo.thumbHeight * i16) / localMediaInfo.thumbWidth;
            int i38 = (i17 - i37) / 2;
            return new Rect(0, i38, i16, i37 + i38);
        }
        return null;
    }

    public static int getScaleMode(LocalMediaInfo localMediaInfo, int i3, int i16) {
        float f16;
        float f17;
        if (i3 == 0 || i16 == 0) {
            return -1;
        }
        int i17 = localMediaInfo.orientation;
        if (i17 != 90 && i17 != 270) {
            f16 = i3;
            f17 = i16;
        } else {
            f16 = i16;
            f17 = i3;
        }
        float f18 = f16 / f17;
        if (Float.compare(f18, sRatioMin) != -1 && Float.compare(f18, sRatioMax) != 1) {
            return 0;
        }
        if (Float.compare(f18, sRatioMin) == -1) {
            return 1;
        }
        return 2;
    }

    public static Bitmap getScaledBitmap(Context context, LocalMediaInfo localMediaInfo, BitmapFactory.Options options, int i3) {
        Bitmap bitmap;
        if (i3 == 1) {
            options.inSampleSize = calcSampleSizeByShortSide(options.outWidth, localMediaInfo.thumbWidth);
        } else if (i3 == 2) {
            options.inSampleSize = calcSampleSizeByShortSide(options.outHeight, localMediaInfo.thumbHeight);
        } else {
            options.inSampleSize = calcSampleSizeByShortSide(options.outWidth, localMediaInfo.thumbWidth);
        }
        try {
            bitmap = getThumb(context, localMediaInfo, options);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            bitmap = null;
        }
        if (bitmap == null) {
            if (QLog.isColorLevel()) {
                QLog.e("QQAlbum", 2, "decode bitmap return null,maybe oom");
            }
            return bitmap;
        }
        return scaleBitmap(localMediaInfo, i3, bitmap);
    }

    protected static Bitmap getThumb(Context context, LocalMediaInfo localMediaInfo, BitmapFactory.Options options) {
        Bitmap createVideoThumbnail;
        int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
        if (mediaType == 0) {
            return BaseThumbDecoder.realDecodeBitmap(localMediaInfo, options, "QQAlbum");
        }
        if (mediaType == 1) {
            if (localMediaInfo.isSystemMeidaStore) {
                createVideoThumbnail = MediaStore.Video.Thumbnails.getThumbnail(context.getContentResolver(), localMediaInfo._id, 1, options);
            } else {
                createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(localMediaInfo.path, 1);
            }
            if (createVideoThumbnail != null) {
                options.outHeight = createVideoThumbnail.getHeight();
                options.outWidth = createVideoThumbnail.getWidth();
                return createVideoThumbnail;
            }
            return createVideoThumbnail;
        }
        return null;
    }

    public static Bitmap rotate(Bitmap bitmap, int i3) {
        if (i3 != 0 && bitmap != null && !bitmap.isRecycled()) {
            Matrix matrix = new Matrix();
            matrix.setRotate(i3, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (bitmap != createBitmap) {
                    bitmap.recycle();
                    return createBitmap;
                }
                return bitmap;
            } catch (OutOfMemoryError e16) {
                throw e16;
            }
        }
        return bitmap;
    }

    private static Bitmap scaleBitmap(LocalMediaInfo localMediaInfo, int i3, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i16 = localMediaInfo.orientation;
        if (i3 == 0 && BaseThumbDecoder.checkBitmapValid(localMediaInfo, bitmap, i16)) {
            return bitmap;
        }
        Rect rect = getRect(localMediaInfo, i3, width, height, i16);
        Rect rect2 = new Rect(0, 0, localMediaInfo.thumbWidth, localMediaInfo.thumbHeight);
        Bitmap createBitmap = Bitmap.createBitmap(localMediaInfo.thumbWidth, localMediaInfo.thumbHeight, Bitmap.Config.RGB_565);
        if (createBitmap != null) {
            new Canvas(createBitmap).drawBitmap(bitmap, rect, rect2, new Paint(6));
            bitmap.recycle();
            if (i16 != 0) {
                createBitmap = rotate(createBitmap, i16);
            }
            if (QLog.isColorLevel()) {
                QLog.i("QQAlbum", 2, "FlowThumbDecoder src " + rect + ", dst " + rect2);
            }
            return createBitmap;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder
    public Bitmap getBitmap(URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        Context context = this.mContext;
        LocalMediaInfo localMediaInfo = this.mInfo;
        int exifRotation = URLDrawableHelper.getExifRotation(localMediaInfo.path);
        if (exifRotation != 0 && exifRotation != localMediaInfo.orientation) {
            QLog.w("QQAlbum", 1, "FlowThumbDecoder rotation not same, rotation:" + exifRotation + " info orientation: " + localMediaInfo.orientation);
            localMediaInfo.orientation = exifRotation;
        }
        if (exifRotation != 90 && exifRotation != 270) {
            localMediaInfo.thumbWidth = 0;
            localMediaInfo.thumbHeight = (int) sFlowItemHeight;
        } else {
            localMediaInfo.thumbWidth = (int) sFlowItemHeight;
            localMediaInfo.thumbHeight = 0;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        getThumb(context, localMediaInfo, options);
        if (options.outWidth != 0 && options.outHeight != 0) {
            if (QLog.isColorLevel()) {
                QLog.i("QQAlbum", 2, "FlowThumbDecoder origin w " + options.outWidth + " h " + options.outHeight);
            }
            options.inJustDecodeBounds = false;
            int scaleMode = getScaleMode(localMediaInfo, options.outWidth, options.outHeight);
            if (localMediaInfo.thumbWidth <= 0 || localMediaInfo.thumbHeight <= 0) {
                determineThumbSize(localMediaInfo, options.outWidth, options.outHeight);
            }
            return getScaledBitmap(context, localMediaInfo, options, scaleMode);
        }
        return null;
    }
}
