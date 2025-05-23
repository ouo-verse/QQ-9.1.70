package pq;

import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.ttpic.openapi.filter.GLGestureListener;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b implements GLGestureListener {

    /* renamed from: a, reason: collision with root package name */
    GLSurfaceView f426983a;

    /* renamed from: b, reason: collision with root package name */
    private int f426984b;

    public b(GLSurfaceView gLSurfaceView, int i3) {
        this.f426984b = i3;
        this.f426983a = gLSurfaceView;
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public int onGetPriority() {
        return 1010;
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public boolean onTouchEvent(MotionEvent motionEvent, boolean z16) {
        boolean z17;
        int pointerCount = motionEvent.getPointerCount();
        if ((z16 && pointerCount == 1) || !(this.f426983a instanceof AECameraGLSurfaceView)) {
            return false;
        }
        ms.a.a(GLGestureListener.TAG, "[gestureFix][CameraTriggerGesture]:onTouchEvent isRecording=" + z16);
        int action = motionEvent.getAction() & 255;
        AECameraGLSurfaceView aECameraGLSurfaceView = (AECameraGLSurfaceView) this.f426983a;
        boolean hasTouchEffect = aECameraGLSurfaceView.hasTouchEffect();
        boolean hasTapEffect = aECameraGLSurfaceView.hasTapEffect();
        if (hasTouchEffect) {
            aECameraGLSurfaceView.updateTouchEvent(motionEvent);
            z17 = true;
        } else {
            z17 = false;
        }
        if (hasTapEffect) {
            if (action == 1) {
                aECameraGLSurfaceView.setTapEvent(100, motionEvent.getX(), motionEvent.getY() - this.f426984b);
                return true;
            }
            if (action == 6) {
                aECameraGLSurfaceView.setTapEvent(100, (motionEvent.getX(1) + motionEvent.getRawX()) - motionEvent.getX(0), (motionEvent.getY(1) + motionEvent.getRawY()) - motionEvent.getY(0));
                return true;
            }
        }
        return z17;
    }
}
