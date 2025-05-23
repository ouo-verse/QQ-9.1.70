package com.tencent.mobileqq.activity.aio.zplan;

import com.tencent.luggage.wxa.ig.s;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView", f = "ZPlanIntimateInfoView.kt", i = {0, 0}, l = {s.CTRL_INDEX}, m = "checkNeedInitIntimateBg", n = {"this", "lastSceneId"}, s = {"L$0", "L$1"})
/* loaded from: classes10.dex */
public final class ZPlanIntimateInfoView$checkNeedInitIntimateBg$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanIntimateInfoView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanIntimateInfoView$checkNeedInitIntimateBg$1(ZPlanIntimateInfoView zPlanIntimateInfoView, Continuation<? super ZPlanIntimateInfoView$checkNeedInitIntimateBg$1> continuation) {
        super(continuation);
        this.this$0 = zPlanIntimateInfoView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object E;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        E = this.this$0.E(this);
        return E;
    }
}
