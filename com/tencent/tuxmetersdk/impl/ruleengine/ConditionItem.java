package com.tencent.tuxmetersdk.impl.ruleengine;

import com.google.gson.JsonElement;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.impl.ruleengine.calculator.IConditionCalculate;
import com.tencent.tuxmetersdk.impl.ruleengine.constant.Operator;
import com.tencent.tuxmetersdk.impl.ruleengine.handler.OperatorHandler;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ConditionItem extends Condition {
    static IPatchRedirector $redirector_;
    private String filter;
    private String identifier;
    private String key;
    private Object value;

    public ConditionItem(Operator operator, String str, Object obj, JsonElement jsonElement) {
        super(operator);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, operator, str, obj, jsonElement);
            return;
        }
        this.key = str;
        this.value = obj;
        if (jsonElement != null) {
            this.filter = jsonElement.getAsString();
        }
    }

    public String generateRanger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        Object obj = this.value;
        if (obj == null) {
            return "";
        }
        int parseInt = Integer.parseInt(obj.toString());
        Operator operator = this.operator;
        if (operator == Operator.EQ) {
            return String.format(Locale.CHINA, "{%d}", Integer.valueOf(parseInt));
        }
        if (operator == Operator.GT) {
            return String.format(Locale.CHINA, "{%d,}", Integer.valueOf(parseInt + 1));
        }
        if (operator != Operator.LT) {
            return "";
        }
        return String.format(Locale.CHINA, "{0,%d}", Integer.valueOf(parseInt - 1));
    }

    public String getFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.filter;
    }

    public String getIdentifier() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.identifier;
    }

    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.key;
    }

    public Object getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.value;
    }

    @Override // com.tencent.tuxmetersdk.impl.ruleengine.Condition
    public boolean match(List<Fact> list, Map<String, IConditionCalculate> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) list, (Object) map)).booleanValue();
        }
        return OperatorHandler.handle(this, list);
    }

    public void setFilter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.filter = str;
        }
    }

    public void setIdentifier(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.identifier = str;
        }
    }

    public void setKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.key = str;
        }
    }

    public void setValue(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, obj);
        } else {
            this.value = obj;
        }
    }
}
