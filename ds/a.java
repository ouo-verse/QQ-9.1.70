package ds;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.ark.EGLContextHolder;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.TimeoutException;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements SurfaceTexture.OnFrameAvailableListener {
    int D;
    int E;
    private boolean G;
    private ByteBuffer H;

    /* renamed from: d, reason: collision with root package name */
    private b f394725d;

    /* renamed from: e, reason: collision with root package name */
    private SurfaceTexture f394726e;

    /* renamed from: f, reason: collision with root package name */
    private Surface f394727f;

    /* renamed from: h, reason: collision with root package name */
    private EGL10 f394728h;

    /* renamed from: i, reason: collision with root package name */
    private EGLDisplay f394729i = EGL10.EGL_NO_DISPLAY;

    /* renamed from: m, reason: collision with root package name */
    private EGLContext f394730m = EGL10.EGL_NO_CONTEXT;
    private EGLSurface C = EGL10.EGL_NO_SURFACE;
    private Object F = new Object();

    public a(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            this.f394728h = (EGL10) EGLContext.getEGL();
            this.D = i3;
            this.E = i16;
            d();
            g();
            i();
            return;
        }
        throw new IllegalArgumentException();
    }

    private void b(String str) {
        int eglGetError = this.f394728h.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    private void d() {
        EGLDisplay eglGetDisplay = this.f394728h.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f394729i = eglGetDisplay;
        if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
            if (this.f394728h.eglInitialize(eglGetDisplay, new int[2])) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (this.f394728h.eglChooseConfig(this.f394729i, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, eGLConfigArr, 1, new int[1])) {
                    this.f394730m = this.f394728h.eglCreateContext(this.f394729i, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
                    b("eglCreateContext");
                    if (this.f394730m != null) {
                        this.C = this.f394728h.eglCreatePbufferSurface(this.f394729i, eGLConfigArr[0], new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, this.D, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, this.E, 12344});
                        b("eglCreatePbufferSurface");
                        if (this.C == null) {
                            throw new RuntimeException("surface was null");
                        }
                        return;
                    }
                    throw new RuntimeException("null context");
                }
                throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
            }
            this.f394729i = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    private void i() {
        b bVar = new b();
        this.f394725d = bVar;
        bVar.g();
        Log.d("CodecOutputSurface", "textureID=" + this.f394725d.e());
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f394725d.e());
        this.f394726e = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f394727f = new Surface(this.f394726e);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.D * this.E * 4);
        this.H = allocateDirect;
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
    }

    public void a() throws TimeoutException {
        Log.e("CodecOutputSurface", "awaitNewImage");
        synchronized (this.F) {
            do {
                if (!this.G) {
                    try {
                        this.F.wait(1L);
                    } catch (InterruptedException e16) {
                        throw new RuntimeException(e16);
                    }
                } else {
                    this.G = false;
                }
            } while (this.G);
            throw new TimeoutException("frame wait timed out");
        }
    }

    public void c(boolean z16) {
        this.f394725d.d(this.f394726e, z16);
    }

    public Bitmap e() {
        this.H.rewind();
        GLES20.glReadPixels(0, 0, this.D, this.E, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.H);
        Bitmap createBitmap = Bitmap.createBitmap(this.D, this.E, Bitmap.Config.ARGB_8888);
        this.H.rewind();
        createBitmap.copyPixelsFromBuffer(this.H);
        Log.d("CodecOutputSurface", "getFrameBitmap() finish...");
        return createBitmap;
    }

    public Surface f() {
        return this.f394727f;
    }

    public void g() {
        EGL10 egl10 = this.f394728h;
        EGLDisplay eGLDisplay = this.f394729i;
        EGLSurface eGLSurface = this.C;
        if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f394730m)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void h() {
        EGLDisplay eGLDisplay = this.f394729i;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            this.f394728h.eglDestroySurface(eGLDisplay, this.C);
            this.f394728h.eglDestroyContext(this.f394729i, this.f394730m);
            EGL10 egl10 = this.f394728h;
            EGLDisplay eGLDisplay2 = this.f394729i;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.f394728h.eglTerminate(this.f394729i);
        }
        this.f394729i = EGL10.EGL_NO_DISPLAY;
        this.f394730m = EGL10.EGL_NO_CONTEXT;
        this.C = EGL10.EGL_NO_SURFACE;
        this.f394727f.release();
        this.f394725d = null;
        this.f394727f = null;
        this.f394726e = null;
    }

    public void j() {
        this.f394725d.a("before updateTexImage");
        this.f394726e.updateTexImage();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Log.e("CodecOutputSurface", "onFrameAvailable new frame available");
        synchronized (this.F) {
            if (!this.G) {
                this.G = true;
                this.F.notifyAll();
            } else {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
        }
    }
}
