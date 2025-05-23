package com.tencent.freesia;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class FetchType {
    private static final /* synthetic */ FetchType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final FetchType ALL;
    public static final FetchType ALL_V2;
    public static final FetchType CONFIG_SNAPSHOT;
    public static final FetchType FIRST_TIME;
    public static final FetchType HIGH_FREQUENCY;
    public static final FetchType INCREAMENT;
    public static final FetchType INC_REGULAR_CHECK;
    public static final FetchType PUSH;
    public static final FetchType SPECIFIC;
    public static final FetchType UNKNOW;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10629);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        FetchType fetchType = new FetchType("UNKNOW", 0);
        UNKNOW = fetchType;
        FetchType fetchType2 = new FetchType("ALL", 1);
        ALL = fetchType2;
        FetchType fetchType3 = new FetchType("SPECIFIC", 2);
        SPECIFIC = fetchType3;
        FetchType fetchType4 = new FetchType("ALL_V2", 3);
        ALL_V2 = fetchType4;
        FetchType fetchType5 = new FetchType("CONFIG_SNAPSHOT", 4);
        CONFIG_SNAPSHOT = fetchType5;
        FetchType fetchType6 = new FetchType("FIRST_TIME", 5);
        FIRST_TIME = fetchType6;
        FetchType fetchType7 = new FetchType("PUSH", 6);
        PUSH = fetchType7;
        FetchType fetchType8 = new FetchType("HIGH_FREQUENCY", 7);
        HIGH_FREQUENCY = fetchType8;
        FetchType fetchType9 = new FetchType("INCREAMENT", 8);
        INCREAMENT = fetchType9;
        FetchType fetchType10 = new FetchType("INC_REGULAR_CHECK", 9);
        INC_REGULAR_CHECK = fetchType10;
        $VALUES = new FetchType[]{fetchType, fetchType2, fetchType3, fetchType4, fetchType5, fetchType6, fetchType7, fetchType8, fetchType9, fetchType10};
    }

    FetchType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static FetchType valueOf(String str) {
        return (FetchType) Enum.valueOf(FetchType.class, str);
    }

    public static FetchType[] values() {
        return (FetchType[]) $VALUES.clone();
    }
}
