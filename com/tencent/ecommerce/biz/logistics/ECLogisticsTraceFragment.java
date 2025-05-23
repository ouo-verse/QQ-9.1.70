package com.tencent.ecommerce.biz.logistics;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.logistics.ECLogisticsTraceAdapter;
import com.tencent.ecommerce.biz.orders.common.Coordinate;
import com.tencent.ecommerce.biz.orders.common.LogisticsInfo;
import com.tencent.ecommerce.biz.orders.common.LogisticsTraceItem;
import com.tencent.ecommerce.biz.orders.common.TrailStatus;
import com.tencent.ecommerce.biz.util.ECViewUtilKt;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.IEmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001O\u0018\u0000 U2\u00020\u0001:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J \u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u0006H\u0002J\b\u0010%\u001a\u00020\u0006H\u0002R\u0014\u0010(\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00102R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010J\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "resId", "", "widthDp", "heightDp", "Lcom/tencent/tencentmap/mapsdk/maps/model/BitmapDescriptor;", "gi", "ei", "initView", "fi", "Lcom/tencent/ecommerce/biz/orders/common/e;", "info", "bi", "Lcom/tencent/lbssearch/object/result/DrivingResultObject;", "drivingResultObject", "ai", "hi", WidgetCacheLunarData.JI, "ii", "di", "P", UserInfo.SEX_FEMALE, "MAP_LINE_WIDTH", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateCenterView", "Lcom/tencent/tencentmap/mapsdk/maps/MapView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/tencentmap/mapsdk/maps/MapView;", "mapView", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "mapErrorLayout", "Landroid/widget/LinearLayout;", "T", "Landroid/widget/LinearLayout;", "mapLoadingLayout", "U", "mapLoadingIconView", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "V", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR, "Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceViewModel;", "W", "Lkotlin/Lazy;", "ci", "()Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceViewModel;", "viewModel", "X", "Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Y", "logisticsCode", "Z", "hideMapView", "Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceAdapter;", "a0", "Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceAdapter;", "adapter", "com/tencent/ecommerce/biz/logistics/ECLogisticsTraceFragment$i", "b0", "Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceFragment$i;", "mapInfoWindowAdapter", "<init>", "()V", "c0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLogisticsTraceFragment extends ECBaseFragment {

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private final float MAP_LINE_WIDTH = com.tencent.ecommerce.biz.util.e.c(4.0f);

    /* renamed from: Q, reason: from kotlin metadata */
    private ECStateCenterView stateCenterView;

    /* renamed from: R, reason: from kotlin metadata */
    private MapView mapView;

    /* renamed from: S, reason: from kotlin metadata */
    private View mapErrorLayout;

    /* renamed from: T, reason: from kotlin metadata */
    private LinearLayout mapLoadingLayout;

    /* renamed from: U, reason: from kotlin metadata */
    private View mapLoadingIconView;

    /* renamed from: V, reason: from kotlin metadata */
    private BottomSheetBehavior<View> behavior;

    /* renamed from: W, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: X, reason: from kotlin metadata */
    private String orderId;

    /* renamed from: Y, reason: from kotlin metadata */
    private String logisticsCode;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean hideMapView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final ECLogisticsTraceAdapter adapter;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final i mapInfoWindowAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceFragment$a;", "", "Landroid/content/Context;", "context", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "logisticsCode", "", "a", "LOGISTICS_CODE", "Ljava/lang/String;", "", "MAP_LINE_ANIMATION_TIME_MS", "J", "ORDER_ID", "TAG", "", "TITLE_HEIGHT_DP", UserInfo.SEX_FEMALE, "", "WEB_VIEW_HEIGHT_DP", "I", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.logistics.ECLogisticsTraceFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(Context context, String orderId, String logisticsCode) {
            Bundle bundle = new Bundle();
            bundle.putString("order_id", orderId);
            bundle.putString("logistics_code", logisticsCode);
            yi0.a.q(context, ECLogisticsTraceFragment.class, bundle, 0, null, 24, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/logistics/ECLogisticsTraceFragment$b", "Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceAdapter$ActionListener;", "", "phone", "", "makePhoneCall", "label", "text", "copyToClipboard", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements ECLogisticsTraceAdapter.ActionListener {
        b() {
        }

        @Override // com.tencent.ecommerce.biz.logistics.ECLogisticsTraceAdapter.ActionListener
        public void copyToClipboard(String label, String text) {
            Object systemService = ECLogisticsTraceFragment.this.requireActivity().getSystemService("clipboard");
            if (systemService != null) {
                ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText(label, text));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
        }

        @Override // com.tencent.ecommerce.biz.logistics.ECLogisticsTraceAdapter.ActionListener
        public void makePhoneCall(String phone) {
            if (phone.length() == 0) {
                com.tencent.ecommerce.base.ui.i.e(com.tencent.ecommerce.base.ui.i.f101155b, R.string.wok, null, 0, 6, null);
                return;
            }
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + phone));
            intent.setFlags(268435456);
            ECLogisticsTraceFragment.this.requireActivity().startActivity(intent);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/logistics/ECLogisticsTraceFragment$initView$2$1", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f extends BottomSheetBehavior.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f102849b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ECLogisticsTraceFragment f102850c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f102851d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f102852e;

        f(BottomSheetBehavior bottomSheetBehavior, ECLogisticsTraceFragment eCLogisticsTraceFragment, View view, View view2) {
            this.f102849b = bottomSheetBehavior;
            this.f102850c = eCLogisticsTraceFragment;
            this.f102851d = view;
            this.f102852e = view2;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(View bottomSheet, float slideOffset) {
            this.f102851d.setAlpha(slideOffset);
            this.f102852e.setAlpha(slideOffset);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(View bottomSheet, int newState) {
            if (!this.f102850c.hideMapView || newState == 3) {
                return;
            }
            this.f102849b.setState(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/logistics/ECLogisticsTraceFragment$initView$1$4"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f102854e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f102855f;

        g(View view, View view2) {
            this.f102854e = view;
            this.f102855f = view2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECLogisticsTraceFragment.this.ii();
            ECLogisticsTraceFragment.this.ci().T1();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/logistics/ECLogisticsTraceFragment$initView$1$6$1", "com/tencent/ecommerce/biz/logistics/ECLogisticsTraceFragment$$special$$inlined$apply$lambda$2"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f102857e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f102858f;

        h(View view, View view2) {
            this.f102857e = view;
            this.f102858f = view2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECLogisticsTraceFragment.this.requireActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/ecommerce/biz/logistics/ECLogisticsTraceFragment$i", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap$InfoWindowAdapter;", "Lcom/tencent/tencentmap/mapsdk/maps/model/Marker;", "marker", "Landroid/view/View;", "getInfoWindow", "p0", "getInfoContents", "view", "", "a", "", "d", "Ljava/util/Map;", "markerToView", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i implements TencentMap.InfoWindowAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final Map<Marker, View> markerToView = new LinkedHashMap();

        i() {
        }

        public final void a(Marker marker, View view) {
            this.markerToView.put(marker, view);
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter
        public View getInfoContents(Marker p06) {
            return null;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter
        public View getInfoWindow(Marker marker) {
            return this.markerToView.get(marker);
        }
    }

    public ECLogisticsTraceFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.logistics.ECLogisticsTraceFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECLogisticsTraceViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.logistics.ECLogisticsTraceFragment$$special$$inlined$viewModels$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).get_viewModelStore();
                Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.orderId = "";
        this.logisticsCode = "";
        this.hideMapView = true;
        this.adapter = new ECLogisticsTraceAdapter(new b());
        this.mapInfoWindowAdapter = new i();
    }

    public static final /* synthetic */ BottomSheetBehavior Oh(ECLogisticsTraceFragment eCLogisticsTraceFragment) {
        BottomSheetBehavior<View> bottomSheetBehavior = eCLogisticsTraceFragment.behavior;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR);
        }
        return bottomSheetBehavior;
    }

    public static final /* synthetic */ MapView Sh(ECLogisticsTraceFragment eCLogisticsTraceFragment) {
        MapView mapView = eCLogisticsTraceFragment.mapView;
        if (mapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        return mapView;
    }

    public static final /* synthetic */ ECStateCenterView Uh(ECLogisticsTraceFragment eCLogisticsTraceFragment) {
        ECStateCenterView eCStateCenterView = eCLogisticsTraceFragment.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        return eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(LogisticsInfo info, DrivingResultObject drivingResultObject) {
        Object first;
        Object last;
        Object first2;
        List<LatLng> list = drivingResultObject.result.routes.get(0).polyline;
        int O1 = ci().O1(info, drivingResultObject);
        cg0.a.b("ECLogisticsDetailFragment", "carIndex:" + O1 + ",size:" + list.size());
        PolylineOptions polylineOptions = new PolylineOptions();
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) info.e());
        polylineOptions.add(com.tencent.ecommerce.biz.orders.common.f.b((Coordinate) first), new LatLng[0]);
        polylineOptions.addAll(list);
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) info.e());
        polylineOptions.add(com.tencent.ecommerce.biz.orders.common.f.b((Coordinate) last), new LatLng[0]);
        polylineOptions.colors(new int[]{ResourcesCompat.getColor(getResources(), R.color.f6170u, null), ResourcesCompat.getColor(getResources(), R.color.f6331_, null)}, new int[]{0, O1 + 2});
        polylineOptions.width(this.MAP_LINE_WIDTH);
        polylineOptions.lineCap(true);
        MapView mapView = this.mapView;
        if (mapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        Polyline addPolyline = mapView.getMap().addPolyline(polylineOptions);
        MapView mapView2 = this.mapView;
        if (mapView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        TencentMapContext mapContext = mapView2.getMap().getMapContext();
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) addPolyline.getPoints());
        IEmergeAnimation createEmergeAnimation = mapContext.createEmergeAnimation((LatLng) first2);
        createEmergeAnimation.setDuration(1000L);
        createEmergeAnimation.setInterpolator(new DecelerateInterpolator());
        createEmergeAnimation.setAnimationListener(new c(info, list, O1));
        addPolyline.startAnimation(createEmergeAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi(LogisticsInfo info) {
        Object first;
        Object last;
        View g16;
        View f16;
        List<LatLng> listOf;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) info.e());
        Coordinate coordinate = (Coordinate) first;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) info.e());
        Coordinate coordinate2 = (Coordinate) last;
        LatLng b16 = com.tencent.ecommerce.biz.orders.common.f.b(coordinate);
        LatLng b17 = com.tencent.ecommerce.biz.orders.common.f.b(coordinate2);
        MapView mapView = this.mapView;
        if (mapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        TencentMap map = mapView.getMap();
        MarkerOptions anchor = new MarkerOptions(b16).anchor(0.5f, 0.5f);
        int i3 = R.drawable.di_;
        Marker addMarker = map.addMarker(anchor.icon(BitmapDescriptorFactory.fromResource(R.drawable.di_)));
        addMarker.setInfoWindowEnable(true);
        MapView mapView2 = this.mapView;
        if (mapView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        TencentMap map2 = mapView2.getMap();
        MarkerOptions anchor2 = new MarkerOptions(b17).anchor(0.5f, 0.5f);
        TrailStatus trailStatus = info.currentStatus.status;
        if (trailStatus != TrailStatus.SIGNED && trailStatus != TrailStatus.WAITING_RECEIVE) {
            i3 = R.drawable.dia;
        }
        Marker addMarker2 = map2.addMarker(anchor2.icon(BitmapDescriptorFactory.fromResource(i3)));
        addMarker2.setInfoWindowEnable(true);
        i iVar = this.mapInfoWindowAdapter;
        g16 = k.g(requireContext(), coordinate, info);
        iVar.a(addMarker, g16);
        i iVar2 = this.mapInfoWindowAdapter;
        f16 = k.f(requireContext(), coordinate2, info);
        iVar2.a(addMarker2, f16);
        addMarker.showInfoWindow();
        addMarker2.showInfoWindow();
        MapView mapView3 = this.mapView;
        if (mapView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        TencentMap map3 = mapView3.getMap();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new LatLng[]{b16, b17});
        map3.moveCamera(CameraUpdateFactory.newLatLngBoundsRect(builder.include(listOf).build(), com.tencent.ecommerce.biz.util.e.c(50.0f), com.tencent.ecommerce.biz.util.e.c(50.0f), com.tencent.ecommerce.biz.util.e.c(85.0f), com.tencent.ecommerce.biz.util.e.c(50.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECLogisticsTraceViewModel ci() {
        return (ECLogisticsTraceViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void di() {
        View view = this.mapErrorLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapErrorLayout");
        }
        view.setVisibility(8);
        LinearLayout linearLayout = this.mapLoadingLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapLoadingLayout");
        }
        linearLayout.setVisibility(8);
        ji();
    }

    private final void ei() {
        String str;
        String string;
        Bundle arguments = getArguments();
        String str2 = "";
        if (arguments == null || (str = arguments.getString("order_id")) == null) {
            str = "";
        }
        this.orderId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString("logistics_code")) != null) {
            str2 = string;
        }
        this.logisticsCode = str2;
    }

    private final void fi() {
        ci().R1().observe(getViewLifecycleOwner(), new d());
        ci().Q1().observe(getViewLifecycleOwner(), new e());
        ECStateCenterView eCStateCenterView = this.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        IStateCenterView.a.c(eCStateCenterView, null, 1, null);
        ci().U1(this.orderId, this.logisticsCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi() {
        View view = this.mapErrorLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapErrorLayout");
        }
        view.setVisibility(0);
        LinearLayout linearLayout = this.mapLoadingLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapLoadingLayout");
        }
        linearLayout.setVisibility(8);
        ji();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ii() {
        LinearLayout linearLayout = this.mapLoadingLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapLoadingLayout");
        }
        linearLayout.setVisibility(0);
        View view = this.mapLoadingIconView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapLoadingIconView");
        }
        if (view instanceof PAGView) {
            View view2 = this.mapLoadingIconView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mapLoadingIconView");
            }
            if (view2 != null) {
                ((PAGView) view2).play();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type org.libpag.PAGView");
            }
        } else {
            View view3 = this.mapLoadingIconView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mapLoadingIconView");
            }
            if (view3 instanceof ImageView) {
                View view4 = this.mapLoadingIconView;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mapLoadingIconView");
                }
                ECViewUtilKt.c(view4);
            }
        }
        View view5 = this.mapErrorLayout;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapErrorLayout");
        }
        view5.setVisibility(8);
    }

    private final void ji() {
        View view = this.mapLoadingIconView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapLoadingIconView");
        }
        if (view instanceof PAGView) {
            View view2 = this.mapLoadingIconView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mapLoadingIconView");
            }
            if (view2 != null) {
                ((PAGView) view2).stop();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.libpag.PAGView");
        }
        View view3 = this.mapLoadingIconView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapLoadingIconView");
        }
        if (view3 instanceof ImageView) {
            View view4 = this.mapLoadingIconView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mapLoadingIconView");
            }
            view4.clearAnimation();
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECLogisticsDetailFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.f167340cs3;
    }

    public final BitmapDescriptor gi(int resId, float widthDp, float heightDp) {
        return BitmapDescriptorFactory.fromBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), resId), com.tencent.ecommerce.biz.util.e.c(widthDp), com.tencent.ecommerce.biz.util.e.c(heightDp), false));
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MapView mapView = this.mapView;
        if (mapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        mapView.onDestroy();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        MapView mapView = this.mapView;
        if (mapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        mapView.onPause();
        super.onPause();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MapView mapView = this.mapView;
        if (mapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        mapView.onResume();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        MapView mapView = this.mapView;
        if (mapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        mapView.onStart();
        super.onStart();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MapView mapView = this.mapView;
        if (mapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        mapView.onStop();
        super.onStop();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TencentMapInitializer.setAgreePrivacy(true);
        ei();
        initView(view);
        fi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/lbssearch/object/result/DrivingResultObject;", "it", "", "a", "(Lcom/tencent/lbssearch/object/result/DrivingResultObject;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<DrivingResultObject> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(DrivingResultObject drivingResultObject) {
            if (drivingResultObject == null) {
                ECLogisticsTraceFragment.this.hi();
                return;
            }
            ECLogisticsTraceFragment.this.di();
            LogisticsInfo value = ECLogisticsTraceFragment.this.ci().R1().getValue();
            if (value != null) {
                ECLogisticsTraceFragment.this.ai(value, drivingResultObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/e;", "kotlin.jvm.PlatformType", "logisticsInfo", "", "a", "(Lcom/tencent/ecommerce/biz/orders/common/e;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d<T> implements Observer<LogisticsInfo> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(LogisticsInfo logisticsInfo) {
            boolean z16;
            if (logisticsInfo != null) {
                logisticsInfo.channel = ug0.b.f438933d.e();
                ECLogisticsTraceFragment.Uh(ECLogisticsTraceFragment.this).setSucceededState();
                if ((!logisticsInfo.e().isEmpty()) && (!logisticsInfo.c().isEmpty())) {
                    List<LogisticsTraceItem> f16 = logisticsInfo.f();
                    if (!(f16 instanceof Collection) || !f16.isEmpty()) {
                        Iterator<T> it = f16.iterator();
                        while (it.hasNext()) {
                            if (((LogisticsTraceItem) it.next()).status == TrailStatus.PICKED_UP) {
                                z16 = true;
                                break;
                            }
                        }
                    }
                    z16 = false;
                    if (z16) {
                        ECLogisticsTraceFragment.this.hideMapView = false;
                        ECLogisticsTraceFragment.Oh(ECLogisticsTraceFragment.this).setState(4);
                        ECLogisticsTraceFragment.Sh(ECLogisticsTraceFragment.this).setVisibility(0);
                        ECLogisticsTraceFragment.this.bi(logisticsInfo);
                        ECLogisticsTraceFragment.this.ci().T1();
                        ECLogisticsTraceFragment.this.adapter.k0(logisticsInfo);
                        return;
                    }
                }
                ECLogisticsTraceFragment.Sh(ECLogisticsTraceFragment.this).setVisibility(8);
                ECLogisticsTraceFragment.this.hideMapView = true;
                ECLogisticsTraceFragment.Oh(ECLogisticsTraceFragment.this).setState(3);
                ECLogisticsTraceFragment.Oh(ECLogisticsTraceFragment.this).setPeekHeight(com.tencent.ecommerce.biz.util.e.c(PTSDeviceUtil.getScreenHeightDp()));
                ECLogisticsTraceFragment.this.adapter.k0(logisticsInfo);
                return;
            }
            IStateCenterView.a.b(ECLogisticsTraceFragment.Uh(ECLogisticsTraceFragment.this), null, 1, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView(View view) {
        ImageView imageView;
        final ECStateCenterView eCStateCenterView = (ECStateCenterView) view.findViewById(R.id.oaz);
        final View view2 = null;
        eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.logistics.ECLogisticsTraceFragment$initView$$inlined$with$lambda$1
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
                String str;
                String str2;
                IStateCenterView.a.c(ECStateCenterView.this, null, 1, null);
                ECLogisticsTraceViewModel ci5 = this.ci();
                str = this.orderId;
                str2 = this.logisticsCode;
                ci5.U1(str, str2);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.stateCenterView = eCStateCenterView;
        MapView mapView = (MapView) view.findViewById(R.id.o48);
        mapView.setOnTop(true);
        mapView.getMap().setMapType(1000);
        mapView.getMap().getUiSettings().setRotateGesturesEnabled(false);
        mapView.getMap().setInfoWindowAdapter(this.mapInfoWindowAdapter);
        mapView.getMap().enableMultipleInfowindow(true);
        this.mapView = mapView;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.o3t);
        if (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPagSoLoader().loadPagSo()) {
            PAGView pAGView = new PAGView(linearLayout.getContext());
            pAGView.setPath("assets://pag/qecommerce_skin_loading_img_sangedian.pag");
            pAGView.setRepeatCount(-1);
            imageView = pAGView;
        } else {
            ImageView imageView2 = new ImageView(linearLayout.getContext());
            imageView2.setBackgroundResource(R.drawable.di9);
            imageView = imageView2;
        }
        this.mapLoadingIconView = imageView;
        linearLayout.addView(imageView, 0, new LinearLayout.LayoutParams(com.tencent.ecommerce.biz.util.e.c(25.0f), com.tencent.ecommerce.biz.util.e.c(25.0f)));
        this.mapLoadingLayout = linearLayout;
        this.mapErrorLayout = view.findViewById(R.id.o3u);
        view.findViewById(R.id.o49).setOnClickListener(new g(null, null));
        View findViewById = view.findViewById(R.id.ock);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        int c16 = com.tencent.ecommerce.biz.util.e.c(36.0f);
        com.tencent.ecommerce.biz.util.r rVar = com.tencent.ecommerce.biz.util.r.f104881b;
        layoutParams.height = c16 + rVar.a(requireActivity());
        View findViewById2 = view.findViewById(R.id.ocd);
        view.findViewById(R.id.nqb).setOnClickListener(new h(findViewById, findViewById2));
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.o8n);
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(new l());
        BottomSheetBehavior<View> from = BottomSheetBehavior.from(view.findViewById(R.id.o3v));
        from.setState(3);
        from.setPeekHeight(com.tencent.ecommerce.biz.util.e.c(PTSDeviceUtil.getScreenHeightDp() - 331) + rVar.a(requireActivity()));
        from.addBottomSheetCallback(new f(from, this, findViewById, findViewById2));
        this.behavior = from;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/ecommerce/biz/logistics/ECLogisticsTraceFragment$c", "Lcom/tencent/tencentmap/mapsdk/maps/model/AnimationListener;", "", "onAnimationStart", "onAnimationEnd", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements AnimationListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LogisticsInfo f102844b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f102845c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f102846d;

        c(LogisticsInfo logisticsInfo, List list, int i3) {
            this.f102844b = logisticsInfo;
            this.f102845c = list;
            this.f102846d = i3;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.AnimationListener
        public void onAnimationEnd() {
            float P1;
            View e16;
            TrailStatus trailStatus = this.f102844b.currentStatus.status;
            if (trailStatus == TrailStatus.ON_THE_WAY || trailStatus == TrailStatus.WRONG) {
                if (this.f102846d + 1 >= this.f102845c.size()) {
                    List list = this.f102845c;
                    P1 = ((LatLng) list.get(list.size() - 1)).longitude - ((LatLng) this.f102845c.get(0)).longitude > ((double) 0) ? 180.0f : 0.0f;
                } else {
                    P1 = ECLogisticsTraceFragment.this.ci().P1((LatLng) this.f102845c.get(this.f102846d), (LatLng) this.f102845c.get(this.f102846d + 1));
                }
                Marker addMarker = ECLogisticsTraceFragment.Sh(ECLogisticsTraceFragment.this).getMap().addMarker(new MarkerOptions((LatLng) this.f102845c.get(this.f102846d)).anchor(0.5f, 0.5f).icon(ECLogisticsTraceFragment.this.gi(R.drawable.dxz, 50.0f, 25.0f)).rotation(P1));
                addMarker.setInfoWindowEnable(true);
                if (this.f102844b.estimatedDeliveryTime.length() == 0) {
                    return;
                }
                i iVar = ECLogisticsTraceFragment.this.mapInfoWindowAdapter;
                e16 = k.e(ECLogisticsTraceFragment.this.requireContext(), this.f102844b);
                iVar.a(addMarker, e16);
                addMarker.showInfoWindow();
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.AnimationListener
        public void onAnimationStart() {
        }
    }
}
