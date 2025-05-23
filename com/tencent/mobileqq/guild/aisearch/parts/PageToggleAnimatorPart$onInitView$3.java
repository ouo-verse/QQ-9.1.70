package com.tencent.mobileqq.guild.aisearch.parts;

import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/aisearch/models/d;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.parts.PageToggleAnimatorPart$onInitView$3", f = "PageToggleAnimatorPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class PageToggleAnimatorPart$onInitView$3 extends SuspendLambda implements Function2<Pair<? extends AiChatSession, ? extends Boolean>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PageToggleAnimatorPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageToggleAnimatorPart$onInitView$3(PageToggleAnimatorPart pageToggleAnimatorPart, Continuation<? super PageToggleAnimatorPart$onInitView$3> continuation) {
        super(2, continuation);
        this.this$0 = pageToggleAnimatorPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PageToggleAnimatorPart$onInitView$3 pageToggleAnimatorPart$onInitView$3 = new PageToggleAnimatorPart$onInitView$3(this.this$0, continuation);
        pageToggleAnimatorPart$onInitView$3.L$0 = obj;
        return pageToggleAnimatorPart$onInitView$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Pair<? extends AiChatSession, ? extends Boolean> pair, Continuation<? super Unit> continuation) {
        return invoke2((Pair<AiChatSession, Boolean>) pair, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Pair pair = (Pair) this.L$0;
            Logger.f235387a.d().d("PageToggleAnimatorPart", 1, "[onCreateView] sessionState: " + pair);
            this.this$0.A9(((Boolean) pair.component2()).booleanValue());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull Pair<AiChatSession, Boolean> pair, @Nullable Continuation<? super Unit> continuation) {
        return ((PageToggleAnimatorPart$onInitView$3) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
