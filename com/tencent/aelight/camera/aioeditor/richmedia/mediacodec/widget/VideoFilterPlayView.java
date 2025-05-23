package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.biz.qqstory.utils.k;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filter.GpuImagePartsFilterGroup;
import com.tencent.mobileqq.filter.a;
import com.tencent.mobileqq.filter.c;
import com.tencent.mobileqq.filter.f;
import com.tencent.mobileqq.filter.g;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterConstants;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQTransferFilter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes32.dex */
public class VideoFilterPlayView extends HWVideoPlayView {

    /* renamed from: y0, reason: collision with root package name */
    public static int f67513y0;

    /* renamed from: f0, reason: collision with root package name */
    private g f67514f0;

    /* renamed from: g0, reason: collision with root package name */
    private GpuImagePartsFilterGroup f67515g0;

    /* renamed from: h0, reason: collision with root package name */
    private GPUBaseFilter f67516h0;

    /* renamed from: i0, reason: collision with root package name */
    private GPUBaseFilter f67517i0;

    /* renamed from: j0, reason: collision with root package name */
    private GPUBaseFilter f67518j0;

    /* renamed from: k0, reason: collision with root package name */
    private RenderBuffer f67519k0;

    /* renamed from: l0, reason: collision with root package name */
    private RenderBuffer f67520l0;

    /* renamed from: m0, reason: collision with root package name */
    private final LinkedList<Runnable> f67521m0;

    /* renamed from: n0, reason: collision with root package name */
    private QQFilterRenderManager f67522n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f67523o0;

    /* renamed from: p0, reason: collision with root package name */
    protected boolean f67524p0;

    /* renamed from: q0, reason: collision with root package name */
    protected boolean f67525q0;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f67526r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f67527s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f67528t0;

    /* renamed from: u0, reason: collision with root package name */
    private ByteBuffer f67529u0;

    /* renamed from: v0, reason: collision with root package name */
    private byte[] f67530v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f67531w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f67532x0;

    public VideoFilterPlayView(Context context) {
        this(context, null);
    }

    private void I() {
        QQFilterRenderManager a16 = f.a();
        this.f67522n0 = a16;
        f.d(a16);
    }

    private void L(LinkedList<Runnable> linkedList) {
        synchronized (linkedList) {
            while (!linkedList.isEmpty()) {
                Runnable poll = linkedList.poll();
                if (poll != null) {
                    poll.run();
                }
            }
        }
    }

    public void H(int i3) {
        this.f67514f0 = new g(i3);
    }

