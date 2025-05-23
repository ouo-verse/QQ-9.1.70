package com.tencent.mobileqq.webview.html;

import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH&Jb\u0010\u0017\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0015H&J\"\u0010\u001c\u001a\u00020\u001b2\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u0018H&J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\tH&J\b\u0010 \u001a\u00020\u0004H&J\n\u0010\"\u001a\u0004\u0018\u00010!H&\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/webview/html/l;", "", "Lcom/tencent/mobileqq/webview/html/HtmlSession;", SessionDbHelper.SESSION_ID, "", "f", "Lcom/tencent/biz/pubaccount/CustomWebView;", "webView", "d", "", "url", "b", "Landroid/os/Bundle;", "bundle", "a", "baseUrl", "data", "mimeType", "encoding", "historyUrl", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "headers", "g", "", "", "rspHeaders", "", "c", "shouldInterceptRequest", "newUrl", tl.h.F, "destroy", "Lcom/tencent/mobileqq/webview/html/o;", "e", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface l {
    void a(@Nullable String url, @Nullable Bundle bundle);

    void b(@NotNull String url);

    boolean c(@NotNull Map<String, ? extends List<String>> rspHeaders);

    void d(@NotNull CustomWebView webView);

    void destroy();

    @Nullable
    o e();

    void f(@NotNull HtmlSession session);

    void g(@Nullable String baseUrl, @Nullable String data, @Nullable String mimeType, @Nullable String encoding, @Nullable String historyUrl, @Nullable HashMap<String, String> headers);

    void h(@NotNull String newUrl);

    @Nullable
    Object shouldInterceptRequest(@NotNull String url);
}
