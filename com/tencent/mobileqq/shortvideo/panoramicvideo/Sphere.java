package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class Sphere {
    private static final int sPositionDataSize = 3;
    private static final int sTextureCoordinateDataSize = 2;
    private ShortBuffer indexBuffer;
    private int mNumIndices;
    private FloatBuffer mTexCoordinateBuffer;
    private FloatBuffer mVerticesBuffer;

    public Sphere(float f16, int i3, int i16) {
        float f17 = 1.0f / i3;
        float f18 = 1.0f / i16;
        int i17 = i3 + 1;
        int i18 = i16 + 1;
        int i19 = i17 * i18;
        int i26 = i19 * 3;
        float[] fArr = new float[i26];
        int i27 = i19 * 2;
        float[] fArr2 = new float[i27];
        int i28 = i19 * 6;
        short[] sArr = new short[i28];
        short s16 = 0;
        int i29 = 0;
        int i36 = 0;
        while (s16 < i17) {
            short s17 = 0;
            while (s17 < i18) {
                int i37 = i17;
                float f19 = s17;
                int i38 = i28;
                double d16 = 6.2831855f * f19 * f18;
                float f26 = s16;
                int i39 = i27;
                double d17 = 3.1415927f * f26 * f17;
                short[] sArr2 = sArr;
                float cos = (float) (Math.cos(d16) * Math.sin(d17));
                float sin = (float) Math.sin(r10 - 1.5707964f);
                float sin2 = (float) (Math.sin(d16) * Math.sin(d17));
                int i46 = i29 + 1;
                fArr2[i29] = f19 * f18;
                i29 = i46 + 1;
                fArr2[i46] = f26 * f17;
                int i47 = i36 + 1;
                fArr[i36] = cos * f16;
                int i48 = i47 + 1;
                fArr[i47] = sin * f16;
                i36 = i48 + 1;
                fArr[i48] = sin2 * f16;
                s17 = (short) (s17 + 1);
                i17 = i37;
                i26 = i26;
                i28 = i38;
                s16 = s16;
                sArr = sArr2;
                i27 = i39;
            }
            s16 = (short) (s16 + 1);
        }
        int i49 = i28;
        int i56 = i26;
        int i57 = i27;
        short[] sArr3 = sArr;
        int i58 = 0;
        for (short s18 = 0; s18 < i3; s18 = (short) (s18 + 1)) {
            short s19 = 0;
            while (s19 < i16) {
                int i59 = i58 + 1;
                int i65 = s18 * i18;
                sArr3[i58] = (short) (i65 + s19);
                int i66 = i59 + 1;
                int i67 = (s18 + 1) * i18;
                short s26 = (short) (i67 + s19);
                sArr3[i59] = s26;
                int i68 = i66 + 1;
                int i69 = s19 + 1;
                short s27 = (short) (i65 + i69);
                sArr3[i66] = s27;
                int i75 = i68 + 1;
                sArr3[i68] = s27;
                int i76 = i75 + 1;
                sArr3[i75] = s26;
                i58 = i76 + 1;
                sArr3[i76] = (short) (i67 + i69);
                s19 = (short) i69;
            }
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i56 * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i57 * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(fArr2);
        asFloatBuffer2.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(i49 * 2);
        allocateDirect3.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
        this.indexBuffer = asShortBuffer;
        asShortBuffer.put(sArr3);
        this.indexBuffer.position(0);
        this.mTexCoordinateBuffer = asFloatBuffer2;
        this.mVerticesBuffer = asFloatBuffer;
        this.mNumIndices = i49;
    }

    public void draw() {
        ShortBuffer shortBuffer = this.indexBuffer;
        if (shortBuffer != null) {
            shortBuffer.position(0);
            GLES20.glDrawElements(4, this.mNumIndices, 5123, this.indexBuffer);
        } else {
            GLES20.glDrawArrays(4, 0, this.mNumIndices);
        }
    }

    public FloatBuffer getTexCoordinateBuffer() {
        return this.mTexCoordinateBuffer;
    }

    public FloatBuffer getVerticesBuffer() {
        return this.mVerticesBuffer;
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
