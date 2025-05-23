package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ktx.ViewExtKt;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.report.api.IECMobileReportManager;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.SlidingUpDialog;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.d;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.comment.ECQShopCommentFragment;
import com.tencent.ecommerce.biz.comment.ECQShopReviewCommentFragment;
import com.tencent.ecommerce.biz.customerservice.CustomerServiceScene;
import com.tencent.ecommerce.biz.customerservice.ECCustomerServiceFragment;
import com.tencent.ecommerce.biz.logistics.ECLogisticsTraceFragment;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.address.modifyorderaddress.ECModifyOrderAddressFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailAccountInfoData;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailBottomBarState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailHeaderState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailPayInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailWidgetsVisibility;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECShopOrderDetailViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.OrderDetailCheckValidData;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.RecommendFetchType;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.BottomAreaOperation;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderDetailEntrance;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderSpuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.TicketDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailListAdapter;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailOperation;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.ecommerce.biz.orders.buyerorders.snapshot.ECOrderSnapshotFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECBlindBoxViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuSpec;
import com.tencent.ecommerce.biz.orders.common.BulletinInfo;
import com.tencent.ecommerce.biz.orders.common.LogisticsInfo;
import com.tencent.ecommerce.biz.orders.common.QShopOrderPromoInfo;
import com.tencent.ecommerce.biz.orders.common.QShopOrderState;
import com.tencent.ecommerce.biz.orders.ticket.ECOrderTicketListView;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import com.tencent.ecommerce.biz.recommend.models.ECProductRecommendItemData;
import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment;
import com.tencent.ecommerce.biz.submitsucceed.SubmitSucceedFrom;
import com.tencent.ecommerce.biz.submitsucceed.SubmitSucceedUIState;
import com.tencent.ecommerce.biz.util.ECViewUtilKt;
import com.tencent.ecommerce.biz.util.j;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import li0.b;
import mqq.app.Constants;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 u2\u00020\u0001:\u0002vwB\u0007\u00a2\u0006\u0004\bs\u0010tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\"\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0007J\f\u0010\u001c\u001a\u00020\u0006*\u00020\u0002H\u0002J\f\u0010\u001e\u001a\u00020\u001d*\u00020\u0002H\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J \u0010%\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002J.\u0010+\u001a\u00020\u00042\u0006\u0010&\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00062\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060'2\u0006\u0010*\u001a\u00020)H\u0002J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020\u0004H\u0002J\u0010\u00101\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u000200H\u0002J\b\u00102\u001a\u00020\nH\u0002J\u0018\u00107\u001a\u00020\u00042\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205H\u0002J\u0010\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0002J\b\u0010;\u001a\u00020\u0004H\u0002J\b\u0010<\u001a\u00020\u0004H\u0002J\b\u0010=\u001a\u00020\u0004H\u0002J\b\u0010>\u001a\u00020\u0004H\u0002J\b\u0010?\u001a\u00020\u0004H\u0002J\b\u0010@\u001a\u00020\u0004H\u0002J\u0010\u0010A\u001a\u00020\b2\u0006\u0010\u001a\u001a\u000203H\u0002J\u0010\u0010B\u001a\u00020\u00062\u0006\u00104\u001a\u000203H\u0002R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001b\u0010J\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010G\u001a\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010VR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010h\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010DR\u0014\u0010n\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010r\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010q\u00a8\u0006x"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/qshop/ECShopOrderDetailFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "getBusinessDescription", "", "getContentLayoutId", "", "Bh", "Dh", "Eh", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/c;", "state", "si", "ii", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/OrderDetailEntrance;", "hi", "initViews", "oi", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;", "payResult", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "spuId", "di", "result", "", "spuIds", "", "payPriceInFen", "qi", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g$b;", "errorState", "ei", "fi", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", SensorJsPlugin.SENSOR_INTERVAL_UI, "pi", "Lcom/tencent/ecommerce/biz/orders/common/QShopOrderState;", "orderState", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/f;", "headerState", "ti", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/BottomAreaOperation;", QCircleDaTongConstant.ElementParamValue.OPERATION, "ni", "ci", "ai", "bi", "vi", "ri", "mi", "ki", WidgetCacheLunarData.JI, "P", "Ljava/lang/String;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECShopOrderDetailViewModel;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "li", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECShopOrderDetailViewModel;", "viewModel", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECBlindBoxViewModel;", BdhLogUtil.LogTag.Tag_Req, "gi", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECBlindBoxViewModel;", "blindBoxViewModel", "Landroidx/constraintlayout/widget/Group;", ExifInterface.LATITUDE_SOUTH, "Landroidx/constraintlayout/widget/Group;", "bottomArea", "Landroid/widget/TextView;", "T", "Landroid/widget/TextView;", "mainOperateTv", "U", "subOperateTv", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "V", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", "Lcom/tencent/ecommerce/base/ui/SlidingUpDialog;", "W", "Lcom/tencent/ecommerce/base/ui/SlidingUpDialog;", "ticketListDialog", "Lcom/tencent/ecommerce/biz/orders/ticket/ECOrderTicketListView;", "X", "Lcom/tencent/ecommerce/biz/orders/ticket/ECOrderTicketListView;", "ticketListView", "Y", "J", "lastResumeTimeMs", "Z", "scene", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/ECOrderDetailListAdapter;", "a0", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/ECOrderDetailListAdapter;", "adapter", "Lcom/tencent/ecommerce/base/report/service/k;", "b0", "Lcom/tencent/ecommerce/base/report/service/k;", "showCostTimeReporter", "<init>", "()V", "c0", "a", "OrderDetailListListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopOrderDetailFragment extends ECBaseFragment {

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private String orderId = "";

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: R, reason: from kotlin metadata */
    private final Lazy blindBoxViewModel;

    /* renamed from: S, reason: from kotlin metadata */
    private Group bottomArea;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView mainOperateTv;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView subOperateTv;

    /* renamed from: V, reason: from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: W, reason: from kotlin metadata */
    private SlidingUpDialog ticketListDialog;

    /* renamed from: X, reason: from kotlin metadata */
    private ECOrderTicketListView ticketListView;

    /* renamed from: Y, reason: from kotlin metadata */
    private long lastResumeTimeMs;

    /* renamed from: Z, reason: from kotlin metadata */
    private String scene;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final ECOrderDetailListAdapter adapter;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final k showCostTimeReporter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/qshop/ECShopOrderDetailFragment$a;", "", "Landroid/content/Context;", "context", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/OrderDetailEntrance;", "from", "", "a", "PARAMS_FROM", "Ljava/lang/String;", "PARAMS_ORDER_ID", "", "REQUEST_CODE_MODIFY_ADDRESS", "I", "START_TO_REQUEST_POSITION", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(Context context, String orderId, OrderDetailEntrance from) {
            if ((orderId.length() == 0) && wg0.a.b()) {
                throw new IllegalArgumentException("must have params orderId");
            }
            Bundle bundle = new Bundle();
            bundle.putString("order_id", orderId);
            bundle.putString("from", String.valueOf(from.value));
            yi0.a.q(context, ECShopOrderDetailFragment.class, bundle, 0, null, 24, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel", "com/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/qshop/ECShopOrderDetailFragment$dealBlindBoxPayResult$loadingDialog$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            ECShopOrderDetailFragment.this.finish();
        }
    }

    public ECShopOrderDetailFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECShopOrderDetailViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$$special$$inlined$viewModels$2
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
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$$special$$inlined$viewModels$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.blindBoxViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECBlindBoxViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$$special$$inlined$viewModels$4
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
        this.scene = "";
        this.adapter = new ECOrderDetailListAdapter(new OrderDetailListListener(), ECShopRecommendScene.QQ_SHOP_ORDER_DETAIL);
        this.showCostTimeReporter = new k(ECShowPageCostTimeScene.SHOW_COST_TIME_ORDER_DETAIL);
    }

    public static final /* synthetic */ ECStateCenterView Rh(ECShopOrderDetailFragment eCShopOrderDetailFragment) {
        ECStateCenterView eCStateCenterView = eCShopOrderDetailFragment.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        return eCStateCenterView;
    }

    private final void ai() {
        g gVar = new g(requireContext());
        gVar.Y(getString(R.string.wi8));
        gVar.Z(17);
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$cancelOrder$$inlined$apply$lambda$1
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
                ECShopOrderDetailFragment.this.li().i2(ECShopOrderDetailFragment.this.orderId);
            }
        });
        gVar.show();
        ECOrderDetailReporter.f103294d.f("qstore_order_detail_bottom_button_clk", 1);
    }

    private final void bi() {
        g gVar = new g(requireContext());
        gVar.Y(getString(R.string.wie));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$confirmReceive$$inlined$apply$lambda$1
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
                ECShopOrderDetailFragment.this.li().j2(ECShopOrderDetailFragment.this.orderId);
            }
        });
        gVar.show();
        ECOrderDetailReporter.f103294d.f("qstore_order_detail_bottom_button_clk", 5);
    }

    private final void ci() {
        li().C2(this.orderId);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("aid", "vip.card.shelfGoods.qqshopGoods_xiaodian");
        IECMobileReportManager.a.a(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getMobileReporter(), "card_collect", "pg_xd_pay_continue", "1", null, "pay_continue", null, "4", 109, 0, 0, null, jSONObject.toString(), null, null, 14120, null);
        ECOrderDetailReporter.f103294d.f("qstore_order_detail_bottom_button_clk", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void di(IECPayApi.PayResult payResult, String orderId, String spuId) {
        d dVar = new d(requireContext(), null, 2, null);
        dVar.setOnCancelListener(new b());
        dVar.show();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECShopOrderDetailFragment$dealBlindBoxPayResult$1(this, payResult, orderId, spuId, dVar, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei(ECOrderSubmitViewModel.g.Error errorState) {
        cg0.a.a("ECShopOrderDetailFragment", "dealWithErrorState", "code: " + errorState.code + ", msg: " + errorState.msg);
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        IStateCenterView.a.b(eCStateCenterView, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fi() {
        li().k2(this.orderId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECBlindBoxViewModel gi() {
        return (ECBlindBoxViewModel) this.blindBoxViewModel.getValue();
    }

    private final OrderDetailEntrance hi(Bundle bundle) {
        int i3;
        OrderDetailEntrance orderDetailEntrance;
        String string = bundle.getString("from");
        if (string != null) {
            i3 = Integer.parseInt(string);
        } else {
            i3 = OrderDetailEntrance.FROM_UNKNOWN.value;
        }
        OrderDetailEntrance[] values = OrderDetailEntrance.values();
        int length = values.length;
        int i16 = 0;
        while (true) {
            if (i16 >= length) {
                orderDetailEntrance = null;
                break;
            }
            orderDetailEntrance = values[i16];
            if (orderDetailEntrance.value == i3) {
                break;
            }
            i16++;
        }
        return orderDetailEntrance != null ? orderDetailEntrance : OrderDetailEntrance.FROM_UNKNOWN;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String ii(Bundle bundle) {
        boolean z16;
        boolean isBlank;
        String string = bundle.getString("order_id");
        if (string != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(string);
            if (!isBlank) {
                z16 = false;
                return !z16 ? "" : string;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final String ji(QShopOrderState orderState) {
        Context context = yh().getContext();
        switch (a.f103308c[orderState.ordinal()]) {
            case 1:
            case 2:
                return context.getString(R.string.wp7);
            case 3:
                return context.getString(R.string.wuc);
            case 4:
            case 5:
            case 6:
            case 7:
                return context.getString(R.string.wev);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final int ki(QShopOrderState state) {
        boolean isNightMode = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getNightManager().isNightMode();
        if (state == QShopOrderState.PAYMENT_PENDING && isNightMode) {
            return ECSkin.INSTANCE.getColor(R.color.f6411h);
        }
        return ECSkin.INSTANCE.getColor(R.color.f59307);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECShopOrderDetailViewModel li() {
        return (ECShopOrderDetailViewModel) this.viewModel.getValue();
    }

    private final void mi() {
        ECScheme.g(li().t2().getValue().blindBoxWareHouseLink, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ni(BottomAreaOperation operation) {
        switch (a.f103307b[operation.ordinal()]) {
            case 1:
                bi();
                return;
            case 2:
                ci();
                return;
            case 3:
                ri();
                return;
            case 4:
                vi();
                return;
            case 5:
                ai();
                return;
            case 6:
                mi();
                return;
            default:
                return;
        }
    }

    private final void oi() {
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$4(this, Lifecycle.State.CREATED, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$5(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6(this, state, null, this), 3, null);
    }

    private final boolean pi() {
        return ug0.b.f438933d.e() == QQECChannel.CHANNEL_QQ_VIP.getId() && Intrinsics.areEqual(this.scene, "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qi(IECPayApi.PayResult result, String orderId, List<String> spuIds, long payPriceInFen) {
        i.f101155b.c(R.string.f169621wp0, ECToastIcon.ICON_SUCCESS, 0);
        li().B2(orderId);
        SubmitSucceedUIState submitSucceedUIState = new SubmitSucceedUIState(getString(R.string.f169621wp0), getString(R.string.f169622wp1, com.tencent.ecommerce.biz.orders.buyerorders.submit.model.i.a(result).name(requireContext()), j.f104870a.a(payPriceInFen)), getString(R.string.wrr));
        ECSubmitSucceedFragment.Companion companion = ECSubmitSucceedFragment.INSTANCE;
        Context requireContext = requireContext();
        SubmitSucceedFrom submitSucceedFrom = SubmitSucceedFrom.PAY_IN_ORDER_DETAIL;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("order_id", orderId);
        Unit unit = Unit.INSTANCE;
        companion.a(requireContext, submitSucceedUIState, submitSucceedFrom, spuIds, jSONObject);
    }

    private final void ri() {
        OrderSkuDetail orderSkuDetail = li().getOrderSkuDetail();
        if (!(this.orderId.length() == 0) && orderSkuDetail != null) {
            ECQShopReviewCommentFragment.INSTANCE.b(requireContext(), this.orderId, orderSkuDetail.skuId, li().getSpuId());
            ECOrderDetailReporter.f103294d.f("qstore_order_detail_bottom_button_clk", 4);
            return;
        }
        cg0.a.a("ECShopOrderDetailFragment", "reviewComment", "invalid params. orderId: " + this.orderId + ", sku: " + orderSkuDetail);
        i.f101155b.c(R.string.wo9, ECToastIcon.ICON_ERROR, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ti(QShopOrderState orderState, ECOrderDetailHeaderState headerState) {
        this.adapter.o0(new f.OrderStateData(orderState.value, ki(orderState), headerState.stateTitleStr, headerState.stateDescStr));
    }

    private final void vi() {
        int collectionSizeOrDefault;
        OrderSkuDetail orderSkuDetail = li().getOrderSkuDetail();
        if (!(this.orderId.length() == 0) && orderSkuDetail != null) {
            ECQShopCommentFragment.Companion companion = ECQShopCommentFragment.INSTANCE;
            Context requireContext = requireContext();
            String str = this.orderId;
            String str2 = orderSkuDetail.skuId;
            String spuId = li().getSpuId();
            String str3 = orderSkuDetail.name;
            String str4 = orderSkuDetail.coverUrl;
            List<OrderSkuSpec> d16 = orderSkuDetail.d();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(d16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = d16.iterator();
            while (it.hasNext()) {
                arrayList.add(((OrderSkuSpec) it.next()).value);
            }
            companion.a(requireContext, str, str2, spuId, str3, str4, new ArrayList<>(arrayList));
            ECOrderDetailReporter.f103294d.f("qstore_order_detail_bottom_button_clk", 3);
            return;
        }
        cg0.a.a("ECShopOrderDetailFragment", "reviewComment", "invalid params. orderId: " + this.orderId + ", sku: " + orderSkuDetail);
        i.f101155b.c(R.string.wo9, ECToastIcon.ICON_ERROR, 1);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopOrderDetailFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.csh;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        OrderDetailEntrance orderDetailEntrance;
        String string;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String str2 = "";
        if (arguments == null || (str = ii(arguments)) == null) {
            str = "";
        }
        this.orderId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString("scene")) != null) {
            str2 = string;
        }
        this.scene = str2;
        ECOrderDetailReporter eCOrderDetailReporter = ECOrderDetailReporter.f103294d;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (orderDetailEntrance = hi(arguments3)) == null) {
            orderDetailEntrance = OrderDetailEntrance.FROM_UNKNOWN;
        }
        eCOrderDetailReporter.a(orderDetailEntrance);
        getLifecycle().addObserver(li());
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.adapter.destroy();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ECOrderDetailReporter eCOrderDetailReporter = ECOrderDetailReporter.f103294d;
        eCOrderDetailReporter.g("qstore_order_detail_page_exit");
        eCOrderDetailReporter.h(System.currentTimeMillis() - this.lastResumeTimeMs);
        eCOrderDetailReporter.k();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ECOrderDetailReporter.j(ECOrderDetailReporter.f103294d, null, 1, null);
        this.lastResumeTimeMs = System.currentTimeMillis();
        fi();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle(R.string.wou);
        initViews(view);
        oi();
    }

    public final void si(final ECOrderDetailBottomBarState state) {
        Group group = this.bottomArea;
        if (group == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomArea");
        }
        group.setVisibility(state.showBottomBar ? 0 : 8);
        TextView textView = this.mainOperateTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainOperateTv");
        }
        textView.setVisibility(state.showMainOperateTv ? 0 : 8);
        if (state.mainOperateTextResId != -1) {
            TextView textView2 = this.mainOperateTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainOperateTv");
            }
            textView2.setText(getString(state.mainOperateTextResId));
        }
        TextView textView3 = this.mainOperateTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainOperateTv");
        }
        ViewExtKt.c(textView3, 0L, new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$updateBottomAreaState$1
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
                ECShopOrderDetailFragment.this.ni(state.mainTextOperation);
            }
        }, 1, null);
        TextView textView4 = this.subOperateTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subOperateTv");
        }
        textView4.setVisibility(state.showSubOperateTv ? 0 : 8);
        if (state.subOperateTextResId != -1) {
            TextView textView5 = this.subOperateTv;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subOperateTv");
            }
            textView5.setText(getString(state.subOperateTextResId));
        }
        TextView textView6 = this.subOperateTv;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subOperateTv");
        }
        ViewExtKt.c(textView6, 0L, new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$updateBottomAreaState$2
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
                ECShopOrderDetailFragment.this.ni(state.subTextOperation);
            }
        }, 1, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/qshop/ECShopOrderDetailFragment$OrderDetailListListener;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "logisticsCode", "", DomainData.DOMAIN_NAME, "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "ecAddress", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "a", "b", "g", "j", "k", h.F, "i", "c", "d", "f", "l", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$n;", "ticketInfoData", "o", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/qshop/ECShopOrderDetailFragment;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public final class OrderDetailListListener extends com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a {
        public OrderDetailListListener() {
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void a(String link) {
            ECOrderDetailReporter.f103294d.f("qstore_order_detail_after_sales_clk", 2);
            OrderDetailCheckValidData applyAfterSalesValidData = ECShopOrderDetailFragment.this.li().getApplyAfterSalesValidData();
            if (applyAfterSalesValidData != null && applyAfterSalesValidData.exceedTimeMs != 0) {
                if (!(applyAfterSalesValidData.exceedStr.length() == 0)) {
                    if (ECShopOrderDetailFragment.this.li().getOrderState() == QShopOrderState.DELIVERY_DONE && System.currentTimeMillis() > applyAfterSalesValidData.exceedTimeMs) {
                        ECOrderDetailOperation.f103235a.b(ECShopOrderDetailFragment.this.requireContext(), applyAfterSalesValidData.exceedStr, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$OrderDetailListListener$applyAfterSales$1
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
                                ECShopOrderDetailFragment.this.li().k2(ECShopOrderDetailFragment.this.orderId);
                            }
                        });
                        return;
                    } else {
                        ECScheme.g(link, null, 2, null);
                        return;
                    }
                }
            }
            ECScheme.g(link, null, 2, null);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void b(String link) {
            ECOrderDetailReporter.f103294d.f("qstore_order_detail_after_sales_clk", 1);
            ECScheme.g(link, null, 2, null);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void c(String orderId) {
            Object first;
            Object first2;
            ECOrderDetailReporter.f103294d.g("qstore_order_detail_contact_shop_clk");
            ECOrderDetailState value = ECShopOrderDetailFragment.this.li().t2().getValue();
            ECCustomerServiceFragment.Companion companion = ECCustomerServiceFragment.INSTANCE;
            Context requireContext = ECShopOrderDetailFragment.this.requireContext();
            CustomerServiceScene customerServiceScene = CustomerServiceScene.ORDER_DETAIL_PAGE_SHOP;
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) value.orderSkuInfo);
            String str = ((OrderSkuDetail) first).shop.id;
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) value.orderSpuInfo);
            companion.a(requireContext, customerServiceScene, str, ((OrderSpuDetail) first2).id, orderId);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void d() {
            ECCustomerServiceFragment.Companion.b(ECCustomerServiceFragment.INSTANCE, ECShopOrderDetailFragment.this.requireContext(), CustomerServiceScene.MY_ORDER_LIST_PAGE_PLATFORM, null, null, null, 28, null);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void f(String orderId) {
            ECOrderDetailOperation.f103235a.a(ECShopOrderDetailFragment.this.requireContext(), orderId);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void g(String link) {
            ECOrderDetailReporter.f103294d.f("qstore_order_detail_after_sales_clk", 4);
            ECScheme.g(link, null, 2, null);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void h(String link) {
            ECOrderDetailReporter.f103294d.g("qstore_order_detail_product_card_clk");
            ECScheme.g(link, null, 2, null);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void j(String link) {
            ECOrderDetailReporter.f103294d.f("qstore_order_detail_after_sales_clk", 3);
            ECScheme.g(link, null, 2, null);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void k(String link) {
            ECOrderDetailReporter.f103294d.g("qstore_order_detail_enter_shop_clk");
            ECScheme.g(link, null, 2, null);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void l(String orderId) {
            ECOrderDetailReporter.f103294d.g("qstore_order_detail_view_snapshot_clk");
            yi0.a.q(ECShopOrderDetailFragment.this.requireContext(), ECOrderSnapshotFragment.class, BundleKt.bundleOf(TuplesKt.to("key_snapshot_data", ECShopOrderDetailFragment.this.li().t2().getValue().a().toJsonString())), 0, null, 24, null);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void m(ECAddress ecAddress) {
            ECOrderDetailReporter.f103294d.g("qstore_order_detail_modify_address_clk");
            OrderDetailCheckValidData modifyAddressValidData = ECShopOrderDetailFragment.this.li().getModifyAddressValidData();
            if (modifyAddressValidData != null && System.currentTimeMillis() > modifyAddressValidData.exceedTimeMs) {
                ECOrderDetailOperation.f103235a.b(ECShopOrderDetailFragment.this.requireContext(), modifyAddressValidData.exceedStr, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$OrderDetailListListener$modifyAddressInfo$1
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
                        ECShopOrderDetailFragment.this.li().k2(ECShopOrderDetailFragment.this.orderId);
                    }
                });
            } else {
                ECModifyOrderAddressFragment.Companion.b(ECModifyOrderAddressFragment.INSTANCE, ECShopOrderDetailFragment.this.requireActivity(), 1001, null, ECShopOrderDetailFragment.this.orderId, ecAddress, 4, null);
            }
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void n(String orderId, String logisticsCode) {
            ECOrderDetailReporter.f103294d.g("qstore_order_detail_logistics_clk");
            ECLogisticsTraceFragment.INSTANCE.a(ECShopOrderDetailFragment.this.requireContext(), orderId, logisticsCode);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void o(final f.TicketInfoData ticketInfoData) {
            SlidingUpDialog slidingUpDialog = ECShopOrderDetailFragment.this.ticketListDialog;
            if (slidingUpDialog == null || !slidingUpDialog.isShowing()) {
                final ECOrderTicketListView eCOrderTicketListView = ECShopOrderDetailFragment.this.ticketListView;
                if (eCOrderTicketListView == null) {
                    eCOrderTicketListView = new ECOrderTicketListView(ECShopOrderDetailFragment.this.requireContext());
                    eCOrderTicketListView.setOnItemClickListener(new Function2<String, TicketDetail, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$OrderDetailListListener$showTicketListDialog$$inlined$also$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(String str, TicketDetail ticketDetail) {
                            invoke2(str, ticketDetail);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String str, TicketDetail ticketDetail) {
                            ECScheme.g(b.f414604a.a(str, ticketDetail), null, 2, null);
                            SlidingUpDialog slidingUpDialog2 = ECShopOrderDetailFragment.this.ticketListDialog;
                            if (slidingUpDialog2 != null) {
                                slidingUpDialog2.dismiss();
                            }
                        }
                    });
                }
                ECShopOrderDetailFragment eCShopOrderDetailFragment = ECShopOrderDetailFragment.this;
                SlidingUpDialog slidingUpDialog2 = new SlidingUpDialog(ECShopOrderDetailFragment.this.requireActivity(), false, 2, null);
                SlidingUpDialog.U(slidingUpDialog2, eCOrderTicketListView, null, 2, null);
                slidingUpDialog2.X(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$OrderDetailListListener$showTicketListDialog$$inlined$also$lambda$2
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
                        Object first;
                        ECOrderDetailState value = ECShopOrderDetailFragment.this.li().t2().getValue();
                        ECOrderTicketListView eCOrderTicketListView2 = eCOrderTicketListView;
                        f.TicketInfoData ticketInfoData2 = ticketInfoData;
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) value.orderSkuInfo);
                        eCOrderTicketListView2.a(ticketInfoData2, ((OrderSkuDetail) first).shop.name);
                    }
                });
                slidingUpDialog2.show();
                Unit unit = Unit.INSTANCE;
                eCShopOrderDetailFragment.ticketListDialog = slidingUpDialog2;
            }
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void i(String link) {
            ECScheme.g(link, null, 2, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/qshop/ECShopOrderDetailFragment$initViews$2$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "d", "I", "lastVisiblePosition", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int lastVisiblePosition;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ StaggeredGridLayoutManager f103304e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ECShopOrderDetailFragment f103305f;

        c(StaggeredGridLayoutManager staggeredGridLayoutManager, ECShopOrderDetailFragment eCShopOrderDetailFragment) {
            this.f103304e = staggeredGridLayoutManager;
            this.f103305f = eCShopOrderDetailFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            int lastIndex;
            super.onScrolled(recyclerView, dx5, dy5);
            int[] findLastVisibleItemPositions = this.f103304e.findLastVisibleItemPositions(null);
            int i3 = 1;
            if (!(findLastVisibleItemPositions.length == 0)) {
                int i16 = findLastVisibleItemPositions[0];
                lastIndex = ArraysKt___ArraysKt.getLastIndex(findLastVisibleItemPositions);
                if (1 <= lastIndex) {
                    while (true) {
                        int i17 = findLastVisibleItemPositions[i3];
                        if (i16 < i17) {
                            i16 = i17;
                        }
                        if (i3 == lastIndex) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                this.lastVisiblePosition = i16;
                return;
            }
            throw new NoSuchElementException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (newState == 0 && this.f103305f.li().get_hasMoreRecommendData() && this.f103304e.getItemCount() - this.lastVisiblePosition <= 4) {
                this.f103305f.li().G2(RecommendFetchType.FETCH_MORE);
            }
        }
    }

    private final void initViews(View view) {
        Group group = (Group) view.findViewById(R.id.nrk);
        this.bottomArea = group;
        if (group == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomArea");
        }
        ECViewUtilKt.b(group, R.id.nvn, R.id.nrj, R.id.f163068o44, R.id.ob8);
        this.mainOperateTv = (TextView) view.findViewById(R.id.f163068o44);
        this.subOperateTv = (TextView) view.findViewById(R.id.ob8);
        ECStateCenterView eCStateCenterView = (ECStateCenterView) view.findViewById(R.id.f163103ob2);
        eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$initViews$$inlined$apply$lambda$1
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
                ECShopOrderDetailFragment.this.fi();
            }
        });
        Unit unit = Unit.INSTANCE;
        this.stateView = eCStateCenterView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.o5f);
        recyclerView.setAdapter(this.adapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.addOnScrollListener(new c(staggeredGridLayoutManager, this));
        recyclerView.addItemDecoration(new com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ui(ECOrderDetailState state) {
        List<? extends f> list;
        int collectionSizeOrDefault;
        List emptyList;
        Object first;
        Object first2;
        boolean z16;
        String str;
        Object first3;
        Object first4;
        ArrayList arrayList = new ArrayList();
        QShopOrderState a16 = QShopOrderState.INSTANCE.a(state.orderStateVal);
        arrayList.add(new f.OrderStateData(state.orderStateVal, ki(a16), state.getHeaderState().stateTitleStr, state.getHeaderState().stateDescStr));
        ECOrderDetailAccountInfoData accountInfo = state.getAccountInfo();
        if (state.widgetsVisibility.showAccountInfo) {
            arrayList.add(new f.AccountInfoData(accountInfo.type, accountInfo.title, accountInfo.id));
            arrayList.add(f.e.f103256b);
        }
        BulletinInfo bulletinInfo = state.bulletinInfo;
        if (bulletinInfo != null) {
            String str2 = bulletinInfo.title;
            String str3 = bulletinInfo.content;
            first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) state.orderSkuInfo);
            String str4 = ((OrderSkuDetail) first3).shop.id;
            first4 = CollectionsKt___CollectionsKt.first((List<? extends Object>) state.orderSpuInfo);
            arrayList.add(new f.BulletinInfoData(str2, str3, str4, ((OrderSpuDetail) first4).id, state.orderId));
        }
        LogisticsInfo logisticsInfo = state.logisticsInfo;
        String str5 = state.orderId;
        ECOrderDetailWidgetsVisibility eCOrderDetailWidgetsVisibility = state.widgetsVisibility;
        f.ShippingAndLocationData shippingAndLocationData = new f.ShippingAndLocationData(str5, eCOrderDetailWidgetsVisibility.showLogisticsInfo, logisticsInfo, eCOrderDetailWidgetsVisibility.showAddressInfo, state.addressInfo, eCOrderDetailWidgetsVisibility.showModifyAddress);
        arrayList.add(shippingAndLocationData);
        if (shippingAndLocationData.getShowing()) {
            arrayList.add(f.e.f103256b);
        }
        if (pi()) {
            arrayList.add(new f.ContactCustomerServiceData(state.orderId));
            arrayList.add(f.e.f103256b);
        }
        arrayList.add(new f.QShopGoodsDetailData(state.orderSkuInfo, state.orderSpuInfo, state.goodsOperateState, state.deliverMessage, !pi(), pi()));
        if (!state.e().isEmpty()) {
            arrayList.add(new f.ExtraJumpInfoData(state.e()));
        }
        f.e eVar = f.e.f103256b;
        arrayList.add(eVar);
        f.TicketInfoData ticketInfoData = state.ticketInfo;
        if (ticketInfoData != null) {
            arrayList.add(ticketInfoData);
            arrayList.add(eVar);
        }
        if (!pi()) {
            String ji5 = ji(a16);
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) state.orderSkuInfo);
            int i3 = ((OrderSkuDetail) first).quantity;
            ECOrderDetailPayInfo eCOrderDetailPayInfo = state.payInfo;
            long j3 = eCOrderDetailPayInfo.orderPrice;
            long j16 = eCOrderDetailPayInfo.originalPrice;
            boolean z17 = state.widgetsVisibility.showFreightInfo;
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) state.orderSkuInfo);
            String str6 = ((OrderSkuDetail) first2).freight;
            List<QShopOrderPromoInfo> g16 = state.g();
            if (a16 == QShopOrderState.REFUND || a16 == QShopOrderState.PAYMENT_CANCELED) {
                z16 = true;
                str = str6;
            } else {
                str = str6;
                z16 = false;
            }
            arrayList.add(new f.PriceDetailData(ji5, i3, j3, j16, z17, str, g16, z16));
            arrayList.add(eVar);
        }
        String str7 = state.orderId;
        long j17 = state.createTimestampMs;
        boolean z18 = state.widgetsVisibility.showPayDetail;
        ECOrderDetailPayInfo eCOrderDetailPayInfo2 = state.payInfo;
        arrayList.add(new f.DetailInfoData(str7, j17, null, z18, eCOrderDetailPayInfo2.payType, eCOrderDetailPayInfo2.payTimestampMs, requireContext().getString(R.string.wqk), state.orderNote, state.orderNoteFromSeller, !pi(), 4, null));
        if (!pi()) {
            List<ECProductRecommendItemData> h16 = state.h();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(h16, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (ECProductRecommendItemData eCProductRecommendItemData : h16) {
                arrayList2.add(new f.RecommendGoodsData(eCProductRecommendItemData.id, eCProductRecommendItemData.getData()));
            }
            if (!arrayList2.isEmpty()) {
                emptyList = CollectionsKt__CollectionsKt.mutableListOf(f.e.f103256b, f.k.f103278b);
                emptyList.addAll(arrayList2);
            } else {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, emptyList);
        }
        ECOrderDetailListAdapter eCOrderDetailListAdapter = this.adapter;
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        eCOrderDetailListAdapter.n0(list);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        final String str;
        final ECAddress eCAddress;
        if (requestCode == 1001 && resultCode == -1) {
            if (data == null || (str = data.getStringExtra("bundle_key_order_id")) == null) {
                str = "";
            }
            if ((!Intrinsics.areEqual(str, this.orderId)) || data == null || (eCAddress = (ECAddress) data.getParcelableExtra("bundle_key_result_address")) == null) {
                return;
            }
            g gVar = new g(requireContext());
            gVar.setTitle(requireContext().getString(R.string.wib));
            gVar.Y(requireContext().getString(R.string.f169619wo3));
            gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$onActivityResult$$inlined$apply$lambda$1
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
                    ECShopOrderDetailFragment.this.li().H2(eCAddress, str);
                }
            });
            gVar.show();
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
