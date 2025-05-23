package com.tencent.hippykotlin.demo.pages.vas_base.native_api;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.native_api.GXH", f = "GXH.kt", i = {0, 0, 1, 1}, l = {276, 278, 296}, m = "batchSetCustomBg", n = {"this", "data", "this", "data"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes33.dex */
public final class GXH$batchSetCustomBg$1 extends ContinuationImpl {
    public GXH L$0;
    public e L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ GXH this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXH$batchSetCustomBg$1(GXH gxh, Continuation<? super GXH$batchSetCustomBg$1> continuation) {
        super(continuation);
        this.this$0 = gxh;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.batchSetCustomBg(null, this);
    }
}
