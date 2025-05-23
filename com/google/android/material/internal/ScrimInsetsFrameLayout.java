package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.tencent.mobileqq.R;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    Drawable f33765d;

    /* renamed from: e, reason: collision with root package name */
    Rect f33766e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f33767f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f33768h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f33769i;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            boolean z16;
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
            if (scrimInsetsFrameLayout.f33766e == null) {
                scrimInsetsFrameLayout.f33766e = new Rect();
            }
            ScrimInsetsFrameLayout.this.f33766e.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            ScrimInsetsFrameLayout.this.a(windowInsetsCompat);
            ScrimInsetsFrameLayout scrimInsetsFrameLayout2 = ScrimInsetsFrameLayout.this;
            if (windowInsetsCompat.hasSystemWindowInsets() && ScrimInsetsFrameLayout.this.f33765d != null) {
                z16 = false;
            } else {
                z16 = true;
            }
            scrimInsetsFrameLayout2.setWillNotDraw(z16);
            ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public ScrimInsetsFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f33766e != null && this.f33765d != null) {
            int save = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            if (this.f33768h) {
                this.f33767f.set(0, 0, width, this.f33766e.top);
                this.f33765d.setBounds(this.f33767f);
                this.f33765d.draw(canvas);
            }
            if (this.f33769i) {
                this.f33767f.set(0, height - this.f33766e.bottom, width, height);
                this.f33765d.setBounds(this.f33767f);
                this.f33765d.draw(canvas);
            }
            Rect rect = this.f33767f;
            Rect rect2 = this.f33766e;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f33765d.setBounds(this.f33767f);
            this.f33765d.draw(canvas);
            Rect rect3 = this.f33767f;
            Rect rect4 = this.f33766e;
            rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
            this.f33765d.setBounds(this.f33767f);
            this.f33765d.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f33765d;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f33765d;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z16) {
        this.f33769i = z16;
    }

    public void setDrawTopInsetForeground(boolean z16) {
        this.f33768h = z16;
    }

    public void setScrimInsetForeground(@Nullable Drawable drawable) {
        this.f33765d = drawable;
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f33767f = new Rect();
        this.f33768h = true;
        this.f33769i = true;
        TypedArray h16 = o.h(context, attributeSet, w0.a.f443876f7, i3, R.style.f173822am3, new int[0]);
        this.f33765d = h16.getDrawable(w0.a.f443888g7);
        h16.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }

    protected void a(WindowInsetsCompat windowInsetsCompat) {
    }
}
