package com.tencent.guild.api.msg.service;

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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/aio/msgservice/j;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.api.msg.service.ChannelAIOMsgService$sendMsgs$2", f = "ChannelAIOMsgService.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ChannelAIOMsgService$sendMsgs$2 extends SuspendLambda implements Function2<ProducerScope<? super com.tencent.aio.msgservice.j<String>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Function1<com.tencent.aio.msgservice.j<String>, Unit>> $sendMsgsCB;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelAIOMsgService$sendMsgs$2(Ref.ObjectRef<Function1<com.tencent.aio.msgservice.j<String>, Unit>> objectRef, Continuation<? super ChannelAIOMsgService$sendMsgs$2> continuation) {
        super(2, continuation);
        this.$sendMsgsCB = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelAIOMsgService$sendMsgs$2 channelAIOMsgService$sendMsgs$2 = new ChannelAIOMsgService$sendMsgs$2(this.$sendMsgsCB, continuation);
        channelAIOMsgService$sendMsgs$2.L$0 = obj;
        return channelAIOMsgService$sendMsgs$2;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.guild.api.msg.service.ChannelAIOMsgService$sendMsgs$2$1, T] */
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
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            this.$sendMsgsCB.element = new Function1<com.tencent.aio.msgservice.j<String>, Unit>() { // from class: com.tencent.guild.api.msg.service.ChannelAIOMsgService$sendMsgs$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.aio.msgservice.j<String> jVar) {
                    invoke2(jVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.aio.msgservice.j<String> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    producerScope.mo2003trySendJP2dKIU(it);
                    SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
                }
            };
            final Ref.ObjectRef<Function1<com.tencent.aio.msgservice.j<String>, Unit>> objectRef = this.$sendMsgsCB;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.guild.api.msg.service.ChannelAIOMsgService$sendMsgs$2.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    objectRef.element = null;
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super com.tencent.aio.msgservice.j<String>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelAIOMsgService$sendMsgs$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
