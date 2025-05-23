package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.aelight.camera.ae.download.AENewResUtilKt$doSetup$1", f = "AENewResUtil.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
public final class AENewResUtilKt$doSetup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AENewResUtilKt$doSetup$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ms.a.f("AEResUtil", "loadConfig  doSetup begin launch");
            AENewResUtilKt$doSetup$1$config$1 aENewResUtilKt$doSetup$1$config$1 = new AENewResUtilKt$doSetup$1$config$1(null);
            this.label = 1;
            obj = TimeoutKt.withTimeout(5000L, aENewResUtilKt$doSetup$1$config$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AEResManagerConfigBean aEResManagerConfigBean = (AEResManagerConfigBean) obj;
        if (aEResManagerConfigBean != null) {
            AEResManager.J().y(aEResManagerConfigBean);
        }
        ms.a.f("AEResUtil", "loadConfig  doSetup end ");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AENewResUtilKt$doSetup$1(Continuation<? super AENewResUtilKt$doSetup$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AENewResUtilKt$doSetup$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
