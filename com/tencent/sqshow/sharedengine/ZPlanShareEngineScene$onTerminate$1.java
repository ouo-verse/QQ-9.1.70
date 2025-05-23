package com.tencent.sqshow.sharedengine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.sqshow.sharedengine.ZPlanShareEngineScene", f = "ZPlanShareEngineScene.kt", i = {0}, l = {213}, m = "onTerminate", n = {"this"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class ZPlanShareEngineScene$onTerminate$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanShareEngineScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanShareEngineScene$onTerminate$1(ZPlanShareEngineScene zPlanShareEngineScene, Continuation<? super ZPlanShareEngineScene$onTerminate$1> continuation) {
        super(continuation);
        this.this$0 = zPlanShareEngineScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onTerminate(this);
    }
}
