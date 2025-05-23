package com.tencent.biz.qui.profileskin.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import de0.a;
import de0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUIFrameLayout extends FrameLayout implements a {

    /* renamed from: d, reason: collision with root package name */
    private c<QUIFrameLayout> f95099d;

    /* renamed from: e, reason: collision with root package name */
    private be0.a f95100e;

    public QUIFrameLayout(@NonNull Context context) {
        super(context);
        this.f95099d = null;
        this.f95100e = null;
    }

    @NonNull
    private c<QUIFrameLayout> a() {
        if (this.f95099d == null) {
            this.f95099d = new c<>(this);
        }
        return this.f95099d;
    }

    @Override // de0.a
    public be0.a N() {
        return this.f95100e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a().b();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(a().d(drawable));
    }

    public void setProfileSkinManager(be0.a aVar) {
        this.f95100e = aVar;
    }

    @Override // de0.b
    public void x() {
        a().c();
    }

    public QUIFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95099d = null;
        this.f95100e = null;
    }

    public QUIFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95099d = null;
        this.f95100e = null;
    }
}
