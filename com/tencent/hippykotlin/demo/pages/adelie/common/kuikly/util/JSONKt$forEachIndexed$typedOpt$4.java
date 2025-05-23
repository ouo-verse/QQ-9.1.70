package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util;

import com.tencent.kuikly.core.nvi.serialization.json.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
/* loaded from: classes31.dex */
public final /* synthetic */ class JSONKt$forEachIndexed$typedOpt$4 extends FunctionReferenceImpl implements Function1<Integer, Double> {
    @Override // kotlin.jvm.functions.Function1
    public final Double invoke(Integer num) {
        return Double.valueOf(((b) this.receiver).g(num.intValue()));
    }

    public JSONKt$forEachIndexed$typedOpt$4(Object obj) {
        super(1, obj, b.class, "optDouble", "optDouble(I)D", 0);
    }
}
