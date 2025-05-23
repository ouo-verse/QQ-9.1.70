package com.tencent.msdk.dns.core.n.c;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.core.rest.share.c;
import java.util.Locale;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b extends c {
    static IPatchRedirector $redirector_;

    public b() {
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
        return WebSocketImpl.DEFAULT_WSS_PORT;
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
        return String.format(Locale.US, "https://%s/d?%s", str, str2);
    }
}
