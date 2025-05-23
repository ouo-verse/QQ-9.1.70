package jq;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.aelight.camera.ae.flashshow.util.CameraFocusView;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements GLGestureListener {

    /* renamed from: a, reason: collision with root package name */
    private CameraFocusView f410807a;

    /* renamed from: b, reason: collision with root package name */
    private final int f410808b;

    /* renamed from: c, reason: collision with root package name */
    private long f410809c;

    /* renamed from: d, reason: collision with root package name */
    private long f410810d;

    /* renamed from: e, reason: collision with root package name */
    int f410811e;

    /* renamed from: f, reason: collision with root package name */
    int f410812f;

    /* renamed from: g, reason: collision with root package name */
    private final int f410813g;

    /* renamed from: h, reason: collision with root package name */
    private float f410814h;

    /* renamed from: i, reason: collision with root package name */
    private float f410815i;

    /* renamed from: j, reason: collision with root package name */
    private float f410816j;

    /* renamed from: k, reason: collision with root package name */
    private float f410817k;

    /* renamed from: l, reason: collision with root package name */
    InterfaceC10605a f410818l;

    /* compiled from: P */
    /* renamed from: jq.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public interface InterfaceC10605a {
        void a(MotionEvent motionEvent);
    }

    public a(Context context, InterfaceC10605a interfaceC10605a) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f410808b = 300;
        this.f410813g = viewConfiguration.getScaledTouchSlop();
        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
        this.f410811e = scaledDoubleTapSlop;
        this.f410812f = scaledDoubleTapSlop * scaledDoubleTapSlop;
        this.f410818l = interfaceC10605a;
    }

    private void b(MotionEvent motionEvent, GLSurfaceView gLSurfaceView) {
        int action = motionEvent.getAction() & 255;
        if (action == 5) {
            this.f410809c = System.currentTimeMillis();
            this.f410814h = motionEvent.getX(1);
            this.f410815i = motionEvent.getY(1);
            return;
        }
        if (action != 6) {
            return;
        }
        this.f410810d = System.currentTimeMillis();
        this.f410816j = motionEvent.getX(1);
        float y16 = motionEvent.getY(1);
        this.f410817k = y16;
        if (d(this.f410814h, this.f410815i, this.f410816j, y16) || !e(this.f410809c, this.f410810d)) {
            return;
        }
        MotionEvent secendFingerMotionEvent = GLGestureProxy.getInstance().getSecendFingerMotionEvent(motionEvent);
        InterfaceC10605a interfaceC10605a = this.f410818l;
        if (interfaceC10605a != null) {
            interfaceC10605a.a(secendFingerMotionEvent);
        } else {
            f(secendFingerMotionEvent, gLSurfaceView);
        }
        secendFingerMotionEvent.recycle();
    }

    private void f(MotionEvent motionEvent, GLSurfaceView gLSurfaceView) {
        motionEvent.recycle();
    }

    private void h(MotionEvent motionEvent, GLSurfaceView gLSurfaceView) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f410809c = System.currentTimeMillis();
            this.f410814h = motionEvent.getX();
            this.f410815i = motionEvent.getY();
        } else {
            if (action != 1) {
                return;
            }
            this.f410810d = System.currentTimeMillis();
            this.f410816j = motionEvent.getX();
            float y16 = motionEvent.getY();
            this.f410817k = y16;
            if (d(this.f410814h, this.f410815i, this.f410816j, y16) || !e(this.f410809c, this.f410810d)) {
                return;
            }
            InterfaceC10605a interfaceC10605a = this.f410818l;
            if (interfaceC10605a != null) {
                interfaceC10605a.a(motionEvent);
            } else {
                g(motionEvent, gLSurfaceView);
            }
        }
    }

    public void c() {
        CameraFocusView cameraFocusView = this.f410807a;
        if (cameraFocusView != null) {
            cameraFocusView.a();
        }
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
            h(motionEvent, gLSurfaceView);
        }
        if (z16 && pointerCount == 2) {
            b(motionEvent, gLSurfaceView);
        }
        return false;
    }

    private boolean a(MotionEvent motionEvent, GLSurfaceView gLSurfaceView) {
        int[] iArr = new int[2];
        gLSurfaceView.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        return motionEvent.getRawX() >= ((float) i3) && motionEvent.getRawX() <= ((float) (i3 + gLSurfaceView.getWidth())) && motionEvent.getRawY() >= ((float) i16) && motionEvent.getRawY() <= ((float) (i16 + gLSurfaceView.getHeight()));
    }

    private boolean e(long j3, long j16) {
        return j16 - j3 < ((long) this.f410808b);
    }

    private boolean d(float f16, float f17, float f18, float f19) {
        int i3 = ((int) f18) - ((int) f16);
        int i16 = ((int) f19) - ((int) f17);
        int i17 = (i3 * i3) + (i16 * i16);
        int i18 = this.f410813g;
        return i17 > i18 * i18;
    }

    private void g(MotionEvent motionEvent, GLSurfaceView gLSurfaceView) {
    }
}
