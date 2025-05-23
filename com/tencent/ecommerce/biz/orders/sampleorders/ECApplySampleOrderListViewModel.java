package com.tencent.ecommerce.biz.orders.sampleorders;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import qi0.ECSelectProductAddWindowResponse;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0002 !B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel;", "Landroidx/lifecycle/ViewModel;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "token", "", "P1", "O1", "Q1", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "newAddress", "S1", "spuId", "N1", "Lcom/tencent/ecommerce/repo/sampleorder/d;", "i", "Lcom/tencent/ecommerce/repo/sampleorder/d;", "repo", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_operateEvent", "Lkotlinx/coroutines/flow/SharedFlow;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/SharedFlow;", "R1", "()Lkotlinx/coroutines/flow/SharedFlow;", "operateEvent", "<init>", "()V", "D", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECApplySampleOrderListViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final SharedFlow<b> operateEvent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.ecommerce.repo.sampleorder.d repo = ServiceLocator.f104891i.d();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableSharedFlow<b> _operateEvent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b;", "", "<init>", "()V", "a", "b", "c", "d", "e", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$c;", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$b;", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$d;", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$e;", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$a;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$a;", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b;", "", "a", "Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lqi0/a;", "b", "Lqi0/a;", "()Lqi0/a;", "addProductWindowResponse", "<init>", "(Ljava/lang/String;Lqi0/a;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final String orderId;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private final ECSelectProductAddWindowResponse addProductWindowResponse;

            /* renamed from: a, reason: from getter */
            public final ECSelectProductAddWindowResponse getAddProductWindowResponse() {
                return this.addProductWindowResponse;
            }

            public a(String str, ECSelectProductAddWindowResponse eCSelectProductAddWindowResponse) {
                super(null);
                this.orderId = str;
                this.addProductWindowResponse = eCSelectProductAddWindowResponse;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$b;", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b;", "", "a", "Z", StateEvent.ProcessResult.SUCCEED, "<init>", "(Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListViewModel$b$b, reason: collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class C1079b extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final boolean succeed;

            public C1079b(boolean z16) {
                super(null);
                this.succeed = z16;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$c;", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b;", "", "a", "Z", StateEvent.ProcessResult.SUCCEED, "<init>", "(Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class c extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final boolean succeed;

            public c(boolean z16) {
                super(null);
                this.succeed = z16;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$d;", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b;", "", "a", "Z", StateEvent.ProcessResult.SUCCEED, "<init>", "(Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class d extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final boolean succeed;

            public d(boolean z16) {
                super(null);
                this.succeed = z16;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$e;", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b;", "Lcom/tencent/ecommerce/repo/sampleorder/e;", "a", "Lcom/tencent/ecommerce/repo/sampleorder/e;", "result", "<init>", "(Lcom/tencent/ecommerce/repo/sampleorder/e;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class e extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final com.tencent.ecommerce.repo.sampleorder.e result;

            public e(com.tencent.ecommerce.repo.sampleorder.e eVar) {
                super(null);
                this.result = eVar;
            }
        }

        b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECApplySampleOrderListViewModel() {
        MutableSharedFlow<b> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._operateEvent = MutableSharedFlow$default;
        this.operateEvent = FlowKt.asSharedFlow(MutableSharedFlow$default);
    }

    public final void N1(String orderId, String spuId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECApplySampleOrderListViewModel$addProductWindow$1(this, spuId, orderId, null), 3, null);
    }

    public final void O1(String orderId, String token) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECApplySampleOrderListViewModel$cancelApplyAbortConsign$1(this, orderId, token, null), 3, null);
    }

    public final void P1(String orderId, String token) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECApplySampleOrderListViewModel$cancelApplySample$1(this, orderId, token, null), 3, null);
    }

    public final void Q1(String orderId, String token) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECApplySampleOrderListViewModel$confirmReceiverGoods$1(this, orderId, token, null), 3, null);
    }

    public final SharedFlow<b> R1() {
        return this.operateEvent;
    }

    public final void S1(String orderId, String token, ECAddress newAddress) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECApplySampleOrderListViewModel$updateAddress$1(this, orderId, token, newAddress, null), 3, null);
    }
}
