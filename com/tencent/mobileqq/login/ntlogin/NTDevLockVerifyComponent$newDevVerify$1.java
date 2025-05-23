package com.tencent.mobileqq.login.ntlogin;

import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.login.ntlogin.NTDevLockVerifyComponent", f = "NTDevLockVerifyComponent.kt", i = {1, 1, 1, 1, 1}, l = {61, 69, 77, 81}, m = "newDevVerify", n = {"this", "uin", "verifyInfo", "passThroughParams", TangramHippyConstants.LOGIN_TYPE}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
/* loaded from: classes15.dex */
public final class NTDevLockVerifyComponent$newDevVerify$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NTDevLockVerifyComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTDevLockVerifyComponent$newDevVerify$1(NTDevLockVerifyComponent nTDevLockVerifyComponent, Continuation<? super NTDevLockVerifyComponent$newDevVerify$1> continuation) {
        super(continuation);
        this.this$0 = nTDevLockVerifyComponent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTDevLockVerifyComponent, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(0, null, null, null, this);
    }
}
