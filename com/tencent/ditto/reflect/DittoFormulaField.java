package com.tencent.ditto.reflect;

import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.utils.DittoLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoFormulaField extends DittoValue {
    private String formula;
    private float offset;
    private String operator;
    private float ratio;
    private DittoValue value;

    public DittoFormulaField(String str, String str2, String str3, String str4, String str5, String str6) {
        this.ratio = Float.parseFloat(str);
        this.value = MustacheParser.parse(str2);
        this.offset = Float.parseFloat(str4);
        if ("dp".equals(str5)) {
            this.offset *= DittoUIEngine.g().getDensity();
        }
        this.operator = str3;
        this.formula = str6;
    }

    @Override // com.tencent.ditto.reflect.DittoValue
    public Object getValue(Object obj) {
        int i3;
        try {
            double d16 = this.ratio;
            double parseDouble = Double.parseDouble(this.value.getValue(obj).toString());
            if ("-".equals(this.operator)) {
                i3 = -1;
            } else {
                i3 = 1;
            }
            return Double.valueOf(d16 * (parseDouble + (i3 * this.offset)));
        } catch (Throwable unused) {
            DittoLog.e("DittoFormulaField", "err parse value " + this.formula);
            return "0";
        }
    }

    @Override // com.tencent.ditto.reflect.DittoValue
    public void setValue(Object obj, boolean z16) {
        DittoLog.e(DittoLog.defaultTag, "cannot set a value of formula:" + this.formula, new RuntimeException());
    }

    @Override // com.tencent.ditto.reflect.DittoValue
    public void setValue(Object obj, String str) {
        DittoLog.e(DittoLog.defaultTag, "cannot set a value of formula:" + this.formula, new RuntimeException());
    }
}
