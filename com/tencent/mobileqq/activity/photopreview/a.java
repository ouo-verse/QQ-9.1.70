package com.tencent.mobileqq.activity.photopreview;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends Handler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f184482a;

    /* renamed from: b, reason: collision with root package name */
    private long f184483b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f184484c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f184485d;

    /* renamed from: e, reason: collision with root package name */
    public CopyOnWriteArrayList<AbstractC7196a> f184486e;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.photopreview.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC7196a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f184487a;

        /* renamed from: b, reason: collision with root package name */
        private a f184488b;

        /* renamed from: c, reason: collision with root package name */
        private long f184489c;

        public AbstractC7196a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
            } else {
                d(j3);
            }
        }

        public abstract void b();

        public abstract void c(long j3);

        public void d(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
                return;
            }
            a aVar = this.f184488b;
            if (aVar != null) {
                aVar.h(j3);
            }
            this.f184489c = j3;
            this.f184487a = SystemClock.elapsedRealtime() + (j3 * 1000);
        }

        public final void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            long elapsedRealtime = this.f184487a - SystemClock.elapsedRealtime();
            if (elapsedRealtime > 1000) {
                c(elapsedRealtime);
            } else {
                b();
            }
        }
    }

    public a(Looper looper) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            return;
        }
        this.f184482a = 1000L;
        this.f184484c = false;
        this.f184485d = false;
        this.f184486e = new CopyOnWriteArrayList<>();
    }

    public void a(AbstractC7196a abstractC7196a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) abstractC7196a);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (abstractC7196a.f184487a > elapsedRealtime) {
            this.f184486e.add(abstractC7196a);
            h(abstractC7196a.f184487a - elapsedRealtime);
        } else {
            abstractC7196a.b();
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f184486e.size() < 2) {
            j();
        }
        Iterator<AbstractC7196a> it = this.f184486e.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f184486e.isEmpty()) {
            j();
        }
        Iterator<AbstractC7196a> it = this.f184486e.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f184485d = false;
        c();
        b();
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            removeMessages(1);
            this.f184484c = true;
        }
    }

    public void f(AbstractC7196a abstractC7196a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) abstractC7196a);
        } else {
            this.f184486e.remove(abstractC7196a);
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.f184484c = false;
        if (this.f184483b >= SystemClock.elapsedRealtime()) {
            sendMessage(obtainMessage(1));
        }
    }

    public void h(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            this.f184483b = Math.max(SystemClock.elapsedRealtime() + (j3 * 1000), this.f184483b);
            i();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
            return;
        }
        synchronized (this) {
            long elapsedRealtime = this.f184483b - SystemClock.elapsedRealtime();
            if (elapsedRealtime <= 0) {
                d();
            } else if (elapsedRealtime < this.f184482a) {
                sendMessageDelayed(obtainMessage(1), elapsedRealtime);
            } else {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                c();
                long elapsedRealtime3 = (elapsedRealtime2 + this.f184482a) - SystemClock.elapsedRealtime();
                while (elapsedRealtime3 < 0) {
                    elapsedRealtime3 += this.f184482a;
                }
                sendMessageDelayed(obtainMessage(1), elapsedRealtime3);
            }
        }
    }

    public synchronized void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.f184485d) {
            return;
        }
        if (this.f184483b <= SystemClock.elapsedRealtime()) {
            d();
        } else {
            this.f184485d = true;
            sendMessage(obtainMessage(1));
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.f184485d = false;
        removeMessages(1);
        this.f184486e.clear();
    }

    @Override // android.os.Handler
    public boolean sendMessageAtTime(Message message, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, message, Long.valueOf(j3))).booleanValue();
        }
        if (this.f184484c) {
            return false;
        }
        return super.sendMessageAtTime(message, j3);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f184482a = 1000L;
        this.f184484c = false;
        this.f184485d = false;
        this.f184486e = new CopyOnWriteArrayList<>();
    }
}
