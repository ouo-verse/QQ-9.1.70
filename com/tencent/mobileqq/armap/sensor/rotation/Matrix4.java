package com.tencent.mobileqq.armap.sensor.rotation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class Matrix4 implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int M00 = 0;
    public static final int M01 = 4;
    public static final int M02 = 8;
    public static final int M03 = 12;
    public static final int M10 = 1;
    public static final int M11 = 5;
    public static final int M12 = 9;
    public static final int M13 = 13;
    public static final int M20 = 2;
    public static final int M21 = 6;
    public static final int M22 = 10;
    public static final int M23 = 14;
    public static final int M30 = 3;
    public static final int M31 = 7;
    public static final int M32 = 11;
    public static final int M33 = 15;
    static Vector3 l_vex = null;
    static Vector3 l_vey = null;
    static Vector3 l_vez = null;
    static Quaternion quat = null;
    private static final long serialVersionUID = -2717655254359579617L;
    public final float[] tmp;
    public final float[] val;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70890);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
            return;
        }
        quat = new Quaternion();
        l_vez = new Vector3();
        l_vex = new Vector3();
        l_vey = new Vector3();
    }

    public Matrix4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.tmp = new float[16];
        float[] fArr = new float[16];
        this.val = fArr;
        fArr[0] = 1.0f;
        fArr[5] = 1.0f;
        fArr[10] = 1.0f;
        fArr[15] = 1.0f;
    }

    public void getRotation(Quaternion quaternion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) quaternion);
        } else {
            quaternion.setFromMatrix(this);
        }
    }

    public void getTranslation(Vector3 vector3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) vector3);
            return;
        }
        float[] fArr = this.val;
        vector3.f199786x = fArr[12];
        vector3.f199787y = fArr[13];
        vector3.f199788z = fArr[14];
    }

    public float[] getValues() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (float[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.val;
    }

    public Matrix4 idt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Matrix4) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        float[] fArr = this.val;
        fArr[0] = 1.0f;
        fArr[4] = 0.0f;
        fArr[8] = 0.0f;
        fArr[12] = 0.0f;
        fArr[1] = 0.0f;
        fArr[5] = 1.0f;
        fArr[9] = 0.0f;
        fArr[13] = 0.0f;
        fArr[2] = 0.0f;
        fArr[6] = 0.0f;
        fArr[10] = 1.0f;
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4 inv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Matrix4) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        float[] fArr = this.val;
        float f16 = fArr[3];
        float f17 = fArr[6];
        float f18 = fArr[9];
        float f19 = fArr[12];
        float f26 = fArr[2];
        float f27 = fArr[7];
        float f28 = fArr[5];
        float f29 = fArr[10];
        float f36 = fArr[1];
        float f37 = fArr[11];
        float f38 = fArr[8];
        float f39 = fArr[13];
        float f46 = fArr[4];
        float f47 = fArr[0];
        float f48 = fArr[14];
        float f49 = fArr[15];
        float f56 = (((((((((((((((((((((((((f16 * f17) * f18) * f19) - (((f26 * f27) * f18) * f19)) - (((f16 * f28) * f29) * f19)) + (((f36 * f27) * f29) * f19)) + (((f26 * f28) * f37) * f19)) - (((f36 * f17) * f37) * f19)) - (((f16 * f17) * f38) * f39)) + (((f26 * f27) * f38) * f39)) + (((f16 * f46) * f29) * f39)) - (((f47 * f27) * f29) * f39)) - (((f26 * f46) * f37) * f39)) + (((f47 * f17) * f37) * f39)) + (((f16 * f28) * f38) * f48)) - (((f36 * f27) * f38) * f48)) - (((f16 * f46) * f18) * f48)) + (((f47 * f27) * f18) * f48)) + (((f36 * f46) * f37) * f48)) - (((f47 * f28) * f37) * f48)) - (((f26 * f28) * f38) * f49)) + (((f36 * f17) * f38) * f49)) + (((f26 * f46) * f18) * f49)) - (((f47 * f17) * f18) * f49)) - (((f36 * f46) * f29) * f49)) + (f47 * f28 * f29 * f49);
        if (f56 != 0.0f) {
            float f57 = 1.0f / f56;
            float[] fArr2 = this.tmp;
            float f58 = ((((((f18 * f48) * f27) - ((f39 * f29) * f27)) + ((f39 * f17) * f37)) - ((f28 * f48) * f37)) - ((f18 * f17) * f49)) + (f28 * f29 * f49);
            fArr2[0] = f58;
            float f59 = ((((((f19 * f29) * f27) - ((f38 * f48) * f27)) - ((f19 * f17) * f37)) + ((f46 * f48) * f37)) + ((f38 * f17) * f49)) - ((f46 * f29) * f49);
            fArr2[4] = f59;
            float f65 = fArr[4];
            float f66 = ((((((f38 * f39) * f27) - ((f19 * f18) * f27)) + ((f19 * f28) * f37)) - ((f65 * f39) * f37)) - ((f38 * f28) * f49)) + (f65 * f18 * f49);
            fArr2[8] = f66;
            float f67 = fArr[8];
            float f68 = ((((((f19 * f18) * f17) - ((f67 * f39) * f17)) - ((f19 * f28) * f29)) + ((f65 * f39) * f29)) + ((f28 * f67) * f48)) - ((f65 * f18) * f48);
            fArr2[12] = f68;
            float f69 = ((((((f39 * f29) * f16) - ((f18 * f48) * f16)) - ((f39 * f26) * f37)) + ((f36 * f48) * f37)) + ((f18 * f26) * f49)) - ((f36 * f29) * f49);
            fArr2[1] = f69;
            float f75 = fArr[12];
            float f76 = fArr[0];
            float f77 = ((((((f67 * f48) * f16) - ((f75 * f29) * f16)) + ((f75 * f26) * f37)) - ((f76 * f48) * f37)) - ((f67 * f26) * f49)) + (f76 * f29 * f49);
            fArr2[5] = f77;
            float f78 = fArr[1];
            float f79 = ((((((f75 * f18) * f16) - ((f67 * f39) * f16)) - ((f75 * f78) * f37)) + ((f76 * f39) * f37)) + ((f67 * f78) * f49)) - ((f18 * f76) * f49);
            fArr2[9] = f79;
            float f85 = fArr[9];
            float f86 = ((((((f67 * f39) * f26) - ((f75 * f85) * f26)) + ((f75 * f78) * f29)) - ((f39 * f76) * f29)) - ((f67 * f78) * f48)) + (f76 * f85 * f48);
            fArr2[13] = f86;
            float f87 = fArr[5];
            float f88 = fArr[13];
            float f89 = ((((((f87 * f48) * f16) - ((f88 * f17) * f16)) + ((f88 * f26) * f27)) - ((f78 * f48) * f27)) - ((f26 * f87) * f49)) + (f78 * f17 * f49);
            fArr2[2] = f89;
            float f95 = fArr[2];
            float f96 = ((((((f75 * f17) * f16) - ((f65 * f48) * f16)) - ((f75 * f95) * f27)) + ((f76 * f48) * f27)) + ((f65 * f95) * f49)) - ((f17 * f76) * f49);
            fArr2[6] = f96;
            float f97 = ((((((f65 * f88) * f16) - ((f75 * f87) * f16)) + ((f75 * f78) * f27)) - ((f76 * f88) * f27)) - ((f65 * f78) * f49)) + (f76 * f87 * f49);
            fArr2[10] = f97;
            float f98 = fArr[6];
            float f99 = ((((((f75 * f87) * f95) - ((f65 * f88) * f95)) - ((f75 * f78) * f98)) + ((f88 * f76) * f98)) + ((f65 * f78) * f48)) - ((f76 * f87) * f48);
            fArr2[14] = f99;
            float f100 = fArr[10];
            float f101 = ((((((f85 * f98) * f16) - ((f87 * f100) * f16)) - ((f85 * f95) * f27)) + ((f78 * f100) * f27)) + ((f87 * f95) * f37)) - ((f78 * f98) * f37);
            fArr2[3] = f101;
            float f102 = fArr[3];
            float f103 = ((((((f65 * f100) * f102) - ((f67 * f98) * f102)) + ((f67 * f95) * f27)) - ((f76 * f100) * f27)) - ((f65 * f95) * f37)) + (f76 * f98 * f37);
            fArr2[7] = f103;
            float f104 = fArr[7];
            float f105 = ((((((f67 * f87) * f102) - ((f65 * f85) * f102)) - ((f67 * f78) * f104)) + ((f76 * f85) * f104)) + ((f65 * f78) * f37)) - ((f76 * f87) * f37);
            fArr2[11] = f105;
            float f106 = ((((((f65 * f85) * f95) - ((f67 * f87) * f95)) + ((f67 * f78) * f98)) - ((f85 * f76) * f98)) - ((f65 * f78) * f100)) + (f76 * f87 * f100);
            fArr2[15] = f106;
            fArr[0] = f58 * f57;
            fArr[4] = f59 * f57;
            fArr[8] = f66 * f57;
            fArr[12] = f68 * f57;
            fArr[1] = f69 * f57;
            fArr[5] = f77 * f57;
            fArr[9] = f79 * f57;
            fArr[13] = f86 * f57;
            fArr[2] = f89 * f57;
            fArr[6] = f96 * f57;
            fArr[10] = f97 * f57;
            fArr[14] = f99 * f57;
            fArr[3] = f101 * f57;
            fArr[7] = f103 * f57;
            fArr[11] = f105 * f57;
            fArr[15] = f106 * f57;
            return this;
        }
        throw new RuntimeException("non-invertible matrix");
    }

    public void lerp(Matrix4 matrix4, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, matrix4, Float.valueOf(f16));
            return;
        }
        for (int i3 = 0; i3 < 16; i3++) {
            float[] fArr = this.val;
            fArr[i3] = (fArr[i3] * (1.0f - f16)) + (matrix4.val[i3] * f16);
        }
    }

    public Matrix4 mul(Matrix4 matrix4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Matrix4) iPatchRedirector.redirect((short) 10, (Object) this, (Object) matrix4);
        }
        return mul_java(matrix4);
    }

    public Matrix4 mul_java(Matrix4 matrix4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Matrix4) iPatchRedirector.redirect((short) 11, (Object) this, (Object) matrix4);
        }
        float[] fArr = this.tmp;
        float[] fArr2 = this.val;
        float f16 = fArr2[0];
        float[] fArr3 = matrix4.val;
        float f17 = f16 * fArr3[0];
        float f18 = fArr2[4];
        float f19 = fArr3[1];
        float f26 = fArr2[8];
        float f27 = fArr3[2];
        float f28 = fArr2[12];
        float f29 = fArr3[3];
        fArr[0] = f17 + (f18 * f19) + (f26 * f27) + (f28 * f29);
        float f36 = fArr2[0];
        float f37 = fArr3[4] * f36;
        float f38 = fArr3[5];
        float f39 = fArr3[6];
        float f46 = fArr3[7];
        fArr[4] = f37 + (f18 * f38) + (f26 * f39) + (f28 * f46);
        float f47 = fArr3[8] * f36;
        float f48 = fArr2[4];
        float f49 = fArr3[9];
        float f56 = fArr3[10];
        float f57 = f47 + (f48 * f49) + (f26 * f56);
        float f58 = fArr3[11];
        fArr[8] = f57 + (f28 * f58);
        float f59 = f36 * fArr3[12];
        float f65 = fArr3[13];
        float f66 = f59 + (f48 * f65);
        float f67 = fArr2[8];
        float f68 = fArr3[14];
        float f69 = fArr3[15];
        fArr[12] = f66 + (f67 * f68) + (f28 * f69);
        float f75 = fArr2[1];
        float f76 = fArr3[0];
        float f77 = fArr2[5];
        float f78 = (f75 * f76) + (f19 * f77);
        float f79 = fArr2[9];
        float f85 = fArr2[13];
        fArr[1] = f78 + (f79 * f27) + (f85 * f29);
        float f86 = fArr2[1];
        float f87 = fArr3[4];
        fArr[5] = (f86 * f87) + (f77 * f38) + (f79 * f39) + (f85 * f46);
        float f88 = fArr3[8];
        float f89 = fArr2[5];
        fArr[9] = (f86 * f88) + (f49 * f89) + (f79 * f56) + (f85 * f58);
        float f95 = fArr3[12];
        fArr[13] = (f86 * f95) + (f89 * f65) + (fArr2[9] * f68) + (f85 * f69);
        float f96 = fArr2[2] * f76;
        float f97 = fArr2[6];
        float f98 = fArr3[1];
        float f99 = fArr2[10];
        float f100 = f96 + (f97 * f98) + (f27 * f99);
        float f101 = fArr2[14];
        fArr[2] = f100 + (f101 * f29);
        float f102 = fArr2[2];
        float f103 = fArr3[5];
        fArr[6] = (f102 * f87) + (f97 * f103) + (f39 * f99) + (f101 * f46);
        float f104 = fArr2[6];
        float f105 = fArr3[9];
        fArr[10] = (f102 * f88) + (f104 * f105) + (f99 * f56) + (f101 * f58);
        float f106 = fArr3[13];
        fArr[14] = (f102 * f95) + (f104 * f106) + (fArr2[10] * f68) + (f101 * f69);
        float f107 = fArr2[3] * f76;
        float f108 = fArr2[7];
        float f109 = f107 + (f98 * f108);
        float f110 = fArr2[11];
        float f111 = f109 + (fArr3[2] * f110);
        float f112 = fArr2[15];
        fArr[3] = f111 + (f29 * f112);
        float f113 = fArr2[3];
        fArr[7] = (f87 * f113) + (f108 * f103) + (fArr3[6] * f110) + (f46 * f112);
        float f114 = fArr2[7];
        fArr[11] = (f88 * f113) + (f105 * f114) + (f110 * fArr3[10]) + (f58 * f112);
        fArr[15] = (f113 * f95) + (f114 * f106) + (fArr2[11] * fArr3[14]) + (f112 * f69);
        return set(fArr);
    }

    public Matrix4 set(Matrix4 matrix4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? set(matrix4.val) : (Matrix4) iPatchRedirector.redirect((short) 5, (Object) this, (Object) matrix4);
    }

    public Matrix4 setToLookAt(Vector3 vector3, Vector3 vector32) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Matrix4) iPatchRedirector.redirect((short) 19, (Object) this, (Object) vector3, (Object) vector32);
        }
        l_vez.set(vector3).nor();
        l_vex.set(vector3).nor();
        l_vex.crs(vector32).nor();
        l_vey.set(l_vex).crs(l_vez).nor();
        idt();
        float[] fArr = this.val;
        Vector3 vector33 = l_vex;
        fArr[0] = vector33.f199786x;
        fArr[4] = vector33.f199787y;
        fArr[8] = vector33.f199788z;
        Vector3 vector34 = l_vey;
        fArr[1] = vector34.f199786x;
        fArr[5] = vector34.f199787y;
        fArr[9] = vector34.f199788z;
        Vector3 vector35 = l_vez;
        fArr[2] = -vector35.f199786x;
        fArr[6] = -vector35.f199787y;
        fArr[10] = -vector35.f199788z;
        return this;
    }

    public Matrix4 setToOrtho(float f16, float f17, float f18, float f19, float f26, float f27) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Matrix4) iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26), Float.valueOf(f27));
        }
        idt();
        float f28 = f17 - f16;
        float f29 = 2.0f / f28;
        float f36 = f19 - f18;
        float f37 = 2.0f / f36;
        float f38 = f27 - f26;
        float f39 = (-2.0f) / f38;
        float f46 = (-(f17 + f16)) / f28;
        float f47 = (-(f19 + f18)) / f36;
        float f48 = (-(f27 + f26)) / f38;
        float[] fArr = this.val;
        fArr[0] = f29;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = f37;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = f39;
        fArr[11] = 0.0f;
        fArr[12] = f46;
        fArr[13] = f47;
        fArr[14] = f48;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4 setToOrtho2D(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Matrix4) iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        }
        setToOrtho(f16, f16 + f18, f17, f17 + f19, 0.0f, 1.0f);
        return this;
    }

    public Matrix4 setToRotation(Vector3 vector3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Matrix4) iPatchRedirector.redirect((short) 18, this, vector3, Float.valueOf(f16));
        }
        if (f16 == 0.0f) {
            idt();
            return this;
        }
        return set(quat.set(vector3, f16));
    }

    public Matrix4 setToTranslation(Vector3 vector3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Matrix4) iPatchRedirector.redirect((short) 17, (Object) this, (Object) vector3);
        }
        idt();
        float[] fArr = this.val;
        fArr[12] = vector3.f199786x;
        fArr[13] = vector3.f199787y;
        fArr[14] = vector3.f199788z;
        return this;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "[" + this.val[0] + "|" + this.val[4] + "|" + this.val[8] + "|" + this.val[12] + "]\n[" + this.val[1] + "|" + this.val[5] + "|" + this.val[9] + "|" + this.val[13] + "]\n[" + this.val[2] + "|" + this.val[6] + "|" + this.val[10] + "|" + this.val[14] + "]\n[" + this.val[3] + "|" + this.val[7] + "|" + this.val[11] + "|" + this.val[15] + "]\n";
    }

    public Matrix4 tra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Matrix4) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        float[] fArr = this.tmp;
        float[] fArr2 = this.val;
        fArr[0] = fArr2[0];
        fArr[4] = fArr2[1];
        fArr[8] = fArr2[2];
        fArr[12] = fArr2[3];
        fArr[1] = fArr2[4];
        fArr[5] = fArr2[5];
        fArr[9] = fArr2[6];
        fArr[13] = fArr2[7];
        fArr[2] = fArr2[8];
        fArr[6] = fArr2[9];
        fArr[10] = fArr2[10];
        fArr[14] = fArr2[11];
        fArr[3] = fArr2[12];
        fArr[7] = fArr2[13];
        fArr[11] = fArr2[14];
        fArr[15] = fArr2[15];
        return set(fArr);
    }

    public Matrix4 set(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Matrix4) iPatchRedirector.redirect((short) 6, (Object) this, (Object) fArr);
        }
        float[] fArr2 = this.val;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        return this;
    }

    public Matrix4 set(Quaternion quaternion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Matrix4) iPatchRedirector.redirect((short) 7, (Object) this, (Object) quaternion);
        }
        float f16 = quaternion.f199780x;
        float f17 = f16 * f16;
        float f18 = quaternion.f199781y;
        float f19 = f16 * f18;
        float f26 = quaternion.f199782z;
        float f27 = f16 * f26;
        float f28 = quaternion.f199779w;
        float f29 = f16 * f28;
        float f36 = f18 * f18;
        float f37 = f18 * f26;
        float f38 = f18 * f28;
        float f39 = f26 * f26;
        float f46 = f26 * f28;
        float[] fArr = this.val;
        fArr[0] = 1.0f - ((f36 + f39) * 2.0f);
        fArr[4] = (f19 - f46) * 2.0f;
        fArr[8] = (f27 + f38) * 2.0f;
        fArr[12] = 0.0f;
        fArr[1] = (f19 + f46) * 2.0f;
        fArr[5] = 1.0f - ((f39 + f17) * 2.0f);
        fArr[9] = (f37 - f29) * 2.0f;
        fArr[13] = 0.0f;
        fArr[2] = (f27 - f38) * 2.0f;
        fArr[6] = (f37 + f29) * 2.0f;
        fArr[10] = 1.0f - ((f17 + f36) * 2.0f);
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4(Matrix4 matrix4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) matrix4);
            return;
        }
        this.tmp = new float[16];
        this.val = new float[16];
        set(matrix4);
    }

    public Matrix4(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fArr);
            return;
        }
        this.tmp = new float[16];
        this.val = new float[16];
        set(fArr);
    }

    public Matrix4(Quaternion quaternion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) quaternion);
            return;
        }
        this.tmp = new float[16];
        this.val = new float[16];
        set(quaternion);
    }

    public Matrix4 set(Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Matrix4) iPatchRedirector.redirect((short) 8, this, vector3, vector32, vector33, vector34);
        }
        float[] fArr = this.val;
        fArr[0] = vector3.f199786x;
        fArr[4] = vector3.f199787y;
        fArr[8] = vector3.f199788z;
        fArr[1] = vector32.f199786x;
        fArr[5] = vector32.f199787y;
        fArr[9] = vector32.f199788z;
        fArr[2] = -vector33.f199786x;
        fArr[6] = -vector33.f199787y;
        fArr[10] = -vector33.f199788z;
        fArr[12] = vector34.f199786x;
        fArr[13] = vector34.f199787y;
        fArr[14] = vector34.f199788z;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4 set(Matrix3 matrix3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Matrix4) iPatchRedirector.redirect((short) 22, (Object) this, (Object) matrix3);
        }
        float[] fArr = this.val;
        float[] fArr2 = matrix3.val;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
        fArr[3] = 0.0f;
        fArr[4] = fArr2[3];
        fArr[5] = fArr2[4];
        fArr[6] = fArr2[5];
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = fArr2[6];
        fArr[13] = fArr2[7];
        fArr[14] = 0.0f;
        fArr[15] = fArr2[8];
        return this;
    }
}
