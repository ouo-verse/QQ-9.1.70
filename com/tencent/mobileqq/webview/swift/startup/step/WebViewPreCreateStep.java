package com.tencent.mobileqq.webview.swift.startup.step;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.startup.BrowserAutomator;
import com.tencent.mobileqq.webview.swift.startup.e;
import com.tencent.mobileqq.webview.swift.utils.m;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\u0006H\u0014R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/step/WebViewPreCreateStep;", "Lcom/tencent/mobileqq/webview/swift/startup/step/BrowserUIStep;", "", "postTs", "", "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", DomainData.DOMAIN_NAME, "doStep", "k", "j", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "uiHandler", "Ljava/util/concurrent/atomic/AtomicInteger;", "f", "Ljava/util/concurrent/atomic/AtomicInteger;", "getRetryCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setRetryCount", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "retryCount", "<init>", "(Landroid/os/Handler;)V", h.F, "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class WebViewPreCreateStep extends BrowserUIStep {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger retryCount;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/step/WebViewPreCreateStep$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.swift.startup.step.WebViewPreCreateStep$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46039);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewPreCreateStep(@NotNull Handler uiHandler) {
        super(uiHandler);
        Intrinsics.checkNotNullParameter(uiHandler, "uiHandler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) uiHandler);
        } else {
            this.uiHandler = uiHandler;
            this.retryCount = new AtomicInteger(3);
        }
    }

    private final int m(long postTs) {
        long uptimeMillis = SystemClock.uptimeMillis();
        int j3 = j();
        QLog.e(((BrowserAutomator) this.mAutomator).getTag(), 1, this.mName + " remainCnt=" + this.retryCount.get() + " result=" + j3 + " execCost=" + (SystemClock.uptimeMillis() - uptimeMillis) + "ms waitCost=" + (SystemClock.uptimeMillis() - postTs));
        return j3;
    }

    private final boolean n() {
        boolean z16;
        if (SwiftReuseTouchWebView.I == 0 && !e.b(e.EVENT_KERNEL_INIT_WEBVIEW)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            t.Companion companion = t.INSTANCE;
            if (companion.a().i("debug_webview_precreate")) {
                if (z16 && ((Boolean) companion.a().b("debug_webview_precreate", Boolean.TRUE)).booleanValue()) {
                    return true;
                }
                return false;
            }
        }
        return z16;
    }

    private final void o(final long postTs) {
        if (this.retryCount.decrementAndGet() >= 0) {
            this.uiHandler.postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.startup.step.c
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewPreCreateStep.p(WebViewPreCreateStep.this, postTs);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(WebViewPreCreateStep this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.m(j3) != 7) {
            this$0.o(SystemClock.uptimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.startup.step.BrowserUIStep, com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (!k()) {
            return 7;
        }
        o(SystemClock.uptimeMillis());
        if (QLog.isColorLevel()) {
            QLog.e(((BrowserAutomator) this.mAutomator).getTag(), 2, this.mName + " AsyncStep.doStep()");
        }
        return 7;
    }

    @Override // com.tencent.mobileqq.webview.swift.startup.step.BrowserUIStep
    protected int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (!n()) {
            return 7;
        }
        if (!m.e()) {
            return 2;
        }
        try {
            QLog.d("WebViewPreCreateStep", 1, "[webViewReuse] preload WebView.");
            SwiftReuseTouchWebView.q(BaseApplication.getContext()).t(true);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th5) {
            QLog.e("IAutomator", 1, th5.getMessage(), th5);
        }
        return 7;
    }

    @Override // com.tencent.mobileqq.webview.swift.startup.step.BrowserUIStep
    protected boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (n() && InitX5StrategyStep.INSTANCE.a()) {
            return true;
        }
        return false;
    }
}
