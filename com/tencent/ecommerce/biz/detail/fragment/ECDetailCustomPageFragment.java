package com.tencent.ecommerce.biz.detail.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cg0.a;
import ck0.Product;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager;
import com.tencent.ecommerce.base.share.api.ECActionItemClickListener;
import com.tencent.ecommerce.base.share.api.ECActionItemData;
import com.tencent.ecommerce.base.share.api.ECQQShareData;
import com.tencent.ecommerce.base.share.api.IECShareProxy;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.component.ECBaseRecyclerView;
import com.tencent.ecommerce.biz.detail.ECDetailGuidanceDialog;
import com.tencent.ecommerce.biz.detail.fragment.ECDetailHostPageFragment;
import com.tencent.ecommerce.biz.detail.ui.ECShopDetailItemDecoration;
import com.tencent.ecommerce.biz.detail.utils.ECDetailPageDuration;
import com.tencent.ecommerce.biz.detail.utils.ECSourceFrom;
import com.tencent.ecommerce.biz.detail.viewmodel.saas.ECDetailPageCustomViewModel;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;
import org.json.JSONObject;
import zi0.ECForegroundEvent;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0002\u0080\u0001\u0018\u0000 \u0086\u00012\u00020\u0001:\u0002\u0087\u0001B\t\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\"\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0014H\u0003J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0010H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010.R\u0016\u0010O\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010NR\u0016\u0010T\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010SR\u0016\u0010X\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010SR\u0016\u0010Z\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010SR\u0016\u0010\\\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010SR\u0016\u0010^\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010SR\u0016\u0010`\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010SR\u0016\u0010b\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010SR\u0016\u0010d\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010SR\u0016\u0010f\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010SR\u0016\u0010h\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010SR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010KR\u001b\u0010s\u001a\u00020o8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bp\u0010(\u001a\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010NR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010{\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010KR\u0018\u0010\u007f\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/fragment/ECDetailCustomPageFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "initArguments", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "ni", "ri", "qi", "vi", "ti", "xi", WidgetCacheLunarData.YI, "action", "status", SensorJsPlugin.SENSOR_INTERVAL_UI, "wi", "si", "Lcom/tencent/ecommerce/biz/detail/viewmodel/saas/ECDetailPageCustomViewModel;", "P", "Lkotlin/Lazy;", "oi", "()Lcom/tencent/ecommerce/biz/detail/viewmodel/saas/ECDetailPageCustomViewModel;", "ecDetailCustomViewModel", "Landroid/widget/FrameLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/FrameLayout;", "titleBar", BdhLogUtil.LogTag.Tag_Req, "Landroid/view/View;", "titleBarBackground", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "detailPageRecyclerView", "Lbh0/b;", "T", "Lbh0/b;", "ecBaseRecyclerViewAdapter", "Landroid/widget/ImageView;", "U", "Landroid/widget/ImageView;", "backButton", "V", "shareButton", "Landroid/widget/Button;", "W", "Landroid/widget/Button;", "goToWindowButton", "X", "goToBuyButton", "Landroid/view/ViewGroup;", "Y", "Landroid/view/ViewGroup;", "ecommerceButtonContainer", "Z", "ecommerceContainer", "a0", "I", "scrollY", "b0", WadlProxyConsts.CHANNEL, "c0", "Ljava/lang/String;", "saasType", "d0", "saasProductId", "e0", "mediaId", "f0", "mediaProductID", "g0", "categoryName", "h0", "goodsType", "i0", "categoryId", "j0", "sealTransfer", "k0", GetAdInfoRequest.SOURCE_FROM, "l0", "roomId", "m0", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "Ljava/util/concurrent/atomic/AtomicBoolean;", "n0", "Ljava/util/concurrent/atomic/AtomicBoolean;", "showGuidanceDialog", "o0", "isCurrentNightMode", "Lkotlinx/coroutines/CoroutineScope;", "p0", "pi", "()Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope", "q0", "shareAction", "Lcom/tencent/ecommerce/biz/detail/utils/b;", "r0", "Lcom/tencent/ecommerce/biz/detail/utils/b;", "detailPageDurationReport", "s0", "hasScrollToTop", "Lcom/tencent/ecommerce/biz/detail/utils/c;", "t0", "Lcom/tencent/ecommerce/biz/detail/utils/c;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "com/tencent/ecommerce/biz/detail/fragment/ECDetailCustomPageFragment$g", "u0", "Lcom/tencent/ecommerce/biz/detail/fragment/ECDetailCustomPageFragment$g;", "observer", "<init>", "()V", "v0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECDetailCustomPageFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy ecDetailCustomViewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private FrameLayout titleBar;

    /* renamed from: R, reason: from kotlin metadata */
    private View titleBarBackground;

    /* renamed from: S, reason: from kotlin metadata */
    private ECBaseRecyclerView detailPageRecyclerView;

    /* renamed from: T, reason: from kotlin metadata */
    private bh0.b ecBaseRecyclerViewAdapter;

    /* renamed from: U, reason: from kotlin metadata */
    private ImageView backButton;

    /* renamed from: V, reason: from kotlin metadata */
    private ImageView shareButton;

    /* renamed from: W, reason: from kotlin metadata */
    private Button goToWindowButton;

    /* renamed from: X, reason: from kotlin metadata */
    private Button goToBuyButton;

    /* renamed from: Y, reason: from kotlin metadata */
    private ViewGroup ecommerceButtonContainer;

    /* renamed from: Z, reason: from kotlin metadata */
    private FrameLayout ecommerceContainer;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private int scrollY;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int channel;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private String saasType;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private String saasProductId;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private String mediaId;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private String mediaProductID;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private String categoryName;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private String goodsType;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private String categoryId;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private String sealTransfer;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private String sourceFrom;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private String roomId;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private String requestId;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean showGuidanceDialog;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private boolean isCurrentNightMode;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private final Lazy lifecycleScope;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private int shareAction;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.utils.b detailPageDurationReport;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private boolean hasScrollToTop;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.utils.c reportParams;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private final g observer;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECDetailCustomPageFragment$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            ECDetailCustomPageFragment.this.scrollY += dy5;
            ECDetailCustomPageFragment.this.oi().k2(ECDetailCustomPageFragment.this.scrollY);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FragmentActivity activity = ECDetailCustomPageFragment.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECDetailCustomPageFragment$g", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lzi0/a;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements EventObserver<ECForegroundEvent> {
        g() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECForegroundEvent event) {
            boolean z16 = event.isForeground;
            if (z16) {
                ECDetailCustomPageFragment eCDetailCustomPageFragment = ECDetailCustomPageFragment.this;
                eCDetailCustomPageFragment.detailPageDurationReport = new com.tencent.ecommerce.biz.detail.utils.b(eCDetailCustomPageFragment.sourceFrom);
                com.tencent.ecommerce.biz.detail.utils.b bVar = ECDetailCustomPageFragment.this.detailPageDurationReport;
                if (bVar != null) {
                    bVar.d();
                }
                ECDetailCustomPageFragment.this.wi();
                return;
            }
            if (z16) {
                return;
            }
            com.tencent.ecommerce.biz.detail.utils.b bVar2 = ECDetailCustomPageFragment.this.detailPageDurationReport;
            if (bVar2 != null) {
                com.tencent.ecommerce.biz.detail.utils.b.c(bVar2, null, 1, null);
            }
            com.tencent.ecommerce.biz.detail.utils.b bVar3 = ECDetailCustomPageFragment.this.detailPageDurationReport;
            if (bVar3 != null) {
                bVar3.f();
            }
            ECDetailCustomPageFragment.this.detailPageDurationReport = null;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECDetailCustomPageFragment$onResume$dialog$1$2", "Lcom/tencent/ecommerce/biz/detail/ECDetailGuidanceDialog$IECDetailGuidanceDialogListener;", "", "onCancel", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements ECDetailGuidanceDialog.IECDetailGuidanceDialogListener {
        h() {
        }

        @Override // com.tencent.ecommerce.biz.detail.ECDetailGuidanceDialog.IECDetailGuidanceDialogListener
        public void onCancel() {
            ECDetailCustomPageFragment.Rh(ECDetailCustomPageFragment.this).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i<T> implements Observer<Integer> {

        /* renamed from: d, reason: collision with root package name */
        public static final i f102053d = new i();

        i() {
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j<T> implements Observer<String> {

        /* renamed from: d, reason: collision with root package name */
        public static final j f102054d = new j();

        j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(String str) {
            a.b("ECDetailCustomPageFragment", "[ecDetailCustomViewModel] buyItemUrlData = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lorg/json/JSONObject;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k<T> implements Observer<JSONObject> {
        k() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(JSONObject jSONObject) {
            String optString = jSONObject.optString("button_bg_color");
            if (optString.length() > 0) {
                ECDetailHostPageFragment.INSTANCE.a(ECDetailCustomPageFragment.Sh(ECDetailCustomPageFragment.this), optString);
                IECLocalConfig.a.j(ECLocalConfig.f100650f, "button_bg_color", optString, null, 4, null);
            }
            String optString2 = jSONObject.optString(AppDownloadCallback.BUTTON_TXT);
            if (optString2.length() > 0) {
                ECDetailCustomPageFragment.Sh(ECDetailCustomPageFragment.this).setText(optString2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lck0/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lck0/c;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class l<T> implements Observer<Product> {
        l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Product product) {
            a.b("ECDetailCustomPageFragment", "[ecDetailCustomViewModel] productLiveData = " + product);
            ECDetailCustomPageFragment.this.si();
        }
    }

    public ECDetailCustomPageFragment() {
        Lazy lazy;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailCustomPageFragment$ecDetailCustomViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return new com.tencent.ecommerce.biz.detail.viewmodel.saas.a(ECDetailCustomPageFragment.this.getArguments());
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailCustomPageFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.ecDetailCustomViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECDetailPageCustomViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailCustomPageFragment$$special$$inlined$viewModels$2
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
        this.showGuidanceDialog = new AtomicBoolean(false);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailCustomPageFragment$lifecycleScope$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.MainScope();
            }
        });
        this.lifecycleScope = lazy;
        this.shareAction = -1;
        this.observer = new g();
    }

    public static final /* synthetic */ ECBaseRecyclerView Oh(ECDetailCustomPageFragment eCDetailCustomPageFragment) {
        ECBaseRecyclerView eCBaseRecyclerView = eCDetailCustomPageFragment.detailPageRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        return eCBaseRecyclerView;
    }

    public static final /* synthetic */ bh0.b Ph(ECDetailCustomPageFragment eCDetailCustomPageFragment) {
        bh0.b bVar = eCDetailCustomPageFragment.ecBaseRecyclerViewAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        return bVar;
    }

    public static final /* synthetic */ FrameLayout Rh(ECDetailCustomPageFragment eCDetailCustomPageFragment) {
        FrameLayout frameLayout = eCDetailCustomPageFragment.ecommerceContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecommerceContainer");
        }
        return frameLayout;
    }

    public static final /* synthetic */ Button Sh(ECDetailCustomPageFragment eCDetailCustomPageFragment) {
        Button button = eCDetailCustomPageFragment.goToBuyButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goToBuyButton");
        }
        return button;
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
        this.isCurrentNightMode = fg0.a.f398587b.a();
        a.b("ECDetailCustomPageFragment", "channel = " + this.channel + ", saasType = " + this.saasType + ", saasProductId = " + this.saasProductId + ", mediaId = " + this.mediaId + ", mediaProductID = " + this.mediaProductID + ", categoryName = " + this.categoryName + ", goodsType = " + this.goodsType + ", categoryId = " + this.categoryId + ", isCurrentNightMode = " + this.isCurrentNightMode);
    }

    private final void ni(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i3 = layoutParams.height;
        r rVar = r.f104881b;
        layoutParams.height = i3 + rVar.a(getActivity());
        view.setLayoutParams(layoutParams);
        view.setPadding(view.getPaddingLeft(), rVar.a(getActivity()), view.getPaddingRight(), view.getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECDetailPageCustomViewModel oi() {
        return (ECDetailPageCustomViewModel) this.ecDetailCustomViewModel.getValue();
    }

    private final CoroutineScope pi() {
        return (CoroutineScope) this.lifecycleScope.getValue();
    }

    private final void qi() {
        ECBaseRecyclerView eCBaseRecyclerView = this.detailPageRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        eCBaseRecyclerView.addOnScrollListener(new b());
        ImageView imageView = this.backButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        imageView.setOnClickListener(new c());
        Button button = this.goToWindowButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goToWindowButton");
        }
        button.setOnClickListener(new d());
        Button button2 = this.goToBuyButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goToBuyButton");
        }
        button2.setOnClickListener(new e());
        ImageView imageView2 = this.shareButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareButton");
        }
        imageView2.setOnClickListener(new f());
    }

    private final void ri(View rootView) {
        if (this.isCurrentNightMode) {
            rootView.setBackgroundColor(requireContext().getResources().getColor(R.color.f156552dz));
            View view = this.titleBarBackground;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBarBackground");
            }
            view.setBackgroundColor(requireContext().getResources().getColor(R.color.f156552dz));
            ViewGroup viewGroup = this.ecommerceButtonContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ecommerceButtonContainer");
            }
            viewGroup.setBackgroundColor(requireContext().getResources().getColor(R.color.f156552dz));
            Button button = this.goToWindowButton;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goToWindowButton");
            }
            button.setBackground(requireContext().getResources().getDrawable(R.drawable.bke));
            Button button2 = this.goToWindowButton;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goToWindowButton");
            }
            button2.setTextColor(requireContext().getResources().getColor(R.color.f7163i));
            return;
        }
        rootView.setBackgroundColor(requireContext().getResources().getColor(R.color.f7163i));
        View view2 = this.titleBarBackground;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBarBackground");
        }
        view2.setBackgroundColor(requireContext().getResources().getColor(R.color.f7163i));
        ViewGroup viewGroup2 = this.ecommerceButtonContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecommerceButtonContainer");
        }
        viewGroup2.setBackgroundColor(requireContext().getResources().getColor(R.color.f7163i));
        Button button3 = this.goToWindowButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goToWindowButton");
        }
        button3.setBackground(requireContext().getResources().getDrawable(R.drawable.bkh));
        Button button4 = this.goToWindowButton;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goToWindowButton");
        }
        button4.setTextColor(requireContext().getResources().getColor(R.color.f156552dz));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void si() {
        String str;
        com.tencent.ecommerce.biz.detail.utils.c cVar = new com.tencent.ecommerce.biz.detail.utils.c();
        cVar.g(2);
        cVar.q(this.mediaId);
        Product value = oi().a2().getValue();
        if (value == null || (str = value.getSaasProductId()) == null) {
            str = "";
        }
        cVar.i(str);
        cVar.h(this.categoryId);
        cVar.s(this.sourceFrom);
        cVar.n(this.roomId);
        cVar.o(this.saasType);
        cVar.f(2);
        Unit unit = Unit.INSTANCE;
        this.reportParams = cVar;
    }

    private final void ti() {
        oi().S1().observe(getViewLifecycleOwner(), new Observer<List<? extends ECBasePtsViewData>>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailCustomPageFragment$registerLivedataObserver$1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(List<ECBasePtsViewData> list) {
                ECDetailCustomPageFragment.Ph(ECDetailCustomPageFragment.this).setData(list);
                ECDetailCustomPageFragment.Oh(ECDetailCustomPageFragment.this).post(new Runnable() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECDetailCustomPageFragment$registerLivedataObserver$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean z16;
                        z16 = ECDetailCustomPageFragment.this.hasScrollToTop;
                        if (z16) {
                            return;
                        }
                        ECDetailCustomPageFragment.this.hasScrollToTop = true;
                        ECDetailCustomPageFragment.Oh(ECDetailCustomPageFragment.this).scrollToPosition(0);
                    }
                });
            }
        });
        oi().d2().observe(getViewLifecycleOwner(), i.f102053d);
        oi().T1().observe(getViewLifecycleOwner(), j.f102054d);
        oi().e2().observe(getViewLifecycleOwner(), new k());
        oi().a2().observe(getViewLifecycleOwner(), new l());
        oi().b2().observe(getViewLifecycleOwner(), new m());
    }

    private final void vi() {
        BuildersKt__Builders_commonKt.launch$default(pi(), null, null, new ECDetailCustomPageFragment$requestData$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yi() {
        com.tencent.ecommerce.base.ui.i.f101155b.d(requireContext().getString(R.string.wvp), ECToastIcon.ICON_ERROR, 0);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECDetailCustomPageFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.f167328cq1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String str;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 21) {
            int i3 = this.shareAction;
            if (resultCode == -1) {
                str = "1";
            } else {
                str = "2";
            }
            ui(i3, str);
            oi().R1(this.shareAction, resultCode == -1);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initArguments();
        this.detailPageDurationReport = new com.tencent.ecommerce.biz.detail.utils.b(this.sourceFrom);
        LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, ECForegroundEvent.class, this.observer);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CoroutineScopeKt.cancel$default(pi(), null, 1, null);
        oi().destroy();
        LifecycleEventBus.f100688b.e(this.observer);
        com.tencent.ecommerce.biz.detail.utils.b bVar = this.detailPageDurationReport;
        if (bVar != null) {
            com.tencent.ecommerce.biz.detail.utils.b.c(bVar, null, 1, null);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ECRMonitorManager.f100953c.b("EC_STAGE_DETAIL_PAGE_GUEST");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        super.onResume();
        if (this.showGuidanceDialog.compareAndSet(true, false)) {
            ECDetailGuidanceDialog eCDetailGuidanceDialog = new ECDetailGuidanceDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("channel_id", this.channel);
            Unit unit = Unit.INSTANCE;
            eCDetailGuidanceDialog.setArguments(bundle);
            eCDetailGuidanceDialog.Mh(new h());
            FragmentActivity activity = getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (add = beginTransaction.add(R.id.nwi, eCDetailGuidanceDialog)) != null) {
                add.commit();
            }
            FrameLayout frameLayout = this.ecommerceContainer;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ecommerceContainer");
            }
            frameLayout.setVisibility(0);
        }
        ECRMonitorManager.f100953c.c("EC_STAGE_DETAIL_PAGE_GUEST");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        qi();
        ti();
        vi();
        ECDetailPageCustomViewModel oi5 = oi();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, this.mediaProductID);
        jSONObject.put("seller_id", this.mediaId);
        Unit unit = Unit.INSTANCE;
        oi5.g2(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/ecommerce/base/share/api/c;", "it", "", "a", "(Lcom/tencent/ecommerce/base/share/api/c;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class m<T> implements Observer<ECQQShareData> {
        m() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECQQShareData eCQQShareData) {
            if (eCQQShareData == null) {
                ECDetailCustomPageFragment.this.yi();
            } else {
                QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getShareProxy().shareMsgToQQ(ECDetailCustomPageFragment.this.requireActivity(), 21, eCQQShareData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xi() {
        List<Integer> mutableListOf;
        List<Integer> emptyList;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(2);
        IECShareProxy shareProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getShareProxy();
        n nVar = new n();
        FragmentActivity requireActivity = requireActivity();
        String string = getResources().getString(R.string.wvo);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        shareProxy.showShareActionSheet(requireActivity, string, mutableListOf, emptyList, nVar);
    }

    private final void ui(int action, String status) {
        String str;
        String title;
        com.tencent.ecommerce.biz.detail.utils.d dVar = com.tencent.ecommerce.biz.detail.utils.d.f102466a;
        String valueOf = String.valueOf(this.channel);
        long currentAccount = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount();
        String str2 = this.mediaId;
        String str3 = this.saasType;
        Product value = oi().a2().getValue();
        String str4 = "";
        if (value == null || (str = value.getSaasProductId()) == null) {
            str = "";
        }
        Product value2 = oi().a2().getValue();
        if (value2 != null && (title = value2.getTitle()) != null) {
            str4 = title;
        }
        String str5 = this.categoryId;
        Product value3 = oi().a2().getValue();
        long price = value3 != null ? value3.getPrice() : 0L;
        Product value4 = oi().a2().getValue();
        dVar.q(valueOf, currentAccount, str2, str3, str, str4, str5, price, value4 != null ? value4.getSales() : 0L, ug0.b.f438933d.f().optString("content_id"), action, status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wi() {
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
            Product value = oi().a2().getValue();
            String str5 = "";
            if (value == null || (str = value.getSaasProductId()) == null) {
                str = "";
            }
            Product value2 = oi().a2().getValue();
            if (value2 != null && (title = value2.getTitle()) != null) {
                str5 = title;
            }
            String str6 = this.categoryId;
            Product value3 = oi().a2().getValue();
            long price = value3 != null ? value3.getPrice() : 0L;
            Product value4 = oi().a2().getValue();
            bVar.e(new ECDetailPageDuration(2, "", "", str2, valueOf, currentAccount, str3, "", "0", str4, str, str5, str6, price, value4 != null ? value4.getSales() : 0L, this.sourceFrom, bVar2.f().optString("content_id"), this.sealTransfer, this.requestId, 0, 524288, null));
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
            String title;
            String saasProductId;
            EventCollector.getInstance().onViewClickedBefore(view);
            ECScheme.g("mqqapi://ecommerce/open?target=7&media_id=" + ECDetailCustomPageFragment.this.mediaId, null, 2, null);
            com.tencent.ecommerce.biz.detail.utils.d dVar = com.tencent.ecommerce.biz.detail.utils.d.f102466a;
            ug0.b bVar = ug0.b.f438933d;
            String valueOf = String.valueOf(bVar.e());
            long currentAccount = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount();
            String str = ECDetailCustomPageFragment.this.mediaId;
            String str2 = ECDetailCustomPageFragment.this.saasType;
            Product value = ECDetailCustomPageFragment.this.oi().a2().getValue();
            String str3 = (value == null || (saasProductId = value.getSaasProductId()) == null) ? "" : saasProductId;
            Product value2 = ECDetailCustomPageFragment.this.oi().a2().getValue();
            String str4 = (value2 == null || (title = value2.getTitle()) == null) ? "" : title;
            String str5 = ECDetailCustomPageFragment.this.categoryId;
            Product value3 = ECDetailCustomPageFragment.this.oi().a2().getValue();
            long price = value3 != null ? value3.getPrice() : 0L;
            Product value4 = ECDetailCustomPageFragment.this.oi().a2().getValue();
            dVar.i(valueOf, currentAccount, str, "", str2, str3, str4, str5, price, value4 != null ? value4.getSales() : 0L, ECDetailCustomPageFragment.this.sourceFrom, bVar.f().optString("content_id"), ECDetailCustomPageFragment.this.sealTransfer, ECDetailCustomPageFragment.this.roomId, ECDetailCustomPageFragment.this.requestId);
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
            String str;
            String str2;
            String title;
            String saasProductId;
            EventCollector.getInstance().onViewClickedBefore(view);
            zh0.a aVar = zh0.a.f452541a;
            ug0.b bVar = ug0.b.f438933d;
            String valueOf = String.valueOf(bVar.e());
            QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
            long currentAccount = qQEcommerceSdk.getGlobalInternalSdk().getAccountManager().getCurrentAccount();
            String str3 = ECDetailCustomPageFragment.this.mediaId;
            String valueOf2 = String.valueOf(qQEcommerceSdk.getGlobalInternalSdk().getAccountManager().getCurrentAccount());
            String str4 = ECDetailCustomPageFragment.this.goodsType;
            String str5 = ECDetailCustomPageFragment.this.saasType;
            Product value = ECDetailCustomPageFragment.this.oi().a2().getValue();
            if (value == null || (str = value.getSaasProductId()) == null) {
                str = "";
            }
            Product value2 = ECDetailCustomPageFragment.this.oi().a2().getValue();
            if (value2 == null || (str2 = value2.getTitle()) == null) {
                str2 = "";
            }
            Map<Object, Object> a16 = aVar.a(valueOf, currentAccount, str3, valueOf2, str4, str5, str, str2, ECDetailCustomPageFragment.this.categoryId, ECDetailCustomPageFragment.this.sourceFrom, bVar.f().optString("content_id"), ECDetailCustomPageFragment.this.roomId, ECDetailCustomPageFragment.this.requestId, ECDetailCustomPageFragment.this.sealTransfer);
            String value3 = ECDetailCustomPageFragment.this.oi().T1().getValue();
            if (value3 == null) {
                value3 = "";
            }
            ECScheme.e(value3, a16);
            com.tencent.ecommerce.biz.detail.utils.d dVar = com.tencent.ecommerce.biz.detail.utils.d.f102466a;
            String valueOf3 = String.valueOf(bVar.e());
            long currentAccount2 = qQEcommerceSdk.getGlobalInternalSdk().getAccountManager().getCurrentAccount();
            String str6 = ECDetailCustomPageFragment.this.mediaId;
            String str7 = ECDetailCustomPageFragment.this.saasType;
            Product value4 = ECDetailCustomPageFragment.this.oi().a2().getValue();
            String str8 = (value4 == null || (saasProductId = value4.getSaasProductId()) == null) ? "" : saasProductId;
            Product value5 = ECDetailCustomPageFragment.this.oi().a2().getValue();
            String str9 = (value5 == null || (title = value5.getTitle()) == null) ? "" : title;
            String str10 = ECDetailCustomPageFragment.this.categoryId;
            Product value6 = ECDetailCustomPageFragment.this.oi().a2().getValue();
            long price = value6 != null ? value6.getPrice() : 0L;
            Product value7 = ECDetailCustomPageFragment.this.oi().a2().getValue();
            dVar.o(valueOf3, currentAccount2, str6, "", str7, str8, str9, str10, price, value7 != null ? value7.getSales() : 0L, ECDetailCustomPageFragment.this.sourceFrom, bVar.f().optString("content_id"), ECDetailCustomPageFragment.this.sealTransfer, ECDetailCustomPageFragment.this.roomId, ECDetailCustomPageFragment.this.requestId);
            com.tencent.ecommerce.biz.common.c.f101553a.b();
            ECLocalConfig eCLocalConfig = ECLocalConfig.f100650f;
            if ((!IECLocalConfig.a.c(eCLocalConfig, "CHANNEL_MALGRANDA_MONDO_GVIDILO_KEY", false, null, 4, null) && ECDetailCustomPageFragment.this.channel == QQECChannel.CHANNEL_QQ_LITTLE_WORLD.ordinal()) || (!IECLocalConfig.a.c(eCLocalConfig, "CHANNEL_BABILEJO_GVIDILO_KEY", false, null, 4, null) && ECDetailCustomPageFragment.this.channel == QQECChannel.CHANNEL_QQ_CHANNEL.ordinal())) {
                ECDetailCustomPageFragment.this.showGuidanceDialog.set(true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            String str2;
            EventCollector.getInstance().onViewClickedBefore(view);
            ECDetailCustomPageFragment.this.xi();
            com.tencent.ecommerce.biz.detail.utils.d dVar = com.tencent.ecommerce.biz.detail.utils.d.f102466a;
            String valueOf = String.valueOf(ECDetailCustomPageFragment.this.channel);
            long currentAccount = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount();
            String str3 = ECDetailCustomPageFragment.this.mediaId;
            String str4 = ECDetailCustomPageFragment.this.saasType;
            Product value = ECDetailCustomPageFragment.this.oi().a2().getValue();
            if (value == null || (str = value.getSaasProductId()) == null) {
                str = "";
            }
            Product value2 = ECDetailCustomPageFragment.this.oi().a2().getValue();
            if (value2 == null || (str2 = value2.getTitle()) == null) {
                str2 = "";
            }
            String str5 = ECDetailCustomPageFragment.this.categoryId;
            Product value3 = ECDetailCustomPageFragment.this.oi().a2().getValue();
            long price = value3 != null ? value3.getPrice() : 0L;
            Product value4 = ECDetailCustomPageFragment.this.oi().a2().getValue();
            dVar.p(valueOf, currentAccount, str3, str4, str, str2, str5, price, value4 != null ? value4.getSales() : 0L, ug0.b.f438933d.f().optString("content_id"));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private final void initUI(View rootView) {
        this.titleBar = (FrameLayout) rootView.findViewById(R.id.nzl);
        this.titleBarBackground = rootView.findViewById(R.id.och);
        this.backButton = (ImageView) rootView.findViewById(R.id.nwm);
        this.shareButton = (ImageView) rootView.findViewById(R.id.o_x);
        this.goToWindowButton = (Button) rootView.findViewById(R.id.f163025nx0);
        this.goToBuyButton = (Button) rootView.findViewById(R.id.nwz);
        this.ecommerceButtonContainer = (ViewGroup) rootView.findViewById(R.id.nwa);
        this.ecommerceContainer = (FrameLayout) rootView.findViewById(R.id.nwi);
        this.detailPageRecyclerView = (ECBaseRecyclerView) rootView.findViewById(R.id.nve);
        ECLocalConfig eCLocalConfig = ECLocalConfig.f100650f;
        if (IECLocalConfig.a.a(eCLocalConfig, "button_bg_color", null, 2, null)) {
            String f16 = IECLocalConfig.a.f(eCLocalConfig, "button_bg_color", "linear-gradient(to right, #0099FF 0%, #0099FF 100%)", null, 4, null);
            ECDetailHostPageFragment.Companion companion = ECDetailHostPageFragment.INSTANCE;
            Button button = this.goToBuyButton;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goToBuyButton");
            }
            companion.a(button, f16);
        }
        if (this.channel != QQECChannel.CHANNEL_QQ_LITTLE_WORLD.ordinal() && this.channel != QQECChannel.CHANNEL_QQ_LIVE.ordinal()) {
            ImageView imageView = this.shareButton;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareButton");
            }
            imageView.setVisibility(8);
        } else {
            ImageView imageView2 = this.shareButton;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareButton");
            }
            imageView2.setVisibility(0);
        }
        Button button2 = this.goToBuyButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goToBuyButton");
        }
        button2.setVisibility(0);
        Button button3 = this.goToWindowButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goToWindowButton");
        }
        button3.setVisibility(0);
        this.ecBaseRecyclerViewAdapter = new com.tencent.ecommerce.biz.detail.ui.b(requireContext(), oi(), false);
        ECBaseRecyclerView eCBaseRecyclerView = this.detailPageRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        eCBaseRecyclerView.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6471n));
        eCBaseRecyclerView.setItemAnimator(null);
        eCBaseRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        bh0.b bVar = this.ecBaseRecyclerViewAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        eCBaseRecyclerView.setAdapter(bVar);
        int c16 = com.tencent.ecommerce.biz.util.e.c(12.0f);
        int c17 = com.tencent.ecommerce.biz.util.e.c(16.0f);
        int c18 = com.tencent.ecommerce.biz.util.e.c(11.0f);
        bh0.b bVar2 = this.ecBaseRecyclerViewAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        eCBaseRecyclerView.addItemDecoration(new ECShopDetailItemDecoration(c16, c17, c18, 2, bVar2));
        FrameLayout frameLayout = this.titleBar;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        }
        ni(frameLayout);
        View view = this.titleBarBackground;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBarBackground");
        }
        ni(view);
        ri(rootView);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECDetailCustomPageFragment$n", "Lcom/tencent/ecommerce/base/share/api/ECActionItemClickListener;", "", "action", "Lcom/tencent/ecommerce/base/share/api/b;", "data", "", "onItemClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class n implements ECActionItemClickListener {
        n() {
        }

        @Override // com.tencent.ecommerce.base.share.api.ECActionItemClickListener
        public void onItemClick(int action, ECActionItemData data) {
            String str;
            String label;
            if (action == 2 || action == 72 || action == 73) {
                ECDetailPageCustomViewModel oi5 = ECDetailCustomPageFragment.this.oi();
                String str2 = "";
                if (data == null || (str = data.getUin()) == null) {
                    str = "";
                }
                if (data != null && (label = data.getLabel()) != null) {
                    str2 = label;
                }
                oi5.i2(action, str, str2, data != null ? data.getUinType() : -1);
                ECDetailCustomPageFragment.this.oi().j2();
                ECDetailCustomPageFragment.this.shareAction = action;
            }
        }
    }
}
