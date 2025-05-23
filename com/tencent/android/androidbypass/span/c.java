package com.tencent.android.androidbypass.span;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LineHeightSpan;
import android.text.style.ReplacementSpan;
import com.tencent.android.androidbypass.codeblock.span.CodeBlockSpan;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J8\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/android/androidbypass/span/c;", "Landroid/text/style/LineHeightSpan;", "Landroid/text/Spanned;", "text", "", "start", "", "a", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "", "b", "end", "spanstartv", "v", "", "chooseHeight", "d", "Ljava/lang/Integer;", "originalFmAscent", "e", "I", "previousAscentAdjustment", "f", "defaultSpace", "Landroid/text/TextPaint;", "textPaint", "<init>", "(ILandroid/text/TextPaint;)V", tl.h.F, "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class c implements LineHeightSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Integer originalFmAscent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int previousAscentAdjustment;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int defaultSpace;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/android/androidbypass/span/c$a;", "", "", "MAX_EXTRA_SPACING", "I", "MIN_EXTRA_SPACING", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.span.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19191);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(int i3, @NotNull TextPaint textPaint) {
        Integer num;
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) textPaint);
            return;
        }
        this.defaultSpace = i3;
        Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
        if (fontMetricsInt != null) {
            num = Integer.valueOf(fontMetricsInt.ascent);
        } else {
            num = null;
        }
        this.originalFmAscent = num;
    }

    private final boolean a(Spanned text, int start) {
        if (start != 0) {
            int i3 = start - 1;
            if (text.charAt(i3) != '\n' && text.charAt(i3) != '\r') {
                Object[] spans = text.getSpans(i3, start, ReplacementSpan.class);
                Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(start - 1,\u2026lacementSpan::class.java)");
                for (Object obj : spans) {
                    if (((ReplacementSpan) obj) instanceof CodeBlockSpan) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private final boolean b(Paint.FontMetricsInt fm5, CharSequence text, int start) {
        boolean z16;
        int i3 = fm5.ascent;
        Integer num = this.originalFmAscent;
        if (num != null && i3 == num.intValue()) {
            return false;
        }
        f[] fVarArr = null;
        if (!(text instanceof Spanned)) {
            text = null;
        }
        Spanned spanned = (Spanned) text;
        if (spanned != null) {
            fVarArr = (f[]) spanned.getSpans(start, start, f.class);
        }
        if (fVarArr != null) {
            if (fVarArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
        }
        return true;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(@NotNull CharSequence text, int start, int end, int spanstartv, int v3, @NotNull Paint.FontMetricsInt fm5) {
        int i3;
        int coerceIn;
        int coerceIn2;
        Pair pair;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, text, Integer.valueOf(start), Integer.valueOf(end), Integer.valueOf(spanstartv), Integer.valueOf(v3), fm5);
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fm5, "fm");
        if (!(text instanceof Spanned)) {
            return;
        }
        Spanned spanned = (Spanned) text;
        boolean a16 = a(spanned, start);
        if (a16) {
            if (start != 0) {
                i3 = this.defaultSpace;
            }
            i3 = 0;
        } else {
            if (this.previousAscentAdjustment != 0) {
                if (b(fm5, text, start)) {
                    i3 = -this.previousAscentAdjustment;
                } else {
                    i3 = 0;
                }
                this.previousAscentAdjustment = 0;
            }
            i3 = 0;
        }
        Object[] spans = spanned.getSpans(start, end, Object.class);
        Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(start, end, Any::class.java)");
        int i16 = 0;
        for (Object obj : spans) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                pair = TuplesKt.to(Integer.valueOf(aVar.b()), Integer.valueOf(aVar.a()));
            } else if (obj instanceof d) {
                d dVar = (d) obj;
                pair = TuplesKt.to(Integer.valueOf(dVar.c()), Integer.valueOf(dVar.b()));
            }
            int intValue = ((Number) pair.component1()).intValue();
            int intValue2 = ((Number) pair.component2()).intValue();
            if (start != 0) {
                i3 = Math.max(i3, intValue);
            }
            i16 = Math.max(i16, intValue2);
        }
        coerceIn = RangesKt___RangesKt.coerceIn(i3, -100, 100);
        coerceIn2 = RangesKt___RangesKt.coerceIn(i16, -100, 100);
        if (a16) {
            this.previousAscentAdjustment = coerceIn;
        }
        if (coerceIn != 0 || coerceIn2 != 0) {
            fm5.ascent -= coerceIn;
            fm5.top -= coerceIn;
            fm5.descent += coerceIn2;
            fm5.bottom += coerceIn2;
        }
        com.tencent.android.androidbypass.config.a.f72049a.d("CustomLineHeightSpan", fm5.hashCode() + ", " + fm5 + ", start: " + text.charAt(start) + TokenParser.SP + "ascentAdjustment: " + coerceIn + ", descentAdjustment: " + coerceIn2);
    }
}
