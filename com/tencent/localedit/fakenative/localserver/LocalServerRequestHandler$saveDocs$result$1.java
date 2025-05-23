package com.tencent.localedit.fakenative.localserver;

import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.meta.CommonConvertResult;
import com.tencent.localedit.fakenative.meta.SaveConvertOptions;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/localedit/fakenative/meta/CommonConvertResult;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.localedit.fakenative.localserver.LocalServerRequestHandler$saveDocs$result$1", f = "LocalServerRequestHandler.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class LocalServerRequestHandler$saveDocs$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CommonConvertResult>, Object> {
    final /* synthetic */ SaveConvertOptions $option;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalServerRequestHandler$saveDocs$result$1(SaveConvertOptions saveConvertOptions, Continuation<? super LocalServerRequestHandler$saveDocs$result$1> continuation) {
        super(2, continuation);
        this.$option = saveConvertOptions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LocalServerRequestHandler$saveDocs$result$1(this.$option, continuation);
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
            com.tencent.localedit.fakenative.convert.a delegate = LocalEditSDK.INSTANCE.getConvert().getDelegate();
            SaveConvertOptions saveConvertOptions = this.$option;
            this.label = 1;
            obj = delegate.f(saveConvertOptions, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super CommonConvertResult> continuation) {
        return ((LocalServerRequestHandler$saveDocs$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
