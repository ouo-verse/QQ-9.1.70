package com.tencent.mobileqq.remoteweb;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/ab;", "Lcom/tencent/mobileqq/webview/swift/d;", "Landroid/content/Intent;", "intent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "url", "", "navigateToAnotherActivity", "needSwitchFragment", "<init>", "()V", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ab implements com.tencent.mobileqq.webview.swift.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    private static final String f281143b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/ab$a;", "", "", "kotlin.jvm.PlatformType", "REMOTE_WEB_HOST", "Ljava/lang/String;", "TAG", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.remoteweb.ab$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39653);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
            f281143b = QQTranslucentBrowserActivity.class.getName();
        }
    }

    public ab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean navigateToAnotherActivity(@Nullable Intent intent, @NotNull Activity activity, @Nullable String url) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, intent, activity, url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (intent != null && intent.getBooleanExtra("key_enable_remote_web_render", false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        ComponentName component = intent.getComponent();
        if (component == null || (str = component.getClassName()) == null) {
            str = "";
        }
        boolean areEqual = Intrinsics.areEqual(str, f281143b);
        com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
        aVar.a().d("RemoteWebRenderNavigationItem", 1, "[navigateToAnotherActivity] goToRemoteWeb " + areEqual + ", targetClassName " + str + ", REMOTE_WEB_HOST " + f281143b);
        if (!areEqual) {
            return false;
        }
        aVar.a().d("RemoteWebRenderNavigationItem", 1, "[navigateToAnotherActivity] prepareCreateRemoteView");
        RemoteWebRenderIPCClient a16 = RemoteWebRenderIPCClient.INSTANCE.a();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        a16.W(activity, extras);
        activity.finish();
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean needSwitchFragment(@Nullable Intent intent, @Nullable Activity activity, @Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, intent, activity, url)).booleanValue();
        }
        return false;
    }
}
