package com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.HeatMapRenderReason;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainMode;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMapUtil;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPSubMode;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap.NBPHeatMapConfig;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap.NBPMainHeatMapViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import f35.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import o25.f;
import org.apache.httpcore.message.TokenParser;
import t25.a;
import t25.b;
import t25.d;
import t25.e;

/* loaded from: classes31.dex */
public final class NBPMainHeatMapViewModel extends NBPMainBaseViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainHeatMapViewModel.class, "heatMapData", "getHeatMapData()Lkuikly/com/tencent/trpcprotocol/lplan/heatmap/HeatMapData;", 0)};
    public CameraPosition currentCameraPosition;
    public boolean didLoginSuccess;
    public boolean durationAutoZoomIn;
    public NBPLatLng lastDoRenderPos;
    public String lastRenderThemeID;
    public boolean moving;
    public IHeatMapRender render;
    public long renderIndex;
    public List<e> rspData;
    public boolean showHeatMap;
    public final CameraSpeedTracker speedTracker;
    public final CameraZoomLevelTracker zoomLevelTracker;
    public final ReadWriteProperty heatMapData$delegate = c.a(new a(null, null, null, 0.0f, 0, 0, 0, false, 0.0f, null, 1023, null));
    public NBPHeatMapRepo repo = new NBPHeatMapRepo();
    public final NBPHeatMapConfig.NearbyProHeatMapConfig heatMapConfig = NBPHeatMapConfig.INSTANCE.getNearbyProHeatMapConfig();
    public HeatMapPos lastRspFetchPos = new HeatMapPos(0 == true ? 1 : 0, 0, 3, 0 == true ? 1 : 0);

    /* loaded from: classes31.dex */
    public static final class HeatMapPos {
        public int dis;
        public NBPLatLng latLng;

        public HeatMapPos() {
            this(null, 0, 3, 0 == true ? 1 : 0);
        }

        public final int hashCode() {
            return this.dis + (this.latLng.hashCode() * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("{latitude:");
            m3.append(this.latLng.latitude);
            m3.append(" longitude:");
            m3.append(this.latLng.longitude);
            m3.append(" dis:");
            return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.dis, '}');
        }

        public HeatMapPos(NBPLatLng nBPLatLng, int i3) {
            this.latLng = nBPLatLng;
            this.dis = i3;
        }

        public /* synthetic */ HeatMapPos(NBPLatLng nBPLatLng, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(new NBPLatLng(0.0d, 0.0d, 3, null), 0);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HeatMapPos)) {
                return false;
            }
            HeatMapPos heatMapPos = (HeatMapPos) obj;
            return Intrinsics.areEqual(this.latLng, heatMapPos.latLng) && this.dis == heatMapPos.dis;
        }
    }

    public NBPMainHeatMapViewModel() {
        List<e> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.rspData = emptyList;
        this.speedTracker = new CameraSpeedTracker(NBPMainKtxKt.getPageData().c(), NBPMainKtxKt.getPageData().b(), new NBPMainHeatMapViewModel$speedTracker$1(this));
        this.zoomLevelTracker = new CameraZoomLevelTracker(new NBPMainHeatMapViewModel$zoomLevelTracker$1(this));
        this.lastRenderThemeID = "";
    }

    public final void doRenderHeatMap(HeatMapRenderReason heatMapRenderReason, boolean z16) {
        NBPLatLng nBPLatLng;
        NBPLatLng nBPLatLng2 = this.lastDoRenderPos;
        CameraPosition cameraPosition = this.currentCameraPosition;
        String str = NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getVmStore()).currentThemeId;
        if (nBPLatLng2 == null || cameraPosition == null || !Intrinsics.areEqual(str, this.lastRenderThemeID) || CameraSpeedTrackerKt.getDistanceToLeftTop(NBPMainKtxKt.getPageData().m(), NBPMainKtxKt.getPageData().l(), nBPLatLng2.latitude, nBPLatLng2.longitude, cameraPosition) >= this.heatMapConfig.radius) {
            boolean z17 = this.showHeatMap && !this.durationAutoZoomIn;
            IHeatMapRender iHeatMapRender = this.render;
            if (iHeatMapRender != null) {
                iHeatMapRender.renderHeatMap(z17, heatMapRenderReason, z16);
            }
            CameraPosition cameraPosition2 = this.currentCameraPosition;
            this.lastDoRenderPos = (cameraPosition2 == null || (nBPLatLng = cameraPosition2.topLeftPosition) == null) ? null : new NBPLatLng(nBPLatLng.latitude, nBPLatLng.longitude);
            this.lastRenderThemeID = str;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onLocationFinish(boolean z16, NBPSsoLocation nBPSsoLocation) {
        if (this.didLoginSuccess && z16) {
            NBPLatLng nBPLatLng = new NBPLatLng(nBPSsoLocation.lat02, nBPSsoLocation.lon02);
            int i3 = this.heatMapConfig.optimizePreloadDis;
            KLog.INSTANCE.e("NBPMainHeatMapViewModel", "preloadNearbyHeatMapData, centerLatLng:" + nBPLatLng + " preloadDis:" + i3);
            fetchNearbyHeatMapDataIfNeeded(nBPLatLng, i3, true);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onMapCameraChanged(CameraPosition cameraPosition) {
        if (this.showHeatMap) {
            if (!this.moving) {
                this.moving = true;
                CameraSpeedTracker cameraSpeedTracker = this.speedTracker;
                cameraSpeedTracker.running = true;
                cameraSpeedTracker.runLoop();
            }
            this.currentCameraPosition = cameraPosition;
            CameraSpeedTracker cameraSpeedTracker2 = this.speedTracker;
            cameraSpeedTracker2.curCamera = cameraPosition;
            if (cameraSpeedTracker2.lastTime == 0) {
                cameraSpeedTracker2.lastTime = APICallTechReporterKt.NBPCurrentTime();
                cameraSpeedTracker2.lastPos = cameraPosition.topLeftPosition;
            }
            CameraZoomLevelTracker cameraZoomLevelTracker = this.zoomLevelTracker;
            float f16 = cameraPosition.zoomLevel;
            Float f17 = cameraZoomLevelTracker.curZoom;
            cameraZoomLevelTracker.curZoom = Float.valueOf(f16);
            if (f17 != null) {
                f17.floatValue();
                if (Intrinsics.areEqual(f17, f16) || ((int) f17.floatValue()) == ((int) f16)) {
                    return;
                }
                cameraZoomLevelTracker.onZoomLevelIntChange.invoke();
            }
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onMapCameraChangedFinish(CameraPosition cameraPosition) {
        this.speedTracker.reset();
        this.moving = false;
        this.renderIndex++;
        this.currentCameraPosition = cameraPosition;
        tryUpdateHeatMap(cameraPosition, false);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onMapThemeChanged(f fVar) {
        List<e> emptyList;
        if (!this.showHeatMap) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.rspData = emptyList;
            updateHeatMapData();
            return;
        }
        tryUpdateHeatMap(this.currentCameraPosition, true);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onModeChanged(NBPMainMode nBPMainMode, NBPSubMode nBPSubMode) {
        this.mainMode = nBPMainMode;
        this.subMode = nBPSubMode;
        boolean z16 = nBPMainMode == NBPMainMode.Normal && nBPSubMode == NBPSubMode.HeatMap;
        if (z16 != this.showHeatMap) {
            KLog.INSTANCE.e("NBPMainHeatMapViewModel", "onHeatModeChanged, newState:" + z16);
            this.showHeatMap = z16;
            this.lastDoRenderPos = null;
            updateHeatMapData();
        }
        if (z16) {
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_enter_hot_map", AdelieCategoryHomePage$$ExternalSyntheticOutline0.m(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU"));
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onNBPLogin(boolean z16, g gVar) {
        this.didLoginSuccess = z16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerWillDestroy() {
        this.speedTracker.reset();
    }

    public final void updateHeatMapData() {
        List<e> emptyList;
        float f16;
        List mutableList;
        List mutableList2;
        int collectionSizeOrDefault;
        List mutableList3;
        List mutableList4;
        int collectionSizeOrDefault2;
        List mutableList5;
        if (!this.showHeatMap) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = this.rspData;
        }
        NBPHeatMapConfig.NearbyProHeatMapConfig nearbyProHeatMapConfig = this.heatMapConfig;
        if (nearbyProHeatMapConfig.dynamicIntensityRangeMax) {
            Iterator<T> it = emptyList.iterator();
            float f17 = 0.0f;
            while (it.hasNext()) {
                f17 = Math.max(f17, (float) ((e) it.next()).f435343e);
            }
            f16 = Math.max(f17, 1.0f);
        } else {
            f16 = nearbyProHeatMapConfig.intensityRangeMax;
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) emptyList);
        int[] iArr = nearbyProHeatMapConfig.gradientColors;
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i3 : iArr) {
            arrayList.add(String.valueOf(i3));
        }
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        List<Float> list = nearbyProHeatMapConfig.gradientStartPoints;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList2.add(String.valueOf(((Number) it5.next()).floatValue()));
        }
        mutableList3 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        b bVar = new b(mutableList2, mutableList3);
        int[] iArr2 = nearbyProHeatMapConfig.customGradientColors;
        ArrayList arrayList3 = new ArrayList(iArr2.length);
        for (int i16 : iArr2) {
            arrayList3.add(String.valueOf(i16));
        }
        mutableList4 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        List<Float> list2 = nearbyProHeatMapConfig.customGradientStartPoints;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it6 = list2.iterator();
        while (it6.hasNext()) {
            arrayList4.add(String.valueOf(((Number) it6.next()).floatValue()));
        }
        mutableList5 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList4);
        a aVar = new a(mutableList, bVar, new t25.c(nearbyProHeatMapConfig.intensityRangeMin, f16), nearbyProHeatMapConfig.opacity, nearbyProHeatMapConfig.radius, 2, 3000, false, 60.0f, new b(mutableList4, mutableList5));
        ReadWriteProperty readWriteProperty = this.heatMapData$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[0], aVar);
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("new heatmap data size=");
        m3.append(((a) this.heatMapData$delegate.getValue(this, kPropertyArr[0])).f435330d.size());
        kLog.i("NBPMainHeatMapViewModel", m3.toString());
        doRenderHeatMap(HeatMapRenderReason.DataChanged, true);
    }

    public final void tryUpdateHeatMap(CameraPosition cameraPosition, boolean z16) {
        if (cameraPosition != null && this.showHeatMap) {
            NBPLatLng nBPLatLng = cameraPosition.target;
            if (fetchNearbyHeatMapDataIfNeeded(nBPLatLng, (int) (NBPMapUtil.INSTANCE.distanceBetween(nBPLatLng, cameraPosition.topRightPosition) * this.heatMapConfig.optimizeEnlargeRatio), z16)) {
                return;
            }
            doRenderHeatMap(HeatMapRenderReason.MoveFinished, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x017b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean fetchNearbyHeatMapDataIfNeeded(NBPLatLng nBPLatLng, int i3, boolean z16) {
        KLog kLog;
        int roundToInt;
        boolean z17;
        String str = "NBPMainHeatMapViewModel";
        if (!this.didLoginSuccess) {
            KLog.INSTANCE.e("NBPMainHeatMapViewModel", "fetchNearbyHeatMapDataIfNeeded, return because not login");
            return false;
        }
        final HeatMapPos heatMapPos = new HeatMapPos(nBPLatLng, i3);
        NBPMapUtil nBPMapUtil = NBPMapUtil.INSTANCE;
        double distanceBetween = nBPMapUtil.distanceBetween(this.lastRspFetchPos.latLng, nBPLatLng);
        KLog kLog2 = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchNearbyHeatMapDataIfNeeded, mapThemeId:");
        m3.append(NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getVmStore()).currentThemeId);
        m3.append(" reqNearbyPos:");
        m3.append(heatMapPos);
        m3.append(" lastRspFetchPos:");
        m3.append(this.lastRspFetchPos);
        m3.append(" force:");
        m3.append(z16);
        m3.append(" distanceBetween:");
        m3.append(distanceBetween);
        kLog2.e("NBPMainHeatMapViewModel", m3.toString());
        if (z16) {
            kLog = kLog2;
        } else {
            NBPHeatMapConfig.NearbyProHeatMapConfig nearbyProHeatMapConfig = this.heatMapConfig;
            HeatMapPos heatMapPos2 = this.lastRspFetchPos;
            double d16 = nearbyProHeatMapConfig.optimizeTransitionRatio;
            NBPLatLng nBPLatLng2 = heatMapPos2.latLng;
            double d17 = nBPLatLng2.latitude;
            double d18 = nBPLatLng2.longitude;
            NBPLatLng nBPLatLng3 = heatMapPos.latLng;
            double d19 = (d17 * 3.141592653589793d) / 180.0d;
            double d26 = (nBPLatLng3.latitude * 3.141592653589793d) / 180.0d;
            roundToInt = MathKt__MathJVMKt.roundToInt(Math.asin(Math.sqrt((Math.pow(Math.sin((((d18 * 3.141592653589793d) / 180.0d) - ((nBPLatLng3.longitude * 3.141592653589793d) / 180.0d)) / 2.0d), 2.0d) * Math.cos(d26) * Math.cos(d19)) + Math.pow(Math.sin((d19 - d26) / 2.0d), 2.0d))) * 2.0d * 6378.137d * 10000.0d);
            double d27 = (roundToInt / 10000.0d) * 1000.0d;
            int i16 = heatMapPos2.dis;
            if (d27 <= ((double) i16) * d16) {
                str = "NBPMainHeatMapViewModel";
                kLog = kLog2;
                float f16 = heatMapPos.dis;
                float f17 = i16;
                if (f16 >= nearbyProHeatMapConfig.optimizeZoomInRatio * f17 || f16 <= f17 * nearbyProHeatMapConfig.optimizeZoomOutRatio) {
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("shouldRequestNearByHeatMap, match zoom strategy, reqNearbyPos.dis:");
                    m16.append(heatMapPos.dis);
                    m16.append(" lastRspFetchPos.dis:");
                    m16.append(heatMapPos2.dis);
                    m16.append(" zoomInRatio:");
                    m16.append(nearbyProHeatMapConfig.optimizeZoomInRatio);
                    m16.append(" zoomOutRatio:");
                    m16.append(nearbyProHeatMapConfig.optimizeZoomOutRatio);
                    m16.append(TokenParser.SP);
                    kLog.e(str, m16.toString());
                } else {
                    z17 = false;
                    if (!z17) {
                        return false;
                    }
                }
            } else {
                double distanceBetween2 = nBPMapUtil.distanceBetween(heatMapPos2.latLng, heatMapPos.latLng);
                StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("shouldRequestNearByHeatMap, match transition strategy, lastDis:");
                m17.append(heatMapPos2.dis);
                m17.append(" ratio:");
                m17.append(nearbyProHeatMapConfig.optimizeTransitionRatio);
                m17.append(" distanceBetween:");
                m17.append(distanceBetween2);
                str = "NBPMainHeatMapViewModel";
                kLog = kLog2;
                kLog.e(str, m17.toString());
            }
            z17 = true;
            if (!z17) {
            }
        }
        StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchNearbyHeatMapData, start request, dis=");
        m18.append(heatMapPos.dis);
        m18.append(" zoom=");
        CameraPosition cameraPosition = this.currentCameraPosition;
        m18.append(cameraPosition != null ? Float.valueOf(cameraPosition.zoomLevel) : null);
        m18.append(" reqNearbyPos=");
        m18.append(heatMapPos);
        kLog.e(str, m18.toString());
        final NBPHeatMapRepo nBPHeatMapRepo = this.repo;
        String str2 = NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getVmStore()).currentThemeId;
        NBPLatLng nBPLatLng4 = heatMapPos.latLng;
        int i17 = heatMapPos.dis;
        final Function1<List<? extends e>, Unit> function1 = new Function1<List<? extends e>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap.NBPMainHeatMapViewModel$fetchNearbyHeatMapDataIfNeeded$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(List<? extends e> list) {
                int roundToInt2;
                List<? extends e> list2 = list;
                NBPMainHeatMapViewModel.HeatMapPos heatMapPos3 = heatMapPos;
                Iterator it = list2.iterator();
                double d28 = 0.0d;
                double d29 = 0.0d;
                while (it.hasNext()) {
                    e eVar = (e) it.next();
                    d dVar = eVar.f435342d;
                    if (dVar != null) {
                        NBPLatLng nBPLatLng5 = heatMapPos3.latLng;
                        double d36 = dVar.f435340d;
                        double d37 = dVar.f435341e;
                        NBPMainHeatMapViewModel.HeatMapPos heatMapPos4 = heatMapPos3;
                        double d38 = (nBPLatLng5.latitude * 3.141592653589793d) / 180.0d;
                        double d39 = (d36 * 3.141592653589793d) / 180.0d;
                        roundToInt2 = MathKt__MathJVMKt.roundToInt(Math.asin(Math.sqrt((Math.pow(Math.sin((((nBPLatLng5.longitude * 3.141592653589793d) / 180.0d) - ((d37 * 3.141592653589793d) / 180.0d)) / 2.0d), 2.0d) * Math.cos(d39) * Math.cos(d38)) + Math.pow(Math.sin((d38 - d39) / 2.0d), 2.0d))) * 2.0d * 6378.137d * 10000.0d);
                        d28 = Math.max(d28, (roundToInt2 / 10000.0d) * 1000.0d);
                        d29 = Math.max(d29, eVar.f435343e);
                        it = it;
                        heatMapPos3 = heatMapPos4;
                        list2 = list2;
                    }
                }
                List list3 = list2;
                KLog kLog3 = KLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fetchNearbyHeatMapData success, dis=");
                sb5.append(d28);
                sb5.append(" zoom=");
                CameraPosition cameraPosition2 = NBPMainHeatMapViewModel.this.currentCameraPosition;
                sb5.append(cameraPosition2 != null ? Float.valueOf(cameraPosition2.zoomLevel) : null);
                sb5.append(" maxIntensity=");
                sb5.append(d29);
                sb5.append(" count:");
                sb5.append(list3.size());
                kLog3.i("NBPMainHeatMapViewModel", sb5.toString());
                NBPMainHeatMapViewModel nBPMainHeatMapViewModel = NBPMainHeatMapViewModel.this;
                nBPMainHeatMapViewModel.lastRspFetchPos = new NBPMainHeatMapViewModel.HeatMapPos(heatMapPos.latLng, (int) d28);
                nBPMainHeatMapViewModel.rspData = list3;
                nBPMainHeatMapViewModel.updateHeatMapData();
                return Unit.INSTANCE;
            }
        };
        nBPHeatMapRepo.getClass();
        GetHotMapRequest getHotMapRequest = new GetHotMapRequest(str2, nBPLatLng4, i17);
        Function1<PbResponse<v25.g>, Unit> function12 = new Function1<PbResponse<v25.g>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap.NBPHeatMapRepo$requestHeatMapData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<v25.g> pbResponse) {
                List<o25.e> list;
                int collectionSizeOrDefault;
                List<e> list2;
                PbResponse<v25.g> pbResponse2 = pbResponse;
                KLog kLog3 = KLog.INSTANCE;
                StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestHeatMapData, code: ");
                m19.append(pbResponse2.code);
                m19.append(", msg: ");
                m19.append(pbResponse2.f114187msg);
                kLog3.e("NBPMainHeatMapViewModel", m19.toString());
                v25.g gVar = pbResponse2.rsp;
                if (gVar != null) {
                    list = CollectionsKt___CollectionsKt.toList(gVar.f440853e);
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (o25.e eVar : list) {
                        arrayList.add(new e(new d(eVar.f421846d, eVar.f421847e), eVar.f421848f));
                    }
                    list2 = CollectionsKt___CollectionsKt.toList(arrayList);
                    NBPHeatMapRepo.this.getClass();
                    if (list2.isEmpty()) {
                        KLog.INSTANCE.e("NBPMainHeatMapViewModel", "requestHeatMapData, empty data");
                    } else {
                        KLog.INSTANCE.d("NBPMainHeatMapViewModel", "requestHeatMapData begin >>>>>>>>>>>>>>>>>>>>>");
                        double d28 = 0.0d;
                        int i18 = 0;
                        for (Object obj : list2) {
                            int i19 = i18 + 1;
                            if (i18 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            e eVar2 = (e) obj;
                            if (i18 <= 3) {
                                KLog kLog4 = KLog.INSTANCE;
                                StringBuilder m26 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("requestHeatMapData data[", i18, "]->:{latitude: ");
                                d dVar = eVar2.f435342d;
                                m26.append(dVar != null ? Double.valueOf(dVar.f435340d) : null);
                                m26.append(", longitude: ");
                                d dVar2 = eVar2.f435342d;
                                m26.append(dVar2 != null ? Double.valueOf(dVar2.f435341e) : null);
                                m26.append(", intensity: ");
                                m26.append(eVar2.f435343e);
                                m26.append('}');
                                kLog4.d("NBPMainHeatMapViewModel", m26.toString());
                            }
                            d28 = Math.max(d28, eVar2.f435343e);
                            i18 = i19;
                        }
                        KLog kLog5 = KLog.INSTANCE;
                        StringBuilder m27 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestHeatMapData, data.count:");
                        m27.append(list2.size());
                        m27.append(" maxIntensity:");
                        m27.append(d28);
                        kLog5.e("NBPMainHeatMapViewModel", m27.toString());
                        kLog5.d("NBPMainHeatMapViewModel", "requestHeatMapData end <<<<<<<<<<<<<<<<<<<<<");
                    }
                    function1.invoke(list2);
                }
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.map_svr.Map.SsoGetHotMap");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(getHotMapRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function12), 6);
        return true;
    }
}
