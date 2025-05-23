package com.tencent.mobileqq.guild.aisearch.models;

import com.tencent.mobileqq.guild.aisearch.models.i;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetSessionMsgListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSessionMsg;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.bk;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/guild/aisearch/models/d;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$loadMsgListFromServer$1", f = "AIChatRepository.kt", i = {}, l = {319}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class AIChatRepository$loadMsgListFromServer$1 extends SuspendLambda implements Function2<ProducerScope<? super AiChatSession>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatUuid;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/aisearch/models/AIChatRepository$loadMsgListFromServer$1$a", "Lwh2/bk;", "", "result", "", "errMsg", "", QAdRewardDefine$VideoParams.ISCACHE, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAISearchGetSessionMsgListRsp;", "rsp", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements bk {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f214102a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProducerScope<AiChatSession> f214103b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f214104c;

        /* JADX WARN: Multi-variable type inference failed */
        a(Ref.BooleanRef booleanRef, ProducerScope<? super AiChatSession> producerScope, String str) {
            this.f214102a = booleanRef;
            this.f214103b = producerScope;
            this.f214104c = str;
        }

        @Override // wh2.bk
        public void a(int result, @Nullable String errMsg, boolean isCache, @Nullable IGProAISearchGetSessionMsgListRsp rsp) {
            boolean l3;
            boolean z16;
            List i3;
            String str = errMsg;
            Logger logger = Logger.f235387a;
            Ref.BooleanRef booleanRef = this.f214102a;
            logger.d().i("AIChatRepository", 1, "loadMsgList: result=" + result + ", errMsg=" + str + ", isCache=" + isCache + ", isCanceled=" + booleanRef.element + ", rsp=" + rsp);
            if (this.f214102a.element) {
                return;
            }
            if (str == null) {
                str = "";
            }
            ri1.a error = ri1.a.c(result, str, rsp);
            AIChatRepository aIChatRepository = AIChatRepository.f214077d;
            ProducerScope<AiChatSession> producerScope = this.f214103b;
            String str2 = this.f214104c;
            Intrinsics.checkNotNullExpressionValue(error, "error");
            l3 = aIChatRepository.l(producerScope, str2, error, "loadMsgListFromServer");
            if (l3) {
                return;
            }
            if (rsp != null) {
                ArrayList<IGProAISearchSessionMsg> sessionMsgList = rsp.getSessionMsgList();
                if (sessionMsgList != null && !sessionMsgList.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16 && isCache) {
                    Logger.b bVar = new Logger.b();
                    bVar.a().add("loadMsgList: sessionMsgList from cache is empty");
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("AIChatRepository", 1, (String) it.next(), null);
                    }
                    this.f214103b.mo2003trySendJP2dKIU(null);
                    return;
                }
                ProducerScope<AiChatSession> producerScope2 = this.f214103b;
                i3 = aIChatRepository.i(rsp);
                producerScope2.mo2003trySendJP2dKIU(new AiChatSession(this.f214104c, i3, 0, i.d.f214154a, rsp.getCookie(), rsp.getIsFinished(), 4, null));
                if (!isCache) {
                    SendChannel.DefaultImpls.close$default(this.f214103b, null, 1, null);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIChatRepository$loadMsgListFromServer$1(String str, Continuation<? super AIChatRepository$loadMsgListFromServer$1> continuation) {
        super(2, continuation);
        this.$chatUuid = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AIChatRepository$loadMsgListFromServer$1 aIChatRepository$loadMsgListFromServer$1 = new AIChatRepository$loadMsgListFromServer$1(this.$chatUuid, continuation);
        aIChatRepository$loadMsgListFromServer$1.L$0 = obj;
        return aIChatRepository$loadMsgListFromServer$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IGPSService k3;
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
            ProducerScope producerScope = (ProducerScope) this.L$0;
            com.tencent.mobileqq.qqguildsdk.data.genc.d dVar = new com.tencent.mobileqq.qqguildsdk.data.genc.d();
            String str = this.$chatUuid;
            com.tencent.mobileqq.qqguildsdk.data.genc.g gVar = new com.tencent.mobileqq.qqguildsdk.data.genc.g();
            gVar.e(str);
            gVar.d(0);
            dVar.e(gVar);
            dVar.d(1);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            k3 = AIChatRepository.f214077d.k();
            k3.getAISearchSessionMsgList(dVar, true, new a(booleanRef, producerScope, this.$chatUuid));
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$loadMsgListFromServer$1.2
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
                    Ref.BooleanRef.this.element = true;
                    Logger.f235387a.d().i("AIChatRepository", 1, "loadMsgListFromServer: awaitClose");
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
    public final Object invoke(@NotNull ProducerScope<? super AiChatSession> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AIChatRepository$loadMsgListFromServer$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
