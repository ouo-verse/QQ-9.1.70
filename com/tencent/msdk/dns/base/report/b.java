package com.tencent.msdk.dns.base.report;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.base.report.a;
import com.tencent.msdk.dns.base.report.a.InterfaceC9209a;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class b<InitParameters extends a.InterfaceC9209a> implements a<InitParameters> {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.msdk.dns.base.report.a
    public boolean c(int i3, String str, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, map)).booleanValue();
        }
        if (TextUtils.isEmpty(str) || map == null) {
            return false;
        }
        return d(i3, str, map);
    }

    abstract boolean d(int i3, String str, Map<String, String> map);
}
