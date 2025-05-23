package com.tencent.qqmusic.mediaplayer;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FloatBufferInfo {
    public int bufferSize;
    public float[] floatBuffer;
    public float[] tempFloatBuffer;

    public void appendFloat(float[] fArr, int i3, int i16) {
        if (fArr != null && i3 >= 0 && i16 > 0 && i3 + i16 <= fArr.length) {
            setFloatBufferCapacity(this.bufferSize + i16);
            System.arraycopy(fArr, i3, this.floatBuffer, this.bufferSize, i16);
        }
    }

    public FloatBufferInfo copy(FloatBufferInfo floatBufferInfo) {
        floatBufferInfo.bufferSize = this.bufferSize;
        floatBufferInfo.floatBuffer = this.floatBuffer;
        floatBufferInfo.tempFloatBuffer = this.tempFloatBuffer;
        return floatBufferInfo;
    }

    public void fillFloat(float[] fArr, int i3) {
        if (fArr != null && i3 > 0 && i3 <= fArr.length) {
            this.floatBuffer = fArr;
            this.bufferSize = i3;
        }
    }

    public void setFloatBufferCapacity(int i3) {
        float[] fArr = this.floatBuffer;
        if (fArr == null || fArr.length < i3) {
            this.floatBuffer = new float[i3];
        }
    }

    public void setTempFloatBufferCapacity(int i3) {
        float[] fArr = this.tempFloatBuffer;
        if (fArr == null || fArr.length < i3) {
            this.tempFloatBuffer = new float[i3];
        }
    }
}
