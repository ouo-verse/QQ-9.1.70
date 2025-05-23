package com.tencent.hippykotlin.demo.pages.vas_base;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.VasModule", f = "VasModule.kt", i = {0, 0, 0}, l = {286, 300}, m = "setBackgroundPhoto", n = {"this", "data", "callback"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes33.dex */
public final class VasModule$setBackgroundPhoto$1 extends ContinuationImpl {
    public Object L$0;
    public e L$1;
    public Function3 L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ VasModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasModule$setBackgroundPhoto$1(VasModule vasModule, Continuation<? super VasModule$setBackgroundPhoto$1> continuation) {
        super(continuation);
        this.this$0 = vasModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setBackgroundPhoto(null, null, this);
    }
}
