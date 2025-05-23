package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import androidx.core.util.Consumer;
import com.tencent.mobileqq.guild.report.DummyPerformanceReportTask;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.PostFeedMainTaskFacadeImpl$javaCallUploadTaskAwait$1", f = "PostFeedMainTaskFacadeImpl.kt", i = {1}, l = {120, 122}, m = "invokeSuspend", n = {"reportTask"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class PostFeedMainTaskFacadeImpl$javaCallUploadTaskAwait$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Consumer<h> $callback;
    Object L$0;
    int label;
    final /* synthetic */ PostFeedMainTaskFacadeImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostFeedMainTaskFacadeImpl$javaCallUploadTaskAwait$1(PostFeedMainTaskFacadeImpl postFeedMainTaskFacadeImpl, Consumer<h> consumer, Continuation<? super PostFeedMainTaskFacadeImpl$javaCallUploadTaskAwait$1> continuation) {
        super(2, continuation);
        this.this$0 = postFeedMainTaskFacadeImpl;
        this.$callback = consumer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PostFeedMainTaskFacadeImpl$javaCallUploadTaskAwait$1(this.this$0, this.$callback, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x004a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPerformanceReportTask iPerformanceReportTask;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    iPerformanceReportTask = (IPerformanceReportTask) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    h hVar = (h) obj;
                    if (iPerformanceReportTask != null) {
                        if (iPerformanceReportTask == DummyPerformanceReportTask.INSTANCE) {
                            z16 = false;
                        }
                        if (!z16) {
                            iPerformanceReportTask = null;
                        }
                        if (iPerformanceReportTask != null) {
                            d.f223127a.b(iPerformanceReportTask, hVar);
                        }
                    }
                    this.$callback.accept(hVar);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            PostFeedMainTaskFacadeImpl postFeedMainTaskFacadeImpl = this.this$0;
            this.label = 1;
            obj = postFeedMainTaskFacadeImpl.g(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        IPerformanceReportTask iPerformanceReportTask2 = (IPerformanceReportTask) obj;
        in1.c uploadTaskApi = this.this$0.getUploadTaskApi();
        this.L$0 = iPerformanceReportTask2;
        this.label = 2;
        Object k3 = uploadTaskApi.k(true, this);
        if (k3 == coroutine_suspended) {
            return coroutine_suspended;
        }
        iPerformanceReportTask = iPerformanceReportTask2;
        obj = k3;
        h hVar2 = (h) obj;
        if (iPerformanceReportTask != null) {
        }
        this.$callback.accept(hVar2);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PostFeedMainTaskFacadeImpl$javaCallUploadTaskAwait$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
