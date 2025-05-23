package com.tencent.guild.aio.util;

import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback;
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
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/qqnt/msg/api/c;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.util.NTServiceApiKt$getFirstUnreadMsgSeq$1", f = "NTServiceApi.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class NTServiceApiKt$getFirstUnreadMsgSeq$1 extends SuspendLambda implements Function2<ProducerScope<? super com.tencent.qqnt.msg.api.c<Long>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ GProContact $peer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTServiceApiKt$getFirstUnreadMsgSeq$1(GProContact gProContact, Continuation<? super NTServiceApiKt$getFirstUnreadMsgSeq$1> continuation) {
        super(2, continuation);
        this.$peer = gProContact;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Ref.ObjectRef objectRef, int i3, String errMsg, long j3) {
        Function1 function1 = (Function1) objectRef.element;
        if (function1 != null) {
            Long valueOf = Long.valueOf(j3);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            function1.invoke(new com.tencent.qqnt.msg.api.c(valueOf, i3, errMsg));
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        NTServiceApiKt$getFirstUnreadMsgSeq$1 nTServiceApiKt$getFirstUnreadMsgSeq$1 = new NTServiceApiKt$getFirstUnreadMsgSeq$1(this.$peer, continuation);
        nTServiceApiKt$getFirstUnreadMsgSeq$1.L$0 = obj;
        return nTServiceApiKt$getFirstUnreadMsgSeq$1;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.guild.aio.util.NTServiceApiKt$getFirstUnreadMsgSeq$1$callback$1, T] */
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
            objectRef.element = new Function1<com.tencent.qqnt.msg.api.c<Long>, Unit>() { // from class: com.tencent.guild.aio.util.NTServiceApiKt$getFirstUnreadMsgSeq$1$callback$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.msg.api.c<Long> cVar) {
                    invoke2(cVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.qqnt.msg.api.c<Long> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    producerScope.mo2003trySendJP2dKIU(it);
                    SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
                }
            };
            uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
            if (gProGuildMsgService != null) {
                gProGuildMsgService.getFirstUnreadCommonMsg(this.$peer, new IGuildFetchChannelLatestSeqCallback() { // from class: com.tencent.guild.aio.util.u
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback
                    public final void onFetchChannelLatestSeq(int i16, String str, long j3) {
                        NTServiceApiKt$getFirstUnreadMsgSeq$1.b(Ref.ObjectRef.this, i16, str, j3);
                    }
                });
            }
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.guild.aio.util.NTServiceApiKt$getFirstUnreadMsgSeq$1.2
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
    public final Object invoke(@NotNull ProducerScope<? super com.tencent.qqnt.msg.api.c<Long>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NTServiceApiKt$getFirstUnreadMsgSeq$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
