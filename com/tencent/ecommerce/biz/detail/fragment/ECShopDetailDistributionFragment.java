package com.tencent.ecommerce.biz.detail.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager;
import com.tencent.ecommerce.base.ui.ECBasePtsView;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECBaseViewController;
import com.tencent.ecommerce.base.ui.component.ECBaseRecyclerView;
import com.tencent.ecommerce.base.ui.tabbar.ECTabCoverInfo;
import com.tencent.ecommerce.base.ui.tabbar.ECTabLayout;
import com.tencent.ecommerce.biz.advertise.ECAdAttributionReporter;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailInfo;
import com.tencent.ecommerce.biz.detail.ui.ECShopDetailItemDecoration;
import com.tencent.ecommerce.biz.detail.ui.a;
import com.tencent.ecommerce.biz.detail.utils.ECDetailPageDuration;
import com.tencent.ecommerce.biz.detail.utils.ECSourceFrom;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailDistributorViewModel;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.showwindow.viewmodel.ECGlobalShowWindowViewModel;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.PTSRootNode;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
import ri0.ECAddProductToWindowEvent;
import zi0.ECForegroundEvent;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\t*\u0004\u00a6\u0001\u00aa\u0001\u0018\u0000 \u00b0\u00012\u00020\u0001:\u0002\u00b1\u0001B\t\u00a2\u0006\u0006\b\u00ae\u0001\u0010\u00af\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J.\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\u0004H\u0003J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0007H\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u0004H\u0002J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0004H\u0002J\b\u0010.\u001a\u00020\u0011H\u0002R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u00108R\u0016\u0010]\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u00108R\u0016\u0010_\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b^\u0010TR\u0018\u0010b\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010g\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010dR\u0016\u0010j\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010iR\u0016\u0010n\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010iR\u0016\u0010p\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010iR\u0016\u0010r\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010iR\u0016\u0010t\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010iR\u0016\u0010v\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010iR\u0016\u0010x\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010iR\u0016\u0010z\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010iR\u0016\u0010|\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010iR\u0016\u0010~\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010iR\u0017\u0010\u0080\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u007f\u0010iR\u0018\u0010\u0082\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010dR!\u0010\u0088\u0001\u001a\u00030\u0083\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008e\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008d\u0001\u0010dR$\u0010\u0092\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0094\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0093\u0001\u0010dR\u0018\u0010\u0096\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0095\u0001\u0010dR\u0018\u0010\u0098\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0097\u0001\u0010dR\u0018\u0010\u009a\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0099\u0001\u0010dR\u0018\u0010\u009c\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009b\u0001\u0010WR\u001c\u0010\u00a0\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R!\u0010\u00a5\u0001\u001a\u00030\u00a1\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a2\u0001\u0010\u0085\u0001\u001a\u0006\b\u00a3\u0001\u0010\u00a4\u0001R\u0018\u0010\u00a9\u0001\u001a\u00030\u00a6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u0018\u0010\u00ad\u0001\u001a\u00030\u00aa\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001\u00a8\u0006\u00b2\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/fragment/ECShopDetailDistributionFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "initViewModel", "", "getContentLayoutId", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "onBackPressed", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getBusinessDescription", "Eh", "initArguments", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "Hi", "key", "", "", "map", RemoteHandleConst.PARAM_DEFAULT_VALUE, "Fi", "Mi", "Oi", "Ni", "Ji", "Pi", "Ki", "targetPosition", "Qi", "isLoading", "Si", "Li", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "shopDetailInfo", "Bi", "Ri", "Ii", "Ei", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailDistributorViewModel;", "P", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailDistributorViewModel;", "viewModel", "Landroid/widget/LinearLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/LinearLayout;", "rootLayout", BdhLogUtil.LogTag.Tag_Req, "Landroid/view/View;", "titleBar", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "detailPageRecyclerView", "Lcom/tencent/ecommerce/biz/detail/ui/d;", "T", "Lcom/tencent/ecommerce/biz/detail/ui/d;", "ecBaseRecyclerViewAdapter", "Landroid/widget/ImageView;", "U", "Landroid/widget/ImageView;", "blackBackButton", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", "V", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", "tabLayout", "Lcom/tencent/ecommerce/biz/detail/ui/a;", "W", "Lcom/tencent/ecommerce/biz/detail/ui/a;", "tabLayoutController", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "X", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "shopBottomBar", "Landroid/view/ViewGroup;", "Y", "Landroid/view/ViewGroup;", "shopBottomBarContainer", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "Z", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "shopBottomBarController", "a0", "shopNetworkErrorContainer", "b0", "shopNetworkErrorRetryBtn", "c0", "loadingViewContainer", "d0", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "productDetailInfo", "e0", "I", "scrollY", "f0", WadlProxyConsts.CHANNEL, "g0", "Ljava/lang/String;", "saasType", "h0", "goodsType", "i0", "sellerId", "j0", "mediaProductID", "k0", "sealTransfer", "l0", GetAdInfoRequest.SOURCE_FROM, "m0", "adClickId", "n0", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "o0", "bizType", "p0", "shopId", "q0", "spuId", "r0", "littleWorldFeedId", "s0", "role", "Lkotlinx/coroutines/CoroutineScope;", "t0", "Lkotlin/Lazy;", "Di", "()Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope", "Lcom/tencent/ecommerce/biz/detail/utils/b;", "u0", "Lcom/tencent/ecommerce/biz/detail/utils/b;", "detailPageDurationReport", "v0", "scrollerState", "", "w0", "Ljava/util/Map;", "itemHeightMap", "x0", "titleBarOffset", "y0", "tabOffsetYForComment", "z0", "tabOffsetYForDetail", "A0", "tabOffsetYForRecommend", "B0", "isScrollingByTabClick", "Lcom/tencent/ecommerce/biz/detail/utils/c;", "C0", "Lcom/tencent/ecommerce/biz/detail/utils/c;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECGlobalShowWindowViewModel;", "D0", "Ci", "()Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECGlobalShowWindowViewModel;", "ecGlobalShowWindowViewModel", "com/tencent/ecommerce/biz/detail/fragment/ECShopDetailDistributionFragment$b", "E0", "Lcom/tencent/ecommerce/biz/detail/fragment/ECShopDetailDistributionFragment$b;", "addProductEventObserver", "com/tencent/ecommerce/biz/detail/fragment/ECShopDetailDistributionFragment$h", "F0", "Lcom/tencent/ecommerce/biz/detail/fragment/ECShopDetailDistributionFragment$h;", "observer", "<init>", "()V", "G0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopDetailDistributionFragment extends ECBaseFragment {

    /* renamed from: A0, reason: from kotlin metadata */
    private int tabOffsetYForRecommend;

    /* renamed from: B0, reason: from kotlin metadata */
    private boolean isScrollingByTabClick;

    /* renamed from: C0, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.utils.c reportParams;

    /* renamed from: D0, reason: from kotlin metadata */
    private final Lazy ecGlobalShowWindowViewModel;

    /* renamed from: E0, reason: from kotlin metadata */
    private final b addProductEventObserver;

    /* renamed from: F0, reason: from kotlin metadata */
    private final h observer;

    /* renamed from: P, reason: from kotlin metadata */
    private ECShopProductDetailDistributorViewModel viewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private LinearLayout rootLayout;

    /* renamed from: R, reason: from kotlin metadata */
    private View titleBar;

    /* renamed from: S, reason: from kotlin metadata */
    private ECBaseRecyclerView detailPageRecyclerView;

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.ui.d ecBaseRecyclerViewAdapter;

    /* renamed from: U, reason: from kotlin metadata */
    private ImageView blackBackButton;

    /* renamed from: V, reason: from kotlin metadata */
    private ECTabLayout tabLayout;

    /* renamed from: W, reason: from kotlin metadata */
    private a tabLayoutController;

    /* renamed from: X, reason: from kotlin metadata */
    private ECBasePtsView shopBottomBar;

    /* renamed from: Y, reason: from kotlin metadata */
    private ViewGroup shopBottomBarContainer;

    /* renamed from: Z, reason: from kotlin metadata */
    private ECBaseViewController shopBottomBarController;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private View shopNetworkErrorContainer;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private View shopNetworkErrorRetryBtn;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ViewGroup loadingViewContainer;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private ECShopProductDetailInfo productDetailInfo;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private int scrollY;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private int channel;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private String saasType = "";

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private String goodsType = "";

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private String sellerId = "";

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private String mediaProductID = "";

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private String sealTransfer = "";

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private String sourceFrom = String.valueOf(ECSourceFrom.SOURCE_FROM_UNKNOWN.ordinal());

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private String adClickId = "";

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private String requestId = "";

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private String bizType = "";

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private String shopId = "";

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private String spuId = "";

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private String littleWorldFeedId = "";

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private int role = 1;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private final Lazy lifecycleScope;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.utils.b detailPageDurationReport;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private int scrollerState;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, Integer> itemHeightMap;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private int titleBarOffset;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private int tabOffsetYForComment;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private int tabOffsetYForDetail;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopDetailDistributionFragment$b", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lri0/a;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements EventObserver<ECAddProductToWindowEvent> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECAddProductToWindowEvent event) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            JSONObject optJSONObject;
            ECShopProductDetailInfo eCShopProductDetailInfo = ECShopDetailDistributionFragment.this.productDetailInfo;
            if (eCShopProductDetailInfo == null || (jSONObject2 = eCShopProductDetailInfo.infoData) == null || (optJSONObject = jSONObject2.optJSONObject("product")) == null || (jSONObject = optJSONObject.optJSONObject("product_id_info")) == null) {
                jSONObject = new JSONObject();
            }
            if (Intrinsics.areEqual(event.saasProductId, jSONObject.optString("id", "")) && event.isAdded) {
                ECShopDetailDistributionFragment.this.Ri();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FragmentActivity activity = ECShopDetailDistributionFragment.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopDetailDistributionFragment$d", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout$OnTabClickListener;", "Lcom/tencent/ecommerce/base/ui/tabbar/a;", "data", "", "position", "", "onTabClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements ECTabLayout.OnTabClickListener {
        d() {
        }

        @Override // com.tencent.ecommerce.base.ui.tabbar.ECTabLayout.OnTabClickListener
        public void onTabClick(ECTabCoverInfo data, int position) {
            if (ECShopDetailDistributionFragment.Oh(ECShopDetailDistributionFragment.this).getChildCount() > 0 && ECShopDetailDistributionFragment.ei(ECShopDetailDistributionFragment.this).getAlpha() != 0.0f) {
                if (position != ECShopDetailDistributionFragment.ei(ECShopDetailDistributionFragment.this).getSelectedIndex()) {
                    ECShopDetailDistributionFragment.this.isScrollingByTabClick = true;
                }
                ECShopDetailDistributionFragment.fi(ECShopDetailDistributionFragment.this).a(position);
                String str = data.tabIdentifier;
                if (str != null) {
                    ECShopDetailDistributionFragment.this.Qi(ECShopDetailDistributionFragment.Qh(ECShopDetailDistributionFragment.this).j0(str));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECShopDetailDistributionFragment.this.Oi();
            ECShopDetailDistributionFragment.this.Si(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopDetailDistributionFragment$f", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f extends com.tencent.ecommerce.base.ui.e {
        f() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str = "mqqapi://ecommerce/open?target=52&channel=2&page_name=ApplySampleAgreement&shop_id=" + ECShopDetailDistributionFragment.this.shopId + "&spu_id=" + ECShopDetailDistributionFragment.this.spuId + "&is_sample=1&modal_mode=1";
            cg0.a.b("ECShopDetailDistributionFragment", "Apply Sample " + str);
            ECScheme.g(str, null, 2, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopDetailDistributionFragment$g", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g extends com.tencent.ecommerce.base.ui.e {
        g() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            JSONObject jSONObject;
            ECGlobalShowWindowViewModel Ci = ECShopDetailDistributionFragment.this.Ci();
            Context requireContext = ECShopDetailDistributionFragment.this.requireContext();
            String str = ECShopDetailDistributionFragment.this.saasType;
            String str2 = ECShopDetailDistributionFragment.this.spuId;
            String str3 = ECShopDetailDistributionFragment.this.goodsType;
            ECShopProductDetailInfo eCShopProductDetailInfo = ECShopDetailDistributionFragment.this.productDetailInfo;
            if (eCShopProductDetailInfo == null || (jSONObject = eCShopProductDetailInfo.infoData) == null) {
                jSONObject = new JSONObject();
            }
            Ci.N1(requireContext, str, str2, str3, jSONObject);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopDetailDistributionFragment$h", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lzi0/a;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements EventObserver<ECForegroundEvent> {
        h() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECForegroundEvent event) {
            boolean z16 = event.isForeground;
            if (z16) {
                ECShopDetailDistributionFragment eCShopDetailDistributionFragment = ECShopDetailDistributionFragment.this;
                eCShopDetailDistributionFragment.detailPageDurationReport = new com.tencent.ecommerce.biz.detail.utils.b(eCShopDetailDistributionFragment.sourceFrom);
                com.tencent.ecommerce.biz.detail.utils.b bVar = ECShopDetailDistributionFragment.this.detailPageDurationReport;
                if (bVar != null) {
                    bVar.d();
                }
                ECShopDetailDistributionFragment.this.Pi();
                return;
            }
            if (z16) {
                return;
            }
            com.tencent.ecommerce.biz.detail.utils.b bVar2 = ECShopDetailDistributionFragment.this.detailPageDurationReport;
            if (bVar2 != null) {
                com.tencent.ecommerce.biz.detail.utils.b.c(bVar2, null, 1, null);
            }
            com.tencent.ecommerce.biz.detail.utils.b bVar3 = ECShopDetailDistributionFragment.this.detailPageDurationReport;
            if (bVar3 != null) {
                bVar3.f();
            }
            ECShopDetailDistributionFragment.this.detailPageDurationReport = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i<T> implements Observer<ECShopProductDetailInfo> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECShopProductDetailInfo eCShopProductDetailInfo) {
            ECShopDetailDistributionFragment.this.productDetailInfo = eCShopProductDetailInfo;
            ECShopDetailDistributionFragment.this.Ji();
            ECShopDetailDistributionFragment.this.Bi(eCShopProductDetailInfo);
            ECShopDetailDistributionFragment.this.Ki();
            com.tencent.ecommerce.biz.detail.utils.d.f102466a.f(ECShopDetailDistributionFragment.this.reportParams, null, "qstore_prd_detail_pg_exp");
            ECAdAttributionReporter.f101288c.k(ECShopDetailDistributionFragment.this.adClickId);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042&\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001 \u0002*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/Map;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j<T> implements Observer<Map<String, ? extends String>> {
        j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Map<String, String> map) {
            String str = map.get("QSTORE_PRD_DETAIL_EVENT_CODE");
            if (str != null) {
                com.tencent.ecommerce.biz.detail.utils.d.f102466a.f(ECShopDetailDistributionFragment.this.reportParams, null, str);
            }
            cg0.a.b("ECShopDetailDistributionFragment", "viewModel productDetailLiveData eventName: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042&\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001 \u0002*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/Map;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class l<T> implements Observer<Map<String, ? extends String>> {
        l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Map<String, String> map) {
            com.tencent.ecommerce.biz.detail.utils.d.f102466a.f(ECShopDetailDistributionFragment.this.reportParams, map, "qstore_prd_detail_pg_recommend_ck");
        }
    }

    public ECShopDetailDistributionFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopDetailDistributionFragment$lifecycleScope$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.MainScope();
            }
        });
        this.lifecycleScope = lazy;
        this.itemHeightMap = new ConcurrentHashMap();
        this.tabOffsetYForRecommend = Integer.MAX_VALUE;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopDetailDistributionFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.ecGlobalShowWindowViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECGlobalShowWindowViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopDetailDistributionFragment$$special$$inlined$viewModels$2
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
        this.addProductEventObserver = new b();
        this.observer = new h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECGlobalShowWindowViewModel Ci() {
        return (ECGlobalShowWindowViewModel) this.ecGlobalShowWindowViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope Di() {
        return (CoroutineScope) this.lifecycleScope.getValue();
    }

    private final String Ei() {
        if (this.scrollerState == 2) {
            return "5";
        }
        ECTabLayout eCTabLayout = this.tabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        return String.valueOf(eCTabLayout.getSelectedIndex() + 1);
    }

    private final String Fi(String key, Map<Object, ? extends Object> map, String defaultValue) {
        Intent intent;
        FragmentActivity activity = getActivity();
        String stringExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra(key);
        if (stringExtra != null) {
            return stringExtra;
        }
        if (!map.containsKey(key) || !(map.get(key) instanceof String)) {
            return defaultValue;
        }
        Object obj = map.get(key);
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void Hi() {
        ImageView imageView = this.blackBackButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blackBackButton");
        }
        imageView.setOnClickListener(new c());
        ECBaseRecyclerView eCBaseRecyclerView = this.detailPageRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        eCBaseRecyclerView.addOnScrollListener(new ECShopDetailDistributionFragment$initListeners$2(this));
        ECTabLayout eCTabLayout = this.tabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        eCTabLayout.setOnTabClickListener(new d());
        View view = this.shopNetworkErrorRetryBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopNetworkErrorRetryBtn");
        }
        view.setOnClickListener(new e());
    }

    private final void Ii() {
        ECBasePtsView eCBasePtsView = new ECBasePtsView(requireContext());
        ECBaseViewController eCBaseViewController = new ECBaseViewController(requireContext(), eCBasePtsView);
        Context requireContext = requireContext();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("show_head", true);
        Unit unit = Unit.INSTANCE;
        eCBaseViewController.h(requireContext, new ECBasePtsViewData(null, "qshop_detail_loading", jSONObject.toString(), null, 9, null));
        ViewGroup viewGroup = this.loadingViewContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingViewContainer");
        }
        viewGroup.addView(eCBasePtsView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ji() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject optJSONObject;
        ECShopProductDetailInfo eCShopProductDetailInfo = this.productDetailInfo;
        if (eCShopProductDetailInfo == null || (jSONObject2 = eCShopProductDetailInfo.infoData) == null || (optJSONObject = jSONObject2.optJSONObject("product")) == null || (jSONObject = optJSONObject.optJSONObject("product_id_info")) == null) {
            jSONObject = new JSONObject();
        }
        this.saasType = jSONObject.optString("sub_type", "");
        this.spuId = jSONObject.optString("id", "");
        this.goodsType = jSONObject.optString("type", "101");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ki() {
        ECShopProductDetailInfo eCShopProductDetailInfo = this.productDetailInfo;
        if (eCShopProductDetailInfo != null) {
            JSONObject optJSONObject = eCShopProductDetailInfo.infoData.optJSONObject("user_right");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            this.role = optJSONObject.optInt("role_id", 1);
            if (!TextUtils.isEmpty(eCShopProductDetailInfo.infoData.optString("spu_id"))) {
                this.spuId = eCShopProductDetailInfo.infoData.optString("spu_id");
            }
            JSONObject optJSONObject2 = eCShopProductDetailInfo.infoData.optJSONObject("shop");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            if (!TextUtils.isEmpty(optJSONObject2.optString("id"))) {
                this.shopId = optJSONObject2.optString("id");
            }
        }
        Pi();
        com.tencent.ecommerce.biz.detail.utils.c cVar = new com.tencent.ecommerce.biz.detail.utils.c();
        cVar.g(2);
        cVar.q(this.sellerId);
        cVar.r(this.shopId);
        cVar.i("0");
        cVar.t(this.spuId);
        cVar.m(this.role);
        cVar.h("0");
        cVar.s(this.sourceFrom);
        cVar.n("0");
        cVar.o("0");
        cVar.d(this.littleWorldFeedId);
        cVar.f(1);
        cVar.a("0");
        cVar.k("0");
        cVar.b(0);
        cVar.l(this.requestId);
        cVar.p(this.sealTransfer);
        Unit unit = Unit.INSTANCE;
        this.reportParams = cVar;
        com.tencent.ecommerce.biz.detail.ui.d dVar = this.ecBaseRecyclerViewAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        dVar.y0(this.reportParams);
    }

    private final void Li() {
        Map<String, ? extends IPTSLiteEventListener> mapOf;
        Context requireContext = requireContext();
        ECBasePtsView eCBasePtsView = this.shopBottomBar;
        if (eCBasePtsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopBottomBar");
        }
        ECBaseViewController eCBaseViewController = new ECBaseViewController(requireContext, eCBasePtsView);
        this.shopBottomBarController = eCBaseViewController;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("shopApplyAction", new f()), TuplesKt.to("addWindow", new g()));
        eCBaseViewController.i(mapOf);
    }

    private final void Mi() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("spu_id", this.spuId);
        ECShopProductDetailDistributorViewModel eCShopProductDetailDistributorViewModel = this.viewModel;
        if (eCShopProductDetailDistributorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailDistributorViewModel.s2(this.spuId, jSONObject);
    }

    private final void Ni() {
        ECShopProductDetailDistributorViewModel eCShopProductDetailDistributorViewModel = this.viewModel;
        if (eCShopProductDetailDistributorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailDistributorViewModel.a2().observe(getViewLifecycleOwner(), new Observer<List<? extends ECBasePtsViewData>>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopDetailDistributionFragment$registerLivedataObserver$1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(final List<ECBasePtsViewData> list) {
                ECShopDetailDistributionFragment.this.Si(false);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                if (ECShopDetailDistributionFragment.ki(ECShopDetailDistributionFragment.this).l2(arrayList)) {
                    ECShopDetailDistributionFragment.Qh(ECShopDetailDistributionFragment.this).addData(arrayList);
                } else {
                    ECShopDetailDistributionFragment.Qh(ECShopDetailDistributionFragment.this).setData(arrayList);
                }
                ECShopDetailDistributionFragment.Oh(ECShopDetailDistributionFragment.this).post(new Runnable() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopDetailDistributionFragment$registerLivedataObserver$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i3;
                        int i16;
                        Map map;
                        Map map2;
                        Map map3;
                        int i17;
                        PTSAppInstance ptsAppInstance;
                        PTSRootNode rootNode;
                        PTSNodeInfo rootNodeInfo;
                        PTSNodeStyle style;
                        int size = list.size();
                        int i18 = 0;
                        boolean z16 = false;
                        for (int i19 = 0; i19 < size; i19++) {
                            ECBasePtsViewData eCBasePtsViewData = (ECBasePtsViewData) list.get(i19);
                            PTSComposer ptsComposer = eCBasePtsViewData.getPtsComposer();
                            if (i19 == 0) {
                                z16 = !Intrinsics.areEqual("product_detail_mainpic", ptsComposer != null ? ptsComposer.getPageName() : null);
                            }
                            Integer valueOf = (ptsComposer == null || (ptsAppInstance = ptsComposer.getPtsAppInstance()) == null || (rootNode = ptsAppInstance.getRootNode()) == null || (rootNodeInfo = rootNode.getRootNodeInfo()) == null || (style = rootNodeInfo.getStyle()) == null) ? null : Integer.valueOf(style.getHeight());
                            if (Intrinsics.areEqual(eCBasePtsViewData.getPageName(), "qshop_chart_info_view_container") && valueOf != null && valueOf.intValue() > 0) {
                                valueOf = Integer.valueOf(valueOf.intValue() + e.c(264.0f));
                            }
                            if (Intrinsics.areEqual("qshop_detail_comment", ptsComposer != null ? ptsComposer.getPageName() : null)) {
                                ECShopDetailDistributionFragment eCShopDetailDistributionFragment = ECShopDetailDistributionFragment.this;
                                i17 = eCShopDetailDistributionFragment.titleBarOffset;
                                eCShopDetailDistributionFragment.tabOffsetYForComment = i18 - i17;
                            } else if (Intrinsics.areEqual("qshop_product_detail_table_title", ptsComposer != null ? ptsComposer.getPageName() : null)) {
                                ECShopDetailDistributionFragment eCShopDetailDistributionFragment2 = ECShopDetailDistributionFragment.this;
                                i16 = eCShopDetailDistributionFragment2.titleBarOffset;
                                eCShopDetailDistributionFragment2.tabOffsetYForDetail = i18 - i16;
                            } else if (Intrinsics.areEqual("qshop_detail_recommen_title_new", ptsComposer != null ? ptsComposer.getPageName() : null)) {
                                ECShopDetailDistributionFragment eCShopDetailDistributionFragment3 = ECShopDetailDistributionFragment.this;
                                i3 = eCShopDetailDistributionFragment3.titleBarOffset;
                                eCShopDetailDistributionFragment3.tabOffsetYForRecommend = i18 - i3;
                            }
                            if (valueOf != null) {
                                i18 += valueOf.intValue();
                                if (z16) {
                                    map2 = ECShopDetailDistributionFragment.this.itemHeightMap;
                                    map3 = ECShopDetailDistributionFragment.this.itemHeightMap;
                                    map2.put(Integer.valueOf(map3.size()), valueOf);
                                } else {
                                    map = ECShopDetailDistributionFragment.this.itemHeightMap;
                                    map.put(Integer.valueOf(i19), valueOf);
                                }
                            }
                        }
                    }
                });
            }
        });
        ECShopProductDetailDistributorViewModel eCShopProductDetailDistributorViewModel2 = this.viewModel;
        if (eCShopProductDetailDistributorViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailDistributorViewModel2.e2().observe(getViewLifecycleOwner(), new i());
        ECShopProductDetailDistributorViewModel eCShopProductDetailDistributorViewModel3 = this.viewModel;
        if (eCShopProductDetailDistributorViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailDistributorViewModel3.h2().observe(getViewLifecycleOwner(), new j());
        ECShopProductDetailDistributorViewModel eCShopProductDetailDistributorViewModel4 = this.viewModel;
        if (eCShopProductDetailDistributorViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailDistributorViewModel4.i2().observe(getViewLifecycleOwner(), new Observer<Integer>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopDetailDistributionFragment$registerLivedataObserver$4

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
            @DebugMetadata(c = "com.tencent.ecommerce.biz.detail.fragment.ECShopDetailDistributionFragment$registerLivedataObserver$4$1", f = "ECShopDetailDistributionFragment.kt", i = {}, l = {441}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.ecommerce.biz.detail.fragment.ECShopDetailDistributionFragment$registerLivedataObserver$4$1, reason: invalid class name */
            /* loaded from: classes31.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ JSONArray $spuIdList;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(JSONArray jSONArray, Continuation continuation) {
                    super(2, continuation);
                    this.$spuIdList = jSONArray;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$spuIdList, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ECShopProductDetailDistributorViewModel ki5 = ECShopDetailDistributionFragment.ki(ECShopDetailDistributionFragment.this);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("spu_id", ECShopDetailDistributionFragment.this.spuId);
                        jSONObject.put("spu_ids", this.$spuIdList);
                        jSONObject.put("is_first_screen_recommend", false);
                        Unit unit = Unit.INSTANCE;
                        this.label = 1;
                        if (ki5.t2(jSONObject, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(Integer num) {
                int i3;
                int i16;
                boolean z16;
                int i17;
                int i18;
                int i19;
                int i26;
                CoroutineScope Di;
                if (num.intValue() > 530) {
                    ECShopDetailDistributionFragment.ei(ECShopDetailDistributionFragment.this).setAlpha(1.0f);
                } else {
                    ECShopDetailDistributionFragment.ei(ECShopDetailDistributionFragment.this).setAlpha(num.intValue() / 530);
                }
                ECShopDetailDistributionFragment eCShopDetailDistributionFragment = ECShopDetailDistributionFragment.this;
                if (num.intValue() == 0) {
                    i3 = 1;
                } else {
                    i3 = !ECShopDetailDistributionFragment.Oh(ECShopDetailDistributionFragment.this).canScrollVertically(1) ? 2 : 0;
                }
                eCShopDetailDistributionFragment.scrollerState = i3;
                i16 = ECShopDetailDistributionFragment.this.scrollerState;
                if (i16 == 2) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.mo162put(ECShopDetailDistributionFragment.this.spuId);
                    Di = ECShopDetailDistributionFragment.this.Di();
                    BuildersKt__Builders_commonKt.launch$default(Di, null, null, new AnonymousClass1(jSONArray, null), 3, null);
                }
                z16 = ECShopDetailDistributionFragment.this.isScrollingByTabClick;
                if (z16) {
                    return;
                }
                int intValue = num.intValue();
                i17 = ECShopDetailDistributionFragment.this.tabOffsetYForRecommend;
                if (intValue < i17) {
                    i18 = ECShopDetailDistributionFragment.this.scrollerState;
                    if (i18 != 2) {
                        int intValue2 = num.intValue();
                        i19 = ECShopDetailDistributionFragment.this.tabOffsetYForDetail;
                        if (intValue2 >= i19) {
                            ECShopDetailDistributionFragment.fi(ECShopDetailDistributionFragment.this).a(2);
                            return;
                        }
                        int intValue3 = num.intValue();
                        i26 = ECShopDetailDistributionFragment.this.tabOffsetYForComment;
                        if (intValue3 >= i26) {
                            ECShopDetailDistributionFragment.fi(ECShopDetailDistributionFragment.this).a(1);
                            return;
                        } else {
                            ECShopDetailDistributionFragment.fi(ECShopDetailDistributionFragment.this).a(0);
                            return;
                        }
                    }
                }
                ECShopDetailDistributionFragment.fi(ECShopDetailDistributionFragment.this).a(3);
            }
        });
        ECShopProductDetailDistributorViewModel eCShopProductDetailDistributorViewModel5 = this.viewModel;
        if (eCShopProductDetailDistributorViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailDistributorViewModel5.d2().observe(getViewLifecycleOwner(), new k());
        com.tencent.ecommerce.biz.detail.ui.d dVar = this.ecBaseRecyclerViewAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        dVar.u0().observe(getViewLifecycleOwner(), new l());
    }

    public static final /* synthetic */ ECBaseRecyclerView Oh(ECShopDetailDistributionFragment eCShopDetailDistributionFragment) {
        ECBaseRecyclerView eCBaseRecyclerView = eCShopDetailDistributionFragment.detailPageRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        return eCBaseRecyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oi() {
        BuildersKt__Builders_commonKt.launch$default(Di(), null, null, new ECShopDetailDistributionFragment$requestData$1(this, null), 3, null);
    }

    public static final /* synthetic */ com.tencent.ecommerce.biz.detail.ui.d Qh(ECShopDetailDistributionFragment eCShopDetailDistributionFragment) {
        com.tencent.ecommerce.biz.detail.ui.d dVar = eCShopDetailDistributionFragment.ecBaseRecyclerViewAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ri() {
        ECShopProductDetailDistributorViewModel eCShopProductDetailDistributorViewModel = this.viewModel;
        if (eCShopProductDetailDistributorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        ECShopProductDetailInfo value = eCShopProductDetailDistributorViewModel.e2().getValue();
        if (value != null) {
            JSONObject jSONObject = new JSONObject(value.infoData.toString());
            jSONObject.put("is_add", true);
            ECBaseViewController eCBaseViewController = this.shopBottomBarController;
            if (eCBaseViewController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shopBottomBarController");
            }
            eCBaseViewController.h(requireContext(), new ECBasePtsViewData(null, "qshop_detail_bottom_bar_host", jSONObject.toString(), null, 9, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Si(boolean isLoading) {
        if (isLoading) {
            ViewGroup viewGroup = this.loadingViewContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingViewContainer");
            }
            viewGroup.setVisibility(0);
            return;
        }
        ViewGroup viewGroup2 = this.loadingViewContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingViewContainer");
        }
        viewGroup2.setVisibility(8);
    }

    public static final /* synthetic */ View bi(ECShopDetailDistributionFragment eCShopDetailDistributionFragment) {
        View view = eCShopDetailDistributionFragment.shopNetworkErrorContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopNetworkErrorContainer");
        }
        return view;
    }

    public static final /* synthetic */ ECTabLayout ei(ECShopDetailDistributionFragment eCShopDetailDistributionFragment) {
        ECTabLayout eCTabLayout = eCShopDetailDistributionFragment.tabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        return eCTabLayout;
    }

    public static final /* synthetic */ a fi(ECShopDetailDistributionFragment eCShopDetailDistributionFragment) {
        a aVar = eCShopDetailDistributionFragment.tabLayoutController;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayoutController");
        }
        return aVar;
    }

    private final void initArguments() {
        Map<Object, Object> extUserDataMap = com.tencent.ecommerce.base.ktx.a.a(requireArguments(), "ext_userdata").getExtUserDataMap();
        this.channel = Integer.parseInt(Fi(WadlProxyConsts.CHANNEL, extUserDataMap, String.valueOf(QQECChannel.CHANNEL_UNKNOWN.ordinal())));
        this.sellerId = Gi(this, "seller_id", extUserDataMap, null, 4, null);
        this.mediaProductID = Gi(this, "media_product_id", extUserDataMap, null, 4, null);
        this.sealTransfer = Gi(this, QCircleLpReportDc05507.KEY_SEAL_TRANSFER, extUserDataMap, null, 4, null);
        this.sourceFrom = Fi("source_from", extUserDataMap, String.valueOf(ECSourceFrom.SOURCE_FROM_UNKNOWN.ordinal()));
        this.requestId = Gi(this, "request_id", extUserDataMap, null, 4, null);
        this.bizType = Gi(this, "biz_type", extUserDataMap, null, 4, null);
        this.shopId = Gi(this, "shop_id", extUserDataMap, null, 4, null);
        this.spuId = Gi(this, "spu_id", extUserDataMap, null, 4, null);
        this.adClickId = Fi("qz_gdt", extUserDataMap, "");
        this.titleBarOffset = r.f104881b.a(getActivity());
        this.littleWorldFeedId = Gi(this, "little_world_feed_id", extUserDataMap, null, 4, null);
        boolean areEqual = Intrinsics.areEqual(Fi("is_from_ec_goods", extUserDataMap, "0"), "1");
        if (areEqual) {
            this.sourceFrom = "1";
        }
        cg0.a.b("ECShopDetailDistributionFragment", "[initArguments] channel = " + this.channel + ", sellerId = " + this.sellerId + ", mediaProductID = " + this.mediaProductID + ", sourceFrom = " + this.sourceFrom + ", requestId = " + this.requestId + ", bizType = " + this.bizType + ", shopId = " + this.shopId + ",spuId = " + this.spuId + ", titleBarOffset = " + this.titleBarOffset + ", littleWorldFeedId = " + this.littleWorldFeedId + ", isFromGoods = " + areEqual);
    }

    public static final /* synthetic */ ECShopProductDetailDistributorViewModel ki(ECShopDetailDistributionFragment eCShopDetailDistributionFragment) {
        ECShopProductDetailDistributorViewModel eCShopProductDetailDistributorViewModel = eCShopDetailDistributionFragment.viewModel;
        if (eCShopProductDetailDistributorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return eCShopProductDetailDistributorViewModel;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopDetailDistributionFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cue;
    }

    public final void initViewModel() {
        this.viewModel = (ECShopProductDetailDistributorViewModel) new com.tencent.ecommerce.biz.detail.viewmodel.shop.c(getArguments(), getChildFragmentManager()).create(ECShopProductDetailDistributorViewModel.class);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initArguments();
        initViewModel();
        this.detailPageDurationReport = new com.tencent.ecommerce.biz.detail.utils.b(this.sourceFrom);
        LifecycleEventBus lifecycleEventBus = LifecycleEventBus.f100688b;
        h hVar = this.observer;
        ThreadMode threadMode = ThreadMode.ORIGIN;
        lifecycleEventBus.d(threadMode, ECForegroundEvent.class, hVar);
        lifecycleEventBus.d(threadMode, ECAddProductToWindowEvent.class, this.addProductEventObserver);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CoroutineScopeKt.cancel$default(Di(), null, 1, null);
        LifecycleEventBus lifecycleEventBus = LifecycleEventBus.f100688b;
        lifecycleEventBus.e(this.observer);
        lifecycleEventBus.e(this.addProductEventObserver);
        com.tencent.ecommerce.biz.detail.utils.b bVar = this.detailPageDurationReport;
        if (bVar != null) {
            bVar.b("qstore_prd_detail_pg_duration");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("depth", Ei());
        com.tencent.ecommerce.biz.detail.utils.d.f102466a.f(this.reportParams, linkedHashMap, "qstore_prd_detail_pg_browse_depth");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ECRMonitorManager.f100953c.b("STATE_SHOP_DETAIL_PAGE_DISTRIBUTION");
        com.tencent.ecommerce.biz.detail.ui.d dVar = this.ecBaseRecyclerViewAdapter;
        if (dVar != null) {
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
            }
            dVar.r0();
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ECRMonitorManager.f100953c.c("STATE_SHOP_DETAIL_PAGE_DISTRIBUTION");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        Hi();
        Oi();
        Mi();
        Ni();
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.b("shop_id", this.shopId);
        eVar.b("spu_id", this.spuId);
        eVar.b("is_sample", "1");
        IECDataReport.a.a(bVar, "qstore_b_prd_detail_page_exp", eVar.f(), false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bi(ECShopProductDetailInfo shopDetailInfo) {
        ViewGroup viewGroup = this.shopBottomBarContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopBottomBarContainer");
        }
        viewGroup.setVisibility(0);
        JSONObject jSONObject = shopDetailInfo.infoData;
        jSONObject.put("is_sample", 1);
        jSONObject.put("apply_text", "\u514d\u8d39\u7533\u6837");
        JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
        ECBaseViewController eCBaseViewController = this.shopBottomBarController;
        if (eCBaseViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopBottomBarController");
        }
        eCBaseViewController.h(requireContext(), new ECBasePtsViewData(null, "qshop_detail_bottom_bar_host", jSONObject2.toString(), null, 9, null));
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.b("shop_id", this.shopId);
        eVar.b("spu_id", this.spuId);
        IECDataReport.a.a(bVar, "qstore_prd_detail_sample_btn_exp", eVar.f(), false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Pi() {
        com.tencent.ecommerce.biz.detail.utils.b bVar = this.detailPageDurationReport;
        if (bVar != null) {
            bVar.e(new ECDetailPageDuration(2, this.shopId, this.spuId, "0", String.valueOf(ug0.b.f438933d.e()), QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount(), this.sellerId, "", "0", "0", "0", "", "0", 0L, 0L, this.sourceFrom, this.littleWorldFeedId, this.sealTransfer, this.requestId, this.role));
        }
    }

    private final void initUI(View rootView) {
        this.rootLayout = (LinearLayout) rootView.findViewById(R.id.o9i);
        this.titleBar = rootView.findViewById(R.id.nzl);
        this.blackBackButton = (ImageView) rootView.findViewById(R.id.nwm);
        this.detailPageRecyclerView = (ECBaseRecyclerView) rootView.findViewById(R.id.nve);
        this.tabLayout = (ECTabLayout) rootView.findViewById(R.id.nwt);
        ECTabLayout eCTabLayout = this.tabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        this.tabLayoutController = new a(eCTabLayout, true);
        this.shopBottomBar = (ECBasePtsView) rootView.findViewById(R.id.nwu);
        this.shopBottomBarContainer = (ViewGroup) rootView.findViewById(R.id.nwv);
        this.shopNetworkErrorContainer = rootView.findViewById(R.id.f163071o51);
        this.shopNetworkErrorRetryBtn = rootView.findViewById(R.id.f163072o52);
        this.loadingViewContainer = (ViewGroup) rootView.findViewById(R.id.nww);
        ECShopProductDetailDistributorViewModel eCShopProductDetailDistributorViewModel = this.viewModel;
        if (eCShopProductDetailDistributorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        this.ecBaseRecyclerViewAdapter = new com.tencent.ecommerce.biz.detail.ui.d(requireContext(), eCShopProductDetailDistributorViewModel);
        ECTabLayout eCTabLayout2 = this.tabLayout;
        if (eCTabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        eCTabLayout2.setVisibility(0);
        a aVar = this.tabLayoutController;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayoutController");
        }
        aVar.b();
        Li();
        Ii();
        Si(true);
        ECBaseRecyclerView eCBaseRecyclerView = this.detailPageRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        eCBaseRecyclerView.setItemAnimator(null);
        eCBaseRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        com.tencent.ecommerce.biz.detail.ui.d dVar = this.ecBaseRecyclerViewAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        eCBaseRecyclerView.setAdapter(dVar);
        ECBaseRecyclerView eCBaseRecyclerView2 = this.detailPageRecyclerView;
        if (eCBaseRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        int c16 = com.tencent.ecommerce.biz.util.e.c(12.0f);
        int c17 = com.tencent.ecommerce.biz.util.e.c(16.0f);
        int c18 = com.tencent.ecommerce.biz.util.e.c(11.0f);
        com.tencent.ecommerce.biz.detail.ui.d dVar2 = this.ecBaseRecyclerViewAdapter;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        eCBaseRecyclerView2.addItemDecoration(new ECShopDetailItemDecoration(c16, c17, c18, 2, dVar2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k<T> implements Observer<Integer> {
        k() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            if (num != null && num.intValue() == 1) {
                ECShopDetailDistributionFragment.ei(ECShopDetailDistributionFragment.this).setVisibility(8);
                return;
            }
            if (num != null && num.intValue() == 2) {
                ECShopDetailDistributionFragment.bi(ECShopDetailDistributionFragment.this).setVisibility(0);
                ECShopDetailDistributionFragment.this.Si(false);
            } else if (num != null && num.intValue() == 3) {
                ECShopDetailDistributionFragment.bi(ECShopDetailDistributionFragment.this).setVisibility(8);
            }
        }
    }

    static /* synthetic */ String Gi(ECShopDetailDistributionFragment eCShopDetailDistributionFragment, String str, Map map, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        return eCShopDetailDistributionFragment.Fi(str, map, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qi(int targetPosition) {
        int i3 = 0;
        for (int i16 = 0; i16 < targetPosition; i16++) {
            Integer num = this.itemHeightMap.get(Integer.valueOf(i16));
            i3 += num != null ? num.intValue() : 0;
        }
        int i17 = (i3 - this.scrollY) - this.titleBarOffset;
        if (Math.abs(i17) >= 1000) {
            ECBaseRecyclerView eCBaseRecyclerView = this.detailPageRecyclerView;
            if (eCBaseRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
            }
            eCBaseRecyclerView.smoothScrollBy(0, i17, new AccelerateDecelerateInterpolator(), 300);
            return;
        }
        ECBaseRecyclerView eCBaseRecyclerView2 = this.detailPageRecyclerView;
        if (eCBaseRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        eCBaseRecyclerView2.smoothScrollBy(0, i17);
    }
}
