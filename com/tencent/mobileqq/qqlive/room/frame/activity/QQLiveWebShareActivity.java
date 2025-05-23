package com.tencent.mobileqq.qqlive.room.frame.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.af;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.x;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.mobileqq.webviewplugin.n;
import com.tencent.mobileqq.webviewplugin.r;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tenpay.realname.RealNameSource;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\b\b\u0016\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J:\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0016J\u0015\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0017H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019JX\u0010!\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\"\u001a\u00020\u000fH\u0016J\n\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\bH\u0014J\b\u0010'\u001a\u00020\bH\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010*\u001a\u0004\u0018\u00010)H\u0016J\b\u0010+\u001a\u00020\rH\u0016J\b\u0010,\u001a\u00020\bH\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020)H\u0016J\b\u00101\u001a\u000200H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\n\u00105\u001a\u0004\u0018\u000104H\u0016J\"\u0010=\u001a\u00020<2\u0006\u00107\u001a\u0002062\b\u00109\u001a\u0004\u0018\u0001082\u0006\u0010;\u001a\u00020:H\u0016J\u0018\u0010>\u001a\u00020<2\u0006\u00107\u001a\u0002062\u0006\u0010;\u001a\u00020:H\u0016J\"\u0010A\u001a\u00020\b2\u0006\u0010;\u001a\u00020<2\u0006\u0010?\u001a\u00020<2\b\u0010@\u001a\u0004\u0018\u000108H\u0014R\u0018\u0010D\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010M\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/frame/activity/QQLiveWebShareActivity;", "Lcom/tencent/mobileqq/activity/QPublicFragmentActivityForTool;", "Lcom/tencent/mobileqq/webviewplugin/n;", "Lcom/tencent/mobileqq/webviewplugin/r;", "Lcom/tencent/mobileqq/webview/swift/component/b$e;", "Lcom/tencent/mobileqq/webview/swift/af;", "Lcom/tencent/mobileqq/webview/swift/component/b;", "createComponentsProvider", "", "F2", Constants.MMCCID, "Landroid/os/Bundle;", mqq.app.Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "", "url", "setShareUrl", "title", "desc", "thumb", "extradata", "setSummary", "T", "getShare", "()Ljava/lang/Object;", "publicUin", "summary", "targetUrl", "imageUrl", RealNameSource.EXTRA_KEY_SOURCE_NAME, "needback", "callback", "shareStructMsgForH5", "getShareUrl", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "getSharePD", "destroy", "doOnDestroy", "reset", "getCurrentUrl", "Lcom/tencent/biz/pubaccount/CustomWebView;", "getWebView", "isActivityResume", "showActionSheet", "I2", "webView", "H2", "Landroid/app/Activity;", "getHostActivity", "Lcom/tencent/smtt/sdk/WebView;", "getHostWebView", "Lcom/tencent/mobileqq/webview/swift/WebViewProvider;", "getWebViewProvider", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Landroid/content/Intent;", "intent", "", "requestCode", "", "pluginStartActivityForResult", "switchRequestCode", QzoneIPCModule.RESULT_CODE, "data", "doOnActivityResult", "a0", "Lcom/tencent/mobileqq/webviewplugin/n;", "webShareInterface", "b0", "Ljava/lang/String;", "liveWebViewUrl", "c0", "Lcom/tencent/biz/pubaccount/CustomWebView;", "liveWebView", "d0", "Lcom/tencent/mobileqq/webview/swift/component/b;", "swiftBrowserComponentProvider", "", "e0", "J", "rulesFromUrl", "<init>", "()V", "f0", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class QQLiveWebShareActivity extends QPublicFragmentActivityForTool implements n, r, b.e, af {
    static IPatchRedirector $redirector_;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private n webShareInterface;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String liveWebViewUrl;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CustomWebView liveWebView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b swiftBrowserComponentProvider;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private long rulesFromUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/frame/activity/QQLiveWebShareActivity$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.frame.activity.QQLiveWebShareActivity$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24633);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveWebShareActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.swiftBrowserComponentProvider = createComponentsProvider();
            this.rulesFromUrl = 8996L;
        }
    }

    private final void F2() {
        WebViewPluginEngine webViewPluginEngine;
        ViewParent viewParent;
        ViewParent viewParent2;
        String str;
        n nVar = this.webShareInterface;
        if (nVar != null) {
            nVar.destroy();
        }
        CustomWebView customWebView = this.liveWebView;
        if (customWebView != null) {
            webViewPluginEngine = customWebView.getPluginEngine();
        } else {
            webViewPluginEngine = null;
        }
        if (webViewPluginEngine != null) {
            CustomWebView customWebView2 = this.liveWebView;
            if (customWebView2 != null) {
                str = customWebView2.getUrl();
            } else {
                str = null;
            }
            webViewPluginEngine.s(str, 8589934596L, null);
        }
        if (webViewPluginEngine != null) {
            webViewPluginEngine.H();
        }
        CustomWebView customWebView3 = this.liveWebView;
        if (customWebView3 != null) {
            customWebView3.setPluginEngine(null);
        }
        CustomWebView customWebView4 = this.liveWebView;
        if (customWebView4 != null) {
            viewParent = customWebView4.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null) {
            try {
                CustomWebView customWebView5 = this.liveWebView;
                if (customWebView5 != null) {
                    viewParent2 = customWebView5.getParent();
                } else {
                    viewParent2 = null;
                }
                Intrinsics.checkNotNull(viewParent2, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) viewParent2).removeView(this.liveWebView);
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQLiveWebShareActivity", 2, "remove webview error");
                }
            }
        }
        try {
            CustomWebView customWebView6 = this.liveWebView;
            if (customWebView6 != null) {
                customWebView6.stopLoading();
            }
        } catch (Exception unused2) {
        }
        CustomWebView customWebView7 = this.liveWebView;
        if (customWebView7 != null) {
            customWebView7.loadUrlOriginal("about:blank");
        }
        CustomWebView customWebView8 = this.liveWebView;
        if (customWebView8 != null) {
            customWebView8.clearView();
        }
        CustomWebView customWebView9 = this.liveWebView;
        if (customWebView9 != null) {
            customWebView9.setWebChromeClient(null);
        }
        CustomWebView customWebView10 = this.liveWebView;
        if (customWebView10 != null) {
            customWebView10.setWebViewClient(null);
        }
        CustomWebView customWebView11 = this.liveWebView;
        if (customWebView11 != null) {
            customWebView11.destroy();
        }
        this.liveWebView = null;
    }

    private final n G2() {
        if (this.webShareInterface == null) {
            n b16 = ((x) aa.k(x.class)).b(getAppRuntime(), super.getActivity());
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface");
            this.webShareInterface = b16;
        }
        return this.webShareInterface;
    }

    private final b createComponentsProvider() {
        return new b(this, 575, null);
    }

    public void H2(@NotNull CustomWebView webView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) webView);
        } else {
            Intrinsics.checkNotNullParameter(webView, "webView");
            this.liveWebView = webView;
        }
    }

    public void I2(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) url);
        } else {
            Intrinsics.checkNotNullParameter(url, "url");
            this.liveWebViewUrl = url;
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, mqq.app.AppActivity
    public void doOnActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        WebViewPluginEngine webViewPluginEngine;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.doOnActivityResult(requestCode, resultCode, data);
        int d16 = i.d(requestCode);
        int c16 = i.c(requestCode);
        if (c16 <= 0 || getWebView() == null) {
            return;
        }
        CustomWebView customWebView = this.liveWebView;
        WebViewPlugin webViewPlugin = null;
        if (customWebView != null) {
            webViewPluginEngine = customWebView.getPluginEngine();
        } else {
            webViewPluginEngine = null;
        }
        if (webViewPluginEngine != null) {
            webViewPlugin = webViewPluginEngine.l(c16, true);
        }
        if (webViewPlugin != null) {
            webViewPlugin.onActivityResult(data, (byte) d16, resultCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState)).booleanValue();
        }
        getIntent().putExtra("big_brother_source_key", "biz_src_jc_qqlive");
        return super.doOnCreate(savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.doOnDestroy();
            F2();
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    @Nullable
    public String getCurrentUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.liveWebViewUrl;
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    @NotNull
    public Activity getHostActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Activity) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    @Nullable
    public WebView getHostWebView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (WebView) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.liveWebView;
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public <T> T getShare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return (T) G2();
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    @Nullable
    public QQProgressDialog getSharePD() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QQProgressDialog) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        G2();
        n nVar = this.webShareInterface;
        if (nVar == null) {
            return null;
        }
        Intrinsics.checkNotNull(nVar);
        return nVar.getSharePD();
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    @NotNull
    public String getShareUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        G2();
        n nVar = this.webShareInterface;
        if (nVar == null) {
            return "";
        }
        Intrinsics.checkNotNull(nVar);
        String shareUrl = nVar.getShareUrl();
        Intrinsics.checkNotNullExpressionValue(shareUrl, "webShareInterface!!.shareUrl");
        return shareUrl;
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    @Nullable
    public CustomWebView getWebView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (CustomWebView) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.liveWebView;
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    @Nullable
    public WebViewProvider getWebViewProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (WebViewProvider) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    public boolean isActivityResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return isResume();
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.webview.swift.af
    public int pluginStartActivityForResult(@NotNull WebViewPlugin plugin, @Nullable Intent intent, byte requestCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, this, plugin, intent, Byte.valueOf(requestCode))).intValue();
        }
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        int switchRequestCode = switchRequestCode(plugin, requestCode);
        if (switchRequestCode == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveWebShareActivity", 2, "pluginStartActivityForResult not handled");
            }
        } else {
            startActivityForResult(intent, switchRequestCode);
        }
        return switchRequestCode;
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        G2();
        n nVar = this.webShareInterface;
        if (nVar != null) {
            nVar.reset();
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean setShareUrl(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url)).booleanValue();
        }
        G2();
        n nVar = this.webShareInterface;
        if (nVar == null) {
            return false;
        }
        Intrinsics.checkNotNull(nVar);
        return nVar.setShareUrl(url);
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean setSummary(@Nullable String title, @Nullable String desc, @Nullable String url, @Nullable String thumb, @Nullable Bundle extradata) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, title, desc, url, thumb, extradata)).booleanValue();
        }
        G2();
        n nVar = this.webShareInterface;
        if (nVar == null) {
            return false;
        }
        Intrinsics.checkNotNull(nVar);
        return nVar.setSummary(title, desc, url, thumb, extradata);
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean shareStructMsgForH5(@Nullable String publicUin, @Nullable String title, @Nullable String summary, @Nullable String targetUrl, @Nullable String imageUrl, @Nullable String sourceName, @Nullable String needback, @Nullable String callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, publicUin, title, summary, targetUrl, imageUrl, sourceName, needback, callback)).booleanValue();
        }
        G2();
        n nVar = this.webShareInterface;
        if (nVar == null) {
            return false;
        }
        Intrinsics.checkNotNull(nVar);
        return nVar.shareStructMsgForH5(publicUin, title, summary, targetUrl, imageUrl, sourceName, needback, callback);
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    public void showActionSheet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            ((x) aa.k(x.class)).c((b.C8976b) this.swiftBrowserComponentProvider.a(4), this.rulesFromUrl, G2());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.af
    public int switchRequestCode(@NotNull WebViewPlugin plugin, byte requestCode) {
        int a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, this, plugin, Byte.valueOf(requestCode))).intValue();
        }
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        CustomWebView e16 = plugin.mRuntime.e();
        if (e16 == null || e16.getPluginEngine() == null || (a16 = ao.a(plugin)) == -1) {
            return -1;
        }
        return ((a16 << 8) & 65280) | 0 | (requestCode & 255);
    }
}
