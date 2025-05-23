package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util;

import com.tencent.kuikly.core.nvi.serialization.json.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
/* loaded from: classes31.dex */
public final /* synthetic */ class JSONKt$forEachIndexed$typedOpt$6 extends FunctionReferenceImpl implements Function1<Integer, b> {
    @Override // kotlin.jvm.functions.Function1
    public final b invoke(Integer num) {
        return ((b) this.receiver).k(num.intValue());
    }

    public JSONKt$forEachIndexed$typedOpt$6(Object obj) {
        super(1, obj, b.class, "optJSONArray", "optJSONArray(I)Lcom/tencent/kuikly/core/nvi/serialization/json/JSONArray;", 0);
    }
}
