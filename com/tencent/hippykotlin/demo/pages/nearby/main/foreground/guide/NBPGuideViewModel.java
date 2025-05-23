package com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide;

import c01.c;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$getUserInfoFromNT$2;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyAIOAccessService;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.login.NBPMainLoginViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.tasks.FeedEntranceTipsTask;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.tasks.PublicAccountFollowGuideTask;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.tasks.RedirectJumpCheckTask;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.tasks.TagPickGuideTask;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import defpackage.j;
import f35.g;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPGuideViewModel extends NBPMainBaseViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideViewModel.class, "showMarkerTouchGuide", "getShowMarkerTouchGuide()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideViewModel.class, "isInMainPage", "isInMainPage()Z", 0)};
    public e cachedPushNTUser;
    public boolean hasJumpAIO;
    public boolean isDoingRequestLocationPermission;
    public g loginRsp;
    public boolean needCheckLocationPermissionWhenAppear;
    public final ReadWriteProperty showMarkerTouchGuide$delegate = c.a(Boolean.FALSE);
    public String pageWillDestroyNotifyRef = "";
    public final ReadWriteProperty isInMainPage$delegate = c.a(Boolean.TRUE);
    public SequenceTaskQueue sequenceTasks = new SequenceTaskQueue();

    public final boolean hadLocationPermission() {
        return QQNearbyModule.Companion.getInstance().hadLocationPermission();
    }

    public final void jumpToAIO(String str, String str2) {
        e eVar;
        e eVar2;
        if (this.hasJumpAIO) {
            return;
        }
        this.hasJumpAIO = true;
        QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
        int j3 = NBPMainKtxKt.getPageData().n().j("key_from");
        String peerUid = NBPMainKtxKt.getPeerUid(NBPMainKtxKt.getPageData());
        if ((str.length() == 0) && ((eVar2 = this.cachedPushNTUser) == null || (str = eVar2.p("nick")) == null)) {
            str = "";
        }
        if ((str2.length() == 0) && ((eVar = this.cachedPushNTUser) == null || (str2 = eVar.p("avatar")) == null)) {
            str2 = "";
        }
        companion.launchNearbyAIOFragment(j3, peerUid, str, str2);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onBeforeSetSigData() {
        if (Intrinsics.areEqual(NBPMainKtxKt.getJumpScheme(NBPMainKtxKt.getPageData()), "nearby_pro_open_chat_aio")) {
            this.hasJumpAIO = false;
        }
        if (Intrinsics.areEqual(NBPMainKtxKt.getJumpScheme(NBPMainKtxKt.getPageData()), "nearby_pro_open_chat_aio")) {
            QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
            String peerUid = NBPMainKtxKt.getPeerUid(NBPMainKtxKt.getPageData());
            Function2<String, String, Unit> function2 = new Function2<String, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel$processNTBeforeSetSigData$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(String str, String str2) {
                    String str3 = str;
                    String str4 = str2;
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("processNTBeforeSetSigData pageData.peerUid:");
                    m3.append(NBPMainKtxKt.getPeerUid(NBPMainKtxKt.getPageData()));
                    m3.append(", nick: ");
                    m3.append(str3);
                    m3.append(", url: ");
                    m3.append(str4);
                    kLog.i("NBPGuideViewModel", m3.toString());
                    NBPGuideViewModel nBPGuideViewModel = NBPGuideViewModel.this;
                    e eVar = new e();
                    eVar.v("key_peerId", NBPMainKtxKt.getPeerUid(NBPMainKtxKt.getPageData()));
                    eVar.v("nick", str3);
                    eVar.v(PhotoCategorySummaryInfo.AVATAR_URL, str4);
                    nBPGuideViewModel.cachedPushNTUser = eVar;
                    QQNearbyModule.Companion.getInstance().asyncToNativeMethod("cacheNTUserBeforeSetSig", NBPGuideViewModel.this.cachedPushNTUser, (Function1<? super e, Unit>) null);
                    if (((NBPMainLoginViewModel) NBPMainKtxKt.getVmStore().getViewModel("NBPMainLoginViewModel")).locationSuccess) {
                        NBPGuideViewModel.this.jumpToAIO(str3, str4);
                    }
                    return Unit.INSTANCE;
                }
            };
            companion.getClass();
            e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("key_peerId", peerUid);
            Unit unit = Unit.INSTANCE;
            companion.asyncToNativeMethod("getUserInfoFromNT", m3, new QQNearbyModule$getUserInfoFromNT$2(function2));
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onEnterMap() {
        CollectionsKt__MutableCollectionsKt.addAll(this.sequenceTasks.tasks, new ISequenceTask[]{new RedirectJumpCheckTask(NBPMainKtxKt.getPageData()), new PublicAccountFollowGuideTask(), new FeedEntranceTipsTask(NBPViewModelStoreKt.getControlViewModel(NBPMainKtxKt.getVmStore())), new TagPickGuideTask(NBPMainKtxKt.getPageData(), new Function0<g>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel$onEnterMap$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final g invoke() {
                return NBPGuideViewModel.this.loginRsp;
            }
        }, new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel$onEnterMap$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                NBPGuideViewModel nBPGuideViewModel = NBPGuideViewModel.this;
                return Boolean.valueOf(((Boolean) nBPGuideViewModel.isInMainPage$delegate.getValue(nBPGuideViewModel, NBPGuideViewModel.$$delegatedProperties[1])).booleanValue());
            }
        }, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel$onEnterMap$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                NBPGuideViewModel.this.setInMainPage(bool.booleanValue());
                return Unit.INSTANCE;
            }
        })});
        SequenceTaskQueue sequenceTaskQueue = this.sequenceTasks;
        if (sequenceTaskQueue.started) {
            return;
        }
        sequenceTaskQueue.started = true;
        sequenceTaskQueue.execute();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onLocationFinish(boolean z16, NBPSsoLocation nBPSsoLocation) {
        String q16 = NBPMainKtxKt.getPageData().n().q("min_version", "");
        KLog kLog = KLog.INSTANCE;
        kLog.i("NBPGuideViewModel", "onLocationFinish success: " + z16 + ", router: " + NBPMainKtxKt.getJumpScheme(NBPMainKtxKt.getPageData()) + ", minVersion: " + q16 + '.');
        if (z16) {
            if (NBPMainKtxKt.getJumpScheme(NBPMainKtxKt.getPageData()).length() > 0) {
                if (QQUtils.INSTANCE.compare(q16) < 0) {
                    StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("version is too low, not jump. minVersion: ", q16, ", currentVersion: ");
                    com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                    m3.append(cVar.g().getPageData().getAppVersion());
                    kLog.i("NBPGuideViewModel", m3.toString());
                    ((QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi")).qqToast("\u7248\u672c\u8f83\u4f4e\uff0c\u8bf7\u5347\u7ea7\u5230\u6700\u65b0\u7248\u672c\u4f53\u9a8c", QToastMode.Info);
                    return;
                }
                if (Intrinsics.areEqual(NBPMainKtxKt.getJumpScheme(NBPMainKtxKt.getPageData()), "nearby_pro_open_chat_aio")) {
                    e eVar = this.cachedPushNTUser;
                    if (Intrinsics.areEqual(eVar != null ? eVar.p("peerUid") : null, NBPMainKtxKt.getPeerUid(NBPMainKtxKt.getPageData()))) {
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleJumpToAIO cache NT user:");
                        m16.append(this.cachedPushNTUser);
                        kLog.i("NBPGuideViewModel", m16.toString());
                        jumpToAIO("", "");
                        return;
                    }
                    QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                    String peerUid = NBPMainKtxKt.getPeerUid(NBPMainKtxKt.getPageData());
                    Function2<String, String, Unit> function2 = new Function2<String, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel$handleJumpToAIO$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(String str, String str2) {
                            String str3 = str;
                            String str4 = str2;
                            KLog kLog2 = KLog.INSTANCE;
                            StringBuilder a16 = j.a("getUserInfoFromNT nick: ", str3, ", url: ", str4, ", cached user:");
                            a16.append(NBPGuideViewModel.this.cachedPushNTUser);
                            kLog2.i("NBPGuideViewModel", a16.toString());
                            if (str3.length() > 0) {
                                if (str4.length() > 0) {
                                    NBPGuideViewModel.this.jumpToAIO(str3, str4);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    companion.getClass();
                    e m17 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("key_peerId", peerUid);
                    Unit unit = Unit.INSTANCE;
                    companion.asyncToNativeMethod("getUserInfoFromNT", m17, new QQNearbyModule$getUserInfoFromNT$2(function2));
                    return;
                }
                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.openPage$default(NBPMainKtxKt.getJumpScheme(NBPMainKtxKt.getPageData()), false, 6);
            }
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerCreated() {
        ((NBPMainLoginViewModel) NBPMainKtxKt.getVmStore().getViewModel("NBPMainLoginViewModel")).startLogin();
        NearbyAIOAccessService companion = NearbyAIOAccessService.Companion.getInstance();
        if (companion != null) {
            companion.fetch();
        }
        this.pageWillDestroyNotifyRef = k.b((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "NBP_KUIKLY_PAGE_WILL_DESTORY_EVENT", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel$addKuiklyPageDestroyNotify$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                String p16 = eVar2 != null ? eVar2.p("pageName") : null;
                if (Intrinsics.areEqual(p16, "nearbypro_guide_tag_pick") || Intrinsics.areEqual(p16, "nbp_public_account_follow")) {
                    NBPGuideViewModel.this.setInMainPage(true);
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerWillDestroy() {
        NearbyAIOAccessService.Companion companion = NearbyAIOAccessService.Companion;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("clear=");
        m3.append(NearbyAIOAccessService.instance);
        kLog.i("NearbyAioSafeCheckService", m3.toString());
        NearbyAIOAccessService.instance = null;
        Utils.INSTANCE.cacheModule("").setObject("nbp_aio_access_data_for_safe", NearbyAIOAccessService.defaultJson);
        ((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule")).e("NBP_KUIKLY_PAGE_WILL_DESTORY_EVENT", this.pageWillDestroyNotifyRef);
    }

    public final void reportAuthImpEnd(boolean z16) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_auth_layer", "dt_eid", "em_nearby_authlayer");
        m3.t("nearby_is_auth", d.b(z16));
        m3.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp_end", m3);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    public final void requestLocationPermission() {
        AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("nearby_location: start request location permission, isRequesting: "), this.isDoingRequestLocationPermission, KLog.INSTANCE, "NBPGuideViewModel");
        if (this.isDoingRequestLocationPermission) {
            return;
        }
        this.isDoingRequestLocationPermission = true;
        Iterator it = NBPMainKtxKt.getVmStore().viewModels.values().iterator();
        while (it.hasNext()) {
            ((NBPMainBaseViewModel) it.next()).onRequestLocationPermission();
        }
        QQNearbyModule.Companion.getInstance().requestLocationPermission(new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel$requestLocationPermission$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Integer num) {
                int intValue = num.intValue();
                NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("nearby_location: on request location permission finish: ", intValue, KLog.INSTANCE, "NBPGuideViewModel");
                if (intValue == 1) {
                    NBPMainKtxKt.getVmStore().onLocationPermissionGranted(false);
                    NBPGuideViewModel.this.reportAuthImpEnd(true);
                } else if (intValue == 2) {
                    NBPMainKtxKt.getVmStore().onLocationPermissionDenied();
                    NBPGuideViewModel.this.reportAuthImpEnd(false);
                    TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel$requestLocationPermission$1.1
                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.closePage$default();
                            return Unit.INSTANCE;
                        }
                    }, 1, null);
                } else if (intValue != 3) {
                    TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel$requestLocationPermission$1.2
                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.closePage$default();
                            return Unit.INSTANCE;
                        }
                    }, 1, null);
                } else {
                    NBPGuideViewModel.this.needCheckLocationPermissionWhenAppear = true;
                }
                NBPGuideViewModel.this.isDoingRequestLocationPermission = false;
                return Unit.INSTANCE;
            }
        });
    }

    public final void setInMainPage(boolean z16) {
        this.isInMainPage$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }

    public final void setShowMarkerTouchGuide(boolean z16) {
        this.showMarkerTouchGuide$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }

    public final boolean studyModeSwitch() {
        boolean areEqual = Intrinsics.areEqual(QQNearbyModule.Companion.getInstance().syncToNativeMethod("studyModeSwitch", (e) null, (Function1<? super e, Unit>) null), "1");
        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("is in study mode: ", areEqual, KLog.INSTANCE, "NBPGuideViewModel");
        return areEqual;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPageDidAppear() {
        setInMainPage(true);
        if (this.needCheckLocationPermissionWhenAppear) {
            this.needCheckLocationPermissionWhenAppear = false;
            KLog kLog = KLog.INSTANCE;
            kLog.i("NBPGuideViewModel", "start check location permission when appear");
            if (hadLocationPermission()) {
                NBPMainKtxKt.getVmStore().onLocationPermissionGranted(true);
                reportAuthImpEnd(true);
                kLog.i("NBPGuideViewModel", "had location permission in appear");
                return;
            } else {
                NBPMainKtxKt.getVmStore().onLocationPermissionDenied();
                reportAuthImpEnd(false);
                TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel$onPageDidAppear$1
                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi.Companion.closePage$default();
                        return Unit.INSTANCE;
                    }
                }, 1, null);
                kLog.i("NBPGuideViewModel", "denied location permission in appear");
                return;
            }
        }
        if (this.loginRsp == null || hadLocationPermission()) {
            return;
        }
        requestLocationPermission();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onNBPLogin(boolean z16, g gVar) {
        if (z16) {
            this.loginRsp = gVar;
            KLog kLog = KLog.INSTANCE;
            kLog.i("NBPGuideViewModel", "start nbp check and guide");
            if (studyModeSwitch()) {
                ((QQUIModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQUIModule")).openAlertDialog("", "\u62b1\u6b49\uff0c\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u4e0b\u6682\u4e0d\u652f\u6301\u8bbf\u95ee", "", "\u6211\u77e5\u9053\u4e86", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel$showStudyModeLimit$1
                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Boolean bool, Boolean bool2) {
                        bool.booleanValue();
                        bool2.booleanValue();
                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi.Companion.closePage$default();
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            if (hadLocationPermission()) {
                kLog.i("NBPGuideViewModel", "checkAndGuide: had permission dispatch on granted");
                NBPMainKtxKt.getVmStore().onLocationPermissionGranted(false);
            } else {
                requestLocationPermission();
            }
            if (NBPMainKtxKt.getJumpScheme(NBPMainKtxKt.getPageData()).length() > 0) {
                TimerKt.d(5000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.NBPGuideViewModel$startLoginResultTimer$1
                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        KLog.INSTANCE.i("NBPGuideViewModel", "wait login time");
                        return Unit.INSTANCE;
                    }
                });
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("need jump to ");
                m3.append(NBPMainKtxKt.getJumpScheme(NBPMainKtxKt.getPageData()));
                m3.append(", wait location success");
                kLog.i("NBPGuideViewModel", m3.toString());
            }
        }
    }
}
