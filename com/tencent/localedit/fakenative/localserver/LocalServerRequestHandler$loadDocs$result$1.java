package com.tencent.localedit.fakenative.localserver;

import com.tencent.localedit.fakenative.meta.FileIORequestData;
import com.tencent.localedit.fakenative.preload.FilePreloadManager;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.localedit.fakenative.localserver.LocalServerRequestHandler$loadDocs$result$1", f = "LocalServerRequestHandler.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class LocalServerRequestHandler$loadDocs$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ FileIORequestData $info;
    int label;
    final /* synthetic */ LocalServerRequestHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalServerRequestHandler$loadDocs$result$1(LocalServerRequestHandler localServerRequestHandler, FileIORequestData fileIORequestData, Continuation<? super LocalServerRequestHandler$loadDocs$result$1> continuation) {
        super(2, continuation);
        this.this$0 = localServerRequestHandler;
        this.$info = fileIORequestData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LocalServerRequestHandler$loadDocs$result$1(this.this$0, this.$info, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FilePreloadManager d16;
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
            d16 = this.this$0.d();
            String globalPadId = this.$info.getGlobalPadId();
            this.label = 1;
            obj = d16.getLoadDocsResult(globalPadId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((LocalServerRequestHandler$loadDocs$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
