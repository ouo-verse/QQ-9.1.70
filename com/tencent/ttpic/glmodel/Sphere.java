package com.tencent.ttpic.glmodel;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.math.Math;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Sphere {
    private static final int AMOUNT_OF_NUMBERS_PER_TEXTURE_POINT = 2;
    private static final int AMOUNT_OF_NUMBERS_PER_VERTEX_POINT = 3;
    private static final int MAXIMUM_ALLOWED_DEPTH = 5;
    private static final int NUM_FLOATS_PER_TEXTURE = 2;
    private static final int NUM_FLOATS_PER_VERTEX = 3;
    private static final int PER_FLOAT_BYTE = 4;
    private static final int VERTEX_MAGIC_NUMBER = 5;
    private final int mTotalNumStrips;
    private final List<FloatBuffer> mVertexBuffer = new ArrayList();
    private final List<float[]> mColors = new ArrayList();
    private final List<FloatBuffer> mColorBuffer = new ArrayList();
    private final List<float[]> mVertices = new ArrayList();
    private final List<FloatBuffer> mTextureBuffer = new ArrayList();
    private final int[] mTextures = new int[1];

    public Sphere(int i3, float f16) {
        int max = Math.max(1, Math.min(5, i3));
        int power = Math.power(2, max - 1) * 5;
        this.mTotalNumStrips = power;
        int power2 = Math.power(2, max) * 3;
        double power3 = 2.0943951023931953d / Math.power(2, max);
        long j3 = 4618760256179416344L;
        double d16 = 6.283185307179586d / power;
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        while (i16 < this.mTotalNumStrips) {
            int i17 = power2 * 3;
            float[] fArr = new float[i17];
            int i18 = power2 * 2;
            float[] fArr2 = new float[i18];
            float[] fArr3 = new float[i17];
            double d17 = power3;
            double d18 = i16 * d16;
            double d19 = 1.5707963267948966d;
            int i19 = 0;
            int i26 = 0;
            int i27 = 0;
            while (i19 < power2) {
                ArrayList arrayList2 = arrayList;
                int i28 = power2;
                double d26 = f16;
                double sin = d26 * Math.sin(d19);
                double cos = Math.cos(d19) * d26;
                double sin2 = cos * Math.sin(d18);
                double d27 = d16;
                double cos2 = cos * Math.cos(d18);
                int i29 = i18;
                int i36 = this.mTotalNumStrips;
                int i37 = i17;
                int i38 = i19;
                float f17 = i16;
                fArr3[i26] = (1.0f / i36) * f17;
                int i39 = i26 + 1;
                fArr[i26] = (float) cos2;
                fArr3[i39] = (1.0f / i36) * f17;
                int i46 = i39 + 1;
                fArr[i39] = (float) sin;
                fArr3[i46] = (1.0f / i36) * f17;
                int i47 = i46 + 1;
                fArr[i46] = (float) sin2;
                int i48 = i27 + 1;
                fArr2[i27] = (float) (1.0d - (d18 / 6.283185307179586d));
                int i49 = i48 + 1;
                fArr2[i48] = (float) (1.0d - ((d19 + 1.5707963267948966d) / 3.141592653589793d));
                d19 -= d17;
                double d28 = d18 - (d27 / 2.0d);
                double sin3 = Math.sin(d19) * d26;
                double cos3 = d26 * Math.cos(d19);
                double sin4 = cos3 * Math.sin(d28);
                double cos4 = cos3 * Math.cos(d28);
                int i56 = this.mTotalNumStrips;
                fArr3[i47] = (1.0f / i56) * f17;
                int i57 = i47 + 1;
                fArr[i47] = (float) cos4;
                fArr3[i57] = (1.0f / i56) * f17;
                int i58 = i57 + 1;
                fArr[i57] = (float) sin3;
                fArr3[i58] = (1.0f / i56) * f17;
                fArr[i58] = (float) sin4;
                int i59 = i49 + 1;
                fArr2[i49] = (float) (1.0d - (d28 / 6.283185307179586d));
                i27 = i59 + 1;
                fArr2[i59] = (float) (1.0d - ((d19 + 1.5707963267948966d) / 3.141592653589793d));
                d18 = d28 + d27;
                i16 = i16;
                j3 = 4618760256179416344L;
                i26 = i58 + 1;
                arrayList = arrayList2;
                i18 = i29;
                i17 = i37;
                d16 = d27;
                i19 = i38 + 2;
                power2 = i28;
            }
            ArrayList arrayList3 = arrayList;
            int i65 = i16;
            this.mVertices.add(fArr);
            this.mColors.add(fArr3);
            arrayList3.add(fArr2);
            int i66 = i17 * 32;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i66);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(this.mVertices.get(i65));
            asFloatBuffer.position(0);
            this.mVertexBuffer.add(asFloatBuffer);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i66);
            allocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
            asFloatBuffer2.put(this.mColors.get(i65));
            asFloatBuffer2.position(0);
            this.mColorBuffer.add(asFloatBuffer2);
            ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(i18 * 32);
            allocateDirect3.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer3 = allocateDirect3.asFloatBuffer();
            asFloatBuffer3.put((float[]) arrayList3.get(i65));
            asFloatBuffer3.position(0);
            this.mTextureBuffer.add(asFloatBuffer3);
            i16 = i65 + 1;
            arrayList = arrayList3;
            power3 = d17;
            power2 = power2;
            d16 = d16;
        }
    }

    public void draw(GL10 gl10) {
        gl10.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mTextures[0]);
        gl10.glEnableClientState(32884);
        gl10.glEnableClientState(32888);
        gl10.glFrontFace(2304);
        for (int i3 = 0; i3 < this.mTotalNumStrips; i3++) {
            gl10.glVertexPointer(3, 5126, 0, this.mVertexBuffer.get(i3));
            gl10.glTexCoordPointer(2, 5126, 0, this.mTextureBuffer.get(i3));
            gl10.glDrawArrays(5, 0, this.mVertices.get(i3).length / 3);
        }
        gl10.glDisableClientState(32884);
        gl10.glDisableClientState(32888);
    }

    public void loadGLTexture(Bitmap bitmap) {
        int[] iArr = this.mTextures;
        if (iArr[0] <= 0) {
            GLES20.glGenTextures(1, iArr, 0);
        }
        if (BitmapUtils.isLegal(bitmap)) {
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mTextures[0]);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
        }
    }

    public void draw(int i3, int i16, int i17, int i18) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mTextures[0]);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glUniform1i(i18, 0);
        GLES20.glEnableVertexAttribArray(i3);
        GLES20.glEnableVertexAttribArray(i16);
        GLES20.glFrontFace(2304);
        for (int i19 = 0; i19 < this.mTotalNumStrips; i19++) {
            GLES20.glVertexAttribPointer(i3, 3, 5126, false, 12, (Buffer) this.mVertexBuffer.get(i19));
            GLES20.glVertexAttribPointer(i17, 2, 5126, false, 8, (Buffer) this.mColorBuffer.get(i19));
            GLES20.glVertexAttribPointer(i16, 2, 5126, false, 8, (Buffer) this.mTextureBuffer.get(i19));
            GLES20.glDrawArrays(5, 0, this.mVertices.get(i19).length / 3);
        }
        GLES20.glFinish();
    }
}
