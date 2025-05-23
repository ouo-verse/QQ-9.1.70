package com.tencent.mobileqq.guild.aisearch.models;

import com.tencent.mobileqq.guild.aisearch.models.a;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$retryLastMessage$1", f = "AIChatRepository.kt", i = {0}, l = {123, 124}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes12.dex */
public final class AIChatRepository$retryLastMessage$1 extends SuspendLambda implements Function2<FlowCollector<? super SearchAllGuildAIInfoResponseResult>, Continuation<? super Unit>, Object> {
    final /* synthetic */ a.AnswerItem $lastAnswerItem;
    final /* synthetic */ a.QuestionItem $lastQuery;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIChatRepository$retryLastMessage$1(a.QuestionItem questionItem, a.AnswerItem answerItem, Continuation<? super AIChatRepository$retryLastMessage$1> continuation) {
        super(2, continuation);
        this.$lastQuery = questionItem;
        this.$lastAnswerItem = answerItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AIChatRepository$retryLastMessage$1 aIChatRepository$retryLastMessage$1 = new AIChatRepository$retryLastMessage$1(this.$lastQuery, this.$lastAnswerItem, continuation);
        aIChatRepository$retryLastMessage$1.L$0 = obj;
        return aIChatRepository$retryLastMessage$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        Object t16;
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
            t16 = ((Result) obj).getValue();
        } else {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            AIChatRepository aIChatRepository = AIChatRepository.f214077d;
            String question = this.$lastQuery.getQuestion();
            String modelType = this.$lastAnswerItem.getModelType();
            this.L$0 = flowCollector;
            this.label = 1;
            t16 = AIChatRepository.t(aIChatRepository, question, modelType, null, this, 4, null);
            if (t16 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (Result.m482isFailureimpl(t16)) {
            t16 = null;
        }
        SearchAllGuildAIInfoResponseResult searchAllGuildAIInfoResponseResult = (SearchAllGuildAIInfoResponseResult) t16;
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
        return ((AIChatRepository$retryLastMessage$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
