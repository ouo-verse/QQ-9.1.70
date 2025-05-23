package com.tencent.mobileqq.zplan.minihome.api.impl;

import com.tencent.mobileqq.zplan.minihome.MiniHomeInfoObserver;
import com.tencent.mobileqq.zplan.minihome.ai;
import com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import q55.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.api.impl.MiniHomeHelperImpl$requestMiniHomeInfoFromNet$1", f = "MiniHomeHelperImpl.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class MiniHomeHelperImpl$requestMiniHomeInfoFromNet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WeakReference<IMiniHomeHelper.b> $callback;
    final /* synthetic */ String $uin;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeHelperImpl$requestMiniHomeInfoFromNet$1(String str, WeakReference<IMiniHomeHelper.b> weakReference, Continuation<? super MiniHomeHelperImpl$requestMiniHomeInfoFromNet$1> continuation) {
        super(2, continuation);
        this.$uin = str;
        this.$callback = weakReference;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniHomeHelperImpl$requestMiniHomeInfoFromNet$1(this.$uin, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        d dVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                MiniHomeInfoObserver miniHomeInfoObserver = MiniHomeInfoObserver.f334284c;
                String str = this.$uin;
                this.label = 1;
                obj = miniHomeInfoObserver.g(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dVar = (d) obj;
        } catch (Throwable th5) {
            QLog.e(MiniHomeHelperImpl.TAG, 1, "requestMiniHomeInfo error, " + th5);
            IMiniHomeHelper.b bVar = this.$callback.get();
            if (bVar != null) {
                bVar.onResult(false, null);
            }
        }
        if (dVar == null) {
            IMiniHomeHelper.b bVar2 = this.$callback.get();
            if (bVar2 != null) {
                bVar2.onResult(false, null);
            }
            return Unit.INSTANCE;
        }
        IMiniHomeHelper.b bVar3 = this.$callback.get();
        if (bVar3 != null) {
            bVar3.onResult(true, ai.a(dVar));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniHomeHelperImpl$requestMiniHomeInfoFromNet$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
