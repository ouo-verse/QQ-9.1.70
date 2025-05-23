package com.tencent.mobileqq.zplan.aigc;

import com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2;
import com.tencent.mobileqq.zplan.servlet.ZPlanAIGCRequest;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$checkAndRefreshUGCId$1", f = "SuitCreateFragmentV2.kt", i = {}, l = {292}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitCreateFragmentV2$checkAndRefreshUGCId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SuitCreateFragmentV2.b $callback;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitCreateFragmentV2$checkAndRefreshUGCId$1(SuitCreateFragmentV2.b bVar, Continuation<? super SuitCreateFragmentV2$checkAndRefreshUGCId$1> continuation) {
        super(2, continuation);
        this.$callback = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitCreateFragmentV2$checkAndRefreshUGCId$1(this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Deferred<yv4.e> p16 = ZPlanAIGCRequest.f335341a.p();
                this.label = 1;
                obj = p16.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.$callback.a(((yv4.e) obj).f451340a, 0);
            return Unit.INSTANCE;
        } catch (Throwable th5) {
            QLog.e("SuitCreateFragmentV2", 1, "\u751f\u6210\u8863\u670d\u7684\u540d\u8bcd error ", th5);
            this.$callback.a(0L, -2);
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitCreateFragmentV2$checkAndRefreshUGCId$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
