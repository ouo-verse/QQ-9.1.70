package com.tencent.msdk.dns.core.rest.share;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.core.i;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class g implements i.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public final String f336366b;

    /* renamed from: c, reason: collision with root package name */
    public final String f336367c;

    /* renamed from: d, reason: collision with root package name */
    public final String f336368d;

    public g(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                this.f336366b = str;
                this.f336367c = str2;
                this.f336368d = str3;
                return;
            }
            throw new IllegalArgumentException("bizKey".concat(" can not be empty"));
        }
        throw new IllegalArgumentException("bizId".concat(" can not be empty"));
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "LookupExtra{bizId='" + this.f336366b + "', bizKey='" + this.f336367c + "', token='" + this.f336368d + "'}";
    }
}
