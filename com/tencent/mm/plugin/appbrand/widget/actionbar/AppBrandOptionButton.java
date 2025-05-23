package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.kl.e;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AppBrandOptionButton extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public ImageButton f152351a;

    /* renamed from: b, reason: collision with root package name */
    public View f152352b;

    /* renamed from: c, reason: collision with root package name */
    public int f152353c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f152354d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f152355e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AppBrandOptionButton.this.findViewById(R.id.sqn).setVisibility(8);
            AppBrandOptionButton.this.c();
            AppBrandOptionButton.this.f152352b = null;
        }
    }

    public AppBrandOptionButton(@NonNull Context context) {
        super(context);
        this.f152353c = 0;
        this.f152354d = false;
        this.f152355e = false;
        a(context);
    }

    public void b() {
        View view = this.f152352b;
        if (view != null && (view instanceof e)) {
            ValueAnimator a16 = ((e) view).a();
            a16.addListener(new a());
            a16.start();
            return;
        }
        c();
    }

    public final void c() {
        this.f152351a.setVisibility(0);
        if (!this.f152355e) {
            this.f152351a.setAlpha(1.0f);
        }
        this.f152351a.setImageDrawable(getDefaultImageDrawable());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return ImageButton.class.getName();
    }

    public int getActionBarHeight() {
        return getResources().getDimensionPixelSize(R.dimen.bfh);
    }

    public ImageView getButtonImage() {
        return this.f152351a;
    }

    public View getCustomOptionView() {
        return this.f152352b;
    }

    public String getDefaultAccessibilityLabel() {
        return getContext().getString(R.string.ywi);
    }

    public Drawable getDefaultImageDrawable() {
        return ContextCompat.getDrawable(getContext(), R.drawable.f160305og4);
    }

    public int getStyleColor() {
        return this.f152353c;
    }

    @Override // android.view.View
    public void onCancelPendingInputEvents() {
        super.onCancelPendingInputEvents();
        setPressed(false);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f152352b != null) {
            this.f152354d = true;
            b();
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setAccessibilityLabel(String str) {
        ImageButton imageButton = this.f152351a;
        if (imageButton != null && imageButton.getVisibility() == 0) {
            this.f152351a.setContentDescription(str);
        }
    }

    public void setColor(int i3) {
        this.f152351a.setImageDrawable(getDefaultImageDrawable());
        this.f152351a.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
        this.f152351a.setBackground(getBackground());
        if (this.f152351a.getBackground() != null) {
            this.f152351a.getBackground().setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
        }
        View view = this.f152352b;
        if (view != null && (view instanceof e)) {
            ((e) view).setColor(i3);
        }
        this.f152353c = i3;
    }

    public void setIcon(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f152351a.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
            this.f152351a.setVisibility(0);
        }
    }

    public final void a(Context context) {
        ImageButton imageButton = new ImageButton(context);
        this.f152351a = imageButton;
        imageButton.setClickable(false);
        this.f152351a.setBackground(null);
        this.f152351a.setImportantForAccessibility(2);
        addView(this.f152351a, new FrameLayout.LayoutParams(getActionBarHeight(), -1, 17));
        setAccessibilityLabel(getDefaultAccessibilityLabel());
    }

    public AppBrandOptionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f152353c = 0;
        this.f152354d = false;
        this.f152355e = false;
        a(context);
    }

    public void a(e eVar) {
        this.f152351a.setVisibility(8);
        this.f152352b = eVar;
        addView(eVar);
        eVar.b();
    }

    public AppBrandOptionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3);
        this.f152353c = 0;
        this.f152354d = false;
        this.f152355e = false;
        a(context);
    }

    public boolean a() {
        return this.f152352b != null;
    }

    @TargetApi(21)
    public AppBrandOptionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        super(context, attributeSet, i3, i16);
        this.f152353c = 0;
        this.f152354d = false;
        this.f152355e = false;
        a(context);
    }
}
