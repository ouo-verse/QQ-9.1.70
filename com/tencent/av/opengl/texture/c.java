package com.tencent.av.opengl.texture;

import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.filter.GLSLRender;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: q, reason: collision with root package name */
    private float f74109q = 0.0f;

    /* renamed from: r, reason: collision with root package name */
    private final float[] f74110r = {0.0f, 0.0f, 0.0f, 0.0f};

    public c() {
        this.f74094c = 9;
    }

    public void C(int i3) {
        float f16;
        int i16 = (i3 >>> 24) & 255;
        if (i16 == 255) {
            f16 = 1.0f;
        } else {
            f16 = i16 / 255.0f;
        }
        float[] fArr = this.f74110r;
        fArr[0] = ((i3 >>> 16) & 255) / 255.0f;
        fArr[1] = ((i3 >>> 8) & 255) / 255.0f;
        fArr[2] = (i3 & 255) / 255.0f;
        fArr[3] = f16;
    }

    public void D(float f16) {
        this.f74109q = f16;
    }

    @Override // com.tencent.av.opengl.texture.a
    public void a(ov.a aVar, int i3, int i16, int i17, int i18) {
        this.f74102k = i17;
        this.f74103l = i18;
        super.a(aVar, i3, i16, i17, i18);
    }

    @Override // com.tencent.av.opengl.texture.a
    public int g() {
        return GLSLRender.GL_TEXTURE_2D;
    }

    @Override // com.tencent.av.opengl.texture.a
    public boolean q() {
        if (this.f74110r[3] == 1.0f) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.av.opengl.texture.a
    public boolean r(ov.a aVar) {
        return false;
    }

    @Override // com.tencent.av.opengl.texture.a
    public qv.b[] s(ov.a aVar) {
        TextureProgram i3 = i();
        qv.b[] s16 = super.s(aVar);
        if (i3 instanceof pv.c) {
            GLES20.glUniform1f(s16[4].f429680a, this.f74102k);
            GLES20.glUniform1f(s16[5].f429680a, this.f74103l);
            GLES20.glUniform1f(s16[6].f429680a, this.f74109q);
            int i16 = s16[7].f429680a;
            float[] fArr = this.f74110r;
            GLES20.glUniform4f(i16, fArr[0], fArr[1], fArr[2], fArr[3]);
        }
        return s16;
    }
}
