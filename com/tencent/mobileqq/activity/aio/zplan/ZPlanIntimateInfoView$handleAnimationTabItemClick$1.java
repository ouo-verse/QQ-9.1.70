package com.tencent.mobileqq.activity.aio.zplan;

import com.tencent.mobileqq.zplan.show.IZPlanMsgService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$handleAnimationTabItemClick$1", f = "ZPlanIntimateInfoView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class ZPlanIntimateInfoView$handleAnimationTabItemClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ le3.b $actionConfig;
    int label;
    final /* synthetic */ ZPlanIntimateInfoView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanIntimateInfoView$handleAnimationTabItemClick$1(le3.b bVar, ZPlanIntimateInfoView zPlanIntimateInfoView, Continuation<? super ZPlanIntimateInfoView$handleAnimationTabItemClick$1> continuation) {
        super(2, continuation);
        this.$actionConfig = bVar;
        this.this$0 = zPlanIntimateInfoView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ZPlanIntimateInfoView$handleAnimationTabItemClick$1(this.$actionConfig, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        com.tencent.mobileqq.zplan.aio.couple.i I;
        IZPlanMsgService iZPlanMsgService;
        String str;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("ZPlanIntimateInfoView", 1, "handleAnimationTabItemClick, name:" + this.$actionConfig.getName() + ", type:" + this.$actionConfig.getActionType() + ", masterActionId:" + this.$actionConfig.getId() + ", guestActionId:" + this.$actionConfig.b());
            I = this.this$0.I();
            if (I != null) {
                I.n(this.$actionConfig);
            }
            if (!this.$actionConfig.a() || this.$actionConfig.e()) {
                iZPlanMsgService = this.this$0.messageService;
                str = this.this$0.friendUin;
                iZPlanMsgService.sendActionMsg(str, new IZPlanMsgService.ZPlanActionMsg(this.$actionConfig.getId(), this.$actionConfig.b(), this.$actionConfig.getActionType(), this.$actionConfig.getName()));
            }
            return Boxing.boxBoolean(true);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((ZPlanIntimateInfoView$handleAnimationTabItemClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
