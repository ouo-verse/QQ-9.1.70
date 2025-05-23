package com.tencent.qqguild.directmessage.aio.input.mixin;

import com.tencent.aio.msgservice.j;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/aio/msgservice/j;", "", "resp", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqguild.directmessage.aio.input.mixin.AioMessageSenderMixinKt$realSendMessage$1", f = "AioMessageSenderMixin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes22.dex */
final class AioMessageSenderMixinKt$realSendMessage$1 extends SuspendLambda implements Function2<j<String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<j<String>, Unit> $onSendResult;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AioMessageSenderMixinKt$realSendMessage$1(Function1<? super j<String>, Unit> function1, Continuation<? super AioMessageSenderMixinKt$realSendMessage$1> continuation) {
        super(2, continuation);
        this.$onSendResult = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AioMessageSenderMixinKt$realSendMessage$1 aioMessageSenderMixinKt$realSendMessage$1 = new AioMessageSenderMixinKt$realSendMessage$1(this.$onSendResult, continuation);
        aioMessageSenderMixinKt$realSendMessage$1.L$0 = obj;
        return aioMessageSenderMixinKt$realSendMessage$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull j<String> jVar, @Nullable Continuation<? super Unit> continuation) {
        return ((AioMessageSenderMixinKt$realSendMessage$1) create(jVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$onSendResult.invoke((j) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
