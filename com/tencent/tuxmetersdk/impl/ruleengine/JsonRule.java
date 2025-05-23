package com.tencent.tuxmetersdk.impl.ruleengine;

import com.google.gson.Gson;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.impl.event.TuxEvent;
import com.tencent.tuxmetersdk.impl.ruleengine.Fact;
import com.tencent.tuxmetersdk.impl.ruleengine.calculator.IConditionCalculate;
import com.tencent.tuxmetersdk.impl.ruleengine.calculator.SortConditionCalculator;
import com.tencent.tuxmetersdk.impl.ruleengine.constant.LogicOpAndNecessaryRelationOpMap;
import com.tencent.tuxmetersdk.impl.ruleengine.constant.Operator;
import com.tencent.tuxmetersdk.impl.ruleengine.constant.OperatorAndCalcRuleFuncMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes27.dex */
public class JsonRule {
    static IPatchRedirector $redirector_;
    private Condition condition;
    private double probability;
    private String ruleStr;
    private JsonRuleType type;

    public JsonRule(Condition condition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) condition);
        } else {
            this.type = JsonRuleType.EVENT;
            this.condition = condition;
        }
    }

    private SortConditionCalculator generateSortConditionCalculator(Condition condition) {
        HashMap hashMap = new HashMap();
        String generateSortConditionRegex = generateSortConditionRegex(condition, hashMap, new AtomicInteger(0), new Gson());
        if (generateSortConditionRegex.equals("")) {
            return null;
        }
        return new SortConditionCalculator(condition.getCid(), Pattern.compile(AECameraConstants.WIDGETINFO_SEPARATE + generateSortConditionRegex), hashMap);
    }

    private String generateSortConditionRegex(Condition condition, Map<TuxEvent, Integer> map, AtomicInteger atomicInteger, Gson gson) {
        int intValue;
        if (condition == null || ((condition.getOperator() != Operator.ALL_SORT && condition.getOperator() != Operator.ANY_SORT) || condition.getSubConditions() == null)) {
            return "";
        }
        String str = "";
        for (int i3 = 0; i3 < condition.getSubConditions().size(); i3++) {
            Condition condition2 = condition.getSubConditions().get(i3);
            if (condition2 instanceof ConditionItem) {
                ConditionItem conditionItem = (ConditionItem) condition2;
                TuxEvent tuxEvent = (TuxEvent) gson.fromJson(conditionItem.getKey(), TuxEvent.class);
                if (tuxEvent == null) {
                    return "";
                }
                tuxEvent.setFilter(conditionItem.getFilter());
                String generateRanger = conditionItem.generateRanger();
                if (generateRanger.equals("")) {
                    return "";
                }
                if (!map.containsKey(tuxEvent)) {
                    intValue = atomicInteger.addAndGet(1);
                    map.put(tuxEvent, Integer.valueOf(intValue));
                } else {
                    intValue = map.get(tuxEvent).intValue();
                }
                if (condition.getOperator() == Operator.ALL_SORT) {
                    str = String.format(Locale.CHINA, "(%d;)%s%s", Integer.valueOf(intValue), generateRanger, str);
                } else {
                    if (condition.getOperator() != Operator.ANY_SORT) {
                        return "";
                    }
                    if (str.equals("")) {
                        str = String.format(Locale.CHINA, "(%d;)%s", Integer.valueOf(intValue), generateRanger);
                    } else {
                        str = String.format(Locale.CHINA, "(%d;)%s|%s", Integer.valueOf(intValue), generateRanger, str);
                    }
                }
            } else {
                String generateSortConditionRegex = generateSortConditionRegex(condition2, map, atomicInteger, gson);
                if (generateSortConditionRegex.equals("")) {
                    return "";
                }
                if (condition.getOperator() == Operator.ANY_SORT) {
                    if (!str.equals("")) {
                        str = String.format(Locale.CHINA, "%s|%s", generateSortConditionRegex, str);
                    } else {
                        str = generateSortConditionRegex;
                    }
                } else if (condition.getOperator() != Operator.ALL_SORT) {
                    str = "";
                } else {
                    str = String.format(Locale.CHINA, "%s%s", generateSortConditionRegex, str);
                }
            }
        }
        if (condition.getOperator() == Operator.ANY_SORT) {
            return String.format(Locale.CHINA, "(%s)", str);
        }
        return str;
    }

    public CalculateFactor generateCalculateFactor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (CalculateFactor) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        Gson gson = new Gson();
        CalculateFactor calculateFactor = new CalculateFactor();
        Condition condition = this.condition;
        if (condition == null) {
            return null;
        }
        Stack stack = new Stack();
        stack.push(condition);
        while (!stack.isEmpty()) {
            Condition condition2 = (Condition) stack.pop();
            if (Operator.isSortOperator(condition2.getOperator())) {
                SortConditionCalculator generateSortConditionCalculator = generateSortConditionCalculator(condition2);
                if (generateSortConditionCalculator == null) {
                    return null;
                }
                calculateFactor.getConditionCalculators().put(generateSortConditionCalculator.getCid(), generateSortConditionCalculator);
            } else if (condition2.getSubConditions() != null) {
                TuxEvent tuxEvent = null;
                for (int i3 = 0; i3 < condition2.getSubConditions().size(); i3++) {
                    Condition condition3 = condition2.getSubConditions().get(i3);
                    if (condition3 instanceof ConditionItem) {
                        ConditionItem conditionItem = (ConditionItem) condition3;
                        TuxEvent tuxEvent2 = (TuxEvent) gson.fromJson(conditionItem.getKey(), TuxEvent.class);
                        if (tuxEvent2 == null) {
                            return null;
                        }
                        Fact.Builder event = new Fact.Builder().key(conditionItem.getKey()).filter(conditionItem.getFilter()).calcRuleFunc(OperatorAndCalcRuleFuncMap.MAP.get(conditionItem.getOperator())).event(tuxEvent2);
                        if (condition2.getOperator() == Operator.ALL_TIMER) {
                            if (i3 == 0) {
                                if (!LogicOpAndNecessaryRelationOpMap.ALL_TIMER.contains(conditionItem.getOperator())) {
                                    return null;
                                }
                                tuxEvent = tuxEvent2;
                            }
                            event.resetEvent(tuxEvent);
                        }
                        Fact build = event.build();
                        conditionItem.setIdentifier(build.getIdentifier());
                        calculateFactor.getFacts().add(build);
                    } else {
                        if (condition2.getOperator() == Operator.ALL_TIMER) {
                            return null;
                        }
                        stack.push(condition3);
                    }
                }
            } else {
                continue;
            }
        }
        return calculateFactor;
    }

    public Condition getCondition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Condition) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.condition;
    }

    public double getProbability() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Double) iPatchRedirector.redirect((short) 9, (Object) this)).doubleValue();
        }
        return this.probability;
    }

    public Set<TuxEvent> getRelatedEvents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Set) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        Gson gson = new Gson();
        HashSet hashSet = new HashSet();
        if (this.condition == null) {
            return null;
        }
        Stack stack = new Stack();
        stack.push(this.condition);
        while (!stack.isEmpty()) {
            Condition condition = (Condition) stack.pop();
            if (condition.getSubConditions() != null) {
                for (int i3 = 0; i3 < condition.getSubConditions().size(); i3++) {
                    Condition condition2 = condition.getSubConditions().get(i3);
                    if (condition2 instanceof ConditionItem) {
                        TuxEvent tuxEvent = (TuxEvent) gson.fromJson(((ConditionItem) condition2).getKey(), TuxEvent.class);
                        if (tuxEvent == null) {
                            return null;
                        }
                        hashSet.add(tuxEvent);
                    } else {
                        stack.push(condition2);
                    }
                }
            }
        }
        return hashSet;
    }

    public String getRuleStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.ruleStr;
    }

    public JsonRuleType getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JsonRuleType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.type;
    }

    public boolean match(List<TuxEvent> list) {
        Set<Fact> facts;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) list)).booleanValue();
        }
        CalculateFactor generateCalculateFactor = generateCalculateFactor();
        if (generateCalculateFactor == null || (facts = generateCalculateFactor.getFacts()) == null) {
            return false;
        }
        Map<String, IConditionCalculate> conditionCalculators = generateCalculateFactor.getConditionCalculators();
        if (conditionCalculators != null) {
            Iterator<IConditionCalculate> it = conditionCalculators.values().iterator();
            while (it.hasNext()) {
                it.next().calculate(list);
            }
        }
        for (TuxEvent tuxEvent : list) {
            Iterator<Fact> it5 = facts.iterator();
            while (it5.hasNext()) {
                it5.next().calculate(tuxEvent);
            }
        }
        return match(new ArrayList(facts), conditionCalculators);
    }

    public void setCondition(Condition condition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) condition);
        } else {
            this.condition = condition;
        }
    }

    public void setProbability(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Double.valueOf(d16));
        } else {
            this.probability = d16;
        }
    }

    public void setRuleStr(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.ruleStr = str;
        }
    }

    public void setType(JsonRuleType jsonRuleType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jsonRuleType);
        } else {
            this.type = jsonRuleType;
        }
    }

    public JsonRule(Condition condition, JsonRuleType jsonRuleType, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, condition, jsonRuleType, Double.valueOf(d16));
            return;
        }
        JsonRuleType jsonRuleType2 = JsonRuleType.EVENT;
        this.condition = condition;
        this.type = jsonRuleType;
        this.probability = d16;
    }

    private boolean match(List<Fact> list, Map<String, IConditionCalculate> map) {
        return this.condition.match(list, map);
    }
}
