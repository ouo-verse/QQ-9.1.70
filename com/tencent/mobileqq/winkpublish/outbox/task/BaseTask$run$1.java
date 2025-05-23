package com.tencent.mobileqq.winkpublish.outbox.task;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkpublish.outbox.d;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.BaseTask$run$1", f = "BaseTask.kt", i = {0}, l = {105, 127}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes35.dex */
public final class BaseTask$run$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.BaseTask$run$1$1", f = "BaseTask.kt", i = {0}, l = {110}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* renamed from: com.tencent.mobileqq.winkpublish.outbox.task.BaseTask$run$1$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BaseTask this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BaseTask baseTask, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = baseTask;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x008d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0038 -> B:5:0x003b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            CoroutineScope coroutineScope;
            AnonymousClass1 anonymousClass1;
            int i3;
            int i16;
            int i17;
            String str;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i18 = this.label;
            if (i18 == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                anonymousClass1 = this;
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                }
            } else if (i18 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                anonymousClass1 = this;
                BaseTask baseTask = anonymousClass1.this$0;
                i3 = baseTask.timerRunTimes;
                baseTask.timerRunTimes = i3 + 1;
                i16 = anonymousClass1.this$0.timerRunTimes;
                QLog.i("WinkPublish-upload2-BaseTask", 1, "[run] timer check, times=" + i16);
                TaskContext taskContext = anonymousClass1.this$0.getTaskContext();
                String r16 = anonymousClass1.this$0.getTaskContext().r();
                i17 = anonymousClass1.this$0.timerRunTimes;
                String valueOf = String.valueOf(i17);
                if (!anonymousClass1.this$0.getTaskContext().B()) {
                    str = "1";
                } else {
                    str = "0";
                }
                d.d(taskContext, "T_TASK_TIMER_CHECK", r16, (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : valueOf, (r33 & 16) != 0 ? "" : str, (r33 & 32) != 0 ? "" : String.valueOf(anonymousClass1.this$0.getTaskContext().getUploadTaskType()), (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    anonymousClass1.L$0 = coroutineScope;
                    anonymousClass1.label = 1;
                    if (DelayKt.delay(180000L, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    BaseTask baseTask2 = anonymousClass1.this$0;
                    i3 = baseTask2.timerRunTimes;
                    baseTask2.timerRunTimes = i3 + 1;
                    i16 = anonymousClass1.this$0.timerRunTimes;
                    QLog.i("WinkPublish-upload2-BaseTask", 1, "[run] timer check, times=" + i16);
                    TaskContext taskContext2 = anonymousClass1.this$0.getTaskContext();
                    String r162 = anonymousClass1.this$0.getTaskContext().r();
                    i17 = anonymousClass1.this$0.timerRunTimes;
                    String valueOf2 = String.valueOf(i17);
                    if (!anonymousClass1.this$0.getTaskContext().B()) {
                    }
                    d.d(taskContext2, "T_TASK_TIMER_CHECK", r162, (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : valueOf2, (r33 & 16) != 0 ? "" : str, (r33 & 32) != 0 ? "" : String.valueOf(anonymousClass1.this$0.getTaskContext().getUploadTaskType()), (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTask$run$1(BaseTask baseTask, Continuation<? super BaseTask$run$1> continuation) {
        super(2, continuation);
        this.this$0 = baseTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseTask$run$1 baseTask$run$1 = new BaseTask$run$1(this.this$0, continuation);
        baseTask$run$1.L$0 = obj;
        return baseTask$run$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0093  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        Object R;
        Job launch$default;
        Job job;
        Job job2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_wink_publish_outbox_get_a2_sync", true)) {
                BaseTask baseTask = this.this$0;
                this.L$0 = coroutineScope;
                this.label = 1;
                R = baseTask.R(this);
                if (R == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    int intValue = ((Number) obj).intValue();
                    job2 = this.this$0.timer;
                    if (job2 != null) {
                        Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                    }
                    this.this$0.P(intValue);
                    QLog.i("WinkPublish-upload2-BaseTask", 1, "[run] end, task id=" + this.this$0.u());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        QLog.i("WinkPublish-upload2-BaseTask", 1, "waitForA2 finish...");
        BaseTask baseTask2 = this.this$0;
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(baseTask2, null), 3, null);
        baseTask2.timer = launch$default;
        job = this.this$0.timer;
        if (job != null) {
            final BaseTask baseTask3 = this.this$0;
            job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.winkpublish.outbox.task.BaseTask$run$1.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th5) {
                    QLog.i("WinkPublish-upload2-BaseTask", 1, "[run] timer complete");
                    BaseTask.this.timerRunTimes = 0;
                }
            });
        }
        BaseTask baseTask4 = this.this$0;
        this.L$0 = null;
        this.label = 2;
        obj = baseTask4.q(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        int intValue2 = ((Number) obj).intValue();
        job2 = this.this$0.timer;
        if (job2 != null) {
        }
        this.this$0.P(intValue2);
        QLog.i("WinkPublish-upload2-BaseTask", 1, "[run] end, task id=" + this.this$0.u());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseTask$run$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
