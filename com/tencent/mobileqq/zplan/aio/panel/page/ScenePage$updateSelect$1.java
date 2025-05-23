package com.tencent.mobileqq.zplan.aio.panel.page;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.page.ScenePage", f = "ScenePage.kt", i = {0}, l = {110}, m = "updateSelect", n = {"this"}, s = {"L$0"})
/* loaded from: classes35.dex */
public final class ScenePage$updateSelect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScenePage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScenePage$updateSelect$1(ScenePage scenePage, Continuation<? super ScenePage$updateSelect$1> continuation) {
        super(continuation);
        this.this$0 = scenePage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.A(this);
    }
}
