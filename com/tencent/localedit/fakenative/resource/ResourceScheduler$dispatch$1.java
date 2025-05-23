package com.tencent.localedit.fakenative.resource;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.localedit.fakenative.resource.ResourceScheduler$dispatch$1", f = "ResourceScheduler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class ResourceScheduler$dispatch$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ c $task;
    int label;
    final /* synthetic */ ResourceScheduler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResourceScheduler$dispatch$1(c cVar, ResourceScheduler resourceScheduler, Continuation<? super ResourceScheduler$dispatch$1> continuation) {
        super(1, continuation);
        this.$task = cVar;
        this.this$0 = resourceScheduler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new ResourceScheduler$dispatch$1(this.$task, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object runBlocking$default;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new ResourceScheduler$dispatch$1$result$1(this.this$0, this.$task, null), 1, null);
            Function1<Object, Unit> a16 = this.$task.a();
            if (a16 != null) {
                a16.invoke(runBlocking$default);
            }
            x11.b.f446855a.d("ResourceScheduler", Intrinsics.stringPlus("task finish in ", Thread.currentThread()));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((ResourceScheduler$dispatch$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
