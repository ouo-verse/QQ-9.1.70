package com.tencent.mobileqq.guild.feed.topic;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.feed.morepanel.cooperate.FeedTopicListPartMorePanelCooperateHelper;
import com.tencent.mobileqq.guild.feed.topic.mvi.TopicFeedsRepository;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u001a\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n\u001a\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002\u001a\u0006\u0010\u0014\u001a\u00020\u0013\u001a\u0016\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0013\u001a\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\f*\n\u0010\u001d\"\u00020\u001c2\u00020\u001c\u00a8\u0006\u001e"}, d2 = {"", "topicId", "", "topicName", "guildId", "channelSign", "Lcom/tencent/mobileqq/guild/feed/topic/f;", "a", "Lcom/tencent/mobileqq/guild/feed/topic/e;", "topicSession", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", ISchemeApi.KEY_PAGE_DATA, "Lcom/tencent/mobileqq/guild/feed/topic/d;", "f", "Landroidx/fragment/app/Fragment;", "fragment", QCircleWeakNetReporter.KEY_TRACE_ID, "Lcom/tencent/mobileqq/guild/feed/topic/a;", "b", "Lcom/tencent/mobileqq/guild/feed/topic/b;", "c", "topicDepends", "topicGlobalDepends", "Lcom/tencent/mobileqq/guild/feed/topic/c;", "d", "topicListSession", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/c;", "e", "Lyj1/e;", "TopicVideoPlayManager", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicContextKt {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\bR \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/topic/TopicContextKt$a", "Lcom/tencent/mobileqq/guild/feed/topic/b;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "a", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lvn1/a;", "b", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "rvPool", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "feedsDelegate", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements com.tencent.mobileqq.guild.feed.topic.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RecyclerView.RecycledViewPool rvPool;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AdapterDelegatesManager<List<vn1.a>> feedsDelegate;

        a() {
            RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
            for (Map.Entry<Integer, Integer> entry : un1.b.a().entrySet()) {
                recycledViewPool.setMaxRecycledViews(entry.getKey().intValue(), entry.getValue().intValue());
            }
            this.rvPool = recycledViewPool;
            this.feedsDelegate = un1.b.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.b
        @NotNull
        /* renamed from: a, reason: from getter */
        public RecyclerView.RecycledViewPool getRvPool() {
            return this.rvPool;
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.b
        @NotNull
        public AdapterDelegatesManager<List<vn1.a>> b() {
            return this.feedsDelegate;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0015\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0096\u0001J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0096\u0001J\f\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0018\u0010\u0011\u001a\u00060\u000bj\u0002`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/feed/topic/TopicContextKt$b", "Lcom/tencent/mobileqq/guild/feed/topic/c;", "Lcom/tencent/mobileqq/guild/feed/topic/a;", "", "", "", "d", "Lzp1/a;", "Lvn1/b;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/ioc/IMorePanelLauncherIoc;", "b", "Lyj1/e;", "Lcom/tencent/mobileqq/guild/feed/topic/TopicVideoPlayManager;", "a", "Lun1/c;", "c", "Lyj1/e;", "videoMgr", "Lun1/c;", "adapterHolder", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements com.tencent.mobileqq.guild.feed.topic.c, com.tencent.mobileqq.guild.feed.topic.a {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ com.tencent.mobileqq.guild.feed.topic.a f223513a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final yj1.e videoMgr = new yj1.e();

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final un1.c adapterHolder;

        b(com.tencent.mobileqq.guild.feed.topic.a aVar, com.tencent.mobileqq.guild.feed.topic.b bVar) {
            this.f223513a = aVar;
            this.adapterHolder = new un1.c(bVar.b());
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.c
        @NotNull
        /* renamed from: a, reason: from getter */
        public yj1.e getVideoMgr() {
            return this.videoMgr;
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.a
        @NotNull
        public zp1.a<vn1.b> b() {
            return this.f223513a.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.c
        @NotNull
        /* renamed from: c, reason: from getter */
        public un1.c getAdapterHolder() {
            return this.adapterHolder;
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.a
        @NotNull
        public Map<String, Object> d() {
            return this.f223513a.d();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00060\u0003j\u0002`\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/topic/TopicContextKt$c", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/c;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/b;", "Lcom/tencent/mobileqq/guild/feed/topic/g;", "Lcom/tencent/mobileqq/guild/feed/topic/LoadMoreRsp;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "firstFeedId", "Lcom/tencent/mobileqq/guild/feed/topic/RefreshRsp;", "b", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements com.tencent.mobileqq.guild.feed.topic.mvi.c, com.tencent.mobileqq.guild.feed.topic.mvi.b {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ TopicFeedsRepository f223516a;

        c(com.tencent.mobileqq.guild.feed.topic.d dVar) {
            this.f223516a = new TopicFeedsRepository(dVar.getTopicId(), dVar.getF223518b(), MiscKt.l(dVar.getGuildId()));
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.mvi.b
        @Nullable
        public Object a(@NotNull Continuation<? super g> continuation) {
            return this.f223516a.a(continuation);
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.mvi.b
        @Nullable
        public Object b(@NotNull String str, @NotNull Continuation<? super g> continuation) {
            return this.f223516a.b(str, continuation);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0005\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\t\u0010\b\u001a\u00020\u0003H\u0096\u0001J\b\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/topic/TopicContextKt$d", "Lcom/tencent/mobileqq/guild/feed/topic/d;", "Lcom/tencent/mobileqq/guild/feed/topic/e;", "", "a", "getGuildId", "", "getTopicId", "getTopicName", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "getPageData", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements com.tencent.mobileqq.guild.feed.topic.d, e {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ e f223517a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PageData f223518b;

        d(e eVar, PageData pageData) {
            this.f223518b = pageData;
            this.f223517a = eVar;
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.e
        @NotNull
        /* renamed from: a */
        public String getChannelSign() {
            return this.f223517a.getChannelSign();
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.e
        @NotNull
        public String getGuildId() {
            return this.f223517a.getGuildId();
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.d
        @NotNull
        /* renamed from: getPageData, reason: from getter */
        public PageData getF223518b() {
            return this.f223518b;
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.e
        public long getTopicId() {
            return this.f223517a.getTopicId();
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.e
        @NotNull
        /* renamed from: getTopicName */
        public String getTopicNameRef() {
            return this.f223517a.getTopicNameRef();
        }
    }

    @NotNull
    public static final f a(long j3, @NotNull String topicName, @NotNull String guildId, @NotNull String channelSign) {
        Intrinsics.checkNotNullParameter(topicName, "topicName");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelSign, "channelSign");
        return new f(j3, topicName, guildId, channelSign);
    }

    @NotNull
    public static final com.tencent.mobileqq.guild.feed.topic.a b(@NotNull final Fragment fragment, @NotNull final String traceID) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(traceID, "traceID");
        return new com.tencent.mobileqq.guild.feed.topic.a(fragment, traceID) { // from class: com.tencent.mobileqq.guild.feed.topic.TopicContextKt$newTopicDepends$1

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy panelCooperateHelper;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f223520b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Lazy lazy;
                this.f223520b = traceID;
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<FeedTopicListPartMorePanelCooperateHelper>() { // from class: com.tencent.mobileqq.guild.feed.topic.TopicContextKt$newTopicDepends$1$panelCooperateHelper$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final FeedTopicListPartMorePanelCooperateHelper invoke() {
                        return new FeedTopicListPartMorePanelCooperateHelper(Fragment.this);
                    }
                });
                this.panelCooperateHelper = lazy;
            }

            @Override // com.tencent.mobileqq.guild.feed.topic.a
            @NotNull
            public Map<String, Object> d() {
                Map<String, Object> mapOf;
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, this.f223520b));
                return mapOf;
            }

            @NotNull
            public final FeedTopicListPartMorePanelCooperateHelper e() {
                return (FeedTopicListPartMorePanelCooperateHelper) this.panelCooperateHelper.getValue();
            }

            @Override // com.tencent.mobileqq.guild.feed.topic.a
            @NotNull
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public FeedTopicListPartMorePanelCooperateHelper b() {
                return e();
            }
        };
    }

    @NotNull
    public static final com.tencent.mobileqq.guild.feed.topic.b c() {
        return new a();
    }

    @NotNull
    public static final com.tencent.mobileqq.guild.feed.topic.c d(@NotNull com.tencent.mobileqq.guild.feed.topic.a topicDepends, @NotNull com.tencent.mobileqq.guild.feed.topic.b topicGlobalDepends) {
        Intrinsics.checkNotNullParameter(topicDepends, "topicDepends");
        Intrinsics.checkNotNullParameter(topicGlobalDepends, "topicGlobalDepends");
        return new b(topicDepends, topicGlobalDepends);
    }

    @NotNull
    public static final com.tencent.mobileqq.guild.feed.topic.mvi.c e(@NotNull com.tencent.mobileqq.guild.feed.topic.d topicListSession) {
        Intrinsics.checkNotNullParameter(topicListSession, "topicListSession");
        return new c(topicListSession);
    }

    @NotNull
    public static final com.tencent.mobileqq.guild.feed.topic.d f(@NotNull e topicSession, @NotNull PageData pageData) {
        Intrinsics.checkNotNullParameter(topicSession, "topicSession");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        return new d(topicSession, pageData);
    }
}
