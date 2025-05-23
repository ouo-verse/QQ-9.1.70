package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AECompoundButton extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f65840d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f65841e;

    /* renamed from: f, reason: collision with root package name */
    private int f65842f;

    /* renamed from: h, reason: collision with root package name */
    private int f65843h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f65844i;

    public AECompoundButton(Context context) {
        this(context, null);
    }

    private void b(Context context, AttributeSet attributeSet) {
        c(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.dlf, (ViewGroup) this, true);
        this.f65840d = (ImageView) findViewById(R.id.rvu);
        Drawable d16 = d();
        if (d16 != null) {
            this.f65840d.setImageDrawable(d16);
        }
    }

    private Drawable d() {
        Drawable drawable;
        return (!i.b() || (drawable = this.f65844i) == null) ? this.f65841e : drawable;
    }

    private void e() {
        ImageView imageView = this.f65840d;
        if (imageView == null || this.f65842f == 0 || this.f65843h == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = this.f65842f;
        layoutParams.height = this.f65843h;
        this.f65840d.setLayoutParams(layoutParams);
    }

    public ImageView a() {
        return this.f65840d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    public void setForegroundAndBackgroundResource(int i3, int i16) {
        setForegroundResource(i3);
        setBackgroundResource(i16);
    }

    public void setForegroundResource(int i3) {
        ImageView imageView = this.f65840d;
        if (imageView != null) {
            imageView.setImageResource(i3);
        }
    }

    public void setForegroundSize(int i3, int i16) {
        this.f65842f = i3;
        this.f65843h = i16;
        e();
    }

    public AECompoundButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AECompoundButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b(context, attributeSet);
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ls.a.f415478b)) == null) {
            return;
        }
        this.f65841e = obtainStyledAttributes.getDrawable(1);
        this.f65844i = obtainStyledAttributes.getDrawable(2);
        this.f65842f = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.f65843h = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
    }
}
