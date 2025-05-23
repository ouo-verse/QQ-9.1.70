package com.tencent.localedit.fakenative.localserver;

import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.meta.ChunkConvertResult;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/localedit/fakenative/meta/ChunkConvertResult;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.localedit.fakenative.localserver.LocalServerRequestHandler$chunkImport$result$1", f = "LocalServerRequestHandler.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class LocalServerRequestHandler$chunkImport$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChunkConvertResult>, Object> {
    final /* synthetic */ int $chunkIndex;
    final /* synthetic */ int $chunkSize;
    final /* synthetic */ String $localFilePath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalServerRequestHandler$chunkImport$result$1(String str, int i3, int i16, Continuation<? super LocalServerRequestHandler$chunkImport$result$1> continuation) {
        super(2, continuation);
        this.$localFilePath = str;
        this.$chunkIndex = i3;
        this.$chunkSize = i16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LocalServerRequestHandler$chunkImport$result$1(this.$localFilePath, this.$chunkIndex, this.$chunkSize, continuation);
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
            String str = this.$localFilePath;
            int i16 = this.$chunkIndex;
            int i17 = this.$chunkSize;
            this.label = 1;
            obj = delegate.a(str, i16, i17, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ChunkConvertResult> continuation) {
        return ((LocalServerRequestHandler$chunkImport$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
