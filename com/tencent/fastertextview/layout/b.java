package com.tencent.fastertextview.layout;

import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/fastertextview/layout/b;", "", "a", "FasterView_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/fastertextview/layout/b$a;", "", "Lcom/tencent/fastertextview/layout/c;", "param", "Landroid/text/TextPaint;", "paint", "Landroid/text/StaticLayout;", "a", "<init>", "()V", "FasterView_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.fastertextview.layout.b$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
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

        @NotNull
        public final StaticLayout a(@NotNull c param, @NotNull TextPaint paint) {
            SpannableStringBuilder spannableStringBuilder;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (StaticLayout) iPatchRedirector.redirect((short) 2, (Object) this, (Object) param, (Object) paint);
            }
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(paint, "paint");
            StaticLayout build = StaticLayout.Builder.obtain(param.i(), 0, param.i().length(), paint, param.h()).setAlignment(param.a()).setLineSpacing(param.j(), param.k()).setIncludePad(param.f()).setEllipsize(param.e()).setEllipsizedWidth(param.d()).setMaxLines(param.g()).setBreakStrategy(param.b()).setHyphenationFrequency(0).build();
            Intrinsics.checkNotNullExpressionValue(build, "obtain(\n                    param.source,\n                    0,\n                    param.source.length,\n                    paint,\n                    param.outerWidth\n                )\n                    .setAlignment(param.align)\n                    .setLineSpacing(param.spacingAdd, param.spacingMult)\n                    .setIncludePad(param.includePad)\n                    .setEllipsize(param.ellipsize)\n                    .setEllipsizedWidth(param.ellipsisWidth)\n                    .setMaxLines(param.maxLines)\n                    .setBreakStrategy(param.breakStrategy)\n                    .setHyphenationFrequency(StaticLayout.HYPHENATION_FREQUENCY_NONE)\n                    .build()");
            if (build.getLineCount() <= param.g()) {
                return build;
            }
            int lineStart = build.getLineStart(param.g());
            if (param.e() == TextUtils.TruncateAt.END) {
                spannableStringBuilder = new SpannableStringBuilder(param.i().subSequence(0, lineStart - 1)).append((CharSequence) "\u2026");
                Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "{\n                    SpannableStringBuilder(\n                        param.source.subSequence(0, lineStart - 1)\n                    ).append(\"\\u2026\")\n                }");
            } else {
                spannableStringBuilder = new SpannableStringBuilder(param.i().subSequence(0, lineStart));
            }
            StaticLayout build2 = StaticLayout.Builder.obtain(spannableStringBuilder, 0, spannableStringBuilder.length(), paint, param.h()).setAlignment(param.a()).setLineSpacing(param.j(), param.k()).setIncludePad(param.f()).setEllipsize(param.e()).setEllipsizedWidth(param.d()).setMaxLines(param.g()).setBreakStrategy(param.c() ? 1 : 0).setHyphenationFrequency(0).build();
            Intrinsics.checkNotNullExpressionValue(build2, "obtain(\n                    stringBuilder,\n                    0,\n                    stringBuilder.length,\n                    paint,\n                    param.outerWidth\n                )\n                    .setAlignment(param.align)\n                    .setLineSpacing(param.spacingAdd, param.spacingMult)\n                    .setIncludePad(param.includePad)\n                    .setEllipsize(param.ellipsize)\n                    .setEllipsizedWidth(param.ellipsisWidth)\n                    .setMaxLines(param.maxLines)\n                    .setBreakStrategy(if (param.canContainUrl) LineBreaker.BREAK_STRATEGY_HIGH_QUALITY else LineBreaker.BREAK_STRATEGY_SIMPLE)\n                    .setHyphenationFrequency(StaticLayout.HYPHENATION_FREQUENCY_NONE).build()");
            return build2;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15036);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }
}
