package com.tencent.ditto.reflect;

import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class MustacheParser {
    private static final Pattern formulaPattern = Pattern.compile("^([0-9.]*)\\*\\(([a-zA-Z0-9\\[\\].']*)([+\\-])([0-9.]*)(|px|dp)\\)$");

    private static List<String> getTokens(String str) {
        ArrayList arrayList = new ArrayList(3);
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = false;
        for (char c16 : str.toCharArray()) {
            if (c16 == '\'') {
                z16 = !z16;
                sb5.append(c16);
            } else if (c16 == ' ' && !z16) {
                if (sb5.length() != 0) {
                    arrayList.add(sb5.toString());
                    sb5 = new StringBuilder();
                }
            } else if (c16 != '?' && c16 != ':') {
                sb5.append(c16);
            } else {
                if (sb5.length() != 0) {
                    arrayList.add(sb5.toString());
                    sb5 = new StringBuilder();
                }
                arrayList.add(Character.valueOf(c16).toString());
            }
        }
        if (sb5.length() != 0) {
            arrayList.add(sb5.toString());
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.tencent.ditto.reflect.DittoFieldValue] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.tencent.ditto.reflect.DittoValue] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.tencent.ditto.reflect.DittoStringValue] */
    public static DittoValue parse(String str) {
        List<String> tokens = getTokens(str);
        Matcher matcher = formulaPattern.matcher(str.replace(" ", ""));
        if (matcher.matches()) {
            return new DittoFormulaField(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4), matcher.group(5), str);
        }
        DittoConditionOperatorValue dittoConditionOperatorValue = null;
        DittoValue dittoValue = 0;
        for (String str2 : tokens) {
            if (QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER.equals(str2)) {
                if (dittoValue != 0) {
                    dittoConditionOperatorValue = new DittoConditionOperatorValue();
                    dittoConditionOperatorValue.conditionValue = dittoValue;
                } else {
                    throw new RuntimeException("mustache should not be started with ?");
                }
            } else if (":".equals(str2)) {
                if (dittoConditionOperatorValue != null) {
                    if (dittoValue == 0) {
                        dittoConditionOperatorValue.trueValue = dittoConditionOperatorValue.conditionValue;
                    } else {
                        dittoConditionOperatorValue.trueValue = dittoValue;
                    }
                }
            } else if (str2.startsWith("'")) {
                dittoValue = new DittoStringValue();
                dittoValue.mString = str2.substring(1, str2.length() - 1);
            } else {
                dittoValue = new DittoFieldValue();
                dittoValue.fieldName = str2;
            }
            dittoValue = 0;
        }
        if (dittoConditionOperatorValue != null) {
            if (dittoValue != 0) {
                dittoConditionOperatorValue.falseValue = dittoValue;
            } else {
                throw new RuntimeException("there must be a string | field name after ':'");
            }
        }
        if (dittoConditionOperatorValue == null) {
            return dittoValue;
        }
        return dittoConditionOperatorValue;
    }
}
