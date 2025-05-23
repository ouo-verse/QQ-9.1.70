package com.tencent.qqprotect.qsec.utils;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final long f363536a;

    /* renamed from: b, reason: collision with root package name */
    private final long f363537b;

    /* renamed from: c, reason: collision with root package name */
    private long f363538c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f363539d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f363540e;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            synchronized (b.this) {
                if (b.this.f363539d) {
                    return true;
                }
                long elapsedRealtime = b.this.f363538c - SystemClock.elapsedRealtime();
                long j16 = 0;
                if (elapsedRealtime <= 0) {
                    b.this.e();
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    b.this.f(elapsedRealtime);
                    long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                    if (elapsedRealtime < b.this.f363537b) {
                        j3 = elapsedRealtime - elapsedRealtime3;
                        if (j3 < 0) {
                            b.this.f363540e.sendMessageDelayed(b.this.f363540e.obtainMessage(1), j16);
                        }
                    } else {
                        j3 = b.this.f363537b - elapsedRealtime3;
                        while (j3 < 0) {
                            j3 += b.this.f363537b;
                        }
                    }
                    j16 = j3;
                    b.this.f363540e.sendMessageDelayed(b.this.f363540e.obtainMessage(1), j16);
                }
                return false;
            }
        }
    }

    public b(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.f363539d = false;
        this.f363536a = j3;
        this.f363537b = j16;
        this.f363540e = new Handler(ThreadManagerV2.getQQCommonThreadLooper(), new a());
    }

    public abstract void e();

    public abstract void f(long j3);

    public final synchronized b g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        this.f363539d = false;
        if (this.f363536a <= 0) {
            e();
            return this;
        }
        this.f363538c = SystemClock.elapsedRealtime() + this.f363536a;
        Handler handler = this.f363540e;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
