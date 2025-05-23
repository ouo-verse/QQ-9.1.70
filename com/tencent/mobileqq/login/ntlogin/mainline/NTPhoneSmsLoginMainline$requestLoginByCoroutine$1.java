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
@DebugMetadata(c = "com.tencent.mobileqq.login.ntlogin.mainline.NTPhoneSmsLoginMainline", f = "NTPhoneSmsLoginMainline.kt", i = {0, 0, 1, 1, 1, 2, 3}, l = {104, 109, 119, 148, 177}, m = "requestLoginByCoroutine", n = {"this", "getSmsReq", "this", "getSmsReq", "sendSmsResult", "this", "this"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$0"})
/* loaded from: classes15.dex */
public final class NTPhoneSmsLoginMainline$requestLoginByCoroutine$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NTPhoneSmsLoginMainline this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTPhoneSmsLoginMainline$requestLoginByCoroutine$1(NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline, Continuation<? super NTPhoneSmsLoginMainline$requestLoginByCoroutine$1> continuation) {
        super(continuation);
        this.this$0 = nTPhoneSmsLoginMainline;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTPhoneSmsLoginMainline, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object requestLoginByCoroutine;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        requestLoginByCoroutine = this.this$0.requestLoginByCoroutine(this);
        return requestLoginByCoroutine;
    }
}
