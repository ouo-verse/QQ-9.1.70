package com.tencent.tuxmetersdk.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRule;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ChildTrigger {
    static IPatchRedirector $redirector_;
    double defaultProbability;
    List<JsonRule> jsonRules;

    public ChildTrigger(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Double.valueOf(d16));
        } else {
            this.defaultProbability = d16;
        }
    }

    public double getDefaultProbability() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Double) iPatchRedirector.redirect((short) 2, (Object) this)).doubleValue();
        }
        return this.defaultProbability;
    }

    public List<JsonRule> getJsonRules() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.jsonRules;
    }

    public void setDefaultProbability(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16));
        } else {
            this.defaultProbability = d16;
        }
    }

    public void setJsonRules(List<JsonRule> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.jsonRules = list;
        }
    }
}
