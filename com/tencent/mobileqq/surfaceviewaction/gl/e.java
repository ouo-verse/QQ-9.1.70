package com.tencent.mobileqq.surfaceviewaction.gl;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.surfaceviewaction.f;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends d implements com.tencent.mobileqq.surfaceviewaction.d<SpriteGLView> {
    static IPatchRedirector $redirector_;
    protected Texture Q;
    private final float[] R;
    protected final short[] S;
    protected final float[] T;
    protected FloatBuffer U;
    protected ShortBuffer V;
    protected FloatBuffer W;
    protected float[] X;
    protected f Y;

    public e(SpriteGLView spriteGLView, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) spriteGLView, (Object) bitmap);
            return;
        }
        this.R = new float[]{1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f};
        this.S = new short[]{0, 1, 2, 3, 4, 5};
        this.T = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.X = new float[16];
        this.Y = new f(0.0f, 0.0f);
        this.P = spriteGLView;
        this.Q = new Texture(spriteGLView, bitmap);
        G();
        H();
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.gl.d
    public void A(int i3, int i16, int i17, int i18, int i19, int i26, int i27, float[] fArr) {
        float g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), fArr);
            return;
        }
        super.A(i3, i16, i17, i18, i19, i26, i27, fArr);
        if (this.Q == null) {
            return;
        }
        SpriteGLView spriteGLView = this.P;
        if (spriteGLView != null) {
            GLES20.glUseProgram(spriteGLView.I);
        }
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, E());
        GLES20.glEnableVertexAttribArray(i17);
        GLES20.glVertexAttribPointer(i17, 3, 5126, false, 0, (Buffer) this.U);
        GLES20.glEnableVertexAttribArray(i18);
        GLES20.glVertexAttribPointer(i18, 2, 5126, false, 0, (Buffer) this.W);
        Matrix.setIdentityM(this.X, 0);
        Matrix.translateM(this.X, 0, 0.0f, 0.0f, -1.0E-4f);
        h(this.Y);
        float f16 = i3;
        float f17 = i16;
        float f18 = f16 / f17;
        float g17 = (f16 / this.f291151e) / (this.f291155m * g());
        float g18 = (((this.Y.f291217a * 2.0f) * g()) - f16) / f17;
        SpriteGLView spriteGLView2 = this.P;
        if (spriteGLView2 != null && spriteGLView2.H) {
            g16 = (-i16) + (this.Y.f291218b * 2.0f * g());
        } else {
            g16 = f17 - ((this.Y.f291218b * 2.0f) * g());
        }
        Matrix.translateM(this.X, 0, g18, g16 / f17, 0.0f);
        Matrix.rotateM(this.X, 0, -this.D, 0.0f, 0.0f, 1.0f);
        float f19 = f18 / g17;
        Matrix.scaleM(this.X, 0, f19, (this.f291152f / this.f291151e) * f19, 1.0f);
        float[] fArr2 = new float[16];
        Matrix.multiplyMM(fArr2, 0, fArr, 0, this.X, 0);
        GLES20.glUniformMatrix4fv(i19, 1, false, fArr2, 0);
        GLES20.glUniform1i(i26, 0);
        GLES20.glUniform1f(i27, ((this.E * f()) / 255.0f) / 255.0f);
        GLES20.glDrawElements(4, this.S.length, 5123, this.V);
        GLES20.glDisableVertexAttribArray(i17);
        GLES20.glDisableVertexAttribArray(i18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.surfaceviewaction.gl.d
    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.B();
        Texture texture = this.Q;
        if (texture != null) {
            texture.f291257d = false;
        }
    }

    public int C() {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        Texture texture = this.Q;
        if (texture != null && (bitmap = texture.f291255b) != null && !bitmap.isRecycled()) {
            return this.Q.f291255b.getHeight();
        }
        return (int) this.f291152f;
    }

    public Texture D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Texture) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.Q;
    }

    public int E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        this.Q.d();
        return this.Q.f291254a;
    }

    public int F() {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        Texture texture = this.Q;
        if (texture != null && (bitmap = texture.f291255b) != null && !bitmap.isRecycled()) {
            return this.Q.f291255b.getWidth();
        }
        return (int) this.f291151e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Texture texture = this.Q;
        if (texture != null && (bitmap = texture.f291255b) != null) {
            this.f291151e = bitmap.getWidth();
            this.f291152f = this.Q.f291255b.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        FloatBuffer put = ByteBuffer.allocateDirect(this.R.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.R);
        this.U = put;
        put.position(0);
        ShortBuffer put2 = ByteBuffer.allocateDirect(this.S.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer().put(this.S);
        this.V = put2;
        put2.position(0);
        FloatBuffer put3 = ByteBuffer.allocateDirect(this.T.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.T);
        this.W = put3;
        put3.position(0);
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.d
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void a(SpriteGLView spriteGLView, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) spriteGLView, (Object) bitmap);
            return;
        }
        this.P = spriteGLView;
        this.Q = new Texture(spriteGLView, bitmap);
        G();
    }

    public void J(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f291153h = f16;
            this.f291154i = f17;
        }
    }

    public void K(Texture texture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) texture);
        } else {
            this.Q = texture;
            G();
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.a
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Texture texture = this.Q;
        if (texture != null) {
            texture.e();
        }
    }

    public e(SpriteGLView spriteGLView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) spriteGLView);
            return;
        }
        this.R = new float[]{1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f};
        this.S = new short[]{0, 1, 2, 3, 4, 5};
        this.T = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.X = new float[16];
        this.Y = new f(0.0f, 0.0f);
        this.P = spriteGLView;
        H();
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.R = new float[]{1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f};
        this.S = new short[]{0, 1, 2, 3, 4, 5};
        this.T = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.X = new float[16];
        this.Y = new f(0.0f, 0.0f);
        H();
    }
}
