package com.tencent.biz.qui.profileskin.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import de0.b;
import de0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUIView extends View implements b {

    /* renamed from: d, reason: collision with root package name */
    private c<QUIView> f95110d;

    public QUIView(Context context) {
        super(context);
        this.f95110d = null;
    }

    @NonNull
    private c<QUIView> a() {
        if (this.f95110d == null) {
            this.f95110d = new c<>(this);
        }
        return this.f95110d;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a().b();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(a().d(drawable));
    }

    @Override // de0.b
    public void x() {
        a().c();
    }

    public QUIView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95110d = null;
    }

    public QUIView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95110d = null;
    }
}
