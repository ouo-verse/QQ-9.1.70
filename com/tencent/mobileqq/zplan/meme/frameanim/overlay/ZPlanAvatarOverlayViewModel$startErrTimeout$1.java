package com.tencent.mobileqq.zplan.meme.frameanim.overlay;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.meme.frameanim.overlay.ZPlanAvatarOverlayViewModel", f = "ZPlanAvatarOverlayViewModel.kt", i = {0}, l = {106}, m = "startErrTimeout", n = {"this"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class ZPlanAvatarOverlayViewModel$startErrTimeout$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanAvatarOverlayViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarOverlayViewModel$startErrTimeout$1(ZPlanAvatarOverlayViewModel zPlanAvatarOverlayViewModel, Continuation<? super ZPlanAvatarOverlayViewModel$startErrTimeout$1> continuation) {
        super(continuation);
        this.this$0 = zPlanAvatarOverlayViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object i26;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        i26 = this.this$0.i2(this);
        return i26;
    }
}
