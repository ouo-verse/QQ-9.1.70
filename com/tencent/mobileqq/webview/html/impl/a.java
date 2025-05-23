package com.tencent.mobileqq.webview.html.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.inject.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.webview.html.d;
import com.tencent.mobileqq.webview.html.j;
import com.tencent.mobileqq.webview.html.n;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.c;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.QbSdk;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010&\u001a\u00020$\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\"\u0010\u0016\u001a\u00020\u00042\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\u0014H\u0016J:\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J*\u0010#\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\"H\u0016R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/webview/html/impl/a;", "Lcom/tencent/mobileqq/webview/html/d;", "", "url", "", "e", "d", "k", "c", "", "Lcom/tencent/mobileqq/webview/html/j;", "b", "Ljava/lang/Runnable;", "runnable", "", "delayMillis", "", "i", "cookies", "j", "", "rspHeaders", h.F, "mimeType", "encoding", "respHeaders", "Ljava/io/InputStream;", "ins", "", "a", "tag", "", "level", "msg", "", "f", "Landroid/content/Context;", "Landroid/content/Context;", "appContext", "<init>", "(Landroid/content/Context;)V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_busi_htmlcallback.yml", version = 2)
    @NotNull
    private static ArrayList<Class<? extends j>> f313921d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static ArrayList<j> f313922e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static volatile String f313923f;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context appContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/webview/html/impl/a$a;", "", "", "defaultUserAgent", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setDefaultUserAgent", "(Ljava/lang/String;)V", "TAG", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.html.impl.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return a.f313923f;
            }
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40891);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        INSTANCE = new Companion(null);
        f313921d = new ArrayList<>();
        f313922e = new ArrayList<>();
        f313923f = "";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context appContext) {
        super(appContext);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appContext);
        } else {
            this.appContext = appContext;
        }
    }

    @Override // com.tencent.mobileqq.webview.html.d
    @NotNull
    public Object a(@NotNull String mimeType, @NotNull String encoding, @NotNull Map<String, ? extends List<String>> respHeaders, @NotNull InputStream ins) {
        int mapCapacity;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, this, mimeType, encoding, respHeaders, ins);
        }
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        Intrinsics.checkNotNullParameter(respHeaders, "respHeaders");
        Intrinsics.checkNotNullParameter(ins, "ins");
        WebResourceResponse webResourceResponse = new WebResourceResponse(mimeType, encoding, ins);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(respHeaders.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = respHeaders.entrySet().iterator();
        while (true) {
            str = "";
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            if (!((Collection) entry.getValue()).isEmpty()) {
                str = (String) ((List) entry.getValue()).get(0);
            }
            linkedHashMap.put(key, str);
        }
        webResourceResponse.setResponseHeaders(linkedHashMap);
        if (((Boolean) t.INSTANCE.a().b("debug_enable_verbose_log", Boolean.FALSE)).booleanValue()) {
            str = respHeaders.toString();
        }
        d.g(this, "htmlAgent_HtmlRuntimeImpl", 3, "buildWebResourceResponse mimeType:" + mimeType + ", encoding:" + encoding + " " + str, null, 8, null);
        return webResourceResponse;
    }

    @Override // com.tencent.mobileqq.webview.html.d
    @NotNull
    public List<j> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (f313922e.size() == 0) {
            Iterator<T> it = f313921d.iterator();
            while (it.hasNext()) {
                Class cls = (Class) it.next();
                ArrayList<j> arrayList = f313922e;
                Object newInstance = cls.newInstance();
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mobileqq.webview.html.IHtmlCallback");
                arrayList.add((j) newInstance);
            }
            f313922e.add(new DefaultHtmlCallback());
            d.g(this, "htmlAgent_HtmlRuntimeImpl", 3, "collectHtmlCallbacks size=" + f313922e.size(), null, 8, null);
        }
        return f313922e;
    }

    @Override // com.tencent.mobileqq.webview.html.d
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return n.f313939a.e(this.appContext);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.webview.html.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(@NotNull String url) {
        long j3;
        String queryParameter;
        int checkRadix;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Uri parse = Uri.parse(url);
        if (parse.isHierarchical() && (queryParameter = parse.getQueryParameter("_wv")) != null) {
            try {
                checkRadix = CharsKt__CharJVMKt.checkRadix(10);
                j3 = Long.parseLong(queryParameter, checkRadix);
            } catch (NumberFormatException e16) {
                QLog.e("htmlAgent_HtmlRuntimeImpl", 1, "isNoCache parse " + queryParameter + " error:" + e16.getMessage());
            }
            if ((j3 & 65536) == 0) {
                return true;
            }
            return false;
        }
        j3 = 0;
        if ((j3 & 65536) == 0) {
        }
    }

    @Override // com.tencent.mobileqq.webview.html.d
    public boolean e(@NotNull String url) {
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        int tbsVersion = QbSdk.getTbsVersion(BaseApplication.getContext());
        if (tbsVersion < 43304) {
            d.g(this, "htmlAgent_HtmlRuntimeImpl", 5, "isSwitchOn false cause tbsVersion=" + tbsVersion, null, 8, null);
            return false;
        }
        if (TextUtils.isEmpty(f313923f)) {
            String c16 = t.INSTANCE.a().c("default_wv_useragent", "");
            Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type kotlin.String");
            f313923f = c16;
            if (!TextUtils.isEmpty(f313923f)) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) f313923f, (CharSequence) "MQQBrowser", false, 2, (Object) null);
                if (!contains$default) {
                    d.g(this, "htmlAgent_HtmlRuntimeImpl", 5, "isSwitchOn false cause no x5", null, 8, null);
                    return false;
                }
            } else {
                d.g(this, "htmlAgent_HtmlRuntimeImpl", 5, "isSwitchOn false cause ua empty", null, 8, null);
                return false;
            }
        }
        if (!((c) aa.k(c.class)).h(url)) {
            d.g(this, "htmlAgent_HtmlRuntimeImpl", 5, "isSwitchOn false cause config", null, 8, null);
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.html.d
    public void f(@NotNull String tag, int level, @NotNull String msg2, @Nullable Throwable e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, tag, Integer.valueOf(level), msg2, e16);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (level >= 4 || QLog.isColorLevel() || ((b) aa.k(b.class)).isDebugVersion()) {
            switch (level) {
                case 2:
                    QLog.d(tag, 2, msg2, e16);
                    return;
                case 3:
                    QLog.d(tag, 2, msg2, e16);
                    return;
                case 4:
                    QLog.i(tag, 1, msg2, e16);
                    return;
                case 5:
                    QLog.w(tag, 1, msg2, e16);
                    return;
                case 6:
                    QLog.e(tag, 1, msg2, e16);
                    return;
                case 7:
                    QLog.d(tag, 1, msg2, e16);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.html.d
    public boolean h(@NotNull Map<String, ? extends List<String>> rspHeaders) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) rspHeaders)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(rspHeaders, "rspHeaders");
        List<String> c16 = com.tencent.mobileqq.webview.html.a.f313876a.c();
        if ((c16 instanceof Collection) && c16.isEmpty()) {
            return false;
        }
        Iterator<T> it = c16.iterator();
        while (it.hasNext()) {
            String lowerCase = ((String) it.next()).toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            if (rspHeaders.containsKey(lowerCase)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.html.d
    public void i(@NotNull Runnable runnable, long delayMillis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, runnable, Long.valueOf(delayMillis));
            return;
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (delayMillis > 0) {
            ThreadManagerV2.executeDelay(runnable, 64, null, true, delayMillis);
        } else {
            ThreadManagerV2.excute(runnable, 64, null, true);
        }
    }

    @Override // com.tencent.mobileqq.webview.html.d
    public boolean j(@NotNull String url, @NotNull List<String> cookies) {
        String f16;
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) url, (Object) cookies)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        if (cookies.isEmpty() || (f16 = com.tencent.mobileqq.webview.swift.cookie.b.f(url)) == null) {
            return false;
        }
        if (((Boolean) t.INSTANCE.a().b("debug_enable_verbose_log", Boolean.FALSE)).booleanValue()) {
            valueOf = CollectionsKt___CollectionsKt.joinToString$default(cookies, null, null, null, 0, null, null, 63, null);
        } else {
            valueOf = Integer.valueOf(cookies.size());
        }
        d.g(this, "htmlAgent_HtmlRuntimeImpl", 3, "setCookies cookieHost:" + f16 + " cookies:" + valueOf, null, 8, null);
        try {
            HashMap hashMap = new HashMap(1);
            Object[] array = cookies.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            hashMap.put(f16, array);
            CookieManager.getInstance().setCookies(hashMap);
            return true;
        } catch (Throwable th5) {
            f("htmlAgent_HtmlRuntimeImpl", 5, "setCookies error. ", th5);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.webview.html.d
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }
}
