package com.tencent.mobileqq.guild.aisearch.parts;

import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.i;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/d;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.parts.EmptyPagePart$onInitView$7", f = "EmptyPagePart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class EmptyPagePart$onInitView$7 extends SuspendLambda implements Function2<AiChatSession, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EmptyPagePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyPagePart$onInitView$7(EmptyPagePart emptyPagePart, Continuation<? super EmptyPagePart$onInitView$7> continuation) {
        super(2, continuation);
        this.this$0 = emptyPagePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        EmptyPagePart$onInitView$7 emptyPagePart$onInitView$7 = new EmptyPagePart$onInitView$7(this.this$0, continuation);
        emptyPagePart$onInitView$7.L$0 = obj;
        return emptyPagePart$onInitView$7;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull AiChatSession aiChatSession, @Nullable Continuation<? super Unit> continuation) {
        return ((EmptyPagePart$onInitView$7) create(aiChatSession, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AiChatSession aiChatSession = (AiChatSession) this.L$0;
            Logger.f235387a.d().d("EmptyPagePart", 1, "[onCreateView] sessionState: " + aiChatSession);
            if (aiChatSession.getSessionState() instanceof i.c) {
                this.this$0.E9();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
