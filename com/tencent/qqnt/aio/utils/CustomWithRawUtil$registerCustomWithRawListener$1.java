package com.tencent.qqnt.aio.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/CustomWithdrawConfig;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.utils.CustomWithRawUtil$registerCustomWithRawListener$1", f = "CustomWithRawUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class CustomWithRawUtil$registerCustomWithRawListener$1 extends SuspendLambda implements Function2<CustomWithdrawConfig, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomWithRawUtil$registerCustomWithRawListener$1(Continuation<? super CustomWithRawUtil$registerCustomWithRawListener$1> continuation) {
        super(2, continuation);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        CustomWithRawUtil$registerCustomWithRawListener$1 customWithRawUtil$registerCustomWithRawListener$1 = new CustomWithRawUtil$registerCustomWithRawListener$1(continuation);
        customWithRawUtil$registerCustomWithRawListener$1.L$0 = obj;
        return customWithRawUtil$registerCustomWithRawListener$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CustomWithdrawConfig customWithdrawConfig, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((CustomWithRawUtil$registerCustomWithRawListener$1) create(customWithdrawConfig, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) customWithdrawConfig, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CustomWithdrawConfig customWithdrawConfig = (CustomWithdrawConfig) this.L$0;
                QLog.d("CustomWithdrawConfig", 1, "onEach CustomWithdrawConfig: " + customWithdrawConfig);
                CustomWithRawUtil.f352256a.c(customWithdrawConfig);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
