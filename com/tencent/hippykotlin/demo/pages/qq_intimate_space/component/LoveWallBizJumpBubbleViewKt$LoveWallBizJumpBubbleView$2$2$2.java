package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.animation.m;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import yo3.Offset;
import yo3.Size;
import yo3.b;
import yo3.c;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2$2$2", f = "LoveWallBizJumpBubbleView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ BubbleConfig $config;
    public final /* synthetic */ FoldAnimation $foldAnimation;
    public final /* synthetic */ Animatable<b> $rectAnimation;
    public final /* synthetic */ BubbleViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2$2$2(BubbleViewModel bubbleViewModel, Animatable<b> animatable, BubbleConfig bubbleConfig, FoldAnimation foldAnimation, Continuation<? super LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2$2$2> continuation) {
        super(2, continuation);
        this.$viewModel = bubbleViewModel;
        this.$rectAnimation = animatable;
        this.$config = bubbleConfig;
        this.$foldAnimation = foldAnimation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2$2$2(this.$viewModel, this.$rectAnimation, this.$config, this.$foldAnimation, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2$2$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        this.$viewModel.bubbleStatus.setValue(BubbleStatus.UNFOLDING);
        Animatable<b> animatable = this.$rectAnimation;
        Offset offset = new Offset(0.0f, 0.0f);
        BubbleConfig bubbleConfig = this.$config;
        b a16 = c.a(offset, new Size(bubbleConfig.bubbleUnfoldWidth, bubbleConfig.bubbleContainerHeight));
        this.$foldAnimation.getClass();
        m d16 = com.tencent.ntcompose.animation.b.d(300, 0, null, null, 14, null);
        final BubbleViewModel bubbleViewModel = this.$viewModel;
        Animatable.b(animatable, a16, d16, new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2$2$2.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(b bVar) {
                BubbleViewModel.this.bubbleStatus.setValue(BubbleStatus.START_FOLD);
                return Unit.INSTANCE;
            }
        }, false, 8, null);
        return Unit.INSTANCE;
    }
}
