package com.tencent.mobileqq.guild.aisearch;

import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/guild/aisearch/models/d;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.AIChatListViewModel$submitChat$3", f = "AIChatListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class AIChatListViewModel$submitChat$3 extends SuspendLambda implements Function2<FlowCollector<? super AiChatSession>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sessionId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIChatListViewModel$submitChat$3(String str, Continuation<? super AIChatListViewModel$submitChat$3> continuation) {
        super(2, continuation);
        this.$sessionId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AIChatListViewModel$submitChat$3(this.$sessionId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Logger logger = Logger.f235387a;
            String str = this.$sessionId;
            Logger.b bVar = new Logger.b();
            String str2 = "submitChat(" + str + "): failed";
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("AIChatListViewModel", 1, (String) it.next(), null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super AiChatSession> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((AIChatListViewModel$submitChat$3) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
