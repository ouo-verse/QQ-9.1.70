package com.tencent.turingcam;

import android.os.LocaleList;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class jWEgB implements XjdKN {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final LocaleList f382262a;

    public jWEgB(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        } else {
            this.f382262a = (LocaleList) obj;
        }
    }

    @Override // com.tencent.turingcam.XjdKN
    public Locale a(int i3) {
        Locale locale;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Locale) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        locale = this.f382262a.get(i3);
        return locale;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            hashCode = this.f382262a.hashCode();
            return hashCode;
        }
        return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
    }

    @Override // com.tencent.turingcam.XjdKN
    public int a() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        size = this.f382262a.size();
        return size;
    }
}
