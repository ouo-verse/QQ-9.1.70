package com.tencent.tuxmetersdk.impl.ruleengine.calculator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.impl.Utils;
import com.tencent.tuxmetersdk.impl.event.TuxEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SortConditionCalculator implements IConditionCalculate {
    static IPatchRedirector $redirector_;
    private String cid;
    private Map<TuxEvent, Integer> eventAndConditionItemIndexMap;
    private boolean isMatch;
    private Pattern pattern;

    public SortConditionCalculator(String str, Pattern pattern, Map<TuxEvent, Integer> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, pattern, map);
            return;
        }
        new HashMap();
        this.cid = str;
        this.pattern = pattern;
        this.eventAndConditionItemIndexMap = map;
    }

    @Override // com.tencent.tuxmetersdk.impl.ruleengine.calculator.IConditionCalculate
    public void calculate(List<TuxEvent> list) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            TuxEvent tuxEvent = list.get(size);
            if (tuxEvent != null) {
                Iterator<Map.Entry<TuxEvent, Integer>> it = this.eventAndConditionItemIndexMap.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<TuxEvent, Integer> next = it.next();
                        if (next.getKey() != null && tuxEvent.contain(next.getKey(), next.getKey().getFilter())) {
                            num = next.getValue();
                            break;
                        }
                    } else {
                        num = null;
                        break;
                    }
                }
                if (num == null) {
                    if (size == list.size() - 1) {
                        break;
                    }
                } else {
                    arrayList.add(String.valueOf(num));
                }
            }
        }
        this.isMatch = this.pattern.matcher(Utils.join(";", arrayList) + ";").find();
    }

    @Override // com.tencent.tuxmetersdk.impl.ruleengine.calculator.IConditionCalculate
    public String getCid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.cid;
    }

    public Map<TuxEvent, Integer> getEventAndConditionItemIndexMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.eventAndConditionItemIndexMap;
    }

    public Pattern getPattern() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pattern) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.pattern;
    }

    @Override // com.tencent.tuxmetersdk.impl.ruleengine.calculator.IConditionCalculate
    public boolean getResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.isMatch;
    }

    public boolean isMatch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isMatch;
    }

    public void setCid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.cid = str;
        }
    }

    public void setEventAndConditionItemIndexMap(Map<TuxEvent, Integer> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) map);
        } else {
            this.eventAndConditionItemIndexMap = map;
        }
    }

    public void setMatch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.isMatch = z16;
        }
    }

    public void setPattern(Pattern pattern) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) pattern);
        } else {
            this.pattern = pattern;
        }
    }
}
