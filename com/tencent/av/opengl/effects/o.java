package com.tencent.av.opengl.effects;

import android.opengl.Matrix;
import com.tencent.filter.GLSLRender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

/* compiled from: P */
/* loaded from: classes3.dex */
public class o {

    /* renamed from: b, reason: collision with root package name */
    private TextureRender f74000b;

    /* renamed from: c, reason: collision with root package name */
    private final float[] f74001c;

    /* renamed from: d, reason: collision with root package name */
    private final float[] f74002d;

    /* renamed from: a, reason: collision with root package name */
    private RenderBuffer f73999a = null;

    /* renamed from: e, reason: collision with root package name */
    private int f74003e = 0;

    public o() {
        this.f74000b = null;
        float[] fArr = new float[16];
        this.f74001c = fArr;
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = new float[16];
        this.f74002d = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        if (this.f74000b == null) {
            this.f74000b = new TextureRender();
        }
    }

    public void a() {
        RenderBuffer renderBuffer = this.f73999a;
        if (renderBuffer != null) {
            renderBuffer.destroy();
            this.f73999a = null;
        }
        TextureRender textureRender = this.f74000b;
        if (textureRender != null) {
            textureRender.release();
            this.f74000b = null;
        }
    }

    public boolean b() {
        if (this.f74003e != 0) {
            return true;
        }
        return false;
    }

    public t c(t tVar, int i3, int i16) {
        if (tVar != null && tVar.f74046b != -1 && i3 != 0 && i16 != 0) {
            RenderBuffer renderBuffer = this.f73999a;
            if (renderBuffer == null || i3 != renderBuffer.getWidth() || i16 != this.f73999a.getHeight()) {
                RenderBuffer renderBuffer2 = this.f73999a;
                if (renderBuffer2 != null) {
                    renderBuffer2.destroy();
                }
                this.f73999a = new RenderBuffer(i3, i16, 33984);
            }
            this.f73999a.bind();
            this.f74000b.drawTexture(GLSLRender.GL_TEXTURE_2D, tVar.f74046b, this.f74001c, this.f74002d);
            this.f73999a.unbind();
            return t.a(0, this.f73999a.getTexId());
        }
        return null;
    }

    public void d(int i3) {
        if (this.f74003e == i3) {
            return;
        }
        Matrix.setIdentityM(this.f74002d, 0);
        if (i3 == 1) {
            Matrix.scaleM(this.f74002d, 0, -1.0f, 1.0f, 1.0f);
        } else if (i3 == 2) {
            Matrix.scaleM(this.f74002d, 0, 1.0f, -1.0f, 1.0f);
        }
        this.f74003e = i3;
        if (QLog.isDevelopLevel()) {
            QLog.i("ExtraRender", 4, "updateMatrix, mirrorFlag[" + i3 + "]");
        }
    }
}
