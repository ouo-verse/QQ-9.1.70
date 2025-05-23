package com.tencent.qqnt.aio.interceptor;

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
@DebugMetadata(c = "com.tencent.qqnt.aio.interceptor.FriendVerifyTempAIOInterceptor", f = "FriendVerifyTempAIOInterceptor.kt", i = {}, l = {37}, m = "interceptStartAIO", n = {}, s = {})
/* loaded from: classes23.dex */
public final class FriendVerifyTempAIOInterceptor$interceptStartAIO$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FriendVerifyTempAIOInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendVerifyTempAIOInterceptor$interceptStartAIO$1(FriendVerifyTempAIOInterceptor friendVerifyTempAIOInterceptor, Continuation<? super FriendVerifyTempAIOInterceptor$interceptStartAIO$1> continuation) {
        super(continuation);
        this.this$0 = friendVerifyTempAIOInterceptor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) friendVerifyTempAIOInterceptor, (Object) continuation);
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
        return this.this$0.b(null, 0, null, null, null, this);
    }
}
