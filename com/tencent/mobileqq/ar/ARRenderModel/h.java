package com.tencent.mobileqq.ar.ARRenderModel;

import android.annotation.TargetApi;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h {
    private static int O = 16;
    private boolean A;
    float[] B;
    float[] C;
    float[] D;
    float[] E;
    private float[] F;
    private float[] G;
    private boolean H;
    private float[] I;
    private float[] J;
    private float[] K;
    public float[] L;
    float[] M;
    private float[] N;

    /* renamed from: a, reason: collision with root package name */
    public long f197234a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f197235b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f197236c = 0;

    /* renamed from: d, reason: collision with root package name */
    private ReentrantLock f197237d = new ReentrantLock();

    /* renamed from: e, reason: collision with root package name */
    private a f197238e = new a();

    /* renamed from: f, reason: collision with root package name */
    private float[] f197239f = new float[2];

    /* renamed from: g, reason: collision with root package name */
    private float[] f197240g;

    /* renamed from: h, reason: collision with root package name */
    private float[] f197241h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f197242i;

    /* renamed from: j, reason: collision with root package name */
    private int f197243j;

    /* renamed from: k, reason: collision with root package name */
    private int f197244k;

    /* renamed from: l, reason: collision with root package name */
    private float[] f197245l;

    /* renamed from: m, reason: collision with root package name */
    private float[] f197246m;

    /* renamed from: n, reason: collision with root package name */
    private float[] f197247n;

    /* renamed from: o, reason: collision with root package name */
    private float[] f197248o;

    /* renamed from: p, reason: collision with root package name */
    private float[] f197249p;

    /* renamed from: q, reason: collision with root package name */
    private float[] f197250q;

    /* renamed from: r, reason: collision with root package name */
    private float[] f197251r;

    /* renamed from: s, reason: collision with root package name */
    private float[] f197252s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f197253t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f197254u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f197255v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f197256w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f197257x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f197258y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f197259z;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private HashMap<String, Object> f197260a = new HashMap<>();

        /* renamed from: b, reason: collision with root package name */
        public float[] f197261b;

        public Object a(String str) {
            return this.f197260a.get(str);
        }

        public void b(String str, Object obj) {
            this.f197260a.put(str, obj);
        }
    }

    public h() {
        int i3 = O;
        this.f197240g = new float[i3];
        this.f197241h = new float[i3];
        this.f197242i = new float[i3];
        this.f197243j = 0;
        this.f197244k = -1;
        this.f197245l = new float[2];
        this.f197246m = new float[i3];
        this.f197247n = new float[i3];
        this.f197248o = new float[i3];
        this.f197249p = new float[2];
        this.f197250q = new float[i3];
        this.f197251r = new float[i3];
        this.f197252s = new float[i3];
        this.f197253t = false;
        this.f197254u = false;
        this.f197255v = false;
        this.f197256w = false;
        this.f197257x = false;
        this.f197258y = false;
        this.f197259z = false;
        this.A = false;
        this.B = new float[i3];
        this.C = new float[i3];
        this.D = new float[i3];
        this.E = new float[i3];
        this.F = new float[i3];
        this.G = new float[i3];
        this.H = false;
        float[] fArr = new float[i3];
        this.I = fArr;
        this.J = new float[i3];
        this.K = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
        this.L = null;
        this.M = new float[4];
        this.N = new float[i3];
        Matrix.setRotateM(fArr, 0, -90.0f, 0.0f, 0.0f, 1.0f);
        Matrix.setRotateM(this.J, 0, 90.0f, 0.0f, 0.0f, 1.0f);
        f();
    }

    public static boolean d() {
        return false;
    }

    private boolean e(float[] fArr) {
        for (float f16 : fArr) {
            if (f16 != 0.0f) {
                return false;
            }
        }
        return true;
    }

    public void a(int i3, int i16, ArCloudConfigInfo.b bVar) {
        int i17;
        int i18;
        float f16;
        float f17;
        float f18;
        int i19;
        if (i3 == 1 || i3 == 2) {
            if (i16 != 0 && i16 != 2 && i16 != 3 && i16 != 4) {
                return;
            }
            float[] fArr = new float[2];
            this.f197245l = fArr;
            int i26 = O;
            this.f197246m = new float[i26];
            this.f197247n = new float[i26];
            this.f197248o = new float[i26];
            if (i16 == 0) {
                int i27 = bVar.f197704a;
                if (i27 != 0 && (i19 = bVar.f197705b) != 0) {
                    fArr[0] = i27;
                    fArr[1] = i19;
                } else {
                    fArr[0] = UniformGLRenderManagerImpl.U;
                    fArr[1] = UniformGLRenderManagerImpl.V;
                }
            } else if (i16 != 2 && i16 != 3) {
                if (i16 == 4) {
                    int i28 = bVar.f197704a;
                    if (i28 != 0 && (i18 = bVar.f197705b) != 0) {
                        fArr[0] = i28;
                        fArr[1] = i18;
                    } else {
                        fArr[0] = UniformGLRenderManagerImpl.U;
                        fArr[1] = UniformGLRenderManagerImpl.V;
                    }
                }
            } else {
                int i29 = bVar.f197704a;
                if (i29 != 0 && (i17 = bVar.f197705b) != 0) {
                    fArr[0] = i29;
                    fArr[1] = i17;
                } else {
                    fArr[0] = UniformGLRenderManagerImpl.U;
                    fArr[1] = UniformGLRenderManagerImpl.V;
                }
            }
            float[] fArr2 = new float[O];
            Matrix.setIdentityM(fArr2, 0);
            Matrix.perspectiveM(fArr2, 0, 45.0f, (UniformGLRenderManagerImpl.V * 1.0f) / UniformGLRenderManagerImpl.U, 100.0f, 8000.0f);
            float[] fArr3 = new float[16];
            Matrix.setRotateM(fArr3, 0, 270.0f, 0.0f, 0.0f, 1.0f);
            Matrix.multiplyMM(this.f197246m, 0, fArr3, 0, fArr2, 0);
            if (i16 == 0) {
                f16 = 1.25f;
            } else {
                f16 = 1.0f;
            }
            float[] fArr4 = this.f197245l;
            float f19 = fArr4[0];
            int i36 = UniformGLRenderManagerImpl.U;
            if (f19 > i36) {
                f17 = f19;
            } else {
                f17 = i36;
            }
            if (f19 != 0.0f) {
                f18 = (fArr4[1] / f19) / ((UniformGLRenderManagerImpl.V * 1.0f) / UniformGLRenderManagerImpl.U);
            } else {
                f18 = 1.0f;
            }
            if (f18 > 1.0f && fArr4[1] > UniformGLRenderManagerImpl.V) {
                f16 *= f18;
            }
            QLog.i("AREngine_ARRenerArumentManager", 1, "genProjAndPose. mNoFeatureTrackModeTargetSize[0] = " + this.f197245l[0] + ", mNoFeatureTrackModeTargetSize[1] = " + this.f197245l[1] + ", scale = " + f16 + ", zSize = " + f17 + ", ratio = " + f18);
            float[] fArr5 = new float[O];
            Matrix.setIdentityM(fArr5, 0);
            float[] fArr6 = this.f197245l;
            Matrix.translateM(fArr5, 0, fArr6[1] / 2.0f, (-fArr6[0]) / 2.0f, ((-f17) / 2.0f) * 2.4142137f * f16);
            Matrix.rotateM(fArr5, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            System.arraycopy(fArr5, 0, this.f197247n, 0, O);
            System.arraycopy(this.f197247n, 0, this.f197248o, 0, O);
            System.arraycopy(this.f197245l, 0, this.f197239f, 0, 2);
            System.arraycopy(this.f197246m, 0, this.f197240g, 0, O);
            this.f197237d.lock();
            System.arraycopy(this.f197247n, 0, this.f197241h, 0, O);
            this.f197237d.unlock();
            System.arraycopy(this.f197248o, 0, this.f197242i, 0, O);
        }
    }

    public a b(int i3, int i16) {
        float[] fArr;
        if (this.f197258y) {
            int i17 = O;
            float[] fArr2 = new float[i17];
            float[] fArr3 = new float[i17];
            float[] fArr4 = new float[i17];
            Matrix.setIdentityM(fArr3, 0);
            Matrix.setIdentityM(fArr4, 0);
            Matrix.setIdentityM(fArr2, 0);
            a aVar = new a();
            aVar.b("TARGET_SIZE", new float[]{1.0f, 1.0f});
            aVar.b("CAMERA_MATRIX", fArr4);
            aVar.b("CAMERA_POSITION", fArr2);
            aVar.b("POSE", fArr3);
            return aVar;
        }
        if (i3 == 100) {
            this.f197243j = 1;
            int i18 = O;
            float[] fArr5 = new float[i18];
            float[] fArr6 = new float[i18];
            float[] fArr7 = new float[i18];
            Matrix.setIdentityM(fArr6, 0);
            Matrix.setIdentityM(fArr7, 0);
            Matrix.setIdentityM(fArr5, 0);
            a aVar2 = new a();
            aVar2.b("TARGET_SIZE", new float[]{1.0f, 1.0f});
            aVar2.b("CAMERA_MATRIX", fArr7);
            aVar2.b("CAMERA_POSITION", fArr5);
            aVar2.b("POSE", fArr6);
            aVar2.f197261b = this.L;
            return aVar2;
        }
        if (i3 == 8) {
            a aVar3 = new a();
            this.f197243j = 1;
            int i19 = O;
            float[] fArr8 = new float[i19];
            float[] fArr9 = new float[i19];
            float[] fArr10 = new float[i19];
            Matrix.setIdentityM(fArr9, 0);
            Matrix.setIdentityM(fArr10, 0);
            Matrix.setIdentityM(fArr8, 0);
            aVar3.b("TARGET_SIZE", new float[]{1.0f, 1.0f});
            aVar3.b("CAMERA_MATRIX", fArr10);
            aVar3.b("CAMERA_POSITION", fArr8);
            aVar3.b("POSE", fArr9);
            aVar3.f197261b = this.L;
            return aVar3;
        }
        if (!this.f197259z) {
            return null;
        }
        if (i16 == 0 && !this.f197253t) {
            return null;
        }
        this.f197257x = true;
        this.f197243j = i16;
        if (this.A && ((i16 == 0 && !this.f197255v) || i16 == 2 || (i16 == 1 && !this.f197256w))) {
            float[] fArr11 = new float[2];
            int i26 = O;
            float[] fArr12 = new float[i26];
            float[] fArr13 = new float[i26];
            float[] fArr14 = new float[i26];
            System.arraycopy(this.f197249p, 0, fArr11, 0, 2);
            System.arraycopy(this.f197250q, 0, fArr12, 0, O);
            System.arraycopy(this.f197251r, 0, fArr13, 0, O);
            System.arraycopy(this.f197252s, 0, fArr14, 0, O);
            a aVar4 = new a();
            aVar4.b("TARGET_SIZE", fArr11);
            aVar4.b("CAMERA_MATRIX", fArr14);
            aVar4.b("CAMERA_POSITION", fArr12);
            aVar4.b("POSE", fArr13);
            this.f197257x = false;
            return aVar4;
        }
        this.f197255v = false;
        this.f197256w = false;
        float[] fArr15 = new float[2];
        int i27 = O;
        float[] fArr16 = new float[i27];
        float[] fArr17 = new float[i27];
        float[] fArr18 = new float[i27];
        if (i3 == 0) {
            if (e(this.f197241h)) {
                System.arraycopy(this.f197239f, 0, fArr15, 0, 2);
                System.arraycopy(this.f197240g, 0, fArr16, 0, O);
                System.arraycopy(this.K, 0, fArr17, 0, O);
                System.arraycopy(this.K, 0, fArr18, 0, O);
            } else if (i16 == 0) {
                System.arraycopy(this.f197239f, 0, fArr15, 0, 2);
                System.arraycopy(this.f197240g, 0, fArr16, 0, O);
                this.f197237d.lock();
                Matrix.invertM(this.C, 0, this.f197241h, 0);
                this.f197237d.unlock();
                System.arraycopy(this.C, 0, fArr17, 0, O);
                System.arraycopy(this.C, 0, fArr18, 0, O);
                System.arraycopy(fArr18, 0, this.f197242i, 0, O);
            } else if (i16 == 1) {
                System.arraycopy(this.f197245l, 0, this.f197239f, 0, 2);
                System.arraycopy(this.f197246m, 0, this.f197240g, 0, O);
                System.arraycopy(this.f197247n, 0, this.f197241h, 0, O);
                System.arraycopy(this.f197248o, 0, this.f197242i, 0, O);
                System.arraycopy(this.f197239f, 0, fArr15, 0, 2);
                System.arraycopy(this.f197240g, 0, fArr16, 0, O);
                Matrix.invertM(this.C, 0, this.f197241h, 0);
                System.arraycopy(this.C, 0, fArr17, 0, O);
                Matrix.rotateM(this.C, 0, 90.0f, 0.0f, 0.0f, 1.0f);
                Matrix.transposeM(this.B, 0, this.C, 0);
                this.f197237d.lock();
                Matrix.multiplyMM(this.D, 0, this.G, 0, this.B, 0);
                this.f197237d.unlock();
                Matrix.transposeM(this.E, 0, this.D, 0);
                Matrix.rotateM(this.E, 0, -90.0f, 0.0f, 0.0f, 1.0f);
                System.arraycopy(this.E, 0, fArr18, 0, O);
                System.arraycopy(fArr18, 0, this.f197242i, 0, O);
            } else if (i16 == 2) {
                System.arraycopy(this.f197245l, 0, this.f197239f, 0, 2);
                System.arraycopy(this.f197246m, 0, this.f197240g, 0, O);
                System.arraycopy(this.f197247n, 0, this.f197241h, 0, O);
                System.arraycopy(this.f197248o, 0, this.f197242i, 0, O);
                System.arraycopy(this.f197239f, 0, fArr15, 0, 2);
                System.arraycopy(this.f197240g, 0, fArr16, 0, O);
                this.f197237d.lock();
                Matrix.invertM(this.C, 0, this.f197241h, 0);
                this.f197237d.unlock();
                System.arraycopy(this.C, 0, fArr17, 0, O);
                System.arraycopy(this.C, 0, fArr18, 0, O);
                System.arraycopy(fArr18, 0, this.f197242i, 0, O);
            }
        } else if (i3 != 2 && i3 != 3 && i3 != 4) {
            Matrix.setIdentityM(fArr17, 0);
            Matrix.setIdentityM(fArr18, 0);
            Matrix.setIdentityM(fArr16, 0);
            fArr15[0] = 1.0f;
            fArr15[1] = 1.0f;
        } else if (i16 == 0) {
            System.arraycopy(this.f197239f, 0, fArr15, 0, 2);
            System.arraycopy(this.f197240g, 0, fArr16, 0, O);
            this.f197237d.lock();
            System.arraycopy(this.f197241h, 0, fArr17, 0, O);
            this.f197237d.unlock();
            if (this.f197244k != 1) {
                Matrix.translateM(fArr17, 0, fArr15[0] / 2.0f, fArr15[1] / 2.0f, 0.0f);
            }
            System.arraycopy(fArr17, 0, fArr18, 0, O);
            System.arraycopy(fArr18, 0, this.f197242i, 0, O);
        } else {
            if (i16 == 1) {
                System.arraycopy(this.f197245l, 0, this.f197239f, 0, 2);
                System.arraycopy(this.f197246m, 0, this.f197240g, 0, O);
                System.arraycopy(this.f197247n, 0, this.f197241h, 0, O);
                System.arraycopy(this.f197248o, 0, this.f197242i, 0, O);
                System.arraycopy(this.f197239f, 0, fArr15, 0, 2);
                System.arraycopy(this.f197240g, 0, fArr16, 0, O);
                System.arraycopy(this.f197241h, 0, fArr17, 0, O);
                Matrix.translateM(fArr17, 0, fArr15[0] / 2.0f, fArr15[1] / 2.0f, 0.0f);
                Matrix.multiplyMM(fArr18, 0, this.I, 0, fArr17, 0);
                this.f197237d.lock();
                Matrix.multiplyMM(fArr18, 0, this.G, 0, fArr18, 0);
                this.f197237d.unlock();
                Matrix.multiplyMM(fArr18, 0, this.J, 0, fArr18, 0);
                System.arraycopy(fArr18, 0, this.f197242i, 0, O);
                fArr = fArr17;
            } else {
                fArr = fArr17;
                if (i16 == 2) {
                    Matrix.setIdentityM(fArr, 0);
                    Matrix.setIdentityM(fArr18, 0);
                    Matrix.setIdentityM(fArr16, 0);
                    fArr15[0] = 1.0f;
                    fArr15[1] = 1.0f;
                }
            }
            System.arraycopy(fArr15, 0, this.f197249p, 0, 2);
            System.arraycopy(fArr16, 0, this.f197250q, 0, O);
            System.arraycopy(fArr, 0, this.f197251r, 0, O);
            System.arraycopy(fArr18, 0, this.f197252s, 0, O);
            this.A = true;
            a aVar5 = new a();
            aVar5.b("TARGET_SIZE", fArr15);
            aVar5.b("CAMERA_MATRIX", fArr18);
            aVar5.b("CAMERA_POSITION", fArr16);
            aVar5.b("POSE", fArr);
            this.f197257x = false;
            return aVar5;
        }
        fArr = fArr17;
        System.arraycopy(fArr15, 0, this.f197249p, 0, 2);
        System.arraycopy(fArr16, 0, this.f197250q, 0, O);
        System.arraycopy(fArr, 0, this.f197251r, 0, O);
        System.arraycopy(fArr18, 0, this.f197252s, 0, O);
        this.A = true;
        a aVar52 = new a();
        aVar52.b("TARGET_SIZE", fArr15);
        aVar52.b("CAMERA_MATRIX", fArr18);
        aVar52.b("CAMERA_POSITION", fArr16);
        aVar52.b("POSE", fArr);
        this.f197257x = false;
        return aVar52;
    }

    @TargetApi(9)
    public void c(float[] fArr, float[] fArr2) {
        float[] fArr3 = this.M;
        fArr3[0] = fArr2[1];
        fArr3[1] = fArr2[2];
        fArr3[2] = fArr2[3];
        fArr3[3] = fArr2[0];
        SensorManager.getRotationMatrixFromVector(fArr, fArr3);
    }

    public void f() {
        this.f197237d.lock();
        this.f197239f = new float[2];
        int i3 = O;
        this.f197240g = new float[i3];
        this.f197241h = new float[i3];
        this.f197242i = new float[i3];
        this.f197249p = new float[2];
        this.f197250q = new float[i3];
        this.f197251r = new float[i3];
        this.f197252s = new float[i3];
        this.f197253t = false;
        this.f197254u = false;
        this.f197255v = false;
        this.f197256w = false;
        this.f197257x = false;
        this.f197258y = false;
        this.f197259z = false;
        this.A = false;
        this.B = new float[i3];
        this.C = new float[i3];
        this.D = new float[i3];
        this.E = new float[i3];
        this.F = new float[i3];
        this.G = new float[i3];
        this.H = false;
        float[] fArr = new float[i3];
        float[] fArr2 = new float[i3];
        float[] fArr3 = new float[i3];
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(fArr2, 0);
        Matrix.setIdentityM(fArr3, 0);
        this.f197238e.b("TARGET_SIZE", new float[]{1.0f, 1.0f});
        this.f197238e.b("POSE", fArr);
        this.f197238e.b("CAMERA_MATRIX", fArr2);
        this.f197238e.b("CAMERA_POSITION", fArr3);
        this.f197237d.unlock();
    }

    public void g(boolean z16, e eVar) {
        int i3;
        QLog.i("AREngine_ARRenerArumentManager", 1, "start. trackMode = " + eVar.f197228d + ", arType = " + eVar.f197226b + ", isObjectAnim = " + z16);
        this.f197258y = z16;
        int i16 = eVar.f197228d;
        this.f197243j = i16;
        this.f197244k = eVar.f197229e;
        this.A = false;
        if (!z16 && (i3 = eVar.f197226b) != 100 && i3 != 8) {
            if (i3 == 0) {
                a(i16, i3, ((k) eVar).f197286l);
            } else if (i3 != 2 && i3 != 3) {
                if (i3 == 4) {
                    a(i16, i3, ((q) eVar).f197331o);
                }
            } else {
                a(i16, i3, ((p) eVar).f197324m);
            }
            this.f197259z = true;
            return;
        }
        this.f197259z = true;
    }

    public synchronized void h(float[] fArr) {
        int i3 = this.f197243j;
        if (i3 != 4 && i3 != 1) {
            return;
        }
        if (i3 == 4 && d()) {
            return;
        }
        if (this.f197257x) {
            return;
        }
        if (!this.H) {
            this.H = true;
            Matrix.setIdentityM(this.F, 0);
            c(this.N, fArr);
            Matrix.invertM(this.F, 0, this.N, 0);
            this.f197254u = false;
            this.f197256w = false;
        } else {
            this.L = fArr;
            this.f197254u = true;
            this.f197256w = true;
            c(this.N, fArr);
            this.f197237d.lock();
            Matrix.multiplyMM(this.G, 0, this.N, 0, this.F, 0);
            this.f197237d.unlock();
        }
    }

    public void i(f fVar) {
        if (fVar == null) {
            return;
        }
        this.f197253t = true;
        this.f197255v = true;
        d dVar = (d) fVar;
        this.f197244k = dVar.f197219b;
        float[] fArr = this.f197239f;
        fArr[0] = dVar.f197220c;
        fArr[1] = dVar.f197221d;
        System.arraycopy(dVar.f197224g, 0, this.f197240g, 0, O);
        this.f197237d.lock();
        System.arraycopy(dVar.f197223f, 0, this.f197241h, 0, O);
        this.f197237d.unlock();
        System.arraycopy(dVar.f197223f, 0, this.f197242i, 0, O);
    }
}
