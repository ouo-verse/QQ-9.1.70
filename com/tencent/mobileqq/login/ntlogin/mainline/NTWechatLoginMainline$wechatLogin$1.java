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
@DebugMetadata(c = "com.tencent.mobileqq.login.ntlogin.mainline.NTWechatLoginMainline", f = "NTWechatLoginMainline.kt", i = {0, 0, 1, 1, 1, 3, 3}, l = {422, 425, 434, 452}, m = "wechatLogin", n = {"this", "loginInfo", "this", "loginInfo", "loginResult", "this", "loginResult"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"})
/* loaded from: classes15.dex */
public final class NTWechatLoginMainline$wechatLogin$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NTWechatLoginMainline this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTWechatLoginMainline$wechatLogin$1(NTWechatLoginMainline nTWechatLoginMainline, Continuation<? super NTWechatLoginMainline$wechatLogin$1> continuation) {
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
        Object wechatLogin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        wechatLogin = this.this$0.wechatLogin(null, this);
        return wechatLogin;
    }
}
