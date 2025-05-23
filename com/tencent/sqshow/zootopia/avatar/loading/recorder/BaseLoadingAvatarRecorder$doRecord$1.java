package com.tencent.sqshow.zootopia.avatar.loading.recorder;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.loading.recorder.BaseLoadingAvatarRecorder$doRecord$1", f = "BaseLoadingAvatarRecorder.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class BaseLoadingAvatarRecorder$doRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $canTriggerRecord;
    final /* synthetic */ SingleRecordRequestParams $params;
    final /* synthetic */ String $selfUin;
    final /* synthetic */ List<Source> $sources;
    final /* synthetic */ long $startTime;
    int label;
    final /* synthetic */ BaseLoadingAvatarRecorder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseLoadingAvatarRecorder$doRecord$1(SingleRecordRequestParams singleRecordRequestParams, List<? extends Source> list, BaseLoadingAvatarRecorder baseLoadingAvatarRecorder, boolean z16, long j3, String str, Continuation<? super BaseLoadingAvatarRecorder$doRecord$1> continuation) {
        super(2, continuation);
        this.$params = singleRecordRequestParams;
        this.$sources = list;
        this.this$0 = baseLoadingAvatarRecorder;
        this.$canTriggerRecord = z16;
        this.$startTime = j3;
        this.$selfUin = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(BaseLoadingAvatarRecorder baseLoadingAvatarRecorder, ZPlanRecordResource zPlanRecordResource) {
        baseLoadingAvatarRecorder.k(zPlanRecordResource);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseLoadingAvatarRecorder$doRecord$1(this.$params, this.$sources, this.this$0, this.$canTriggerRecord, this.$startTime, this.$selfUin, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        HashMap hashMap;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
            SingleRecordRequestParams singleRecordRequestParams = this.$params;
            List<Source> list = this.$sources;
            this.label = 1;
            obj = zPlanRecordResourceCenter.h(singleRecordRequestParams, list, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final ZPlanRecordResource zPlanRecordResource = (ZPlanRecordResource) obj;
        QLog.i(this.this$0.n(), 1, "doRecord finish. res:" + zPlanRecordResource);
        if (this.$canTriggerRecord) {
            this.this$0.h(this.$params, zPlanRecordResource, this.$startTime);
        }
        if (zPlanRecordResource == null) {
            return Unit.INSTANCE;
        }
        if (zPlanRecordResource.o() || zPlanRecordResource.p()) {
            hashMap = this.this$0.mResourcePool;
            hashMap.put(this.$selfUin, zPlanRecordResource);
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final BaseLoadingAvatarRecorder baseLoadingAvatarRecorder = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.avatar.loading.recorder.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseLoadingAvatarRecorder$doRecord$1.b(BaseLoadingAvatarRecorder.this, zPlanRecordResource);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseLoadingAvatarRecorder$doRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
