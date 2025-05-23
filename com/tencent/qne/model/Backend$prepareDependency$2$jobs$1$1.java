package com.tencent.qne.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/qne/util/c;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.qne.model.Backend$prepareDependency$2$jobs$1$1", f = "Backend.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes22.dex */
final class Backend$prepareDependency$2$jobs$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.tencent.qne.util.c>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ DependencyLibrary $it;
    final /* synthetic */ com.tencent.qne.delegate.d $shiply;
    final /* synthetic */ String $unzipPath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Backend$prepareDependency$2$jobs$1$1(DependencyLibrary dependencyLibrary, com.tencent.qne.delegate.d dVar, String str, Continuation<? super Backend$prepareDependency$2$jobs$1$1> continuation) {
        super(2, continuation);
        this.$it = dependencyLibrary;
        this.$shiply = dVar;
        this.$unzipPath = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, dependencyLibrary, dVar, str, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new Backend$prepareDependency$2$jobs$1$1(this.$it, this.$shiply, this.$unzipPath, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                DependencyLibrary dependencyLibrary = this.$it;
                com.tencent.qne.delegate.d dVar = this.$shiply;
                String str = this.$unzipPath;
                this.label = 1;
                obj = dependencyLibrary.prepare(dVar, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super com.tencent.qne.util.c> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((Backend$prepareDependency$2$jobs$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
