package jq;

import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView;
import com.tencent.ttpic.openapi.filter.GLGestureListener;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e implements GLGestureListener {

    /* renamed from: a, reason: collision with root package name */
    GLSurfaceView f410837a;

    /* renamed from: b, reason: collision with root package name */
    private int f410838b;

    public e(GLSurfaceView gLSurfaceView, int i3) {
        this.f410838b = i3;
        this.f410837a = gLSurfaceView;
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public int onGetPriority() {
        return 1010;
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public boolean onTouchEvent(MotionEvent motionEvent, boolean z16) {
        boolean z17;
        int pointerCount = motionEvent.getPointerCount();
        if ((z16 && pointerCount == 1) || !(this.f410837a instanceof LSCameraGLSurfaceView)) {
            return false;
        }
        ms.a.a(GLGestureListener.TAG, "[gestureFix][LSCameraTriggerGesture]:onTouchEvent isRecording=" + z16);
        int action = motionEvent.getAction() & 255;
        LSCameraGLSurfaceView lSCameraGLSurfaceView = (LSCameraGLSurfaceView) this.f410837a;
        boolean S0 = lSCameraGLSurfaceView.S0();
        boolean R0 = lSCameraGLSurfaceView.R0();
        if (S0) {
            lSCameraGLSurfaceView.j2(motionEvent);
            z17 = true;
        } else {
            z17 = false;
        }
        if (R0) {
            if (action == 1) {
                lSCameraGLSurfaceView.setTapEvent(100, motionEvent.getX(), motionEvent.getY() - this.f410838b);
                return true;
            }
            if (action == 6) {
                lSCameraGLSurfaceView.setTapEvent(100, (motionEvent.getX(1) + motionEvent.getRawX()) - motionEvent.getX(0), (motionEvent.getY(1) + motionEvent.getRawY()) - motionEvent.getY(0));
                return true;
            }
        }
        return z17;
    }
}
