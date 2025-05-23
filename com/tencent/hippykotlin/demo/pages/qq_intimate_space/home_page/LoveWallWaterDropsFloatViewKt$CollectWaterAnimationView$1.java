package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$CollectWaterAnimationView$1", f = "LoveWallWaterDropsFloatView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class LoveWallWaterDropsFloatViewKt$CollectWaterAnimationView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ WaterDropFloatViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoveWallWaterDropsFloatViewKt$CollectWaterAnimationView$1(WaterDropFloatViewModel waterDropFloatViewModel, Continuation<? super LoveWallWaterDropsFloatViewKt$CollectWaterAnimationView$1> continuation) {
        super(2, continuation);
        this.$viewModel = waterDropFloatViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoveWallWaterDropsFloatViewKt$CollectWaterAnimationView$1(this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoveWallWaterDropsFloatViewKt$CollectWaterAnimationView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        if (this.$viewModel.collectAnimationCount.getValue().intValue() == 0) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.$viewModel.collectAnimations, (Function1) new Function1<CollectAnimation, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$CollectWaterAnimationView$1.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(CollectAnimation collectAnimation) {
                    return Boolean.valueOf(collectAnimation.waitFroRemove);
                }
            });
        }
        return Unit.INSTANCE;
    }
}
