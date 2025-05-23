package com.tencent.tuxmetersdk.export.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes27.dex */
public final class TuxSurveyType {
    private static final /* synthetic */ TuxSurveyType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TuxSurveyType ALL_SELF_RENDERING;
    public static final TuxSurveyType SELF_RENDING_WITH_TUXH5;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7665);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TuxSurveyType tuxSurveyType = new TuxSurveyType("ALL_SELF_RENDERING", 0);
        ALL_SELF_RENDERING = tuxSurveyType;
        TuxSurveyType tuxSurveyType2 = new TuxSurveyType("SELF_RENDING_WITH_TUXH5", 1);
        SELF_RENDING_WITH_TUXH5 = tuxSurveyType2;
        $VALUES = new TuxSurveyType[]{tuxSurveyType, tuxSurveyType2};
    }

    TuxSurveyType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TuxSurveyType valueOf(String str) {
        return (TuxSurveyType) Enum.valueOf(TuxSurveyType.class, str);
    }

    public static TuxSurveyType[] values() {
        return (TuxSurveyType[]) $VALUES.clone();
    }
}
