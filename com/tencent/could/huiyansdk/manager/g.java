package com.tencent.could.huiyansdk.manager;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final g f100181a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12544);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100181a = new g();
            }
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final Context a(Context context, Locale locale) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) locale);
        }
        if (context == null) {
            k.a.f100197a.a(2, "LanguageManager", "update locale, but context is null.");
            return null;
        }
        k.a.f100197a.a(1, "LanguageManager", "country: " + locale.getCountry() + " language: " + locale.getLanguage());
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }
}
