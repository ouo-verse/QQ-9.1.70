package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qzoneplayer.video.b;
import com.tencent.oskplayer.util.PlayerUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes35.dex */
public class VideoSurfaceView extends GLSurfaceView {

    /* renamed from: f, reason: collision with root package name */
    private static int f279938f;

    /* renamed from: d, reason: collision with root package name */
    a f279939d;

    /* renamed from: e, reason: collision with root package name */
    f f279940e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class a implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
        private static String U = "VideoRender";
        private static int V = 36197;
        private int C;
        private int D;
        private int E;
        private int F;
        private int G;
        private final GLSurfaceView H;
        private SurfaceTexture I;
        private boolean J;
        private float[] K;
        private short[] L;
        private FloatBuffer M;
        private ShortBuffer N;
        private RectF P;
        private b Q;
        private final Point R;
        private final RectF S;
        private boolean T;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f279941d;

        /* renamed from: e, reason: collision with root package name */
        private final String f279942e;

        /* renamed from: f, reason: collision with root package name */
        private final String f279943f;

        /* renamed from: h, reason: collision with root package name */
        private float[] f279944h;

        /* renamed from: i, reason: collision with root package name */
        private float[] f279945i;

        /* renamed from: m, reason: collision with root package name */
        private int f279946m;

        public a(GLSurfaceView gLSurfaceView) {
            this(gLSurfaceView, new b(), new RectF(-1.0f, 1.0f, 1.0f, -1.0f));
        }

