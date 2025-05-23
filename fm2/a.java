package fm2;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements GLGestureListener {

    /* renamed from: a, reason: collision with root package name */
    private CameraFocusView f399837a;

    /* renamed from: b, reason: collision with root package name */
    private final int f399838b;

    /* renamed from: c, reason: collision with root package name */
    private long f399839c;

    /* renamed from: d, reason: collision with root package name */
    private long f399840d;

    /* renamed from: e, reason: collision with root package name */
    int f399841e;

    /* renamed from: f, reason: collision with root package name */
    int f399842f;

    /* renamed from: g, reason: collision with root package name */
    private final int f399843g;

    /* renamed from: h, reason: collision with root package name */
    private float f399844h;

    /* renamed from: i, reason: collision with root package name */
    private float f399845i;

    /* renamed from: j, reason: collision with root package name */
    private float f399846j;

    /* renamed from: k, reason: collision with root package name */
    private float f399847k;

    /* renamed from: l, reason: collision with root package name */
    InterfaceC10327a f399848l;

    /* compiled from: P */
    /* renamed from: fm2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC10327a {
        void a(MotionEvent motionEvent);
    }

    public a(Context context, InterfaceC10327a interfaceC10327a) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f399838b = 300;
        this.f399843g = viewConfiguration.getScaledTouchSlop();
        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
        this.f399841e = scaledDoubleTapSlop;
        this.f399842f = scaledDoubleTapSlop * scaledDoubleTapSlop;
        this.f399848l = interfaceC10327a;
    }

    private boolean a(MotionEvent motionEvent, GLSurfaceView gLSurfaceView) {
        int[] iArr = new int[2];
        gLSurfaceView.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        int width = gLSurfaceView.getWidth();
        int height = gLSurfaceView.getHeight();
        if (motionEvent.getRawX() < i3 || motionEvent.getRawX() > i3 + width || motionEvent.getRawY() < i16 || motionEvent.getRawY() > i16 + height) {
            return false;
        }
        return true;
    }

    private void b(MotionEvent motionEvent, GLSurfaceView gLSurfaceView) {
        int action = motionEvent.getAction() & 255;
        if (action != 5) {
            if (action == 6) {
                this.f399840d = System.currentTimeMillis();
                this.f399846j = motionEvent.getX(1);
                float y16 = motionEvent.getY(1);
                this.f399847k = y16;
                if (!d(this.f399844h, this.f399845i, this.f399846j, y16) && e(this.f399839c, this.f399840d)) {
                    MotionEvent secendFingerMotionEvent = GLGestureProxy.getInstance().getSecendFingerMotionEvent(motionEvent);
                    InterfaceC10327a interfaceC10327a = this.f399848l;
                    if (interfaceC10327a != null) {
                        interfaceC10327a.a(secendFingerMotionEvent);
                    } else {
                        f(secendFingerMotionEvent, gLSurfaceView);
                    }
                    secendFingerMotionEvent.recycle();
                    return;
                }
                return;
            }
            return;
        }
        this.f399839c = System.currentTimeMillis();
        this.f399844h = motionEvent.getX(1);
        this.f399845i = motionEvent.getY(1);
    }

    private boolean d(float f16, float f17, float f18, float f19) {
        int i3 = ((int) f18) - ((int) f16);
        int i16 = ((int) f19) - ((int) f17);
        int i17 = (i3 * i3) + (i16 * i16);
        int i18 = this.f399843g;
        if (i17 > i18 * i18) {
            return true;
        }
        return false;
    }

    private boolean e(long j3, long j16) {
        if (j16 - j3 < this.f399838b) {
            return true;
        }
        return false;
    }

    private void f(MotionEvent motionEvent, GLSurfaceView gLSurfaceView) {
        if ((gLSurfaceView instanceof CameraCaptureView) && this.f399837a != null) {
            CameraCaptureView cameraCaptureView = (CameraCaptureView) gLSurfaceView;
            if (cameraCaptureView.F() != 1) {
                this.f399837a.c(motionEvent);
                h(cameraCaptureView, motionEvent.getX(), motionEvent.getY());
                if (QLog.isColorLevel()) {
                    QLog.d(GLGestureListener.TAG, 2, "", "CameraFocusGesture isRecording == true");
                }
            }
        }
        motionEvent.recycle();
    }

    private void g(MotionEvent motionEvent, GLSurfaceView gLSurfaceView) {
        if ((gLSurfaceView instanceof CameraCaptureView) && this.f399837a != null) {
            CameraCaptureView cameraCaptureView = (CameraCaptureView) gLSurfaceView;
            if (cameraCaptureView.F() != 1) {
                this.f399837a.c(motionEvent);
                h(cameraCaptureView, motionEvent.getX(), motionEvent.getY());
                if (QLog.isColorLevel()) {
                    QLog.d(GLGestureListener.TAG, 2, "", "CameraFocusGesture isRecording == false");
                }
            }
        }
    }

    private void i(MotionEvent motionEvent, GLSurfaceView gLSurfaceView) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1) {
                this.f399840d = System.currentTimeMillis();
                this.f399846j = motionEvent.getX();
                float y16 = motionEvent.getY();
                this.f399847k = y16;
                if (!d(this.f399844h, this.f399845i, this.f399846j, y16) && e(this.f399839c, this.f399840d)) {
                    InterfaceC10327a interfaceC10327a = this.f399848l;
                    if (interfaceC10327a != null) {
                        interfaceC10327a.a(motionEvent);
                        return;
                    } else {
                        g(motionEvent, gLSurfaceView);
                        return;
                    }
                }
                return;
            }
            return;
        }
        this.f399839c = System.currentTimeMillis();
        this.f399844h = motionEvent.getX();
        this.f399845i = motionEvent.getY();
    }

    public void c() {
        CameraFocusView cameraFocusView = this.f399837a;
        if (cameraFocusView != null) {
            cameraFocusView.a();
        }
    }

    protected void h(CameraCaptureView cameraCaptureView, float f16, float f17) {
        cameraCaptureView.U(f16, f17);
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public int onGetPriority() {
        return 0;
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public boolean onTouchEvent(MotionEvent motionEvent, boolean z16) {
        int pointerCount = motionEvent.getPointerCount();
        GLSurfaceView gLSurfaceView = GLGestureProxy.getInstance().getGLSurfaceView();
        if (!a(motionEvent, gLSurfaceView)) {
            return false;
        }
        if (!z16 && pointerCount == 1) {
            i(motionEvent, gLSurfaceView);
        }
        if (z16 && pointerCount == 2) {
            b(motionEvent, gLSurfaceView);
        }
        return false;
    }
}
