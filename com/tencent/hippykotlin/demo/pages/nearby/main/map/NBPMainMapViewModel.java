package com.tencent.hippykotlin.demo.pages.nearby.main.map;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.QQComposeViewExtCreator$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.HomepageSource;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPArticleFeedDetailRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyFeedRepo$fetchFeedDetailInfo$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraUpdate;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.NBPMarkerFactory;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import n25.l;
import o25.f;
import s25.d;

/* loaded from: classes31.dex */
public final class NBPMainMapViewModel extends NBPMainBaseViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainMapViewModel.class, "didEnterMapFinishWithMarkers", "getDidEnterMapFinishWithMarkers()Z", 0)};
    public static final Companion Companion = new Companion();
    public int enterLocationState;
    public boolean firstPositionChangeFinish;
    public aa<NBPMapView> mapViewRef;
    public NBPMapMarker selfHostPersonMarker;
    public float currentZoomLevel = -1.0f;
    public NBPLatLng currentTargetPosition = new NBPLatLng(0.0d, 0.0d, 3, null);
    public final ReadWriteProperty didEnterMapFinishWithMarkers$delegate = c.a(Boolean.FALSE);

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final boolean isVersionGreaterOrEqual(String str, String str2) {
            List split$default;
            List take;
            List split$default2;
            List take2;
            Integer intOrNull;
            Integer intOrNull2;
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull((String) it.next());
                if (intOrNull2 != null) {
                    arrayList.add(intOrNull2);
                }
            }
            take = CollectionsKt___CollectionsKt.take(arrayList, 3);
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{"."}, false, 0, 6, (Object) null);
            ArrayList arrayList2 = new ArrayList();
            Iterator it5 = split$default2.iterator();
            while (it5.hasNext()) {
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) it5.next());
                if (intOrNull != null) {
                    arrayList2.add(intOrNull);
                }
            }
            take2 = CollectionsKt___CollectionsKt.take(arrayList2, 3);
            int min = Math.min(take.size(), take2.size());
            for (int i3 = 0; i3 < min; i3++) {
                if (((Number) take2.get(i3)).intValue() > ((Number) take.get(i3)).intValue()) {
                    return true;
                }
                if (((Number) take2.get(i3)).intValue() < ((Number) take.get(i3)).intValue()) {
                    return false;
                }
            }
            return take2.size() >= take.size();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onEnterMap() {
        List listOf;
        e n3 = NBPMainKtxKt.getPageData().n();
        final int j3 = n3.j("source");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{3, 4});
        HomepageSource homepageSource = null;
        if (listOf.contains(Integer.valueOf(j3))) {
            String p16 = n3.p("nbp_fid");
            if (!(p16.length() == 0)) {
                final boolean areEqual = Intrinsics.areEqual(n3.p("is_detail"), "1");
                KLog kLog = KLog.INSTANCE;
                kLog.i("NBPJumpUtil", "handleJumpFromFeedShare, feedId: " + p16 + "\uff0c isDetail: " + areEqual);
                Function2<d, Integer, Unit> function2 = new Function2<d, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil$jumpFeedShare$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(d dVar, Integer num) {
                        d dVar2 = dVar;
                        int intValue = num.intValue();
                        if (NearbyProUtilsKt.isInNBPMain()) {
                            l lVar = dVar2 != null ? dVar2.f433131d : null;
                            if (intValue == -13005) {
                                Utils.INSTANCE.currentBridgeModule().qToast("\u5e16\u5b50\u5df2\u5220\u9664", QToastMode.Info);
                            } else if (lVar != null) {
                                if (areEqual) {
                                    int i3 = j3;
                                    int i16 = i3 != 3 ? i3 != 4 ? 0 : 14 : 13;
                                    NBPJumpUtil.INSTANCE.jumpArticleFeedDetailPage(lVar, i16, new e());
                                    KLog kLog2 = KLog.INSTANCE;
                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleJumpFromFeedShare, jumpArticleFeedDetailPage: ");
                                    m3.append(lVar.f418092d);
                                    m3.append("\uff0c detailSource: ");
                                    m3.append(i16);
                                    kLog2.i("NBPJumpUtil", m3.toString());
                                } else {
                                    NBPJumpUtil.jumpSquareFeedList$default(null, lVar, null, "3", false, null, null, null, 240);
                                }
                            } else {
                                KLog.INSTANCE.e("NBPJumpUtil", "fetchFeedDetailInfo failed, code: " + intValue);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fetchFeedDetailInfo: ");
                sb5.append(p16);
                kLog.i("NearbyFeedRepo", sb5.toString());
                NBPArticleFeedDetailRequest nBPArticleFeedDetailRequest = new NBPArticleFeedDetailRequest(p16);
                NearbyFeedRepo$fetchFeedDetailInfo$1 nearbyFeedRepo$fetchFeedDetailInfo$1 = new NearbyFeedRepo$fetchFeedDetailInfo$1(function2);
                APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.feed_svr.StatusRead.SsoGetStatusDetail");
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.sendPbRequest$default(nBPArticleFeedDetailRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, nearbyFeedRepo$fetchFeedDetailInfo$1), 6);
            }
        }
        for (MatchResult matchResult : Regex.findAll$default(new Regex("(\\w+)=([^&]+)"), NBPMainKtxKt.getPageData().n().p("key_scheme"), 0, 2, null)) {
            NBPMainKtxKt.getPageData().n().v(matchResult.getGroupValues().get(1), matchResult.getGroupValues().get(2));
        }
        KLog kLog2 = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("nbp_forrwad: ");
        m3.append(NBPMainKtxKt.getPageData().n().j("nbp_forward"));
        m3.append(", poi_key: ");
        m3.append(NBPMainKtxKt.getPageData().n().p("poi_key"));
        kLog2.i("NBPMainMapViewModel", m3.toString());
        int j16 = NBPMainKtxKt.getPageData().n().j("nbp_forward");
        if (j16 == 1) {
            String p17 = NBPMainKtxKt.getPageData().n().p("nbp_forward_account_id");
            int j17 = NBPMainKtxKt.getPageData().n().j("nbp_forward_source");
            boolean areEqual2 = Intrinsics.areEqual(p17, String.valueOf(UserDataManager.INSTANCE.getUserSelfInfo().tid));
            HomepageSource[] values = HomepageSource.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                HomepageSource homepageSource2 = values[i3];
                if (homepageSource2.nbpValue == j17) {
                    homepageSource = homepageSource2;
                    break;
                }
                i3++;
            }
            NBPJumpUtil.jumpPersonaPage$default(2, p17, areEqual2, false, homepageSource == null ? HomepageSource.SHARE : homepageSource, null, 32);
            return;
        }
        if (j16 == 2) {
            NBPJumpUtil.jumpMoodGroupPage$default(4, Integer.parseInt(NBPMainKtxKt.getPageData().n().p("nbp_forward_mid")), NBPMainKtxKt.getPageData().n().k("auto_jump", 0), null, false, 24);
            return;
        }
        if (j16 == 3) {
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("targetVersion: 9.1.10, currentVersion: ");
            com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
            m16.append(cVar.g().getPageData().getAppVersion());
            kLog2.i("NBPMainMapViewModel", m16.toString());
            if (Companion.isVersionGreaterOrEqual("9.1.10", cVar.g().getPageData().getAppVersion())) {
                NBPJumpUtil.jumpPrayCalendarPage$default();
                return;
            } else {
                Utils.INSTANCE.currentBridgeModule().qToast("\u7248\u672c\u8f83\u4f4e\uff0c\u8bf7\u5347\u7ea7\u5230\u6700\u65b0\u7248\u672c\u4f53\u9a8c", QToastMode.Info);
                return;
            }
        }
        if (j16 != 4) {
            return;
        }
        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("targetVersion: 9.1.25, currentVersion: ");
        com.tencent.kuikly.core.manager.c cVar2 = com.tencent.kuikly.core.manager.c.f117352a;
        m17.append(cVar2.g().getPageData().getAppVersion());
        kLog2.i("NBPMainMapViewModel", m17.toString());
        if (Companion.isVersionGreaterOrEqual("9.1.25", cVar2.g().getPageData().getAppVersion())) {
            String m18 = QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_middle_page&poi_key=", NBPMainKtxKt.getPageData().n().p("poi_key"), "&local_bundle_name=nearbypro");
            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.openPage$default(m18, false, 6);
            return;
        }
        Utils.INSTANCE.currentBridgeModule().qToast("\u7248\u672c\u8f83\u4f4e\uff0c\u8bf7\u5347\u7ea7\u5230\u6700\u65b0\u7248\u672c\u4f53\u9a8c", QToastMode.Info);
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onLocationFinish(boolean z16, NBPSsoLocation nBPSsoLocation) {
        NBPMapView b16;
        KLog.INSTANCE.i("NBPMainMapViewModel", "map vm: onLocationFinish, " + z16 + ", lat: " + nBPSsoLocation.lat02 + ", lon: " + nBPSsoLocation.lon02);
        this.enterLocationState = z16 ? 1 : 2;
        if (z16) {
            Iterator it = NBPMainKtxKt.getVmStore().viewModels.values().iterator();
            while (it.hasNext()) {
                ((NBPMainBaseViewModel) it.next()).onEnterMap();
            }
            CameraUpdate createSelfPositionCamera$default = createSelfPositionCamera$default(this, 0.0f, 0L, 15);
            this.currentZoomLevel = createSelfPositionCamera$default.zoomLevel;
            NBPLatLng nBPLatLng = createSelfPositionCamera$default.target;
            this.currentTargetPosition = nBPLatLng == null ? new NBPLatLng(0.0d, 0.0d, 3, null) : nBPLatLng;
            if (nBPLatLng != null) {
                NBPViewModelStoreKt.getMarkersViewModel(NBPMainKtxKt.getVmStore()).fetchPositionMarkerIfNeed(nBPLatLng, false, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMainMapViewModel$onLocationFinish$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        final NBPMainMapViewModel nBPMainMapViewModel = NBPMainMapViewModel.this;
                        TimerKt.d(300, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMainMapViewModel$onLocationFinish$1$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                NBPMainMapViewModel nBPMainMapViewModel2 = NBPMainMapViewModel.this;
                                nBPMainMapViewModel2.didEnterMapFinishWithMarkers$delegate.setValue(nBPMainMapViewModel2, NBPMainMapViewModel.$$delegatedProperties[0], Boolean.TRUE);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                NBPMapMarker generateHostMapMarker = NBPMarkerFactory.INSTANCE.generateHostMapMarker(nBPLatLng);
                if (generateHostMapMarker != null) {
                    updateHostMarker(generateHostMapMarker);
                }
            }
            Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMainMapViewModel$onLocationFinish$2
                {
                    super(1);
                }

                /* JADX WARN: Type inference failed for: r2v4, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Boolean bool) {
                    bool.booleanValue();
                    NBPMainMapViewModel.this.firstPositionChangeFinish = true;
                    Iterator it5 = NBPMainKtxKt.getVmStore().viewModels.values().iterator();
                    while (it5.hasNext()) {
                        ((NBPMainBaseViewModel) it5.next()).onFirstPositionChangeFinish();
                    }
                    return Unit.INSTANCE;
                }
            };
            aa<NBPMapView> aaVar = this.mapViewRef;
            if (aaVar == null || (b16 = aaVar.b()) == null) {
                return;
            }
            b16.moveCamera(createSelfPositionCamera$default, function1);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onMapCameraChangedFinish(CameraPosition cameraPosition) {
        String str;
        if (this.firstPositionChangeFinish) {
            float f16 = cameraPosition.zoomLevel;
            float f17 = this.currentZoomLevel;
            if (!(f16 == f17)) {
                boolean z16 = f16 > f17;
                e eVar = new e();
                if (z16) {
                    str = "magnify";
                } else {
                    str = "reduce";
                }
                eVar.v("nearby_map_act", str);
                eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_map_act", eVar);
            } else if (!Intrinsics.areEqual(cameraPosition.target, this.currentTargetPosition)) {
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_map_act", AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("nearby_map_act", WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE, DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU"));
            }
            this.currentZoomLevel = cameraPosition.zoomLevel;
            this.currentTargetPosition = cameraPosition.target;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onMapThemeChanged(f fVar) {
        boolean updateCurrentTheme = NBPViewModelStoreKt.getMarkersViewModel(NBPMainKtxKt.getVmStore()).updateCurrentTheme(fVar);
        NBPMapMarker nBPMapMarker = this.selfHostPersonMarker;
        if (nBPMapMarker != null) {
            NBPViewModelStoreKt.getMarkersViewModel(NBPMainKtxKt.getVmStore()).addMarker(nBPMapMarker);
        }
        if (updateCurrentTheme) {
            NBPViewModelStoreKt.getMarkersViewModel(NBPMainKtxKt.getVmStore()).syncMarkerDisplayIfNeed();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerViewDidLoad() {
        NBPMapView b16;
        aa<NBPMapView> aaVar = this.mapViewRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        CameraUpdate createSelfPositionCamera$default = createSelfPositionCamera$default(this, 13.0f, 0L, 8);
        int i3 = NBPMapView.$r8$clinit;
        b16.moveCamera(createSelfPositionCamera$default, null);
    }

    public final void updateHostMarker(NBPMapMarker nBPMapMarker) {
        NBPViewModelStoreKt.getMarkersViewModel(NBPMainKtxKt.getVmStore()).removeMarker(nBPMapMarker.key);
        NBPViewModelStoreKt.getMarkersViewModel(NBPMainKtxKt.getVmStore()).syncMarkerDisplayIfNeed();
        this.selfHostPersonMarker = nBPMapMarker;
        NBPViewModelStoreKt.getMarkersViewModel(NBPMainKtxKt.getVmStore()).getClass();
        NBPViewModelStoreKt.getMarkersViewModel(NBPMainKtxKt.getVmStore()).addMarker(nBPMapMarker);
        NBPViewModelStoreKt.getMarkersViewModel(NBPMainKtxKt.getVmStore()).syncMarkerDisplayIfNeed();
    }

    public final void moveCameraToTarget(NBPLatLng nBPLatLng) {
        NBPMapView b16;
        CameraUpdate cameraUpdate = new CameraUpdate();
        cameraUpdate.target = new NBPLatLng(nBPLatLng.latitude, nBPLatLng.longitude);
        cameraUpdate.zoomLevel = 13.6f;
        cameraUpdate.animate = true;
        cameraUpdate.animateDuration = 300.0f;
        aa<NBPMapView> aaVar = this.mapViewRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        b16.moveCamera(cameraUpdate, null);
    }

    public static CameraUpdate createSelfPositionCamera$default(NBPMainMapViewModel nBPMainMapViewModel, float f16, long j3, int i3) {
        if ((i3 & 2) != 0) {
            if (!PageDataExtKt.isPublic(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData())) {
                String item = Utils.INSTANCE.cacheModule("").getItem("KEY_NBP_INIT_ZOOM_LEVEL");
                Float valueOf = item.length() > 0 ? Float.valueOf(Float.parseFloat(item)) : null;
                if (valueOf != null) {
                    f16 = valueOf.floatValue();
                }
            }
            f16 = 13.65f;
        }
        boolean z16 = (i3 & 4) != 0;
        if ((i3 & 8) != 0) {
            j3 = AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(com.tencent.kuikly.core.manager.c.f117352a) ? 500L : 250L;
        }
        nBPMainMapViewModel.getClass();
        NBPLatLng nBPLatLng = UserDataManager.INSTANCE.getUserSelfInfo().latLng;
        CameraUpdate cameraUpdate = new CameraUpdate();
        cameraUpdate.target = new NBPLatLng(nBPLatLng.latitude, nBPLatLng.longitude);
        cameraUpdate.zoomLevel = f16;
        cameraUpdate.animate = z16;
        cameraUpdate.animateDuration = j3;
        return cameraUpdate;
    }
}
