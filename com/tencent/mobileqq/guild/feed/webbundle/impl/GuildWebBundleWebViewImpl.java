package com.tencent.mobileqq.guild.feed.webbundle.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.guild.feed.webbundle.GuildWebBundleManager;
import com.tencent.mobileqq.guild.feed.webbundle.impl.GuildWebBundleWebViewImpl;
import com.tencent.mobileqq.guild.feed.webbundle.k;
import com.tencent.mobileqq.guild.feed.webbundle.p;
import com.tencent.mobileqq.guild.feed.webbundle.q;
import com.tencent.mobileqq.guild.feed.webbundle.t;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001-B\u000f\u0012\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+J\u0016\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\"\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u001a\u0010\u001d\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016R\u001c\u0010\"\u001a\n \u001f*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010'\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/feed/webbundle/impl/GuildWebBundleWebViewImpl;", "Lcom/tencent/biz/ui/TouchWebView;", "Lcom/tencent/mobileqq/guild/feed/webbundle/t;", "", "", "arrayList", ReportConstant.COSTREPORT_PREFIX, "", "enable", "", "enableJavaScript", "Lcom/tencent/mobileqq/guild/feed/webbundle/q;", "listener", "setOnPageFinishedListener", AdMetricTag.EVENT_NAME, "Lorg/json/JSONObject;", "data", "source", "dispatchJsEvent", "url", "setRealUrl", "getUrl", "getThemeId", "isHit", "setIsHitFeedJson", DomainData.DOMAIN_NAME, "jsMethod", "Lcom/tencent/mobileqq/guild/feed/webbundle/p;", "listen", "o", DKWebViewController.DKHippyWebviewFunction.CAN_GO_BACK, "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "themeId", "D", "realUrl", "E", "Z", "isHitJson", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildWebBundleWebViewImpl extends TouchWebView implements t {

    /* renamed from: C, reason: from kotlin metadata */
    private final String themeId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String realUrl;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isHitJson;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/webbundle/impl/GuildWebBundleWebViewImpl$b", "Lcom/tencent/smtt/sdk/WebViewClient;", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "", "onPageFinished", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends WebViewClient {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f224106b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildWebBundleWebViewImpl f224107c;

        b(q qVar, GuildWebBundleWebViewImpl guildWebBundleWebViewImpl) {
            this.f224106b = qVar;
            this.f224107c = guildWebBundleWebViewImpl;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(@NotNull WebView view, @NotNull String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            this.f224106b.a(this.f224107c, url);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildWebBundleWebViewImpl(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.themeId = ThemeUtil.getCurrentThemeId();
        this.realUrl = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(p listen, String it) {
        Intrinsics.checkNotNullParameter(listen, "$listen");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        listen.a(it);
    }

    private final String s(List<String> arrayList) {
        boolean contains$default;
        List split$default;
        for (String str : arrayList) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "QQTheme", false, 2, (Object) null);
            if (contains$default) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"/"}, false, 0, 6, (Object) null);
                if ((!split$default.isEmpty()) && split$default.size() >= 2) {
                    return (String) split$default.get(1);
                }
            }
        }
        return "unknown";
    }

    @Override // com.tencent.smtt.sdk.WebView
    public boolean canGoBack() {
        ArrayList<String> arrayList;
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        if (copyBackForwardList != null && copyBackForwardList.getSize() != 0) {
            WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(0);
            if (itemAtIndex != null) {
                String url = itemAtIndex.getUrl();
                k p16 = GuildWebBundleManager.INSTANCE.a().p();
                if (p16 == null || (arrayList = p16.c()) == null) {
                    arrayList = new ArrayList<>();
                }
                if (!TextUtils.isEmpty(url) && arrayList.contains(url)) {
                    Logger.f235387a.d().d("GuildWebBundleWebViewImpl", 1, "multi history list, so break and return!");
                    return super.canGoBackOrForward(-2);
                }
            }
            return super.canGoBack();
        }
        return super.canGoBack();
    }

    @Override // com.tencent.mobileqq.guild.feed.webbundle.t
    public void dispatchJsEvent(@NotNull String eventName, @NotNull JSONObject data, @Nullable JSONObject source) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        callJs(WebViewPlugin.toJsScript(eventName, data, source));
    }

    @Override // com.tencent.mobileqq.guild.feed.webbundle.t
    public void enableJavaScript(boolean enable) {
        getSettings().setJavaScriptEnabled(enable);
    }

    @Override // com.tencent.mobileqq.guild.feed.webbundle.t
    @NotNull
    public String getThemeId() {
        List<String> split$default;
        WebSettings settings = getSettings();
        if (settings != null) {
            String ua5 = settings.getUserAgentString();
            if (TextUtils.isEmpty(ua5)) {
                String themeId = this.themeId;
                Intrinsics.checkNotNullExpressionValue(themeId, "themeId");
                return themeId;
            }
            Intrinsics.checkNotNullExpressionValue(ua5, "ua");
            split$default = StringsKt__StringsKt.split$default((CharSequence) ua5, new String[]{" "}, false, 0, 6, (Object) null);
            if (!split$default.isEmpty()) {
                return s(split$default);
            }
        }
        String themeId2 = this.themeId;
        Intrinsics.checkNotNullExpressionValue(themeId2, "themeId");
        return themeId2;
    }

    @Override // com.tencent.smtt.sdk.WebView
    @Nullable
    public String getUrl() {
        boolean z16;
        String str = this.realUrl;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return super.getUrl();
        }
        return str;
    }

    @Override // com.tencent.mobileqq.guild.feed.webbundle.t
    /* renamed from: n, reason: from getter */
    public boolean getIsHitJson() {
        return this.isHitJson;
    }

    @Override // com.tencent.mobileqq.guild.feed.webbundle.t
    public void o(@Nullable String jsMethod, @NotNull final p listen) {
        Intrinsics.checkNotNullParameter(listen, "listen");
        evaluateJavascript(jsMethod, new ValueCallback() { // from class: go1.b
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                GuildWebBundleWebViewImpl.r(p.this, (String) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.webbundle.t
    public void setIsHitFeedJson(boolean isHit) {
        this.isHitJson = isHit;
    }

    @Override // com.tencent.mobileqq.guild.feed.webbundle.t
    public void setOnPageFinishedListener(@NotNull q listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        setWebViewClient(new b(listener, this));
    }

    @Override // com.tencent.mobileqq.guild.feed.webbundle.t
    public void setRealUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.realUrl = url;
    }
}
