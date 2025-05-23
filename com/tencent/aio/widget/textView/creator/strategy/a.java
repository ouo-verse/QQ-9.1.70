package com.tencent.aio.widget.textView.creator.strategy;

import android.annotation.SuppressLint;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/widget/textView/creator/strategy/a;", "Lcom/tencent/aio/widget/textView/creator/a;", "Lcom/tencent/aio/widget/textView/param/b;", "param", "Landroid/text/TextPaint;", "paint", "Landroid/text/StaticLayout;", "b", "", "a", "c", "<init>", "()V", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a extends com.tencent.aio.widget.textView.creator.a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/widget/textView/creator/strategy/a$a;", "", "", "HighSdkVersion", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.widget.textView.creator.strategy.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11343);
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
        }
    }

    @Override // com.tencent.aio.widget.textView.creator.e
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 24;
    }

    @Override // com.tencent.aio.widget.textView.creator.d
    @RequiresApi(23)
    @SuppressLint({"WrongConstant"})
    @NotNull
    public StaticLayout b(@NotNull com.tencent.aio.widget.textView.param.b param, @NotNull TextPaint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (StaticLayout) iPatchRedirector.redirect((short) 1, (Object) this, (Object) param, (Object) paint);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(paint, "paint");
        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(param.h(), 0, param.h().length(), paint, param.g()).setAlignment(param.a()).setLineSpacing(param.j(), param.k()).setIncludePad(param.e()).setEllipsize(param.d()).setEllipsizedWidth(param.c()).setMaxLines(param.f()).setBreakStrategy(1).setHyphenationFrequency(0);
        Intrinsics.checkNotNullExpressionValue(hyphenationFrequency, "StaticLayout.Builder.obt\u2026PHENATION_FREQUENCY_NONE)");
        StaticLayout build = hyphenationFrequency.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        if (build.getLineCount() <= param.f()) {
            return build;
        }
        int lineStart = build.getLineStart(param.f());
        com.tencent.aio.widget.textView.log.a.f70035a.a("BetweenAPI24To31Creator", "substring " + lineStart);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(param.h().subSequence(0, lineStart));
        StaticLayout.Builder.obtain(spannableStringBuilder, 0, spannableStringBuilder.length(), paint, param.g()).setAlignment(param.a()).setLineSpacing(param.j(), param.k()).setIncludePad(param.e()).setEllipsize(param.d()).setEllipsizedWidth(param.c()).setMaxLines(param.f()).setBreakStrategy(param.b() ? 1 : 0).setHyphenationFrequency(0);
        StaticLayout build2 = hyphenationFrequency.build();
        Intrinsics.checkNotNullExpressionValue(build2, "builder.build()");
        return build2;
    }

    @Override // com.tencent.aio.widget.textView.creator.e
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return Integer.MAX_VALUE;
    }
}
