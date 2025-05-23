package com.tencent.mobileqq.qcoroutine.framework.coroutine;

import com.tencent.mobileqq.qcoroutine.framework.d;
import com.tencent.mobileqq.qcoroutine.framework.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.mobileqq.qcoroutine.framework.coroutine.CoroutineRunnableKt$launchBlock$2", f = "CoroutineRunnable.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class CoroutineRunnableKt$launchBlock$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function2 $_block;
    final /* synthetic */ a $runnable;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineRunnableKt$launchBlock$2(a aVar, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$runnable = aVar;
        this.$_block = function2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, aVar, function2, continuation);
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
        CoroutineRunnableKt$launchBlock$2 coroutineRunnableKt$launchBlock$2 = new CoroutineRunnableKt$launchBlock$2(this.$runnable, this.$_block, completion);
        coroutineRunnableKt$launchBlock$2.L$0 = obj;
        return coroutineRunnableKt$launchBlock$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
        return ((CoroutineRunnableKt$launchBlock$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00eb A[DONT_GENERATE] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.mobileqq.qcoroutine.framework.b d16;
        com.tencent.mobileqq.qcoroutine.framework.b d17;
        com.tencent.mobileqq.qcoroutine.framework.b d18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    e.e("launchBlock:" + this.$runnable.d(), null, 2, null);
                    d dVar = d.f261833c;
                    c c16 = dVar.c(this.$runnable.e());
                    if (c16 != null && (d17 = c16.d(this.$runnable)) != null) {
                        d17.m(Boxing.boxLong(System.currentTimeMillis()));
                    }
                    if (!this.$runnable.f().get()) {
                        c c17 = dVar.c(this.$runnable.e());
                        if (c17 != null && (d16 = c17.d(this.$runnable)) != null) {
                            d16.n(Boxing.boxLong(System.currentTimeMillis()));
                        }
                        com.tencent.mobileqq.qcoroutine.api.a a16 = this.$runnable.a();
                        if (a16 != null) {
                            a16.onTaskStart();
                        }
                        Function2 function2 = this.$_block;
                        this.label = 1;
                        if (function2.invoke(coroutineScope, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                com.tencent.mobileqq.qcoroutine.api.a a17 = this.$runnable.a();
                if (a17 != null) {
                    a17.b();
                }
                c c18 = d.f261833c.c(this.$runnable.e());
                if (c18 != null && (d18 = c18.d(this.$runnable)) != null) {
                    d18.k(Boxing.boxLong(System.currentTimeMillis()));
                }
                return Unit.INSTANCE;
            } finally {
                c c19 = d.f261833c.c(this.$runnable.e());
                if (c19 != null) {
                    c19.c(this.$runnable);
                }
            }
        }
        return iPatchRedirector.redirect((short) 1, (Object) this, obj);
    }
}
