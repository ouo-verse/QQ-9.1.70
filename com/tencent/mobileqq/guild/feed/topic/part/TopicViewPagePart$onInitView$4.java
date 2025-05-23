package com.tencent.mobileqq.guild.feed.topic.part;

import androidx.viewpager2.widget.ViewPager2;
import kn1.a;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkn1/a$a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.part.TopicViewPagePart$onInitView$4", f = "TopicViewPagePart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class TopicViewPagePart$onInitView$4 extends SuspendLambda implements Function2<a.FeedPublishBegin, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TopicViewPagePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicViewPagePart$onInitView$4(TopicViewPagePart topicViewPagePart, Continuation<? super TopicViewPagePart$onInitView$4> continuation) {
        super(2, continuation);
        this.this$0 = topicViewPagePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TopicViewPagePart$onInitView$4 topicViewPagePart$onInitView$4 = new TopicViewPagePart$onInitView$4(this.this$0, continuation);
        topicViewPagePart$onInitView$4.L$0 = obj;
        return topicViewPagePart$onInitView$4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ViewPager2 viewPager2;
        int i3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (((a.FeedPublishBegin) this.L$0).getState().getIsNewFeed()) {
                viewPager2 = this.this$0.mViewPage;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPage");
                    viewPager2 = null;
                }
                i3 = TopicViewPagePart.E;
                viewPager2.setCurrentItem(i3, false);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull a.FeedPublishBegin feedPublishBegin, @Nullable Continuation<? super Unit> continuation) {
        return ((TopicViewPagePart$onInitView$4) create(feedPublishBegin, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
