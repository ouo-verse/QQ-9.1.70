package com.tencent.biz.qui.profileskin.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import de0.b;
import de0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUIImageView extends ImageView implements b {

    /* renamed from: d, reason: collision with root package name */
    private c<QUIImageView> f95102d;

    public QUIImageView(Context context) {
        super(context);
        this.f95102d = null;
    }

    @NonNull
    private c<QUIImageView> a() {
        if (this.f95102d == null) {
            this.f95102d = new c<>(this);
        }
        return this.f95102d;
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

    public QUIImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95102d = null;
    }

    public QUIImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95102d = null;
    }
}
