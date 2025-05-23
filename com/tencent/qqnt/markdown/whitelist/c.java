package com.tencent.qqnt.markdown.whitelist;

import android.text.style.DynamicDrawableSpan;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.markdown.api.IMarkdownConfigApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/markdown/whitelist/c;", "Lcom/tencent/android/androidbypass/e;", "Landroid/view/View;", "view", "Landroid/text/style/DynamicDrawableSpan;", "imageSpan", "", "url", "", "a", "Lcom/tencent/android/androidbypass/e;", "wrappedListener", "<init>", "(Lcom/tencent/android/androidbypass/e;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c implements com.tencent.android.androidbypass.e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.android.androidbypass.e wrappedListener;

    public c(@NotNull com.tencent.android.androidbypass.e wrappedListener) {
        Intrinsics.checkNotNullParameter(wrappedListener, "wrappedListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) wrappedListener);
        } else {
            this.wrappedListener = wrappedListener;
        }
    }

    @Override // com.tencent.android.androidbypass.e
    public void a(@Nullable View view, @Nullable DynamicDrawableSpan imageSpan, @Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, imageSpan, url);
        } else if (!((IMarkdownConfigApi) QRoute.api(IMarkdownConfigApi.class)).isWhiteListScheme(url, true)) {
            b.b();
        } else {
            this.wrappedListener.a(view, imageSpan, url);
        }
    }
}
