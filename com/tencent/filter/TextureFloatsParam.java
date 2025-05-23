package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes6.dex */
public class TextureFloatsParam extends UniformParam.TextureParam {
    static IPatchRedirector $redirector_;
    private int[] value;

    public TextureFloatsParam(String str, int[] iArr, int i3) {
        super(str, 0, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, iArr, Integer.valueOf(i3));
        } else {
            this.value = iArr;
        }
    }

    @Override // com.tencent.aekit.openrender.UniformParam.TextureParam, com.tencent.aekit.openrender.UniformParam
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        GLES20.glActiveTexture(this.textureId);
        GlUtil.glDeleteTextures(1, this.texture, 0);
        super.clear();
    }

    @Override // com.tencent.aekit.openrender.UniformParam
    public void initialParams(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        super.initialParams(i3);
        if (this.value == null) {
            return;
        }
        GLES20.glActiveTexture(this.textureId);
        GlUtil.glGenTextures(1, this.texture, 0);
        GLSLRender.nativeTextCure(this.value, this.texture[0]);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
    }
}
