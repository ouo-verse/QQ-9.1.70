package com.tencent.qqnt.markdown.whitelist;

import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.markdown.api.IMarkdownConfigApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J9\u0010\n\u001a\u00020\t2\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00070\u0007H\u0096\u0001J$\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\u0012\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/markdown/whitelist/f;", "Lcom/tencent/android/androidbypass/parser/api/b;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "p0", "Landroid/text/style/ClickableSpan;", "p1", "", "p2", "", "b", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "Lcom/tencent/android/androidbypass/parser/api/b;", "wrappedListener", "<init>", "(Lcom/tencent/android/androidbypass/parser/api/b;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class f implements com.tencent.android.androidbypass.parser.api.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.android.androidbypass.parser.api.b wrappedListener;

    public f(@NotNull com.tencent.android.androidbypass.parser.api.b wrappedListener) {
        Intrinsics.checkNotNullParameter(wrappedListener, "wrappedListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) wrappedListener);
        } else {
            this.wrappedListener = wrappedListener;
        }
    }

    @Override // com.tencent.android.androidbypass.parser.api.a
    public boolean a(@Nullable String url, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @Nullable String clickText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, url, parsedResult, clickText)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
        if (!this.wrappedListener.a(url, parsedResult, clickText) || !((IMarkdownConfigApi) QRoute.api(IMarkdownConfigApi.class)).isWhiteListScheme(url, false)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.android.androidbypass.enhance.j
    public void b(View p06, ClickableSpan p16, String p26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, p06, p16, p26);
        } else {
            this.wrappedListener.b(p06, p16, p26);
        }
    }
}
