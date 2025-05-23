package com.tencent.mobileqq.guild.feed.webbundle;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H&J\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0014\u001a\u00020\u0004H&J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H&J\b\u0010\u0016\u001a\u00020\u0007H&J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0002H&J\b\u0010\u0019\u001a\u00020\u0002H&J\u001a\u0010\u001d\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u001bH&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/webbundle/t;", "", "", "enable", "", "enableJavaScript", "obj", "", "name", "addJavascriptInterface", "Lcom/tencent/mobileqq/guild/feed/webbundle/q;", "listener", "setOnPageFinishedListener", "url", DKWebViewController.DKHippyWebviewFunction.LOAD_URL, AdMetricTag.EVENT_NAME, "Lorg/json/JSONObject;", "data", "source", "dispatchJsEvent", "destroy", "setRealUrl", "getThemeId", "isHit", "setIsHitFeedJson", DomainData.DOMAIN_NAME, "jsMethod", "Lcom/tencent/mobileqq/guild/feed/webbundle/p;", "listen", "o", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface t {
    void addJavascriptInterface(@NotNull Object obj, @NotNull String name);

    void destroy();

    void dispatchJsEvent(@NotNull String eventName, @NotNull JSONObject data, @Nullable JSONObject source);

    void enableJavaScript(boolean enable);

    @NotNull
    String getThemeId();

    void loadUrl(@NotNull String url);

    boolean n();

    void o(@Nullable String jsMethod, @NotNull p listen);

    void setIsHitFeedJson(boolean isHit);

    void setOnPageFinishedListener(@NotNull q listener);

    void setRealUrl(@NotNull String url);
}
