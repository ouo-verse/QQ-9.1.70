package com.tencent.guildlive.aio.input;

import com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guildlive.aio.input.GuildLiveAioInputUIState;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/guild/aio/sendmsg/SendMsgInterceptUtil$a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guildlive.aio.input.GuildLiveAioInputViewModel$sendMsg$1", f = "GuildLiveAioInputViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildLiveAioInputViewModel$sendMsg$1 extends SuspendLambda implements Function2<SendMsgInterceptUtil.SendMsgsRsp, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildLiveAioInputViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.guildlive.aio.input.GuildLiveAioInputViewModel$sendMsg$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function2<com.tencent.aio.msgservice.j<String>, Continuation<? super Unit>, Object>, SuspendFunction {
        AnonymousClass1(Object obj) {
            super(2, obj, GuildLiveAioInputViewModel.class, "handleSendMsgsResp", "handleSendMsgsResp(Lcom/tencent/aio/msgservice/MsgServiceRsp;)V", 4);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull com.tencent.aio.msgservice.j<String> jVar, @NotNull Continuation<? super Unit> continuation) {
            return GuildLiveAioInputViewModel$sendMsg$1.a((GuildLiveAioInputViewModel) this.receiver, jVar, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildLiveAioInputViewModel$sendMsg$1(GuildLiveAioInputViewModel guildLiveAioInputViewModel, Continuation<? super GuildLiveAioInputViewModel$sendMsg$1> continuation) {
        super(2, continuation);
        this.this$0 = guildLiveAioInputViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object a(GuildLiveAioInputViewModel guildLiveAioInputViewModel, com.tencent.aio.msgservice.j jVar, Continuation continuation) {
        guildLiveAioInputViewModel.K(jVar);
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildLiveAioInputViewModel$sendMsg$1 guildLiveAioInputViewModel$sendMsg$1 = new GuildLiveAioInputViewModel$sendMsg$1(this.this$0, continuation);
        guildLiveAioInputViewModel$sendMsg$1.L$0 = obj;
        return guildLiveAioInputViewModel$sendMsg$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull SendMsgInterceptUtil.SendMsgsRsp sendMsgsRsp, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildLiveAioInputViewModel$sendMsg$1) create(sendMsgsRsp, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MsgRecord msgRecord;
        MsgRecord msgRecord2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SendMsgInterceptUtil.SendMsgsRsp sendMsgsRsp = (SendMsgInterceptUtil.SendMsgsRsp) this.L$0;
            if (!sendMsgsRsp.getIsIntercept()) {
                FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.F(sendMsgsRsp.getSendMsgsReq()), new AnonymousClass1(this.this$0)), Dispatchers.getIO()), this.this$0.vmScope());
                this.this$0.x();
                msgRecord = this.this$0.reeditMsg;
                if (msgRecord != null) {
                    GuildLiveAioInputViewModel guildLiveAioInputViewModel = this.this$0;
                    msgRecord2 = guildLiveAioInputViewModel.reeditMsg;
                    Intrinsics.checkNotNull(msgRecord2);
                    guildLiveAioInputViewModel.H(msgRecord2);
                }
                this.this$0.updateUI(new GuildLiveAioInputUIState.SendSuccessUIState());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
