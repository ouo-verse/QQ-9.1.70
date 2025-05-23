package com.tencent.mobileqq.nearbypro.map.part;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mapsdk.internal.ky;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.m;
import com.tencent.mobileqq.nearbypro.map.view.NearbyProMapView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import cooperation.qzone.PlatformInfor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/part/f;", "Lcom/tencent/mobileqq/nearbypro/map/part/i;", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap$OnMapLoadedCallback;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "", PlatformInfor.SIMPLE_MODE, "C9", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "E9", "Lcom/tencent/mobileqq/nearbypro/map/view/NearbyProMapView;", "F9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStart", "onPartResume", "onPartPause", "onPartStop", "onPartDestroy", "onMapLoaded", tl.h.F, "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "tencentMap", "i", "Lcom/tencent/mobileqq/nearbypro/map/view/NearbyProMapView;", "mapView", "Lfb2/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lfb2/b;", "markerAdapter", BdhLogUtil.LogTag.Tag_Conn, "Z", "needIgnoreNextPauseOnce", "<init>", "()V", "D", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f extends i implements TencentMap.OnMapLoadedCallback {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean needIgnoreNextPauseOnce;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TencentMap tencentMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NearbyProMapView mapView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private fb2.b markerAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/nearbypro/map/part/f$b", "Lcom/tencent/mobileqq/nearbypro/map/part/j;", "Lbb2/d;", "Lda2/b;", "markerView", "date", "Landroid/view/MotionEvent;", "clickEvent", "", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends j {
        b() {
        }

        @Override // com.tencent.mobileqq.nearbypro.map.part.j
        public void a(@Nullable bb2.d<da2.b> markerView, @NotNull da2.b date, @NotNull MotionEvent clickEvent) {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
            super.a(markerView, date, clickEvent);
            if (markerView != null) {
                markerView.e(date, f.this.z9(), clickEvent);
            }
        }
    }

    private final void I9(ViewGroup parent) {
        NearbyProMapView nearbyProMapView;
        com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.NearbyMapPart", "initMap");
        if (com.tencent.mobileqq.nearbypro.base.j.a().debug()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TencentMapOptions tencentMapOptions = new TencentMapOptions();
            tencentMapOptions.openDebugLogByTags(ky.f149098d);
            Unit unit = Unit.INSTANCE;
            nearbyProMapView = new NearbyProMapView(context, tencentMapOptions);
        } else {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            nearbyProMapView = new NearbyProMapView(context2);
        }
        this.mapView = nearbyProMapView;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        if (parent != null) {
            parent.addView(this.mapView, layoutParams);
        }
        NearbyProMapView nearbyProMapView2 = this.mapView;
        if (nearbyProMapView2 != null) {
            nearbyProMapView2.setClipChildren(false);
            nearbyProMapView2.setClipToPadding(false);
        }
        NearbyProMapView nearbyProMapView3 = this.mapView;
        Intrinsics.checkNotNull(nearbyProMapView3, "null cannot be cast to non-null type com.tencent.mobileqq.nearbypro.map.view.NearbyProMapView");
        TencentMap map = nearbyProMapView3.getMap();
        this.tencentMap = map;
        if (map != null) {
            map.setMapStyle(2);
            map.addOnMapLoadedCallback(this);
            UiSettings uiSettings = map.getUiSettings();
            if (uiSettings != null) {
                Intrinsics.checkNotNullExpressionValue(uiSettings, "uiSettings");
                uiSettings.setTiltGesturesEnabled(false);
                uiSettings.setScaleViewEnabled(false);
                uiSettings.setRotateGesturesEnabled(false);
                uiSettings.setGestureScaleByMapCenter(true);
                uiSettings.setLogoScale(0.7f);
            }
            map.setMinZoomLevel(ab2.a.f25767a.q());
            map.setBuilding3dEffectEnable(false);
            fb2.b bVar = new fb2.b(new WeakReference(z9()), null, 2, null);
            this.markerAdapter = bVar;
            map.setInfoWindowAdapter(bVar);
            map.enableMultipleInfowindow(true);
            UiSettings uiSettings2 = map.getUiSettings();
            if (uiSettings2 != null) {
                uiSettings2.setLogoPositionWithMargin(1, -1, ImmersiveUtils.dpToPx(14.0f), -1, -1);
            }
        }
        TencentMap tencentMap = this.tencentMap;
        if (tencentMap != null) {
            tencentMap.setOnInfoWindowClickListener(new b());
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e
    public void C9(boolean concise) {
        super.C9(concise);
        com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.NearbyMapPart", "onStyleModeChange concise=" + concise);
    }

    @Override // com.tencent.mobileqq.nearbypro.map.part.i
    @Nullable
    /* renamed from: E9, reason: from getter */
    public TencentMap getTencentMap() {
        return this.tencentMap;
    }

    @Override // com.tencent.mobileqq.nearbypro.map.part.i
    @Nullable
    /* renamed from: F9, reason: from getter */
    public NearbyProMapView getMapView() {
        return this.mapView;
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "MSG_LOCATION_ACTION")) {
            this.needIgnoreNextPauseOnce = true;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        super.onInitView(rootView);
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.emc);
        } else {
            viewGroup = null;
        }
        I9(viewGroup);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback
    public void onMapLoaded() {
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        String logTag = getTAG();
        Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
        c16.c(logTag, "onMapLoaded");
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        m mVar = m.f253240a;
        long uptimeMillis = SystemClock.uptimeMillis();
        NearbyProMapView nearbyProMapView = this.mapView;
        if (nearbyProMapView != null) {
            nearbyProMapView.onDestroy();
            Unit unit = Unit.INSTANCE;
        }
        com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.NearbyMapPart", "onPartDestroy cost(ms):" + (SystemClock.uptimeMillis() - uptimeMillis));
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        if (this.needIgnoreNextPauseOnce) {
            this.needIgnoreNextPauseOnce = false;
            return;
        }
        NearbyProMapView nearbyProMapView = this.mapView;
        if (nearbyProMapView != null) {
            nearbyProMapView.onPause();
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        NearbyProMapView nearbyProMapView = this.mapView;
        if (nearbyProMapView != null) {
            nearbyProMapView.onResume();
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartStart(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartStart(activity);
        NearbyProMapView nearbyProMapView = this.mapView;
        if (nearbyProMapView != null) {
            nearbyProMapView.onStart();
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartStop(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartStop(activity);
        NearbyProMapView nearbyProMapView = this.mapView;
        if (nearbyProMapView != null) {
            nearbyProMapView.onStop();
        }
    }
}
