package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class InstrumentType {
    private static final /* synthetic */ InstrumentType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final InstrumentType COUNTER;
    public static final InstrumentType HISTOGRAM;
    public static final InstrumentType OBSERVABLE_COUNTER;
    public static final InstrumentType OBSERVABLE_GAUGE;
    public static final InstrumentType OBSERVABLE_UP_DOWN_COUNTER;
    public static final InstrumentType UP_DOWN_COUNTER;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14121);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        InstrumentType instrumentType = new InstrumentType("COUNTER", 0);
        COUNTER = instrumentType;
        InstrumentType instrumentType2 = new InstrumentType("UP_DOWN_COUNTER", 1);
        UP_DOWN_COUNTER = instrumentType2;
        InstrumentType instrumentType3 = new InstrumentType("HISTOGRAM", 2);
        HISTOGRAM = instrumentType3;
        InstrumentType instrumentType4 = new InstrumentType("OBSERVABLE_COUNTER", 3);
        OBSERVABLE_COUNTER = instrumentType4;
        InstrumentType instrumentType5 = new InstrumentType("OBSERVABLE_UP_DOWN_COUNTER", 4);
        OBSERVABLE_UP_DOWN_COUNTER = instrumentType5;
        InstrumentType instrumentType6 = new InstrumentType("OBSERVABLE_GAUGE", 5);
        OBSERVABLE_GAUGE = instrumentType6;
        $VALUES = new InstrumentType[]{instrumentType, instrumentType2, instrumentType3, instrumentType4, instrumentType5, instrumentType6};
    }

    InstrumentType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static InstrumentType valueOf(String str) {
        return (InstrumentType) Enum.valueOf(InstrumentType.class, str);
    }

    public static InstrumentType[] values() {
        return (InstrumentType[]) $VALUES.clone();
    }
}
