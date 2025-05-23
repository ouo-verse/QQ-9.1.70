package com.tencent.biz.qqcircle.push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
public class QFSFastPushGestureLayout extends FrameLayout {
    private int C;
    private Runnable D;

    /* renamed from: d, reason: collision with root package name */
    private GestureDetector f91779d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f91780e;

    /* renamed from: f, reason: collision with root package name */
    private int f91781f;

    /* renamed from: h, reason: collision with root package name */
    private int f91782h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f91783i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f91784m;

    /* loaded from: classes5.dex */
    public interface b {
    }

    public QFSFastPushGestureLayout(@NonNull Context context) {
        this(context, null);
    }

    static /* bridge */ /* synthetic */ b b(QFSFastPushGestureLayout qFSFastPushGestureLayout) {
        qFSFastPushGestureLayout.getClass();
        return null;
    }

    private GestureDetector i() {
        if (this.f91779d == null) {
            this.f91779d = new GestureDetector(getContext(), new a());
        }
        return this.f91779d;
    }

    private void j() {
        this.D = new Runnable() { // from class: com.tencent.biz.qqcircle.push.QFSFastPushGestureLayout.2
            @Override // java.lang.Runnable
            public void run() {
                QFSFastPushGestureLayout qFSFastPushGestureLayout = QFSFastPushGestureLayout.this;
                qFSFastPushGestureLayout.C--;
                if (QFSFastPushGestureLayout.this.C <= 0 && !QFSFastPushGestureLayout.this.f91784m && !QFSFastPushGestureLayout.this.f91783i) {
                    QFSFastPushGestureLayout.this.k();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f91780e = true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        i().onTouchEvent(motionEvent);
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    l(motionEvent.getRawX(), motionEvent.getRawY());
                    if (!this.f91783i && (Math.abs(this.f91781f - x16) > 20 || Math.abs(this.f91782h - y16) > 20)) {
                        this.f91783i = true;
                    }
                }
            } else {
                m(motionEvent.getRawX(), motionEvent.getRawY());
                this.f91784m = true;
            }
        } else {
            this.f91781f = x16;
            this.f91782h = y16;
            this.C++;
            this.f91784m = false;
            this.f91783i = false;
            postDelayed(this.D, 100L);
        }
        return true;
    }

    public QFSFastPushGestureLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSFastPushGestureLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public QFSFastPushGestureLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f91780e = false;
        j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements GestureDetector.OnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            QFSFastPushGestureLayout.this.f91780e = false;
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (QFSFastPushGestureLayout.this.f91780e) {
                return false;
            }
            QFSFastPushGestureLayout.b(QFSFastPushGestureLayout.this);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }
    }

    public void setGestureListener(b bVar) {
    }

    private void l(float f16, float f17) {
    }

    private void m(float f16, float f17) {
    }
}
