package com.tencent.mobileqq.webview.html.impl;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.webview.html.c;
import com.tencent.mobileqq.webview.html.d;
import com.tencent.mobileqq.webview.html.i;
import com.tencent.mobileqq.webview.html.j;
import com.tencent.mobileqq.webview.html.k;
import com.tencent.mobileqq.webview.html.l;
import com.tencent.mobileqq.webview.html.m;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.ad;
import com.tencent.mobileqq.webview.swift.aq;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 \u00152\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0018B\u0007\u00a2\u0006\u0004\b&\u0010'J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0011H\u0016J\u0010\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001dR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001eR\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010 R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010%\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/webview/html/impl/DefaultHtmlCallback;", "Lcom/tencent/mobileqq/webview/html/j;", "Lcom/tencent/mobileqq/webview/html/i;", "", "Lcom/tencent/mobileqq/webview/swift/utils/t;", "k", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "url", "Landroid/content/Intent;", "intent", "", "c", "isSwitchOn", "Lcom/tencent/mobileqq/webview/html/m;", "b", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/webview/html/l;", "g", "Lcom/tencent/mobileqq/webview/html/k;", "f", "Lcom/tencent/mobileqq/webview/html/h;", "e", "a", "i", "j", "l", h.F, "Ljava/lang/String;", "Landroid/content/Intent;", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "activityRef", "d", "webViewKernelCallBackRef", "Z", "bDoneGetKernelCallback", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class DefaultHtmlCallback implements j, i {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f313902g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Intent intent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Activity> activityRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<t> webViewKernelCallBackRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean bDoneGetKernelCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/webview/html/impl/DefaultHtmlCallback$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.html.impl.DefaultHtmlCallback$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/webview/html/impl/DefaultHtmlCallback$b", "Lcom/tencent/mobileqq/webview/swift/ad;", "", "a", "b", "", "c", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements ad {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DefaultHtmlCallback.this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.ad
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            d e16 = c.f313882a.e();
            if (e16 != null) {
                String str = DefaultHtmlCallback.this.url;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("url");
                    str = null;
                }
                if (!e16.d(str)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.webview.swift.ad
        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.webview.swift.ad
        public long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return 0L;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40236);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
            f313902g = true;
        }
    }

    public DefaultHtmlCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final t k() {
        t tVar;
        ComponentCallbacks2 componentCallbacks2;
        t tVar2;
        Integer num;
        WeakReference<t> weakReference = this.webViewKernelCallBackRef;
        if (weakReference != null) {
            tVar = weakReference.get();
        } else {
            tVar = null;
        }
        if (tVar == null && !this.bDoneGetKernelCallback) {
            this.bDoneGetKernelCallback = true;
            WeakReference<Activity> weakReference2 = this.activityRef;
            if (weakReference2 != null) {
                componentCallbacks2 = (Activity) weakReference2.get();
            } else {
                componentCallbacks2 = null;
            }
            if (componentCallbacks2 instanceof com.tencent.mobileqq.webviewplugin.j) {
                com.tencent.mobileqq.webviewplugin.j jVar = (com.tencent.mobileqq.webviewplugin.j) componentCallbacks2;
                WebViewFragment currentWebViewFragment = jVar.getCurrentWebViewFragment();
                if (currentWebViewFragment == null) {
                    c.g(c.f313882a, "htmlAgent_DefaultHtmlCallback", 5, "getUserAgentMark() curFragment is null, create a new one.", null, 8, null);
                    ArrayList<WebViewTabBarData> b16 = aq.b(this.intent);
                    Intrinsics.checkNotNullExpressionValue(b16, "getTabBarData(intent)");
                    Intent intent = this.intent;
                    int i3 = 0;
                    if (intent != null) {
                        num = Integer.valueOf(intent.getIntExtra(QQBrowserActivity.TAB_DEFAULT_INDEX, 0));
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        i3 = num.intValue();
                    }
                    currentWebViewFragment = jVar.createWebViewFragment(b16.get(i3), new Intent(this.intent));
                }
                if (currentWebViewFragment != null) {
                    this.webViewKernelCallBackRef = new WeakReference<>(currentWebViewFragment.getWebViewKernelCallBack());
                }
                c cVar = c.f313882a;
                WeakReference<t> weakReference3 = this.webViewKernelCallBackRef;
                if (weakReference3 != null) {
                    tVar2 = weakReference3.get();
                } else {
                    tVar2 = null;
                }
                c.g(cVar, "htmlAgent_DefaultHtmlCallback", 4, "getWebViewKernelCallBack() " + tVar2, null, 8, null);
            }
            WeakReference<t> weakReference4 = this.webViewKernelCallBackRef;
            if (weakReference4 == null) {
                return null;
            }
            return weakReference4.get();
        }
        WeakReference<t> weakReference5 = this.webViewKernelCallBackRef;
        if (weakReference5 == null) {
            return null;
        }
        return weakReference5.get();
    }

    @Override // com.tencent.mobileqq.webview.html.i
    @NotNull
    public String a(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        String r16 = SwiftBrowserCookieMonster.r(url);
        Intrinsics.checkNotNullExpressionValue(r16, "getCookie4WebSoOrSonic(url)");
        return r16;
    }

    @Override // com.tencent.mobileqq.webview.html.j
    @NotNull
    public m b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (m) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        m.Companion companion = m.INSTANCE;
        String str = this.url;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
            str = null;
        }
        Class<? extends l> g16 = g();
        Class<? extends k> f16 = f();
        Class<? extends com.tencent.mobileqq.webview.html.h> e16 = e();
        l sessionClient = g16.newInstance();
        k reqHandler = f16.newInstance();
        com.tencent.mobileqq.webview.html.h cacheHandler = e16.newInstance();
        Intrinsics.checkNotNullExpressionValue(sessionClient, "sessionClient");
        Intrinsics.checkNotNullExpressionValue(reqHandler, "reqHandler");
        Intrinsics.checkNotNullExpressionValue(cacheHandler, "cacheHandler");
        m mVar = new m(str, sessionClient, reqHandler, cacheHandler);
        mVar.p(1);
        mVar.s(true);
        mVar.r(15);
        mVar.o(l());
        mVar.q(h());
        mVar.n(this);
        mVar.t(i());
        return mVar;
    }

    @Override // com.tencent.mobileqq.webview.html.j
    public boolean c(@Nullable Activity activity, @NotNull String url, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, activity, url, intent)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.intent = intent;
        if (activity != null) {
            this.activityRef = new WeakReference<>(activity);
        }
        this.webViewKernelCallBackRef = null;
        this.bDoneGetKernelCallback = false;
        return true;
    }

    @NotNull
    public Class<? extends com.tencent.mobileqq.webview.html.h> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return DefaultCacheHandler.class;
    }

    @NotNull
    public Class<? extends k> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return DefaultReqHandler.class;
    }

    @NotNull
    public Class<? extends l> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return DefaultSessionClient.class;
    }

    @Nullable
    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return null;
    }

    @NotNull
    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return com.tencent.mobileqq.webview.swift.utils.i.n(a.INSTANCE.a(), j(), false) + " HA";
    }

    @Override // com.tencent.mobileqq.webview.html.j
    public boolean isSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).p()) {
            return true;
        }
        if (f313902g) {
            f313902g = false;
            return true;
        }
        c.g(c.f313882a, "htmlAgent_DefaultHtmlCallback", 5, "not fistPage", null, 8, null);
        return false;
    }

    @Nullable
    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        try {
            t k3 = k();
            if (k3 == null) {
                return null;
            }
            return k3.getUAMark();
        } catch (Exception unused) {
            c.g(c.f313882a, "htmlAgent_DefaultHtmlCallback", 5, "getUserAgentMark() fail.", null, 8, null);
            return null;
        }
    }

    public boolean l() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        try {
            t k3 = k();
            if (k3 != null) {
                num = Integer.valueOf(k3.getCacheMode(new b()));
            } else {
                num = null;
            }
            c.g(c.f313882a, "htmlAgent_DefaultHtmlCallback", 3, "isNoCache() cacheMode=" + num, null, 8, null);
            if (num == null) {
                return false;
            }
            if (num.intValue() != 2) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            c.g(c.f313882a, "htmlAgent_DefaultHtmlCallback", 5, "isNoCache() fail.", null, 8, null);
            return false;
        }
    }
}
