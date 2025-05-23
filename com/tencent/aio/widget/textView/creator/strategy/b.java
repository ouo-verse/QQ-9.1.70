package com.tencent.aio.widget.textView.creator.strategy;

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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/widget/textView/creator/strategy/b;", "Lcom/tencent/aio/widget/textView/creator/a;", "Lcom/tencent/aio/widget/textView/param/b;", "param", "Landroid/text/TextPaint;", "paint", "Landroid/text/StaticLayout;", "b", "", "a", "c", "<init>", "()V", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b extends com.tencent.aio.widget.textView.creator.a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/widget/textView/creator/strategy/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.widget.textView.creator.strategy.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12066);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
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
        return 1;
    }

    @Override // com.tencent.aio.widget.textView.creator.d
    @NotNull
    public StaticLayout b(@NotNull com.tencent.aio.widget.textView.param.b param, @NotNull TextPaint paint) {
        SpannableStringBuilder spannableStringBuilder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (StaticLayout) iPatchRedirector.redirect((short) 1, (Object) this, (Object) param, (Object) paint);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(paint, "paint");
        StaticLayout staticLayout = new StaticLayout(param.h(), 0, param.h().length(), paint, param.g(), param.a(), param.k(), param.j(), param.e(), param.d(), param.c());
        if (staticLayout.getLineCount() <= param.f()) {
            return staticLayout;
        }
        int lineStart = staticLayout.getLineStart(param.f());
        com.tencent.aio.widget.textView.log.a.f70035a.a("UnderAPi24Creator", "subString " + lineStart);
        if (param.d() == TextUtils.TruncateAt.END) {
            spannableStringBuilder = new SpannableStringBuilder(param.h().subSequence(0, lineStart - 1)).append((CharSequence) "\u2026");
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "SpannableStringBuilder(p\u2026rt - 1)).append(\"\\u2026\")");
        } else {
            spannableStringBuilder = new SpannableStringBuilder(param.h().subSequence(0, lineStart));
        }
        return new StaticLayout(spannableStringBuilder, 0, spannableStringBuilder.length(), paint, param.g(), param.a(), param.k(), param.j(), param.e(), param.d(), param.c());
    }

    @Override // com.tencent.aio.widget.textView.creator.e
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 23;
    }
}
