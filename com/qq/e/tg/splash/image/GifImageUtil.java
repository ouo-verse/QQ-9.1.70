package com.qq.e.tg.splash.image;

import android.graphics.Bitmap;
import android.graphics.Movie;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.net.NetworkUtil;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GifImageUtil {

    /* renamed from: a, reason: collision with root package name */
    private static String f40832a = "GifImageUtil";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class GifLock {

        /* renamed from: a, reason: collision with root package name */
        private static final GifLock f40833a = new GifLock();

        /* renamed from: b, reason: collision with root package name */
        private Map<String, ReentrantReadWriteLock> f40834b = new ConcurrentHashMap();

        GifLock() {
        }

        public static GifLock getInstance() {
            return f40833a;
        }

        final ReentrantReadWriteLock a(String str) {
            ReentrantReadWriteLock reentrantReadWriteLock;
            if (str == null || TextUtils.isEmpty(str)) {
                GDTLogger.e(GifImageUtil.f40832a + " GifLock get fail. url is null");
                reentrantReadWriteLock = null;
            } else {
                synchronized (this) {
                    reentrantReadWriteLock = this.f40834b.get(str);
                    if (reentrantReadWriteLock == null) {
                        reentrantReadWriteLock = new ReentrantReadWriteLock();
                        this.f40834b.put(str, reentrantReadWriteLock);
                    }
                }
            }
            GDTLogger.d(GifImageUtil.f40832a + " lockMap size: " + this.f40834b.size());
            return reentrantReadWriteLock;
        }

        final void a(String str, ReentrantReadWriteLock reentrantReadWriteLock) {
            if (str == null || reentrantReadWriteLock == null) {
                GDTLogger.e(GifImageUtil.f40832a + " GifLock release failed.");
                return;
            }
            try {
                if (!reentrantReadWriteLock.hasQueuedThreads()) {
                    GDTLogger.d(GifImageUtil.f40832a + " GifLock unlock can release.");
                    this.f40834b.remove(str);
                    return;
                }
                GDTLogger.d(GifImageUtil.f40832a + " GifLock unlock can't release.");
            } catch (NullPointerException e16) {
                GDTLogger.e(GifImageUtil.f40832a + " GifLock release failed. NullPointerException: ", e16);
                e16.printStackTrace();
            }
        }
    }

    public static File getAdImageDownLoadPath() {
        return new File(GDTADManager.getInstance().getAppContext().getCacheDir(), "GDTDOWNLOAD/image");
    }

    public static Bitmap getBitmapFromDisk(String str, ImageView imageView) {
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(getAdImageDownLoadPath(), FileUtil.getFileName(str));
        ReentrantReadWriteLock a16 = GifLock.getInstance().a(file.getPath());
        Bitmap bitmap = null;
        if (a16 == null) {
            GDTLogger.e(f40832a + " getBitmapFromDisk failed. lock is null");
            return null;
        }
        a16.readLock().lock();
        try {
            if (file.exists()) {
                try {
                    bitmap = BitmapUtil.decodeBitmapFromFile(file, imageView);
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

    /* JADX WARN: Removed duplicated region for block: B:29:0x00af A[Catch: all -> 0x00d7, TRY_ENTER, TryCatch #7 {all -> 0x00d7, blocks: (B:25:0x0059, B:27:0x0065, B:37:0x006a, B:29:0x00af, B:32:0x00bb, B:40:0x005e), top: B:24:0x0059, inners: #1, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Movie getMovieFromDisk(File file) {
        Movie movie;
        Throwable th5;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ReentrantReadWriteLock a16 = GifLock.getInstance().a(file.getPath());
        Movie movie2 = null;
        if (a16 == null) {
            GDTLogger.e(f40832a + " getMovieFromDisk failed. lock is null");
            return null;
        }
        a16.readLock().lock();
        try {
            if (isGif(file)) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    } catch (Throwable th6) {
                        th = th6;
                        byteArrayOutputStream = null;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream = null;
                    byteArrayOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byteArrayOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    movie = Movie.decodeByteArray(byteArray, 0, byteArray.length);
                    try {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th8) {
                            th5 = th8;
                            try {
                                GDTLogger.e(f40832a + " getMovieFromDisk failed.", th5);
                                a16.readLock().unlock();
                                GifLock.getInstance().a(file.getPath(), a16);
                                return movie;
                            } finally {
                                a16.readLock().unlock();
                                GifLock.getInstance().a(file.getPath(), a16);
                            }
                        }
                    } catch (Exception e16) {
                        GDTLogger.e(e16.getMessage());
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e17) {
                        GDTLogger.e(e17.getMessage());
                    }
                } catch (Throwable th9) {
                    th = th9;
                    try {
                        GDTLogger.e("decode movie failed: " + th.getMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e18) {
                                GDTLogger.e(e18.getMessage());
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e19) {
                                GDTLogger.e(e19.getMessage());
                            }
                        }
                        movie = null;
                        if (movie != null) {
                        }
                        movie2 = movie;
                        return movie2;
                    } finally {
                    }
                }
                if (movie != null) {
                    int width = movie.width();
                    int height = movie.height();
                    if (width == 0 || height == 0) {
                        GDTLogger.e("invalid gif width or height, w = " + width + ", h = " + height);
                    }
                }
                movie2 = movie;
            }
            return movie2;
        } catch (Throwable th10) {
            movie = null;
            th5 = th10;
            GDTLogger.e(f40832a + " getMovieFromDisk failed.", th5);
            a16.readLock().unlock();
            GifLock.getInstance().a(file.getPath(), a16);
            return movie;
        }
    }

    public static Object getMovieOrBitmapFromUrl(String str, HttpURLConnection httpURLConnection, ImageView imageView) {
        Object obj;
        String str2;
        try {
            try {
                GDTLogger.d("#####Downloading Image#####");
                long currentTimeMillis = System.currentTimeMillis();
                httpURLConnection = NetworkUtil.followRedirect(httpURLConnection);
                InputStream inputStream = httpURLConnection.getInputStream();
                GDTLogger.d("ImageTask#ImageConnectionTime=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                Object obj2 = null;
                if (a(str, inputStream)) {
                    GDTLogger.i(f40832a + " cacheToDisk return " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    Object movieFromDisk = getMovieFromDisk(str);
                    if (movieFromDisk == null) {
                        obj2 = getBitmapFromDisk(str, imageView);
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(f40832a);
                    sb5.append(" url: ");
                    sb5.append(str);
                    sb5.append(" is ");
                    if (movieFromDisk != null) {
                        str2 = "gif";
                    } else {
                        str2 = MimeHelper.IMAGE_SUBTYPE_BITMAP;
                    }
                    sb5.append(str2);
                    GDTLogger.d(sb5.toString());
                    obj = obj2;
                    obj2 = movieFromDisk;
                } else {
                    obj = null;
                }
                httpURLConnection.disconnect();
                if (obj2 != null) {
                    return obj2;
                }
                return obj;
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

    /* JADX WARN: Removed duplicated region for block: B:72:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isGif(File file) {
        FileInputStream fileInputStream;
        Exception e16;
        byte b16;
        boolean z16 = false;
        if (file == null) {
            GDTLogger.e(f40832a + " isGif image file is null");
            return false;
        }
        if (!file.exists()) {
            GDTLogger.e(f40832a + " isGif " + file.getAbsolutePath() + " not exist");
            return false;
        }
        ?? length = file.length();
        if (length < 6) {
            GDTLogger.e(f40832a + " isGif " + file.getAbsolutePath() + " size too short, len = " + file.length());
            return false;
        }
        ReentrantReadWriteLock a16 = GifLock.getInstance().a(file.getPath());
        if (a16 == null) {
            GDTLogger.e(f40832a + " isGif failed. lock is null");
            return false;
        }
        a16.readLock().lock();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e17) {
                fileInputStream = null;
                e16 = e17;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream2 != null) {
                }
                a16.readLock().unlock();
                GifLock.getInstance().a(file.getPath(), a16);
                throw th;
            }
            try {
                byte[] bArr = new byte[6];
                int read = fileInputStream.read(bArr);
                if (read < 6) {
                    GDTLogger.e(file.getAbsolutePath() + " only read " + read + " bytes!");
                    try {
                        fileInputStream.close();
                    } catch (Exception e18) {
                        GDTLogger.e(e18.getMessage());
                    }
                    a16.readLock().unlock();
                    GifLock.getInstance().a(file.getPath(), a16);
                    return false;
                }
                if (bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56 && (((b16 = bArr[4]) == 55 || b16 == 57) && bArr[5] == 97)) {
                    z16 = true;
                }
                try {
                    fileInputStream.close();
                } catch (Exception e19) {
                    GDTLogger.e(e19.getMessage());
                }
                a16.readLock().unlock();
                GifLock.getInstance().a(file.getPath(), a16);
                return z16;
            } catch (Exception e26) {
                e16 = e26;
                GDTLogger.e(e16.getMessage());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e27) {
                        GDTLogger.e(e27.getMessage());
                    }
                }
                a16.readLock().unlock();
                GifLock.getInstance().a(file.getPath(), a16);
                return false;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = length;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e28) {
                    GDTLogger.e(e28.getMessage());
                }
            }
            a16.readLock().unlock();
            GifLock.getInstance().a(file.getPath(), a16);
            throw th;
        }
    }

    private static boolean a(String str, InputStream inputStream) {
        boolean z16;
        ReentrantReadWriteLock reentrantReadWriteLock;
        GifLock gifLock;
        ReentrantReadWriteLock reentrantReadWriteLock2;
        boolean z17;
        long currentTimeMillis = System.currentTimeMillis();
        File adImageDownLoadPath = getAdImageDownLoadPath();
        adImageDownLoadPath.mkdirs();
        File file = new File(adImageDownLoadPath, FileUtil.getTempFileName(str));
        String path = file.getPath();
        GDTLogger.d(f40832a + " url: " + str + " tempPath: " + path);
        File file2 = new File(adImageDownLoadPath, FileUtil.getFileName(str));
        String path2 = file2.getPath();
        if (file2.exists()) {
            GDTLogger.d(f40832a + " url:  target.exist. ");
            return true;
        }
        GDTLogger.d(f40832a + " url: " + str + " path: " + path2);
        ReentrantReadWriteLock a16 = GifLock.getInstance().a(path);
        ReentrantReadWriteLock a17 = GifLock.getInstance().a(path2);
        boolean z18 = false;
        if (a16 == null || a17 == null) {
            GDTLogger.e(f40832a + " cacheToDisk tempFile or file lock is null.");
            return false;
        }
        if (a16.isWriteLocked() || a17.isWriteLocked()) {
            GDTLogger.d(f40832a + " cacheToDisk same file is writing.");
            return true;
        }
        GDTLogger.d(f40832a + " cacheToDisk new file is writing.");
        a16.writeLock().lock();
        a17.writeLock().lock();
        try {
            z16 = FileUtil.copyTo(inputStream, file);
        } catch (Throwable th5) {
            try {
                GDTLogger.e(f40832a + " cacheToDisk copyTo failed.", th5);
                a16.writeLock().unlock();
                GifLock.getInstance().a(path, a16);
                z16 = false;
            } finally {
                a16.writeLock().unlock();
                GifLock.getInstance().a(path, a16);
            }
        }
        if (z16) {
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(f40832a);
                sb5.append(" target.exist ");
                sb5.append(file2.exists());
                sb5.append(" filename: ");
                sb5.append(FileUtil.getFileName(str));
                sb5.append(" ");
                reentrantReadWriteLock = a17;
                try {
                    sb5.append(System.currentTimeMillis());
                    GDTLogger.i(sb5.toString());
                    if (file2.exists()) {
                        z17 = true;
                    } else {
                        z17 = FileUtil.renameTo(file, file2);
                        try {
                            GDTLogger.i(f40832a + " renameTo: " + z17 + " " + System.currentTimeMillis());
                        } catch (Throwable th6) {
                            th = th6;
                            z18 = z17;
                            try {
                                GDTLogger.e(f40832a + " cacheToDisk renameTo failed.", th);
                                reentrantReadWriteLock.writeLock().unlock();
                                gifLock = GifLock.getInstance();
                                reentrantReadWriteLock2 = reentrantReadWriteLock;
                                gifLock.a(path2, reentrantReadWriteLock2);
                                GDTLogger.d("ImageTask#CacheImageToDiskTime=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                                return z18;
                            } catch (Throwable th7) {
                                ReentrantReadWriteLock reentrantReadWriteLock3 = reentrantReadWriteLock;
                                reentrantReadWriteLock3.writeLock().unlock();
                                GifLock.getInstance().a(path2, reentrantReadWriteLock3);
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
                reentrantReadWriteLock = a17;
            }
        } else {
            reentrantReadWriteLock2 = a17;
        }
        reentrantReadWriteLock2.writeLock().unlock();
        gifLock = GifLock.getInstance();
        gifLock.a(path2, reentrantReadWriteLock2);
        GDTLogger.d("ImageTask#CacheImageToDiskTime=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        return z18;
    }

    public static Movie getMovieFromDisk(String str) {
        return getMovieFromDisk(new File(getAdImageDownLoadPath(), FileUtil.getFileName(str)));
    }
}
