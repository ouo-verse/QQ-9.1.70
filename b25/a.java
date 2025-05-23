package b25;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static volatile a f27761i = null;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f27762j = false;

    /* renamed from: k, reason: collision with root package name */
    public static volatile boolean f27763k = false;

    /* renamed from: b, reason: collision with root package name */
    private Object f27765b;

    /* renamed from: c, reason: collision with root package name */
    private c25.b f27766c;

    /* renamed from: d, reason: collision with root package name */
    private c25.c f27767d;

    /* renamed from: f, reason: collision with root package name */
    private c25.d f27769f;

    /* renamed from: g, reason: collision with root package name */
    private Handler.Callback f27770g;

    /* renamed from: a, reason: collision with root package name */
    private ClassLoader f27764a = null;

    /* renamed from: e, reason: collision with root package name */
    private Handler.Callback f27768e = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f27771h = true;

    a() {
    }

    private void b() {
        if (this.f27769f == null) {
            return;
        }
        try {
            this.f27770g = new g(new c(this));
            q.b(this.f27765b, null, q.c(this.f27765b, "setOuterSharkInterface", Handler.Callback.class), this.f27770g);
        } catch (Throwable th5) {
            p.b(th5);
        }
    }

    private boolean c(Context context, ClassLoader classLoader) {
        try {
            p.a("KcSdkShellManager", "loadSdkByClassLoader " + String.format(" process id [%d]", Integer.valueOf(Process.myPid())));
            this.f27764a = classLoader;
            this.f27765b = classLoader.loadClass("tmsdk.common.KcSdkManager").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            p.a("KcSdkShellManager", "mKcsdkManager:" + this.f27765b);
            q.b(this.f27765b, null, q.c(this.f27765b, "setLogEnable", Boolean.TYPE), Boolean.valueOf(this.f27771h));
            g();
            b();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean d(Context context, String str) {
        try {
            return c(context, new DexClassLoader(str, context.getApplicationInfo().dataDir, context.getApplicationInfo().nativeLibraryDir, a.class.getClassLoader()));
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:9|10|11|(12:13|14|15|16|(1:18)|19|(1:21)|22|(1:24)(1:34)|(4:(1:27)|28|29|30)|32|33)|39|14|15|16|(0)|19|(0)|22|(0)(0)|(0)|32|33) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f0, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f1, code lost:
    
        r9.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:16:0x0043, B:18:0x0047, B:19:0x0050, B:21:0x006b, B:22:0x0084, B:24:0x008a, B:27:0x0097, B:28:0x00a1, B:34:0x008f), top: B:15:0x0043, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:16:0x0043, B:18:0x0047, B:19:0x0050, B:21:0x006b, B:22:0x0084, B:24:0x008a, B:27:0x0097, B:28:0x00a1, B:34:0x008f), top: B:15:0x0043, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008a A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:16:0x0043, B:18:0x0047, B:19:0x0050, B:21:0x006b, B:22:0x0084, B:24:0x008a, B:27:0x0097, B:28:0x00a1, B:34:0x008f), top: B:15:0x0043, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:16:0x0043, B:18:0x0047, B:19:0x0050, B:21:0x006b, B:22:0x0084, B:24:0x008a, B:27:0x0097, B:28:0x00a1, B:34:0x008f), top: B:15:0x0043, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean e(Context context, boolean z16, c25.e eVar, String str, ClassLoader classLoader) {
        String str2;
        Thread currentThread;
        boolean c16;
        File file;
        File file2;
        if (f27762j) {
            return true;
        }
        k kVar = null;
        try {
            file = new File(str);
            file2 = new File(context.getFilesDir(), "kingcard/kcsdk.jar");
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        if (file.exists()) {
            str2 = file2.getCanonicalPath();
            p.a("KcSdkShellManager", "so_sp_re: " + str2);
            if (this.f27771h) {
                p.a("KcSdkShellManager", "init");
            }
            r.a(context);
            currentThread = Thread.currentThread();
            if (currentThread.getId() != Looper.getMainLooper().getThread().getId()) {
                currentThread.setName("kcsdk_" + currentThread.getName());
            }
            if (TextUtils.isEmpty(str2)) {
                c16 = m(context, str2);
            } else {
                c16 = c(context, classLoader);
            }
            if (c16) {
                if (eVar != null) {
                    kVar = new k(new b(this, eVar));
                }
                f27762j = true;
                boolean booleanValue = ((Boolean) q.b(this.f27765b, Boolean.class, q.c(this.f27765b, "initForShell", Context.class, Boolean.TYPE, Handler.Callback.class), context, Boolean.valueOf(z16), kVar)).booleanValue();
                p.a("KcSdkShellManager", "initResult:" + booleanValue);
                return booleanValue;
            }
            return false;
        }
        str2 = null;
        if (this.f27771h) {
        }
        r.a(context);
        currentThread = Thread.currentThread();
        if (currentThread.getId() != Looper.getMainLooper().getThread().getId()) {
        }
        if (TextUtils.isEmpty(str2)) {
        }
        if (c16) {
        }
        return false;
    }

    private void g() {
        if (this.f27767d == null) {
            return;
        }
        try {
            this.f27768e = new f(new d(this));
            q.b(this.f27765b, null, q.c(this.f27765b, "setLogPrint", Handler.Callback.class), this.f27768e);
        } catch (Throwable th5) {
            p.b(th5);
        }
    }

    public static a h() {
        if (f27761i == null) {
            synchronized (a.class) {
                if (f27761i == null) {
                    f27761i = new a();
                }
            }
        }
        return f27761i;
    }

    public ClassLoader i() {
        return this.f27764a;
    }

    public synchronized c25.b j(Context context) {
        c25.b bVar = this.f27766c;
        if (bVar != null) {
            return bVar;
        }
        Object obj = this.f27765b;
        if (obj == null) {
            return null;
        }
        Object b16 = q.b(this.f27765b, Object.class, q.c(obj, "getKingCardManager", Context.class), context);
        if (b16 == null) {
            return null;
        }
        m mVar = new m(b16);
        this.f27766c = mVar;
        return mVar;
    }

    public boolean k(Context context, boolean z16, String str, c25.e eVar) {
        if (f27762j) {
            return true;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            if (!new File(str).exists()) {
                return false;
            }
            return e(context, z16, eVar, str, null);
        }
        throw new RuntimeException("Must init king card sdk in work thread");
    }

    public boolean l() {
        return this.f27771h;
    }

    public boolean m(Context context, String str) {
        if (f27763k) {
            return true;
        }
        if (this.f27771h) {
            p.a("KcSdkShellManager", "sdkPath:" + str);
        }
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            boolean d16 = d(context, str);
            f27763k = d16;
            return d16;
        }
        return false;
    }

    public void n(boolean z16) {
        this.f27771h = z16;
        Object obj = this.f27765b;
        if (obj == null) {
            return;
        }
        q.b(this.f27765b, null, q.c(obj, "setLogEnable", Boolean.TYPE), Boolean.valueOf(this.f27771h));
    }

    public void o(c25.c cVar) {
        this.f27767d = cVar;
        g();
    }
}
