package com.tencent.mobileqq.ar.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ARRecord.e;
import com.tencent.mobileqq.ar.ARRecord.g;
import com.tencent.mobileqq.ar.ARRenderModel.CameraRendererable;
import com.tencent.mobileqq.ar.ARRenderModel.f;
import com.tencent.mobileqq.ar.ARRenderModel.h;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.x;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.IntBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes11.dex */
public class UniformGLRenderManagerImpl implements d, com.tencent.mobileqq.ar.ARRenderModel.c {
    public static int U;
    public static int V;
    private long E;
    private long F;
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.a G;
    private boolean H;
    private RenderBuffer I;
    private TextureRender J;
    private g K;
    private com.tencent.mobileqq.ar.view.c P;

    /* renamed from: e, reason: collision with root package name */
    GLSurfaceView f198513e;

    /* renamed from: f, reason: collision with root package name */
    public volatile com.tencent.mobileqq.ar.ARRenderModel.a f198514f;

    /* renamed from: i, reason: collision with root package name */
    private Context f198516i;

    /* renamed from: m, reason: collision with root package name */
    com.tencent.mobileqq.ar.ARRenderModel.b f198517m;
    h C = new h();
    private Map<Integer, Object> D = new ConcurrentHashMap();
    private boolean L = false;
    private boolean M = false;
    public boolean N = false;
    private volatile boolean Q = false;
    int R = 0;
    int S = 0;
    public Map<String, com.tencent.mobileqq.ar.ARRenderModel.a> T = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    FramePerformanceMonitor f198515h = new FramePerformanceMonitor();

    /* renamed from: d, reason: collision with root package name */
    private CameraRendererable f198512d = new CameraRendererable(this);

