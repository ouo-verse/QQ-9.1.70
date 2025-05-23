package com.tencent.biz.qui.profileskin.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import de0.a;
import de0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUIConstraintLayout extends ConstraintLayout implements a {

    /* renamed from: d, reason: collision with root package name */
    private c<QUIConstraintLayout> f95096d;

    /* renamed from: e, reason: collision with root package name */
    private be0.a f95097e;

    public QUIConstraintLayout(@NonNull Context context) {
        super(context);
        this.f95096d = null;
        this.f95097e = null;
    }

    @NonNull
    private c<QUIConstraintLayout> z0() {
        if (this.f95096d == null) {
            this.f95096d = new c<>(this);
        }
        return this.f95096d;
    }

    @Override // de0.a
    public be0.a N() {
        return this.f95097e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        z0().b();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(z0().d(drawable));
    }

    public void setProfileSkinManager(be0.a aVar) {
        this.f95097e = aVar;
    }

    @Override // de0.b
    public void x() {
        z0().c();
    }

    public QUIConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95096d = null;
        this.f95097e = null;
    }

    public QUIConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95096d = null;
        this.f95097e = null;
    }
}
