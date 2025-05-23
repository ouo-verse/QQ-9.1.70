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
@DebugMetadata(c = "com.tencent.mobileqq.login.ntlogin.mainline.NTWechatLoginMainline", f = "NTWechatLoginMainline.kt", i = {0, 1, 2, 3}, l = {95, 113, 117, 137, 152}, m = "startLoginByCoroutine", n = {"this", "this", "this", "this"}, s = {"L$0", "L$0", "L$0", "L$0"})
/* loaded from: classes15.dex */
public final class NTWechatLoginMainline$startLoginByCoroutine$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NTWechatLoginMainline this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTWechatLoginMainline$startLoginByCoroutine$1(NTWechatLoginMainline nTWechatLoginMainline, Continuation<? super NTWechatLoginMainline$startLoginByCoroutine$1> continuation) {
        super(continuation);
        this.this$0 = nTWechatLoginMainline;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTWechatLoginMainline, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object startLoginByCoroutine;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        startLoginByCoroutine = this.this$0.startLoginByCoroutine(this);
        return startLoginByCoroutine;
    }
}
