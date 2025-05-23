package com.tencent.hlyyb.downloader.g.a;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public CountDownLatch f114654a;

    /* renamed from: b, reason: collision with root package name */
    public Context f114655b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f114656c;

    /* renamed from: d, reason: collision with root package name */
    public String f114657d;

    /* renamed from: e, reason: collision with root package name */
    public String f114658e;

    /* compiled from: P */
    /* renamed from: com.tencent.hlyyb.downloader.g.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC5823a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f114659d;

        public RunnableC5823a(a aVar, Context context) {
            this.f114659d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) context);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                j.f(this.f114659d);
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f114656c = false;
        this.f114657d = "";
        this.f114658e = "";
    }

    public abstract void a();

    public void b(boolean z16, String str, String str2) {
        CountDownLatch countDownLatch;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2);
            return;
        }
        this.f114656c = z16;
        this.f114657d = str;
        this.f114658e = str2;
        if (this.f114656c && (countDownLatch = this.f114654a) != null && countDownLatch.getCount() == 1) {
            this.f114654a.countDown();
        }
    }

    public final boolean c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
        }
        if (context == null) {
            k.m(null, d(), 1, null);
            return false;
        }
        this.f114655b = context;
        this.f114654a = new CountDownLatch(1);
        a();
        try {
            int s16 = k.s(context);
            if (s16 >= 7742130 && s16 <= 8302130) {
                h.e().postDelayed(new RunnableC5823a(this, context), 2000L);
            }
        } catch (Throwable unused) {
        }
        try {
            if (!this.f114656c && this.f114654a.getCount() == 1) {
                this.f114654a.await(5000L, TimeUnit.MILLISECONDS);
            }
        } catch (Throwable unused2) {
        }
        if (this.f114656c) {
            k.g(context, d(), 0, j.e(this.f114657d, this.f114658e));
        } else {
            k.m(context, d(), 19, j.e(this.f114657d, this.f114658e));
        }
        return this.f114656c;
    }

    public abstract String d();
}
