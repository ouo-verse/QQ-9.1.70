package com.tencent.luggage.wxa.r4;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.luggage.wxa.a9.b;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.c0;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.commonjni.BatchRequestWxaFileDescriptorsResponse;
import com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final AppBrandCommonBindingJni f139077a;

    /* renamed from: b, reason: collision with root package name */
    public final BufferURLManager f139078b;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.r4.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractC6666a implements com.tencent.luggage.wxa.a9.a {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f139079a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f139080b = new AtomicBoolean(false);

        /* renamed from: c, reason: collision with root package name */
        public volatile String f139081c;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.r4.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6667a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Throwable f139082a;

            public RunnableC6667a(Throwable th5) {
                this.f139082a = th5;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw this.f139082a;
            }
        }

        public AbstractC6666a(com.tencent.luggage.wxa.xd.e eVar) {
            this.f139079a = new WeakReference(eVar);
        }

        @Override // com.tencent.luggage.wxa.a9.a
        public boolean a(String str, String str2) {
            return false;
        }

        @Override // com.tencent.luggage.wxa.a9.a
        public String b(String str) {
            com.tencent.luggage.wxa.rc.q qVar;
            com.tencent.luggage.wxa.xd.e eVar = (com.tencent.luggage.wxa.xd.e) this.f139079a.get();
            if (eVar == null || (qVar = (com.tencent.luggage.wxa.rc.q) eVar.b(com.tencent.luggage.wxa.rc.q.class)) == null) {
                return null;
            }
            return qVar.g(str);
        }

        @Override // com.tencent.luggage.wxa.a9.a
        public ByteBuffer c(String str) {
            if (this.f139079a.get() == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AbsAppBrandDelegate", "hy: component released when readWeAppFile");
                return null;
            }
            new com.tencent.luggage.wxa.tk.i();
            com.tencent.luggage.wxa.rc.q qVar = (com.tencent.luggage.wxa.rc.q) ((com.tencent.luggage.wxa.xd.e) this.f139079a.get()).b(com.tencent.luggage.wxa.rc.q.class);
            if (qVar == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AbsAppBrandDelegate", "commLibReader null");
                return null;
            }
            InputStream a16 = qVar.a(str);
            if (a16 == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AbsAppBrandDelegate", "commLibReader openRead null");
                return null;
            }
            byte[] a17 = com.tencent.luggage.wxa.tk.c.a(a16);
            if (a17.length == 0) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AbsAppBrandDelegate", "commLibReader byteArray null");
                return null;
            }
            return c0.a(a17);
        }

        @Override // com.tencent.luggage.wxa.a9.a
        public void d(String str) {
        }

        @Override // com.tencent.luggage.wxa.a9.a
        public void e(String str) {
            com.tencent.luggage.wxa.nn.a.a(Base64.encodeToString(str.getBytes(), 2), "appbrand_commonbinding");
        }

        public void f(String str) {
            this.f139080b.set(true);
            this.f139081c = str;
        }

        @Override // com.tencent.luggage.wxa.a9.a
        public String a(String str, String str2, String str3, int i3, boolean z16, int i16) {
            if (this.f139079a.get() != null && !this.f139080b.get()) {
                try {
                    return ((com.tencent.luggage.wxa.xd.e) this.f139079a.get()).a(str, str2, str3, i3, z16, (com.tencent.luggage.wxa.ei.p) null, i16);
                } catch (Throwable th5) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AbsAppBrandDelegate", th5, "nativeInvokeHandler", new Object[0]);
                    com.tencent.luggage.wxa.tn.c0.a(new RunnableC6667a(th5));
                    return "";
                }
            }
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AbsAppBrandDelegate", "hy: component released when nativeInvokeHandler: %s, %s, %d, %b", str, str2, Integer.valueOf(i3), Boolean.valueOf(z16));
            String str4 = this.f139081c;
            if (TextUtils.isEmpty(str4)) {
                return null;
            }
            try {
                return new JSONObject().put("errMsg", str + ":" + str4).toString();
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // com.tencent.luggage.wxa.a9.a
        public String[] d() {
            if (this.f139079a.get() == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AbsAppBrandDelegate", "hy: component released when getAsyncableJsApis");
                return new String[0];
            }
            return ((com.tencent.luggage.wxa.xd.e) this.f139079a.get()).m();
        }

        @Override // com.tencent.luggage.wxa.a9.a
        public ByteBuffer a(String str) {
            if (this.f139079a.get() == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AbsAppBrandDelegate", "hy: component released when readWeAppFile");
                return null;
            }
            com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
            com.tencent.luggage.wxa.rc.r fileSystem = ((com.tencent.luggage.wxa.xd.e) this.f139079a.get()).getFileSystem();
            Objects.requireNonNull(fileSystem);
            com.tencent.luggage.wxa.rc.l readFile = fileSystem.readFile(str, iVar);
            if (readFile == com.tencent.luggage.wxa.rc.l.OK) {
                return c0.a((ByteBuffer) iVar.f141499a);
            }
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AbsAppBrandDelegate", "readFile %s failed: %s", str, readFile);
            return null;
        }

        @Override // com.tencent.luggage.wxa.a9.a
        public BatchRequestWxaFileDescriptorsResponse a(String[] strArr, Map map) {
            com.tencent.luggage.wxa.xd.e eVar = (com.tencent.luggage.wxa.xd.e) this.f139079a.get();
            if (eVar != null && (eVar instanceof com.tencent.luggage.wxa.ic.d)) {
                return com.tencent.luggage.wxa.uk.y.a((com.tencent.luggage.wxa.ic.d) eVar, strArr);
            }
            return null;
        }

        @Override // com.tencent.luggage.wxa.a9.a
        public void a(int i3, int i16, int i17) {
            try {
                com.tencent.luggage.wxa.xm.b.INSTANCE.a(i3, i16, i17);
            } catch (Exception unused) {
            }
        }

        @Override // com.tencent.luggage.wxa.a9.a
        public void a(int i3, String str) {
            try {
                com.tencent.luggage.wxa.xm.b.INSTANCE.a(i3, str);
            } catch (Exception unused) {
            }
        }
    }

    public a(com.tencent.luggage.wxa.a9.a aVar) {
        a();
        com.tencent.luggage.wxa.so.h.a("new AppBrandCommonBindingJni");
        this.f139077a = new AppBrandCommonBindingJni(aVar);
        com.tencent.luggage.wxa.so.h.a();
        com.tencent.luggage.wxa.so.h.a("new BufferURLManager");
        this.f139078b = new BufferURLManager();
        com.tencent.luggage.wxa.so.h.a();
    }

    public static void a() {
        b.a();
    }

    public BufferURLManager b() {
        return this.f139078b;
    }

    public AppBrandCommonBindingJni c() {
        return this.f139077a;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.r4.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6668a implements b.InterfaceC5992b {
            @Override // com.tencent.luggage.wxa.a9.b.InterfaceC5992b
            public void loadLibrary(String str) {
                com.tencent.luggage.wxa.so.h.a("AppBrandCommonBinding.loadLibrary(" + str + ")");
                long a16 = w0.a();
                com.tencent.luggage.wxa.aa.h.g(str);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandCommonBinding", "hy: test loading %s using %d ms", str, Long.valueOf(w0.e(a16)));
                com.tencent.luggage.wxa.so.h.a();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.r4.a$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6669b implements com.tencent.luggage.wxa.a9.e {
            @Override // com.tencent.luggage.wxa.a9.e
            public void e(String str, String str2, Object... objArr) {
                com.tencent.luggage.wxa.tn.w.b(str, str2, objArr);
            }

            @Override // com.tencent.luggage.wxa.a9.e
            public void i(String str, String str2, Object... objArr) {
                com.tencent.luggage.wxa.tn.w.d(str, str2, objArr);
            }

            @Override // com.tencent.luggage.wxa.a9.e
            public void printStackTrace(String str, Throwable th5, String str2, Object... objArr) {
                com.tencent.luggage.wxa.tn.w.a(str, th5, str2, objArr);
            }
        }

        static {
            com.tencent.luggage.wxa.so.h.a("AppBrandCommonBinding.LibraryLoader.<clinit>");
            com.tencent.luggage.wxa.a9.b.a(new C6668a());
            com.tencent.luggage.wxa.a9.f.a(new C6669b());
            com.tencent.luggage.wxa.a9.b.a("wxa-runtime-binding");
            com.tencent.luggage.wxa.so.h.a();
        }

        b() {
        }

        public static void a() {
        }
    }
}
