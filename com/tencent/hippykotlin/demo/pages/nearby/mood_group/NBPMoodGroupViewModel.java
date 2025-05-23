package com.tencent.hippykotlin.demo.pages.nearby.mood_group;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Point;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.mood.PublishRequest;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupOpenParams;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.NBPMoodGroupRepo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.BackgroundInfo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerInfo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.layout.MarkerLayout;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.layout.PointInfo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupReportViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupUserActionViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.enter_tip.NBPUserEnterTipViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.INBPShootEventListener;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootPoint;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.timer.TimerKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import p25.a;
import w25.f;

/* loaded from: classes31.dex */
public final class NBPMoodGroupViewModel implements IBarrageLoop, INBPShootEventListener {
    public d barrageIconFrame;
    public BarrageLoopManger barrageLoopManger;
    public final MutableState barragePopShow$delegate;
    public final MutableState bgInfo$delegate;
    public NBPMoodGroupConfig config;
    public String configStrData;
    public MutableState<Boolean> didReceivePrayCard;
    public NBPUserEnterTipViewModel enterTipVM;
    public final MutableState groupDistance$delegate;
    public final MutableState groupUserNum$delegate;
    public final MutableState hostMood$delegate;
    public final MutableState isFirstTime$delegate;
    public MutableState<Boolean> isResultViewPopable;
    public boolean isShooting;
    public MarkerLayout markerLayout;
    public final g pageData;
    public final NBPMoodGroupOpenParams pageParams;
    public final MutableState pageState$delegate;
    public final Lazy repo$delegate;
    public final Lazy reportVM$delegate;
    public final Lazy resultVM$delegate;
    public final Lazy shootVM$delegate;
    public final MutableState showJoinPop$delegate;
    public MutableState<Boolean> startToPlay;
    public final Lazy userActionVM$delegate;
    public final SnapshotStateList<UserMarkerInfo> userMarkers;

