package com.tencent.qqguild.directmessage.aio.input.mixin;

import com.tencent.aio.msgservice.j;
import com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqguild.directmessage.aio.input.mixin.AioMessageSenderMixinKt$sendMessage$5", f = "AioMessageSenderMixin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes22.dex */
public final class AioMessageSenderMixinKt$sendMessage$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ Flow<SendMsgInterceptUtil.SendMsgsRsp> $messageFlow;
    final /* synthetic */ Function0<Unit> $onInterrupt;
    final /* synthetic */ Function1<j<String>, Unit> $onSendResult;
    final /* synthetic */ Function0<Unit> $onSendStart;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/guild/aio/sendmsg/SendMsgInterceptUtil$a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqguild.directmessage.aio.input.mixin.AioMessageSenderMixinKt$sendMessage$5$1", f = "AioMessageSenderMixin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqguild.directmessage.aio.input.mixin.AioMessageSenderMixinKt$sendMessage$5$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<SendMsgInterceptUtil.SendMsgsRsp, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ Function0<Unit> $onInterrupt;
        final /* synthetic */ Function1<j<String>, Unit> $onSendResult;
        final /* synthetic */ Function0<Unit> $onSendStart;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function0<Unit> function0, CoroutineScope coroutineScope, Function1<? super j<String>, Unit> function1, Function0<Unit> function02, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$onInterrupt = function0;
            this.$$this$coroutineScope = coroutineScope;
            this.$onSendResult = function1;
            this.$onSendStart = function02;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onInterrupt, this.$$this$coroutineScope, this.$onSendResult, this.$onSendStart, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull SendMsgInterceptUtil.SendMsgsRsp sendMsgsRsp, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sendMsgsRsp, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SendMsgInterceptUtil.SendMsgsRsp sendMsgsRsp = (SendMsgInterceptUtil.SendMsgsRsp) this.L$0;
                if (!sendMsgsRsp.getIsIntercept()) {
                    AioMessageSenderMixinKt.b(this.$$this$coroutineScope, sendMsgsRsp, this.$onSendResult, this.$onSendStart);
                } else {
                    this.$onInterrupt.invoke();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AioMessageSenderMixinKt$sendMessage$5(Flow<SendMsgInterceptUtil.SendMsgsRsp> flow, Function0<Unit> function0, Function1<? super j<String>, Unit> function1, Function0<Unit> function02, Continuation<? super AioMessageSenderMixinKt$sendMessage$5> continuation) {
        super(2, continuation);
        this.$messageFlow = flow;
        this.$onInterrupt = function0;
        this.$onSendResult = function1;
        this.$onSendStart = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AioMessageSenderMixinKt$sendMessage$5 aioMessageSenderMixinKt$sendMessage$5 = new AioMessageSenderMixinKt$sendMessage$5(this.$messageFlow, this.$onInterrupt, this.$onSendResult, this.$onSendStart, continuation);
        aioMessageSenderMixinKt$sendMessage$5.L$0 = obj;
        return aioMessageSenderMixinKt$sendMessage$5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            return FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(this.$messageFlow, new AnonymousClass1(this.$onInterrupt, coroutineScope, this.$onSendResult, this.$onSendStart, null)), Dispatchers.getMain()), coroutineScope);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Job> continuation) {
        return ((AioMessageSenderMixinKt$sendMessage$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
