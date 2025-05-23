package com.tencent.turingfd.sdk.xq;

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
public abstract class Betelnut implements Dorado {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Avocado f382591a;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Betelnut$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f382592a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f382593b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f382594c;

        public Cdo(Betelnut betelnut, AtomicReference atomicReference, AtomicReference atomicReference2, Object obj) {
            this.f382592a = atomicReference;
            this.f382593b = atomicReference2;
            this.f382594c = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, betelnut, atomicReference, atomicReference2, obj);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            this.f382592a.set(iBinder);
            this.f382593b.set(this);
            synchronized (this.f382594c) {
                try {
                    this.f382594c.notifyAll();
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

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Betelnut$if, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cif extends BaseThread {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f382595a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f382596b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f382597c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f382598d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f382599e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Object f382600f;

        public Cif(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicReference atomicReference3, Context context, AtomicReference atomicReference4, Object obj) {
            this.f382595a = atomicReference;
            this.f382596b = atomicReference2;
            this.f382597c = atomicReference3;
            this.f382598d = context;
            this.f382599e = atomicReference4;
            this.f382600f = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Betelnut.this, atomicReference, atomicReference2, atomicReference3, context, atomicReference4, obj);
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
                str = Betelnut.this.a((IBinder) this.f382595a.get());
            } catch (Throwable unused) {
                this.f382596b.set(-102);
            }
            this.f382597c.set(str);
            try {
                this.f382598d.unbindService((ServiceConnection) this.f382599e.get());
            } catch (Throwable unused2) {
                this.f382596b.set(-103);
            }
            synchronized (this.f382600f) {
                try {
                    this.f382600f.notifyAll();
                } catch (Throwable unused3) {
                }
            }
        }
    }

    public Betelnut() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Dorado
    public Avocado a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Avocado) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Avocado avocado = this.f382591a;
        if (avocado == null || avocado.f382585b != 0) {
            this.f382591a = c(context);
        }
        return this.f382591a;
    }

    public abstract String a(IBinder iBinder) throws Exception;

    @Override // com.tencent.turingfd.sdk.xq.Dorado
    public void b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            this.f382591a = c(context);
        }
    }

    public final Avocado c(Context context) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Avocado) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
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
        return new Avocado(atomicReference.get(), i3);
    }

    public final int a(Context context, AtomicReference<IBinder> atomicReference, AtomicReference<ServiceConnection> atomicReference2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, context, atomicReference, atomicReference2)).intValue();
        }
        Object obj = new Object();
        Intent intent = new Intent(Ccontinue.a(Ccontinue.f383279k));
        intent.setComponent(new ComponentName(Ccontinue.a(Ccontinue.f383267g), Ccontinue.a(Ccontinue.f383270h)));
        if (!context.bindService(intent, new Cdo(this, atomicReference, atomicReference2, obj), 1)) {
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
