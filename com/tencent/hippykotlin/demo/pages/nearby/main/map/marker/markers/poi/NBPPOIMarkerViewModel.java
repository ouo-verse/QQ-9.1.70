package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStore;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.FocusableMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerRect;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerTransform;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerUIScheduler;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerUIConfig;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import n25.i;
import n25.k;
import v25.t;

/* loaded from: classes31.dex */
public final class NBPPOIMarkerViewModel extends FocusableMarker implements IMarkerCollection, INBPMapMarkerUpdate {
    public static final Companion Companion = new Companion();
    public static final long MAX_INTERNAL_ORDER = 11360448000L / 100;
    public final Lazy key$delegate;
    public final t poi;
    public final String poiTitle;
    public final NBPPOIMarkerUIConfig uiCfg;
    public final Lazy viewBuilder$delegate;

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    public NBPPOIMarkerViewModel(t tVar, String str, NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig) {
        super(nBPPOIMarkerUIConfig.getFocusedScale(), nBPPOIMarkerUIConfig.getTargetXPercent(), nBPPOIMarkerUIConfig.getTargetYPercent());
        Lazy lazy;
        Lazy lazy2;
        NBPViewModelStore nbpVMStore;
        this.poi = tVar;
        this.poiTitle = str;
        this.uiCfg = nBPPOIMarkerUIConfig;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerViewModel$key$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                i iVar;
                i iVar2;
                k kVar = NBPPOIMarkerViewModel.this.poi.f440896d;
                Long l3 = null;
                String str2 = kVar != null ? kVar.R : null;
                if (str2 == null || str2.length() == 0) {
                    k kVar2 = NBPPOIMarkerViewModel.this.poi.f440896d;
                    str2 = kVar2 != null ? kVar2.f418086d : null;
                }
                if (str2 == null || str2.length() == 0) {
                    k kVar3 = NBPPOIMarkerViewModel.this.poi.f440896d;
                    str2 = kVar3 != null ? kVar3.Q : null;
                }
                if (str2 == null || str2.length() == 0) {
                    StringBuilder sb5 = new StringBuilder();
                    k kVar4 = NBPPOIMarkerViewModel.this.poi.f440896d;
                    sb5.append((kVar4 == null || (iVar2 = kVar4.C) == null) ? null : Long.valueOf(iVar2.f418079d));
                    sb5.append('-');
                    k kVar5 = NBPPOIMarkerViewModel.this.poi.f440896d;
                    if (kVar5 != null && (iVar = kVar5.C) != null) {
                        l3 = Long.valueOf(iVar.f418080e);
                    }
                    sb5.append(l3);
                    str2 = sb5.toString();
                }
                return AgreementConsentViewKt$$ExternalSyntheticOutline0.m("poi_", str2);
            }
        });
        this.key$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Function1<? super ViewContainer<?, ?>, ? extends Unit>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerViewModel$viewBuilder$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Function1<? super ViewContainer<?, ?>, ? extends Unit> invoke() {
                final NBPPOIMarkerViewModel nBPPOIMarkerViewModel = NBPPOIMarkerViewModel.this;
                return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerViewModel$viewBuilder$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                        final NBPPOIMarkerViewModel nBPPOIMarkerViewModel2 = NBPPOIMarkerViewModel.this;
                        viewContainer.addChild(new NBPPOIMarkerView(), new Function1<NBPPOIMarkerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerViewModel.viewBuilder.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPPOIMarkerView nBPPOIMarkerView) {
                                final NBPPOIMarkerViewModel nBPPOIMarkerViewModel3 = NBPPOIMarkerViewModel.this;
                                nBPPOIMarkerView.attr(new Function1<NBPPOIMarkerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerViewModel.viewBuilder.2.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPPOIMarkerAttr nBPPOIMarkerAttr) {
                                        nBPPOIMarkerAttr.viewModel = NBPPOIMarkerViewModel.this;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                };
            }
        });
        this.viewBuilder$delegate = lazy2;
        k kVar = tVar.f440896d;
        if (kVar != null) {
            String poiDetailName = NearbyProUtilsKt.getPoiDetailName(kVar);
            nbpVMStore = NBPMainKtxKt.getNbpVMStore(c.f117352a.g());
            NBPViewModelStoreKt.getMarkersViewModel(nbpVMStore).addOfficialPOI(poiDetailName);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection
    public final boolean addCollectionMarker(NBPMapMarker nBPMapMarker, float f16) {
        return f16 >= NBPFeedMarkerUIConfig.Companion.getInstance().collectionAreaPercent;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final boolean canShowOnSubMode() {
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final Boolean clickInSide(float f16, float f17, MarkerRect markerRect) {
        if (isFocused()) {
            NBPPOIMarkerUIConfig nBPPOIMarkerUIConfig = this.uiCfg;
            float f18 = nBPPOIMarkerUIConfig.focusedScale;
            markerRect = markerRect.scale(f18, f18, nBPPOIMarkerUIConfig.targetXPercent, nBPPOIMarkerUIConfig.targetYPercent);
        }
        if (markerRect.contains(f16, f17)) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onClickMarker poi=");
            m3.append(this.poi.f440898f);
            kLog.i("NBPPOIMarkerViewModel", m3.toString());
            e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
            jsonWithMainPgParams.v("dt_eid", "em_nearby_middle_page_icon");
            jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
            k kVar = this.poi.f440896d;
            if (kVar != null) {
                QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[][]{c45.i.d(kVar)});
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_middle_page&nbp_source=1&local_bundle_name=nearbypro", false, 6);
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final MarkerRect getMarkerRectOnScreen(NBPMapMarker nBPMapMarker) {
        return null;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final NBPMarkerTransform getMarkerViewTransformWhenMapChangedOnVisible(float f16, float f17, float f18, NBPMarkerUIScheduler nBPMarkerUIScheduler) {
        w wVar = this.uiCfg.size;
        return new NBPMarkerTransform(new y((f17 / wVar.getWidth()) - 0.5f, (f18 / wVar.getHeight()) - 0.5f, 0.0f, 0.0f, 12, null), new u(1.0f, 1.0f));
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection
    public final void resetCollection() {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final void themeConfigDidLoad() {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final void onClickMarkerFromMap(float f16, float f17) {
    }
}
