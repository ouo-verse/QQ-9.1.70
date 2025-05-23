package com.tencent.mobileqq.guild.feed.publish.publishV2;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.annotation.Service;
import in1.d;
import java.util.List;
import kn1.FeedPublishStateV2;
import kn1.a;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Service(process = {"all"})
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H&J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH&J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/IFeedPublishServiceV2;", "Lmqq/app/api/IRuntimeService;", "", "", "guild", WadlProxyConsts.CHANNEL, "", "topicId", "", "Lkn1/b;", "syncQueryFailPublishStateV2s", "", "activePublishingFeed", "Lkn1/a$b;", "finishedFeedPublishState", "Lkotlinx/coroutines/flow/Flow;", "Lkn1/a$a;", "publishBeginFlow", "Lkn1/a$c;", "publishUpdateFlow", "publishEndFlow", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface IFeedPublishServiceV2 extends IRuntimeService {
    void activePublishingFeed(@NotNull String guild2);

    @NotNull
    List<a.FeedPublishFinish> finishedFeedPublishState(@NotNull String guild2, @NotNull String channel);

    @Nullable
    /* synthetic */ d getPostFeedMainTaskFacade(@NotNull String str);

    @NotNull
    Flow<a.FeedPublishBegin> publishBeginFlow();

    @NotNull
    Flow<a.FeedPublishFinish> publishEndFlow();

    @NotNull
    Flow<a.FeedPublishUpdate> publishUpdateFlow();

    @NotNull
    List<FeedPublishStateV2> syncQueryFailPublishStateV2s(@NotNull String guild2, @NotNull String channel);

    @NotNull
    List<FeedPublishStateV2> syncQueryFailPublishStateV2s(@NotNull String guild2, @NotNull String channel, long topicId);
}
