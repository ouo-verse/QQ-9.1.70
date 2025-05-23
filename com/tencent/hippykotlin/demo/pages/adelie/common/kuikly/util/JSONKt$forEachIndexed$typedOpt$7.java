package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util;

import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
/* loaded from: classes31.dex */
public final /* synthetic */ class JSONKt$forEachIndexed$typedOpt$7 extends FunctionReferenceImpl implements Function1<Integer, e> {
    @Override // kotlin.jvm.functions.Function1
    public final e invoke(Integer num) {
        return ((b) this.receiver).l(num.intValue());
    }

    public JSONKt$forEachIndexed$typedOpt$7(Object obj) {
        super(1, obj, b.class, "optJSONObject", "optJSONObject(I)Lcom/tencent/kuikly/core/nvi/serialization/json/JSONObject;", 0);
    }
}
