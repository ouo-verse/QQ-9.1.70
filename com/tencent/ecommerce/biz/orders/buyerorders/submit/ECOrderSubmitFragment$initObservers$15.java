package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import android.content.Context;
import com.tencent.ecommerce.base.network.service.CommonNetworkErrorHandler;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.l;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$initObservers$15", f = "ECOrderSubmitFragment.kt", i = {}, l = {1203}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECOrderSubmitFragment$initObservers$15 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECOrderSubmitFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements FlowCollector<l> {
        public a() {
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(l lVar, Continuation continuation) {
            l lVar2 = lVar;
            if (lVar2 instanceof l.ErrorToastWithMsgEvent) {
                com.tencent.ecommerce.base.ui.i.f101155b.d(((l.ErrorToastWithMsgEvent) lVar2).msg, ECToastIcon.ICON_ERROR, 0);
            } else if (lVar2 instanceof l.ErrorToastWithMsgResIdEvent) {
                com.tencent.ecommerce.base.ui.i.f101155b.c(((l.ErrorToastWithMsgResIdEvent) lVar2).msgResId, ECToastIcon.ICON_ERROR, 0);
            } else if (lVar2 instanceof l.ErrorCommonEvent) {
                Context context = ECOrderSubmitFragment$initObservers$15.this.this$0.getContext();
                if (context != null) {
                    l.ErrorCommonEvent errorCommonEvent = (l.ErrorCommonEvent) lVar2;
                    CommonNetworkErrorHandler.f100823a.a(errorCommonEvent.code, errorCommonEvent.msg, context);
                }
            } else if (lVar2 instanceof l.ErrorWithSpecificType) {
                l.ErrorWithSpecificType errorWithSpecificType = (l.ErrorWithSpecificType) lVar2;
                ECOrderSubmitFragment$initObservers$15.this.this$0.Mi(errorWithSpecificType.errorType, errorWithSpecificType.msg);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderSubmitFragment$initObservers$15(ECOrderSubmitFragment eCOrderSubmitFragment, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCOrderSubmitFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECOrderSubmitFragment$initObservers$15(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECOrderSubmitFragment$initObservers$15) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<l> y26 = this.this$0.Li().y2();
            a aVar = new a();
            this.label = 1;
            if (y26.collect(aVar, this) == coroutine_suspended) {
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
