package com.tencent.mobileqq.login.ntlogin.mainline;

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
@DebugMetadata(c = "com.tencent.mobileqq.login.ntlogin.mainline.NTAccountLoginMainline", f = "NTAccountLoginMainline.kt", i = {0, 0, 1, 1, 1, 1, 1, 3, 3, 3, 5, 5}, l = {82, 115, 137, 158, 164, 183}, m = "requestLoginByCoroutine", n = {"this", "pwdLoginInfo", "this", "pwdLoginInfo", "loginResult", "puzzleReportParam", "startTime", "this", "pwdLoginInfo", "loginResult", "this", "loginResult"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$0", "L$1"})
/* loaded from: classes15.dex */
public final class NTAccountLoginMainline$requestLoginByCoroutine$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NTAccountLoginMainline this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTAccountLoginMainline$requestLoginByCoroutine$1(NTAccountLoginMainline nTAccountLoginMainline, Continuation<? super NTAccountLoginMainline$requestLoginByCoroutine$1> continuation) {
        super(continuation);
        this.this$0 = nTAccountLoginMainline;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTAccountLoginMainline, (Object) continuation);
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
        requestLoginByCoroutine = this.this$0.requestLoginByCoroutine(null, this);
        return requestLoginByCoroutine;
    }
}
