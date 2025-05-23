package com.tencent.mobileqq.armap.sensor.rotation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class Vector2 implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final Vector2 X;
    public static final Vector2 Y;
    public static final Vector2 Zero;
    private static final long serialVersionUID = 913902788239530931L;
    public static final Vector2 tmp;
    public static final Vector2 tmp2;
    public static final Vector2 tmp3;

    /* renamed from: x, reason: collision with root package name */
    public float f199783x;

    /* renamed from: y, reason: collision with root package name */
    public float f199784y;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70895);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
            return;
        }
        tmp = new Vector2();
        tmp2 = new Vector2();
        tmp3 = new Vector2();
        X = new Vector2(1.0f, 0.0f);
        Y = new Vector2(0.0f, 1.0f);
        Zero = new Vector2(0.0f, 0.0f);
    }

    public Vector2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public Vector2 add(Vector2 vector2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Vector2) iPatchRedirector.redirect((short) 9, (Object) this, (Object) vector2);
        }
        this.f199783x += vector2.f199783x;
        this.f199784y += vector2.f199784y;
        return this;
    }

    public float angle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Float) iPatchRedirector.redirect((short) 18, (Object) this)).floatValue();
        }
        float atan2 = ((float) Math.atan2(this.f199784y, this.f199783x)) * 57.295776f;
        if (atan2 < 0.0f) {
            return atan2 + 360.0f;
        }
        return atan2;
    }

    public float dot(Vector2 vector2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, (Object) this, (Object) vector2)).floatValue();
        }
        return (this.f199783x * vector2.f199783x) + (this.f199784y * vector2.f199784y);
    }

    public float dst(Vector2 vector2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Float) iPatchRedirector.redirect((short) 13, (Object) this, (Object) vector2)).floatValue();
        }
        float f16 = vector2.f199783x - this.f199783x;
        float f17 = vector2.f199784y - this.f199784y;
        return (float) Math.sqrt((f16 * f16) + (f17 * f17));
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vector2 vector2 = (Vector2) obj;
        if (b.a(this.f199783x) == b.a(vector2.f199783x) && b.a(this.f199784y) == b.a(vector2.f199784y)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return ((b.a(this.f199783x) + 31) * 31) + b.a(this.f199784y);
    }

    public float len() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        float f16 = this.f199783x;
        float f17 = this.f199784y;
        return (float) Math.sqrt((f16 * f16) + (f17 * f17));
    }

    public Vector2 lerp(Vector2 vector2, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Vector2) iPatchRedirector.redirect((short) 21, this, vector2, Float.valueOf(f16));
        }
        Vector2 mul = mul(1.0f - f16);
        mul.add(vector2.tmp().mul(f16));
        return mul;
    }

    public Vector2 mul(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Vector2) iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
        }
        this.f199783x *= f16;
        this.f199784y *= f16;
        return this;
    }

    public Vector2 nor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Vector2) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        float len = len();
        if (len != 0.0f) {
            this.f199783x /= len;
            this.f199784y /= len;
        }
        return this;
    }

    public Vector2 rotate(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Vector2) iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16));
        }
        double d16 = f16 * 0.017453292f;
        float cos = (float) Math.cos(d16);
        float sin = (float) Math.sin(d16);
        float f17 = this.f199783x;
        float f18 = this.f199784y;
        this.f199783x = (f17 * cos) - (f18 * sin);
        this.f199784y = (f17 * sin) + (f18 * cos);
        return this;
    }

    public Vector2 set(Vector2 vector2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Vector2) iPatchRedirector.redirect((short) 5, (Object) this, (Object) vector2);
        }
        this.f199783x = vector2.f199783x;
        this.f199784y = vector2.f199784y;
        return this;
    }

    public void setAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16));
        } else {
            set(len(), 0.0f);
            rotate(f16);
        }
    }

    public Vector2 sub(Vector2 vector2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Vector2) iPatchRedirector.redirect((short) 7, (Object) this, (Object) vector2);
        }
        this.f199783x -= vector2.f199783x;
        this.f199784y -= vector2.f199784y;
        return this;
    }

    public Vector2 tmp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Vector2) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return tmp.set(this);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "[" + this.f199783x + ":" + this.f199784y + "]";
    }

    public Vector2(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f199783x = f16;
            this.f199784y = f17;
        }
    }

    public Vector2 add(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Vector2) iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16), Float.valueOf(f17));
        }
        this.f199783x += f16;
        this.f199784y += f17;
        return this;
    }

    public Vector2 set(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Vector2) iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16), Float.valueOf(f17));
        }
        this.f199783x = f16;
        this.f199784y = f17;
        return this;
    }

    public Vector2 sub(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Vector2) iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16), Float.valueOf(f17));
        }
        this.f199783x -= f16;
        this.f199784y -= f17;
        return this;
    }

    public float dst(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Float) iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16), Float.valueOf(f17))).floatValue();
        }
        float f18 = f16 - this.f199783x;
        float f19 = f17 - this.f199784y;
        return (float) Math.sqrt((f18 * f18) + (f19 * f19));
    }

    public Vector2(Vector2 vector2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            set(vector2);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) vector2);
        }
    }
}
