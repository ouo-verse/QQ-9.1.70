package com.tencent.mobileqq.profilecard.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes35.dex */
public class QCircleCoverBlurCacheUtil {
    private static final String COVER_PATH = "/profilecardblur/";
    private static final String FILE_NAME_PREFIX = "qcircle_profilecard_";
    private static final String TAG = "QCircleCoverBlurCache";
    public static final int TYPE_BLUR = 0;
    public static final int TYPE_COVER = 1;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface ISaveCacheCallBack {
        void onSave(String str);
    }

    QCircleCoverBlurCacheUtil() {
    }

    public static Bitmap decodeBitmap(String str, int i3, int i16) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i17 = i3 > 0 ? options.outWidth / i3 : 1;
        if (i16 > 0) {
            i16 = options.outHeight / i16;
        }
        if (i17 > 1 && i16 > 1) {
            options.inSampleSize = Math.max(i17, i16);
        }
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        QLog.d(TAG, 1, "get cache bitmap bytes :" + decodeFile.getAllocationByteCount());
        return decodeFile;
    }

    public static Bitmap getCache(Context context, String str, String str2, int i3, int i16, int i17) {
        String str3 = i3 == 0 ? "blur" : "cover";
        String str4 = FILE_NAME_PREFIX + str3 + "_" + str + "_" + str2;
        String str5 = getDiskCachePath(context) + COVER_PATH;
        QCircleCoverBlurCachePool qCircleCoverBlurCachePool = QCircleCoverBlurCachePool.INSTANCE;
        Bitmap cache = qCircleCoverBlurCachePool.getCache(QCircleCoverBlurCachePool.getCacheKey(str, str2, str3));
        if (cache != null) {
            QLog.d(TAG, 1, "get cache form memory:" + str4);
            return cache;
        }
        try {
            String str6 = str5 + str4 + ".jpg";
            if (!new File(str6).exists()) {
                QLog.d(TAG, 1, "no cache:" + str4);
                return null;
            }
            Bitmap decodeBitmap = decodeBitmap(str6, i16, i17);
            qCircleCoverBlurCachePool.addCache(QCircleCoverBlurCachePool.getCacheKey(str, str2, str3), decodeBitmap);
            QLog.d(TAG, 1, "get cache form disk:" + str4);
            return decodeBitmap;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return cache;
        }
    }

    public static String getDiskCachePath(Context context) {
        File externalCacheDir;
        if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && (externalCacheDir = context.getExternalCacheDir()) != null) {
            return externalCacheDir.getPath();
        }
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir.getPath();
        }
        QLog.d(TAG, 1, "[getDiskCachePath] default cacheDir path");
        return MobileQQ.sMobileQQ.getCacheDir() + "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveCache$0(Context context, String str, Bitmap bitmap, ISaveCacheCallBack iSaveCacheCallBack) {
        try {
            String str2 = getDiskCachePath(context) + COVER_PATH;
            File file = new File(str2);
            if (!file.exists() && !file.mkdir()) {
                QLog.e(TAG, 1, "create dir error:" + str2);
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2 + str + ".jpg"));
            bitmap.compress(Bitmap.CompressFormat.JPEG, Build.VERSION.SDK_INT <= 25 ? 50 : 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            QLog.d(TAG, 1, "save cache:" + str2 + str + ".jpg");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            sb5.append(str);
            sb5.append(".jpg");
            iSaveCacheCallBack.onSave(sb5.toString());
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    public static synchronized void saveCache(final Context context, final Bitmap bitmap, String str, String str2, int i3, final ISaveCacheCallBack iSaveCacheCallBack) {
        String str3;
        synchronized (QCircleCoverBlurCacheUtil.class) {
            if (i3 == 0) {
                str3 = "blur";
            } else {
                str3 = "cover";
            }
            final String str4 = FILE_NAME_PREFIX + str3 + "_" + str + "_" + str2;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.utils.m
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleCoverBlurCacheUtil.lambda$saveCache$0(context, str4, bitmap, iSaveCacheCallBack);
                }
            }, 64, null, true);
        }
    }
}
