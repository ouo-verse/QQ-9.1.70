package com.tencent.mobileqq.register.ntregister;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.register.ntregister.NTRegisterMainline", f = "NTRegisterMainline.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {193, 200}, m = "handleUnbindUin", n = {"this", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "wechatInfo", "registerRsp", "this", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "wechatInfo"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
/* loaded from: classes17.dex */
public final class NTRegisterMainline$handleUnbindUin$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NTRegisterMainline this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTRegisterMainline$handleUnbindUin$1(NTRegisterMainline nTRegisterMainline, Continuation<? super NTRegisterMainline$handleUnbindUin$1> continuation) {
        super(continuation);
        this.this$0 = nTRegisterMainline;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTRegisterMainline, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object x16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        x16 = this.this$0.x(null, null, null, this);
        return x16;
    }
}
