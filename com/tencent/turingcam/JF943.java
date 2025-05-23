package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class JF943 extends UMDtK implements Cloneable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static SkEpO f381870d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ boolean f381871e;

    /* renamed from: a, reason: collision with root package name */
    public int f381872a;

    /* renamed from: b, reason: collision with root package name */
    public SkEpO f381873b;

    /* renamed from: c, reason: collision with root package name */
    public long f381874c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14315);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f381871e = true;
            f381870d = new SkEpO();
        }
    }

    public JF943() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f381872a = 0;
        this.f381873b = null;
        this.f381874c = 0L;
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) xjpd8);
            return;
        }
        xjpd8.a(this.f381872a, 0);
        SkEpO skEpO = this.f381873b;
        if (skEpO != null) {
            xjpd8.a((UMDtK) skEpO, 1);
        }
        xjpd8.a(this.f381874c, 2);
    }

    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f381871e) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        JF943 jf943 = (JF943) obj;
        if (!vzMV2.a(this.f381872a, jf943.f381872a) || !this.f381873b.equals(jf943.f381873b) || !vzMV2.a(this.f381874c, jf943.f381874c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        try {
            throw new Exception("");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) yunKQ);
            return;
        }
        this.f381872a = yunKQ.a(this.f381872a, 0, true);
        this.f381873b = (SkEpO) yunKQ.a((UMDtK) f381870d, 1, false);
        this.f381874c = yunKQ.a(this.f381874c, 2, true);
    }
}
