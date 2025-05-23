package com.tencent.mobileqq.aio.msglist.holder.component.ptt;

import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<no name provided>", "", "result", "", "errMsg", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class AIOPttContentComponent$showSpeechToTextLayout$1$resultCallback$1 extends Lambda implements Function2<Integer, String, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $isFromClick;
    final /* synthetic */ AIOPttContentComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOPttContentComponent$showSpeechToTextLayout$1$resultCallback$1(boolean z16, AIOPttContentComponent aIOPttContentComponent) {
        super(2);
        this.$isFromClick = z16;
        this.this$0 = aIOPttContentComponent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), aIOPttContentComponent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AIOPttContentComponent this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N3("", Boolean.valueOf(z16));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
        invoke(num.intValue(), str);
        return Unit.INSTANCE;
    }

    public final void invoke(int i3, @NotNull String errMsg) {
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) errMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("AIOPttContentComponent", 1, "translatePtt2Text result:" + i3 + ", errMsg:" + errMsg);
        if (this.$isFromClick) {
            AIOPttContentComponent aIOPttContentComponent = this.this$0;
            aIOPttContentComponent.u2(AIOPttContentComponent.Y1(aIOPttContentComponent));
        }
        if (i3 != 0) {
            handler = this.this$0.handler;
            final AIOPttContentComponent aIOPttContentComponent2 = this.this$0;
            final boolean z16 = this.$isFromClick;
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.r
                @Override // java.lang.Runnable
                public final void run() {
                    AIOPttContentComponent$showSpeechToTextLayout$1$resultCallback$1.b(AIOPttContentComponent.this, z16);
                }
            });
        }
    }
}
