package com.tencent.mobileqq.zplan.aio.panel.page;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.page.ScenePageBuilder", f = "ScenePage.kt", i = {0, 0, 1, 1, 1}, l = {143, 145}, m = "onCreatePage", n = {"this", "data", "this", "data", "staticConfigs"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes35.dex */
public final class ScenePageBuilder$onCreatePage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScenePageBuilder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScenePageBuilder$onCreatePage$1(ScenePageBuilder scenePageBuilder, Continuation<? super ScenePageBuilder$onCreatePage$1> continuation) {
        super(continuation);
        this.this$0 = scenePageBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
