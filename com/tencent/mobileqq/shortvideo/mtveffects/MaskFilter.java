package com.tencent.mobileqq.shortvideo.mtveffects;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MaskFilter extends GPUBaseFilter {
    private static final String A_POSITION = "a_Position";
    private static final String MASK_FRAGMENT_SHADER = "precision mediump float;\nuniform vec4 u_Color;\nvoid main() {\n    gl_FragColor = u_Color;\n}\n";
    private static final String MASK_VERTEX_SHADER = "uniform mat4 u_Matrix;\nattribute vec4 a_Position;\nvoid main() {\n    gl_Position = u_Matrix * a_Position;\n}\n";
    private static final String TAG = "MaskFilter";
    private static final String U_COLOR = "u_Color";
    private static final String U_MATRIX = "u_Matrix";
    private final int BYTES_PER_FLOAT;
    private final int COORDS_PER_VERTEX;
    private int mColorLocation;
    private float[] mDefaultMvpMatirx;
    private int mMatrixLocation;
    private FloatBuffer mVertexBuffer;
    private int maPositionLocation;

    public MaskFilter() {
        super(MASK_VERTEX_SHADER, MASK_FRAGMENT_SHADER);
        this.COORDS_PER_VERTEX = 2;
        this.BYTES_PER_FLOAT = 4;
    }

    private void getFloatBuffer(float[] fArr) {
        if (fArr == null) {
            FloatBuffer floatBuffer = this.mVertexBuffer;
            if (floatBuffer != null) {
                floatBuffer.clear();
                return;
            }
            return;
        }
        FloatBuffer floatBuffer2 = this.mVertexBuffer;
        if (floatBuffer2 != null && floatBuffer2.capacity() >= fArr.length * 4) {
            this.mVertexBuffer.clear();
            this.mVertexBuffer.put(fArr);
            this.mVertexBuffer.rewind();
            return;
        }
        this.mVertexBuffer = GlUtil.createFloatBuffer(fArr);
    }

    public boolean drawShape(float[] fArr, int i3, float[] fArr2) {
        if (fArr2 == null) {
            fArr2 = this.mDefaultMvpMatirx;
        }
        int program = getProgram();
        if (program <= 0) {
            return false;
        }
        getFloatBuffer(fArr);
        FloatBuffer floatBuffer = this.mVertexBuffer;
        if (floatBuffer == null || floatBuffer.limit() == 0) {
            return false;
        }
        int limit = this.mVertexBuffer.limit() / 2;
        GLES20.glUseProgram(program);
        GLES20.glVertexAttribPointer(this.maPositionLocation, 2, 5126, false, 0, (Buffer) this.mVertexBuffer);
        GLES20.glEnableVertexAttribArray(this.maPositionLocation);
        GLES20.glUniform4f(this.mColorLocation, (i3 >> 16) & 255, (i3 >> 8) & 255, i3 & 255, (i3 >> 24) & 255);
        int i16 = this.mMatrixLocation;
        if (i16 >= 0) {
            GLES20.glUniformMatrix4fv(i16, 1, false, fArr2, 0);
        }
        GLES20.glDrawArrays(6, 0, limit);
        GLES20.glDisableVertexAttribArray(this.maPositionLocation);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onInitialized() {
        this.mDefaultMvpMatirx = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        int program = getProgram();
        if (program <= 0) {
            return;
        }
        GLES20.glUseProgram(program);
        this.mMatrixLocation = GLES20.glGetUniformLocation(program, U_MATRIX);
        this.maPositionLocation = GLES20.glGetAttribLocation(program, A_POSITION);
        this.mColorLocation = GLES20.glGetUniformLocation(program, U_COLOR);
    }
}
