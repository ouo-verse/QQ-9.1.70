package com.tencent.taveffect.core;

import android.graphics.Matrix;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class TAVBaseFilter implements TAVTextureProcessor, Cloneable {
    protected TAVRectangle cropRect;
    protected String fragmentShaderCode;
    protected boolean overlay;
    protected int program;
    protected int rendererHeight;
    protected int rendererWidth;
    protected Matrix stMatrix;
    protected int stMatrixHandle;
    protected int textureType;
    protected TAVTimeRange timeRange;
    protected String vertexShaderCode;
    protected Matrix xyMatrix;
    protected int xyMatrixHandle;
    protected final String TAG = getClass().getSimpleName();

    /* renamed from: id, reason: collision with root package name */
    protected long f374470id = System.nanoTime();
    protected int[] defaultViewport = new int[4];
    protected float alpha = 1.0f;

    public TAVTextureInfo applyFilter(TAVTextureInfo tAVTextureInfo) {
        if (isValid(tAVTextureInfo)) {
            TAVTextureInfo applyNewTexture = applyNewTexture(tAVTextureInfo);
            onProcess(applyNewTexture);
            return applyNewTexture;
        }
        return tAVTextureInfo;
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVBaseFilter mo93clone() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends TAVBaseFilter> T cloneFilter(T t16) {
        TAVTimeRange tAVTimeRange = this.timeRange;
        if (tAVTimeRange != null) {
            t16.setTimeRange(new TAVTimeRange(tAVTimeRange.start(), this.timeRange.duration()));
        }
        t16.setRendererWidth(this.rendererWidth);
        t16.setRendererWidth(this.rendererHeight);
        t16.setOverlay(this.overlay);
        t16.alpha = this.alpha;
        t16.cropRect = this.cropRect;
        t16.xyMatrix = this.xyMatrix;
        t16.stMatrix = this.stMatrix;
        t16.f374470id = this.f374470id;
        return t16;
    }

    public long getId() {
        return this.f374470id;
    }

    public TAVTimeRange getTimeRange() {
        return this.timeRange;
    }

    public boolean isOverlay() {
        return this.overlay;
    }

    protected boolean isValid(TAVTextureInfo tAVTextureInfo) {
        TAVTimeRange tAVTimeRange = this.timeRange;
        if (tAVTimeRange == null) {
            return true;
        }
        return tAVTimeRange.contain(tAVTextureInfo.frameTimeUs);
    }

    public void setOverlay(boolean z16) {
        this.overlay = z16;
    }

    public void setRendererHeight(int i3) {
        this.rendererHeight = i3;
    }

    public void setRendererWidth(int i3) {
        this.rendererWidth = i3;
    }

    public void setTimeRange(TAVTimeRange tAVTimeRange) {
        this.timeRange = tAVTimeRange;
    }

    @Override // com.tencent.taveffect.core.TAVTextureProcessor
    public void onProcess(TAVTextureInfo tAVTextureInfo) {
    }

    public void setParams(Matrix matrix, Matrix matrix2, TAVRectangle tAVRectangle, float f16) {
    }
}
