package com.tencent.mobileqq.webview.html;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bJ*\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0013\u001a\u00020\bJ.\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/webview/html/c;", "", "", "url", "Lcom/tencent/mobileqq/webview/html/HtmlSession;", "c", "Lcom/tencent/mobileqq/webview/html/d;", "runtime", "Lcom/tencent/mobileqq/webview/html/c$a;", "htmlConfig", "i", "tag", "", "level", "msg", "", "e", "", "f", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "", "autoStart", "b", "Lcom/tencent/mobileqq/webview/html/l;", tl.h.F, "a", "Lcom/tencent/mobileqq/webview/html/d;", "Lcom/tencent/mobileqq/webview/html/c$a;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "sessionsToBind", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f313882a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static d runtime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static a htmlConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<HtmlSession> sessionsToBind;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\u0011\u001a\u00020\r8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\r8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/webview/html/c$a;", "", "", "a", "I", "b", "()I", "setCacheControlMaxAgeSeconds", "(I)V", "cacheControlMaxAgeSeconds", "e", "setMaxCacheSize", QzoneConfig.SECONDARY_VIDEO_MAX_CACHE_SIZE, "", "c", "D", "()D", "cacheMaxThreshold", "d", "cacheMinThreshold", "cacheCheckIntervalSeconds", "<init>", "()V", "f", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int cacheControlMaxAgeSeconds;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int maxCacheSize;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final double cacheMaxThreshold;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final double cacheMinThreshold;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int cacheCheckIntervalSeconds;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/webview/html/c$a$a;", "", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.webview.html.c$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes20.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40022);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 9)) {
                redirector.redirect((short) 9);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.cacheControlMaxAgeSeconds = 300;
            this.maxCacheSize = 20971520;
            this.cacheMaxThreshold = 0.8d;
            this.cacheMinThreshold = 0.25d;
            this.cacheCheckIntervalSeconds = 86400;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.cacheCheckIntervalSeconds;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.cacheControlMaxAgeSeconds;
        }

        public final double c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Double) iPatchRedirector.redirect((short) 6, (Object) this)).doubleValue();
            }
            return this.cacheMaxThreshold;
        }

        public final double d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Double) iPatchRedirector.redirect((short) 7, (Object) this)).doubleValue();
            }
            return this.cacheMinThreshold;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.maxCacheSize;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40033);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f313882a = new c();
            sessionsToBind = new CopyOnWriteArrayList<>();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final HtmlSession c(String url) {
        HtmlSession htmlSession;
        boolean z16;
        Iterator<HtmlSession> it = sessionsToBind.iterator();
        while (true) {
            if (it.hasNext()) {
                HtmlSession sessionsToBind2 = it.next();
                Intrinsics.checkNotNullExpressionValue(sessionsToBind2, "sessionsToBind");
                htmlSession = sessionsToBind2;
                if (Intrinsics.areEqual(url, htmlSession.k())) {
                    sessionsToBind.remove(htmlSession);
                    break;
                }
            } else {
                htmlSession = null;
                break;
            }
        }
        if (htmlSession != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        g(this, "htmlAgent_engine", 3, "findRemoveSession=" + z16, null, 8, null);
        return htmlSession;
    }

    public static /* synthetic */ void g(c cVar, String str, int i3, String str2, Throwable th5, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            th5 = null;
        }
        cVar.f(str, i3, str2, th5);
    }

    public static /* synthetic */ c j(c cVar, d dVar, a aVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            aVar = new a();
        }
        return cVar.i(dVar, aVar);
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            n.f313939a.d();
        }
    }

    @Nullable
    public final HtmlSession b(@Nullable Activity activity, @NotNull String url, @Nullable Intent intent, boolean autoStart) {
        j jVar;
        List<j> b16;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HtmlSession) iPatchRedirector.redirect((short) 6, this, activity, url, intent, Boolean.valueOf(autoStart));
        }
        Intrinsics.checkNotNullParameter(url, "url");
        d dVar = runtime;
        if (dVar == null || !dVar.e(url)) {
            z16 = false;
        }
        if (!z16) {
            g(this, "htmlAgent_engine", 4, "createSession runtime says switchOn=false return", null, 8, null);
            return null;
        }
        d dVar2 = runtime;
        if (dVar2 != null && (b16 = dVar2.b()) != null) {
            Iterator<T> it = b16.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((j) obj).c(activity, url, intent)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            jVar = (j) obj;
        } else {
            jVar = null;
        }
        g(this, "htmlAgent_HtmlRuntimeImpl", 3, "find intercept callback: " + jVar, null, 8, null);
        if (jVar != null && jVar.isSwitchOn()) {
            o oVar = new o();
            oVar.o(SystemClock.elapsedRealtime());
            oVar.t(url);
            m b17 = jVar.b();
            g(this, "htmlAgent_engine", 3, "createSession :" + b17, null, 8, null);
            HtmlSession htmlSession = new HtmlSession(b17, oVar);
            b17.i().f(htmlSession);
            sessionsToBind.add(htmlSession);
            if (autoStart) {
                htmlSession.B();
            }
            return htmlSession;
        }
        g(this, "htmlAgent_engine", 4, "createSession callback says switchOn=false return", null, 8, null);
        return null;
    }

    @NotNull
    public final a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        a aVar = htmlConfig;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("htmlConfig");
            return null;
        }
        return aVar;
    }

    @Nullable
    public final d e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return runtime;
    }

    public final void f(@NotNull String tag, int level, @NotNull String msg2, @Nullable Throwable e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, tag, Integer.valueOf(level), msg2, e16);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        d dVar = runtime;
        if (dVar != null) {
            dVar.f(tag, level, msg2, e16);
        }
    }

    @Nullable
    public final l h(@NotNull String url) {
        m j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (l) iPatchRedirector.redirect((short) 7, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        HtmlSession c16 = c(url);
        if (c16 != null && (j3 = c16.j()) != null) {
            return j3.i();
        }
        return null;
    }

    @NotNull
    public final c i(@NotNull d runtime2, @NotNull a htmlConfig2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runtime2, (Object) htmlConfig2);
        }
        Intrinsics.checkNotNullParameter(runtime2, "runtime");
        Intrinsics.checkNotNullParameter(htmlConfig2, "htmlConfig");
        runtime = runtime2;
        htmlConfig = htmlConfig2;
        return this;
    }
}
