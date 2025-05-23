package com.tencent.mobileqq.guild.media.thirdapp.container.webview;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.GuildOpenWebViewJsPlugin;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001\bB!\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\r\u001a\u00020\u00042\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u0015\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/l;", "Lcom/tencent/mobileqq/remoteweb/view/e;", "", "url", "", "b", "", "hasRes", "a", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "Lkotlin/collections/ArrayList;", "pluginList", "bindJavaScript", "Lcom/tencent/smtt/sdk/WebView;", "view", "onPageFinished", "", "doInterceptRequest", "Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;", "res", "notifyLocalInterceptRequest", "Ljava/util/concurrent/ConcurrentHashMap;", "", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "offlineResCostTimeMap", "Landroid/app/Activity;", "inActivity", "Lcom/tencent/biz/ui/TouchWebView;", "webView", "Landroid/os/Bundle;", "extraInfo", "<init>", "(Landroid/app/Activity;Lcom/tencent/biz/ui/TouchWebView;Landroid/os/Bundle;)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class l extends com.tencent.mobileqq.remoteweb.view.e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConcurrentHashMap<String, Long> offlineResCostTimeMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull Activity inActivity, @NotNull TouchWebView webView, @NotNull Bundle extraInfo) {
        super(inActivity, webView, extraInfo);
        Intrinsics.checkNotNullParameter(inActivity, "inActivity");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.offlineResCostTimeMap = new ConcurrentHashMap<>();
    }

    private final void a(String url, boolean hasRes) {
        if (this.offlineResCostTimeMap.containsKey(url) && hasRes) {
            Long l3 = this.offlineResCostTimeMap.get(url);
            if (l3 == null) {
                l3 = -1L;
            }
            long currentTimeMillis = System.currentTimeMillis() - l3.longValue();
            Logger.f235387a.d().d("GuildMediaWebViewBuilder", 1, "notifyOfflineResCompleted " + url + ", time=" + currentTimeMillis);
            if (currentTimeMillis > 0 && currentTimeMillis < 60000) {
                GuildMediaWebIPCClient.INSTANCE.a().m(new ToolProcessIntent.NotifyOfflineResCompleted(url, currentTimeMillis));
                this.offlineResCostTimeMap.remove(url);
                return;
            }
            return;
        }
        this.offlineResCostTimeMap.remove(url);
    }

    private final void b(String url) {
        this.offlineResCostTimeMap.put(url, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void bindJavaScript(@Nullable ArrayList<WebViewPlugin> pluginList) {
        super.bindJavaScript(pluginList);
        if (pluginList != null) {
            pluginList.add(new GuildOpenWebViewJsPlugin());
        }
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    @Nullable
    public Object doInterceptRequest(@Nullable WebView view, @Nullable String url) {
        if (url != null) {
            b(url);
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    protected void notifyLocalInterceptRequest(@Nullable WebView view, @Nullable String url, @Nullable WebResourceResponse res) {
        boolean z16;
        if (url != null) {
            if (res != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            a(url, z16);
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.view.e, com.tencent.mobileqq.webview.AbsWebView
    public void onPageFinished(@Nullable WebView view, @Nullable String url) {
        Logger.f235387a.d().d("GuildMediaWebViewBuilder", 1, "[onPageFinished] url " + url);
        super.onPageFinished(view, url);
    }
}
