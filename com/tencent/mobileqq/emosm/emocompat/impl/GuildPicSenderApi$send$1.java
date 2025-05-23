package com.tencent.mobileqq.emosm.emocompat.impl;

import com.tencent.aio.msgservice.j;
import com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/guild/aio/sendmsg/SendMsgInterceptUtil$a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.emosm.emocompat.impl.GuildPicSenderApi$send$1", f = "GuildPicSenderApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildPicSenderApi$send$1 extends SuspendLambda implements Function2<SendMsgInterceptUtil.SendMsgsRsp, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/aio/msgservice/j;", "", "rsp", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.emosm.emocompat.impl.GuildPicSenderApi$send$1$1", f = "GuildPicSenderApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.emosm.emocompat.impl.GuildPicSenderApi$send$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<j<String>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull j<String> jVar, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(jVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                j jVar = (j) this.L$0;
                QLog.i("GuildPicSenderApi", 4, "MessageForPic result=" + jVar.c() + " errMsg=" + jVar.b());
                GuildPicSenderApi.f204282a.d(jVar.c());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildPicSenderApi$send$1(Continuation<? super GuildPicSenderApi$send$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildPicSenderApi$send$1 guildPicSenderApi$send$1 = new GuildPicSenderApi$send$1(continuation);
        guildPicSenderApi$send$1.L$0 = obj;
        return guildPicSenderApi$send$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull SendMsgInterceptUtil.SendMsgsRsp sendMsgsRsp, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildPicSenderApi$send$1) create(sendMsgsRsp, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SendMsgInterceptUtil.SendMsgsRsp sendMsgsRsp = (SendMsgInterceptUtil.SendMsgsRsp) this.L$0;
            QLog.i("GuildPicSenderApi", 1, "isIntercept=" + sendMsgsRsp.getIsIntercept());
            if (!sendMsgsRsp.getIsIntercept()) {
                FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.F(sendMsgsRsp.getSendMsgsReq()), new AnonymousClass1(null)), Dispatchers.getMain()), GlobalScope.INSTANCE);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
