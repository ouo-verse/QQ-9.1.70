package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GlitchFilter extends GPUBaseFilter implements VertexDataJobListener {
    public static final int BYTES_PER_FLOAT = 4;
    public static final int COORDS_PER_VERTEX = 2;
    public static final int DISPLACE_COLOR_BLUE = 2;
    public static final int DISPLACE_COLOR_GREEN = 1;
    public static final int DISPLACE_COLOR_NONE = -1;
    public static final int DISPLACE_COLOR_RED = 0;
    public static final String GLITCH_FRAGMENT_SHADER = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!\u7d20\u6750\u56fe\u7247\nuniform vec4 dstColor; //!\u7d20\u6750\u56fe\u7247\u989c\u8272\u66ff\u6362 x \u662f\u5426\u542f\u7528 y z w \u989c\u8272\u503c alpha\u4e0d\u6539\u53d8\n\nvoid main()\n{\n    vec4 v4DstColor = texture2D(inputImageTexture, vTextureCoord);\n    if (dstColor.x > 0.0)\n    {\n        //!\u9700\u8981\u989c\u8272\u66ff\u6362\n        gl_FragColor = vec4(dstColor.yzw, v4DstColor.a);\n    }\n    else\n    {\n        gl_FragColor = v4DstColor;\n    }\n}\n";
    public static final String GLITCH_VERTEX_SHADER = "precision highp float;\nuniform int nHorizontalColor; //!\u6c34\u5e73\u7f6e\u6362\u989c\u8272(-1=\u65e0\u6548,0=R,1=G,2=B)\nuniform vec2 vDisParamH; //!x:\u6700\u5927\u6c34\u5e73\u7f6e\u6362 y:\u6c34\u5e73\u504f\u79fb\nuniform int nVerticalColor; //!\u5782\u76f4\u7f6e\u6362\u989c\u8272((-1=\u65e0\u6548,0=R,1=G,2=B)\nuniform vec2 vDisParamV; //!x:\u6700\u5927\u6c34\u5e73\u7f6e\u6362 y:\u5782\u76f4\u504f\u79fb\nuniform sampler2D uGlitchTexture;\nattribute vec4 aPosition;\nvarying vec2 vTextureCoord;\n\nfloat getDisplacementValue(vec4 v4Glitch, int nColor, vec2 v2Param)\n{\n    if (nColor < 0){\n        return 0.0;\n    }\n    //!\u6c34\u5e73\u7f6e\u6362\u6709\u6548\n    float fValue = 0.0;\n    if (nColor == 0)\n    {\n        fValue = v4Glitch.r;\n    }\n    else if (nColor == 1)\n    {\n        fValue = v4Glitch.g;\n    }\n    else if (nColor == 2)\n    {\n        fValue = v4Glitch.b;\n    }\n\n    return (fValue * 2.0 - 1.0) * v2Param.x + v2Param.y * 2.0;\n}\n\nvoid main()\n {\n    vTextureCoord = vec2((aPosition.x + 1.0) / 2.0, (aPosition.y + 1.0) / 2.0);\n    vec4 v4Glitch = texture2DLod(uGlitchTexture, aPosition.xy, 0.0);\n\n    float fDisHor = getDisplacementValue(v4Glitch, nHorizontalColor, vDisParamH);\n    float fDisVer = getDisplacementValue(v4Glitch, nVerticalColor, vDisParamV);\n    gl_Position = vec4(aPosition.x + fDisHor, aPosition.y + fDisVer, aPosition.zw);\n}\n";
    private static final String TAG = "GlitchFilter";
    private static final FloatBuffer mTextureData = GlUtil.createFloatBuffer(GPUBaseFilter.TEXUTURE_COORDS);
    private int[] mArrayBuffers;
    private int mAttrPosition;
    private int mAttrTextureCoord;
    private int mDisColorH;
    private int mDisColorV;
    private RectF mGlitchAraea;
    private float mMaxDisH;
    private float mMaxDisV;
    private float mShiftH;
    private float mShiftY;
    private int mUniDisParamH;
    private int mUniDisParamV;
    private int mUniDstColor;
    private int mUniGlitchTexture;
    private int mUniHorColor;
    private int mUniInputTexture;
    private int mUniVerColor;
    private FloatBuffer mVertexData;

    public GlitchFilter(RectF rectF) {
        super(GLITCH_VERTEX_SHADER, GLITCH_FRAGMENT_SHADER);
        this.mDisColorH = -1;
        this.mMaxDisH = 0.5f;
        this.mShiftH = 0.0f;
        this.mDisColorV = -1;
        this.mMaxDisV = 0.5f;
        this.mShiftY = 0.0f;
        this.mUniVerColor = -1;
        this.mUniHorColor = -1;
        this.mUniDisParamV = -1;
        this.mUniDisParamH = -1;
        this.mAttrPosition = -1;
        this.mAttrTextureCoord = -1;
        this.mUniGlitchTexture = -1;
        this.mUniInputTexture = -1;
        this.mUniDstColor = -1;
        this.mArrayBuffers = null;
        this.mGlitchAraea = rectF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onDestroy() {
        super.onDestroy();
        int[] iArr = this.mArrayBuffers;
        if (iArr != null) {
            GLES20.glDeleteBuffers(iArr.length, iArr, 0);
            this.mArrayBuffers = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onInitialized() {
        super.onInitialized();
        int program = getProgram();
        if (program <= 0) {
            return;
        }
        GLES20.glUseProgram(program);
        this.mAttrPosition = GLES20.glGetAttribLocation(program, "aPosition");
        this.mUniGlitchTexture = GLES20.glGetUniformLocation(program, "uGlitchTexture");
        this.mUniVerColor = GLES20.glGetUniformLocation(program, "nVerticalColor");
        this.mUniDisParamV = GLES20.glGetUniformLocation(program, "vDisParamV");
        this.mUniHorColor = GLES20.glGetUniformLocation(program, "nHorizontalColor");
        this.mUniDisParamH = GLES20.glGetUniformLocation(program, "vDisParamH");
        this.mUniInputTexture = GLES20.glGetUniformLocation(program, "inputImageTexture");
        this.mUniDstColor = GLES20.glGetUniformLocation(program, "dstColor");
    }

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onOutputSizeChanged(int i3, int i16) {
        RectF rectF;
        super.onOutputSizeChanged(i3, i16);
        if (i3 == 0 || i16 == 0 || (rectF = this.mGlitchAraea) == null) {
            return;
        }
        int abs = (int) Math.abs(rectF.width() * i3);
        int abs2 = (int) Math.abs(this.mGlitchAraea.height() * i16);
        synchronized (this) {
            FloatBuffer floatBuffer = this.mVertexData;
            if (floatBuffer != null && floatBuffer.limit() == abs * 2 * abs2) {
                return;
            }
            this.mVertexData = null;
            new BaseThread(new VertexDataJob(this.mGlitchAraea, abs, abs2, i3, i16, this)).start();
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.VertexDataJobListener
    public void onResult(FloatBuffer floatBuffer) {
        synchronized (this) {
            this.mVertexData = floatBuffer;
        }
    }

    public boolean process(int i3, int i16, boolean z16, int i17, boolean z17) {
        int program;
        float f16;
        if (i16 < 0 || i3 < 0 || (program = getProgram()) <= 0) {
            return false;
        }
        GLES20.glUseProgram(program);
        if (this.mArrayBuffers == null) {
            synchronized (this) {
                if (this.mVertexData == null) {
                    return false;
                }
                int[] iArr = new int[2];
                this.mArrayBuffers = iArr;
                GLES20.glGenBuffers(2, iArr, 0);
                GLES20.glBindBuffer(34962, this.mArrayBuffers[0]);
                this.mVertexData.rewind();
                GLES20.glBufferData(34962, this.mVertexData.limit() * 4, this.mVertexData, 35044);
                GLES20.glEnableVertexAttribArray(this.mAttrPosition);
                GLES20.glBindBuffer(34962, this.mArrayBuffers[0]);
                GLES20.glVertexAttribPointer(this.mAttrPosition, 2, 5126, false, 0, 0);
                GLES20.glBindBuffer(34962, this.mArrayBuffers[1]);
                FloatBuffer floatBuffer = mTextureData;
                floatBuffer.rewind();
                GLES20.glBufferData(34962, floatBuffer.limit() * 4, floatBuffer, 35044);
                GLES20.glEnableVertexAttribArray(this.mAttrTextureCoord);
                GLES20.glBindBuffer(34962, this.mArrayBuffers[1]);
                GLES20.glVertexAttribPointer(this.mAttrTextureCoord, 2, 5126, false, 0, 0);
            }
        } else {
            GLES20.glEnableVertexAttribArray(this.mAttrPosition);
            GLES20.glBindBuffer(34962, this.mArrayBuffers[0]);
            GLES20.glVertexAttribPointer(this.mAttrPosition, 2, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.mAttrTextureCoord);
            GLES20.glBindBuffer(34962, this.mArrayBuffers[1]);
            GLES20.glVertexAttribPointer(this.mAttrTextureCoord, 2, 5126, false, 0, 0);
        }
        GLES20.glUniform1i(this.mUniHorColor, this.mDisColorH);
        GLES20.glUniform2f(this.mUniDisParamH, this.mMaxDisH, this.mShiftH);
        GLES20.glUniform1i(this.mUniVerColor, this.mDisColorV);
        GLES20.glUniform2f(this.mUniDisParamV, this.mMaxDisV, this.mShiftY);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i16);
        GLES20.glUniform1i(this.mUniInputTexture, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(this.mTextureType, i3);
        GLES20.glUniform1i(this.mUniGlitchTexture, 1);
        int i18 = this.mUniDstColor;
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        GLES20.glUniform4f(i18, f16, LayerRenderBase.getRed(i17), LayerRenderBase.getGreen(i17), LayerRenderBase.getBlue(i17));
        if (z17) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        }
        GLES20.glDrawArrays(0, 0, this.mVertexData.limit() / 2);
        GLES20.glDisableVertexAttribArray(this.mAttrPosition);
        GLES20.glDisableVertexAttribArray(this.mAttrTextureCoord);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(this.mTextureType, 0);
        if (z17) {
            GLES20.glDisable(3042);
        }
        return true;
    }

    public void updateData(int i3, float f16, float f17, int i16, float f18, float f19) {
        this.mDisColorH = i3;
        this.mDisColorV = i16;
        this.mMaxDisH = f16;
        this.mMaxDisV = f18;
        this.mShiftH = f17;
        this.mShiftY = f19;
    }
}
