package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.MutableState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleConfig;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleStatus;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.FoldAnimation;
import e25.a;
import e25.b;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$2", f = "LoveWallWaterDropsFloatView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MutableState<BubbleViewModel> $bubbleViewModel;
    public final /* synthetic */ WaterDropViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$2(MutableState<BubbleViewModel> mutableState, WaterDropViewModel waterDropViewModel, Continuation<? super LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$2> continuation) {
        super(2, continuation);
        this.$bubbleViewModel = mutableState;
        this.$viewModel = waterDropViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$2(this.$bubbleViewModel, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoveWallWaterDropsFloatViewKt$WaterDropWithBubbleView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        b bVar;
        String str3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        a value = this.$bubbleViewModel.getValue().bubbleTips.getValue();
        BubbleViewModel value2 = this.$bubbleViewModel.getValue();
        float floatValue = this.$viewModel.width.getValue().floatValue();
        FoldAnimation foldAnimation = new FoldAnimation();
        if (value == null || (str = value.f395423e) == null) {
            str = "";
        }
        if (value == null || (str2 = value.f395424f) == null) {
            str2 = "";
        }
        value2.updateBubbleConfig(new BubbleConfig(floatValue, foldAnimation, str, str2, this.$viewModel.triangleDirection.getValue(), BubbleStatus.START_FOLD, (value == null || (bVar = value.f395425h) == null || (str3 = bVar.f395469e) == null) ? "" : str3, 57950));
        return Unit.INSTANCE;
    }
}
