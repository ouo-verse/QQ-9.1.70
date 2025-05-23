package com.tencent.tuxmetersdk.impl.ruleengine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes27.dex */
public final class CalcRuleFunc {
    private static final /* synthetic */ CalcRuleFunc[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final CalcRuleFunc COUNT;
    public static final CalcRuleFunc CURRENT_TIME_DIFF;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11264);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        CalcRuleFunc calcRuleFunc = new CalcRuleFunc("COUNT", 0);
        COUNT = calcRuleFunc;
        CalcRuleFunc calcRuleFunc2 = new CalcRuleFunc("CURRENT_TIME_DIFF", 1);
        CURRENT_TIME_DIFF = calcRuleFunc2;
        $VALUES = new CalcRuleFunc[]{calcRuleFunc, calcRuleFunc2};
    }

    CalcRuleFunc(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static CalcRuleFunc valueOf(String str) {
        return (CalcRuleFunc) Enum.valueOf(CalcRuleFunc.class, str);
    }

    public static CalcRuleFunc[] values() {
        return (CalcRuleFunc[]) $VALUES.clone();
    }
}
