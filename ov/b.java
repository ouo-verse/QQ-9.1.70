package ov;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.av.opengl.program.DrawProgram;
import com.tencent.filter.GLSLRender;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

/* compiled from: P */
@TargetApi(8)
/* loaded from: classes3.dex */
public class b implements a {
    private static final float[] F = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private static final d G = new c();
    private final float[] D;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f424110e;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f424111f;

    /* renamed from: g, reason: collision with root package name */
    private DrawProgram f424112g;

    /* renamed from: h, reason: collision with root package name */
    private int f424113h;

    /* renamed from: k, reason: collision with root package name */
    private float[] f424116k;

    /* renamed from: a, reason: collision with root package name */
    private float[] f424106a = new float[8];

    /* renamed from: b, reason: collision with root package name */
    private tv.a f424107b = new tv.a();

    /* renamed from: c, reason: collision with root package name */
    private int f424108c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f424109d = 0;

    /* renamed from: i, reason: collision with root package name */
    private float[] f424114i = new float[16];

    /* renamed from: j, reason: collision with root package name */
    private float[] f424115j = new float[16];

    /* renamed from: l, reason: collision with root package name */
    private float f424117l = 3.0f;

    /* renamed from: m, reason: collision with root package name */
    private float f424118m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    private float f424119n = 180.0f;

