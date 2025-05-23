package com.tencent.liteav.videobase.a;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.frame.c;
import com.tencent.liteav.videobase.frame.d;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static final float[] f119202i = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicInteger f119203j = new AtomicInteger();

    /* renamed from: a, reason: collision with root package name */
    protected final com.tencent.liteav.videobase.utils.a f119204a;

    /* renamed from: b, reason: collision with root package name */
    protected final Size f119205b;

    /* renamed from: c, reason: collision with root package name */
    protected int f119206c;

    /* renamed from: d, reason: collision with root package name */
    protected int f119207d;

    /* renamed from: e, reason: collision with root package name */
    protected int f119208e;

    /* renamed from: f, reason: collision with root package name */
    protected e f119209f;

    /* renamed from: g, reason: collision with root package name */
    public int f119210g;

    /* renamed from: h, reason: collision with root package name */
    public float[] f119211h;

    /* renamed from: k, reason: collision with root package name */
    private final com.tencent.liteav.videobase.utils.e f119212k;

    /* renamed from: l, reason: collision with root package name */
    private int f119213l;

    /* renamed from: m, reason: collision with root package name */
    private final c f119214m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f119215n;

    public a() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform mat4 textureTransform;\nvarying highp vec2 textureCoordinate;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", QQAVImageFilter.NO_FILTER_FRAGMENT_SHADER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i3) {
    }

    public int b() {
        return GLSLRender.GL_TEXTURE_2D;
    }

    public final void c() {
        if (!this.f119215n) {
            return;
        }
        this.f119204a.a();
        d();
        this.f119215n = false;
        this.f119214m.d();
        int i3 = this.f119210g;
        if (i3 != -1) {
            GLES20.glDeleteProgram(i3);
            this.f119210g = -1;
        }
        LiteavLog.d("TXCGPUImageFilter", "%s uninitialized, count: %d", this, Integer.valueOf(f119203j.decrementAndGet()));
    }

    public a(String str, String str2) {
        this.f119205b = new Size(-1, -1);
        this.f119210g = -1;
        this.f119214m = new c();
        this.f119204a = new com.tencent.liteav.videobase.utils.a();
        this.f119212k = new com.tencent.liteav.videobase.utils.e(str, str2);
    }

    public final void a() {
        if (this.f119215n) {
            return;
        }
        this.f119214m.a();
        com.tencent.liteav.videobase.utils.e eVar = this.f119212k;
        int a16 = com.tencent.liteav.videobase.utils.e.a(eVar.f119400a, 35633);
        int i3 = -1;
        if (a16 == 0) {
            LiteavLog.e("Program", "load vertex shader failed.");
        } else {
            int a17 = com.tencent.liteav.videobase.utils.e.a(eVar.f119401b, 35632);
            if (a17 == 0) {
                LiteavLog.e("Program", "load fragment shader failed.");
                GLES20.glDeleteShader(a16);
            } else {
                int glCreateProgram = GLES20.glCreateProgram();
                GLES20.glAttachShader(glCreateProgram, a16);
                GLES20.glAttachShader(glCreateProgram, a17);
                GLES20.glLinkProgram(glCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    LiteavLog.e("Program", "link program failed. status: " + iArr[0]);
                    GLES20.glDeleteShader(a16);
                    GLES20.glDeleteShader(a17);
                    GLES20.glDeleteProgram(glCreateProgram);
                } else {
                    GLES20.glDeleteShader(a16);
                    GLES20.glDeleteShader(a17);
                    i3 = glCreateProgram;
                }
            }
        }
        this.f119210g = i3;
        this.f119206c = GLES20.glGetAttribLocation(i3, "position");
        this.f119207d = GLES20.glGetUniformLocation(this.f119210g, "inputImageTexture");
        this.f119208e = GLES20.glGetAttribLocation(this.f119210g, "inputTextureCoordinate");
        this.f119213l = GLES20.glGetUniformLocation(this.f119210g, "textureTransform");
        a((e) null);
        this.f119215n = true;
        LiteavLog.d("TXCGPUImageFilter", "%s initialized, count: %d", this, Integer.valueOf(f119203j.incrementAndGet()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
    }

    public final void a(int i3, int i16) {
        Size size = this.f119205b;
        size.width = i3;
        size.height = i16;
    }

    public void a(int i3, d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.f119215n) {
            GLES20.glUseProgram(this.f119210g);
            this.f119204a.a();
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.f119206c, 2, 5126, false, 0, (Buffer) floatBuffer);
            GLES20.glEnableVertexAttribArray(this.f119206c);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.f119208e, 2, 5126, false, 0, (Buffer) floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.f119208e);
            if (i3 != -1) {
                GLES20.glActiveTexture(33984);
                OpenGlUtils.bindTexture(b(), i3);
                GLES20.glUniform1i(this.f119207d, 0);
            }
            if (dVar != null) {
                this.f119214m.a(dVar.a());
                this.f119214m.b();
            } else {
                OpenGlUtils.bindFramebuffer(36160, 0);
            }
            float[] fArr = this.f119211h;
            if (fArr == null) {
                fArr = f119202i;
            }
            GLES20.glUniformMatrix4fv(this.f119213l, 1, false, fArr, 0);
            a(i3);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.f119206c);
            GLES20.glDisableVertexAttribArray(this.f119208e);
            GLES20.glActiveTexture(33984);
            OpenGlUtils.bindTexture(b(), 0);
            if (dVar != null) {
                OpenGlUtils.bindFramebuffer(36160, 0);
                this.f119214m.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(e eVar) {
        this.f119209f = eVar;
    }
}
