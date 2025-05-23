package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import com.tencent.mobileqq.guild.feed.publish.GuildTaskQueueManager;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kn1.a;
import kn1.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$activePublishingFeed$5", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {431, 270}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedPublishServiceV2Impl$activePublishingFeed$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Set<String> $endMainTaskIds;
    final /* synthetic */ String $id;
    final /* synthetic */ Job $job;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ FeedPublishServiceV2Impl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052*\u0010\u0004\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00030\u0000H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "kotlin.jvm.PlatformType", "", "list", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a<T> implements GuildDbDataHelper.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<List<GuildTaskProgressState>> f223074a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Continuation<? super List<GuildTaskProgressState>> continuation) {
            this.f223074a = continuation;
        }

        @Override // com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onResult(List<GuildTaskProgressState> list) {
            this.f223074a.resumeWith(Result.m476constructorimpl(list));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPublishServiceV2Impl$activePublishingFeed$5(Job job, String str, Set<String> set, FeedPublishServiceV2Impl feedPublishServiceV2Impl, Continuation<? super FeedPublishServiceV2Impl$activePublishingFeed$5> continuation) {
        super(2, continuation);
        this.$job = job;
        this.$id = str;
        this.$endMainTaskIds = set;
        this.this$0 = feedPublishServiceV2Impl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedPublishServiceV2Impl$activePublishingFeed$5(this.$job, this.$id, this.$endMainTaskIds, this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01d0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x01ac -> B:6:0x01af). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0179 -> B:7:0x01cc). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object withTimeoutOrNull;
        Iterator it;
        FeedPublishServiceV2Impl$activePublishingFeed$5 feedPublishServiceV2Impl$activePublishingFeed$5;
        Set<String> set;
        FeedPublishServiceV2Impl feedPublishServiceV2Impl;
        long j3;
        List<GuildTaskProgressState> listOf;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    it = (Iterator) this.L$2;
                    feedPublishServiceV2Impl = (FeedPublishServiceV2Impl) this.L$1;
                    set = (Set) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    feedPublishServiceV2Impl$activePublishingFeed$5 = this;
                    char c16 = 2;
                    Object withTimeoutOrNull2 = obj;
                    Logger.f235387a.d().i("FeedPublishServiceV2Impl", 1, "activePublishingFeed: finish " + ((a.FeedPublishFinish) withTimeoutOrNull2));
                    if (!it.hasNext()) {
                        GuildTaskProgressState progressState = (GuildTaskProgressState) it.next();
                        Intrinsics.checkNotNullExpressionValue(progressState, "progressState");
                        if (c.b(progressState)) {
                            IGProGuildInfo L = ch.L(progressState.getGuildId());
                            boolean z16 = false;
                            if (L != null && L.isMember()) {
                                z16 = true;
                            }
                            if (!z16) {
                                Logger.f235387a.d().i("FeedPublishServiceV2Impl", 1, "activePublishingFeed: not member " + progressState);
                            } else {
                                IGProGuildInfo L2 = ch.L(progressState.getGuildId());
                                if (L2 != null) {
                                    j3 = L2.getJoinTime();
                                } else {
                                    j3 = Long.MAX_VALUE;
                                }
                                long j16 = 1000;
                                if (((progressState.getTriggerPublishTimeNs() / j16) / j16) / j16 < j3) {
                                    Logger.f235387a.d().i("FeedPublishServiceV2Impl", 1, "activePublishingFeed: joinTime " + progressState);
                                } else if (set.contains(progressState.getMainTaskId())) {
                                    Logger.f235387a.d().i("FeedPublishServiceV2Impl", 1, "activePublishingFeed: already end " + progressState);
                                } else if (FeedPublishServiceV2Impl.INSTANCE.b(progressState) > feedPublishServiceV2Impl.getConfig().getUploadLimit()) {
                                    Logger logger = Logger.f235387a;
                                    Logger.b bVar = new Logger.b();
                                    String str = "activePublishingFeed: mediaSize too large " + progressState;
                                    if (str instanceof String) {
                                        bVar.a().add(str);
                                    }
                                    Iterator<T> it5 = bVar.a().iterator();
                                    while (it5.hasNext()) {
                                        Logger.f235387a.d().e("FeedPublishServiceV2Impl", 1, (String) it5.next(), null);
                                    }
                                    GuildTaskQueueManager m3 = GuildTaskQueueManager.m();
                                    listOf = CollectionsKt__CollectionsJVMKt.listOf(progressState);
                                    m3.g(listOf);
                                } else {
                                    Logger.f235387a.d().i("FeedPublishServiceV2Impl", 1, "activePublishingFeed: begin " + progressState);
                                    FeedPublishServiceV2Impl$activePublishingFeed$5$1$result$1 feedPublishServiceV2Impl$activePublishingFeed$5$1$result$1 = new FeedPublishServiceV2Impl$activePublishingFeed$5$1$result$1(progressState, feedPublishServiceV2Impl, null);
                                    feedPublishServiceV2Impl$activePublishingFeed$5.L$0 = set;
                                    feedPublishServiceV2Impl$activePublishingFeed$5.L$1 = feedPublishServiceV2Impl;
                                    feedPublishServiceV2Impl$activePublishingFeed$5.L$2 = it;
                                    c16 = 2;
                                    feedPublishServiceV2Impl$activePublishingFeed$5.label = 2;
                                    withTimeoutOrNull2 = TimeoutKt.withTimeoutOrNull(3600000L, feedPublishServiceV2Impl$activePublishingFeed$5$1$result$1, feedPublishServiceV2Impl$activePublishingFeed$5);
                                    if (withTimeoutOrNull2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    Logger.f235387a.d().i("FeedPublishServiceV2Impl", 1, "activePublishingFeed: finish " + ((a.FeedPublishFinish) withTimeoutOrNull2));
                                    if (!it.hasNext()) {
                                        Job.DefaultImpls.cancel$default(feedPublishServiceV2Impl$activePublishingFeed$5.$job, (CancellationException) null, 1, (Object) null);
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                        }
                        c16 = 2;
                        if (!it.hasNext()) {
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                withTimeoutOrNull = obj;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FeedPublishServiceV2Impl$activePublishingFeed$5$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1 feedPublishServiceV2Impl$activePublishingFeed$5$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1 = new FeedPublishServiceV2Impl$activePublishingFeed$5$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1(null, this.$id);
            this.label = 1;
            withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(15000L, feedPublishServiceV2Impl$activePublishingFeed$5$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1, this);
            if (withTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        List list = (List) withTimeoutOrNull;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Set<String> set2 = this.$endMainTaskIds;
        FeedPublishServiceV2Impl feedPublishServiceV2Impl2 = this.this$0;
        it = list.iterator();
        feedPublishServiceV2Impl$activePublishingFeed$5 = this;
        set = set2;
        feedPublishServiceV2Impl = feedPublishServiceV2Impl2;
        if (!it.hasNext()) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedPublishServiceV2Impl$activePublishingFeed$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
