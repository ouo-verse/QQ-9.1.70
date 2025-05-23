package com.tencent.qfsmonet.gles;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.gles.MonetShaderDescriptor;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static final float[] f342494i;

    /* renamed from: j, reason: collision with root package name */
    private static final float[] f342495j;

    /* renamed from: a, reason: collision with root package name */
    private int f342496a;

    /* renamed from: b, reason: collision with root package name */
    private FloatBuffer f342497b;

    /* renamed from: c, reason: collision with root package name */
    private FloatBuffer f342498c;

    /* renamed from: d, reason: collision with root package name */
    private int f342499d;

    /* renamed from: e, reason: collision with root package name */
    private int f342500e;

    /* renamed from: f, reason: collision with root package name */
    private int f342501f;

    /* renamed from: g, reason: collision with root package name */
    private int f342502g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f342503h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17206);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f342494i = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
            f342495j = new float[]{-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f342499d = MonetShaderDescriptor.OpenGLSamplerType.SAMPLER_2D;
        this.f342503h = null;
        com.tencent.qfsmonet.utils.a.c("MonetGLES20Renderer", "create MonetGLES20Render!");
    }

    public synchronized void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.qfsmonet.utils.a.c("MonetGLES20Renderer", "destroy");
        int i3 = this.f342496a;
        if (i3 > 0) {
            GLES20.glDeleteProgram(i3);
            this.f342496a = 0;
        }
    }

    public synchronized void b(@NonNull MonetShaderDescriptor monetShaderDescriptor) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) monetShaderDescriptor);
            return;
        }
        if (this.f342496a != 0) {
            com.tencent.qfsmonet.utils.a.c("MonetGLES20Renderer", "initWithShader has init!");
            return;
        }
        com.tencent.qfsmonet.utils.a.c("MonetGLES20Renderer", "initWithShader");
        int c16 = g.c(monetShaderDescriptor.l(), monetShaderDescriptor.g());
        this.f342496a = c16;
        if (c16 != 0) {
            GLES20.glUseProgram(c16);
            this.f342500e = GLES20.glGetUniformLocation(this.f342496a, monetShaderDescriptor.j());
            this.f342501f = GLES20.glGetAttribLocation(this.f342496a, monetShaderDescriptor.i());
            this.f342502g = GLES20.glGetAttribLocation(this.f342496a, monetShaderDescriptor.k());
            float[] fArr = f342495j;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            this.f342498c = asFloatBuffer;
            asFloatBuffer.put(fArr);
            this.f342498c.position(0);
            float[] fArr2 = f342494i;
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(fArr2.length * 4);
            allocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
            this.f342497b = asFloatBuffer2;
            asFloatBuffer2.put(fArr2);
            this.f342497b.position(0);
            this.f342499d = monetShaderDescriptor.h();
            com.tencent.qfsmonet.utils.a.c("MonetGLES20Renderer", "initWithShader success, program = " + this.f342496a);
            return;
        }
        com.tencent.qfsmonet.utils.a.b("MonetGLES20Renderer", "program create error!");
        throw new IllegalStateException("gl program failed!");
    }

    public synchronized void c(int i3, int i16, int i17) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            d(i3, new p(i16, i17, 0));
        }
    }

    public synchronized void d(int i3, @NonNull p pVar) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) pVar);
        } else {
            f(i3, pVar, this.f342498c, this.f342497b);
        }
    }

    public synchronized void e(int i3, @NonNull p pVar, @NonNull FloatBuffer floatBuffer) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), pVar, floatBuffer);
        } else {
            f(i3, pVar, this.f342498c, floatBuffer);
        }
    }

    public synchronized void f(int i3, @NonNull p pVar, @NonNull FloatBuffer floatBuffer, @NonNull FloatBuffer floatBuffer2) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), pVar, floatBuffer, floatBuffer2);
            return;
        }
        int i16 = this.f342496a;
        if (i16 != 0) {
            GLES20.glUseProgram(i16);
            GLES20.glBindFramebuffer(36160, pVar.b());
            GLES20.glViewport(0, 0, pVar.c(), pVar.a());
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(h.g(this.f342499d), i3);
            GLES20.glUniform1i(this.f342500e, 0);
            GLES20.glEnableVertexAttribArray(this.f342502g);
            GLES20.glVertexAttribPointer(this.f342502g, 2, 5126, false, 0, (Buffer) floatBuffer);
            GLES20.glEnableVertexAttribArray(this.f342501f);
            GLES20.glVertexAttribPointer(this.f342501f, 2, 5126, false, 0, (Buffer) floatBuffer2);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.f342502g);
            GLES20.glDisableVertexAttribArray(this.f342501f);
            GLES20.glBindFramebuffer(36160, 0);
            return;
        }
        com.tencent.qfsmonet.utils.a.h("MonetGLES20Renderer", "renderWithVertexBufferAndTextureBuffer, no init shader.");
        throw new IllegalStateException("no init shader.");
    }
}
