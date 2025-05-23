package com.tencent.qcircle.weseevideo.model.effect;

import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectType;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CropModel extends BaseEffectModel {
    private CropConfig cropConfig;
    private int effectType = VideoEffectType.TYPE_CROP.value;

    public CropConfig getCropConfig() {
        return this.cropConfig;
    }

    public void setCropConfig(CropConfig cropConfig) {
        this.cropConfig = cropConfig;
    }
}
