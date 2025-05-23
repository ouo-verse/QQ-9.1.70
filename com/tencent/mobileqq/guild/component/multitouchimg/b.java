package com.tencent.mobileqq.guild.component.multitouchimg;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f215998a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f215999b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final ScaleGestureDetector f216000c;

    /* renamed from: d, reason: collision with root package name */
    private VelocityTracker f216001d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f216002e;

    /* renamed from: f, reason: collision with root package name */
    private float f216003f;

    /* renamed from: g, reason: collision with root package name */
    private float f216004g;

    /* renamed from: h, reason: collision with root package name */
    private final float f216005h;

    /* renamed from: i, reason: collision with root package name */
    private final float f216006i;

    /* renamed from: j, reason: collision with root package name */
    private f f216007j;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (!Float.isNaN(scaleFactor) && !Float.isInfinite(scaleFactor)) {
                if (scaleFactor >= 0.0f) {
                    b.this.f216007j.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
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
            scaleGestureDetector.getScaleFactor();
            b.c(b.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, f fVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f216006i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f216005h = viewConfiguration.getScaledTouchSlop();
        this.f216007j = fVar;
        this.f216000c = new ScaleGestureDetector(context, new a(), new Handler(Looper.getMainLooper()));
    }

    static /* bridge */ /* synthetic */ j b(b bVar) {
        bVar.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ l c(b bVar) {
        bVar.getClass();
        return null;
    }

    private float d(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f215999b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float e(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f215999b);
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
                            int b16 = q.b(motionEvent.getAction());
                            if (motionEvent.getPointerId(b16) == this.f215998a) {
                                if (b16 == 0) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                this.f215998a = motionEvent.getPointerId(i3);
                                this.f216003f = motionEvent.getX(i3);
                                this.f216004g = motionEvent.getY(i3);
                            }
                        }
                    } else {
                        this.f215998a = -1;
                        VelocityTracker velocityTracker = this.f216001d;
                        if (velocityTracker != null) {
                            velocityTracker.recycle();
                            this.f216001d = null;
                        }
                    }
                } else {
                    float d16 = d(motionEvent);
                    float e16 = e(motionEvent);
                    int pointerCount = motionEvent.getPointerCount();
                    float f16 = d16 - this.f216003f;
                    float f17 = e16 - this.f216004g;
                    if (!this.f216002e) {
                        if (Math.sqrt((f16 * f16) + (f17 * f17)) >= this.f216005h) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        this.f216002e = z16;
                    }
                    if (pointerCount > 1) {
                        this.f216002e = false;
                    }
                    if (this.f216002e) {
                        this.f216003f = d16;
                        this.f216004g = e16;
                        VelocityTracker velocityTracker2 = this.f216001d;
                        if (velocityTracker2 != null) {
                            velocityTracker2.addMovement(motionEvent);
                        }
                    }
                }
            } else {
                this.f215998a = -1;
                if (this.f216002e && this.f216001d != null) {
                    this.f216003f = d(motionEvent);
                    this.f216004g = e(motionEvent);
                    this.f216001d.addMovement(motionEvent);
                    this.f216001d.computeCurrentVelocity(1000);
                    float xVelocity = this.f216001d.getXVelocity();
                    float yVelocity = this.f216001d.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f216006i) {
                        this.f216007j.onFling(this.f216003f, this.f216004g, -xVelocity, -yVelocity);
                    }
                }
                VelocityTracker velocityTracker3 = this.f216001d;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f216001d = null;
                }
            }
        } else {
            this.f215998a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f216001d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f216003f = d(motionEvent);
            this.f216004g = e(motionEvent);
            this.f216002e = false;
        }
        int i17 = this.f215998a;
        if (i17 != -1) {
            i16 = i17;
        }
        this.f215999b = motionEvent.findPointerIndex(i16);
        return true;
    }

    public boolean f() {
        return this.f216002e;
    }

    public boolean g() {
        return this.f216000c.isInProgress();
    }

    public boolean h(MotionEvent motionEvent) {
        try {
            boolean onTouchEvent = this.f216000c.onTouchEvent(motionEvent);
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
    }

    public void k(l lVar) {
    }
}
