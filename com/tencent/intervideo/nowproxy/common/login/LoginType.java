package com.tencent.intervideo.nowproxy.common.login;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class LoginType implements Serializable {
    private static final /* synthetic */ LoginType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final LoginType CUSTOM;
    public static final LoginType QQConnect;
    public static final LoginType TOURIST;
    public static final LoginType WTLOGIN;
    public static final LoginType WXBind;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10863);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        LoginType loginType = new LoginType("WTLOGIN", 0);
        WTLOGIN = loginType;
        LoginType loginType2 = new LoginType("CUSTOM", 1);
        CUSTOM = loginType2;
        LoginType loginType3 = new LoginType("TOURIST", 2);
        TOURIST = loginType3;
        LoginType loginType4 = new LoginType("QQConnect", 3);
        QQConnect = loginType4;
        LoginType loginType5 = new LoginType("WXBind", 4);
        WXBind = loginType5;
        $VALUES = new LoginType[]{loginType, loginType2, loginType3, loginType4, loginType5};
    }

    LoginType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static LoginType valueOf(String str) {
        return (LoginType) Enum.valueOf(LoginType.class, str);
    }

    public static LoginType[] values() {
        return (LoginType[]) $VALUES.clone();
    }
}
