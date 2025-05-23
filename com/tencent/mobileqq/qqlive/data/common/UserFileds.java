package com.tencent.mobileqq.qqlive.data.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes17.dex */
public final class UserFileds {
    private static final /* synthetic */ UserFileds[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final UserFileds Fileds_Base;
    public static final UserFileds Fileds_Follow;
    public static final UserFileds Fileds_Medal;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56661);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        UserFileds userFileds = new UserFileds("Fileds_Base", 0);
        Fileds_Base = userFileds;
        UserFileds userFileds2 = new UserFileds("Fileds_Follow", 1);
        Fileds_Follow = userFileds2;
        UserFileds userFileds3 = new UserFileds("Fileds_Medal", 2);
        Fileds_Medal = userFileds3;
        $VALUES = new UserFileds[]{userFileds, userFileds2, userFileds3};
    }

    UserFileds(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static UserFileds valueOf(String str) {
        return (UserFileds) Enum.valueOf(UserFileds.class, str);
    }

    public static UserFileds[] values() {
        return (UserFileds[]) $VALUES.clone();
    }
}
