package com.tencent.luggage.wxa.mo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

/* compiled from: P */
/* loaded from: classes8.dex */
public class x extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    public View.OnTouchListener f134854a;

    /* renamed from: b, reason: collision with root package name */
    public Context f134855b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends FrameLayout {
        public a(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            KeyEvent.DispatcherState keyDispatcherState;
            if (keyEvent.getKeyCode() == 4) {
                if (getKeyDispatcherState() == null) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                    x.this.dismiss();
                    return true;
                }
                return super.dispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (x.this.f134854a != null && x.this.f134854a.onTouch(this, motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public int[] onCreateDrawableState(int i3) {
            return super.onCreateDrawableState(i3);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x16 < 0 || x16 >= getWidth() || y16 < 0 || y16 >= getHeight())) {
                x.this.dismiss();
                return true;
            }
            if (motionEvent.getAction() == 4) {
                x.this.dismiss();
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i3) {
            if (getChildCount() == 1) {
                getChildAt(0).sendAccessibilityEvent(i3);
            } else {
                super.sendAccessibilityEvent(i3);
            }
            super.sendAccessibilityEvent(i3);
        }
    }

    public x(Context context) {
        super(context);
        this.f134855b = context;
        super.setBackgroundDrawable(null);
        setContentView(new a(this.f134855b));
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.lo.n.b("MicroMsg.MMPopupWindow", "dismiss exception, e = " + e16.getMessage(), new Object[0]);
        }
    }

    @Override // android.widget.PopupWindow
    public Drawable getBackground() {
        View contentView = getContentView();
        if (contentView == null || !(contentView instanceof a)) {
            return null;
        }
        return contentView.getBackground();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if (r2.height == (-2)) goto L15;
     */
    @Override // android.widget.PopupWindow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setBackgroundDrawable(Drawable drawable) {
        int i3;
        View contentView = getContentView();
        if (contentView == null) {
            return;
        }
        Context context = contentView.getContext();
        if (contentView instanceof a) {
            contentView.setBackgroundDrawable(drawable);
            return;
        }
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        if (layoutParams != null) {
            i3 = -2;
        }
        i3 = -1;
        a aVar = new a(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, i3);
        aVar.setBackgroundDrawable(drawable);
        aVar.addView(contentView, layoutParams2);
        super.setContentView(aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
    
        if (r1.height == (-2)) goto L17;
     */
    @Override // android.widget.PopupWindow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setContentView(View view) {
        int i3;
        View contentView = getContentView();
        if (contentView == null) {
            super.setContentView(view);
        } else if (contentView instanceof a) {
            a aVar = (a) contentView;
            aVar.removeAllViews();
            if (view == null) {
                super.setContentView(aVar);
                return;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                i3 = -2;
            }
            i3 = -1;
            aVar.addView(view, new FrameLayout.LayoutParams(-1, i3));
            super.setContentView(aVar);
            return;
        }
        super.setContentView(view);
    }

    @Override // android.widget.PopupWindow
    public void setTouchInterceptor(View.OnTouchListener onTouchListener) {
        this.f134854a = onTouchListener;
    }

    public x(View view) {
        super(view);
        this.f134855b = null;
        super.setBackgroundDrawable(null);
    }
}
