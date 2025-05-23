package com.tencent.luggage.wxa.il;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Spannable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.luggage.wxa.gh.c;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends TextView implements com.tencent.luggage.wxa.ee.f, c.b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f130704a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.cm.a f130705b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends Spannable.Factory {
        public a() {
        }

        @Override // android.text.Spannable.Factory
        public Spannable newSpannable(CharSequence charSequence) {
            Spannable newSpannable = super.newSpannable(charSequence);
            if (h.this.f130705b != null && !TextUtils.isEmpty(newSpannable)) {
                newSpannable.setSpan(h.this.f130705b, 0, newSpannable.length(), 18);
            }
            return newSpannable;
        }
    }

    public h(Context context) {
        super(com.tencent.luggage.wxa.ye.c.a(context));
        super.setIncludeFontPadding(false);
        super.setLineSpacing(0.0f, 1.0f);
        super.setSpannableFactory(new a());
    }

    @Override // com.tencent.luggage.wxa.gh.c.b
    public void setFakeBoldText(boolean z16) {
        getPaint().setFakeBoldText(z16);
    }

    @Override // com.tencent.luggage.wxa.gh.c.b
    public void setFontWeight(int i3) {
        Typeface create;
        if (Build.VERSION.SDK_INT >= 28) {
            create = Typeface.create(Typeface.DEFAULT, i3, false);
            setTypeface(create, 0);
        } else {
            w.b("luggage.AppBrandTextView", "not support setFontWeight");
        }
    }

    public void setInterceptEvent(boolean z16) {
        this.f130704a = z16;
    }

    @Override // android.widget.TextView, com.tencent.luggage.wxa.gh.c.b
    public void setLineHeight(int i3) {
        if (this.f130705b == null) {
            this.f130705b = new com.tencent.luggage.wxa.cm.a(i3, 17);
        }
        if (!this.f130705b.b(i3)) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (bufferType == TextView.BufferType.NORMAL) {
            bufferType = TextView.BufferType.SPANNABLE;
        }
        super.setText(charSequence, bufferType);
    }

    @Override // com.tencent.luggage.wxa.ee.f
    public boolean a() {
        return this.f130704a;
    }
}
