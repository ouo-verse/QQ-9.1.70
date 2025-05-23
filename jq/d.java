package jq;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.aelight.camera.report.api.ICaptureReportUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureListener;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d implements GLGestureListener {

    /* renamed from: a, reason: collision with root package name */
    private final int f410828a;

    /* renamed from: b, reason: collision with root package name */
    private final int f410829b;

    /* renamed from: c, reason: collision with root package name */
    private MotionEvent f410830c;

    /* renamed from: d, reason: collision with root package name */
    private MotionEvent f410831d;

    /* renamed from: e, reason: collision with root package name */
    int f410832e;

    /* renamed from: f, reason: collision with root package name */
    int f410833f;

    /* renamed from: g, reason: collision with root package name */
    a f410834g;

    /* renamed from: h, reason: collision with root package name */
    private final int f410835h;

    /* renamed from: i, reason: collision with root package name */
    private long f410836i;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface a {
        void onDoubleTap();
    }

    public d(a aVar) {
        this.f410834g = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(BaseApplication.getContext());
        this.f410828a = ViewConfiguration.getDoubleTapTimeout();
        this.f410829b = 1000;
        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
        this.f410832e = scaledDoubleTapSlop;
        this.f410833f = scaledDoubleTapSlop * scaledDoubleTapSlop;
        this.f410835h = viewConfiguration.getScaledTouchSlop();
        this.f410836i = 0L;
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public int onGetPriority() {
        return 0;
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public boolean onTouchEvent(MotionEvent motionEvent, boolean z16) {
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction() & 255;
        ms.a.a(GLGestureListener.TAG, "[gestureFix][CameraSwitchGesture]:onTouchEvent");
        if (pointerCount == 1 && !z16) {
            if (action == 0) {
                if (a(this.f410830c, this.f410831d, motionEvent)) {
                    ms.a.a(GLGestureListener.TAG, "[gestureFix][CameraSwitchGesture]:camera double click");
                    if (this.f410834g != null) {
                        this.f410836i = System.currentTimeMillis();
                        this.f410834g.onDoubleTap();
                        ((ICaptureReportUtil) QRoute.api(ICaptureReportUtil.class)).reportDoubleClickChangeCamera();
                        if (QLog.isColorLevel()) {
                            QLog.d(GLGestureListener.TAG, 2, "", "CameraSwitchGesture");
                        }
                    }
                }
                MotionEvent motionEvent2 = this.f410830c;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.f410830c = MotionEvent.obtain(motionEvent);
            } else if (action == 1) {
                MotionEvent motionEvent3 = this.f410831d;
                if (motionEvent3 != null) {
                    motionEvent3.recycle();
                }
                this.f410831d = MotionEvent.obtain(motionEvent);
            }
        }
        return false;
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (motionEvent == null || motionEvent2 == null || Math.abs(System.currentTimeMillis() - this.f410836i) < this.f410829b || motionEvent3.getEventTime() - motionEvent2.getEventTime() > this.f410828a || b(motionEvent.getX(), motionEvent.getY(), motionEvent2.getX(), motionEvent2.getY())) {
            return false;
        }
        int x16 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y16 = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        return (x16 * x16) + (y16 * y16) < this.f410833f;
    }

    private boolean b(float f16, float f17, float f18, float f19) {
        int i3 = ((int) f18) - ((int) f16);
        int i16 = ((int) f19) - ((int) f17);
        return (i3 * i3) + (i16 * i16) > this.f410835h;
    }
}
