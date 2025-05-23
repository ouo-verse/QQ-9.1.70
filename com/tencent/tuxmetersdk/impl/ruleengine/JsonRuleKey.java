package com.tencent.tuxmetersdk.impl.ruleengine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class JsonRuleKey {
    static IPatchRedirector $redirector_ = null;
    public static final String FACT = "fact";
    public static final String FILTER = "filter";
    public static final String OPERATOR = "operator";
    public static final String VALUE = "value";

    public JsonRuleKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
