package com.tencent.mobileqq.activity.recent.cur;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQUIAppSetting;

/* compiled from: P */
@TargetApi(19)
/* loaded from: classes10.dex */
public class DragTextView extends TextView {
    static IPatchRedirector $redirector_;
    private static int F;
    private static int G;
    private static int H;
    private final Handler C;
    private GestureDetector D;
    private GestureDetector.OnDoubleTapListener E;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.activity.recent.cur.b f185371d;

    /* renamed from: e, reason: collision with root package name */
    private int f185372e;

    /* renamed from: f, reason: collision with root package name */
    private String f185373f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f185374h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f185375i;

    /* renamed from: m, reason: collision with root package name */
    private View f185376m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DragTextView.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (DragTextView.this.E != null) {
                return DragTextView.this.E.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (DragTextView.this.E != null) {
                DragTextView.this.E.onSingleTapConfirmed(motionEvent);
            }
            ViewParent parent = DragTextView.this.getParent();
            if (parent != null) {
                ((ViewGroup) parent).performClick();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends TouchDelegate {
        static IPatchRedirector $redirector_;

        public b(Rect rect, View view) {
            super(rect, view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DragTextView.this, rect, view);
            }
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (DragTextView.this.getVisibility() != 0) {
                return false;
            }
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            if (!QQUIAppSetting.isPublicVersion() && QLog.isColorLevel() && motionEvent.getAction() == 0) {
                QLog.d("DragTextView", 2, "TouchDelegate onTouchEvent: " + motionEvent + "; cur Rect:" + DragTextView.this.f185375i);
            }
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            motionEvent.setLocation(x16, y16);
            return onTouchEvent;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46471);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            F = 0;
        }
    }

    public DragTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f185372e = -1;
        this.f185375i = null;
        this.f185376m = null;
        this.C = new Handler(Looper.getMainLooper());
        f(context);
        e(context);
    }

    private void d(View view, Rect rect) {
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        super.getGlobalVisibleRect(rect);
        if (this.f185372e == 2) {
            int i3 = rect.top - rect2.top;
            int i16 = F;
            rect.top = i3 - i16;
            int i17 = rect.left - rect2.left;
            int i18 = H;
            rect.left = i17 - i18;
            rect.bottom = (rect.bottom - rect2.top) + i18;
            rect.right = (rect.right - rect2.left) + i16;
            return;
        }
        int i19 = rect.top - rect2.top;
        int i26 = G;
        rect.top = i19 - i26;
        rect.left = (rect.left - rect2.left) - i26;
        int i27 = rect.bottom - rect2.top;
        int i28 = F;
        rect.bottom = i27 + i28;
        rect.right = (rect.right - rect2.left) + i28;
    }

    private void e(Context context) {
        this.D = new GestureDetector(context, new a(), this.C);
    }

    private static void f(Context context) {
        if (F == 0) {
            float f16 = context.getResources().getDisplayMetrics().density * 16.0f;
            F = (int) f16;
            G = (int) (1.5f * f16);
            H = (int) (f16 * 0.5f);
        }
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f185372e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        Rect rect = this.f185375i;
        if (rect != null && z16) {
            d(this.f185376m, rect);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            QLog.d("DragTextView", 1, "onTouchEvent  text:" + ((Object) getText()) + ", textSize:" + getTextSize() + ", tag:" + getTag());
        }
        if (this.E != null) {
            this.D.onTouchEvent(motionEvent);
        }
        if (this.f185372e != -1 && !this.f185374h && motionEvent.getAction() == 0) {
            if (this.f185371d != null) {
                if (!QQUIAppSetting.isPublicVersion() && QLog.isColorLevel()) {
                    QLog.d("DragTextView", 2, "onTouchEvent hit: " + motionEvent + "; cur Rect:" + this.f185375i);
                }
                this.f185374h = true;
                this.f185371d.onModeChanged(this, this.f185372e, -1, this.f185373f);
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDragGroup(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.f185373f = str;
        }
    }

    public void setDragViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            setDragViewType(i3, null);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onDoubleTapListener);
        } else {
            this.E = onDoubleTapListener;
        }
    }

    public void setOnModeChangeListener(com.tencent.mobileqq.activity.recent.cur.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
            return;
        }
        this.f185371d = bVar;
        if (QLog.isColorLevel()) {
            QLog.d("Drag", 2, "setOnModeChangeListener:" + bVar);
        }
        if (this.f185371d != null && this.f185376m != null && this.f185375i == null) {
            this.f185375i = new Rect();
            this.f185376m.setTouchDelegate(new b(this.f185375i, this));
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        super.setVisibility(i3);
        if (this.f185374h && i3 == 0) {
            this.f185374h = false;
        }
    }

    public void setDragViewType(int i3, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) view);
            return;
        }
        this.f185372e = i3;
        this.f185376m = view;
        if (view == null) {
            this.f185376m = (ViewGroup) getParent();
        }
        if (this.f185371d == null || this.f185376m == null || this.f185375i != null) {
            return;
        }
        this.f185375i = new Rect();
        this.f185376m.setTouchDelegate(new b(this.f185375i, this));
    }

    public DragTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f185372e = -1;
        this.f185375i = null;
        this.f185376m = null;
        this.C = new Handler(Looper.getMainLooper());
        f(context);
        e(context);
    }

    public DragTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f185372e = -1;
        this.f185375i = null;
        this.f185376m = null;
        this.C = new Handler(Looper.getMainLooper());
        f(context);
        e(context);
    }
}
