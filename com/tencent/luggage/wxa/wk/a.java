package com.tencent.luggage.wxa.wk;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.luggage.wxa.wk.d;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends URLSpan {

    /* renamed from: a, reason: collision with root package name */
    public String f144282a;

    /* renamed from: b, reason: collision with root package name */
    public d.a f144283b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f144284c;

    public a(String str, d.a aVar, boolean z16) {
        super(str);
        this.f144282a = str;
        this.f144283b = aVar;
        this.f144284c = z16;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        d.a aVar = this.f144283b;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f144282a);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(this.f144284c);
    }
}
