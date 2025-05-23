package com.tencent.mobileqq.webview.swift.startup.step;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.html.HtmlSession;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.startup.BrowserAutomator;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0017\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/step/InitHtmlSessionStep;", "Lcom/tencent/mobileqq/webview/swift/startup/step/BrowserStep;", "", "doStep", "T", "g", "()Ljava/lang/Object;", "<init>", "()V", "d", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class InitHtmlSessionStep extends BrowserStep {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/step/InitHtmlSessionStep$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.swift.startup.step.InitHtmlSessionStep$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44117);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InitHtmlSessionStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        Intent intent;
        String str;
        boolean startsWith$default;
        boolean startsWith$default2;
        WebViewProvider m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        Activity l3 = ((BrowserAutomator) this.mAutomator).l();
        if (l3 != null) {
            intent = l3.getIntent();
        } else {
            intent = null;
        }
        if (intent != null) {
            str = intent.getStringExtra("url");
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str) && (m3 = ((BrowserAutomator) this.mAutomator).m()) != null) {
            str = m3.getUrlFromIntent();
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("htmlAgent_InitHtmlSessionStep", 1, "url empty return");
            return super.doStep();
        }
        Intrinsics.checkNotNull(str);
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, "https://", false, 2, null);
            if (!startsWith$default2) {
                QLog.d("htmlAgent_InitHtmlSessionStep", 1, "url scheme not support return ");
                return super.doStep();
            }
        }
        com.tencent.mobileqq.webview.html.c cVar = com.tencent.mobileqq.webview.html.c.f313882a;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        HtmlSession b16 = com.tencent.mobileqq.webview.html.c.j(cVar, new com.tencent.mobileqq.webview.html.impl.a(context), null, 2, null).b(l3, str, intent, true);
        if (!QLog.isColorLevel()) {
            str = s.d(str, new String[0]);
        }
        QLog.d("htmlAgent_InitHtmlSessionStep", 1, "htmlSession=" + b16 + " url=" + str);
        return super.doStep();
    }

    @Override // com.tencent.mobileqq.webview.swift.startup.step.BrowserStep
    @Nullable
    public <T> T g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        doStep();
        return (T) Boolean.TRUE;
    }
}
