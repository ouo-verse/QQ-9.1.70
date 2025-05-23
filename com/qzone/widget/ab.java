package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ab {

    /* renamed from: a, reason: collision with root package name */
    private Context f60701a;

    /* renamed from: b, reason: collision with root package name */
    private View f60702b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f60703c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f60704d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f60705e;

    public ab(View view) {
        this.f60704d = false;
        this.f60705e = true;
        this.f60701a = view.getContext();
        this.f60702b = view;
    }

    public void b(Canvas canvas) {
        int i3;
        Drawable drawable = this.f60703c;
        if (drawable != null) {
            View view = this.f60702b;
            if (this.f60704d) {
                int i16 = 0;
                this.f60704d = false;
                int width = view.getWidth();
                int height = view.getHeight();
                if (this.f60705e) {
                    i16 = view.getPaddingLeft();
                    width -= view.getPaddingRight();
                    i3 = view.getPaddingTop();
                    height -= view.getPaddingBottom();
                } else {
                    i3 = 0;
                }
                drawable.setBounds(i16, i3, width, height);
            }
            drawable.draw(canvas);
        }
    }

    public void c() {
        Drawable drawable = this.f60703c;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f60703c.setState(this.f60702b.getDrawableState());
    }

    public Drawable d() {
        return this.f60703c;
    }

    public void e(Drawable drawable) {
        Drawable drawable2 = this.f60703c;
        if (drawable2 != drawable) {
            View view = this.f60702b;
            if (drawable2 != null) {
                drawable2.setCallback(null);
                view.unscheduleDrawable(this.f60703c);
            }
            this.f60703c = drawable;
            if (drawable != null) {
                view.setWillNotDraw(false);
                drawable.setCallback(view);
                if (drawable.isStateful()) {
                    drawable.setState(view.getDrawableState());
                }
            } else {
                view.setWillNotDraw(true);
            }
            view.requestLayout();
            view.invalidate();
        }
    }

    public void a() {
        this.f60704d = true;
    }

    public ab(View view, Drawable drawable) {
        this(view);
        e(drawable);
    }
}
