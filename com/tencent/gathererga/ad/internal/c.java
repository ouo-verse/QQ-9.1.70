package com.tencent.gathererga.ad.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c implements ul0.a {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // ul0.a
    public String a(Integer num, String str) {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) num, (Object) str);
        }
        int intValue = num.intValue();
        if (intValue != 115) {
            if (intValue != 307) {
                switch (intValue) {
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case 110:
                    case 111:
                    case 112:
                        if (str == null) {
                            return null;
                        }
                        a16 = b.a(str);
                        break;
                    default:
                        return null;
                }
            } else {
                if (str == null) {
                    return null;
                }
                a16 = e.a(str);
            }
        } else {
            if (str == null) {
                return null;
            }
            a16 = a.a(str);
        }
        return a16;
    }
}