    private void F(GL10 gl10) {
        if (this.f198514f != null) {
            this.f198514f.onUpdate();
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glDepthMask(true);
        GLES20.glColorMask(true, true, true, true);
        GLES20.glClear(16640);
        GLES20.glDisable(2929);
        G(gl10);
        GLES20.glFinish();
    }

    private void G(GL10 gl10) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f198512d.onDrawFrame(gl10);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isDebugVersion()) {
            int i3 = this.S + 1;
            this.S = i3;
            this.R = (int) (this.R + (currentTimeMillis2 - currentTimeMillis));
            if (i3 % 100 == 0) {
                Log.i("wing", "scan line anime cameraRenderer cost---- " + ((this.R * 1.0f) / Math.max(1, this.S)));
            }
        }
        com.tencent.mobileqq.ar.ARRenderModel.a aVar = this.f198514f;
        if (aVar != null && aVar.canRender()) {
            System.currentTimeMillis();
            GLES20.glEnable(2929);
            h.a b16 = this.C.b(aVar.getType(), aVar.g());
            if (b16 != null) {
                aVar.l(b16);
            }
            GLES20.glDisable(2929);
            System.currentTimeMillis();
        }
        System.currentTimeMillis();
    }

    private com.tencent.mobileqq.ar.ARRenderModel.a p(String str) {
        if (this.T.containsKey(str)) {
            return this.T.get(str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public boolean A(GLSurfaceView gLSurfaceView, Context context) {
        QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "init.");
        this.f198513e = gLSurfaceView;
        this.f198516i = context;
        this.f198514f = null;
        return true;
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public void B(long j3) {
        this.C.f197234a = j3;
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public boolean C() {
        CameraRendererable cameraRendererable = this.f198512d;
        if (cameraRendererable != null) {
            return cameraRendererable.i();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public void D(com.tencent.mobileqq.ar.ARRenderModel.b bVar) {
        this.f198517m = bVar;
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public void E(g gVar) {
        this.K = gVar;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public Context d() {
        return this.f198516i;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public Object e(int i3) {
        return this.D.get(Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public void f(String str) {
        this.T.remove(str);
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public void h(int i3, int i16) {
        if (this.f198517m != null && this.f198514f != null) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            this.f198517m.B(this.f198514f.getUniqueKey(), i16);
                            return;
                        }
                        return;
                    }
                    this.f198517m.w(this.f198514f.getUniqueKey(), i16);
                    return;
                }
                this.f198517m.i(this.f198514f.getUniqueKey(), i16);
                return;
            }
            this.f198517m.f(this.f198514f.getUniqueKey(), i16);
            return;
        }
        QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "notifyAnimationPlayStatusChange.mCurrentRenderable or mOutCallBack is null");
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public void i(Runnable runnable) {
        GLSurfaceView gLSurfaceView = this.f198513e;
        if (gLSurfaceView != null) {
            gLSurfaceView.queueEvent(runnable);
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public h k() {
        return this.C;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public void m(com.tencent.mobileqq.ar.ARRenderModel.a aVar, ArCloudConfigInfo arCloudConfigInfo, int i3, int i16, Object obj) {
        com.tencent.mobileqq.ar.ARRenderModel.b bVar;
        if (arCloudConfigInfo != null && arCloudConfigInfo.e() && (bVar = this.f198517m) != null) {
            bVar.e(arCloudConfigInfo, i3, i16, obj);
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public void n(ArVideoResourceInfo arVideoResourceInfo, com.tencent.mobileqq.ar.ARRenderModel.c cVar) {
        com.tencent.mobileqq.ar.ARRenderModel.b bVar = this.f198517m;
        if (bVar == null) {
            return;
        }
        bVar.b(arVideoResourceInfo, cVar);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        boolean z16;
        RenderBuffer renderBuffer;
        g gVar = this.K;
        if (gVar != null && gVar.f()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (!this.H) {
                if (this.I == null) {
                    this.I = new RenderBuffer(U, V, 33984);
                }
                if (this.J == null) {
                    this.J = new TextureRender();
                }
                this.K.k(this.G, U, V);
                this.H = true;
            }
            RenderBuffer renderBuffer2 = this.I;
            if (renderBuffer2 == null) {
                F(gl10);
                QLog.d("AREngine_UniformGLRenderManagerImpl", 1, "onDrawFrame, mRecordFBO == null");
                return;
            }
            renderBuffer2.bind();
            F(gl10);
            this.I.unbind();
            this.K.t(GLSLRender.GL_TEXTURE_2D, this.I.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(0, 0, U, V);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glDisable(2929);
            GLES20.glDisable(3042);
            this.J.drawTexture(GLSLRender.GL_TEXTURE_2D, this.I.getTexId(), null, null);
        } else {
            if (this.H) {
                RenderBuffer renderBuffer3 = this.I;
                if (renderBuffer3 != null) {
                    GLES20.glDeleteTextures(1, new int[]{renderBuffer3.getTexId()}, 0);
                    this.I.destroy();
                    this.I = null;
                }
                TextureRender textureRender = this.J;
                if (textureRender != null) {
                    textureRender.release();
                    this.J = null;
                }
                g gVar2 = this.K;
                if (gVar2 != null) {
                    gVar2.u();
                }
                this.H = false;
            }
            GLES20.glViewport(0, 0, U, V);
            if (this.L) {
                renderBuffer = new RenderBuffer(U, V, 33984);
                renderBuffer.bind();
            } else {
                renderBuffer = null;
            }
            F(gl10);
            if (this.L) {
                renderBuffer.unbind();
                TextureRender textureRender2 = new TextureRender();
                GLES20.glViewport(0, 0, U, V);
                textureRender2.drawTexture(GLSLRender.GL_TEXTURE_2D, renderBuffer.getTexId(), null, null);
                RenderBuffer renderBuffer4 = new RenderBuffer(540, 960, 33984);
                renderBuffer4.bind();
                textureRender2.drawTexture(GLSLRender.GL_TEXTURE_2D, renderBuffer.getTexId(), null, null);
                renderBuffer4.unbind();
                Bitmap captureFrame = GlUtil.captureFrame(renderBuffer4.getTexId(), 540, 960, 0);
                GLES20.glDeleteTextures(1, new int[]{renderBuffer4.getTexId()}, 0);
                GLES20.glDeleteTextures(1, new int[]{renderBuffer.getTexId()}, 0);
                renderBuffer4.destroy();
                textureRender2.release();
                renderBuffer.destroy();
                com.tencent.mobileqq.ar.ARRenderModel.b bVar = this.f198517m;
                if (bVar != null) {
                    bVar.e(null, 1001, 0, captureFrame);
                }
                this.L = false;
            }
        }
        if (this.E == 0) {
            this.E = System.currentTimeMillis();
        }
        this.F++;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        U = i3;
        V = i16;
        com.tencent.mobileqq.ar.view.c cVar = this.P;
        if (cVar != null) {
            cVar.Ac(gl10, i3, i16);
        }
        this.f198512d.onSurfaceChanged(gl10, i3, i16);
        com.tencent.mobileqq.ar.ARRenderModel.b bVar = this.f198517m;
        if (bVar != null) {
            bVar.s();
        }
        this.Q = true;
        this.N = true;
        GLES20.glEnable(2884);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        String[] strArr;
        QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "onSurfaceCreated.");
        this.M = false;
        if (e.c()) {
            this.G = new com.tencent.mobileqq.videocodec.mediacodec.encoder.a(EGL14.eglGetCurrentContext(), 1);
        }
        ARDeviceController.b().h(gl10.glGetString(7937));
        this.f198512d.onSurfaceCreated(gl10, eGLConfig);
        com.tencent.mobileqq.ar.view.c cVar = this.P;
        if (cVar != null) {
            cVar.mc(gl10);
        }
        gl10.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
        if (QLog.isDevelopLevel()) {
            QLog.d("GPU_INFO", 2, "GL_RENDERER = " + gl10.glGetString(7937));
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GL_RENDERER = ");
        sb5.append(gl10.glGetString(7937));
        if (QLog.isDevelopLevel()) {
            QLog.d("GPU_INFO", 1, "GL_VENDOR = " + gl10.glGetString(7936));
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("GL_VENDOR = ");
        sb6.append(gl10.glGetString(7936));
        if (QLog.isDevelopLevel()) {
            QLog.d("GPU_INFO", 2, "GL_VERSION = " + gl10.glGetString(7938));
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append("GL_VERSION = ");
        sb7.append(gl10.glGetString(7938));
        IntBuffer allocate = IntBuffer.allocate(20);
        gl10.glGetIntegerv(36347, allocate);
        StringBuilder sb8 = new StringBuilder();
        sb8.append("GL_MAX_VERTEX_UNIFORM_VECTORS = ");
        sb8.append(allocate.get());
        IntBuffer allocate2 = IntBuffer.allocate(20);
        gl10.glGetIntegerv(35661, allocate2);
        StringBuilder sb9 = new StringBuilder();
        sb9.append("GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = ");
        sb9.append(allocate2.get());
        IntBuffer allocate3 = IntBuffer.allocate(20);
        gl10.glGetIntegerv(34076, allocate3);
        StringBuilder sb10 = new StringBuilder();
        sb10.append("GL_MAX_CUBE_MAP_TEXTURE_SIZE = ");
        sb10.append(allocate3.get());
        IntBuffer allocate4 = IntBuffer.allocate(20);
        gl10.glGetIntegerv(34024, allocate4);
        StringBuilder sb11 = new StringBuilder();
        sb11.append("GL_MAX_RENDERBUFFER_SIZE = ");
        sb11.append(allocate4.get());
        IntBuffer allocate5 = IntBuffer.allocate(20);
        gl10.glGetIntegerv(34930, allocate5);
        StringBuilder sb12 = new StringBuilder();
        sb12.append("GL_MAX_TEXTURE_IMAGE_UNITS = ");
        sb12.append(allocate5.get());
        IntBuffer allocate6 = IntBuffer.allocate(20);
        gl10.glGetIntegerv(3379, allocate6);
        StringBuilder sb13 = new StringBuilder();
        sb13.append("GL_MAX_TEXTURE_SIZE = ");
        sb13.append(allocate6.get());
        IntBuffer allocate7 = IntBuffer.allocate(20);
        gl10.glGetIntegerv(36349, allocate7);
        StringBuilder sb14 = new StringBuilder();
        sb14.append("GL_MAX_FRAGMENT_UNIFORM_VECTORS = ");
        sb14.append(allocate7.get());
        IntBuffer allocate8 = IntBuffer.allocate(20);
        gl10.glGetIntegerv(34921, allocate8);
        StringBuilder sb15 = new StringBuilder();
        sb15.append("GL_MAX_VERTEX_ATTRIBS = ");
        sb15.append(allocate8.get());
        IntBuffer allocate9 = IntBuffer.allocate(20);
        gl10.glGetIntegerv(36348, allocate9);
        StringBuilder sb16 = new StringBuilder();
        sb16.append("GL_MAX_VARYING_VECTORS = ");
        sb16.append(allocate9.get());
        IntBuffer allocate10 = IntBuffer.allocate(20);
        gl10.glGetIntegerv(36349, allocate10);
        StringBuilder sb17 = new StringBuilder();
        sb17.append("GL_MAX_FRAGMENT_UNIFORM_VECTORS = ");
        sb17.append(allocate10.get());
        StringBuilder sb18 = new StringBuilder();
        String glGetString = gl10.glGetString(7939);
        if (glGetString != null) {
            strArr = glGetString.split(" ");
        } else {
            strArr = null;
        }
        if (strArr != null) {
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("GPU_INFO", 2, "GL_EXTENSIONS = " + strArr[i3]);
                    sb18.append(strArr[i3] + " ");
                }
            }
        }
        x.a(gl10.glGetString(7937), gl10.glGetString(7936), gl10.glGetString(7938), sb18.toString());
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public void q() {
        QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender.");
        this.f198513e.queueEvent(new Runnable() { // from class: com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (UniformGLRenderManagerImpl.this.M) {
                    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender. has been refused");
                    return;
                }
                if (UniformGLRenderManagerImpl.this.f198514f != null) {
                    UniformGLRenderManagerImpl uniformGLRenderManagerImpl = UniformGLRenderManagerImpl.this;
                    uniformGLRenderManagerImpl.T.remove(uniformGLRenderManagerImpl.f198514f.getUniqueKey());
                    UniformGLRenderManagerImpl.this.f198514f.onDestroy();
                    UniformGLRenderManagerImpl.this.f198514f = null;
                }
                if (UniformGLRenderManagerImpl.this.I != null) {
                    GLES20.glDeleteTextures(1, new int[]{UniformGLRenderManagerImpl.this.I.getTexId()}, 0);
                    UniformGLRenderManagerImpl.this.I.destroy();
                    UniformGLRenderManagerImpl.this.I = null;
                }
                if (UniformGLRenderManagerImpl.this.J != null) {
                    UniformGLRenderManagerImpl.this.J.release();
                    UniformGLRenderManagerImpl.this.J = null;
                }
                if (UniformGLRenderManagerImpl.this.K != null) {
                    UniformGLRenderManagerImpl.this.K.u();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public void r(int i3, Object obj) {
        this.D.put(Integer.valueOf(i3), obj);
    }

    @Override // com.tencent.mobileqq.ar.model.d, com.tencent.mobileqq.ar.ARRenderModel.c
    public void requestRender() {
        GLSurfaceView gLSurfaceView = this.f198513e;
        if (gLSurfaceView != null) {
            gLSurfaceView.requestRender();
        }
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public void s(int i3, SurfaceTexture surfaceTexture, int i16, int i17, int i18, int i19) {
        QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startCameraPreviewRender. textureId = " + i3 + ", surfaceTexture = " + surfaceTexture);
        this.f198512d.l(i3, surfaceTexture);
        this.f198512d.n(i16, i17, i18, i19);
        this.E = 0L;
        this.F = 0L;
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public boolean start() {
        QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "start.");
        return true;
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public void stop() {
        QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stop. mHasDestroyElgContext:" + this.M);
        this.N = false;
        if (this.M) {
            return;
        }
        Iterator<com.tencent.mobileqq.ar.ARRenderModel.a> it = this.T.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.T.clear();
        this.f198514f = null;
        this.f198512d.f();
        this.C.f();
        this.Q = false;
        this.M = true;
        try {
            com.tencent.mobileqq.videocodec.mediacodec.encoder.a aVar = this.G;
            if (aVar != null) {
                aVar.g();
                this.G = null;
            }
        } catch (Exception e16) {
            QLog.e("AREngine_UniformGLRenderManagerImpl", 1, "stop, mEglCore release: " + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public long t() {
        return this.C.f197234a;
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public boolean u(final com.tencent.mobileqq.ar.ARRenderModel.e eVar) {
        QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startModelRender. resourceInfo.key = " + eVar.f197225a + ", resourceInfo.arType = " + eVar.f197226b + ", resourceInfo.trackMode = " + eVar.f197228d);
        if (!this.Q) {
            QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startModelRender. fail because of render not ready");
            return false;
        }
        final com.tencent.mobileqq.ar.ARRenderModel.a p16 = p(eVar.f197225a);
        if (p16 == null) {
            p16 = com.tencent.mobileqq.ar.ARRenderModel.g.a(this, eVar, this.f198513e);
            QLog.d("AREngine_UniformGLRenderManagerImpl", 1, "crate new render here 1" + p16);
            this.T.put(eVar.f197225a, p16);
            QLog.d("AREngine_UniformGLRenderManagerImpl", 1, "crate new render here " + p16);
        }
        if (p16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("HSRender", 1, "onARStateChanged, renderable == null");
            }
            final com.tencent.mobileqq.ar.ARRenderModel.a aVar = this.f198514f;
            this.f198514f = null;
            this.f198513e.queueEvent(new Runnable() { // from class: com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.ar.ARRenderModel.a aVar2 = aVar;
                    if (aVar2 != null && aVar2 != UniformGLRenderManagerImpl.this.f198514f) {
                        aVar.onDestroy();
                    }
                }
            });
            return false;
        }
        this.f198513e.queueEvent(new Runnable() { // from class: com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                p16.c(UniformGLRenderManagerImpl.U, UniformGLRenderManagerImpl.V);
                com.tencent.mobileqq.ar.ARRenderModel.a aVar2 = UniformGLRenderManagerImpl.this.f198514f;
                UniformGLRenderManagerImpl.this.f198514f = p16;
                if (QLog.isColorLevel()) {
                    QLog.d("HSRender", 2, "onARStateChanged, queueEvent");
                }
                if (aVar2 != null && aVar2 != UniformGLRenderManagerImpl.this.f198514f) {
                    aVar2.onDestroy();
                }
                if (UniformGLRenderManagerImpl.this.f198514f == null) {
                    return;
                }
                com.tencent.mobileqq.ar.ARRenderModel.e eVar2 = eVar;
                if (eVar2.f197226b == 5) {
                    long j3 = eVar2.f197227c;
                    if (j3 == 2 || j3 == 2048) {
                        z16 = true;
                        UniformGLRenderManagerImpl.this.C.f();
                        UniformGLRenderManagerImpl.this.C.g(z16, eVar);
                        UniformGLRenderManagerImpl.this.f198514f.init();
                        UniformGLRenderManagerImpl.this.f198514f.start();
                    }
                }
                z16 = false;
                UniformGLRenderManagerImpl.this.C.f();
                UniformGLRenderManagerImpl.this.C.g(z16, eVar);
                UniformGLRenderManagerImpl.this.f198514f.init();
                UniformGLRenderManagerImpl.this.f198514f.start();
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public void uninit() {
        QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "uninit.");
        this.f198513e = null;
        this.f198516i = null;
        this.f198517m = null;
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public void v(com.tencent.mobileqq.ar.view.c cVar) {
        this.P = cVar;
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public boolean w(boolean z16, float f16, float f17) {
        QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "enableCameraPreviewScanLine. isEnable = " + z16 + ", endY = " + f17);
        CameraRendererable cameraRendererable = this.f198512d;
        if (cameraRendererable != null) {
            cameraRendererable.m(z16);
            this.f198512d.k(f17);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public void x(long j3) {
        this.C.f197236c = j3;
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public void y(int i3, float[] fArr) {
        this.C.h(fArr);
    }

    @Override // com.tencent.mobileqq.ar.model.d
    public void z(f fVar) {
        this.C.i(fVar);
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public void j(ArVideoResourceInfo arVideoResourceInfo) {
    }
}
