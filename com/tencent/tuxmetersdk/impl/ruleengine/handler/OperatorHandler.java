package com.tencent.tuxmetersdk.impl.ruleengine.handler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tuxmetersdk.impl.ruleengine.ConditionItem;
import com.tencent.tuxmetersdk.impl.ruleengine.Fact;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OperatorHandler {
    static IPatchRedirector $redirector_;
    private static final List<IOperatorHandler> operatorHandlers;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11940);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            operatorHandlers = Arrays.asList(new EqHandler(), new GreaterThanHandler(), new LessThanHandler(), new StayTimeGTHandler(), new StayTimeEQHandler());
        }
    }

    public OperatorHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean handle(ConditionItem conditionItem, List<Fact> list) {
        Iterator<IOperatorHandler> it = operatorHandlers.iterator();
        while (it.hasNext()) {
            if (it.next().handle(conditionItem, list)) {
                return true;
            }
        }
        return false;
    }
}
