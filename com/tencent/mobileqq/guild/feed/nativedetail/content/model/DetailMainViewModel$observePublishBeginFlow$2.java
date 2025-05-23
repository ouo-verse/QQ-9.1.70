package com.tencent.mobileqq.guild.feed.nativedetail.content.model;

import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import kn1.FeedPublishStateV2;
import kn1.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkn1/a$a;", "publishState", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailMainViewModel$observePublishBeginFlow$2", f = "DetailMainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class DetailMainViewModel$observePublishBeginFlow$2 extends SuspendLambda implements Function2<a.FeedPublishBegin, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DetailMainViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailMainViewModel$observePublishBeginFlow$2(DetailMainViewModel detailMainViewModel, Continuation<? super DetailMainViewModel$observePublishBeginFlow$2> continuation) {
        super(2, continuation);
        this.this$0 = detailMainViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DetailMainViewModel$observePublishBeginFlow$2 detailMainViewModel$observePublishBeginFlow$2 = new DetailMainViewModel$observePublishBeginFlow$2(this.this$0, continuation);
        detailMainViewModel$observePublishBeginFlow$2.L$0 = obj;
        return detailMainViewModel$observePublishBeginFlow$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPartHost iPartHost;
        Object firstOrNull;
        Integer p16;
        FeedDetailMainData feedDetailMainData;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FeedPublishStateV2 state = ((a.FeedPublishBegin) this.L$0).getState();
            GProStFeed stFeed = state.getStFeed();
            GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
            iPartHost = this.this$0.partHost;
            guildSplitViewUtils.E(iPartHost, "guild_feed_publish_info", com.tencent.mobileqq.guild.feed.feedsquare.data.g.a(state.getTaskState(), com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(stFeed)));
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.this$0.i());
            hl1.g gVar = (hl1.g) firstOrNull;
            qj1.h hVar = null;
            if (gVar != null) {
                if (gVar instanceof FeedDetailMainData) {
                    feedDetailMainData = (FeedDetailMainData) gVar;
                } else {
                    feedDetailMainData = null;
                }
                if (feedDetailMainData != null) {
                    hVar = feedDetailMainData.getFeedDetail();
                }
            }
            if (hVar instanceof GProStFeedDetailRspWrapper) {
                GProStFeedDetailRspWrapper gProStFeedDetailRspWrapper = (GProStFeedDetailRspWrapper) hVar;
                com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.m(gProStFeedDetailRspWrapper.getFeed(), stFeed);
                stFeed = gProStFeedDetailRspWrapper.getFeed();
            } else {
                QLog.i("FeedNativeDetail.ContentDetailMainViewModel", 1, "feedDetail is not GProStFeedDetailRspWrapper");
                if (hVar != null && (p16 = hVar.p()) != null) {
                    stFeed.visitorInfo.viewCount = p16.intValue();
                }
            }
            GProStFeed gProStFeed = stFeed;
            DetailMainViewModel.z2(this.this$0, gProStFeed, 0, "", true, gProStFeed.meta.lastModifiedTime, null, 32, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull a.FeedPublishBegin feedPublishBegin, @Nullable Continuation<? super Unit> continuation) {
        return ((DetailMainViewModel$observePublishBeginFlow$2) create(feedPublishBegin, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
