package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import dalvik.system.DexClassLoader;

/* compiled from: P */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static DexClassLoader f30160a;

    /* renamed from: b, reason: collision with root package name */
    public static Context f30161b;

    /* renamed from: c, reason: collision with root package name */
    public static f f30162c;

    public f(Context context) {
        f30161b = context;
        m.a(context).a();
    }

    public static f a(Context context) {
        if (f30162c == null) {
            synchronized (f.class) {
                if (f30162c == null) {
                    f30162c = new f(context);
                }
            }
        }
        return f30162c;
    }

    public void b() {
        try {
            new BaseThread(new h(f30161b, q.d(q.c(f30161b, "__SP_Tencent_Loc_COMP_INFO__sapp_", "")), false)).start();
        } catch (Throwable unused) {
        }
    }

    public void c() {
        f30162c = null;
        f30160a = null;
    }

    public synchronized DexClassLoader a() {
        DexClassLoader dexClassLoader = f30160a;
        if (dexClassLoader != null) {
            return dexClassLoader;
        }
        Context context = f30161b;
        if (context == null) {
            return null;
        }
        d.a(context).b("load_sapp");
        q.f30192e = System.currentTimeMillis();
        DexClassLoader b16 = g.a(f30161b).b();
        f30160a = b16;
        if (b16 != null) {
            e.a(f30161b).a();
        }
        b();
        d.a(f30161b).c("load_sapp");
        return f30160a;
    }
}
