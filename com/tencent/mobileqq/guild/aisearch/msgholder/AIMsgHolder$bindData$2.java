package com.tencent.mobileqq.guild.aisearch.msgholder;

import com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData;
import com.tencent.mobileqq.guild.aisearch.models.a;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/e;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.msgholder.AIMsgHolder$bindData$2", f = "AIMsgHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class AIMsgHolder$bindData$2 extends SuspendLambda implements Function2<ChatAnswerData, Continuation<? super Unit>, Object> {
    final /* synthetic */ a.AnswerItem $answerItem;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIMsgHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIMsgHolder$bindData$2(AIMsgHolder aIMsgHolder, a.AnswerItem answerItem, Continuation<? super AIMsgHolder$bindData$2> continuation) {
        super(2, continuation);
        this.this$0 = aIMsgHolder;
        this.$answerItem = answerItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AIMsgHolder$bindData$2 aIMsgHolder$bindData$2 = new AIMsgHolder$bindData$2(this.this$0, this.$answerItem, continuation);
        aIMsgHolder$bindData$2.L$0 = obj;
        return aIMsgHolder$bindData$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ChatAnswerData chatAnswerData, @Nullable Continuation<? super Unit> continuation) {
        return ((AIMsgHolder$bindData$2) create(chatAnswerData, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ChatAnswerData chatAnswerData = (ChatAnswerData) this.L$0;
            AIMsgHolder.x(this.this$0, this.$answerItem, chatAnswerData);
            this.this$0.adapter.p0(chatAnswerData);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
