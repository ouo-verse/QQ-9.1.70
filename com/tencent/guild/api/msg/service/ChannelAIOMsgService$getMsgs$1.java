package com.tencent.guild.api.msg.service;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.api.msg.service.ChannelAIOMsgService$getMsgs$1", f = "ChannelAIOMsgService.kt", i = {}, l = {229}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ChannelAIOMsgService$getMsgs$1 extends SuspendLambda implements Function2<ProducerScope<? super com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.aio.msgservice.f $req;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelAIOMsgService$getMsgs$1(com.tencent.aio.msgservice.f fVar, Continuation<? super ChannelAIOMsgService$getMsgs$1> continuation) {
        super(2, continuation);
        this.$req = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Ref.ObjectRef objectRef, int i3, String str, ArrayList msgList) {
        boolean z16;
        Function1 function1 = (Function1) objectRef.element;
        if (function1 != null) {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            l lVar = l.f112634a;
            Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
            function1.invoke(new com.tencent.aio.msgservice.h(z16, i3, str, lVar.g(msgList)));
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelAIOMsgService$getMsgs$1 channelAIOMsgService$getMsgs$1 = new ChannelAIOMsgService$getMsgs$1(this.$req, continuation);
        channelAIOMsgService$getMsgs$1.L$0 = obj;
        return channelAIOMsgService$getMsgs$1;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, com.tencent.guild.api.msg.service.ChannelAIOMsgService$getMsgs$1$callback$1] */
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
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new Function1<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Unit>() { // from class: com.tencent.guild.api.msg.service.ChannelAIOMsgService$getMsgs$1$callback$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar) {
                    invoke2(hVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    producerScope.mo2003trySendJP2dKIU(it);
                    SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
                }
            };
            ((IMsgService) QRoute.api(IMsgService.class)).getMsgs(l.f112634a.c(this.$req.a()), this.$req.c(), this.$req.b(), this.$req.d(), new IMsgOperateCallback() { // from class: com.tencent.guild.api.msg.service.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i16, String str, ArrayList arrayList) {
                    ChannelAIOMsgService$getMsgs$1.b(Ref.ObjectRef.this, i16, str, arrayList);
                }
            });
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.guild.api.msg.service.ChannelAIOMsgService$getMsgs$1.2
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
    public final Object invoke(@NotNull ProducerScope<? super com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelAIOMsgService$getMsgs$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
