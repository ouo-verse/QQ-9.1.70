package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.TreeUpgradeCardViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.Point;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene.FilamentSceneMessageChannelModule;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene.IntimateSpaceFilamentView;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LevelProgressModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.msf.QQNetworkEngine$Companion$sendOIDBRequest$1;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.msf.QQNetworkEngine$QQNetworkEngineOIDBRequest;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.DTReportKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.IntimateSpaceReportUtilKt;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.Timer;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.ntcompose.activity.b;
import e25.a;
import e25.ab;
import e25.ac;
import e25.ad;
import e25.ae;
import e25.af;
import e25.ai;
import e25.aj;
import e25.ak;
import e25.al;
import e25.g;
import e25.i;
import e25.l;
import e25.m;
import e25.n;
import e25.o;
import e25.p;
import e25.q;
import e25.r;
import e25.s;
import e25.t;
import e25.u;
import e25.v;
import e25.w;
import e25.x;
import e25.y;
import e25.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallHomepageViewModel {
    public MutableState<Boolean> allWaterTaskComplete;
    public MutableState<CardShowState> cardShowState;
    public MutableState<i> clickedFlower;
    public MutableState<Long> collectWaterWeight;
    public MutableState<ToastInfo> currentToast;
    public MutableState<UpgradeCard> currentUpgradeCard;
    public MutableState<Boolean> filamentMessageChannelReady;
    public MutableState<Boolean> filamentSceneReady;
    public aa<IntimateSpaceFilamentView> filamentViewRef;
    public MutableState<GuildState> guildState;
    public MutableState<Boolean> isShowingToast;
    public MutableState<Boolean> isShowingUpgradeCard;
    public MutableState<ManualState> manualState;
    public Function0<Unit> onTreeUpgradeAnimationFinish;
    public LoveWallHomepageData pageData;
    public SnapshotStateList<PhotoBubble> photoBubbles;
    public Map<Long, List<y>> photoMap;
    public MutableState<Boolean> playTreeUpgradeAnimation;
    public MutableState<Boolean> playWateringAnimation;
    public final MutableState<LevelProgressModel> progressViewModel;
    public MutableState<i> shareFlower;
    public MutableState<SharePanelState> sharePanelState;
    public MutableState<Point> sproutFlowerPosition;
    public SnapshotStateList<ToastInfo> toastQueue;
    public MutableState<ad> tree;
    public MutableState<String> treeBubbleText;
    public int treeBubbleTimeInterval;
    public List<String> treeBubbleTips;
    public Timer treeBubbleTipsTimer;
    public MutableState<Boolean> unfoldAllWaterBubbles;
    public SnapshotStateList<UpgradeCard> upgradeCardQueue;
    public MutableState<UserTreeState> userTreeState;
    public SnapshotStateList<ai> userWaterList;
    public MutableState<Boolean> viewHasDisappear;
    public SnapshotStateList<aj> waterTaskList;
    public final LoveWallWaterViewModel waterViewModel;
    public String zoneWaterBubbleTip;

    public static void requestShare$default(LoveWallHomepageViewModel loveWallHomepageViewModel, final Function0 function0) {
        loveWallHomepageViewModel.getClass();
        KLog.INSTANCE.i("LoveWallHomepage", "start request share");
        long parseLong = Long.parseLong(loveWallHomepageViewModel.pageData.peerUin);
        final int i3 = 1;
        ac acVar = new ac(parseLong, 1);
        LoveWallHomepageViewModel$requestShare$1 loveWallHomepageViewModel$requestShare$1 = new Function1<byte[], m>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$requestShare$1
            @Override // kotlin.jvm.functions.Function1
            public final m invoke(byte[] bArr) {
                return (m) c45.i.b(new m(null, 1, null), bArr);
            }
        };
        Function1<OIDBResponse<m>, Unit> function1 = new Function1<OIDBResponse<m>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$requestShare$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(OIDBResponse<m> oIDBResponse) {
                OIDBResponse<m> oIDBResponse2 = oIDBResponse;
                if (!oIDBResponse2.success) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("share fail, type: ");
                    m3.append(i3);
                    m3.append(". Error: ");
                    m3.append(oIDBResponse2.f114186msg);
                    m3.append(", errorCode: ");
                    m3.append(oIDBResponse2.code);
                    kLog.e("LoveWallHomepage", m3.toString());
                    Mqq.INSTANCE.getUi().showErrorTips(ImageTaskConst.ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_NETWORK_FAIL_DESC);
                } else {
                    function0.invoke();
                }
                return Unit.INSTANCE;
            }
        };
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(new QQNetworkEngine$QQNetworkEngineOIDBRequest(37790, acVar, loveWallHomepageViewModel$requestShare$1), false, new QQNetworkEngine$Companion$sendOIDBRequest$1(function1));
    }

    public final void addEventListeners() {
        FilamentSceneMessageChannelModule filamentSceneMessageChannelModule = (FilamentSceneMessageChannelModule) b.a().acquireModule("FilamentSceneMessageChannelModule");
        filamentSceneMessageChannelModule.registerMessageHandler("IntimateSpace.ClickFlower", new Function1<Object, Object>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$addEventListeners$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                byte[] bArr = obj instanceof byte[] ? (byte[]) obj : null;
                if (bArr == null) {
                    KLog.INSTANCE.e("LoveWallHomepage", "click flower fail, data is null");
                    return null;
                }
                i iVar = ((v) c45.i.b(new v(null, null, 3, null), bArr)).f395507e;
                if (iVar != null) {
                    LoveWallHomepageViewModel loveWallHomepageViewModel = LoveWallHomepageViewModel.this;
                    loveWallHomepageViewModel.getClass();
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("IntimateSpace.ClickFlower, id: ");
                    m3.append(iVar.f395478d);
                    m3.append(", status: ");
                    ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, iVar.G, kLog, "LoveWallHomepage");
                    int i3 = iVar.G;
                    if (i3 == 1) {
                        loveWallHomepageViewModel.clickedFlower.setValue(iVar);
                        loveWallHomepageViewModel.cardShowState.setValue(CardShowState.FLOWER_CARD_LIST);
                    } else if (i3 == 2) {
                        loveWallHomepageViewModel.clickedFlower.setValue(iVar);
                        loveWallHomepageViewModel.cardShowState.setValue(CardShowState.FLOWER_TASK_CARD);
                    }
                    e pageReportParams = loveWallHomepageViewModel.getPageReportParams();
                    e intimateDTReportBaseParams = IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams();
                    intimateDTReportBaseParams.v("bud_id", String.valueOf(iVar.f395478d));
                    Unit unit = Unit.INSTANCE;
                    DTReportKt.reportElementClickEvent(pageReportParams, "em_qz_bud", intimateDTReportBaseParams);
                }
                return c45.i.d(new g(null));
            }
        });
        filamentSceneMessageChannelModule.registerMessageHandler("IntimateSpace.ClickTree", new Function1<Object, Object>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$addEventListeners$2
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object random;
                KLog kLog = KLog.INSTANCE;
                kLog.i("LoveWallHomepage", "click tree, show feedback bubble");
                byte[] bArr = obj instanceof byte[] ? (byte[]) obj : null;
                if (bArr == null) {
                    kLog.e("LoveWallHomepage", "click tree fail, data is null");
                    return null;
                }
                ab abVar = ((x) c45.i.b(new x(null, null, 3, null), bArr)).f395513e;
                if (abVar != null) {
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click tree, point: (");
                    m3.append(abVar.f395428d);
                    m3.append(", ");
                    m3.append(abVar.f395429e);
                    m3.append(')');
                    kLog.i("LoveWallHomepage", m3.toString());
                }
                if (!LoveWallHomepageViewModel.this.treeBubbleTips.isEmpty()) {
                    LoveWallHomepageViewModel loveWallHomepageViewModel = LoveWallHomepageViewModel.this;
                    MutableState<String> mutableState = loveWallHomepageViewModel.treeBubbleText;
                    random = CollectionsKt___CollectionsKt.random(loveWallHomepageViewModel.treeBubbleTips, Random.INSTANCE);
                    mutableState.setValue(random);
                }
                return c45.i.d(new g(null));
            }
        });
        filamentSceneMessageChannelModule.registerMessageHandler("IntimateSpace.ClickPhoto", new Function1<Object, Object>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$addEventListeners$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object first;
                KLog kLog = KLog.INSTANCE;
                kLog.i("LoveWallHomepage", "click photo");
                byte[] bArr = obj instanceof byte[] ? (byte[]) obj : null;
                if (bArr == null) {
                    kLog.e("LoveWallHomepage", "click photo fail, data is null");
                    return null;
                }
                w wVar = (w) c45.i.b(new w(null, null, null, null, 15, null), bArr);
                if (!wVar.f395509e.isEmpty()) {
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) wVar.f395509e);
                    z zVar = (z) first;
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click photo: "), zVar.f395518d, kLog, "LoveWallHomepage");
                    if (zVar.f395520f.length() > 0) {
                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click photo, jumpUrl: "), zVar.f395520f, kLog, "LoveWallHomepage");
                        MqqUi.openUrl$default(Mqq.INSTANCE.getUi(), zVar.f395520f);
                    }
                } else {
                    ab abVar = wVar.f395510f;
                    if (abVar != null) {
                        final LoveWallHomepageViewModel loveWallHomepageViewModel = LoveWallHomepageViewModel.this;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click photo frame point=");
                        m3.append(abVar.f395428d);
                        m3.append(", ");
                        NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, abVar.f395429e, kLog, "LoveWallHomepage");
                        a aVar = wVar.f395511h;
                        if (aVar != null) {
                            final PhotoBubble photoBubble = new PhotoBubble(new ab(abVar.f395428d, abVar.f395429e), aVar);
                            loveWallHomepageViewModel.photoBubbles.add(photoBubble);
                            TimerKt.c(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$showPhotoBubble$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    LoveWallHomepageViewModel.this.photoBubbles.remove(photoBubble);
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                    }
                }
                DTReportKt.reportElementClickEvent(LoveWallHomepageViewModel.this.getPageReportParams(), "em_qz_album", IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams());
                return c45.i.d(new g(null));
            }
        });
        filamentSceneMessageChannelModule.registerMessageHandler("IntimateSpace.HideBubbles", new Function1<Object, Object>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$addEventListeners$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                KLog.INSTANCE.i("LoveWallHomepage", "hide bubbles");
                LoveWallHomepageViewModel loveWallHomepageViewModel = LoveWallHomepageViewModel.this;
                loveWallHomepageViewModel.treeBubbleText.setValue(null);
                loveWallHomepageViewModel.photoBubbles.clear();
                return c45.i.d(new g(null));
            }
        });
    }

    public final void fetchSproutFlowerPosition() {
        i firstLevelFlower;
        if (hasTreeRendered() && this.sproutFlowerPosition.getValue() == null && (firstLevelFlower = getFirstLevelFlower()) != null) {
            ((FilamentSceneMessageChannelModule) b.a().acquireModule("FilamentSceneMessageChannelModule")).postMessage("IntimateSpace.GetFlowerPosition", c45.i.d(new r(Long.valueOf(firstLevelFlower.f395478d))), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$fetchSproutFlowerPosition$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    ab abVar;
                    byte[] bArr = obj instanceof byte[] ? (byte[]) obj : null;
                    if (bArr == null) {
                        KLog.INSTANCE.e("LoveWallHomepage", "get flower position rsp data is null");
                    } else {
                        s sVar = (s) c45.i.b(new s(null, null, 3, null), bArr);
                        Boolean bool = sVar.f395501e;
                        if (bool != null) {
                            LoveWallHomepageViewModel loveWallHomepageViewModel = LoveWallHomepageViewModel.this;
                            if (bool.booleanValue() && (abVar = sVar.f395500d) != null) {
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("get flower position success, point: (");
                                m3.append(abVar.f395428d);
                                m3.append(", ");
                                m3.append(abVar.f395429e);
                                m3.append(')');
                                kLog.i("LoveWallHomepage", m3.toString());
                                MutableState<Point> mutableState = loveWallHomepageViewModel.sproutFlowerPosition;
                                Integer num = abVar.f395428d;
                                Intrinsics.checkNotNull(num);
                                float intValue = num.intValue();
                                Intrinsics.checkNotNull(abVar.f395429e);
                                mutableState.setValue(new Point(intValue, r6.intValue()));
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final void fetchTreeRandomBubbleTips() {
        String stringFromQQCommonConfig = ((QQCommonNApiModule) b.a().acquireModule("QQCommonNApiModule")).getStringFromQQCommonConfig("intimate_space_love_tree_bubble_tips", "{}");
        KLog.INSTANCE.i("LoveWallHomepage", "getQQMCConfig: intimate_space_love_tree_bubble_tips: " + stringFromQQCommonConfig);
        try {
            ArrayList arrayList = new ArrayList();
            e eVar = new e(stringFromQQCommonConfig);
            com.tencent.kuikly.core.nvi.serialization.json.b l3 = eVar.l("bubbleTips");
            if (l3 != null) {
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    String o16 = l3.o(i3);
                    if (o16 != null) {
                        arrayList.add(o16);
                    }
                }
            }
            this.treeBubbleTips = arrayList;
            this.treeBubbleTimeInterval = eVar.j(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL);
        } catch (Throwable th5) {
            KLog.INSTANCE.i("LoveWallHomepage", "getQQMCConfig: intimate_space_love_tree_bubble_tips fail. Error: " + th5);
        }
    }

    public final void fetchWaterInfo(final Function0<Unit> function0) {
        LoveWallWaterViewModel loveWallWaterViewModel = this.waterViewModel;
        final Function1<o, Unit> function1 = new Function1<o, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$fetchWaterInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(o oVar) {
                o oVar2 = oVar;
                LoveWallHomepageViewModel.this.waterTaskList.clear();
                LoveWallHomepageViewModel.this.waterTaskList.addAll(oVar2.f395491e);
                LoveWallHomepageViewModel loveWallHomepageViewModel = LoveWallHomepageViewModel.this;
                Iterator<aj> it = loveWallHomepageViewModel.waterTaskList.iterator();
                while (it.hasNext()) {
                    aj next = it.next();
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("water: ");
                    m3.append(next.f395459d);
                    m3.append(", incr_weight=");
                    m3.append(next.f395463i);
                    kLog.i("LoveWallHomepage", m3.toString());
                    if (next.f395459d == 3) {
                        String str = loveWallHomepageViewModel.zoneWaterBubbleTip;
                        if (str == null) {
                            a aVar = next.E;
                            loveWallHomepageViewModel.zoneWaterBubbleTip = aVar != null ? aVar.f395424f : null;
                        } else {
                            a aVar2 = next.E;
                            if (aVar2 != null) {
                                Intrinsics.checkNotNull(str);
                                aVar2.f395424f = str;
                            }
                        }
                    }
                }
                LoveWallHomepageViewModel.this.userWaterList.clear();
                LoveWallHomepageViewModel.this.userWaterList.addAll(oVar2.f395490d);
                LoveWallHomepageViewModel.this.collectWaterWeight.setValue(Long.valueOf(oVar2.f395492f));
                LoveWallHomepageViewModel.this.updateWaterTaskState();
                Function0<Unit> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                return Unit.INSTANCE;
            }
        };
        n nVar = new n(loveWallWaterViewModel.uin);
        LoveWallWaterViewModel$fetchWaterInfo$1 loveWallWaterViewModel$fetchWaterInfo$1 = new Function1<byte[], o>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallWaterViewModel$fetchWaterInfo$1
            @Override // kotlin.jvm.functions.Function1
            public final o invoke(byte[] bArr) {
                return (o) c45.i.b(new o(null, null, 0L, 7, null), bArr);
            }
        };
        Function1<OIDBResponse<o>, Unit> function12 = new Function1<OIDBResponse<o>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallWaterViewModel$fetchWaterInfo$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(OIDBResponse<o> oIDBResponse) {
                OIDBResponse<o> oIDBResponse2 = oIDBResponse;
                if (!oIDBResponse2.success) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetch water task list fail. Error: ");
                    m3.append(oIDBResponse2.f114186msg);
                    m3.append(", errorCode: ");
                    m3.append(oIDBResponse2.code);
                    kLog.e("LoveWallWaterViewModel", m3.toString());
                } else {
                    o oVar = oIDBResponse2.rsp;
                    if (oVar == null) {
                        KLog.INSTANCE.e("LoveWallWaterViewModel", "fetch water task list fail. Error: response is null");
                    } else {
                        Function1<o, Unit> function13 = function1;
                        Intrinsics.checkNotNull(oVar);
                        function13.invoke(oVar);
                    }
                }
                return Unit.INSTANCE;
            }
        };
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(new QQNetworkEngine$QQNetworkEngineOIDBRequest(37747, nVar, loveWallWaterViewModel$fetchWaterInfo$1), false, new QQNetworkEngine$Companion$sendOIDBRequest$1(function12));
    }

    public final i getFirstLevelFlower() {
        ae firstLevelTreeBody = getFirstLevelTreeBody();
        if (firstLevelTreeBody == null) {
            return null;
        }
        for (i iVar : firstLevelTreeBody.f395442i) {
            if (iVar.f395478d == 1) {
                return iVar;
            }
        }
        return null;
    }

    public final ae getFirstLevelTreeBody() {
        if (this.tree.getValue() == null) {
            return null;
        }
        ad value = this.tree.getValue();
        Intrinsics.checkNotNull(value);
        for (ae aeVar : value.f395435h) {
            if (aeVar.f395438d == 1) {
                return aeVar;
            }
        }
        return null;
    }

    public final int getFlowersCount() {
        List<ae> list;
        int i3 = 0;
        if (this.tree.getValue() == null) {
            return 0;
        }
        ad value = this.tree.getValue();
        if (value != null && (list = value.f395435h) != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Iterator<T> it5 = ((ae) it.next()).f395442i.iterator();
                while (it5.hasNext()) {
                    if (((i) it5.next()).G == 1) {
                        i3++;
                    }
                }
            }
        }
        return i3;
    }

    public final e getPageReportParams() {
        e intimateDTReportBaseParams = IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams();
        intimateDTReportBaseParams.t("visit_src", this.pageData.from);
        return intimateDTReportBaseParams;
    }

    public final boolean hasCompleteAllWaterTasks() {
        Iterator<aj> it = this.waterTaskList.iterator();
        while (it.hasNext()) {
            if (!it.next().C) {
                return false;
            }
        }
        return true;
    }

    public final boolean hasTreeRendered() {
        return this.filamentSceneReady.getValue().booleanValue() && this.filamentMessageChannelReady.getValue().booleanValue() && this.tree.getValue() != null;
    }

    public final void loadProgressView() {
        af afVar;
        ad value = this.tree.getValue();
        if (value == null || (afVar = value.f395433e) == null) {
            return;
        }
        LevelProgressModel value2 = this.progressViewModel.getValue();
        value2.treeProgress.setValue(afVar);
        MutableState<Float> mutableState = value2.heightProgress;
        float f16 = afVar.f395444d;
        float f17 = afVar.f395449m;
        mutableState.setValue(Float.valueOf(((f16 - f17) * 1.0f) / (afVar.f395445e - f17)));
    }

    public final void loadTree() {
        if (this.filamentSceneReady.getValue().booleanValue() && this.filamentMessageChannelReady.getValue().booleanValue()) {
            if (this.tree.getValue() == null) {
                KLog.INSTANCE.e("LoveWallHomepage", "notify reset tree fail. Error: tree is null");
            } else {
                ((FilamentSceneMessageChannelModule) b.a().acquireModule("FilamentSceneMessageChannelModule")).postMessage("IntimateSpace.ResetTree", c45.i.d(new t(null, this.tree.getValue())), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$notifyResetTree$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object obj) {
                        KLog kLog = KLog.INSTANCE;
                        kLog.i("LoveWallHomepage", "NativeResetTreeReq callback");
                        byte[] bArr = obj instanceof byte[] ? (byte[]) obj : null;
                        if (bArr == null) {
                            kLog.e("LoveWallHomepage", "NativeResetTree rsp data is null");
                        } else {
                            u uVar = (u) c45.i.b(new u(null, null, 3, null), bArr);
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NativeResetTreeReq success: ");
                            m3.append(uVar.f395505e);
                            kLog.i("LoveWallHomepage", m3.toString());
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
            if (this.treeBubbleTimeInterval <= 0) {
                return;
            }
            Timer timer = this.treeBubbleTipsTimer;
            if (timer != null) {
                timer.e();
            }
            this.treeBubbleTipsTimer = null;
            Timer timer2 = new Timer();
            timer2.f(1000, this.treeBubbleTimeInterval, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$startTreeBubbleTipsTimer$1$1
                {
                    super(0);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    Object random;
                    if (LoveWallHomepageViewModel.this.treeBubbleText.getValue() == null && (!LoveWallHomepageViewModel.this.treeBubbleTips.isEmpty()) && LoveWallHomepageViewModel.this.guildState.getValue() == GuildState.NONE) {
                        LoveWallHomepageViewModel loveWallHomepageViewModel = LoveWallHomepageViewModel.this;
                        MutableState<String> mutableState = loveWallHomepageViewModel.treeBubbleText;
                        random = CollectionsKt___CollectionsKt.random(loveWallHomepageViewModel.treeBubbleTips, Random.INSTANCE);
                        mutableState.setValue(random);
                    }
                    return Unit.INSTANCE;
                }
            });
            this.treeBubbleTipsTimer = timer2;
        }
    }

    public final void notifyTreeFreeState(final int i3) {
        if (this.filamentSceneReady.getValue().booleanValue() && this.filamentMessageChannelReady.getValue().booleanValue()) {
            ((FilamentSceneMessageChannelModule) b.a().acquireModule("FilamentSceneMessageChannelModule")).postMessage("IntimateSpace.ChangeState", c45.i.d(new p(Integer.valueOf(i3), 11)), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$notifyTreeFreeState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    byte[] bArr = obj instanceof byte[] ? (byte[]) obj : null;
                    if (bArr == null) {
                        KLog.INSTANCE.e("LoveWallHomepage", "NativeChangeStateReq rsp data is null");
                    } else {
                        q qVar = (q) c45.i.b(new q(null, null, 3, null), bArr);
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NativeChangeStateRsp state: ");
                        m3.append(i3);
                        m3.append(" success: ");
                        NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, qVar.f395498e, kLog, "LoveWallHomepage");
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final void predownloadImages() {
        BridgeModule.preDownloadImage$default((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule"), "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_AaXNv2lLZwg.png");
    }

    public final void refreshUIWhenResume() {
        KLog.INSTANCE.i("LoveWallHomepage", "refreshUIWhenResume");
        fetchWaterInfo(null);
        fetchTree$default(this, false, null, 3);
    }

    public final void showNextToast() {
        if (this.toastQueue.isEmpty()) {
            this.currentToast.setValue(null);
            this.isShowingToast.setValue(Boolean.FALSE);
            KLog.INSTANCE.i("LoveWallHomepage", "toast queue is empty");
        } else {
            this.currentToast.setValue(this.toastQueue.remove(0));
            this.isShowingToast.setValue(Boolean.TRUE);
        }
    }

    public final void showNextUpgradeCard() {
        if (this.upgradeCardQueue.isEmpty()) {
            this.currentUpgradeCard.setValue(null);
            this.isShowingUpgradeCard.setValue(Boolean.FALSE);
            KLog.INSTANCE.i("LoveWallHomepage", "show upgrade queue is empty");
        } else {
            this.currentUpgradeCard.setValue(this.upgradeCardQueue.remove(0));
            this.isShowingUpgradeCard.setValue(Boolean.TRUE);
        }
    }

    public final void showToast(String str) {
        this.toastQueue.add(new ToastInfo(str));
        if (this.isShowingToast.getValue().booleanValue()) {
            return;
        }
        showNextToast();
    }

    public final void updateWaterTaskState() {
        this.allWaterTaskComplete.setValue(Boolean.valueOf(hasCompleteAllWaterTasks() && this.collectWaterWeight.getValue().longValue() == 0));
    }

    public final void requestWatering(final Function0<Unit> function0) {
        final List emptyList;
        List mutableList;
        notifyTreeFreeState(4);
        if (this.guildState.getValue() == GuildState.NONE) {
            notifyTreeFreeState(1);
        }
        LoveWallWaterViewModel loveWallWaterViewModel = this.waterViewModel;
        final Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$requestWatering$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                LoveWallHomepageViewModel.this.playWateringAnimation.setValue(Boolean.TRUE);
                function0.invoke();
                return Unit.INSTANCE;
            }
        };
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        long j3 = loveWallWaterViewModel.uin;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) emptyList);
        ak akVar = new ak(j3, mutableList);
        LoveWallWaterViewModel$requestWatering$1 loveWallWaterViewModel$requestWatering$1 = new Function1<byte[], al>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallWaterViewModel$requestWatering$1
            @Override // kotlin.jvm.functions.Function1
            public final al invoke(byte[] bArr) {
                return (al) c45.i.b(new al(false, 1, null), bArr);
            }
        };
        Function1<OIDBResponse<al>, Unit> function1 = new Function1<OIDBResponse<al>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallWaterViewModel$requestWatering$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(OIDBResponse<al> oIDBResponse) {
                OIDBResponse<al> oIDBResponse2 = oIDBResponse;
                if (!oIDBResponse2.success) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("watering fail, waterIdList: ");
                    m3.append(emptyList);
                    m3.append(". Error: ");
                    m3.append(oIDBResponse2.f114186msg);
                    m3.append(", errorCode: ");
                    m3.append(oIDBResponse2.code);
                    kLog.e("LoveWallWaterViewModel", m3.toString());
                    Mqq.INSTANCE.getUi().showErrorTips(ImageTaskConst.ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_NETWORK_FAIL_DESC);
                } else {
                    function02.invoke();
                }
                return Unit.INSTANCE;
            }
        };
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(new QQNetworkEngine$QQNetworkEngineOIDBRequest(37778, akVar, loveWallWaterViewModel$requestWatering$1), false, new QQNetworkEngine$Companion$sendOIDBRequest$1(function1));
    }

    public LoveWallHomepageViewModel(e eVar) {
        MutableState<GuildState> mutableStateOf$default;
        MutableState<Point> mutableStateOf$default2;
        MutableState<CardShowState> mutableStateOf$default3;
        MutableState<ManualState> mutableStateOf$default4;
        MutableState<SharePanelState> mutableStateOf$default5;
        MutableState<i> mutableStateOf$default6;
        MutableState<UpgradeCard> mutableStateOf$default7;
        MutableState<Boolean> mutableStateOf$default8;
        MutableState<Boolean> mutableStateOf$default9;
        MutableState<ToastInfo> mutableStateOf$default10;
        MutableState<Boolean> mutableStateOf$default11;
        MutableState<String> mutableStateOf$default12;
        List<String> emptyList;
        MutableState<UserTreeState> mutableStateOf$default13;
        MutableState<ad> mutableStateOf$default14;
        MutableState<Long> mutableStateOf$default15;
        MutableState<LevelProgressModel> mutableStateOf$default16;
        MutableState<Boolean> mutableStateOf$default17;
        MutableState<Boolean> mutableStateOf$default18;
        MutableState<Boolean> mutableStateOf$default19;
        MutableState<i> mutableStateOf$default20;
        MutableState<Boolean> mutableStateOf$default21;
        MutableState<Boolean> mutableStateOf$default22;
        MutableState<Boolean> mutableStateOf$default23;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(GuildState.REQUESTING, null, 2, null);
        this.guildState = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.sproutFlowerPosition = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CardShowState.NONE, null, 2, null);
        this.cardShowState = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ManualState.NONE, null, 2, null);
        this.manualState = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SharePanelState.NONE, null, 2, null);
        this.sharePanelState = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.shareFlower = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentUpgradeCard = mutableStateOf$default7;
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isShowingUpgradeCard = mutableStateOf$default8;
        this.upgradeCardQueue = SnapshotStateKt.mutableStateListOf();
        mutableStateOf$default9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.playTreeUpgradeAnimation = mutableStateOf$default9;
        mutableStateOf$default10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentToast = mutableStateOf$default10;
        mutableStateOf$default11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isShowingToast = mutableStateOf$default11;
        this.toastQueue = SnapshotStateKt.mutableStateListOf();
        mutableStateOf$default12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.treeBubbleText = mutableStateOf$default12;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.treeBubbleTips = emptyList;
        this.treeBubbleTimeInterval = 10000;
        mutableStateOf$default13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(UserTreeState.NONE, null, 2, null);
        this.userTreeState = mutableStateOf$default13;
        mutableStateOf$default14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.tree = mutableStateOf$default14;
        this.photoMap = new LinkedHashMap();
        this.waterTaskList = SnapshotStateKt.mutableStateListOf();
        this.userWaterList = SnapshotStateKt.mutableStateListOf();
        mutableStateOf$default15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
        this.collectWaterWeight = mutableStateOf$default15;
        mutableStateOf$default16 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new LevelProgressModel(), null, 2, null);
        this.progressViewModel = mutableStateOf$default16;
        mutableStateOf$default17 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.unfoldAllWaterBubbles = mutableStateOf$default17;
        mutableStateOf$default18 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.allWaterTaskComplete = mutableStateOf$default18;
        mutableStateOf$default19 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.playWateringAnimation = mutableStateOf$default19;
        mutableStateOf$default20 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new i(0L, null, 0L, null, null, 0, null, null, null, null, 0, null, 0L, InitSkin.DRAWABLE_COUNT, null), null, 2, null);
        this.clickedFlower = mutableStateOf$default20;
        this.photoBubbles = SnapshotStateKt.mutableStateListOf();
        LoveWallHomepageData loveWallHomepageData = new LoveWallHomepageData(eVar.p(ProtocolDownloaderConstants.HEADER_FRIEND_UIN), eVar.j("enter_page"), eVar.n("flower_id"), eVar.j("from"));
        this.pageData = loveWallHomepageData;
        this.waterViewModel = new LoveWallWaterViewModel(Long.parseLong(loveWallHomepageData.getPeerUin()));
        mutableStateOf$default21 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.filamentMessageChannelReady = mutableStateOf$default21;
        mutableStateOf$default22 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.filamentSceneReady = mutableStateOf$default22;
        mutableStateOf$default23 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.viewHasDisappear = mutableStateOf$default23;
        KLog.INSTANCE.i("LoveWallHomepage", "LoveWallHomepageViewModel init");
        addEventListeners();
        predownloadImages();
        fetchTree$default(this, false, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool2) {
                if (bool2.booleanValue()) {
                    LoveWallHomepageViewModel.this.fetchWaterInfo(null);
                    LoveWallHomepageViewModel.this.notifyTreeFreeState(1);
                    LoveWallHomepageViewModel loveWallHomepageViewModel = LoveWallHomepageViewModel.this;
                    LoveWallHomepageData loveWallHomepageData2 = loveWallHomepageViewModel.pageData;
                    if (loveWallHomepageData2.enterPage == 1) {
                        long j3 = loveWallHomepageData2.flowerId;
                        ad value = loveWallHomepageViewModel.tree.getValue();
                        if (value != null) {
                            Iterator<T> it = value.f395435h.iterator();
                            while (it.hasNext()) {
                                for (i iVar : ((ae) it.next()).f395442i) {
                                    if (iVar.f395478d == j3) {
                                        loveWallHomepageViewModel.cardShowState.setValue(CardShowState.FLOWER_CARD_LIST);
                                        loveWallHomepageViewModel.clickedFlower.setValue(iVar);
                                    }
                                }
                            }
                        }
                    }
                    LoveWallHomepageViewModel.fetchTree$default(LoveWallHomepageViewModel.this, true, null, 2);
                }
                return Unit.INSTANCE;
            }
        }, 1);
        fetchTreeRandomBubbleTips();
    }

    public static void fetchTree$default(final LoveWallHomepageViewModel loveWallHomepageViewModel, final boolean z16, final Function1 function1, int i3) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(new QQNetworkEngine$QQNetworkEngineOIDBRequest(37746, new l(Long.parseLong(loveWallHomepageViewModel.pageData.peerUin), z16), new Function1<byte[], m>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$fetchTree$1
            @Override // kotlin.jvm.functions.Function1
            public final m invoke(byte[] bArr) {
                return (m) c45.i.b(new m(null, 1, null), bArr);
            }
        }), false, new QQNetworkEngine$Companion$sendOIDBRequest$1(new Function1<OIDBResponse<m>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$fetchTree$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r6v7, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Long, java.util.List<e25.y>>] */
            /* JADX WARN: Type inference failed for: r8v2, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Long, java.util.List<e25.y>>] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(OIDBResponse<m> oIDBResponse) {
                UserTreeState userTreeState;
                GuildState guildState;
                LoveWallHomepageViewModel loveWallHomepageViewModel2;
                List mutableList;
                Object first;
                Object first2;
                LoveWallHomepageViewModel loveWallHomepageViewModel3;
                boolean z17;
                Object first3;
                OIDBResponse<m> oIDBResponse2 = oIDBResponse;
                String str = "LoveWallHomepage";
                if (!oIDBResponse2.success) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetch tree fail. Error: ");
                    m3.append(oIDBResponse2.f114186msg);
                    m3.append(", errorCode: ");
                    m3.append(oIDBResponse2.code);
                    kLog.e("LoveWallHomepage", m3.toString());
                    if (oIDBResponse2.code == 10101) {
                        Mqq.INSTANCE.getUi().showInfoTips("\u6062\u590d\u4eb2\u5bc6\u5173\u7cfb\uff0c\u8ba9\u7231\u60c5\u518d\u6b21\u6210\u957f");
                    } else {
                        Mqq.INSTANCE.getUi().showErrorTips(ImageTaskConst.ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_NETWORK_FAIL_DESC);
                    }
                } else {
                    m mVar = oIDBResponse2.rsp;
                    ad adVar = mVar != null ? mVar.f395488d : null;
                    if (adVar != null) {
                        LoveWallHomepageViewModel loveWallHomepageViewModel4 = loveWallHomepageViewModel;
                        boolean z18 = z16;
                        loveWallHomepageViewModel4.playTreeUpgradeAnimation.setValue(Boolean.FALSE);
                        ad value = loveWallHomepageViewModel4.tree.getValue();
                        if (value == null || loveWallHomepageViewModel4.guildState.getValue() != GuildState.NONE || adVar.f395435h.isEmpty() || value.f395435h.isEmpty()) {
                            loveWallHomepageViewModel2 = loveWallHomepageViewModel4;
                        } else {
                            KLog kLog2 = KLog.INSTANCE;
                            StringBuilder m16 = NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(adVar.f395435h, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("new body count: "), ", old body count: ");
                            m16.append(value.f395435h.size());
                            kLog2.i("LoveWallHomepage", m16.toString());
                            ArrayList arrayList = new ArrayList();
                            af afVar = adVar.f395433e;
                            if (afVar != null && value.f395433e != null) {
                                Intrinsics.checkNotNull(afVar);
                                long j3 = afVar.f395448i;
                                af afVar2 = value.f395433e;
                                Intrinsics.checkNotNull(afVar2);
                                if (j3 > afVar2.f395448i) {
                                    loveWallHomepageViewModel4.playTreeUpgradeAnimation.setValue(Boolean.TRUE);
                                    af afVar3 = value.f395433e;
                                    float f16 = afVar3 != null ? afVar3.f395444d : 0.0f;
                                    af afVar4 = adVar.f395433e;
                                    float f17 = afVar4 != null ? afVar4.f395444d : 0.0f;
                                    first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) adVar.f395435h);
                                    arrayList.add(new UpgradeCard(new TreeUpgradeCardViewModel(f16, f17, ((ae) first3).f395443m), 2));
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<T> it = adVar.f395435h.iterator();
                            while (it.hasNext()) {
                                for (i iVar : ((ae) it.next()).f395442i) {
                                    if (iVar.G == 1) {
                                        arrayList2.add(iVar);
                                    }
                                }
                            }
                            ArrayList arrayList3 = new ArrayList();
                            Iterator<T> it5 = value.f395435h.iterator();
                            while (it5.hasNext()) {
                                for (i iVar2 : ((ae) it5.next()).f395442i) {
                                    if (iVar2.G == 1) {
                                        arrayList3.add(iVar2);
                                    }
                                }
                            }
                            KLog kLog3 = KLog.INSTANCE;
                            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("oldLightFlowerCount: ");
                            m17.append(arrayList3.size());
                            m17.append(", newLightFlowerCount: ");
                            m17.append(arrayList2.size());
                            kLog3.i("LoveWallHomepage", m17.toString());
                            if (arrayList2.size() > arrayList3.size()) {
                                ArrayList arrayList4 = new ArrayList();
                                Iterator it6 = arrayList2.iterator();
                                while (it6.hasNext()) {
                                    Object next = it6.next();
                                    i iVar3 = (i) next;
                                    if (!arrayList3.isEmpty()) {
                                        Iterator it7 = arrayList3.iterator();
                                        while (it7.hasNext()) {
                                            loveWallHomepageViewModel3 = loveWallHomepageViewModel4;
                                            if (((i) it7.next()).f395478d == iVar3.f395478d) {
                                                z17 = false;
                                                break;
                                            }
                                            loveWallHomepageViewModel4 = loveWallHomepageViewModel3;
                                        }
                                    }
                                    loveWallHomepageViewModel3 = loveWallHomepageViewModel4;
                                    z17 = true;
                                    if (z17) {
                                        arrayList4.add(next);
                                    }
                                    loveWallHomepageViewModel4 = loveWallHomepageViewModel3;
                                }
                                LoveWallHomepageViewModel loveWallHomepageViewModel5 = loveWallHomepageViewModel4;
                                Iterator it8 = arrayList4.iterator();
                                while (it8.hasNext()) {
                                    i iVar4 = (i) it8.next();
                                    KLog kLog4 = KLog.INSTANCE;
                                    StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("flower upgrade, flowerId: ");
                                    m18.append(iVar4.f395478d);
                                    kLog4.i("LoveWallHomepage", m18.toString());
                                    arrayList.add(new UpgradeCard(iVar4, 3));
                                }
                                loveWallHomepageViewModel2 = loveWallHomepageViewModel5;
                            } else {
                                loveWallHomepageViewModel2 = loveWallHomepageViewModel4;
                            }
                            if (loveWallHomepageViewModel2.playTreeUpgradeAnimation.getValue().booleanValue()) {
                                loveWallHomepageViewModel2.onTreeUpgradeAnimationFinish = new LoveWallHomepageViewModel$updateTree$1$4(arrayList, loveWallHomepageViewModel2);
                            } else {
                                Iterator it9 = arrayList.iterator();
                                while (it9.hasNext()) {
                                    loveWallHomepageViewModel2.upgradeCardQueue.add((UpgradeCard) it9.next());
                                    if (!loveWallHomepageViewModel2.isShowingUpgradeCard.getValue().booleanValue()) {
                                        loveWallHomepageViewModel2.showNextUpgradeCard();
                                    }
                                }
                            }
                        }
                        String str2 = ", photo url: ";
                        if (z18) {
                            loveWallHomepageViewModel2.photoMap.clear();
                            for (ae aeVar : adVar.f395435h) {
                                if (!aeVar.f395441h.isEmpty()) {
                                    KLog kLog5 = KLog.INSTANCE;
                                    StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("save photoSocialAssets: level=");
                                    m19.append(aeVar.f395438d);
                                    kLog5.i("LoveWallHomepage", m19.toString());
                                    loveWallHomepageViewModel2.photoMap.put(Long.valueOf(aeVar.f395438d), aeVar.f395441h);
                                    for (y yVar : aeVar.f395441h) {
                                        if (!yVar.f395514d.isEmpty()) {
                                            KLog kLog6 = KLog.INSTANCE;
                                            StringBuilder m26 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetch: level=");
                                            m26.append(aeVar.f395438d);
                                            m26.append(", photo url: ");
                                            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) yVar.f395514d);
                                            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m26, ((z) first2).f395518d, kLog6, "LoveWallHomepage");
                                        }
                                    }
                                }
                            }
                            loveWallHomepageViewModel2.tree.setValue(adVar);
                        } else {
                            ArrayList arrayList5 = new ArrayList();
                            Iterator it10 = adVar.f395435h.iterator();
                            while (it10.hasNext()) {
                                ae aeVar2 = (ae) it10.next();
                                List<y> list = (List) loveWallHomepageViewModel2.photoMap.get(Long.valueOf(aeVar2.f395438d));
                                if (list != null) {
                                    KLog kLog7 = KLog.INSTANCE;
                                    StringBuilder m27 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("merge photoSocialAssets: level=");
                                    m27.append(aeVar2.f395438d);
                                    m27.append(", photoSocialAssets size: ");
                                    m27.append(list.size());
                                    kLog7.i(str, m27.toString());
                                    for (y yVar2 : list) {
                                        if (!yVar2.f395514d.isEmpty()) {
                                            KLog kLog8 = KLog.INSTANCE;
                                            StringBuilder m28 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("merge: level=");
                                            m28.append(aeVar2.f395438d);
                                            m28.append(str2);
                                            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) yVar2.f395514d);
                                            str = str;
                                            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m28, ((z) first).f395518d, kLog8, str);
                                        }
                                    }
                                    long j16 = aeVar2.f395438d;
                                    String str3 = aeVar2.f395439e;
                                    String str4 = aeVar2.f395440f;
                                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
                                    arrayList5.add(new ae(j16, str3, str4, mutableList, aeVar2.f395442i, aeVar2.f395443m, aeVar2.C, aeVar2.D));
                                    it10 = it10;
                                    str2 = str2;
                                } else {
                                    arrayList5.add(aeVar2);
                                }
                            }
                            loveWallHomepageViewModel2.tree.setValue(new ad(adVar.f395432d, adVar.f395433e, adVar.f395434f, arrayList5, adVar.f395436i, adVar.f395437m, adVar.C));
                        }
                        loveWallHomepageViewModel2.loadTree();
                        loveWallHomepageViewModel2.loadProgressView();
                    }
                    boolean z19 = adVar != null;
                    Function1<Boolean, Unit> function12 = function1;
                    if (function12 != null) {
                        function12.invoke(Boolean.valueOf(z19));
                    }
                    if (loveWallHomepageViewModel.guildState.getValue() == GuildState.REQUESTING) {
                        MutableState<GuildState> mutableState = loveWallHomepageViewModel.guildState;
                        if (z19) {
                            guildState = GuildState.NONE;
                        } else {
                            guildState = GuildState.PLANTING_GUILD;
                        }
                        mutableState.setValue(guildState);
                    }
                    MutableState<UserTreeState> mutableState2 = loveWallHomepageViewModel.userTreeState;
                    if (z19) {
                        userTreeState = UserTreeState.HAS_TREE;
                    } else {
                        userTreeState = UserTreeState.NOT_CREATE_TREE;
                    }
                    mutableState2.setValue(userTreeState);
                }
                return Unit.INSTANCE;
            }
        }));
    }
}
