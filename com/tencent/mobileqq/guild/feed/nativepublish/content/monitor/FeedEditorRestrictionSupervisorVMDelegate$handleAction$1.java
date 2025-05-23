package com.tencent.mobileqq.guild.feed.nativepublish.content.monitor;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u000b\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorVMDelegate$handleAction$1", f = "FeedEditorRestrictionSupervisorVMDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedEditorRestrictionSupervisorVMDelegate$handleAction$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ FeedEditorRestrictionSupervisorVMDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorRestrictionSupervisorVMDelegate$handleAction$1(FeedEditorRestrictionSupervisorVMDelegate feedEditorRestrictionSupervisorVMDelegate, Continuation<? super FeedEditorRestrictionSupervisorVMDelegate$handleAction$1> continuation) {
        super(1, continuation);
        this.this$0 = feedEditorRestrictionSupervisorVMDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new FeedEditorRestrictionSupervisorVMDelegate$handleAction$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean l3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            l3 = this.this$0.l(true);
            return Boxing.boxBoolean(l3);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public final Object invoke(@Nullable Continuation<? super Boolean> continuation) {
        return ((FeedEditorRestrictionSupervisorVMDelegate$handleAction$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
