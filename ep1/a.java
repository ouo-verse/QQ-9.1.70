package ep1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.z;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.sdk.WebViewCallbackClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lep1/a;", "Lcom/tencent/mobileqq/webview/swift/WebViewWrapper;", "Landroid/content/Context;", "context", "", "useWebViewPool", "Lcom/tencent/biz/ui/TouchWebView;", h.F, "webView", "Landroid/content/Intent;", "intent", "p", "Lcom/tencent/smtt/sdk/WebViewCallbackClient;", "j", "Lcom/tencent/smtt/sdk/WebViewCallbackClient;", "nestedCallBackClient", "Lcom/tencent/mobileqq/webview/swift/z;", "webViewCallback", "<init>", "(Landroid/content/Context;Landroid/content/Intent;ZLcom/tencent/mobileqq/webview/swift/z;)V", "k", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends WebViewWrapper {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private WebViewCallbackClient nestedCallBackClient;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, @NotNull Intent intent, boolean z16, @NotNull z webViewCallback) {
        super(webViewCallback, intent, context, z16);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(webViewCallback, "webViewCallback");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewWrapper
    @NotNull
    public TouchWebView h(@NotNull Context context, boolean useWebViewPool) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(context, "context");
        s.a(AbsBaseWebViewActivity.WEBVIEW_BROWSER_INIT_WEBVIEW);
        long currentTimeMillis = System.currentTimeMillis();
        TouchWebView touchWebView = new TouchWebView(context);
        this.nestedCallBackClient = new b(touchWebView.getView(), touchWebView);
        DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        Bundle extras = this.f314156c.getExtras();
        if (extras != null) {
            i3 = extras.getInt("guild_webview_width", displayMetrics.widthPixels);
        } else {
            i3 = displayMetrics.widthPixels;
        }
        Bundle extras2 = this.f314156c.getExtras();
        if (extras2 != null) {
            i16 = extras2.getInt("guild_webview_height", displayMetrics.heightPixels);
        } else {
            i16 = displayMetrics.heightPixels;
        }
        ViewGroup.LayoutParams layoutParams = touchWebView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(i3, i16);
        } else {
            layoutParams.width = i3;
            layoutParams.height = i16;
        }
        touchWebView.setLayoutParams(layoutParams);
        this.f314159f = System.currentTimeMillis() - currentTimeMillis;
        Logger.f235387a.d().d("GuildMainFrameCustomWebWrapper", 1, "[createWebView], cost=" + this.f314159f + ", width: " + i3 + ", height: " + i16);
        return touchWebView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewWrapper
    @NotNull
    public TouchWebView p(@Nullable TouchWebView webView, @Nullable Intent intent) {
        TouchWebView p16 = super.p(webView, intent);
        WebViewCallbackClient webViewCallbackClient = this.nestedCallBackClient;
        WebViewCallbackClient webViewCallbackClient2 = null;
        if (webViewCallbackClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nestedCallBackClient");
            webViewCallbackClient = null;
        }
        p16.setWebViewCallbackClient(webViewCallbackClient);
        WebViewCallbackClient webViewCallbackClient3 = this.nestedCallBackClient;
        if (webViewCallbackClient3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nestedCallBackClient");
        } else {
            webViewCallbackClient2 = webViewCallbackClient3;
        }
        p16.setWebViewClientExtension(new c(webViewCallbackClient2));
        Intrinsics.checkNotNullExpressionValue(p16, "super.initWebView(webVie\u2026CallBackClient)\n        }");
        return p16;
    }
}