    protected void M(Runnable runnable) {
        synchronized (this.f67521m0) {
            this.f67521m0.add(runnable);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView
    public void h(long j3, long j16) {
        super.h(j3, j16);
        QQFilterRenderManager qQFilterRenderManager = this.f67522n0;
        if (qQFilterRenderManager != null) {
            qQFilterRenderManager.getBusinessOperation().SetTimeStamp(j3, j16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView
    public void i(float[] fArr, float[] fArr2) {
        if (this.f67523o0) {
            return;
        }
        if (this.f67524p0 && this.f67525q0) {
            if (this.f67526r0) {
                fArr2 = new float[16];
                Matrix.setIdentityM(fArr2, 0);
            } else {
                fArr2 = GPUBaseFilter.caculateFitCenterMvpMatrix(this.C, this.D, this.f67507i, this.f67508m);
            }
        }
        L(this.f67521m0);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        Matrix.rotateM(fArr2, 0, this.I, 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(fArr2, 0, 1.0f, -1.0f, 1.0f);
        this.f67519k0.bind();
        super.i(fArr, fArr2);
        this.f67519k0.unbind();
        RenderBuffer renderBuffer = this.f67519k0;
        int texId = renderBuffer.getTexId();
        if (this.f67514f0 != null) {
            renderBuffer.bind();
            texId = this.f67514f0.c(texId);
            renderBuffer.unbind();
        }
        QQFilterRenderManager qQFilterRenderManager = this.f67522n0;
        if (qQFilterRenderManager != null) {
            qQFilterRenderManager.setParam(QQFilterConstants.FilterParameters.KEY_DRAW_SCREEN, String.valueOf(false));
            this.f67522n0.setParam(QQFilterConstants.FilterParameters.KEY_WIDTH, String.valueOf(this.C));
            this.f67522n0.setParam(QQFilterConstants.FilterParameters.KEY_HEIGHT, String.valueOf(this.D));
            int drawFrame = this.f67522n0.drawFrame(texId);
            if (drawFrame != -1) {
                texId = drawFrame;
            }
        }
        RenderBuffer renderBuffer2 = this.f67519k0;
        if (renderBuffer == renderBuffer2) {
            renderBuffer2 = this.f67520l0;
        }
        renderBuffer2.bind();
        this.f67517i0.drawTexture(texId, null, null);
        int texId2 = renderBuffer2.getTexId();
        renderBuffer2.unbind();
        this.f67515g0.h();
        if (this.f67515g0.e()) {
            RenderBuffer renderBuffer3 = this.f67519k0;
            if (renderBuffer2 == renderBuffer3) {
                renderBuffer3 = this.f67520l0;
            }
            renderBuffer2 = renderBuffer3;
            renderBuffer2.bind();
            this.f67515g0.drawTexture(texId2, null, null);
            texId2 = renderBuffer2.getTexId();
            renderBuffer2.unbind();
        }
        if (this.f67532x0) {
            K(renderBuffer2, this.C, this.D);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.f67507i, this.f67508m);
        float[] fArr3 = new float[16];
        Matrix.setIdentityM(fArr3, 0);
        Matrix.scaleM(fArr3, 0, 1.0f, -1.0f, 1.0f);
        this.f67516h0.drawTexture(texId2, null, fArr3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView
    public void k() {
        super.k();
        RenderBuffer renderBuffer = this.f67519k0;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
        RenderBuffer renderBuffer2 = this.f67520l0;
        if (renderBuffer2 != null) {
            renderBuffer2.destroy();
        }
        ByteBuffer byteBuffer = this.f67529u0;
        if (byteBuffer != null) {
            byteBuffer.clear();
            this.f67529u0 = null;
        }
        GPUBaseFilter gPUBaseFilter = this.f67517i0;
        if (gPUBaseFilter != null) {
            gPUBaseFilter.destroy();
            this.f67517i0 = null;
        }
        g gVar = this.f67514f0;
        if (gVar != null) {
            gVar.f();
        }
        GPUBaseFilter gPUBaseFilter2 = this.f67518j0;
        if (gPUBaseFilter2 != null) {
            gPUBaseFilter2.destroy();
            this.f67518j0 = null;
        }
        GpuImagePartsFilterGroup gpuImagePartsFilterGroup = this.f67515g0;
        if (gpuImagePartsFilterGroup != null) {
            gpuImagePartsFilterGroup.destroy();
            this.f67515g0 = null;
        }
        QQFilterRenderManager qQFilterRenderManager = this.f67522n0;
        if (qQFilterRenderManager != null) {
            qQFilterRenderManager.surfaceDestroyed();
            this.f67523o0 = true;
            QQFilterRenderManager a16 = f.a();
            this.f67522n0 = a16;
            f.d(a16);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.F) {
            int i17 = this.E;
            if (i17 == 0) {
                int size = View.MeasureSpec.getSize(i3);
                int size2 = View.MeasureSpec.getSize(i16);
                int i18 = this.C;
                int i19 = this.D;
                if (i18 * i19 > 0 && size * i19 != size2 * i18) {
                    i16 = View.MeasureSpec.makeMeasureSpec((size * i19) / i18, 1073741824);
                    this.E = i16;
                }
            } else {
                i16 = i17;
            }
        }
        super.onMeasure(i3, i16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.e("VideoFilterPlayView", 4, "onSurfaceChanged : " + gl10.hashCode());
        }
        if (this.f67528t0) {
            if (this.U && this.f67507i == i3 && this.f67508m == i16) {
                return;
            }
            this.U = true;
            super.onSurfaceChanged(gl10, i3, i16);
            this.f67519k0 = new RenderBuffer(this.C, this.D, 33984);
            this.f67520l0 = new RenderBuffer(this.C, this.D, 33984);
            GpuImagePartsFilterGroup gpuImagePartsFilterGroup = this.f67515g0;
            if (gpuImagePartsFilterGroup != null) {
                gpuImagePartsFilterGroup.onOutputSizeChanged(this.C, this.D);
            }
            g gVar = this.f67514f0;
            if (gVar != null) {
                gVar.d(this.C, this.D);
            }
            this.f67516h0.onOutputSizeChanged(this.C, this.D);
            if (this.f67529u0 == null) {
                try {
                    byte[] bArr = new byte[this.C * this.D * 4];
                    this.f67530v0 = bArr;
                    this.f67529u0 = ByteBuffer.wrap(bArr);
                } catch (OutOfMemoryError e16) {
                    QLog.e("VideoFilterPlayView", 1, "init trackByteBuffer failed ", e16);
                    ByteBuffer byteBuffer = this.f67529u0;
                    if (byteBuffer != null) {
                        byteBuffer.clear();
                        this.f67529u0 = null;
                    }
                }
            }
            QQFilterRenderManager qQFilterRenderManager = this.f67522n0;
            if (qQFilterRenderManager != null) {
                qQFilterRenderManager.surfaceChange(this.C, this.D, this.f67507i, this.f67508m);
                this.f67523o0 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoFilterPlayView", 2, "onSurfaceChanged");
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        super.onSurfaceCreated(gl10, eGLConfig);
        AEResUtil.k0();
        if (VideoEnvironment.loadAVCodecSo() != 0) {
            final WeakReference weakReference = new WeakReference((Activity) getContext());
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.VideoFilterPlayView.2
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity = (Activity) weakReference.get();
                    if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
                        return;
                    }
                    activity.finish();
                }
            });
            this.f67528t0 = false;
            QLog.e("VideoFilterPlayView", 1, "onSurfaceCreated : Load so fail");
            return;
        }
        this.U = false;
        GPUBaseFilter a16 = a.a(101);
        this.f67517i0 = a16;
        this.f67516h0 = a16;
        a16.init();
        GPUBaseFilter gPUBaseFilter = this.f67518j0;
        if (gPUBaseFilter != null) {
            this.f67516h0 = gPUBaseFilter;
            gPUBaseFilter.initForce();
        }
        GpuImagePartsFilterGroup gpuImagePartsFilterGroup = new GpuImagePartsFilterGroup();
        this.f67515g0 = gpuImagePartsFilterGroup;
        gpuImagePartsFilterGroup.init();
        g gVar = this.f67514f0;
        if (gVar != null) {
            gVar.e(this.G, this.H, this.C, this.D);
        }
        QQFilterRenderManager qQFilterRenderManager = this.f67522n0;
        if (qQFilterRenderManager != null) {
            qQFilterRenderManager.surfaceCreate(this.C, this.D, this.f67507i, this.f67508m);
            this.f67523o0 = false;
            if (QLog.isColorLevel()) {
                QLog.w("VideoFilterPlayView", 2, "mFilterProcess, surfaceCreated success");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoFilterPlayView", 2, "onSurfaceCreated");
        }
    }

    public void setColorFilterType(int i3) {
        GpuImagePartsFilterGroup gpuImagePartsFilterGroup = this.f67515g0;
        if (gpuImagePartsFilterGroup != null) {
            if (gpuImagePartsFilterGroup.e() || i3 != 0) {
                this.f67515g0.i(i3, this.f67507i, this.f67508m);
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView
    public void setFilePath(String str, String str2) {
        super.setFilePath(str, str2);
    }

    @Override // com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView
    public void setSpeedType(final int i3) {
        super.setSpeedType(i3);
        M(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.VideoFilterPlayView.3
            @Override // java.lang.Runnable
            public void run() {
                List<QQBaseFilter> qQFilters;
                if (VideoFilterPlayView.this.f67522n0 == null || (qQFilters = VideoFilterPlayView.this.f67522n0.getQQFilters(160)) == null || qQFilters.size() <= 0 || !(qQFilters.get(0) instanceof QQTransferFilter)) {
                    return;
                }
                ((QQTransferFilter) qQFilters.get(0)).setSpeedRate(HWVideoDecoder.getSpeedRate(i3));
            }
        });
    }

    public void setTransferData(final TransferData transferData) {
        M(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.VideoFilterPlayView.4
            @Override // java.lang.Runnable
            public void run() {
                if (VideoFilterPlayView.this.f67522n0 != null) {
                    if (!VideoFilterPlayView.this.f67522n0.hasQQFilter(160)) {
                        VideoFilterPlayView.this.f67522n0.pushChainBasedStackTopChain(160, null);
                    }
                    List<QQBaseFilter> qQFilters = VideoFilterPlayView.this.f67522n0.getQQFilters(160);
                    if (qQFilters == null || qQFilters.size() <= 0 || !(qQFilters.get(0) instanceof QQTransferFilter)) {
                        return;
                    }
                    QQTransferFilter qQTransferFilter = (QQTransferFilter) qQFilters.get(0);
                    qQTransferFilter.setTransferData(transferData);
                    qQTransferFilter.setSpeedRate(HWVideoDecoder.getSpeedRate(VideoFilterPlayView.this.f()));
                }
            }
        });
    }

    public VideoFilterPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f67523o0 = false;
        this.f67527s0 = 0;
        this.f67528t0 = true;
        this.f67531w0 = false;
        this.f67532x0 = false;
        this.f67521m0 = new LinkedList<>();
        I();
        int i3 = f67513y0 + 1;
        f67513y0 = i3;
        this.f67527s0 = i3;
    }

    public void setFilePath(String str, String str2, boolean z16, boolean z17, boolean z18) {
        this.f67524p0 = z16;
        this.f67525q0 = z17;
        this.f67526r0 = z18;
        setFilePath(str, str2);
        if (this.f67524p0 && this.f67526r0) {
            Pair<Integer, Integer> b16 = k.b(this.C, this.D, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT);
            this.C = ((Integer) b16.first).intValue();
            this.D = ((Integer) b16.second).intValue();
        }
    }

    public void setMosaicFilterType(Bitmap bitmap) {
        if (bitmap == null) {
            this.f67516h0 = this.f67517i0;
            this.f67518j0 = null;
            return;
        }
        if (this.f67518j0 == null) {
            this.f67518j0 = a.a(106);
            M(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.VideoFilterPlayView.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoFilterPlayView.this.f67518j0.init();
                    GPUBaseFilter gPUBaseFilter = VideoFilterPlayView.this.f67518j0;
                    VideoFilterPlayView videoFilterPlayView = VideoFilterPlayView.this;
                    gPUBaseFilter.onOutputSizeChanged(videoFilterPlayView.C, videoFilterPlayView.D);
                }
            });
        }
        ((c) this.f67518j0).c(bitmap);
        this.f67516h0 = this.f67518j0;
    }

    public void setColorFilterType(int i3, int i16, float f16, int i17) {
        this.f67515g0.j(i3, i16, f16, i17, this.f67507i, this.f67508m);
    }

    public void K(RenderBuffer renderBuffer, int i3, int i16) {
        ByteBuffer byteBuffer;
        int texId = renderBuffer != null ? renderBuffer.getTexId() : 0;
        if (this.f67530v0 != null && (byteBuffer = this.f67529u0) != null) {
            byteBuffer.rewind();
            try {
                if (texId != 0) {
                    GLES20.glGenFramebuffers(1, r6, 0);
                    GLES20.glBindFramebuffer(36160, r6[0]);
                    GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, texId, 0);
                    GLES20.glReadPixels(0, 0, i3, i16, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.f67529u0);
                    GLES20.glBindFramebuffer(36160, 0);
                    GLES20.glDeleteFramebuffers(1, r6, 0);
                    int[] iArr = {0};
                } else {
                    GLES20.glReadPixels(0, 0, i3, i16, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.f67529u0);
                }
                this.f67532x0 = false;
                return;
            } catch (Exception e16) {
                this.f67529u0.clear();
                if (QLog.isColorLevel()) {
                    QLog.e("VideoFilterPlayView", 2, "readTextureToBuffer error " + e16.toString());
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("VideoFilterPlayView", 2, "readTextureToBuffer trackData is null ");
        }
    }

    public void J() {
    }
}
