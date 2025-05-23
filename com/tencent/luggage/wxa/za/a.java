package com.tencent.luggage.wxa.za;

import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {

    /* renamed from: s, reason: collision with root package name */
    public static b f146434s = new b(3);

    /* renamed from: t, reason: collision with root package name */
    public static final SpannableString f146435t = new SpannableString("");

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f146436a = null;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f146437b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f146438c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f146439d = 0;

    /* renamed from: e, reason: collision with root package name */
    public TextPaint f146440e = null;

    /* renamed from: f, reason: collision with root package name */
    public int f146441f = 0;

    /* renamed from: g, reason: collision with root package name */
    public Layout.Alignment f146442g = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: h, reason: collision with root package name */
    public int f146443h = 51;

    /* renamed from: i, reason: collision with root package name */
    public TextUtils.TruncateAt f146444i = null;

    /* renamed from: j, reason: collision with root package name */
    public int f146445j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f146446k = Integer.MAX_VALUE;

    /* renamed from: l, reason: collision with root package name */
    public TextDirectionHeuristic f146447l = null;

    /* renamed from: m, reason: collision with root package name */
    public float f146448m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    public float f146449n = 1.1f;

    /* renamed from: o, reason: collision with root package name */
    public boolean f146450o = false;

    /* renamed from: p, reason: collision with root package name */
    public int f146451p = -1;

    /* renamed from: q, reason: collision with root package name */
    public int f146452q = -1;

    /* renamed from: r, reason: collision with root package name */
    public InputFilter.LengthFilter f146453r = null;

    public static a a(CharSequence charSequence, TextPaint textPaint, int i3) {
        a b16 = b();
        b16.f146437b = charSequence;
        b16.f146438c = 0;
        b16.f146439d = charSequence.length();
        b16.f146440e = textPaint;
        b16.f146441f = i3;
        return b16;
    }

    public static a b() {
        a a16 = f146434s.a();
        return a16 == null ? new a() : a16;
    }

    public void c() {
        this.f146436a = null;
        this.f146437b = null;
        this.f146438c = 0;
        this.f146439d = 0;
        this.f146440e = new TextPaint();
        this.f146441f = 0;
        this.f146442g = Layout.Alignment.ALIGN_NORMAL;
        this.f146443h = 51;
        this.f146444i = null;
        this.f146445j = 0;
        this.f146446k = Integer.MAX_VALUE;
        this.f146447l = null;
        this.f146448m = 0.0f;
        this.f146449n = 1.0f;
        this.f146450o = false;
        this.f146451p = 0;
        this.f146453r = null;
        this.f146452q = -1;
    }

    public final void d() {
        Layout.Alignment alignment = this.f146442g;
        Layout.Alignment alignment2 = Layout.Alignment.ALIGN_NORMAL;
        if (alignment == alignment2) {
            int i3 = this.f146443h & 8388615;
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 != 8388611) {
                            if (i3 != 8388613) {
                                this.f146442g = alignment2;
                                return;
                            }
                        }
                    }
                    this.f146442g = Layout.Alignment.ALIGN_OPPOSITE;
                    return;
                }
                this.f146442g = alignment2;
                return;
            }
            this.f146442g = Layout.Alignment.ALIGN_CENTER;
        }
    }

    public a b(int i3) {
        if (i3 >= 0) {
            this.f146446k = i3;
        }
        return this;
    }

    public a a(CharSequence charSequence) {
        if (charSequence == null) {
            return this;
        }
        this.f146437b = charSequence;
        this.f146438c = 0;
        this.f146439d = charSequence.length();
        return this;
    }

    public a a(TextUtils.TruncateAt truncateAt) {
        if (truncateAt != null) {
            this.f146444i = truncateAt;
        }
        return this;
    }

    public a a(int i3) {
        this.f146443h = i3;
        return this;
    }

    public c a() {
        int i3;
        int i16;
        StaticLayout staticLayout;
        InputFilter.LengthFilter lengthFilter;
        TextUtils.TruncateAt truncateAt = this.f146444i;
        if (truncateAt == null || (i3 = this.f146445j) <= 0) {
            i3 = this.f146441f;
        }
        if (truncateAt == null && this.f146446k == 1) {
            this.f146444i = TextUtils.TruncateAt.END;
        }
        if (this.f146451p > 0 && (lengthFilter = this.f146453r) != null) {
            CharSequence charSequence = this.f146437b;
            CharSequence filter = lengthFilter.filter(charSequence, 0, charSequence.length(), f146435t, 0, 0);
            if (filter != null) {
                this.f146437b = filter;
                if (this.f146439d > filter.length()) {
                    this.f146439d = this.f146437b.length();
                }
            }
        }
        if (d.f146468a) {
            w.d("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + ((Object) this.f146437b) + " " + this.f146441f);
        }
        d();
        this.f146440e.setAntiAlias(true);
        boolean z16 = (this.f146447l == null || (com.tencent.luggage.wxa.aa.a.c(18) && this.f146447l == TextDirectionHeuristics.FIRSTSTRONG_LTR)) && ((i16 = this.f146446k) == Integer.MAX_VALUE || i16 == -1);
        try {
            staticLayout = a(this.f146437b, z16, i3, this.f146452q);
        } catch (Exception e16) {
            w.d("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", e16.getMessage());
            StaticLayout staticLayout2 = null;
            int i17 = 0;
            while (i17 < 3) {
                try {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f146437b);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
                    if (metricAffectingSpanArr == null || metricAffectingSpanArr.length <= 0) {
                        i17 = 100;
                    } else {
                        spannableStringBuilder.insert(spannableStringBuilder.getSpanStart(metricAffectingSpanArr[0]) - 1, (CharSequence) " ");
                        i17++;
                    }
                    this.f146437b = spannableStringBuilder;
                    staticLayout2 = a(spannableStringBuilder, z16, i3, this.f146452q);
                    w.d("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", Integer.valueOf(i17));
                    break;
                } catch (Exception e17) {
                    w.d("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", e17.getMessage(), Integer.valueOf(i17));
                }
            }
            staticLayout = staticLayout2;
        }
        if (staticLayout == null) {
            CharSequence charSequence2 = this.f146437b.toString();
            this.f146437b = charSequence2;
            staticLayout = a(charSequence2, z16, i3, this.f146452q);
        }
        c cVar = new c(staticLayout);
        cVar.a(this.f146436a);
        cVar.b(this.f146437b);
        cVar.c(this.f146451p);
        cVar.d(this.f146446k);
        cVar.a(this.f146442g);
        cVar.a(this.f146444i);
        cVar.a(this.f146440e);
        cVar.b(this.f146443h);
        cVar.a(this.f146452q);
        f146434s.b(this);
        return cVar;
    }

    public final StaticLayout a(CharSequence charSequence, boolean z16, int i3, int i16) {
        if (i16 >= 0) {
            return StaticLayout.Builder.obtain(charSequence, this.f146438c, this.f146439d, this.f146440e, this.f146441f).setAlignment(this.f146442g).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(this.f146448m, this.f146449n).setIncludePad(this.f146450o).setEllipsize(this.f146444i).setEllipsizedWidth(i3).setBreakStrategy(i16).setMaxLines(Integer.MAX_VALUE).build();
        }
        if (z16) {
            return new StaticLayout(charSequence, this.f146438c, this.f146439d, this.f146440e, this.f146441f, this.f146442g, this.f146449n, this.f146448m, this.f146450o, this.f146444i, i3);
        }
        if (this.f146447l == null) {
            this.f146447l = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        return com.tencent.luggage.wxa.ab.a.b(charSequence, this.f146438c, this.f146439d, this.f146440e, this.f146441f, this.f146442g, this.f146447l, this.f146449n, this.f146448m, this.f146450o, this.f146444i, i3, this.f146446k);
    }
}
