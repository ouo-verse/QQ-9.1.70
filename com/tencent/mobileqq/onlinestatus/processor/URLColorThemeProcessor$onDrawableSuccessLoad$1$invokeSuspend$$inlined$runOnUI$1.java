package com.tencent.mobileqq.onlinestatus.processor;

import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.processor.URLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$1", f = "URLColorThemeProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class URLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ URLColorThemeProcessor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public URLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$1(Continuation continuation, URLColorThemeProcessor uRLColorThemeProcessor) {
        super(2, continuation);
        this.this$0 = uRLColorThemeProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new URLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$1(continuation, this.this$0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.k();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((URLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
