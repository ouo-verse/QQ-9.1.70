package com.tencent.mobileqq.aio.msglist.holder.component.msgstatus;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class AIOMsgStatusComponent$showSendingRunnable$2 extends Lambda implements Function0<Runnable> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AIOMsgStatusComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgStatusComponent$showSendingRunnable$2(AIOMsgStatusComponent aIOMsgStatusComponent) {
        super(0);
        this.this$0 = aIOMsgStatusComponent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOMsgStatusComponent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AIOMsgStatusComponent this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z16 = this$0.canExecuteSendingRunnable;
        if (z16) {
            this$0.D1();
            return;
        }
        if (QLog.isColorLevel()) {
            com.tencent.aio.data.msglist.a aVar = this$0.curMsgItem;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("curMsgItem");
                aVar = null;
            }
            QLog.d("AIOMsgStatusComponent", 2, "intercept showSendingRunnable :" + aVar.getMsgId() + "}");
        }
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Runnable invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Runnable) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final AIOMsgStatusComponent aIOMsgStatusComponent = this.this$0;
        return new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgstatus.b
            @Override // java.lang.Runnable
            public final void run() {
                AIOMsgStatusComponent$showSendingRunnable$2.b(AIOMsgStatusComponent.this);
            }
        };
    }
}
