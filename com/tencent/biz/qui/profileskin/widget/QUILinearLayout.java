package com.tencent.biz.qui.profileskin.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import de0.a;
import de0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUILinearLayout extends LinearLayout implements a {

    /* renamed from: d, reason: collision with root package name */
    private c<QUILinearLayout> f95103d;

    /* renamed from: e, reason: collision with root package name */
    private be0.a f95104e;

    public QUILinearLayout(Context context) {
        super(context);
        this.f95103d = null;
        this.f95104e = null;
    }

    @NonNull
    private c<QUILinearLayout> a() {
        if (this.f95103d == null) {
            this.f95103d = new c<>(this);
        }
        return this.f95103d;
    }

    @Override // de0.a
    public be0.a N() {
        return this.f95104e;
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
        this.f95104e = aVar;
    }

    @Override // de0.b
    public void x() {
        a().c();
    }

    public QUILinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95103d = null;
        this.f95104e = null;
    }

    public QUILinearLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95103d = null;
        this.f95104e = null;
    }
}
