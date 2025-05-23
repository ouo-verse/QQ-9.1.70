package com.tencent.mobileqq.ar.ARRenderModel;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Handler;
import android.util.Size;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ar.DrawView2;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.Random;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes11.dex */
public class CameraRendererable implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: s0, reason: collision with root package name */
    private static String f197111s0 = "AREngine_CameraRendererable";

    /* renamed from: t0, reason: collision with root package name */
    private static int f197112t0;

    /* renamed from: u0, reason: collision with root package name */
    private static int f197113u0;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private float M;
    private float P;
    private float Q;
    private SurfaceTexture U;
    private c V;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: b0, reason: collision with root package name */
    h f197115b0;

    /* renamed from: e, reason: collision with root package name */
    private int f197119e;

    /* renamed from: f, reason: collision with root package name */
    private int f197121f;

    /* renamed from: h, reason: collision with root package name */
    private int f197124h;

    /* renamed from: i, reason: collision with root package name */
    private int f197126i;

    /* renamed from: j0, reason: collision with root package name */
    private Bitmap f197128j0;

    /* renamed from: k0, reason: collision with root package name */
    private Canvas f197129k0;

    /* renamed from: l0, reason: collision with root package name */
    private Paint f197130l0;

    /* renamed from: m, reason: collision with root package name */
    private int f197131m;

    /* renamed from: o0, reason: collision with root package name */
    private Random f197134o0;

    /* renamed from: q0, reason: collision with root package name */
    private FloatBuffer f197136q0;

    /* renamed from: r0, reason: collision with root package name */
    private Size f197137r0;

    /* renamed from: d, reason: collision with root package name */
    j f197117d = new j();
    private float L = 1.0f;
    private float N = 1.0f;
    private boolean R = false;
    private float[] S = new float[16];
    private y1.a T = new y1.a();
    private int W = -1;

    /* renamed from: a0, reason: collision with root package name */
    Handler f197114a0 = new Handler();

    /* renamed from: c0, reason: collision with root package name */
    public boolean f197116c0 = true;

    /* renamed from: d0, reason: collision with root package name */
    private int f197118d0 = 1;

    /* renamed from: e0, reason: collision with root package name */
    private float[] f197120e0 = new float[16];

    /* renamed from: f0, reason: collision with root package name */
    Runnable f197122f0 = new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.CameraRendererable.1
        @Override // java.lang.Runnable
        public void run() {
            if (CameraRendererable.this.V != null) {
                try {
                    CameraRendererable.this.V.requestRender();
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d(CameraRendererable.f197111s0, 2, "requestRender", e16);
                    }
                }
            }
        }
    };

    /* renamed from: g0, reason: collision with root package name */
    private int f197123g0 = 255;

    /* renamed from: h0, reason: collision with root package name */
    private a[] f197125h0 = new a[300];

    /* renamed from: i0, reason: collision with root package name */
    private float[] f197127i0 = new float[600];

    /* renamed from: m0, reason: collision with root package name */
    private int f197132m0 = 0;

    /* renamed from: n0, reason: collision with root package name */
    private long f197133n0 = 0;

    /* renamed from: p0, reason: collision with root package name */
    private long f197135p0 = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        float f197138a;

        /* renamed from: b, reason: collision with root package name */
        float f197139b;

        /* renamed from: c, reason: collision with root package name */
        boolean f197140c = true;

        a() {
        }
    }

    public CameraRendererable(c cVar) {
        this.V = cVar;
        this.f197115b0 = cVar.k();
    }

    protected void F() {
        GLES20.glUseProgram(this.C);
    }

    protected void c(float[] fArr, FloatBuffer floatBuffer, int i3, int i16, float[] fArr2, FloatBuffer floatBuffer2, int i17) {
        if (this.R) {
            if (this.f197135p0 == -1) {
                this.f197135p0 = System.currentTimeMillis();
            }
            float currentTimeMillis = (float) (System.currentTimeMillis() - this.f197135p0);
            if (currentTimeMillis < 4000.0f) {
                float f16 = (currentTimeMillis * 1.0f) / 4000.0f;
                this.M = f16 * f16 * f16 * 1.35f;
            } else {
                this.M = 0.0f;
                this.f197135p0 = System.currentTimeMillis();
            }
            this.f197132m0 = 1;
        } else {
            this.M = 0.0f;
            this.f197135p0 = -1L;
            this.f197132m0 = 0;
        }
        GLES20.glUniform1f(this.D, this.P);
        GLES20.glUniform1f(this.E, this.Q);
        GLES20.glUniform1f(this.F, this.M);
        GLES20.glUniform1f(this.G, this.N);
        GLES20.glUniformMatrix4fv(this.f197121f, 1, false, fArr, 0);
        GLES20.glUniformMatrix4fv(this.f197124h, 1, false, fArr2, 0);
        GLES20.glEnableVertexAttribArray(this.f197119e);
        GLES20.glVertexAttribPointer(this.f197119e, i3, 5126, false, i16, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.f197126i);
        GLES20.glVertexAttribPointer(this.f197126i, 2, 5126, false, i17, (Buffer) floatBuffer2);
    }

    protected void d(int i3) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i3);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.X);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.Y);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glUniform1i(this.f197131m, 0);
        GLES20.glUniform1i(this.H, 1);
        GLES20.glUniform1i(this.I, 2);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.Z);
        e();
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glUniform1i(this.J, 3);
        if (this.f197128j0 == null) {
            this.f197132m0 = 0;
        }
        GLES20.glUniform1i(this.K, this.f197132m0);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0114 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        float f16;
        long j3 = this.f197133n0 + 1;
        this.f197133n0 = j3;
        if (this.f197128j0 != null && this.f197132m0 != 0 && j3 % 3 == 1) {
            if (this.f197134o0 == null) {
                this.f197134o0 = new Random();
            }
            System.currentTimeMillis();
            int width = this.f197128j0.getWidth();
            int height = this.f197128j0.getHeight();
            int i3 = this.f197123g0;
            float f17 = height;
            float f18 = 1.0f / f17;
            float f19 = 5.0f / f17;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (i16 < 300) {
                a aVar = this.f197125h0[i16];
                if (aVar != null && !aVar.f197140c) {
                    if (this.f197134o0.nextFloat() > (0.7f - (aVar.f197139b * 0.35f)) - Math.abs((aVar.f197138a * 0.3f) - 0.15f)) {
                        aVar.f197140c = true;
                    } else {
                        float nextFloat = this.f197134o0.nextFloat();
                        float f26 = aVar.f197139b;
                        float f27 = f26 + (nextFloat * 0.3f) + (0.2f * f26) + f19;
                        aVar.f197139b = f27;
                        f16 = f18;
                        if (f27 > 1.0d) {
                            aVar.f197140c = true;
                        }
                        if (aVar != null || aVar.f197140c) {
                            if (i18 <= i3) {
                                if (aVar == null) {
                                    a aVar2 = new a();
                                    this.f197125h0[i16] = aVar2;
                                    aVar = aVar2;
                                }
                                float nextFloat2 = this.f197134o0.nextFloat();
                                if (nextFloat2 < 0.4d) {
                                    aVar.f197138a = (nextFloat2 * 2.35f) + 0.02f;
                                } else if (nextFloat2 > 0.6f) {
                                    aVar.f197138a = ((1.0f - nextFloat2) * 2.35f) + 0.02f;
                                }
                                aVar.f197139b = (this.f197134o0.nextFloat() * 0.05f) + f16;
                                aVar.f197140c = false;
                                i18++;
                            } else {
                                i16++;
                                f18 = f16;
                            }
                        }
                        if (!aVar.f197140c && aVar.f197139b < 1.0d) {
                            float[] fArr = this.f197127i0;
                            int i19 = i17 * 2;
                            a aVar3 = this.f197125h0[i16];
                            fArr[i19] = aVar3.f197138a * width;
                            fArr[i19 + 1] = aVar3.f197139b * f17;
                            i17++;
                        }
                        i16++;
                        f18 = f16;
                    }
                }
                f16 = f18;
                if (aVar != null) {
                }
                if (i18 <= i3) {
                }
            }
            this.f197129k0.drawColor(-16777216, PorterDuff.Mode.CLEAR);
            this.f197130l0.setStrokeWidth(1.0f);
            this.f197130l0.setColor(-1);
            this.f197129k0.drawPoints(this.f197127i0, 0, i17, this.f197130l0);
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, this.f197128j0, 0);
        }
    }

    public void f() {
        SurfaceTexture surfaceTexture = this.U;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(null);
            this.U.release();
            this.W = 0;
            this.U = null;
        }
        this.W = -1;
        this.f197137r0 = null;
        this.f197116c0 = false;
    }

    protected void g() {
        GLES20.glUseProgram(0);
    }

    protected void h(int i3, int i16) {
        if (this.P > 0.0f && this.Q > 0.0f) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, i3, i16);
        }
    }

    public boolean i() {
        return this.R;
    }

    protected void j() {
        this.f197131m = GLES20.glGetUniformLocation(this.C, "uTexture");
        this.f197119e = GLES20.glGetAttribLocation(this.C, "aPosition");
        this.f197121f = GLES20.glGetUniformLocation(this.C, "uMVPMatrix");
        this.f197124h = GLES20.glGetUniformLocation(this.C, "uTexMatrix");
        this.f197126i = GLES20.glGetAttribLocation(this.C, "aTextureCoord");
        this.D = GLES20.glGetUniformLocation(this.C, "cameraVideoWidth");
        this.E = GLES20.glGetUniformLocation(this.C, "cameraVideoHeight");
        this.F = GLES20.glGetUniformLocation(this.C, "cameraEdgeStart");
        this.G = GLES20.glGetUniformLocation(this.C, "cameraEdgeEnd");
        this.H = GLES20.glGetUniformLocation(this.C, "cameraScanLineTexture");
        this.I = GLES20.glGetUniformLocation(this.C, "cameraScanNetTexture");
        this.J = GLES20.glGetUniformLocation(this.C, "cameraScanNoiseTexture");
        this.K = GLES20.glGetUniformLocation(this.C, "noiseMode");
        int[] iArr = new int[3];
        GLES20.glGenTextures(3, iArr, 0);
        this.X = iArr[0];
        this.Y = iArr[1];
        this.Z = iArr[2];
        if (QLog.isColorLevel()) {
            QLog.d(f197111s0, 1, "textureLightId:" + this.X + "   textureNetId:" + this.Y + "   textureNoiseId:" + this.Z);
        }
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.X);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap decodeResource = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), R.drawable.enf, options);
            if (decodeResource != null) {
                GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, decodeResource, 0);
                decodeResource.recycle();
            }
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d(f197111s0, 2, "getGLSLValues", e16);
            }
        }
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.Y);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        try {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap decodeResource2 = BitmapFactory.decodeResource(this.V.d().getResources(), R.drawable.enh, options2);
            if (decodeResource2 != null) {
                GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, decodeResource2, 0);
                decodeResource2.recycle();
            }
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d(f197111s0, 2, "getGLSLValues 2 ", e17);
            }
        }
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.Z);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
    }

    public void k(float f16) {
        this.N = f16;
    }

    public void l(int i3, SurfaceTexture surfaceTexture) {
        this.f197118d0 = 1;
        h hVar = this.f197115b0;
        hVar.f197234a = 0L;
        hVar.f197236c = 0L;
        hVar.f197235b = 0L;
        SurfaceTexture surfaceTexture2 = this.U;
        if (surfaceTexture2 != null && surfaceTexture2 != surfaceTexture) {
            surfaceTexture2.setOnFrameAvailableListener(null);
            if (!DeviceInfoMonitor.getModel().equalsIgnoreCase("NX512J")) {
                try {
                    this.U.release();
                } catch (NullPointerException unused) {
                }
            }
            this.W = 0;
            this.U = null;
        }
        this.W = i3;
        this.U = surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(this);
        }
        this.f197116c0 = true;
    }

    public void m(boolean z16) {
        this.R = z16;
    }

    public void n(int i3, int i16, int i17, int i18) {
        float f16;
        float f17;
        int i19;
        f197112t0 = i17;
        f197113u0 = i18;
        float f18 = i17 / i18;
        float f19 = i16;
        float f26 = i3;
        float f27 = f19 / f26;
        DrawView2.G = i18;
        DrawView2.F = f197112t0;
        DrawView2.E = i3 / 2;
        DrawView2.D = i16 / 2;
        if (f18 < f27) {
            f17 = (f27 * f197113u0) / f197112t0;
            DrawView2.f197420m = f17;
            f16 = 1.0f;
        } else if (f18 > f27) {
            f16 = f197112t0 / (f27 * f197113u0);
            DrawView2.C = f16;
            f17 = 1.0f;
        } else {
            f16 = 1.0f;
            f17 = 1.0f;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f197111s0, 2, "[debugRay] setPreviewFrameSize  height = " + i3 + ",width = " + i16 + ",screenWidth = " + f197112t0 + ",screenHeight = " + f197113u0 + ",scaleX = " + f17 + ",scaleY = " + f16);
            String str = f197111s0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[debugRay] setPreviewFrameSize  DrawView2.scaleX = ");
            sb5.append(DrawView2.f197420m);
            sb5.append(",DrawView2.scaleY = ");
            sb5.append(DrawView2.C);
            QLog.d(str, 2, sb5.toString());
        }
        Matrix.setIdentityM(this.S, 0);
        Matrix.scaleM(this.S, 0, f17, f16, 1.0f);
        this.L = f16;
        this.P = f19;
        this.Q = f26;
        if (i16 > i3) {
            i19 = i3;
        } else {
            i19 = i16;
        }
        if (i16 > i3) {
            i3 = i16;
        }
        if (i19 <= 0 || i3 <= 0) {
            i19 = 720;
            i3 = 1280;
        }
        int i26 = (int) (i19 * 0.42d);
        int i27 = (int) (i3 * 0.6d * 0.25d * 0.42d);
        if (i26 < 240) {
            i27 = (int) (((i27 * 1.0f) / i26) * 240);
            i26 = 240;
        }
        try {
            if (QLog.isDevelopLevel()) {
                QLog.d(f197111s0, 2, "create noiseBmp width:", Integer.valueOf(i26), " height:", Integer.valueOf(i27));
            }
            this.f197128j0 = Bitmap.createBitmap(i26, i27, Bitmap.Config.ALPHA_8);
            this.f197129k0 = new Canvas(this.f197128j0);
            Paint paint = new Paint();
            this.f197130l0 = paint;
            paint.setColor(-1);
        } catch (Exception e16) {
            this.f197128j0 = null;
            e16.printStackTrace();
            QLog.d(f197111s0, 1, "create noiseBmp error2 ", e16);
        } catch (OutOfMemoryError e17) {
            this.f197128j0 = null;
            e17.printStackTrace();
            QLog.d(f197111s0, 1, "create noiseBmp error ", e17);
        }
    }

    protected void o() {
        GLES20.glDisableVertexAttribArray(this.f197119e);
        GLES20.glDisableVertexAttribArray(this.f197126i);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if ((this.W == -1 && this.f197118d0 == 1) || !this.f197116c0) {
            return;
        }
        System.currentTimeMillis();
        if (this.U != null && this.f197118d0 == 1) {
            if (DeviceInfoMonitor.getModel().equalsIgnoreCase("MI 5C")) {
                try {
                    this.U.updateTexImage();
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d(f197111s0, 2, "onDrawFrame updateTexImage error", e16);
                    }
                }
            } else if (this.f197115b0.f197234a != 0) {
                while (true) {
                    h hVar = this.f197115b0;
                    long j3 = hVar.f197236c;
                    long j16 = hVar.f197235b;
                    if (j3 <= j16) {
                        break;
                    }
                    hVar.f197235b = j16 + 1;
                    try {
                        this.U.updateTexImage();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.d(f197111s0, 2, "onDrawFrame updateTexImage error", e17);
                        }
                    }
                }
            } else {
                return;
            }
        }
        int i3 = this.f197118d0;
        if (i3 == 1 && this.U != null) {
            F();
            d(this.W);
            float[] fArr = new float[16];
            if (this.f197118d0 == 1) {
                this.U.getTransformMatrix(fArr);
            } else {
                Matrix.setIdentityM(fArr, 0);
            }
            c(this.S, this.T.d(), this.T.a(), this.T.f(), fArr, this.T.b(), this.T.c());
            h(0, this.T.e());
            o();
            p();
            g();
        } else {
            j jVar = this.f197117d;
            if (jVar != null && i3 == 2) {
                jVar.a(this.f197136q0);
            }
        }
        this.f197114a0.removeCallbacks(this.f197122f0);
        this.f197114a0.postDelayed(this.f197122f0, 30L);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        GLES20.glViewport(0, 0, i3, i16);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.C = y1.b.c("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\n\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\n\nvarying vec2 vTextureCoord;\nvarying vec2 edgeTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n    edgeTextureCoord = vec2(aTextureCoord.x,1.0 - aTextureCoord.y);\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n\nvarying vec2 vTextureCoord;\nvarying vec2 edgeTextureCoord;\nuniform samplerExternalOES uTexture;\nuniform sampler2D cameraScanLineTexture;\nuniform sampler2D cameraScanNetTexture;\nuniform sampler2D cameraScanNoiseTexture;\nuniform int noiseMode;\nuniform float cameraVideoWidth;\nuniform float cameraVideoHeight;\nuniform float cameraEdgeStart;\nuniform float cameraEdgeEnd;\nvoid getEdgeRGBSobel(vec2 vTextureCoord){\n   float gadthis =  cameraEdgeStart - edgeTextureCoord.y;\n   vec4 cTemp4 = texture2D(uTexture, vTextureCoord);\n   const float gad = 0.6;\n   if(edgeTextureCoord.y > cameraEdgeEnd || gadthis < 0.0 || gadthis>gad){\n       gl_FragColor=cTemp4;\n    }else{\n        vec2 thistexcoord = vec2( edgeTextureCoord.x , 1.0 - gadthis / gad);\n        vec4 netColor = texture2D(cameraScanNetTexture, thistexcoord);\n        cTemp4.rgb = cTemp4.rgb * (1.0 - netColor.w) + vec3(1.0, 1.0, 1.0) * netColor.w;\n        vec2 offset0=vec2(-1.0/cameraVideoWidth,-1.0/cameraVideoHeight); vec2 offset1=vec2(0.0,-1.0/cameraVideoHeight); vec2 offset2=vec2(1.0/cameraVideoWidth,-1.0/cameraVideoHeight);\n        vec2 offset3=vec2(-1.0/cameraVideoWidth,0.0); vec2 offset5=vec2(1.0/cameraVideoWidth,0.0);\n        vec2 offset6=vec2(-1.0/cameraVideoWidth,1.0/cameraVideoHeight); vec2 offset7=vec2(0.0,1.0/cameraVideoHeight); vec2 offset8=vec2(1.0/cameraVideoWidth,1.0/cameraVideoHeight);\n        vec4 cTemp0,cTemp1,cTemp2,cTemp3,cTemp5,cTemp6,cTemp7,cTemp8;\n        cTemp0=texture2D(uTexture, vTextureCoord + offset0);\n        cTemp1=texture2D(uTexture, vTextureCoord + offset1);\n        cTemp2=texture2D(uTexture, vTextureCoord + offset2);\n        cTemp3=texture2D(uTexture, vTextureCoord + offset3);\n        cTemp5=texture2D(uTexture, vTextureCoord + offset5);\n        cTemp6=texture2D(uTexture, vTextureCoord + offset6);\n        cTemp7=texture2D(uTexture, vTextureCoord + offset7);\n        cTemp8=texture2D(uTexture, vTextureCoord + offset8);\n        vec4 sumx = -cTemp0 -  cTemp1 - cTemp2 + cTemp6.r +  cTemp7 + cTemp8;\n        vec4 sumy = -cTemp6 -  cTemp3 - cTemp0 + cTemp8 +  cTemp5 + cTemp2;\n        float sumxy = 0.3*sumx.r+0.59*sumx.g+0.11*sumx.b;\n        float sumyy = 0.3*sumy.r+0.59*sumy.g+0.11*sumy.b;\n        float sum  = length(vec2(sumxy, sumyy));\n        if(sum > 0.45){\n            sum+=0.2;\n            sum = min(sum,1.0);\n            float weightT = ((gad - gadthis)/gad *0.8);\n            sum = 0.8 * sum * weightT;\n            cTemp4 = vec4(0.0*weightT,0.9725*weightT,weightT*1.0,weightT) + cTemp4 * (1.0 - weightT - sum)+vec4(sum,sum,sum,1.0);\n        }\n        vec4 fugaicolor = texture2D(cameraScanLineTexture, thistexcoord);\n        float alphaW = fugaicolor.w * (gad - gadthis)/gad;\n        gl_FragColor = cTemp4 * (1.0 - alphaW) + fugaicolor * alphaW;\n        if(sum <= 0.45 && thistexcoord.y > 0.75 && noiseMode == 1){\n            float noiseAlpha = texture2D(cameraScanNoiseTexture, vec2(thistexcoord.x, (1.0-thistexcoord.y)/0.25)).a;\n            noiseAlpha = noiseAlpha*(4.0*thistexcoord.y-3.0);\n            if(noiseAlpha > 0.0626 && noiseAlpha<=1.0){\n                gl_FragColor.rgb = gl_FragColor.rgb * (1.0 - noiseAlpha) + vec3(0.753, 0.988, 1.0) * noiseAlpha;\n            }\n        }\n        gl_FragColor.a = 1.0;\n    }\n}\nvoid main() {\n   getEdgeRGBSobel(vTextureCoord);\n}");
        j();
        w81.b.a();
    }

    protected void p() {
        GLES20.glBindTexture(36197, 0);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }
}
