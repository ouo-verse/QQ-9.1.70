package com.tencent.mobileqq.webview.html;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.sonic.sdk.SonicSessionConnection;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\b\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/webview/html/a;", "", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "DEFAULT_CHARSET_STR", "Ljava/nio/charset/Charset;", "c", "Ljava/nio/charset/Charset;", "a", "()Ljava/nio/charset/Charset;", "DEFAULT_CHARSET", "", "d", "Ljava/util/List;", "()Ljava/util/List;", "SHOULD_INTERCEPT_HEADERS", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f313876a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String DEFAULT_CHARSET_STR;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Charset DEFAULT_CHARSET;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> SHOULD_INTERCEPT_HEADERS;

    static {
        List<String> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39994);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f313876a = new a();
        String name = Charset.defaultCharset().name();
        Intrinsics.checkNotNullExpressionValue(name, "defaultCharset().name()");
        DEFAULT_CHARSET_STR = name;
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset()");
        DEFAULT_CHARSET = defaultCharset;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{SonicSessionConnection.HTTP_HEAD_CSP, "X-Content-Security-Policy", "X-Frame-Options"});
        SHOULD_INTERCEPT_HEADERS = listOf;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Charset a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Charset) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return DEFAULT_CHARSET;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return DEFAULT_CHARSET_STR;
    }

    @NotNull
    public final List<String> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return SHOULD_INTERCEPT_HEADERS;
    }
}
