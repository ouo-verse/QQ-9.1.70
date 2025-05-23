package com.tencent.mobileqq.guild.feed.topic.mvi;

import com.tencent.mobileqq.guild.feed.topic.mvi.e;
import com.tencent.mobileqq.guild.feed.topic.mvi.g;
import com.tencent.mobileqq.guild.feed.topic.mvi.i;
import com.tencent.mobileqq.guild.feed.topic.mvi.k;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$handleRepoReq$1", f = "TopicListViewModel.kt", i = {}, l = {263, 266, 269}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class TopicListViewModel$handleRepoReq$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h $change;
    final /* synthetic */ n $i;
    Object L$0;
    int label;
    final /* synthetic */ TopicListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicListViewModel$handleRepoReq$1(h hVar, TopicListViewModel topicListViewModel, n nVar, Continuation<? super TopicListViewModel$handleRepoReq$1> continuation) {
        super(2, continuation);
        this.$change = hVar;
        this.this$0 = topicListViewModel;
        this.$i = nVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TopicListViewModel$handleRepoReq$1(this.$change, this.this$0, this.$i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        final h hVar;
        c cVar;
        g.Companion companion;
        c cVar2;
        k.Companion companion2;
        c cVar3;
        k.Companion companion3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        companion = (g.Companion) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        hVar = companion.a((com.tencent.mobileqq.guild.feed.topic.g) obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    companion2 = (k.Companion) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    hVar = companion2.a((com.tencent.mobileqq.guild.feed.topic.g) obj);
                }
            } else {
                companion3 = (k.Companion) this.L$0;
                ResultKt.throwOnFailure(obj);
                hVar = companion3.a((com.tencent.mobileqq.guild.feed.topic.g) obj);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            h hVar2 = this.$change;
            if (hVar2 instanceof l) {
                k.Companion companion4 = k.INSTANCE;
                cVar3 = this.this$0.repo;
                this.L$0 = companion4;
                this.label = 1;
                Object b16 = cVar3.b("", this);
                if (b16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                companion3 = companion4;
                obj = b16;
                hVar = companion3.a((com.tencent.mobileqq.guild.feed.topic.g) obj);
            } else if (hVar2 instanceof i.Refresh) {
                k.Companion companion5 = k.INSTANCE;
                cVar2 = this.this$0.repo;
                String firstFeedId = ((i.Refresh) this.$change).getFirstFeedId();
                this.L$0 = companion5;
                this.label = 2;
                Object b17 = cVar2.b(firstFeedId, this);
                if (b17 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                companion2 = companion5;
                obj = b17;
                hVar = companion2.a((com.tencent.mobileqq.guild.feed.topic.g) obj);
            } else if (hVar2 instanceof e.LoreMoreLoading) {
                g.Companion companion6 = g.INSTANCE;
                cVar = this.this$0.repo;
                this.L$0 = companion6;
                this.label = 3;
                Object a16 = cVar.a(this);
                if (a16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                companion = companion6;
                obj = a16;
                hVar = companion.a((com.tencent.mobileqq.guild.feed.topic.g) obj);
            } else {
                hVar = null;
            }
        }
        if (hVar == null) {
            return Unit.INSTANCE;
        }
        TopicListViewModel topicListViewModel = this.this$0;
        final n nVar = this.$i;
        final h hVar3 = this.$change;
        topicListViewModel.a2(new Function1<FeedListState, FeedListState>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$handleRepoReq$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final FeedListState invoke(@NotNull FeedListState old) {
                Intrinsics.checkNotNullParameter(old, "old");
                FeedListState a17 = h.this.a(old);
                QLog.i("GTopic_LIST_VM", 1, "handleRepoReq\n " + nVar + "\n-> " + hVar3 + "\n-> " + old + "\n-> " + h.this + "\n-> " + a17);
                return a17;
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TopicListViewModel$handleRepoReq$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
