package com.tencent.msdk.dns.d;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes21.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static d f336447e;

    /* renamed from: a, reason: collision with root package name */
    private long f336448a;

    /* renamed from: b, reason: collision with root package name */
    private int f336449b;

    /* renamed from: c, reason: collision with root package name */
    private int f336450c;

    /* renamed from: d, reason: collision with root package name */
    private long f336451d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17543);
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
        this.f336448a = 0L;
        this.f336449b = 0;
        this.f336450c = 3;
        this.f336451d = MiniBoxNoticeInfo.MIN_5;
    }

    public static d c() {
        if (f336447e == null) {
            synchronized (com.tencent.msdk.dns.d.class) {
                if (f336447e == null) {
                    f336447e = new d();
                }
            }
        }
        return f336447e;
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.f336448a = j3;
            this.f336449b++;
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f336449b < this.f336450c && System.currentTimeMillis() - this.f336448a >= this.f336451d) {
            return true;
        }
        return false;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f336449b = 0;
        }
    }
}
