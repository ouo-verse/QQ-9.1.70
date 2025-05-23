package com.tencent.mobileqq.ar.ARRenderModel;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes11.dex */
public class j {

    /* renamed from: n, reason: collision with root package name */
    private static final String f197269n = "j";

    /* renamed from: c, reason: collision with root package name */
    private FloatBuffer f197272c;

    /* renamed from: d, reason: collision with root package name */
    private FloatBuffer f197273d;

    /* renamed from: e, reason: collision with root package name */
    private int f197274e;

    /* renamed from: f, reason: collision with root package name */
    private int f197275f;

    /* renamed from: g, reason: collision with root package name */
    private int f197276g;

    /* renamed from: h, reason: collision with root package name */
    private int f197277h;

    /* renamed from: a, reason: collision with root package name */
    private final String f197270a = "attribute vec4 a_Position;\nattribute vec2 a_TexCoord;\n\nvarying vec2 v_TexCoord;\n\nvoid main() {\n   gl_Position = a_Position;\n   v_TexCoord = a_TexCoord;\n}";

    /* renamed from: b, reason: collision with root package name */
    private final String f197271b = "\n#extension GL_OES_EGL_image_external : require\n\nprecision mediump float;\nvarying vec2 v_TexCoord;\nuniform samplerExternalOES sTexture;\n\n\nvoid main() {\n    gl_FragColor = texture2D(sTexture, v_TexCoord);\n}";

    /* renamed from: i, reason: collision with root package name */
    private int f197278i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f197279j = 36197;

    /* renamed from: k, reason: collision with root package name */
    private boolean f197280k = false;

    /* renamed from: l, reason: collision with root package name */
    public final float[] f197281l = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};

    /* renamed from: m, reason: collision with root package name */
    public final float[] f197282m = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    public void a(FloatBuffer floatBuffer) {
        String str = f197269n;
        z81.d.a(str, "before draw");
        this.f197273d = floatBuffer;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glColorMask(true, true, true, true);
        GLES20.glClear(16640);
        GLES20.glDepthMask(false);
        GLES20.glDisable(2929);
        GLES20.glDisable(3042);
        GLES20.glUseProgram(this.f197274e);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f197278i);
        GLES20.glUniform1i(this.f197277h, 0);
        GLES20.glVertexAttribPointer(this.f197275f, 2, 5126, false, 0, (Buffer) this.f197272c);
        GLES20.glVertexAttribPointer(this.f197276g, 2, 5126, false, 0, (Buffer) this.f197273d);
        GLES20.glEnableVertexAttribArray(this.f197275f);
        GLES20.glEnableVertexAttribArray(this.f197276g);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f197275f);
        GLES20.glDisableVertexAttribArray(this.f197276g);
        GLES20.glEnable(2929);
        z81.d.a(str, "after draw");
    }
}
