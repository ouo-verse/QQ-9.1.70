package com.tencent.ecommerce.biz.orders.sampleorders;

import com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$2;
import com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "com/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListFragment$$special$$inlined$collect$2"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$2$1$lambda$1 implements FlowCollector<ECApplySampleOrderListViewModel.b> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$2.AnonymousClass1 f103773d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@\u00a8\u0006\u0006"}, d2 = {"T", "value", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "com/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListFragment$$special$$inlined$collect$2$1", "emit"}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$2$1$lambda$1$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$2$1$lambda$1.this.emit(null, this);
        }
    }

    public ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$2$1$lambda$1(ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$2.AnonymousClass1 anonymousClass1) {
        this.f103773d = anonymousClass1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(ECApplySampleOrderListViewModel.b bVar, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i16 = anonymousClass1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i16 - Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = anonymousClass1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ECApplySampleOrderListViewModel.b bVar2 = bVar;
                    if (bVar2 instanceof ECApplySampleOrderListViewModel.b.c) {
                        anonymousClass1.label = 1;
                        if (ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$2.this.this$0.Xh((ECApplySampleOrderListViewModel.b.c) bVar2, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (bVar2 instanceof ECApplySampleOrderListViewModel.b.C1079b) {
                        anonymousClass1.label = 2;
                        if (ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$2.this.this$0.Wh((ECApplySampleOrderListViewModel.b.C1079b) bVar2, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (bVar2 instanceof ECApplySampleOrderListViewModel.b.d) {
                        anonymousClass1.label = 3;
                        if (ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$2.this.this$0.Yh((ECApplySampleOrderListViewModel.b.d) bVar2, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (bVar2 instanceof ECApplySampleOrderListViewModel.b.e) {
                        ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$2.this.this$0.Zh((ECApplySampleOrderListViewModel.b.e) bVar2);
                    } else if (bVar2 instanceof ECApplySampleOrderListViewModel.b.a) {
                        ECApplySampleOrderListViewModel.b.a aVar = (ECApplySampleOrderListViewModel.b.a) bVar2;
                        ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$2.this.this$0.Vh(aVar.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID java.lang.String, aVar.getAddProductWindowResponse());
                    }
                } else {
                    if (i3 != 1 && i3 != 2 && i3 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = anonymousClass1.label;
        if (i3 != 0) {
        }
        return Unit.INSTANCE;
    }
}
