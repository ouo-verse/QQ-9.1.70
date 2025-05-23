package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import android.app.Application;
import android.os.CountDownTimer;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.ecommerce.biz.bulletin.BulletinScene;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.OrderStateUpdateType;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.BottomAreaOperation;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderSpuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayStatus;
import com.tencent.ecommerce.biz.orders.common.QShopOrderState;
import com.tencent.ecommerce.biz.recommend.models.ECProductRecommendItemData;
import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import com.tencent.ecommerce.biz.util.ECDateUtil;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.buyerorder.ECQShopOrderInfoRepository;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$OrderInfo;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u009e\u00012\u00020\u00012\u00020\u0002:\u0002\u009f\u0001B\u0013\u0012\b\u0010\u0098\u0001\u001a\u00030\u0095\u0001\u00a2\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fH\u0002J4\u0010'\u001a\u00020\u0003*\u00020\"2\u001c\u0010&\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030$\u0012\u0006\u0012\u0004\u0018\u00010%0#H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u0003H\u0002J\f\u0010+\u001a\u00020\u0012*\u00020\u0012H\u0002J \u00100\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010/\u001a\u00020.H\u0002J\"\u00103\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00052\u0006\u00102\u001a\u000201H\u0002R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u0012048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u0012088\u0006\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020=048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u00106R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020=088\u0006\u00a2\u0006\f\n\u0004\b@\u0010:\u001a\u0004\bA\u0010<R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u0015048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u00106R\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020\u0015088\u0006\u00a2\u0006\f\n\u0004\bE\u0010:\u001a\u0004\bF\u0010<R\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020I0H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001d\u0010R\u001a\b\u0012\u0004\u0012\u00020I0M8\u0006\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00050H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010KR\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00050M8\u0006\u00a2\u0006\f\n\u0004\bU\u0010O\u001a\u0004\bV\u0010QR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020X0H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010KR\u001d\u0010]\u001a\b\u0012\u0004\u0012\u00020X0M8\u0006\u00a2\u0006\f\n\u0004\b[\u0010O\u001a\u0004\b\\\u0010QR\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR$\u0010k\u001a\u00020,2\u0006\u0010f\u001a\u00020,8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR(\u0010q\u001a\u0004\u0018\u00010l2\b\u0010f\u001a\u0004\u0018\u00010l8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR$\u0010v\u001a\u00020\u00052\u0006\u0010f\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR(\u0010|\u001a\u0004\u0018\u00010w2\b\u0010f\u001a\u0004\u0018\u00010w8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R(\u0010\u007f\u001a\u0004\u0018\u00010w2\b\u0010f\u001a\u0004\u0018\u00010w8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b}\u0010y\u001a\u0004\b~\u0010{R\u0018\u0010\u0081\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010sR\u001f\u0010\u0086\u0001\u001a\n\u0012\u0005\u0012\u00030\u0083\u00010\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0019\u0010\u0089\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0019\u0010\u008b\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010sR\u001c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u008f\u0001R\u0016\u0010\u0092\u0001\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0091\u0001\u0010sR\u0016\u0010\u0094\u0001\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0093\u0001\u0010sR\u0018\u0010\u0098\u0001\u001a\u00030\u0095\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0014\u0010\u009b\u0001\u001a\u00020.8F\u00a2\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00a0\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECShopOrderDetailViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "", "onCleared", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "k2", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "newAddress", "H2", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/RecommendFetchType;", "fetchType", Constants.MMCCID, "j2", "i2", "C2", "B2", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "orderDetailState", Constants.BASE_IN_PLUGIN_VERSION, "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", "state", "M2", "K2", "desc", "L2", "J2", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/d;", "data", "I2", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$OrderInfo;", "orderInfo", "N2", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "action", NowProxyConstants.AccountInfoKey.A2, "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "o2", "F2", "E2", "Lcom/tencent/ecommerce/biz/orders/common/QShopOrderState;", "preferStr", "", "hasPaymentInconsistency", "r2", "", "deadlineMs", "q2", "Lkotlinx/coroutines/flow/MutableStateFlow;", "i", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_orderDetailState", "Lkotlinx/coroutines/flow/StateFlow;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/StateFlow;", "t2", "()Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/c;", BdhLogUtil.LogTag.Tag_Conn, "_bottomBarState", "D", ICustomDataEditor.NUMBER_PARAM_2, "bottomBarState", "E", "_pageState", UserInfo.SEX_FEMALE, "w2", "pageState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/m;", "G", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_payOrderEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "H", "Lkotlinx/coroutines/flow/SharedFlow;", "x2", "()Lkotlinx/coroutines/flow/SharedFlow;", "payOrderEvent", "I", "_alertDialogEvent", "J", "l2", "alertDialogEvent", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/l;", "K", "_toastEvent", "L", "z2", "toastEvent", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/d;", "M", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/d;", "operateRepository", "Lcom/tencent/ecommerce/repo/buyerorder/b;", "N", "Lcom/tencent/ecommerce/repo/buyerorder/b;", "orderRepository", "<set-?>", "P", "Lcom/tencent/ecommerce/biz/orders/common/QShopOrderState;", "v2", "()Lcom/tencent/ecommerce/biz/orders/common/QShopOrderState;", "orderState", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "u2", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "orderSkuDetail", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", "y2", "()Ljava/lang/String;", "spuId", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/k;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/k;", "m2", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/k;", "applyAfterSalesValidData", "T", ICustomDataEditor.STRING_PARAM_2, "modifyAddressValidData", "U", "token", "", "Lcom/tencent/ecommerce/biz/recommend/models/a;", "V", "Ljava/util/List;", "recommendDatas", "W", "Z", "_hasMoreRecommendData", "X", "isLoadingRecommendData", "Y", "recommendCookie", "Landroid/os/CountDownTimer;", "Landroid/os/CountDownTimer;", "countDownTimer", "a0", "paramsErrorMsg", "b0", "modifyAddressSucceedTips", "Landroid/app/Application;", "c0", "Landroid/app/Application;", "app", "p2", "()Z", "hasMoreRecommendData", "<init>", "(Landroid/app/Application;)V", "d0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopOrderDetailViewModel extends AndroidViewModel implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableStateFlow<ECOrderDetailBottomBarState> _bottomBarState;

    /* renamed from: D, reason: from kotlin metadata */
    private final StateFlow<ECOrderDetailBottomBarState> bottomBarState;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableStateFlow<ECOrderSubmitViewModel.g> _pageState;

    /* renamed from: F, reason: from kotlin metadata */
    private final StateFlow<ECOrderSubmitViewModel.g> pageState;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableSharedFlow<PayOrderEventInfo> _payOrderEvent;

    /* renamed from: H, reason: from kotlin metadata */
    private final SharedFlow<PayOrderEventInfo> payOrderEvent;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableSharedFlow<String> _alertDialogEvent;

    /* renamed from: J, reason: from kotlin metadata */
    private final SharedFlow<String> alertDialogEvent;

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableSharedFlow<OrderDetailToastEvent> _toastEvent;

    /* renamed from: L, reason: from kotlin metadata */
    private final SharedFlow<OrderDetailToastEvent> toastEvent;

    /* renamed from: M, reason: from kotlin metadata */
    private final com.tencent.ecommerce.repo.buyerorder.orderlist.d operateRepository;

    /* renamed from: N, reason: from kotlin metadata */
    private final com.tencent.ecommerce.repo.buyerorder.b orderRepository;

    /* renamed from: P, reason: from kotlin metadata */
    private QShopOrderState orderState;

    /* renamed from: Q, reason: from kotlin metadata */
    private OrderSkuDetail orderSkuDetail;

    /* renamed from: R, reason: from kotlin metadata */
    private String spuId;

    /* renamed from: S, reason: from kotlin metadata */
    private OrderDetailCheckValidData applyAfterSalesValidData;

    /* renamed from: T, reason: from kotlin metadata */
    private OrderDetailCheckValidData modifyAddressValidData;

    /* renamed from: U, reason: from kotlin metadata */
    private String token;

    /* renamed from: V, reason: from kotlin metadata */
    private final List<ECProductRecommendItemData> recommendDatas;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean _hasMoreRecommendData;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean isLoadingRecommendData;

    /* renamed from: Y, reason: from kotlin metadata */
    private String recommendCookie;

    /* renamed from: Z, reason: from kotlin metadata */
    private CountDownTimer countDownTimer;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final String paramsErrorMsg;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final String modifyAddressSucceedTips;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    public final Application app;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableStateFlow<ECOrderDetailState> _orderDetailState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final StateFlow<ECOrderDetailState> orderDetailState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECShopOrderDetailViewModel$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Application f103146b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ECOrderDetailState f103147c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f103148d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Application application, ECOrderDetailState eCOrderDetailState, long j3, long j16, long j17) {
            super(j16, j17);
            this.f103146b = application;
            this.f103147c = eCOrderDetailState;
            this.f103148d = j3;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ECShopOrderDetailViewModel.this.k2(this.f103147c.orderId);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            ECShopOrderDetailViewModel.this.L2(this.f103146b.getString(R.string.wp8, ECDateUtil.f104850a.f(this.f103146b, millisUntilFinished)));
        }
    }

    public ECShopOrderDetailViewModel(Application application) {
        super(application);
        this.app = application;
        MutableStateFlow<ECOrderDetailState> MutableStateFlow = StateFlowKt.MutableStateFlow(h.a());
        this._orderDetailState = MutableStateFlow;
        this.orderDetailState = MutableStateFlow;
        MutableStateFlow<ECOrderDetailBottomBarState> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new ECOrderDetailBottomBarState(false, false, 0, null, false, 0, null, 127, null));
        this._bottomBarState = MutableStateFlow2;
        this.bottomBarState = MutableStateFlow2;
        MutableStateFlow<ECOrderSubmitViewModel.g> MutableStateFlow3 = StateFlowKt.MutableStateFlow(ECOrderSubmitViewModel.g.c.f103527a);
        this._pageState = MutableStateFlow3;
        this.pageState = MutableStateFlow3;
        MutableSharedFlow<PayOrderEventInfo> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._payOrderEvent = MutableSharedFlow$default;
        this.payOrderEvent = FlowKt.asSharedFlow(MutableSharedFlow$default);
        MutableSharedFlow<String> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._alertDialogEvent = MutableSharedFlow$default2;
        this.alertDialogEvent = FlowKt.asSharedFlow(MutableSharedFlow$default2);
        MutableSharedFlow<OrderDetailToastEvent> MutableSharedFlow$default3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._toastEvent = MutableSharedFlow$default3;
        this.toastEvent = FlowKt.asSharedFlow(MutableSharedFlow$default3);
        ServiceLocator serviceLocator = ServiceLocator.f104891i;
        this.operateRepository = serviceLocator.k();
        this.orderRepository = serviceLocator.i();
        this.orderState = QShopOrderState.UNKNOWN;
        this.spuId = "";
        this.token = "";
        this.recommendDatas = new ArrayList();
        this._hasMoreRecommendData = true;
        this.recommendCookie = "";
        this.paramsErrorMsg = application.getString(R.string.wo9);
        this.modifyAddressSucceedTips = application.getString(R.string.f169620wo4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D2(ECOrderDetailState orderDetailState) {
        Object first;
        Object first2;
        if (orderDetailState.bulletinInfo != null) {
            com.tencent.ecommerce.biz.bulletin.b bVar = com.tencent.ecommerce.biz.bulletin.b.f101349a;
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) orderDetailState.orderSkuInfo);
            String str = ((OrderSkuDetail) first).shop.id;
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) orderDetailState.orderSkuInfo);
            bVar.d(str, ((OrderSkuDetail) first2).spuId, BulletinScene.ORDER_DETAIL_PAGE, orderDetailState.orderId);
        }
    }

    private final void F2() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        ECOrderDetailState value = this.orderDetailState.getValue();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        boolean z16 = false;
        if (value.orderStateVal == QShopOrderState.PAYMENT_PENDING.value) {
            if ((value.preferOrderStateDesc.length() == 0) && value.deadlineMs > timeInMillis) {
                z16 = true;
            }
        }
        if (z16) {
            this.countDownTimer = new b(wg0.a.a(), value, timeInMillis, value.deadlineMs - timeInMillis, 1000L).start();
            cg0.a.b("ECShopOrderDetailViewModel", "start timer: startTime: " + timeInMillis + ", deadline: " + value.deadlineMs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I2(ECOrderDetailBottomUIData data) {
        BottomAreaOperation bottomAreaOperation;
        int i3;
        BottomAreaOperation bottomAreaOperation2;
        int i16;
        BottomAreaOperation bottomAreaOperation3;
        int i17;
        boolean z16;
        BottomAreaOperation bottomAreaOperation4;
        int i18;
        BottomAreaOperation bottomAreaOperation5 = BottomAreaOperation.NONE;
        if (data.showConfirmReceive) {
            bottomAreaOperation2 = BottomAreaOperation.CONFIRM_RECEIVE;
            i16 = R.string.wic;
        } else if (data.showContinuePay) {
            bottomAreaOperation2 = BottomAreaOperation.CONTINUE_PAY;
            i16 = R.string.wir;
        } else if (data.showWriteComment) {
            bottomAreaOperation2 = BottomAreaOperation.WRITE_COMMENT;
            i16 = R.string.whe;
        } else if (data.showGoDelivery) {
            bottomAreaOperation2 = BottomAreaOperation.GO_DELIVERY;
            i16 = R.string.wkq;
        } else {
            bottomAreaOperation = bottomAreaOperation5;
            i3 = -1;
            boolean z17 = i3 == -1;
            if (!data.showCancelOrder) {
                bottomAreaOperation4 = BottomAreaOperation.CANCEL_ORDER;
                i18 = R.string.wed;
            } else if (data.showReviewComment) {
                bottomAreaOperation4 = BottomAreaOperation.REVIEW_COMMENT;
                i18 = R.string.wrq;
            } else {
                bottomAreaOperation3 = bottomAreaOperation5;
                i17 = -1;
                z16 = false;
                boolean z18 = i17 != -1 ? true : z16;
                this._bottomBarState.setValue(new ECOrderDetailBottomBarState(!z17 || z18, z17, i3, bottomAreaOperation, z18, i17, bottomAreaOperation3));
            }
            i17 = i18;
            bottomAreaOperation3 = bottomAreaOperation4;
            z16 = true;
            if (i17 != -1) {
            }
            this._bottomBarState.setValue(new ECOrderDetailBottomBarState(!z17 || z18, z17, i3, bottomAreaOperation, z18, i17, bottomAreaOperation3));
        }
        bottomAreaOperation = bottomAreaOperation2;
        i3 = i16;
        if (i3 == -1) {
        }
        if (!data.showCancelOrder) {
        }
        i17 = i18;
        bottomAreaOperation3 = bottomAreaOperation4;
        z16 = true;
        if (i17 != -1) {
        }
        this._bottomBarState.setValue(new ECOrderDetailBottomBarState(!z17 || z18, z17, i3, bottomAreaOperation, z18, i17, bottomAreaOperation3));
    }

    private final void J2(ECOrderDetailState state) {
        Object first;
        Object first2;
        this.orderState = QShopOrderState.INSTANCE.a(state.orderStateVal);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) state.orderSkuInfo);
        this.orderSkuDetail = (OrderSkuDetail) first;
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) state.orderSpuInfo);
        this.spuId = ((OrderSpuDetail) first2).id;
        ECOrderDetailGoodsOperateState eCOrderDetailGoodsOperateState = state.goodsOperateState;
        this.applyAfterSalesValidData = eCOrderDetailGoodsOperateState != null ? eCOrderDetailGoodsOperateState.applyAfterSalesValidInfo : null;
        this.modifyAddressValidData = state.modifyAddressValidInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K2(ECOrderDetailState state) {
        cg0.a.b("ECShopOrderDetailViewModel", "updateOrderDetailState state=" + QShopOrderState.INSTANCE.a(state.orderStateVal) + " payType=" + state.payInfo.payType);
        this._orderDetailState.setValue(state);
        F2();
        J2(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M2(ECOrderSubmitViewModel.g state) {
        this._pageState.setValue(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N2(ECOrderInfo$OrderInfo orderInfo) {
        ECQShopOrderInfoRepository.Companion companion = ECQShopOrderInfoRepository.INSTANCE;
        K2(E2(companion.b(orderInfo)));
        I2(companion.d(orderInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String o2(String orderId) {
        return "params is empty. orderId: " + orderId + ", token: " + this.token;
    }

    private final String r2(QShopOrderState state, String preferStr, boolean hasPaymentInconsistency) {
        int i3;
        if (preferStr.length() > 0) {
            return preferStr;
        }
        if (hasPaymentInconsistency) {
            return this.app.getString(R.string.wp6);
        }
        switch (j.f103192a[state.ordinal()]) {
            case 1:
                i3 = R.string.wgc;
                break;
            case 2:
                i3 = R.string.wp7;
                break;
            case 3:
                i3 = R.string.wp5;
                break;
            case 4:
                i3 = R.string.wjg;
                break;
            case 5:
                i3 = R.string.wjf;
                break;
            case 6:
                i3 = R.string.wqv;
                break;
            case 7:
                i3 = R.string.f169625wp4;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return this.app.getString(i3);
    }

    public final void B2(String orderId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECShopOrderDetailViewModel$notifyPaySucceed$1(this, orderId, null), 3, null);
    }

    public final void C2(String orderId) {
        A2(ViewModelKt.getViewModelScope(this), new ECShopOrderDetailViewModel$payOrder$1(this, orderId, null));
    }

    public final void G2(RecommendFetchType fetchType) {
        List listOf;
        JSONObject b16;
        boolean z16 = (this.recommendDatas.isEmpty() ^ true) && !get_hasMoreRecommendData();
        cg0.a.b("ECShopOrderDetailViewModel", "tryFetchRecommendGoodsInfo. hasFetchedData: " + z16 + ", fetchType: " + fetchType.name());
        if (z16 && fetchType == RecommendFetchType.FIRST_FETCH) {
            cg0.a.b("ECShopOrderDetailViewModel", "recommend data has fetched. Duplicated first fetch skipped.");
            return;
        }
        if (this.isLoadingRecommendData) {
            cg0.a.b("ECShopOrderDetailViewModel", "isLoadingRecommendData: " + this.isLoadingRecommendData + ", fetch skipped.");
            return;
        }
        if (this.spuId.length() == 0) {
            cg0.a.b("ECShopOrderDetailViewModel", "spuId is empty. fetch skipped.");
            return;
        }
        ECShopRecommendScene eCShopRecommendScene = ECShopRecommendScene.QQ_SHOP_ORDER_DETAIL;
        this.isLoadingRecommendData = true;
        ti0.a aVar = ti0.a.f436377a;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(this.spuId);
        b16 = aVar.b((r13 & 1) != 0 ? "" : null, listOf, eCShopRecommendScene, (r13 & 8) != 0 ? "" : null, this.recommendCookie);
        cg0.a.b("ECShopOrderDetailViewModel", "start fetch recommend info. spuId: " + this.spuId + "\uff0ccookie: " + this.recommendCookie);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECShopOrderDetailViewModel$tryFetchRecommendGoodsInfo$1(this, b16, null), 3, null);
    }

    public final void H2(ECAddress newAddress, String orderId) {
        A2(ViewModelKt.getViewModelScope(this), new ECShopOrderDetailViewModel$updateAddressInfo$1(this, orderId, newAddress, null));
    }

    public final void i2(String orderId) {
        A2(ViewModelKt.getViewModelScope(this), new ECShopOrderDetailViewModel$cancelOrder$1(this, orderId, null));
    }

    public final void j2(String orderId) {
        A2(ViewModelKt.getViewModelScope(this), new ECShopOrderDetailViewModel$confirmReceive$1(this, orderId, null));
    }

    public final void k2(String orderId) {
        cg0.a.b("ECShopOrderDetailViewModel", "fetchOrderDetailData orderId: " + orderId);
        if (!(orderId.length() == 0)) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECShopOrderDetailViewModel$fetchOrderDetailData$1(this, orderId, null), 3, null);
        } else {
            cg0.a.a("ECShopOrderDetailViewModel", "fetchOrderDetailData", "invalid param: orderId is Empty");
            M2(new ECOrderSubmitViewModel.g.Error(-1, ""));
        }
    }

    public final SharedFlow<String> l2() {
        return this.alertDialogEvent;
    }

    /* renamed from: m2, reason: from getter */
    public final OrderDetailCheckValidData getApplyAfterSalesValidData() {
        return this.applyAfterSalesValidData;
    }

    public final StateFlow<ECOrderDetailBottomBarState> n2() {
        return this.bottomBarState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = null;
    }

    /* renamed from: p2, reason: from getter */
    public final boolean get_hasMoreRecommendData() {
        return this._hasMoreRecommendData;
    }

    /* renamed from: s2, reason: from getter */
    public final OrderDetailCheckValidData getModifyAddressValidData() {
        return this.modifyAddressValidData;
    }

    public final StateFlow<ECOrderDetailState> t2() {
        return this.orderDetailState;
    }

    /* renamed from: u2, reason: from getter */
    public final OrderSkuDetail getOrderSkuDetail() {
        return this.orderSkuDetail;
    }

    /* renamed from: v2, reason: from getter */
    public final QShopOrderState getOrderState() {
        return this.orderState;
    }

    public final StateFlow<ECOrderSubmitViewModel.g> w2() {
        return this.pageState;
    }

    public final SharedFlow<PayOrderEventInfo> x2() {
        return this.payOrderEvent;
    }

    /* renamed from: y2, reason: from getter */
    public final String getSpuId() {
        return this.spuId;
    }

    public final SharedFlow<OrderDetailToastEvent> z2() {
        return this.toastEvent;
    }

    private final void A2(CoroutineScope coroutineScope, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ECShopOrderDetailViewModel$launchMutexOperation$1(this, function1, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L2(String desc) {
        ECOrderDetailState b16;
        MutableStateFlow<ECOrderDetailState> mutableStateFlow = this._orderDetailState;
        b16 = r3.b((r49 & 1) != 0 ? r3.orderId : null, (r49 & 2) != 0 ? r3.orderStateVal : 0, (r49 & 4) != 0 ? r3.headerState : ECOrderDetailHeaderState.b(this._orderDetailState.getValue().getHeaderState(), null, desc, 1, null), (r49 & 8) != 0 ? r3.preferOrderStateTitle : null, (r49 & 16) != 0 ? r3.preferOrderStateDesc : null, (r49 & 32) != 0 ? r3.createTimestampMs : 0L, (r49 & 64) != 0 ? r3.deadlineMs : 0L, (r49 & 128) != 0 ? r3.hasComment : false, (r49 & 256) != 0 ? r3.orderNote : null, (r49 & 512) != 0 ? r3.orderNoteFromSeller : null, (r49 & 1024) != 0 ? r3.buyerMobile : null, (r49 & 2048) != 0 ? r3.accountInfo : null, (r49 & 4096) != 0 ? r3.logisticsInfo : null, (r49 & 8192) != 0 ? r3.addressInfo : null, (r49 & 16384) != 0 ? r3.modifyAddressValidInfo : null, (r49 & 32768) != 0 ? r3.orderSkuInfo : null, (r49 & 65536) != 0 ? r3.orderSpuInfo : null, (r49 & 131072) != 0 ? r3.payInfo : null, (r49 & 262144) != 0 ? r3.ticketInfo : null, (r49 & 524288) != 0 ? r3.promoInfos : null, (r49 & 1048576) != 0 ? r3.usedCouponInfo : null, (r49 & 2097152) != 0 ? r3.goodsOperateState : null, (r49 & 4194304) != 0 ? r3.recommendList : null, (r49 & 8388608) != 0 ? r3.widgetsVisibility : null, (r49 & 16777216) != 0 ? r3.updateType : OrderStateUpdateType.ONLY_HEADER, (r49 & 33554432) != 0 ? r3.bulletinInfo : null, (r49 & 67108864) != 0 ? r3.extraJumpInfoList : null, (r49 & 134217728) != 0 ? r3.blindBoxWareHouseLink : null, (r49 & 268435456) != 0 ? mutableStateFlow.getValue().deliverMessage : null);
        mutableStateFlow.setValue(b16);
    }

    private final String q2(QShopOrderState state, String preferStr, long deadlineMs) {
        if (preferStr.length() > 0) {
            return preferStr;
        }
        Application a16 = wg0.a.a();
        int i3 = j.f103193b[state.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return "";
            }
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            cg0.a.b("ECShopOrderDetailViewModel", "deadlineMs: " + deadlineMs + ", currentTimeMs: " + timeInMillis);
            return a16.getString(R.string.wjh, Integer.valueOf(ECDateUtil.e(ECDateUtil.f104850a, deadlineMs - timeInMillis, 0, 2, null)));
        }
        long timeInMillis2 = Calendar.getInstance().getTimeInMillis();
        cg0.a.b("ECShopOrderDetailViewModel", "deadlineMs: " + deadlineMs + ", currentTimeMs: " + timeInMillis2);
        if (deadlineMs > timeInMillis2) {
            return a16.getString(R.string.wp8, ECDateUtil.f104850a.f(a16, deadlineMs - timeInMillis2));
        }
        cg0.a.a("ECShopOrderDetailViewModel", "getHeaderDescStr", "deadlineMs: " + deadlineMs + ", currentTimeMs: " + timeInMillis2);
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECOrderDetailState E2(ECOrderDetailState eCOrderDetailState) {
        List list;
        ECOrderDetailState b16;
        PayStatus d16 = this.orderRepository.d(eCOrderDetailState.orderId);
        QShopOrderState a16 = QShopOrderState.INSTANCE.a(eCOrderDetailState.orderStateVal);
        PayStatus payStatus = a16.getPayStatus();
        PayStatus payStatus2 = PayStatus.PAID;
        ECOrderDetailHeaderState eCOrderDetailHeaderState = new ECOrderDetailHeaderState(r2(a16, eCOrderDetailState.preferOrderStateTitle, d16 == payStatus2 && payStatus != payStatus2), q2(a16, eCOrderDetailState.preferOrderStateDesc, eCOrderDetailState.deadlineMs));
        list = CollectionsKt___CollectionsKt.toList(this.recommendDatas);
        b16 = eCOrderDetailState.b((r49 & 1) != 0 ? eCOrderDetailState.orderId : null, (r49 & 2) != 0 ? eCOrderDetailState.orderStateVal : 0, (r49 & 4) != 0 ? eCOrderDetailState.headerState : eCOrderDetailHeaderState, (r49 & 8) != 0 ? eCOrderDetailState.preferOrderStateTitle : null, (r49 & 16) != 0 ? eCOrderDetailState.preferOrderStateDesc : null, (r49 & 32) != 0 ? eCOrderDetailState.createTimestampMs : 0L, (r49 & 64) != 0 ? eCOrderDetailState.deadlineMs : 0L, (r49 & 128) != 0 ? eCOrderDetailState.hasComment : false, (r49 & 256) != 0 ? eCOrderDetailState.orderNote : null, (r49 & 512) != 0 ? eCOrderDetailState.orderNoteFromSeller : null, (r49 & 1024) != 0 ? eCOrderDetailState.buyerMobile : null, (r49 & 2048) != 0 ? eCOrderDetailState.accountInfo : null, (r49 & 4096) != 0 ? eCOrderDetailState.logisticsInfo : null, (r49 & 8192) != 0 ? eCOrderDetailState.addressInfo : null, (r49 & 16384) != 0 ? eCOrderDetailState.modifyAddressValidInfo : null, (r49 & 32768) != 0 ? eCOrderDetailState.orderSkuInfo : null, (r49 & 65536) != 0 ? eCOrderDetailState.orderSpuInfo : null, (r49 & 131072) != 0 ? eCOrderDetailState.payInfo : null, (r49 & 262144) != 0 ? eCOrderDetailState.ticketInfo : null, (r49 & 524288) != 0 ? eCOrderDetailState.promoInfos : null, (r49 & 1048576) != 0 ? eCOrderDetailState.usedCouponInfo : null, (r49 & 2097152) != 0 ? eCOrderDetailState.goodsOperateState : null, (r49 & 4194304) != 0 ? eCOrderDetailState.recommendList : list, (r49 & 8388608) != 0 ? eCOrderDetailState.widgetsVisibility : null, (r49 & 16777216) != 0 ? eCOrderDetailState.updateType : OrderStateUpdateType.ALL, (r49 & 33554432) != 0 ? eCOrderDetailState.bulletinInfo : null, (r49 & 67108864) != 0 ? eCOrderDetailState.extraJumpInfoList : null, (r49 & 134217728) != 0 ? eCOrderDetailState.blindBoxWareHouseLink : null, (r49 & 268435456) != 0 ? eCOrderDetailState.deliverMessage : null);
        return b16;
    }
}
