package com.tencent.mobileqq.shortvideo.panoramicvideo.GL;

import android.content.Context;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

/* loaded from: classes18.dex */
public class GLPassThroughProgram extends GLProgram {
    private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor=texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String VERTEX_SHADER = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nuniform mat4 uMVPMatrix;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}\n";
    private int uMVPMatrixHandle;
    private int uTextureSamplerHandle;

    public GLPassThroughProgram(Context context) {
        super(context, VERTEX_SHADER, FRAGMENT_SHADER);
    }

    @Override // com.tencent.mobileqq.shortvideo.panoramicvideo.GL.GLProgram
    public void create() {
        super.create();
        this.uTextureSamplerHandle = GLES20.glGetUniformLocation(getProgramId(), "sTexture");
        GlUtil.checkGlError("glGetUniformLocation uniform sTexture");
        this.uMVPMatrixHandle = GLES20.glGetUniformLocation(getProgramId(), "uMVPMatrix");
        GlUtil.checkGlError("glGetUniformLocation uMVPMatrix");
    }

    public int getMVPMatrixHandle() {
        return this.uMVPMatrixHandle;
    }

    public int getTextureSamplerHandle() {
        return this.uTextureSamplerHandle;
    }
}
