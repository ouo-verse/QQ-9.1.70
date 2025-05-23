package com.tencent.mobileqq.zplan.minixwconnected.view;

import com.tencent.mobileqq.zplan.minihome.MiniHomeNetworkKt;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectStrangerComponent$requestRecommendUserInfo$1", f = "MiniHomeConnectStrangerComponent.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class MiniHomeConnectStrangerComponent$requestRecommendUserInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MiniHomeConnectStrangerComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectStrangerComponent$requestRecommendUserInfo$1(MiniHomeConnectStrangerComponent miniHomeConnectStrangerComponent, Continuation<? super MiniHomeConnectStrangerComponent$requestRecommendUserInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = miniHomeConnectStrangerComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniHomeConnectStrangerComponent$requestRecommendUserInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        AtomicBoolean atomicBoolean;
        Object firstOrNull;
        AtomicBoolean atomicBoolean2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            atomicBoolean = this.this$0.isVisiting;
            if (!atomicBoolean.compareAndSet(false, true)) {
                this.this$0.q("\u5148\u6b47\u4f1a\u513f\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0);
                return Unit.INSTANCE;
            }
            this.label = 1;
            obj = MiniHomeNetworkKt.h(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        x45.h[] hVarArr = (x45.h[]) obj;
        if (hVarArr != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(hVarArr);
            x45.h hVar = (x45.h) firstOrNull;
            if (hVar != null) {
                MiniHomeConnectStrangerComponent miniHomeConnectStrangerComponent = this.this$0;
                miniHomeConnectStrangerComponent.recommendUserInfo = hVar;
                atomicBoolean2 = miniHomeConnectStrangerComponent.isVisiting;
                Boxing.boxBoolean(atomicBoolean2.compareAndSet(true, false));
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniHomeConnectStrangerComponent$requestRecommendUserInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
