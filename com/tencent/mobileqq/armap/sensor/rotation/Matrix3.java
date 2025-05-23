package com.tencent.mobileqq.armap.sensor.rotation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class Matrix3 implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int M00 = 0;
    public static final int M01 = 3;
    public static final int M02 = 6;
    public static final int M10 = 1;
    public static final int M11 = 4;
    public static final int M12 = 7;
    public static final int M20 = 2;
    public static final int M21 = 5;
    public static final int M22 = 8;
    private static final long serialVersionUID = 7907569533774959788L;
    private float[] tmp;
    public float[] val;

    public Matrix3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.val = new float[9];
        this.tmp = new float[9];
        idt();
    }

    private static void a(float[] fArr, float[] fArr2) {
        float f16 = fArr[0];
        float f17 = fArr2[0];
        float f18 = fArr[3];
        float f19 = fArr2[1];
        float f26 = fArr[6];
        float f27 = fArr2[2];
        float f28 = (f16 * f17) + (f18 * f19) + (f26 * f27);
        float f29 = fArr2[3];
        float f36 = fArr2[4];
        float f37 = fArr2[5];
        float f38 = (f16 * f29) + (f18 * f36) + (f26 * f37);
        float f39 = fArr2[6];
        float f46 = fArr2[7];
        float f47 = fArr2[8];
        float f48 = (f16 * f39) + (f18 * f46) + (f26 * f47);
        float f49 = fArr[1];
        float f56 = fArr[4];
        float f57 = fArr[7];
        float f58 = (f49 * f17) + (f56 * f19) + (f57 * f27);
        float f59 = (f49 * f29) + (f56 * f36) + (f57 * f37);
        float f65 = (f49 * f39) + (f56 * f46) + (f57 * f47);
        float f66 = fArr[2];
        float f67 = fArr[5];
        float f68 = (f17 * f66) + (f19 * f67);
        float f69 = fArr[8];
        fArr[0] = f28;
        fArr[1] = f58;
        fArr[2] = f68 + (f27 * f69);
        fArr[3] = f38;
        fArr[4] = f59;
        fArr[5] = (f29 * f66) + (f36 * f67) + (f37 * f69);
        fArr[6] = f48;
        fArr[7] = f65;
        fArr[8] = (f66 * f39) + (f67 * f46) + (f69 * f47);
    }

    public float[] getValues() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (float[]) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.val;
    }

    public Matrix3 idt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Matrix3) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        float[] fArr = this.val;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        return this;
    }

    public Matrix3 rotate(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Matrix3) iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        }
        if (f16 == 0.0f) {
            return this;
        }
        double d16 = f16 * 0.017453292f;
        float cos = (float) Math.cos(d16);
        float sin = (float) Math.sin(d16);
        float[] fArr = this.tmp;
        fArr[0] = cos;
        fArr[1] = sin;
        fArr[2] = 0.0f;
        fArr[3] = -sin;
        fArr[4] = cos;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        a(this.val, fArr);
        return this;
    }

    public Matrix3 scale(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Matrix3) iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16), Float.valueOf(f17));
        }
        float[] fArr = this.tmp;
        fArr[0] = f16;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = f17;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        a(this.val, fArr);
        return this;
    }

    public Matrix3 set(Matrix3 matrix3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Matrix3) iPatchRedirector.redirect((short) 5, (Object) this, (Object) matrix3);
        }
        float[] fArr = matrix3.val;
        float[] fArr2 = this.val;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        return this;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "[" + this.val[0] + "|" + this.val[3] + "|" + this.val[6] + "]\n[" + this.val[1] + "|" + this.val[4] + "|" + this.val[7] + "]\n[" + this.val[2] + "|" + this.val[5] + "|" + this.val[8] + "]";
    }

    public Matrix3 translate(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Matrix3) iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16), Float.valueOf(f17));
        }
        float[] fArr = this.tmp;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = 0.0f;
        fArr[6] = f16;
        fArr[7] = f17;
        fArr[8] = 1.0f;
        a(this.val, fArr);
        return this;
    }

    public Matrix3 transpose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Matrix3) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        float[] fArr = this.val;
        float f16 = fArr[1];
        float f17 = fArr[2];
        float f18 = fArr[3];
        float f19 = fArr[5];
        float f26 = fArr[6];
        float f27 = fArr[7];
        fArr[3] = f16;
        fArr[6] = f17;
        fArr[1] = f18;
        fArr[7] = f19;
        fArr[2] = f26;
        fArr[5] = f27;
        return this;
    }

    public Matrix3 set(Matrix4 matrix4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Matrix3) iPatchRedirector.redirect((short) 6, (Object) this, (Object) matrix4);
        }
        float[] fArr = this.val;
        float[] fArr2 = matrix4.val;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
        fArr[3] = fArr2[4];
        fArr[4] = fArr2[5];
        fArr[5] = fArr2[6];
        fArr[6] = fArr2[8];
        fArr[7] = fArr2[9];
        fArr[8] = fArr2[10];
        return this;
    }

    public Matrix3(Matrix3 matrix3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) matrix3);
            return;
        }
        this.val = new float[9];
        this.tmp = new float[9];
        set(matrix3);
    }

    public Matrix3 scale(Vector2 vector2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Matrix3) iPatchRedirector.redirect((short) 11, (Object) this, (Object) vector2);
        }
        float[] fArr = this.tmp;
        fArr[0] = vector2.f199783x;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = vector2.f199784y;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        a(this.val, fArr);
        return this;
    }

    public Matrix3 translate(Vector2 vector2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Matrix3) iPatchRedirector.redirect((short) 8, (Object) this, (Object) vector2);
        }
        float[] fArr = this.tmp;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = 0.0f;
        fArr[6] = vector2.f199783x;
        fArr[7] = vector2.f199784y;
        fArr[8] = 1.0f;
        a(this.val, fArr);
        return this;
    }
}
