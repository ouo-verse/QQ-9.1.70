package com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.story;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.tencent.android.androidbypass.Bypass;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J:\u0010\u0013\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J0\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/story/b;", "Lut/a;", "Landroid/net/Uri;", "src", "", "a", "Landroid/widget/TextView;", "tv", "Lcom/tencent/android/androidbypass/Bypass$f;", "options", "Landroid/text/SpannableStringBuilder;", "builder", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "", QCircleSchemeAttr.Polymerize.ALT, "", "traceId", "", "c", "Landroid/content/Context;", "context", "", "mkMaxWidth", "Landroid/view/View;", "b", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/a;", "msgItemCallback", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/a;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b implements ut.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.mini.a msgItemCallback;

    public b(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.mini.a msgItemCallback) {
        Intrinsics.checkNotNullParameter(msgItemCallback, "msgItemCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItemCallback);
        } else {
            this.msgItemCallback = msgItemCallback;
        }
    }

    @Override // ut.a
    public boolean a(@NotNull Uri src) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) src)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(src, "src");
        return Intrinsics.areEqual(src.getQueryParameter("id"), "5");
    }

    @Override // ut.a
    @NotNull
    public View b(@NotNull Context context, @NotNull Bypass.f options, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @NotNull String alt, int mkMaxWidth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, options, parsedResult, alt, Integer.valueOf(mkMaxWidth));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
        Intrinsics.checkNotNullParameter(alt, "alt");
        return new e(context, new c(parsedResult.e()), this.msgItemCallback).b();
    }

    @Override // ut.a
    public void c(@Nullable TextView tv5, @NotNull Bypass.f options, @NotNull SpannableStringBuilder builder, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @NotNull String alt, long traceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, tv5, options, builder, parsedResult, alt, Long.valueOf(traceId));
            return;
        }
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
        Intrinsics.checkNotNullParameter(alt, "alt");
    }
}
