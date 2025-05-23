package com.tencent.mobileqq.flock.base;

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
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0006\b\u0000\u0010\u0000 \u0001*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.flock.base.FlockBaseRequest$getPsKey$1", f = "FlockBaseRequest.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class FlockBaseRequest$getPsKey$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AppRuntime $appRuntime;
    final /* synthetic */ Ref.ObjectRef<String> $passkey;
    Object L$0;
    int label;
    final /* synthetic */ FlockBaseRequest<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlockBaseRequest$getPsKey$1(Ref.ObjectRef<String> objectRef, FlockBaseRequest<? extends T> flockBaseRequest, AppRuntime appRuntime, Continuation<? super FlockBaseRequest$getPsKey$1> continuation) {
        super(2, continuation);
        this.$passkey = objectRef;
        this.this$0 = flockBaseRequest;
        this.$appRuntime = appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, objectRef, flockBaseRequest, appRuntime, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new FlockBaseRequest$getPsKey$1(this.$passkey, this.this$0, this.$appRuntime, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object a16;
        Ref.ObjectRef<String> objectRef;
        T t16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    objectRef = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    t16 = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<String> objectRef2 = this.$passkey;
                FlockBaseRequest<T> flockBaseRequest = this.this$0;
                AppRuntime appRuntime = this.$appRuntime;
                Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
                this.L$0 = objectRef2;
                this.label = 1;
                a16 = flockBaseRequest.a(FlockBaseRequest.QUN_DOMAIN, appRuntime, this);
                if (a16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                t16 = a16;
            }
            objectRef.element = t16;
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((FlockBaseRequest$getPsKey$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
