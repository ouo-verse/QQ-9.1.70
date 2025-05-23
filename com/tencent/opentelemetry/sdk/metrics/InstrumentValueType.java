package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class InstrumentValueType {
    private static final /* synthetic */ InstrumentValueType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final InstrumentValueType DOUBLE;
    public static final InstrumentValueType LONG;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14082);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        InstrumentValueType instrumentValueType = new InstrumentValueType("LONG", 0);
        LONG = instrumentValueType;
        InstrumentValueType instrumentValueType2 = new InstrumentValueType("DOUBLE", 1);
        DOUBLE = instrumentValueType2;
        $VALUES = new InstrumentValueType[]{instrumentValueType, instrumentValueType2};
    }

    InstrumentValueType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static InstrumentValueType valueOf(String str) {
        return (InstrumentValueType) Enum.valueOf(InstrumentValueType.class, str);
    }

    public static InstrumentValueType[] values() {
        return (InstrumentValueType[]) $VALUES.clone();
    }
}
