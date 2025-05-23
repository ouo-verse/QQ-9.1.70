package com.tencent.mobileqq.guild.feed.topic.mvi;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2;
import com.tencent.mobileqq.guild.feed.topic.PageData;
import com.tencent.mobileqq.guild.feed.topic.TopicFeedsRspEvent;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopicFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopicFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetTopicFeedsCallback;
import java.util.ArrayList;
import java.util.List;
import kn1.FeedPublishStateV2;
import kn1.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vn1.TopicDataExt;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\r\u0018\u0000 \u00032\u00020\u0001:\u0001\rB\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\bH\u0002J\u0017\u0010\r\u001a\u00060\u0005j\u0002`\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00060\u0005j\u0002`\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\"\u00101\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/TopicFeedsRepository;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/b;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetTopicFeedsReq;", "i", "req", "Lcom/tencent/mobileqq/guild/feed/topic/g;", "k", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetTopicFeedsReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetTopicFeedsRsp;", "", "Lvn1/b;", "j", "Lcom/tencent/mobileqq/guild/feed/topic/LoadMoreRsp;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "firstFeedId", "Lcom/tencent/mobileqq/guild/feed/topic/RefreshRsp;", "b", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "J", "mTopicId", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "mPageData", "c", "mGuildId", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/k;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/k;", "helper", "e", "Lcom/tencent/mobileqq/guild/feed/topic/g;", "timeoutRsp", "", "f", "I", "mPullCount", "", "g", "[B", "mServerData", tl.h.F, "Ljava/lang/String;", "getMTopFeedId", "()Ljava/lang/String;", "setMTopFeedId", "(Ljava/lang/String;)V", "mTopFeedId", "<init>", "(JLcom/tencent/mobileqq/guild/feed/topic/PageData;J)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicFeedsRepository implements com.tencent.mobileqq.guild.feed.topic.mvi.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long mTopicId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PageData mPageData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long mGuildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.utils.k<vn1.b> helper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.topic.g timeoutRsp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile int mPullCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile byte[] mServerData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile String mTopFeedId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "ret", "", "msg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetTopicFeedsRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b implements IGProGetTopicFeedsCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Triple<Integer, String, GProGetTopicFeedsRsp>> f223601a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Continuation<? super Triple<Integer, String, GProGetTopicFeedsRsp>> continuation) {
            this.f223601a = continuation;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetTopicFeedsCallback
        public final void onResult(int i3, String str, GProGetTopicFeedsRsp gProGetTopicFeedsRsp) {
            Continuation<Triple<Integer, String, GProGetTopicFeedsRsp>> continuation = this.f223601a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new Triple(Integer.valueOf(i3), str, gProGetTopicFeedsRsp)));
        }
    }

    public TopicFeedsRepository(long j3, @NotNull PageData mPageData, long j16) {
        List emptyList;
        Intrinsics.checkNotNullParameter(mPageData, "mPageData");
        this.mTopicId = j3;
        this.mPageData = mPageData;
        this.mGuildId = j16;
        this.helper = new com.tencent.mobileqq.guild.feed.feedsquare.utils.k<>(new Function1<vn1.b, GProStFeed>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicFeedsRepository$helper$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final GProStFeed invoke(@NotNull vn1.b $receiver) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                Object a16 = $receiver.d().a();
                if (a16 instanceof GProStFeed) {
                    return (GProStFeed) a16;
                }
                return null;
            }
        }, new Function2<vn1.b, GuildTaskProgressState, Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicFeedsRepository$helper$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(vn1.b bVar, GuildTaskProgressState guildTaskProgressState) {
                invoke2(bVar, guildTaskProgressState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull vn1.b $receiver, @NotNull GuildTaskProgressState it) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                Intrinsics.checkNotNullParameter(it, "it");
                $receiver.h(it);
            }
        }, new Function1<GProStFeed, vn1.b>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicFeedsRepository$helper$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final vn1.b invoke(@NotNull GProStFeed it) {
                PageData pageData;
                long j17;
                Intrinsics.checkNotNullParameter(it, "it");
                xn1.e eVar = xn1.e.f448187a;
                GProStFeedDetailRspWrapper gProStFeedDetailRspWrapper = new GProStFeedDetailRspWrapper(it, null, 2, 0 == true ? 1 : 0);
                pageData = TopicFeedsRepository.this.mPageData;
                j17 = TopicFeedsRepository.this.mTopicId;
                return xn1.e.p(eVar, gProStFeedDetailRspWrapper, new TopicDataExt(pageData, j17, ""), 0L, null, 12, null);
            }
        }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.utils.d<vn1.b>, List<? extends a.FeedPublishFinish>>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicFeedsRepository$helper$4
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<a.FeedPublishFinish> invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.utils.d<vn1.b> it) {
                List<a.FeedPublishFinish> emptyList2;
                Intrinsics.checkNotNullParameter(it, "it");
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
        }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.utils.d<vn1.b>, List<? extends FeedPublishStateV2>>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicFeedsRepository$helper$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<FeedPublishStateV2> invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.utils.d<vn1.b> it) {
                long j17;
                Intrinsics.checkNotNullParameter(it, "it");
                IFeedPublishServiceV2 iFeedPublishServiceV2 = (IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class);
                String guildId = it.getGuildId();
                String channelId = it.getChannelId();
                j17 = TopicFeedsRepository.this.mTopicId;
                return iFeedPublishServiceV2.syncQueryFailPublishStateV2s(guildId, channelId, j17);
            }
        });
        ri1.a a16 = ri1.a.a(1002);
        Intrinsics.checkNotNullExpressionValue(a16, "error(GProStateCode.ERROR_NETWORK_TIMEOUT)");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.timeoutRsp = new com.tencent.mobileqq.guild.feed.topic.g(a16, emptyList, new GProGetTopicFeedsRsp());
        this.mPullCount = 10;
        this.mServerData = new byte[0];
        this.mTopFeedId = "";
    }

    private final GProGetTopicFeedsReq i() {
        GProGetTopicFeedsReq gProGetTopicFeedsReq = new GProGetTopicFeedsReq();
        gProGetTopicFeedsReq.topicId = this.mTopicId;
        gProGetTopicFeedsReq.getType = this.mPageData.getType();
        gProGetTopicFeedsReq.count = this.mPullCount;
        gProGetTopicFeedsReq.attachInfo = this.mServerData;
        gProGetTopicFeedsReq.topFeedId = this.mTopFeedId;
        gProGetTopicFeedsReq.guildId = this.mGuildId;
        return gProGetTopicFeedsReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<vn1.b> j(GProGetTopicFeedsRsp gProGetTopicFeedsRsp) {
        int collectionSizeOrDefault;
        ArrayList<GProStFeed> feeds = gProGetTopicFeedsRsp.getFeeds();
        Intrinsics.checkNotNullExpressionValue(feeds, "getFeeds()");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(feeds, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (GProStFeed it : feeds) {
            xn1.e eVar = xn1.e.f448187a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            GProStFeedDetailRspWrapper gProStFeedDetailRspWrapper = new GProStFeedDetailRspWrapper(it, null, 2, 0 == true ? 1 : 0);
            PageData pageData = this.mPageData;
            long j3 = this.mTopicId;
            String traceId = gProGetTopicFeedsRsp.traceId;
            Intrinsics.checkNotNullExpressionValue(traceId, "traceId");
            arrayList.add(xn1.e.p(eVar, gProStFeedDetailRspWrapper, new TopicDataExt(pageData, j3, traceId), 0L, null, 4, null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object k(GProGetTopicFeedsReq gProGetTopicFeedsReq, Continuation<? super com.tencent.mobileqq.guild.feed.topic.g> continuation) {
        TopicFeedsRepository$innerGetFeeds$1 topicFeedsRepository$innerGetFeeds$1;
        Object coroutine_suspended;
        int i3;
        long currentTimeMillis;
        TopicFeedsRepository topicFeedsRepository;
        Triple triple;
        TopicFeedsRepository topicFeedsRepository2;
        long j3;
        GProGetTopicFeedsReq gProGetTopicFeedsReq2 = gProGetTopicFeedsReq;
        if (continuation instanceof TopicFeedsRepository$innerGetFeeds$1) {
            topicFeedsRepository$innerGetFeeds$1 = (TopicFeedsRepository$innerGetFeeds$1) continuation;
            int i16 = topicFeedsRepository$innerGetFeeds$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                topicFeedsRepository$innerGetFeeds$1.label = i16 - Integer.MIN_VALUE;
                Object obj = topicFeedsRepository$innerGetFeeds$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = topicFeedsRepository$innerGetFeeds$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            j3 = topicFeedsRepository$innerGetFeeds$1.J$0;
                            gProGetTopicFeedsReq2 = (GProGetTopicFeedsReq) topicFeedsRepository$innerGetFeeds$1.L$1;
                            topicFeedsRepository2 = (TopicFeedsRepository) topicFeedsRepository$innerGetFeeds$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            com.tencent.mobileqq.guild.feed.topic.g gVar = (com.tencent.mobileqq.guild.feed.topic.g) obj;
                            SimpleEventBus.getInstance().dispatchEvent(new TopicFeedsRspEvent(topicFeedsRepository2.mTopicId, gVar));
                            Logger logger = Logger.f235387a;
                            Logger.a d16 = logger.d();
                            GProGetTopicFeedsRsp rawRsp = gVar.getRawRsp();
                            d16.i("GTopic_GuildTopicFeedsRepository", 1, "innerGetFeeds req:topicId:" + gProGetTopicFeedsReq2.topicId + " type:" + gProGetTopicFeedsReq2.getType + " feedId:" + gProGetTopicFeedsReq2.topFeedId + " trans:" + gProGetTopicFeedsReq2.attachInfo.length + " rsp:status:" + gVar.getRspStatus() + " topicInfo:[" + rawRsp.topicName + "-" + rawRsp.pageView + "-" + rawRsp.totalFeedNum + "] feeds:" + rawRsp.feeds.size() + " finish:" + gVar.getIsFinish());
                            Logger.a d17 = logger.d();
                            long currentTimeMillis2 = System.currentTimeMillis();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("[trace] getFeeds cost: ");
                            sb5.append(currentTimeMillis2 - j3);
                            d17.i("GTopic_GuildTopicFeedsRepository", 1, sb5.toString());
                            return gVar;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    currentTimeMillis = topicFeedsRepository$innerGetFeeds$1.J$0;
                    gProGetTopicFeedsReq2 = (GProGetTopicFeedsReq) topicFeedsRepository$innerGetFeeds$1.L$1;
                    topicFeedsRepository = (TopicFeedsRepository) topicFeedsRepository$innerGetFeeds$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    currentTimeMillis = System.currentTimeMillis();
                    TopicFeedsRepository$innerGetFeeds$$inlined$suspendCoroutineWithTimeout$default$1 topicFeedsRepository$innerGetFeeds$$inlined$suspendCoroutineWithTimeout$default$1 = new TopicFeedsRepository$innerGetFeeds$$inlined$suspendCoroutineWithTimeout$default$1(null, gProGetTopicFeedsReq2);
                    topicFeedsRepository$innerGetFeeds$1.L$0 = this;
                    topicFeedsRepository$innerGetFeeds$1.L$1 = gProGetTopicFeedsReq2;
                    topicFeedsRepository$innerGetFeeds$1.J$0 = currentTimeMillis;
                    topicFeedsRepository$innerGetFeeds$1.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(15000L, topicFeedsRepository$innerGetFeeds$$inlined$suspendCoroutineWithTimeout$default$1, topicFeedsRepository$innerGetFeeds$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    topicFeedsRepository = this;
                }
                triple = (Triple) obj;
                if (triple != null) {
                    return topicFeedsRepository.timeoutRsp;
                }
                int intValue = ((Number) triple.component1()).intValue();
                String str = (String) triple.component2();
                GProGetTopicFeedsRsp gProGetTopicFeedsRsp = (GProGetTopicFeedsRsp) triple.component3();
                CoroutineDispatcher c16 = ae.a().c();
                TopicFeedsRepository$innerGetFeeds$rsp$1 topicFeedsRepository$innerGetFeeds$rsp$1 = new TopicFeedsRepository$innerGetFeeds$rsp$1(topicFeedsRepository, gProGetTopicFeedsRsp, gProGetTopicFeedsReq2, intValue, str, null);
                topicFeedsRepository$innerGetFeeds$1.L$0 = topicFeedsRepository;
                topicFeedsRepository$innerGetFeeds$1.L$1 = gProGetTopicFeedsReq2;
                topicFeedsRepository$innerGetFeeds$1.J$0 = currentTimeMillis;
                topicFeedsRepository$innerGetFeeds$1.label = 2;
                obj = BuildersKt.withContext(c16, topicFeedsRepository$innerGetFeeds$rsp$1, topicFeedsRepository$innerGetFeeds$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                topicFeedsRepository2 = topicFeedsRepository;
                j3 = currentTimeMillis;
                com.tencent.mobileqq.guild.feed.topic.g gVar2 = (com.tencent.mobileqq.guild.feed.topic.g) obj;
                SimpleEventBus.getInstance().dispatchEvent(new TopicFeedsRspEvent(topicFeedsRepository2.mTopicId, gVar2));
                Logger logger2 = Logger.f235387a;
                Logger.a d162 = logger2.d();
                GProGetTopicFeedsRsp rawRsp2 = gVar2.getRawRsp();
                d162.i("GTopic_GuildTopicFeedsRepository", 1, "innerGetFeeds req:topicId:" + gProGetTopicFeedsReq2.topicId + " type:" + gProGetTopicFeedsReq2.getType + " feedId:" + gProGetTopicFeedsReq2.topFeedId + " trans:" + gProGetTopicFeedsReq2.attachInfo.length + " rsp:status:" + gVar2.getRspStatus() + " topicInfo:[" + rawRsp2.topicName + "-" + rawRsp2.pageView + "-" + rawRsp2.totalFeedNum + "] feeds:" + rawRsp2.feeds.size() + " finish:" + gVar2.getIsFinish());
                Logger.a d172 = logger2.d();
                long currentTimeMillis22 = System.currentTimeMillis();
                StringBuilder sb52 = new StringBuilder();
                sb52.append("[trace] getFeeds cost: ");
                sb52.append(currentTimeMillis22 - j3);
                d172.i("GTopic_GuildTopicFeedsRepository", 1, sb52.toString());
                return gVar2;
            }
        }
        topicFeedsRepository$innerGetFeeds$1 = new TopicFeedsRepository$innerGetFeeds$1(this, continuation);
        Object obj2 = topicFeedsRepository$innerGetFeeds$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = topicFeedsRepository$innerGetFeeds$1.label;
        if (i3 == 0) {
        }
        triple = (Triple) obj2;
        if (triple != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.mobileqq.guild.feed.topic.mvi.b
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(@NotNull Continuation<? super com.tencent.mobileqq.guild.feed.topic.g> continuation) {
        TopicFeedsRepository$loadMoreTopicFeeds$1 topicFeedsRepository$loadMoreTopicFeeds$1;
        Object coroutine_suspended;
        int i3;
        TopicFeedsRepository topicFeedsRepository;
        if (continuation instanceof TopicFeedsRepository$loadMoreTopicFeeds$1) {
            topicFeedsRepository$loadMoreTopicFeeds$1 = (TopicFeedsRepository$loadMoreTopicFeeds$1) continuation;
            int i16 = topicFeedsRepository$loadMoreTopicFeeds$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                topicFeedsRepository$loadMoreTopicFeeds$1.label = i16 - Integer.MIN_VALUE;
                Object obj = topicFeedsRepository$loadMoreTopicFeeds$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = topicFeedsRepository$loadMoreTopicFeeds$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        topicFeedsRepository = (TopicFeedsRepository) topicFeedsRepository$loadMoreTopicFeeds$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    GProGetTopicFeedsReq i17 = i();
                    topicFeedsRepository$loadMoreTopicFeeds$1.L$0 = this;
                    topicFeedsRepository$loadMoreTopicFeeds$1.label = 1;
                    obj = k(i17, topicFeedsRepository$loadMoreTopicFeeds$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    topicFeedsRepository = this;
                }
                com.tencent.mobileqq.guild.feed.topic.g gVar = (com.tencent.mobileqq.guild.feed.topic.g) obj;
                byte[] bArr = gVar.getRawRsp().attachInfo;
                Intrinsics.checkNotNullExpressionValue(bArr, "rsp.rawRsp.attachInfo");
                topicFeedsRepository.mServerData = bArr;
                return gVar;
            }
        }
        topicFeedsRepository$loadMoreTopicFeeds$1 = new TopicFeedsRepository$loadMoreTopicFeeds$1(this, continuation);
        Object obj2 = topicFeedsRepository$loadMoreTopicFeeds$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = topicFeedsRepository$loadMoreTopicFeeds$1.label;
        if (i3 == 0) {
        }
        com.tencent.mobileqq.guild.feed.topic.g gVar2 = (com.tencent.mobileqq.guild.feed.topic.g) obj2;
        byte[] bArr2 = gVar2.getRawRsp().attachInfo;
        Intrinsics.checkNotNullExpressionValue(bArr2, "rsp.rawRsp.attachInfo");
        topicFeedsRepository.mServerData = bArr2;
        return gVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.mobileqq.guild.feed.topic.mvi.b
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(@NotNull String str, @NotNull Continuation<? super com.tencent.mobileqq.guild.feed.topic.g> continuation) {
        TopicFeedsRepository$pullRefreshTopicFeeds$1 topicFeedsRepository$pullRefreshTopicFeeds$1;
        Object coroutine_suspended;
        int i3;
        TopicFeedsRepository topicFeedsRepository;
        if (continuation instanceof TopicFeedsRepository$pullRefreshTopicFeeds$1) {
            topicFeedsRepository$pullRefreshTopicFeeds$1 = (TopicFeedsRepository$pullRefreshTopicFeeds$1) continuation;
            int i16 = topicFeedsRepository$pullRefreshTopicFeeds$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                topicFeedsRepository$pullRefreshTopicFeeds$1.label = i16 - Integer.MIN_VALUE;
                Object obj = topicFeedsRepository$pullRefreshTopicFeeds$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = topicFeedsRepository$pullRefreshTopicFeeds$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        topicFeedsRepository = (TopicFeedsRepository) topicFeedsRepository$pullRefreshTopicFeeds$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    this.mTopFeedId = str;
                    this.mServerData = new byte[0];
                    GProGetTopicFeedsReq i17 = i();
                    topicFeedsRepository$pullRefreshTopicFeeds$1.L$0 = this;
                    topicFeedsRepository$pullRefreshTopicFeeds$1.label = 1;
                    obj = k(i17, topicFeedsRepository$pullRefreshTopicFeeds$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    topicFeedsRepository = this;
                }
                com.tencent.mobileqq.guild.feed.topic.g gVar = (com.tencent.mobileqq.guild.feed.topic.g) obj;
                byte[] bArr = gVar.getRawRsp().attachInfo;
                Intrinsics.checkNotNullExpressionValue(bArr, "rsp.rawRsp.attachInfo");
                topicFeedsRepository.mServerData = bArr;
                return gVar;
            }
        }
        topicFeedsRepository$pullRefreshTopicFeeds$1 = new TopicFeedsRepository$pullRefreshTopicFeeds$1(this, continuation);
        Object obj2 = topicFeedsRepository$pullRefreshTopicFeeds$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = topicFeedsRepository$pullRefreshTopicFeeds$1.label;
        if (i3 == 0) {
        }
        com.tencent.mobileqq.guild.feed.topic.g gVar2 = (com.tencent.mobileqq.guild.feed.topic.g) obj2;
        byte[] bArr2 = gVar2.getRawRsp().attachInfo;
        Intrinsics.checkNotNullExpressionValue(bArr2, "rsp.rawRsp.attachInfo");
        topicFeedsRepository.mServerData = bArr2;
        return gVar2;
    }
}
