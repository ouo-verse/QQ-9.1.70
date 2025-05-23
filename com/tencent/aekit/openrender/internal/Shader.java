package com.tencent.aekit.openrender.internal;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.openrender.util.ProgramTools;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Shader {
    static IPatchRedirector $redirector_;
    private int fragmentShaderId;
    private final String fragmentShaderSource;
    private int shaderProgram;
    private int vertexShaderId;
    private final String vertexShaderSource;

    public Shader(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.shaderProgram = 0;
        this.fragmentShaderSource = str2;
        this.vertexShaderSource = str;
    }

    public void bind() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        GLES20.glUseProgram(this.shaderProgram);
        GlUtil.checkGlError("glUseProgram:" + this.shaderProgram);
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        GLES20.glDeleteShader(this.vertexShaderId);
        GLES20.glDeleteShader(this.fragmentShaderId);
        GLES20.glDeleteProgram(this.shaderProgram);
        this.shaderProgram = 0;
    }

    public void compile() {
        ProgramTools.ProgramInfo createProgram;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (this.shaderProgram == 0 && (createProgram = ProgramTools.createProgram(this.vertexShaderSource, this.fragmentShaderSource)) != null) {
            this.shaderProgram = createProgram.programId;
            this.vertexShaderId = createProgram.vertextShaderId;
            this.fragmentShaderId = createProgram.fragShaderId;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getFragmentShaderSource() {
        return this.fragmentShaderSource;
    }

    public int getShaderProgram() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.shaderProgram;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getVertexShaderSource() {
        return this.vertexShaderSource;
    }
}
