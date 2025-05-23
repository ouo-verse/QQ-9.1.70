package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mapsdk.internal.lc;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qk implements View.OnTouchListener {
    private static final int I = 50;

    /* renamed from: b, reason: collision with root package name */
    private static final int f149849b = 255;

    /* renamed from: c, reason: collision with root package name */
    private static final int f149850c = 5;

    /* renamed from: d, reason: collision with root package name */
    private static final int f149851d = 6;

    /* renamed from: e, reason: collision with root package name */
    private static final double f149852e = 2.5d;

    /* renamed from: f, reason: collision with root package name */
    private static final double f149853f = 0.5d;

    /* renamed from: g, reason: collision with root package name */
    private static final double f149854g = 0.003d;

    /* renamed from: h, reason: collision with root package name */
    private static final double f149855h = 0.001d;

    /* renamed from: i, reason: collision with root package name */
    private static final double f149856i = 0.1d;

    /* renamed from: j, reason: collision with root package name */
    private static final double f149857j = 0.5d;

    /* renamed from: k, reason: collision with root package name */
    private static final int f149858k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static final int f149859l = 1;

    /* renamed from: m, reason: collision with root package name */
    private static final int f149860m = 2;

    /* renamed from: n, reason: collision with root package name */
    private static final int f149861n = 4;

    /* renamed from: o, reason: collision with root package name */
    private static final int f149862o = 8;

    /* renamed from: p, reason: collision with root package name */
    private static final float f149863p = (float) Math.cos(0.0017453292780017621d);

    /* renamed from: q, reason: collision with root package name */
    private static final int f149864q = 10;

    /* renamed from: u, reason: collision with root package name */
    private static final int f149865u = 120;
    private final GestureDetector E;
    private final bf F;
    private final WeakReference<tz> G;
    private final a H;
    private Method J;
    private Method K;

    /* renamed from: a, reason: collision with root package name */
    public final ql f149866a;

    /* renamed from: r, reason: collision with root package name */
    private boolean f149867r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f149868s;

    /* renamed from: t, reason: collision with root package name */
    private long f149869t;

    /* renamed from: v, reason: collision with root package name */
    private int f149870v = 0;

    /* renamed from: w, reason: collision with root package name */
    private final PointF f149871w = new PointF();

    /* renamed from: x, reason: collision with root package name */
    private final PointF f149872x = new PointF();

    /* renamed from: y, reason: collision with root package name */
    private final PointF f149873y = new PointF();

    /* renamed from: z, reason: collision with root package name */
    private final PointF f149874z = new PointF();
    private final PointF A = new PointF();
    private final PointF B = new PointF();
    private final PointF C = new PointF();
    private long D = 0;

    public qk(tz tzVar) {
        a aVar = new a(this, (byte) 0);
        this.H = aVar;
        this.G = new WeakReference<>(tzVar);
        GestureDetector gestureDetector = new GestureDetector(tzVar.H(), aVar);
        this.E = gestureDetector;
        this.f149866a = new ql();
        this.F = (bf) tzVar.d_;
        gestureDetector.setOnDoubleTapListener(aVar);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        qk qkVar;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        double d16;
        boolean z36;
        double max;
        boolean z37;
        float max2;
        boolean z38;
        boolean z39;
        boolean z46;
        boolean z47;
        boolean z48;
        double d17;
        boolean z49;
        boolean a16;
        int width;
        int height;
        float f16;
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action != 6 || this.f149868s) {
                                qkVar = this;
                            } else {
                                this.f149868s = true;
                                this.f149866a.d();
                                return true;
                            }
                        } else {
                            this.D = SystemClock.elapsedRealtime();
                            this.f149870v = 0;
                            this.f149867r = true;
                            this.f149869t = SystemClock.elapsedRealtime();
                            this.f149868s = false;
                            a(this.f149873y, this.f149874z, motionEvent);
                            this.f149866a.c();
                            return true;
                        }
                    }
                } else {
                    if (this.f149867r && !this.f149868s) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (elapsedRealtime - this.f149869t < 8) {
                            return true;
                        }
                        this.f149869t = elapsedRealtime;
                        a(this.f149871w, this.f149872x, motionEvent);
                        PointF pointF = this.f149871w;
                        float f17 = pointF.x;
                        PointF pointF2 = this.f149873y;
                        float f18 = f17 - pointF2.x;
                        float f19 = pointF.y - pointF2.y;
                        PointF pointF3 = this.f149872x;
                        float f26 = pointF3.x;
                        PointF pointF4 = this.f149874z;
                        float f27 = f26 - pointF4.x;
                        float f28 = pointF3.y - pointF4.y;
                        if (Math.abs(f19) > Math.abs(f18) * 1.5d && Math.abs(f28) > Math.abs(f27) * 1.5d) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (Math.abs(f19) > Math.abs(f18) * 1.5d && Math.abs(f28) > Math.abs(f27) * 1.5d) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (Math.abs(f18) > Math.abs(f19) * 1.5d && Math.abs(f27) > Math.abs(f28) * 1.5d) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (Math.abs(f18) > Math.abs(f19) * 1.5d && Math.abs(f27) > Math.abs(f28) * 1.5d) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        float f29 = f18 * f27;
                        if (f29 > 0.0f) {
                            z27 = true;
                        } else {
                            z27 = false;
                        }
                        float f36 = f19 * f28;
                        if (f36 > 0.0f) {
                            z28 = true;
                        } else {
                            z28 = false;
                        }
                        int i3 = this.f149870v;
                        if ((i3 & 8) == 0 && (i3 & 1) == 0 && (i3 & 4) == 0) {
                            z29 = false;
                        } else {
                            z29 = true;
                        }
                        double d18 = 0.5d;
                        if (z29) {
                            d16 = f149856i;
                        } else {
                            d16 = 0.5d;
                        }
                        if (f29 > 0.0f) {
                            z36 = z18;
                            max = Math.abs(f18 + f27);
                        } else {
                            z36 = z18;
                            max = Math.max(Math.abs(f18), Math.abs(f27));
                        }
                        if (f36 > 0.0f) {
                            max2 = Math.abs(f19 + f28);
                            z37 = z28;
                        } else {
                            z37 = z28;
                            max2 = Math.max(Math.abs(f19), Math.abs(f28));
                        }
                        double max3 = Math.max(max, max2);
                        if (max3 > d16) {
                            z38 = true;
                        } else {
                            z38 = false;
                        }
                        if (z38 && z27 && ((z19 || z26) && this.G.get().g())) {
                            z39 = true;
                        } else {
                            z39 = false;
                        }
                        if (z38 && z37 && ((z17 || z36) && this.G.get().i())) {
                            z46 = true;
                        } else {
                            z46 = false;
                        }
                        PointF pointF5 = this.f149874z;
                        float f37 = pointF5.x;
                        PointF pointF6 = this.f149873y;
                        boolean z55 = z39;
                        double d19 = f37 - pointF6.x;
                        double d26 = pointF5.y - pointF6.y;
                        PointF pointF7 = this.f149872x;
                        float f38 = pointF7.x;
                        PointF pointF8 = this.f149871w;
                        boolean z56 = z37;
                        boolean z57 = z27;
                        double d27 = f38 - pointF8.x;
                        double d28 = pointF7.y - pointF8.y;
                        double sqrt = Math.sqrt((d19 * d19) + (d26 * d26));
                        double sqrt2 = Math.sqrt((d27 * d27) + (d28 * d28));
                        double d29 = sqrt * sqrt2;
                        double d36 = ((d19 * d27) + (d26 * d28)) / d29;
                        boolean z58 = z46;
                        double acos = (Math.acos(d36) * 180.0d) / 3.141592653589793d;
                        if ((d19 * d28) - (d26 * d27) < 0.0d) {
                            acos = -acos;
                        }
                        if (Math.abs(d36) < f149863p) {
                            z47 = true;
                        } else {
                            z47 = false;
                        }
                        if ((this.f149870v & 2) == 0) {
                            d18 = f149852e;
                        }
                        double abs = Math.abs(acos);
                        if (d29 > 0.0d && z47 && Math.abs(acos) > d18 && this.G.get().j()) {
                            z48 = true;
                        } else {
                            z48 = false;
                        }
                        double d37 = sqrt2 / sqrt;
                        if (z29) {
                            d17 = 0.001d;
                        } else {
                            d17 = f149854g;
                        }
                        double d38 = d37 - 1.0d;
                        double d39 = acos;
                        double abs2 = Math.abs(d38);
                        if (sqrt > 0.0d && abs2 > d17 && this.G.get().h()) {
                            z49 = true;
                        } else {
                            z49 = false;
                        }
                        boolean z59 = z49;
                        lc.a(ky.f149115u).a("trace-gesture", "began:" + z38 + ":" + z49 + ":" + z48, "value:" + max3 + ":" + abs2 + ":" + abs);
                        if (z48) {
                            z38 = false;
                        }
                        if (z58) {
                            z48 = false;
                            z55 = false;
                            z59 = false;
                        }
                        lc.a(ky.f149115u).a("beganMove:".concat(String.valueOf(z38)), "vertical:".concat(String.valueOf(z56)), "horizontal:".concat(String.valueOf(z57)), "verticalMove:".concat(String.valueOf(z58)), "horizontalMove:".concat(String.valueOf(z55)));
                        lc.a(ky.f149115u).a("beganRotate:".concat(String.valueOf(z48)), "cosValue : ".concat(String.valueOf(d36)), "cosAngle : ".concat(String.valueOf(z47)), "angle:".concat(String.valueOf(d39)), "rotateJudge : ".concat(String.valueOf(d18)));
                        lc.a(ky.f149115u).a("beganScale:".concat(String.valueOf(z59)), "d1:".concat(String.valueOf(sqrt)), "scale - 1 = " + Math.abs(d38), "scaleJudge : ".concat(String.valueOf(d17)));
                        if (z38) {
                            if (z55) {
                                this.f149870v |= 8;
                                lc.a(ky.f149115u).a("MT_INTENT_MOVE");
                                this.f149866a.d((f18 + f27) / 2.0f, (f19 + f28) / 2.0f);
                            }
                            if (z58) {
                                this.f149870v |= 1;
                                lc.a(ky.f149115u).a("MT_INTENT_MOVE_VERTICAL");
                                PointF pointF9 = this.f149873y;
                                PointF pointF10 = this.f149871w;
                                pointF9.set(pointF10.x, pointF10.y);
                                PointF pointF11 = this.f149874z;
                                PointF pointF12 = this.f149872x;
                                pointF11.set(pointF12.x, pointF12.y);
                                ql qlVar = this.f149866a;
                                if (Math.abs(f19) > Math.abs(f28)) {
                                    f16 = f19;
                                } else {
                                    f16 = f28;
                                }
                                qlVar.a(f16);
                            }
                        }
                        if (z48) {
                            this.f149870v |= 2;
                            lc.a(ky.f149115u).a("MT_INTENT_ROTATE");
                            if (z57 && !this.G.get().g()) {
                                PointF pointF13 = this.f149873y;
                                PointF pointF14 = this.f149871w;
                                pointF13.set(pointF14.x, pointF14.y);
                                PointF pointF15 = this.f149874z;
                                PointF pointF16 = this.f149872x;
                                pointF15.set(pointF16.x, pointF16.y);
                                lc.a(ky.f149115u).a("NO_HORIZONAL_ROTATE");
                                return true;
                            }
                            PointF pointF17 = this.f149874z;
                            PointF pointF18 = this.f149873y;
                            PointF pointF19 = this.f149872x;
                            PointF pointF20 = this.f149871w;
                            float f39 = pointF18.x;
                            float f46 = pointF17.x;
                            PointF pointF21 = null;
                            if (f39 != f46) {
                                float f47 = pointF20.x;
                                float f48 = pointF19.x;
                                if (f47 != f48) {
                                    float f49 = pointF18.y;
                                    float f56 = pointF17.y;
                                    float f57 = (f49 - f56) / (f39 - f46);
                                    float f58 = pointF20.y;
                                    float f59 = pointF19.y;
                                    float f65 = (f58 - f59) / (f47 - f48);
                                    if (f57 != f65) {
                                        float f66 = ((f59 * f47) - (f58 * f48)) / (f47 - f48);
                                        float f67 = (f66 - (((f56 * f39) - (f49 * f46)) / (f39 - f46))) / (f57 - f65);
                                        pointF21 = new PointF(f67, (f65 * f67) + f66);
                                    }
                                }
                            }
                            if (pointF21 == null) {
                                a16 = false;
                            } else {
                                a16 = a(pointF21.x, pointF21.y);
                            }
                            if (a16) {
                                bf bfVar = this.F;
                                if (bfVar == null) {
                                    width = 0;
                                } else {
                                    width = bfVar.h().width() / 2;
                                }
                                bf bfVar2 = this.F;
                                if (bfVar2 == null) {
                                    height = 0;
                                } else {
                                    height = bfVar2.h().height() / 2;
                                }
                                this.C.set(width, height);
                                ql qlVar2 = this.f149866a;
                                PointF pointF22 = this.C;
                                qlVar2.a(pointF22, pointF22, (float) d39);
                            } else {
                                PointF pointF23 = this.A;
                                PointF pointF24 = this.f149873y;
                                float f68 = pointF24.x;
                                PointF pointF25 = this.f149874z;
                                pointF23.set((f68 + pointF25.x) / 2.0f, (pointF24.y + pointF25.y) / 2.0f);
                                PointF pointF26 = this.B;
                                PointF pointF27 = this.f149871w;
                                float f69 = pointF27.x;
                                PointF pointF28 = this.f149872x;
                                pointF26.set((f69 + pointF28.x) / 2.0f, (pointF27.y + pointF28.y) / 2.0f);
                                this.f149866a.a(this.A, this.B, (float) d39);
                            }
                        }
                        if (z59) {
                            this.f149870v |= 4;
                            lc.a(ky.f149115u).a("MT_INTENT_SCALE");
                            if (z57 && !this.G.get().g()) {
                                PointF pointF29 = this.f149873y;
                                PointF pointF30 = this.f149871w;
                                pointF29.set(pointF30.x, pointF30.y);
                                PointF pointF31 = this.f149874z;
                                PointF pointF32 = this.f149872x;
                                pointF31.set(pointF32.x, pointF32.y);
                                lc.a(ky.f149115u).a("NO_HORIZONAL_SCALE");
                                return true;
                            }
                            PointF pointF33 = this.A;
                            PointF pointF34 = this.f149873y;
                            float f75 = pointF34.x;
                            PointF pointF35 = this.f149874z;
                            pointF33.set((f75 + pointF35.x) / 2.0f, (pointF34.y + pointF35.y) / 2.0f);
                            PointF pointF36 = this.B;
                            PointF pointF37 = this.f149871w;
                            float f76 = pointF37.x;
                            PointF pointF38 = this.f149872x;
                            pointF36.set((f76 + pointF38.x) / 2.0f, (pointF37.y + pointF38.y) / 2.0f);
                            this.f149866a.a(this.A, this.B, sqrt, sqrt2);
                        }
                        PointF pointF39 = this.f149873y;
                        PointF pointF40 = this.f149871w;
                        pointF39.set(pointF40.x, pointF40.y);
                        PointF pointF41 = this.f149874z;
                        PointF pointF42 = this.f149872x;
                        pointF41.set(pointF42.x, pointF42.y);
                        return true;
                    }
                    qkVar = this;
                    qkVar.f149866a.k(motionEvent.getX(), motionEvent.getY());
                }
            }
            qkVar = this;
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - qkVar.D;
            if (qkVar.f149870v == 0 && elapsedRealtime2 > 0 && elapsedRealtime2 < 200) {
                PointF pointF43 = qkVar.f149873y;
                float f77 = pointF43.x;
                PointF pointF44 = qkVar.f149874z;
                double d46 = f77 - pointF44.x;
                double d47 = pointF43.y - pointF44.y;
                if ((d46 * d46) + (d47 * d47) > 2500.0d) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    qkVar.f149866a.b();
                }
            }
            qkVar.f149866a.j(motionEvent.getX(), motionEvent.getY());
        } else {
            qkVar = this;
            qkVar.D = 0L;
            qkVar.f149867r = false;
            qkVar.f149866a.i(motionEvent.getX(), motionEvent.getY());
        }
        if (!qkVar.f149867r) {
            qkVar.E.onTouchEvent(motionEvent);
            return true;
        }
        return true;
    }

    private void b(fd fdVar) {
        synchronized (this.f149866a) {
            this.f149866a.b(fdVar);
        }
    }

    private boolean c() {
        PointF pointF = this.f149873y;
        float f16 = pointF.x;
        PointF pointF2 = this.f149874z;
        double d16 = f16 - pointF2.x;
        double d17 = pointF.y - pointF2.y;
        return (d16 * d16) + (d17 * d17) > 2500.0d;
    }

    public final void a(fd fdVar) {
        synchronized (this.f149866a) {
            this.f149866a.a(fdVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: b, reason: collision with root package name */
        private PointF f149876b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f149877c;

        a() {
            this.f149876b = new PointF();
            this.f149877c = true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        PointF pointF = this.f149876b;
                        float f16 = x16 - pointF.x;
                        float f17 = y16 - pointF.y;
                        if (Math.abs(f16) > 10.0f || Math.abs(f17) > 10.0f) {
                            this.f149877c = false;
                            qk.this.f149866a.g(x16, y16);
                        }
                        qk.this.E.setIsLongpressEnabled(true);
                    }
                } else {
                    if (this.f149877c) {
                        qk.this.f149866a.a(x16, y16);
                    }
                    this.f149876b.set(0.0f, 0.0f);
                    qk.this.E.setIsLongpressEnabled(true);
                    qk.this.f149866a.h(x16, y16);
                }
            } else {
                this.f149877c = true;
                qk.this.E.setIsLongpressEnabled(false);
                this.f149876b.set(motionEvent.getX(), motionEvent.getY());
                qk.this.f149866a.f(x16, y16);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            qk.this.f149866a.c(f16, f17);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
            if (!qk.this.f149867r) {
                qk.this.f149866a.e(motionEvent.getX(), motionEvent.getY());
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (qk.this.G != null && qk.this.G.get() != null && ((tz) qk.this.G.get()).ak()) {
                double sqrt = Math.sqrt((f16 * f16) + (f17 * f17));
                if ((motionEvent != null && (motionEvent.getX() < 0.0f || motionEvent.getY() < 0.0f)) || ((motionEvent2 != null && (motionEvent2.getX() < 0.0f || motionEvent2.getY() < 0.0f)) || sqrt > 50.0d)) {
                    return true;
                }
            }
            qk.this.f149866a.d(-f16, -f17);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            qk.this.f149866a.b(motionEvent.getX(), motionEvent.getY());
            return true;
        }

        /* synthetic */ a(qk qkVar, byte b16) {
            this();
        }
    }

    private void a() {
        double max;
        float f16;
        boolean z16;
        double max2;
        PointF pointF = this.f149871w;
        float f17 = pointF.x;
        PointF pointF2 = this.f149873y;
        float f18 = f17 - pointF2.x;
        float f19 = pointF.y - pointF2.y;
        PointF pointF3 = this.f149872x;
        float f26 = pointF3.x;
        PointF pointF4 = this.f149874z;
        float f27 = f26 - pointF4.x;
        float f28 = pointF3.y - pointF4.y;
        boolean z17 = ((double) Math.abs(f19)) > ((double) Math.abs(f18)) * 1.5d && ((double) Math.abs(f28)) > ((double) Math.abs(f27)) * 1.5d;
        boolean z18 = ((double) Math.abs(f19)) > ((double) Math.abs(f18)) * 1.5d && ((double) Math.abs(f28)) > ((double) Math.abs(f27)) * 1.5d;
        boolean z19 = ((double) Math.abs(f18)) > ((double) Math.abs(f19)) * 1.5d && ((double) Math.abs(f27)) > ((double) Math.abs(f28)) * 1.5d;
        boolean z26 = ((double) Math.abs(f18)) > ((double) Math.abs(f19)) * 1.5d && ((double) Math.abs(f27)) > ((double) Math.abs(f28)) * 1.5d;
        float f29 = f18 * f27;
        boolean z27 = f29 > 0.0f;
        float f36 = f19 * f28;
        boolean z28 = f36 > 0.0f;
        int i3 = this.f149870v;
        boolean z29 = ((i3 & 8) == 0 && (i3 & 1) == 0 && (i3 & 4) == 0) ? false : true;
        double d16 = z29 ? f149856i : 0.5d;
        if (f29 > 0.0f) {
            max = Math.abs(f18 + f27);
        } else {
            max = Math.max(Math.abs(f18), Math.abs(f27));
        }
        if (f36 > 0.0f) {
            f16 = f27;
            z16 = z17;
            max2 = Math.abs(f19 + f28);
        } else {
            f16 = f27;
            z16 = z17;
            max2 = Math.max(Math.abs(f19), Math.abs(f28));
        }
        double max3 = Math.max(max, max2);
        boolean z36 = max3 > d16;
        boolean z37 = z36 && z27 && (z19 || z26) && this.G.get().g();
        boolean z38 = z36 && z28 && (z16 || z18) && this.G.get().i();
        PointF pointF5 = this.f149874z;
        float f37 = pointF5.x;
        PointF pointF6 = this.f149873y;
        boolean z39 = z37;
        double d17 = f37 - pointF6.x;
        double d18 = pointF5.y - pointF6.y;
        PointF pointF7 = this.f149872x;
        float f38 = pointF7.x;
        PointF pointF8 = this.f149871w;
        float f39 = f16;
        boolean z46 = z27;
        double d19 = f38 - pointF8.x;
        float f46 = pointF7.y - pointF8.y;
        boolean z47 = z38;
        double d26 = f46;
        double sqrt = Math.sqrt((d17 * d17) + (d18 * d18));
        double sqrt2 = Math.sqrt((d19 * d19) + (d26 * d26));
        double d27 = sqrt * sqrt2;
        double d28 = ((d17 * d19) + (d18 * d26)) / d27;
        double acos = (Math.acos(d28) * 180.0d) / 3.141592653589793d;
        if ((d17 * d26) - (d18 * d19) < 0.0d) {
            acos = -acos;
        }
        boolean z48 = Math.abs(d28) < ((double) f149863p);
        double d29 = (this.f149870v & 2) == 0 ? f149852e : 0.5d;
        double abs = Math.abs(acos);
        boolean z49 = d27 > 0.0d && z48 && Math.abs(acos) > d29 && this.G.get().j();
        double d36 = sqrt2 / sqrt;
        double d37 = z29 ? 0.001d : f149854g;
        double d38 = d36 - 1.0d;
        boolean z55 = z36;
        double abs2 = Math.abs(d38);
        boolean z56 = sqrt > 0.0d && abs2 > d37 && this.G.get().h();
        boolean z57 = z55;
        lc.a a16 = lc.a(ky.f149115u);
        boolean z58 = z56;
        StringBuilder sb5 = new StringBuilder("value:");
        double d39 = acos;
        sb5.append(max3);
        sb5.append(":");
        sb5.append(abs2);
        sb5.append(":");
        sb5.append(abs);
        a16.a("trace-gesture", "began:" + z57 + ":" + z56 + ":" + z49, sb5.toString());
        if (z49) {
            z57 = false;
        }
        if (z47) {
            z49 = false;
            z39 = false;
            z58 = false;
        }
        lc.a(ky.f149115u).a("beganMove:".concat(String.valueOf(z57)), "vertical:".concat(String.valueOf(z28)), "horizontal:".concat(String.valueOf(z46)), "verticalMove:".concat(String.valueOf(z47)), "horizontalMove:".concat(String.valueOf(z39)));
        lc.a(ky.f149115u).a("beganRotate:".concat(String.valueOf(z49)), "cosValue : ".concat(String.valueOf(d28)), "cosAngle : ".concat(String.valueOf(z48)), "angle:".concat(String.valueOf(d39)), "rotateJudge : ".concat(String.valueOf(d29)));
        lc.a(ky.f149115u).a("beganScale:".concat(String.valueOf(z58)), "d1:".concat(String.valueOf(sqrt)), "scale - 1 = " + Math.abs(d38), "scaleJudge : ".concat(String.valueOf(d37)));
        if (z57) {
            if (z39) {
                this.f149870v |= 8;
                lc.a(ky.f149115u).a("MT_INTENT_MOVE");
                this.f149866a.d((f18 + f39) / 2.0f, (f19 + f28) / 2.0f);
            }
            if (z47) {
                this.f149870v |= 1;
                lc.a(ky.f149115u).a("MT_INTENT_MOVE_VERTICAL");
                PointF pointF9 = this.f149873y;
                PointF pointF10 = this.f149871w;
                pointF9.set(pointF10.x, pointF10.y);
                PointF pointF11 = this.f149874z;
                PointF pointF12 = this.f149872x;
                pointF11.set(pointF12.x, pointF12.y);
                this.f149866a.a(Math.abs(f19) > Math.abs(f28) ? f19 : f28);
            }
        }
        if (z49) {
            this.f149870v |= 2;
            lc.a(ky.f149115u).a("MT_INTENT_ROTATE");
            if (z46 && !this.G.get().g()) {
                PointF pointF13 = this.f149873y;
                PointF pointF14 = this.f149871w;
                pointF13.set(pointF14.x, pointF14.y);
                PointF pointF15 = this.f149874z;
                PointF pointF16 = this.f149872x;
                pointF15.set(pointF16.x, pointF16.y);
                lc.a(ky.f149115u).a("NO_HORIZONAL_ROTATE");
                return;
            }
            PointF pointF17 = this.f149874z;
            PointF pointF18 = this.f149873y;
            PointF pointF19 = this.f149872x;
            PointF pointF20 = this.f149871w;
            float f47 = pointF18.x;
            float f48 = pointF17.x;
            PointF pointF21 = null;
            if (f47 != f48) {
                float f49 = pointF20.x;
                float f56 = pointF19.x;
                if (f49 != f56) {
                    float f57 = pointF18.y;
                    float f58 = pointF17.y;
                    float f59 = (f57 - f58) / (f47 - f48);
                    float f65 = pointF20.y;
                    float f66 = pointF19.y;
                    float f67 = (f65 - f66) / (f49 - f56);
                    if (f59 != f67) {
                        float f68 = ((f66 * f49) - (f65 * f56)) / (f49 - f56);
                        float f69 = (f68 - (((f58 * f47) - (f57 * f48)) / (f47 - f48))) / (f59 - f67);
                        pointF21 = new PointF(f69, (f67 * f69) + f68);
                    }
                }
            }
            if (pointF21 == null ? false : a(pointF21.x, pointF21.y)) {
                bf bfVar = this.F;
                this.C.set(bfVar == null ? 0 : bfVar.h().width() / 2, this.F == null ? 0 : r4.h().height() / 2);
                ql qlVar = this.f149866a;
                PointF pointF22 = this.C;
                qlVar.a(pointF22, pointF22, (float) d39);
            } else {
                PointF pointF23 = this.A;
                PointF pointF24 = this.f149873y;
                float f75 = pointF24.x;
                PointF pointF25 = this.f149874z;
                pointF23.set((f75 + pointF25.x) / 2.0f, (pointF24.y + pointF25.y) / 2.0f);
                PointF pointF26 = this.B;
                PointF pointF27 = this.f149871w;
                float f76 = pointF27.x;
                PointF pointF28 = this.f149872x;
                pointF26.set((f76 + pointF28.x) / 2.0f, (pointF27.y + pointF28.y) / 2.0f);
                this.f149866a.a(this.A, this.B, (float) d39);
            }
        }
        if (z58) {
            this.f149870v |= 4;
            lc.a(ky.f149115u).a("MT_INTENT_SCALE");
            if (z46 && !this.G.get().g()) {
                PointF pointF29 = this.f149873y;
                PointF pointF30 = this.f149871w;
                pointF29.set(pointF30.x, pointF30.y);
                PointF pointF31 = this.f149874z;
                PointF pointF32 = this.f149872x;
                pointF31.set(pointF32.x, pointF32.y);
                lc.a(ky.f149115u).a("NO_HORIZONAL_SCALE");
                return;
            }
            PointF pointF33 = this.A;
            PointF pointF34 = this.f149873y;
            float f77 = pointF34.x;
            PointF pointF35 = this.f149874z;
            pointF33.set((f77 + pointF35.x) / 2.0f, (pointF34.y + pointF35.y) / 2.0f);
            PointF pointF36 = this.B;
            PointF pointF37 = this.f149871w;
            float f78 = pointF37.x;
            PointF pointF38 = this.f149872x;
            pointF36.set((f78 + pointF38.x) / 2.0f, (pointF37.y + pointF38.y) / 2.0f);
            this.f149866a.a(this.A, this.B, sqrt, sqrt2);
        }
        PointF pointF39 = this.f149873y;
        PointF pointF40 = this.f149871w;
        pointF39.set(pointF40.x, pointF40.y);
        PointF pointF41 = this.f149874z;
        PointF pointF42 = this.f149872x;
        pointF41.set(pointF42.x, pointF42.y);
    }

    private boolean b() {
        PointF pointF = this.f149874z;
        PointF pointF2 = this.f149873y;
        PointF pointF3 = this.f149872x;
        PointF pointF4 = this.f149871w;
        float f16 = pointF2.x;
        float f17 = pointF.x;
        PointF pointF5 = null;
        if (f16 != f17) {
            float f18 = pointF4.x;
            float f19 = pointF3.x;
            if (f18 != f19) {
                float f26 = pointF2.y;
                float f27 = pointF.y;
                float f28 = (f26 - f27) / (f16 - f17);
                float f29 = pointF4.y;
                float f36 = pointF3.y;
                float f37 = (f29 - f36) / (f18 - f19);
                if (f28 != f37) {
                    float f38 = ((f36 * f18) - (f29 * f19)) / (f18 - f19);
                    float f39 = (f38 - (((f27 * f16) - (f26 * f17)) / (f16 - f17))) / (f28 - f37);
                    pointF5 = new PointF(f39, (f37 * f39) + f38);
                }
            }
        }
        if (pointF5 == null) {
            return false;
        }
        return a(pointF5.x, pointF5.y);
    }

    private boolean b(float f16, float f17) {
        return a(f16, f17);
    }

    private boolean a(float f16, float f17) {
        bf bfVar = this.F;
        int width = bfVar == null ? 0 : bfVar.h().width() / 2;
        bf bfVar2 = this.F;
        int height = bfVar2 == null ? 0 : bfVar2.h().height() / 2;
        float width2 = this.F == null ? 0.0f : r3.h().width() / 3.0f;
        bf bfVar3 = this.F;
        return Math.abs(f16 - ((float) width)) < width2 && Math.abs(f17 - ((float) height)) < (bfVar3 != null ? ((float) bfVar3.h().height()) / 3.0f : 0.0f);
    }

    private static void a(PointF pointF, PointF pointF2, MotionEvent motionEvent) {
        try {
            float x16 = motionEvent.getX(0);
            float x17 = motionEvent.getX(1);
            float y16 = motionEvent.getY(0);
            float y17 = motionEvent.getY(1);
            pointF.set(x16, y16);
            pointF2.set(x17, y17);
        } catch (Exception unused) {
        }
    }
}
