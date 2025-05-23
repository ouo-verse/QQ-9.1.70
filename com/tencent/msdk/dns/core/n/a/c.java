package com.tencent.msdk.dns.core.n.a;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes21.dex */
final class c extends com.tencent.msdk.dns.core.rest.share.c {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.msdk.dns.core.rest.share.c
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 80;
    }

    @Override // com.tencent.msdk.dns.core.rest.share.c
    public String b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return String.format(Locale.US, "http://%s/d?%s&alg=aes", str, str2);
    }
}
