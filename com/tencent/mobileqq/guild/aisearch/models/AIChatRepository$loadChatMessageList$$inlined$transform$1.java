package com.tencent.mobileqq.guild.aisearch.models;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@\u00a8\u0006\u0004"}, d2 = {"T", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/FlowCollector;", "", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$loadChatMessageList$$inlined$transform$1", f = "AIChatRepository.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class AIChatRepository$loadChatMessageList$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super AiChatSession>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sessionId$inlined;
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements FlowCollector<AiChatSession> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FlowCollector f214083d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f214084e;

        public a(FlowCollector flowCollector, String str) {
            this.f214084e = str;
            this.f214083d = flowCollector;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(AiChatSession aiChatSession, @NotNull Continuation continuation) {
            AiChatSession j3;
            Object coroutine_suspended;
            LinkedHashMap linkedHashMap;
            Object coroutine_suspended2;
            FlowCollector flowCollector = this.f214083d;
            AiChatSession aiChatSession2 = aiChatSession;
            if (aiChatSession2 == null) {
                linkedHashMap = AIChatRepository.sessionCache;
                Object obj = linkedHashMap.get(this.f214084e);
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "loadMsgList: session is null, use local cache " + ((AiChatSession) obj);
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("AIChatRepository", 1, (String) it.next(), null);
                }
                Object emit = flowCollector.emit(obj, continuation);
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (emit == coroutine_suspended2) {
                    return emit;
                }
            } else {
                j3 = AIChatRepository.f214077d.j(aiChatSession2);
                Object emit2 = flowCollector.emit(j3, continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (emit2 == coroutine_suspended) {
                    return emit2;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIChatRepository$loadChatMessageList$$inlined$transform$1(Flow flow, Continuation continuation, String str) {
        super(2, continuation);
        this.$this_transform = flow;
        this.$sessionId$inlined = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AIChatRepository$loadChatMessageList$$inlined$transform$1 aIChatRepository$loadChatMessageList$$inlined$transform$1 = new AIChatRepository$loadChatMessageList$$inlined$transform$1(this.$this_transform, continuation, this.$sessionId$inlined);
        aIChatRepository$loadChatMessageList$$inlined$transform$1.L$0 = obj;
        return aIChatRepository$loadChatMessageList$$inlined$transform$1;
    }

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
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow flow = this.$this_transform;
            a aVar = new a(flowCollector, this.$sessionId$inlined);
            this.label = 1;
            if (flow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super AiChatSession> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((AIChatRepository$loadChatMessageList$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
