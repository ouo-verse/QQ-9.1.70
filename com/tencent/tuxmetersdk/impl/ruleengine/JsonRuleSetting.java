package com.tencent.tuxmetersdk.impl.ruleengine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class JsonRuleSetting {
    static IPatchRedirector $redirector_;
    private JsonRuleType type;

    public JsonRuleSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.type = JsonRuleType.EVENT;
        }
    }

    public JsonRuleType getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JsonRuleType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.type;
    }

    public void setType(JsonRuleType jsonRuleType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jsonRuleType);
        } else {
            this.type = jsonRuleType;
        }
    }
}
