package com.tencent.luggage.wxa.th;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.kj.s;
import com.tencent.luggage.wxa.mc.k0;
import com.tencent.luggage.wxa.rc.m;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.i;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.zip.ZipInputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentMap f141323a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static Map f141324b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final String f141325c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f141326a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f141327b;

        public a(String str, d dVar) {
            this.f141326a = str;
            this.f141327b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!b.f141324b.containsKey(this.f141326a)) {
                b.f141324b.put(this.f141326a, new ArrayList());
            }
            ((List) b.f141324b.get(this.f141326a)).add(this.f141327b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.th.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6756b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f141328a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f141329b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f141330c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f141331d;

        public RunnableC6756b(boolean z16, com.tencent.luggage.wxa.xd.d dVar, String str, String str2) {
            this.f141328a = z16;
            this.f141329b = dVar;
            this.f141330c = str;
            this.f141331d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f141328a) {
                b.b(this.f141329b, this.f141330c, this.f141331d);
            } else {
                b.e(this.f141330c, this.f141331d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f141332a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f141333b;

        public c(String str, String str2) {
            this.f141332a = str;
            this.f141333b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.d(this.f141332a, this.f141333b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void onLoad(String str);
    }

    static {
        String e16 = com.tencent.luggage.wxa.db.a.e();
        if (!e16.endsWith("/")) {
            e16 = e16 + "/";
        }
        String str = e16 + "wxacache/";
        f141325c = str;
        l.a(str);
    }

    public static boolean c(com.tencent.luggage.wxa.xd.d dVar, String str, boolean z16, String str2, d dVar2) {
        w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, url:%s", str);
        if (dVar == null) {
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, component is null");
            return false;
        }
        if (z16) {
            return d(dVar, str, str2, dVar2);
        }
        return c(dVar, str, str2, dVar2);
    }

    public static void d(com.tencent.luggage.wxa.xd.d dVar, String str, boolean z16, String str2, d dVar2) {
        if (w0.c(str) || dVar2 == null) {
            return;
        }
        if (str.startsWith("wxfile://")) {
            if (c(dVar, str, z16, str2, dVar2)) {
                return;
            }
            a(dVar2);
        } else {
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                if (b(dVar, str, z16, str2, dVar2)) {
                    return;
                }
                a(dVar2);
                return;
            }
            a(dVar, str, z16, str2, dVar2);
        }
    }

    public static void e(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, d dVar2) {
        d(dVar, str, false, str2, dVar2);
    }

    public static boolean f(String str, String str2) {
        if (w0.c(str)) {
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid target nil, no check");
            return true;
        }
        String a16 = com.tencent.luggage.wxa.y8.c.a(str2);
        w.d("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid file:%s target:%s", a16, str);
        return str.equals(a16);
    }

    public static boolean b(com.tencent.luggage.wxa.xd.d dVar, String str, boolean z16, String str2, d dVar2) {
        if (z16) {
            return b(dVar, str, str2, dVar2);
        }
        return a(dVar, str, str2, dVar2);
    }

    public static void e(String str, String str2) {
        String format = String.format("%s%s", f141325c, a(str));
        w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handleNetworkFile, localPath:%s", format);
        v vVar = new v(format);
        if (vVar.e()) {
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "download already exists: %s", str);
            if (f(str2, format)) {
                c(str, format);
                return;
            }
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "download already exists, but md5 not valid. deleted:%b", Boolean.valueOf(vVar.d()));
        }
        if (f141323a.containsKey(str)) {
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "download ing: %s", str);
            return;
        }
        f141323a.put(str, Boolean.TRUE);
        a(str, vVar);
        w.d("MicroMsg.AppBrandLiveFileLoadHelper", "download done");
        f141323a.remove(str);
        if (f(str2, format)) {
            c(str, format);
        } else {
            w.f("MicroMsg.AppBrandLiveFileLoadHelper", "download md5 not valid");
            c(str, null);
        }
    }

    public static void a(d dVar) {
        if (dVar != null) {
            dVar.onLoad(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean b(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, d dVar2) {
        Throwable th5;
        ZipInputStream zipInputStream;
        Exception e16;
        ZipInputStream zipInputStream2;
        w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageZip, url:%s", str);
        f fVar = f.f141339a;
        v b16 = fVar.b(dVar, str);
        if (b16 == null) {
            return false;
        }
        com.tencent.luggage.wxa.ic.g a16 = a(dVar);
        if (a16 == null) {
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageZip, runtime is null");
            return false;
        }
        InputStream d16 = k0.d(a16, str);
        try {
            if (d16 != 0) {
                try {
                    if (d16.available() > 0) {
                        if (!a(str2, d16)) {
                            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageZip, md5 is invalid");
                            w0.a((Closeable) d16);
                            return false;
                        }
                        ZipInputStream zipInputStream3 = d16;
                        if (!fVar.a(b16)) {
                            w0.a((Closeable) d16);
                            zipInputStream = new ZipInputStream(k0.d(a16, str));
                            try {
                                if (fVar.a(zipInputStream, b16) == null) {
                                    w0.a((Closeable) zipInputStream);
                                    return false;
                                }
                                zipInputStream3 = zipInputStream;
                            } catch (Exception e17) {
                                e16 = e17;
                                zipInputStream2 = zipInputStream;
                                w.f("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageZip, fail since " + e16);
                                if (zipInputStream2 != null) {
                                    w0.a((Closeable) zipInputStream2);
                                }
                                return false;
                            } catch (Throwable th6) {
                                th5 = th6;
                                if (zipInputStream != null) {
                                    w0.a((Closeable) zipInputStream);
                                }
                                throw th5;
                            }
                        }
                        if (dVar2 == null) {
                            w0.a((Closeable) zipInputStream3);
                            return false;
                        }
                        dVar2.onLoad(b16.g());
                        w0.a((Closeable) zipInputStream3);
                        return true;
                    }
                } catch (Exception e18) {
                    e16 = e18;
                    zipInputStream2 = d16;
                }
            }
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageZip, stream is illegal");
            if (d16 != 0) {
                w0.a((Closeable) d16);
            }
            return false;
        } catch (Throwable th7) {
            th5 = th7;
            zipInputStream = d16;
        }
    }

    public static boolean a(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, d dVar2) {
        w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, url:%s", str);
        com.tencent.luggage.wxa.ic.g a16 = a(dVar);
        if (a16 == null) {
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, runtime is null");
            return false;
        }
        String b16 = m.b(str);
        if (w0.c(b16)) {
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, url is empty");
            return false;
        }
        String format = String.format("%s%s", f141325c, a(b16));
        w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, localPath:%s", format);
        if (!new v(format).e()) {
            InputStream d16 = k0.d(a16, b16);
            try {
                if (d16 != null) {
                    try {
                        if (d16.available() > 0) {
                            if (!a(str2, d16)) {
                                w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, md5 is invalid");
                                w0.a((Closeable) d16);
                                return false;
                            }
                            Bitmap a17 = s.a(a16, b16);
                            if (a17 != null && !a17.isRecycled()) {
                                try {
                                    try {
                                        com.tencent.luggage.wxa.tn.d.a(a17, 100, Bitmap.CompressFormat.PNG, format, true);
                                        if (!a17.isRecycled()) {
                                            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", a17);
                                            a17.recycle();
                                        }
                                        w0.a((Closeable) d16);
                                    } catch (IOException e16) {
                                        w.b("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, fail to compress bitmap to file", e16);
                                        if (!a17.isRecycled()) {
                                            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", a17);
                                            a17.recycle();
                                        }
                                        w0.a((Closeable) d16);
                                        return false;
                                    }
                                } catch (Throwable th5) {
                                    if (!a17.isRecycled()) {
                                        w.d("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", a17);
                                        a17.recycle();
                                    }
                                    throw th5;
                                }
                            } else {
                                w.b("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, no bitmap in the given url");
                                w0.a((Closeable) d16);
                                return false;
                            }
                        }
                    } catch (Exception e17) {
                        w.f("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, fail since " + e17);
                        if (d16 != null) {
                            w0.a((Closeable) d16);
                        }
                        return false;
                    }
                }
                w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, stream is illegal");
                if (d16 != null) {
                    w0.a((Closeable) d16);
                }
                return false;
            } catch (Throwable th6) {
                if (d16 != null) {
                    w0.a((Closeable) d16);
                }
                throw th6;
            }
        }
        if (dVar2 == null) {
            return false;
        }
        dVar2.onLoad(format);
        return true;
    }

    public static boolean c(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, d dVar2) {
        v absoluteFile = dVar.getFileSystem().getAbsoluteFile(str);
        if (absoluteFile != null && absoluteFile.e()) {
            String g16 = absoluteFile.g();
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, localPath:%s", g16);
            if (f(str2, g16) && dVar2 != null) {
                dVar2.onLoad(g16);
                return true;
            }
        }
        return false;
    }

    public static boolean d(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, d dVar2) {
        f fVar = f.f141339a;
        v b16 = fVar.b(dVar, str);
        if (b16 == null) {
            return false;
        }
        ZipInputStream zipInputStream = null;
        try {
            InputStream readStream = dVar.getFileSystem().readStream(str);
            if (readStream == null) {
                w0.a((Closeable) readStream);
                return false;
            }
            if (!a(str2, readStream)) {
                w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfileZip, md5 is invalid");
                w0.a((Closeable) readStream);
                return false;
            }
            if (!fVar.a(b16)) {
                w0.a((Closeable) readStream);
                InputStream readStream2 = dVar.getFileSystem().readStream(str);
                if (readStream2 == null) {
                    w0.a((Closeable) readStream2);
                    return false;
                }
                ZipInputStream zipInputStream2 = new ZipInputStream(readStream2);
                try {
                    if (fVar.a(zipInputStream2, b16) == null) {
                        w0.a((Closeable) zipInputStream2);
                        return false;
                    }
                    readStream = zipInputStream2;
                } catch (Throwable th5) {
                    zipInputStream = zipInputStream2;
                    th = th5;
                    w0.a((Closeable) zipInputStream);
                    throw th;
                }
            }
            if (dVar2 == null) {
                w0.a((Closeable) readStream);
                return false;
            }
            dVar2.onLoad(b16.g());
            w0.a((Closeable) readStream);
            return true;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0071 A[Catch: Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:7:0x000f, B:9:0x005d, B:13:0x0071, B:15:0x007a, B:17:0x0084, B:19:0x008a, B:21:0x0099, B:25:0x0065), top: B:6:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008a A[Catch: Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:7:0x000f, B:9:0x005d, B:13:0x0071, B:15:0x007a, B:17:0x0084, B:19:0x008a, B:21:0x0099, B:25:0x0065), top: B:6:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static v c(com.tencent.luggage.wxa.xd.d dVar, String str, String str2) {
        String sb5;
        v vVar;
        boolean z16;
        f fVar = f.f141339a;
        v b16 = fVar.b(dVar, str);
        if (b16 == null) {
            return null;
        }
        try {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(f141325c);
            sb6.append(a(dVar.getAppId() + "_" + str));
            sb5 = sb6.toString();
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "downloadAndUnzipInner, cachedZipPath: " + sb5);
            vVar = new v(sb5);
        } catch (Exception e16) {
            w.a("MicroMsg.AppBrandLiveFileLoadHelper", e16, "download file url %s ", str);
        }
        if (vVar.e()) {
            if (!f(str2, sb5)) {
                w.d("MicroMsg.AppBrandLiveFileLoadHelper", "downloadAndUnzipInner, cachedZipPath is invalid 1");
                vVar.d();
            } else {
                z16 = false;
                if (z16) {
                    a(str, vVar);
                    if (!f(str2, sb5)) {
                        w.d("MicroMsg.AppBrandLiveFileLoadHelper", "downloadAndUnzipInner, cachedZipPath is invalid 2");
                        vVar.d();
                        return null;
                    }
                }
                if (!fVar.a(b16)) {
                    ZipInputStream zipInputStream = new ZipInputStream(x.a(vVar));
                    if (fVar.a(zipInputStream, b16) == null) {
                        w0.a((Closeable) zipInputStream);
                        return null;
                    }
                }
                w.d("MicroMsg.AppBrandLiveFileLoadHelper", "download done");
                return b16;
            }
        }
        z16 = true;
        if (z16) {
        }
        if (!fVar.a(b16)) {
        }
        w.d("MicroMsg.AppBrandLiveFileLoadHelper", "download done");
        return b16;
    }

    public static void d(String str, String str2) {
        w.d("MicroMsg.AppBrandLiveFileLoadHelper", "doCallback url:%s, localPath:%s", str, str2);
        List list = (List) f141324b.get(str);
        if (list != null && list.size() != 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                ((d) list.get(i3)).onLoad(str2);
            }
            f141324b.remove(str);
            return;
        }
        w.d("MicroMsg.AppBrandLiveFileLoadHelper", "doCallback callbacks nil");
    }

    public static void b(com.tencent.luggage.wxa.xd.d dVar, String str, String str2) {
        if (f141323a.containsKey(str)) {
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "download ing: %s", str);
            return;
        }
        f141323a.put(str, Boolean.TRUE);
        v c16 = c(dVar, str, str2);
        f141323a.remove(str);
        if (c16 != null) {
            c(str, c16.g());
        } else {
            c(str, null);
        }
    }

    public static void c(String str, String str2) {
        c0.a(new c(str, str2));
    }

    public static void a(com.tencent.luggage.wxa.xd.d dVar, String str, boolean z16, String str2, d dVar2) {
        w.d("MicroMsg.AppBrandLiveFileLoadHelper", "handleNetworkFile, url:%s", str);
        c0.a(new a(str, dVar2));
        com.tencent.luggage.wxa.co.a.a(new RunnableC6756b(z16, dVar, str, str2), "AppBrandLiveFileLoadHelperThread");
    }

    public static void a(String str, v vVar) {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection2;
        BufferedInputStream bufferedInputStream;
        Exception e16;
        InputStream inputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                inputStream = httpURLConnection.getInputStream();
                outputStream = x.b(vVar);
            } catch (Exception e17) {
                e = e17;
                outputStream = null;
            } catch (Throwable th5) {
                th = th5;
                outputStream = null;
            }
        } catch (Exception e18) {
            e = e18;
            httpURLConnection2 = null;
            outputStream = null;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            outputStream = null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
        } catch (Exception e19) {
            e = e19;
            Exception exc = e;
            httpURLConnection2 = httpURLConnection;
            e = exc;
            bufferedInputStream = null;
            e16 = e;
            httpURLConnection = httpURLConnection2;
            vVar.d();
            w.a("MicroMsg.AppBrandLiveFileLoadHelper", e16, "download file url %s ", str);
            try {
                httpURLConnection.getInputStream().close();
            } catch (Exception e26) {
                w.b("MicroMsg.AppBrandLiveFileLoadHelper", e26.getMessage());
            }
            w0.a((Closeable) outputStream);
            w0.a((Closeable) bufferedInputStream);
            httpURLConnection.disconnect();
        } catch (Throwable th7) {
            th = th7;
            try {
                httpURLConnection.getInputStream().close();
            } catch (Exception e27) {
                w.b("MicroMsg.AppBrandLiveFileLoadHelper", e27.getMessage());
            }
            w0.a((Closeable) outputStream);
            w0.a((Closeable) bufferedInputStream2);
            httpURLConnection.disconnect();
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    } else {
                        outputStream.write(bArr, 0, read);
                    }
                }
                outputStream.flush();
                try {
                    httpURLConnection.getInputStream().close();
                } catch (Exception e28) {
                    w.b("MicroMsg.AppBrandLiveFileLoadHelper", e28.getMessage());
                }
                w0.a((Closeable) outputStream);
                w0.a((Closeable) bufferedInputStream);
                httpURLConnection.disconnect();
            } catch (Throwable th8) {
                th = th8;
                bufferedInputStream2 = bufferedInputStream;
                httpURLConnection.getInputStream().close();
                w0.a((Closeable) outputStream);
                w0.a((Closeable) bufferedInputStream2);
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (Exception e29) {
            e16 = e29;
            vVar.d();
            w.a("MicroMsg.AppBrandLiveFileLoadHelper", e16, "download file url %s ", str);
            httpURLConnection.getInputStream().close();
            w0.a((Closeable) outputStream);
            w0.a((Closeable) bufferedInputStream);
            httpURLConnection.disconnect();
        }
    }

    public static String a(String str) {
        if (w0.c(str)) {
            return null;
        }
        return com.tencent.luggage.wxa.y8.c.a(str.getBytes());
    }

    public static boolean a(String str, InputStream inputStream) {
        if (w0.c(str)) {
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid target nil, no check");
            return true;
        }
        String a16 = com.tencent.luggage.wxa.y8.c.a(inputStream, 4096);
        w.d("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid file:%s target:%s", a16, str);
        return str.equals(a16);
    }

    public static com.tencent.luggage.wxa.ic.g a(com.tencent.luggage.wxa.xd.d dVar) {
        if (dVar == null) {
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, component is null");
            return null;
        }
        if (!(dVar instanceof i)) {
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, can not get runtime from component");
            return null;
        }
        com.tencent.luggage.wxa.ic.g runtime = ((i) dVar).getRuntime();
        if (runtime == null) {
            w.d("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, runtime is null");
        }
        return runtime;
    }
}
