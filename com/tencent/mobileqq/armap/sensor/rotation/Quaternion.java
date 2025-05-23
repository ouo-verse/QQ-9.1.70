package com.tencent.mobileqq.armap.sensor.rotation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class Quaternion implements Serializable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: d, reason: collision with root package name */
    private static Quaternion f199777d = null;

    /* renamed from: e, reason: collision with root package name */
    private static Quaternion f199778e = null;
    private static final long serialVersionUID = -7661875440774897168L;

    /* renamed from: w, reason: collision with root package name */
    public float f199779w;

    /* renamed from: x, reason: collision with root package name */
    public float f199780x;

    /* renamed from: y, reason: collision with root package name */
    public float f199781y;

    /* renamed from: z, reason: collision with root package name */
    public float f199782z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70893);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            f199777d = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
            f199778e = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public Quaternion(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            set(f16, f17, f18, f19);
        } else {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        }
    }

    public Quaternion conjugate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Quaternion) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        this.f199780x = -this.f199780x;
        this.f199781y = -this.f199781y;
        this.f199782z = -this.f199782z;
        return this;
    }

    public Quaternion cpy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Quaternion) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new Quaternion(this);
    }

    public float dot(Quaternion quaternion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Float) iPatchRedirector.redirect((short) 23, (Object) this, (Object) quaternion)).floatValue();
        }
        return (this.f199780x * quaternion.f199780x) + (this.f199781y * quaternion.f199781y) + (this.f199782z * quaternion.f199782z) + (this.f199779w * quaternion.f199779w);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Quaternion)) {
            return false;
        }
        Quaternion quaternion = (Quaternion) obj;
        if (this.f199780x == quaternion.f199780x && this.f199781y == quaternion.f199781y && this.f199782z == quaternion.f199782z && this.f199779w == quaternion.f199779w) {
            return true;
        }
        return false;
    }

    public Quaternion idt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Quaternion) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        set(0.0f, 0.0f, 0.0f, 1.0f);
        return this;
    }

    public float len() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        float f16 = this.f199780x;
        float f17 = this.f199781y;
        float f18 = (f16 * f16) + (f17 * f17);
        float f19 = this.f199782z;
        float f26 = f18 + (f19 * f19);
        float f27 = this.f199779w;
        return (float) Math.sqrt(f26 + (f27 * f27));
    }

    public float len2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, (Object) this)).floatValue();
        }
        float f16 = this.f199780x;
        float f17 = this.f199781y;
        float f18 = (f16 * f16) + (f17 * f17);
        float f19 = this.f199782z;
        float f26 = f18 + (f19 * f19);
        float f27 = this.f199779w;
        return f26 + (f27 * f27);
    }

    public Quaternion mul(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Quaternion) iPatchRedirector.redirect((short) 24, this, Float.valueOf(f16));
        }
        this.f199780x *= f16;
        this.f199781y *= f16;
        this.f199782z *= f16;
        this.f199779w *= f16;
        return this;
    }

    public Quaternion mulLeft(Quaternion quaternion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Quaternion) iPatchRedirector.redirect((short) 15, (Object) this, (Object) quaternion);
        }
        float f16 = quaternion.f199779w;
        float f17 = this.f199780x;
        float f18 = quaternion.f199780x;
        float f19 = this.f199779w;
        float f26 = quaternion.f199781y;
        float f27 = this.f199782z;
        float f28 = quaternion.f199782z;
        float f29 = this.f199781y;
        this.f199780x = (((f16 * f17) + (f18 * f19)) + (f26 * f27)) - (f28 * f29);
        this.f199781y = (((f16 * f29) + (f26 * f19)) + (f28 * f17)) - (f18 * f27);
        this.f199782z = (((f16 * f27) + (f28 * f19)) + (f18 * f29)) - (f26 * f17);
        this.f199779w = (((f16 * f19) - (f18 * f17)) - (f26 * f29)) - (f28 * f27);
        return this;
    }

    public Quaternion nor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Quaternion) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        float len2 = len2();
        if (len2 != 0.0f && Math.abs(len2 - 1.0f) > 1.0E-5f) {
            float sqrt = (float) Math.sqrt(len2);
            this.f199779w /= sqrt;
            this.f199780x /= sqrt;
            this.f199781y /= sqrt;
            this.f199782z /= sqrt;
        }
        return this;
    }

    public Quaternion set(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Quaternion) iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        }
        this.f199780x = f16;
        this.f199781y = f17;
        this.f199782z = f18;
        this.f199779w = f19;
        return this;
    }

    public Quaternion setFromAxes(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36) {
        double d16;
        double d17;
        double d18;
        double d19;
        float f37;
        double d26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Quaternion) iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26), Float.valueOf(f27), Float.valueOf(f28), Float.valueOf(f29), Float.valueOf(f36));
        }
        if (f16 + f26 + f36 >= 0.0f) {
            double sqrt = Math.sqrt(r4 + 1.0f);
            d26 = sqrt * 0.5d;
            double d27 = 0.5d / sqrt;
            d18 = (f29 - f27) * d27;
            d19 = (f18 - f28) * d27;
            d16 = (f19 - f17) * d27;
        } else if (f16 > f26 && f16 > f36) {
            double sqrt2 = Math.sqrt(((f16 + 1.0d) - f26) - f36);
            double d28 = 0.5d / sqrt2;
            d19 = (f19 + f17) * d28;
            d16 = (f18 + f28) * d28;
            d18 = sqrt2 * 0.5d;
            d26 = (f29 - f27) * d28;
        } else {
            if (f26 > f36) {
                double sqrt3 = Math.sqrt(((f26 + 1.0d) - f16) - f36);
                d19 = sqrt3 * 0.5d;
                d17 = 0.5d / sqrt3;
                d18 = (f19 + f17) * d17;
                d16 = (f29 + f27) * d17;
                f37 = f18 - f28;
            } else {
                double sqrt4 = Math.sqrt(((f36 + 1.0d) - f16) - f26);
                d16 = sqrt4 * 0.5d;
                d17 = 0.5d / sqrt4;
                d18 = (f18 + f28) * d17;
                d19 = (f29 + f27) * d17;
                f37 = f19 - f17;
            }
            d26 = f37 * d17;
        }
        return set((float) d18, (float) d19, (float) d16, (float) d26);
    }

    public Quaternion setFromAxis(Vector3 vector3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) ? setFromAxis(vector3.f199786x, vector3.f199787y, vector3.f199788z, f16) : (Quaternion) iPatchRedirector.redirect((short) 17, this, vector3, Float.valueOf(f16));
    }

    public Quaternion setFromMatrix(Matrix4 matrix4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Quaternion) iPatchRedirector.redirect((short) 19, (Object) this, (Object) matrix4);
        }
        float[] fArr = matrix4.val;
        return setFromAxes(fArr[0], fArr[4], fArr[8], fArr[1], fArr[5], fArr[9], fArr[2], fArr[6], fArr[10]);
    }

    public Quaternion slerp(Quaternion quaternion, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Quaternion) iPatchRedirector.redirect((short) 21, this, quaternion, Float.valueOf(f16));
        }
        if (equals(quaternion)) {
            return this;
        }
        float dot = dot(quaternion);
        if (dot < 0.0d) {
            quaternion.mul(-1.0f);
            dot = -dot;
        }
        float f17 = 1.0f - f16;
        if (1.0f - dot > 0.1d) {
            double acos = Math.acos(dot);
            double sin = 1.0d / Math.sin(acos);
            f17 = (float) (Math.sin(f17 * acos) * sin);
            f16 = (float) (Math.sin(f16 * acos) * sin);
        }
        set((this.f199780x * f17) + (quaternion.f199780x * f16), (this.f199781y * f17) + (quaternion.f199781y * f16), (this.f199782z * f17) + (quaternion.f199782z * f16), (f17 * this.f199779w) + (f16 * quaternion.f199779w));
        return this;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "[" + this.f199780x + "|" + this.f199781y + "|" + this.f199782z + "|" + this.f199779w + "]";
    }

    public void transform(Vector3 vector3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) vector3);
            return;
        }
        f199778e.set(this);
        f199778e.conjugate();
        f199778e.mulLeft(f199777d.set(vector3.f199786x, vector3.f199787y, vector3.f199788z, 0.0f)).mulLeft(this);
        Quaternion quaternion = f199778e;
        vector3.f199786x = quaternion.f199780x;
        vector3.f199787y = quaternion.f199781y;
        vector3.f199788z = quaternion.f199782z;
    }

    public Quaternion setFromAxis(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Quaternion) iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        }
        float f26 = (f19 * 0.017453292f) / 2.0f;
        float b16 = a.b(f26);
        return set(f16 * b16, f17 * b16, f18 * b16, a.a(f26)).nor();
    }

    public Quaternion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            idt();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public Quaternion(Quaternion quaternion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            set(quaternion);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) quaternion);
        }
    }

    public Quaternion set(Quaternion quaternion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? set(quaternion.f199780x, quaternion.f199781y, quaternion.f199782z, quaternion.f199779w) : (Quaternion) iPatchRedirector.redirect((short) 6, (Object) this, (Object) quaternion);
    }

    public Quaternion set(Vector3 vector3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Quaternion) iPatchRedirector.redirect((short) 7, this, vector3, Float.valueOf(f16));
        }
        double radians = ((float) Math.toRadians(f16)) / 2.0f;
        float sin = (float) Math.sin(radians);
        return set(vector3.f199786x * sin, vector3.f199787y * sin, vector3.f199788z * sin, (float) Math.cos(radians)).nor();
    }

    public Quaternion(Vector3 vector3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            set(vector3, f16);
        } else {
            iPatchRedirector.redirect((short) 4, this, vector3, Float.valueOf(f16));
        }
    }
}