        private void a(String str) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                return;
            }
            PlayerUtils.log(6, U, str + ": glError " + glGetError);
            throw new RuntimeException(str + ": glError " + glGetError);
        }

        private int e(int i3, String str) {
            int glCreateShader = GLES20.glCreateShader(i3);
            if (glCreateShader == 0) {
                return glCreateShader;
            }
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] != 0) {
                return glCreateShader;
            }
            PlayerUtils.log(6, U, "Could not compile shader " + i3 + ":");
            PlayerUtils.log(6, U, GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }

        private void i() {
            b.a c16 = this.Q.c(this.P, this.S, this.R, VideoSurfaceView.f279938f);
            float[] fArr = c16.f279968a;
            this.K = fArr;
            this.L = c16.f279969b;
            FloatBuffer floatBuffer = this.M;
            if (floatBuffer != null) {
                floatBuffer.clear();
            } else {
                this.M = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            }
            ShortBuffer shortBuffer = this.N;
            if (shortBuffer != null) {
                shortBuffer.clear();
            } else {
                this.N = ByteBuffer.allocateDirect(this.L.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
            }
            this.M.put(this.K).position(0);
            this.N.put(this.L).position(0);
        }

        public Surface c() {
            return new Surface(this.I);
        }

        public boolean d() {
            return this.I != null;
        }

        public void f(float f16, float f17, float f18, float f19) {
            RectF rectF = this.P;
            rectF.left = f16;
            rectF.top = f17;
            rectF.right = f18;
            rectF.bottom = f19;
            if (this.R.x > 1) {
                i();
            }
        }

        public void g(boolean z16) {
            this.T = z16;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                if (this.J) {
                    this.I.updateTexImage();
                    this.I.getTransformMatrix(this.f279945i);
                    this.J = false;
                }
            }
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(this.T ? 49408 : 16640);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
            GLES20.glUseProgram(this.f279946m);
            a("glUseProgram");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(V, this.C);
            this.M.position(0);
            GLES20.glVertexAttribPointer(this.F, 3, 5126, false, 20, (Buffer) this.M);
            a("glVertexAttribPointer maPosition");
            GLES20.glEnableVertexAttribArray(this.F);
            a("glEnableVertexAttribArray maPositionHandle");
            this.M.position(3);
            GLES20.glVertexAttribPointer(this.G, 3, 5126, false, 20, (Buffer) this.M);
            a("glVertexAttribPointer maTextureHandle");
            GLES20.glEnableVertexAttribArray(this.G);
            a("glEnableVertexAttribArray maTextureHandle");
            Matrix.setIdentityM(this.f279944h, 0);
            Matrix.scaleM(this.f279944h, 0, 1.0f, 1.0f, 1.0f);
            GLES20.glUniformMatrix4fv(this.D, 1, false, this.f279944h, 0);
            GLES20.glUniformMatrix4fv(this.E, 1, false, this.f279945i, 0);
            GLES20.glDrawElements(4, this.L.length, 5123, this.N);
            a("glDrawElements");
            GLES20.glFinish();
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.J = true;
            this.H.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            int b16 = b("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
            this.f279946m = b16;
            if (b16 == 0) {
                return;
            }
            this.F = GLES20.glGetAttribLocation(b16, "aPosition");
            a("glGetAttribLocation aPosition");
            if (this.F != -1) {
                this.G = GLES20.glGetAttribLocation(this.f279946m, "aTextureCoord");
                a("glGetAttribLocation aTextureCoord");
                if (this.G != -1) {
                    this.D = GLES20.glGetUniformLocation(this.f279946m, "uMVPMatrix");
                    a("glGetUniformLocation uMVPMatrix");
                    if (this.D != -1) {
                        this.E = GLES20.glGetUniformLocation(this.f279946m, "uSTMatrix");
                        a("glGetUniformLocation uSTMatrix");
                        if (this.E != -1) {
                            int[] iArr = new int[1];
                            GLES20.glGenTextures(1, iArr, 0);
                            int i3 = iArr[0];
                            this.C = i3;
                            GLES20.glBindTexture(V, i3);
                            a("glBindTexture mTextureID");
                            GLES20.glTexParameterf(V, 10241, 9729.0f);
                            GLES20.glTexParameterf(V, 10240, 9729.0f);
                            SurfaceTexture surfaceTexture = new SurfaceTexture(this.C);
                            this.I = surfaceTexture;
                            surfaceTexture.setOnFrameAvailableListener(this);
                            synchronized (this) {
                                this.J = false;
                            }
                            return;
                        }
                        throw new RuntimeException("Could not get attrib location for uSTMatrix");
                    }
                    throw new RuntimeException("Could not get attrib location for uMVPMatrix");
                }
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            throw new RuntimeException("Could not get attrib location for aPosition");
        }

        public a(GLSurfaceView gLSurfaceView, b bVar, RectF rectF) {
            this.f279941d = true;
            this.f279942e = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
            this.f279943f = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
            this.f279944h = new float[16];
            this.f279945i = new float[16];
            this.J = false;
            this.P = new RectF();
            Point point = new Point();
            this.R = point;
            this.T = false;
            this.H = gLSurfaceView;
            this.Q = bVar;
            this.S = rectF;
            point.set(1, 1);
            Matrix.setIdentityM(this.f279945i, 0);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
            GLES20.glViewport(0, 0, i3, i16);
            this.R.set(i3, i16);
            i();
        }

        private int b(String str, String str2) {
            int e16;
            int e17 = e(35633, str);
            if (e17 == 0 || (e16 = e(35632, str2)) == 0) {
                return 0;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            if (glCreateProgram != 0) {
                GLES20.glAttachShader(glCreateProgram, e17);
                a("glAttachShader");
                GLES20.glAttachShader(glCreateProgram, e16);
                a("glAttachShader");
                GLES20.glLinkProgram(glCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    PlayerUtils.log(6, U, "Could not link program: ");
                    PlayerUtils.log(6, U, GLES20.glGetProgramInfoLog(glCreateProgram));
                    GLES20.glDeleteProgram(glCreateProgram);
                    return 0;
                }
            }
            return glCreateProgram;
        }

        public void h(float f16) {
        }
    }

    public VideoSurfaceView(Context context) {
        super(context);
        c(new a(this));
    }

    public Surface b() {
        a aVar = this.f279939d;
        if (aVar == null) {
            return null;
        }
        return aVar.c();
    }

    public boolean d() {
        a aVar = this.f279939d;
        return aVar != null && aVar.d();
    }

    public void setCornerRadius(float f16) {
        setCornerRadius(f16, f16, f16, f16);
    }

    public void setCornerTriangleNumber(int i3) {
        f279938f = i3;
    }

    public void setVideoAspectRatio(float f16) {
        this.f279939d.h(f16);
    }

    private void c(a aVar) {
        setEGLContextClientVersion(2);
        e(true, true);
        f fVar = this.f279940e;
        if (fVar != null) {
            aVar.g(fVar.b());
        }
        this.f279939d = aVar;
        setRenderer(aVar);
        setRenderMode(0);
        f279938f = 6;
    }

    public void setCornerRadius(float f16, float f17, float f18, float f19) {
        this.f279939d.f(f16, f17, f18, f19);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(new a(this));
    }

    private void e(boolean z16, boolean z17) {
        if (z16) {
            if (z17) {
                f fVar = new f();
                this.f279940e = fVar;
                setEGLConfigChooser(fVar);
            } else {
                setEGLConfigChooser(8, 8, 8, 8, 16, 0);
            }
            getHolder().setFormat(1);
            return;
        }
        if (z17) {
            f fVar2 = new f();
            this.f279940e = fVar2;
            setEGLConfigChooser(fVar2);
        } else {
            setEGLConfigChooser(5, 6, 5, 0, 16, 0);
        }
        getHolder().setFormat(4);
    }
}
