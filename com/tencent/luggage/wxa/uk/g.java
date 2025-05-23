package com.tencent.luggage.wxa.uk;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.tn.w0;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentMap f142702a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static Map f142703b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final String f142704c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f142705a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f142706b;

        public a(String str, d dVar) {
            this.f142705a = str;
            this.f142706b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!g.f142703b.containsKey(this.f142705a)) {
                g.f142703b.put(this.f142705a, new ArrayList());
            }
            ((List) g.f142703b.get(this.f142705a)).add(this.f142706b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f142707a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f142708b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f142709c;

        public b(String str, String str2, String str3) {
            this.f142707a = str;
            this.f142708b = str2;
            this.f142709c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.b(this.f142707a, this.f142708b, this.f142709c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f142710a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f142711b;

        public c(String str, String str2) {
            this.f142710a = str;
            this.f142711b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.c(this.f142710a, this.f142711b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void onLoad(String str);
    }

    static {
        String a16 = com.tencent.luggage.wxa.tk.c.a();
        if (!a16.endsWith("/")) {
            a16 = a16 + "/";
        }
        String str = a16 + "wxacache/";
        f142704c = str;
        com.tencent.luggage.wxa.tn.l.a(str);
    }

    public static boolean b(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, d dVar2) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, url:%s", str);
        if (dVar == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, component is null");
            return false;
        }
        com.tencent.luggage.wxa.cp.v absoluteFile = dVar.getFileSystem().getAbsoluteFile(str);
        if (absoluteFile != null && absoluteFile.e()) {
            String g16 = absoluteFile.g();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, localPath:%s", g16);
            if (d(str2, g16) && dVar2 != null) {
                dVar2.onLoad(g16);
                return true;
            }
        }
        return false;
    }

    public static void c(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, d dVar2) {
        if (w0.c(str) || dVar2 == null) {
            return;
        }
        if (str.startsWith("wxfile://")) {
            if (b(dVar, str, str2, dVar2)) {
                return;
            }
            a(dVar2);
        } else {
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                if (a(dVar, str, str2, dVar2)) {
                    return;
                }
                a(dVar2);
                return;
            }
            a(str, str2, dVar2);
        }
    }

    public static boolean d(String str, String str2) {
        if (w0.c(str)) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid target nil, no check");
            return true;
        }
        String a16 = com.tencent.luggage.wxa.y8.c.a(str2);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid file:%s target:%s", a16, str);
        return str.equals(a16);
    }

    public static void a(d dVar) {
        if (dVar != null) {
            dVar.onLoad(null);
        }
    }

    public static boolean a(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, d dVar2) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, url:%s", str);
        if (dVar == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, component is null");
            return false;
        }
        if (!(dVar instanceof com.tencent.luggage.wxa.xd.i)) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, can not get runtime from component");
            return false;
        }
        com.tencent.luggage.wxa.ic.g runtime = ((com.tencent.luggage.wxa.xd.i) dVar).getRuntime();
        if (runtime == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, runtime is null");
            return false;
        }
        String a16 = a(str);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, localPath:%s", a16);
        com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(a16);
        if (!vVar.e()) {
            Bitmap a17 = com.tencent.luggage.wxa.kj.s.a(runtime, str);
            if (a17 != null) {
                try {
                    if (!a17.isRecycled()) {
                        try {
                            com.tencent.luggage.wxa.tn.d.a(a17, 100, Bitmap.CompressFormat.PNG, a16, true);
                            if (!a17.isRecycled()) {
                                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", a17);
                                a17.recycle();
                            }
                        } catch (IOException e16) {
                            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, fail to compress bitmap to file", e16);
                            if (!a17.isRecycled()) {
                                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", a17);
                                a17.recycle();
                            }
                            return false;
                        }
                    }
                } catch (Throwable th5) {
                    if (!a17.isRecycled()) {
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", a17);
                        a17.recycle();
                    }
                    throw th5;
                }
            }
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, no bitmap in the given url");
            return false;
        }
        if (!d(str2, a16)) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, file exists but md5 not valid, deleted:%b", Boolean.valueOf(vVar.d()));
        } else if (dVar2 != null) {
            dVar2.onLoad(a16);
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00f2: MOVE (r1 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:68:0x00f2 */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Boolean, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(String str, String str2, String str3) {
        OutputStream outputStream;
        Exception e16;
        Closeable closeable;
        BufferedInputStream bufferedInputStream;
        com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(str3);
        if (vVar.e()) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download already exists: %s", str);
            if (d(str2, str3)) {
                b(str, str3);
                return;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download already exists, but md5 not valid. deleted:%b", Boolean.valueOf(vVar.d()));
        }
        if (f142702a.containsKey(str)) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download ing: %s", str);
            return;
        }
        ConcurrentMap concurrentMap = f142702a;
        ?? r56 = Boolean.TRUE;
        concurrentMap.put(str, r56);
        Closeable closeable2 = null;
        try {
            try {
                r56 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    outputStream = com.tencent.luggage.wxa.cp.x.b(vVar);
                    try {
                        bufferedInputStream = new BufferedInputStream(r56.getInputStream());
                    } catch (Exception e17) {
                        e16 = e17;
                        r56 = r56;
                        bufferedInputStream = null;
                        vVar.d();
                        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", e16, "download file url %s ", str);
                        try {
                            r56.getInputStream().close();
                        } catch (Exception e18) {
                            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", e18.getMessage());
                        }
                        w0.a((Closeable) outputStream);
                        w0.a((Closeable) bufferedInputStream);
                        r56.disconnect();
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download done");
                        f142702a.remove(str);
                        if (d(str2, str3)) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            r56.getInputStream().close();
                        } catch (Exception e19) {
                            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", e19.getMessage());
                        }
                        w0.a((Closeable) outputStream);
                        w0.a(closeable2);
                        r56.disconnect();
                        throw th;
                    }
                } catch (Exception e26) {
                    e16 = e26;
                    outputStream = null;
                    r56 = r56;
                } catch (Throwable th6) {
                    th = th6;
                    outputStream = null;
                }
            } catch (Exception e27) {
                outputStream = null;
                e16 = e27;
                r56 = 0;
            } catch (Throwable th7) {
                th = th7;
                r56 = 0;
                outputStream = null;
            }
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
                    r56.getInputStream().close();
                } catch (Exception e28) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", e28.getMessage());
                }
                w0.a((Closeable) outputStream);
                w0.a((Closeable) bufferedInputStream);
                r56.disconnect();
            } catch (Exception e29) {
                e16 = e29;
                vVar.d();
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", e16, "download file url %s ", str);
                r56.getInputStream().close();
                w0.a((Closeable) outputStream);
                w0.a((Closeable) bufferedInputStream);
                r56.disconnect();
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download done");
                f142702a.remove(str);
                if (d(str2, str3)) {
                }
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download done");
            f142702a.remove(str);
            if (d(str2, str3)) {
                b(str, str3);
            } else {
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "download md5 not valid");
                b(str, null);
            }
        } catch (Throwable th8) {
            th = th8;
            closeable2 = closeable;
        }
    }

    public static void c(String str, String str2) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "doCallback url:%s, localPath:%s", str, str2);
        List list = (List) f142703b.get(str);
        if (list != null && list.size() != 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                ((d) list.get(i3)).onLoad(str2);
            }
            f142703b.remove(str);
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "doCallback callbacks nil");
    }

    public static void a(String str, String str2, d dVar) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, url:%s", str);
        String a16 = a(str);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, localPath:%s", a16);
        com.tencent.luggage.wxa.tn.c0.a(new a(str, dVar));
        com.tencent.luggage.wxa.co.a.a(new b(str, str2, a16), "AppBrandLiveFileLoadHelperThread");
    }

    public static String a(String str) {
        return String.format("%s%s", f142704c, b(str));
    }

    public static void b(String str, String str2) {
        com.tencent.luggage.wxa.tn.c0.a(new c(str, str2));
    }

    public static String b(String str) {
        if (w0.c(str)) {
            return null;
        }
        return com.tencent.luggage.wxa.y8.c.a(str.getBytes());
    }
}
