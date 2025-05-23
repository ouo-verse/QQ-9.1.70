package com.tencent.sqshow.zootopia.avatar.loading.recorder;

import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.ZPlanRecordResource;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.loading.recorder.BaseLoadingAvatarRecorder$preloadCache$1", f = "BaseLoadingAvatarRecorder.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class BaseLoadingAvatarRecorder$preloadCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SingleRecordRequestParams $params;
    int label;
    final /* synthetic */ BaseLoadingAvatarRecorder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLoadingAvatarRecorder$preloadCache$1(SingleRecordRequestParams singleRecordRequestParams, BaseLoadingAvatarRecorder baseLoadingAvatarRecorder, Continuation<? super BaseLoadingAvatarRecorder$preloadCache$1> continuation) {
        super(2, continuation);
        this.$params = singleRecordRequestParams;
        this.this$0 = baseLoadingAvatarRecorder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseLoadingAvatarRecorder$preloadCache$1(this.$params, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
            SingleRecordRequestParams singleRecordRequestParams = this.$params;
            this.label = 1;
            obj = zPlanRecordResourceCenter.b(singleRecordRequestParams, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        QLog.i(this.this$0.n(), 1, "preloadCache cacheRes:" + ((ZPlanRecordResource) obj));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseLoadingAvatarRecorder$preloadCache$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
