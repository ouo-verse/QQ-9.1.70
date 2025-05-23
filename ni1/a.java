package ni1;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.guild.discoveryv2.widget.webview.DiscoverNestedWebView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.z;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lni1/a;", "Lcom/tencent/mobileqq/webview/swift/WebViewWrapper;", "Landroid/content/Context;", "context", "", "useWebViewPool", "Lcom/tencent/biz/ui/TouchWebView;", h.F, "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/webview/swift/z;", "webViewCallback", "<init>", "(Landroid/content/Context;Landroid/content/Intent;ZLcom/tencent/mobileqq/webview/swift/z;)V", "j", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends WebViewWrapper {
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
        Intrinsics.checkNotNullParameter(context, "context");
        s.a(AbsBaseWebViewActivity.WEBVIEW_BROWSER_INIT_WEBVIEW);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoverCustomWebWrapper", "[init webview] start create webview");
        }
        long currentTimeMillis = System.currentTimeMillis();
        DiscoverNestedWebView discoverNestedWebView = new DiscoverNestedWebView(context, null, 0, 6, null);
        DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        ViewGroup.LayoutParams layoutParams = discoverNestedWebView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            layoutParams.width = displayMetrics.widthPixels;
            layoutParams.height = displayMetrics.heightPixels;
        }
        discoverNestedWebView.setLayoutParams(layoutParams);
        this.f314159f = System.currentTimeMillis() - currentTimeMillis;
        Logger.f235387a.d().d("DiscoverCustomWebWrapper", 1, "[createWebView] mWebViewCreateTime " + this.f314159f);
        return discoverNestedWebView;
    }
}
