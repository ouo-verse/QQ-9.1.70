package com.tencent.qqnt.markdown.click;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J%\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J&\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/markdown/click/c;", "Lcom/tencent/android/androidbypass/parser/api/b;", "Lcom/tencent/android/androidbypass/parser/api/a;", "", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "Landroid/view/View;", "view", "Landroid/text/style/ClickableSpan;", "clickableSpan", "", "b", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c implements com.tencent.android.androidbypass.parser.api.b, com.tencent.android.androidbypass.parser.api.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.tencent.android.androidbypass.enhance.scheme.matcher.c f359332a;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f359332a = new com.tencent.android.androidbypass.enhance.scheme.matcher.c();
        }
    }

    @Override // com.tencent.android.androidbypass.parser.api.a
    public boolean a(@Nullable String url, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @Nullable String clickText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, url, parsedResult, clickText)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
        return this.f359332a.a(url, parsedResult, clickText);
    }

    @Override // com.tencent.android.androidbypass.enhance.j
    public void b(@Nullable View view, @Nullable ClickableSpan clickableSpan, @Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, clickableSpan, url);
            return;
        }
        if (!b.b(b.f359330a, 0L, 1, null) && view != null && url != null) {
            IMarkdownFeatureCompatApi iMarkdownFeatureCompatApi = (IMarkdownFeatureCompatApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownFeatureCompatApi.class);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            iMarkdownFeatureCompatApi.startUrl(context, url);
        }
    }
}
