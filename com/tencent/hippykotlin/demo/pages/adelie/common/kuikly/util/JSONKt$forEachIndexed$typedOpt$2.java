package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util;

import com.tencent.kuikly.core.nvi.serialization.json.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
/* loaded from: classes31.dex */
public final /* synthetic */ class JSONKt$forEachIndexed$typedOpt$2 extends FunctionReferenceImpl implements Function1<Integer, Integer> {
    @Override // kotlin.jvm.functions.Function1
    public final Integer invoke(Integer num) {
        return Integer.valueOf(((b) this.receiver).i(num.intValue()));
    }

    public JSONKt$forEachIndexed$typedOpt$2(Object obj) {
        super(1, obj, b.class, "optInt", "optInt(I)I", 0);
    }
}
