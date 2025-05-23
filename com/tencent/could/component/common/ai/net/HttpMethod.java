package com.tencent.could.component.common.ai.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class HttpMethod {
    static IPatchRedirector $redirector_;
    public static final HttpMethod GET;
    public static final HttpMethod POST;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HttpMethod[] f99979a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14104);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HttpMethod httpMethod = new HttpMethod("POST", 0);
        POST = httpMethod;
        HttpMethod httpMethod2 = new HttpMethod("GET", 1);
        GET = httpMethod2;
        f99979a = new HttpMethod[]{httpMethod, httpMethod2};
    }

    public HttpMethod(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static HttpMethod valueOf(String str) {
        return (HttpMethod) Enum.valueOf(HttpMethod.class, str);
    }

    public static HttpMethod[] values() {
        return (HttpMethod[]) f99979a.clone();
    }
}
