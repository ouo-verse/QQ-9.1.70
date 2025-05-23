package com.tencent.richmediabrowser.view;

import android.graphics.drawable.ColorDrawable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class EmptyDrawable extends ColorDrawable {

    /* renamed from: h, reason: collision with root package name */
    private int f365137h;

    /* renamed from: w, reason: collision with root package name */
    private int f365138w;

    public EmptyDrawable(int i3, int i16, int i17) {
        super(i3);
        this.f365138w = i16;
        this.f365137h = i17;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f365137h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f365138w;
    }

    public EmptyDrawable(int i3, int i16) {
        super(0);
        this.f365138w = i3;
        this.f365137h = i16;
    }
}
