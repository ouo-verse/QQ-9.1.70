package com.tencent.taveffect.effects;

import android.opengl.GLES20;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.utils.RandomUtils;
import com.tencent.taveffect.utils.TAVGLUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public class GanraoEffect extends BaseEffect {
    private static String FRAGMENT_SHADER_CODE = "sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform vec4 shadowOffset;\nuniform int shadowColorInit;\nuniform int barNum;\nuniform mat4 barPositions;\nvoid main()\n{\n    vec2 originTexCoord = vTextureCoord;\n    vec2 adjustTexCoord = vTextureCoord;\n    vec2 offset = vec2(0.0, 0.0);\n    float flag = 0.0;\n    for (int i = 0;i < barNum;i++)\n    {\n        float diff1 = clamp(originTexCoord.y - barPositions[i].x, 0.0, 1.0);\n        float diff2 = clamp(barPositions[i].y - originTexCoord.y, 0.0, 1.0);\n        flag = clamp(diff1 * diff2 * 1e08, 0.0, 1.0);\n\n        offset = offset + flag * vec2(barPositions[i].z, 0.0);\n        adjustTexCoord = adjustTexCoord + offset;\n    }\n\n    vec4 videoColor = texture2D(sTexture, adjustTexCoord);\n    vec4 shadow = texture2D(sTexture, adjustTexCoord + shadowOffset.xy + offset);\n\n    float shadowColor = clamp(float(shadowColorInit), 1.0, 3.0);\n\n    vec4 finalColor = vec4(0.0, 0.0, 0.0, 1.0);\n\n    flag = abs(shadowColor - 1.0);\n    flag = abs(step(1.0, flag) - 1.0);\n    finalColor += flag * vec4(videoColor.r, videoColor.g, shadow.b, 0.0);\n\n    flag = abs(shadowColor - 2.0);\n    flag = abs(step(1.0, flag) - 1.0);\n    finalColor += flag * vec4(videoColor.r, shadow.g, videoColor.b, 0.0);\n\n    flag = abs(shadowColor - 3.0);\n    flag = abs(step(1.0, flag) - 1.0);\n    gl_FragColor = finalColor + flag * vec4(shadow.r, videoColor.g, videoColor.b, 0.0);\n}";
    private int barNumHandle;
    private int barPositionsHandle;
    private String columnCode = "    for (int i = 0;i < barNum;i++)\n    {\n        float diff1 = clamp(originTexCoord.x - barPositions[i].x, 0.0, 1.0);\n        float diff2 = clamp(barPositions[i].y - originTexCoord.x, 0.0, 1.0);\n        flag = clamp(diff1 * diff2 * 1e08, 0.0, 1.0);\n\n        offset = offset + flag * vec2(0.0, barPositions[i].z);\n        adjustTexCoord = adjustTexCoord + offset;\n    }\n";
    private float deltaTime = 0.02f;
    private float elpsedTime;
    private int flickCount;
    private float flickTime;
    private boolean init;
    private int shadowColorInitHandle;
    private int shadowOffsetHandle;

    private void generateRandomData() {
        float f16 = 0.0f;
        float[] fArr = {RandomUtils.randomFloat(0.0f, 0.01f), RandomUtils.randomFloat(0.0f, 0.01f), 0.0f, 0.0f};
        int randomInt = RandomUtils.randomInt(1, 3);
        float[] fArr2 = new float[16];
        int i3 = 0;
        while (true) {
            if (i3 >= randomInt) {
                break;
            }
            float randomFloat = RandomUtils.randomFloat(f16, 0.9f);
            float randomFloat2 = RandomUtils.randomFloat(0.05f + randomFloat, 0.2f + randomFloat);
            if (randomFloat2 > 0.99f) {
                randomInt = i3;
                break;
            }
            float randomFloat3 = RandomUtils.randomFloat(0.005f, 0.02f);
            int randomInt2 = RandomUtils.randomInt(1, 2);
            if (randomInt2 == 2) {
                randomInt2 = -1;
            }
            setRowForMatrix4(fArr2, i3, randomFloat, randomFloat2, randomFloat3 * randomInt2, 0.0f);
            i3++;
            f16 = randomFloat2;
        }
        GLES20.glUniform4f(this.shadowOffsetHandle, fArr[0], fArr[1], fArr[2], fArr[3]);
        GLES20.glUniform1i(this.barNumHandle, randomInt);
        GLES20.glUniformMatrix4fv(this.barPositionsHandle, 1, false, fArr2, 0);
        GLES20.glUniform1i(this.shadowColorInitHandle, RandomUtils.randomInt(1, 2));
    }

    private void recover() {
        GLES20.glUniform1i(this.barNumHandle, 0);
        GLES20.glUniform4f(this.shadowOffsetHandle, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    private void setRowForMatrix4(float[] fArr, int i3, float f16, float f17, float f18, float f19) {
        int i16 = i3 * 4;
        fArr[i16] = f16;
        fArr[i16 + 1] = f17;
        fArr[i16 + 2] = f18;
        fArr[i16 + 3] = f19;
    }

    private void update() {
        float f16 = this.elpsedTime + 0.05f;
        this.elpsedTime = f16;
        if (f16 > 1.0f) {
            if (this.flickCount == 0) {
                this.flickCount = RandomUtils.randomInt(3, 7);
            }
            float f17 = this.flickTime + 0.05f;
            this.flickTime = f17;
            if (f17 > 0.06f) {
                generateRandomData();
                this.flickTime = 0.0f;
                int i3 = this.flickCount - 1;
                this.flickCount = i3;
                if (i3 == 0) {
                    recover();
                    this.elpsedTime = 0.0f;
                }
            }
        }
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected void beforeDraw(TAVTextureInfo tAVTextureInfo) {
        if (!this.init) {
            this.init = true;
            recover();
        }
        update();
    }

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected String getFragmentShaderCode(TAVTextureInfo tAVTextureInfo) {
        if (tAVTextureInfo.textureType == 36197) {
            return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES " + FRAGMENT_SHADER_CODE;
        }
        return "uniform sampler2D " + FRAGMENT_SHADER_CODE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.taveffect.effects.BaseEffect
    public void initShader(TAVTextureInfo tAVTextureInfo) {
        super.initShader(tAVTextureInfo);
        this.barNumHandle = GLES20.glGetUniformLocation(this.program, "barNum");
        TAVGLUtils.checkEglError("glGetAttribLocation barNum");
        this.shadowOffsetHandle = GLES20.glGetUniformLocation(this.program, NodeProps.SHADOW_OFFSET);
        TAVGLUtils.checkEglError("glGetAttribLocation shadowOffset");
        this.barPositionsHandle = GLES20.glGetUniformLocation(this.program, "barPositions");
        TAVGLUtils.checkEglError("glGetAttribLocation barPositions");
        this.shadowColorInitHandle = GLES20.glGetUniformLocation(this.program, "shadowColorInit");
        TAVGLUtils.checkEglError("glGetAttribLocation shadowColorInit");
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    /* renamed from: clone */
    public GanraoEffect mo93clone() {
        return (GanraoEffect) cloneFilter(new GanraoEffect());
    }
}
