package com.tencent.mobileqq.login.ntlogin.mainline;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.login.ntlogin.mainline.NTPhonePasswordLoginMainline", f = "NTPhonePasswordLoginMainline.kt", i = {0, 0}, l = {230}, m = "newDevLockVerify", n = {"this", "startTime"}, s = {"L$0", "J$0"})
/* loaded from: classes15.dex */
public final class NTPhonePasswordLoginMainline$newDevLockVerify$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NTPhonePasswordLoginMainline this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTPhonePasswordLoginMainline$newDevLockVerify$1(NTPhonePasswordLoginMainline nTPhonePasswordLoginMainline, Continuation<? super NTPhonePasswordLoginMainline$newDevLockVerify$1> continuation) {
        super(continuation);
        this.this$0 = nTPhonePasswordLoginMainline;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTPhonePasswordLoginMainline, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object newDevLockVerify;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        newDevLockVerify = this.this$0.newDevLockVerify(null, this);
        return newDevLockVerify;
    }
}
