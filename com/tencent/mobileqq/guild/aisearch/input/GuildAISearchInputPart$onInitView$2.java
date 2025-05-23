package com.tencent.mobileqq.guild.aisearch.input;

import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/d;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.input.GuildAISearchInputPart$onInitView$2", f = "GuildAISearchInputPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class GuildAISearchInputPart$onInitView$2 extends SuspendLambda implements Function2<AiChatSession, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildAISearchInputPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAISearchInputPart$onInitView$2(GuildAISearchInputPart guildAISearchInputPart, Continuation<? super GuildAISearchInputPart$onInitView$2> continuation) {
        super(2, continuation);
        this.this$0 = guildAISearchInputPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildAISearchInputPart$onInitView$2 guildAISearchInputPart$onInitView$2 = new GuildAISearchInputPart$onInitView$2(this.this$0, continuation);
        guildAISearchInputPart$onInitView$2.L$0 = obj;
        return guildAISearchInputPart$onInitView$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@Nullable AiChatSession aiChatSession, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildAISearchInputPart$onInitView$2) create(aiChatSession, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AiChatSession aiChatSession = (AiChatSession) this.L$0;
            if (aiChatSession != null) {
                GuildAISearchInputView guildAISearchInputView = this.this$0.searchInputView;
                if (guildAISearchInputView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
                    guildAISearchInputView = null;
                }
                if (aiChatSession.getSessionState() instanceof i.c) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                guildAISearchInputView.setVisibility(i3);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
