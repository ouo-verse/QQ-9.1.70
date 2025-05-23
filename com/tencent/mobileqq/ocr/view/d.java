package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d extends com.tencent.mobileqq.ocr.view.gesture.control.c implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private boolean C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private int H;
    private Handler I;
    private com.tencent.mobileqq.ocr.view.gesture.animation.a J;
    private int K;
    private CommonMenuPopupView L;
    private View.OnClickListener M;
    private a N;

    /* renamed from: d, reason: collision with root package name */
    private GestureFrameLayout f254966d;

    /* renamed from: e, reason: collision with root package name */
    private List<? extends com.tencent.mobileqq.ocr.view.a> f254967e;

    /* renamed from: f, reason: collision with root package name */
    private List<? extends com.tencent.mobileqq.ocr.view.a> f254968f;

    /* renamed from: h, reason: collision with root package name */
    private Matrix f254969h;

    /* renamed from: i, reason: collision with root package name */
    private final float[] f254970i;

    /* renamed from: m, reason: collision with root package name */
    private Point f254971m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void F0();

        void F2();
    }

    public d(GestureFrameLayout gestureFrameLayout, List<c> list, List<b> list2, View.OnClickListener onClickListener, a aVar) {
        com.tencent.mobileqq.ocr.view.gesture.animation.a aVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, gestureFrameLayout, list, list2, onClickListener, aVar);
            return;
        }
        this.f254969h = new Matrix();
        this.f254970i = new float[2];
        this.K = -1;
        this.f254966d = gestureFrameLayout;
        this.f254967e = list;
        this.f254968f = list2;
        this.M = onClickListener;
        this.N = aVar;
        Context context = gestureFrameLayout.getContext();
        gestureFrameLayout.e().P().e().invert(this.f254969h);
        CommonMenuPopupView commonMenuPopupView = new CommonMenuPopupView();
        this.L = commonMenuPopupView;
        commonMenuPopupView.b(R.id.bbi, context.getString(R.string.aep), R.drawable.cb5);
        this.L.b(R.id.cjs, context.getString(R.string.f170968bc0), R.drawable.cbd);
        this.L.b(R.id.j5q, context.getString(R.string.fos), R.drawable.cbd);
        this.L.f(this.M);
        this.I = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        if (com.tencent.mobileqq.ocr.view.gesture.animation.a.a()) {
            aVar2 = new com.tencent.mobileqq.ocr.view.gesture.animation.a();
        } else {
            aVar2 = null;
        }
        this.J = aVar2;
    }

    public static int d(Point point, Point point2) {
        return (point.x * point2.x) + (point.y * point2.y);
    }

    private void e(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (!this.C) {
            this.C = true;
            this.f254970i[0] = motionEvent.getX();
            this.f254970i[1] = motionEvent.getY();
            this.f254969h.mapPoints(this.f254970i);
            int round = Math.round(this.f254970i[0]);
            int round2 = Math.round(this.f254970i[1]);
            List<? extends com.tencent.mobileqq.ocr.view.a> l3 = l();
            for (int i3 = 0; i3 < l3.size(); i3++) {
                if (j(new Point(round, round2), l3.get(i3))) {
                    f(l3.get(i3), i3);
                }
            }
        }
        this.f254970i[0] = motionEvent2.getX();
        this.f254970i[1] = motionEvent2.getY();
        this.f254969h.mapPoints(this.f254970i);
        int round3 = Math.round(this.f254970i[0]);
        int round4 = Math.round(this.f254970i[1]);
        if (this.f254971m != null) {
            List<? extends com.tencent.mobileqq.ocr.view.a> l16 = l();
            for (int i16 = 0; i16 < l16.size(); i16++) {
                Point point = this.f254971m;
                if (h(round3, round4, point.x, point.y, l16.get(i16))) {
                    f(l16.get(i16), i16);
                }
            }
        }
        this.f254971m = new Point(round3, round4);
    }

    private boolean g(MotionEvent motionEvent, boolean z16, boolean z17) {
        boolean z18;
        int i3;
        this.f254970i[0] = motionEvent.getX();
        this.f254970i[1] = motionEvent.getY();
        this.f254969h.mapPoints(this.f254970i);
        int round = Math.round(this.f254970i[0]);
        int round2 = Math.round(this.f254970i[1]);
        boolean z19 = false;
        for (com.tencent.mobileqq.ocr.view.a aVar : l()) {
            if (j(new Point(round, round2), aVar)) {
                if (!z17) {
                    if (!z16 && aVar.f254926b) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    aVar.f254926b = z18;
                    GestureFrameLayout gestureFrameLayout = this.f254966d;
                    gestureFrameLayout.f(gestureFrameLayout);
                    int i16 = 2;
                    if (!z16 && !aVar.f254926b) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    this.K = i3;
                    if (z16) {
                        k(aVar);
                    }
                    if (aVar.f254926b) {
                        i16 = 1;
                    }
                    com.tencent.mobileqq.ocr.d.n("0X800AAED", i16);
                }
                z19 = true;
            }
        }
        return z19;
    }

    private boolean h(int i3, int i16, int i17, int i18, com.tencent.mobileqq.ocr.view.a aVar) {
        Point point = aVar.f254925a.get(0);
        Point point2 = aVar.f254925a.get(1);
        if (i(i3, i16, i17, i18, point.x, point.y, point2.x, point2.y)) {
            return true;
        }
        Point point3 = aVar.f254925a.get(2);
        Point point4 = aVar.f254925a.get(3);
        if (i(i3, i16, i17, i18, point3.x, point3.y, point4.x, point4.y)) {
            return true;
        }
        if (!i(i3, i16, i17, i18, point2.x, point2.y, point3.x, point3.y) && !i(i3, i16, i17, i18, point4.x, point4.y, point.x, point.y)) {
            return false;
        }
        return true;
    }

    private boolean i(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        int i29 = i18 - i16;
        int i36 = i16 - i26;
        int i37 = i3 - i19;
        float f16 = ((i28 - i26) * (i17 - i3)) - ((i27 - i19) * i29);
        float f17 = ((r9 * i36) - (r10 * i37)) / f16;
        float f18 = ((r5 * i36) - (i29 * i37)) / f16;
        if (f17 >= 0.0f && f17 <= 1.0f && f18 >= 0.0f && f18 <= 1.0f) {
            return true;
        }
        return false;
    }

    private static boolean j(Point point, com.tencent.mobileqq.ocr.view.a aVar) {
        int i3;
        Point m3;
        int d16;
        int i16 = point.y;
        if (i16 > aVar.f254929e || i16 < aVar.f254931g || (i3 = point.x) > aVar.f254928d || i3 < aVar.f254930f) {
            return false;
        }
        if (aVar.f254927c % 90 < 1) {
            return true;
        }
        Point point2 = aVar.f254925a.get(0);
        Point point3 = aVar.f254925a.get(1);
        Point point4 = aVar.f254925a.get(2);
        Point m16 = m(point2, point3);
        int d17 = d(m16, m(point2, point));
        if (d17 < 0 || d17 > d(m16, m16) || (d16 = d((m3 = m(point3, point4)), m(point3, point))) < 0 || d16 > d(m3, m3)) {
            return false;
        }
        return true;
    }

    private List<? extends com.tencent.mobileqq.ocr.view.a> l() {
        if (com.tencent.mobileqq.ocr.d.f254704a) {
            return this.f254968f;
        }
        return this.f254967e;
    }

    public static Point m(Point point, Point point2) {
        return new Point(point2.x - point.x, point2.y - point.y);
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.c, com.tencent.mobileqq.ocr.view.gesture.control.b
    public void a(Matrix matrix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) matrix);
        } else {
            this.f254969h.set(matrix);
        }
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.c, com.tencent.mobileqq.ocr.view.gesture.control.b
    public void b(MotionEvent motionEvent) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) motionEvent);
            return;
        }
        this.N.F2();
        if (this.E) {
            this.H = 4;
            if (this.K == 1) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ReportController.o(null, "dc00898", "", "", "0X800AAEE", "0X800AAEE", i3, 0, String.valueOf(this.D), "0", "0", "");
        } else if (this.G) {
            this.H = 1;
            com.tencent.mobileqq.ocr.d.n("0X800AAF6", 0);
        } else if (this.F) {
            this.H = 3;
            com.tencent.mobileqq.ocr.d.n("0X800AAF7", 0);
        }
        this.E = false;
        this.G = false;
        this.F = false;
        this.I.removeMessages(1);
        this.I.sendEmptyMessageDelayed(1, 500L);
        this.f254971m = null;
        this.K = -1;
        this.D = 0;
        this.C = false;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return ((OCRPerformFragment) this.M).Nh();
    }

    public void f(com.tencent.mobileqq.ocr.view.a aVar, int i3) {
        boolean z16;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) aVar, i3);
            return;
        }
        if (this.K == -1) {
            if (aVar.f254926b) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            this.K = i16;
            this.E = true;
        }
        if (this.K == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 != aVar.f254926b) {
            this.D++;
            aVar.f254926b = z16;
            GestureFrameLayout gestureFrameLayout = this.f254966d;
            gestureFrameLayout.f(gestureFrameLayout);
            this.f254966d.e().O().F(false);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("actType", String.valueOf(this.H));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actOcrGestureType", true, 0L, 0L, hashMap, null);
            QLog.d("OcrScroll", 1, "report ActOcrGestureType, type:", Integer.valueOf(this.H));
        }
        return false;
    }

    public void k(com.tencent.mobileqq.ocr.view.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
            return;
        }
        if (!this.L.e()) {
            Point point = aVar.f254925a.get(0);
            Point point2 = aVar.f254925a.get(1);
            Matrix matrix = new Matrix();
            this.f254969h.invert(matrix);
            float[] fArr = {point.x, point.y};
            float[] fArr2 = {point2.x, point2.y};
            matrix.mapPoints(fArr);
            matrix.mapPoints(fArr2);
            this.L.g(this.f254966d, ((int) (fArr[0] + fArr2[0])) / 2, ((int) (fArr[1] + fArr2[1])) / 2);
        }
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.c, com.tencent.mobileqq.ocr.view.gesture.control.b
    public boolean onDoubleTap(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
        }
        this.H = 2;
        return super.onDoubleTap(motionEvent);
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.c, com.tencent.mobileqq.ocr.view.gesture.control.b
    public void onDown(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent);
        } else {
            this.L.d();
            this.f254966d.e().O().F(true);
        }
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.c, com.tencent.mobileqq.ocr.view.gesture.control.b
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        this.H = 7;
        return super.onFling(motionEvent, motionEvent2, f16, f17);
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.c, com.tencent.mobileqq.ocr.view.gesture.control.b
    public void onLongPress(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent);
        } else {
            g(motionEvent, true, false);
            this.H = 5;
        }
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.c, com.tencent.mobileqq.ocr.view.gesture.control.b
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) scaleGestureDetector)).booleanValue();
        }
        this.J.c();
        return super.onScale(scaleGestureDetector);
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.c, com.tencent.mobileqq.ocr.view.gesture.control.b
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) scaleGestureDetector)).booleanValue();
        }
        this.J.b(1);
        this.N.F0();
        return super.onScaleBegin(scaleGestureDetector);
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.b
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) scaleGestureDetector);
        } else {
            this.J.d();
            this.G = true;
        }
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.c, com.tencent.mobileqq.ocr.view.gesture.control.b
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (motionEvent2.getPointerCount() >= 2) {
            this.F = true;
            return false;
        }
        if (!this.F && (this.f254971m != null || !c() || g(motionEvent, false, true))) {
            e(motionEvent, motionEvent2);
            return true;
        }
        this.F = true;
        return false;
    }

    @Override // com.tencent.mobileqq.ocr.view.gesture.control.c, com.tencent.mobileqq.ocr.view.gesture.control.b
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        g(motionEvent, false, false);
        this.H = 6;
        return true;
    }
}
