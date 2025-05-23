package com.tencent.qqmini.sdk.core.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ShortVideoUtil {
    private static final String TAG = "ShortVideoUtil";
    static String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
    static String SDCARD_IMG_VIDEO = SDCARD_ROOT + "/DCIM/Video/";
    static String SDCARD_IMG_VIDEO_GN9000L = SDCARD_ROOT + "/\u7167\u76f8\u673a/Camera/";
    static String SDCARD_IMG_VIDEO_VIVO_X7 = SDCARD_ROOT + "/\u76f8\u673a/";
    static String SDCARD_IMG_VIDEO_RUBBISH_MX040 = SDCARD_ROOT + "/Camera/Video/";
    static String SDCARD_IMG_CAMERA = SDCARD_ROOT + "/DCIM/Camera/";
    static int VIDEO_THUMBNAIL_MAX_LENGTH_DEFAULT = 640;

    public static String getCameraPath() {
        String str;
        String upperCase = DeviceInfoUtil.getPhoneModel().toUpperCase();
        if (upperCase.contains("GN9000L")) {
            str = SDCARD_IMG_VIDEO_GN9000L;
        } else if (isDCIMVideoModel(upperCase)) {
            str = SDCARD_IMG_VIDEO;
        } else if (upperCase.contains("M040")) {
            str = SDCARD_IMG_VIDEO_RUBBISH_MX040;
        } else if (isVIVOX7Model(upperCase)) {
            str = SDCARD_IMG_VIDEO_VIVO_X7;
        } else {
            str = SDCARD_IMG_CAMERA;
        }
        QMLog.d(TAG, "getCameraPath: commonPath=" + str);
        return str;
    }

    @TargetApi(10)
    public static Bitmap getVideoThumbnail(Context context, String str) {
        return getVideoThumbnail(context, str, VIDEO_THUMBNAIL_MAX_LENGTH_DEFAULT);
    }

    private static boolean isDCIMVideoModel(String str) {
        if (!str.contains("MX4") && !str.contains("MX6") && !str.contains("MX5") && !str.contains("M355") && !str.contains("M571C")) {
            return false;
        }
        return true;
    }

    private static boolean isVIVOX7Model(String str) {
        if (!str.contains("VIVO X7") && !str.contains("VIVO X6A") && !str.contains("VIVO XPLAY6") && !str.contains("VIVO X5PRO") && !str.contains("VIVO X9 PLUS") && !str.contains("VIVO Y51A") && !str.contains("VIVO X9I") && !str.contains("VIVO X9") && !str.contains("VIVO X6D")) {
            return false;
        }
        return true;
    }

    @TargetApi(10)
    public static Bitmap getVideoThumbnail(Context context, String str, int i3) {
        return getVideoThumbnail(context, str, i3, -1L);
    }

    @TargetApi(10)
    public static Bitmap getVideoThumbnail(Context context, String str, int i3, long j3) {
        Bitmap bitmap;
        if (i3 <= 0) {
            i3 = VIDEO_THUMBNAIL_MAX_LENGTH_DEFAULT;
        }
        long currentTimeMillis = System.currentTimeMillis();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Bitmap bitmap2 = null;
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                bitmap = mediaMetadataRetriever.getFrameAtTime(j3);
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException unused) {
                }
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
                    } catch (OutOfMemoryError e16) {
                        e16.printStackTrace();
                    }
                } else {
                    bitmap2 = bitmap;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (bitmap2 != null) {
                    if (QMLog.isColorLevel()) {
                        QMLog.d(TAG, "getVideoThumbnail => success, width=" + bitmap2.getWidth() + ", height=" + bitmap2.getHeight() + ", videoPath=" + str + ", cost:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
                    }
                } else if (QMLog.isColorLevel()) {
                    QMLog.e(TAG, "getVideoThumbnail => fail,  videoPath=" + str);
                }
                return bitmap2;
            } catch (IllegalArgumentException | RuntimeException unused2) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException unused3) {
                    bitmap = null;
                }
            } catch (OutOfMemoryError e17) {
                QMLog.d(TAG, "getVideoThumbnail OOM, ", e17);
                mediaMetadataRetriever.release();
            }
        } catch (Throwable th5) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused4) {
            }
            throw th5;
        }
    }
}
