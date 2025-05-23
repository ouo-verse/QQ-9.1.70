package com.tencent.aelight.camera.ae.flashshow.zshow;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.aelight.camera.ae.flashshow.zshow.ZShowFilamentPreviewView$fetchLightRes$2$deferredList$1", f = "ZShowFilamentPreviewView.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
final class ZShowFilamentPreviewView$fetchLightRes$2$deferredList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ HashMap<String, Object> $costCollector;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZShowFilamentPreviewView$fetchLightRes$2$deferredList$1(HashMap<String, Object> hashMap, Continuation<? super ZShowFilamentPreviewView$fetchLightRes$2$deferredList$1> continuation) {
        super(2, continuation);
        this.$costCollector = hashMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZShowFilamentPreviewView$fetchLightRes$2$deferredList$1(this.$costCollector, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            WinkSchemaPreCheck winkSchemaPreCheck = WinkSchemaPreCheck.f326271a;
            String str = AEResInfo.LIGHT_RES_BASE_PACKAGE.agentType;
            Intrinsics.checkNotNullExpressionValue(str, "LIGHT_RES_BASE_PACKAGE.agentType");
            HashMap<String, Object> hashMap = this.$costCollector;
            this.label = 1;
            obj = winkSchemaPreCheck.p(str, hashMap, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((ZShowFilamentPreviewView$fetchLightRes$2$deferredList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
