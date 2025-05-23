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
@DebugMetadata(c = "com.tencent.qqnt.aio.interceptor.BaseTempAIOStartInterceptor", f = "BaseTempAIOStartInterceptor.kt", i = {}, l = {40}, m = "interceptStartAIO$suspendImpl", n = {}, s = {})
/* loaded from: classes23.dex */
public final class BaseTempAIOStartInterceptor$interceptStartAIO$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseTempAIOStartInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTempAIOStartInterceptor$interceptStartAIO$1(BaseTempAIOStartInterceptor baseTempAIOStartInterceptor, Continuation<? super BaseTempAIOStartInterceptor$interceptStartAIO$1> continuation) {
        super(continuation);
        this.this$0 = baseTempAIOStartInterceptor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTempAIOStartInterceptor, (Object) continuation);
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
        return BaseTempAIOStartInterceptor.d(this.this$0, null, 0, null, null, null, this);
    }
}
