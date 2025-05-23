package com.tencent.tuxmetersdk.impl.ruleengine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.impl.ruleengine.calculator.IConditionCalculate;
import com.tencent.tuxmetersdk.impl.ruleengine.constant.Operator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Condition {
    static IPatchRedirector $redirector_;
    private String cid;
    protected Operator operator;
    private List<Condition> subConditions;

    /* JADX INFO: Access modifiers changed from: protected */
    public Condition(Operator operator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.operator = operator;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) operator);
        }
    }

    public String getCid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.cid;
    }

    public Operator getOperator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Operator) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.operator;
    }

    public List<Condition> getSubConditions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.subConditions;
    }

    public boolean match(List<Fact> list, Map<String, IConditionCalculate> map) {
        IConditionCalculate iConditionCalculate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) list, (Object) map)).booleanValue();
        }
        if (!this.operator.equals(Operator.ALL) && !this.operator.equals(Operator.ALL_TIMER)) {
            if (this.operator.equals(Operator.ANY)) {
                Iterator<Condition> it = this.subConditions.iterator();
                while (it.hasNext()) {
                    if (it.next().match(list, map)) {
                        return true;
                    }
                }
                return false;
            }
            if ((!this.operator.equals(Operator.ALL_SORT) && !this.operator.equals(Operator.ANY_SORT)) || (iConditionCalculate = map.get(this.cid)) == null) {
                return false;
            }
            return iConditionCalculate.getResult();
        }
        Iterator<Condition> it5 = this.subConditions.iterator();
        while (it5.hasNext()) {
            if (!it5.next().match(list, map)) {
                return false;
            }
        }
        return true;
    }

    public Condition(Operator operator, List<Condition> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) operator, (Object) list);
            return;
        }
        this.operator = operator;
        this.subConditions = list;
        this.cid = UUID.randomUUID().toString();
    }
}
