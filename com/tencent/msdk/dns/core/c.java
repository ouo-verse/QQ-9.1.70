package com.tencent.msdk.dns.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final c f336247d;

    /* renamed from: a, reason: collision with root package name */
    public final String[] f336248a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f336249b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f336250c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17808);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            String[] strArr = e.f336253a;
            f336247d = new c(strArr, strArr);
        }
    }

    public c(String[] strArr, String[] strArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) strArr, (Object) strArr2);
            return;
        }
        if (strArr == null) {
            throw new IllegalArgumentException("v4Ips".concat(" can not be null"));
        }
        if (strArr2 != null) {
            this.f336248a = strArr;
            this.f336249b = strArr2;
            this.f336250c = null;
            return;
        }
        throw new IllegalArgumentException("v6Ips".concat(" can not be null"));
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "IpSet{v4Ips=" + Arrays.toString(this.f336248a) + ", v6Ips=" + Arrays.toString(this.f336249b) + ", ips=" + Arrays.toString(this.f336250c) + '}';
    }

    public c(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) strArr);
        } else {
            if (strArr != null) {
                this.f336250c = strArr;
                this.f336248a = null;
                this.f336249b = null;
                return;
            }
            throw new IllegalArgumentException("ips".concat(" can not be null"));
        }
    }
}
