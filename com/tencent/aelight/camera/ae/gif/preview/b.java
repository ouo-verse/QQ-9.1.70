package com.tencent.aelight.camera.ae.gif.preview;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.Surface;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.gif.preview.a;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.openapi.filter.SpaceFilter;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes32.dex */
public class b implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
    private static final String J = "b";
    private float C;
    private MediaPlayer D;

    /* renamed from: d, reason: collision with root package name */
    private int f65446d;

    /* renamed from: e, reason: collision with root package name */
    private SurfaceTexture f65447e;

    /* renamed from: i, reason: collision with root package name */
    private final GLSurfaceView f65450i;

    /* renamed from: m, reason: collision with root package name */
    private float f65451m;

    /* renamed from: f, reason: collision with root package name */
    private final float[] f65448f = new float[16];

    /* renamed from: h, reason: collision with root package name */
    private AtomicBoolean f65449h = new AtomicBoolean(false);
    private a E = new a();
    private BaseFilter F = new SurfaceTextureFilter();
    private SpaceFilter G = new SpaceFilter();
    private Frame H = new Frame();
    private Frame I = new Frame();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GLSurfaceView gLSurfaceView) {
        this.f65450i = gLSurfaceView;
    }

    private void d() {
        this.F.apply();
        this.F.setRotationAndFlip(0, 0, 1);
        this.G.apply();
        this.G.setRotationAndFlip(0, 0, 1);
        this.E.b();
    }

    public void a() {
        this.F.clearGLSL();
        this.G.clearGLSL();
        this.H.clear();
        this.I.clear();
        b();
        this.E.a();
        this.D.release();
    }

    public void f(a.InterfaceC0565a interfaceC0565a) {
        a aVar = this.E;
        if (aVar != null) {
            aVar.e(interfaceC0565a);
        }
    }

    public void g(boolean z16) {
        a aVar = this.E;
        if (aVar != null) {
            aVar.f(z16);
        }
    }

    public void h(MediaPlayer mediaPlayer) {
        this.D = mediaPlayer;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.f65449h.compareAndSet(true, false)) {
            this.f65447e.updateTexImage();
            this.f65447e.getTransformMatrix(this.f65448f);
            this.F.updateMatrix(this.f65448f);
            this.F.RenderProcess(this.f65446d, (int) (this.f65451m * 2.0f), (int) this.C, -1, 0.0d, this.H);
        }
        if (GLES20.glIsTexture(this.H.getTextureId())) {
            e(this.E.d(this.H, (int) this.f65451m, (int) this.C));
            return;
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClear(16384);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f65449h.set(true);
        this.f65450i.requestRender();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        Log.d(J, "onSurfaceChanged width = " + i3 + "  height = " + i16);
        this.f65451m = (float) i3;
        this.C = (float) i16;
        this.E.c(i3, i16);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.f65449h.set(false);
        c();
        d();
    }

    private void b() {
        GLES20.glDeleteTextures(1, new int[]{this.f65446d}, 0);
        this.f65447e.release();
    }

    private void c() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f65446d = iArr[0];
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f65446d);
        this.f65447e = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.D.setSurface(new Surface(this.f65447e));
        this.D.prepareAsync();
    }

    private void e(Frame frame) {
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glClearColor(0.92f, 0.93f, 0.96f, 1.0f);
        GLES20.glClear(16384);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        this.G.RenderProcess(frame.getTextureId(), (int) this.f65451m, (int) this.C, 0, 0.0d, this.I);
        GLES20.glDisable(3042);
    }
}
