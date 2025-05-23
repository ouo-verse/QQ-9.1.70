package com.tencent.biz.qui.profileskin.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.annotation.NonNull;
import de0.b;
import de0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUIEditText extends EditText implements b {

    /* renamed from: d, reason: collision with root package name */
    private c<QUIEditText> f95098d;

    public QUIEditText(Context context) {
        super(context);
        this.f95098d = null;
    }

    @NonNull
    private c<QUIEditText> a() {
        if (this.f95098d == null) {
            this.f95098d = new c<>(this);
        }
        return this.f95098d;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a().b();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(a().d(drawable));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Drawable[] e16 = a().e(drawable, drawable2, drawable3, drawable4);
        super.setCompoundDrawables(e16[0], e16[1], e16[2], e16[3]);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Drawable[] f16 = a().f(drawable, drawable2, drawable3, drawable4);
        super.setCompoundDrawablesRelative(f16[0], f16[1], f16[2], f16[3]);
    }

    public void setHintTextColor2(ColorStateList colorStateList) {
        super.setHintTextColor(a().g(colorStateList));
    }

    public void setLinkTextColor2(ColorStateList colorStateList) {
        super.setLinkTextColor(a().i(colorStateList));
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(a().j(colorStateList));
    }

    @Override // de0.b
    public void x() {
        a().c();
    }

    public QUIEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95098d = null;
    }

    public QUIEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95098d = null;
    }
}
