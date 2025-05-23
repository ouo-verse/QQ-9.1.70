package com.tencent.gathererga.core.internal.provider;

import com.tencent.gathererga.core.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f108239g;

    /* renamed from: a, reason: collision with root package name */
    private long f108240a;

    /* renamed from: b, reason: collision with root package name */
    private Object f108241b;

    /* renamed from: c, reason: collision with root package name */
    private int f108242c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f108243d;

    /* renamed from: e, reason: collision with root package name */
    private Throwable f108244e;

    /* renamed from: f, reason: collision with root package name */
    private long f108245f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56039);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f108239g = new String[0];
        }
    }

    public c(long j3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), obj);
            return;
        }
        this.f108240a = j3;
        this.f108241b = obj;
        this.f108242c = 1;
    }

    public static f f(long j3) {
        return new c(j3, null, 0, f108239g, null);
    }

    public static f g(long j3, Throwable th5) {
        return new c(j3, null, 0, f108239g, th5);
    }

    public static f h(Object obj, int i3) {
        return new c(0L, obj, i3, f108239g, null);
    }

    public static f i(long j3, String[] strArr) {
        return new c(j3, null, -1, strArr, null);
    }

    @Override // com.tencent.gathererga.core.f
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f108242c;
    }

    @Override // com.tencent.gathererga.core.f
    public Object b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f108241b;
    }

    @Override // com.tencent.gathererga.core.f
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f108240a == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gathererga.core.f
    public void d(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        } else {
            this.f108245f = j3;
        }
    }

    @Override // com.tencent.gathererga.core.f
    public long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.f108245f;
    }

    @Override // com.tencent.gathererga.core.f
    public long getErrorCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.f108240a;
    }

    public c(long j3, Object obj, int i3, String[] strArr, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), obj, Integer.valueOf(i3), strArr, th5);
            return;
        }
        this.f108240a = j3;
        this.f108241b = obj;
        this.f108242c = i3;
        this.f108244e = th5;
        this.f108243d = strArr;
    }
}
