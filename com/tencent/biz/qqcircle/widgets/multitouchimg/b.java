package com.tencent.biz.qqcircle.widgets.multitouchimg;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f93667a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f93668b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final ScaleGestureDetector f93669c;

    /* renamed from: d, reason: collision with root package name */
    private VelocityTracker f93670d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f93671e;

    /* renamed from: f, reason: collision with root package name */
    private float f93672f;

    /* renamed from: g, reason: collision with root package name */
    private float f93673g;

    /* renamed from: h, reason: collision with root package name */
    private final float f93674h;

    /* renamed from: i, reason: collision with root package name */
    private final float f93675i;

    /* renamed from: j, reason: collision with root package name */
    private f f93676j;

    /* renamed from: k, reason: collision with root package name */
    private j f93677k;

    /* renamed from: l, reason: collision with root package name */
    private l f93678l;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (!Float.isNaN(scaleFactor) && !Float.isInfinite(scaleFactor)) {
                if (scaleFactor >= 0.0f) {
                    b.this.f93676j.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (b.this.f93677k != null) {
                b.this.f93677k.onScaleBegin(scaleFactor);
                return true;
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (b.this.f93678l != null) {
                b.this.f93678l.onScaleEnd(scaleFactor);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, f fVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f93675i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f93674h = viewConfiguration.getScaledTouchSlop();
        this.f93676j = fVar;
        this.f93669c = new ScaleGestureDetector(context, new a(), new Handler(Looper.getMainLooper()));
    }

    private float d(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f93668b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float e(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f93668b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean i(MotionEvent motionEvent) {
        boolean z16;
        int i3;
        int action = motionEvent.getAction() & 255;
        int i16 = 0;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 6) {
                            int b16 = p.b(motionEvent.getAction());
                            if (motionEvent.getPointerId(b16) == this.f93667a) {
                                if (b16 == 0) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                this.f93667a = motionEvent.getPointerId(i3);
                                this.f93672f = motionEvent.getX(i3);
                                this.f93673g = motionEvent.getY(i3);
                            }
                        }
                    } else {
                        this.f93667a = -1;
                        VelocityTracker velocityTracker = this.f93670d;
                        if (velocityTracker != null) {
                            velocityTracker.recycle();
                            this.f93670d = null;
                        }
                    }
                } else {
                    float d16 = d(motionEvent);
                    float e16 = e(motionEvent);
                    int pointerCount = motionEvent.getPointerCount();
                    float f16 = d16 - this.f93672f;
                    float f17 = e16 - this.f93673g;
                    if (!this.f93671e) {
                        if (Math.sqrt((f16 * f16) + (f17 * f17)) >= this.f93674h) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        this.f93671e = z16;
                    }
                    if (pointerCount > 1) {
                        this.f93671e = false;
                    }
                    if (this.f93671e) {
                        this.f93672f = d16;
                        this.f93673g = e16;
                        VelocityTracker velocityTracker2 = this.f93670d;
                        if (velocityTracker2 != null) {
                            velocityTracker2.addMovement(motionEvent);
                        }
                    }
                }
            } else {
                this.f93667a = -1;
                if (this.f93671e && this.f93670d != null) {
                    this.f93672f = d(motionEvent);
                    this.f93673g = e(motionEvent);
                    this.f93670d.addMovement(motionEvent);
                    this.f93670d.computeCurrentVelocity(1000);
                    float xVelocity = this.f93670d.getXVelocity();
                    float yVelocity = this.f93670d.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f93675i) {
                        this.f93676j.onFling(this.f93672f, this.f93673g, -xVelocity, -yVelocity);
                    }
                }
                VelocityTracker velocityTracker3 = this.f93670d;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f93670d = null;
                }
            }
        } else {
            this.f93667a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f93670d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f93672f = d(motionEvent);
            this.f93673g = e(motionEvent);
            this.f93671e = false;
        }
        int i17 = this.f93667a;
        if (i17 != -1) {
            i16 = i17;
        }
        this.f93668b = motionEvent.findPointerIndex(i16);
        return true;
    }

    public boolean f() {
        return this.f93671e;
    }

    public boolean g() {
        return this.f93669c.isInProgress();
    }

    public boolean h(MotionEvent motionEvent) {
        try {
            boolean onTouchEvent = this.f93669c.onTouchEvent(motionEvent);
            boolean i3 = i(motionEvent);
            if (!onTouchEvent || !i3) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void j(j jVar) {
        this.f93677k = jVar;
    }

    public void k(l lVar) {
        this.f93678l = lVar;
    }
}
