package com.tencent.mobileqq.guild.aisearch.models;

import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/guild/aisearch/models/d;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$sendMessage$3", f = "AIChatRepository.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class AIChatRepository$sendMessage$3 extends SuspendLambda implements Function2<FlowCollector<? super AiChatSession>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $modelType;
    final /* synthetic */ String $queryMessage;
    final /* synthetic */ String $sessionId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIChatRepository$sendMessage$3(String str, String str2, String str3, Continuation<? super AIChatRepository$sendMessage$3> continuation) {
        super(2, continuation);
        this.$sessionId = str;
        this.$queryMessage = str2;
        this.$modelType = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AIChatRepository$sendMessage$3 aIChatRepository$sendMessage$3 = new AIChatRepository$sendMessage$3(this.$sessionId, this.$queryMessage, this.$modelType, continuation);
        aIChatRepository$sendMessage$3.L$0 = obj;
        return aIChatRepository$sendMessage$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AiChatSession j3;
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
            j3 = AIChatRepository.f214077d.j(AiChatSession.Companion.e(AiChatSession.INSTANCE, this.$sessionId, this.$queryMessage, this.$modelType, 1, null, 16, null));
            this.label = 1;
            if (flowCollector.emit(j3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super AiChatSession> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((AIChatRepository$sendMessage$3) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
