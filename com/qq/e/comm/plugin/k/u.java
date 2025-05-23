package com.qq.e.comm.plugin.k;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static String f39662a = "GifImageUtil";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        private static final a f39663b = new a();

        /* renamed from: a, reason: collision with root package name */
        Map<String, ReentrantReadWriteLock> f39664a = new ConcurrentHashMap();

        a() {
        }

        public static a a() {
            return f39663b;
        }

        ReentrantReadWriteLock a(String str) {
            ReentrantReadWriteLock reentrantReadWriteLock;
            if (str != null && !TextUtils.isEmpty(str)) {
                synchronized (this) {
                    reentrantReadWriteLock = this.f39664a.get(str);
                    if (reentrantReadWriteLock == null) {
                        reentrantReadWriteLock = new ReentrantReadWriteLock();
                        this.f39664a.put(str, reentrantReadWriteLock);
                    }
                }
            } else {
                GDTLogger.e(u.f39662a + " GifLock get fail. url is null");
                reentrantReadWriteLock = null;
            }
            GDTLogger.d(u.f39662a + " lockMap size: " + this.f39664a.size());
            return reentrantReadWriteLock;
        }

        void a(String str, ReentrantReadWriteLock reentrantReadWriteLock) {
            if (str != null && reentrantReadWriteLock != null) {
                try {
                    if (!reentrantReadWriteLock.hasQueuedThreads()) {
                        GDTLogger.d(u.f39662a + " GifLock unlock can release.");
                        this.f39664a.remove(str);
                    } else {
                        GDTLogger.d(u.f39662a + " GifLock unlock can't release.");
                    }
                    return;
                } catch (NullPointerException e16) {
                    GDTLogger.e(u.f39662a + " GifLock release failed. NullPointerException: ", e16);
                    e16.printStackTrace();
                    return;
                }
            }
            GDTLogger.e(u.f39662a + " GifLock release failed.");
        }
    }

    private static boolean a(String str, InputStream inputStream) {
        boolean z16;
        ReentrantReadWriteLock reentrantReadWriteLock;
        a a16;
        ReentrantReadWriteLock reentrantReadWriteLock2;
        boolean z17;
        long currentTimeMillis = System.currentTimeMillis();
        File a17 = a();
        a17.mkdirs();
        File file = new File(a17, FileUtil.getTempFileName(str));
        String path = file.getPath();
        GDTLogger.d(f39662a + " url: " + str + " tempPath: " + path);
        File file2 = new File(a17, FileUtil.getFileName(str));
        String path2 = file2.getPath();
        if (file2.exists()) {
            GDTLogger.d(f39662a + " url:  target.exist. ");
            return true;
        }
        GDTLogger.d(f39662a + " url: " + str + " path: " + path2);
        ReentrantReadWriteLock a18 = a.a().a(path);
        ReentrantReadWriteLock a19 = a.a().a(path2);
        boolean z18 = false;
        if (a18 != null && a19 != null) {
            if (!a18.isWriteLocked() && !a19.isWriteLocked()) {
                GDTLogger.d(f39662a + " cacheToDisk new file is writing.");
                a18.writeLock().lock();
                a19.writeLock().lock();
                try {
                    z16 = FileUtil.copyTo(inputStream, file);
                } catch (Throwable th5) {
                    try {
                        GDTLogger.e(f39662a + " cacheToDisk copyTo failed.", th5);
                        a18.writeLock().unlock();
                        a.a().a(path, a18);
                        z16 = false;
                    } finally {
                        a18.writeLock().unlock();
                        a.a().a(path, a18);
                    }
                }
                if (z16) {
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(f39662a);
                        sb5.append(" target.exist ");
                        sb5.append(file2.exists());
                        sb5.append(" filename: ");
                        sb5.append(FileUtil.getFileName(str));
                        sb5.append(" ");
                        reentrantReadWriteLock = a19;
                        try {
                            sb5.append(System.currentTimeMillis());
                            GDTLogger.i(sb5.toString());
                            if (file2.exists()) {
                                z17 = true;
                            } else {
                                z17 = FileUtil.renameTo(file, file2);
                                try {
                                    GDTLogger.i(f39662a + " renameTo: " + z17 + " " + System.currentTimeMillis());
                                } catch (Throwable th6) {
                                    th = th6;
                                    z18 = z17;
                                    try {
                                        GDTLogger.e(f39662a + " cacheToDisk renameTo failed.", th);
                                        reentrantReadWriteLock.writeLock().unlock();
                                        a16 = a.a();
                                        reentrantReadWriteLock2 = reentrantReadWriteLock;
                                        a16.a(path2, reentrantReadWriteLock2);
                                        GDTLogger.d("ImageTask#CacheImageToDiskTime=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                                        return z18;
                                    } catch (Throwable th7) {
                                        ReentrantReadWriteLock reentrantReadWriteLock3 = reentrantReadWriteLock;
                                        reentrantReadWriteLock3.writeLock().unlock();
                                        a.a().a(path2, reentrantReadWriteLock3);
                                        throw th7;
                                    }
                                }
                            }
                            GDTLogger.d("ImageTask#RenameTime=" + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                            z18 = z17;
                            reentrantReadWriteLock2 = reentrantReadWriteLock;
                        } catch (Throwable th8) {
                            th = th8;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        reentrantReadWriteLock = a19;
                    }
                } else {
                    reentrantReadWriteLock2 = a19;
                }
                reentrantReadWriteLock2.writeLock().unlock();
                a16 = a.a();
                a16.a(path2, reentrantReadWriteLock2);
                GDTLogger.d("ImageTask#CacheImageToDiskTime=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return z18;
            }
            GDTLogger.d(f39662a + " cacheToDisk same file is writing.");
            return true;
        }
        GDTLogger.e(f39662a + " cacheToDisk tempFile or file lock is null.");
        return false;
    }

    public static File a() {
        return new File(GDTADManager.getInstance().getAppContext().getCacheDir(), "GDTDOWNLOAD/image");
    }

    public static Object a(String str, HttpURLConnection httpURLConnection, ImageView imageView) {
        Bitmap bitmap;
        try {
            try {
                GDTLogger.d("#####Downloading Image#####");
                long currentTimeMillis = System.currentTimeMillis();
                httpURLConnection = ac.a(httpURLConnection);
                InputStream inputStream = httpURLConnection.getInputStream();
                GDTLogger.d("ImageTask#ImageConnectionTime=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                if (a(str, inputStream)) {
                    GDTLogger.i(f39662a + " cacheToDisk return " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    bitmap = a(str, imageView);
                    GDTLogger.d(f39662a + " url: " + str + " is " + MimeHelper.IMAGE_SUBTYPE_BITMAP);
                } else {
                    bitmap = null;
                }
                httpURLConnection.disconnect();
                return bitmap;
            } catch (Exception e16) {
                GDTLogger.d("LoadSplashImageException: " + e16.getMessage());
                throw new RuntimeException("LoadSplashImageException: get image from url failed");
            }
        } catch (Throwable th5) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th5;
        }
    }

    public static Bitmap a(String str, ImageView imageView) {
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(a(), FileUtil.getFileName(str));
        ReentrantReadWriteLock a16 = a.a().a(file.getPath());
        Bitmap bitmap = null;
        if (a16 == null) {
            GDTLogger.e(f39662a + " getBitmapFromDisk failed. lock is null");
            return null;
        }
        a16.readLock().lock();
        try {
            if (file.exists()) {
                try {
                    bitmap = h.a(file, imageView);
                } catch (OutOfMemoryError e16) {
                    GDTLogger.d("ImageTask#DecodeBitmapFromFileOutOfMemoryError:" + e16.getMessage());
                }
            }
            GDTLogger.d("ImageTask#GetBitmapFromDiskTime=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        } finally {
            try {
                return bitmap;
            } finally {
            }
        }
        return bitmap;
    }
}
