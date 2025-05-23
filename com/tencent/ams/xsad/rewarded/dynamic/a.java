package com.tencent.ams.xsad.rewarded.dynamic;

import com.tencent.ams.dsdk.event.DKEventHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private HippyImageLoader f71787a;

    /* renamed from: b, reason: collision with root package name */
    private long f71788b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f71789c;

    /* renamed from: d, reason: collision with root package name */
    private DKEventHandler f71790d;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f71791a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12666);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f71791a = new a(null);
            }
        }
    }

    /* synthetic */ a(C0703a c0703a) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) c0703a);
    }

    public static a e() {
        return b.f71791a;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.f71787a = null;
        this.f71790d = null;
        this.f71788b = 10000L;
    }

    public DKEventHandler b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DKEventHandler) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f71790d;
    }

    public HippyImageLoader c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HippyImageLoader) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f71787a;
    }

    public long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.f71788b;
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f71789c;
    }

    public void g(DKEventHandler dKEventHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) dKEventHandler);
        } else {
            this.f71790d = dKEventHandler;
        }
    }

    public void h(HippyImageLoader hippyImageLoader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) hippyImageLoader);
        } else {
            this.f71787a = hippyImageLoader;
        }
    }

    public void i(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            this.f71788b = j3;
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f71788b = 10000L;
        this.f71789c = false;
        this.f71790d = null;
    }
}
