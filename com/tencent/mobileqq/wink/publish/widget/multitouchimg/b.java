package com.tencent.mobileqq.wink.publish.widget.multitouchimg;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f326121a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f326122b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final ScaleGestureDetector f326123c;

    /* renamed from: d, reason: collision with root package name */
    private VelocityTracker f326124d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f326125e;

    /* renamed from: f, reason: collision with root package name */
    private float f326126f;

    /* renamed from: g, reason: collision with root package name */
    private float f326127g;

    /* renamed from: h, reason: collision with root package name */
    private final float f326128h;

    /* renamed from: i, reason: collision with root package name */
    private final float f326129i;

    /* renamed from: j, reason: collision with root package name */
    private d f326130j;

    /* renamed from: k, reason: collision with root package name */
    private j f326131k;

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
                    b.this.f326130j.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            scaleGestureDetector.getScaleFactor();
            b.b(b.this);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (b.this.f326131k != null) {
                b.this.f326131k.onScaleEnd(scaleFactor);
            }
        }
    }

    public b(Context context, d dVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f326129i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f326128h = viewConfiguration.getScaledTouchSlop();
        this.f326130j = dVar;
        this.f326123c = new ScaleGestureDetector(context, new a());
    }

    static /* bridge */ /* synthetic */ h b(b bVar) {
        bVar.getClass();
        return null;
    }

    private float d(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f326122b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float e(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f326122b);
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
                            int b16 = n.b(motionEvent.getAction());
                            if (motionEvent.getPointerId(b16) == this.f326121a) {
                                if (b16 == 0) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                this.f326121a = motionEvent.getPointerId(i3);
                                this.f326126f = motionEvent.getX(i3);
                                this.f326127g = motionEvent.getY(i3);
                            }
                        }
                    } else {
                        this.f326121a = -1;
                        VelocityTracker velocityTracker = this.f326124d;
                        if (velocityTracker != null) {
                            velocityTracker.recycle();
                            this.f326124d = null;
                        }
                    }
                } else {
                    float d16 = d(motionEvent);
                    float e16 = e(motionEvent);
                    int pointerCount = motionEvent.getPointerCount();
                    float f16 = d16 - this.f326126f;
                    float f17 = e16 - this.f326127g;
                    if (!this.f326125e) {
                        if (Math.sqrt((f16 * f16) + (f17 * f17)) >= this.f326128h) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        this.f326125e = z16;
                    }
                    if (pointerCount > 1) {
                        this.f326125e = false;
                    }
                    if (this.f326125e) {
                        this.f326126f = d16;
                        this.f326127g = e16;
                        VelocityTracker velocityTracker2 = this.f326124d;
                        if (velocityTracker2 != null) {
                            velocityTracker2.addMovement(motionEvent);
                        }
                    }
                }
            } else {
                this.f326121a = -1;
                if (this.f326125e && this.f326124d != null) {
                    this.f326126f = d(motionEvent);
                    this.f326127g = e(motionEvent);
                    this.f326124d.addMovement(motionEvent);
                    this.f326124d.computeCurrentVelocity(1000);
                    float xVelocity = this.f326124d.getXVelocity();
                    float yVelocity = this.f326124d.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f326129i) {
                        this.f326130j.onFling(this.f326126f, this.f326127g, -xVelocity, -yVelocity);
                    }
                }
                VelocityTracker velocityTracker3 = this.f326124d;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f326124d = null;
                }
            }
        } else {
            this.f326121a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f326124d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f326126f = d(motionEvent);
            this.f326127g = e(motionEvent);
            this.f326125e = false;
        }
        int i17 = this.f326121a;
        if (i17 != -1) {
            i16 = i17;
        }
        this.f326122b = motionEvent.findPointerIndex(i16);
        return true;
    }

    public boolean f() {
        return this.f326125e;
    }

    public boolean g() {
        return this.f326123c.isInProgress();
    }

    public boolean h(MotionEvent motionEvent) {
        try {
            boolean onTouchEvent = this.f326123c.onTouchEvent(motionEvent);
            boolean i3 = i(motionEvent);
            if (!onTouchEvent || !i3) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void k(j jVar) {
        this.f326131k = jVar;
    }

    public void j(h hVar) {
    }
}
