package com.tencent.mobileqq.guild.widget.qqui.dragframe;

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
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@TargetApi(19)
/* loaded from: classes14.dex */
public class DragTextView extends TextView {
    private static int F;
    private static int G;
    private static int H;
    private final Handler C;
    private GestureDetector D;
    private GestureDetector.OnDoubleTapListener E;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.guild.widget.qqui.dragframe.b f236518d;

    /* renamed from: e, reason: collision with root package name */
    private int f236519e;

    /* renamed from: f, reason: collision with root package name */
    private String f236520f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f236521h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f236522i;

    /* renamed from: m, reason: collision with root package name */
    private View f236523m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (DragTextView.this.E != null) {
                return DragTextView.this.E.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (DragTextView.this.E != null) {
                DragTextView.this.E.onDoubleTap(motionEvent);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
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
    /* loaded from: classes14.dex */
    public class b extends TouchDelegate {
        public b(Rect rect, View view) {
            super(rect, view);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (DragTextView.this.getVisibility() != 0) {
                return false;
            }
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            motionEvent.setLocation(x16, y16);
            return onTouchEvent;
        }
    }

    public DragTextView(Context context) {
        super(context);
        this.f236519e = -1;
        this.f236522i = null;
        this.f236523m = null;
        this.C = new Handler(Looper.getMainLooper());
        d(context);
        c(context);
    }

    private void b(View view, Rect rect) {
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        super.getGlobalVisibleRect(rect);
        if (this.f236519e == 2) {
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

    private void c(Context context) {
        this.D = new GestureDetector(context, new a(), this.C);
    }

    private static void d(Context context) {
        if (F == 0) {
            float f16 = context.getResources().getDisplayMetrics().density * 16.0f;
            F = (int) f16;
            G = (int) (1.5f * f16);
            H = (int) (f16 * 0.5f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        Rect rect = this.f236522i;
        if (rect != null && z16) {
            b(this.f236523m, rect);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.E != null) {
            this.D.onTouchEvent(motionEvent);
        }
        if (this.f236519e != -1 && !this.f236521h && motionEvent.getAction() == 0) {
            com.tencent.mobileqq.guild.widget.qqui.dragframe.b bVar = this.f236518d;
            if (bVar != null) {
                this.f236521h = true;
                bVar.a(this, this.f236519e, this.f236520f);
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDragGroup(String str) {
        this.f236520f = str;
    }

    public void setDragViewType(int i3) {
        setDragViewType(i3, null);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.E = onDoubleTapListener;
    }

    public void setOnModeChangeListener(com.tencent.mobileqq.guild.widget.qqui.dragframe.b bVar) {
        this.f236518d = bVar;
        if (QLog.isColorLevel()) {
            QLog.d("Drag", 2, "setOnModeChangeListener:" + bVar);
        }
        if (this.f236518d != null && this.f236523m != null && this.f236522i == null) {
            this.f236522i = new Rect();
            this.f236523m.setTouchDelegate(new b(this.f236522i, this));
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (this.f236521h && i3 == 0) {
            this.f236521h = false;
        }
    }

    public void setDragViewType(int i3, View view) {
        this.f236519e = i3;
        this.f236523m = view;
        if (view == null) {
            this.f236523m = (ViewGroup) getParent();
        }
        if (this.f236518d == null || this.f236523m == null || this.f236522i != null) {
            return;
        }
        this.f236522i = new Rect();
        this.f236523m.setTouchDelegate(new b(this.f236522i, this));
    }

    public DragTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f236519e = -1;
        this.f236522i = null;
        this.f236523m = null;
        this.C = new Handler(Looper.getMainLooper());
        d(context);
        c(context);
    }

    public DragTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236519e = -1;
        this.f236522i = null;
        this.f236523m = null;
        this.C = new Handler(Looper.getMainLooper());
        d(context);
        c(context);
    }
}
