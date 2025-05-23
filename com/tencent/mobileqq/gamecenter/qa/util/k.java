package com.tencent.mobileqq.gamecenter.qa.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaMetadataRetriever;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.util.BitmapUtil;
import cooperation.peak.PeakConstants;
import java.util.UUID;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class k {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends TransProcessorHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f212713a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f212714b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f212715c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ITransFileController f212716d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Looper looper, long j3, String str, b bVar, ITransFileController iTransFileController) {
            super(looper);
            this.f212713a = j3;
            this.f212714b = str;
            this.f212715c = bVar;
            this.f212716d = iTransFileController;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            float f16;
            FileMsg fileMsg = (FileMsg) message.obj;
            if (fileMsg == null || fileMsg.fileType != 24 || fileMsg.commandId != 94) {
                return;
            }
            if (this.f212713a != fileMsg.uniseq) {
                if (QLog.isColorLevel()) {
                    QLog.d("MediaUtil", 2, "uploadImage--uniqueSeq not same,uniqueSeq:" + this.f212713a + ",uniseq:" + fileMsg.uniseq);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MediaUtil", 2, "uploadImage--transProcessorHandler--handleMessage: what=" + message.what);
            }
            switch (message.what) {
                case 1002:
                    b bVar = this.f212715c;
                    if (bVar != null) {
                        long j3 = fileMsg.fileSize;
                        if (j3 <= 0) {
                            f16 = 0.0f;
                        } else {
                            f16 = (((float) fileMsg.transferedSize) * 1.0f) / ((float) j3);
                        }
                        bVar.onProgress(f16);
                        return;
                    }
                    return;
                case 1003:
                    Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
                    try {
                        uploadPicExtInfo.mergeFrom(fileMsg.bdhExtendInfo);
                        uploadPicExtInfo.bytes_file_resid.get().toStringUtf8();
                        String stringUtf8 = uploadPicExtInfo.bytes_download_url.get().toStringUtf8();
                        String stringUtf82 = uploadPicExtInfo.bytes_thumb_download_url.get().toStringUtf8();
                        if (QLog.isColorLevel()) {
                            QLog.i("MediaUtil", 2, "handleMessage imagePath[" + this.f212714b + "],imageUrl[" + stringUtf8 + "], imageThumbUrl" + stringUtf82 + ",uniqueSeq:" + this.f212713a + ",file-uniseq" + fileMsg.uniseq + "]");
                        }
                        b bVar2 = this.f212715c;
                        if (bVar2 != null) {
                            bVar2.onSuccess(stringUtf8);
                        }
                    } catch (Exception e16) {
                        QLog.e("MediaUtil", 1, e16, new Object[0]);
                    }
                    this.f212716d.removeHandle(this);
                    return;
                case 1004:
                case 1005:
                    b bVar3 = this.f212715c;
                    if (bVar3 != null) {
                        bVar3.onFail(fileMsg.errorCode);
                    }
                    this.f212716d.removeHandle(this);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void onFail(int i3);

        void onProgress(float f16);

        void onSuccess(String str);
    }

    public static void a(Activity activity) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 57);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).getPhotoListCustomizationAIOClassName());
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).getPhotoPreviewCustomizationAIOClassName());
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, "com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationAIO");
        activityURIRequest.extra().putBoolean(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, true);
        activityURIRequest.extra().putBoolean(PeakConstants.ALBUM_SHOW_ORI_BUTTON, false);
        activityURIRequest.extra().putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
        activityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", 9);
        activityURIRequest.extra().putInt(PeakConstants.SEND_BUSINESS_TYPE, 1058);
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        activityURIRequest.extra().putBoolean(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, true);
        activityURIRequest.extra().putBoolean(QAlbumConstants.ALBUM_ENTER_DIRECTLY, true);
        activityURIRequest.extra().putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        activityURIRequest.setRequestCode(10022);
        activityURIRequest.setFlags(603979776);
        QRoute.startUri(activityURIRequest);
        QAlbumUtil.anim(activity, false, true);
    }

    public static void b(Activity activity) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 57);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).getPhotoListCustomizationAIOClassName());
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).getPhotoPreviewCustomizationAIOClassName());
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, "com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationAIO");
        activityURIRequest.extra().putBoolean(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, false);
        activityURIRequest.extra().putLong(QAlbumConstants.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT, MiniBoxNoticeInfo.MIN_5);
        activityURIRequest.extra().putBoolean(PeakConstants.ALBUM_SHOW_ORI_BUTTON, false);
        activityURIRequest.extra().putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 2);
        activityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
        activityURIRequest.extra().putInt(PeakConstants.SEND_BUSINESS_TYPE, 1058);
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        activityURIRequest.extra().putBoolean(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, true);
        activityURIRequest.extra().putBoolean(QAlbumConstants.ALBUM_ENTER_DIRECTLY, true);
        activityURIRequest.extra().putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        activityURIRequest.extra().putBoolean(PeakConstants.VIDEO_EDIT_GAME_STRATEGY_PUBLISH, true);
        activityURIRequest.extra().putBoolean(PeakConstants.VIDEO_EDIT_ENABLED, true);
        activityURIRequest.setRequestCode(10023);
        activityURIRequest.setFlags(603979776);
        QRoute.startUri(activityURIRequest);
        QAlbumUtil.anim(activity, false, true);
    }

    public static int c(int i3) {
        return BaseApplication.context.getResources().getColor(i3);
    }

    private static URLDrawable.URLDrawableOptions d(int i3, int i16) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (i3 > 0 && i16 > 0) {
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i16;
        }
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mPlayGifImage = true;
        return obtain;
    }

    public static String e(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) <= 0) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String f(String str) {
        String e16 = e(str);
        if (TextUtils.isEmpty(e16)) {
            return "";
        }
        return "." + e16;
    }

    public static GradientDrawable g(int i3, int i16) {
        return h(0, i3, -1, i16);
    }

    public static GradientDrawable h(int i3, int i16, int i17, int i18) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i18);
        gradientDrawable.setCornerRadius(i16);
        gradientDrawable.setStroke(i3, i17);
        return gradientDrawable;
    }

    @NonNull
    public static int[] i(int i3, int i16, int i17, int i18) {
        if (i3 > 0 && i16 > 0) {
            int i19 = (int) (ah.f307408i * 100.0f);
            float f16 = i16;
            float f17 = i3;
            float f18 = f16 / f17;
            if (i16 <= i18 && i3 <= i17) {
                if (i16 < i19 || i3 < i19) {
                    if (f18 > 1.0f) {
                        f17 = i19;
                        f16 = f17 * f18;
                        float f19 = i18;
                        if (f16 > f19) {
                            f17 = f19 / f18;
                            f16 = f19;
                        }
                    } else {
                        f16 = i19;
                        f17 = f16 / f18;
                        float f26 = i17;
                        if (f17 > f26) {
                            f16 = f26 * f18;
                            f17 = f26;
                        }
                    }
                }
            } else {
                f17 = i17;
                f16 = f17 * f18;
            }
            return new int[]{(int) f17, (int) f16};
        }
        return new int[2];
    }

    @NonNull
    public static int[] j(String str, int i3, int i16) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return i(options.outWidth, options.outHeight, i3, i16);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("MediaUtil", 2, QLog.getStackTraceString(e16));
            }
            return new int[2];
        }
    }

    @NonNull
    public static int[] k(String str, int i3, int i16, int i17) {
        int i18;
        float f16;
        if (i16 > 0 && i17 > 0) {
            f16 = i17 * i3;
        } else {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                int i19 = options.outHeight;
                if (i19 > 0) {
                    i16 = options.outWidth;
                    if (i16 > 0) {
                        f16 = i19 * i3;
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(BitmapUtil.TAG, 2, QLog.getStackTraceString(e16));
                }
            }
            i18 = 0;
            i3 = 0;
            return new int[]{i3, i18};
        }
        i18 = (int) (f16 / i16);
        return new int[]{i3, i18};
    }

    public static URLDrawable l(String str, int i3, int i16) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("MediaUtil", 2, "getDrawable url:" + str);
            }
            if (p(str)) {
                return URLDrawable.getDrawable(str, d(i3, i16));
            }
            return URLDrawable.getFileDrawable(str, d(i3, i16));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static URLDrawable m(String str, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("MediaUtil", 2, "getDrawable url:" + str);
            }
            if (p(str)) {
                return URLDrawable.getDrawable(str, uRLDrawableOptions);
            }
            return URLDrawable.getFileDrawable(str, uRLDrawableOptions);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long n(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        long j3 = 0;
        try {
            mediaMetadataRetriever.setDataSource(str);
            try {
                j3 = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
            mediaMetadataRetriever.release();
            return j3;
        } catch (Error | RuntimeException e17) {
            hd0.c.h("MediaUtil", "getVideoDuration path=" + str + " exists=" + com.tencent.biz.qqstory.utils.d.j(str), e17);
            mediaMetadataRetriever.release();
            return 0L;
        }
    }

    @TargetApi(10)
    public static Bitmap o(String str, int i3, long j3) {
        Bitmap bitmap;
        if (i3 <= 0) {
            i3 = 640;
        }
        long currentTimeMillis = System.currentTimeMillis();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Bitmap bitmap2 = null;
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long j16 = j3 + 500;
                bitmap = mediaMetadataRetriever.getFrameAtTime(j16, 2);
                if (bitmap == null) {
                    try {
                        bitmap = mediaMetadataRetriever.getFrameAtTime(j16, 0);
                    } catch (OutOfMemoryError e16) {
                        e = e16;
                        QLog.d("MediaUtil", 1, "getVideoThumbnail OOM, ", e);
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException e17) {
                        e = e17;
                        QLog.e("MediaUtil", 1, e, new Object[0]);
                        mediaMetadataRetriever.release();
                    }
                }
            } catch (OutOfMemoryError e18) {
                e = e18;
                bitmap = null;
            } catch (RuntimeException e19) {
                e = e19;
                bitmap = null;
            }
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                if (bitmap == null) {
                    return null;
                }
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int max = Math.max(width, height);
                if (max > i3) {
                    float f16 = i3 / max;
                    try {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, Math.round(width * f16), Math.round(f16 * height), true);
                    } catch (OutOfMemoryError e26) {
                        e26.printStackTrace();
                    }
                } else {
                    bitmap2 = bitmap;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (bitmap2 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MediaUtil", 2, "getVideoThumbnail => success, width=" + bitmap2.getWidth() + ", height=" + bitmap2.getHeight() + ", videoPath=" + str + ", cost:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.e("MediaUtil", 2, "getVideoThumbnail => fail,  videoPath=" + str);
                }
                return bitmap2;
            }
        } catch (Throwable th5) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused2) {
            }
            throw th5;
        }
    }

    public static boolean p(String str) {
        if (!TextUtils.isEmpty(str) && (str.startsWith("https://") || str.startsWith("http://"))) {
            return true;
        }
        return false;
    }

    public static void q(AppRuntime appRuntime, String str, b bVar) {
        long currentTimeMillis = System.currentTimeMillis() + ((long) (Math.random() * 10000.0d));
        ITransFileController iTransFileController = (ITransFileController) appRuntime.getRuntimeService(ITransFileController.class, "");
        a aVar = new a(ThreadManagerV2.getQQCommonThreadLooper(), currentTimeMillis, str, bVar, iTransFileController);
        aVar.addFilter(BDHCommonUploadProcessor.class);
        iTransFileController.addHandle(aVar);
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = str;
        transferRequest.mFileType = 24;
        transferRequest.mCommandId = 94;
        transferRequest.mRichTag = StatisticCollector.GAMECENTER_STRATEGY_UPLOAD_STATISTIC_TAG;
        transferRequest.mPeerUin = "0";
        transferRequest.mUniseq = currentTimeMillis;
        transferRequest.mSelfUin = appRuntime.getCurrentAccountUin();
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        String f16 = f(str);
        QLog.i("MediaUtil", 1, "[uploadImage] suffix:" + f16);
        commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString() + f16));
        transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
        iTransFileController.transferAsync(transferRequest);
    }
}
