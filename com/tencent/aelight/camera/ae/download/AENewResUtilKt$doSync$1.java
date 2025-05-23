package com.tencent.aelight.camera.ae.download;

import eipc.EIPCResult;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.aelight.camera.ae.download.AENewResUtilKt$doSync$1", f = "AENewResUtil.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
public final class AENewResUtilKt$doSync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AENewResUtilKt$doSync$1 aENewResUtilKt$doSync$1 = new AENewResUtilKt$doSync$1(continuation);
        aENewResUtilKt$doSync$1.L$0 = obj;
        return aENewResUtilKt$doSync$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        Serializable serializable = null;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ms.a.a("AEResUtil", "doSync-start" + Thread.currentThread().getName());
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getDefault(), null, new AENewResUtilKt$doSync$1$deferred$1(null), 2, null);
            this.label = 1;
            obj = async$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        EIPCResult eIPCResult = (EIPCResult) obj;
        if ((eIPCResult != null ? eIPCResult.data : null) == null) {
            ms.a.c("AEResUtil", "doSync result is null or result.data is null.");
            return Unit.INSTANCE;
        }
        try {
            serializable = eIPCResult.data.getSerializable("KEY_RESP_COMMON_DATA_KEY");
        } catch (Exception e16) {
            ms.a.c("AEResUtil", "doSync result getSerializable error. " + e16.getMessage());
        }
        if (serializable == null) {
            return Unit.INSTANCE;
        }
        if (serializable instanceof HashMap) {
            AEResUtil.O().putAll((HashMap) serializable);
            ms.a.f("AEResUtil", "sync size =  " + AEResUtil.O().size());
        }
        ms.a.a("AEResUtil", "doSync -end " + Thread.currentThread().getName());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AENewResUtilKt$doSync$1(Continuation<? super AENewResUtilKt$doSync$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AENewResUtilKt$doSync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
