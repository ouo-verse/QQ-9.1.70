package com.tencent.tuxmetersdk.impl.ruleengine.constant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LogicOpAndNecessaryRelationOpMap {
    static IPatchRedirector $redirector_;
    public static final Set<Operator> ALL_TIMER;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11475);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            ALL_TIMER = new HashSet() { // from class: com.tencent.tuxmetersdk.impl.ruleengine.constant.LogicOpAndNecessaryRelationOpMap.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    } else {
                        add(Operator.STAY_TIME_GT);
                        add(Operator.STAY_TIME_EQ);
                    }
                }
            };
        }
    }

    public LogicOpAndNecessaryRelationOpMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
