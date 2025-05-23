package com.tencent.mobileqq.guild.feed.webbundle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.v;
import com.tencent.util.UiThreadUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J$\u0010\n\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0014J\b\u0010\u0012\u001a\u00020\fH\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/webbundle/GuildFeedDetailWebBundleFragment;", "Lcom/tencent/mobileqq/guild/feed/detail/GuildFeedDetailWebViewFragment;", "Lcom/tencent/mobileqq/webview/swift/utils/t;", "createWebViewKernelCallBack", "", "defaultUA", "uaMark", "", "isX5", "onGetUserAgent", "isUserDDefaultUA", "targetUrl", "", "preloadCache", "useWebViewPool", "Lcom/tencent/mobileqq/webview/swift/WebViewWrapper;", "createWebViewWrapper", "interceptStartLoadUrl", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/feed/webbundle/j;", "guildWebBundle", "Lcom/tencent/mobileqq/guild/feed/webbundle/j;", "Lcom/tencent/mobileqq/guild/feed/webbundle/t;", "guildWebView", "Lcom/tencent/mobileqq/guild/feed/webbundle/t;", "<init>", "()V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedDetailWebBundleFragment extends GuildFeedDetailWebViewFragment {

    @NotNull
    private static final String TAG = "GuildFeedDetailWebBundleFragment";

    @NotNull
    private static final String UA_MARK = "Guild";

    @Nullable
    private j guildWebBundle;

    @Nullable
    private t guildWebView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J/\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/webbundle/GuildFeedDetailWebBundleFragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "", "getUAMark", "", "interceptUserAgentGenerate", "defaultUA", "uaMark", "isX5", DKWebViewController.DKHippyWebviewFunction.GET_USER_AGENT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/String;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        b(ak akVar) {
            super(akVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        @NotNull
        public String getUAMark() {
            return GuildFeedDetailWebBundleFragment.UA_MARK;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        @Nullable
        public String getUserAgent(@Nullable String defaultUA, @Nullable String uaMark, @Nullable Boolean isX5) {
            GuildFeedDetailWebBundleFragment guildFeedDetailWebBundleFragment = GuildFeedDetailWebBundleFragment.this;
            Intrinsics.checkNotNull(isX5);
            return guildFeedDetailWebBundleFragment.onGetUserAgent(defaultUA, uaMark, isX5.booleanValue());
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public boolean interceptUserAgentGenerate() {
            return true;
        }
    }

    private final com.tencent.mobileqq.webview.swift.utils.t createWebViewKernelCallBack() {
        return new b(this.webViewSurface);
    }

    private final boolean isUserDDefaultUA(String defaultUA, String uaMark, boolean isX5) {
        boolean contains$default;
        boolean contains$default2;
        String webpVersion = ((v) aa.k(v.class)).a(isX5);
        if (defaultUA != null && uaMark != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) defaultUA, (CharSequence) uaMark, false, 2, (Object) null);
            if (!contains$default) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(webpVersion, "webpVersion");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) defaultUA, (CharSequence) webpVersion, false, 2, (Object) null);
            if (!contains$default2) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String onGetUserAgent(String defaultUA, String uaMark, boolean isX5) {
        String resultUA = com.tencent.mobileqq.webview.swift.utils.i.n(defaultUA, uaMark, isX5);
        if (isUserDDefaultUA(defaultUA, uaMark, isX5)) {
            resultUA = defaultUA;
        }
        Logger.f235387a.d().i(TAG, 1, "getSettingUA uaMark=" + uaMark + " \n resultUA=" + ((Object) resultUA) + " \n defaultUA=" + defaultUA);
        Intrinsics.checkNotNullExpressionValue(resultUA, "resultUA");
        return resultUA;
    }

    private final void preloadCache(final String targetUrl) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.webbundle.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedDetailWebBundleFragment.preloadCache$lambda$11(targetUrl, this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadCache$lambda$11(final String targetUrl, final GuildFeedDetailWebBundleFragment this$0) {
        GuildFeedDetailInitBean guildFeedDetailInitBean;
        long j3;
        final int i3;
        Intrinsics.checkNotNullParameter(targetUrl, "$targetUrl");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final String queryParameter = Uri.parse(targetUrl).getQueryParameter("feedId");
        GuildFeedBaseInitBean guildFeedBaseInitBean = this$0.mInitBean;
        if (guildFeedBaseInitBean instanceof GuildFeedDetailInitBean) {
            guildFeedDetailInitBean = (GuildFeedDetailInitBean) guildFeedBaseInitBean;
        } else {
            guildFeedDetailInitBean = null;
        }
        if (guildFeedDetailInitBean != null) {
            j3 = guildFeedDetailInitBean.getLastModifiedTime();
        } else {
            j3 = 0;
        }
        String q16 = GuildFeedDetailDataCacheManager.y().q(queryParameter, j3);
        if (q16 == null) {
            q16 = "";
        }
        boolean z16 = true;
        Logger.f235387a.d().i(TAG, 1, "preloadCache FeedWebBundle== feedJson=" + q16);
        if (q16.length() != 0) {
            z16 = false;
        }
        if (z16) {
            i3 = -1;
        } else {
            i3 = 0;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", targetUrl);
        jSONObject.put("feedId", queryParameter);
        jSONObject.put("feedJson", q16);
        final JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("code", i3);
        jSONObject2.put("data", jSONObject);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.webbundle.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedDetailWebBundleFragment.preloadCache$lambda$11$lambda$10(GuildFeedDetailWebBundleFragment.this, i3, targetUrl, jSONObject2, queryParameter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadCache$lambda$11$lambda$10(GuildFeedDetailWebBundleFragment this$0, int i3, String targetUrl, JSONObject resultJson, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(targetUrl, "$targetUrl");
        Intrinsics.checkNotNullParameter(resultJson, "$resultJson");
        t tVar = this$0.guildWebView;
        boolean z17 = false;
        if (tVar != null) {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            tVar.setIsHitFeedJson(z16);
        }
        j jVar = this$0.guildWebBundle;
        if (jVar != null) {
            jVar.w(targetUrl, resultJson);
        }
        Logger.a d16 = Logger.f235387a.d();
        if (this$0.guildWebBundle != null) {
            z17 = true;
        }
        d16.d(TAG, 1, "[preloadCache] [" + str + "], FeedWebBundle== guildWebBundle is  [" + z17 + "], preloadCode " + i3 + ", ");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @Nullable
    public WebViewWrapper createWebViewWrapper(boolean useWebViewPool) {
        t tVar;
        t tVar2;
        GuildWebBundleManager a16 = GuildWebBundleManager.INSTANCE.a();
        Activity hostActivity = getHostActivity();
        Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
        j o16 = GuildWebBundleManager.o(a16, hostActivity, null, 2, null);
        this.guildWebBundle = o16;
        if (o16 != null) {
            tVar = o16.getWebView();
        } else {
            tVar = null;
        }
        this.guildWebView = tVar;
        String stringExtra = this.intent.getStringExtra("url");
        Logger.f235387a.d().d(TAG, 1, "createWebViewWrapper FeedWebBundle== realUrl=" + stringExtra + " guildWebView=" + this.guildWebView);
        if (!TextUtils.isEmpty(stringExtra) && (tVar2 = this.guildWebView) != null) {
            Intrinsics.checkNotNull(stringExtra);
            tVar2.setRealUrl(stringExtra);
        }
        if (this.guildWebView instanceof TouchWebView) {
            com.tencent.mobileqq.webview.swift.utils.t createWebViewKernelCallBack = createWebViewKernelCallBack();
            Intent intent = this.intent;
            Object obj = this.guildWebView;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.biz.ui.TouchWebView");
            return new WebViewWrapper(createWebViewKernelCallBack, intent, (TouchWebView) obj);
        }
        Logger.b bVar = new Logger.b();
        bVar.a().add("createWebViewWrapper FeedWebBundle== guildWebView is not TouchWebView");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
        }
        return super.createWebViewWrapper(useWebViewPool);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        com.tencent.biz.richframework.compat.f.c(this, activity);
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    protected boolean interceptStartLoadUrl() {
        boolean z16;
        if (this.guildWebBundle != null && this.guildWebView != null) {
            String string = GuildSplitViewUtils.f235370a.h(this).getString("url");
            if (string != null && string.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("interceptStartLoadUrl FeedWebBundle==  targetUrl is empty");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
                }
                return false;
            }
            if (TextUtils.isEmpty(Uri.parse(string).getQueryParameter("feedId"))) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                bVar2.a().add("interceptStartLoadUrl FeedWebBundle==  feedId is empty");
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e(TAG, 1, (String) it5.next(), null);
                }
                return false;
            }
            preloadCache(string);
            return true;
        }
        Logger logger3 = Logger.f235387a;
        Logger.b bVar3 = new Logger.b();
        bVar3.a().add("interceptStartLoadUrl FeedWebBundle==  guildWebBundle=null || guildWebView=null");
        Iterator<T> it6 = bVar3.a().iterator();
        while (it6.hasNext()) {
            Logger.f235387a.d().e(TAG, 1, (String) it6.next(), null);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return com.tencent.biz.richframework.compat.f.d(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return com.tencent.biz.richframework.compat.f.e(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return com.tencent.biz.richframework.compat.f.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return com.tencent.biz.richframework.compat.f.g(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment, com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        j jVar = this.guildWebBundle;
        if (jVar != null) {
            jVar.j();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        com.tencent.biz.richframework.compat.f.l(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return com.tencent.biz.richframework.compat.f.o(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
