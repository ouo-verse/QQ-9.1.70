package com.tencent.hippykotlin.demo.pages.nearby.mood_group;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendOIDBRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.AttendanceStatusRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPAttendanceService$getAttendanceStatus$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.NBPBaseActivity;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.INBPMoodGroupRepo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BarragePopViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.BottomViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ErrorViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ShootResultViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.UserEnterTipViewNewKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.BackgroundInfo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.PlaygroundViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerInfo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.layout.MarkerLayout;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootAnimationLayerViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.enter_tip.EnterTip;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.enter_tip.NBPUserEnterTipViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.ICalendar;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.v;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k25.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import w25.g;

/* loaded from: classes31.dex */
public final class NBPMoodGroupActivity extends NBPBaseActivity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Lazy vm$delegate;

    public NBPMoodGroupActivity() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<NBPMoodGroupViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupActivity$vm$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final NBPMoodGroupViewModel invoke() {
                return new NBPMoodGroupViewModel(NBPMoodGroupActivity.this.getPageData());
            }
        });
        this.vm$delegate = lazy;
    }

    public final NBPMoodGroupViewModel getVm() {
        return (NBPMoodGroupViewModel) this.vm$delegate.getValue();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List<h35.a>, java.util.ArrayList] */
    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onDestroy() {
        super.onDestroy();
        NBPMoodGroupViewModel vm5 = getVm();
        vm5.enterTipVM.list.clear();
        BarrageLoopManger barrageLoopManger = vm5.barrageLoopManger;
        barrageLoopManger.msgIdSet.clear();
        barrageLoopManger.historyBarrage.clear();
        vm5.getShootVM().getClass();
        KLog.INSTANCE.i(NBPShootViewModel.TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        String str = vm5.getResultVM().openPageNotifyCallbackRef;
        if (str != null) {
            ((k) c.f117352a.g().acquireModule("KRNotifyModule")).e("NEARBY_OPEN_SHOOT_RESULT_PAGE", str);
        }
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        int collectionSizeOrDefault;
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, Pager.PAGER_EVENT_ROOT_VIEW_SIZE_CHANGED)) {
            final NBPMoodGroupViewModel vm5 = getVm();
            w wVar = new w(getPageData().m(), getPageData().l());
            vm5.getClass();
            KLog kLog = KLog.INSTANCE;
            kLog.i("NBPMoodGroupViewModel", "onContainerSizeChanged: " + wVar);
            NBPMoodGroupConfig nBPMoodGroupConfig = vm5.config;
            if (nBPMoodGroupConfig != null) {
                BackgroundInfo bgInfo = vm5.getBgInfo();
                if (Intrinsics.areEqual(bgInfo != null ? Float.valueOf(bgInfo.containerWidth) : null, wVar.getWidth())) {
                    BackgroundInfo bgInfo2 = vm5.getBgInfo();
                    if (Intrinsics.areEqual(bgInfo2 != null ? Float.valueOf(bgInfo2.containerHeight) : null, wVar.getHeight())) {
                        kLog.i("NBPMoodGroupViewModel", "onContainerSizeChanged: same");
                        return;
                    }
                }
                NBPMoodGroupConfig.BackgroundConfig backgroundConfig = nBPMoodGroupConfig.backgroundConfig;
                w wVar2 = nBPMoodGroupConfig.userMarkerConfig.infoBarSize;
                BackgroundInfo backgroundInfo = new BackgroundInfo(backgroundConfig, wVar2, vm5.pageData.m(), vm5.pageData.l());
                vm5.bgInfo$delegate.setValue(backgroundInfo);
                MarkerLayout markerLayout = vm5.markerLayout;
                if (markerLayout != null) {
                    vm5.markerLayout = new MarkerLayout(backgroundInfo.guestAreaPolygon, backgroundInfo.hostAreaPolygon, markerLayout.guestCount, wVar2);
                    SnapshotStateList<UserMarkerInfo> snapshotStateList = vm5.userMarkers;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(snapshotStateList, 10);
                    final ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<UserMarkerInfo> it = snapshotStateList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().user);
                    }
                    vm5.userMarkers.clear();
                    TimerKt.d(50, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel$onContainerSizeChanged$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            List<g> list = arrayList;
                            NBPMoodGroupViewModel nBPMoodGroupViewModel = vm5;
                            Iterator<T> it5 = list.iterator();
                            while (it5.hasNext()) {
                                NBPMoodGroupViewModel.access$addUserMarker(nBPMoodGroupViewModel, false, (g) it5.next());
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
            }
        }
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void pageDidAppear() {
        super.pageDidAppear();
        final NBPMoodGroupViewModel vm5 = getVm();
        BarrageLoopManger barrageLoopManger = vm5.barrageLoopManger;
        barrageLoopManger.pageVisibleState = 1;
        barrageLoopManger.resume();
        k.b((k) c.f117352a.g().acquireModule("KRNotifyModule"), "NEARBY_RECEIVE_PRAY_CARD", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel$pageDidAppear$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                MutableState<Boolean> mutableState = NBPMoodGroupViewModel.this.startToPlay;
                Boolean bool = Boolean.TRUE;
                mutableState.setValue(bool);
                NBPMoodGroupViewModel.this.didReceivePrayCard.setValue(bool);
                return Unit.INSTANCE;
            }
        }, 2, null);
        getVm().getReportVM().dtReportPageExposure(true);
        TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupActivity$pageDidAppear$1
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).setBlackStatusBarStyle();
                return Unit.INSTANCE;
            }
        }, 1, null);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void pageDidDisappear() {
        super.pageDidDisappear();
        BarrageLoopManger barrageLoopManger = getVm().barrageLoopManger;
        barrageLoopManger.pageVisibleState = 2;
        barrageLoopManger.mangerState = 1;
        String str = barrageLoopManger.loop;
        if (str != null) {
            TimerKt.b(str);
            barrageLoopManger.loop = null;
        }
        getVm().getReportVM().dtReportPageExposure(false);
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity
    public final QUITokenThemeMode quiTokenThemeMode() {
        return QUITokenThemeMode.ONLY_DAY_AND_NIGHT;
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        super.onCreate(aVar);
        final NBPMoodGroupViewModel vm5 = getVm();
        vm5.getClass();
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onCreated, source:");
        m3.append(vm5.pageParams.source);
        m3.append(", mid:");
        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, vm5.pageParams.mid, kLog, "NBPMoodGroupViewModel");
        vm5.pageState$delegate.setValue(NBPMoodGroupPageState.LOADING);
        CacheModule cacheModule = Utils.INSTANCE.cacheModule("");
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("first_time_enter_mood_map_");
        m16.append(UserDataManager.INSTANCE.getUserSelfInfo().tid);
        vm5.isFirstTime$delegate.setValue(Boolean.valueOf(cacheModule.getInt(m16.toString()) == null));
        Function3<Boolean, String, b, Unit> function3 = new Function3<Boolean, String, b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel$checkDidReceivePrayCard$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Boolean bool, String str, b bVar) {
                bool.booleanValue();
                b bVar2 = bVar;
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("has received pray card: ");
                m17.append(bVar2 != null ? Boolean.valueOf(bVar2.f411442d) : null);
                kLog2.i("NBPMoodGroupViewModel", m17.toString());
                NBPMoodGroupViewModel.this.didReceivePrayCard.setValue(Boolean.valueOf(bVar2 != null ? bVar2.f411442d : false));
                return Unit.INSTANCE;
            }
        };
        c cVar = c.f117352a;
        ICalendar c16 = com.tencent.kuikly.core.module.b.c((com.tencent.kuikly.core.module.b) cVar.g().acquireModule("KRCalendarModule"), 0L, 1, null);
        int c17 = c16.c(ICalendar.Field.YEAR);
        int c18 = c16.c(ICalendar.Field.MONTH) + 1;
        int c19 = c16.c(ICalendar.Field.DAY_OF_MONTH);
        k25.c cVar2 = new k25.c(c17, c18, c19, 8);
        kLog.i("NBPAttendanceService", "getAttendanceStatus req: " + c17 + '-' + c18 + '-' + c19);
        AttendanceStatusRequest attendanceStatusRequest = new AttendanceStatusRequest(cVar2);
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(attendanceStatusRequest, false, new NearbyApi$sendOIDBRequest$1(new APICallTechReporter(1, attendanceStatusRequest.getCmd()), new NBPAttendanceService$getAttendanceStatus$1(function3)));
        String str = vm5.pageParams.attachConfig;
        if (!(str == null || str.length() == 0)) {
            vm5.setAttachConfig(str, true);
        }
        ((INBPMoodGroupRepo) vm5.repo$delegate.getValue()).getAll(vm5.pageParams.mid, new Function3<k35.c, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel$initPageData$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(k35.c cVar3, Integer num, String str2) {
                int collectionSizeOrDefault;
                List shuffled;
                int collectionSizeOrDefault2;
                k35.c cVar4 = cVar3;
                int intValue = num.intValue();
                String str3 = str2;
                if (intValue == 0 && cVar4 != null) {
                    NBPMoodGroupViewModel nBPMoodGroupViewModel = NBPMoodGroupViewModel.this;
                    int i3 = 0;
                    if (nBPMoodGroupViewModel.config == null && !nBPMoodGroupViewModel.setAttachConfig(cVar4.f411538i, false)) {
                        NearbyProUtilsKt.toastAPIErrorMsg$default(-1, "");
                        NBPMoodGroupViewModel.this.pageState$delegate.setValue(NBPMoodGroupPageState.ERROR);
                    } else {
                        NBPMoodGroupViewModel.this.groupUserNum$delegate.setValue(Integer.valueOf((int) cVar4.f411537h));
                        NBPMoodGroupViewModel.this.groupDistance$delegate.setValue(Integer.valueOf((int) cVar4.f411536f));
                        NBPMoodGroupViewModel.this.hostMood$delegate.setValue(cVar4.f411535e);
                        List<g> list = cVar4.f411534d;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list) {
                            if (true ^ UserDataManager.INSTANCE.isHostTid(Long.valueOf(((g) obj).f444488d))) {
                                arrayList.add(obj);
                            }
                        }
                        NBPMoodGroupViewModel nBPMoodGroupViewModel2 = NBPMoodGroupViewModel.this;
                        BackgroundInfo bgInfo = nBPMoodGroupViewModel2.getBgInfo();
                        nBPMoodGroupViewModel2.markerLayout = bgInfo != null ? new MarkerLayout(bgInfo.guestAreaPolygon, bgInfo.hostAreaPolygon, arrayList.size(), bgInfo.markerInfoBarSize) : null;
                        NBPMoodGroupViewModel nBPMoodGroupViewModel3 = NBPMoodGroupViewModel.this;
                        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                        spreadBuilder.add(NBPMoodGroupViewModel.this.getHostMood());
                        Object[] array = arrayList.toArray(new g[0]);
                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        spreadBuilder.addSpread(array);
                        NBPMoodGroupViewModel.access$addUserMarker(nBPMoodGroupViewModel3, false, (g[]) spreadBuilder.toArray(new g[spreadBuilder.size()]));
                        NBPMoodGroupViewModel.this.pageState$delegate.setValue(NBPMoodGroupPageState.SUCCESS);
                        NBPMoodGroupViewModel nBPMoodGroupViewModel4 = NBPMoodGroupViewModel.this;
                        final NBPUserEnterTipViewModel nBPUserEnterTipViewModel = nBPMoodGroupViewModel4.enterTipVM;
                        SnapshotStateList<UserMarkerInfo> snapshotStateList = nBPMoodGroupViewModel4.userMarkers;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(snapshotStateList, 10);
                        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                        Iterator<UserMarkerInfo> it = snapshotStateList.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(it.next().user);
                        }
                        nBPUserEnterTipViewModel.getClass();
                        KLog kLog2 = KLog.INSTANCE;
                        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("initData: size= ");
                        m17.append(arrayList2.size());
                        kLog2.i("EnterTipManger", m17.toString());
                        if (!arrayList2.isEmpty()) {
                            shuffled = CollectionsKt__CollectionsJVMKt.shuffled(arrayList2);
                            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(shuffled, 10);
                            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                            for (Object obj2 : shuffled) {
                                int i16 = i3 + 1;
                                if (i3 < 0) {
                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                }
                                g gVar = (g) obj2;
                                final EnterTip enterTip = new EnterTip(gVar.f444491h, gVar.f444490f);
                                TimerKt.d(i3 == 0 ? 5000 : i3 * 60000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.enter_tip.NBPUserEnterTipViewModel$initData$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPUserEnterTipViewModel.this.list.add(enterTip);
                                        return Unit.INSTANCE;
                                    }
                                });
                                arrayList3.add(enterTip);
                                i3 = i16;
                            }
                        }
                        NBPMoodGroupViewModel.this.barrageLoopManger.resume();
                        NBPMoodGroupViewModel nBPMoodGroupViewModel5 = NBPMoodGroupViewModel.this;
                        if (nBPMoodGroupViewModel5.pageParams.autoJoin == 1 && nBPMoodGroupViewModel5.getHostMood() == null) {
                            NBPMoodGroupViewModel.this.onJoinMoodGroup();
                        }
                    }
                } else {
                    KLog.INSTANCE.e("NBPMoodGroupViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("load data failed code=", intValue, ", msg=", str3));
                    NearbyProUtilsKt.toastAPIErrorMsg$default(intValue, str3);
                    NBPMoodGroupViewModel.this.pageState$delegate.setValue(NBPMoodGroupPageState.ERROR);
                }
                return Unit.INSTANCE;
            }
        });
        vm5.getShootVM().getClass();
        kLog.i(NBPShootViewModel.TAG, "onCreated");
        final NBPShootResultViewModel resultVM = vm5.getResultVM();
        resultVM.getClass();
        resultVM.openPageNotifyCallbackRef = k.b((k) cVar.g().acquireModule("KRNotifyModule"), "NEARBY_OPEN_SHOOT_RESULT_PAGE", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel$onCreated$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                KLog kLog2 = KLog.INSTANCE;
                kLog2.i("NBPShootResultPage", "open shoot result page");
                if (eVar2 != null) {
                    NBPShootResultViewModel.this.mid = eVar2.j("mid");
                    NBPShootResultViewModel.this.configString = eVar2.p(DownloadInfo.spKey_Config);
                    NBPShootResultViewModel.this.emojiId = eVar2.p("emoji_id");
                    int j3 = eVar2.j("serial_shoot_times");
                    NBPShootResultViewModel nBPShootResultViewModel = NBPShootResultViewModel.this;
                    int i3 = nBPShootResultViewModel.mid;
                    String str2 = nBPShootResultViewModel.emojiId;
                    nBPShootResultViewModel.mid = i3;
                    nBPShootResultViewModel.emojiId = str2;
                    nBPShootResultViewModel.boomCount = j3;
                    nBPShootResultViewModel.gameData = new k35.a(j3);
                    nBPShootResultViewModel.loadPageData();
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("initPageConfigData size: "), nBPShootResultViewModel.configString, kLog2, "NBPShootResultPage");
                    nBPShootResultViewModel.resultConfig$delegate.setValue(NBPMoodGroupConfig.Companion.parseFromJsonStr(nBPShootResultViewModel.configString));
                    NBPMoodGroupConfig resultConfig$qecommerce_biz_release = nBPShootResultViewModel.getResultConfig$qecommerce_biz_release();
                    if (resultConfig$qecommerce_biz_release != null) {
                        NBPMoodGroupConfig.MatchConfig matchConfig = resultConfig$qecommerce_biz_release.matchMsgConfig;
                        nBPShootResultViewModel.topRightBackgroundImg = matchConfig.topRightBackgroundImg;
                        nBPShootResultViewModel.cartoonImg = matchConfig.cartoonImg;
                        nBPShootResultViewModel.recommendMatchMsgList$delegate.setValue(matchConfig.texts);
                        nBPShootResultViewModel.themeId = resultConfig$qecommerce_biz_release.indicatorConfig.mapThemeId;
                        NBPMoodGroupConfig.Guide guide = resultConfig$qecommerce_biz_release.matchMsgConfig.guide;
                        nBPShootResultViewModel.guideText = guide.guideText;
                        nBPShootResultViewModel.guidePicture = guide.images;
                        nBPShootResultViewModel.editedText$delegate.setValue(nBPShootResultViewModel.getRecommendMatchMsgList().get(0));
                    }
                    if (c.f117352a.g().getPageData().l() < 830.0f) {
                        NBPShootResultViewModel.this.smallScreenOffsetY.setValue(Float.valueOf(70.0f));
                    }
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        com.tencent.ntcompose.activity.b.c(this, null, ComposableLambdaKt.composableLambdaInstance(-1175309530, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupActivity$onCreate$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer, Integer num) {
                Composer composer2 = composer;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1175309530, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupActivity.onCreate.<anonymous> (NBPMoodGroupActivity.kt:53)");
                    }
                    i E = ModifiersKt.E(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), true);
                    final NBPMoodGroupActivity nBPMoodGroupActivity = NBPMoodGroupActivity.this;
                    BoxKt.a(E, null, null, ComposableLambdaKt.composableLambda(composer2, -1853924564, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupActivity$onCreate$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num2) {
                            Composer composer4 = composer3;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1853924564, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupActivity.onCreate.<anonymous>.<anonymous> (NBPMoodGroupActivity.kt:57)");
                                }
                                NBPMoodGroupActivity nBPMoodGroupActivity2 = NBPMoodGroupActivity.this;
                                int i3 = NBPMoodGroupActivity.$r8$clinit;
                                int ordinal = nBPMoodGroupActivity2.getVm().getPageState().ordinal();
                                if (ordinal == 0 || ordinal == 1) {
                                    composer4.startReplaceableGroup(1246997214);
                                    i c26 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), h.INSTANCE.j());
                                    final NBPMoodGroupActivity nBPMoodGroupActivity3 = NBPMoodGroupActivity.this;
                                    Function2<v, aa<v>, Unit> function2 = new Function2<v, aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupActivity.onCreate.1.1.2
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(v vVar, aa<v> aaVar) {
                                            NBPMoodGroupActivity nBPMoodGroupActivity4 = NBPMoodGroupActivity.this;
                                            int i16 = NBPMoodGroupActivity.$r8$clinit;
                                            nBPMoodGroupActivity4.getVm().getShootVM().rootView = aaVar;
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final NBPMoodGroupActivity nBPMoodGroupActivity4 = NBPMoodGroupActivity.this;
                                    BoxKt.a(c26, null, function2, ComposableLambdaKt.composableLambda(composer4, 1398910675, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupActivity.onCreate.1.1.3
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer5, Integer num3) {
                                            Composer composer6 = composer5;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1398910675, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (NBPMoodGroupActivity.kt:70)");
                                                }
                                                NBPMoodGroupActivity nBPMoodGroupActivity5 = NBPMoodGroupActivity.this;
                                                int i16 = NBPMoodGroupActivity.$r8$clinit;
                                                PlaygroundViewKt.PlaygroundView(nBPMoodGroupActivity5.getVm(), composer6, 8);
                                                NavBarViewKt.NavBarView(NBPMoodGroupActivity.this.getVm(), composer6, 8);
                                                BottomViewKt.BottomView(NBPMoodGroupActivity.this.getVm(), composer6, 8);
                                                UserEnterTipViewNewKt.UserEnterTipViewNew(NBPMoodGroupActivity.this.getVm(), composer6, 8);
                                                BarragePopViewKt.BarragePopView(NBPMoodGroupActivity.this.getVm(), composer6, 8);
                                                JoinPopViewKt.JoinPopView(NBPMoodGroupActivity.this.getVm(), composer6, 8);
                                                ShootAnimationLayerViewKt.ShootAnimationLayerView(NBPMoodGroupActivity.this.getVm().getShootVM(), composer6, 8);
                                                ShootResultViewKt.ShootResultView(NBPMoodGroupActivity.this.getVm(), composer6, 8);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer4, 3080, 2);
                                    composer4.endReplaceableGroup();
                                } else if (ordinal != 2) {
                                    composer4.startReplaceableGroup(1246997882);
                                    composer4.endReplaceableGroup();
                                } else {
                                    composer4.startReplaceableGroup(1246996982);
                                    final NBPMoodGroupActivity nBPMoodGroupActivity5 = NBPMoodGroupActivity.this;
                                    ErrorViewKt.ErrorView(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupActivity.onCreate.1.1.1
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            NBPMoodGroupActivity nBPMoodGroupActivity6 = NBPMoodGroupActivity.this;
                                            int i16 = NBPMoodGroupActivity.$r8$clinit;
                                            NBPJumpUtil.jumpMoodGroupPage$default(nBPMoodGroupActivity6.getPageData().n().j("nbp_source"), nBPMoodGroupActivity6.getPageData().n().j("mid"), nBPMoodGroupActivity6.getPageData().n().k("auto_join", 0), null, true, 8);
                                            return Unit.INSTANCE;
                                        }
                                    }, composer4, 0);
                                    composer4.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer2, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
        if (getPageData().n().j("nbp_source") == 5 && getPageData().getIsAndroid()) {
            TimerKt.d(50, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupActivity$onCreate$2
                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m((k) c.f117352a.g().acquireModule("KRNotifyModule"), "NEARBY_CLOSE_MSG_PAGE_EVENT", false, 4, null);
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
