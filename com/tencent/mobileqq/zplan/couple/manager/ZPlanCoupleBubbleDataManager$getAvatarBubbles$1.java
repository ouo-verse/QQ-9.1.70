package com.tencent.mobileqq.zplan.couple.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.couple.manager.ZPlanCoupleBubbleDataManager", f = "ZPlanCoupleBubbleDataManager.kt", i = {0}, l = {95}, m = "getAvatarBubbles", n = {"this"}, s = {"L$0"})
/* loaded from: classes35.dex */
public final class ZPlanCoupleBubbleDataManager$getAvatarBubbles$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanCoupleBubbleDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanCoupleBubbleDataManager$getAvatarBubbles$1(ZPlanCoupleBubbleDataManager zPlanCoupleBubbleDataManager, Continuation<? super ZPlanCoupleBubbleDataManager$getAvatarBubbles$1> continuation) {
        super(continuation);
        this.this$0 = zPlanCoupleBubbleDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(this);
    }
}
