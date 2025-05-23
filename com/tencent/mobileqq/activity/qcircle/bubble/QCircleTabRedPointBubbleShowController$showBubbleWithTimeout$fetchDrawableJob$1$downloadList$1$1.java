package com.tencent.mobileqq.activity.qcircle.bubble;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/graphics/drawable/Drawable;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleShowController$showBubbleWithTimeout$fetchDrawableJob$1$downloadList$1$1", f = "QCircleTabRedPointBubbleShowController.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
final class QCircleTabRedPointBubbleShowController$showBubbleWithTimeout$fetchDrawableJob$1$downloadList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Drawable>, Object> {
    final /* synthetic */ String $url;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleTabRedPointBubbleShowController$showBubbleWithTimeout$fetchDrawableJob$1$downloadList$1$1(String str, Continuation<? super QCircleTabRedPointBubbleShowController$showBubbleWithTimeout$fetchDrawableJob$1$downloadList$1$1> continuation) {
        super(2, continuation);
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QCircleTabRedPointBubbleShowController$showBubbleWithTimeout$fetchDrawableJob$1$downloadList$1$1(this.$url, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            QCircleTabRedPointBubbleShowController qCircleTabRedPointBubbleShowController = QCircleTabRedPointBubbleShowController.f184502a;
            String url = this.$url;
            Intrinsics.checkNotNullExpressionValue(url, "url");
            this.label = 1;
            obj = qCircleTabRedPointBubbleShowController.s(url, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Drawable> continuation) {
        return ((QCircleTabRedPointBubbleShowController$showBubbleWithTimeout$fetchDrawableJob$1$downloadList$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
