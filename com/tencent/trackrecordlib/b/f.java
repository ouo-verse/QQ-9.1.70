package com.tencent.trackrecordlib.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.trackrecordlib.enums.UiActionKey;
import com.tencent.trackrecordlib.enums.UiActionScreenRotation;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b a(int i3, int i16, int i17, int i18) {
        return new b(i3 + "," + i16, i17 + "," + i18);
    }

    public static d a(UiActionKey uiActionKey) {
        return new d(uiActionKey);
    }

    public static e a(int i3, int i16, int i17, int i18, int i19) {
        return new e(i3 + "," + i16, i17 + "," + i18, i19);
    }

    public static g a(UiActionScreenRotation uiActionScreenRotation) {
        return new g(uiActionScreenRotation);
    }

    public static h a(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29) {
        return new h(i3 + "," + i16, i17 + "," + i18, i19 + "," + i26, i27 + "," + i28, i29);
    }

    public static i a(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        return new i(i3 + "," + i16, i17 + "," + i18, i19 + "," + i26, i27 + "," + i28);
    }

    public static c a(int i3) {
        return new c(i3);
    }
}
