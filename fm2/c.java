package fm2;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.aelight.camera.report.api.ICaptureReportUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureListener;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements GLGestureListener {

    /* renamed from: a, reason: collision with root package name */
    private final int f399854a;

    /* renamed from: b, reason: collision with root package name */
    private final int f399855b;

    /* renamed from: c, reason: collision with root package name */
    private MotionEvent f399856c;

    /* renamed from: d, reason: collision with root package name */
    private MotionEvent f399857d;

    /* renamed from: e, reason: collision with root package name */
    int f399858e;

    /* renamed from: f, reason: collision with root package name */
    int f399859f;

    /* renamed from: g, reason: collision with root package name */
    a f399860g;

    /* renamed from: h, reason: collision with root package name */
    private final int f399861h;

    /* renamed from: i, reason: collision with root package name */
    private long f399862i;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void onDoubleTap();
    }

    public c(Context context, a aVar) {
        this.f399860g = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f399854a = ViewConfiguration.getDoubleTapTimeout();
        this.f399855b = 1000;
        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
        this.f399858e = scaledDoubleTapSlop;
        this.f399859f = scaledDoubleTapSlop * scaledDoubleTapSlop;
        this.f399861h = viewConfiguration.getScaledTouchSlop();
        this.f399862i = 0L;
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (motionEvent == null || motionEvent2 == null || Math.abs(System.currentTimeMillis() - this.f399862i) < this.f399855b || motionEvent3.getEventTime() - motionEvent2.getEventTime() > this.f399854a || b(motionEvent.getX(), motionEvent.getY(), motionEvent2.getX(), motionEvent2.getY())) {
            return false;
        }
        int x16 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y16 = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        if ((x16 * x16) + (y16 * y16) >= this.f399859f) {
            return false;
        }
        return true;
    }

    private boolean b(float f16, float f17, float f18, float f19) {
        int i3 = ((int) f18) - ((int) f16);
        int i16 = ((int) f19) - ((int) f17);
        if ((i3 * i3) + (i16 * i16) > this.f399861h) {
            return true;
        }
        return false;
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
            if (action != 0) {
                if (action == 1) {
                    MotionEvent motionEvent2 = this.f399857d;
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    this.f399857d = MotionEvent.obtain(motionEvent);
                }
            } else {
                if (a(this.f399856c, this.f399857d, motionEvent)) {
                    ms.a.a(GLGestureListener.TAG, "[gestureFix][CameraSwitchGesture]:camera double click");
                    if (this.f399860g != null) {
                        this.f399862i = System.currentTimeMillis();
                        this.f399860g.onDoubleTap();
                        id0.a.p("camera_clkdouble", -1, 0, new String[0]);
                        ((ICaptureReportUtil) QRoute.api(ICaptureReportUtil.class)).reportDoubleClickChangeCamera();
                        if (QLog.isColorLevel()) {
                            QLog.d(GLGestureListener.TAG, 2, "", "CameraSwitchGesture");
                        }
                    }
                }
                MotionEvent motionEvent3 = this.f399856c;
                if (motionEvent3 != null) {
                    motionEvent3.recycle();
                }
                this.f399856c = MotionEvent.obtain(motionEvent);
            }
        }
        return false;
    }
}
