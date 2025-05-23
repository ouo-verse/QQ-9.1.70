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
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopsetting.share.qrcode.QRQZoneShareAction", f = "QRQZoneShareAction.kt", i = {0}, l = {40}, m = "reqTailLink", n = {"bundle"}, s = {"L$0"})
/* loaded from: classes19.dex */
public final class QRQZoneShareAction$reqTailLink$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QRQZoneShareAction this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QRQZoneShareAction$reqTailLink$1(QRQZoneShareAction qRQZoneShareAction, Continuation<? super QRQZoneShareAction$reqTailLink$1> continuation) {
        super(continuation);
        this.this$0 = qRQZoneShareAction;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qRQZoneShareAction, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        j3 = this.this$0.j(null, null, this);
        return j3;
    }
}
