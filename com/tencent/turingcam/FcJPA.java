package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: classes27.dex */
public final class FcJPA implements XjdKN {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final Locale[] f381822b;

    /* renamed from: a, reason: collision with root package name */
    public final Locale[] f381823a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19736);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f381822b = new Locale[0];
        }
    }

    public FcJPA(Locale... localeArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) localeArr);
            return;
        }
        if (localeArr.length == 0) {
            this.f381823a = f381822b;
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < localeArr.length; i3++) {
            Locale locale = localeArr[i3];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    a(sb5, locale2);
                    if (i3 < localeArr.length - 1) {
                        sb5.append(',');
                    }
                    hashSet.add(locale2);
                }
            } else {
                throw new NullPointerException("list[" + i3 + "] is null");
            }
        }
        this.f381823a = (Locale[]) arrayList.toArray(new Locale[0]);
    }

    @Override // com.tencent.turingcam.XjdKN
    public Locale a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Locale) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (i3 >= 0) {
            Locale[] localeArr = this.f381823a;
            if (i3 < localeArr.length) {
                return localeArr[i3];
            }
        }
        return null;
    }

    @Override // com.tencent.turingcam.XjdKN
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f381823a.length : ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
    }

    public static void a(StringBuilder sb5, Locale locale) {
        sb5.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb5.append('-');
        sb5.append(locale.getCountry());
    }
}
