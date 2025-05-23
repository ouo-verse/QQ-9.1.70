package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.sample;

import android.app.Application;
import android.os.CountDownTimer;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.OrderStateUpdateType;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailHeaderState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.OrderDetailCheckValidData;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.h;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderSpuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.common.SampleOrderState;
import com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderTimerView;
import com.tencent.ecommerce.biz.recommend.models.ECProductRecommendItemData;
import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.buyerorder.sample.ECSampleOrderInfoRepository;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$OrderDetail;
import com.tencent.ecommerce.repo.sampleorder.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
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
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 s2\u00020\u00012\u00020\u0002:\u0002\u008a\u0001B\u0013\u0012\b\u0010\u0084\u0001\u001a\u00030\u0081\u0001\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J4\u0010\u0015\u001a\u00020\u0005*\u00020\u00102\u001c\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\f\u0010\u001a\u001a\u00020\u0007*\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u001bH\u0002J\"\u0010 \u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u0005H\u0014J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\tJ\u0016\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u00030)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010+R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u00030-8\u0006\u00a2\u0006\f\n\u0004\b5\u0010/\u001a\u0004\b6\u00101R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\t088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020\t0<8\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020B088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010:R\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020B0<8\u0006\u00a2\u0006\f\n\u0004\bE\u0010>\u001a\u0004\bF\u0010@R\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR$\u0010U\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020\u001b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR(\u0010[\u001a\u0004\u0018\u00010V2\b\u0010P\u001a\u0004\u0018\u00010V8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR$\u0010`\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R$\u0010c\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\ba\u0010]\u001a\u0004\bb\u0010_R(\u0010i\u001a\u0004\u0018\u00010d2\b\u0010P\u001a\u0004\u0018\u00010d8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010]R\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020m0l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010v\u001a\u00020q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010sR\u0016\u0010x\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010]R\u0018\u0010|\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0014\u0010~\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b}\u0010]R\u0015\u0010\u0080\u0001\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u007f\u0010]R\u0018\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0014\u0010\u0087\u0001\u001a\u00020q8F\u00a2\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u008b\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/sample/ECSampleOrderDetailViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", "state", "", "x2", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "v2", "", "desc", "w2", "u2", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$OrderDetail;", "orderInfo", "y2", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "action", "p2", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, SemanticAttributes.DbSystemValues.H2, "r2", "q2", "Lcom/tencent/ecommerce/biz/orders/common/SampleOrderState;", "k2", "preferStr", "", "deadlineMs", "j2", "onCleared", "f2", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "newAddress", "t2", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/sample/RecommendFetchType;", "fetchType", ICustomDataEditor.STRING_PARAM_2, "Lkotlinx/coroutines/flow/MutableStateFlow;", "i", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_orderDetailState", "Lkotlinx/coroutines/flow/StateFlow;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/StateFlow;", "m2", "()Lkotlinx/coroutines/flow/StateFlow;", "orderDetailState", BdhLogUtil.LogTag.Tag_Conn, "_pageState", "D", ICustomDataEditor.NUMBER_PARAM_2, "pageState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "E", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_alertDialogEvent", "Lkotlinx/coroutines/flow/SharedFlow;", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/flow/SharedFlow;", "g2", "()Lkotlinx/coroutines/flow/SharedFlow;", "alertDialogEvent", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/sample/b;", "G", "_toastEvent", "H", "o2", "toastEvent", "Lcom/tencent/ecommerce/repo/sampleorder/d;", "I", "Lcom/tencent/ecommerce/repo/sampleorder/d;", "operateRepository", "Lcom/tencent/ecommerce/repo/buyerorder/sample/a;", "J", "Lcom/tencent/ecommerce/repo/buyerorder/sample/a;", "orderRepository", "<set-?>", "K", "Lcom/tencent/ecommerce/biz/orders/common/SampleOrderState;", "getOrderState", "()Lcom/tencent/ecommerce/biz/orders/common/SampleOrderState;", "orderState", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "L", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "getOrderSkuDetail", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "orderSkuDetail", "M", "Ljava/lang/String;", "getShopId", "()Ljava/lang/String;", "shopId", "N", "getSpuId", "spuId", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/k;", "P", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/k;", "l2", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/k;", "modifyAddressValidData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "token", "", "Lcom/tencent/ecommerce/biz/recommend/models/a;", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/List;", "recommendDatas", "", ExifInterface.LATITUDE_SOUTH, "Z", "_hasMoreRecommendData", "T", "isLoadingRecommendData", "U", "recommendCookie", "Landroid/os/CountDownTimer;", "V", "Landroid/os/CountDownTimer;", "countDownTimer", "W", "paramsErrorMsg", "X", "modifyAddressSucceedTips", "Landroid/app/Application;", "Y", "Landroid/app/Application;", "app", "i2", "()Z", "hasMoreRecommendData", "<init>", "(Landroid/app/Application;)V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSampleOrderDetailViewModel extends AndroidViewModel implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableStateFlow<ECOrderSubmitViewModel.g> _pageState;

    /* renamed from: D, reason: from kotlin metadata */
    private final StateFlow<ECOrderSubmitViewModel.g> pageState;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableSharedFlow<String> _alertDialogEvent;

    /* renamed from: F, reason: from kotlin metadata */
    private final SharedFlow<String> alertDialogEvent;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableSharedFlow<OrderDetailToastEvent> _toastEvent;

    /* renamed from: H, reason: from kotlin metadata */
    private final SharedFlow<OrderDetailToastEvent> toastEvent;

    /* renamed from: I, reason: from kotlin metadata */
    private final d operateRepository;

    /* renamed from: J, reason: from kotlin metadata */
    private final com.tencent.ecommerce.repo.buyerorder.sample.a orderRepository;

    /* renamed from: K, reason: from kotlin metadata */
    private SampleOrderState orderState;

    /* renamed from: L, reason: from kotlin metadata */
    private OrderSkuDetail orderSkuDetail;

    /* renamed from: M, reason: from kotlin metadata */
    private String shopId;

    /* renamed from: N, reason: from kotlin metadata */
    private String spuId;

    /* renamed from: P, reason: from kotlin metadata */
    private OrderDetailCheckValidData modifyAddressValidData;

    /* renamed from: Q, reason: from kotlin metadata */
    private String token;

    /* renamed from: R, reason: from kotlin metadata */
    private final List<ECProductRecommendItemData> recommendDatas;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean _hasMoreRecommendData;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isLoadingRecommendData;

    /* renamed from: U, reason: from kotlin metadata */
    private String recommendCookie;

    /* renamed from: V, reason: from kotlin metadata */
    private CountDownTimer countDownTimer;

    /* renamed from: W, reason: from kotlin metadata */
    private final String paramsErrorMsg;

    /* renamed from: X, reason: from kotlin metadata */
    private final String modifyAddressSucceedTips;

    /* renamed from: Y, reason: from kotlin metadata */
    public final Application app;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableStateFlow<ECOrderDetailState> _orderDetailState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final StateFlow<ECOrderDetailState> orderDetailState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/detail/domain/sample/ECSampleOrderDetailViewModel$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Application f103203b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ECOrderDetailState f103204c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f103205d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Application application, ECOrderDetailState eCOrderDetailState, long j3, long j16, long j17) {
            super(j16, j17);
            this.f103203b = application;
            this.f103204c = eCOrderDetailState;
            this.f103205d = j3;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ECSampleOrderDetailViewModel.this.f2(this.f103204c.orderId);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            ECSampleOrderDetailViewModel.this.w2(ECApplySampleOrderTimerView.INSTANCE.a(this.f103203b, millisUntilFinished));
        }
    }

    public ECSampleOrderDetailViewModel(Application application) {
        super(application);
        this.app = application;
        MutableStateFlow<ECOrderDetailState> MutableStateFlow = StateFlowKt.MutableStateFlow(h.a());
        this._orderDetailState = MutableStateFlow;
        this.orderDetailState = MutableStateFlow;
        MutableStateFlow<ECOrderSubmitViewModel.g> MutableStateFlow2 = StateFlowKt.MutableStateFlow(ECOrderSubmitViewModel.g.c.f103527a);
        this._pageState = MutableStateFlow2;
        this.pageState = MutableStateFlow2;
        MutableSharedFlow<String> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._alertDialogEvent = MutableSharedFlow$default;
        this.alertDialogEvent = FlowKt.asSharedFlow(MutableSharedFlow$default);
        MutableSharedFlow<OrderDetailToastEvent> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._toastEvent = MutableSharedFlow$default2;
        this.toastEvent = FlowKt.asSharedFlow(MutableSharedFlow$default2);
        ServiceLocator serviceLocator = ServiceLocator.f104891i;
        this.operateRepository = serviceLocator.d();
        this.orderRepository = serviceLocator.q();
        this.orderState = SampleOrderState.RESERVE;
        this.shopId = "";
        this.spuId = "";
        this.token = "";
        this.recommendDatas = new ArrayList();
        this._hasMoreRecommendData = true;
        this.recommendCookie = "";
        this.paramsErrorMsg = application.getString(R.string.wo9);
        this.modifyAddressSucceedTips = application.getString(R.string.f169620wo4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h2(String orderId) {
        return "params is empty. orderId: " + orderId + ", token: " + this.token;
    }

    private final String j2(SampleOrderState state, String preferStr, long deadlineMs) {
        if (preferStr.length() > 0) {
            return preferStr;
        }
        Application a16 = wg0.a.a();
        if (a.f103207b[state.ordinal()] != 1) {
            return "";
        }
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        cg0.a.b("ECSampleOrderDetailViewModel", "deadlineMs: " + deadlineMs + ", currentTimeMs: " + timeInMillis);
        if (deadlineMs > timeInMillis) {
            return ECApplySampleOrderTimerView.INSTANCE.a(a16, deadlineMs - timeInMillis);
        }
        cg0.a.a("ECSampleOrderDetailViewModel", "getHeaderDescStr", "deadlineMs: " + deadlineMs + ", currentTimeMs: " + timeInMillis);
        return "";
    }

    private final String k2(SampleOrderState state) {
        int i3 = a.f103206a[state.ordinal()];
        int i16 = R.string.wrv;
        switch (i3) {
            case 1:
                i16 = R.string.f169636ws0;
                break;
            case 2:
            case 7:
                break;
            case 3:
                i16 = R.string.wrw;
                break;
            case 4:
                i16 = R.string.wrz;
                break;
            case 5:
                i16 = R.string.f169637ws1;
                break;
            case 6:
                i16 = R.string.wry;
                break;
            case 8:
                i16 = R.string.f169638ws2;
                break;
            case 9:
                i16 = R.string.wrx;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return this.app.getString(i16);
    }

    private final void r2() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        ECOrderDetailState value = this.orderDetailState.getValue();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        boolean z16 = false;
        if (value.orderStateVal == SampleOrderState.FULFILLING.value) {
            if (value.preferOrderStateDesc.length() == 0) {
                long j3 = value.deadlineMs - timeInMillis;
                if (0 <= j3 && 86400000 >= j3) {
                    z16 = true;
                }
            }
        }
        if (z16) {
            this.countDownTimer = new b(wg0.a.a(), value, timeInMillis, value.deadlineMs - timeInMillis, 1000L).start();
            cg0.a.b("ECSampleOrderDetailViewModel", "start timer: startTime: " + timeInMillis + ", deadline: " + value.deadlineMs);
        }
    }

    private final void u2(ECOrderDetailState state) {
        Object first;
        Object first2;
        Object first3;
        this.orderState = SampleOrderState.INSTANCE.a(state.orderStateVal);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) state.orderSkuInfo);
        this.orderSkuDetail = (OrderSkuDetail) first;
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) state.orderSpuInfo);
        this.spuId = ((OrderSpuDetail) first2).id;
        first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) state.orderSkuInfo);
        this.shopId = ((OrderSkuDetail) first3).shop.id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v2(ECOrderDetailState state) {
        this._orderDetailState.setValue(state);
        r2();
        u2(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x2(ECOrderSubmitViewModel.g state) {
        this._pageState.setValue(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y2(ECQshopSampleSvr$OrderDetail orderInfo) {
        v2(q2(ECSampleOrderInfoRepository.INSTANCE.a(orderInfo)));
    }

    public final void f2(String orderId) {
        cg0.a.b("ECSampleOrderDetailViewModel", "fetchOrderDetailData orderId: " + orderId);
        if (!(orderId.length() == 0)) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECSampleOrderDetailViewModel$fetchOrderDetailData$1(this, orderId, null), 3, null);
        } else {
            cg0.a.a("ECSampleOrderDetailViewModel", "fetchOrderDetailData", "invalid param: orderId is Empty");
            x2(new ECOrderSubmitViewModel.g.Error(-1, ""));
        }
    }

    public final SharedFlow<String> g2() {
        return this.alertDialogEvent;
    }

    /* renamed from: i2, reason: from getter */
    public final boolean get_hasMoreRecommendData() {
        return this._hasMoreRecommendData;
    }

    /* renamed from: l2, reason: from getter */
    public final OrderDetailCheckValidData getModifyAddressValidData() {
        return this.modifyAddressValidData;
    }

    public final StateFlow<ECOrderDetailState> m2() {
        return this.orderDetailState;
    }

    public final StateFlow<ECOrderSubmitViewModel.g> n2() {
        return this.pageState;
    }

    public final SharedFlow<OrderDetailToastEvent> o2() {
        return this.toastEvent;
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

    public final void s2(RecommendFetchType fetchType) {
        List listOf;
        JSONObject b16;
        boolean z16 = (this.recommendDatas.isEmpty() ^ true) && !get_hasMoreRecommendData();
        cg0.a.b("ECSampleOrderDetailViewModel", "tryFetchRecommendGoodsInfo. hasFetchedData: " + z16 + ", fetchType: " + fetchType.name());
        if (z16 && fetchType == RecommendFetchType.FIRST_FETCH) {
            cg0.a.b("ECSampleOrderDetailViewModel", "recommend data has fetched. Duplicated first fetch skipped.");
            return;
        }
        if (this.isLoadingRecommendData) {
            cg0.a.b("ECSampleOrderDetailViewModel", "isLoadingRecommendData: " + this.isLoadingRecommendData + ", fetch skipped.");
            return;
        }
        if (this.spuId.length() == 0) {
            cg0.a.b("ECSampleOrderDetailViewModel", "spuId is empty. fetch skipped.");
            return;
        }
        ECShopRecommendScene eCShopRecommendScene = ECShopRecommendScene.QQ_SHOP_APPLY_SAMPLE_ORDER_DETAIL;
        this.isLoadingRecommendData = true;
        ti0.a aVar = ti0.a.f436377a;
        String str = this.shopId;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(this.spuId);
        b16 = aVar.b((r13 & 1) != 0 ? "" : str, listOf, eCShopRecommendScene, (r13 & 8) != 0 ? "" : null, this.recommendCookie);
        cg0.a.b("ECSampleOrderDetailViewModel", "start fetch recommend info. spuId: " + this.spuId + "\uff0ccookie: " + this.recommendCookie);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECSampleOrderDetailViewModel$tryFetchRecommendGoodsInfo$1(this, b16, null), 3, null);
    }

    public final void t2(ECAddress newAddress, String orderId) {
        p2(ViewModelKt.getViewModelScope(this), new ECSampleOrderDetailViewModel$updateAddressInfo$1(this, orderId, newAddress, null));
    }

    private final void p2(CoroutineScope coroutineScope, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ECSampleOrderDetailViewModel$launchMutexOperation$1(this, function1, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w2(String desc) {
        ECOrderDetailState b16;
        MutableStateFlow<ECOrderDetailState> mutableStateFlow = this._orderDetailState;
        b16 = r3.b((r49 & 1) != 0 ? r3.orderId : null, (r49 & 2) != 0 ? r3.orderStateVal : 0, (r49 & 4) != 0 ? r3.headerState : ECOrderDetailHeaderState.b(this._orderDetailState.getValue().getHeaderState(), null, desc, 1, null), (r49 & 8) != 0 ? r3.preferOrderStateTitle : null, (r49 & 16) != 0 ? r3.preferOrderStateDesc : null, (r49 & 32) != 0 ? r3.createTimestampMs : 0L, (r49 & 64) != 0 ? r3.deadlineMs : 0L, (r49 & 128) != 0 ? r3.hasComment : false, (r49 & 256) != 0 ? r3.orderNote : null, (r49 & 512) != 0 ? r3.orderNoteFromSeller : null, (r49 & 1024) != 0 ? r3.buyerMobile : null, (r49 & 2048) != 0 ? r3.accountInfo : null, (r49 & 4096) != 0 ? r3.logisticsInfo : null, (r49 & 8192) != 0 ? r3.addressInfo : null, (r49 & 16384) != 0 ? r3.modifyAddressValidInfo : null, (r49 & 32768) != 0 ? r3.orderSkuInfo : null, (r49 & 65536) != 0 ? r3.orderSpuInfo : null, (r49 & 131072) != 0 ? r3.payInfo : null, (r49 & 262144) != 0 ? r3.ticketInfo : null, (r49 & 524288) != 0 ? r3.promoInfos : null, (r49 & 1048576) != 0 ? r3.usedCouponInfo : null, (r49 & 2097152) != 0 ? r3.goodsOperateState : null, (r49 & 4194304) != 0 ? r3.recommendList : null, (r49 & 8388608) != 0 ? r3.widgetsVisibility : null, (r49 & 16777216) != 0 ? r3.updateType : OrderStateUpdateType.ONLY_HEADER, (r49 & 33554432) != 0 ? r3.bulletinInfo : null, (r49 & 67108864) != 0 ? r3.extraJumpInfoList : null, (r49 & 134217728) != 0 ? r3.blindBoxWareHouseLink : null, (r49 & 268435456) != 0 ? mutableStateFlow.getValue().deliverMessage : null);
        mutableStateFlow.setValue(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECOrderDetailState q2(ECOrderDetailState eCOrderDetailState) {
        List list;
        ECOrderDetailState b16;
        SampleOrderState a16 = SampleOrderState.INSTANCE.a(eCOrderDetailState.orderStateVal);
        ECOrderDetailHeaderState eCOrderDetailHeaderState = new ECOrderDetailHeaderState(k2(a16), j2(a16, eCOrderDetailState.preferOrderStateDesc, eCOrderDetailState.deadlineMs));
        list = CollectionsKt___CollectionsKt.toList(this.recommendDatas);
        b16 = eCOrderDetailState.b((r49 & 1) != 0 ? eCOrderDetailState.orderId : null, (r49 & 2) != 0 ? eCOrderDetailState.orderStateVal : 0, (r49 & 4) != 0 ? eCOrderDetailState.headerState : eCOrderDetailHeaderState, (r49 & 8) != 0 ? eCOrderDetailState.preferOrderStateTitle : null, (r49 & 16) != 0 ? eCOrderDetailState.preferOrderStateDesc : null, (r49 & 32) != 0 ? eCOrderDetailState.createTimestampMs : 0L, (r49 & 64) != 0 ? eCOrderDetailState.deadlineMs : 0L, (r49 & 128) != 0 ? eCOrderDetailState.hasComment : false, (r49 & 256) != 0 ? eCOrderDetailState.orderNote : null, (r49 & 512) != 0 ? eCOrderDetailState.orderNoteFromSeller : null, (r49 & 1024) != 0 ? eCOrderDetailState.buyerMobile : null, (r49 & 2048) != 0 ? eCOrderDetailState.accountInfo : null, (r49 & 4096) != 0 ? eCOrderDetailState.logisticsInfo : null, (r49 & 8192) != 0 ? eCOrderDetailState.addressInfo : null, (r49 & 16384) != 0 ? eCOrderDetailState.modifyAddressValidInfo : null, (r49 & 32768) != 0 ? eCOrderDetailState.orderSkuInfo : null, (r49 & 65536) != 0 ? eCOrderDetailState.orderSpuInfo : null, (r49 & 131072) != 0 ? eCOrderDetailState.payInfo : null, (r49 & 262144) != 0 ? eCOrderDetailState.ticketInfo : null, (r49 & 524288) != 0 ? eCOrderDetailState.promoInfos : null, (r49 & 1048576) != 0 ? eCOrderDetailState.usedCouponInfo : null, (r49 & 2097152) != 0 ? eCOrderDetailState.goodsOperateState : null, (r49 & 4194304) != 0 ? eCOrderDetailState.recommendList : list, (r49 & 8388608) != 0 ? eCOrderDetailState.widgetsVisibility : null, (r49 & 16777216) != 0 ? eCOrderDetailState.updateType : OrderStateUpdateType.ALL, (r49 & 33554432) != 0 ? eCOrderDetailState.bulletinInfo : null, (r49 & 67108864) != 0 ? eCOrderDetailState.extraJumpInfoList : null, (r49 & 134217728) != 0 ? eCOrderDetailState.blindBoxWareHouseLink : null, (r49 & 268435456) != 0 ? eCOrderDetailState.deliverMessage : null);
        return b16;
    }
}
