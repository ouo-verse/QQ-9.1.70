package com.tencent.mobileqq.shortvideo.filter;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQBaseFilter {
    static final int CREATED = 1;
    static final int INITED = 2;
    static final int UNINIT = 0;
    protected boolean mCaptureMode;
    private QQFilterRenderManager mFilterRenderManagerInstance;
    protected int mFilterType;
    protected int mInputTextureID;
    protected int mOutputTextureID;
    protected Object mSpecificParam;
    protected int mStatus = 0;
    protected AtomicInteger mQuoteCount = new AtomicInteger(0);

    public QQBaseFilter(int i3, QQFilterRenderManager qQFilterRenderManager) {
        this.mFilterRenderManagerInstance = null;
        this.mFilterType = i3;
        this.mFilterRenderManagerInstance = qQFilterRenderManager;
    }

    public int getFilterType() {
        return this.mFilterType;
    }

    public int getIntputTextureID() {
        return this.mInputTextureID;
    }

    public int getOutputTextureID() {
        return this.mOutputTextureID;
    }

    public QQFilterRenderManager getQQFilterRenderManager() {
        return this.mFilterRenderManagerInstance;
    }

    public Object getSpecificParam() {
        return this.mSpecificParam;
    }

    public boolean isFilterWork() {
        return false;
    }

    public boolean needFaceDetect() {
        return false;
    }

    public void setCaptureMode(boolean z16) {
        this.mCaptureMode = z16;
    }

    public void setInputTextureID(int i3) {
        this.mInputTextureID = i3;
    }

    public void setOutputTextureID(int i3) {
        this.mOutputTextureID = i3;
    }

    public void setSpecificParam(Object obj) {
        this.mSpecificParam = obj;
        parseSpecificParam();
    }

    public void onDrawFrame() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onSurfaceCreate() {
    }

    public void onSurfaceDestroy() {
    }

    protected void parseSpecificParam() {
    }

    public void onChangeCamera(int i3) {
    }

    public void onSurfaceChange(int i3, int i16) {
    }
}
