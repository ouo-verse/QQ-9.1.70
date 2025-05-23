package com.tencent.mobileqq.zplan.aigc.vm;

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
import org.light.utils.LightDyeUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel$releaseLightDyeUtil$1", f = "SuitCustomColorVewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitCustomColorVewModel$releaseLightDyeUtil$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SuitCustomColorVewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitCustomColorVewModel$releaseLightDyeUtil$1(SuitCustomColorVewModel suitCustomColorVewModel, Continuation<? super SuitCustomColorVewModel$releaseLightDyeUtil$1> continuation) {
        super(2, continuation);
        this.this$0 = suitCustomColorVewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitCustomColorVewModel$releaseLightDyeUtil$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LightDyeUtil lightDyeUtil;
        LightDyeUtil lightDyeUtil2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            lightDyeUtil = this.this$0.lightDyeUtil;
            if (lightDyeUtil != null) {
                SuitCustomColorVewModel suitCustomColorVewModel = this.this$0;
                synchronized (lightDyeUtil) {
                    lightDyeUtil2 = suitCustomColorVewModel.lightDyeUtil;
                    QLog.i("SuitCustomColorVewModel", 1, "lightDyeUtil destroy  " + lightDyeUtil2);
                    lightDyeUtil.destroy();
                    suitCustomColorVewModel.lightDyeUtil = null;
                    Unit unit = Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitCustomColorVewModel$releaseLightDyeUtil$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
