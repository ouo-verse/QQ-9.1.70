package com.tencent.mobileqq.activity.aio.zplan;

import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;
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
@DebugMetadata(c = "com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$handleSceneTabItemClick$1", f = "ZPlanIntimateInfoView.kt", i = {}, l = {QVipGiftProcessor.CMD}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class ZPlanIntimateInfoView$handleSceneTabItemClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ le3.b $sceneConfig;
    int label;
    final /* synthetic */ ZPlanIntimateInfoView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanIntimateInfoView$handleSceneTabItemClick$1(le3.b bVar, ZPlanIntimateInfoView zPlanIntimateInfoView, Continuation<? super ZPlanIntimateInfoView$handleSceneTabItemClick$1> continuation) {
        super(2, continuation);
        this.$sceneConfig = bVar;
        this.this$0 = zPlanIntimateInfoView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ZPlanIntimateInfoView$handleSceneTabItemClick$1(this.$sceneConfig, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        com.tencent.mobileqq.zplan.aio.couple.i I;
        com.tencent.mobileqq.zplan.aio.couple.i I2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            QLog.i("ZPlanIntimateInfoView", 1, "handleSceneTabItemClick, sceneId:" + this.$sceneConfig.getId() + ", name:" + this.$sceneConfig.getName());
            String k3 = this.$sceneConfig.k();
            if (k3.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                this.this$0.p0(k3);
                I = this.this$0.I();
                if (I != null) {
                    I.a(this.$sceneConfig);
                }
                I2 = this.this$0.I();
                if (I2 != null) {
                    le3.b bVar = this.$sceneConfig;
                    this.label = 1;
                    if (I2.b(bVar, true, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                return Boxing.boxBoolean(false);
            }
        }
        return Boxing.boxBoolean(true);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((ZPlanIntimateInfoView$handleSceneTabItemClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
