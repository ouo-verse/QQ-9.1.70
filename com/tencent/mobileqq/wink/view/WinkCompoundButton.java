package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkCompoundButton extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f326874d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f326875e;

    /* renamed from: f, reason: collision with root package name */
    private int f326876f;

    /* renamed from: h, reason: collision with root package name */
    private int f326877h;

    public WinkCompoundButton(@NonNull Context context) {
        this(context, null);
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        b(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.i4w, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.y3f);
        this.f326874d = imageView;
        Drawable drawable = this.f326875e;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    private void b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.wink.j.f323096b)) == null) {
            return;
        }
        this.f326875e = obtainStyledAttributes.getDrawable(com.tencent.mobileqq.wink.j.f323120d);
        this.f326876f = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.f323132e, 0);
        this.f326877h = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.f323108c, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ImageView imageView = this.f326874d;
        if (imageView != null && this.f326876f != 0 && this.f326877h != 0) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = this.f326876f;
            layoutParams.height = this.f326877h;
            this.f326874d.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isClickable() && isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    setAlpha(1.0f);
                }
                return super.onTouchEvent(motionEvent);
            }
            setAlpha(0.5f);
            super.onTouchEvent(motionEvent);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForegroundResource(@DrawableRes int i3) {
        ImageView imageView = this.f326874d;
        if (imageView != null) {
            imageView.setImageResource(i3);
        }
    }

    public WinkCompoundButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WinkCompoundButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context, attributeSet);
    }
}
