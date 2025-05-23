package com.tencent.mobileqq.shortvideo.dancemachine;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLShaderManager {
    private static HashMap<String, GLProgram> sShaderMgr = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class GLProgram {
        int colorSize;
        int programId;
        int textureSize;
        int vertexSize;
        HashMap<String, Integer> attribute = new HashMap<>();
        HashMap<String, Integer> uniform = new HashMap<>();
        int textureMaskSize = 0;

        GLProgram() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getColorOffset() {
            return this.vertexSize + this.textureSize;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getMaskOffset() {
            return this.vertexSize + this.textureSize + this.colorSize;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getTextureOffset() {
            return this.vertexSize;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getVertexAttributeSize() {
            return this.vertexSize + this.textureSize + this.colorSize + this.textureMaskSize;
        }
    }

    private static int buildProgram(String str) {
        if (str.equals(GLShaderFile.BASE_KEY)) {
            return GlUtil.createProgram(GLShaderFile.GL_VIEW_VERTEX, GLShaderFile.GL_VIEW_FRAGMENT);
        }
        if (str.equals(GLShaderFile.MASK_KEY)) {
            return GlUtil.createProgram(GLShaderFile.GL_VIEW_VERTEX_MASK, GLShaderFile.GL_VIEW_FRAGMENT_MASK);
        }
        return 0;
    }

    public static void clearShaderManager() {
        sShaderMgr.clear();
        DanceLog.printFrameQueue("GLShaderManager", "clearShaderManager");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GLProgram createProgram(String str) {
        GLProgram gLProgram = sShaderMgr.get(str);
        if (gLProgram == null) {
            gLProgram = createProgramInit(str);
            if (gLProgram != null) {
                sShaderMgr.put(str, gLProgram);
            } else {
                DanceLog.printFrameQueue("GLShaderManager", "createProgram[Init]program=null");
            }
        }
        DanceLog.printFrameQueue("GLShaderManager", "createProgram");
        return gLProgram;
    }

    private static GLProgram createProgramInit(String str) {
        int buildProgram = buildProgram(str);
        DanceLog.printFrameQueue("GLShaderManager", "createProgramInit program=" + buildProgram);
        if (buildProgram != 0) {
            GLProgram gLProgram = new GLProgram();
            gLProgram.programId = buildProgram;
            GLES20.glUseProgram(buildProgram);
            if (str.equals(GLShaderFile.BASE_KEY)) {
                gLProgram.attribute.put("a_position", Integer.valueOf(GLES20.glGetAttribLocation(buildProgram, "a_position")));
                gLProgram.attribute.put("a_texCoord", Integer.valueOf(GLES20.glGetAttribLocation(buildProgram, "a_texCoord")));
                gLProgram.attribute.put("a_color", Integer.valueOf(GLES20.glGetAttribLocation(buildProgram, "a_color")));
                gLProgram.uniform.put("u_projectionMatrix", Integer.valueOf(GLES20.glGetUniformLocation(buildProgram, "u_projectionMatrix")));
                gLProgram.uniform.put("u_texture", Integer.valueOf(GLES20.glGetUniformLocation(buildProgram, "u_texture")));
                gLProgram.vertexSize = 3;
                gLProgram.textureSize = 2;
                gLProgram.colorSize = 4;
            } else if (str.equals(GLShaderFile.MASK_KEY)) {
                gLProgram.attribute.put("a_position", Integer.valueOf(GLES20.glGetAttribLocation(buildProgram, "a_position")));
                gLProgram.attribute.put("a_texCoord", Integer.valueOf(GLES20.glGetAttribLocation(buildProgram, "a_texCoord")));
                gLProgram.attribute.put("a_color", Integer.valueOf(GLES20.glGetAttribLocation(buildProgram, "a_color")));
                gLProgram.attribute.put("a_texCoordMask", Integer.valueOf(GLES20.glGetAttribLocation(buildProgram, "a_texCoordMask")));
                gLProgram.uniform.put("u_projectionMatrix", Integer.valueOf(GLES20.glGetUniformLocation(buildProgram, "u_projectionMatrix")));
                gLProgram.uniform.put("u_texture", Integer.valueOf(GLES20.glGetUniformLocation(buildProgram, "u_texture")));
                gLProgram.uniform.put("u_texture_mask", Integer.valueOf(GLES20.glGetUniformLocation(buildProgram, "u_texture_mask")));
                gLProgram.vertexSize = 3;
                gLProgram.textureSize = 2;
                gLProgram.colorSize = 4;
                gLProgram.textureMaskSize = 2;
            }
            GLES20.glUseProgram(0);
            return gLProgram;
        }
        return null;
    }
}
