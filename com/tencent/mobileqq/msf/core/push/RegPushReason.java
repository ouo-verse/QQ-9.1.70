package com.tencent.mobileqq.msf.core.push;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes15.dex */
public final class RegPushReason {
    private static final /* synthetic */ RegPushReason[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final RegPushReason appRegister;
    public static final RegPushReason createDefaultRegInfo;
    public static final RegPushReason fillRegProxy;
    public static final RegPushReason msfBoot;
    public static final RegPushReason msfByNetChange;
    public static final RegPushReason msfHeartTimeTooLong;
    public static final RegPushReason serverPush;
    public static final RegPushReason setOnlineStatus;
    public static final RegPushReason unknown;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28219);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        RegPushReason regPushReason = new RegPushReason("msfBoot", 0);
        msfBoot = regPushReason;
        RegPushReason regPushReason2 = new RegPushReason("appRegister", 1);
        appRegister = regPushReason2;
        RegPushReason regPushReason3 = new RegPushReason("unknown", 2);
        unknown = regPushReason3;
        RegPushReason regPushReason4 = new RegPushReason("msfHeartTimeTooLong", 3);
        msfHeartTimeTooLong = regPushReason4;
        RegPushReason regPushReason5 = new RegPushReason("msfByNetChange", 4);
        msfByNetChange = regPushReason5;
        RegPushReason regPushReason6 = new RegPushReason("serverPush", 5);
        serverPush = regPushReason6;
        RegPushReason regPushReason7 = new RegPushReason("fillRegProxy", 6);
        fillRegProxy = regPushReason7;
        RegPushReason regPushReason8 = new RegPushReason("createDefaultRegInfo", 7);
        createDefaultRegInfo = regPushReason8;
        RegPushReason regPushReason9 = new RegPushReason("setOnlineStatus", 8);
        setOnlineStatus = regPushReason9;
        $VALUES = new RegPushReason[]{regPushReason, regPushReason2, regPushReason3, regPushReason4, regPushReason5, regPushReason6, regPushReason7, regPushReason8, regPushReason9};
    }

    RegPushReason(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static RegPushReason valueOf(String str) {
        return (RegPushReason) Enum.valueOf(RegPushReason.class, str);
    }

    public static RegPushReason[] values() {
        return (RegPushReason[]) $VALUES.clone();
    }
}
