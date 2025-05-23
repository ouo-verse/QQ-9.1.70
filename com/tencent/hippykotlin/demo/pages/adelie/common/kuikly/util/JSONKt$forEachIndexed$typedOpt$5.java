package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util;

import com.tencent.kuikly.core.nvi.serialization.json.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
/* loaded from: classes31.dex */
public final /* synthetic */ class JSONKt$forEachIndexed$typedOpt$5 extends FunctionReferenceImpl implements Function1<Integer, String> {
    @Override // kotlin.jvm.functions.Function1
    public final String invoke(Integer num) {
        return ((b) this.receiver).o(num.intValue());
    }

    public JSONKt$forEachIndexed$typedOpt$5(Object obj) {
        super(1, obj, b.class, "optString", "optString(I)Ljava/lang/String;", 0);
    }
}
