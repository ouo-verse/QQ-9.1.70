package com.tencent.android.androidbypass.enhance.scheme.handler;

import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.android.androidbypass.config.g;
import com.tencent.android.androidbypass.parser.api.b;
import com.tencent.android.androidbypass.parser.api.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u00112\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0011\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H$R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/scheme/handler/a;", "Lcom/tencent/android/androidbypass/parser/api/b;", "", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "Landroid/view/View;", "view", "Landroid/text/style/ClickableSpan;", "clickableSpan", "", "b", "guildId", "channelId", "c", "Lcom/tencent/android/androidbypass/enhance/scheme/matcher/b;", "Lcom/tencent/android/androidbypass/enhance/scheme/matcher/b;", "mSchemeMatcherDelegate", "Lcom/tencent/android/androidbypass/parser/api/d;", "mUrlParsedResult", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public abstract class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.android.androidbypass.enhance.scheme.matcher.b mSchemeMatcherDelegate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private d mUrlParsedResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/scheme/handler/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.enhance.scheme.handler.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17793);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mSchemeMatcherDelegate = new com.tencent.android.androidbypass.enhance.scheme.matcher.b();
        }
    }

    @Override // com.tencent.android.androidbypass.parser.api.a
    public boolean a(@Nullable String url, @NotNull d parsedResult, @Nullable String clickText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, url, parsedResult, clickText)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
        boolean a16 = this.mSchemeMatcherDelegate.a(url, parsedResult, clickText);
        if (a16) {
            this.mUrlParsedResult = parsedResult;
        }
        return a16;
    }

    @Override // com.tencent.android.androidbypass.enhance.j
    public void b(@Nullable View view, @Nullable ClickableSpan clickableSpan, @Nullable String url) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, clickableSpan, url);
            return;
        }
        if (url == null) {
            g gVar = com.tencent.android.androidbypass.config.a.f72049a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onClick]: url is null, view.hashCode=");
            if (view != null) {
                i3 = view.hashCode();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            gVar.e("AbsHashtagSchemeClickHandler", sb5.toString());
            return;
        }
        Uri parse = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
        c(parse.getQueryParameter("guildId"), parse.getQueryParameter("channelId"));
    }

    protected abstract void c(@Nullable String guildId, @Nullable String channelId);
}
