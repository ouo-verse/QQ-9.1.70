package com.tencent.guild.aio.sendmsg;

import android.os.Bundle;
import com.tencent.aio.msgservice.k;
import com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil;
import com.tencent.guild.aio.util.ex.FromScene;
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
import st1.m;
import st1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/guild/aio/sendmsg/SendMsgInterceptUtil$a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil$sendMsgs$1", f = "SendMsgInterceptUtil.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class SendMsgInterceptUtil$sendMsgs$1 extends SuspendLambda implements Function2<ProducerScope<? super SendMsgInterceptUtil.SendMsgsRsp>, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.aio.api.runtime.a $context;
    final /* synthetic */ Bundle $extData;
    final /* synthetic */ k $req;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/guild/aio/sendmsg/SendMsgInterceptUtil$sendMsgs$1$a", "Lcom/tencent/guild/aio/sendmsg/DefaultSendMsgIntercept;", "", "isIntercept", "Lst1/n;", "sendMsgsReq", "Landroid/os/Bundle;", "extData", "", "b", "Ljava/util/ArrayList;", "Lst1/m;", "Lkotlin/collections/ArrayList;", "e", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends DefaultSendMsgIntercept {

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.api.runtime.a f112289h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Function1<SendMsgInterceptUtil.SendMsgsRsp, Unit>> f112290i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(k kVar, com.tencent.aio.api.runtime.a aVar, Bundle bundle, Ref.ObjectRef<Function1<SendMsgInterceptUtil.SendMsgsRsp, Unit>> objectRef) {
            super(kVar, aVar, bundle);
            this.f112289h = aVar;
            this.f112290i = objectRef;
        }

        @Override // st1.k
        public void b(boolean isIntercept, @NotNull n sendMsgsReq, @Nullable Bundle extData) {
            Intrinsics.checkNotNullParameter(sendMsgsReq, "sendMsgsReq");
            Function1<SendMsgInterceptUtil.SendMsgsRsp, Unit> function1 = this.f112290i.element;
            if (function1 != null) {
                function1.invoke(new SendMsgInterceptUtil.SendMsgsRsp(isIntercept, sendMsgsReq, extData));
            }
        }

        @Override // com.tencent.guild.aio.sendmsg.DefaultSendMsgIntercept
        @NotNull
        public ArrayList<m> e() {
            if (com.tencent.guild.aio.util.ex.a.d(this.f112289h) != FromScene.DIRECT.ordinal()) {
                return super.e();
            }
            return new ArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendMsgInterceptUtil$sendMsgs$1(k kVar, com.tencent.aio.api.runtime.a aVar, Bundle bundle, Continuation<? super SendMsgInterceptUtil$sendMsgs$1> continuation) {
        super(2, continuation);
        this.$req = kVar;
        this.$context = aVar;
        this.$extData = bundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SendMsgInterceptUtil$sendMsgs$1 sendMsgInterceptUtil$sendMsgs$1 = new SendMsgInterceptUtil$sendMsgs$1(this.$req, this.$context, this.$extData, continuation);
        sendMsgInterceptUtil$sendMsgs$1.L$0 = obj;
        return sendMsgInterceptUtil$sendMsgs$1;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil$sendMsgs$1$sendMsgsCB$1] */
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
            objectRef.element = new Function1<SendMsgInterceptUtil.SendMsgsRsp, Unit>() { // from class: com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil$sendMsgs$1$sendMsgsCB$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SendMsgInterceptUtil.SendMsgsRsp sendMsgsRsp) {
                    invoke2(sendMsgsRsp);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull SendMsgInterceptUtil.SendMsgsRsp it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    producerScope.mo2003trySendJP2dKIU(it);
                    SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
                }
            };
            new a(this.$req, this.$context, this.$extData, objectRef).h();
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil$sendMsgs$1.2
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
    public final Object invoke(@NotNull ProducerScope<? super SendMsgInterceptUtil.SendMsgsRsp> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SendMsgInterceptUtil$sendMsgs$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
