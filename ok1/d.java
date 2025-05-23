package ok1;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.guild.feed.webbundle.t;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0000\u00a8\u0006\u0007"}, d2 = {"Lok1/c;", "", "nameSpace", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "a", "Lcom/tencent/mobileqq/guild/feed/webbundle/t;", "b", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {
    @Nullable
    public static final WebViewPlugin a(@NotNull c cVar, @NotNull String nameSpace) {
        CustomWebView e16;
        WebViewPluginEngine pluginEngine;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(nameSpace, "nameSpace");
        WebViewPlugin.b bVar = cVar.mRuntime;
        if (bVar != null && (e16 = bVar.e()) != null && (pluginEngine = e16.getPluginEngine()) != null) {
            return pluginEngine.m(nameSpace);
        }
        return null;
    }

    @Nullable
    public static final t b(@NotNull c cVar) {
        CustomWebView customWebView;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        WebViewPlugin.b bVar = cVar.mRuntime;
        if (bVar != null) {
            customWebView = bVar.e();
        } else {
            customWebView = null;
        }
        if (!(customWebView instanceof t)) {
            return null;
        }
        return (t) customWebView;
    }
}
