package go1;

import android.content.Context;
import com.tencent.mobileqq.guild.feed.webbundle.impl.GuildWebBundleWebViewImpl;
import com.tencent.mobileqq.guild.feed.webbundle.s;
import com.tencent.mobileqq.guild.feed.webbundle.t;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.smtt.sdk.WebSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"Lgo1/a;", "Lcom/tencent/mobileqq/guild/feed/webbundle/s;", "Landroid/content/Context;", "getContext", "context", "Lcom/tencent/mobileqq/guild/feed/webbundle/t;", "a", "", "destroy", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements s {
    @Override // com.tencent.mobileqq.guild.feed.webbundle.s
    @NotNull
    public t a(@NotNull Context context) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        GuildWebBundleWebViewImpl guildWebBundleWebViewImpl = new GuildWebBundleWebViewImpl(context);
        WebSettings settings = guildWebBundleWebViewImpl.getSettings();
        String userAgentString = settings.getUserAgentString();
        if (guildWebBundleWebViewImpl.getX5WebViewExtension() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        settings.setUserAgentString(i.n(userAgentString, "Guild", z16));
        return guildWebBundleWebViewImpl;
    }

    @Override // com.tencent.mobileqq.guild.feed.webbundle.s
    @NotNull
    public Context getContext() {
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
        return applicationContext;
    }

    @Override // com.tencent.mobileqq.guild.feed.webbundle.s
    public void destroy() {
    }
}