    /* renamed from: o, reason: collision with root package name */
    private float[][] f424120o = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 16);

    /* renamed from: p, reason: collision with root package name */
    private int f424121p = -1;

    /* renamed from: q, reason: collision with root package name */
    private float f424122q = 0.0f;

    /* renamed from: r, reason: collision with root package name */
    private ByteBuffer f424123r = ByteBuffer.allocateDirect(12);

    /* renamed from: s, reason: collision with root package name */
    float[] f424124s = new float[16];

    /* renamed from: t, reason: collision with root package name */
    private final tv.a f424125t = new tv.a();

    /* renamed from: u, reason: collision with root package name */
    private final tv.a f424126u = new tv.a();

    /* renamed from: v, reason: collision with root package name */
    private int f424127v = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f424128w = 0;

    /* renamed from: x, reason: collision with root package name */
    private int f424129x = 0;

    /* renamed from: y, reason: collision with root package name */
    private int f424130y = 0;

    /* renamed from: z, reason: collision with root package name */
    private final float[] f424131z = new float[32];
    private final float[] A = new float[4];
    private final RectF B = new RectF();
    private final RectF C = new RectF();
    private final int[] E = new int[1];

    public b() {
        float[] fArr = new float[16];
        this.D = fArr;
        Matrix.setIdentityM(fArr, 0);
        this.f424106a[this.f424108c] = 1.0f;
        this.f424113h = M(r(F));
        this.f424112g = new DrawProgram();
        GLES20.glBlendFunc(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        tv.c.a();
    }

    private void D(int i3, int i16, float f16) {
        boolean z16;
        GLES20.glUseProgram(this.f424112g.b());
        tv.c.a();
        if (f16 > 0.0f) {
            GLES20.glLineWidth(f16);
            tv.c.a();
        }
        float[] y16 = y(i16);
        if (y16[3] < 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        x(z16);
        if (z16) {
            GLES20.glBlendColor(y16[0], y16[1], y16[2], y16[3]);
            tv.c.a();
        }
        GLES20.glUniform4fv(this.f424112g.c()[2].f429680a, 1, y16, 0);
        I(this.f424112g.c(), i3);
        tv.c.a();
    }

    private void H(qv.b[] bVarArr, float f16, float f17, float f18, float f19) {
        E();
        e(f16, f17, 0.0f);
        m(f18, f19, 1.0f);
        GLES20.glUniformMatrix4fv(bVarArr[1].f429680a, 1, false, z(), 0);
        C();
        tv.c.a();
    }

    private void I(qv.b[] bVarArr, int i3) {
        GLES20.glBindBuffer(34962, this.f424113h);
        tv.c.a();
        GLES20.glVertexAttribPointer(bVarArr[0].f429680a, 2, 5126, false, 8, i3 * 8);
        tv.c.a();
        GLES20.glBindBuffer(34962, 0);
        tv.c.a();
    }

    private void J(float f16, float f17, float f18, float f19, float f26, float f27) {
        Matrix.frustumM(this.f424114i, 0, f16, f17, f18, f19, f26, f27);
    }

    private void K(RectF rectF) {
        this.D[0] = rectF.width();
        this.D[5] = rectF.height();
        float[] fArr = this.D;
        fArr[12] = rectF.left;
        fArr[13] = rectF.top;
    }

    private int L(Buffer buffer, int i3) {
        G.c(1, this.E, 0);
        tv.c.a();
        int i16 = this.E[0];
        GLES20.glBindBuffer(34962, i16);
        tv.c.a();
        GLES20.glBufferData(34962, buffer.capacity() * i3, buffer, 35044);
        tv.c.a();
        return i16;
    }

    private static void q(RectF rectF, com.tencent.av.opengl.texture.a aVar) {
        int j3 = aVar.j();
        int h16 = aVar.h();
        float f16 = j3;
        rectF.left /= f16;
        rectF.right /= f16;
        float f17 = h16;
        rectF.top /= f17;
        rectF.bottom /= f17;
    }

    private static FloatBuffer r(float[] fArr) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr, 0, fArr.length).position(0);
        return asFloatBuffer;
    }

    private void s(int i3, int i16, int i17, float f16, float f17, float f18, float f19, int i18, float f26) {
        D(i16, i18, f26);
        u(this.f424112g.c(), i3, i17, f16, f17, f18, f19);
    }

    private void t(int i3, int i16, int i17, float f16, float f17, float f18, float f19, e eVar) {
        s(i3, i16, i17, f16, f17, f18, f19, eVar.a(), eVar.b());
    }

    private void u(qv.b[] bVarArr, int i3, int i16, float f16, float f17, float f18, float f19) {
        H(bVarArr, f16, f17, f18, f19);
        int i17 = bVarArr[0].f429680a;
        GLES20.glEnableVertexAttribArray(i17);
        tv.c.a();
        GLES20.glDrawArrays(i3, 0, i16);
        tv.c.a();
        GLES20.glDisableVertexAttribArray(i17);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        tv.c.a();
    }

    private void v(com.tencent.av.opengl.texture.a aVar, RectF rectF, RectF rectF2) {
        K(rectF);
        w(aVar, this.D, rectF2);
    }

    private void w(com.tencent.av.opengl.texture.a aVar, float[] fArr, RectF rectF) {
        qv.b[] s16 = aVar.s(this);
        I(s16, 0);
        GLES20.glUniformMatrix4fv(s16[3].f429680a, 1, false, fArr, 0);
        tv.c.a();
        if (aVar.o()) {
            f(2);
            k(0.0f, rectF.centerY());
            m(1.0f, -1.0f, 1.0f);
            k(0.0f, -rectF.centerY());
        }
        u(s16, 5, 4, rectF.left, rectF.top, rectF.width(), rectF.height());
        if (aVar.o()) {
            restore();
        }
        this.f424128w++;
    }

    public static void x(boolean z16) {
        if (z16) {
            GLES20.glEnable(3042);
            tv.c.a();
        } else {
            GLES20.glDisable(3042);
            tv.c.a();
        }
    }

    private float[] y(int i3) {
        float alpha = (((i3 >>> 24) & 255) / 255.0f) * getAlpha();
        float[] fArr = this.A;
        fArr[0] = (((i3 >>> 16) & 255) / 255.0f) * alpha;
        fArr[1] = (((i3 >>> 8) & 255) / 255.0f) * alpha;
        fArr[2] = ((i3 & 255) / 255.0f) * alpha;
        fArr[3] = alpha;
        return fArr;
    }

    private float[] z() {
        Matrix.multiplyMM(this.f424124s, 0, this.f424115j, 0, this.f424116k, 0);
        float[] fArr = this.f424124s;
        Matrix.multiplyMM(fArr, 0, this.f424114i, 0, fArr, 0);
        return this.f424124s;
    }

    public int A() {
        return this.f424111f;
    }

    public int B() {
        return this.f424110e;
    }

    public void C() {
        for (int i3 = 0; i3 < 16; i3++) {
            this.f424116k[i3] = this.f424120o[this.f424121p][i3];
        }
        this.f424121p--;
    }

    public void E() {
        this.f424121p++;
        for (int i3 = 0; i3 < 16; i3++) {
            this.f424120o[this.f424121p][i3] = this.f424116k[i3];
        }
    }

    public void F(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36) {
        this.f424122q = f18;
        Matrix.setLookAtM(this.f424115j, 0, f16, f17, f18, f19, f26, f27, f28, f29, f36);
    }

    public void G() {
        float[] fArr = new float[16];
        this.f424116k = fArr;
        Matrix.setRotateM(fArr, 0, 0.0f, 1.0f, 0.0f, 0.0f);
    }

    public int M(FloatBuffer floatBuffer) {
        return L(floatBuffer, 4);
    }

    @Override // ov.a
    public void a() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        tv.c.a();
        GLES20.glClear(16384);
        tv.c.a();
    }

    @Override // ov.a
    public void b(float f16, float f17, float f18, float f19, e eVar) {
        t(3, 4, 2, f16, f17, f18 - f16, f19 - f17, eVar);
        this.f424130y++;
    }

    @Override // ov.a
    public void c(com.tencent.av.opengl.texture.a aVar, Bitmap bitmap) {
        int g16 = aVar.g();
        int[] c16 = aVar.c();
        for (int i3 = 0; i3 < c16.length; i3++) {
            GLES20.glBindTexture(g16, aVar.c()[i3]);
        }
        tv.c.a();
        GLUtils.texImage2D(g16, 0, bitmap, 0);
    }

    @Override // ov.a
    public boolean d(com.tencent.av.opengl.texture.a aVar) {
        boolean p16 = aVar.p();
        if (p16) {
            synchronized (this.f424125t) {
                int[] c16 = aVar.c();
                if (c16 == null) {
                    return p16;
                }
                for (int i3 : c16) {
                    this.f424125t.a(i3);
                }
            }
        }
        return p16;
    }

    @Override // ov.a
    public void e(float f16, float f17, float f18) {
        Matrix.translateM(this.f424116k, 0, f16, f17, f18);
    }

    @Override // ov.a
    @TargetApi(9)
    public void f(int i3) {
        boolean z16;
        boolean z17 = false;
        if ((i3 & 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            float alpha = getAlpha();
            int i16 = this.f424108c + 1;
            this.f424108c = i16;
            float[] fArr = this.f424106a;
            if (fArr.length <= i16) {
                this.f424106a = Arrays.copyOf(fArr, fArr.length * 2);
            }
            this.f424106a[this.f424108c] = alpha;
        }
        if ((i3 & 2) == 2) {
            z17 = true;
        }
        if (z17) {
            E();
        }
        this.f424107b.a(i3);
    }

    @Override // ov.a
    public void g(com.tencent.av.opengl.texture.a aVar, int i3, int i16, int i17, int i18) {
        if (i17 > 0 && i18 > 0) {
            Rect d16 = aVar.d();
            this.B.set(d16.left, d16.top, d16.right, d16.bottom);
            this.C.set(i3, i16, i3 + i17, i16 + i18);
            q(this.B, aVar);
            v(aVar, this.B, this.C);
        }
    }

    @Override // ov.a
    public float getAlpha() {
        return this.f424106a[this.f424108c];
    }

    @Override // ov.a
    public int getHeight() {
        return this.f424111f;
    }

    @Override // ov.a
    public int getWidth() {
        return this.f424110e;
    }

    @Override // ov.a
    public void h() {
        synchronized (this.f424125t) {
            tv.a aVar = this.f424125t;
            if (aVar.e() > 0) {
                G.a(null, aVar.e(), aVar.c(), 0);
                aVar.b();
            }
            tv.a aVar2 = this.f424126u;
            if (aVar2.e() > 0) {
                G.d(null, aVar2.e(), aVar2.c(), 0);
                aVar2.b();
            }
        }
    }

    @Override // ov.a
    public d i() {
        return G;
    }

    @Override // ov.a
    public void j(com.tencent.av.opengl.texture.a aVar, int i3, int i16, Bitmap bitmap, int i17, int i18) {
        int g16 = aVar.g();
        int[] c16 = aVar.c();
        for (int i19 = 0; i19 < c16.length; i19++) {
            GLES20.glBindTexture(g16, aVar.c()[i19]);
        }
        tv.c.a();
        GLUtils.texSubImage2D(g16, 0, i3, i16, bitmap, i17, i18);
    }

    @Override // ov.a
    public void k(float f16, float f17) {
        e(f16, f17, 0.0f);
    }

    @Override // ov.a
    public void l(float f16, float f17, float f18, float f19, int i3) {
        s(5, 0, 4, f16, f17, f18, f19, i3, 0.0f);
        this.f424129x++;
    }

    @Override // ov.a
    public void m(float f16, float f17, float f18) {
        Matrix.scaleM(this.f424116k, 0, f16, f17, f18);
    }

    @Override // ov.a
    public void n(com.tencent.av.opengl.texture.a aVar) {
        int g16 = aVar.g();
        int[] c16 = aVar.c();
        for (int i3 = 0; i3 < c16.length; i3++) {
            GLES20.glBindTexture(g16, aVar.c()[i3]);
        }
        tv.c.a();
        GLES20.glTexParameteri(g16, 10242, 33071);
        GLES20.glTexParameteri(g16, 10243, 33071);
        GLES20.glTexParameterf(g16, 10241, 9729.0f);
        GLES20.glTexParameterf(g16, 10240, 9729.0f);
    }

    @Override // ov.a
    public void o(com.tencent.av.opengl.texture.a aVar, int i3, int i16) {
        int g16 = aVar.g();
        int[] c16 = aVar.c();
        for (int i17 = 0; i17 < c16.length; i17++) {
            GLES20.glBindTexture(g16, aVar.c()[i17]);
        }
        tv.c.a();
        GLES20.glTexImage2D(g16, 0, i3, aVar.j(), aVar.h(), 0, i3, i16, null);
    }

    @Override // ov.a
    public void p(float f16, float f17, float f18, float f19) {
        Matrix.rotateM(this.f424116k, 0, f16, f17, f18, f19);
    }

    @Override // ov.a
    public void restore() {
        boolean z16;
        int d16 = this.f424107b.d();
        boolean z17 = false;
        if ((d16 & 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.f424108c--;
        }
        if ((d16 & 2) == 2) {
            z17 = true;
        }
        if (z17) {
            this.f424109d -= 16;
            C();
        }
    }

    @Override // ov.a
    public void save() {
        f(-1);
    }

    @Override // ov.a
    public void setAlpha(float f16) {
        this.f424106a[this.f424108c] = f16;
    }

    @Override // ov.a
    public void setSize(int i3, int i16) {
        this.f424110e = i3;
        this.f424111f = i16;
        GLES20.glViewport(0, 0, i3, i16);
        G();
        int i17 = -i3;
        J(i17 / 4, i3 / 4, (-i16) / 4, i16 / 4, i16, 1000000.0f);
        F(0.0f, 0.0f, i16 * 2, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        e(0.0f, i16 / 2, 0.0f);
        m(1.0f, -1.0f, 1.0f);
        e(i17 / 2, 0.0f, 0.0f);
        tv.c.a();
    }
}
