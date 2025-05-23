package com.tencent.luggage.wxa.ka;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.luggage.wxa.ma.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends Service {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f131800d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f131801a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f131802b;

    /* renamed from: c, reason: collision with root package name */
    public final a.AbstractBinderC6463a f131803c = new BinderC6368a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements i, com.tencent.luggage.wxa.pa.a {

        /* renamed from: a, reason: collision with root package name */
        public com.tencent.luggage.wxa.ma.b f131813a;

        /* renamed from: b, reason: collision with root package name */
        public final List f131814b = new LinkedList();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ka.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6370a implements IBinder.DeathRecipient {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ma.b f131815a;

            public C6370a(com.tencent.luggage.wxa.ma.b bVar) {
                this.f131815a = bVar;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                try {
                    com.tencent.luggage.wxa.ta.c.c("IPC.IPCInvokeCallbackProxy", "binderDied(%s)", Integer.valueOf(this.f131815a.hashCode()));
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.ta.c.c("IPC.IPCInvokeCallbackProxy", "DeathRecipient %s", e16.getMessage());
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ka.a$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class RunnableC6371b implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public static final Bundle f131817b;

            /* renamed from: a, reason: collision with root package name */
            public com.tencent.luggage.wxa.ma.b f131818a;

            static {
                Bundle bundle = new Bundle();
                f131817b = bundle;
                bundle.putBoolean("__command_release_ref", true);
            }

            public RunnableC6371b(com.tencent.luggage.wxa.ma.b bVar) {
                this.f131818a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.luggage.wxa.ta.c.c("IPC.IPCInvokeCallbackProxy", "notify release ref of callback(%s).", Integer.valueOf(this.f131818a.hashCode()));
                    this.f131818a.onCallback(f131817b);
                    com.tencent.luggage.wxa.ra.b.b(this.f131818a);
                    this.f131818a = null;
                } catch (RemoteException e16) {
                    com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s", Log.getStackTraceString(e16));
                } catch (Exception e17) {
                    com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s\n %s", e17.getMessage(), Log.getStackTraceString(e17));
                }
            }
        }

        public b(com.tencent.luggage.wxa.ma.b bVar) {
            this.f131813a = bVar;
            if (bVar != null) {
                com.tencent.luggage.wxa.ta.c.c("IPC.IPCInvokeCallbackProxy", "keep ref of callback(%s)", Integer.valueOf(bVar.hashCode()));
                com.tencent.luggage.wxa.ra.b.a(bVar);
                try {
                    this.f131813a.asBinder().linkToDeath(new C6370a(bVar), 0);
                } catch (RemoteException e16) {
                    com.tencent.luggage.wxa.ta.c.c("IPC.IPCInvokeCallbackProxy", "%s", e16.getMessage());
                }
            }
        }

        public void finalize() {
            try {
                if (this.f131813a != null) {
                    s.a(new RunnableC6371b(this.f131813a));
                    this.f131813a = null;
                }
            } catch (Throwable th5) {
                try {
                    com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvokeCallbackProxy", "finalize failed : " + th5.getMessage(), new Object[0]);
                } finally {
                    super.finalize();
                }
            }
        }

        @Override // com.tencent.luggage.wxa.ka.i
        public void a(Parcelable parcelable) {
            com.tencent.luggage.wxa.ma.b bVar = this.f131813a;
            if (bVar == null) {
                return;
            }
            try {
                com.tencent.luggage.wxa.ta.c.c("IPC.IPCInvokeCallbackProxy", "onCallback(%d) invoke", Integer.valueOf(bVar.hashCode()));
                com.tencent.luggage.wxa.ta.c.c("IPC.IPCInvokeCallbackProxy", "onCallback(%d), isBinderAlive:%b, pingBinder:%b", Integer.valueOf(this.f131813a.hashCode()), Boolean.valueOf(this.f131813a.asBinder().isBinderAlive()), Boolean.valueOf(this.f131813a.asBinder().pingBinder()));
            } catch (Exception e16) {
                com.tencent.luggage.wxa.ta.c.c("IPC.IPCInvokeCallbackProxy", "onCallback %s", e16.getMessage());
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putParcelable("__remote_task_result_data", parcelable);
                this.f131813a.onCallback(bundle);
            } catch (Exception e17) {
                com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvokeCallbackProxy", "%s", Log.getStackTraceString(e17));
                if (this.f131814b.isEmpty()) {
                    return;
                }
                synchronized (this.f131814b) {
                    Iterator it = new LinkedList(this.f131814b).iterator();
                    if (it.hasNext()) {
                        com.tencent.luggage.wxa.k0.d.a(it.next());
                        throw null;
                    }
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.tencent.luggage.wxa.ka.b.a(intent);
        com.tencent.luggage.wxa.ta.c.c("IPC.BaseIPCService", "onBind, myProcess:%s, invokeProcess:%s, invokeId:%d, killSelf(%s)", n.c(), intent.getStringExtra("__bind_key_invoke_process__"), Long.valueOf(intent.getLongExtra("__bind_key_invoke_id__", 0L)), Boolean.valueOf(this.f131801a));
        if (this.f131801a) {
            com.tencent.luggage.wxa.ta.c.c("IPC.BaseIPCService", "need to kill self, return null Binder object.", new Object[0]);
            return null;
        }
        q.a().a(n.c(), this);
        this.f131802b = true;
        return this.f131803c;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        com.tencent.luggage.wxa.ta.c.c("IPC.BaseIPCService", "onUnbind(%s)", intent);
        boolean onUnbind = super.onUnbind(intent);
        this.f131802b = false;
        return onUnbind;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ka.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class BinderC6368a extends a.AbstractBinderC6463a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ka.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6369a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f131805a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Parcelable f131806b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f131807c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ f f131808d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ int f131809e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ma.b f131810f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Bundle f131811g;

            public RunnableC6369a(String str, Parcelable parcelable, String str2, f fVar, int i3, com.tencent.luggage.wxa.ma.b bVar, Bundle bundle) {
                this.f131805a = str;
                this.f131806b = parcelable;
                this.f131807c = str2;
                this.f131808d = fVar;
                this.f131809e = i3;
                this.f131810f = bVar;
                this.f131811g = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        com.tencent.luggage.wxa.ta.c.c("IPC.BaseIPCService", "invokeAsync in target process, after ThreadPool.post, clazz=%s, data=%s serialTag=%s finalTask=%s", this.f131805a, this.f131806b, this.f131807c, this.f131808d);
                        ThreadLocal threadLocal = a.f131800d;
                        threadLocal.set(Integer.valueOf(this.f131809e));
                        com.tencent.luggage.wxa.ta.c.c("IPC.BaseIPCService", "before finalTask.invoke", new Object[0]);
                        this.f131808d.a(this.f131806b, new b(this.f131810f));
                        threadLocal.remove();
                    } catch (NullPointerException e16) {
                        com.tencent.luggage.wxa.ta.c.b("IPC.BaseIPCService", "invoke task, clazz=%s, npe=%s", this.f131805a, e16);
                        a.f131800d.remove();
                    }
                } catch (Throwable th5) {
                    a.f131800d.remove();
                    throw th5;
                }
            }

            public String toString() {
                return super.toString() + " class:" + this.f131805a + ",data:" + this.f131811g;
            }
        }

        public BinderC6368a() {
        }

        @Override // com.tencent.luggage.wxa.ma.a
        public void a(Bundle bundle, String str, com.tencent.luggage.wxa.ma.b bVar) {
            if (str != null) {
                try {
                    if (str.length() != 0) {
                        if (bundle == null) {
                            com.tencent.luggage.wxa.ta.c.b("IPC.BaseIPCService", "invokeAsync failed, data is null.", new Object[0]);
                            return;
                        }
                        bundle.setClassLoader(a.class.getClassLoader());
                        Parcelable parcelable = bundle.getParcelable("__remote_task_data");
                        String string = bundle.getString("__command_tag");
                        int f16 = f();
                        f fVar = (f) w.a(str, f.class);
                        if (fVar == null) {
                            com.tencent.luggage.wxa.ta.c.b("IPC.BaseIPCService", "invokeAsync failed, can not newInstance by class %s.", str);
                            return;
                        }
                        com.tencent.luggage.wxa.ta.c.c("IPC.BaseIPCService", "invokeAsync in target process, before ThreadPool.post, clazz=%s data=%s serialTag=%s", str, parcelable, string);
                        RunnableC6369a runnableC6369a = new RunnableC6369a(str, parcelable, string, fVar, f16, bVar, bundle);
                        s sVar = s.f131876c;
                        n.d();
                        s.a(runnableC6369a, "Invoke:" + fVar.getClass().getName() + ",data:" + bundle);
                        return;
                    }
                } catch (Throwable th5) {
                    com.tencent.luggage.wxa.ta.c.b("IPC.BaseIPCService", "invokeAsync class:%s, get exception %s", str, Log.getStackTraceString(th5));
                    if (!(th5 instanceof RemoteException)) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("__remote_exception", th5.getMessage());
                        bVar.onCallback(bundle2);
                        return;
                    }
                    throw th5;
                }
            }
            com.tencent.luggage.wxa.ta.c.b("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.", new Object[0]);
        }

        public final int f() {
            int callingUidOrThrow;
            if (Build.VERSION.SDK_INT >= 29) {
                callingUidOrThrow = Binder.getCallingUidOrThrow();
                return callingUidOrThrow;
            }
            return Binder.getCallingUid();
        }

        @Override // com.tencent.luggage.wxa.ma.a
        public Bundle a(Bundle bundle, String str) {
            if (str == null || str.length() == 0) {
                com.tencent.luggage.wxa.ta.c.b("IPC.BaseIPCService", "invokeSync failed, class is null or nil.", new Object[0]);
                return null;
            }
            if (bundle == null) {
                com.tencent.luggage.wxa.ta.c.b("IPC.BaseIPCService", "invokeSync failed, data is null.", new Object[0]);
                return null;
            }
            r rVar = (r) w.a(str, r.class);
            if (rVar == null) {
                com.tencent.luggage.wxa.ta.c.b("IPC.BaseIPCService", "invokeSync failed, can not newInstance by class %s.", str);
                return null;
            }
            int f16 = f();
            bundle.setClassLoader(a.class.getClassLoader());
            Parcelable parcelable = bundle.getParcelable("__remote_task_data");
            Bundle bundle2 = new Bundle();
            ThreadLocal threadLocal = a.f131800d;
            threadLocal.set(Integer.valueOf(f16));
            bundle2.putParcelable("__remote_task_result_data", (Parcelable) rVar.invoke(parcelable));
            threadLocal.remove();
            return bundle2;
        }
    }
}
