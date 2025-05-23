package com.tencent.mobileqq.qcoroutine.framework.coroutine;

import com.tencent.mobileqq.qcoroutine.framework.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.mobileqq.qcoroutine.framework.coroutine.QCoroutineExecute$Companion$qRunBlockingExecute$1", f = "QCoroutineExecute.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class QCoroutineExecute$Companion$qRunBlockingExecute$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function2 $block;
    final /* synthetic */ String $name;
    final /* synthetic */ Ref.ObjectRef $qJob;
    final /* synthetic */ Ref.ObjectRef $runnable;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCoroutineExecute$Companion$qRunBlockingExecute$1(String str, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$name = str;
        this.$runnable = objectRef;
        this.$qJob = objectRef2;
        this.$block = function2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, objectRef, objectRef2, function2, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
        }
        Intrinsics.checkNotNullParameter(completion, "completion");
        QCoroutineExecute$Companion$qRunBlockingExecute$1 qCoroutineExecute$Companion$qRunBlockingExecute$1 = new QCoroutineExecute$Companion$qRunBlockingExecute$1(this.$name, this.$runnable, this.$qJob, this.$block, completion);
        qCoroutineExecute$Companion$qRunBlockingExecute$1.L$0 = obj;
        return qCoroutineExecute$Companion$qRunBlockingExecute$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, obj);
        }
        return ((QCoroutineExecute$Companion$qRunBlockingExecute$1) create(coroutineScope, (Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                e.b(coroutineScope);
                CoroutineName coroutineName = (CoroutineName) coroutineScope.getCoroutineContext().get(CoroutineName.INSTANCE);
                if (coroutineName == null || (str = coroutineName.getName()) == null) {
                    str = this.$name;
                }
                ((a) this.$runnable.element).i(str);
                ((com.tencent.mobileqq.qcoroutine.api.coroutine.a) this.$qJob.element).j(JobKt.getJob(coroutineScope.getCoroutineContext()));
                a aVar = (a) this.$runnable.element;
                Function2 function2 = this.$block;
                this.label = 1;
                obj = CoroutineRunnableKt.a(aVar, function2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
        }
        return iPatchRedirector.redirect((short) 1, (Object) this, obj);
    }
}
