package com.tencent.now.od.ui.game.meleegame.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.DrawableRes;
import tn3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class LevelIconView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    protected int f338560d;

    /* renamed from: e, reason: collision with root package name */
    protected ImageView f338561e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f338562f;

    public LevelIconView(Context context) {
        this(context, null);
    }

    private void c() {
        setOrientation(0);
        setGravity(5);
        this.f338561e = new ImageView(getContext());
        this.f338562f = new ImageView(getContext());
        this.f338561e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f338561e.setAdjustViewBounds(false);
        this.f338562f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f338562f.setAdjustViewBounds(false);
        addView(this.f338561e, new LinearLayout.LayoutParams(-2, -1));
        addView(this.f338562f, new LinearLayout.LayoutParams(-2, -1));
    }

    private void d() {
        int a16 = a(this.f338560d);
        int b16 = b(this.f338560d);
        this.f338561e.setImageResource(a16);
        this.f338562f.setImageResource(b16);
    }

    @DrawableRes
    protected abstract int a(int i3);

    @DrawableRes
    protected abstract int b(int i3);

    public void setLevel(int i3) {
        if (this.f338560d != i3) {
            this.f338560d = i3;
            d();
        }
    }

    public LevelIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LevelIconView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.G);
        setLevel(obtainStyledAttributes.getInt(a.H, 0));
        obtainStyledAttributes.recycle();
    }
}
