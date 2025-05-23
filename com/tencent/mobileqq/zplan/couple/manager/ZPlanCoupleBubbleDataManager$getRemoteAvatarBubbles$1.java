package com.tencent.mobileqq.zplan.couple.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.couple.manager.ZPlanCoupleBubbleDataManager", f = "ZPlanCoupleBubbleDataManager.kt", i = {}, l = {111}, m = "getRemoteAvatarBubbles", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ZPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanCoupleBubbleDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1(ZPlanCoupleBubbleDataManager zPlanCoupleBubbleDataManager, Continuation<? super ZPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1> continuation) {
        super(continuation);
        this.this$0 = zPlanCoupleBubbleDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object g16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g16 = this.this$0.g(this);
        return g16;
    }
}
