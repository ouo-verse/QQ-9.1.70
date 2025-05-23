package ht1;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<Runnable> f406224a;

    /* renamed from: b, reason: collision with root package name */
    protected final b f406225b;

    /* renamed from: c, reason: collision with root package name */
    private int f406226c;

    /* renamed from: d, reason: collision with root package name */
    private int f406227d;

    /* renamed from: e, reason: collision with root package name */
    private int f406228e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f406229f;

    public a(boolean z16) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", z16 ? "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, vec2(textureCoordinate.x, 1.0 - textureCoordinate.y));\n}" : QQAVImageFilter.NO_FILTER_FRAGMENT_SHADER);
    }

    public final void b() {
        h();
        g();
        this.f406229f = false;
        this.f406225b.b();
    }

    public int c() {
        return GLSLRender.GL_TEXTURE_2D;
    }

    public final void d() {
        f();
        this.f406229f = true;
    }

    public void e(int i3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.f406225b.c());
        h();
        if (!this.f406229f) {
            return;
        }
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.f406226c, 2, 5126, false, 0, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.f406226c);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.f406228e, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.f406228e);
        if (i3 != -1) {
            GLES20.glActiveTexture(33984);
            OpenGlUtils.bindTexture(c(), i3);
            GLES20.glUniform1i(this.f406227d, 0);
        }
        a(i3);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f406226c);
        GLES20.glDisableVertexAttribArray(this.f406228e);
        OpenGlUtils.bindTexture(c(), 0);
    }

    protected void f() {
        this.f406225b.a();
        this.f406226c = GLES20.glGetAttribLocation(this.f406225b.c(), "position");
        this.f406227d = GLES20.glGetUniformLocation(this.f406225b.c(), "inputImageTexture");
        this.f406228e = GLES20.glGetAttribLocation(this.f406225b.c(), "inputTextureCoordinate");
        this.f406229f = true;
    }

    protected void h() {
        LinkedList linkedList;
        synchronized (this.f406224a) {
            linkedList = new LinkedList(this.f406224a);
            this.f406224a.clear();
        }
        while (!linkedList.isEmpty()) {
            ((Runnable) linkedList.removeFirst()).run();
        }
    }

    public a(String str, String str2) {
        this.f406224a = new LinkedList<>();
        this.f406225b = new b(str, str2);
    }

    protected void g() {
    }

    protected void a(int i3) {
    }
}
