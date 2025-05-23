package com.tencent.turingcam;

import android.os.Build;
import android.os.LocaleList;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class lkZFD {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final lkZFD f382305b;

    /* renamed from: a, reason: collision with root package name */
    public final XjdKN f382306a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18133);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382305b = a(new Locale[0]);
        }
    }

    public lkZFD(XjdKN xjdKN) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) xjdKN);
        } else {
            this.f382306a = xjdKN;
        }
    }

    public static lkZFD a(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new lkZFD(new jWEgB(new LocaleList(localeArr)));
        }
        return new lkZFD(new FcJPA(localeArr));
    }

    public static lkZFD a(String str) {
        if (str != null && !str.isEmpty()) {
            String[] split = str.split(",", -1);
            int length = split.length;
            Locale[] localeArr = new Locale[length];
            for (int i3 = 0; i3 < length; i3++) {
                localeArr[i3] = Locale.forLanguageTag(split[i3]);
            }
            return a(localeArr);
        }
        return f382305b;
    }
}
