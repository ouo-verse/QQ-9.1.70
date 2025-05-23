package com.tencent.biz.qui.profileskin.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import de0.a;
import de0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUIRecyclerView extends RecyclerView implements a {

    /* renamed from: f, reason: collision with root package name */
    private c<QUIRecyclerView> f95105f;

    /* renamed from: h, reason: collision with root package name */
    private be0.a f95106h;

    public QUIRecyclerView(@NonNull Context context) {
        super(context);
        this.f95105f = null;
        this.f95106h = null;
    }

    @NonNull
    private c<QUIRecyclerView> C() {
        if (this.f95105f == null) {
            this.f95105f = new c<>(this);
        }
        return this.f95105f;
    }

    @Override // de0.a
    public be0.a N() {
        return this.f95106h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C().b();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(C().d(drawable));
    }

    public void setProfileSkinManager(be0.a aVar) {
        this.f95106h = aVar;
    }

    @Override // de0.b
    public void x() {
        C().c();
    }

    public QUIRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95105f = null;
        this.f95106h = null;
    }

    public QUIRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95105f = null;
        this.f95106h = null;
    }
}
