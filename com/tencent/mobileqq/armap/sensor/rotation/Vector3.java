package com.tencent.mobileqq.armap.sensor.rotation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class Vector3 implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final Vector3 X;
    public static final Vector3 Y;
    public static final Vector3 Z;
    public static final Vector3 Zero;

    /* renamed from: d, reason: collision with root package name */
    private static final Matrix4 f199785d;
    private static final long serialVersionUID = 3840054589595372522L;
    public static final Vector3 tmp;

    /* renamed from: x, reason: collision with root package name */
    public float f199786x;

    /* renamed from: y, reason: collision with root package name */
    public float f199787y;

    /* renamed from: z, reason: collision with root package name */
    public float f199788z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70896);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 37)) {
            redirector.redirect((short) 37);
            return;
        }
        tmp = new Vector3();
        X = new Vector3(1.0f, 0.0f, 0.0f);
        Y = new Vector3(0.0f, 1.0f, 0.0f);
        Z = new Vector3(0.0f, 0.0f, 1.0f);
        Zero = new Vector3(0.0f, 0.0f, 0.0f);
        f199785d = new Matrix4();
    }

    public Vector3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public Vector3 add(Vector3 vector3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? add(vector3.f199786x, vector3.f199787y, vector3.f199788z) : (Vector3) iPatchRedirector.redirect((short) 9, (Object) this, (Object) vector3);
    }

    public Vector3 crs(Vector3 vector3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Vector3) iPatchRedirector.redirect((short) 22, (Object) this, (Object) vector3);
        }
        float f16 = this.f199787y;
        float f17 = vector3.f199788z;
        float f18 = this.f199788z;
        float f19 = vector3.f199787y;
        float f26 = (f16 * f17) - (f18 * f19);
        float f27 = vector3.f199786x;
        float f28 = this.f199786x;
        return set(f26, (f18 * f27) - (f17 * f28), (f28 * f19) - (f16 * f27));
    }

    public Vector3 div(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Vector3) iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16));
        }
        return mul(1.0f / f16);
    }

    public float dot(Vector3 vector3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) ? (this.f199786x * vector3.f199786x) + (this.f199787y * vector3.f199787y) + (this.f199788z * vector3.f199788z) : ((Float) iPatchRedirector.redirect((short) 21, (Object) this, (Object) vector3)).floatValue();
    }

    public float dst(Vector3 vector3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Float) iPatchRedirector.redirect((short) 19, (Object) this, (Object) vector3)).floatValue();
        }
        float f16 = vector3.f199786x - this.f199786x;
        float f17 = vector3.f199787y - this.f199787y;
        float f18 = vector3.f199788z - this.f199788z;
        return (float) Math.sqrt((f16 * f16) + (f17 * f17) + (f18 * f18));
    }

    public float dst2(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Float) iPatchRedirector.redirect((short) 32, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18))).floatValue();
        }
        float f19 = f16 - this.f199786x;
        float f26 = f17 - this.f199787y;
        float f27 = f18 - this.f199788z;
        return (f19 * f19) + (f26 * f26) + (f27 * f27);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vector3 vector3 = (Vector3) obj;
        if (b.a(this.f199786x) == b.a(vector3.f199786x) && b.a(this.f199787y) == b.a(vector3.f199787y) && b.a(this.f199788z) == b.a(vector3.f199788z)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        return ((((b.a(this.f199786x) + 31) * 31) + b.a(this.f199787y)) * 31) + b.a(this.f199788z);
    }

    public boolean isUnit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        if (len() == 1.0f) {
            return true;
        }
        return false;
    }

    public boolean isZero() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        if (this.f199786x == 0.0f && this.f199787y == 0.0f && this.f199788z == 0.0f) {
            return true;
        }
        return false;
    }

    public float len() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Float) iPatchRedirector.redirect((short) 18, (Object) this)).floatValue();
        }
        float f16 = this.f199786x;
        float f17 = this.f199787y;
        float f18 = (f16 * f16) + (f17 * f17);
        float f19 = this.f199788z;
        return (float) Math.sqrt(f18 + (f19 * f19));
    }

    public Vector3 lerp(Vector3 vector3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Vector3) iPatchRedirector.redirect((short) 28, this, vector3, Float.valueOf(f16));
        }
        Vector3 mul = mul(1.0f - f16);
        mul.add(vector3.tmp().mul(f16));
        return mul;
    }

    public Vector3 mul(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) ? set(this.f199786x * f16, this.f199787y * f16, this.f199788z * f16) : (Vector3) iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
    }

    public Vector3 nor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Vector3) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        float len = len();
        if (len == 0.0f) {
            return this;
        }
        return div(len);
    }

    public Vector3 rotate(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) ? rotate(tmp.set(f17, f18, f19), f16) : (Vector3) iPatchRedirector.redirect((short) 24, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
    }

    public Vector3 scale(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (Vector3) iPatchRedirector.redirect((short) 36, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        }
        this.f199786x *= f16;
        this.f199787y *= f17;
        this.f199788z *= f18;
        return this;
    }

    public Vector3 set(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Vector3) iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        }
        this.f199786x = f16;
        this.f199787y = f17;
        this.f199788z = f18;
        return this;
    }

    public Vector3 slerp(Vector3 vector3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Vector3) iPatchRedirector.redirect((short) 29, this, vector3, Float.valueOf(f16));
        }
        float dot = dot(vector3);
        double d16 = dot;
        if (d16 <= 0.99995d && d16 >= 0.9995d) {
            if (dot > 1.0f) {
                dot = 1.0f;
            }
            if (dot < -1.0f) {
                dot = -1.0f;
            }
            float acos = ((float) Math.acos(dot)) * f16;
            Vector3 sub = vector3.tmp().sub(this.f199786x * dot, this.f199787y * dot, this.f199788z * dot);
            sub.nor();
            double d17 = acos;
            return mul((float) Math.cos(d17)).add(sub.mul((float) Math.sin(d17))).nor();
        }
        add(vector3.tmp().sub(this).mul(f16));
        nor();
        return this;
    }

    public Vector3 sub(Vector3 vector3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? sub(vector3.f199786x, vector3.f199787y, vector3.f199788z) : (Vector3) iPatchRedirector.redirect((short) 12, (Object) this, (Object) vector3);
    }

    public Vector3 tmp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Vector3) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return tmp.set(this);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.f199786x + "," + this.f199787y + "," + this.f199788z;
    }

    public Vector3(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            set(f16, f17, f18);
        } else {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        }
    }

    public Vector3 add(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? set(this.f199786x + f16, this.f199787y + f17, this.f199788z + f18) : (Vector3) iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
    }

    public float dot(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) ? (this.f199786x * f16) + (this.f199787y * f17) + (this.f199788z * f18) : ((Float) iPatchRedirector.redirect((short) 31, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18))).floatValue();
    }

    public Vector3 mul(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) ? set(this.f199786x * f16, this.f199787y * f17, this.f199788z * f18) : (Vector3) iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
    }

    public Vector3 rotate(Vector3 vector3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Vector3) iPatchRedirector.redirect((short) 25, this, vector3, Float.valueOf(f16));
        }
        Matrix4 matrix4 = f199785d;
        matrix4.setToRotation(vector3, f16);
        return mul(matrix4);
    }

    public Vector3 sub(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? set(this.f199786x - f16, this.f199787y - f17, this.f199788z - f18) : (Vector3) iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
    }

    public Vector3 add(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? set(this.f199786x + f16, this.f199787y + f16, this.f199788z + f16) : (Vector3) iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
    }

    public Vector3 mul(Matrix4 matrix4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Vector3) iPatchRedirector.redirect((short) 23, (Object) this, (Object) matrix4);
        }
        float[] fArr = matrix4.val;
        float f16 = this.f199786x;
        float f17 = fArr[0] * f16;
        float f18 = this.f199787y;
        float f19 = f17 + (fArr[4] * f18);
        float f26 = this.f199788z;
        return set(f19 + (fArr[8] * f26) + fArr[12], (fArr[1] * f16) + (fArr[5] * f18) + (fArr[9] * f26) + fArr[13], (f16 * fArr[2]) + (f18 * fArr[6]) + (f26 * fArr[10]) + fArr[14]);
    }

    public Vector3 sub(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? set(this.f199786x - f16, this.f199787y - f16, this.f199788z - f16) : (Vector3) iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
    }

    public Vector3(Vector3 vector3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            set(vector3);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) vector3);
        }
    }

    public Vector3 set(Vector3 vector3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? set(vector3.f199786x, vector3.f199787y, vector3.f199788z) : (Vector3) iPatchRedirector.redirect((short) 6, (Object) this, (Object) vector3);
    }

    public float dst(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) ? (float) Math.sqrt(dst2(f16, f17, f18)) : ((Float) iPatchRedirector.redirect((short) 33, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18))).floatValue();
    }

    public Vector3 set(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? set(fArr[0], fArr[1], fArr[2]) : (Vector3) iPatchRedirector.redirect((short) 7, (Object) this, (Object) fArr);
    }

    public Vector3(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            set(fArr[0], fArr[1], fArr[2]);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fArr);
        }
    }
}
