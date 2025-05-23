package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util;

import com.tencent.kuikly.core.nvi.serialization.json.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
/* loaded from: classes31.dex */
public final /* synthetic */ class JSONKt$forEachIndexed$typedOpt$3 extends FunctionReferenceImpl implements Function1<Integer, Long> {
    @Override // kotlin.jvm.functions.Function1
    public final Long invoke(Integer num) {
        return Long.valueOf(((b) this.receiver).m(num.intValue()));
    }

    public JSONKt$forEachIndexed$typedOpt$3(Object obj) {
        super(1, obj, b.class, "optLong", "optLong(I)J", 0);
    }
}
