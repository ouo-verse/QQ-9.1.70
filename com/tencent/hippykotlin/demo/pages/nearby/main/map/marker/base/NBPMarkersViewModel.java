package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.GeoNearRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraUpdate;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.HeatMapRenderReason;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainMode;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPSubMode;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStore;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMainMapViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.NBPMapView;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap.NBPMainHeatMapViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.NBPMarkerFactory;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation.NBPOperationMarkerViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerUIConfig;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerUIConfig;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi.NBPPOIMarkerViewModelKt;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.pager.h;
import com.tencent.kuikly.core.timer.TimerKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n25.i;
import n25.k;
import o25.d;
import o25.f;
import o25.g;
import v25.p;
import v25.t;
import zz0.a;

/* loaded from: classes31.dex */
public final class NBPMarkersViewModel extends NBPMainBaseViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {IPagerIdKtxKt$$ExternalSyntheticOutline0.m(NBPMarkersViewModel.class, "visibleMarkers", "getVisibleMarkers()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMarkersViewModel.class, "showMarkersLayer", "getShowMarkersLayer()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMarkersViewModel.class, "currentFocusedKey", "getCurrentFocusedKey()Ljava/lang/String;", 0)};
    public CameraPosition currentCameraPosition;
    public List<NBPMapMarker> currentFocusShadowMarkers;
    public final ReadWriteProperty currentFocusedKey$delegate;
    public NBPMapMarker currentFocusedMarker;
    public FocusableMarker currentFocusedMarkerVm;
    public String currentMapThemeId;
    public boolean didEnterMap;
    public boolean didEnterMapCameraFinish;
    public boolean isPageVisible;
    public boolean setNeedSyncDisplayMarker;
    public boolean themeConfigDidLoad;
    public final ReadWriteProperty visibleMarkers$delegate = c.b();
    public final HashMap<String, NBPMapMarker> visibleMarkersMap = new HashMap<>();
    public HashMap<String, Boolean> markersSourceFlag = new HashMap<>();
    public ArrayList<NBPMapMarker> markersSource = new ArrayList<>();
    public final NBPMarkerUIScheduler uiScheduler = new NBPMarkerUIScheduler();
    public final NBPMarkerFetcher markersFetcher = new NBPMarkerFetcher();
    public NBPMarkerCollection markerCollection = new NBPMarkerCollection();
    public NBPMainMode markerMainMode = NBPMainMode.Normal;
    public NBPSubMode markerSubMode = NBPSubMode.Normal;
    public final ReadWriteProperty showMarkersLayer$delegate = c.a(Boolean.TRUE);
    public Set<String> officialPOIs = new LinkedHashSet();

    public NBPMarkersViewModel() {
        this.currentMapThemeId = "";
        String q16 = com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().n().q("theme_id", "");
        this.currentMapThemeId = q16;
        if (q16.length() > 0) {
            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("init currentMapThemeId:"), this.currentMapThemeId, KLog.INSTANCE, "NBPMarkersViewModel");
        }
        this.currentFocusShadowMarkers = new ArrayList();
        this.currentFocusedKey$delegate = c.a("");
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker>, java.util.ArrayList] */
    public static final void access$updateFocusedMarkers(NBPMarkersViewModel nBPMarkersViewModel) {
        String str;
        Pair pair;
        if (nBPMarkersViewModel.markerMainMode != NBPMainMode.Concise && nBPMarkersViewModel.isPageVisible) {
            Iterator<Map.Entry<String, NBPMapMarker>> it = nBPMarkersViewModel.visibleMarkersMap.entrySet().iterator();
            float f16 = Float.MAX_VALUE;
            NBPMapMarker nBPMapMarker = null;
            FocusableMarker focusableMarker = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                NBPMapMarker value = it.next().getValue();
                Object obj = value.data;
                FocusableMarker focusableMarker2 = obj instanceof FocusableMarker ? (FocusableMarker) obj : null;
                if (focusableMarker2 != null) {
                    float f17 = value.screenX;
                    float f18 = value.screenY;
                    if (!focusableMarker2.readyToFocus) {
                        pair = new Pair(Boolean.FALSE, Float.valueOf(0.0f));
                    } else {
                        float f19 = f17 - focusableMarker2.focusCenterX;
                        float f26 = f18 - focusableMarker2.focusCenterY;
                        float sqrt = (float) Math.sqrt((f26 * f26) + (f19 * f19));
                        pair = new Pair(Boolean.valueOf(sqrt < focusableMarker2.focusDistance), Float.valueOf(sqrt));
                    }
                    boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
                    float floatValue = ((Number) pair.component2()).floatValue();
                    if (booleanValue && floatValue < f16) {
                        nBPMapMarker = value;
                        f16 = floatValue;
                        focusableMarker = focusableMarker2;
                    }
                }
            }
            Pair pair2 = new Pair(nBPMapMarker, focusableMarker);
            NBPMapMarker nBPMapMarker2 = (NBPMapMarker) pair2.component1();
            FocusableMarker focusableMarker3 = (FocusableMarker) pair2.component2();
            if (Intrinsics.areEqual(focusableMarker3, nBPMarkersViewModel.currentFocusedMarkerVm)) {
                return;
            }
            if (nBPMapMarker2 == null || (str = nBPMapMarker2.key) == null) {
                str = "";
            }
            nBPMarkersViewModel.currentFocusedKey$delegate.setValue(nBPMarkersViewModel, $$delegatedProperties[2], str);
            FocusableMarker focusableMarker4 = nBPMarkersViewModel.currentFocusedMarkerVm;
            if (focusableMarker4 != null) {
                focusableMarker4.updatedStatus(false);
            }
            nBPMarkersViewModel.currentFocusedMarkerVm = focusableMarker3;
            nBPMarkersViewModel.currentFocusedMarker = nBPMapMarker2;
            Iterator it5 = nBPMarkersViewModel.currentFocusShadowMarkers.iterator();
            while (it5.hasNext()) {
                final NBPMapMarker nBPMapMarker3 = (NBPMapMarker) it5.next();
                nBPMarkersViewModel.uiScheduler.addUITask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersViewModel$updateFocusedMarkers$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        NBPMapMarker.this.setCoveredByFocusMarker(false);
                        return Unit.INSTANCE;
                    }
                });
            }
            nBPMarkersViewModel.currentFocusShadowMarkers.clear();
            if (focusableMarker3 == null || nBPMapMarker2 == null || !focusableMarker3.updatedStatus(true)) {
                return;
            }
            MarkerRect focusedMarkerRect = focusableMarker3.getFocusedMarkerRect(nBPMapMarker2.getMarkerRectOnScreen());
            Iterator<NBPMapMarker> it6 = nBPMarkersViewModel.getVisibleMarkers().iterator();
            while (it6.hasNext()) {
                final NBPMapMarker next = it6.next();
                if (!Intrinsics.areEqual(next, nBPMapMarker2)) {
                    MarkerRect markerRectOnScreen = next.getMarkerRectOnScreen();
                    float max = Math.max(markerRectOnScreen.left, focusedMarkerRect.left);
                    float max2 = Math.max(markerRectOnScreen.top, focusedMarkerRect.top);
                    float min = Math.min(markerRectOnScreen.right, focusedMarkerRect.right);
                    float min2 = Math.min(markerRectOnScreen.bottom, focusedMarkerRect.bottom);
                    if ((((min <= max || min2 <= max2) ? null : new MarkerRect(max, max2, min, min2)) == null ? 0.0d : (r9.width * r9.height) / (focusedMarkerRect.width * focusedMarkerRect.height)) > 0.01d) {
                        nBPMarkersViewModel.uiScheduler.addUITask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersViewModel$updateFocusedMarkers$2$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                NBPMapMarker.this.setCoveredByFocusMarker(true);
                                return Unit.INSTANCE;
                            }
                        });
                        nBPMarkersViewModel.currentFocusShadowMarkers.add(next);
                    }
                }
            }
            nBPMarkersViewModel.syncMarkerDisplayIfNeed();
        }
    }

    public static void setNeedSyncMarkerDisplayOnMap$default(final NBPMarkersViewModel nBPMarkersViewModel) {
        if (nBPMarkersViewModel.setNeedSyncDisplayMarker) {
            return;
        }
        nBPMarkersViewModel.setNeedSyncDisplayMarker = true;
        TimerKt.d(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersViewModel$setNeedSyncMarkerDisplayOnMap$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                NBPMarkersViewModel.this.syncMarkerDisplayIfNeed();
                return Unit.INSTANCE;
            }
        });
    }

    public final void addMarker(NBPMapMarker nBPMapMarker) {
        if (this.markersSourceFlag.containsKey(nBPMapMarker.key)) {
            return;
        }
        this.markersSourceFlag.put(nBPMapMarker.key, Boolean.TRUE);
        if (this.themeConfigDidLoad) {
            nBPMapMarker.markerUpdate.themeConfigDidLoad();
        }
        this.markersSource.add(nBPMapMarker);
        setNeedSyncMarkerDisplayOnMap$default(this);
    }

    public final void addOfficialPOI(String str) {
        this.officialPOIs.add(str);
    }

    public final boolean getShowMarkersLayer() {
        return ((Boolean) this.showMarkersLayer$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<NBPMapMarker> getVisibleMarkers() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.visibleMarkers$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onMapCameraChanged(CameraPosition cameraPosition) {
        this.currentCameraPosition = cameraPosition;
        syncMarkerDisplay();
        if (this.didEnterMapCameraFinish && this.didEnterMap) {
            this.uiScheduler.mapScrolling = true;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onMapCameraChangedFinish(CameraPosition cameraPosition) {
        List list;
        if (this.didEnterMap) {
            if (this.currentCameraPosition == null) {
                this.currentCameraPosition = cameraPosition;
            }
            if (!this.didEnterMapCameraFinish) {
                this.didEnterMapCameraFinish = true;
                KLog.INSTANCE.i("NBPMarkersViewModel", "didEnterMapCameraFinish");
                syncMarkerDisplay();
            }
            NBPLatLng nBPLatLng = cameraPosition.topLeftPosition;
            fetchPositionMarkerIfNeed$default(this, new NBPLatLng((nBPLatLng.latitude + cameraPosition.bottomLeftPosition.latitude) / 2.0d, (nBPLatLng.longitude + cameraPosition.topRightPosition.longitude) / 2.0d), 4);
            NBPMarkerUIScheduler nBPMarkerUIScheduler = this.uiScheduler;
            nBPMarkerUIScheduler.mapScrolling = false;
            if (!nBPMarkerUIScheduler.endScrollLazyTasks.isEmpty()) {
                list = CollectionsKt___CollectionsKt.toList(nBPMarkerUIScheduler.endScrollLazyTasks);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                nBPMarkerUIScheduler.endScrollLazyTasks = new ArrayList<>();
                com.tencent.kuikly.core.manager.c.f117352a.g().syncFlushUI();
            }
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onMapClick(ClickParams clickParams) {
        List list;
        List<NBPMapMarker> sortedWith;
        NBPMapView b16;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("x: ");
        m3.append(clickParams.getX());
        m3.append(", y : ");
        m3.append(clickParams.getY());
        m3.append(", zoom:");
        CameraPosition cameraPosition = this.currentCameraPosition;
        m3.append(cameraPosition != null ? cameraPosition.zoomLevel : 13.6f);
        kLog.i("MapClick", m3.toString());
        if ((this.currentCameraPosition != null ? r0.zoomLevel : 13.6f) + 0.05d < 13.0d) {
            NBPMainMapViewModel mapViewModel = NBPViewModelStoreKt.getMapViewModel(NBPMainKtxKt.getVmStore());
            double y16 = clickParams.getY();
            double x16 = clickParams.getX();
            CameraUpdate cameraUpdate = new CameraUpdate();
            cameraUpdate.target = new NBPLatLng(y16, x16);
            cameraUpdate.zoomLevel = 13.0f;
            cameraUpdate.animate = true;
            cameraUpdate.animateDuration = 500.0f;
            aa<NBPMapView> aaVar = mapViewModel.mapViewRef;
            if (aaVar != null && (b16 = aaVar.b()) != null) {
                b16.moveCamera(cameraUpdate, null);
            }
            final NBPMainHeatMapViewModel heatMapVM = NBPViewModelStoreKt.getHeatMapVM(NBPMainKtxKt.getVmStore());
            heatMapVM.lastDoRenderPos = null;
            heatMapVM.durationAutoZoomIn = true;
            heatMapVM.doRenderHeatMap(HeatMapRenderReason.AutoZoomInHide, true);
            TimerKt.d((int) 500.0f, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap.NBPMainHeatMapViewModel$onAutoZoomInStart$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NBPMainHeatMapViewModel.this.durationAutoZoomIn = false;
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (getShowMarkersLayer()) {
            clickParams.getX();
            CameraPosition cameraPosition2 = this.currentCameraPosition;
            if (cameraPosition2 != null) {
                com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                float m16 = GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(cVar);
                float l3 = cVar.g().getPageData().l();
                double d16 = cameraPosition2.topRightPosition.longitude;
                NBPLatLng nBPLatLng = cameraPosition2.topLeftPosition;
                double d17 = (m16 * 1.0d) / (d16 - nBPLatLng.longitude);
                double d18 = (l3 * 1.0d) / (cameraPosition2.bottomLeftPosition.latitude - nBPLatLng.latitude);
                float x17 = (float) ((clickParams.getX() - cameraPosition2.topLeftPosition.longitude) * d17);
                float y17 = (float) ((clickParams.getY() - cameraPosition2.topLeftPosition.latitude) * d18);
                list = CollectionsKt___CollectionsKt.toList(getVisibleMarkers());
                sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new Comparator() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersViewModel$onMapClick$lambda$6$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t16, T t17) {
                        int compareValues;
                        compareValues = ComparisonsKt__ComparisonsKt.compareValues(Double.valueOf(((NBPMapMarker) t17).zIndex), Double.valueOf(((NBPMapMarker) t16).zIndex));
                        return compareValues;
                    }
                });
                NBPMapMarker nBPMapMarker = this.currentFocusedMarker;
                if (nBPMapMarker != null ? nBPMapMarker.clickInSide(x17, y17) : false) {
                    return;
                }
                for (NBPMapMarker nBPMapMarker2 : sortedWith) {
                    if (nBPMapMarker2.clickInSide(x17, y17)) {
                        KLog kLog2 = KLog.INSTANCE;
                        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("marker did handle click with  key:");
                        m17.append(nBPMapMarker2.key);
                        m17.append(" x:");
                        m17.append(clickParams.getX());
                        m17.append(" y:");
                        m17.append(clickParams.getY());
                        kLog2.i("MapClick", m17.toString());
                        return;
                    }
                }
            }
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onModeChanged(NBPMainMode nBPMainMode, NBPSubMode nBPSubMode) {
        CameraPosition cameraPosition;
        this.mainMode = nBPMainMode;
        this.subMode = nBPSubMode;
        boolean z16 = true;
        boolean z17 = false;
        if (this.markerMainMode.ordinal() != nBPMainMode.ordinal()) {
            this.markerMainMode = nBPMainMode;
            boolean z18 = nBPMainMode != NBPMainMode.Concise && nBPMainMode == NBPMainMode.Normal;
            if (z18 != getShowMarkersLayer()) {
                this.showMarkersLayer$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z18));
            }
            if (this.markerMainMode == NBPMainMode.Normal && getShowMarkersLayer()) {
                CameraPosition cameraPosition2 = this.currentCameraPosition;
                if (cameraPosition2 != null) {
                    fetchPositionMarkerIfNeed$default(this, cameraPosition2.target, 6);
                }
                z17 = true;
            }
        }
        if (this.markerSubMode.ordinal() != nBPSubMode.ordinal()) {
            this.markerSubMode = nBPSubMode;
            if (nBPSubMode == NBPSubMode.Normal && (cameraPosition = this.currentCameraPosition) != null) {
                fetchPositionMarkerIfNeed$default(this, cameraPosition.target, 6);
            }
        } else {
            z16 = z17;
        }
        if (z16) {
            syncMarkerDisplay();
        }
        if (nBPMainMode != NBPMainMode.Concise) {
            this.uiScheduler.addUITask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersViewModel$onModeChanged$3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NBPMarkersViewModel.access$updateFocusedMarkers(NBPMarkersViewModel.this);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final void removeMarker(String str) {
        List<NBPMapMarker> list;
        if (this.markersSourceFlag.containsKey(str)) {
            this.markersSourceFlag.remove(str);
            list = CollectionsKt___CollectionsKt.toList(this.markersSource);
            for (NBPMapMarker nBPMapMarker : list) {
                if (Intrinsics.areEqual(nBPMapMarker.key, str)) {
                    this.markersSource.remove(nBPMapMarker);
                }
            }
            setNeedSyncMarkerDisplayOnMap$default(this);
        }
    }

    public final void syncMarkerDisplayIfNeed() {
        if (this.setNeedSyncDisplayMarker) {
            this.setNeedSyncDisplayMarker = false;
            syncMarkerDisplay();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onEnterMap() {
        this.didEnterMap = true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPageDidAppear() {
        this.isPageVisible = true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPageDidDisappear() {
        this.isPageVisible = false;
    }

    public final boolean updateCurrentTheme(f fVar) {
        String str;
        String str2;
        this.themeConfigDidLoad = true;
        if (fVar.H) {
            str = "";
        } else {
            str = fVar.f421849d;
        }
        boolean z16 = !Intrinsics.areEqual(this.currentMapThemeId, str);
        KLog kLog = KLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateCurrentTheme -> shouldReset:");
        sb5.append(z16);
        sb5.append(", isCity:");
        sb5.append(fVar.H);
        sb5.append(", cur:");
        sb5.append(this.currentMapThemeId);
        sb5.append(", newTheme.id: ");
        if (fVar.H) {
            str2 = "is city theme(hide id info)";
        } else {
            str2 = fVar.f421849d;
        }
        sb5.append(str2);
        sb5.append(", newThemeId: ");
        sb5.append(str);
        sb5.append(" .");
        kLog.i("NBPMarkersViewModel", sb5.toString());
        if (z16) {
            this.currentMapThemeId = str;
            this.markersSource.clear();
            this.markersSourceFlag.clear();
            NBPMarkerFetcher nBPMarkerFetcher = this.markersFetcher;
            nBPMarkerFetcher.didFetchPositions.clear();
            String str3 = nBPMarkerFetcher.limitFrequencyTimeoutRef;
            if (str3 != null) {
                TimerKt.b(str3);
                nBPMarkerFetcher.limitFrequencyTimeoutRef = null;
            }
            CameraPosition cameraPosition = this.currentCameraPosition;
            if (cameraPosition == null) {
                return true;
            }
            fetchPositionMarkerIfNeed$default(this, cameraPosition.target, 6);
            return true;
        }
        Iterator<NBPMapMarker> it = this.markersSource.iterator();
        while (it.hasNext()) {
            it.next().markerUpdate.themeConfigDidLoad();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
    public final void syncMarkerDisplay() {
        Map map;
        ArrayList<NBPMapMarker> arrayList;
        List sortedWith;
        List list;
        int i3;
        CameraPosition cameraPosition = this.currentCameraPosition;
        if (cameraPosition == null || !this.didEnterMapCameraFinish) {
            return;
        }
        HashMap hashMap = new HashMap();
        CameraPosition cameraPosition2 = this.currentCameraPosition;
        if (cameraPosition2 != null && this.didEnterMapCameraFinish) {
            if (this.mainMode == NBPMainMode.Concise) {
                arrayList = new ArrayList<>();
            } else if (this.subMode != NBPSubMode.Normal) {
                arrayList = new ArrayList<>();
                Iterator<NBPMapMarker> it = this.markersSource.iterator();
                while (it.hasNext()) {
                    NBPMapMarker next = it.next();
                    if (next.markerUpdate.canShowOnSubMode()) {
                        arrayList.add(next);
                    }
                }
            } else {
                arrayList = this.markersSource;
            }
            for (NBPMapMarker nBPMapMarker : arrayList) {
                if (nBPMapMarker.updateByCameraPosition(cameraPosition2)) {
                    hashMap.put(nBPMapMarker.key, nBPMapMarker);
                }
            }
            NBPMarkerCollection nBPMarkerCollection = this.markerCollection;
            float f16 = cameraPosition2.zoomLevel;
            nBPMarkerCollection.getClass();
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(hashMap.values(), new Comparator() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerCollection$collectionMarkers$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t16, T t17) {
                    int compareValues;
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Double.valueOf(((NBPMapMarker) t17).zIndex), Double.valueOf(((NBPMapMarker) t16).zIndex));
                    return compareValues;
                }
            });
            Iterator it5 = sortedWith.iterator();
            while (it5.hasNext()) {
                IMarkerCollection iMarkerCollection = ((NBPMapMarker) it5.next()).markerCollection;
                if (iMarkerCollection != null) {
                    iMarkerCollection.resetCollection();
                }
            }
            int size = sortedWith.size();
            int i16 = 0;
            while (i16 < size) {
                NBPMapMarker nBPMapMarker2 = (NBPMapMarker) sortedWith.get(i16);
                if (hashMap.containsKey(nBPMapMarker2.key) && nBPMapMarker2.markerCollection != null) {
                    float f17 = 0.0f;
                    if (!(nBPMapMarker2.markerViewSize.getWidth() == 0.0f)) {
                        if (!(nBPMapMarker2.markerViewSize.getHeight() == 0.0f)) {
                            MarkerRect markerRectOnScreenForCollection = nBPMapMarker2.getMarkerRectOnScreenForCollection();
                            int i17 = i16 + 1;
                            int size2 = sortedWith.size();
                            while (i17 < size2) {
                                NBPMapMarker nBPMapMarker3 = (NBPMapMarker) sortedWith.get(i17);
                                if (hashMap.containsKey(nBPMapMarker3.key)) {
                                    if (!(nBPMapMarker3.markerViewSize.getWidth() == f17)) {
                                        if (!(nBPMapMarker3.markerViewSize.getHeight() == f17)) {
                                            MarkerRect markerRectOnScreenForCollection2 = nBPMapMarker3.getMarkerRectOnScreenForCollection();
                                            float max = Math.max(markerRectOnScreenForCollection.left, markerRectOnScreenForCollection2.left);
                                            float max2 = Math.max(markerRectOnScreenForCollection.top, markerRectOnScreenForCollection2.top);
                                            list = sortedWith;
                                            float min = Math.min(markerRectOnScreenForCollection.right, markerRectOnScreenForCollection2.right);
                                            i3 = size;
                                            float min2 = Math.min(markerRectOnScreenForCollection.bottom, markerRectOnScreenForCollection2.bottom);
                                            if (nBPMapMarker2.markerCollection.addCollectionMarker(nBPMapMarker3, (float) (((min <= max || min2 <= max2) ? null : new MarkerRect(max, max2, min, min2)) == null ? 0.0d : (r11.width * r11.height) / (markerRectOnScreenForCollection2.width * markerRectOnScreenForCollection2.height)))) {
                                                hashMap.remove(nBPMapMarker3.key);
                                                if (nBPMapMarker3.collectionParentMarker == null) {
                                                    nBPMapMarker3.collectionParentMarker = nBPMapMarker2;
                                                    nBPMapMarker3.collectionZoomLevel = Float.valueOf(f16);
                                                }
                                            }
                                            i17++;
                                            sortedWith = list;
                                            size = i3;
                                            f17 = 0.0f;
                                        }
                                    }
                                }
                                list = sortedWith;
                                i3 = size;
                                i17++;
                                sortedWith = list;
                                size = i3;
                                f17 = 0.0f;
                            }
                        }
                    }
                }
                i16++;
                sortedWith = sortedWith;
                size = size;
            }
        }
        map = MapsKt__MapsKt.toMap(this.visibleMarkersMap);
        for (final Map.Entry entry : map.entrySet()) {
            if (!hashMap.containsKey(entry.getKey())) {
                this.visibleMarkersMap.remove(entry.getKey());
                ((NBPMapMarker) entry.getValue()).updateVisibleOnMap(false, cameraPosition, this.uiScheduler);
                this.uiScheduler.addUITask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersViewModel$syncMarkerDisplay$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        if (!NBPMarkersViewModel.this.visibleMarkersMap.containsKey(entry.getKey()) && NBPMarkersViewModel.this.getVisibleMarkers().contains(entry.getValue())) {
                            NBPMarkersViewModel.this.getVisibleMarkers().remove(entry.getValue());
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
        }
        for (final Map.Entry entry2 : hashMap.entrySet()) {
            ((NBPMapMarker) entry2.getValue()).updateVisibleOnMap(true, cameraPosition, this.uiScheduler);
            if (!this.visibleMarkersMap.containsKey(entry2.getKey())) {
                this.visibleMarkersMap.put(entry2.getKey(), entry2.getValue());
                if (!getVisibleMarkers().contains(entry2.getValue())) {
                    this.uiScheduler.addUITask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersViewModel$syncMarkerDisplay$1$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            if (NBPMarkersViewModel.this.visibleMarkersMap.containsKey(entry2.getKey()) && !NBPMarkersViewModel.this.getVisibleMarkers().contains(entry2.getValue())) {
                                Iterator<NBPMapMarker> it6 = NBPMarkersViewModel.this.getVisibleMarkers().iterator();
                                int i18 = 0;
                                while (it6.hasNext() && it6.next().zIndex <= entry2.getValue().zIndex) {
                                    i18++;
                                }
                                NBPMarkersViewModel.this.getVisibleMarkers().add(i18, entry2.getValue());
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
            }
        }
        NBPViewModelStore vmStore = NBPMainKtxKt.getVmStore();
        com.tencent.kuikly.core.reactive.collection.c<NBPMapMarker> visibleMarkers = getVisibleMarkers();
        Iterator it6 = vmStore.viewModels.values().iterator();
        while (it6.hasNext()) {
            ((NBPMainBaseViewModel) it6.next()).onMarkersDisplayed(visibleMarkers);
        }
        this.uiScheduler.addUITask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersViewModel$syncMarkerDisplay$1$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                NBPMarkersViewModel.access$updateFocusedMarkers(NBPMarkersViewModel.this);
                return Unit.INSTANCE;
            }
        });
    }

    public final void fetchPositionMarkerIfNeed(final NBPLatLng nBPLatLng, boolean z16, final Function0<Unit> function0) {
        boolean z17;
        int roundToInt;
        if (!this.didEnterMap) {
            AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchPositionMarkerIfNeed, didEnterMap: "), this.didEnterMap, KLog.INSTANCE, "NBPMarkersViewModel");
            return;
        }
        if (this.subMode == NBPSubMode.Normal && this.mainMode != NBPMainMode.Concise) {
            final NBPMarkerFetcher nBPMarkerFetcher = this.markersFetcher;
            final String str = this.currentMapThemeId;
            Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersViewModel$fetchPositionMarkerIfNeed$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel>] */
                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NBPViewModelStore vmStore = NBPMainKtxKt.getVmStore();
                    int size = NBPMarkersViewModel.this.markersSource.size();
                    String str2 = NBPMarkersViewModel.this.currentMapThemeId;
                    Iterator it = vmStore.viewModels.values().iterator();
                    while (it.hasNext()) {
                        ((NBPMainBaseViewModel) it.next()).onFetchMaker(size, str2);
                    }
                    return Unit.INSTANCE;
                }
            };
            final Function1<ArrayList<NBPMapMarker>, Unit> function1 = new Function1<ArrayList<NBPMapMarker>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersViewModel$fetchPositionMarkerIfNeed$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ArrayList<NBPMapMarker> arrayList) {
                    NBPMarkersViewModel nBPMarkersViewModel = this;
                    Iterator<T> it = arrayList.iterator();
                    while (it.hasNext()) {
                        nBPMarkersViewModel.addMarker((NBPMapMarker) it.next());
                    }
                    Function0<Unit> function03 = function0;
                    if (function03 != null) {
                        function03.invoke();
                    }
                    return Unit.INSTANCE;
                }
            };
            Iterator<NBPLatLng> it = nBPMarkerFetcher.didFetchPositions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z17 = false;
                    break;
                }
                NBPLatLng next = it.next();
                double d16 = nBPLatLng.latitude;
                double d17 = nBPLatLng.longitude;
                double d18 = (d16 * 3.141592653589793d) / 180.0d;
                double d19 = (next.latitude * 3.141592653589793d) / 180.0d;
                Iterator<NBPLatLng> it5 = it;
                roundToInt = MathKt__MathJVMKt.roundToInt(Math.asin(Math.sqrt((Math.pow(Math.sin((((d17 * 3.141592653589793d) / 180.0d) - ((next.longitude * 3.141592653589793d) / 180.0d)) / 2.0d), 2.0d) * Math.cos(d19) * Math.cos(d18)) + Math.pow(Math.sin((d18 - d19) / 2.0d), 2.0d))) * 2.0d * 6378.137d * 10000.0d);
                if ((roundToInt / 10000.0d) * 1000.0d < nBPMarkerFetcher.validDistance) {
                    z17 = true;
                    break;
                }
                it = it5;
            }
            if (z17) {
                KLog.INSTANCE.i("NBPMarkerFetcher", "had fetched");
                return;
            }
            final Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerFetcher$fetchMakerIfNeed$requestAction$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    final NBPMarkerFetcher nBPMarkerFetcher2 = NBPMarkerFetcher.this;
                    final NBPLatLng nBPLatLng2 = nBPLatLng;
                    String str2 = str;
                    final Function1<ArrayList<NBPMapMarker>, Unit> function12 = function1;
                    nBPMarkerFetcher2.didFetchPositions.add(nBPLatLng2);
                    KLog kLog = KLog.INSTANCE;
                    kLog.i("NBPMarkerFetcher", "will request user geo near with centerPosition: " + nBPLatLng2 + " themeId:" + str2);
                    final long a16 = a.f453719a.a();
                    double d26 = nBPLatLng2.latitude;
                    double d27 = nBPLatLng2.longitude;
                    final Function1<v25.c, Unit> function13 = new Function1<v25.c, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerFetcher$requestUserGeoNear$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:55:0x0199 A[SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:59:0x0121 A[SYNTHETIC] */
                        @Override // kotlin.jvm.functions.Function1
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(v25.c cVar) {
                            NBPMapMarker nBPMapMarker;
                            String str3;
                            NBPMapMarker nBPMapMarker2;
                            NBPMapMarker nBPMapMarker3;
                            Iterator it6;
                            i iVar;
                            String str4;
                            final v25.c cVar2 = cVar;
                            long a17 = a.f453719a.a();
                            KLog kLog2 = KLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("did request user geo near with centerPosition: ");
                            m3.append(NBPLatLng.this);
                            m3.append(" is success:");
                            m3.append(cVar2 != null);
                            m3.append(" costTime:");
                            m3.append(a17 - a16);
                            kLog2.i("NBPMarkerFetcher", m3.toString());
                            if (cVar2 != null) {
                                final ArrayList<NBPMapMarker> arrayList = new ArrayList<>();
                                final ArrayList arrayList2 = new ArrayList();
                                Iterator it7 = cVar2.D.iterator();
                                while (true) {
                                    NBPMapMarker nBPMapMarker4 = null;
                                    if (!it7.hasNext()) {
                                        break;
                                    }
                                    t tVar = (t) it7.next();
                                    NBPPOIMarkerViewModel.Companion companion = NBPPOIMarkerViewModel.Companion;
                                    k kVar = tVar.f440896d;
                                    if (kVar == null || (iVar = kVar.C) == null) {
                                        it6 = it7;
                                    } else {
                                        double d28 = 1000000;
                                        it6 = it7;
                                        NBPLatLng nBPLatLng3 = new NBPLatLng(iVar.f418079d / d28, iVar.f418080e / d28);
                                        k kVar2 = tVar.f440896d;
                                        if (kVar2 == null || (str4 = kVar2.Q) == null) {
                                            if (kVar2 != null) {
                                                str4 = kVar2.f418087e;
                                            } else {
                                                str4 = "\u9644\u8fd1\u5730\u6807";
                                            }
                                        }
                                        NBPPOIMarkerViewModel nBPPOIMarkerViewModel = new NBPPOIMarkerViewModel(tVar, str4, new NBPPOIMarkerUIConfig(NBPPOIMarkerViewModelKt.access$isSmallSize(str4)));
                                        long j3 = 11360448000L;
                                        if (h.a().getPagerData().getIsAndroid()) {
                                            long j16 = 1000;
                                            long j17 = (iVar.f418080e % j16) + ((iVar.f418079d % j16) * j16);
                                            long j18 = NBPPOIMarkerViewModel.MAX_INTERNAL_ORDER;
                                            if (j17 > j18) {
                                                j17 %= j18;
                                            }
                                            j3 = 11360448000L + j17;
                                        }
                                        nBPMapMarker4 = new NBPMapMarker(nBPLatLng3, (Function1) nBPPOIMarkerViewModel.viewBuilder$delegate.getValue(), nBPPOIMarkerViewModel, (String) nBPPOIMarkerViewModel.key$delegate.getValue(), j3, nBPPOIMarkerViewModel.uiCfg.size, nBPPOIMarkerViewModel, nBPPOIMarkerViewModel);
                                    }
                                    if (nBPMapMarker4 != null) {
                                        arrayList.add(nBPMapMarker4);
                                    }
                                    it7 = it6;
                                }
                                for (v25.a aVar : cVar2.f440837f) {
                                    arrayList2.add(aVar.f440824d);
                                    NBPMapMarker generateMapMarker = NBPMarkerFactory.INSTANCE.generateMapMarker(aVar);
                                    if (generateMapMarker != null) {
                                        arrayList.add(generateMapMarker);
                                    }
                                }
                                final ArrayList arrayList3 = new ArrayList();
                                for (p pVar : cVar2.f440836e) {
                                    UserDataManager userDataManager = UserDataManager.INSTANCE;
                                    if (!userDataManager.isHostTid(Long.valueOf(pVar.f440880d))) {
                                        arrayList3.add(Long.valueOf(pVar.f440880d));
                                        NBPPersonMarkerViewModel.Companion companion2 = NBPPersonMarkerViewModel.Companion;
                                        if (!userDataManager.isHostTid(Long.valueOf(pVar.f440880d))) {
                                            NBPPersonMarkerViewModel nBPPersonMarkerViewModel = new NBPPersonMarkerViewModel(pVar);
                                            NBPLatLng nBPLatLng4 = nBPPersonMarkerViewModel.position;
                                            if (nBPLatLng4 == null) {
                                                KLog kLog3 = KLog.INSTANCE;
                                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("position is null when generate personViewModel tid:");
                                                m16.append(pVar.f440880d);
                                                m16.append(" text:");
                                                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m16, pVar.f440882f, kLog3, "NBPFeedMarkerViewModel");
                                            } else {
                                                Intrinsics.checkNotNull(nBPLatLng4);
                                                nBPMapMarker3 = new NBPMapMarker(nBPLatLng4, (Function1) nBPPersonMarkerViewModel.viewBuilder$delegate.getValue(), nBPPersonMarkerViewModel, nBPPersonMarkerViewModel.key, nBPPersonMarkerViewModel.zIndex, NBPPersonMarkerUIConfig.size, nBPPersonMarkerViewModel, nBPPersonMarkerViewModel);
                                                if (nBPMapMarker3 == null) {
                                                    arrayList.add(nBPMapMarker3);
                                                }
                                            }
                                        }
                                        nBPMapMarker3 = null;
                                        if (nBPMapMarker3 == null) {
                                        }
                                    }
                                }
                                final ArrayList arrayList4 = new ArrayList();
                                for (o25.a aVar2 : cVar2.f440838h) {
                                    d dVar = aVar2.f421834i;
                                    if (dVar == null || (str3 = dVar.f421841d) == null) {
                                        str3 = "";
                                    }
                                    arrayList4.add(str3);
                                    NBPLandMarkerViewModel.Companion.getClass();
                                    NBPLandMarkerViewModel nBPLandMarkerViewModel = new NBPLandMarkerViewModel(aVar2);
                                    NBPLatLng nBPLatLng5 = nBPLandMarkerViewModel.position;
                                    KLog kLog4 = KLog.INSTANCE;
                                    StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("area ");
                                    m17.append(aVar2.f421830d);
                                    m17.append(", ");
                                    d dVar2 = aVar2.f421834i;
                                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m17, dVar2 != null ? dVar2.f421841d : null, kLog4, "NBPLandMarkerViewModel");
                                    if (nBPLatLng5 == null) {
                                        StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("area position is null, ");
                                        m18.append(aVar2.f421830d);
                                        m18.append(", ");
                                        d dVar3 = aVar2.f421834i;
                                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m18, dVar3 != null ? dVar3.f421841d : null, kLog4, "NBPLandMarkerViewModel");
                                        nBPMapMarker2 = null;
                                    } else {
                                        nBPMapMarker2 = new NBPMapMarker(nBPLatLng5, (Function1) nBPLandMarkerViewModel.viewBuilder$delegate.getValue(), nBPLandMarkerViewModel, (String) nBPLandMarkerViewModel.key$delegate.getValue(), ((Number) nBPLandMarkerViewModel.zIndex$delegate.getValue()).doubleValue(), nBPLandMarkerViewModel.getMarkerViewSize(), nBPLandMarkerViewModel, nBPLandMarkerViewModel);
                                    }
                                    if (nBPMapMarker2 != null) {
                                        arrayList.add(nBPMapMarker2);
                                    }
                                }
                                for (g gVar : cVar2.C) {
                                    NBPOperationMarkerViewModel nBPOperationMarkerViewModel = new NBPOperationMarkerViewModel(gVar);
                                    NBPLatLng nBPLatLng6 = nBPOperationMarkerViewModel.position;
                                    if (nBPLatLng6 == null) {
                                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("position is null when generate operation url:"), gVar.f421858h, KLog.INSTANCE, "NBPOperationMarkerViewModel");
                                        nBPMapMarker = null;
                                    } else {
                                        Intrinsics.checkNotNull(nBPLatLng6);
                                        nBPMapMarker = new NBPMapMarker(nBPLatLng6, (Function1) nBPOperationMarkerViewModel.viewBuilder$delegate.getValue(), nBPOperationMarkerViewModel, (String) nBPOperationMarkerViewModel.key$delegate.getValue(), nBPOperationMarkerViewModel.zIndex, nBPOperationMarkerViewModel.getMarkerViewSize(), nBPOperationMarkerViewModel, nBPOperationMarkerViewModel);
                                    }
                                    if (nBPMapMarker != null) {
                                        arrayList.add(nBPMapMarker);
                                    }
                                }
                                function12.invoke(arrayList);
                                final NBPLatLng nBPLatLng7 = NBPLatLng.this;
                                TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerFetcher$requestUserGeoNear$1.6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        KLog kLog5 = KLog.INSTANCE;
                                        StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("did fetch near request position:");
                                        m19.append(NBPLatLng.this);
                                        m19.append(" feeds:");
                                        StringBuilder m26 = NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(cVar2.f440838h, NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(cVar2.f440836e, NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(cVar2.f440837f, m19, " persons:"), " areas:"), " markers:");
                                        m26.append(arrayList.size());
                                        m26.append(" \nfeedIds:");
                                        m26.append(arrayList2);
                                        m26.append(", \npersonIds:");
                                        m26.append(arrayList3);
                                        m26.append(", \nareaIds:");
                                        m26.append(arrayList4);
                                        m26.append(", \noperationMarkers:");
                                        m26.append(cVar2.C.size());
                                        kLog5.i("NBPMarkerFetcher", m26.toString());
                                        return Unit.INSTANCE;
                                    }
                                });
                                final List<v25.a> list = cVar2.f440837f;
                                TimerKt.d(50, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.ReportReadFeedsRepo$reportReadMapFeeds$1
                                    public final /* synthetic */ int $source = 1;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        int collectionSizeOrDefault;
                                        List<v25.a> list2 = list;
                                        ArrayList arrayList5 = new ArrayList();
                                        for (Object obj : list2) {
                                            if (!UserDataManager.INSTANCE.isHostTid(Long.valueOf(((v25.a) obj).f440825e))) {
                                                arrayList5.add(obj);
                                            }
                                        }
                                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10);
                                        final ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault);
                                        Iterator it8 = arrayList5.iterator();
                                        while (it8.hasNext()) {
                                            arrayList6.add(((v25.a) it8.next()).f440824d);
                                        }
                                        if (!arrayList6.isEmpty()) {
                                            QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.sendPbRequest$default(new ReportReadFeedsRequest(ReportReadFeedsSource$EnumUnboxingLocalUtility.getValue(this.$source), arrayList6), null, new Function1<PbResponse<s25.h>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.ReportReadFeedsRepo$reportReadMapFeeds$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(PbResponse<s25.h> pbResponse) {
                                                    PbResponse<s25.h> pbResponse2 = pbResponse;
                                                    KLog kLog5 = KLog.INSTANCE;
                                                    StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("reportReadFeeds[map] code: ");
                                                    m19.append(pbResponse2.code);
                                                    m19.append(", msg1: ");
                                                    m19.append(pbResponse2.f114187msg);
                                                    m19.append(" feedId:");
                                                    m19.append(arrayList6);
                                                    kLog5.e("ReportReadFeedsRepo", m19.toString());
                                                    return Unit.INSTANCE;
                                                }
                                            }, 6);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                            } else {
                                nBPMarkerFetcher2.didFetchPositions.remove(NBPLatLng.this);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    NearbyConst nearbyConst = NearbyConst.INSTANCE;
                    kLog.i("feed_detail_page", "start requestSelfGeoNear latitude :" + d26 + ", longitude" + d27 + ", mapThemeId:" + str2);
                    GeoNearRequest geoNearRequest = new GeoNearRequest((float) d26, (float) d27, str2);
                    Function1<PbResponse<v25.c>, Unit> function14 = new Function1<PbResponse<v25.c>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbySsoGeoNearRequestModel$Companion$requestUserGeoNear$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(PbResponse<v25.c> pbResponse) {
                            List<v25.a> list;
                            PbResponse<v25.c> pbResponse2 = pbResponse;
                            if (pbResponse2.success) {
                                KLog kLog2 = KLog.INSTANCE;
                                NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestSelfGeoNear success feedSize:");
                                v25.c cVar = pbResponse2.rsp;
                                NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, (cVar == null || (list = cVar.f440837f) == null) ? null : Integer.valueOf(list.size()), kLog2, "feed_detail_page");
                            } else {
                                KLog kLog3 = KLog.INSTANCE;
                                NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestSelfGeoNear failure code:");
                                m16.append(pbResponse2.code);
                                m16.append(", message:");
                                m16.append(pbResponse2.f114187msg);
                                m16.append('}');
                                kLog3.i("feed_detail_page", m16.toString());
                            }
                            function13.invoke(pbResponse2.rsp);
                            return Unit.INSTANCE;
                        }
                    };
                    APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.map_svr.Map.SsoGeoNear");
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.sendPbRequest$default(geoNearRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function14), 6);
                    return Unit.INSTANCE;
                }
            };
            String str2 = nBPMarkerFetcher.limitFrequencyTimeoutRef;
            if (str2 != null) {
                TimerKt.b(str2);
                nBPMarkerFetcher.limitFrequencyTimeoutRef = null;
            }
            if (z16) {
                function02.invoke();
                nBPMarkerFetcher.limitFrequencyTimeoutRef = TimerKt.d(nBPMarkerFetcher.limitFrequencyTime, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerFetcher$fetchMakerIfNeed$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        function03.invoke();
                        return Unit.INSTANCE;
                    }
                });
                return;
            } else {
                function02.invoke();
                function03.invoke();
                return;
            }
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchPositionMarkerIfNeed, mode return ");
        m3.append(this.subMode);
        m3.append(", mainMode: ");
        m3.append(this.mainMode);
        kLog.i("NBPMarkersViewModel", m3.toString());
    }

    public static /* synthetic */ void fetchPositionMarkerIfNeed$default(NBPMarkersViewModel nBPMarkersViewModel, NBPLatLng nBPLatLng, int i3) {
        nBPMarkersViewModel.fetchPositionMarkerIfNeed(nBPLatLng, (i3 & 2) != 0, null);
    }
}
