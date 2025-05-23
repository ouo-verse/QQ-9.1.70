package com.tencent.mobileqq.activity.aio.zplan;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView", f = "ZPlanIntimateInfoView.kt", i = {0}, l = {588}, m = "initCoupleAvatarView", n = {"this"}, s = {"L$0"})
/* loaded from: classes10.dex */
public final class ZPlanIntimateInfoView$initCoupleAvatarView$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanIntimateInfoView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanIntimateInfoView$initCoupleAvatarView$1(ZPlanIntimateInfoView zPlanIntimateInfoView, Continuation<? super ZPlanIntimateInfoView$initCoupleAvatarView$1> continuation) {
        super(continuation);
        this.this$0 = zPlanIntimateInfoView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object b06;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        b06 = this.this$0.b0(this);
        return b06;
    }
}
