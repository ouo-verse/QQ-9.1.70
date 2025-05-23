package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import bi0.ECHREvent;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ktx.TextViewKt;
import com.tencent.ecommerce.base.ktx.ViewExtKt;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.list.ListRepository;
import com.tencent.ecommerce.base.list.ListViewModel;
import com.tencent.ecommerce.base.list.ListViewModelLazyKt$listViewModels$1;
import com.tencent.ecommerce.base.list.ListViewModelLazyKt$listViewModels$2;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.SlidingUpDialog;
import com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.advertise.ECAdAttributionReporter;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderDetailEntrance;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSubmitPriceInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.SimpleSku;
import com.tencent.ecommerce.biz.orders.realname.RealNameAccount;
import com.tencent.ecommerce.biz.orders.realname.RealNameAccountsReqInfo;
import com.tencent.ecommerce.biz.orders.realname.widgets.CreateRealNameLayout;
import com.tencent.ecommerce.biz.orders.realname.widgets.SelectRealNameLayout;
import com.tencent.ecommerce.biz.orders.span.ECOrderOperation;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import com.tencent.ecommerce.biz.register.ECommerceCaptchaVerifyDialog;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$OrderPageDetailRsp;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00df\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001o\b\u0016\u0018\u0000 \u00b2\u00012\u00020\u0001:\u0002\u00b3\u0001B\t\u00a2\u0006\u0006\b\u00b0\u0001\u0010\u00b1\u0001J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J \u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\rH\u0002J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\rH\u0002J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u0005H\u0002J&\u00102\u001a\u0002012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\r0+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0002J\u0012\u00104\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u00105\u001a\u00020\u000bH\u0016J\b\u00106\u001a\u00020\u0015H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\u0018\u0010:\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u0015H\u0016J\b\u0010;\u001a\u00020\rH\u0016J\b\u0010<\u001a\u00020\u0015H\u0016J\b\u0010=\u001a\u00020\u000bH\u0016J\b\u0010>\u001a\u00020\u000bH\u0016J\b\u0010?\u001a\u00020\u000bH\u0016J\u001a\u0010@\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010C\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010J\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010ER\u0018\u0010L\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010ER\u0018\u0010N\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010ER\u0018\u0010Q\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001b\u0010Z\u001a\u00020U8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u001b\u0010_\u001a\u00020[8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\\\u0010W\u001a\u0004\b]\u0010^R-\u0010e\u001a\u0014\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020\r0`8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010W\u001a\u0004\bc\u0010dR\u0018\u0010h\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010gR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010r\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010v\u001a\u00020s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010y\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010|\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0017\u0010\u0080\u0001\u001a\u00020}8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0082\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010{R\u0018\u0010\u0084\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010{R*\u0010\u008c\u0001\u001a\u00030\u0085\u00018\u0004@\u0004X\u0084.\u00a2\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R*\u0010\u0094\u0001\u001a\u00030\u008d\u00018\u0004@\u0004X\u0084.\u00a2\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0096\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0095\u0001\u0010xR\u001a\u0010\u009a\u0001\u001a\u00030\u0097\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0018\u0010\u009c\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u009b\u0001\u0010{R\u0018\u0010\u009e\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u009d\u0001\u0010xR\u001a\u0010\u00a0\u0001\u001a\u00030\u0097\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u0099\u0001R\u0018\u0010\u00a2\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u00a1\u0001\u0010{R\u0018\u0010\u00a6\u0001\u001a\u00030\u00a3\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001R \u0010\u00ab\u0001\u001a\u00030\u00a7\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a8\u0001\u0010W\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001R\u0018\u0010\u00af\u0001\u001a\u00030\u00ac\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ad\u0001\u0010\u00ae\u0001\u00a8\u0006\u00b4\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/os/Bundle;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "Ji", "", "Ni", "Landroid/view/View;", "view", "initViews", "Oi", "", "isQShop", "", "version", "Vi", "Landroid/widget/TextView;", "agreementContentView", "agreement", WadlProxyConsts.KEY_JUMP_URL, "Ui", "", "triggerFrom", "Xi", "Lcom/tencent/ecommerce/base/ui/SlidingUpDialog;", "Di", "Ei", "networkSuccess", "Ti", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "Si", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "errorMsg", "Bi", "Mi", "Ai", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$h$b;", "submitResult", "Ci", "initData", "Wi", "", "orderIds", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "payType", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;", "orderDetailRsp", "Lorg/json/JSONObject;", "zi", Constants.FILE_INSTANCE_STATE, "onCreate", "Pi", "Hi", "Ri", "isVisible", "bottomBarHeightPx", "Qi", "getBusinessDescription", "getContentLayoutId", "Bh", "Dh", "Eh", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "P", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "sku", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "adClickId", BdhLogUtil.LogTag.Tag_Req, "activityId", ExifInterface.LATITUDE_SOUTH, GetAdInfoRequest.SOURCE_FROM, "T", "contentId", "U", "groupId", "V", "Ljava/lang/Boolean;", "isBuyAll", "W", "Z", "hadShowRecheckLotteryDialog", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel;", "X", "Lkotlin/Lazy;", "Li", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel;", "viewModel", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECBlindBoxViewModel;", "Y", "Fi", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECBlindBoxViewModel;", "blindBoxViewModel", "Lcom/tencent/ecommerce/base/list/ListViewModel;", "Lcom/tencent/ecommerce/biz/orders/realname/b;", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "Ii", "()Lcom/tencent/ecommerce/base/list/ListViewModel;", "realNamelistViewModel", "a0", "Lcom/tencent/ecommerce/base/ui/SlidingUpDialog;", "createRealNameDialog", "b0", "selectRealNameDialog", "Lcom/tencent/ecommerce/biz/orders/realname/widgets/SelectRealNameLayout;", "c0", "Lcom/tencent/ecommerce/biz/orders/realname/widgets/SelectRealNameLayout;", "selectRealNameLayout", "com/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitFragment$itemOperationListener$1", "d0", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitFragment$itemOperationListener$1;", "itemOperationListener", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/g;", "e0", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/g;", "adapter", "f0", "Landroid/view/View;", "bottomArea", "g0", "Landroid/widget/TextView;", "priceTv", "Landroid/widget/ImageView;", "h0", "Landroid/widget/ImageView;", "belowZeroIv", "i0", "discountTv", "j0", "submitBtn", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "k0", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "Ki", "()Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "setStateView", "(Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;)V", "stateView", "Landroidx/recyclerview/widget/RecyclerView;", "l0", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "m0", "agreementContainer", "Landroid/widget/CheckBox;", "n0", "Landroid/widget/CheckBox;", "agreementCheckBox", "o0", "agreementContent", "p0", "privacyAgreementContainer", "q0", "privacyAgreementCheckBox", "r0", "privacyAgreementContent", "Lcom/tencent/ecommerce/base/report/service/k;", "s0", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTimeReporter", "Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog;", "t0", "Gi", "()Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog;", "captchaDialog", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "u0", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "checkedChangeListener", "<init>", "()V", "v0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class ECOrderSubmitFragment extends ECBaseFragment {

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private SimpleSku sku;

    /* renamed from: Q, reason: from kotlin metadata */
    private String adClickId;

    /* renamed from: R, reason: from kotlin metadata */
    private String activityId;

    /* renamed from: S, reason: from kotlin metadata */
    private String sourceFrom = "-1";

    /* renamed from: T, reason: from kotlin metadata */
    private String contentId;

    /* renamed from: U, reason: from kotlin metadata */
    private String groupId;

    /* renamed from: V, reason: from kotlin metadata */
    private Boolean isBuyAll;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean hadShowRecheckLotteryDialog;

    /* renamed from: X, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: Y, reason: from kotlin metadata */
    private final Lazy blindBoxViewModel;

    /* renamed from: Z, reason: from kotlin metadata */
    private final Lazy realNamelistViewModel;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private SlidingUpDialog createRealNameDialog;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private SlidingUpDialog selectRealNameDialog;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private SelectRealNameLayout selectRealNameLayout;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final ECOrderSubmitFragment$itemOperationListener$1 itemOperationListener;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.ecommerce.biz.orders.buyerorders.submit.g adapter;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private View bottomArea;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private TextView priceTv;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private ImageView belowZeroIv;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private TextView discountTv;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private TextView submitBtn;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    protected ECStateCenterView stateView;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    protected RecyclerView recyclerView;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private View agreementContainer;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private CheckBox agreementCheckBox;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private TextView agreementContent;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private View privacyAgreementContainer;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private CheckBox privacyAgreementCheckBox;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private TextView privacyAgreementContent;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.ecommerce.base.report.service.k showPageCostTimeReporter;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private final Lazy captchaDialog;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private final CompoundButton.OnCheckedChangeListener checkedChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitFragment$a;", "", "Landroid/os/Bundle;", "", "d", "c", "APP_ID", "Ljava/lang/String;", "BLIND_BOX_AGREEMENT_LINK", "BLIND_BOX_AGREEMENT_VERSION", "Q_SHOP_AGREEMENT_LINK", "Q_SHOP_AGREEMENT_VERSION", "Q_SHOP_PRIVACY_AGREEMENT_LINK", "Q_SHOP_PRIVACY_AGREEMENT_VERSION", "SOURCE_FROM_UNKNOWN", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String c(Bundle bundle) {
            String obj;
            String str = "";
            String string = bundle.getString("content_id", "");
            if (string == null) {
                string = "";
            }
            Object obj2 = com.tencent.ecommerce.base.ktx.a.a(bundle, "ext_userdata").getExtUserDataMap().get("content_id");
            if (obj2 != null && (obj = obj2.toString()) != null) {
                str = obj;
            }
            String optString = ug0.b.f438933d.f().optString("content_id");
            if (string.length() == 0) {
                return str.length() == 0 ? optString : str;
            }
            return string;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String d(Bundle bundle) {
            String obj;
            String str = "";
            String string = bundle.getString("source_from", "");
            if (string == null) {
                string = "";
            }
            Object obj2 = com.tencent.ecommerce.base.ktx.a.a(bundle, "ext_userdata").getExtUserDataMap().get("source_from");
            if (obj2 != null && (obj = obj2.toString()) != null) {
                str = obj;
            }
            String g16 = ug0.b.f438933d.g();
            if (string.length() == 0) {
                return str.length() == 0 ? g16 : str;
            }
            return string;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "view", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "checked", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: d, reason: collision with root package name */
        public static final b f103469d = new b();

        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            Drawable drawable;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (z16) {
                drawable = ECSkin.INSTANCE.getDrawable(R.drawable.e6v);
            } else {
                drawable = ECSkin.INSTANCE.getDrawable(R.drawable.e5s);
            }
            compoundButton.setBackground(drawable);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
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
            ECOrderSubmitFragment.this.Ri();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lbi0/a;", "event", "", "a", "(Lbi0/a;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d<T> implements EventObserver<ECHREvent> {
        d() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onEvent(ECHREvent eCHREvent) {
            if (!Intrinsics.areEqual(eCHREvent.getEventName(), "select_coupon_event")) {
                return;
            }
            JSONArray optJSONArray = eCHREvent.getData().optJSONArray("ids");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = optJSONArray.optString(i3);
                if (optString != null) {
                    arrayList.add(optString);
                }
            }
            ECOrderSubmitFragment.this.Li().S2(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<ECOrderSubmitViewModel.g> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECOrderSubmitViewModel.g gVar) {
            if (Intrinsics.areEqual(gVar, ECOrderSubmitViewModel.g.c.f103527a)) {
                IStateCenterView.a.c(ECOrderSubmitFragment.this.Ki(), null, 1, null);
                return;
            }
            if (Intrinsics.areEqual(gVar, ECOrderSubmitViewModel.g.d.f103528a)) {
                ECOrderSubmitFragment.this.Ki().setSucceededState();
                ECOrderSubmitFragment.this.Ti(true);
            } else if (gVar instanceof ECOrderSubmitViewModel.g.Empty) {
                IStateCenterView.a.a(ECOrderSubmitFragment.this.Ki(), ((ECOrderSubmitViewModel.g.Empty) gVar).msg, null, 0, 6, null);
                ECOrderSubmitFragment.this.Ti(true);
            } else if (gVar instanceof ECOrderSubmitViewModel.g.Error) {
                IStateCenterView.a.b(ECOrderSubmitFragment.this.Ki(), null, 1, null);
                ECOrderSubmitFragment.this.Ti(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/p;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f<T> implements Observer<List<? extends p>> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<? extends p> list) {
            ECOrderSubmitFragment.Wh(ECOrderSubmitFragment.this).setVisibility(list.isEmpty() ^ true ? 0 : 8);
            ECOrderSubmitFragment.this.Qi(!r1.isEmpty(), com.tencent.ecommerce.biz.util.e.c(60.0f));
            ECOrderSubmitFragment.this.adapter.n0(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/h;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/h;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g<T> implements Observer<OrderSubmitPriceInfo> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(OrderSubmitPriceInfo orderSubmitPriceInfo) {
            Object tag = ECOrderSubmitFragment.di(ECOrderSubmitFragment.this).getTag(R.id.o6t);
            if (!(tag instanceof Long)) {
                tag = null;
            }
            Long l3 = (Long) tag;
            long longValue = l3 != null ? l3.longValue() : 0L;
            ECOrderSubmitFragment.di(ECOrderSubmitFragment.this).setTag(R.id.o6t, Long.valueOf(orderSubmitPriceInfo.totalPrice));
            TextViewKt.d(ECOrderSubmitFragment.di(ECOrderSubmitFragment.this), longValue, orderSubmitPriceInfo.totalPrice, R.dimen.f9980u, R.dimen.f9970t, R.dimen.f9960s);
            if (orderSubmitPriceInfo.totalDiscount == 0) {
                ECOrderSubmitFragment.Zh(ECOrderSubmitFragment.this).setVisibility(8);
                return;
            }
            ECOrderSubmitFragment.Zh(ECOrderSubmitFragment.this).setVisibility(0);
            ECOrderSubmitFragment.Zh(ECOrderSubmitFragment.this).setText("\u5df2\u4f18\u60e0\u00a5" + com.tencent.ecommerce.biz.util.j.f104870a.a(orderSubmitPriceInfo.totalDiscount));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h<T> implements Observer<Boolean> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECOrderSubmitFragment.Uh(ECOrderSubmitFragment.this).setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i<T> implements Observer<Boolean> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECOrderSubmitFragment.mi(ECOrderSubmitFragment.this).setEnabled(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j<T> implements Observer<String> {
        j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(String str) {
            ECOrderSubmitFragment.this.Vi(false, str);
            if (str.length() > 0) {
                ECOrderSubmitFragment.Sh(ECOrderSubmitFragment.this).setChecked(Intrinsics.areEqual(str, ECLocalConfig.f100650f.getString("blind_box_agreement_version", "", Boolean.TRUE)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k<T> implements Observer<String> {
        k() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(String str) {
            ECOrderSubmitFragment.this.Vi(true, str);
            if (str.length() > 0) {
                ECOrderSubmitFragment.Sh(ECOrderSubmitFragment.this).setChecked(Intrinsics.areEqual(str, ECLocalConfig.f100650f.getString("q_shop_agreement_version", "", Boolean.TRUE)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class l<T> implements Observer<String> {
        l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(String str) {
            ECOrderSubmitFragment.fi(ECOrderSubmitFragment.this).setVisibility(str.length() > 0 ? 0 : 8);
            ECOrderSubmitFragment eCOrderSubmitFragment = ECOrderSubmitFragment.this;
            eCOrderSubmitFragment.Ui(ECOrderSubmitFragment.gi(eCOrderSubmitFragment), ECOrderSubmitFragment.this.getString(R.string.wpp), "https://rule.tencent.com/rule/preview/ba334d90-dff8-4380-8ee5-6c683b285de9");
            if (str.length() > 0) {
                ECOrderSubmitFragment.ei(ECOrderSubmitFragment.this).setChecked(Intrinsics.areEqual(str, ECLocalConfig.f100650f.getString("q_shop_privacy_agreement_version", "", Boolean.TRUE)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitFragment$initViews$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECOrderSubmitFragment.this.Wi();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitFragment$initViews$5$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class n extends RecyclerView.OnScrollListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f103488e;

        n(View view) {
            this.f103488e = view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            FragmentActivity activity;
            Window window;
            super.onScrollStateChanged(recyclerView, newState);
            if (newState != 1 || (activity = ECOrderSubmitFragment.this.getActivity()) == null || (window = activity.getWindow()) == null) {
                return;
            }
            SoftKeyboardStateHelper.INSTANCE.c(window);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitFragment$o", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class o extends ClickableSpan {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f103490e;

        o(String str) {
            this.f103490e = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            ECScheme.g(this.f103490e, null, 2, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds5) {
            ds5.setColor(ContextCompat.getColor(ECOrderSubmitFragment.this.requireContext(), R.color.f156573l2));
            ds5.setUnderlineText(false);
        }
    }

    public ECOrderSubmitFragment() {
        Lazy lazy;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                String str;
                String str2;
                String str3;
                Boolean bool;
                SimpleSku ki5 = ECOrderSubmitFragment.ki(ECOrderSubmitFragment.this);
                str = ECOrderSubmitFragment.this.activityId;
                str2 = ECOrderSubmitFragment.this.adClickId;
                str3 = ECOrderSubmitFragment.this.groupId;
                bool = ECOrderSubmitFragment.this.isBuyAll;
                return new j(ki5, str, str2, str3, bool);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECOrderSubmitViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$$special$$inlined$viewModels$2
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
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$$special$$inlined$viewModels$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.blindBoxViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECBlindBoxViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$$special$$inlined$viewModels$4
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
        ServiceLocator serviceLocator = ServiceLocator.f104891i;
        this.realNamelistViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ListViewModel.class), new ListViewModelLazyKt$listViewModels$1(this), new ListViewModelLazyKt$listViewModels$2(new com.tencent.ecommerce.base.list.d(new ListRepository(serviceLocator.o().getRealNameListDataSource(), serviceLocator.o().getListOperator(), null, 4, null))));
        ECOrderSubmitFragment$itemOperationListener$1 eCOrderSubmitFragment$itemOperationListener$1 = new ECOrderSubmitFragment$itemOperationListener$1(this);
        this.itemOperationListener = eCOrderSubmitFragment$itemOperationListener$1;
        this.adapter = new com.tencent.ecommerce.biz.orders.buyerorders.submit.g(eCOrderSubmitFragment$itemOperationListener$1);
        this.showPageCostTimeReporter = new com.tencent.ecommerce.base.report.service.k(ECShowPageCostTimeScene.SHOW_COST_TIME_ORDER_SUBMIT);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECommerceCaptchaVerifyDialog>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$captchaDialog$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECommerceCaptchaVerifyDialog invoke() {
                ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog = new ECommerceCaptchaVerifyDialog();
                Bundle bundle = new Bundle();
                bundle.putString("appId", "2089865252");
                Unit unit = Unit.INSTANCE;
                eCommerceCaptchaVerifyDialog.setArguments(bundle);
                return eCommerceCaptchaVerifyDialog;
            }
        });
        this.captchaDialog = lazy;
        this.checkedChangeListener = b.f103469d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bi(int errorType, int errorCode, String errorMsg) {
        if (Mi(errorType, errorMsg)) {
            return;
        }
        Ai(errorCode, errorMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ci(ECOrderSubmitViewModel.h.SubmitSucceedResult submitResult) {
        IECPayApi.a.a(mi0.a.f416850b, requireActivity(), submitResult.payTokenUrl, 0, submitResult.getPayType().id, new ECOrderSubmitFragment$dealWithSubmitSucceedResult$1(this, submitResult), 4, null);
        com.tencent.ecommerce.biz.advertise.b.f101293a.c(Li().B2(), this.adClickId);
        ECAdAttributionReporter.f101288c.d(this.adClickId);
    }

    private final SlidingUpDialog Di() {
        CreateRealNameLayout createRealNameLayout = new CreateRealNameLayout(requireContext());
        createRealNameLayout.setSubmitClickListener(new Function1<RealNameAccount, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$generateCreateRealNameDialog$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RealNameAccount realNameAccount) {
                invoke2(realNameAccount);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RealNameAccount realNameAccount) {
                Map emptyMap;
                ECOrderSubmitFragment.this.Li().q2(realNameAccount);
                com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
                emptyMap = MapsKt__MapsKt.emptyMap();
                IECDataReport.a.a(bVar, "qstore_order_submit_id_check_submit_ck", emptyMap, false, 4, null);
            }
        });
        SlidingUpDialog slidingUpDialog = new SlidingUpDialog(requireActivity(), false, 2, null);
        SlidingUpDialog.U(slidingUpDialog, createRealNameLayout, null, 2, null);
        return slidingUpDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SlidingUpDialog Ei() {
        SelectRealNameLayout selectRealNameLayout = new SelectRealNameLayout(requireContext());
        selectRealNameLayout.setOnAccountClickListener(new Function1<RealNameAccount, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$generateSelectRealNameDialog$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RealNameAccount realNameAccount) {
                invoke2(realNameAccount);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RealNameAccount realNameAccount) {
                SlidingUpDialog slidingUpDialog;
                Map emptyMap;
                ECOrderSubmitFragment.this.Li().e3(realNameAccount);
                slidingUpDialog = ECOrderSubmitFragment.this.selectRealNameDialog;
                if (slidingUpDialog != null) {
                    slidingUpDialog.dismiss();
                }
                com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
                emptyMap = MapsKt__MapsKt.emptyMap();
                IECDataReport.a.a(bVar, "qstore_order_submit_checked_id_list_ck", emptyMap, false, 4, null);
            }
        });
        selectRealNameLayout.setOnAccountDeleteListener(new Function1<RealNameAccount, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$generateSelectRealNameDialog$$inlined$apply$lambda$2

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitFragment$generateSelectRealNameDialog$content$1$2$1"}, k = 3, mv = {1, 4, 1})
            @DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$generateSelectRealNameDialog$content$1$2$1", f = "ECOrderSubmitFragment.kt", i = {}, l = {674}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$generateSelectRealNameDialog$$inlined$apply$lambda$2$1, reason: invalid class name */
            /* loaded from: classes31.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ RealNameAccount $it;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(RealNameAccount realNameAccount, Continuation continuation) {
                    super(2, continuation);
                    this.$it = realNameAccount;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$it, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    ListViewModel Ii;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ECOrderSubmitViewModel Li = ECOrderSubmitFragment.this.Li();
                        RealNameAccount realNameAccount = this.$it;
                        this.label = 1;
                        obj = Li.r2(realNameAccount, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    if (((Boolean) obj).booleanValue()) {
                        Ii = ECOrderSubmitFragment.this.Ii();
                        Ii.X1(new RealNameAccountsReqInfo(null, 1, null));
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RealNameAccount realNameAccount) {
                invoke2(realNameAccount);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RealNameAccount realNameAccount) {
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ECOrderSubmitFragment.this), null, null, new AnonymousClass1(realNameAccount, null), 3, null);
            }
        });
        selectRealNameLayout.setOnNewAccountListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$generateSelectRealNameDialog$$inlined$apply$lambda$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ECOrderSubmitFragment.this.Xi(3);
            }
        });
        selectRealNameLayout.setOnRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$generateSelectRealNameDialog$$inlined$apply$lambda$4
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ListViewModel Ii;
                Ii = ECOrderSubmitFragment.this.Ii();
                Ii.X1(new RealNameAccountsReqInfo(null, 1, null));
            }
        });
        selectRealNameLayout.setOnLoadMoreListener(new Function1<String, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$generateSelectRealNameDialog$$inlined$apply$lambda$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                ListViewModel Ii;
                Ii = ECOrderSubmitFragment.this.Ii();
                Ii.Z1(new RealNameAccountsReqInfo(str));
            }
        });
        this.selectRealNameLayout = selectRealNameLayout;
        SlidingUpDialog slidingUpDialog = new SlidingUpDialog(requireActivity(), false, 2, null);
        SlidingUpDialog.U(slidingUpDialog, selectRealNameLayout, null, 2, null);
        return slidingUpDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECBlindBoxViewModel Fi() {
        return (ECBlindBoxViewModel) this.blindBoxViewModel.getValue();
    }

    private final ECommerceCaptchaVerifyDialog Gi() {
        return (ECommerceCaptchaVerifyDialog) this.captchaDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListViewModel<RealNameAccountsReqInfo, RealNameAccount, String> Ii() {
        return (ListViewModel) this.realNamelistViewModel.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SimpleSku Ji(Bundle bundle) {
        boolean z16;
        Integer intOrNull;
        boolean isBlank;
        String string = bundle.getString("sku_id");
        int i3 = 1;
        if (string != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(string);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return SimpleSku.INSTANCE.a();
                }
                String string2 = bundle.getString("sku_num");
                if (string2 != null && intOrNull != null) {
                    i3 = intOrNull.intValue();
                }
                return new SimpleSku(string, i3);
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECOrderSubmitViewModel Li() {
        return (ECOrderSubmitViewModel) this.viewModel.getValue();
    }

    private final void Oi() {
        LifecycleEventBus.f100688b.c(ThreadMode.ORIGIN, getViewLifecycleOwner(), ECHREvent.class, new d());
        Li().C2().observe(getViewLifecycleOwner(), new e());
        Li().A2().observe(getViewLifecycleOwner(), new f());
        Li().D2().observe(getViewLifecycleOwner(), new g());
        Li().L2().observe(getViewLifecycleOwner(), new h());
        Li().M2().observe(getViewLifecycleOwner(), new i());
        Li().x2().observe(getViewLifecycleOwner(), new j());
        Li().G2().observe(getViewLifecycleOwner(), new k());
        Li().F2().observe(getViewLifecycleOwner(), new l());
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECOrderSubmitFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECOrderSubmitFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECOrderSubmitFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECOrderSubmitFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$4(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECOrderSubmitFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$5(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECOrderSubmitFragment$initObservers$15(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECOrderSubmitFragment$initObservers$16(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECOrderSubmitFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6(this, state, null, this), 3, null);
    }

    public static final /* synthetic */ CheckBox Sh(ECOrderSubmitFragment eCOrderSubmitFragment) {
        CheckBox checkBox = eCOrderSubmitFragment.agreementCheckBox;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("agreementCheckBox");
        }
        return checkBox;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Si(ECAddress address) {
        String str;
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        if (address == null) {
            str = "0";
        } else {
            str = "1";
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_order_submit_address_ck", eVar.b("address_is_empty", str).f(), false, 4, null);
    }

    public static final /* synthetic */ View Th(ECOrderSubmitFragment eCOrderSubmitFragment) {
        View view = eCOrderSubmitFragment.agreementContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("agreementContainer");
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ti(boolean networkSuccess) {
        com.tencent.ecommerce.base.report.service.k.c(this.showPageCostTimeReporter, networkSuccess ? 2 : 3, null, 2, null);
    }

    public static final /* synthetic */ ImageView Uh(ECOrderSubmitFragment eCOrderSubmitFragment) {
        ImageView imageView = eCOrderSubmitFragment.belowZeroIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("belowZeroIv");
        }
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ui(TextView agreementContentView, String agreement, String jumpUrl) {
        int indexOf$default;
        int indexOf$default2;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) agreement, "\u300a", 0, false, 6, (Object) null);
        indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) agreement, "\u300b", 0, false, 6, (Object) null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(agreement);
        spannableStringBuilder.setSpan(new o(jumpUrl), indexOf$default, indexOf$default2 + 1, 18);
        agreementContentView.setMovementMethod(LinkMovementMethod.getInstance());
        agreementContentView.setText(spannableStringBuilder);
        agreementContentView.setHighlightColor(ContextCompat.getColor(requireContext(), R.color.f7153h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vi(boolean isQShop, String version) {
        String str;
        if (version.length() > 0) {
            View view = this.agreementContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("agreementContainer");
            }
            view.setVisibility(0);
            String string = getString(isQShop ? R.string.f169628wq2 : R.string.wgd);
            TextView textView = this.agreementContent;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("agreementContent");
            }
            if (isQShop) {
                str = "https://docs.qq.com/doc/DSGJ1QnhvQVhFVWxp";
            } else {
                str = "https://docs.qq.com/doc/p/1f3e665f303aa7c68757d43470e7875ec80c794c";
            }
            Ui(textView, string, str);
        }
    }

    public static final /* synthetic */ View Wh(ECOrderSubmitFragment eCOrderSubmitFragment) {
        View view = eCOrderSubmitFragment.bottomArea;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomArea");
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wi() {
        com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(requireContext());
        gVar.Y(requireContext().getString(R.string.wvg));
        gVar.b0("");
        gVar.f0(requireContext().getString(R.string.wpm));
        gVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xi(int triggerFrom) {
        Map mapOf;
        SlidingUpDialog slidingUpDialog = this.createRealNameDialog;
        if (slidingUpDialog != null) {
            slidingUpDialog.dismiss();
        }
        SlidingUpDialog Di = Di();
        Di.show();
        Unit unit = Unit.INSTANCE;
        this.createRealNameDialog = Di;
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("triger", String.valueOf(triggerFrom)));
        IECDataReport.a.a(bVar, "qstore_order_submit_id_check_expo", mapOf, false, 4, null);
    }

    public static final /* synthetic */ TextView Zh(ECOrderSubmitFragment eCOrderSubmitFragment) {
        TextView textView = eCOrderSubmitFragment.discountTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountTv");
        }
        return textView;
    }

    public static final /* synthetic */ TextView di(ECOrderSubmitFragment eCOrderSubmitFragment) {
        TextView textView = eCOrderSubmitFragment.priceTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceTv");
        }
        return textView;
    }

    public static final /* synthetic */ CheckBox ei(ECOrderSubmitFragment eCOrderSubmitFragment) {
        CheckBox checkBox = eCOrderSubmitFragment.privacyAgreementCheckBox;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyAgreementCheckBox");
        }
        return checkBox;
    }

    public static final /* synthetic */ View fi(ECOrderSubmitFragment eCOrderSubmitFragment) {
        View view = eCOrderSubmitFragment.privacyAgreementContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyAgreementContainer");
        }
        return view;
    }

    public static final /* synthetic */ TextView gi(ECOrderSubmitFragment eCOrderSubmitFragment) {
        TextView textView = eCOrderSubmitFragment.privacyAgreementContent;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyAgreementContent");
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initData() {
        ECOrderSubmitViewModel.u2(Li(), null, false, 3, null);
    }

    public static final /* synthetic */ SimpleSku ki(ECOrderSubmitFragment eCOrderSubmitFragment) {
        SimpleSku simpleSku = eCOrderSubmitFragment.sku;
        if (simpleSku == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sku");
        }
        return simpleSku;
    }

    public static final /* synthetic */ TextView mi(ECOrderSubmitFragment eCOrderSubmitFragment) {
        TextView textView = eCOrderSubmitFragment.submitBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitBtn");
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject zi(List<String> orderIds, PayType payType, ECQshopOrderQuerySvr$OrderPageDetailRsp orderDetailRsp) {
        String joinToString$default;
        String str;
        JSONObject jSONObject = new JSONObject();
        ECOrderSubmitViewModel.OrderSubmitReportInfo c16 = com.tencent.ecommerce.biz.orders.buyerorders.submit.k.c(orderDetailRsp, null, false, 1, null);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(orderIds, "-", null, null, 0, null, null, 62, null);
        jSONObject.put("order_id", joinToString$default);
        jSONObject.put("seller_id", c16.sellerId);
        jSONObject.put("shop_id", c16.shopId);
        jSONObject.put("spu_id", c16.spuId);
        jSONObject.put("sku_id", c16.skuId);
        jSONObject.put("pri_sort_id", c16.priSortId);
        if (c16.addressIsEmpty) {
            str = "0";
        } else {
            str = "1";
        }
        jSONObject.put("address_is_empty", str);
        jSONObject.put("source_from", this.sourceFrom);
        String str2 = this.contentId;
        if (str2 != null) {
            jSONObject.put("content_id", str2);
        }
        jSONObject.put("payment_method", String.valueOf(payType.id));
        return jSONObject;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return Pi();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    public int Hi() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ECStateCenterView Ki() {
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        return eCStateCenterView;
    }

    public boolean Pi() {
        return true;
    }

    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECOrderSubmitFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cuv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        SimpleSku a16;
        String str;
        String string;
        String string2;
        Window window;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (a16 = Ji(arguments)) == null) {
            a16 = SimpleSku.INSTANCE.a();
        }
        this.sku = a16;
        Bundle arguments2 = getArguments();
        this.activityId = arguments2 != null ? arguments2.getString("active_id", null) : null;
        Bundle arguments3 = getArguments();
        this.adClickId = arguments3 != null ? arguments3.getString("qz_gdt", null) : null;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str = INSTANCE.d(arguments4)) == null) {
            str = "-1";
        }
        this.sourceFrom = str;
        Bundle arguments5 = getArguments();
        this.contentId = arguments5 != null ? INSTANCE.c(arguments5) : null;
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        Bundle arguments6 = getArguments();
        if (arguments6 != null && (string2 = arguments6.getString("group_id")) != null) {
            this.groupId = string2;
        }
        Bundle arguments7 = getArguments();
        if (arguments7 == null || (string = arguments7.getString("buy_all")) == null) {
            return;
        }
        this.isBuyAll = Boolean.valueOf(Intrinsics.areEqual(string, "1"));
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Ni();
        initViews(view);
        Oi();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Mi(int errorType, final String errorMsg) {
        if (errorType == 1) {
            com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(requireActivity());
            gVar.Y(errorMsg);
            gVar.b0("");
            gVar.f0(getString(R.string.wo7));
            gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$handlerErrorType$$inlined$apply$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    FragmentActivity activity = ECOrderSubmitFragment.this.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            });
            gVar.show();
            return true;
        }
        if (errorType == 2) {
            com.tencent.ecommerce.base.ui.g gVar2 = new com.tencent.ecommerce.base.ui.g(requireActivity());
            gVar2.Y(errorMsg);
            gVar2.b0("");
            gVar2.f0(getString(R.string.wo7));
            gVar2.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$handlerErrorType$$inlined$apply$lambda$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    ECOrderSubmitFragment.this.Li().R2();
                }
            });
            gVar2.show();
            return true;
        }
        if (errorType == 3) {
            final com.tencent.ecommerce.base.ui.g gVar3 = new com.tencent.ecommerce.base.ui.g(requireActivity());
            gVar3.Y(errorMsg);
            gVar3.b0("");
            gVar3.f0(getString(R.string.wo7));
            gVar3.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$handlerErrorType$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    com.tencent.ecommerce.base.ui.g.this.dismiss();
                }
            });
            gVar3.show();
            return true;
        }
        if (errorType == 4) {
            com.tencent.ecommerce.base.ui.i.f101155b.d(errorMsg, ECToastIcon.ICON_ERROR, 0);
            return true;
        }
        if (errorType != 5) {
            return false;
        }
        com.tencent.ecommerce.base.ui.i.f101155b.d(errorMsg, ECToastIcon.ICON_ERROR, 0);
        Li().R2();
        return true;
    }

    private final void Ni() {
        setTitle(R.string.wv_);
        if (Pi()) {
            Hh(true);
            return;
        }
        Hh(false);
        Jh(R.drawable.e9u);
        Ih(new c());
    }

    private final void initViews(View view) {
        this.bottomArea = view.findViewById(R.id.nrj);
        this.priceTv = (TextView) view.findViewById(R.id.ocu);
        ImageView imageView = (ImageView) view.findViewById(R.id.nqh);
        imageView.setOnClickListener(new m());
        Unit unit = Unit.INSTANCE;
        this.belowZeroIv = imageView;
        this.discountTv = (TextView) view.findViewById(R.id.ocr);
        this.submitBtn = (TextView) view.findViewById(R.id.oba);
        ECStateCenterView eCStateCenterView = (ECStateCenterView) view.findViewById(R.id.f163103ob2);
        eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$initViews$$inlined$apply$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ECOrderSubmitFragment.this.initData();
            }
        });
        this.stateView = eCStateCenterView;
        this.agreementContainer = view.findViewById(R.id.o88);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.o89);
        checkBox.setOnCheckedChangeListener(this.checkedChangeListener);
        this.agreementCheckBox = checkBox;
        this.agreementContent = (TextView) view.findViewById(R.id.o8_);
        this.privacyAgreementContainer = view.findViewById(R.id.o6u);
        CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.o6v);
        checkBox2.setOnCheckedChangeListener(this.checkedChangeListener);
        this.privacyAgreementCheckBox = checkBox2;
        this.privacyAgreementContent = (TextView) view.findViewById(R.id.o6w);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.o5j);
        recyclerView.setAdapter(this.adapter);
        recyclerView.setItemAnimator(null);
        recyclerView.addItemDecoration(new com.tencent.ecommerce.biz.orders.buyerorders.submit.h(view.getContext()));
        recyclerView.addOnScrollListener(new n(view));
        this.recyclerView = recyclerView;
        TextView textView = this.submitBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitBtn");
        }
        ViewExtKt.b(textView, 1000L, new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$initViews$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                boolean z16 = true;
                if (ECOrderSubmitFragment.Th(ECOrderSubmitFragment.this).getVisibility() == 0) {
                    if (ECOrderSubmitFragment.Sh(ECOrderSubmitFragment.this).isChecked()) {
                        String value = ECOrderSubmitFragment.this.Li().x2().getValue();
                        String value2 = ECOrderSubmitFragment.this.Li().G2().getValue();
                        if (!(value == null || value.length() == 0)) {
                            ECLocalConfig.f100650f.setString("blind_box_agreement_version", value, Boolean.TRUE);
                        } else {
                            if (!(value2 == null || value2.length() == 0)) {
                                ECLocalConfig.f100650f.setString("q_shop_agreement_version", value2, Boolean.TRUE);
                            }
                        }
                    } else {
                        com.tencent.ecommerce.base.ui.i.e(com.tencent.ecommerce.base.ui.i.f101155b, R.string.wge, null, 0, 6, null);
                        return;
                    }
                }
                if (ECOrderSubmitFragment.fi(ECOrderSubmitFragment.this).getVisibility() == 0) {
                    if (ECOrderSubmitFragment.ei(ECOrderSubmitFragment.this).isChecked()) {
                        String value3 = ECOrderSubmitFragment.this.Li().F2().getValue();
                        if (value3 != null && value3.length() != 0) {
                            z16 = false;
                        }
                        if (!z16) {
                            ECLocalConfig.f100650f.setString("q_shop_privacy_agreement_version", value3, Boolean.TRUE);
                        }
                    } else {
                        com.tencent.ecommerce.base.ui.i.e(com.tencent.ecommerce.base.ui.i.f101155b, R.string.wge, null, 0, 6, null);
                        return;
                    }
                }
                ECOrderSubmitViewModel.U2(ECOrderSubmitFragment.this.Li(), true, null, false, 6, null);
            }
        });
    }

    private final void Ai(int errorCode, final String errorMsg) {
        if (errorCode == -3333) {
            com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(requireActivity());
            gVar.Y(getString(R.string.wv7, errorMsg));
            gVar.b0(getString(R.string.wgw));
            gVar.f0(getString(R.string.wo7));
            gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$dealWithSubmitFailedCodeCaseByCase$$inlined$apply$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    ECOrderSubmitViewModel.U2(ECOrderSubmitFragment.this.Li(), false, null, true, 2, null);
                }
            });
            gVar.show();
            return;
        }
        if (errorCode == -2222) {
            com.tencent.ecommerce.base.ui.i.f101155b.c(R.string.wvb, ECToastIcon.ICON_ERROR, 0);
            return;
        }
        if (errorCode == -1111) {
            com.tencent.ecommerce.biz.orders.address.c.e(1, null, new Function1<ECAddress, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$dealWithSubmitFailedCodeCaseByCase$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECAddress eCAddress) {
                    invoke2(eCAddress);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECAddress eCAddress) {
                    ECOrderSubmitFragment.this.Li().o2(eCAddress);
                }
            });
            com.tencent.ecommerce.base.ui.i.f101155b.c(R.string.wv8, ECToastIcon.ICON_ERROR, 0);
            return;
        }
        if (errorCode == 20) {
            final String B2 = Li().B2();
            if (B2 != null) {
                final com.tencent.ecommerce.base.ui.g gVar2 = new com.tencent.ecommerce.base.ui.g(requireActivity());
                gVar2.Y(errorMsg);
                gVar2.b0("");
                gVar2.f0(getString(R.string.wo7));
                gVar2.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$dealWithSubmitFailedCodeCaseByCase$$inlined$apply$lambda$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        ECShopOrderDetailFragment.INSTANCE.a(this.requireContext(), B2, OrderDetailEntrance.FROM_PAY_PAGE);
                        com.tencent.ecommerce.base.ui.g.this.dismiss();
                        this.finish();
                    }
                });
                gVar2.show();
                com.tencent.ecommerce.biz.advertise.b.f101293a.c(Li().B2(), this.adClickId);
                ECAdAttributionReporter.f101288c.d(this.adClickId);
                return;
            }
            return;
        }
        if (errorCode == 9) {
            if (Gi().isAdded()) {
                Gi().dismiss();
            }
            Gi().uh(getChildFragmentManager(), new Function1<ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$dealWithSubmitFailedCodeCaseByCase$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult captchaVerifyDialogResult) {
                    invoke2(captchaVerifyDialogResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult captchaVerifyDialogResult) {
                    Map<String, String> mapOf;
                    cg0.a.b("ECOrderSubmitFragment", "captcha onCallbackFinished, result: " + captchaVerifyDialogResult);
                    boolean z16 = captchaVerifyDialogResult instanceof ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.Verified;
                    if (z16) {
                        ECOrderSubmitViewModel.U2(ECOrderSubmitFragment.this.Li(), false, com.tencent.ecommerce.repo.register.e.a(((ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.Verified) captchaVerifyDialogResult).captcha), false, 4, null);
                    }
                    ECOrderSpan eCOrderSpan = ECOrderSpan.f103884c;
                    String B22 = ECOrderSubmitFragment.this.Li().B2();
                    if (B22 == null) {
                        B22 = "";
                    }
                    String str = B22;
                    ECOrderSpanScene eCOrderSpanScene = ECOrderSpanScene.OrderSubmit;
                    ECOrderOperation eCOrderOperation = ECOrderOperation.OrderVerification;
                    ECOrderSpan.OrderRequestInfo orderRequestInfo = new ECOrderSpan.OrderRequestInfo(z16 ? 0 : -1, null, 2, null);
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", String.valueOf(captchaVerifyDialogResult)));
                    eCOrderSpan.b(str, eCOrderSpanScene, eCOrderOperation, orderRequestInfo, mapOf);
                }
            });
        } else {
            if (errorCode != 10) {
                final com.tencent.ecommerce.base.ui.g gVar3 = new com.tencent.ecommerce.base.ui.g(requireActivity());
                gVar3.Y(errorMsg);
                gVar3.b0("");
                gVar3.f0(getString(R.string.wo7));
                gVar3.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$dealWithSubmitFailedCodeCaseByCase$5$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        com.tencent.ecommerce.base.ui.g.this.dismiss();
                    }
                });
                gVar3.show();
                return;
            }
            com.tencent.ecommerce.base.ui.i.f101155b.d(errorMsg, ECToastIcon.ICON_ERROR, 0);
        }
    }

    public void Ri() {
    }

    public void Qi(boolean isVisible, int bottomBarHeightPx) {
    }
}
