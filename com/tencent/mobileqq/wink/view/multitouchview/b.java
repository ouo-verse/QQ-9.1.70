package com.tencent.mobileqq.wink.view.multitouchview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f327049a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f327050b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final ScaleGestureDetector f327051c;

    /* renamed from: d, reason: collision with root package name */
    private VelocityTracker f327052d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f327053e;

    /* renamed from: f, reason: collision with root package name */
    private float f327054f;

    /* renamed from: g, reason: collision with root package name */
    private float f327055g;

    /* renamed from: h, reason: collision with root package name */
    private final float f327056h;

    /* renamed from: i, reason: collision with root package name */
    private final float f327057i;

    /* renamed from: j, reason: collision with root package name */
    private c f327058j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f327057i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f327056h = viewConfiguration.getScaledTouchSlop();
        this.f327058j = cVar;
        this.f327051c = new ScaleGestureDetector(context, new a());
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f327050b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f327050b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean g(MotionEvent motionEvent) {
        boolean z16;
        int i3;
        int action = motionEvent.getAction() & 255;
        int i16 = 0;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 6) {
                            int a16 = e.a(motionEvent.getAction());
                            if (motionEvent.getPointerId(a16) == this.f327049a) {
                                if (a16 == 0) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                this.f327049a = motionEvent.getPointerId(i3);
                                this.f327054f = motionEvent.getX(i3);
                                this.f327055g = motionEvent.getY(i3);
                            }
                        }
                    } else {
                        this.f327049a = -1;
                        VelocityTracker velocityTracker = this.f327052d;
                        if (velocityTracker != null) {
                            velocityTracker.recycle();
                            this.f327052d = null;
                        }
                    }
                } else {
                    float b16 = b(motionEvent);
                    float c16 = c(motionEvent);
                    int pointerCount = motionEvent.getPointerCount();
                    float f16 = b16 - this.f327054f;
                    float f17 = c16 - this.f327055g;
                    if (!this.f327053e) {
                        if (Math.sqrt((f16 * f16) + (f17 * f17)) >= this.f327056h) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        this.f327053e = z16;
                    }
                    if (pointerCount > 1) {
                        this.f327053e = false;
                    }
                    if (this.f327053e) {
                        this.f327054f = b16;
                        this.f327055g = c16;
                        VelocityTracker velocityTracker2 = this.f327052d;
                        if (velocityTracker2 != null) {
                            velocityTracker2.addMovement(motionEvent);
                        }
                    }
                }
            } else {
                this.f327049a = -1;
                if (this.f327053e && this.f327052d != null) {
                    this.f327054f = b(motionEvent);
                    this.f327055g = c(motionEvent);
                    this.f327052d.addMovement(motionEvent);
                    this.f327052d.computeCurrentVelocity(1000);
                    float xVelocity = this.f327052d.getXVelocity();
                    float yVelocity = this.f327052d.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f327057i) {
                        this.f327058j.onFling(this.f327054f, this.f327055g, -xVelocity, -yVelocity);
                    }
                }
                VelocityTracker velocityTracker3 = this.f327052d;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f327052d = null;
                }
            }
        } else {
            this.f327049a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f327052d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f327054f = b(motionEvent);
            this.f327055g = c(motionEvent);
            this.f327053e = false;
        }
        int i17 = this.f327049a;
        if (i17 != -1) {
            i16 = i17;
        }
        this.f327050b = motionEvent.findPointerIndex(i16);
        return true;
    }

    public boolean d() {
        return this.f327053e;
    }

    public boolean e() {
        return this.f327051c.isInProgress();
    }

    public boolean f(MotionEvent motionEvent) {
        try {
            boolean onTouchEvent = this.f327051c.onTouchEvent(motionEvent);
            boolean g16 = g(motionEvent);
            if (!onTouchEvent || !g16) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (!Float.isNaN(scaleFactor) && !Float.isInfinite(scaleFactor)) {
                if (scaleFactor >= 0.0f) {
                    b.this.f327058j.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }
}
