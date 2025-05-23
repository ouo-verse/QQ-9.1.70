package com.tencent.biz.qui.profileskin.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import de0.b;
import de0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUIImageButton extends ImageButton implements b {

    /* renamed from: d, reason: collision with root package name */
    private c<QUIImageButton> f95101d;

    public QUIImageButton(Context context) {
        super(context);
        this.f95101d = null;
    }

    @NonNull
    private c<QUIImageButton> a() {
        if (this.f95101d == null) {
            this.f95101d = new c<>(this);
        }
        return this.f95101d;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a().b();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(a().d(drawable));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(a().h(drawable));
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        String resourceEntryName = getResources().getResourceEntryName(i3);
        if (resourceEntryName != null && resourceEntryName.startsWith("qui_")) {
            setImageDrawable(getResources().getDrawable(i3));
        } else {
            super.setImageResource(i3);
        }
    }

    @Override // de0.b
    public void x() {
        a().c();
    }

    public QUIImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95101d = null;
    }

    public QUIImageButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95101d = null;
    }
}
