package com.tencent.mobileqq.zplan.minixwconnected.view;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent", f = "MiniHomeConnectActionFocusComponent.kt", i = {0, 1, 1}, l = {237, 245}, m = "requestPanel", n = {"builders", "builders", "destination$iv$iv"}, s = {"L$0", "L$0", "L$2"})
/* loaded from: classes34.dex */
public final class MiniHomeConnectActionFocusComponent$requestPanel$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MiniHomeConnectActionFocusComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectActionFocusComponent$requestPanel$1(MiniHomeConnectActionFocusComponent miniHomeConnectActionFocusComponent, Continuation<? super MiniHomeConnectActionFocusComponent$requestPanel$1> continuation) {
        super(continuation);
        this.this$0 = miniHomeConnectActionFocusComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m3 = this.this$0.m(null, this);
        return m3;
    }
}
