package com.tencent.tuxmetersdk.impl.ruleengine.constant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tuxmetersdk.impl.ruleengine.CalcRuleFunc;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OperatorAndCalcRuleFuncMap {
    static IPatchRedirector $redirector_;
    public static final Map<Operator, CalcRuleFunc> MAP;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11514);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            MAP = new HashMap() { // from class: com.tencent.tuxmetersdk.impl.ruleengine.constant.OperatorAndCalcRuleFuncMap.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    Operator operator = Operator.EQ;
                    CalcRuleFunc calcRuleFunc = CalcRuleFunc.COUNT;
                    put(operator, calcRuleFunc);
                    put(Operator.GT, calcRuleFunc);
                    put(Operator.LT, calcRuleFunc);
                    Operator operator2 = Operator.STAY_TIME_GT;
                    CalcRuleFunc calcRuleFunc2 = CalcRuleFunc.CURRENT_TIME_DIFF;
                    put(operator2, calcRuleFunc2);
                    put(Operator.STAY_TIME_EQ, calcRuleFunc2);
                }
            };
        }
    }

    OperatorAndCalcRuleFuncMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
