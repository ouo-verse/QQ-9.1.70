package com.tencent.mobileqq.zplan.aio.panel.panel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class PanelAdapterKt$mapStateIn$2$invokeSuspend$$inlined$collect$1<T> implements FlowCollector<T> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ FlowCollector f331290d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Function1 f331291e;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.panel.PanelAdapterKt$mapStateIn$2$invokeSuspend$$inlined$collect$1", f = "PanelAdapter.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aio.panel.panel.PanelAdapterKt$mapStateIn$2$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    /* loaded from: classes35.dex */
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
            return PanelAdapterKt$mapStateIn$2$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public PanelAdapterKt$mapStateIn$2$invokeSuspend$$inlined$collect$1(FlowCollector flowCollector, Function1 function1) {
        this.f331290d = flowCollector;
        this.f331291e = function1;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|26|6|7|(0)(0)|11|12|13|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        com.tencent.qphone.base.util.QLog.e("PanelAdapter", 1, "mapStateIn ", r5);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t16, Continuation<? super Unit> continuation) {
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
                    FlowCollector flowCollector = this.f331290d;
                    Object invoke = this.f331291e.invoke(t16);
                    anonymousClass1.label = 1;
                    if (flowCollector.emit(invoke, anonymousClass1) == coroutine_suspended) {
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
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = anonymousClass1.label;
        if (i3 != 0) {
        }
        return Unit.INSTANCE;
    }
}
