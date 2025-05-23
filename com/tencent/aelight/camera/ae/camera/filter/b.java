package com.tencent.aelight.camera.ae.camera.filter;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.filter.GLSLRender;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.view.RendererUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends FilterProcessBase {
    private TextureRender D;
    private RenderBuffer E;
    private RenderBuffer F;

    private void x(int i3, int i16, int i17) {
        try {
            if (this.F == null) {
                this.F = new RenderBuffer(this.f62253e, this.f62254f, 33984);
            }
            this.F.bind();
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
            this.D.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, fArr);
            this.F.unbind();
            Bitmap saveTexture = RendererUtils.saveTexture(this.F.getTexId(), i16, i17);
            AEFilterProcessTex.c cVar = this.f62270v;
            if (cVar != null) {
                cVar.onPhotoCaptured(saveTexture);
            }
        } catch (OutOfMemoryError unused) {
            AEFilterProcessTex.c cVar2 = this.f62270v;
            if (cVar2 != null) {
                cVar2.onCaptureError(103);
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
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
        SurfaceTexture surfaceTexture = this.f62265q;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(null);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
    public void i() {
        this.D = new TextureRender();
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
    public int[] s(int i3, int i16, boolean z16) {
        if (this.f62255g != 0 && this.f62256h != 0) {
            boolean z17 = this.f62268t;
            if (this.E == null) {
                this.E = new RenderBuffer(this.f62255g, this.f62256h, 33984);
            }
            this.E.bind();
            int i17 = this.f62253e;
            int i18 = (int) (i17 / this.f62260l);
            this.D.drawTexture(36197, this.f62264p, this.f62267s, GPUBaseFilter.caculateCenterCropMvpMatrix(this.f62255g, this.f62256h, i17, i18));
            this.E.unbind();
            int texId = this.E.getTexId();
            y(texId, i3, i16);
            if (z17) {
                x(texId, i17, i18);
                this.f62268t = false;
            }
            int[] iArr = this.f62266r;
            iArr[0] = texId;
            iArr[1] = texId;
            return iArr;
        }
        return this.f62266r;
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
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

    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
    public void d(boolean z16) {
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
    public void u(float f16) {
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
    public void m() {
    }
}
