package com.tencent.mobileqq.remoteweb.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.mobileqq.webview.util.m;
import com.tencent.mobileqq.wifiphoto.fragment.RequestApplyFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 42\u00020\u00012\u00020\u0002:\u0001\u001cB!\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00101\u001a\u000200\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0015\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J.\u0010\u001a\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u001a\u0010 \u001a\u00020\u00058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020\u00108\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$RN\u0010-\u001a6\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100'0&j\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100'`(8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/e;", "Lcom/tencent/mobileqq/webview/AbsWebView;", "Lcom/tencent/mobileqq/webview/util/m;", "", "buildBottomBar", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "buildContentView", "buildData", "buildLayout", "buildTitleBar", "Lmqq/app/AppRuntime;", "mApp", "buildWebView", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "onPageFinished", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "", "errorCode", "description", "failingUrl", "onReceivedError", "preInitWebviewPlugin", "a", "Landroid/os/Bundle;", "getExtraInfo", "()Landroid/os/Bundle;", "extraInfo", "b", "Ljava/lang/String;", "getMWebPageId", "()Ljava/lang/String;", "mWebPageId", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "getMErrors", "()Ljava/util/HashMap;", "mErrors", "Landroid/app/Activity;", "inActivity", "Lcom/tencent/biz/ui/TouchWebView;", "webView", "<init>", "(Landroid/app/Activity;Lcom/tencent/biz/ui/TouchWebView;Landroid/os/Bundle;)V", "d", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class e extends AbsWebView implements m {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle extraInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mWebPageId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Pair<Integer, String>> mErrors;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.remoteweb.view.e$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39810);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull Activity inActivity, @NotNull TouchWebView webView, @NotNull Bundle extraInfo) {
        super(inActivity, inActivity, i.g("modular_web"));
        Intrinsics.checkNotNullParameter(inActivity, "inActivity");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, inActivity, webView, extraInfo);
            return;
        }
        this.extraInfo = extraInfo;
        this.mErrors = new HashMap<>();
        this.mWebview = webView;
        String string = extraInfo.getString("key_web_page_id", "");
        Intrinsics.checkNotNullExpressionValue(string, "extraInfo.getString(Remo\u2026ants.KEY_WEB_PAGE_ID, \"\")");
        this.mWebPageId = string;
        webView.setTag(R.id.f72813rv, string);
        buildBaseWebView(null);
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildBottomBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildContentView(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) savedInstanceState);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildTitleBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildWebView(@Nullable AppRuntime mApp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) mApp);
        }
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onPageFinished(@Nullable WebView view, @Nullable String url) {
        String str;
        int i3;
        int[] intArray;
        String second;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view, (Object) url);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RemoteWeb.RemoteRenderWebView", 1, "onPageFinished: url: " + url);
        }
        RemoteWebRenderIPCClient a16 = RemoteWebRenderIPCClient.INSTANCE.a();
        String str2 = this.mWebPageId;
        RemoteWebViewEvent remoteWebViewEvent = RemoteWebViewEvent.ON_PAGE_FINISH;
        Bundle bundle = new Bundle();
        String str3 = "";
        if (url == null) {
            str = "";
        } else {
            str = url;
        }
        bundle.putString("ON_PAGE_FINISH_URL", str);
        Pair<Integer, String> pair = this.mErrors.get(url);
        if (pair != null) {
            i3 = pair.getFirst().intValue();
        } else {
            i3 = 0;
        }
        bundle.putInt(RequestApplyFragment.ERROR_CODE, i3);
        Pair<Integer, String> pair2 = this.mErrors.get(url);
        if (pair2 != null && (second = pair2.getSecond()) != null) {
            str3 = second;
        }
        bundle.putString("ERROR_MESSAGE", str3);
        boolean[] zArr = {getWebView().canScrollVertically(-1), getWebView().canScrollVertically(1), getWebView().canScrollHorizontally(-1), getWebView().canScrollHorizontally(1)};
        ArrayList arrayList = new ArrayList(4);
        for (int i16 = 0; i16 < 4; i16++) {
            arrayList.add(Integer.valueOf(zArr[i16] ? 1 : 0));
        }
        intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        bundle.putIntArray("CAN_SCROLL_INIT_DATA", intArray);
        Unit unit = Unit.INSTANCE;
        a16.S(str2, remoteWebViewEvent, bundle);
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onPageStarted(@Nullable WebView view, @Nullable String url, @Nullable Bitmap favicon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, view, url, favicon);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RemoteWeb.RemoteRenderWebView", 1, "onPageStarted: url: " + url);
        }
        TypeIntrinsics.asMutableMap(this.mErrors).remove(url);
        RemoteWebRenderIPCClient.T(RemoteWebRenderIPCClient.INSTANCE.a(), this.mWebPageId, RemoteWebViewEvent.ON_PAGE_STARTED, null, 4, null);
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onReceivedError(@Nullable WebView view, int errorCode, @Nullable String description, @Nullable String failingUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, view, Integer.valueOf(errorCode), description, failingUrl);
            return;
        }
        QLog.e("RemoteWeb.RemoteRenderWebView", 1, "onReceivedError: " + errorCode + " " + description + " url: " + failingUrl);
        if (failingUrl != null) {
            HashMap<String, Pair<Integer, String>> hashMap = this.mErrors;
            Integer valueOf = Integer.valueOf(errorCode);
            if (description == null) {
                description = "";
            }
            hashMap.put(failingUrl, new Pair<>(valueOf, description));
        }
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void preInitWebviewPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }
}
