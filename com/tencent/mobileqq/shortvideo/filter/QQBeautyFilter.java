package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQBeautyFilter extends QQBaseFilter {
    public static int sBeautyLevel = -1;
    private boolean bwork;
    private boolean isLevel0;
    private int lastHeight;
    private int lastWidth;
    private BeautyRender mBeautyRender;
    private float mediaCodecRate;

    public QQBeautyFilter(int i3, QQFilterRenderManager qQFilterRenderManager) {
        super(i3, qQFilterRenderManager);
        this.bwork = false;
        this.mediaCodecRate = 1.0f;
        this.lastWidth = 0;
        this.lastHeight = 0;
    }

    private boolean beNeedShowBeauty() {
        if (!SdkContext.getInstance().getDpcSwitcher().isBeautySwitchOpen() || this.isLevel0 || QmcfManager.getInstance().isQmcfNoNeedBeauty() || getQQFilterRenderManager().getBusinessOperation().getAVFilterFilterType() == 3) {
            return false;
        }
        return true;
    }

    private void initBeautyRender() {
        if (this.mBeautyRender == null) {
            this.mBeautyRender = new BeautyRender(SdkContext.getInstance().getApplication(), SdkContext.getInstance().getResources().getBeautyResource().getBeautyFilePath());
            int i3 = sBeautyLevel;
            if (i3 >= 0) {
                updateBeautyFilter(i3);
            }
        }
        this.mediaCodecRate = SdkContext.getInstance().getDpcSwitcher().getBeatyRate();
    }

    private boolean needSkinColor() {
        int aVFilterFilterType = getQQFilterRenderManager().getBusinessOperation().getAVFilterFilterType();
        if (aVFilterFilterType != 1 && aVFilterFilterType != 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean isFilterWork() {
        return this.bwork;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        BeautyRender beautyRender = this.mBeautyRender;
        if (beautyRender == null) {
            initBeautyRender();
            this.mOutputTextureID = this.mInputTextureID;
            return;
        }
        if (beautyRender != null && beNeedShowBeauty()) {
            this.mBeautyRender.setNeedSkinColor(needSkinColor());
            this.lastWidth = getQQFilterRenderManager().getFilterWidth();
            int filterHeight = getQQFilterRenderManager().getFilterHeight();
            this.lastHeight = filterHeight;
            this.mOutputTextureID = this.mBeautyRender.process(this.mInputTextureID, -1, this.lastWidth, filterHeight).getTextureId();
            QQFilterLogManager.setFilterStatus("QQBeautyFilter", true);
            this.bwork = true;
            return;
        }
        this.mOutputTextureID = this.mInputTextureID;
        QQFilterLogManager.setFilterStatus("QQBeautyFilter", false);
        this.bwork = false;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        BeautyRender beautyRender;
        int i17 = this.lastHeight;
        if ((i17 != i3 || i17 != i16) && (beautyRender = this.mBeautyRender) != null) {
            beautyRender.destroy();
            this.mBeautyRender = null;
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        BeautyRender beautyRender = this.mBeautyRender;
        if (beautyRender != null) {
            beautyRender.destroy();
            this.mBeautyRender = null;
        }
    }

    public void updateBeautyFilter(float f16) {
        boolean z16;
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isLevel0 = z16;
        float f17 = f16 / 100.0f;
        BeautyRender beautyRender = this.mBeautyRender;
        if (beautyRender != null) {
            beautyRender.setBeautyLevel(f17 * this.mediaCodecRate);
            if (SLog.isEnable()) {
                SLog.i("FilterBeauty", "setBeautyLevel " + f16 + " rate: " + this.mediaCodecRate);
            }
        }
    }

    public void updateBeautyFilterParam(float f16, float f17, float f18) {
        boolean z16;
        if (f16 == 0.0f && f17 == 0.0f && f18 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isLevel0 = z16;
        BeautyRender beautyRender = this.mBeautyRender;
        if (beautyRender != null) {
            float f19 = this.mediaCodecRate;
            beautyRender.setBeautyLevel(f16 * f19, f17 * f19, f18 * f19);
        }
    }
}
