package com.tencent.qqnt.msg.api;

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
@DebugMetadata(c = "com.tencent.qqnt.msg.api.NTOperateUtils", f = "NTOperateUtils.kt", i = {}, l = {28}, m = "queryLastMsg", n = {}, s = {})
/* loaded from: classes24.dex */
public final class NTOperateUtils$queryLastMsg$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NTOperateUtils this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTOperateUtils$queryLastMsg$1(NTOperateUtils nTOperateUtils, Continuation<? super NTOperateUtils$queryLastMsg$1> continuation) {
        super(continuation);
        this.this$0 = nTOperateUtils;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTOperateUtils, (Object) continuation);
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
        return this.this$0.g(null, this);
    }
}
