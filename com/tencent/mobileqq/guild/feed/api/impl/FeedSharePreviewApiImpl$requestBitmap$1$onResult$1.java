package com.tencent.mobileqq.guild.feed.api.impl;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.guild.feed.api.IFeedSharePreviewApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.FeedSharePreviewApiImpl$requestBitmap$1$onResult$1", f = "FeedSharePreviewApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedSharePreviewApiImpl$requestBitmap$1$onResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFeedSharePreviewApi.a<Bitmap> $callback;
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedSharePreviewApiImpl$requestBitmap$1$onResult$1(IFeedSharePreviewApi.a<Bitmap> aVar, View view, Continuation<? super FeedSharePreviewApiImpl$requestBitmap$1$onResult$1> continuation) {
        super(2, continuation);
        this.$callback = aVar;
        this.$view = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedSharePreviewApiImpl$requestBitmap$1$onResult$1 feedSharePreviewApiImpl$requestBitmap$1$onResult$1 = new FeedSharePreviewApiImpl$requestBitmap$1$onResult$1(this.$callback, this.$view, continuation);
        feedSharePreviewApiImpl$requestBitmap$1$onResult$1.L$0 = obj;
        return feedSharePreviewApiImpl$requestBitmap$1$onResult$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m476constructorimpl;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            View view = this.$view;
            try {
                Result.Companion companion = Result.INSTANCE;
                view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
                view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                m476constructorimpl = Result.m476constructorimpl(com.tencent.mobileqq.guild.base.extension.t.h(view));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            this.$callback.onResult(m476constructorimpl);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedSharePreviewApiImpl$requestBitmap$1$onResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
