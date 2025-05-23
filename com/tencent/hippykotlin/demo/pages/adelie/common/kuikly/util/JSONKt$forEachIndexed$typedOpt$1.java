package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util;

import com.tencent.kuikly.core.nvi.serialization.json.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
/* loaded from: classes31.dex */
public final /* synthetic */ class JSONKt$forEachIndexed$typedOpt$1 extends FunctionReferenceImpl implements Function1<Integer, Boolean> {
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Integer num) {
        return Boolean.valueOf(((b) this.receiver).e(num.intValue()));
    }

    public JSONKt$forEachIndexed$typedOpt$1(Object obj) {
        super(1, obj, b.class, "optBoolean", "optBoolean(I)Z", 0);
    }
}
