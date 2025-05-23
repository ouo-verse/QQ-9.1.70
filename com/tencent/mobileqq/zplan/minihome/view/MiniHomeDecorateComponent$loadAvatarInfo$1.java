package com.tencent.mobileqq.zplan.minihome.view;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.view.MiniHomeDecorateComponent", f = "MiniHomeDecorateComponent.kt", i = {}, l = {598}, m = "loadAvatarInfo", n = {}, s = {})
/* loaded from: classes34.dex */
public final class MiniHomeDecorateComponent$loadAvatarInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MiniHomeDecorateComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeDecorateComponent$loadAvatarInfo$1(MiniHomeDecorateComponent miniHomeDecorateComponent, Continuation<? super MiniHomeDecorateComponent$loadAvatarInfo$1> continuation) {
        super(continuation);
        this.this$0 = miniHomeDecorateComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object H;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        H = this.this$0.H(this);
        return H;
    }
}
