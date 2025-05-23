package com.tencent.freesia;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class NextFetchType {
    private static final /* synthetic */ NextFetchType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final NextFetchType GET_ALL_IMMEDIATELY;
    public static final NextFetchType INCREAMENT_FETCH;
    public static final NextFetchType INCREAMENT_FETCH_IMMEDIATELY;
    public static final NextFetchType INCREAMENT_FETCH_WITH_SNAPSHOT_ID;
    public static final NextFetchType INCREAMENT_FETCH_WITH_SNAPSHOT_ID_IMMEDIATELY;
    public static final NextFetchType NO_CHANGE;
    public static final NextFetchType SNAPSHOT_FETCH_IMMEDIATELY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8338);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NextFetchType nextFetchType = new NextFetchType("NO_CHANGE", 0);
        NO_CHANGE = nextFetchType;
        NextFetchType nextFetchType2 = new NextFetchType("GET_ALL_IMMEDIATELY", 1);
        GET_ALL_IMMEDIATELY = nextFetchType2;
        NextFetchType nextFetchType3 = new NextFetchType("SNAPSHOT_FETCH_IMMEDIATELY", 2);
        SNAPSHOT_FETCH_IMMEDIATELY = nextFetchType3;
        NextFetchType nextFetchType4 = new NextFetchType("INCREAMENT_FETCH_WITH_SNAPSHOT_ID", 3);
        INCREAMENT_FETCH_WITH_SNAPSHOT_ID = nextFetchType4;
        NextFetchType nextFetchType5 = new NextFetchType("INCREAMENT_FETCH", 4);
        INCREAMENT_FETCH = nextFetchType5;
        NextFetchType nextFetchType6 = new NextFetchType("INCREAMENT_FETCH_WITH_SNAPSHOT_ID_IMMEDIATELY", 5);
        INCREAMENT_FETCH_WITH_SNAPSHOT_ID_IMMEDIATELY = nextFetchType6;
        NextFetchType nextFetchType7 = new NextFetchType("INCREAMENT_FETCH_IMMEDIATELY", 6);
        INCREAMENT_FETCH_IMMEDIATELY = nextFetchType7;
        $VALUES = new NextFetchType[]{nextFetchType, nextFetchType2, nextFetchType3, nextFetchType4, nextFetchType5, nextFetchType6, nextFetchType7};
    }

    NextFetchType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static NextFetchType valueOf(String str) {
        return (NextFetchType) Enum.valueOf(NextFetchType.class, str);
    }

    public static NextFetchType[] values() {
        return (NextFetchType[]) $VALUES.clone();
    }
}
