package com.tencent.biz.qui.profileskin.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import de0.a;
import de0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUIRelativeLayout extends RelativeLayout implements a {

    /* renamed from: d, reason: collision with root package name */
    private c<QUIRelativeLayout> f95107d;

    /* renamed from: e, reason: collision with root package name */
    private be0.a f95108e;

    public QUIRelativeLayout(Context context) {
        super(context);
        this.f95107d = null;
        this.f95108e = null;
    }

    @NonNull
    private c<QUIRelativeLayout> a() {
        if (this.f95107d == null) {
            this.f95107d = new c<>(this);
        }
        return this.f95107d;
    }

    @Override // de0.a
    public be0.a N() {
        return this.f95108e;
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
        this.f95108e = aVar;
    }

    @Override // de0.b
    public void x() {
        a().c();
    }

    public QUIRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95107d = null;
        this.f95108e = null;
    }

    public QUIRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95107d = null;
        this.f95108e = null;
    }
}
