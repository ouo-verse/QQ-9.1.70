package com.tencent.halley.common.b.a;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class d implements HostnameVerifier {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f113318a;

    public d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f113318a = str;
        }
    }

    public final boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (TextUtils.isEmpty(this.f113318a) || !(obj instanceof d)) {
            return false;
        }
        String str = ((d) obj).f113318a;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f113318a.equals(str);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) sSLSession)).booleanValue();
        }
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f113318a, sSLSession);
    }
}
