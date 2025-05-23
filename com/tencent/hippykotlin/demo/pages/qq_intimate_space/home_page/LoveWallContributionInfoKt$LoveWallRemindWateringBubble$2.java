package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.animation.b;
import com.tencent.ntcompose.animation.m;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallRemindWateringBubble$2", f = "LoveWallContributionInfo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class LoveWallContributionInfoKt$LoveWallRemindWateringBubble$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Animatable<Float> $opacityAnimation;
    public final /* synthetic */ LoveWallContributionInfoViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoveWallContributionInfoKt$LoveWallRemindWateringBubble$2(Animatable<Float> animatable, LoveWallContributionInfoViewModel loveWallContributionInfoViewModel, Continuation<? super LoveWallContributionInfoKt$LoveWallRemindWateringBubble$2> continuation) {
        super(2, continuation);
        this.$opacityAnimation = animatable;
        this.$viewModel = loveWallContributionInfoViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoveWallContributionInfoKt$LoveWallRemindWateringBubble$2(this.$opacityAnimation, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoveWallContributionInfoKt$LoveWallRemindWateringBubble$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Animatable<Float> animatable = this.$opacityAnimation;
        Float boxFloat = Boxing.boxFloat(0.0f);
        m d16 = b.d(300, 3000, null, null, 12, null);
        final LoveWallContributionInfoViewModel loveWallContributionInfoViewModel = this.$viewModel;
        Animatable.b(animatable, boxFloat, d16, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallRemindWateringBubble$2.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Float f16) {
                f16.floatValue();
                LoveWallContributionInfoViewModel.this.showRemindBubble.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            }
        }, false, 8, null);
        return Unit.INSTANCE;
    }
}
