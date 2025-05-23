package com.tencent.mobileqq.guild.aisearch;

import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/d;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.AIChatListViewModel$submitChat$2", f = "AIChatListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class AIChatListViewModel$submitChat$2 extends SuspendLambda implements Function2<AiChatSession, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sessionId;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIChatListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIChatListViewModel$submitChat$2(String str, AIChatListViewModel aIChatListViewModel, Continuation<? super AIChatListViewModel$submitChat$2> continuation) {
        super(2, continuation);
        this.$sessionId = str;
        this.this$0 = aIChatListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AIChatListViewModel$submitChat$2 aIChatListViewModel$submitChat$2 = new AIChatListViewModel$submitChat$2(this.$sessionId, this.this$0, continuation);
        aIChatListViewModel$submitChat$2.L$0 = obj;
        return aIChatListViewModel$submitChat$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@Nullable AiChatSession aiChatSession, @Nullable Continuation<? super Unit> continuation) {
        return ((AIChatListViewModel$submitChat$2) create(aiChatSession, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableStateFlow mutableStateFlow;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AiChatSession aiChatSession = (AiChatSession) this.L$0;
            Logger logger = Logger.f235387a;
            String str = this.$sessionId;
            logger.d().i("AIChatListViewModel", 1, "submitChat(" + str + "): success: " + aiChatSession);
            if (aiChatSession != null) {
                mutableStateFlow = this.this$0._aiChatSession;
                mutableStateFlow.setValue(aiChatSession);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
