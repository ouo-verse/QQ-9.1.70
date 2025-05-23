package com.tencent.mobileqq.shortvideo.panoramicvideo.utils;

import android.opengl.Matrix;

/* compiled from: P */
/* loaded from: classes18.dex */
public class OrientationHelper {
    public static final int IGNORE_ROTATION_AXIS_X = 8;
    public static final int IGNORE_ROTATION_AXIS_Y = 16;
    public static final int IGNORE_ROTATION_AXIS_Z = 32;
    public static final int IGNORE_ROTATION_NONE = 0;
    public static final int LOCK_MODE_ALL_AXIS = 7;
    public static final int LOCK_MODE_AXIS_X = 1;
    public static final int LOCK_MODE_AXIS_Y = 2;
    public static final int LOCK_MODE_AXIS_Z = 4;
    public static final int LOCK_MODE_NONE = 0;
    private static final String TAG = "OrientationHelper";
    private float[] initialRotation = new float[3];
    private float[] currentRotation = new float[3];
    float[] tmp = new float[16];
    private int lockAxisMode = 0;
    private int ignoreRotationMode = 0;
    private boolean rotationRecorded = false;

    private void convertToDegrees(float[] fArr) {
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = (float) Math.toDegrees(fArr[i3]);
        }
    }

    public float[] getCurrentRotation() {
        return this.currentRotation;
    }

    public int getIgnoreRotationMode() {
        return this.ignoreRotationMode;
    }

    public int getLockAxisMode() {
        return this.lockAxisMode;
    }

    public void recordRotation(float[] fArr) {
        if (!this.rotationRecorded) {
            Matrix.transposeM(this.tmp, 0, fArr, 0);
            SensorUtil.getOrientationFromRotationMatrix(this.tmp, this.initialRotation);
            convertToDegrees(this.initialRotation);
            this.rotationRecorded = true;
            return;
        }
        Matrix.transposeM(this.tmp, 0, fArr, 0);
        SensorUtil.getOrientationFromRotationMatrix(this.tmp, this.currentRotation);
        convertToDegrees(this.currentRotation);
    }

    public void revertRotation(float[] fArr) {
        float f16;
        float f17;
        if (this.lockAxisMode == 0 && this.ignoreRotationMode == 0) {
            return;
        }
        if (this.ignoreRotationMode != 0) {
            Matrix.setIdentityM(this.tmp, 0);
            if ((this.ignoreRotationMode & 32) == 0) {
                Matrix.rotateM(this.tmp, 0, -this.currentRotation[0], 0.0f, 0.0f, 1.0f);
            }
            if ((this.ignoreRotationMode & 8) == 0) {
                Matrix.rotateM(this.tmp, 0, -this.currentRotation[1], 1.0f, 0.0f, 0.0f);
            }
            if ((this.ignoreRotationMode & 16) == 0) {
                Matrix.rotateM(this.tmp, 0, this.currentRotation[2], 0.0f, 1.0f, 0.0f);
            }
            System.arraycopy(this.tmp, 0, fArr, 0, 16);
            Matrix.transposeM(this.tmp, 0, fArr, 0);
            SensorUtil.getOrientationFromRotationMatrix(this.tmp, this.currentRotation);
            convertToDegrees(this.currentRotation);
        }
        if (this.lockAxisMode != 0) {
            Matrix.setIdentityM(this.tmp, 0);
            int i3 = this.lockAxisMode;
            float f18 = 0.0f;
            if ((i3 & 4) != 0) {
                f16 = this.initialRotation[0];
            } else {
                f16 = 0.0f;
            }
            if ((i3 & 1) != 0) {
                f17 = this.initialRotation[1];
            } else {
                f17 = 0.0f;
            }
            if ((i3 & 2) != 0) {
                f18 = -this.initialRotation[2];
            }
            Matrix.rotateM(this.tmp, 0, (-this.currentRotation[0]) + f16, 0.0f, 0.0f, 1.0f);
            Matrix.rotateM(this.tmp, 0, (-this.currentRotation[1]) + f17, 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(this.tmp, 0, this.currentRotation[2] + f18, 0.0f, 1.0f, 0.0f);
            System.arraycopy(this.tmp, 0, fArr, 0, 16);
            Matrix.transposeM(this.tmp, 0, fArr, 0);
            SensorUtil.getOrientationFromRotationMatrix(this.tmp, this.currentRotation);
            convertToDegrees(this.currentRotation);
        }
    }

    public void setIgnoreRotationMode(int i3) {
        this.ignoreRotationMode = i3;
    }

    public void setLockAxisMode(int i3) {
        this.lockAxisMode = i3;
    }

    public void setRotationRecorded(boolean z16) {
        this.rotationRecorded = z16;
    }
}
