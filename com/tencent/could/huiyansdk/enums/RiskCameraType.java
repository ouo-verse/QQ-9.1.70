package com.tencent.could.huiyansdk.enums;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class RiskCameraType {
    private static final /* synthetic */ RiskCameraType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final RiskCameraType BASE;
    public static final RiskCameraType EXPOSURE;
    public static final RiskCameraType WHITE_BALANCE;
    public static final RiskCameraType ZOOM;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18939);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        RiskCameraType riskCameraType = new RiskCameraType("BASE", 0);
        BASE = riskCameraType;
        RiskCameraType riskCameraType2 = new RiskCameraType("EXPOSURE", 1);
        EXPOSURE = riskCameraType2;
        RiskCameraType riskCameraType3 = new RiskCameraType("ZOOM", 2);
        ZOOM = riskCameraType3;
        RiskCameraType riskCameraType4 = new RiskCameraType("WHITE_BALANCE", 3);
        WHITE_BALANCE = riskCameraType4;
        $VALUES = new RiskCameraType[]{riskCameraType, riskCameraType2, riskCameraType3, riskCameraType4};
    }

    RiskCameraType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static RiskCameraType valueOf(String str) {
        return (RiskCameraType) Enum.valueOf(RiskCameraType.class, str);
    }

    public static RiskCameraType[] values() {
        return (RiskCameraType[]) $VALUES.clone();
    }
}
