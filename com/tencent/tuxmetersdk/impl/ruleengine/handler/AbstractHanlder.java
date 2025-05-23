package com.tencent.tuxmetersdk.impl.ruleengine.handler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.impl.ruleengine.ConditionItem;
import com.tencent.tuxmetersdk.impl.ruleengine.Fact;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class AbstractHanlder implements IOperatorHandler {
    static IPatchRedirector $redirector_;

    public AbstractHanlder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected abstract boolean canHandle(ConditionItem conditionItem);

    protected abstract boolean doHandle(ConditionItem conditionItem, Fact fact);

    @Override // com.tencent.tuxmetersdk.impl.ruleengine.handler.IOperatorHandler
    public boolean handle(ConditionItem conditionItem, List<Fact> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) conditionItem, (Object) list)).booleanValue();
        }
        if (!canHandle(conditionItem)) {
            return false;
        }
        for (Fact fact : list) {
            if (conditionItem.getIdentifier().equals(fact.getIdentifier()) && doHandle(conditionItem, fact)) {
                return true;
            }
        }
        return false;
    }
}
