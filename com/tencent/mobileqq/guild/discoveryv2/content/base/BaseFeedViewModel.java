package com.tencent.mobileqq.guild.discoveryv2.content.base;

import androidx.annotation.CallSuper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreArgs;
import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreState;
import com.tencent.mobileqq.guild.discoveryv2.content.model.PullToRefreshArgs;
import com.tencent.mobileqq.guild.discoveryv2.content.model.PullToRefreshState;
import com.tencent.mobileqq.guild.discoveryv2.content.model.f;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendDataUpdateEvent;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendFeedsGuildData;
import com.tencent.mobileqq.guild.discoveryv2.content.util.DeleteRecommendData;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsSnapshot;
import com.tencent.mobileqq.guild.feed.event.GuildDetailViewDestroyEvent;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\\\u0010]J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0002J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0017J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tH\u0017J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0014J\u001e\u0010 \u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u001e\u0010\"\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0\u001dH\u0016J\b\u0010$\u001a\u00020#H\u0016J\u001e\u0010%\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dH\u0016J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H\u0016J\u000e\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020!J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u001eH\u0016J&\u00105\u001a\u00020\u00052\u0006\u00100\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u0001012\f\u00104\u001a\b\u0012\u0004\u0012\u0002030\u0017J\u0010\u00106\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H&J\u0010\u00107\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H&R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020!088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u00109R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001e0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010=R \u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00170;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010=R \u0010G\u001a\b\u0012\u0004\u0012\u00020\u00180B8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\"\u0010J\u001a\u00020#8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010S\u001a\u00020\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bQ\u0010RR\u0011\u0010W\u001a\u00020T8F\u00a2\u0006\u0006\u001a\u0004\bU\u0010VR\u001d\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00170X8F\u00a2\u0006\u0006\u001a\u0004\bY\u0010Z\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/base/BaseFeedViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/f;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendDataUpdateEvent;", "event", "", "Z1", "Lcom/tencent/mobileqq/guild/feed/event/GuildDetailViewDestroyEvent;", "X1", "", "feedId", "", "preferCount", "", "preferStatus", "R1", "Lcom/tencent/mobileqq/guild/discoveryv2/content/util/DeleteRecommendData;", "W1", "Lcom/tencent/mvi/base/route/j;", "message", "D0", "account", "onAccountChanged", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "i", "b2", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/h;", "observer", "b", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/j;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "l", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/i;", "pullToRefreshArgs", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/g;", "loadMoreArgs", "B", "pullToRefreshState", "f2", "loadMoreState", "e2", "tabType", "", "value", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationTab;", "tabList", "g2", "c2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/mobileqq/guild/util/cn;", "Lcom/tencent/mobileqq/guild/util/cn;", "pullToRefreshStateLiveData", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "loadMoreStateLiveData", "notifyContentListUpdatedLiveData", "D", "_liveTabList", "Ljava/util/LinkedList;", "E", "Ljava/util/LinkedList;", "S1", "()Ljava/util/LinkedList;", "contentList", UserInfo.SEX_FEMALE, "Z", "isLoading", "()Z", "d2", "(Z)V", "G", "Ljava/lang/String;", "accountUin", "getTag", "()Ljava/lang/String;", "tag", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "U1", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "Landroidx/lifecycle/LiveData;", "T1", "()Landroidx/lifecycle/LiveData;", "liveTabList", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class BaseFeedViewModel extends ViewModel implements com.tencent.mobileqq.guild.discoveryv2.content.model.f {

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isLoading;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String accountUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cn<PullToRefreshState> pullToRefreshStateLiveData = new cn<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<LoadMoreState> loadMoreStateLiveData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> notifyContentListUpdatedLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<IGProNavigationTab>> _liveTabList = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LinkedList<h> contentList = new LinkedList<>();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function2<GuildDetailViewDestroyEvent, Continuation<? super Unit>, Object>, SuspendFunction {
        AnonymousClass1(Object obj) {
            super(2, obj, BaseFeedViewModel.class, "handleGuildDetailViewDestroyEvent", "handleGuildDetailViewDestroyEvent(Lcom/tencent/mobileqq/guild/feed/event/GuildDetailViewDestroyEvent;)V", 4);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull GuildDetailViewDestroyEvent guildDetailViewDestroyEvent, @NotNull Continuation<? super Unit> continuation) {
            return BaseFeedViewModel.M1((BaseFeedViewModel) this.receiver, guildDetailViewDestroyEvent, continuation);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel$2, reason: invalid class name */
    /* loaded from: classes13.dex */
    /* synthetic */ class AnonymousClass2 extends AdaptedFunctionReference implements Function2<RecommendDataUpdateEvent, Continuation<? super Unit>, Object>, SuspendFunction {
        AnonymousClass2(Object obj) {
            super(2, obj, BaseFeedViewModel.class, "handleRecommendDataUpdate", "handleRecommendDataUpdate(Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendDataUpdateEvent;)V", 4);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull RecommendDataUpdateEvent recommendDataUpdateEvent, @NotNull Continuation<? super Unit> continuation) {
            return BaseFeedViewModel.N1((BaseFeedViewModel) this.receiver, recommendDataUpdateEvent, continuation);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel$3, reason: invalid class name */
    /* loaded from: classes13.dex */
    /* synthetic */ class AnonymousClass3 extends AdaptedFunctionReference implements Function2<DeleteRecommendData, Continuation<? super Unit>, Object>, SuspendFunction {
        AnonymousClass3(Object obj) {
            super(2, obj, BaseFeedViewModel.class, "handleDeleteRecommendDataEvent", "handleDeleteRecommendDataEvent(Lcom/tencent/mobileqq/guild/discoveryv2/content/util/DeleteRecommendData;)V", 4);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull DeleteRecommendData deleteRecommendData, @NotNull Continuation<? super Unit> continuation) {
            return BaseFeedViewModel.L1((BaseFeedViewModel) this.receiver, deleteRecommendData, continuation);
        }
    }

    public BaseFeedViewModel() {
        String g16 = ch.g();
        Intrinsics.checkNotNullExpressionValue(g16, "accountUin()");
        this.accountUin = g16;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus, "getInstance()");
        SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus2, "getInstance()");
        SimpleEventBus simpleEventBus3 = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus3, "getInstance()");
        FlowKt.launchIn(FlowKt.merge(FlowKt.onEach(FlowKt.callbackFlow(new BaseFeedViewModel$special$$inlined$eventFlow$1(simpleEventBus, null)), new AnonymousClass1(this)), FlowKt.onEach(FlowKt.callbackFlow(new BaseFeedViewModel$special$$inlined$eventFlow$2(simpleEventBus2, null)), new AnonymousClass2(this)), FlowKt.onEach(FlowKt.callbackFlow(new BaseFeedViewModel$special$$inlined$eventFlow$3(simpleEventBus3, null)), new AnonymousClass3(this))), ViewModelKt.getViewModelScope(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object L1(BaseFeedViewModel baseFeedViewModel, DeleteRecommendData deleteRecommendData, Continuation continuation) {
        baseFeedViewModel.W1(deleteRecommendData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object M1(BaseFeedViewModel baseFeedViewModel, GuildDetailViewDestroyEvent guildDetailViewDestroyEvent, Continuation continuation) {
        baseFeedViewModel.X1(guildDetailViewDestroyEvent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object N1(BaseFeedViewModel baseFeedViewModel, RecommendDataUpdateEvent recommendDataUpdateEvent, Continuation continuation) {
        baseFeedViewModel.Z1(recommendDataUpdateEvent);
        return Unit.INSTANCE;
    }

    private final void R1(String feedId, long preferCount, int preferStatus) {
        int collectionSizeOrDefault;
        boolean z16;
        boolean z17;
        QLog.i(getTag(), 1, "feedLikeUpdate: feedId=" + feedId + ", preferCount=" + preferCount + ", preferStatus=" + preferStatus);
        LinkedList<h> linkedList = this.contentList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(linkedList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        boolean z18 = false;
        for (h hVar : linkedList) {
            if (hVar instanceof RecommendAbsFeedData) {
                RecommendAbsFeedData recommendAbsFeedData = (RecommendAbsFeedData) hVar;
                if (Intrinsics.areEqual(recommendAbsFeedData.getIdd(), feedId)) {
                    if (recommendAbsFeedData.getMUpVoteStatus() != preferStatus) {
                        recommendAbsFeedData.setUpVoteStatus(preferStatus);
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (preferCount >= 0 && recommendAbsFeedData.getMUpVoteCount() != preferCount) {
                        recommendAbsFeedData.setUpVoteCount(preferCount);
                        z17 = true;
                    }
                    if (z17) {
                        recommendAbsFeedData.notifyChanged();
                        z18 = true;
                    }
                }
            } else if (hVar instanceof RecommendFeedsGuildData) {
                RecommendFeedsGuildData recommendFeedsGuildData = (RecommendFeedsGuildData) hVar;
                boolean z19 = false;
                for (RecommendAbsFeedData recommendAbsFeedData2 : recommendFeedsGuildData.getRecommendFeeds()) {
                    if (Intrinsics.areEqual(recommendAbsFeedData2.getIdd(), feedId)) {
                        if (recommendAbsFeedData2.getMUpVoteStatus() != preferStatus) {
                            recommendAbsFeedData2.setUpVoteStatus(preferStatus);
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (preferCount >= 0 && recommendAbsFeedData2.getMUpVoteCount() != preferCount) {
                            recommendAbsFeedData2.setUpVoteCount(preferCount);
                            z16 = true;
                        }
                        if (z16) {
                            recommendAbsFeedData2.notifyChanged();
                            z18 = true;
                            z19 = true;
                        }
                    }
                }
                hVar = z19 ? RecommendFeedsGuildData.copy$default(recommendFeedsGuildData, null, null, null, null, recommendFeedsGuildData.getSeq() + 1, 15, null) : recommendFeedsGuildData;
            }
            arrayList.add(hVar);
        }
        if (z18) {
            QLog.i(getTag(), 1, "feedLikeUpdate: listUpdated");
            this.contentList.clear();
            this.contentList.addAll(arrayList);
            b2();
        }
    }

    private final void W1(DeleteRecommendData event) {
        if (this.contentList.remove(event.getData())) {
            b2();
        }
    }

    private final void X1(GuildDetailViewDestroyEvent event) {
        String feedId = event.getFeedId();
        Intrinsics.checkNotNullExpressionValue(feedId, "event.feedId");
        R1(feedId, event.getPreferCount(), event.getPreferStatus());
    }

    private final void Z1(RecommendDataUpdateEvent event) {
        LinkedList<h> linkedList = this.contentList;
        boolean z16 = true;
        if (!(linkedList instanceof Collection) || !linkedList.isEmpty()) {
            Iterator<T> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual((h) it.next(), event.getData())) {
                    z16 = false;
                    break;
                }
            }
        }
        if (z16) {
            String idd = event.getData().getIdd();
            Intrinsics.checkNotNullExpressionValue(idd, "event.data.idd");
            R1(idd, event.getData().getMUpVoteCount(), event.getData().getMUpVoteStatus());
        }
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.model.f
    public void B(@NotNull LoadMoreArgs loadMoreArgs) {
        Intrinsics.checkNotNullParameter(loadMoreArgs, "loadMoreArgs");
        if (this.isLoading) {
            return;
        }
        LoadMoreState value = this.loadMoreStateLiveData.getValue();
        if (value != null) {
            value.f(false);
        }
        a2(loadMoreArgs);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.model.f
    public void C(@NotNull PullToRefreshArgs pullToRefreshArgs) {
        Intrinsics.checkNotNullParameter(pullToRefreshArgs, "pullToRefreshArgs");
        c2(pullToRefreshArgs);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.model.f
    @CallSuper
    public void D0(@NotNull com.tencent.mvi.base.route.j message) {
        Intrinsics.checkNotNullParameter(message, "message");
        f.a.a(this, message);
        if (!Intrinsics.areEqual(this.accountUin, ch.g())) {
            String g16 = ch.g();
            Intrinsics.checkNotNullExpressionValue(g16, "accountUin()");
            this.accountUin = g16;
            this.contentList.clear();
        }
        String g17 = ch.g();
        Intrinsics.checkNotNullExpressionValue(g17, "accountUin()");
        this.accountUin = g17;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final LinkedList<h> S1() {
        return this.contentList;
    }

    @NotNull
    public final LiveData<List<IGProNavigationTab>> T1() {
        return this._liveTabList;
    }

    @NotNull
    public final IGPSService U1() {
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        return (IGPSService) S0;
    }

    public abstract void a2(@NotNull LoadMoreArgs loadMoreArgs);

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.model.f
    public void b(@NotNull LifecycleOwner owner, @NotNull Observer<LoadMoreState> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.loadMoreStateLiveData.observe(owner, observer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b2() {
        this.notifyContentListUpdatedLiveData.setValue(Long.valueOf(Random.INSTANCE.nextLong()));
    }

    public abstract void c2(@NotNull PullToRefreshArgs pullToRefreshArgs);

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.model.f
    public void d(@NotNull LifecycleOwner owner, @NotNull Observer<Long> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.notifyContentListUpdatedLiveData.observe(owner, observer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d2(boolean z16) {
        this.isLoading = z16;
    }

    public void e2(@NotNull LoadMoreState loadMoreState) {
        Intrinsics.checkNotNullParameter(loadMoreState, "loadMoreState");
        this.loadMoreStateLiveData.setValue(loadMoreState);
    }

    public final void f2(@NotNull PullToRefreshState pullToRefreshState) {
        Intrinsics.checkNotNullParameter(pullToRefreshState, "pullToRefreshState");
        this.pullToRefreshStateLiveData.setValue(pullToRefreshState);
    }

    public final void g2(int tabType, @Nullable byte[] value, @NotNull List<? extends IGProNavigationTab> tabList) {
        Intrinsics.checkNotNullParameter(tabList, "tabList");
        if (tabList.isEmpty()) {
            return;
        }
        TabsSnapshot.f217705a.e(tabType, value, tabList);
        this._liveTabList.setValue(tabList);
    }

    @NotNull
    public abstract String getTag();

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.model.f
    @NotNull
    public List<h> i() {
        return this.contentList;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.model.f
    public boolean l() {
        LoadMoreState value = this.loadMoreStateLiveData.getValue();
        if (value == null || !value.getIsCompleted()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.model.f
    @CallSuper
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.accountUin = account;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.model.f
    public void q(@NotNull LifecycleOwner owner, @NotNull Observer<PullToRefreshState> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.pullToRefreshStateLiveData.observe(owner, observer);
    }
}
