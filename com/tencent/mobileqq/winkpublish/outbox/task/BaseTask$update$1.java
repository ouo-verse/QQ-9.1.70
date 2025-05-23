package com.tencent.mobileqq.winkpublish.outbox.task;

import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.outbox.d;
import com.tencent.mobileqq.winkpublish.outbox.e;
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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.BaseTask$update$1", f = "BaseTask.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class BaseTask$update$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WinkPublishParams $newParams;
    int label;
    final /* synthetic */ BaseTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTask$update$1(BaseTask baseTask, WinkPublishParams winkPublishParams, Continuation<? super BaseTask$update$1> continuation) {
        super(2, continuation);
        this.this$0 = baseTask;
        this.$newParams = winkPublishParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseTask$update$1(this.this$0, this.$newParams, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseTask$update$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0095  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean O;
        Job job;
        String str;
        String str2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            O = this.this$0.O(this.$newParams);
            if (O) {
                job = this.this$0.job;
                if (job != null) {
                    this.label = 1;
                    if (JobKt.cancelAndJoin(job, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            this.this$0.getTaskContext().T(this.$newParams);
            com.tencent.mobileqq.winkpublish.outbox.db.a.c().e(this.this$0);
            this.this$0.P(1);
            d.c(this.this$0.getTaskContext(), "key_user_click_upload_cost");
            TaskContext taskContext = this.this$0.getTaskContext();
            String r16 = this.this$0.getTaskContext().r();
            String valueOf = String.valueOf(this.this$0.getTaskContext().getSeqId());
            if (!this.this$0.getTaskContext().A()) {
                str = "1";
            } else {
                str = "0";
            }
            String str3 = str;
            String dtCameraSessionId = this.this$0.getTaskContext().getDtCameraSessionId();
            if (!this.this$0.getTaskContext().C()) {
                str2 = "video";
            } else {
                str2 = "image";
            }
            d.d(taskContext, "E_PUBLISH_UPDATA_SLIENCE_TASK", r16, (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : valueOf, (r33 & 16) != 0 ? "" : str3, (r33 & 32) != 0 ? "" : dtCameraSessionId, (r33 & 64) != 0 ? "" : str2, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
            e.f327257a.a(this.this$0.s()).c(this.this$0.z());
            return Unit.INSTANCE;
        }
        if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        QLog.d("WinkPublish-upload2-BaseTask", 2, "[update] after cancel");
        this.this$0.getTaskContext().T(this.$newParams);
        com.tencent.mobileqq.winkpublish.outbox.db.a.c().e(this.this$0);
        this.this$0.P(1);
        d.c(this.this$0.getTaskContext(), "key_user_click_upload_cost");
        TaskContext taskContext2 = this.this$0.getTaskContext();
        String r162 = this.this$0.getTaskContext().r();
        String valueOf2 = String.valueOf(this.this$0.getTaskContext().getSeqId());
        if (!this.this$0.getTaskContext().A()) {
        }
        String str32 = str;
        String dtCameraSessionId2 = this.this$0.getTaskContext().getDtCameraSessionId();
        if (!this.this$0.getTaskContext().C()) {
        }
        d.d(taskContext2, "E_PUBLISH_UPDATA_SLIENCE_TASK", r162, (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : valueOf2, (r33 & 16) != 0 ? "" : str32, (r33 & 32) != 0 ? "" : dtCameraSessionId2, (r33 & 64) != 0 ? "" : str2, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        e.f327257a.a(this.this$0.s()).c(this.this$0.z());
        return Unit.INSTANCE;
    }
}
