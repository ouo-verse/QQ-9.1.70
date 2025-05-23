package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.TopFeedCommentApi;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart$doItemOptionTop$job$1", f = "CommentFunctionPart.kt", i = {}, l = {419}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class CommentFunctionPart$doItemOptionTop$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ jl1.b $commentItemData;
    final /* synthetic */ a.CommentMainFeedData $feed;
    int label;
    final /* synthetic */ CommentFunctionPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentFunctionPart$doItemOptionTop$job$1(CommentFunctionPart commentFunctionPart, a.CommentMainFeedData commentMainFeedData, jl1.b bVar, Continuation<? super CommentFunctionPart$doItemOptionTop$job$1> continuation) {
        super(2, continuation);
        this.this$0 = commentFunctionPart;
        this.$feed = commentMainFeedData;
        this.$commentItemData = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CommentFunctionPart$doItemOptionTop$job$1(this.this$0, this.$feed, this.$commentItemData, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        TopFeedCommentApi ja5;
        CommentFunctionPart.b Aa;
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
            ja5 = this.this$0.ja();
            a.CommentMainFeedData commentMainFeedData = this.$feed;
            GProStComment commentData = this.$commentItemData.getCommentData();
            Aa = this.this$0.Aa(this.$commentItemData, true);
            this.label = 1;
            if (ja5.a(commentMainFeedData, commentData, true, Aa, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CommentFunctionPart$doItemOptionTop$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
