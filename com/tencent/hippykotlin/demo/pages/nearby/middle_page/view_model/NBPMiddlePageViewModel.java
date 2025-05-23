package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.Query;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLngExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPOIRepo;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.MiniAppUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.TencentMapUtils;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageConfig;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageDTReporter;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListViewModel$markExpanded$1;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewModel$markExpanded$1;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.lazy.d;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.common.a;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import l25.b;
import p35.af;
import p35.ah;
import x25.l;
import x25.m;
import x25.n;

/* loaded from: classes31.dex */
public final class NBPMiddlePageViewModel extends g implements a {
    public static final Companion Companion = new Companion();
    public final MutableState activeUserCount$delegate;
    public aa<?> backgroundRef;
    public MutableState<Float> blurDegree;
    public final Lazy channelFeedsVm$delegate;
    public final float collapsedListHeight;
    public final Lazy config$delegate;
    public aa<v> containerRef;
    public final MutableState distance$delegate;
    public final Lazy dtReporter$delegate;
    public MutableState<Boolean> fadeOutAnimation;
    public final MutableState feedAreaHeightState$delegate;
    public final d feedAreaListViewState;
    public boolean hasCanceledToday;
    public MutableState<Boolean> hasLightThisPlace;
    public float headerHeight;
    public final float initListHeight;
    public final m initialData = null;
    public MutableState<Boolean> isFirstEnter;
    public float lastSetBlurDegree;
    public long lightedTimestamps;
    public float mainListContentOffsetY;
    public List<n> myTags;
    public final float navBarHeight;
    public final Lazy nearbyFeedsVm$delegate;
    public Map<String, String> notifyEventHandles;
    public final com.tencent.kuikly.core.pager.g pageData;
    public final float placeProfileHeight;
    public final ah poi;
    public final MutableState poiData$delegate;
    public final Lazy repo$delegate;
    public MutableState<Boolean> showLoadingView;
    public MutableState<Boolean> showPopView;
    public final SnapshotStateList<TabViewModel<FeedListViewModel>> tabList;
    public final MutableState<Integer> tabSelectedIndex;
    public SnapshotStateMap<Long, h> tagsColorMap;
    public SnapshotStateMap<Long, Long> tagsCountMap;
    public List<aa<?>> viewRefList;

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final boolean containsPoint(com.tencent.kuikly.core.layout.d dVar, float f16, float f17) {
            if (f16 >= dVar.getX()) {
                if (f16 <= dVar.getWidth() + dVar.getX() && f17 >= dVar.getY()) {
                    if (f17 <= dVar.getHeight() + dVar.getY()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public NBPMiddlePageViewModel(ah ahVar, com.tencent.kuikly.core.pager.g gVar) {
        MutableState<Integer> mutableStateOf$default;
        Lazy lazy;
        Lazy lazy2;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState<Boolean> mutableStateOf$default4;
        Lazy lazy3;
        MutableState<Boolean> mutableStateOf$default5;
        MutableState<Boolean> mutableStateOf$default6;
        MutableState<Boolean> mutableStateOf$default7;
        MutableState<Boolean> mutableStateOf$default8;
        MutableState mutableStateOf$default9;
        MutableState<Float> mutableStateOf$default10;
        MutableState mutableStateOf$default11;
        Lazy lazy4;
        Lazy lazy5;
        this.poi = ahVar;
        this.pageData = gVar;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.tabSelectedIndex = mutableStateOf$default;
        this.initListHeight = ((gVar.l() - 44.0f) - gVar.getStatusBarHeight()) - 56.0f;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NBPMiddlePageConfig>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$config$2
            @Override // kotlin.jvm.functions.Function0
            public final NBPMiddlePageConfig invoke() {
                String stringFromQQCommonConfig = QQNearbyModule.Companion.getInstance().getStringFromQQCommonConfig("nbp_middle_page", "{}");
                KLog.INSTANCE.i("NBPMiddlePageConfig", "loaded  : " + stringFromQQCommonConfig);
                String str = "/modules/router-uni/index?path=/uniapp/modules/poi-list/pages/index/index&query=poiId%3D[POI_ID]%26fromSource%3Dqqpos_landmarks";
                try {
                    str = new e(stringFromQQCommonConfig).q("tmap_poipage_path", "/modules/router-uni/index?path=/uniapp/modules/poi-list/pages/index/index&query=poiId%3D[POI_ID]%26fromSource%3Dqqpos_landmarks");
                } catch (Exception e16) {
                    KLog.INSTANCE.e("NBPMiddlePageConfig", "load failed " + e16);
                }
                return new NBPMiddlePageConfig(str);
            }
        });
        this.config$delegate = lazy;
        float statusBarHeight = gVar.getStatusBarHeight() + 44.0f;
        this.navBarHeight = statusBarHeight;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<NBPMiddlePageDTReporter>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$dtReporter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final NBPMiddlePageDTReporter invoke() {
                return new NBPMiddlePageDTReporter(NBPMiddlePageViewModel.this.pageData);
            }
        });
        this.dtReporter$delegate = lazy2;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.poiData$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Double.valueOf(0.0d), null, 2, null);
        this.distance$delegate = mutableStateOf$default3;
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isFirstEnter = mutableStateOf$default4;
        this.myTags = new ArrayList();
        this.tagsColorMap = SnapshotStateKt.mutableStateMapOf();
        this.tagsCountMap = SnapshotStateKt.mutableStateMapOf();
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<NBPPOIRepo>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$repo$2
            @Override // kotlin.jvm.functions.Function0
            public final NBPPOIRepo invoke() {
                return new NBPPOIRepo();
            }
        });
        this.repo$delegate = lazy3;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.fadeOutAnimation = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showPopView = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.hasLightThisPlace = mutableStateOf$default7;
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showLoadingView = mutableStateOf$default8;
        float max = Math.max(gVar.g() * 0.35f, statusBarHeight + 200.0f);
        this.placeProfileHeight = max;
        this.collapsedListHeight = (gVar.l() - max) - 56.0f;
        mutableStateOf$default9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(1, null, 2, null);
        this.feedAreaHeightState$delegate = mutableStateOf$default9;
        this.feedAreaListViewState = new d(0, 0.0f, 3, null);
        mutableStateOf$default10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.blurDegree = mutableStateOf$default10;
        this.viewRefList = new ArrayList();
        mutableStateOf$default11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
        this.activeUserCount$delegate = mutableStateOf$default11;
        this.notifyEventHandles = new LinkedHashMap();
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ChannelFeedListViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$channelFeedsVm$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ChannelFeedListViewModel invoke() {
                b bVar;
                m poiData = NBPMiddlePageViewModel.this.getPoiData();
                if (poiData == null || (bVar = poiData.I) == null) {
                    m poiData2 = NBPMiddlePageViewModel.this.getPoiData();
                    bVar = new b(poiData2 != null ? poiData2.f447117i : 0L, 6);
                }
                NBPMiddlePageViewModel nBPMiddlePageViewModel = NBPMiddlePageViewModel.this;
                return new ChannelFeedListViewModel(nBPMiddlePageViewModel.collapsedListHeight, nBPMiddlePageViewModel.getDtReporter(), bVar, NBPMiddlePageViewModel.this.poi);
            }
        });
        this.channelFeedsVm$delegate = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<NearbyFeedListViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$nearbyFeedsVm$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final NearbyFeedListViewModel invoke() {
                NBPMiddlePageViewModel nBPMiddlePageViewModel = NBPMiddlePageViewModel.this;
                return new NearbyFeedListViewModel(nBPMiddlePageViewModel.collapsedListHeight, nBPMiddlePageViewModel.getDtReporter(), NBPMiddlePageViewModel.this.poi);
            }
        });
        this.nearbyFeedsVm$delegate = lazy5;
        this.tabList = SnapshotStateKt.mutableStateListOf();
    }

    public final boolean canLightPoi(boolean z16) {
        l lVar;
        m poiData = getPoiData();
        if ((poiData == null || (lVar = poiData.E) == null || !lVar.f447111f) ? false : true) {
            return true;
        }
        getDistance();
        if (Double.compare(getDistance(), 500.1d) <= 0) {
            return true;
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Distance is too far: ");
        m3.append(getDistance());
        kLog.i("NBPMiddlePageViewModel", m3.toString());
        if (z16) {
            Utils.INSTANCE.currentBridgeModule().qToast("\u4f60\u4e0d\u5728\u6b64\u5730\u9644\u8fd1\u54e6", QToastMode.Info);
        }
        return false;
    }

    public final boolean enableTencentMapMiniApp() {
        return !AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(c.f117352a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long getActiveUserCount() {
        return ((Number) this.activeUserCount$delegate.getValue()).longValue();
    }

    public final boolean getBindChannel() {
        m poiData = getPoiData();
        return (poiData != null ? poiData.f447117i : 0L) > 0;
    }

    public final ChannelFeedListViewModel getChannelFeedsVm() {
        return (ChannelFeedListViewModel) this.channelFeedsVm$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final double getDistance() {
        return ((Number) this.distance$delegate.getValue()).doubleValue();
    }

    public final NBPMiddlePageDTReporter getDtReporter() {
        return (NBPMiddlePageDTReporter) this.dtReporter$delegate.getValue();
    }

    public final NearbyFeedListViewModel getNearbyFeedsVm() {
        return (NearbyFeedListViewModel) this.nearbyFeedsVm$delegate.getValue();
    }

    public final float getPageListHeight() {
        int intValue = this.tabSelectedIndex.getValue().intValue();
        SnapshotStateList<TabViewModel<FeedListViewModel>> snapshotStateList = this.tabList;
        if (snapshotStateList != null && intValue >= 0 && intValue < snapshotStateList.size()) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("getPageListHeight selectedIndex=", intValue, ", height:");
            m3.append(this.tabList.get(intValue).listContentHeight.getValue().floatValue());
            kLog.i("NBPMiddlePageViewModel", m3.toString());
            return this.tabList.get(intValue).listContentHeight.getValue().floatValue();
        }
        return com.tencent.ntcompose.activity.b.a().getPageData().l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final m getPoiData() {
        return (m) this.poiData$delegate.getValue();
    }

    public final String getPoiId() {
        ah ahVar;
        String str;
        m poiData = getPoiData();
        return (poiData == null || (ahVar = poiData.f447113d) == null || (str = ahVar.f425143d) == null) ? "" : str;
    }

    public final NBPPOIRepo getRepo() {
        return (NBPPOIRepo) this.repo$delegate.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<x25.n>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.List<x25.n>, java.util.ArrayList] */
    public final void initPoiData(m mVar) {
        af afVar;
        boolean z16;
        h color$default;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("initPoiData poiKey=");
        ah ahVar = mVar.f447113d;
        m3.append(ahVar != null ? ahVar.R : null);
        m3.append(", poiName = ");
        ah ahVar2 = mVar.f447113d;
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, ahVar2 != null ? ahVar2.Q : null, kLog, "NBPMiddlePageViewModel");
        this.poiData$delegate.setValue(mVar);
        setActiveUserCount(mVar.f447115f);
        this.myTags.addAll(mVar.f447118m);
        this.hasLightThisPlace.setValue(Boolean.valueOf(mVar.C));
        l lVar = mVar.E;
        this.lightedTimestamps = !(lVar != null && lVar.f447109d) ? 0L : lVar.f447110e;
        SnapshotStateMap<Long, h> mutableStateMapOf = SnapshotStateKt.mutableStateMapOf();
        for (n nVar : mVar.f447114e) {
            ?? r85 = this.myTags;
            if (!(r85 instanceof Collection) || !r85.isEmpty()) {
                Iterator it = r85.iterator();
                while (it.hasNext()) {
                    if (((n) it.next()).f447119d == nVar.f447119d) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (z16) {
                color$default = QUIToken.color$default("fill_allwhite_strong");
            } else {
                color$default = QUIToken.color$default("fill_allwhite_weak");
            }
            mutableStateMapOf.put(Long.valueOf(nVar.f447119d), color$default);
        }
        this.tagsColorMap = mutableStateMapOf;
        SnapshotStateMap<Long, Long> mutableStateMapOf2 = SnapshotStateKt.mutableStateMapOf();
        for (n nVar2 : mVar.f447114e) {
            mutableStateMapOf2.put(Long.valueOf(nVar2.f447119d), Long.valueOf(nVar2.f447121f));
        }
        this.tagsCountMap = mutableStateMapOf2;
        ah ahVar3 = mVar.f447113d;
        if (ahVar3 != null && (afVar = ahVar3.C) != null) {
            NBPLatLng latLng = NBPLatLngExtKt.toLatLng(afVar);
            this.distance$delegate.setValue(Double.valueOf(TencentMapUtils.INSTANCE.meterDistanceBetween(latLng, UserDataManager.INSTANCE.getUserSelfInfo().latLng)));
            KLog kLog2 = KLog.INSTANCE;
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u66f4\u65b0 ");
            m16.append(this.poi.Q);
            m16.append(" gps=");
            m16.append(latLng);
            m16.append(" distance=");
            m16.append(getDistance());
            m16.append('\u7c73');
            kLog2.i("NBPMiddlePageViewModel", m16.toString());
        }
        if (mVar.f447117i > 0) {
            TabViewModel<FeedListViewModel> tabViewModel = new TabViewModel<>();
            tabViewModel.tabTitle = "\u9891\u9053";
            tabViewModel.listContentHeight.setValue(Float.valueOf(this.initListHeight));
            getChannelFeedsVm();
            this.tabList.add(tabViewModel);
        }
        NBPMiddlePageDTReporter dtReporter = getDtReporter();
        dtReporter.poiData = mVar;
        dtReporter.setupTask.markDone(Unit.INSTANCE);
    }

    public final void launchTencentMapNavigation() {
        Map mapOf;
        if (enableTencentMapMiniApp()) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("launchTencentMapNavigation poiId: ");
            m3.append(getPoiId());
            kLog.i("NBPMiddlePageViewModel", m3.toString());
            af afVar = this.poi.C;
            if (afVar != null) {
                NBPLatLng latLng = NBPLatLngExtKt.toLatLng(afVar);
                NBPUserSelfInfo userSelfInfo = UserDataManager.INSTANCE.getUserSelfInfo();
                String valueOf = String.valueOf(userSelfInfo.latLng.latitude);
                String valueOf2 = String.valueOf(userSelfInfo.latLng.longitude);
                String str = userSelfInfo.locationName;
                String valueOf3 = String.valueOf(latLng.latitude);
                String valueOf4 = String.valueOf(latLng.longitude);
                String str2 = this.poi.Q;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("/modules/route/pages/index/index?");
                e eVar = new e();
                e m17 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("latitude", valueOf, "longitude", valueOf2);
                m17.v("strName", str);
                eVar.v("startPos", m17);
                e eVar2 = new e();
                eVar2.v("latitude", valueOf3);
                eVar2.v("longitude", valueOf4);
                eVar2.v("strName", str2);
                eVar.v("endPos", eVar2);
                eVar.t("elec", com.tencent.kuikly.core.base.d.b(false));
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("from", "qqpos_landmarks"), TuplesKt.to("option", eVar.toString()));
                m16.append(String.valueOf(new Query(mapOf)));
                String sb5 = m16.toString();
                kLog.d("TencentMapUtils", "launchTMapRouteMiniApp: " + sb5);
                MiniAppUtils.launch$default(sb5);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r13v4, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.String>] */
    @Override // com.tencent.ntcompose.lifecycle.common.a
    public final void onStateChanged(com.tencent.ntcompose.lifecycle.common.c cVar, Lifecycle.Event event) {
        final boolean z16 = false;
        if (event == Lifecycle.Event.ON_CREATE) {
            KLog.INSTANCE.i("NBPMiddlePageViewModel", OperateCustomButton.OPERATE_CREATE);
            TabViewModel<FeedListViewModel> tabViewModel = new TabViewModel<>();
            tabViewModel.tabTitle = "\u9644\u8fd1";
            tabViewModel.listContentHeight.setValue(Float.valueOf(this.initListHeight));
            getNearbyFeedsVm();
            this.tabList.add(tabViewModel);
            m mVar = this.initialData;
            if (mVar != null) {
                initPoiData(mVar);
                return;
            }
            MutableState<Boolean> mutableState = this.isFirstEnter;
            Utils utils = Utils.INSTANCE;
            CacheModule cacheModule = utils.cacheModule("");
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("is_first_enter");
            UserDataManager userDataManager = UserDataManager.INSTANCE;
            m3.append(userDataManager.getUserSelfInfo().tid);
            Integer num = cacheModule.getInt(m3.toString());
            final boolean z17 = true;
            mutableState.setValue(Boolean.valueOf(num == null || num.intValue() != 1));
            if (this.isFirstEnter.getValue().booleanValue()) {
                CacheModule cacheModule2 = utils.cacheModule("");
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("is_first_enter");
                m16.append(userDataManager.getUserSelfInfo().tid);
                cacheModule2.setInt(m16.toString(), 1);
                TimerKt.d(3000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$refreshFirstEntryStatus$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        NBPMiddlePageViewModel.this.isFirstEnter.setValue(Boolean.FALSE);
                        return Unit.INSTANCE;
                    }
                });
            }
            NBPPOIRepo repo = getRepo();
            ah ahVar = this.poi;
            userDataManager.getUserSelfInfo();
            repo.getPOIDetail(ahVar, NearbyProUtilsKt.getCoord(), new Function3<x25.h, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$onCreate$1
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(x25.h hVar, Integer num2, String str) {
                    m mVar2;
                    ah ahVar2;
                    x25.h hVar2 = hVar;
                    int intValue = num2.intValue();
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getPOIDetail rsp poiKey="), (hVar2 == null || (mVar2 = hVar2.f447095e) == null || (ahVar2 = mVar2.f447113d) == null) ? null : ahVar2.R, ", code=", intValue, ", msg="), str, KLog.INSTANCE, "NBPMiddlePageViewModel");
                    if (intValue == 0) {
                        if ((hVar2 != null ? hVar2.f447095e : null) != null) {
                            m mVar3 = hVar2.f447095e;
                            if (mVar3 != null) {
                                NBPMiddlePageViewModel.this.initPoiData(mVar3);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    af afVar = NBPMiddlePageViewModel.this.poi.C;
                    if (afVar != null) {
                        NBPMiddlePageViewModel.this.distance$delegate.setValue(Double.valueOf(TencentMapUtils.INSTANCE.meterDistanceBetween(NBPLatLngExtKt.toLatLng(afVar), UserDataManager.INSTANCE.getUserSelfInfo().latLng)));
                    }
                    return Unit.INSTANCE;
                }
            });
            Map<String, String> map = this.notifyEventHandles;
            c cVar2 = c.f117352a;
            map.put("onPublishFeedFinish", k.b((k) cVar2.g().acquireModule("KRNotifyModule"), "onPublishFeedFinish", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$registerNotify$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    e eVar2 = eVar;
                    NBPMiddlePageViewModel nBPMiddlePageViewModel = NBPMiddlePageViewModel.this;
                    if (eVar2 != null) {
                        nBPMiddlePageViewModel.getClass();
                        String p16 = eVar2.p("source");
                        KLog kLog = KLog.INSTANCE;
                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("[handlePublishFeedSuccess] source: ", p16, kLog, "NBPMiddlePageViewModel");
                        if (!Intrinsics.areEqual(p16, "5")) {
                            DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("[handlePublishFeedSuccess] no need for source: ", p16, kLog, "NBPMiddlePageViewModel");
                        } else if (!nBPMiddlePageViewModel.hasLightThisPlace.getValue().booleanValue()) {
                            nBPMiddlePageViewModel.hasLightThisPlace.setValue(Boolean.TRUE);
                            nBPMiddlePageViewModel.lightedTimestamps = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
                            nBPMiddlePageViewModel.setActiveUserCount(nBPMiddlePageViewModel.getActiveUserCount() + 1);
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, 2, null));
            this.notifyEventHandles.put("NBPNotifyPublishAppearEvent", k.b((k) cVar2.g().acquireModule("KRNotifyModule"), "NBPNotifyPublishAppearEvent", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$registerNotify$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    NBPMiddlePageViewModel.this.showLoadingView.setValue(Boolean.FALSE);
                    return Unit.INSTANCE;
                }
            }, 2, null));
            final NBPMiddlePageDTReporter dtReporter = getDtReporter();
            dtReporter.setupTask.executeOnDone(false, new Function1<Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageDTReporter$reportPageExposure$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Unit unit) {
                    String str;
                    if (z17) {
                        str = "dt_pgin";
                    } else {
                        str = "dt_pgout";
                    }
                    e access$getDTReportPageParams = NBPMiddlePageDTReporter.access$getDTReportPageParams(dtReporter);
                    access$getDTReportPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, access$getDTReportPageParams);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            KLog.INSTANCE.i("NBPMiddlePageViewModel", "destroy");
            for (Map.Entry entry : this.notifyEventHandles.entrySet()) {
                ((k) c.f117352a.g().acquireModule("KRNotifyModule")).e((String) entry.getKey(), (String) entry.getValue());
            }
            final NBPMiddlePageDTReporter dtReporter2 = getDtReporter();
            dtReporter2.setupTask.executeOnDone(false, new Function1<Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageDTReporter$reportPageExposure$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Unit unit) {
                    String str;
                    if (z16) {
                        str = "dt_pgin";
                    } else {
                        str = "dt_pgout";
                    }
                    e access$getDTReportPageParams = NBPMiddlePageDTReporter.access$getDTReportPageParams(dtReporter2);
                    access$getDTReportPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, access$getDTReportPageParams);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final void setActiveUserCount(long j3) {
        this.activeUserCount$delegate.setValue(Long.valueOf(j3));
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.List<kotlin.jvm.functions.Function1<T, kotlin.Unit>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.List<kotlin.jvm.functions.Function1<T, kotlin.Unit>>, java.util.ArrayList] */
    public final void setFeedsAreaState(int i3) {
        this.feedAreaHeightState$delegate.setValue(Integer.valueOf(i3));
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            NearbyFeedListViewModel nearbyFeedsVm = getNearbyFeedsVm();
            nearbyFeedsVm.listExpanded = true;
            nearbyFeedsVm.tabOpenedWaitingTask.executeOnDone(false, new NearbyFeedListViewModel$markExpanded$1(nearbyFeedsVm));
            ChannelFeedListViewModel channelFeedsVm = getChannelFeedsVm();
            channelFeedsVm.listExpanded = true;
            channelFeedsVm.tabOpenedWaitingTask.executeOnDone(false, new ChannelFeedListViewModel$markExpanded$1(channelFeedsVm));
            return;
        }
        NearbyFeedListViewModel nearbyFeedsVm2 = getNearbyFeedsVm();
        nearbyFeedsVm2.listExpanded = false;
        nearbyFeedsVm2.listExpandedWaitingTask.reset(false);
        nearbyFeedsVm2.tabOpenedWaitingTask.waitingCbs.clear();
        ChannelFeedListViewModel channelFeedsVm2 = getChannelFeedsVm();
        channelFeedsVm2.listExpanded = false;
        channelFeedsVm2.listExpandedWaitingTask.reset(false);
        channelFeedsVm2.tabOpenedWaitingTask.waitingCbs.clear();
    }

    public final void updateAllTabListOffset() {
        int i3 = 0;
        for (TabViewModel<FeedListViewModel> tabViewModel : this.tabList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TabViewModel<FeedListViewModel> tabViewModel2 = tabViewModel;
            if (i3 == this.tabSelectedIndex.getValue().intValue()) {
                tabViewModel2.listOffsetY.setValue(Float.valueOf(0.0f));
            } else {
                tabViewModel2.listOffsetY.setValue(Float.valueOf(Math.max(this.mainListContentOffsetY - this.headerHeight, 0.0f) - Math.max(tabViewModel2.lastListScrollOffsetYForMainList - this.headerHeight, 0.0f)));
            }
            i3 = i16;
        }
    }

    public final void jumpToPublishPage() {
        if (canLightPoi(true)) {
            this.showLoadingView.setValue(Boolean.TRUE);
            m poiData = getPoiData();
            Unit unit = null;
            if (poiData != null) {
                NBPJumpUtil nBPJumpUtil = NBPJumpUtil.INSTANCE;
                QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[][]{i.d(poiData)});
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("jumpPublishPageFromMiddlePage source:", "5", ", poiData displayName:");
                ah ahVar = poiData.f447113d;
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, ahVar != null ? ahVar.Q : null, kLog, "NBPJumpUtil");
                nBPJumpUtil.jumpPublishPage("5", null, null);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                KLog.INSTANCE.e("NBPMiddlePageViewModel", "jumpToSharePage failed, poiData is null");
            }
            this.fadeOutAnimation.setValue(Boolean.FALSE);
            TimerKt.d(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$jumpToPublishPage$3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NBPMiddlePageViewModel.this.showPopView.setValue(Boolean.FALSE);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final void bindTabListOffset(final TabViewModel<? extends FeedListViewModel> tabViewModel, final com.tencent.ntcompose.material.base.b bVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-341581441);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-341581441, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel.bindTabListOffset (NBPMiddlePageViewModel.kt:204)");
        }
        bVar.a(ComposeLayoutPropUpdaterKt.o(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, tabViewModel.listOffsetY.getValue().floatValue()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$bindTabListOffset$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPMiddlePageViewModel.this.bindTabListOffset(tabViewModel, bVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
