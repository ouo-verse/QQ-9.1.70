package com.tencent.mobileqq.guild.feed.topic.part;

import com.tencent.mobileqq.guild.feed.topic.mvi.FeedListState;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.part.TopicListPart$handleTopicListChange$3", f = "TopicListPart.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class TopicListPart$handleTopicListChange$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TopicListPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicListPart$handleTopicListChange$3(TopicListPart topicListPart, Continuation<? super TopicListPart$handleTopicListChange$3> continuation) {
        super(2, continuation);
        this.this$0 = topicListPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TopicListPart$handleTopicListChange$3(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        boolean z17;
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
            Logger.f235387a.d().i("GTopic_TopicListPart", 1, "handleTopicListChange lockUpdateList");
            this.label = 1;
            if (DelayKt.delay(450L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Logger logger = Logger.f235387a;
        TopicListPart topicListPart = this.this$0;
        Logger.a d16 = logger.d();
        z16 = topicListPart.updateListWhenUnLock;
        d16.i("GTopic_TopicListPart", 1, "handleTopicListChange unLockUpdateList updateListWhenUnLock:" + z16);
        this.this$0.lockUpdateList = false;
        z17 = this.this$0.updateListWhenUnLock;
        if (z17) {
            this.this$0.updateListWhenUnLock = false;
            FeedListState value = this.this$0.E9().X1().getValue();
            if (value != null) {
                this.this$0.O9(value);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TopicListPart$handleTopicListChange$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
