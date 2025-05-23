package com.tencent.freesia;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class OSType {
    private static final /* synthetic */ OSType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final OSType AND;
    public static final OSType DEFAULT;
    public static final OSType IOS;
    public static final OSType LINUX;
    public static final OSType MAC;
    public static final OSType WINDOWS;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12240);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        OSType oSType = new OSType("DEFAULT", 0);
        DEFAULT = oSType;
        OSType oSType2 = new OSType("IOS", 1);
        IOS = oSType2;
        OSType oSType3 = new OSType("AND", 2);
        AND = oSType3;
        OSType oSType4 = new OSType("WINDOWS", 3);
        WINDOWS = oSType4;
        OSType oSType5 = new OSType(Global.TRACKING_MAC, 4);
        MAC = oSType5;
        OSType oSType6 = new OSType("LINUX", 5);
        LINUX = oSType6;
        $VALUES = new OSType[]{oSType, oSType2, oSType3, oSType4, oSType5, oSType6};
    }

    OSType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static OSType valueOf(String str) {
        return (OSType) Enum.valueOf(OSType.class, str);
    }

    public static OSType[] values() {
        return (OSType[]) $VALUES.clone();
    }
}
