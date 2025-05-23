package com.tencent.gathererga.core.internal.component;

import com.tencent.gathererga.core.internal.util.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final MediaType f108213a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55930);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f108213a = MediaType.parse("application/json; charset=utf-8");
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.gathererga.core.internal.component.c
    public String a(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, str, str2, str3);
        }
        OkHttpClient okHttpClient = new OkHttpClient();
        d.a("post : " + str + " body " + str3);
        try {
            try {
                return okHttpClient.newCall(new Request.Builder().url(str).post(RequestBody.create(f108213a, str3)).build()).execute().body().string();
            } catch (Throwable th5) {
                d.h(th5);
                return "";
            }
        } catch (Throwable th6) {
            d.h(th6);
            return "";
        }
    }
}
