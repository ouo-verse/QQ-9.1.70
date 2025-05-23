package com.tencent.av.opengl.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GLRootView extends GLSurfaceView implements GLSurfaceView.Renderer {
    private static int M;
    int C;
    boolean D;
    private ov.a E;
    private int F;
    private volatile boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private wv.a K;
    private Runnable L;

    /* renamed from: d, reason: collision with root package name */
    final long f74111d;

    /* renamed from: e, reason: collision with root package name */
    final int f74112e;

    /* renamed from: f, reason: collision with root package name */
    protected final String f74113f;

    /* renamed from: h, reason: collision with root package name */
    private final ReentrantLock f74114h;

    /* renamed from: i, reason: collision with root package name */
    protected b f74115i;

    /* renamed from: m, reason: collision with root package name */
    long f74116m;

    public GLRootView(Context context) {
        this(context, null);
    }

    private void b() {
        this.F &= -3;
        int width = getWidth();
        int height = getHeight();
        b bVar = this.f74115i;
        if (bVar != null && width != 0 && height != 0) {
            bVar.q(0, 0, width, height);
        }
    }

    private void e() {
        int i3;
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(3379, iArr, 0);
        int[] iArr2 = new int[1];
        GLES20.glGetIntegerv(34024, iArr2, 0);
        int min = Math.min(iArr[0], iArr2[0]);
        int i16 = 2;
        if (min < 2560) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        if (i3 < 3 || Build.VERSION.SDK_INT >= 28) {
            i16 = i3;
        }
        QLog.d(this.f74113f, 1, "updateMaxRenderSize renderLevel:= " + i16 + ", minSize:=" + min);
        vu.a.c().b().encodeInt("KEY_MAX_RENDER_LEVEL", i16);
    }

    protected void c(GL10 gl10) {
        this.E.h();
        rv.e.G();
        this.G = false;
        if ((this.F & 2) != 0) {
            b();
        }
        b bVar = this.f74115i;
        if (bVar != null) {
            bVar.C(this.E);
        } else {
            this.E.a();
        }
        if (rv.e.J()) {
            requestRender();
        }
        wv.a aVar = this.K;
        if (aVar != null) {
            aVar.onDraw();
        }
    }

    public void d() {
        this.f74114h.lock();
        try {
            if (this.f74115i != null) {
                int i3 = this.F;
                if ((i3 & 2) == 0 && (i3 & 1) != 0) {
                    this.F = i3 | 2;
                    requestRender();
                }
            }
        } finally {
            this.f74114h.unlock();
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        b bVar = this.f74115i;
        if (bVar != null && (bVar instanceof VideoLayerUI) && ((VideoLayerUI) bVar).c2(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 3 && action != 1) {
            if (!this.H && action != 0) {
                return false;
            }
        } else {
            this.H = false;
        }
        try {
        } catch (InterruptedException e16) {
            QLog.e(this.f74113f, 1, "dispatchTouchEvent failed. tryLock failed.", e16);
        }
        if (this.f74114h.tryLock(500L, TimeUnit.MILLISECONDS)) {
            try {
                b bVar = this.f74115i;
                if (bVar != null && bVar.d(motionEvent)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (action == 0 && z16) {
                    this.H = true;
                }
                return z16;
            } finally {
                this.f74114h.unlock();
            }
        }
        QLog.e(this.f74113f, 1, "dispatchTouchEvent failed. tryLock failed.");
        return false;
    }

    @Override // android.opengl.GLSurfaceView
    protected void finalize() throws Throwable {
        try {
            pv.f.a();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            super.finalize();
            throw th5;
        }
        super.finalize();
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f74113f, 1, "GLRootView, \u865a\u6784");
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        float f16;
        b bVar;
        if (this.J) {
            this.f74114h.lock();
            if (M != 1) {
                this.f74114h.unlock();
                QLog.e(this.f74113f, 1, "onDrawFrame failed. sCreatedSurfaceCnt = " + M);
                this.G = false;
                requestRender();
                return;
            }
        }
        SystemClock.elapsedRealtime();
        a.b();
        if (this.D) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, f16);
        GLES20.glClear(16640);
        this.f74114h.lock();
        synchronized (this) {
            int i3 = this.C;
            if (i3 > 0) {
                this.C = i3 - 1;
            }
        }
        try {
            try {
                c(gl10);
            } catch (Exception e16) {
                this.G = false;
                if (QLog.isColorLevel()) {
                    QLog.e(this.f74113f, 2, "WL_DEBUG onDrawFrame e = " + e16);
                    StackTraceElement[] stackTrace = e16.getStackTrace();
                    StringBuilder sb5 = new StringBuilder();
                    int length = stackTrace.length;
                    for (int i16 = 0; i16 < length; i16++) {
                        sb5.append("WL_DEBUG onDrawFrame ste[");
                        sb5.append(i16);
                        sb5.append("]");
                        sb5.append(stackTrace[i16].toString());
                        sb5.append("\n");
                    }
                    QLog.e(this.f74113f, 2, sb5.toString());
                }
            }
            if (this.I && (bVar = this.f74115i) != null) {
                this.I = false;
                bVar.t();
            }
            this.f74116m = SystemClock.elapsedRealtime();
        } finally {
            this.f74114h.unlock();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (z16) {
            d();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        if (QLog.isColorLevel()) {
            QLog.i(this.f74113f, 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        if (this.f74115i instanceof c) {
            queueEvent(new Runnable() { // from class: com.tencent.av.opengl.ui.GLRootView.2
                @Override // java.lang.Runnable
                public void run() {
                    b bVar = GLRootView.this.f74115i;
                    if (bVar != null) {
                        ((c) bVar).a0();
                    }
                }
            });
        }
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.G = false;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i(this.f74113f, 2, "onSurfaceChanged: " + i3 + HippyTKDListViewAdapter.X + i16 + ", gl10: " + gl10.toString());
        }
        if (i3 == 0 || i16 == 0) {
            QLog.d(this.f74113f, 1, "onSurfaceChanged: error system callback - width or height is Zero value");
        }
        b bVar = this.f74115i;
        if (bVar != null && (bVar instanceof c)) {
            ((c) bVar).Y(i3, i16);
        }
        Process.setThreadPriority(-4);
        this.E.setSize(i3, i16);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.f74114h.lock();
        try {
            this.E = new ov.b();
            com.tencent.av.opengl.texture.a.n();
            b bVar = this.f74115i;
            if (bVar != null && (bVar instanceof c)) {
                ((c) bVar).Z();
            }
            this.f74114h.unlock();
            pv.f.a();
            setRenderMode(0);
            e();
        } catch (Throwable th5) {
            this.f74114h.unlock();
            throw th5;
        }
    }

    @Override // android.opengl.GLSurfaceView
    @SuppressLint({"NewApi"})
    public void requestRender() {
        if (this.G) {
            return;
        }
        this.G = true;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f74116m;
        if (elapsedRealtime > 0 && elapsedRealtime < 20) {
            synchronized (this) {
                int i3 = this.C;
                if (i3 >= 2) {
                    return;
                }
                this.C = i3 + 1;
                super.postDelayed(this.L, 20 - elapsedRealtime);
                return;
            }
        }
        ThreadManager.getUIHandler().post(this.L);
    }

    public void setContentPane(b bVar) {
        b bVar2 = this.f74115i;
        if (bVar2 == bVar) {
            return;
        }
        if (bVar2 != null) {
            if (this.H) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f74115i.d(obtain);
                obtain.recycle();
                this.H = false;
            }
            this.f74115i.c();
            com.tencent.av.opengl.texture.a.B();
        }
        this.f74115i = bVar;
        if (bVar != null) {
            bVar.a(this);
            d();
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        super.surfaceChanged(surfaceHolder, i3, i16, i17);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.J) {
            this.f74114h.lock();
            M++;
            this.f74114h.unlock();
        }
        QLog.i(this.f74113f, 1, "STest. surfaceCreated. sCreatedSurfaceCnt = " + M);
        super.surfaceCreated(surfaceHolder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.J) {
            this.f74114h.lock();
            M--;
            this.f74114h.unlock();
        }
        if (this.f74115i instanceof c) {
            queueEvent(new Runnable() { // from class: com.tencent.av.opengl.ui.GLRootView.3
                @Override // java.lang.Runnable
                public void run() {
                    b bVar = GLRootView.this.f74115i;
                    if (bVar != null) {
                        ((c) bVar).a0();
                    }
                }
            });
        }
        QLog.i(this.f74113f, 1, "STest. surfaceDestroyed. sCreatedSurfaceCnt = " + M);
        super.surfaceDestroyed(surfaceHolder);
    }

    public GLRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes;
        this.f74112e = 20;
        this.f74114h = new ReentrantLock();
        this.f74116m = 0L;
        this.C = 0;
        this.D = false;
        this.F = 2;
        this.G = false;
        this.H = false;
        this.I = true;
        this.L = new Runnable() { // from class: com.tencent.av.opengl.ui.GLRootView.1
            @Override // java.lang.Runnable
            public void run() {
                GLRootView.super.requestRender();
            }
        };
        long d16 = com.tencent.av.utils.e.d();
        this.f74111d = d16;
        String str = "GLRootView_" + d16;
        this.f74113f = str;
        this.K = wv.b.b();
        if (QLog.isDevelopLevel()) {
            QLog.w(str, 1, "GLRootView, \u6784\u9020");
        }
        this.J = DeviceInfoMonitor.getModel().equalsIgnoreCase("MI 9") || DeviceInfoMonitor.getModel().equalsIgnoreCase("MI 9 Transparent Edition");
        if (isInEditMode()) {
            return;
        }
        this.F = 1 | this.F;
        setBackgroundDrawable(null);
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GLRootView, 0, 0)) != null) {
            try {
                try {
                    this.D = obtainStyledAttributes.getBoolean(R.styleable.GLRootView_is_smallscreen, false);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(this.f74113f, 2, "GLRootView e = " + e16);
                    }
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        setEGLContextClientVersion(tv.c.c(context));
        if (this.D) {
            setEGLConfigChooser(8, 8, 8, 8, 16, 0);
            getHolder().setFormat(-3);
        } else if (tv.c.f437520c) {
            setEGLConfigChooser(8, 8, 8, 0, 0, 0);
            getHolder().setFormat(3);
        } else {
            setEGLConfigChooser(5, 6, 5, 0, 0, 0);
            getHolder().setFormat(4);
        }
        setRenderer(this);
    }
}
