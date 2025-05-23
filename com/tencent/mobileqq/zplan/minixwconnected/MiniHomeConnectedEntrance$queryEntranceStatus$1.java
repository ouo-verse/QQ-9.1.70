package com.tencent.mobileqq.zplan.minixwconnected;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.MiniHomeConnectedEntrance", f = "MiniHomeConnectedEntrance.kt", i = {}, l = {60}, m = "queryEntranceStatus", n = {}, s = {})
/* loaded from: classes34.dex */
public final class MiniHomeConnectedEntrance$queryEntranceStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MiniHomeConnectedEntrance this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectedEntrance$queryEntranceStatus$1(MiniHomeConnectedEntrance miniHomeConnectedEntrance, Continuation<? super MiniHomeConnectedEntrance$queryEntranceStatus$1> continuation) {
        super(continuation);
        this.this$0 = miniHomeConnectedEntrance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        b16 = this.this$0.b(0L, this);
        return b16;
    }
}
