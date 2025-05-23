package com.tencent.luggage.wxa.ka;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.luggage.wxa.ma.a;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h {

    /* renamed from: h, reason: collision with root package name */
    public static volatile h f131825h;

    /* renamed from: i, reason: collision with root package name */
    public static ThreadLocal f131826i;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f131830d;

    /* renamed from: a, reason: collision with root package name */
    public Map f131827a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Map f131829c = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public Handler f131828b = s.a();

    /* renamed from: e, reason: collision with root package name */
    public final Map f131831e = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Map f131833g = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final Map f131832f = new HashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f131834a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f131835b;

        public a(Class cls, String str) {
            this.f131834a = cls;
            this.f131835b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.a(this.f131834a);
            h.this.a(this.f131835b);
            o.a((Class) null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f131837a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f131838b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f131839c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements IBinder.DeathRecipient {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IBinder f131841a;

            public a(IBinder iBinder) {
                this.f131841a = iBinder;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "binderDied(%d, tid:%d)", Integer.valueOf(b.this.f131838b.hashCode()), Long.valueOf(Thread.currentThread().getId()));
                com.tencent.luggage.wxa.ra.a aVar = new com.tencent.luggage.wxa.ra.a(b.this.f131837a);
                b bVar = b.this;
                h.this.h(bVar.f131837a);
                aVar.binderDied();
                b bVar2 = b.this;
                h.this.d(bVar2.f131837a);
                this.f131841a.unlinkToDeath(this, 0);
            }
        }

        public b(String str, e eVar, Context context) {
            this.f131837a = str;
            this.f131838b = eVar;
            this.f131839c = context;
        }

        public final void a(String str) {
            com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "%s(%s, tid : %s)", str, Integer.valueOf(this.f131838b.hashCode()), Long.valueOf(Thread.currentThread().getId()));
            h.this.h(this.f131837a);
            com.tencent.luggage.wxa.ra.b.a(this.f131837a);
            h.this.e(this.f131837a);
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            a("onBindingDied");
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            a("onNullBinding");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str;
            if (iBinder == null) {
                com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "[%s]->[%s] onServiceConnected(%s) (%s), but service is null", n.c(), this.f131837a, Integer.valueOf(this.f131838b.hashCode()), Integer.valueOf(this.f131838b.f131850b.hashCode()));
                this.f131839c.unbindService(this.f131838b.f131850b);
                h.this.f131829c.remove(this.f131837a);
                e eVar = this.f131838b;
                eVar.f131850b = null;
                eVar.f131849a = null;
            } else {
                this.f131838b.f131849a = a.AbstractBinderC6463a.a(iBinder);
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(this.f131838b.hashCode());
                if (this.f131838b.f131849a == null) {
                    str = "null";
                } else {
                    str = "@" + this.f131838b.f131849a.hashCode();
                }
                objArr[1] = str;
                com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "onServiceConnected(%s), bridge:%s", objArr);
                try {
                    iBinder.linkToDeath(new a(iBinder), 0);
                } catch (RemoteException e16) {
                    com.tencent.luggage.wxa.ta.c.b("IPC.IPCBridgeManager", "binder register linkToDeath listener error, %s", Log.getStackTraceString(e16));
                }
            }
            if (this.f131838b.f131852d != null) {
                h.this.f131828b.removeCallbacks(this.f131838b.f131852d);
            }
            synchronized (this.f131838b) {
                this.f131838b.f131851c = false;
                this.f131838b.notifyAll();
                e eVar2 = this.f131838b;
                eVar2.f131852d = null;
                eVar2.f131850b = this;
            }
            com.tencent.luggage.wxa.ta.c.d("IPC.IPCBridgeManager", "onServiceConnected: [%s]->[%s] success", n.c(), this.f131837a);
            synchronized (h.this.f131829c) {
                h.this.f131829c.put(this.f131837a, this.f131838b);
            }
            h.this.f(this.f131837a);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a("onServiceDisconnected");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f131843a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f131844b;

        public c(e eVar, String str) {
            this.f131843a = eVar;
            this.f131844b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "on connect timeout(%s, tid : %s)", Integer.valueOf(this.f131843a.hashCode()), Long.valueOf(Thread.currentThread().getId()));
            if (!this.f131843a.f131851c) {
                return;
            }
            synchronized (this.f131843a) {
                if (!this.f131843a.f131851c) {
                    return;
                }
                this.f131843a.f131851c = false;
                this.f131843a.notifyAll();
                this.f131843a.f131852d = null;
                synchronized (h.this.f131829c) {
                    h.this.f131829c.remove(this.f131844b);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f131846a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f131847b;

        public d(Class cls, String str) {
            this.f131846a = cls;
            this.f131847b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.a(this.f131846a);
            h.this.a(this.f131847b);
            o.a((Class) null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public volatile com.tencent.luggage.wxa.ma.a f131849a;

        /* renamed from: b, reason: collision with root package name */
        public ServiceConnection f131850b;

        /* renamed from: c, reason: collision with root package name */
        public volatile boolean f131851c;

        /* renamed from: d, reason: collision with root package name */
        public Runnable f131852d;

        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }

        public String toString() {
            com.tencent.luggage.wxa.ma.a aVar;
            ServiceConnection serviceConnection;
            boolean z16;
            Runnable runnable;
            String str;
            String str2;
            String str3;
            synchronized (this) {
                aVar = this.f131849a;
                serviceConnection = this.f131850b;
                z16 = this.f131851c;
                runnable = this.f131852d;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("IPCBridgeWrapper{bridge=");
            if (aVar == null) {
                str = "null";
            } else {
                str = "@" + aVar.hashCode();
            }
            sb5.append(str);
            sb5.append(", serviceConnection=");
            if (serviceConnection == null) {
                str2 = "null";
            } else {
                str2 = "@" + serviceConnection.hashCode();
            }
            sb5.append(str2);
            sb5.append(", isConnecting=");
            sb5.append(z16);
            sb5.append(", connectTimeoutRunnable=");
            if (runnable == null) {
                str3 = "null";
            } else {
                str3 = "@" + runnable.hashCode();
            }
            sb5.append(str3);
            sb5.append('}');
            return sb5.toString();
        }
    }

    public final void d(String str) {
        synchronized (this.f131833g) {
            Set set = (Set) this.f131833g.get(str);
            if (set != null) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    ((t) it.next()).a();
                }
            }
        }
    }

    public final void e(String str) {
        LinkedList linkedList;
        synchronized (this.f131831e) {
            Set set = (Set) this.f131831e.get(str);
            if (set != null) {
                linkedList = new LinkedList(set);
            } else {
                linkedList = null;
            }
        }
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((u) it.next()).a();
            }
        }
    }

    public final void f(String str) {
        LinkedList linkedList;
        synchronized (this.f131832f) {
            Set set = (Set) this.f131832f.get(str);
            if (set != null) {
                linkedList = new LinkedList(set);
            } else {
                linkedList = null;
            }
        }
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((v) it.next()).a();
            }
        }
    }

    public void g(String str) {
        if (n.a(str)) {
            com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", str);
        } else {
            a(str);
        }
    }

    public void h(String str) {
        e eVar;
        if (n.a(str)) {
            com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "the same process(%s), do not need to release IPCBridge.", str);
            return;
        }
        synchronized (this.f131829c) {
            eVar = (e) this.f131829c.get(str);
        }
        if (eVar == null) {
            com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, IPCBridgeWrapper is null.", str);
            return;
        }
        try {
            if (eVar.f131851c) {
                synchronized (eVar) {
                    eVar.f131851c = false;
                    eVar.notifyAll();
                }
            }
            ServiceConnection serviceConnection = eVar.f131850b;
            if (serviceConnection == null) {
                com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", str);
                synchronized (this.f131829c) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        this.f131829c.remove(str, eVar);
                    } else {
                        this.f131829c.remove(str);
                    }
                }
                synchronized (eVar) {
                    eVar.f131849a = null;
                    eVar.f131851c = false;
                    eVar.f131850b = null;
                }
                return;
            }
            try {
                com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "unbind service for proc: " + str, new Object[0]);
                com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "unbind bw(%s) conn(%s)", Integer.valueOf(eVar.hashCode()), Integer.valueOf(serviceConnection.hashCode()));
                n.b().unbindService(serviceConnection);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.ta.c.b("IPC.IPCBridgeManager", "unbindService(%s) error, %s", str, Log.getStackTraceString(e16));
            }
            synchronized (this.f131829c) {
                if (Build.VERSION.SDK_INT >= 24) {
                    this.f131829c.remove(str, eVar);
                } else {
                    this.f131829c.remove(str);
                }
            }
            synchronized (eVar) {
                eVar.f131849a = null;
                eVar.f131851c = false;
                eVar.f131850b = null;
            }
        } catch (Throwable th5) {
            synchronized (this.f131829c) {
                if (Build.VERSION.SDK_INT >= 24) {
                    this.f131829c.remove(str, eVar);
                } else {
                    this.f131829c.remove(str);
                }
                synchronized (eVar) {
                    eVar.f131849a = null;
                    eVar.f131851c = false;
                    eVar.f131850b = null;
                    throw th5;
                }
            }
        }
    }

    public boolean c(String str) {
        return (n.a(str) || this.f131829c.get(str) == null) ? false : true;
    }

    public static h b() {
        if (f131825h == null) {
            synchronized (h.class) {
                if (f131825h == null) {
                    f131825h = new h();
                }
            }
        }
        return f131825h;
    }

    public final Class a(String str, String str2) {
        return (Class) this.f131827a.get(str + '/' + str2);
    }

    public static long c() {
        return Looper.myLooper() == Looper.getMainLooper() ? 3000L : 10000L;
    }

    public final String a() {
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            if (!stackTraceElement.getClassName().contains(h.class.getName())) {
                return stackTraceElement.toString();
            }
        }
        return "<native>";
    }

    public com.tencent.luggage.wxa.ma.a a(String str) {
        return a(str, false);
    }

    public boolean b(String str, v vVar) {
        if (vVar == null) {
            return false;
        }
        synchronized (this.f131832f) {
            Set set = (Set) this.f131832f.get(str);
            if (set == null) {
                return false;
            }
            return set.remove(vVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.tencent.luggage.wxa.ma.a a(String str, boolean z16) {
        boolean z17;
        e eVar = (e) this.f131829c.get(str);
        com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "[getIPCBridge] tid=[%d] %s -> %s, isRetryCall:%b, bridgeWrapper:%s, caller:%s", Long.valueOf(Thread.currentThread().getId()), n.c(), str, Boolean.valueOf(z16), eVar, a());
        a aVar = null;
        if (eVar == null) {
            if (this.f131830d) {
                com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "build IPCBridge(process : %s) failed, locked.", str);
                return null;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                com.tencent.luggage.wxa.ta.c.e("IPC.IPCBridgeManager", "getIPCBridge failed, can not create bridge on Main thread.", new Object[0]);
                s.a(new a(o.a(), str));
                return null;
            }
            String a16 = com.tencent.luggage.wxa.ta.d.a(str, n.b().getPackageName());
            Class a17 = a(a16, str);
            if (a17 == null) {
                com.tencent.luggage.wxa.ta.c.e("IPC.IPCBridgeManager", "getServiceClass by '%s', got null.", str);
                return null;
            }
            e eVar2 = new e(aVar);
            synchronized (this.f131829c) {
                this.f131829c.put(str, eVar2);
            }
            synchronized (eVar2) {
                eVar2.f131851c = true;
            }
            Context b16 = n.b();
            eVar2.f131850b = new b(str, eVar2, b16);
            try {
                try {
                    Intent className = new Intent().setClassName(a16, a17.getName());
                    com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "bindService(bw : %s, tid : %s, intent : %s, conn : %s)", Integer.valueOf(eVar2.hashCode()), Long.valueOf(Thread.currentThread().getId()), className, Integer.valueOf(eVar2.f131850b.hashCode()));
                    b16.bindService(className, eVar2.f131850b, 33);
                    c cVar = new c(eVar2, str);
                    eVar2.f131852d = cVar;
                    this.f131828b.postDelayed(cVar, c());
                    synchronized (eVar2) {
                        if (eVar2.f131851c) {
                            LockMethodProxy.wait(eVar2);
                        }
                    }
                    synchronized (eVar2) {
                        eVar2.f131851c = false;
                    }
                    eVar = eVar2;
                } catch (Throwable th5) {
                    synchronized (eVar2) {
                        eVar2.f131851c = false;
                        throw th5;
                    }
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.ta.c.b("IPC.IPCBridgeManager", "bindService error : %s", Log.getStackTraceString(e16));
                synchronized (this.f131829c) {
                    this.f131829c.remove(str);
                    synchronized (eVar2) {
                        eVar2.f131851c = false;
                        return null;
                    }
                }
            }
        } else {
            if (eVar.f131851c) {
                com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "getIPCBridge: bridge is connecting, may wait up to 10s", new Object[0]);
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    com.tencent.luggage.wxa.ta.c.e("IPC.IPCBridgeManager", "getIPCBridge is connecting, not wait in main thread", new Object[0]);
                    s.a(new d(o.a(), str));
                    return null;
                }
                try {
                    synchronized (eVar) {
                        if (eVar.f131851c) {
                            LockMethodProxy.wait(eVar);
                        }
                    }
                } catch (InterruptedException e17) {
                    com.tencent.luggage.wxa.ta.c.b("IPC.IPCBridgeManager", "%s", e17);
                }
                if (z17) {
                    synchronized (this.f131829c) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.f131829c.remove(str, eVar);
                        } else {
                            this.f131829c.remove(str);
                        }
                    }
                    com.tencent.luggage.wxa.ta.c.c("IPC.IPCBridgeManager", "[getIPCBridge] tid=[%d] %s -> %s !!retry connecting!!", Long.valueOf(Thread.currentThread().getId()), n.c(), str);
                    return a(str, true);
                }
            }
            if (!z16) {
                if (eVar.f131849a == null) {
                    synchronized (eVar) {
                        z17 = eVar.f131849a == null;
                    }
                } else {
                    z17 = false;
                }
                if (z17) {
                }
            }
        }
        return eVar.f131849a;
    }

    public boolean b(String str, u uVar) {
        if (uVar == null) {
            return false;
        }
        synchronized (this.f131831e) {
            Set set = (Set) this.f131831e.get(str);
            if (set == null) {
                return false;
            }
            return set.remove(uVar);
        }
    }

    public boolean b(String str) {
        e eVar;
        return (!c(str) || (eVar = (e) this.f131829c.get(str)) == null || eVar.f131851c || eVar.f131850b == null || eVar.f131849a == null) ? false : true;
    }

    public void a(String str, t tVar) {
        if (tVar == null) {
            return;
        }
        synchronized (this.f131833g) {
            Set set = (Set) this.f131833g.get(str);
            if (set == null) {
                set = new HashSet();
            }
            set.add(tVar);
            this.f131833g.put(str, set);
        }
    }

    public void a(String str, v vVar) {
        if (vVar == null) {
            return;
        }
        synchronized (this.f131832f) {
            Set set = (Set) this.f131832f.get(str);
            if (set == null) {
                set = new HashSet();
            }
            set.add(vVar);
            this.f131832f.put(str, set);
        }
    }

    public void a(String str, u uVar) {
        if (uVar == null) {
            return;
        }
        synchronized (this.f131831e) {
            Set set = (Set) this.f131831e.get(str);
            if (set == null) {
                set = new HashSet();
            }
            set.add(uVar);
            this.f131831e.put(str, set);
        }
    }

    public void a(String str, String str2, Class cls) {
        String str3 = str + "/" + str2;
        Class cls2 = (Class) this.f131827a.get(str3);
        if (cls2 != null) {
            com.tencent.luggage.wxa.ta.c.e("IPC.IPCBridgeManager", "warning: override ipc service: %s -> %s", str3, cls2);
        }
        this.f131827a.put(str3, cls);
    }
}
