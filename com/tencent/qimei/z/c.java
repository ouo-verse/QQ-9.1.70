package com.tencent.qimei.z;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends a<Integer> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f343437a;

    /* renamed from: b, reason: collision with root package name */
    public final int f343438b;

    public c(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        } else {
            this.f343437a = str;
            this.f343438b = i3;
        }
    }

    public Integer a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        String a16 = a(str, this.f343437a);
        if (a16 != null && !a16.isEmpty()) {
            try {
                return Integer.valueOf(Integer.parseInt(a16));
            } catch (Exception e16) {
                e16.printStackTrace();
                return Integer.valueOf(this.f343438b);
            }
        }
        return Integer.valueOf(this.f343438b);
    }
}
