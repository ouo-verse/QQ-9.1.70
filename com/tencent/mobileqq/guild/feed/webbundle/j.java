package com.tencent.mobileqq.guild.feed.webbundle;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.api.IGuildPublicToDetailFullLinkReportApi;
import com.tencent.mobileqq.guild.event.GuildFeedDetailReportEvent;
import com.tencent.mobileqq.guild.feed.event.GuildWebBundleStateEvent;
import com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper;
import com.tencent.mobileqq.guild.feed.webbundle.GuildWebBundleManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0002\u001a#B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0002J\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010.R\u0018\u00103\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010.R\u0016\u0010:\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u00106R\u0014\u0010=\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010<R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010<R\u0014\u0010?\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/webbundle/j;", "Lcom/tencent/mobileqq/guild/feed/webbundle/r;", "", "value", "", "u", "reason", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundlePreloadState;", "state", "r", "t", "k", WebAccelerateHelper.KEY_PRELOAD_URL, "Lorg/json/JSONObject;", "pendingData", "Lcom/tencent/mobileqq/guild/feed/webbundle/j$b;", "listener", "v", "url", "data", "w", "Landroid/content/Context;", "context", ReportConstant.COSTREPORT_PREFIX, "getPreloadState", "a", "j", "l", "Lcom/tencent/mobileqq/guild/feed/webbundle/t;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/MutableContextWrapper;", "Landroid/content/MutableContextWrapper;", "contextWrapper", "Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundleInterface;", "b", "Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundleInterface;", "webBundleInterface", "c", "Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundlePreloadState;", "preloadState", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "e", "Ljava/lang/String;", "f", "realUrl", "g", "Lcom/tencent/mobileqq/guild/feed/webbundle/t;", "webView", "", tl.h.F, "J", "startTime", "i", QzoneIPCModule.RESULT_CODE, WadlProxyConsts.PARAM_TIME_OUT, "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mPreloadTimeOutChecker", "mUseTimeOutChecker", "mShowToast", "<init>", "(Landroid/content/Context;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j implements r {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableContextWrapper contextWrapper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildWebBundleInterface webBundleInterface;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildWebBundlePreloadState preloadState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<b> listeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String preloadUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String realUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t webView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String resultCode;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long timeOut;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mPreloadTimeOutChecker;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mUseTimeOutChecker;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mShowToast;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/webbundle/j$b;", "", "Lcom/tencent/mobileqq/guild/feed/webbundle/j;", "webBundle", "Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundlePreloadState;", "state", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a(@NotNull j webBundle, @NotNull GuildWebBundlePreloadState state);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0006\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/webbundle/j$c", "Lcom/tencent/mobileqq/guild/feed/webbundle/q;", "Lcom/tencent/mobileqq/guild/feed/webbundle/t;", "webView", "", "url", "", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements q {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f224123b;

        c(JSONObject jSONObject) {
            this.f224123b = jSONObject;
        }

        @Override // com.tencent.mobileqq.guild.feed.webbundle.q
        public void a(@NotNull t webView, @NotNull String url) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(url, "url");
            GuildWebBundlePreloadState preloadState = j.this.getPreloadState();
            if (preloadState != GuildWebBundlePreloadState.FAILED && preloadState != GuildWebBundlePreloadState.SUCCESS) {
                j.this.a(GuildWebBundlePreloadState.ON_PAGE_FINISHED);
                webView.dispatchJsEvent("guild_hybrid_bundle_message_preload", this.f224123b, null);
                Logger logger = Logger.f235387a;
                j jVar = j.this;
                JSONObject jSONObject = this.f224123b;
                logger.d().d("GuildWebBundle", 1, "[preload][step 3][#" + jVar.hashCode() + "] FeedWebBundle== onPageFinished, send pendingData message to h5. pendingData = " + jSONObject);
                return;
            }
            Logger logger2 = Logger.f235387a;
            j jVar2 = j.this;
            logger2.d().d("GuildWebBundle", 1, "[preload][step 3][#" + jVar2.hashCode() + "] FeedWebBundle== onPageFinished, already is " + preloadState);
            b();
        }

        public final void b() {
            boolean j3 = GuildFeedReportHelper.i().j();
            if (MobileQQ.sProcessId == 1) {
                ((IGuildPublicToDetailFullLinkReportApi) QRoute.api(IGuildPublicToDetailFullLinkReportApi.class)).end(System.currentTimeMillis(), j3);
            } else {
                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedDetailReportEvent(System.currentTimeMillis(), j3), true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/webbundle/j$d", "Lcom/tencent/mobileqq/guild/feed/webbundle/p;", "", "value", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements p {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.feed.webbundle.p
        public void a(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Logger logger = Logger.f235387a;
            j jVar = j.this;
            boolean z16 = true;
            logger.d().d("GuildWebBundle", 1, "[use][step 2][#" + jVar.hashCode() + "] FeedWebBundle== js callback value=" + value);
            if (value.length() <= 0) {
                z16 = false;
            }
            if (z16 && Intrinsics.areEqual(value, j.this.resultCode)) {
                UiThreadUtil.remove(j.this.mUseTimeOutChecker);
            }
        }
    }

    public j(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.contextWrapper = new MutableContextWrapper(context);
        this.webBundleInterface = new GuildWebBundleInterface(this);
        this.preloadState = GuildWebBundlePreloadState.INIT;
        this.listeners = new CopyOnWriteArrayList<>();
        this.preloadUrl = "";
        this.realUrl = "";
        this.startTime = -1L;
        this.resultCode = "2";
        this.timeOut = 1500L;
        this.mPreloadTimeOutChecker = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.webbundle.g
            @Override // java.lang.Runnable
            public final void run() {
                j.o(j.this);
            }
        };
        this.mUseTimeOutChecker = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.webbundle.h
            @Override // java.lang.Runnable
            public final void run() {
                j.q(j.this);
            }
        };
        this.mShowToast = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.webbundle.i
            @Override // java.lang.Runnable
            public final void run() {
                j.p(j.this);
            }
        };
    }

    private final void n(String reason) {
        Logger.f235387a.d().d("GuildWebBundle", 1, "stop send msg to h5 because " + reason + ", realUrl = " + this.realUrl);
        t tVar = this.webView;
        if (tVar != null) {
            tVar.loadUrl(this.realUrl + "&t=" + System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(j this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k("preload timeout");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(j this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u("callJs error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(j this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n("guildHybridBundleMessage timeout");
    }

    private final void r(GuildWebBundlePreloadState state) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this, state);
        }
    }

    private final void t(GuildWebBundlePreloadState state) {
        SimpleEventBus.getInstance().dispatchEvent(new GuildWebBundleStateEvent(state, System.currentTimeMillis() - this.startTime), true);
    }

    private final void u(String value) {
        QQToast.makeText(this.contextWrapper.getApplicationContext(), value, 1).show();
    }

    @Override // com.tencent.mobileqq.guild.feed.webbundle.r
    public void a(@NotNull GuildWebBundlePreloadState state) {
        boolean z16;
        Intrinsics.checkNotNullParameter(state, "state");
        Logger.a d16 = Logger.f235387a.d();
        GuildWebBundlePreloadState guildWebBundlePreloadState = this.preloadState;
        if (this.preloadState.ordinal() < state.ordinal()) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.d("GuildWebBundle", 1, "current state is " + guildWebBundlePreloadState + ", new state is " + state + ", canUpdate : " + z16);
        if (this.preloadState.ordinal() >= state.ordinal()) {
            return;
        }
        this.preloadState = state;
        r(state);
        GuildWebBundlePreloadState guildWebBundlePreloadState2 = this.preloadState;
        if (guildWebBundlePreloadState2 == GuildWebBundlePreloadState.SUCCESS) {
            Context applicationContext = this.contextWrapper.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "contextWrapper.applicationContext");
            s(applicationContext);
            t(state);
            return;
        }
        if (guildWebBundlePreloadState2 == GuildWebBundlePreloadState.FAILED) {
            t(state);
            j();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.webbundle.r
    @NotNull
    public GuildWebBundlePreloadState getPreloadState() {
        return this.preloadState;
    }

    public final void j() {
        UiThreadUtil.remove(this.mPreloadTimeOutChecker);
        Context applicationContext = this.contextWrapper.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "contextWrapper.applicationContext");
        s(applicationContext);
        t tVar = this.webView;
        if (tVar != null) {
            tVar.destroy();
        }
        this.webView = null;
        this.listeners.clear();
    }

    public final void k(@NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (getPreloadState() != GuildWebBundlePreloadState.SUCCESS) {
            Logger.f235387a.d().d("GuildWebBundle", 1, "forceStop preloading FeedWebBundle== because " + reason);
            a(GuildWebBundlePreloadState.FAILED);
        }
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getPreloadUrl() {
        return this.preloadUrl;
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final t getWebView() {
        return this.webView;
    }

    public final void s(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.contextWrapper.setBaseContext(context);
    }

    public final void v(@NotNull String preloadUrl, @NotNull JSONObject pendingData, @Nullable b listener) {
        Intrinsics.checkNotNullParameter(preloadUrl, "preloadUrl");
        Intrinsics.checkNotNullParameter(pendingData, "pendingData");
        GuildWebBundleManager.Companion companion = GuildWebBundleManager.INSTANCE;
        s u16 = companion.a().u();
        this.startTime = System.currentTimeMillis();
        if (Intrinsics.areEqual(this.preloadUrl, preloadUrl)) {
            QLog.e("GuildWebBundle", 1, "startPreload FeedWebBundle== this.preloadUrl == preloadUrl");
            return;
        }
        this.preloadUrl = preloadUrl;
        if (listener != null) {
            this.listeners.add(listener);
        }
        UiThreadUtil.runOnUiThread(this.mPreloadTimeOutChecker, companion.a().p().getPreloadTimeoutLimit());
        a(GuildWebBundlePreloadState.CREATE_WEBVIEW);
        t a16 = u16.a(this.contextWrapper);
        a16.enableJavaScript(true);
        a16.addJavascriptInterface(this.webBundleInterface, "webbundle");
        a16.setOnPageFinishedListener(new c(pendingData));
        a(GuildWebBundlePreloadState.LOAD_PAGE);
        a16.loadUrl(preloadUrl);
        this.webView = a16;
        Logger.f235387a.d().d("GuildWebBundle", 1, "[preload][step 1][#" + hashCode() + "] FeedWebBundle== init webBundle finish.. preloadUrl=" + preloadUrl);
    }

    public final void w(@NotNull String url, @NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(data, "data");
        GuildWebBundleInterface guildWebBundleInterface = this.webBundleInterface;
        String jSONObject = data.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "data.toString()");
        guildWebBundleInterface.setJson(jSONObject);
        this.realUrl = url;
        UiThreadUtil.runOnUiThread(this.mUseTimeOutChecker, this.timeOut);
        t tVar = this.webView;
        if (tVar != null) {
            tVar.o("javascript:window.guildHybridBundleMessage(" + data + ")", new d());
        }
        Logger.f235387a.d().d("GuildWebBundle", 1, "[use][step 1][#" + hashCode() + "] FeedWebBundle==  url=" + this.realUrl + ", data=" + this.webBundleInterface.getDataStr());
    }
}
