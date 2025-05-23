package com.tencent.av.opengl.effects;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes3.dex */
public class af implements x {

    /* renamed from: a, reason: collision with root package name */
    public final SurfaceTexture f73930a;

    /* renamed from: b, reason: collision with root package name */
    private final float[] f73931b;

    /* renamed from: c, reason: collision with root package name */
    private final float[] f73932c;

    /* renamed from: d, reason: collision with root package name */
    private int f73933d = 0;

    /* renamed from: e, reason: collision with root package name */
    private TextureRender f73934e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f73935f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.av.utils.o f73936g;

    public af(SurfaceTexture surfaceTexture) {
        if (QLog.isColorLevel()) {
            QLog.i("SurfaceTag", 2, "SurfacePreRender");
        }
        this.f73930a = surfaceTexture;
        com.tencent.avcore.camera.data.c.m("SurfaceMode");
        float[] fArr = new float[16];
        this.f73931b = fArr;
        Matrix.setIdentityM(fArr, 0);
        this.f73935f = true;
        float[] fArr2 = new float[16];
        this.f73932c = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        Matrix.scaleM(fArr2, 0, 1.0f, -1.0f, 1.0f);
        this.f73936g = new com.tencent.av.utils.o("SurfacePreRender", 2000L);
    }

    @Override // com.tencent.av.opengl.effects.x
    public t b(q qVar, com.tencent.avcore.camera.data.c cVar, t tVar) {
        boolean z16;
        com.tencent.av.utils.ab abVar = qVar.f74029o;
        if (abVar != null) {
            abVar.e("preRender");
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            cVar.n(this.f73931b);
        } catch (Throwable th5) {
            if (QLog.isDevelopLevel()) {
                QLog.i("SurfaceTag", 4, "render, surface[" + cVar.f77455o + "]", th5);
            }
        }
        this.f73936g.c(System.currentTimeMillis(), System.currentTimeMillis() - currentTimeMillis);
        boolean z17 = cVar.f77447g;
        this.f73935f = z17;
        if (z17) {
            Matrix.setIdentityM(this.f73932c, 0);
            boolean isFilterProcessPostRenderUserShader = ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).isFilterProcessPostRenderUserShader();
            if (cVar.f77451k == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (isFilterProcessPostRenderUserShader && !z16) {
                Matrix.scaleM(this.f73932c, 0, 1.0f, -1.0f, 1.0f);
            } else {
                Matrix.scaleM(this.f73932c, 0, -1.0f, -1.0f, 1.0f);
            }
        } else {
            Matrix.setIdentityM(this.f73932c, 0);
            Matrix.scaleM(this.f73932c, 0, 1.0f, -1.0f, 1.0f);
        }
        int i3 = cVar.f77443c;
        int i16 = cVar.f77442b;
        GLES20.glBindFramebuffer(36160, tVar.f74045a);
        GLES20.glViewport(0, 0, i3, i16);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        TextureRender textureRender = this.f73934e;
        if (textureRender != null) {
            textureRender.drawTexture(36197, this.f73933d, this.f73931b, this.f73932c);
        }
        GLES20.glBindFramebuffer(36160, 0);
        try {
            cVar.f77455o.releaseTexImage();
        } catch (Throwable th6) {
            if (QLog.isDevelopLevel()) {
                QLog.i("SurfaceTag", 4, ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, th6);
            }
        }
        com.tencent.av.utils.ab abVar2 = qVar.f74029o;
        if (abVar2 != null) {
            abVar2.d("preRender");
        }
        return tVar;
    }

    @Override // com.tencent.av.opengl.effects.r
    public void c() {
        this.f73934e = new TextureRender();
        this.f73933d = GlUtil.createTexture(36197);
        SurfaceTexture surfaceTexture = this.f73930a;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.detachFromGLContext();
            } catch (Throwable th5) {
                QLog.i("SurfaceTag", 2, "genTexture1", th5);
            }
            try {
                this.f73930a.attachToGLContext(this.f73933d);
            } catch (Throwable th6) {
                QLog.i("SurfaceTag", 2, "genTexture2", th6);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("SurfaceTag", 2, "genTexture");
        }
    }

    @Override // com.tencent.av.opengl.effects.x
    public boolean d(com.tencent.avcore.camera.data.c cVar) {
        SurfaceTexture surfaceTexture;
        if (cVar != null && (surfaceTexture = cVar.f77455o) != null && surfaceTexture == this.f73930a) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.av.opengl.effects.r
    public void f() {
        SurfaceTexture surfaceTexture = this.f73930a;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.detachFromGLContext();
            } catch (Throwable th5) {
                QLog.i("SurfaceTag", 2, "delTexture", th5);
            }
        }
        GLES20.glDeleteTextures(1, new int[]{this.f73933d}, 0);
        if (QLog.isColorLevel()) {
            QLog.i("SurfaceTag", 2, "delTexture");
        }
    }

    @Override // com.tencent.av.opengl.effects.r
    public void a() {
    }

    @Override // com.tencent.av.opengl.effects.r
    public void g(int i3, int i16) {
    }
}
