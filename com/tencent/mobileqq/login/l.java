package com.tencent.mobileqq.login;

import com.tencent.mobileqq.login.LoginReportConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f242200a;

    /* renamed from: b, reason: collision with root package name */
    @LoginReportConstants.LoginScene
    public int f242201b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f242202c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f242203d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f242204e;

    public l(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f242202c = false;
        this.f242203d = false;
        this.f242204e = false;
        this.f242200a = i3;
        this.f242201b = i16;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "BaseLoginParams{loginType=" + this.f242200a + ", loginScene=" + this.f242201b + ", isSubAccountLogin=" + this.f242202c + ", isOpenSdkLogin=" + this.f242203d + ", isNestedLogin=" + this.f242204e + '}';
    }
}
