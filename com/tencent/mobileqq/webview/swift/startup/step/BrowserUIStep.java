package com.tencent.mobileqq.webview.swift.startup.step;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.startup.BrowserAutomator;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/step/BrowserUIStep;", "Lcom/tencent/mobileqq/webview/swift/startup/step/BrowserStep;", "", "doStep", "j", "", "k", "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "uiHandler", "<init>", "(Landroid/os/Handler;)V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class BrowserUIStep extends BrowserStep {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    public BrowserUIStep(@NotNull Handler uiHandler) {
        Intrinsics.checkNotNullParameter(uiHandler, "uiHandler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) uiHandler);
        } else {
            this.uiHandler = uiHandler;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(BrowserUIStep this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long uptimeMillis = SystemClock.uptimeMillis();
        int j16 = this$0.j();
        QLog.e(((BrowserAutomator) this$0.mAutomator).getTag(), 1, this$0.mName + " execCost=" + (SystemClock.uptimeMillis() - uptimeMillis) + "ms waitCost=" + (SystemClock.uptimeMillis() - j3));
        this$0.setResult(j16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (!k()) {
            return super.doStep();
        }
        final long uptimeMillis = SystemClock.uptimeMillis();
        this.uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.startup.step.a
            @Override // java.lang.Runnable
            public final void run() {
                BrowserUIStep.i(BrowserUIStep.this, uptimeMillis);
            }
        });
        return 2;
    }

    protected int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return super.doStep();
    }

    protected boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }
}
