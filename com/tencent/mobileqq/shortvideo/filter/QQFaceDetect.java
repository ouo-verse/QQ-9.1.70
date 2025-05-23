package com.tencent.mobileqq.shortvideo.filter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQFaceDetect extends QQBaseFilter {
    public QQFaceDetect(QQFilterRenderManager qQFilterRenderManager) {
        super(999, qQFilterRenderManager);
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean needFaceDetect() {
        return true;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        this.mOutputTextureID = this.mInputTextureID;
    }
}
