package com.tencent.ecommerce.biz.shoplist;

import com.tencent.ecommerce.base.list.UIStateKt;
import com.tencent.ecommerce.base.list.h;
import com.tencent.ecommerce.biz.shoplist.ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "com/tencent/ecommerce/biz/shoplist/ECQShopPromoteListFragment$$special$$inlined$collect$1"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1 implements FlowCollector<h<ECPromoteShopItem, String>> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.AnonymousClass1 f104432d;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@\u00a8\u0006\u0006"}, d2 = {"T", "value", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "com/tencent/ecommerce/biz/shoplist/ECQShopPromoteListFragment$$special$$inlined$collect$1$1", "emit"}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.shoplist.ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1.this.emit(null, this);
        }
    }

    public ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1(ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.AnonymousClass1 anonymousClass1) {
        this.f104432d = anonymousClass1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(h<ECPromoteShopItem, String> hVar, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i3;
        h<ECPromoteShopItem, String> hVar2;
        ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1 eCQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1;
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
                    hVar2 = hVar;
                    b Lh = ECQShopPromoteListFragment.Lh(ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0);
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = hVar2;
                    anonymousClass1.label = 1;
                    if (UIStateKt.g(hVar2, Lh, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1 = this;
                } else if (i3 == 1) {
                    hVar2 = (h) anonymousClass1.L$1;
                    eCQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1 = (ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                UIStateKt.f(hVar2, ECQShopPromoteListFragment.Ph(ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0), ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.getString(R.string.woj), null, 4, null);
                UIStateKt.d(hVar2, ECQShopPromoteListFragment.Oh(ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0), false, 2, null);
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = anonymousClass1.label;
        if (i3 != 0) {
        }
        UIStateKt.f(hVar2, ECQShopPromoteListFragment.Ph(ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0), ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.getString(R.string.woj), null, 4, null);
        UIStateKt.d(hVar2, ECQShopPromoteListFragment.Oh(ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0), false, 2, null);
        return Unit.INSTANCE;
    }
}
