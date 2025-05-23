package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util;

import com.tencent.kuikly.core.nvi.serialization.json.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
/* loaded from: classes31.dex */
public final /* synthetic */ class JSONKt$forEachIndexed$typedOpt$8 extends FunctionReferenceImpl implements Function1<Integer, Object> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Integer num) {
        return ((b) this.receiver).d(num.intValue());
    }

    public JSONKt$forEachIndexed$typedOpt$8(Object obj) {
        super(1, obj, b.class, "opt", "opt(I)Ljava/lang/Object;", 0);
    }
}
