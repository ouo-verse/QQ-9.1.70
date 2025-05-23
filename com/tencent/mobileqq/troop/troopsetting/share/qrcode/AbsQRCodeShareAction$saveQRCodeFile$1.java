package com.tencent.mobileqq.troop.troopsetting.share.qrcode;

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
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopsetting.share.qrcode.AbsQRCodeShareAction", f = "AbsQRCodeShareAction.kt", i = {0}, l = {25}, m = "saveQRCodeFile", n = {"result"}, s = {"L$0"})
/* loaded from: classes19.dex */
public final class AbsQRCodeShareAction$saveQRCodeFile$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbsQRCodeShareAction this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsQRCodeShareAction$saveQRCodeFile$1(AbsQRCodeShareAction absQRCodeShareAction, Continuation<? super AbsQRCodeShareAction$saveQRCodeFile$1> continuation) {
        super(continuation);
        this.this$0 = absQRCodeShareAction;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) absQRCodeShareAction, (Object) continuation);
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
        return this.this$0.h(null, this);
    }
}
