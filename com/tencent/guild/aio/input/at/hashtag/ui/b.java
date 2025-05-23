package com.tencent.guild.aio.input.at.hashtag.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class b extends ClickableSpan {

    /* renamed from: d, reason: collision with root package name */
    private bq0.g f110907d;

    /* renamed from: e, reason: collision with root package name */
    private int f110908e;

    /* renamed from: f, reason: collision with root package name */
    private int f110909f;

    public b(bq0.g gVar, int i3, int i16) {
        this.f110907d = gVar;
        this.f110908e = i3;
        this.f110909f = i16;
    }

    public void a(boolean z16) {
        int i3;
        bq0.g gVar = this.f110907d;
        if (gVar != null) {
            if (z16) {
                i3 = this.f110908e;
            } else {
                i3 = this.f110909f;
            }
            gVar.setBackgroundColor(i3);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
    }
}
