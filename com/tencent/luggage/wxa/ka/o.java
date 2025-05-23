package com.tencent.luggage.wxa.ka;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.luggage.wxa.ma.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class o {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f131859a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f131860b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Parcelable f131861c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ i f131862d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f131863e;

        public a(Class cls, String str, Parcelable parcelable, i iVar, String str2) {
            this.f131859a = cls;
            this.f131860b = str;
            this.f131861c = parcelable;
            this.f131862d = iVar;
            this.f131863e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            c cVar;
            com.tencent.luggage.wxa.ta.c.c("IPC.IPCInvoker", "invokeAsync run, task=" + this.f131859a + ", proc=" + this.f131860b, new Object[0]);
            if (n.a(this.f131860b)) {
                f fVar = (f) w.a(this.f131859a, f.class);
                if (fVar == null) {
                    com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvoker", "invokeAsync failed, newInstance(%s) return null.", this.f131859a);
                    return;
                } else {
                    fVar.a(this.f131861c, this.f131862d);
                    return;
                }
            }
            o.a(this.f131859a);
            com.tencent.luggage.wxa.ma.a a16 = h.b().a(this.f131860b);
            if (a16 == null) {
                com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", this.f131860b);
                i iVar = this.f131862d;
                if (iVar instanceof j) {
                    ((j) iVar).b();
                }
                return;
            }
            try {
                z16 = com.tencent.luggage.wxa.ta.a.a(this.f131859a, com.tencent.luggage.wxa.na.a.class);
            } catch (Exception unused) {
                z16 = false;
            }
            try {
                if (this.f131862d != null) {
                    cVar = new c(this.f131860b, this.f131862d, z16);
                } else {
                    cVar = null;
                }
                a16.a(o.b(this.f131861c, this.f131859a, this.f131863e), this.f131859a.getName(), cVar);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.ta.c.a("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", e16);
                i iVar2 = this.f131862d;
                if (iVar2 instanceof j) {
                    ((j) iVar2).a(e16);
                }
            } finally {
                o.a((Class) null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f131864a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f131865b;

        public b(String str, Runnable runnable) {
            this.f131864a = str;
            this.f131865b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.d();
            x.a(this.f131865b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c extends b.a implements com.tencent.luggage.wxa.ra.c {

        /* renamed from: d, reason: collision with root package name */
        public static final Map f131866d = new WeakHashMap();

        /* renamed from: a, reason: collision with root package name */
        public String f131867a;

        /* renamed from: b, reason: collision with root package name */
        public i f131868b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f131869c;

        public c(String str, i iVar, boolean z16) {
            this.f131868b = iVar;
            this.f131867a = str;
            this.f131869c = z16;
            com.tencent.luggage.wxa.ra.b.a(str, this);
            com.tencent.luggage.wxa.ta.c.c("IPC.IPCInvokeCallbackWrapper", "keep ref of callback(%s)", Integer.valueOf(iVar.hashCode()));
            Map map = f131866d;
            synchronized (map) {
                map.put(iVar, new WeakReference(this));
            }
        }

        public void finalize() {
            recycle();
            com.tencent.luggage.wxa.ta.c.c("IPC.IPCInvokeCallbackWrapper", "finalize(%s)", Integer.valueOf(hashCode()));
            super.finalize();
        }

        @Override // com.tencent.luggage.wxa.ma.b
        public void onCallback(Bundle bundle) {
            i iVar = this.f131868b;
            if (iVar == null) {
                com.tencent.luggage.wxa.ta.c.e("IPC.IPCInvokeCallbackWrapper", "callback failed, ref has been release", new Object[0]);
                return;
            }
            if (bundle == null) {
                iVar.a(null);
                return;
            }
            bundle.setClassLoader(o.class.getClassLoader());
            if (bundle.getBoolean("__command_release_ref")) {
                com.tencent.luggage.wxa.ta.c.c("IPC.IPCInvokeCallbackWrapper", "release ref of callback(%s)", Integer.valueOf(iVar.hashCode()));
                if (iVar instanceof j) {
                    try {
                        ((j) iVar).a();
                    } catch (Throwable th5) {
                        com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvokeCallbackWrapper", "callback onReleaseRef fail " + Log.getStackTraceString(th5), new Object[0]);
                    }
                }
                recycle();
                return;
            }
            String string = bundle.getString("__remote_exception");
            if (string != null) {
                com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvokeCallbackWrapper", "callback failed, remote exception " + string, new Object[0]);
                if (iVar instanceof j) {
                    try {
                        ((j) iVar).a(string);
                    } catch (Throwable th6) {
                        com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvokeCallbackWrapper", "callback onCaughtRemoteException fail " + Log.getStackTraceString(th6), new Object[0]);
                    }
                }
            }
            try {
                iVar.a(bundle.getParcelable("__remote_task_result_data"));
            } finally {
                if (this.f131869c) {
                    recycle();
                }
            }
        }

        @Override // com.tencent.luggage.wxa.ra.c
        public void recycle() {
            i iVar = this.f131868b;
            if (iVar != null) {
                Map map = f131866d;
                synchronized (map) {
                    map.remove(iVar);
                }
            }
            this.f131868b = null;
            com.tencent.luggage.wxa.ra.b.b(this.f131867a, this);
        }
    }

    public static void b(String str, v vVar) {
        h.b().b(str, vVar);
    }

    public static boolean a(String str, Parcelable parcelable, Class cls, i iVar, String str2) {
        if (str == null || str.length() == 0) {
            com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvoker", "invokeAsync failed, process is null or nil. stack=" + Log.getStackTraceString(new Throwable()), new Object[0]);
            return false;
        }
        if (cls == null) {
            com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvoker", "invokeAsync failed, taskClass is null(process : %s).", str);
            return false;
        }
        p.a();
        a aVar = new a(cls, str, parcelable, iVar, str2);
        s sVar = s.f131876c;
        b bVar = new b(str2, aVar);
        n.a();
        bVar.run();
        return true;
    }

    public static void b(String str, u uVar) {
        h.b().b(str, uVar);
    }

    public static Bundle b(Parcelable parcelable, Class cls, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("__remote_task_data", parcelable);
        if (str != null) {
            bundle.putString("__command_tag", str);
        }
        return bundle;
    }

    public static boolean a(String str, Parcelable parcelable, Class cls, i iVar) {
        return a(str, parcelable, cls, iVar, null);
    }

    public static void a(String str, v vVar) {
        h.b().a(str, vVar);
    }

    public static void a(String str, u uVar) {
        h.b().a(str, uVar);
    }

    public static void a(String str, t tVar) {
        h.b().a(str, tVar);
    }

    public static boolean a(String str) {
        if (n.a(str)) {
            return true;
        }
        return h.b().b(str);
    }

    public static Parcelable a(String str, Parcelable parcelable, Class cls) {
        if (str == null || str.length() == 0) {
            com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvoker", "invokeSync failed, process is null or nil.", new Object[0]);
            return null;
        }
        if (cls == null) {
            com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvoker", "invokeSync failed, taskClass is null(process : %s).", str);
            return null;
        }
        p.a();
        if (n.a(str)) {
            Object invoke = ((r) w.a(cls, r.class)).invoke(parcelable);
            if (invoke == null) {
                return null;
            }
            return (Parcelable) invoke;
        }
        a(cls);
        com.tencent.luggage.wxa.ma.a a16 = h.b().a(str);
        try {
            if (a16 == null) {
                com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", str);
                return null;
            }
            com.tencent.luggage.wxa.ta.c.c("IPC.IPCInvoker", "invokeSync run, task=" + cls + ", proc=" + str, new Object[0]);
            Bundle a17 = a16.a(b(parcelable, cls, null), cls.getName());
            if (a17 == null) {
                return null;
            }
            a17.setClassLoader(o.class.getClassLoader());
            return a17.getParcelable("__remote_task_result_data");
        } catch (RemoteException e16) {
            com.tencent.luggage.wxa.ta.c.a("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", e16);
            return null;
        } finally {
            a((Class) null);
        }
    }

    public static void a(Class cls) {
        if (h.f131826i == null) {
            h.f131826i = new ThreadLocal();
        }
        h.f131826i.set(cls);
    }

    public static Class a() {
        ThreadLocal threadLocal = h.f131826i;
        if (threadLocal != null) {
            return (Class) threadLocal.get();
        }
        return null;
    }
}
