package com.tencent.mobileqq.guild.aisearch.models;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/guild/aisearch/models/h;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$sendMessage$1", f = "AIChatRepository.kt", i = {0}, l = {82, 83}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes12.dex */
public final class AIChatRepository$sendMessage$1 extends SuspendLambda implements Function2<FlowCollector<? super SearchAllGuildAIInfoResponseResult>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $modelType;
    final /* synthetic */ String $queryMessage;
    final /* synthetic */ String $sessionId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIChatRepository$sendMessage$1(String str, String str2, String str3, Continuation<? super AIChatRepository$sendMessage$1> continuation) {
        super(2, continuation);
        this.$queryMessage = str;
        this.$modelType = str2;
        this.$sessionId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AIChatRepository$sendMessage$1 aIChatRepository$sendMessage$1 = new AIChatRepository$sendMessage$1(this.$queryMessage, this.$modelType, this.$sessionId, continuation);
        aIChatRepository$sendMessage$1.L$0 = obj;
        return aIChatRepository$sendMessage$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        Object s16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            s16 = ((Result) obj).getValue();
        } else {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            AIChatRepository aIChatRepository = AIChatRepository.f214077d;
            String str = this.$queryMessage;
            String str2 = this.$modelType;
            String str3 = this.$sessionId;
            this.L$0 = flowCollector;
            this.label = 1;
            s16 = aIChatRepository.s(str, str2, str3, this);
            if (s16 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (Result.m482isFailureimpl(s16)) {
            s16 = null;
        }
        SearchAllGuildAIInfoResponseResult searchAllGuildAIInfoResponseResult = (SearchAllGuildAIInfoResponseResult) s16;
        if (searchAllGuildAIInfoResponseResult == null) {
            return Unit.INSTANCE;
        }
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit(searchAllGuildAIInfoResponseResult, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super SearchAllGuildAIInfoResponseResult> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((AIChatRepository$sendMessage$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
