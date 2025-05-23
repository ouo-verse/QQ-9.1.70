package com.tencent.mobileqq.nearbypro.qqkuikly.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.map.sdk.utilities.visualization.heatmap.GradientVectorOverlayProvider;
import com.tencent.mapsdk.internal.ky;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.map.view.NearbyProMapView;
import com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.RenderAlgorithm;
import com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.RenderReason;
import com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;
import com.tencent.xweb.FileReaderHelper;
import i01.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;
import vp4.e;

@Metadata(d1 = {"\u0000\u00d5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001s\u0018\u0000 \b2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001zB\u000f\u0012\u0006\u0010w\u001a\u00020v\u00a2\u0006\u0004\bx\u0010yJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0011H\u0002J?\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00112+\u0010\u0018\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013j\u0004\u0018\u0001`\u0017H\u0002J#\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050&2\u0006\u0010%\u001a\u00020$H\u0002J?\u0010(\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00112+\u0010\u0018\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013j\u0004\u0018\u0001`\u0017H\u0002J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u000bH\u0002J\b\u0010/\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\u000bH\u0002J\u0016\u00103\u001a\b\u0012\u0004\u0012\u000202012\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u00105\u001a\u0002042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u00107\u001a\u0002062\u0006\u0010\u000e\u001a\u00020\rH\u0002J0\u0010>\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u00072\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u0002092\u0006\u0010<\u001a\u0002092\u0006\u0010=\u001a\u000209H\u0014J\b\u0010?\u001a\u00020\u000bH\u0016J\u0018\u0010A\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010B\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010E\u001a\u00020\u00072\u0006\u0010C\u001a\u0002092\u0006\u0010\u0006\u001a\u00020DJ\u0016\u0010F\u001a\u00020\u00072\u0006\u0010C\u001a\u0002092\u0006\u0010\u0006\u001a\u00020DJI\u0010I\u001a\u0004\u0018\u00010\u00052\u0006\u0010G\u001a\u00020\u00112\b\u0010H\u001a\u0004\u0018\u00010\u00112+\u0010\u0018\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013j\u0004\u0018\u0001`\u0017H\u0016J\b\u0010J\u001a\u00020\u000bH\u0016J\u0010\u0010K\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010L\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H\u0016R\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR;\u0010[\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013j\u0004\u0018\u0001`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR;\u0010]\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013j\u0004\u0018\u0001`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010ZR;\u0010_\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013j\u0004\u0018\u0001`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010ZR;\u0010`\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013j\u0004\u0018\u0001`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010ZR\u0016\u0010a\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010.R\u0016\u0010b\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010.R\u0016\u0010d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010cR \u0010g\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010fR\u001e\u0010h\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010fR\u0016\u0010i\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010cR\u0016\u0010k\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010.R\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010r\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010qR\u0016\u0010u\u001a\u00020s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010t\u00a8\u0006{"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/NBPKuiklyMapView;", "Landroid/widget/FrameLayout;", "Li01/c;", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap$OnMapLoadedCallback;", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap$OnCameraChangeListener;", "", "propValue", "", "N", "X", "W", "", UserInfo.SEX_FEMALE, "Lvp4/a;", "heatMapData", "E", "D", "", "T", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "U", "", "Lvp4/d;", "data", "", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "([Lvp4/d;)Ljava/util/List;", "v", "L", "u", "Lcom/tencent/tencentmap/mapsdk/maps/model/CameraPosition;", "cameraPosition", "", HippyTKDListViewAdapter.X, ExifInterface.LATITUDE_SOUTH, "M", "P", "O", "H", "G", "I", "t", "w", "", "Lcom/tencent/map/sdk/utilities/visualization/datamodels/WeightedLatLng;", "B", "", "y", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "changed", "", "left", "top", "right", "bottom", "onLayout", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "propKey", "b", BdhLogUtil.LogTag.Tag_Conn, "animate", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "method", "params", "call", "onMapLoaded", "onCameraChange", "onCameraChangeFinished", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "d", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "tencentMap", "Lcom/tencent/mobileqq/nearbypro/map/view/NearbyProMapView;", "e", "Lcom/tencent/mobileqq/nearbypro/map/view/NearbyProMapView;", "mapView", "Lcom/tencent/tencentmap/mapsdk/maps/model/VectorOverlay;", "f", "Lcom/tencent/tencentmap/mapsdk/maps/model/VectorOverlay;", "currentHeatMapOverlay", h.F, "Lkotlin/jvm/functions/Function1;", "mapLoadedCallback", "i", "mapCameraChangedFinish", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mapCameraChanged", "mapClick", "minZoomLevel", "maxZoomLevel", "Z", "mapDestroyed", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "updateCameraPendingTask", "updateHeatMapPendingTask", "hadCallStartAndResume", "J", "mapStyle", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/HeatMapMode;", "K", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/HeatMapMode;", "heatMapMode", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/d;", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/d;", "customHeatMapRenderer", "com/tencent/mobileqq/nearbypro/qqkuikly/view/NBPKuiklyMapView$c", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/NBPKuiklyMapView$c;", "activityLifeCycleCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NBPKuiklyMapView extends FrameLayout implements i01.c, TencentMap.OnMapLoadedCallback, TencentMap.OnCameraChangeListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> mapClick;

    /* renamed from: D, reason: from kotlin metadata */
    private int minZoomLevel;

    /* renamed from: E, reason: from kotlin metadata */
    private int maxZoomLevel;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mapDestroyed;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> updateCameraPendingTask;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> updateHeatMapPendingTask;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean hadCallStartAndResume;

    /* renamed from: J, reason: from kotlin metadata */
    private int mapStyle;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private HeatMapMode heatMapMode;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.d customHeatMapRenderer;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private c activityLifeCycleCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TencentMap tencentMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NearbyProMapView mapView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VectorOverlay currentHeatMapOverlay;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> mapLoadedCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> mapCameraChangedFinish;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> mapCameraChanged;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253841a;

        static {
            int[] iArr = new int[HeatMapMode.values().length];
            try {
                iArr[HeatMapMode.BUILTIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HeatMapMode.CUSTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f253841a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/view/NBPKuiklyMapView$c", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements Application.ActivityLifecycleCallbacks {
        c() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (Intrinsics.areEqual(NBPKuiklyMapView.this.getActivity(), activity)) {
                NBPKuiklyMapView.this.w();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            NearbyProMapView nearbyProMapView;
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (Intrinsics.areEqual(NBPKuiklyMapView.this.getActivity(), activity) && NBPKuiklyMapView.this.hadCallStartAndResume && (nearbyProMapView = NBPKuiklyMapView.this.mapView) != null) {
                nearbyProMapView.onResume();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            NearbyProMapView nearbyProMapView;
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (Intrinsics.areEqual(NBPKuiklyMapView.this.getActivity(), activity) && NBPKuiklyMapView.this.hadCallStartAndResume && (nearbyProMapView = NBPKuiklyMapView.this.mapView) != null) {
                nearbyProMapView.onStart();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            NearbyProMapView nearbyProMapView;
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (Intrinsics.areEqual(NBPKuiklyMapView.this.getActivity(), activity) && (nearbyProMapView = NBPKuiklyMapView.this.mapView) != null) {
                nearbyProMapView.onStop();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NBPKuiklyMapView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.minZoomLevel = 7;
        this.maxZoomLevel = 18;
        this.mapStyle = 2;
        this.heatMapMode = HeatMapMode.CUSTOM;
        this.activityLifeCycleCallback = new c();
        H();
    }

    private final List<LatLng> A(vp4.d[] data) {
        ArrayList arrayList = new ArrayList();
        for (vp4.d dVar : data) {
            arrayList.add(new LatLng(dVar.f443169a, dVar.f443170b));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<WeightedLatLng> B(vp4.a heatMapData) {
        ArrayList arrayList = new ArrayList();
        e[] eVarArr = heatMapData.f443154a;
        Intrinsics.checkNotNullExpressionValue(eVarArr, "heatMapData.weightedData");
        for (e eVar : eVarArr) {
            vp4.d dVar = eVar.f443172a;
            arrayList.add(new WeightedLatLng(new LatLng(dVar.f443169a, dVar.f443170b), eVar.f443173b));
        }
        return arrayList;
    }

    private final void D(final vp4.a heatMapData) {
        boolean z16;
        VectorOverlay vectorOverlay = this.currentHeatMapOverlay;
        if (vectorOverlay != null) {
            vectorOverlay.remove();
        }
        e[] eVarArr = heatMapData.f443154a;
        Intrinsics.checkNotNullExpressionValue(eVarArr, "heatMapData.weightedData");
        if (eVarArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        final GradientVectorOverlayProvider gradientVectorOverlayProvider = new GradientVectorOverlayProvider();
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.view.NBPKuiklyMapView$heatMapBuiltin$updateTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List<WeightedLatLng> B;
                int[] y16;
                float[] z17;
                TencentMap tencentMap;
                GradientVectorOverlayProvider gradientVectorOverlayProvider2 = GradientVectorOverlayProvider.this;
                B = this.B(heatMapData);
                GradientVectorOverlayProvider weightedData = gradientVectorOverlayProvider2.weightedData(B);
                y16 = this.y(heatMapData);
                z17 = this.z(heatMapData);
                GradientVectorOverlayProvider gradient = weightedData.gradient(y16, z17);
                vp4.c cVar = heatMapData.f443156c;
                gradient.setIntensityRange(cVar.f443166a, cVar.f443167b).opacity(heatMapData.f443157d).radius(com.tencent.kuikly.core.render.android.css.ktx.b.K(this.get_kuiklyRenderContext(), heatMapData.f443158e)).displayLevel(heatMapData.f443159f).setAnimateDuration(heatMapData.f443160g).setMaxHeight(heatMapData.f443162i).enable3D(heatMapData.f443161h);
                NBPKuiklyMapView nBPKuiklyMapView = this;
                tencentMap = nBPKuiklyMapView.tencentMap;
                nBPKuiklyMapView.currentHeatMapOverlay = tencentMap != null ? tencentMap.addVectorOverlay(GradientVectorOverlayProvider.this) : null;
            }
        };
        if (this.tencentMap == null) {
            this.updateHeatMapPendingTask = function0;
        } else {
            function0.invoke();
        }
    }

    private final void E(final vp4.a heatMapData) {
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.view.NBPKuiklyMapView$heatMapCustom$updateTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.d dVar;
                dVar = NBPKuiklyMapView.this.customHeatMapRenderer;
                if (dVar != null) {
                    dVar.m(heatMapData);
                }
            }
        };
        if (this.tencentMap == null) {
            this.updateHeatMapPendingTask = function0;
        } else {
            function0.invoke();
        }
    }

    private final void F() {
        if (this.heatMapMode == HeatMapMode.CUSTOM) {
            RenderAlgorithm renderAlgorithm = RenderAlgorithm.Convolution;
            TencentMap tencentMap = this.tencentMap;
            if (tencentMap != null) {
                this.customHeatMapRenderer = new g(tencentMap, renderAlgorithm, new Function1<Float, Integer>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.view.NBPKuiklyMapView$initHeatMap$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Float f16) {
                        return invoke(f16.floatValue());
                    }

                    @NotNull
                    public final Integer invoke(float f16) {
                        return Integer.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.z(NBPKuiklyMapView.this.get_kuiklyRenderContext(), f16));
                    }
                });
            }
        }
    }

    private final void G() {
        NearbyProMapView nearbyProMapView;
        j.c().e("NBPKuiklyMapView", "initMap");
        if (j.a().debug()) {
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
        addView(nearbyProMapView, new ViewGroup.LayoutParams(-1, -1));
        NearbyProMapView nearbyProMapView2 = this.mapView;
        if (nearbyProMapView2 != null) {
            nearbyProMapView2.setClipChildren(false);
            nearbyProMapView2.setClipToPadding(false);
        }
    }

    private final void H() {
        if (this.mapView != null) {
            return;
        }
        G();
        I();
        F();
        t();
        NearbyProMapView nearbyProMapView = this.mapView;
        if (nearbyProMapView != null) {
            nearbyProMapView.onStart();
        }
        NearbyProMapView nearbyProMapView2 = this.mapView;
        if (nearbyProMapView2 != null) {
            nearbyProMapView2.onResume();
        }
        this.hadCallStartAndResume = true;
    }

    private final void I() {
        NearbyProMapView nearbyProMapView = this.mapView;
        Intrinsics.checkNotNull(nearbyProMapView, "null cannot be cast to non-null type com.tencent.mobileqq.nearbypro.map.view.NearbyProMapView");
        TencentMap map = nearbyProMapView.getMap();
        this.tencentMap = map;
        if (map != null) {
            map.setMapStyle(this.mapStyle);
            map.addOnMapLoadedCallback(this);
            map.setOnCameraChangeListener(this);
            UiSettings uiSettings = map.getUiSettings();
            if (uiSettings != null) {
                Intrinsics.checkNotNullExpressionValue(uiSettings, "uiSettings");
                uiSettings.setTiltGesturesEnabled(false);
                uiSettings.setScaleViewEnabled(false);
                uiSettings.setRotateGesturesEnabled(false);
                uiSettings.setGestureScaleByMapCenter(true);
                uiSettings.setLogoScale(0.7f);
            }
            map.setMinZoomLevel(this.minZoomLevel);
            map.setMaxZoomLevel(this.maxZoomLevel);
            map.setOnMapClickListener(new TencentMap.OnMapClickListener() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.view.b
                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener
                public final void onMapClick(LatLng latLng) {
                    NBPKuiklyMapView.J(NBPKuiklyMapView.this, latLng);
                }
            });
            map.setOnMapPoiClickListener(new TencentMap.OnMapPoiClickListener() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.view.c
                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener
                public final void onClicked(MapPoi mapPoi) {
                    NBPKuiklyMapView.K(NBPKuiklyMapView.this, mapPoi);
                }
            });
            map.setBuilding3dEffectEnable(false);
            map.enableMultipleInfowindow(true);
            UiSettings uiSettings2 = map.getUiSettings();
            if (uiSettings2 != null) {
                uiSettings2.setLogoPositionWithMargin(1, -1, ImmersiveUtils.dpToPx(14.0f), -1, -1);
            }
        }
        Function0<Unit> function0 = this.updateCameraPendingTask;
        if (function0 != null) {
            if (function0 != null) {
                function0.invoke();
            }
            this.updateCameraPendingTask = null;
        }
        Function0<Unit> function02 = this.updateHeatMapPendingTask;
        if (function02 != null) {
            if (function02 != null) {
                function02.invoke();
            }
            this.updateHeatMapPendingTask = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(NBPKuiklyMapView this$0, LatLng latLng) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j.c().e("setOnMapClickListener", latLng.latitude + " " + latLng.longitude);
        Function1<Object, Unit> function1 = this$0.mapClick;
        if (function1 != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(HippyTKDListViewAdapter.X, Double.valueOf(latLng.longitude)), TuplesKt.to("y", Double.valueOf(latLng.latitude)));
            function1.invoke(mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(NBPKuiklyMapView this$0, MapPoi mapPoi) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j.c().e("setOnMapClickListener", "from poi " + mapPoi.getPosition().latitude + " " + mapPoi.getPosition().longitude);
        Function1<Object, Unit> function1 = this$0.mapClick;
        if (function1 != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(HippyTKDListViewAdapter.X, Double.valueOf(mapPoi.getPosition().longitude)), TuplesKt.to("y", Double.valueOf(mapPoi.getPosition().latitude)));
            function1.invoke(mapOf);
        }
    }

    private final boolean L(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.mapClick = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    private final boolean M(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.mapLoadedCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    private final boolean N(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) propValue).intValue();
        this.mapStyle = intValue;
        TencentMap tencentMap = this.tencentMap;
        if (tencentMap != null) {
            tencentMap.setMapStyle(intValue);
            return true;
        }
        return true;
    }

    private final boolean O(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Int");
        this.maxZoomLevel = ((Integer) propValue).intValue();
        NearbyProMapView nearbyProMapView = this.mapView;
        Intrinsics.checkNotNull(nearbyProMapView, "null cannot be cast to non-null type com.tencent.mobileqq.nearbypro.map.view.NearbyProMapView");
        TencentMap map = nearbyProMapView.getMap();
        if (map != null) {
            map.setMaxZoomLevel(this.maxZoomLevel);
            return true;
        }
        return true;
    }

    private final boolean P(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Int");
        this.minZoomLevel = ((Integer) propValue).intValue();
        NearbyProMapView nearbyProMapView = this.mapView;
        Intrinsics.checkNotNull(nearbyProMapView, "null cannot be cast to non-null type com.tencent.mobileqq.nearbypro.map.view.NearbyProMapView");
        TencentMap map = nearbyProMapView.getMap();
        if (map != null) {
            map.setMinZoomLevel(this.minZoomLevel);
            return true;
        }
        return true;
    }

    private final void S(String propValue, final Function1<Object, Unit> callback) {
        final boolean z16;
        CameraUpdate newLatLngZoom;
        if (propValue == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(propValue);
        JSONObject optJSONObject = jSONObject.optJSONObject("target");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        LatLng latLng = new LatLng(optJSONObject.optDouble("lat02"), optJSONObject.optDouble("lon02"));
        float optDouble = (float) jSONObject.optDouble("zoomLevel");
        boolean z17 = false;
        if (jSONObject.optInt("animate") == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        final long optLong = jSONObject.optLong("animationDuration");
        if (optDouble == -1.0f) {
            z17 = true;
        }
        if (z17) {
            newLatLngZoom = CameraUpdateFactory.newLatLng(latLng);
        } else {
            newLatLngZoom = CameraUpdateFactory.newLatLngZoom(latLng, optDouble);
        }
        final CameraUpdate cameraUpdate = newLatLngZoom;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.view.NBPKuiklyMapView$moveCamera$updateTask$1

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/view/NBPKuiklyMapView$moveCamera$updateTask$1$a", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap$CancelableCallback;", "", "onFinish", "onCancel", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes15.dex */
            public static final class a implements TencentMap.CancelableCallback {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Function1<Object, Unit> f253843a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ String f253844b;

                a(Function1<Object, Unit> function1, String str) {
                    this.f253843a = function1;
                    this.f253844b = str;
                }

                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback
                public void onCancel() {
                    Map mapOf;
                    Function1<Object, Unit> function1 = this.f253843a;
                    if (function1 != null) {
                        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(this.f253844b, 0));
                        function1.invoke(mapOf);
                    }
                }

                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback
                public void onFinish() {
                    Map mapOf;
                    Function1<Object, Unit> function1 = this.f253843a;
                    if (function1 != null) {
                        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(this.f253844b, 1));
                        function1.invoke(mapOf);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                TencentMap tencentMap;
                Map mapOf;
                TencentMap tencentMap2;
                if (z16) {
                    tencentMap2 = this.tencentMap;
                    if (tencentMap2 == null) {
                        return null;
                    }
                    tencentMap2.animateCamera(cameraUpdate, optLong, new a(callback, "finish"));
                    return Unit.INSTANCE;
                }
                tencentMap = this.tencentMap;
                if (tencentMap != null) {
                    tencentMap.moveCamera(cameraUpdate);
                }
                Function1<Object, Unit> function1 = callback;
                if (function1 == null) {
                    return null;
                }
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("finish", 1));
                function1.invoke(mapOf);
                return Unit.INSTANCE;
            }
        };
        if (this.tencentMap == null) {
            this.updateCameraPendingTask = function0;
        } else {
            function0.invoke();
        }
    }

    private final boolean T(String propValue) {
        if (this.heatMapMode != HeatMapMode.CUSTOM || propValue == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject(propValue);
        boolean optBoolean = jSONObject.optBoolean("showHeatMap", false);
        int optInt = jSONObject.optInt("renderReason", 0);
        boolean optBoolean2 = jSONObject.optBoolean(FileReaderHelper.OPEN_FILE_FROM_FORCE, false);
        boolean optBoolean3 = jSONObject.optBoolean("ignoreTransition", false);
        RenderReason a16 = RenderReason.INSTANCE.a(optInt);
        com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.d dVar = this.customHeatMapRenderer;
        if (dVar != null) {
            dVar.l(optBoolean, a16, optBoolean2, optBoolean3);
            return true;
        }
        return true;
    }

    private final void U(String propValue, final Function1<Object, Unit> callback) {
        View view;
        Map mapOf;
        Map mapOf2;
        Map mapOf3;
        if (propValue == null) {
            propValue = "{}";
        }
        int optInt = new JSONObject(propValue).optInt("imageViewTag", 0);
        if (optInt == 0) {
            j.c().d("NBPKuiklyMapView", "renderSnapshotToImageView failed, imageViewTag is 0");
            if (callback != null) {
                mapOf3 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", 0));
                callback.invoke(mapOf3);
                return;
            }
            return;
        }
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        final ImageView imageView = null;
        if (aVar != null) {
            view = aVar.b(optInt);
        } else {
            view = null;
        }
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        }
        if (imageView == null) {
            j.c().d("NBPKuiklyMapView", "renderSnapshotToImageView failed, imageView is null");
            if (callback != null) {
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", 0));
                callback.invoke(mapOf2);
                return;
            }
            return;
        }
        TencentMap tencentMap = this.tencentMap;
        if (tencentMap == null) {
            j.c().d("NBPKuiklyMapView", "renderSnapshotToImageView failed, tencentMap is null");
            if (callback != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", 0));
                callback.invoke(mapOf);
                return;
            }
            return;
        }
        tencentMap.snapshot(new TencentMap.SnapshotReadyCallback() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.view.d
            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback
            public final void onSnapshotReady(Bitmap bitmap) {
                NBPKuiklyMapView.V(imageView, callback, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(ImageView imageView, Function1 function1, Bitmap bitmap) {
        Map mapOf;
        Map mapOf2;
        try {
            imageView.setImageBitmap(bitmap);
            if (function1 != null) {
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", 1));
                function1.invoke(mapOf2);
            }
        } catch (Exception e16) {
            j.c().d("NBPKuiklyMapView", "renderSnapshotToImageView failed " + e16);
            if (function1 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", 0));
                function1.invoke(mapOf);
            }
        }
    }

    private final boolean W(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.String");
        JSONObject k06 = KRCSSViewExtensionKt.k0((String) propValue);
        float optDouble = (float) k06.optDouble(HippyTKDListViewAdapter.X, 0.5d);
        float optDouble2 = (float) k06.optDouble("y", 0.5d);
        TencentMap tencentMap = this.tencentMap;
        if (tencentMap != null) {
            tencentMap.setCameraCenterProportion(optDouble, optDouble2, false);
            return true;
        }
        return true;
    }

    private final boolean X(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) propValue).intValue();
        HeatMapMode heatMapMode = HeatMapMode.BUILTIN;
        if (intValue == heatMapMode.ordinal()) {
            this.heatMapMode = heatMapMode;
            return true;
        }
        HeatMapMode heatMapMode2 = HeatMapMode.CUSTOM;
        if (intValue == heatMapMode2.ordinal()) {
            this.heatMapMode = heatMapMode2;
            return true;
        }
        return true;
    }

    private final void t() {
        Application application;
        Activity activity = getActivity();
        if (activity != null && (application = activity.getApplication()) != null) {
            application.registerActivityLifecycleCallbacks(this.activityLifeCycleCallback);
        }
    }

    private final boolean u(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.mapCameraChanged = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    private final boolean v(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.mapCameraChangedFinish = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        if (this.mapDestroyed) {
            return;
        }
        this.mapDestroyed = true;
        VectorOverlay vectorOverlay = this.currentHeatMapOverlay;
        if (vectorOverlay != null) {
            vectorOverlay.remove();
        }
        TencentMap tencentMap = this.tencentMap;
        if (tencentMap != null) {
            tencentMap.removeOnMapLoadedCallback(this);
        }
        TencentMap tencentMap2 = this.tencentMap;
        if (tencentMap2 != null) {
            tencentMap2.setOnCameraChangeListener(null);
        }
        com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.d dVar = this.customHeatMapRenderer;
        if (dVar != null) {
            dVar.a();
        }
        this.customHeatMapRenderer = null;
        NearbyProMapView nearbyProMapView = this.mapView;
        if (nearbyProMapView != null) {
            nearbyProMapView.onDestroy();
        }
    }

    private final Map<String, Object> x(CameraPosition cameraPosition) {
        VisibleRegion visibleRegion;
        Map mapOf;
        Map mapOf2;
        Map mapOf3;
        Map mapOf4;
        Map mapOf5;
        Map<String, Object> mapOf6;
        Projection projection;
        TencentMap tencentMap = this.tencentMap;
        if (tencentMap != null && (projection = tencentMap.getProjection()) != null) {
            visibleRegion = projection.getVisibleRegion();
        } else {
            visibleRegion = null;
        }
        if (visibleRegion != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("lat02", Double.valueOf(cameraPosition.target.latitude)), TuplesKt.to("lon02", Double.valueOf(cameraPosition.target.longitude)));
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("lat02", Double.valueOf(visibleRegion.farLeft.latitude)), TuplesKt.to("lon02", Double.valueOf(visibleRegion.farLeft.longitude)));
            mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to("lat02", Double.valueOf(visibleRegion.farRight.latitude)), TuplesKt.to("lon02", Double.valueOf(visibleRegion.farRight.longitude)));
            mapOf4 = MapsKt__MapsKt.mapOf(TuplesKt.to("lat02", Double.valueOf(visibleRegion.nearLeft.latitude)), TuplesKt.to("lon02", Double.valueOf(visibleRegion.nearLeft.longitude)));
            mapOf5 = MapsKt__MapsKt.mapOf(TuplesKt.to("lon02", Double.valueOf(visibleRegion.nearRight.latitude)), TuplesKt.to("lon02", Double.valueOf(visibleRegion.nearRight.longitude)));
            mapOf6 = MapsKt__MapsKt.mapOf(TuplesKt.to("target", mapOf), TuplesKt.to("zoomLevel", Float.valueOf(cameraPosition.zoom)), TuplesKt.to("topLeftPosition", mapOf2), TuplesKt.to("topRightPosition", mapOf3), TuplesKt.to("bottomLeftPosition", mapOf4), TuplesKt.to("bottomRightPosition", mapOf5));
            return mapOf6;
        }
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] y(vp4.a heatMapData) {
        String[] strArr = heatMapData.f443155b.f443164a;
        int length = strArr.length;
        int[] iArr = new int[strArr.length];
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            Intrinsics.checkNotNullExpressionValue(str, "gradientColors[i]");
            iArr[i3] = com.tencent.kuikly.core.render.android.css.ktx.b.w(str);
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float[] z(vp4.a heatMapData) {
        String[] strArr = heatMapData.f443155b.f443165b;
        int length = strArr.length;
        float[] fArr = new float[strArr.length];
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            Intrinsics.checkNotNullExpressionValue(str, "gradientStartPoints[i]");
            fArr[i3] = Float.parseFloat(str);
        }
        return fArr;
    }

    public final boolean C(@NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        vp4.a heatMapData = vp4.a.c((byte[]) propValue);
        int i3 = b.f253841a[this.heatMapMode.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                Intrinsics.checkNotNullExpressionValue(heatMapData, "heatMapData");
                E(heatMapData);
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(heatMapData, "heatMapData");
            D(heatMapData);
        }
        return true;
    }

    public final boolean Q(int animate, @NotNull byte[] propValue) {
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        yp4.a c16 = yp4.a.c(propValue);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        vp4.d[] dVarArr = c16.f450784b;
        Intrinsics.checkNotNullExpressionValue(dVarArr, "data.bounds");
        LatLngBounds build = builder.include(A(dVarArr)).build();
        vp4.d dVar = c16.f450783a;
        CameraUpdate newLatLngBoundsWithMapCenter = CameraUpdateFactory.newLatLngBoundsWithMapCenter(build, new LatLng(dVar.f443169a, dVar.f443170b), com.tencent.kuikly.core.render.android.css.ktx.b.K(get_kuiklyRenderContext(), c16.f450785c));
        if (animate == 1) {
            TencentMap tencentMap = this.tencentMap;
            if (tencentMap != null) {
                tencentMap.animateCamera(newLatLngBoundsWithMapCenter);
            }
        } else {
            TencentMap tencentMap2 = this.tencentMap;
            if (tencentMap2 != null) {
                tencentMap2.moveCamera(newLatLngBoundsWithMapCenter);
            }
        }
        return true;
    }

    public final boolean R(int animate, @NotNull byte[] propValue) {
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        zp4.a c16 = zp4.a.c(propValue);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        vp4.d[] dVarArr = c16.f452990a;
        Intrinsics.checkNotNullExpressionValue(dVarArr, "data.bounds");
        CameraUpdate newLatLngBoundsRect = CameraUpdateFactory.newLatLngBoundsRect(builder.include(A(dVarArr)).build(), com.tencent.kuikly.core.render.android.css.ktx.b.K(get_kuiklyRenderContext(), c16.f452991b), com.tencent.kuikly.core.render.android.css.ktx.b.K(get_kuiklyRenderContext(), c16.f452992c), com.tencent.kuikly.core.render.android.css.ktx.b.K(get_kuiklyRenderContext(), c16.f452993d), com.tencent.kuikly.core.render.android.css.ktx.b.K(get_kuiklyRenderContext(), c16.f452994e));
        if (animate == 1) {
            TencentMap tencentMap = this.tencentMap;
            if (tencentMap != null) {
                tencentMap.animateCamera(newLatLngBoundsRect);
            }
        } else {
            TencentMap tencentMap2 = this.tencentMap;
            if (tencentMap2 != null) {
                tencentMap2.moveCamera(newLatLngBoundsRect);
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0010. Please report as an issue. */
    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1389202110:
                if (propKey.equals("cameraChangedFinish")) {
                    return v(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -1293057777:
                if (propKey.equals("heatMapMode")) {
                    return X(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -547073073:
                if (propKey.equals("cameraChanged")) {
                    return u(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -176699064:
                if (propKey.equals("centerOffset")) {
                    return W(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 152971660:
                if (propKey.equals("mapClick")) {
                    return L(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 168001973:
                if (propKey.equals("mapStyle")) {
                    return N(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 211566189:
                if (propKey.equals("maxZoomLevel")) {
                    return O(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 685992255:
                if (propKey.equals("minZoomLevel")) {
                    return P(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 707349633:
                if (propKey.equals("mapLoaded")) {
                    return M(propValue);
                }
                return c.a.p(this, propKey, propValue);
            default:
                return c.a.p(this, propKey, propValue);
        }
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChange(@NotNull CameraPosition cameraPosition) {
        Intrinsics.checkNotNullParameter(cameraPosition, "cameraPosition");
        Function1<Object, Unit> function1 = this.mapCameraChanged;
        if (function1 != null) {
            function1.invoke(x(cameraPosition));
        }
        com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.d dVar = this.customHeatMapRenderer;
        if (dVar != null) {
            dVar.j(cameraPosition);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChangeFinished(@NotNull CameraPosition cameraPosition) {
        Intrinsics.checkNotNullParameter(cameraPosition, "cameraPosition");
        Function1<Object, Unit> function1 = this.mapCameraChangedFinish;
        if (function1 != null) {
            function1.invoke(x(cameraPosition));
        }
        com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.d dVar = this.customHeatMapRenderer;
        if (dVar != null) {
            dVar.k(cameraPosition);
        }
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        Application application;
        c.a.k(this);
        Activity activity = getActivity();
        if (activity != null && (application = activity.getApplication()) != null) {
            application.unregisterActivityLifecycleCallbacks(this.activityLifeCycleCallback);
        }
        w();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (getWidth() != 0) {
            getHeight();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Map emptyMap;
        Function1<Object, Unit> function1 = this.mapLoadedCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -2056254890) {
            if (hashCode != -95364394) {
                if (hashCode == 1277767819 && method.equals("renderSnapshotToImageView")) {
                    U(params, callback);
                    return Unit.INSTANCE;
                }
            } else if (method.equals("renderHeatMap")) {
                return Boolean.valueOf(T(params));
            }
        } else if (method.equals("moveCamera")) {
            S(params, callback);
            return Unit.INSTANCE;
        }
        return c.a.b(this, method, params, callback);
    }
}