    public NBPMoodGroupViewModel(g gVar) {
        Lazy lazy;
        MutableState mutableStateOf$default;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        MutableState mutableStateOf$default7;
        MutableState<Boolean> mutableStateOf$default8;
        MutableState<Boolean> mutableStateOf$default9;
        MutableState<Boolean> mutableStateOf$default10;
        MutableState mutableStateOf$default11;
        Lazy lazy5;
        this.pageData = gVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NBPMoodGroupRepo>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel$repo$2
            @Override // kotlin.jvm.functions.Function0
            public final NBPMoodGroupRepo invoke() {
                return new NBPMoodGroupRepo();
            }
        });
        this.repo$delegate = lazy;
        this.pageParams = NBPMoodGroupOpenParams.Companion.parse(gVar);
        this.configStrData = "";
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(NBPMoodGroupPageState.LOADING, null, 2, null);
        this.pageState$delegate = mutableStateOf$default;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<NBPMoodGroupReportViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel$reportVM$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final NBPMoodGroupReportViewModel invoke() {
                return new NBPMoodGroupReportViewModel(NBPMoodGroupViewModel.this.pageParams.mid);
            }
        });
        this.reportVM$delegate = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<NBPShootViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel$shootVM$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final NBPShootViewModel invoke() {
                NBPMoodGroupViewModel nBPMoodGroupViewModel = NBPMoodGroupViewModel.this;
                return new NBPShootViewModel(nBPMoodGroupViewModel, nBPMoodGroupViewModel.getReportVM(), NBPMoodGroupViewModel.this.pageData);
            }
        });
        this.shootVM$delegate = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<NBPShootResultViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel$resultVM$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final NBPShootResultViewModel invoke() {
                return new NBPShootResultViewModel(NBPMoodGroupViewModel.this.getReportVM());
            }
        });
        this.resultVM$delegate = lazy4;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.bgInfo$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.groupUserNum$delegate = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.groupDistance$delegate = mutableStateOf$default4;
        this.userMarkers = SnapshotStateKt.mutableStateListOf();
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.hostMood$delegate = mutableStateOf$default5;
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.barragePopShow$delegate = mutableStateOf$default6;
        this.barrageLoopManger = new BarrageLoopManger(getReportVM(), this);
        this.enterTipVM = new NBPUserEnterTipViewModel();
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showJoinPop$delegate = mutableStateOf$default7;
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.startToPlay = mutableStateOf$default8;
        Boolean bool2 = Boolean.TRUE;
        mutableStateOf$default9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.didReceivePrayCard = mutableStateOf$default9;
        mutableStateOf$default10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.isResultViewPopable = mutableStateOf$default10;
        mutableStateOf$default11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isFirstTime$delegate = mutableStateOf$default11;
        lazy5 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<NBPMoodGroupUserActionViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel$userActionVM$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final NBPMoodGroupUserActionViewModel invoke() {
                NBPMoodGroupViewModel nBPMoodGroupViewModel = NBPMoodGroupViewModel.this;
                int i3 = nBPMoodGroupViewModel.pageParams.mid;
                NBPMoodGroupConfig nBPMoodGroupConfig = nBPMoodGroupViewModel.config;
                return new NBPMoodGroupUserActionViewModel(nBPMoodGroupConfig != null ? nBPMoodGroupConfig.barrageConfig : null);
            }
        });
        this.userActionVM$delegate = lazy5;
    }

    public final void changeBarragePopVisible(boolean z16) {
        if (this.isShooting && z16) {
            return;
        }
        getUserActionVM().clear();
        this.barragePopShow$delegate.setValue(Boolean.valueOf(z16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final BackgroundInfo getBgInfo() {
        return (BackgroundInfo) this.bgInfo$delegate.getValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.mood_group.IBarrageLoop
    public final NBPMoodGroupPageState getCurrentPageState() {
        return getPageState();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final w25.g getHostMood() {
        return (w25.g) this.hostMood$delegate.getValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.mood_group.IBarrageLoop
    public final List<UserMarkerInfo> getMarkerList() {
        List<UserMarkerInfo> list;
        list = CollectionsKt___CollectionsKt.toList(this.userMarkers);
        return list;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.mood_group.IBarrageLoop
    public final int getMid() {
        return this.pageParams.mid;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.mood_group.IBarrageLoop
    public final NBPMoodGroupConfig getMoodConfig() {
        return this.config;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final NBPMoodGroupPageState getPageState() {
        return (NBPMoodGroupPageState) this.pageState$delegate.getValue();
    }

    public final NBPMoodGroupReportViewModel getReportVM() {
        return (NBPMoodGroupReportViewModel) this.reportVM$delegate.getValue();
    }

    public final NBPShootResultViewModel getResultVM() {
        return (NBPShootResultViewModel) this.resultVM$delegate.getValue();
    }

    public final NBPShootViewModel getShootVM() {
        return (NBPShootViewModel) this.shootVM$delegate.getValue();
    }

    public final NBPMoodGroupUserActionViewModel getUserActionVM() {
        return (NBPMoodGroupUserActionViewModel) this.userActionVM$delegate.getValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.mood_group.IBarrageLoop
    public final boolean isShooting() {
        return this.isShooting;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.INBPShootEventListener
    public final void onBoom(NBPShootPoint nBPShootPoint) {
        NBPMoodGroupConfig.ShootConfig shootConfig;
        float f16 = nBPShootPoint.f114234x;
        float f17 = nBPShootPoint.f114235y;
        NBPMoodGroupConfig nBPMoodGroupConfig = this.config;
        if (nBPMoodGroupConfig == null || (shootConfig = nBPMoodGroupConfig.shootConfig) == null) {
            return;
        }
        float f18 = shootConfig.boomEffectRadius;
        for (final UserMarkerInfo userMarkerInfo : this.userMarkers) {
            Point point = userMarkerInfo.markerCenterPos;
            float f19 = f16 - point.f114220x;
            float f26 = f17 - point.f114221y;
            float sqrt = (float) Math.sqrt((f26 * f26) + (f19 * f19));
            if (sqrt <= f18) {
                float f27 = (((f18 - sqrt) / f18) * 10) + 5;
                Point point2 = userMarkerInfo.markerCenterPos;
                userMarkerInfo.boomEffectOffset$delegate.setValue(new Point(((point2.f114220x - f16) * f27) / sqrt, ((point2.f114221y - f17) * f27) / sqrt));
                String str = userMarkerInfo.boomEffectResetTimeoutHandle;
                if (str != null) {
                    TimerKt.b(str);
                }
                userMarkerInfo.boomEffectResetTimeoutHandle = TimerKt.d(userMarkerInfo.boomEffectAwayTime, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerInfo$updateBoomEffect$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        UserMarkerInfo.this.boomEffectOffset$delegate.setValue(null);
                        return Unit.INSTANCE;
                    }
                });
            }
        }
    }

    public final void onJoinMoodGroup() {
        int i3 = this.pageParams.mid;
        final Function3<f, Integer, String, Unit> function3 = new Function3<f, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel$onJoinMoodGroup$1
            {
                super(3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(f fVar, Integer num, String str) {
                Object obj;
                a aVar;
                String str2;
                a aVar2;
                f fVar2 = fVar;
                int intValue = num.intValue();
                String str3 = str;
                if (intValue == 0 && fVar2 != null) {
                    DatalineDetailViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onJoinMoodGroup success "), NBPMoodGroupViewModel.this.pageParams.mid, KLog.INSTANCE, "NBPMoodGroupViewModel");
                    w25.g gVar = fVar2.f444487d;
                    if (gVar != null) {
                        final NBPMoodGroupViewModel nBPMoodGroupViewModel = NBPMoodGroupViewModel.this;
                        nBPMoodGroupViewModel.hostMood$delegate.setValue(gVar);
                        nBPMoodGroupViewModel.groupUserNum$delegate.setValue(Integer.valueOf(((Number) nBPMoodGroupViewModel.groupUserNum$delegate.getValue()).intValue() + 1));
                        NBPMoodGroupViewModel.access$addUserMarker(nBPMoodGroupViewModel, true, gVar);
                        TimerKt.d(500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel$onJoinMoodGroup$1$1$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                NBPMoodGroupConfig.BarrageConfig barrageConfig;
                                List<NBPMoodGroupConfig.BarrageItemConfig> list;
                                Object obj2;
                                NBPMoodGroupConfig nBPMoodGroupConfig = NBPMoodGroupViewModel.this.config;
                                if (nBPMoodGroupConfig != null && (barrageConfig = nBPMoodGroupConfig.barrageConfig) != null && (list = barrageConfig.items) != null) {
                                    Iterator<T> it = list.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            obj2 = null;
                                            break;
                                        }
                                        obj2 = it.next();
                                        if (((NBPMoodGroupConfig.BarrageItemConfig) obj2).joinAutoShow) {
                                            break;
                                        }
                                    }
                                    NBPMoodGroupConfig.BarrageItemConfig barrageItemConfig = (NBPMoodGroupConfig.BarrageItemConfig) obj2;
                                    if (barrageItemConfig != null) {
                                        NBPMoodGroupViewModel.this.barrageLoopManger.sendBarrage(barrageItemConfig, false);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    e eVar = new e();
                    NBPMoodGroupViewModel nBPMoodGroupViewModel2 = NBPMoodGroupViewModel.this;
                    w25.g hostMood = nBPMoodGroupViewModel2.getHostMood();
                    String str4 = "";
                    if (hostMood == null || (aVar2 = hostMood.f444489e) == null) {
                        obj = "";
                    } else {
                        obj = Integer.valueOf(aVar2.f424995e);
                    }
                    eVar.v("mid", obj);
                    w25.g hostMood2 = nBPMoodGroupViewModel2.getHostMood();
                    if (hostMood2 != null && (aVar = hostMood2.f444489e) != null && (str2 = aVar.D) != null) {
                        str4 = str2;
                    }
                    eVar.v("icon", str4);
                    k.d((k) c.f117352a.g().acquireModule("KRNotifyModule"), "NEARBY_JOIN_MOOD_GROUP_EVENT", eVar, false, 4, null);
                } else {
                    NearbyProUtilsKt.toastAPIErrorMsg$default(intValue, str3);
                }
                return Unit.INSTANCE;
            }
        };
        KLog.INSTANCE.i("NBPMainMoodGroupRepo", "publish: " + i3);
        PublishRequest publishRequest = new PublishRequest(i3);
        Function1<PbResponse<f>, Unit> function1 = new Function1<PbResponse<f>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.mood.NBPMainMoodGroupRepo$publish$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<f> pbResponse) {
                PbResponse<f> pbResponse2 = pbResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("publish response, ");
                m3.append(pbResponse2.f114187msg);
                m3.append(", ");
                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, pbResponse2.code, kLog, "NBPMainMoodGroupRepo");
                function3.invoke(pbResponse2.rsp, Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.mood_svr.MoodSvr.SsoPublish");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(publishRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function1), 6);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.INBPShootEventListener
    public final void onShootEnd() {
        KLog.INSTANCE.i("NBPMoodGroupViewModel", "onShootEnd");
        this.isShooting = false;
        this.isResultViewPopable.setValue(Boolean.TRUE);
        this.barrageLoopManger.resume();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.INBPShootEventListener
    public final void onShootStart() {
        KLog.INSTANCE.i("NBPMoodGroupViewModel", "onShootStart");
        this.isShooting = true;
        this.isResultViewPopable.setValue(Boolean.FALSE);
        getUserActionVM().clear();
        BarrageLoopManger barrageLoopManger = this.barrageLoopManger;
        barrageLoopManger.mangerState = 1;
        String str = barrageLoopManger.loop;
        if (str != null) {
            TimerKt.b(str);
            barrageLoopManger.loop = null;
        }
        Iterator<UserMarkerInfo> it = this.userMarkers.iterator();
        while (it.hasNext()) {
            UserMarkerInfo next = it.next();
            next.currentBarrage$delegate.setValue(null);
            String str2 = next.barrageTimeoutHandle;
            if (str2 != null) {
                TimerKt.b(str2);
                next.barrageTimeoutHandle = null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean setAttachConfig(String str, boolean z16) {
        com.tencent.kuikly.core.base.k kVar;
        KLog kLog = KLog.INSTANCE;
        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("setAttachConfig: ", str, kLog, "NBPMoodGroupViewModel");
        NBPMoodGroupConfig parseFromJsonStr = NBPMoodGroupConfig.Companion.parseFromJsonStr(str);
        if (parseFromJsonStr == null) {
            kLog.e("NBPMoodGroupViewModel", "parse config failed " + str);
            if (!z16) {
                NearbyProUtilsKt.toastAPIErrorMsg$default(-1, "parse config failed");
                this.pageState$delegate.setValue(NBPMoodGroupPageState.ERROR);
            }
            return false;
        }
        NBPMoodGroupConfig.GradientColor gradientColor = parseFromJsonStr.backgroundConfig.backgroundColor;
        if (gradientColor != null) {
            QQKuiklyPlatformApi currentQQKuiklyPlatformApi = Utils.INSTANCE.currentQQKuiklyPlatformApi();
            Direction direction = gradientColor.direction;
            j[] jVarArr = gradientColor.colorStops;
            j[] jVarArr2 = (j[]) Arrays.copyOf(jVarArr, jVarArr.length);
            currentQQKuiklyPlatformApi.getClass();
            c cVar = c.f117352a;
            if (!AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar)) {
                b g16 = cVar.g();
                Pager pager = g16 instanceof Pager ? (Pager) g16 : null;
                if (pager != null && (kVar = (com.tencent.kuikly.core.base.k) pager.getViewAttr()) != null) {
                    kVar.mo135backgroundLinearGradient(direction, (j[]) Arrays.copyOf(jVarArr2, jVarArr2.length));
                }
            } else {
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("linear-gradient(");
                m3.append(direction.ordinal());
                String sb5 = m3.toString();
                for (j jVar : jVarArr2) {
                    sb5 = sb5 + ',' + jVar;
                }
                currentQQKuiklyPlatformApi.toNative(false, "setPageBackgroundLinearGradient", sb5 + ')', null, true);
            }
        }
        this.config = parseFromJsonStr;
        this.configStrData = str;
        getShootVM().config = str;
        final NBPShootViewModel shootVM = getShootVM();
        NBPMoodGroupConfig.ShootConfig shootConfig = parseFromJsonStr.shootConfig;
        int i3 = this.pageParams.mid;
        shootVM.getClass();
        if (!shootConfig.emojis.isEmpty()) {
            shootVM.mid = i3;
            NBPMoodGroupConfig.ShootEmojiItemConfig shootEmojiItemConfig = shootConfig.emojis.get(Random.INSTANCE.nextInt(0, shootConfig.emojis.size()));
            shootVM.emojiId = shootEmojiItemConfig.emojiId;
            shootVM.entranceEmojiIcon = shootEmojiItemConfig.entranceIcon;
            shootVM.topGuideTipText = shootEmojiItemConfig.newTopGuideTip;
            shootVM.bottomTipText = shootEmojiItemConfig.bottomTip;
            shootVM.shootEmojiIcon = shootEmojiItemConfig.shootIcon;
            shootVM.shootBoomAPNG = shootEmojiItemConfig.boomAPNG;
            List<String> list = shootConfig.numbers;
            shootVM.numberIcons = list;
            if (list.size() > 10) {
                shootVM.xIconUrl = shootVM.numberIcons.get(10);
            }
            TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel$configDidLoad$1
                {
                    super(0);
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0021, code lost:
                
                    if (r1.intValue() == 1) goto L9;
                 */
                @Override // kotlin.jvm.functions.Function0
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Unit invoke() {
                    final NBPShootViewModel nBPShootViewModel = NBPShootViewModel.this;
                    Integer num = ((CacheModule) c.f117352a.g().acquireModule("HRCacheModule")).getInt(nBPShootViewModel.controlGuideCacheKey());
                    boolean z17 = num != null;
                    nBPShootViewModel.didControlGuideOnHistory = z17;
                    if (!Intrinsics.areEqual(nBPShootViewModel.getLastDateOfShoot(), nBPShootViewModel.today)) {
                        nBPShootViewModel.showTopGuideTip.setValue(Boolean.TRUE);
                        TimerKt.d(5000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel$initGuideTip$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                NBPShootViewModel.this.showTopGuideTip.setValue(Boolean.FALSE);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    return Unit.INSTANCE;
                }
            }, 1, null);
            NBPMoodGroupReportViewModel nBPMoodGroupReportViewModel = shootVM.reporter;
            e eVar = new e();
            eVar.v("nearby_emoji_id", shootVM.emojiId);
            Unit unit = Unit.INSTANCE;
            nBPMoodGroupReportViewModel.dtReportElementImp("em_nearby_launch", eVar);
        }
        this.bgInfo$delegate.setValue(new BackgroundInfo(parseFromJsonStr.backgroundConfig, parseFromJsonStr.userMarkerConfig.infoBarSize, this.pageData.m(), this.pageData.l()));
        return true;
    }

    public static final void access$addUserMarker(NBPMoodGroupViewModel nBPMoodGroupViewModel, boolean z16, w25.g... gVarArr) {
        NBPMoodGroupConfig nBPMoodGroupConfig;
        NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig;
        NBPMoodGroupConfig.BarrageConfig barrageConfig;
        List filterNotNull;
        int collectionSizeOrDefault;
        Object removeFirstOrNull;
        PointInfo pointInfo;
        UserMarkerInfo userMarkerInfo;
        MarkerLayout markerLayout = nBPMoodGroupViewModel.markerLayout;
        if (markerLayout == null || (nBPMoodGroupConfig = nBPMoodGroupViewModel.config) == null || (userMarkerConfig = nBPMoodGroupConfig.userMarkerConfig) == null || (barrageConfig = nBPMoodGroupConfig.barrageConfig) == null) {
            return;
        }
        filterNotNull = ArraysKt___ArraysKt.filterNotNull(gVarArr);
        ArrayList arrayList = new ArrayList();
        for (Object obj : filterNotNull) {
            w25.g gVar = (w25.g) obj;
            Iterator<UserMarkerInfo> it = nBPMoodGroupViewModel.userMarkers.iterator();
            while (true) {
                if (it.hasNext()) {
                    userMarkerInfo = it.next();
                    if (gVar.f444488d == userMarkerInfo.user.f444488d) {
                        break;
                    }
                } else {
                    userMarkerInfo = null;
                    break;
                }
            }
            if (true ^ (userMarkerInfo != null)) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            w25.g gVar2 = (w25.g) it5.next();
            if (!UserDataManager.INSTANCE.isHostTid(Long.valueOf(gVar2.f444488d))) {
                removeFirstOrNull = CollectionsKt__MutableCollectionsKt.removeFirstOrNull(markerLayout.guestPositions);
                pointInfo = (PointInfo) removeFirstOrNull;
                if (pointInfo == null) {
                    pointInfo = new PointInfo(markerLayout.randomPoint(false), -1);
                    arrayList2.add(new UserMarkerInfo(gVar2, userMarkerConfig, barrageConfig, pointInfo.point, z16));
                }
            } else {
                pointInfo = markerLayout.hostPosition;
            }
            arrayList2.add(new UserMarkerInfo(gVar2, userMarkerConfig, barrageConfig, pointInfo.point, z16));
        }
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            UserMarkerInfo userMarkerInfo2 = (UserMarkerInfo) it6.next();
            SnapshotStateList<UserMarkerInfo> snapshotStateList = nBPMoodGroupViewModel.userMarkers;
            Point point = userMarkerInfo2.containerPos;
            int size = snapshotStateList.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    Point point2 = snapshotStateList.get(i3).containerPos;
                    float f16 = point2.f114221y;
                    float f17 = point.f114221y;
                    if (f16 <= f17 && (f16 < f17 || point2.f114220x < point.f114220x)) {
                        i3++;
                    }
                } else {
                    i3 = snapshotStateList.size();
                    break;
                }
            }
            nBPMoodGroupViewModel.userMarkers.add(i3, userMarkerInfo2);
        }
    }
}
