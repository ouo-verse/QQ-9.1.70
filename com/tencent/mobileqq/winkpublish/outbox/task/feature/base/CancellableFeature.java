package com.tencent.mobileqq.winkpublish.outbox.task.feature.base;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0005B\u0013\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b%\u0010&J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0006\u0010\u0011\u001a\u00020\u0004J\u0012\u0010\u0015\u001a\u00020\u00042\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013J\u0006\u0010\u0016\u001a\u00020\tR\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0018R\"\u0010 \u001a\u00020\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/CancellableFeature;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "a", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "k", "", ReportConstant.COSTREPORT_PREFIX, "t", DomainData.DOMAIN_NAME, "", "j", "p", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "o", "i", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "f", "I", h.F, "()I", "r", "(I)V", "retryTimes", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "timeoutJob", "next", "<init>", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class CancellableFeature extends b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CancellableContinuation<? super Unit> continuation;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int retryTimes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Job timeoutJob;

    public CancellableFeature() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    static /* synthetic */ Object q(CancellableFeature cancellableFeature, TaskContext taskContext, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new CancellableFeature$run$2(cancellableFeature, taskContext, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a
    public Object a(TaskContext taskContext, Continuation<? super Unit> continuation) {
        return q(this, taskContext, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h, reason: from getter */
    public final int getRetryTimes() {
        return this.retryTimes;
    }

    public final boolean i() {
        CancellableContinuation<? super Unit> cancellableContinuation = this.continuation;
        if (cancellableContinuation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("continuation");
            cancellableContinuation = null;
        }
        return cancellableContinuation.isActive();
    }

    public int j() {
        return 1;
    }

    public boolean k() {
        return false;
    }

    public abstract void l(TaskContext taskContext);

    public abstract void m(TaskContext taskContext);

    public final void o(Exception e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        Job job = this.timeoutJob;
        CancellableContinuation<? super Unit> cancellableContinuation = null;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (i()) {
            CancellableContinuation<? super Unit> cancellableContinuation2 = this.continuation;
            if (cancellableContinuation2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("continuation");
            } else {
                cancellableContinuation = cancellableContinuation2;
            }
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(e16)));
        }
    }

    public final void p() {
        Job job = this.timeoutJob;
        CancellableContinuation<? super Unit> cancellableContinuation = null;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (i()) {
            CancellableContinuation<? super Unit> cancellableContinuation2 = this.continuation;
            if (cancellableContinuation2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("continuation");
            } else {
                cancellableContinuation = cancellableContinuation2;
            }
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(int i3) {
        this.retryTimes = i3;
    }

    public long s() {
        return 5000L;
    }

    public long t() {
        return 0L;
    }

    public CancellableFeature(b bVar) {
        super(bVar);
    }

    public /* synthetic */ CancellableFeature(b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }

    public void n() {
    }
}
