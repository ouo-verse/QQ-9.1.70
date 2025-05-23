package com.tencent.aelight.camera.ae.download;

import android.os.Bundle;
import com.tencent.aelight.camera.qipc.api.IAECameraGetInfoServer;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.aelight.camera.ae.download.AENewResUtilKt$doSync$1$deferred$1", f = "AENewResUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
final class AENewResUtilKt$doSync$1$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EIPCResult>, Object> {
    int label;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AENewResUtilKt$doSync$1$deferred$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ms.a.a("AEResUtil", " call server  " + Thread.currentThread().getName());
            return BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), IAECameraGetInfoServer.NAME, "ACTION_SYNC_AE_RES_WRAPPER_MAP", new Bundle());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AENewResUtilKt$doSync$1$deferred$1(Continuation<? super AENewResUtilKt$doSync$1$deferred$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super EIPCResult> continuation) {
        return ((AENewResUtilKt$doSync$1$deferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
