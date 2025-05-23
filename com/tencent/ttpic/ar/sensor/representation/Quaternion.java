package com.tencent.ttpic.ar.sensor.representation;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Quaternion extends Vector4f {
    private Quaternion tmpQuaternion;
    private boolean dirty = false;
    private Vector4f tmpVector = new Vector4f();
    private MatrixF4x4 matrix = new MatrixF4x4();

    public Quaternion() {
        loadIdentityQuat();
    }

    private void convertQuatToMatrix() {
        float[] fArr = this.points;
        float f16 = fArr[0];
        float f17 = fArr[1];
        float f18 = fArr[2];
        float f19 = fArr[3];
        float f26 = f17 * f17 * 2.0f;
        float f27 = f18 * f18 * 2.0f;
        this.matrix.setX0((1.0f - f26) - f27);
        float f28 = f16 * f17 * 2.0f;
        float f29 = f19 * f18 * 2.0f;
        this.matrix.setX1(f28 + f29);
        float f36 = f16 * f18 * 2.0f;
        float f37 = f19 * f17 * 2.0f;
        this.matrix.setX2(f36 - f37);
        this.matrix.setX3(0.0f);
        this.matrix.setY0(f28 - f29);
        float f38 = 1.0f - ((f16 * f16) * 2.0f);
        this.matrix.setY1(f38 - f27);
        float f39 = f17 * f18 * 2.0f;
        float f46 = f19 * f16 * 2.0f;
        this.matrix.setY2(f39 + f46);
        this.matrix.setY3(0.0f);
        this.matrix.setZ0(f36 + f37);
        this.matrix.setZ1(f39 - f46);
        this.matrix.setZ2(f38 - f26);
        this.matrix.setZ3(0.0f);
        this.matrix.setW0(0.0f);
        this.matrix.setW1(0.0f);
        this.matrix.setW2(0.0f);
        this.matrix.setW3(1.0f);
    }

    private void generateQuaternionFromMatrix() {
        int[] iArr;
        boolean z16;
        float f16;
        float f17;
        float f18;
        float f19;
        float sqrt;
        float f26;
        float f27;
        float f28;
        float f29;
        float f36;
        float[] matrix = this.matrix.getMatrix();
        if (this.matrix.size() == 16) {
            if (this.matrix.isColumnMajor()) {
                iArr = MatrixF4x4.matIndCol16_3x3;
            } else {
                iArr = MatrixF4x4.matIndRow16_3x3;
            }
        } else if (this.matrix.isColumnMajor()) {
            iArr = MatrixF4x4.matIndCol9_3x3;
        } else {
            iArr = MatrixF4x4.matIndRow9_3x3;
        }
        boolean z17 = false;
        int i3 = iArr[0];
        int i16 = iArr[1];
        int i17 = iArr[2];
        int i18 = iArr[3];
        int i19 = iArr[4];
        int i26 = iArr[5];
        int i27 = iArr[6];
        int i28 = iArr[7];
        int i29 = iArr[8];
        float f37 = matrix[i3];
        float f38 = matrix[i19];
        float f39 = matrix[i29];
        float f46 = f37 + f38 + f39;
        if (f46 > 0.0f) {
            float sqrt2 = ((float) Math.sqrt(f46 + 1.0d)) * 2.0f;
            f17 = 0.25f * sqrt2;
            f18 = (matrix[i28] - matrix[i26]) / sqrt2;
            f19 = (matrix[i17] - matrix[i27]) / sqrt2;
            f16 = (matrix[i18] - matrix[i16]) / sqrt2;
        } else {
            if (f37 > f38) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (f37 > f39) {
                z17 = true;
            }
            if (z17 & z16) {
                sqrt = ((float) Math.sqrt(((f37 + 1.0d) - f38) - f39)) * 2.0f;
                f26 = (matrix[i28] - matrix[i26]) / sqrt;
                f27 = sqrt * 0.25f;
                f28 = (matrix[i16] + matrix[i18]) / sqrt;
                f29 = matrix[i17];
                f36 = matrix[i27];
            } else if (f38 > f39) {
                sqrt = ((float) Math.sqrt(((f38 + 1.0d) - f37) - f39)) * 2.0f;
                f26 = (matrix[i17] - matrix[i27]) / sqrt;
                f27 = (matrix[i16] + matrix[i18]) / sqrt;
                f28 = sqrt * 0.25f;
                f29 = matrix[i26];
                f36 = matrix[i28];
            } else {
                float sqrt3 = ((float) Math.sqrt(((f39 + 1.0d) - f37) - f38)) * 2.0f;
                float f47 = (matrix[i18] - matrix[i16]) / sqrt3;
                f16 = sqrt3 * 0.25f;
                f17 = f47;
                f18 = (matrix[i17] + matrix[i27]) / sqrt3;
                f19 = (matrix[i26] + matrix[i28]) / sqrt3;
            }
            f17 = f26;
            f18 = f27;
            f19 = f28;
            f16 = (f29 + f36) / sqrt;
        }
        setX(f18);
        setY(f19);
        setZ(f16);
        setW(f17);
    }

    public void addQuat(Quaternion quaternion) {
        this.dirty = true;
        addQuat(quaternion, this);
    }

    public void copyFromVec3(Vector3f vector3f, float f16) {
        copyFromV3f(vector3f, f16);
    }

    public MatrixF4x4 getMatrix4x4() {
        if (this.dirty) {
            convertQuatToMatrix();
            this.dirty = false;
        }
        return this.matrix;
    }

    public void loadIdentityQuat() {
        this.dirty = true;
        setX(0.0f);
        setY(0.0f);
        setZ(0.0f);
        setW(1.0f);
    }

    public void multiplyByQuat(Quaternion quaternion, Quaternion quaternion2) {
        if (quaternion != quaternion2) {
            float[] fArr = quaternion2.points;
            float[] fArr2 = this.points;
            float f16 = fArr2[3];
            float[] fArr3 = quaternion.points;
            float f17 = f16 * fArr3[3];
            float f18 = fArr2[0];
            float f19 = fArr3[0];
            float f26 = fArr2[1];
            float f27 = fArr3[1];
            float f28 = fArr2[2];
            float f29 = fArr3[2];
            fArr[3] = ((f17 - (f18 * f19)) - (f26 * f27)) - (f28 * f29);
            float f36 = fArr2[3];
            float f37 = fArr3[3];
            fArr[0] = (((f19 * f36) + (f18 * f37)) + (f26 * f29)) - (f28 * f27);
            float f38 = fArr3[0];
            float f39 = fArr2[0];
            fArr[1] = (((f27 * f36) + (f26 * f37)) + (f28 * f38)) - (f39 * f29);
            fArr[2] = (((f36 * f29) + (f28 * f37)) + (f39 * fArr3[1])) - (fArr2[1] * f38);
            return;
        }
        float[] fArr4 = this.tmpVector.points;
        float[] fArr5 = quaternion.points;
        float f46 = fArr5[0];
        fArr4[0] = f46;
        float f47 = fArr5[1];
        fArr4[1] = f47;
        float f48 = fArr5[2];
        fArr4[2] = f48;
        float f49 = fArr5[3];
        fArr4[3] = f49;
        float[] fArr6 = quaternion2.points;
        float[] fArr7 = this.points;
        float f56 = fArr7[3] * f49;
        float f57 = fArr7[0];
        float f58 = fArr7[1];
        float f59 = fArr7[2];
        fArr6[3] = ((f56 - (f57 * f46)) - (f58 * f47)) - (f59 * f48);
        float f65 = fArr7[3];
        float f66 = fArr4[3];
        fArr6[0] = (((f46 * f65) + (f57 * f66)) + (f58 * f48)) - (f59 * f47);
        float f67 = fArr4[0];
        float f68 = fArr7[0];
        fArr6[1] = (((f47 * f65) + (f58 * f66)) + (f59 * f67)) - (f68 * f48);
        fArr6[2] = (((f65 * f48) + (f59 * f66)) + (f68 * fArr4[1])) - (fArr7[1] * f67);
    }

    @Override // com.tencent.ttpic.ar.sensor.representation.Vector4f
    public void multiplyByScalar(float f16) {
        this.dirty = true;
        multiplyByScalar(f16);
    }

    public void normalise() {
        this.dirty = true;
        float[] fArr = this.points;
        float f16 = fArr[3];
        float f17 = fArr[0];
        float f18 = (f16 * f16) + (f17 * f17);
        float f19 = fArr[1];
        float f26 = fArr[2];
        float sqrt = (float) Math.sqrt(f18 + (f19 * f19) + (f26 * f26));
        float[] fArr2 = this.points;
        fArr2[3] = fArr2[3] / sqrt;
        fArr2[0] = fArr2[0] / sqrt;
        fArr2[1] = fArr2[1] / sqrt;
        fArr2[2] = fArr2[2] / sqrt;
    }

    @Override // com.tencent.ttpic.ar.sensor.representation.Vector4f
    public void normalize() {
        normalise();
    }

    public void set(Quaternion quaternion) {
        this.dirty = true;
        copyVec4(quaternion);
    }

    public void setAxisAngle(Vector3f vector3f, float f16) {
        double d16 = f16 / 2.0f;
        float sin = (float) Math.sin(Math.toRadians(d16));
        setX(vector3f.getX() * sin);
        setY(vector3f.getY() * sin);
        setZ(vector3f.getZ() * sin);
        setW((float) Math.cos(Math.toRadians(d16)));
        this.dirty = true;
    }

    public void setAxisAngleRad(Vector3f vector3f, double d16) {
        float f16 = (float) (d16 / 2.0d);
        setX(vector3f.getX() * f16);
        setY(vector3f.getY() * f16);
        setZ(vector3f.getZ() * f16);
        setW(((float) d16) / 2.0f);
        this.dirty = true;
    }

    public void setColumnMajor(float[] fArr) {
        this.matrix.setMatrix(fArr);
        this.matrix.setColumnMajor(true);
        generateQuaternionFromMatrix();
    }

    public void setEulerAngle(float f16, float f17, float f18) {
        double radians = Math.toRadians(f18);
        double radians2 = Math.toRadians(f17);
        double radians3 = Math.toRadians(f16);
        double d16 = radians / 2.0d;
        double cos = Math.cos(d16);
        double sin = Math.sin(d16);
        double d17 = radians2 / 2.0d;
        double cos2 = Math.cos(d17);
        double sin2 = Math.sin(d17);
        double d18 = radians3 / 2.0d;
        double cos3 = Math.cos(d18);
        double sin3 = Math.sin(d18);
        double d19 = cos * cos2;
        double d26 = sin * sin2;
        setW((float) ((d19 * cos3) - (d26 * sin3)));
        setX((float) ((d19 * sin3) + (d26 * cos3)));
        double d27 = sin * cos2;
        double d28 = cos * sin2;
        setY((float) ((d27 * cos3) + (d28 * sin3)));
        setZ((float) ((d28 * cos3) - (d27 * sin3)));
        this.dirty = true;
    }

    public void setRowMajor(float[] fArr) {
        this.matrix.setMatrix(fArr);
        this.matrix.setColumnMajor(false);
        generateQuaternionFromMatrix();
    }

    public void slerp(Quaternion quaternion, Quaternion quaternion2, float f16) {
        float dotProduct = dotProduct(quaternion);
        if (dotProduct < 0.0f) {
            if (this.tmpQuaternion == null) {
                this.tmpQuaternion = new Quaternion();
            }
            Quaternion quaternion3 = this.tmpQuaternion;
            dotProduct = -dotProduct;
            float[] fArr = quaternion3.points;
            float[] fArr2 = quaternion.points;
            fArr[0] = -fArr2[0];
            fArr[1] = -fArr2[1];
            fArr[2] = -fArr2[2];
            fArr[3] = -fArr2[3];
            quaternion = quaternion3;
        }
        if (Math.abs(dotProduct) >= 1.0d) {
            float[] fArr3 = quaternion2.points;
            float[] fArr4 = this.points;
            fArr3[0] = fArr4[0];
            fArr3[1] = fArr4[1];
            fArr3[2] = fArr4[2];
            fArr3[3] = fArr4[3];
            return;
        }
        double sqrt = Math.sqrt(1.0d - (dotProduct * dotProduct));
        double acos = Math.acos(dotProduct);
        double sin = Math.sin((1.0f - f16) * acos) / sqrt;
        double sin2 = Math.sin(f16 * acos) / sqrt;
        float[] fArr5 = quaternion2.points;
        float[] fArr6 = this.points;
        float[] fArr7 = quaternion.points;
        fArr5[3] = (float) ((fArr6[3] * sin) + (fArr7[3] * sin2));
        fArr5[0] = (float) ((fArr6[0] * sin) + (fArr7[0] * sin2));
        fArr5[1] = (float) ((fArr6[1] * sin) + (fArr7[1] * sin2));
        fArr5[2] = (float) ((fArr6[2] * sin) + (fArr7[2] * sin2));
    }

    public void subQuat(Quaternion quaternion) {
        this.dirty = true;
        subQuat(quaternion, this);
    }

    public void toAxisAngle(Vector4f vector4f) {
        float f16;
        float f17;
        float f18;
        if (getW() > 1.0f) {
            normalise();
        }
        float degrees = ((float) Math.toDegrees(Math.acos(getW()))) * 2.0f;
        float sqrt = (float) Math.sqrt(1.0f - (getW() * getW()));
        if (sqrt < 0.001d) {
            float[] fArr = this.points;
            f17 = fArr[0];
            f18 = fArr[1];
            f16 = fArr[2];
        } else {
            float[] fArr2 = this.points;
            float f19 = fArr2[0] / sqrt;
            float f26 = fArr2[1] / sqrt;
            f16 = fArr2[2] / sqrt;
            f17 = f19;
            f18 = f26;
        }
        float[] fArr3 = vector4f.points;
        fArr3[0] = f17;
        fArr3[1] = f18;
        fArr3[2] = f16;
        fArr3[3] = degrees;
    }

    public double[] toEulerAngles() {
        float w3 = this.points[1] * 2.0f * getW();
        float[] fArr = this.points;
        double d16 = w3 - ((fArr[0] * 2.0f) * fArr[2]);
        float f16 = fArr[1];
        float[] fArr2 = this.points;
        float w16 = this.points[0] * 2.0f * getW();
        float[] fArr3 = this.points;
        float f17 = fArr3[1] * 2.0f;
        float f18 = fArr3[2];
        float f19 = fArr3[0];
        return new double[]{Math.atan2(d16, (1.0f - ((f16 * f16) * 2.0f)) - ((r8 * r8) * 2.0f)), Math.asin((fArr2[0] * 2.0f * fArr2[1]) + (fArr2[2] * 2.0f * getW())), Math.atan2(w16 - (f17 * f18), (1.0f - ((f19 * f19) * 2.0f)) - ((f18 * f18) * 2.0f))};
    }

    @Override // com.tencent.ttpic.ar.sensor.representation.Vector4f
    public String toString() {
        return "{X: " + getX() + ", Y:" + getY() + ", Z:" + getZ() + ", W:" + getW() + "}";
    }

    public void addQuat(Quaternion quaternion, Quaternion quaternion2) {
        quaternion2.setX(getX() + quaternion.getX());
        quaternion2.setY(getY() + quaternion.getY());
        quaternion2.setZ(getZ() + quaternion.getZ());
        quaternion2.setW(getW() + quaternion.getW());
    }

    public void subQuat(Quaternion quaternion, Quaternion quaternion2) {
        quaternion2.setX(getX() - quaternion.getX());
        quaternion2.setY(getY() - quaternion.getY());
        quaternion2.setZ(getZ() - quaternion.getZ());
        quaternion2.setW(getW() - quaternion.getW());
    }

    public void multiplyByQuat(Quaternion quaternion) {
        this.dirty = true;
        if (this.tmpQuaternion == null) {
            this.tmpQuaternion = new Quaternion();
        }
        this.tmpQuaternion.copyVec4(this);
        multiplyByQuat(quaternion, this.tmpQuaternion);
        copyVec4(this.tmpQuaternion);
    }
}
