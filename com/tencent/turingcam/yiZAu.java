package com.tencent.turingcam;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class yiZAu implements QmgHg {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public wmqhz f382459a;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class ShGzN extends BaseThread {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f382460a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f382461b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f382462c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f382463d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f382464e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Object f382465f;

        public ShGzN(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicReference atomicReference3, Context context, AtomicReference atomicReference4, Object obj) {
            this.f382460a = atomicReference;
            this.f382461b = atomicReference2;
            this.f382462c = atomicReference3;
            this.f382463d = context;
            this.f382464e = atomicReference4;
            this.f382465f = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, yiZAu.this, atomicReference, atomicReference2, atomicReference3, context, atomicReference4, obj);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            String str = "";
            try {
                str = yiZAu.this.a((IBinder) this.f382460a.get());
            } catch (Throwable unused) {
                this.f382461b.set(-102);
            }
            this.f382462c.set(str);
            try {
                this.f382463d.unbindService((ServiceConnection) this.f382464e.get());
            } catch (Throwable unused2) {
                this.f382461b.set(-103);
            }
            synchronized (this.f382465f) {
                try {
                    this.f382465f.notifyAll();
                } catch (Throwable unused3) {
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f382467a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f382468b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f382469c;

        public spXPg(AtomicReference atomicReference, AtomicReference atomicReference2, Object obj) {
            this.f382467a = atomicReference;
            this.f382468b = atomicReference2;
            this.f382469c = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, atomicReference, atomicReference2, obj);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            this.f382467a.set(iBinder);
            this.f382468b.set(this);
            synchronized (this.f382469c) {
                try {
                    this.f382469c.notifyAll();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            }
        }
    }

    public yiZAu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.turingcam.QmgHg
    public wmqhz a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (wmqhz) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        wmqhz wmqhzVar = this.f382459a;
        if (wmqhzVar == null || wmqhzVar.f382424b != 0) {
            this.f382459a = c(context);
        }
        return this.f382459a;
    }

    public abstract String a(IBinder iBinder);

    @Override // com.tencent.turingcam.QmgHg
    public void b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            this.f382459a = c(context);
        }
    }

    public final wmqhz c(Context context) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (wmqhz) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
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
        return new wmqhz(atomicReference.get(), i3);
    }

    public final int a(Context context, AtomicReference<IBinder> atomicReference, AtomicReference<ServiceConnection> atomicReference2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, context, atomicReference, atomicReference2)).intValue();
        }
        Object obj = new Object();
        Intent intent = new Intent(LwgsO.a(LwgsO.f381911k));
        intent.setComponent(new ComponentName(LwgsO.a(LwgsO.f381899g), LwgsO.a(LwgsO.f381902h)));
        if (!context.bindService(intent, new spXPg(atomicReference, atomicReference2, obj), 1)) {
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
        new ShGzN(atomicReference, atomicReference4, atomicReference3, context, atomicReference2, obj).start();
        synchronized (obj) {
            try {
                obj.wait(1000L);
            } catch (Throwable unused) {
            }
        }
        return ((Integer) atomicReference4.get()).intValue();
    }
}
