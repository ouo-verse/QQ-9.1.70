package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$1", f = "LoveWallWaterDropsFloatView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ LoveWallHomepageViewModel $homepageViewModel;
    public final /* synthetic */ Function0<Unit> $showWaterBubbleFun;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$1(LoveWallHomepageViewModel loveWallHomepageViewModel, Function0<Unit> function0, Continuation<? super LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$1> continuation) {
        super(2, continuation);
        this.$homepageViewModel = loveWallHomepageViewModel;
        this.$showWaterBubbleFun = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$1(this.$homepageViewModel, this.$showWaterBubbleFun, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        if (this.$homepageViewModel.unfoldAllWaterBubbles.getValue().booleanValue()) {
            this.$showWaterBubbleFun.invoke();
        }
        return Unit.INSTANCE;
    }
}
