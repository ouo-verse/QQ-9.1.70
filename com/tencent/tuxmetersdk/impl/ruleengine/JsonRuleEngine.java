package com.tencent.tuxmetersdk.impl.ruleengine;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.export.injector.log.ITuxLog;
import com.tencent.tuxmetersdk.impl.ruleengine.constant.LogicOpAndNecessaryRelationOpMap;
import com.tencent.tuxmetersdk.impl.ruleengine.constant.Operator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class JsonRuleEngine {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TuxJsonRuleEngine";
    private final ITuxLog logger;

    public JsonRuleEngine(ITuxLog iTuxLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iTuxLog);
        } else {
            this.logger = iTuxLog;
        }
    }

    private Condition parseCondition(JsonObject jsonObject, JsonRuleSetting jsonRuleSetting) {
        JsonObject jsonObject2;
        ConditionItem conditionItem;
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, JsonElement>> it = jsonObject.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getKey());
            }
            if (arrayList.size() == 1) {
                ArrayList arrayList2 = new ArrayList();
                boolean equals = Operator.valueOfName((String) arrayList.get(0)).equals(Operator.ALL_TIMER);
                for (int i3 = 0; i3 < jsonObject.getAsJsonArray((String) arrayList.get(0)).size(); i3++) {
                    try {
                        jsonObject2 = jsonObject.getAsJsonArray((String) arrayList.get(0)).get(i3).getAsJsonObject();
                    } catch (Exception e16) {
                        this.logger.e(TAG, "parseCondition\u89e3\u6790\u9519\u8bef\uff0c\u9519\u8bef\u4fe1\u606f" + e16.getLocalizedMessage());
                        jsonObject2 = null;
                    }
                    Condition parseCondition = parseCondition(jsonObject2, jsonRuleSetting);
                    if (parseCondition == null) {
                        return null;
                    }
                    if (parseCondition instanceof ConditionItem) {
                        conditionItem = (ConditionItem) parseCondition;
                    } else {
                        conditionItem = null;
                    }
                    if (equals) {
                        jsonRuleSetting.setType(JsonRuleType.TIMER);
                        if (conditionItem == null) {
                            return null;
                        }
                        if (i3 == 0 && !LogicOpAndNecessaryRelationOpMap.ALL_TIMER.contains(conditionItem.operator)) {
                            return null;
                        }
                    }
                    arrayList2.add(parseCondition);
                }
                return new Condition(Operator.valueOfName((String) arrayList.get(0)), arrayList2);
            }
            return new ConditionItem(Operator.valueOfName(jsonObject.get(JsonRuleKey.OPERATOR).getAsString()), jsonObject.get(JsonRuleKey.FACT).getAsString(), jsonObject.get("value").getAsString(), jsonObject.get("filter"));
        } catch (Exception e17) {
            this.logger.e(TAG, "parseCondition\u89e3\u6790\u9519\u8bef\uff0c\u9519\u8bef\u4fe1\u606f:" + e17.getLocalizedMessage());
            return null;
        }
    }

    public JsonRule parseOne(JsonObject jsonObject, double d16) {
        Condition parseCondition;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JsonRule) iPatchRedirector.redirect((short) 3, this, jsonObject, Double.valueOf(d16));
        }
        try {
            JsonObject asJsonObject = jsonObject.getAsJsonObject("conditions");
            JsonRuleSetting jsonRuleSetting = new JsonRuleSetting();
            if (asJsonObject != null && (parseCondition = parseCondition(asJsonObject, jsonRuleSetting)) != null) {
                return new JsonRule(parseCondition, jsonRuleSetting.getType(), d16);
            }
            return null;
        } catch (Exception e16) {
            this.logger.e(TAG, "parseOne\u89e3\u6790\u9519\u8bef\uff0c\u9519\u8bef\u4fe1\u606f" + e16.getLocalizedMessage());
            return null;
        }
    }

    public JsonRule parseOneWithJsonString(String str, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JsonRule) iPatchRedirector.redirect((short) 2, this, str, Double.valueOf(d16));
        }
        try {
            JsonRule parseOne = parseOne(new JsonParser().parse(str).getAsJsonObject(), d16);
            parseOne.setRuleStr(str);
            return parseOne;
        } catch (Exception e16) {
            this.logger.e(TAG, "parseOneWithJsonString\u89e3\u6790\u9519\u8bef\uff0c\u5165\u53c2:" + str + ";\u9519\u8bef\u4fe1\u606f\uff1a" + e16.getLocalizedMessage());
            return null;
        }
    }
}
