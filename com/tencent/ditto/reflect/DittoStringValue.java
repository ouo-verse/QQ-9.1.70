package com.tencent.ditto.reflect;

import com.tencent.ditto.utils.DittoLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoStringValue extends DittoValue {
    public String mString = null;

    @Override // com.tencent.ditto.reflect.DittoValue
    public Object getValue(Object obj) {
        return this.mString;
    }

    @Override // com.tencent.ditto.reflect.DittoValue
    public void setValue(Object obj, boolean z16) {
        DittoLog.e(DittoLog.defaultTag, "cannot set a value of string constant:" + this.mString, new RuntimeException());
    }

    @Override // com.tencent.ditto.reflect.DittoValue
    public void setValue(Object obj, String str) {
        DittoLog.e(DittoLog.defaultTag, "cannot set a value of string constant:" + this.mString, new RuntimeException());
    }
}
