package com.tencent.luggage.wxa.ye;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import com.tencent.luggage.wxa.gh.c;
import com.tencent.luggage.wxa.tn.w;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a implements c.b {

    /* renamed from: f, reason: collision with root package name */
    public static final ThreadLocal f145549f = new C6952a();

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f145550a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f145551b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.za.a f145552c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f145553d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.cm.a f145554e;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ye.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C6952a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TextPaint get() {
            return new TextPaint(1);
        }
    }

    public a(Resources resources, int i3) {
        this.f145553d = "";
        this.f145551b = resources;
        TextPaint textPaint = (TextPaint) f145549f.get();
        Objects.requireNonNull(textPaint);
        this.f145550a = textPaint;
        this.f145553d = "";
        this.f145552c = com.tencent.luggage.wxa.za.a.a("", textPaint, i3);
    }

    public StaticLayout a() {
        return this.f145552c.a().a();
    }

    public final void b() {
        if (this.f145554e == null) {
            this.f145552c.a(this.f145553d);
            return;
        }
        SpannableString spannableString = new SpannableString(this.f145553d);
        spannableString.setSpan(this.f145554e, 0, spannableString.length(), 18);
        this.f145552c.a(spannableString);
    }

    @Override // com.tencent.luggage.wxa.gh.c.b
    public float getTextSize() {
        return this.f145550a.getTextSize();
    }

    @Override // com.tencent.luggage.wxa.gh.c.b
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.f145552c.a(truncateAt);
    }

    @Override // com.tencent.luggage.wxa.gh.c.b
    public void setFakeBoldText(boolean z16) {
        this.f145550a.setFakeBoldText(z16);
    }

    @Override // com.tencent.luggage.wxa.gh.c.b
    public void setFontWeight(int i3) {
        Typeface create;
        if (Build.VERSION.SDK_INT >= 28) {
            create = Typeface.create(Typeface.DEFAULT, i3, false);
            this.f145550a.setTypeface(create);
        } else {
            w.b("luggage.JsApiMeasureTextString", "not support setFontWeight");
        }
    }

    @Override // com.tencent.luggage.wxa.gh.c.b
    public void setGravity(int i3) {
        this.f145552c.a(i3);
    }

    @Override // com.tencent.luggage.wxa.gh.c.b
    public void setLineHeight(int i3) {
        com.tencent.luggage.wxa.cm.a aVar = this.f145554e;
        if (aVar == null || aVar.b(i3)) {
            this.f145554e = new com.tencent.luggage.wxa.cm.a(i3, 16);
            b();
        }
    }

    @Override // com.tencent.luggage.wxa.gh.c.b
    public void setSingleLine(boolean z16) {
        if (z16) {
            this.f145552c.b(1);
        } else {
            this.f145552c.b(Integer.MAX_VALUE);
        }
    }

    @Override // com.tencent.luggage.wxa.gh.c.b
    public void setText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!charSequence.equals(this.f145553d)) {
            this.f145553d = charSequence;
            b();
        }
    }

    @Override // com.tencent.luggage.wxa.gh.c.b
    public void setTextColor(int i3) {
        this.f145550a.setColor(i3);
    }

    @Override // com.tencent.luggage.wxa.gh.c.b
    public void setTextSize(int i3, float f16) {
        this.f145550a.setTextSize(TypedValue.applyDimension(i3, f16, this.f145551b.getDisplayMetrics()));
    }
}
