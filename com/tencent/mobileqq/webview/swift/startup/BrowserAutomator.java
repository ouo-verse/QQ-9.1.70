package com.tencent.mobileqq.webview.swift.startup;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.automator.AbsAutomator;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.LinearGroup;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.startup.step.BrowserStep;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001f\u0010\f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u000b\u001a\u00020\nH\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J \u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/BrowserAutomator;", "Lcom/tencent/mobileqq/app/automator/AbsAutomator;", "Lcom/tencent/mobileqq/webview/swift/WebViewProvider;", "provider", "", "p", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "o", "T", "", "stepId", "k", "(I)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Lcom/tencent/mobileqq/app/automator/b;", "automator", "", "steps", "Lcom/tencent/mobileqq/app/automator/AsyncStep;", "S1", "", ExifInterface.LATITUDE_SOUTH, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getTag", DomainData.DOMAIN_NAME, "Lmqq/util/WeakReference;", "H", "Lmqq/util/WeakReference;", "webViewProviderRef", "I", "browserActivityRef", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class BrowserAutomator extends AbsAutomator {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final BrowserAutomator G;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private static WeakReference<WebViewProvider> webViewProviderRef;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private static WeakReference<Activity> browserActivityRef;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40937);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            G = new BrowserAutomator();
        }
    }

    BrowserAutomator() {
        super(new a(3, "Automator_Browser"), 3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final <T> T k(int stepId) {
        com.tencent.mobileqq.app.automator.b bVar = G;
        AsyncStep<?> S1 = bVar.S1(bVar, String.valueOf(stepId));
        Intrinsics.checkNotNull(S1, "null cannot be cast to non-null type com.tencent.mobileqq.webview.swift.startup.step.BrowserStep");
        return (T) ((BrowserStep) S1).g();
    }

    @JvmStatic
    public static final void o(@Nullable Activity activity) {
        WeakReference<Activity> weakReference;
        if (activity != null) {
            weakReference = new WeakReference<>(activity);
        } else {
            weakReference = null;
        }
        browserActivityRef = weakReference;
    }

    @JvmStatic
    public static final void p(@Nullable WebViewProvider provider) {
        WeakReference<WebViewProvider> weakReference;
        if (provider != null) {
            weakReference = new WeakReference<>(provider);
        } else {
            weakReference = null;
        }
        webViewProviderRef = weakReference;
    }

    @Override // com.tencent.mobileqq.app.automator.f
    public boolean Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return ((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion();
    }

    @Override // com.tencent.mobileqq.app.automator.f
    public boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && !QLog.isColorLevel()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.automator.d
    @NotNull
    public AsyncStep<?> S1(@Nullable com.tencent.mobileqq.app.automator.b automator, @Nullable String steps) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AsyncStep) iPatchRedirector.redirect((short) 4, (Object) this, (Object) automator, (Object) steps);
        }
        AsyncStep<?> S1 = b.f314655d.S1(automator, steps);
        Intrinsics.checkNotNullExpressionValue(S1, "BrowserStepFactory.createStep(automator, steps)");
        return S1;
    }

    @Override // com.tencent.mobileqq.app.automator.AbsAutomator, com.tencent.mobileqq.app.automator.b
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "Automator_Browser";
    }

    @Nullable
    public final Activity l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Activity) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        WeakReference<Activity> weakReference = browserActivityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Nullable
    public final WebViewProvider m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WebViewProvider) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        WeakReference<WebViewProvider> weakReference = webViewProviderRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final boolean n(@Nullable String steps) {
        String str;
        boolean equals$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) steps)).booleanValue();
        }
        LinearGroup f16 = f();
        if (f16 != null) {
            str = f16.mName;
        } else {
            str = null;
        }
        equals$default = StringsKt__StringsJVMKt.equals$default(str, steps, false, 2, null);
        if (equals$default) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        LinkedList<LinearGroup> mWaitingModes = this.D;
        Intrinsics.checkNotNullExpressionValue(mWaitingModes, "mWaitingModes");
        synchronized (mWaitingModes) {
            arrayList.addAll(G.D);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((LinearGroup) it.next()).mName.equals(steps)) {
                return true;
            }
        }
        return false;
    }
}
