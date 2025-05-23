package com.tencent.tfd.sdk.wxa;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class Hydra implements Cstrictfp {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Eridanus f375640a;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Hydra$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cdo implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f375641a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f375642b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f375643c;

        public Cdo(AtomicReference atomicReference, AtomicReference atomicReference2, Object obj) {
            this.f375641a = atomicReference;
            this.f375642b = atomicReference2;
            this.f375643c = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, atomicReference, atomicReference2, obj);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            this.f375641a.set(iBinder);
            this.f375642b.set(this);
            synchronized (this.f375643c) {
                try {
                    this.f375643c.notifyAll();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Hydra$if, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cif extends BaseThread {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f375644a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f375645b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f375646c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f375647d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f375648e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Object f375649f;

        public Cif(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicReference atomicReference3, Context context, AtomicReference atomicReference4, Object obj) {
            this.f375644a = atomicReference;
            this.f375645b = atomicReference2;
            this.f375646c = atomicReference3;
            this.f375647d = context;
            this.f375648e = atomicReference4;
            this.f375649f = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Hydra.this, atomicReference, atomicReference2, atomicReference3, context, atomicReference4, obj);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            String str = "";
            try {
                str = Hydra.this.a((IBinder) this.f375644a.get());
            } catch (Throwable unused) {
                this.f375645b.set(-102);
            }
            this.f375646c.set(str);
            try {
                this.f375647d.unbindService((ServiceConnection) this.f375648e.get());
            } catch (Throwable unused2) {
                this.f375645b.set(-103);
            }
            synchronized (this.f375649f) {
                try {
                    this.f375649f.notifyAll();
                } catch (Throwable unused3) {
                }
            }
        }
    }

    public Hydra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract String a(IBinder iBinder) throws Exception;

    @Override // com.tencent.tfd.sdk.wxa.Cstrictfp
    public final void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f375640a = c(context);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.tfd.sdk.wxa.Cstrictfp
    public final Eridanus b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Eridanus) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Eridanus eridanus = this.f375640a;
        if (eridanus == null || eridanus.f375606b != 0) {
            this.f375640a = c(context);
        }
        return this.f375640a;
    }

    public final Eridanus c(Context context) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Eridanus) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        AtomicReference<String> atomicReference = new AtomicReference<>();
        atomicReference.set("");
        try {
            AtomicReference<IBinder> atomicReference2 = new AtomicReference<>();
            AtomicReference<ServiceConnection> atomicReference3 = new AtomicReference<>();
            i3 = a(context, atomicReference2, atomicReference3);
            if (i3 == 0) {
                try {
                    i3 = a(context, atomicReference2, atomicReference3, atomicReference);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            i3 = -1;
        }
        return new Eridanus(atomicReference.get(), i3);
    }

    public final int a(Context context, AtomicReference<IBinder> atomicReference, AtomicReference<ServiceConnection> atomicReference2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, context, atomicReference, atomicReference2)).intValue();
        }
        Object obj = new Object();
        Intent intent = new Intent(Cswitch.a(Cswitch.f375803k));
        intent.setComponent(new ComponentName(Cswitch.a(Cswitch.f375795g), Cswitch.a(Cswitch.f375797h)));
        if (!context.bindService(intent, new Cdo(atomicReference, atomicReference2, obj), 1)) {
            return -100;
        }
        if (atomicReference.get() == null) {
            synchronized (obj) {
                try {
                    obj.wait(1000L);
                } catch (Throwable unused) {
                }
            }
        }
        return atomicReference.get() == null ? -105 : 0;
    }

    public final int a(Context context, AtomicReference<IBinder> atomicReference, AtomicReference<ServiceConnection> atomicReference2, AtomicReference<String> atomicReference3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, context, atomicReference, atomicReference2, atomicReference3)).intValue();
        }
        Object obj = new Object();
        AtomicReference atomicReference4 = new AtomicReference(0);
        new Cif(atomicReference, atomicReference4, atomicReference3, context, atomicReference2, obj).start();
        synchronized (obj) {
            try {
                obj.wait(1000L);
            } catch (Throwable unused) {
            }
        }
        return ((Integer) atomicReference4.get()).intValue();
    }
}
