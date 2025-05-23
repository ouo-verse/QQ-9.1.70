package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 B2\u00020\u0001:\u0001CB\u000f\u0012\u0006\u0010?\u001a\u00020>\u00a2\u0006\u0004\b@\u0010AJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J&\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005J<\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020%0)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020/0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010'R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020/0)8\u0006\u00a2\u0006\f\n\u0004\b2\u0010+\u001a\u0004\b3\u0010-R\u001d\u00108\u001a\b\u0012\u0004\u0012\u0002050)8\u0006\u00a2\u0006\f\n\u0004\b6\u0010+\u001a\u0004\b7\u0010-R\u001b\u0010=\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006D"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListOperateViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "token", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/OrderListScene;", "scene", "", "S1", "T1", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "newAddress", "c2", "payParams", "", "price", "", "spuIds", "", "productType", "payTypeId", "b2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/d;", "i", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/d;", "operateRepository", "Lcom/tencent/ecommerce/repo/buyerorder/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/repo/buyerorder/b;", "orderRepository", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "errorTip", "D", "modifyAddressSucceedTips", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/i;", "E", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_payOrderEvent", "Lkotlinx/coroutines/flow/SharedFlow;", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/flow/SharedFlow;", "X1", "()Lkotlinx/coroutines/flow/SharedFlow;", "payOrderEvent", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/h;", "G", "_toastEvent", "H", "Z1", "toastEvent", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/e;", "I", "W1", "orderListOperateEvent", "J", "Lkotlin/Lazy;", "U1", "()Lcom/tencent/ecommerce/repo/buyerorder/b;", "orderInfoRepo", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "K", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderListOperateViewModel extends AndroidViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final String errorTip;

    /* renamed from: D, reason: from kotlin metadata */
    private final String modifyAddressSucceedTips;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableSharedFlow<PayOrderEventInfo> _payOrderEvent;

    /* renamed from: F, reason: from kotlin metadata */
    private final SharedFlow<PayOrderEventInfo> payOrderEvent;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableSharedFlow<OrderListToastEvent> _toastEvent;

    /* renamed from: H, reason: from kotlin metadata */
    private final SharedFlow<OrderListToastEvent> toastEvent;

    /* renamed from: I, reason: from kotlin metadata */
    private final SharedFlow<com.tencent.ecommerce.repo.buyerorder.orderlist.e> orderListOperateEvent;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy orderInfoRepo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.ecommerce.repo.buyerorder.orderlist.d operateRepository;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.ecommerce.repo.buyerorder.b orderRepository;

    public ECOrderListOperateViewModel(Application application) {
        super(application);
        Lazy lazy;
        ServiceLocator serviceLocator = ServiceLocator.f104891i;
        com.tencent.ecommerce.repo.buyerorder.orderlist.d k3 = serviceLocator.k();
        this.operateRepository = k3;
        this.orderRepository = serviceLocator.i();
        this.errorTip = application.getResources().getString(R.string.wo9);
        this.modifyAddressSucceedTips = application.getResources().getString(R.string.f169620wo4);
        MutableSharedFlow<PayOrderEventInfo> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._payOrderEvent = MutableSharedFlow$default;
        this.payOrderEvent = FlowKt.asSharedFlow(MutableSharedFlow$default);
        MutableSharedFlow<OrderListToastEvent> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._toastEvent = MutableSharedFlow$default2;
        this.toastEvent = FlowKt.asSharedFlow(MutableSharedFlow$default2);
        this.orderListOperateEvent = k3.a();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.ecommerce.repo.buyerorder.b>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListOperateViewModel$orderInfoRepo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.ecommerce.repo.buyerorder.b invoke() {
                return ServiceLocator.f104891i.i();
            }
        });
        this.orderInfoRepo = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.ecommerce.repo.buyerorder.b U1() {
        return (com.tencent.ecommerce.repo.buyerorder.b) this.orderInfoRepo.getValue();
    }

    public final void S1(String orderId, String token, OrderListScene scene) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECOrderListOperateViewModel$cancelOrder$1(this, orderId, token, scene, null), 3, null);
    }

    public final void T1(String orderId, String token, OrderListScene scene) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECOrderListOperateViewModel$confirmReceive$1(this, orderId, token, scene, null), 3, null);
    }

    public final SharedFlow<com.tencent.ecommerce.repo.buyerorder.orderlist.e> W1() {
        return this.orderListOperateEvent;
    }

    public final SharedFlow<PayOrderEventInfo> X1() {
        return this.payOrderEvent;
    }

    public final SharedFlow<OrderListToastEvent> Z1() {
        return this.toastEvent;
    }

    public final void a2(String orderId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECOrderListOperateViewModel$notifyPaySucceed$1(this, orderId, null), 3, null);
    }

    public final void b2(String orderId, String payParams, long price, List<String> spuIds, int productType, int payTypeId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECOrderListOperateViewModel$payOrder$1(this, payParams, orderId, payTypeId, price, spuIds, productType, null), 3, null);
    }

    public final void c2(String orderId, String token, ECAddress newAddress, OrderListScene scene) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECOrderListOperateViewModel$updateAddress$1(this, orderId, token, newAddress, scene, null), 3, null);
    }
}
