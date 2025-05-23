package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt;
import com.tencent.ecommerce.biz.advertise.ECAdAttributionReporter;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.PayOrderEventInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderSpuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.d;
import com.tencent.ecommerce.biz.orders.span.ECOrderOperation;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import mi0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6", f = "ECShopOrderDetailFragment.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ Fragment $this_launchAndRepeatWithViewLifecycle;
    int label;
    final /* synthetic */ ECShopOrderDetailFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6$1", f = "ECShopOrderDetailFragment.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "com/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/qshop/ECShopOrderDetailFragment$$special$$inlined$collect$3"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6$1$a */
        /* loaded from: classes31.dex */
        public static final class a implements FlowCollector<PayOrderEventInfo> {

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007\u00b8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/qshop/ECShopOrderDetailFragment$initObservers$6$1$1", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$ECPayCallback;", "", "onPayNeedLogin", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;", "payResult", "onPayResult", "ecommerce_sdk_debug", "com/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/qshop/ECShopOrderDetailFragment$$special$$inlined$collect$3$lambda$1"}, k = 1, mv = {1, 4, 1})
            /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6$1$a$a, reason: collision with other inner class name */
            /* loaded from: classes31.dex */
            public static final class C1068a implements IECPayApi.ECPayCallback {
                C1068a() {
                }

                @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi.ECPayCallback
                public void onPayNeedLogin() {
                    cg0.a.b("ECShopOrderDetailFragment", "onPayNeedLogin");
                    ECOrderSpan.f103884c.b(ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6.this.this$0.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID java.lang.String, ECOrderSpanScene.OrderSubmit, ECOrderOperation.PayOrder, new ECOrderSpan.OrderRequestInfo(-1, null, 2, null), b.c());
                }

                @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi.ECPayCallback
                public void onPayResult(IECPayApi.PayResult payResult) {
                    Object first;
                    Object first2;
                    List listOf;
                    Object first3;
                    ECOrderDetailState value = ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6.this.this$0.li().t2().getValue();
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) value.orderSkuInfo);
                    if (d.b(((OrderSkuDetail) first).productType)) {
                        ECShopOrderDetailFragment eCShopOrderDetailFragment = ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6.this.this$0;
                        String str = value.orderId;
                        first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) value.orderSkuInfo);
                        eCShopOrderDetailFragment.di(payResult, str, ((OrderSkuDetail) first3).spuId);
                        return;
                    }
                    if (payResult.getCode() == 0) {
                        ECShopOrderDetailFragment eCShopOrderDetailFragment2 = ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6.this.this$0;
                        String str2 = value.orderId;
                        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) value.orderSpuInfo);
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(((OrderSpuDetail) first2).id);
                        eCShopOrderDetailFragment2.qi(payResult, str2, listOf, value.payInfo.orderPrice);
                        com.tencent.ecommerce.biz.advertise.b bVar = com.tencent.ecommerce.biz.advertise.b.f101293a;
                        ECAdAttributionReporter.f101288c.h(bVar.a(value.orderId));
                        bVar.b(value.orderId);
                    }
                    ECOrderSpan.f103884c.b(ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6.this.this$0.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID java.lang.String, ECOrderSpanScene.OrderDetail, ECOrderOperation.PayOrder, new ECOrderSpan.OrderRequestInfo(payResult.getCode(), null, 2, null), b.d(payResult));
                }
            }

            public a() {
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(PayOrderEventInfo payOrderEventInfo, Continuation continuation) {
                PayOrderEventInfo payOrderEventInfo2 = payOrderEventInfo;
                IECPayApi.a.a(mi0.a.f416850b, ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6.this.this$0.requireActivity(), payOrderEventInfo2.payParams, 0, payOrderEventInfo2.payTypeId, new C1068a(), 4, null);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
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
                SharedFlow<PayOrderEventInfo> x26 = ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6.this.this$0.li().x2();
                a aVar = new a();
                this.label = 1;
                if (x26.collect(aVar, this) == coroutine_suspended) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6(Fragment fragment, Lifecycle.State state, Continuation continuation, ECShopOrderDetailFragment eCShopOrderDetailFragment) {
        super(2, continuation);
        this.$this_launchAndRepeatWithViewLifecycle = fragment;
        this.$minActiveState = state;
        this.this$0 = eCShopOrderDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6(this.$this_launchAndRepeatWithViewLifecycle, this.$minActiveState, continuation, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Lifecycle lifecycle = this.$this_launchAndRepeatWithViewLifecycle.getViewLifecycleOwner().getLifecycle();
            Lifecycle.State state = this.$minActiveState;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            if (RepeatOnLifecycleKt.a(lifecycle, state, anonymousClass1, this) == coroutine_suspended) {
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
