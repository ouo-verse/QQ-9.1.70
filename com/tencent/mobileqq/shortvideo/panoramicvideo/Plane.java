package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.panoramicvideo.utils.BufferUtils;
import com.tencent.mobileqq.shortvideo.panoramicvideo.utils.PlaneTextureRotationUtil;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: classes18.dex */
public class Plane {
    private final float[] TRIANGLES_DATA_CW;
    private FloatBuffer mTexCoordinateBuffer;
    private FloatBuffer mVerticesBuffer;

    public Plane(boolean z16) {
        float[] fArr = {-1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
        this.TRIANGLES_DATA_CW = fArr;
        this.mVerticesBuffer = BufferUtils.getFloatBuffer(fArr, 0);
        if (z16) {
            this.mTexCoordinateBuffer = BufferUtils.getFloatBuffer(PlaneTextureRotationUtil.getRotation(0, false, true), 0);
        } else {
            this.mTexCoordinateBuffer = BufferUtils.getFloatBuffer(PlaneTextureRotationUtil.TEXTURE_NO_ROTATION, 0);
        }
    }

    public void draw() {
        GLES20.glDrawArrays(5, 0, 4);
    }

    public FloatBuffer getTexCoordinateBuffer() {
        return this.mTexCoordinateBuffer;
    }

    public FloatBuffer getVerticesBuffer() {
        return this.mVerticesBuffer;
    }

    public Plane resetTrianglesDataWithRect(RectF rectF) {
        float[] fArr = this.TRIANGLES_DATA_CW;
        float f16 = rectF.left;
        fArr[0] = f16;
        float f17 = rectF.bottom;
        fArr[1] = f17;
        fArr[3] = f16;
        float f18 = rectF.top;
        fArr[4] = f18;
        float f19 = rectF.right;
        fArr[6] = f19;
        fArr[7] = f17;
        fArr[9] = f19;
        fArr[10] = f18;
        this.mVerticesBuffer = BufferUtils.getFloatBuffer(fArr, 0);
        return this;
    }

    public Plane scale(float f16) {
        float[] fArr = this.TRIANGLES_DATA_CW;
        int length = fArr.length;
        float[] fArr2 = new float[length];
        System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
        for (int i3 = 0; i3 < length; i3++) {
            fArr2[i3] = fArr2[i3] * f16;
        }
        this.mVerticesBuffer = BufferUtils.getFloatBuffer(fArr2, 0);
        return this;
    }

    public void setTexCoordinateBuffer(FloatBuffer floatBuffer) {
        this.mTexCoordinateBuffer = floatBuffer;
    }

    public void setVerticesBuffer(FloatBuffer floatBuffer) {
        this.mVerticesBuffer = floatBuffer;
    }

    public void uploadTexCoordinateBuffer(int i3) {
        FloatBuffer texCoordinateBuffer = getTexCoordinateBuffer();
        if (texCoordinateBuffer == null) {
            return;
        }
        texCoordinateBuffer.position(0);
        GLES20.glVertexAttribPointer(i3, 2, 5126, false, 0, (Buffer) texCoordinateBuffer);
        GlUtil.checkGlError("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(i3);
        GlUtil.checkGlError("glEnableVertexAttribArray maTextureHandle");
    }

    public void uploadVerticesBuffer(int i3) {
        FloatBuffer verticesBuffer = getVerticesBuffer();
        if (verticesBuffer == null) {
            return;
        }
        verticesBuffer.position(0);
        GLES20.glVertexAttribPointer(i3, 3, 5126, false, 0, (Buffer) verticesBuffer);
        GlUtil.checkGlError("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(i3);
        GlUtil.checkGlError("glEnableVertexAttribArray maPositionHandle");
    }
}
