package com.tencent.mobileqq.webview.html;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020#\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0002H&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u001e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\tH&J\"\u0010\u0016\u001a\u00020\u00042\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\u0014H&J:\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\u00142\u0006\u0010\u001b\u001a\u00020\u001aH&J,\u0010\"\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010!H&R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/webview/html/d;", "", "", "url", "", "e", "d", "k", "c", "", "Lcom/tencent/mobileqq/webview/html/j;", "b", "Ljava/lang/Runnable;", "runnable", "", "delayMillis", "", "i", "cookies", "j", "", "rspHeaders", tl.h.F, "mimeType", "encoding", "respHeaders", "Ljava/io/InputStream;", "ins", "a", "tag", "", "level", "msg", "", "f", "Landroid/content/Context;", "Landroid/content/Context;", "appContext", "<init>", "(Landroid/content/Context;)V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context appContext;

    public d(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appContext);
        } else {
            this.appContext = appContext;
        }
    }

    public static /* synthetic */ void g(d dVar, String str, int i3, String str2, Throwable th5, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 8) != 0) {
                th5 = null;
            }
            dVar.f(str, i3, str2, th5);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    @NotNull
    public abstract Object a(@NotNull String mimeType, @NotNull String encoding, @NotNull Map<String, ? extends List<String>> respHeaders, @NotNull InputStream ins);

    @NotNull
    public abstract List<j> b();

    @NotNull
    public abstract String c();

    public abstract boolean d(@NotNull String url);

    public abstract boolean e(@NotNull String url);

    public abstract void f(@NotNull String tag, int level, @NotNull String msg2, @Nullable Throwable e16);

    public abstract boolean h(@NotNull Map<String, ? extends List<String>> rspHeaders);

    public abstract void i(@NotNull Runnable runnable, long delayMillis);

    public abstract boolean j(@NotNull String url, @NotNull List<String> cookies);

    public abstract boolean k();
}
