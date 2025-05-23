package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ecommerce.base.ktx.TextViewKt;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.biz.advertise.ECAdAttributionReporter;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderDetailEntrance;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.biz.orders.span.ECOrderOperation;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import com.tencent.ecommerce.biz.retain.repo.ECRetainRepository;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment;
import com.tencent.ecommerce.biz.submitsucceed.SubmitSucceedFrom;
import com.tencent.ecommerce.biz.submitsucceed.SubmitSucceedUIState;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$OrderPageDetailRsp;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001b\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitFragment$dealWithSubmitSucceedResult$1", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$ECPayCallback;", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;", "payResult", "", "a", "d", "c", "onPayNeedLogin", "onPayResult", "b", "(Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderSubmitFragment$dealWithSubmitSucceedResult$1 implements IECPayApi.ECPayCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ECOrderSubmitFragment f103472a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ECOrderSubmitViewModel.h.SubmitSucceedResult f103473b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel", "com/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$loadingDialog$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            ECOrderSubmitFragment$dealWithSubmitSucceedResult$1.this.f103472a.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECOrderSubmitFragment$dealWithSubmitSucceedResult$1(ECOrderSubmitFragment eCOrderSubmitFragment, ECOrderSubmitViewModel.h.SubmitSucceedResult submitSucceedResult) {
        this.f103472a = eCOrderSubmitFragment;
        this.f103473b = submitSucceedResult;
    }

    private final void a(IECPayApi.PayResult payResult) {
        Object first;
        Object first2;
        JSONObject zi5;
        String str;
        Object first3;
        if (payResult.getCode() == 0) {
            com.tencent.ecommerce.base.ui.i.f101155b.c(R.string.f169621wp0, ECToastIcon.ICON_SUCCESS, 0);
            ECOrderSubmitViewModel Li = this.f103472a.Li();
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.f103473b.b());
            Li.Q2((String) first2);
            SubmitSucceedUIState submitSucceedUIState = new SubmitSucceedUIState(this.f103472a.getString(R.string.f169621wp0), this.f103472a.getString(R.string.f169622wp1, com.tencent.ecommerce.biz.orders.buyerorders.submit.model.i.a(payResult).name(this.f103472a.requireContext()), TextViewKt.e(this.f103473b.orderPrice)), this.f103472a.getString(R.string.wrr));
            ECSubmitSucceedFragment.Companion companion = ECSubmitSucceedFragment.INSTANCE;
            Context requireContext = this.f103472a.requireContext();
            SubmitSucceedFrom submitSucceedFrom = SubmitSucceedFrom.PAY_IN_SUBMIT_ORDER;
            List<String> d16 = this.f103473b.d();
            zi5 = this.f103472a.zi(this.f103473b.b(), com.tencent.ecommerce.biz.orders.buyerorders.submit.model.i.a(payResult), this.f103473b.getOrderDetailRsp());
            companion.a(requireContext, submitSucceedUIState, submitSucceedFrom, d16, zi5);
            ECAdAttributionReporter eCAdAttributionReporter = ECAdAttributionReporter.f101288c;
            str = this.f103472a.adClickId;
            eCAdAttributionReporter.h(str);
            com.tencent.ecommerce.biz.advertise.b bVar = com.tencent.ecommerce.biz.advertise.b.f101293a;
            first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.f103473b.b());
            bVar.b((String) first3);
            ECRetainRepository.f104121b.markPaySuccess();
        } else {
            ECShopOrderDetailFragment.Companion companion2 = ECShopOrderDetailFragment.INSTANCE;
            Context requireContext2 = this.f103472a.requireContext();
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.f103473b.b());
            companion2.a(requireContext2, (String) first, OrderDetailEntrance.FROM_PAY_PAGE);
        }
        this.f103472a.finish();
    }

    private final void c() {
        com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(this.f103472a.requireContext());
        gVar.Y(this.f103472a.getString(R.string.wef));
        gVar.b0(this.f103472a.getString(R.string.whs));
        gVar.f0(this.f103472a.getString(R.string.f169593wh3));
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$showReFundDialog$$inlined$apply$lambda$1
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
                ECOrderSubmitFragment$dealWithSubmitSucceedResult$1.this.f103472a.finish();
            }
        });
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$showReFundDialog$$inlined$apply$lambda$2
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
                ECScheme.g("mqqapi://ecommerce/open?target=2", null, 2, null);
                ECOrderSubmitFragment$dealWithSubmitSucceedResult$1.this.f103472a.finish();
            }
        });
        gVar.setCancelable(false);
        gVar.show();
    }

    private final void d(final IECPayApi.PayResult payResult) {
        boolean z16;
        z16 = this.f103472a.hadShowRecheckLotteryDialog;
        if (z16) {
            com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(this.f103472a.requireContext());
            gVar.Y(this.f103472a.getString(R.string.wuz));
            gVar.b0("");
            gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$tryShowRecheckLotteryResultDialog$$inlined$apply$lambda$1
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
                    ECOrderSubmitFragment$dealWithSubmitSucceedResult$1.this.f103472a.finish();
                }
            });
            gVar.setCancelable(false);
            gVar.show();
            return;
        }
        com.tencent.ecommerce.base.ui.g gVar2 = new com.tencent.ecommerce.base.ui.g(this.f103472a.requireContext());
        gVar2.Y(this.f103472a.getString(R.string.wee));
        gVar2.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$tryShowRecheckLotteryResultDialog$$inlined$apply$lambda$2
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
                ECOrderSubmitFragment$dealWithSubmitSucceedResult$1.this.f103472a.finish();
            }
        });
        gVar2.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$tryShowRecheckLotteryResultDialog$$inlined$apply$lambda$3

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$tryShowRecheckLotteryResultDialog$2$2$1"}, k = 3, mv = {1, 4, 1})
            @DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$tryShowRecheckLotteryResultDialog$2$2$1", f = "ECOrderSubmitFragment.kt", i = {}, l = {1057}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$tryShowRecheckLotteryResultDialog$$inlined$apply$lambda$3$1, reason: invalid class name */
            /* loaded from: classes31.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;

                AnonymousClass1(Continuation continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(continuation);
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
                        ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$tryShowRecheckLotteryResultDialog$$inlined$apply$lambda$3 eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$tryShowRecheckLotteryResultDialog$$inlined$apply$lambda$3 = ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$tryShowRecheckLotteryResultDialog$$inlined$apply$lambda$3.this;
                        ECOrderSubmitFragment$dealWithSubmitSucceedResult$1 eCOrderSubmitFragment$dealWithSubmitSucceedResult$1 = ECOrderSubmitFragment$dealWithSubmitSucceedResult$1.this;
                        IECPayApi.PayResult payResult = payResult;
                        this.label = 1;
                        if (eCOrderSubmitFragment$dealWithSubmitSucceedResult$1.b(payResult, this) == coroutine_suspended) {
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
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ECOrderSubmitFragment$dealWithSubmitSucceedResult$1.this.f103472a), null, null, new AnonymousClass1(null), 3, null);
            }
        });
        gVar2.setCancelable(false);
        gVar2.show();
        this.f103472a.hadShowRecheckLotteryDialog = true;
    }

    @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi.ECPayCallback
    public void onPayNeedLogin() {
        Object first;
        cg0.a.b("ECOrderSubmitFragment", "onPayNeedLogin");
        ECOrderSpan eCOrderSpan = ECOrderSpan.f103884c;
        String B2 = this.f103472a.Li().B2();
        if (B2 == null) {
            B2 = "";
        }
        eCOrderSpan.b(B2, ECOrderSpanScene.OrderSubmit, ECOrderOperation.PayOrder, new ECOrderSpan.OrderRequestInfo(-1, null, 2, null), mi0.b.c());
        ECShopOrderDetailFragment.Companion companion = ECShopOrderDetailFragment.INSTANCE;
        Context requireContext = this.f103472a.requireContext();
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.f103473b.b());
        companion.a(requireContext, (String) first, OrderDetailEntrance.FROM_PAY_PAGE);
        this.f103472a.finish();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
    
        if (com.tencent.ecommerce.biz.orders.buyerorders.submit.model.d.b(r0) == true) goto L8;
     */
    @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi.ECPayCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPayResult(IECPayApi.PayResult payResult) {
        com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j E2 = this.f103472a.Li().E2();
        boolean z16 = E2 != null;
        cg0.a.b("ECOrderSubmitFragment", "onPayResult " + payResult + ", isBlindBox: " + z16);
        if (z16) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f103472a), null, null, new ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$onPayResult$1(this, payResult, null), 3, null);
        } else {
            a(payResult);
        }
        ECOrderSpan eCOrderSpan = ECOrderSpan.f103884c;
        String B2 = this.f103472a.Li().B2();
        if (B2 == null) {
            B2 = "";
        }
        eCOrderSpan.b(B2, ECOrderSpanScene.OrderSubmit, ECOrderOperation.PayOrder, new ECOrderSpan.OrderRequestInfo(payResult.getCode(), null, 2, null), mi0.b.d(payResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object b(IECPayApi.PayResult payResult, Continuation<? super Unit> continuation) {
        ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1 eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1;
        Object coroutine_suspended;
        int i3;
        Ref.BooleanRef booleanRef;
        IECPayApi.PayResult payResult2;
        Object withContext;
        ECOrderSubmitFragment$dealWithSubmitSucceedResult$1 eCOrderSubmitFragment$dealWithSubmitSucceedResult$1;
        com.tencent.ecommerce.base.ui.d dVar;
        int g16;
        if (continuation instanceof ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1) {
            eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1 = (ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1) continuation;
            int i16 = eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1.label = i16 - Integer.MIN_VALUE;
                ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1 eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$12 = eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1;
                Object obj = eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ECQshopOrderQuerySvr$OrderPageDetailRsp orderDetailRsp = this.f103473b.getOrderDetailRsp();
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = orderDetailRsp.product_cart.order_sku.spu.spu_id.get();
                    com.tencent.ecommerce.base.ui.d dVar2 = new com.tencent.ecommerce.base.ui.d(this.f103472a.requireContext(), null, 2, null);
                    dVar2.setOnCancelListener(new a());
                    dVar2.show();
                    booleanRef = new Ref.BooleanRef();
                    booleanRef.element = false;
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$url$1 eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$url$1 = new ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$url$1(this, payResult, objectRef, booleanRef, null);
                    eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$12.L$0 = this;
                    payResult2 = payResult;
                    eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$12.L$1 = payResult2;
                    eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$12.L$2 = dVar2;
                    eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$12.L$3 = booleanRef;
                    eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$12.label = 1;
                    withContext = BuildersKt.withContext(io5, eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$url$1, eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$12);
                    if (withContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCOrderSubmitFragment$dealWithSubmitSucceedResult$1 = this;
                    dVar = dVar2;
                } else if (i3 == 1) {
                    Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$12.L$3;
                    dVar = (com.tencent.ecommerce.base.ui.d) eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$12.L$2;
                    IECPayApi.PayResult payResult3 = (IECPayApi.PayResult) eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$12.L$1;
                    eCOrderSubmitFragment$dealWithSubmitSucceedResult$1 = (ECOrderSubmitFragment$dealWithSubmitSucceedResult$1) eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    booleanRef = booleanRef2;
                    withContext = obj;
                    payResult2 = payResult3;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str = (String) withContext;
                g16 = ECScheme.g(str, null, 2, null);
                dVar.dismiss();
                if (!(g16 == -1)) {
                    cg0.a.b("ECOrderSubmitFragment", "handlePayResultForBlindBox succeed.");
                    eCOrderSubmitFragment$dealWithSubmitSucceedResult$1.f103472a.finish();
                } else {
                    cg0.a.a("ECOrderSubmitFragment", "handlePayResultForBlindBox", "handlePayResultForBlindBox failed. url: " + str);
                    if (booleanRef.element) {
                        eCOrderSubmitFragment$dealWithSubmitSucceedResult$1.c();
                    } else {
                        eCOrderSubmitFragment$dealWithSubmitSucceedResult$1.d(payResult2);
                    }
                }
                return Unit.INSTANCE;
            }
        }
        eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1 = new ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1(this, continuation);
        ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1 eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$122 = eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1;
        Object obj2 = eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$122.label;
        if (i3 != 0) {
        }
        String str2 = (String) withContext;
        g16 = ECScheme.g(str2, null, 2, null);
        dVar.dismiss();
        if (!(g16 == -1)) {
        }
        return Unit.INSTANCE;
    }
}
