package com.tencent.mobileqq.qqgift.webview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements t43.a {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // t43.a
    public List<String> a(String str) {
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (!str.contains(QQLiveCookieConstants.QQ_LIVE_DOMAIN) || (b16 = a.a().b()) == null) {
            return null;
        }
        String b17 = com.tencent.mobileqq.webview.swift.cookie.b.b("p_skey", b16, QQLiveCookieConstants.QQ_LIVE_DOMAIN, false);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(b17);
        return arrayList;
    }
}
