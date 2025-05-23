package com.tencent.ecommerce.repo.buyerorder.orderlist;

import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u0014B\u0011\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001d\u00a2\u0006\u0004\b \u0010!J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ+\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\tJ3\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00178\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/orderlist/ECOrderOperateRepository;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/d;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "token", "", "needLatestOrder", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/f;", "c", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "newAddress", "e", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/address/ECAddress;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/e;", "a", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_orderListOperateEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/SharedFlow;", "()Lkotlinx/coroutines/flow/SharedFlow;", "orderListOperateEvent", "Ljava/lang/String;", "defaultErrTips", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderOperateRepository implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private MutableSharedFlow<e> _orderListOperateEvent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final SharedFlow<e> orderListOperateEvent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String defaultErrTips;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher coroutineDispatcher;

    public ECOrderOperateRepository(CoroutineDispatcher coroutineDispatcher) {
        this.coroutineDispatcher = coroutineDispatcher;
        MutableSharedFlow<e> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._orderListOperateEvent = MutableSharedFlow$default;
        this.orderListOperateEvent = FlowKt.asSharedFlow(MutableSharedFlow$default);
        this.defaultErrTips = wg0.a.a().getString(R.string.wo9);
    }

    @Override // com.tencent.ecommerce.repo.buyerorder.orderlist.d
    public SharedFlow<e> a() {
        return this.orderListOperateEvent;
    }

    @Override // com.tencent.ecommerce.repo.buyerorder.orderlist.d
    public Object b(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(this.coroutineDispatcher, new ECOrderOperateRepository$sendPaySucceedEvent$2(this, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
    }

    @Override // com.tencent.ecommerce.repo.buyerorder.orderlist.d
    public Object c(String str, String str2, boolean z16, Continuation<? super f> continuation) {
        return BuildersKt.withContext(this.coroutineDispatcher, new ECOrderOperateRepository$cancelOrder$2(this, str, str2, z16, null), continuation);
    }

    @Override // com.tencent.ecommerce.repo.buyerorder.orderlist.d
    public Object d(String str, String str2, boolean z16, Continuation<? super f> continuation) {
        return BuildersKt.withContext(this.coroutineDispatcher, new ECOrderOperateRepository$confirmReceive$2(this, str, str2, z16, null), continuation);
    }

    @Override // com.tencent.ecommerce.repo.buyerorder.orderlist.d
    public Object e(String str, String str2, ECAddress eCAddress, boolean z16, Continuation<? super f> continuation) {
        return BuildersKt.withContext(this.coroutineDispatcher, new ECOrderOperateRepository$updateAddress$2(this, str, str2, eCAddress, z16, null), continuation);
    }

    public /* synthetic */ ECOrderOperateRepository(CoroutineDispatcher coroutineDispatcher, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
