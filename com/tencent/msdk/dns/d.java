package com.tencent.msdk.dns;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes21.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static d f336391h;

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f336392a;

    /* renamed from: b, reason: collision with root package name */
    private int f336393b;

    /* renamed from: c, reason: collision with root package name */
    private a f336394c;

    /* renamed from: d, reason: collision with root package name */
    List<String> f336395d;

    /* renamed from: e, reason: collision with root package name */
    private int f336396e;

    /* renamed from: f, reason: collision with root package name */
    private long f336397f;

    /* renamed from: g, reason: collision with root package name */
    private long f336398g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16255);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f336392a = new AtomicInteger(0);
        this.f336393b = 3;
        this.f336396e = 0;
        this.f336397f = 0L;
        this.f336398g = 600000L;
    }

    public static d f() {
        if (f336391h == null) {
            synchronized (d.class) {
                if (f336391h == null) {
                    f336391h = new d();
                }
            }
        }
        return f336391h;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.f336396e != 0 && this.f336397f > 0 && SystemClock.elapsedRealtime() - this.f336397f >= this.f336398g) {
            this.f336396e = 0;
            this.f336392a.set(0);
        }
        if (this.f336392a.get() >= this.f336393b) {
            if (this.f336396e == 0) {
                this.f336397f = SystemClock.elapsedRealtime();
            }
            if (this.f336396e >= this.f336395d.size() - 1) {
                this.f336396e = 0;
                this.f336397f = 0L;
            } else {
                this.f336396e++;
            }
            this.f336392a.set(0);
            com.tencent.msdk.dns.base.log.c.c("IP Changed\uff1a" + this.f336395d.get(this.f336396e), new Object[0]);
        }
        String str = this.f336395d.get(this.f336396e);
        if (TextUtils.isEmpty(str)) {
            return this.f336394c.f336175e;
        }
        return str;
    }

    public void b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        this.f336394c = aVar;
        this.f336392a = new AtomicInteger(0);
        if ("Https".equals(aVar.f336181k)) {
            this.f336395d = new ArrayList(Arrays.asList(this.f336394c.f336175e, "119.28.28.99"));
        } else {
            this.f336395d = new ArrayList(Arrays.asList(this.f336394c.f336175e, "119.28.28.98"));
        }
    }

    public void c(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) num);
            return;
        }
        this.f336392a.set(num.intValue());
        com.tencent.msdk.dns.base.log.c.c(Thread.currentThread().getName() + " set mErrorCount: " + num, new Object[0]);
    }

    public boolean d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        if (i3 >= this.f336393b) {
            return true;
        }
        return false;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f336392a.get();
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.msdk.dns.base.log.c.c(Thread.currentThread().getName() + " increment mErrorCount: " + Integer.valueOf(this.f336392a.incrementAndGet()), new Object[0]);
    }
}
