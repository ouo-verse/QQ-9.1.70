package com.tencent.mobileqq.shortvideo.bighead;

import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;
import com.tencent.sveffects.SLog;
import java.nio.Buffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FeatherBlurFilter {
    public static final String NO_FILTER_FRAGMENT_SHADER = "precision highp float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvoid main() {\n    vec2 lTextureCoord = vec2(vTextureCoord.x,vTextureCoord.y);\n    vec2 textureOffset = vec2(texelWidthOffset,texelHeightOffset);\n    vec4 color = texture2D(uTexture, lTextureCoord);\n    float redValue   = color.r;\n    int featherWidth = 4;\n    bool needFeather  = false;\n    int i = 0;\n    float edgeIndex = 0.0;\n    for(i = -featherWidth/2;i <= featherWidth/2;i++)\n    {\n        float index = float(i);\n        vec2  texCoordAround = vec2(lTextureCoord.x + index * textureOffset.x,lTextureCoord.y);\n        vec4  texValAround   = texture2D(uTexture, texCoordAround);\n        float redAround      = texValAround.r;\n        vec2  texCoordAroundleft = vec2(lTextureCoord.x + (index-1.0) * textureOffset.x,lTextureCoord.y);\n        vec4  texValAroundleft   = texture2D(uTexture, texCoordAroundleft);\n        float redAroundleft      = texValAroundleft.r;\n        vec2  texCoordAroundright = vec2(lTextureCoord.x + (index+1.0) * textureOffset.x,lTextureCoord.y);\n        vec4  texValAroundright   = texture2D(uTexture, texCoordAroundright);\n        float redAroundright      = texValAroundright.r;\n        if(redAround == redAroundleft && redAround == redAroundright){\n           continue;\n        }\n        needFeather = ((redValue == 1.0 && redAround == 0.0) || (redValue == 0.0 && redAround == 1.0));\n        if(needFeather){\n           if(redValue == 1.0){\n               if(index < 0.0){\n                   edgeIndex = index + 1.0;\n               }else{\n                   edgeIndex = index - 1.0;\n               }\n           }else{\n               edgeIndex = index;\n           }\n           if(edgeIndex == 0.0){\n               color.a = 0.5;\n           }else{\n               float featherWidthFloat = float(featherWidth);\n               if(redValue == 0.0){\n                   color.a = 1.0 - abs(edgeIndex/featherWidthFloat);\n               }else{\n                   color.a = 0.5 + abs(edgeIndex/featherWidthFloat);\n               }\n           }\n        }\n    }\n    gl_FragColor = color;\n}\n";
    public static final String NO_FILTER_VERTEX_SHADER = "precision highp float;\nuniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying   vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n";
    private static final String TAG = "FeatherBlurFilter";
    private boolean mIsInitialized;
    private float mOutputHeight;
    private float mOutputWidth;
    private int mProgram;
    private float mWidthStepRatio = 1.0f;
    private float mHeightStepRatio = 1.0f;

    public void destroy() {
        if (this.mIsInitialized) {
            this.mIsInitialized = false;
            GLES20.glDeleteProgram(this.mProgram);
            this.mProgram = 0;
        }
    }

    public void drawTexture(int i3, float[] fArr, float[] fArr2) {
        int i16 = this.mProgram;
        if (fArr == null) {
            fArr = BigHeadBuckler.sGIdentity;
        }
        if (fArr2 == null) {
            fArr2 = BigHeadBuckler.sGIdentity;
        }
        GLES20.glUseProgram(i16);
        int glGetAttribLocation = GLES20.glGetAttribLocation(i16, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(i16, "aTextureCoord");
        int glGetUniformLocation = GLES20.glGetUniformLocation(i16, "uMVPMatrix");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i16, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) GpuGaussianBlurFilter.VERTEXT_BUF);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) GpuGaussianBlurFilter.TEXTURE_BUF);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr2, 0);
        GLES20.glUniformMatrix4fv(glGetUniformLocation2, 1, false, fArr, 0);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i16, "texelWidthOffset");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(i16, "texelHeightOffset");
        GLES20.glUniform1f(glGetUniformLocation3, this.mWidthStepRatio / this.mOutputWidth);
        GLES20.glUniform1f(glGetUniformLocation4, this.mHeightStepRatio / this.mOutputHeight);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(i16, "uTexture"), 0);
        GLES20.glDrawArrays(5, 0, 4);
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException("error =" + glGetError);
    }

    public int getProgram() {
        return this.mProgram;
    }

    public void init(int i3, int i16) {
        if (this.mIsInitialized) {
            return;
        }
        int createProgram = GlUtil.createProgram(NO_FILTER_VERTEX_SHADER, NO_FILTER_FRAGMENT_SHADER);
        this.mProgram = createProgram;
        if (createProgram == 0) {
            RuntimeException runtimeException = new RuntimeException("failed creating program " + getClass().getSimpleName());
            if (SLog.isEnable()) {
                SLog.e(TAG, "FeatherBlurFilter FeatherBlurFilter failed!", runtimeException);
            }
        }
        this.mOutputWidth = i3;
        this.mOutputHeight = i16;
        this.mIsInitialized = true;
    }

    public void setStepRatio(float f16, float f17) {
        this.mWidthStepRatio = f16;
        this.mHeightStepRatio = f17;
    }
}
