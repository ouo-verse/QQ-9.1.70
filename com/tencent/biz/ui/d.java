package com.tencent.biz.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    protected Context f97027a;

    /* renamed from: b, reason: collision with root package name */
    protected PopupWindow f97028b;

    /* renamed from: c, reason: collision with root package name */
    protected View f97029c;

    /* renamed from: d, reason: collision with root package name */
    protected Drawable f97030d = null;

    /* renamed from: e, reason: collision with root package name */
    protected WindowManager f97031e;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 4) {
                d.this.f97028b.dismiss();
                return true;
            }
            return false;
        }
    }

    public d(Context context) {
        this.f97027a = context;
        PopupWindow popupWindow = new PopupWindow(context);
        this.f97028b = popupWindow;
        popupWindow.setTouchInterceptor(new a());
        this.f97031e = (WindowManager) context.getSystemService("window");
    }

    public void a() {
        this.f97028b.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.f97029c != null) {
            Drawable drawable = this.f97030d;
            if (drawable == null) {
                this.f97028b.setBackgroundDrawable(new BitmapDrawable());
            } else {
                this.f97028b.setBackgroundDrawable(drawable);
            }
            this.f97028b.setWidth(-2);
            this.f97028b.setHeight(-2);
            this.f97028b.setTouchable(true);
            this.f97028b.setFocusable(false);
            this.f97028b.setOutsideTouchable(true);
            this.f97028b.setContentView(this.f97029c);
            return;
        }
        throw new IllegalStateException("setContentView was not called with a view to display.");
    }

    public void c(View view) {
        this.f97029c = view;
        this.f97028b.setContentView(view);
    }

    public void d(PopupWindow.OnDismissListener onDismissListener) {
        this.f97028b.setOnDismissListener(onDismissListener);
    }
}
