package com.tencent.ecommerce.biz.detail.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cg0.a;
import ck0.Product;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.component.ECBaseRecyclerView;
import com.tencent.ecommerce.biz.detail.ui.ECShopDetailItemDecoration;
import com.tencent.ecommerce.biz.detail.utils.ECDetailPageDuration;
import com.tencent.ecommerce.biz.detail.utils.ECSourceFrom;
import com.tencent.ecommerce.biz.detail.viewmodel.saas.ECDetailPageHostViewModel;
import com.tencent.ecommerce.biz.detail.viewmodel.saas.b;
import com.tencent.ecommerce.biz.shophome.util.ECShopReportCouponParams;
import com.tencent.ecommerce.biz.showwindow.viewmodel.ECGlobalShowWindowViewModel;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;
import org.json.JSONObject;
import ri0.ECAddProductToWindowEvent;
import zi0.ECForegroundEvent;

@Metadata(d1 = {"\u0000\u00a5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\u0003|\u0080\u0001\u0018\u0000 \u0086\u00012\u00020\u0001:\u0002\u0087\u0001B\t\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000bJ\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0003J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0002R\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010LR\u0018\u0010U\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010PR\u0016\u0010W\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010DR\u0016\u0010Z\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010YR\u0016\u0010^\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010YR\u0016\u0010`\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010YR\u0016\u0010b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010YR\u0016\u0010d\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010YR\u0016\u0010f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010YR\u0016\u0010h\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010YR\u0016\u0010j\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010YR\u0016\u0010l\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010YR\u0016\u0010n\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010YR\u001b\u0010s\u001a\u00020o8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bp\u0010!\u001a\u0004\bq\u0010rR\u0018\u0010w\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010{\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010\u007f\u001a\u00020|8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/fragment/ECDetailHostPageFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "isAdded", "mediaProductId", "pi", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "ii", "mi", "initArguments", "qi", "oi", "ri", "ni", "si", "Lcom/tencent/ecommerce/biz/detail/viewmodel/saas/ECDetailPageHostViewModel;", "P", "Lkotlin/Lazy;", WidgetCacheLunarData.JI, "()Lcom/tencent/ecommerce/biz/detail/viewmodel/saas/ECDetailPageHostViewModel;", "ecDetailHostViewModel", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECGlobalShowWindowViewModel;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "ki", "()Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECGlobalShowWindowViewModel;", "ecGlobalShowWindowViewModel", BdhLogUtil.LogTag.Tag_Req, "Landroid/view/View;", "titleBar", ExifInterface.LATITUDE_SOUTH, "titleBarBackground", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "T", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "detailPageRecyclerView", "Lcom/tencent/ecommerce/biz/detail/ui/b;", "U", "Lcom/tencent/ecommerce/biz/detail/ui/b;", "ecBaseRecyclerViewAdapter", "Landroid/widget/ImageView;", "V", "Landroid/widget/ImageView;", "backButton", "Landroid/widget/Button;", "W", "Landroid/widget/Button;", "addToGoodsCenterButton", "Landroid/widget/FrameLayout;", "X", "Landroid/widget/FrameLayout;", "ecommerceContainer", "Y", "I", "scrollY", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Z", "Ljava/util/concurrent/atomic/AtomicBoolean;", "showGuidanceDialog", "Ljava/util/Timer;", "a0", "Ljava/util/Timer;", "activityStartTimer", "Ljava/util/TimerTask;", "b0", "Ljava/util/TimerTask;", "activityStartTimerTask", "c0", "activityEndTimer", "d0", "activityEndTimerTask", "e0", WadlProxyConsts.CHANNEL, "f0", "Ljava/lang/String;", "saasType", "g0", "saasProductId", "h0", "mediaId", "i0", "mediaProductID", "j0", "categoryName", "k0", "goodsType", "l0", "categoryId", "m0", "sealTransfer", "n0", GetAdInfoRequest.SOURCE_FROM, "o0", "roomId", "p0", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "Lkotlinx/coroutines/CoroutineScope;", "q0", "li", "()Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope", "Lcom/tencent/ecommerce/biz/detail/utils/b;", "r0", "Lcom/tencent/ecommerce/biz/detail/utils/b;", "detailPageDurationReport", "Lcom/tencent/ecommerce/biz/detail/utils/c;", "s0", "Lcom/tencent/ecommerce/biz/detail/utils/c;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "com/tencent/ecommerce/biz/detail/fragment/ECDetailHostPageFragment$b", "t0", "Lcom/tencent/ecommerce/biz/detail/fragment/ECDetailHostPageFragment$b;", "addProductEventObserver", "com/tencent/ecommerce/biz/detail/fragment/ECDetailHostPageFragment$f", "u0", "Lcom/tencent/ecommerce/biz/detail/fragment/ECDetailHostPageFragment$f;", "observer", "<init>", "()V", "v0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECDetailHostPageFragment extends ECBaseFragment {

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy ecDetailHostViewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy ecGlobalShowWindowViewModel;

    /* renamed from: R, reason: from kotlin metadata */
    private View titleBar;

    /* renamed from: S, reason: from kotlin metadata */
    private View titleBarBackground;

    /* renamed from: T, reason: from kotlin metadata */
    private ECBaseRecyclerView detailPageRecyclerView;

    /* renamed from: U, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.ui.b ecBaseRecyclerViewAdapter;

    /* renamed from: V, reason: from kotlin metadata */
    private ImageView backButton;

    /* renamed from: W, reason: from kotlin metadata */
    private Button addToGoodsCenterButton;

    /* renamed from: X, reason: from kotlin metadata */
    private FrameLayout ecommerceContainer;

    /* renamed from: Y, reason: from kotlin metadata */
    private int scrollY;

    /* renamed from: Z, reason: from kotlin metadata */
    private AtomicBoolean showGuidanceDialog;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private Timer activityStartTimer;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private TimerTask activityStartTimerTask;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private Timer activityEndTimer;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private TimerTask activityEndTimerTask;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private int channel;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private String saasType;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private String saasProductId;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private String mediaId;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private String mediaProductID;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private String categoryName;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private String goodsType;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private String categoryId;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private String sealTransfer;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private String sourceFrom;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private String roomId;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private String requestId;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private final Lazy lifecycleScope;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.utils.b detailPageDurationReport;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.utils.c reportParams;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private final b addProductEventObserver;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private final f observer;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/fragment/ECDetailHostPageFragment$a;", "", "Landroid/widget/Button;", "button", "", "colourStr", "", "a", "", "SCROLL_OFFSET_MAX", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.detail.fragment.ECDetailHostPageFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(Button button, String colourStr) {
            int width = button.getWidth();
            int height = button.getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            float c16 = com.tencent.ecommerce.biz.util.e.c(5.3f);
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{c16, c16, c16, c16, c16, c16, c16, c16}, null, null));
            float f16 = width;
            float f17 = height;
            shapeDrawable.getPaint().setShader(com.tencent.ecommerce.richtext.utils.c.v(colourStr, f16, f17));
            button.setBackground(shapeDrawable);
            a.b("setButtonGradientColour", "[setButtonGradientColour] width = " + f16 + ", height = " + f17 + ", colourStr = " + colourStr);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECDetailHostPageFragment$b", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lri0/a;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements EventObserver<ECAddProductToWindowEvent> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECAddProductToWindowEvent event) {
            ECDetailHostPageFragment.this.si(event.isAdded);
            ECDetailHostPageFragment.this.pi(event.isAdded, event.mediaProductId);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECDetailHostPageFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            ECDetailHostPageFragment.this.scrollY += dy5;
            ECDetailHostPageFragment.this.ji().l2(ECDetailHostPageFragment.this.scrollY);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FragmentActivity activity = ECDetailHostPageFragment.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            JSONObject jSONObject;
            EventCollector.getInstance().onViewClickedBefore(view);
            ECGlobalShowWindowViewModel ki5 = ECDetailHostPageFragment.this.ki();
            Context requireContext = ECDetailHostPageFragment.this.requireContext();
            String str = ECDetailHostPageFragment.this.saasType;
            String str2 = ECDetailHostPageFragment.this.saasProductId;
            String str3 = ECDetailHostPageFragment.this.goodsType;
            Product value = ECDetailHostPageFragment.this.ji().b2().getValue();
            if (value == null || (jSONObject = value.getDataJson()) == null) {
                jSONObject = new JSONObject();
            }
            ki5.N1(requireContext, str, str2, str3, jSONObject);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECDetailHostPageFragment$f", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lzi0/a;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements EventObserver<ECForegroundEvent> {
        f() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECForegroundEvent event) {
            boolean z16 = event.isForeground;
            if (z16) {
                ECDetailHostPageFragment eCDetailHostPageFragment = ECDetailHostPageFragment.this;
                eCDetailHostPageFragment.detailPageDurationReport = new com.tencent.ecommerce.biz.detail.utils.b(eCDetailHostPageFragment.sourceFrom);
                com.tencent.ecommerce.biz.detail.utils.b bVar = ECDetailHostPageFragment.this.detailPageDurationReport;
                if (bVar != null) {
                    bVar.d();
                }
                ECDetailHostPageFragment.this.ri();
                return;
            }
            if (z16) {
                return;
            }
            com.tencent.ecommerce.biz.detail.utils.b bVar2 = ECDetailHostPageFragment.this.detailPageDurationReport;
            if (bVar2 != null) {
                com.tencent.ecommerce.biz.detail.utils.b.c(bVar2, null, 1, null);
            }
            com.tencent.ecommerce.biz.detail.utils.b bVar3 = ECDetailHostPageFragment.this.detailPageDurationReport;
            if (bVar3 != null) {
                bVar3.f();
            }
            ECDetailHostPageFragment.this.detailPageDurationReport = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/base/ui/b;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g<T> implements Observer<List<? extends ECBasePtsViewData>> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<ECBasePtsViewData> list) {
            ECDetailHostPageFragment.Qh(ECDetailHostPageFragment.this).setData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h<T> implements Observer<Integer> {

        /* renamed from: d, reason: collision with root package name */
        public static final h f102088d = new h();

        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            if (num.intValue() < 530) {
                num.intValue();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i<T> implements Observer<Boolean> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECDetailHostPageFragment.this.si(bool.booleanValue());
        }
    }

    public ECDetailHostPageFragment() {
        Lazy lazy;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailHostPageFragment$ecDetailHostViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return new b(ECDetailHostPageFragment.this.getArguments());
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailHostPageFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.ecDetailHostViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECDetailPageHostViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailHostPageFragment$$special$$inlined$viewModels$2
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
        }, function0);
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailHostPageFragment$$special$$inlined$viewModels$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.ecGlobalShowWindowViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECGlobalShowWindowViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailHostPageFragment$$special$$inlined$viewModels$4
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
        this.showGuidanceDialog = new AtomicBoolean(false);
        this.saasType = "";
        this.saasProductId = "";
        this.mediaId = "";
        this.mediaProductID = "";
        this.categoryName = "";
        this.goodsType = "";
        this.categoryId = "";
        this.sealTransfer = "";
        this.sourceFrom = String.valueOf(ECSourceFrom.SOURCE_FROM_UNKNOWN.ordinal());
        this.roomId = "";
        this.requestId = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailHostPageFragment$lifecycleScope$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.MainScope();
            }
        });
        this.lifecycleScope = lazy;
        this.addProductEventObserver = new b();
        this.observer = new f();
    }

    public static final /* synthetic */ com.tencent.ecommerce.biz.detail.ui.b Qh(ECDetailHostPageFragment eCDetailHostPageFragment) {
        com.tencent.ecommerce.biz.detail.ui.b bVar = eCDetailHostPageFragment.ecBaseRecyclerViewAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        return bVar;
    }

    private final void ii(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i3 = layoutParams.height;
        r rVar = r.f104881b;
        layoutParams.height = i3 + rVar.a(getActivity());
        view.setLayoutParams(layoutParams);
        view.setPadding(view.getPaddingLeft(), rVar.a(getActivity()), view.getPaddingRight(), view.getPaddingBottom());
    }

    private final void initArguments() {
        int ordinal;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String valueOf;
        String str9;
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        Intent intent5;
        Intent intent6;
        Intent intent7;
        Intent intent8;
        Intent intent9;
        Intent intent10;
        Intent intent11;
        String stringExtra;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent11 = activity.getIntent()) != null && (stringExtra = intent11.getStringExtra(WadlProxyConsts.CHANNEL)) != null) {
            ordinal = Integer.parseInt(stringExtra);
        } else {
            ordinal = QQECChannel.CHANNEL_UNKNOWN.ordinal();
        }
        this.channel = ordinal;
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (intent10 = activity2.getIntent()) == null || (str = intent10.getStringExtra("product_type")) == null) {
            str = "";
        }
        this.saasType = str;
        FragmentActivity activity3 = getActivity();
        if (activity3 == null || (intent9 = activity3.getIntent()) == null || (str2 = intent9.getStringExtra("saas_product_id")) == null) {
            str2 = "";
        }
        this.saasProductId = str2;
        FragmentActivity activity4 = getActivity();
        if (activity4 == null || (intent8 = activity4.getIntent()) == null || (str3 = intent8.getStringExtra("media_id")) == null) {
            str3 = "";
        }
        this.mediaId = str3;
        FragmentActivity activity5 = getActivity();
        if (activity5 == null || (intent7 = activity5.getIntent()) == null || (str4 = intent7.getStringExtra("media_product_id")) == null) {
            str4 = "";
        }
        this.mediaProductID = str4;
        FragmentActivity activity6 = getActivity();
        if (activity6 == null || (intent6 = activity6.getIntent()) == null || (str5 = intent6.getStringExtra("category_name")) == null) {
            str5 = "";
        }
        this.categoryName = str5;
        FragmentActivity activity7 = getActivity();
        if (activity7 == null || (intent5 = activity7.getIntent()) == null || (str6 = intent5.getStringExtra("goods_type")) == null) {
            str6 = "";
        }
        this.goodsType = str6;
        FragmentActivity activity8 = getActivity();
        if (activity8 == null || (intent4 = activity8.getIntent()) == null || (str7 = intent4.getStringExtra(PictureConst.KEY_CATEGORY_ID)) == null) {
            str7 = "";
        }
        this.categoryId = str7;
        FragmentActivity activity9 = getActivity();
        if (activity9 == null || (intent3 = activity9.getIntent()) == null || (str8 = intent3.getStringExtra(QCircleLpReportDc05507.KEY_SEAL_TRANSFER)) == null) {
            str8 = "";
        }
        this.sealTransfer = str8;
        FragmentActivity activity10 = getActivity();
        if (activity10 == null || (intent2 = activity10.getIntent()) == null || (valueOf = intent2.getStringExtra("source_from")) == null) {
            valueOf = String.valueOf(ECSourceFrom.SOURCE_FROM_UNKNOWN.ordinal());
        }
        this.sourceFrom = valueOf;
        FragmentActivity activity11 = getActivity();
        if (activity11 == null || (intent = activity11.getIntent()) == null || (str9 = intent.getStringExtra("request_id")) == null) {
            str9 = "";
        }
        this.requestId = str9;
        this.roomId = ug0.b.f438933d.f().optString("qqlive_room_id", "");
        a.b("ECDetailHostPageFragment", "channel = " + this.channel + ", saasType = " + this.saasType + ", saasProductId = " + this.saasProductId + ", mediaId = " + this.mediaId + ", mediaProductID = " + this.mediaProductID + ", categoryName = " + this.categoryName + ", goodsType = " + this.goodsType + ", categoryId = " + this.categoryId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECDetailPageHostViewModel ji() {
        return (ECDetailPageHostViewModel) this.ecDetailHostViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECGlobalShowWindowViewModel ki() {
        return (ECGlobalShowWindowViewModel) this.ecGlobalShowWindowViewModel.getValue();
    }

    private final CoroutineScope li() {
        return (CoroutineScope) this.lifecycleScope.getValue();
    }

    private final void mi() {
        ECBaseRecyclerView eCBaseRecyclerView = this.detailPageRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        eCBaseRecyclerView.addOnScrollListener(new c());
        ImageView imageView = this.backButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        imageView.setOnClickListener(new d());
        Button button = this.addToGoodsCenterButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToGoodsCenterButton");
        }
        button.setOnClickListener(new e());
    }

    private final void ni() {
        String str;
        com.tencent.ecommerce.biz.detail.utils.c cVar = new com.tencent.ecommerce.biz.detail.utils.c();
        cVar.g(2);
        cVar.q(this.mediaId);
        Product value = ji().b2().getValue();
        if (value == null || (str = value.getSaasProductId()) == null) {
            str = "";
        }
        cVar.i(str);
        cVar.h(this.categoryId);
        cVar.s(this.sourceFrom);
        cVar.n(this.roomId);
        cVar.o(this.saasType);
        cVar.f(1);
        Unit unit = Unit.INSTANCE;
        this.reportParams = cVar;
    }

    private final void oi() {
        ji().S1().observe(getViewLifecycleOwner(), new g());
        ji().e2().observe(getViewLifecycleOwner(), h.f102088d);
        ji().g2().observe(getViewLifecycleOwner(), new i());
        ji().R1().observe(getViewLifecycleOwner(), new Observer<Long>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailHostPageFragment$registerLivedataObserver$4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(Long l3) {
                Timer timer;
                TimerTask timerTask;
                if (l3 != null && l3.longValue() == 0) {
                    return;
                }
                ECDetailHostPageFragment.this.activityStartTimerTask = new TimerTask() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailHostPageFragment$registerLivedataObserver$4.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        if (ECDetailHostPageFragment.this.ji().S1().getValue() != null) {
                            ECDetailHostPageFragment.this.qi();
                        }
                    }
                };
                ECDetailHostPageFragment.this.activityStartTimer = new Timer();
                timer = ECDetailHostPageFragment.this.activityStartTimer;
                if (timer != null) {
                    timerTask = ECDetailHostPageFragment.this.activityStartTimerTask;
                    timer.schedule(timerTask, new Date(l3.longValue()));
                }
            }
        });
        ji().Q1().observe(getViewLifecycleOwner(), new Observer<Long>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailHostPageFragment$registerLivedataObserver$5
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(Long l3) {
                Timer timer;
                TimerTask timerTask;
                if (l3 != null && l3.longValue() == 0) {
                    return;
                }
                ECDetailHostPageFragment.this.activityEndTimerTask = new TimerTask() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailHostPageFragment$registerLivedataObserver$5.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        if (ECDetailHostPageFragment.this.ji().S1().getValue() != null) {
                            ECDetailHostPageFragment.this.qi();
                        }
                    }
                };
                ECDetailHostPageFragment.this.activityEndTimer = new Timer();
                timer = ECDetailHostPageFragment.this.activityEndTimer;
                if (timer != null) {
                    timerTask = ECDetailHostPageFragment.this.activityEndTimerTask;
                    timer.schedule(timerTask, new Date(l3.longValue()));
                }
            }
        });
        LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, ECAddProductToWindowEvent.class, this.addProductEventObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qi() {
        BuildersKt__Builders_commonKt.launch$default(li(), null, null, new ECDetailHostPageFragment$requestData$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void si(boolean isAdded) {
        Button button = this.addToGoodsCenterButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToGoodsCenterButton");
        }
        button.setBackground(ECSkin.INSTANCE.getDrawable(R.drawable.bry));
        if (isAdded) {
            Button button2 = this.addToGoodsCenterButton;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addToGoodsCenterButton");
            }
            button2.setVisibility(0);
            button2.setText("\u5df2\u6dfb\u52a0\u6a71\u7a97");
            button2.setEnabled(false);
            return;
        }
        Button button3 = this.addToGoodsCenterButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToGoodsCenterButton");
        }
        button3.setVisibility(0);
        button3.setText("\u6dfb\u52a0\u5230\u6a71\u7a97");
        button3.setEnabled(true);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECDetailHostPageFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.f167328cq1;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initArguments();
        ni();
        this.detailPageDurationReport = new com.tencent.ecommerce.biz.detail.utils.b(this.sourceFrom);
        LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, ECForegroundEvent.class, this.observer);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CoroutineScopeKt.cancel$default(li(), null, 1, null);
        ji().destroy();
        LifecycleEventBus lifecycleEventBus = LifecycleEventBus.f100688b;
        lifecycleEventBus.e(this.observer);
        lifecycleEventBus.e(this.addProductEventObserver);
        TimerTask timerTask = this.activityStartTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.activityStartTimer;
        if (timer != null) {
            timer.cancel();
        }
        TimerTask timerTask2 = this.activityEndTimerTask;
        if (timerTask2 != null) {
            timerTask2.cancel();
        }
        Timer timer2 = this.activityEndTimer;
        if (timer2 != null) {
            timer2.cancel();
        }
        com.tencent.ecommerce.biz.detail.utils.b bVar = this.detailPageDurationReport;
        if (bVar != null) {
            com.tencent.ecommerce.biz.detail.utils.b.c(bVar, null, 1, null);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ECRMonitorManager.f100953c.b("EC_STAGE_DETAIL_PAGE_HOST");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ECRMonitorManager.f100953c.c("EC_STAGE_DETAIL_PAGE_HOST");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        mi();
        qi();
        oi();
        ECDetailPageHostViewModel ji5 = ji();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, this.mediaProductID);
        jSONObject.put("saas_productId", this.saasProductId);
        jSONObject.put("seller_id", this.mediaId);
        Unit unit = Unit.INSTANCE;
        ji5.i2(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ri() {
        String str;
        String title;
        com.tencent.ecommerce.biz.detail.utils.b bVar = this.detailPageDurationReport;
        if (bVar != null) {
            String str2 = this.roomId;
            ug0.b bVar2 = ug0.b.f438933d;
            String valueOf = String.valueOf(bVar2.e());
            long currentAccount = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount();
            String str3 = this.mediaId;
            String str4 = this.saasType;
            Product value = ji().b2().getValue();
            String str5 = "";
            if (value == null || (str = value.getSaasProductId()) == null) {
                str = "";
            }
            Product value2 = ji().b2().getValue();
            if (value2 != null && (title = value2.getTitle()) != null) {
                str5 = title;
            }
            String str6 = this.categoryId;
            Product value3 = ji().b2().getValue();
            long price = value3 != null ? value3.getPrice() : 0L;
            Product value4 = ji().b2().getValue();
            bVar.e(new ECDetailPageDuration(2, "", "", str2, valueOf, currentAccount, str3, "", "0", str4, str, str5, str6, price, value4 != null ? value4.getSales() : 0L, this.sourceFrom, bVar2.f().optString("content_id"), this.sealTransfer, this.requestId, 0, 524288, null));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if (r6 != true) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0034, code lost:
    
        if (r6 != true) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0045, code lost:
    
        if (r6 == true) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void pi(boolean isAdded, String mediaProductId) {
        String saasProductId;
        boolean contains$default;
        String saasProductId2;
        boolean contains$default2;
        int i3;
        String str;
        JSONObject jSONObject;
        String title;
        String saasProductId3;
        JSONObject dataJson;
        String string;
        String saasProductId4;
        boolean contains$default3;
        Product value = ji().b2().getValue();
        int i16 = 1;
        JSONObject jSONObject2 = null;
        if (value != null && (saasProductId4 = value.getSaasProductId()) != null) {
            contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) saasProductId4, (CharSequence) "txvideovip1111", false, 2, (Object) null);
        }
        if (value != null && (saasProductId2 = value.getSaasProductId()) != null) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) saasProductId2, (CharSequence) "txvideovip", false, 2, (Object) null);
        }
        if (value != null && (saasProductId = value.getSaasProductId()) != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) saasProductId, (CharSequence) "txvideojdunion", false, 2, (Object) null);
        }
        i16 = 2;
        Bundle arguments = getArguments();
        String str2 = (arguments == null || (string = arguments.getString("banner_name", "")) == null) ? "" : string;
        if (value != null && (dataJson = value.getDataJson()) != null) {
            jSONObject2 = dataJson.optJSONObject("active_info");
        }
        if (jSONObject2 == null || jSONObject2.length() <= 0) {
            i3 = 0;
            str = "";
        } else {
            String optString = jSONObject2.optString("active_id", "");
            i3 = jSONObject2.optInt("active_type", 0);
            str = optString;
        }
        if (value == null || (jSONObject = value.getDataJson()) == null) {
            jSONObject = new JSONObject();
        }
        ECShopReportCouponParams b16 = com.tencent.ecommerce.biz.shophome.util.a.f104379a.b(jSONObject);
        com.tencent.ecommerce.biz.detail.utils.d dVar = com.tencent.ecommerce.biz.detail.utils.d.f102466a;
        String valueOf = String.valueOf(ug0.b.f438933d.e());
        long currentAccount = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount();
        String str3 = this.mediaId;
        String str4 = this.saasType;
        Product value2 = ji().b2().getValue();
        String str5 = (value2 == null || (saasProductId3 = value2.getSaasProductId()) == null) ? "" : saasProductId3;
        Product value3 = ji().b2().getValue();
        String str6 = (value3 == null || (title = value3.getTitle()) == null) ? "" : title;
        String str7 = this.categoryId;
        Product value4 = ji().b2().getValue();
        long commission = value4 != null ? value4.getCommission() : 0L;
        Product value5 = ji().b2().getValue();
        long price = value5 != null ? value5.getPrice() : 0L;
        Product value6 = ji().b2().getValue();
        long priceUpper = value6 != null ? value6.getPriceUpper() : 0L;
        Product value7 = ji().b2().getValue();
        long priceLower = value7 != null ? value7.getPriceLower() : 0L;
        Product value8 = ji().b2().getValue();
        long commissonUpper = value8 != null ? value8.getCommissonUpper() : 0L;
        Product value9 = ji().b2().getValue();
        long commissionLower = value9 != null ? value9.getCommissionLower() : 0L;
        Product value10 = ji().b2().getValue();
        long sales = value10 != null ? value10.getSales() : 0L;
        String str8 = this.sourceFrom;
        String bannerId = ji().getBannerId();
        String valueOf2 = String.valueOf(i16);
        Product value11 = ji().b2().getValue();
        dVar.g(valueOf, currentAccount, str3, str4, str5, str6, str7, commission, price, priceUpper, priceLower, commissonUpper, commissionLower, sales, isAdded, str8, bannerId, mediaProductId, valueOf2, str2, value11 != null ? value11.getGoodsType() : -1, str, i3, b16);
    }

    private final void initUI(View rootView) {
        this.titleBar = rootView.findViewById(R.id.nzl);
        this.titleBarBackground = rootView.findViewById(R.id.och);
        this.backButton = (ImageView) rootView.findViewById(R.id.nwm);
        Button button = (Button) rootView.findViewById(R.id.nw_);
        this.addToGoodsCenterButton = button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToGoodsCenterButton");
        }
        button.setVisibility(8);
        this.ecommerceContainer = (FrameLayout) rootView.findViewById(R.id.nwi);
        this.detailPageRecyclerView = (ECBaseRecyclerView) rootView.findViewById(R.id.nve);
        ji();
        this.ecBaseRecyclerViewAdapter = new com.tencent.ecommerce.biz.detail.ui.b(requireContext(), ji(), true);
        ECBaseRecyclerView eCBaseRecyclerView = this.detailPageRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        eCBaseRecyclerView.setItemAnimator(null);
        eCBaseRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        com.tencent.ecommerce.biz.detail.ui.b bVar = this.ecBaseRecyclerViewAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        eCBaseRecyclerView.setAdapter(bVar);
        int c16 = com.tencent.ecommerce.biz.util.e.c(12.0f);
        int c17 = com.tencent.ecommerce.biz.util.e.c(16.0f);
        int c18 = com.tencent.ecommerce.biz.util.e.c(11.0f);
        com.tencent.ecommerce.biz.detail.ui.b bVar2 = this.ecBaseRecyclerViewAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        eCBaseRecyclerView.addItemDecoration(new ECShopDetailItemDecoration(c16, c17, c18, 2, bVar2));
        View view = this.titleBar;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        }
        ii(view);
        View view2 = this.titleBarBackground;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBarBackground");
        }
        ii(view2);
    }
}
