package com.tencent.mobileqq.guild.feed.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.winkpublish.util.PublishVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedMediaUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final WeakHashMap<String, String> f223774a = new WeakHashMap<>();

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface a {
        void onComplete();
    }

    @TargetApi(10)
    private static Bitmap a(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(str);
                        mediaMetadataRetriever.extractMetadata(9);
                        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(500L, 2);
                        if (frameAtTime == null) {
                            QLog.d("GuildFeedMediaUtils", 1, "getFirstFrame... bitmap == null option:0");
                            frameAtTime = mediaMetadataRetriever.getFrameAtTime(500L, 0);
                        }
                        if (frameAtTime == null) {
                            QLog.d("GuildFeedMediaUtils", 1, "getFirstFrame... bitmap == null option:3");
                            frameAtTime = mediaMetadataRetriever.getFrameAtTime(500L, 3);
                        }
                        try {
                            mediaMetadataRetriever.release();
                        } catch (RuntimeException e16) {
                            QLog.e("GuildFeedMediaUtils", 1, "retriever.release error", e16);
                        }
                        return frameAtTime;
                    } catch (Throwable th5) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (RuntimeException e17) {
                            QLog.e("GuildFeedMediaUtils", 1, "retriever.release error", e17);
                        }
                        throw th5;
                    }
                } catch (RuntimeException e18) {
                    QLog.e("GuildFeedMediaUtils", 1, "RuntimeException", e18);
                    mediaMetadataRetriever.release();
                    return null;
                }
            } catch (IllegalArgumentException e19) {
                QLog.e("GuildFeedMediaUtils", 1, "IllegalArgumentException", e19);
                mediaMetadataRetriever.release();
                return null;
            }
        } catch (RuntimeException e26) {
            QLog.e("GuildFeedMediaUtils", 1, "retriever.release error", e26);
            return null;
        }
    }

    public static String b(String str) {
        StringBuilder sb5 = new StringBuilder(32);
        sb5.append(BaseApplication.context.getFilesDir().getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("guild");
        sb5.append(str2);
        sb5.append("thumbs");
        sb5.append(str2);
        sb5.append(str.hashCode());
        sb5.append(".nomedia");
        return sb5.toString();
    }

    @Nullable
    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("GuildFeedMediaUtils", 1, "videoPath == null");
            return null;
        }
        if (!new File(str).exists()) {
            QLog.e("GuildFeedMediaUtils", 1, "!videoFile.exists()");
            return null;
        }
        WeakHashMap<String, String> weakHashMap = f223774a;
        if (weakHashMap.containsKey(str)) {
            String str2 = weakHashMap.get(str);
            if (str2 != null && FileUtils.fileExists(str2)) {
                return str2;
            }
            weakHashMap.remove(str);
        }
        String saveBitmapToLocal = PublishVideoUtils.saveBitmapToLocal(a(str));
        weakHashMap.put(str, saveBitmapToLocal);
        return saveBitmapToLocal;
    }

    public static byte[] d(String str) {
        Bitmap e16 = e(str, 640, -1L);
        if (e16 == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        e16.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        e16.recycle();
        return byteArrayOutputStream.toByteArray();
    }

    @TargetApi(10)
    public static Bitmap e(String str, int i3, long j3) {
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
                    if (QLog.isColorLevel()) {
                        QLog.d("GuildFeedMediaUtils", 2, "getVideoThumbnail => success, width=" + bitmap2.getWidth() + ", height=" + bitmap2.getHeight() + ", videoPath=" + str + ", cost:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.e("GuildFeedMediaUtils", 2, "getVideoThumbnail => fail,  videoPath=" + str);
                }
                return bitmap2;
            } catch (IllegalArgumentException | RuntimeException unused2) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException unused3) {
                    bitmap = null;
                }
            } catch (OutOfMemoryError e17) {
                QLog.d("GuildFeedMediaUtils", 1, "getVideoThumbnail OOM, ", e17);
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

    public static int[] f(String str) {
        Bitmap e16 = e(str, 640, -1L);
        if (e16 == null) {
            return null;
        }
        int[] iArr = {e16.getWidth(), e16.getHeight()};
        e16.recycle();
        return iArr;
    }

    public static void g(final String str, final String str2, final a aVar) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedMediaUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (new File(str2).exists() && aVar != null) {
                        QLog.d("GuildFeedMediaUtils", 1, "saveVideoThumbnailToLocal  thumbFile exists  , videoPath = " + str + " , thumbPath = " + str2);
                        aVar.onComplete();
                        return;
                    }
                    byte[] d16 = GuildFeedMediaUtils.d(str);
                    if (d16 == null) {
                        QLog.w("GuildFeedMediaUtils", 1, "getVideoThumbBytes bytes=null, videoPath=" + str);
                        return;
                    }
                    FileUtils.writeFile(d16, str2);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onComplete();
                    }
                } catch (Exception unused) {
                    QLog.w("GuildFeedMediaUtils", 1, "video thumb writeFile fail, videoPath=" + str + "thumbPath=" + str2);
                }
            }
        });
    }
}
