package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.xiaomi.push.in;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes28.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static long f389721a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static long f389722b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f389723c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a implements Comparator<File> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            if (file == file2) {
                return 0;
            }
            if (file == null) {
                return 1;
            }
            if (file2 == null) {
                return -1;
            }
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified == 0) {
                return 0;
            }
            if (lastModified < 0) {
                return 1;
            }
            return -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        byte[] f389724a;

        /* renamed from: b, reason: collision with root package name */
        int f389725b;

        public b(byte[] bArr, int i3) {
            this.f389724a = bArr;
            this.f389725b = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Bitmap f389726a;

        /* renamed from: b, reason: collision with root package name */
        public long f389727b;

        public c(Bitmap bitmap, long j3) {
            this.f389726a = bitmap;
            this.f389727b = j3;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        int i3;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth != -1 && options.outHeight != -1) {
            int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
            int i16 = options.outWidth;
            if (i16 <= round || (i3 = options.outHeight) <= round) {
                return 1;
            }
            return Math.min(i16 / round, i3 / round);
        }
        jz4.c.m("decode dimension failed for bitmap.");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public static Bitmap b(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        int a16;
        Uri parse = Uri.parse(str);
        ?? r06 = 0;
        r06 = 0;
        try {
            try {
                inputStream = context.getContentResolver().openInputStream(parse);
                try {
                    a16 = a(context, inputStream);
                    inputStream2 = context.getContentResolver().openInputStream(parse);
                } catch (IOException e16) {
                    e = e16;
                    inputStream2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    in.b(r06);
                    in.b(inputStream);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
                inputStream2 = null;
                inputStream = null;
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = a16;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2, null, options);
                in.b(inputStream2);
                in.b(inputStream);
                return decodeStream;
            } catch (IOException e18) {
                e = e18;
                jz4.c.q(e);
                in.b(inputStream2);
                in.b(inputStream);
                return null;
            }
        } catch (Throwable th7) {
            th = th7;
            r06 = context;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ff, code lost:
    
        if (r1 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0102, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e1, code lost:
    
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00df, code lost:
    
        if (r1 == null) goto L54;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0104: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:261), block:B:59:0x0104 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static b c(String str, boolean z16) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Closeable closeable;
        int i3;
        Closeable closeable2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(8000);
                    httpURLConnection.setReadTimeout(20000);
                    httpURLConnection.setRequestProperty("User-agent", "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser");
                    httpURLConnection.connect();
                    int contentLength = httpURLConnection.getContentLength();
                    if (z16 && contentLength > 102400) {
                        jz4.c.m("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + com.xiaomi.push.ag.c(str, 3));
                        in.b(null);
                        httpURLConnection.disconnect();
                        return null;
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200) {
                        jz4.c.m("Invalid Http Response Code " + responseCode + " received");
                        in.b(null);
                        httpURLConnection.disconnect();
                        return null;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        if (z16) {
                            i3 = 102400;
                        } else {
                            i3 = 2048000;
                        }
                        byte[] bArr = new byte[1024];
                        while (i3 > 0) {
                            int read = inputStream.read(bArr, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            i3 -= read;
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (i3 <= 0) {
                            jz4.c.m("length 102400 exhausted.");
                            b bVar = new b(null, RFixConstants.MD5_FILE_BUF_LENGTH);
                            in.b(inputStream);
                            httpURLConnection.disconnect();
                            return bVar;
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        b bVar2 = new b(byteArray, byteArray.length);
                        in.b(inputStream);
                        httpURLConnection.disconnect();
                        return bVar2;
                    } catch (SocketTimeoutException unused) {
                        jz4.c.B("Connect timeout to " + str);
                        in.b(inputStream);
                    } catch (IOException e16) {
                        e = e16;
                        jz4.c.q(e);
                        in.b(inputStream);
                    }
                } catch (SocketTimeoutException unused2) {
                    inputStream = null;
                } catch (IOException e17) {
                    e = e17;
                    inputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    in.b(closeable2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (SocketTimeoutException unused3) {
                httpURLConnection = null;
                inputStream = null;
            } catch (IOException e18) {
                e = e18;
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th6) {
                th = th6;
                httpURLConnection = null;
            }
        } catch (Throwable th7) {
            th = th7;
            closeable2 = closeable;
        }
    }

    public static c d(Context context, String str, boolean z16) {
        Bitmap i3;
        ByteArrayInputStream byteArrayInputStream = null;
        c cVar = new c(null, 0L);
        try {
            try {
                i3 = i(context, str);
            } catch (Exception e16) {
                e = e16;
            }
            if (i3 != null) {
                cVar.f389726a = i3;
                in.b(null);
                return cVar;
            }
            b c16 = c(str, z16);
            if (c16 == null) {
                in.b(null);
                return cVar;
            }
            cVar.f389727b = c16.f389725b;
            byte[] bArr = c16.f389724a;
            if (bArr != null) {
                if (z16) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int a16 = a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = a16;
                        cVar.f389726a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e17) {
                        e = e17;
                        byteArrayInputStream = byteArrayInputStream2;
                        jz4.c.q(e);
                        in.b(byteArrayInputStream);
                        return cVar;
                    } catch (Throwable th5) {
                        th = th5;
                        byteArrayInputStream = byteArrayInputStream2;
                        in.b(byteArrayInputStream);
                        throw th;
                    }
                } else {
                    cVar.f389726a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            g(context, c16.f389724a, str);
            in.b(byteArrayInputStream);
            return cVar;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static String e(Context context) {
        return context.getCacheDir().getPath() + File.separator + "mipush_icon";
    }

    private static synchronized void f(Context context) {
        File file;
        long j3;
        synchronized (h.class) {
            j(context);
            if (f389721a < 62914560 && System.currentTimeMillis() - f389722b < 1209600000) {
                return;
            }
            try {
                file = new File(e(context));
            } catch (Throwable th5) {
                jz4.c.B("Clear pic cache error: " + th5);
            }
            if (!file.exists()) {
                jz4.c.m("The pic cache dir do not exists.");
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                h(listFiles);
                long j16 = f389721a;
                int length = listFiles.length - 1;
                while (true) {
                    if (length >= 0) {
                        File file2 = listFiles[length];
                        if (file2 != null) {
                            if (j16 <= GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV && System.currentTimeMillis() - file2.lastModified() <= 864000000) {
                                j3 = file2.lastModified();
                                break;
                            }
                            j16 -= file2.length();
                            file2.delete();
                        }
                        length--;
                    } else {
                        j3 = 0;
                        break;
                    }
                }
                f389721a = Math.max(j16, 0L);
                f389722b = j3;
            } else {
                jz4.c.m("The pic cache file list is null.");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.OutputStream, java.io.FileOutputStream] */
    private static void g(Context context, byte[] bArr, String str) {
        if (bArr == null) {
            jz4.c.m("cannot save small icon cause bitmap is null");
            return;
        }
        f(context);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                File file = new File(e(context));
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, com.xiaomi.push.ag.b(str));
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                str = new FileOutputStream(file2);
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(str);
                    try {
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.flush();
                        f389721a += file2.length();
                        long j3 = f389722b;
                        if (j3 <= 0) {
                            f389722b = file2.lastModified();
                        } else {
                            f389722b = Math.min(j3, file2.lastModified());
                        }
                        in.b(bufferedOutputStream2);
                        str = str;
                    } catch (Exception e16) {
                        e = e16;
                        bufferedOutputStream = bufferedOutputStream2;
                        jz4.c.B("Save pic error: " + e);
                        in.b(bufferedOutputStream);
                        str = str;
                        in.b(str);
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = bufferedOutputStream2;
                        in.b(bufferedOutputStream);
                        in.b(str);
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            } catch (Exception e18) {
                e = e18;
                str = 0;
            } catch (Throwable th6) {
                th = th6;
                str = 0;
            }
            in.b(str);
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private static void h(File[] fileArr) {
        if (fileArr != null) {
            try {
                if (fileArr.length > 1) {
                    Arrays.sort(fileArr, new a());
                }
            } catch (Throwable th5) {
                jz4.c.B("Sort pic cache error: " + th5);
            }
        }
    }

    private static synchronized Bitmap i(Context context, String str) {
        Bitmap bitmap;
        File file;
        synchronized (h.class) {
            FileInputStream fileInputStream = null;
            Bitmap bitmap2 = null;
            try {
                file = new File(e(context), com.xiaomi.push.ag.b(str));
            } catch (Throwable th5) {
                th = th5;
                bitmap = null;
            }
            if (!file.exists()) {
                return null;
            }
            if (System.currentTimeMillis() - file.lastModified() > 1209600000) {
                jz4.c.m("The pic cache has expired.");
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                bitmap2 = BitmapFactory.decodeStream(fileInputStream2);
                file.setLastModified(System.currentTimeMillis());
                in.b(fileInputStream2);
            } catch (Throwable th6) {
                Bitmap bitmap3 = bitmap2;
                fileInputStream = fileInputStream2;
                th = th6;
                bitmap = bitmap3;
                try {
                    jz4.c.B("Load bmp from cache error: " + th);
                    bitmap2 = bitmap;
                    return bitmap2;
                } finally {
                    in.b(fileInputStream);
                }
            }
            return bitmap2;
        }
    }

    private static synchronized void j(Context context) {
        String str;
        File file;
        synchronized (h.class) {
            if (f389723c) {
                return;
            }
            f389721a = 0L;
            f389722b = 0L;
            try {
                file = new File(e(context));
            } catch (Throwable th5) {
                try {
                    jz4.c.B("Init pic cache error: " + th5);
                    f389723c = true;
                    str = "Init pic cache finish.";
                } finally {
                    f389723c = true;
                    jz4.c.w("Init pic cache finish.");
                }
            }
            if (!file.exists()) {
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    f389721a += file2.length();
                    long j3 = f389722b;
                    if (j3 <= 0) {
                        f389722b = file2.lastModified();
                    } else {
                        f389722b = Math.min(j3, file2.lastModified());
                    }
                }
            }
            f389723c = true;
            str = "Init pic cache finish.";
            jz4.c.w(str);
        }
    }
}
