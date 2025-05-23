package com.tencent.aelight.camera.ae.flashshow.filter;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessTex;
import com.tencent.filter.GLSLRender;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.view.RendererUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends LSFilterProcessBase {
    private TextureRender D;
    private RenderBuffer E;
    private RenderBuffer F;

    private void x(int i3, int i16, int i17) {
        try {
            if (this.F == null) {
                this.F = new RenderBuffer(this.f64259e, this.f64260f, 33984);
            }
            this.F.bind();
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
            this.D.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, fArr);
            this.F.unbind();
            Bitmap saveTexture = RendererUtils.saveTexture(this.F.getTexId(), i16, i17);
            LSFilterProcessTex.d dVar = this.f64276v;
            if (dVar != null) {
                dVar.onPhotoCaptured(saveTexture);
            }
        } catch (OutOfMemoryError unused) {
            LSFilterProcessTex.d dVar2 = this.f64276v;
            if (dVar2 != null) {
                dVar2.onCaptureError(103);
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase
    public void c() {
        TextureRender textureRender = this.D;
        if (textureRender != null) {
            textureRender.release();
        }
        RenderBuffer renderBuffer = this.E;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
        RenderBuffer renderBuffer2 = this.F;
        if (renderBuffer2 != null) {
            renderBuffer2.destroy();
        }
        SurfaceTexture surfaceTexture = this.f64271q;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(null);
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase
    public void i() {
        this.D = new TextureRender();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase
    public int[] s(int i3, int i16, boolean z16) {
        if (this.f64261g != 0 && this.f64262h != 0) {
            boolean z17 = this.f64274t;
            if (this.E == null) {
                this.E = new RenderBuffer(this.f64261g, this.f64262h, 33984);
            }
            this.E.bind();
            int i17 = this.f64259e;
            int i18 = (int) (i17 / this.f64266l);
            this.D.drawTexture(36197, this.f64270p, this.f64273s, GPUBaseFilter.caculateCenterCropMvpMatrix(this.f64261g, this.f64262h, i17, i18));
            this.E.unbind();
            int texId = this.E.getTexId();
            y(texId, i3, i16);
            if (z17) {
                x(texId, i17, i18);
                this.f64274t = false;
            }
            int[] iArr = this.f64272r;
            iArr[0] = texId;
            iArr[1] = texId;
            return iArr;
        }
        return this.f64272r;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase
    public void v(int i3, int i16, int i17, int i18, int i19, int i26) {
        super.v(i3, i16, i17, i18, i19, i26);
    }

    protected void y(int i3, int i16, int i17) {
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, i16, i17);
        GLES20.glClearColor(0.92f, 0.93f, 0.96f, 1.0f);
        GLES20.glClear(16384);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        this.D.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, null);
        GLES20.glDisable(3042);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase
    public void d(boolean z16) {
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase
    public void u(float f16) {
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase
    public void m() {
    }
}
