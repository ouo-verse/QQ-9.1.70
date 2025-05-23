package com.tencent.mobileqq.uftransfer.task.taskinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.api.k;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f305367a;

    /* renamed from: b, reason: collision with root package name */
    private int f305368b;

    /* renamed from: c, reason: collision with root package name */
    private int f305369c;

    /* renamed from: d, reason: collision with root package name */
    private String f305370d;

    /* renamed from: e, reason: collision with root package name */
    private int f305371e;

    /* renamed from: f, reason: collision with root package name */
    private long f305372f;

    /* renamed from: g, reason: collision with root package name */
    private String f305373g;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.mobileqq.uftransfer.api.h f305374h;

    /* renamed from: i, reason: collision with root package name */
    private final k f305375i;

    public a(long j3, int i3, k kVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), kVar, Boolean.valueOf(z16));
            return;
        }
        this.f305374h = new com.tencent.mobileqq.uftransfer.api.h();
        kVar = kVar == null ? new k(z16) : kVar;
        this.f305367a = j3;
        this.f305368b = i3;
        this.f305369c = 0;
        this.f305375i = kVar;
    }

    public byte[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (byte[]) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (!TextUtils.isEmpty(this.f305373g)) {
            return this.f305373g.getBytes();
        }
        return null;
    }

    public k b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (k) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.f305375i;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f305373g;
    }

    public com.tencent.mobileqq.uftransfer.api.h d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (com.tencent.mobileqq.uftransfer.api.h) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.f305374h;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f305370d;
    }

    public long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.f305372f;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f305371e;
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "";
    }

    public long i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.f305367a;
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            this.f305373g = str;
        }
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.f305370d = str;
        }
    }

    public void l(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            this.f305372f = j3;
        }
    }

    public void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f305369c = i3;
        }
    }
}
