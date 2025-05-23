package com.tencent.tuxmetersdk.impl.ruleengine.handler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.impl.ruleengine.ConditionItem;
import com.tencent.tuxmetersdk.impl.ruleengine.Fact;
import com.tencent.tuxmetersdk.impl.ruleengine.constant.Operator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class StayTimeEQHandler extends AbstractHanlder {
    static IPatchRedirector $redirector_;

    public StayTimeEQHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tuxmetersdk.impl.ruleengine.handler.AbstractHanlder
    public boolean canHandle(ConditionItem conditionItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) conditionItem)).booleanValue();
        }
        if (Operator.STAY_TIME_EQ == conditionItem.getOperator()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tuxmetersdk.impl.ruleengine.handler.AbstractHanlder
    public boolean doHandle(ConditionItem conditionItem, Fact fact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) conditionItem, (Object) fact)).booleanValue();
        }
        if (fact.getValue() == null || Math.abs(Long.parseLong(fact.getValue().toString()) - Long.parseLong(conditionItem.getValue().toString())) >= 500) {
            return false;
        }
        return true;
    }
}
