package com.tencent.mobileqq.qzoneplayer.panorama;

import android.content.Context;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes35.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    private FloatBuffer f279440a;

    /* renamed from: b, reason: collision with root package name */
    private FloatBuffer f279441b;

    /* renamed from: c, reason: collision with root package name */
    private int f279442c;

    public int a() {
        return this.f279442c;
    }

    public FloatBuffer b() {
        return this.f279441b;
    }

    public FloatBuffer c() {
        return this.f279440a;
    }

    public void d(Context context) {
        a.c(context, e(), this);
    }

    protected abstract int e();

    public void f(int i3) {
        this.f279442c = i3;
    }

    public void g(FloatBuffer floatBuffer) {
        this.f279441b = floatBuffer;
    }

    public void h(FloatBuffer floatBuffer) {
        this.f279440a = floatBuffer;
    }

    public void i(g gVar) {
        FloatBuffer c16 = c();
        FloatBuffer b16 = b();
        if (c16 == null || b16 == null) {
            return;
        }
        c16.position(0);
        b16.position(0);
        int f16 = gVar.f();
        GLES20.glVertexAttribPointer(f16, 3, 5126, false, 0, (Buffer) c16);
        GLES20.glEnableVertexAttribArray(f16);
        int g16 = gVar.g();
        GLES20.glVertexAttribPointer(g16, 2, 5126, false, 0, (Buffer) b16);
        GLES20.glEnableVertexAttribArray(g16);
    }
}
