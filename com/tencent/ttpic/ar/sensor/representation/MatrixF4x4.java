package com.tencent.ttpic.ar.sensor.representation;

import com.tencent.ttpic.baseutils.log.LogUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MatrixF4x4 {
    private boolean colMaj = true;
    public float[] matrix;
    public static final int[] matIndCol9_3x3 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    public static final int[] matIndCol16_3x3 = {0, 1, 2, 4, 5, 6, 8, 9, 10};
    public static final int[] matIndRow9_3x3 = {0, 3, 6, 1, 4, 7, 3, 5, 8};
    public static final int[] matIndRow16_3x3 = {0, 4, 8, 1, 5, 9, 2, 6, 10};
    public static final int[] matIndCol16_4x4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    public static final int[] matIndRow16_4x4 = {0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15};

    public MatrixF4x4() {
        float[] fArr = new float[16];
        this.matrix = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public float[] getMatrix() {
        return this.matrix;
    }

    public boolean isColumnMajor() {
        return this.colMaj;
    }

    public void multiplyMatrix(float[] fArr, int i3, float[] fArr2, int i16) {
        for (int i17 = 0; i17 < 4; i17++) {
            for (int i18 = 0; i18 < 4; i18++) {
                int i19 = i16 + 0 + i18;
                float f16 = fArr2[i19];
                float[] fArr3 = this.matrix;
                int i26 = (i17 * 4) + i18;
                fArr2[i19] = f16 + (fArr3[i26] * fArr[i3 + 0 + i17]);
                int i27 = i16 + 4 + i18;
                fArr2[i27] = fArr2[i27] + (fArr3[i26] * fArr[i3 + 4 + i17]);
                int i28 = i16 + 8 + i18;
                fArr2[i28] = fArr2[i28] + (fArr3[i26] * fArr[i3 + 8 + i17]);
                int i29 = i16 + 12 + i18;
                fArr2[i29] = fArr2[i29] + (fArr3[i26] * fArr[i3 + 12 + i17]);
            }
        }
    }

    public void multiplyMatrix4x4ByMatrix(MatrixF4x4 matrixF4x4) {
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        multiplyMatrix(matrixF4x4.getMatrix(), 0, fArr, 0);
        matrixF4x4.setMatrix(fArr);
    }

    public void multiplyVector3fByMatrix(Vector3f vector3f) {
        float f16;
        float f17;
        if (this.matrix.length == 9) {
            float[] array = vector3f.toArray();
            float f18 = 0.0f;
            if (!this.colMaj) {
                f16 = 0.0f;
                f17 = 0.0f;
                for (int i3 = 0; i3 < 3; i3++) {
                    int i16 = i3 * 3;
                    float[] fArr = this.matrix;
                    float f19 = fArr[i16 + 0];
                    float f26 = array[i3];
                    f18 += f19 * f26;
                    f16 += fArr[i16 + 1] * f26;
                    f17 += fArr[i16 + 2] * f26;
                }
            } else {
                f16 = 0.0f;
                f17 = 0.0f;
                for (int i17 = 0; i17 < 3; i17++) {
                    float[] fArr2 = this.matrix;
                    float f27 = fArr2[i17 + 0];
                    float f28 = array[i17];
                    f18 += f27 * f28;
                    f16 += fArr2[i17 + 3] * f28;
                    f17 += fArr2[i17 + 6] * f28;
                }
            }
            vector3f.setX(f18);
            vector3f.setY(f16);
            vector3f.setZ(f17);
            return;
        }
        LogUtils.e("matrix", "Matrix is invalid, is " + this.matrix.length + " long, this function expects the internal matrix to be of size 9");
    }

    public void multiplyVector4fByMatrix(Vector4f vector4f) {
        float f16;
        float f17;
        float f18;
        if (this.matrix.length == 16) {
            float[] array = vector4f.array();
            int i3 = 0;
            float f19 = 0.0f;
            if (this.colMaj) {
                f16 = 0.0f;
                f17 = 0.0f;
                f18 = 0.0f;
                while (i3 < 4) {
                    int i16 = i3 * 4;
                    float[] fArr = this.matrix;
                    float f26 = fArr[i16 + 0];
                    float f27 = array[i3];
                    f19 += f26 * f27;
                    f16 += fArr[i16 + 1] * f27;
                    f17 += fArr[i16 + 2] * f27;
                    f18 += fArr[i16 + 3] * f27;
                    i3++;
                }
            } else {
                f16 = 0.0f;
                f17 = 0.0f;
                f18 = 0.0f;
                while (i3 < 4) {
                    float[] fArr2 = this.matrix;
                    float f28 = fArr2[i3 + 0];
                    float f29 = array[i3];
                    f19 += f28 * f29;
                    f16 += fArr2[i3 + 4] * f29;
                    f17 += fArr2[i3 + 8] * f29;
                    f18 += fArr2[i3 + 12] * f29;
                    i3++;
                }
            }
            vector4f.setX(f19);
            vector4f.setY(f16);
            vector4f.setZ(f17);
            vector4f.setW(f18);
            return;
        }
        LogUtils.e("matrix", "Matrix is invalid, is " + this.matrix.length + " long, this equation expects a 16 value matrix");
    }

    public void set(MatrixF4x4 matrixF4x4) {
        float[] fArr = matrixF4x4.matrix;
        float[] fArr2 = this.matrix;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
    }

    public void setColumnMajor(boolean z16) {
        this.colMaj = z16;
    }

    public void setMatrix(float[] fArr) {
        if (fArr.length != 16 && fArr.length != 9) {
            throw new IllegalArgumentException("Matrix set is invalid, size is " + fArr.length + " expected 9 or 16");
        }
        this.matrix = fArr;
    }

    public void setW0(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_4x4[12]] = f16;
                return;
            } else {
                fArr[matIndRow16_4x4[12]] = f16;
                return;
            }
        }
        throw new IllegalStateException("length of matrix should be 16");
    }

    public void setW1(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_4x4[13]] = f16;
                return;
            } else {
                fArr[matIndRow16_4x4[13]] = f16;
                return;
            }
        }
        throw new IllegalStateException("length of matrix should be 16");
    }

    public void setW2(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_4x4[14]] = f16;
                return;
            } else {
                fArr[matIndRow16_4x4[14]] = f16;
                return;
            }
        }
        throw new IllegalStateException("length of matrix should be 16");
    }

    public void setW3(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_4x4[15]] = f16;
                return;
            } else {
                fArr[matIndRow16_4x4[15]] = f16;
                return;
            }
        }
        throw new IllegalStateException("length of matrix should be 16");
    }

    public void setX0(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_3x3[0]] = f16;
                return;
            } else {
                fArr[matIndRow16_3x3[0]] = f16;
                return;
            }
        }
        if (this.colMaj) {
            fArr[matIndCol9_3x3[0]] = f16;
        } else {
            fArr[matIndRow9_3x3[0]] = f16;
        }
    }

    public void setX1(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_3x3[1]] = f16;
                return;
            } else {
                fArr[matIndRow16_3x3[1]] = f16;
                return;
            }
        }
        if (this.colMaj) {
            fArr[matIndCol9_3x3[1]] = f16;
        } else {
            fArr[matIndRow9_3x3[1]] = f16;
        }
    }

    public void setX2(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_3x3[2]] = f16;
                return;
            } else {
                fArr[matIndRow16_3x3[2]] = f16;
                return;
            }
        }
        if (this.colMaj) {
            fArr[matIndCol9_3x3[2]] = f16;
        } else {
            fArr[matIndRow9_3x3[2]] = f16;
        }
    }

    public void setX3(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_4x4[3]] = f16;
                return;
            } else {
                fArr[matIndRow16_4x4[3]] = f16;
                return;
            }
        }
        throw new IllegalStateException("length of matrix should be 16");
    }

    public void setY0(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_3x3[3]] = f16;
                return;
            } else {
                fArr[matIndRow16_3x3[3]] = f16;
                return;
            }
        }
        if (this.colMaj) {
            fArr[matIndCol9_3x3[3]] = f16;
        } else {
            fArr[matIndRow9_3x3[3]] = f16;
        }
    }

    public void setY1(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_3x3[4]] = f16;
                return;
            } else {
                fArr[matIndRow16_3x3[4]] = f16;
                return;
            }
        }
        if (this.colMaj) {
            fArr[matIndCol9_3x3[4]] = f16;
        } else {
            fArr[matIndRow9_3x3[4]] = f16;
        }
    }

    public void setY2(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_3x3[5]] = f16;
                return;
            } else {
                fArr[matIndRow16_3x3[5]] = f16;
                return;
            }
        }
        if (this.colMaj) {
            fArr[matIndCol9_3x3[5]] = f16;
        } else {
            fArr[matIndRow9_3x3[5]] = f16;
        }
    }

    public void setY3(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_4x4[7]] = f16;
                return;
            } else {
                fArr[matIndRow16_4x4[7]] = f16;
                return;
            }
        }
        throw new IllegalStateException("length of matrix should be 16");
    }

    public void setZ0(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_3x3[6]] = f16;
                return;
            } else {
                fArr[matIndRow16_3x3[6]] = f16;
                return;
            }
        }
        if (this.colMaj) {
            fArr[matIndCol9_3x3[6]] = f16;
        } else {
            fArr[matIndRow9_3x3[6]] = f16;
        }
    }

    public void setZ1(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_3x3[7]] = f16;
                return;
            } else {
                fArr[matIndRow16_3x3[7]] = f16;
                return;
            }
        }
        if (this.colMaj) {
            fArr[matIndCol9_3x3[7]] = f16;
        } else {
            fArr[matIndRow9_3x3[7]] = f16;
        }
    }

    public void setZ2(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_3x3[8]] = f16;
                return;
            } else {
                fArr[matIndRow16_3x3[8]] = f16;
                return;
            }
        }
        if (this.colMaj) {
            fArr[matIndCol9_3x3[8]] = f16;
        } else {
            fArr[matIndRow9_3x3[8]] = f16;
        }
    }

    public void setZ3(float f16) {
        float[] fArr = this.matrix;
        if (fArr.length == 16) {
            if (this.colMaj) {
                fArr[matIndCol16_4x4[11]] = f16;
                return;
            } else {
                fArr[matIndRow16_4x4[11]] = f16;
                return;
            }
        }
        throw new IllegalStateException("length of matrix should be 16");
    }

    public int size() {
        return this.matrix.length;
    }

    public void transpose() {
        int i3 = 0;
        if (this.matrix.length == 16) {
            float[] fArr = new float[16];
            while (i3 < 4) {
                int i16 = i3 * 4;
                float[] fArr2 = this.matrix;
                fArr[i16] = fArr2[i3];
                fArr[i16 + 1] = fArr2[i3 + 4];
                fArr[i16 + 2] = fArr2[i3 + 8];
                fArr[i16 + 3] = fArr2[i3 + 12];
                i3++;
            }
            this.matrix = fArr;
            return;
        }
        float[] fArr3 = new float[9];
        while (i3 < 3) {
            int i17 = i3 * 3;
            float[] fArr4 = this.matrix;
            fArr3[i17] = fArr4[i3];
            fArr3[i17 + 1] = fArr4[i3 + 3];
            fArr3[i17 + 2] = fArr4[i3 + 6];
            i3++;
        }
        this.matrix = fArr3;
    }
}
