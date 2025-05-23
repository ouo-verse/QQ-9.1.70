package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt;
import com.tencent.ecommerce.biz.advertise.ECAdAttributionReporter;
import com.tencent.ecommerce.biz.orders.span.ECOrderOperation;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4", f = "ECOrderListFragment.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ Fragment $this_launchAndRepeatWithViewLifecycle;
    int label;
    final /* synthetic */ ECOrderListFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4$1", f = "ECOrderListFragment.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "com/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListFragment$$special$$inlined$collect$4"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4$1$a */
        /* loaded from: classes31.dex */
        public static final class a implements FlowCollector<PayOrderEventInfo> {

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007\u00b8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListFragment$onViewCreated$4$1$1", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$ECPayCallback;", "", "onPayNeedLogin", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;", "payResult", "onPayResult", "ecommerce_sdk_debug", "com/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListFragment$$special$$inlined$collect$4$lambda$1"}, k = 1, mv = {1, 4, 1})
            /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4$1$a$a, reason: collision with other inner class name */
            /* loaded from: classes31.dex */
            public static final class C1072a implements IECPayApi.ECPayCallback {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ PayOrderEventInfo f103386a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ a f103387b;

                C1072a(PayOrderEventInfo payOrderEventInfo, a aVar) {
                    this.f103386a = payOrderEventInfo;
                    this.f103387b = aVar;
                }

                @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi.ECPayCallback
                public void onPayNeedLogin() {
                    OrderListScene orderListScene;
                    cg0.a.b("OrderListFragment", "onPayNeedLogin");
                    ECOrderSpan eCOrderSpan = ECOrderSpan.f103884c;
                    String str = this.f103386a.orderId;
                    orderListScene = ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4.this.this$0.scene;
                    eCOrderSpan.b(str, g.a(orderListScene), ECOrderOperation.PayOrder, new ECOrderSpan.OrderRequestInfo(-1, null, 2, null), mi0.b.c());
                }

                @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi.ECPayCallback
                public void onPayResult(IECPayApi.PayResult payResult) {
                    OrderListScene orderListScene;
                    Object first;
                    PayOrderEventInfo payOrderEventInfo = this.f103386a;
                    if (payOrderEventInfo.productType == 4) {
                        ECOrderListFragment eCOrderListFragment = ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4.this.this$0;
                        String str = payOrderEventInfo.orderId;
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) payOrderEventInfo.a());
                        eCOrderListFragment.Yh(payResult, str, (String) first);
                        return;
                    }
                    if (payResult.getCode() == 0) {
                        ECOrderListFragment eCOrderListFragment2 = ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4.this.this$0;
                        PayOrderEventInfo payOrderEventInfo2 = this.f103386a;
                        eCOrderListFragment2.pi(payResult, payOrderEventInfo2.orderId, payOrderEventInfo2.a(), this.f103386a.priceInFen);
                        com.tencent.ecommerce.biz.advertise.b bVar = com.tencent.ecommerce.biz.advertise.b.f101293a;
                        ECAdAttributionReporter.f101288c.h(bVar.a(this.f103386a.orderId));
                        bVar.b(this.f103386a.orderId);
                    }
                    ECOrderSpan eCOrderSpan = ECOrderSpan.f103884c;
                    String str2 = this.f103386a.orderId;
                    orderListScene = ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4.this.this$0.scene;
                    eCOrderSpan.b(str2, g.a(orderListScene), ECOrderOperation.PayOrder, new ECOrderSpan.OrderRequestInfo(payResult.getCode(), this.f103386a.payParams), mi0.b.d(payResult));
                }
            }

            public a() {
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(PayOrderEventInfo payOrderEventInfo, Continuation continuation) {
                PayOrderEventInfo payOrderEventInfo2 = payOrderEventInfo;
                IECPayApi.a.a(mi0.a.f416850b, ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4.this.this$0.requireActivity(), payOrderEventInfo2.payParams, 0, payOrderEventInfo2.payTypeId, new C1072a(payOrderEventInfo2, this), 4, null);
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
            ECOrderListOperateViewModel fi5;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                fi5 = ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4.this.this$0.fi();
                SharedFlow<PayOrderEventInfo> X1 = fi5.X1();
                a aVar = new a();
                this.label = 1;
                if (X1.collect(aVar, this) == coroutine_suspended) {
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
    public ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4(Fragment fragment, Lifecycle.State state, Continuation continuation, ECOrderListFragment eCOrderListFragment) {
        super(2, continuation);
        this.$this_launchAndRepeatWithViewLifecycle = fragment;
        this.$minActiveState = state;
        this.this$0 = eCOrderListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4(this.$this_launchAndRepeatWithViewLifecycle, this.$minActiveState, continuation, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
