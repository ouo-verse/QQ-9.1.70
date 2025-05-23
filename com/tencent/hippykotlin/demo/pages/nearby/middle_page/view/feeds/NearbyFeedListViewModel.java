package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendOIDBRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.GetPOIFeedsRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPOIRepo;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.AsyncTaskTracker;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageDTReporter;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.FeedListViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.foundation.lazy.a;
import com.tencent.ntcompose.foundation.lazy.d;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.common.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import n25.l;
import org.apache.httpcore.message.TokenParser;
import p35.ah;
import p35.n;
import x25.j;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyFeedListViewModel extends FeedListViewModel {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final MutableState actionMenuFeed$delegate;
    public boolean createEventHandled;
    public final Set<String> exposedFeeds;
    public Set<String> feedIds;
    public String fetchCookies;
    public final MutableState isEnd$delegate;
    public boolean listExpanded;
    public AsyncTaskTracker<Unit> listExpandedWaitingTask;
    public a listState;
    public final ComposeFeedListViewModel listVm;
    public Map<String, String> notifyEventHandles;
    public final Lazy repo$delegate;
    public final MutableState tabOpened$delegate;
    public AsyncTaskTracker<Unit> tabOpenedWaitingTask;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NearbyFeedListViewModel(float f16, NBPMiddlePageDTReporter nBPMiddlePageDTReporter, ah ahVar) {
        super(f16, nBPMiddlePageDTReporter, ahVar);
        Lazy lazy;
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NBPPOIRepo>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewModel$repo$2
            @Override // kotlin.jvm.functions.Function0
            public final NBPPOIRepo invoke() {
                return new NBPPOIRepo();
            }
        });
        this.repo$delegate = lazy;
        this.fetchCookies = "";
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.actionMenuFeed$delegate = mutableStateOf$default;
        this.listVm = new ComposeFeedListViewModel(new Function1<Function2<? super Boolean, ? super Boolean, ? extends Unit>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewModel$listVm$1
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Function2<? super Boolean, ? super Boolean, ? extends Unit> function2) {
                KLog.INSTANCE.i("NearbyFeedListViewModel", "start to LoadMore");
                NearbyFeedListViewModel.this.onLoadMore(function2);
                return Unit.INSTANCE;
            }
        });
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isEnd$delegate = mutableStateOf$default2;
        this.listState = new a(0, 0.0f, 3, null);
        this.notifyEventHandles = new LinkedHashMap();
        this.feedIds = new LinkedHashSet();
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.tabOpened$delegate = mutableStateOf$default3;
        this.tabOpenedWaitingTask = new AsyncTaskTracker<>();
        this.listExpandedWaitingTask = new AsyncTaskTracker<>();
        this.exposedFeeds = new LinkedHashSet();
        markOpened();
    }

    public static final void access$onReportExpose(final NearbyFeedListViewModel nearbyFeedListViewModel, final n nVar, final float f16) {
        String decodeToString;
        if (nearbyFeedListViewModel.exposedFeeds.contains(nVar.f425193d)) {
            return;
        }
        nearbyFeedListViewModel.exposedFeeds.add(nVar.f425193d);
        if (f16 < nearbyFeedListViewModel.collapsedHeight) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u66dd\u5149 ");
            m3.append(nVar.f425193d);
            m3.append("  ");
            decodeToString = StringsKt__StringsJVMKt.decodeToString(nVar.f425197i.f30291a);
            m3.append(decodeToString);
            m3.append(TokenParser.SP);
            m3.append(f16);
            m3.append('/');
            m3.append(nearbyFeedListViewModel.collapsedHeight);
            kLog.d("NearbyFeedListViewModel", m3.toString());
            NBPMiddlePageDTReporter.reportElementImp$default(nearbyFeedListViewModel.dtReporter, "em_nearby_post_dynamic_feed", null, 6);
            return;
        }
        nearbyFeedListViewModel.listExpandedWaitingTask.executeOnDone(false, new Function1<Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewModel$onReportExpose$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Unit unit) {
                String decodeToString2;
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u5ef6\u8fdf\u66dd\u5149 ");
                m16.append(n.this.f425193d);
                m16.append(TokenParser.SP);
                decodeToString2 = StringsKt__StringsJVMKt.decodeToString(n.this.f425197i.f30291a);
                m16.append(decodeToString2);
                m16.append(TokenParser.SP);
                m16.append(f16);
                m16.append('/');
                m16.append(nearbyFeedListViewModel.collapsedHeight);
                kLog2.d("NearbyFeedListViewModel", m16.toString());
                NBPMiddlePageDTReporter.reportElementImp$default(nearbyFeedListViewModel.dtReporter, "em_nearby_post_dynamic_feed", null, 6);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$onShowActionMenu(NearbyFeedListViewModel nearbyFeedListViewModel, n nVar) {
        nearbyFeedListViewModel.getClass();
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onShowActionMenu "), nVar.f425193d, KLog.INSTANCE, "NearbyFeedListViewModel");
        nearbyFeedListViewModel.actionMenuFeed$delegate.setValue(nVar);
    }

    public final NearbyFeedItemViewModel getItemViewModel(String str) {
        BaseComposeCardViewModel baseComposeCardViewModel;
        n nVar;
        Iterator<BaseComposeCardViewModel> it = this.listVm.feedCardViewModelList.iterator();
        while (true) {
            if (!it.hasNext()) {
                baseComposeCardViewModel = null;
                break;
            }
            baseComposeCardViewModel = it.next();
            BaseComposeCardViewModel baseComposeCardViewModel2 = baseComposeCardViewModel;
            NearbyFeedItemViewModel nearbyFeedItemViewModel = baseComposeCardViewModel2 instanceof NearbyFeedItemViewModel ? (NearbyFeedItemViewModel) baseComposeCardViewModel2 : null;
            if (Intrinsics.areEqual((nearbyFeedItemViewModel == null || (nVar = nearbyFeedItemViewModel.feed) == null) ? null : nVar.f425193d, str)) {
                break;
            }
        }
        if (baseComposeCardViewModel instanceof NearbyFeedItemViewModel) {
            return (NearbyFeedItemViewModel) baseComposeCardViewModel;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isEnd() {
        return ((Boolean) this.isEnd$delegate.getValue()).booleanValue();
    }

    public final void markOpened() {
        this.tabOpened$delegate.setValue(Boolean.TRUE);
        this.tabOpenedWaitingTask.markDoneAndClearCbs(Unit.INSTANCE);
        if (this.listExpanded) {
            this.listExpanded = true;
            this.tabOpenedWaitingTask.executeOnDone(false, new NearbyFeedListViewModel$markExpanded$1(this));
        }
    }

    public final void onLoadMore(final Function2<? super Boolean, ? super Boolean, Unit> function2) {
        if (isEnd()) {
            if (function2 != null) {
                function2.invoke(Boolean.TRUE, Boolean.FALSE);
                return;
            }
            return;
        }
        NBPPOIRepo nBPPOIRepo = (NBPPOIRepo) this.repo$delegate.getValue();
        ah ahVar = this.poiInfo;
        String str = this.fetchCookies;
        final Function3<j, Integer, String, Unit> function3 = new Function3<j, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewModel$onLoadMore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(j jVar, Integer num, String str2) {
                boolean z16;
                int collectionSizeOrDefault;
                j jVar2 = jVar;
                int intValue = num.intValue();
                String str3 = str2;
                if (intValue == 0 && jVar2 != null) {
                    NearbyFeedListViewModel nearbyFeedListViewModel = NearbyFeedListViewModel.this;
                    nearbyFeedListViewModel.fetchCookies = jVar2.f447102f;
                    List<n> list = jVar2.f447100d;
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = list.iterator();
                    while (true) {
                        z16 = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (true ^ nearbyFeedListViewModel.feedIds.contains(((n) next).f425193d)) {
                            arrayList.add(next);
                        }
                    }
                    NearbyFeedListViewModel nearbyFeedListViewModel2 = NearbyFeedListViewModel.this;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        n nVar = (n) it5.next();
                        nearbyFeedListViewModel2.feedIds.add(nVar.f425193d);
                        arrayList2.add(new NearbyFeedItemViewModel(nVar, new NearbyFeedListViewModel$onLoadMore$1$newFeeds$2$1(nearbyFeedListViewModel2), new NearbyFeedListViewModel$onLoadMore$1$newFeeds$2$2(nearbyFeedListViewModel2), new NearbyFeedListViewModel$onLoadMore$1$newFeeds$2$3(nearbyFeedListViewModel2)));
                    }
                    NearbyFeedListViewModel.this.listVm.feedCardViewModelList.addAll(arrayList2);
                    NearbyFeedListViewModel nearbyFeedListViewModel3 = NearbyFeedListViewModel.this;
                    if (!jVar2.f447101e && !jVar2.f447100d.isEmpty()) {
                        z16 = false;
                    }
                    nearbyFeedListViewModel3.isEnd$delegate.setValue(Boolean.valueOf(z16));
                    Function2<Boolean, Boolean, Unit> function22 = function2;
                    if (function22 != null) {
                        function22.invoke(Boolean.valueOf(NearbyFeedListViewModel.this.isEnd()), Boolean.FALSE);
                    }
                } else {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("fetchPOIFeeds failure code:", intValue, ", message:", str3, ", rsp=");
                    m3.append(jVar2);
                    m3.append('}');
                    kLog.e("NearbyFeedListViewModel", m3.toString());
                    MutableState mutableState = NearbyFeedListViewModel.this.isEnd$delegate;
                    Boolean bool = Boolean.TRUE;
                    mutableState.setValue(bool);
                    Function2<Boolean, Boolean, Unit> function23 = function2;
                    if (function23 != null) {
                        function23.invoke(bool, Boolean.FALSE);
                    }
                }
                return Unit.INSTANCE;
            }
        };
        nBPPOIRepo.getClass();
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchPOIFeeds: poiId=");
        m3.append(ahVar.f425143d);
        m3.append(" poiName=");
        StringBuilder m16 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m3, ahVar.Q, " count=", 5, " cookies=");
        m16.append(str);
        kLog.i("NBPPOIRepo", m16.toString());
        GetPOIFeedsRequest getPOIFeedsRequest = new GetPOIFeedsRequest(ahVar, str);
        Function1<OIDBResponse<j>, Unit> function1 = new Function1<OIDBResponse<j>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPOIRepo$getPOIFeeds$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(OIDBResponse<j> oIDBResponse) {
                List<n> list;
                OIDBResponse<j> oIDBResponse2 = oIDBResponse;
                if (oIDBResponse2.success) {
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchPOIFeeds success, size=");
                    j jVar = oIDBResponse2.rsp;
                    m17.append((jVar == null || (list = jVar.f447100d) == null) ? null : Integer.valueOf(list.size()));
                    m17.append(" isEnd=");
                    j jVar2 = oIDBResponse2.rsp;
                    m17.append(jVar2 != null ? Boolean.valueOf(jVar2.f447101e) : null);
                    kLog2.i("NBPPOIRepo", m17.toString());
                } else {
                    KLog kLog3 = KLog.INSTANCE;
                    StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchPOIFeeds failure code:");
                    m18.append(oIDBResponse2.code);
                    m18.append(", message:");
                    m18.append(oIDBResponse2.f114186msg);
                    m18.append('}');
                    kLog3.e("NBPPOIRepo", m18.toString());
                }
                function3.invoke(oIDBResponse2.rsp, Integer.valueOf(oIDBResponse2.code), oIDBResponse2.f114186msg);
                return Unit.INSTANCE;
            }
        };
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(getPOIFeedsRequest, false, new NearbyApi$sendOIDBRequest$1(new APICallTechReporter(1, getPOIFeedsRequest.getCmd()), function1));
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.String>] */
    @Override // com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.FeedListViewModel, com.tencent.ntcompose.lifecycle.common.a
    public final void onStateChanged(c cVar, Lifecycle.Event event) {
        int i3 = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            for (Map.Entry entry : this.notifyEventHandles.entrySet()) {
                ((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule")).e((String) entry.getKey(), (String) entry.getValue());
            }
            return;
        }
        KLog.INSTANCE.i("NearbyFeedListViewModel", "onCreate and onLoadMore");
        if (this.createEventHandled) {
            return;
        }
        this.createEventHandled = true;
        onLoadMore(null);
        TimerKt.d(500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewModel$onStateChanged$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                final NearbyFeedListViewModel nearbyFeedListViewModel = NearbyFeedListViewModel.this;
                Map<String, String> map = nearbyFeedListViewModel.notifyEventHandles;
                com.tencent.kuikly.core.manager.c cVar2 = com.tencent.kuikly.core.manager.c.f117352a;
                map.put("onNearbyProFeedCommentCountChange", k.b((k) cVar2.g().acquireModule("KRNotifyModule"), "onNearbyProFeedCommentCountChange", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewModel$registerNotify$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        e eVar2 = eVar;
                        if (eVar2 != null) {
                            String p16 = eVar2.p("feedId");
                            int j3 = eVar2.j("commentCount");
                            NearbyFeedItemViewModel itemViewModel = NearbyFeedListViewModel.this.getItemViewModel(p16);
                            if (itemViewModel != null) {
                                itemViewModel.commentCount$delegate.setValue(Integer.valueOf(j3));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null));
                nearbyFeedListViewModel.notifyEventHandles.put("NearbyFeedLikeStatusChangedEvent", k.b((k) cVar2.g().acquireModule("KRNotifyModule"), "NearbyFeedLikeStatusChangedEvent", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewModel$registerNotify$2$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        e eVar2 = eVar;
                        if (eVar2 != null) {
                            String p16 = eVar2.p("feedId");
                            if (p16 == null) {
                                p16 = "";
                            }
                            int k3 = eVar2.k("count", 0);
                            int k16 = eVar2.k("isLike", 0);
                            NearbyFeedItemViewModel itemViewModel = NearbyFeedListViewModel.this.getItemViewModel(p16);
                            if (itemViewModel != null) {
                                boolean z16 = k16 == 1;
                                if (itemViewModel.meLiked != z16) {
                                    itemViewModel.meLiked = z16;
                                }
                                itemViewModel.likeNumber = k3;
                                itemViewModel.likeData.updateNumber(k3);
                                itemViewModel.likeData.updateLiked(z16);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null));
                nearbyFeedListViewModel.notifyEventHandles.put("onPublishFeedFinish", k.b((k) cVar2.g().acquireModule("KRNotifyModule"), "onPublishFeedFinish", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewModel$registerNotify$3$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        e eVar2 = eVar;
                        NearbyFeedListViewModel nearbyFeedListViewModel2 = NearbyFeedListViewModel.this;
                        if (eVar2 != null) {
                            nearbyFeedListViewModel2.getClass();
                            String p16 = eVar2.p("source");
                            KLog kLog = KLog.INSTANCE;
                            DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("[handlePublishFeedSuccess] source: ", p16, kLog, "NearbyFeedListViewModel");
                            if (!Intrinsics.areEqual(p16, "5")) {
                                DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("[handlePublishFeedSuccess] no need for source: ", p16, kLog, "NearbyFeedListViewModel");
                            } else {
                                l lVar = null;
                                try {
                                    byte[] a16 = d45.a.a(eVar2.p("statusFeed"));
                                    if (a16 != null) {
                                        lVar = (l) i.b(new l(null, null, null, null, null, null, null, 0L, null, false, 0, null, 0, null, null, 2097151), a16);
                                    }
                                } catch (Exception e16) {
                                    KLog.INSTANCE.e("NearbyFeedListViewModel", "[handlePublishFeedSuccess] decode feed error " + e16);
                                }
                                if (lVar == null) {
                                    KLog.INSTANCE.e("NearbyFeedListViewModel", "[handlePublishFeedSuccess] feed is null");
                                } else {
                                    KLog kLog2 = KLog.INSTANCE;
                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[handlePublishFeedSuccess] feedId: ");
                                    m3.append(lVar.f418092d);
                                    m3.append(", images size: ");
                                    m3.append(lVar.f418097m.size());
                                    kLog2.i("NearbyFeedListViewModel", m3.toString());
                                    nearbyFeedListViewModel2.listVm.feedCardViewModelList.add(0, new NearbyFeedItemViewModel(NearbyProUtilsKt.toStrangerFeed(lVar), new NearbyFeedListViewModel$handlePublishFeedSuccess$feedVm$1(nearbyFeedListViewModel2), new NearbyFeedListViewModel$handlePublishFeedSuccess$feedVm$2(nearbyFeedListViewModel2), new NearbyFeedListViewModel$handlePublishFeedSuccess$feedVm$3(nearbyFeedListViewModel2)));
                                    d.x(nearbyFeedListViewModel2.listState, 0, 0.0f, true, null, 10, null);
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null));
                nearbyFeedListViewModel.notifyEventHandles.put("NBPFeedDeleteEvent", k.b((k) cVar2.g().acquireModule("KRNotifyModule"), "NBPFeedDeleteEvent", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewModel$registerNotify$4$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        String str;
                        e eVar2 = eVar;
                        if (eVar2 == null || (str = eVar2.p("feedId")) == null) {
                            str = "";
                        }
                        NearbyFeedListViewModel nearbyFeedListViewModel2 = NearbyFeedListViewModel.this;
                        nearbyFeedListViewModel2.getClass();
                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("[handleDeleteFeedSuccess] feedId: ", str, KLog.INSTANCE, "NearbyFeedListViewModel");
                        NearbyFeedItemViewModel itemViewModel = nearbyFeedListViewModel2.getItemViewModel(str);
                        if (itemViewModel != null) {
                            nearbyFeedListViewModel2.listVm.feedCardViewModelList.remove(itemViewModel);
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null));
                return Unit.INSTANCE;
            }
        });
    }
}
