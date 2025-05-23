package com.tencent.tuxmetersdk.impl.ruleengine.handler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.impl.ruleengine.ConditionItem;
import com.tencent.tuxmetersdk.impl.ruleengine.Fact;
import com.tencent.tuxmetersdk.impl.ruleengine.constant.Operator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class EqHandler extends AbstractHanlder {
    static IPatchRedirector $redirector_;

    public EqHandler() {
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
        if (Operator.EQ == conditionItem.getOperator()) {
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
        if (fact.getValue() == null || Long.parseLong(String.valueOf(conditionItem.getValue())) != Long.parseLong(String.valueOf(fact.getValue()))) {
            return false;
        }
        return true;
    }
}
