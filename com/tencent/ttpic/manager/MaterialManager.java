package com.tencent.ttpic.manager;

import com.tencent.ttpic.openapi.model.VideoMaterial;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum MaterialManager {
    INSTANCE;

    private VideoMaterial material;

    public static MaterialManager getInstance() {
        return INSTANCE;
    }

    public VideoMaterial getCurrentMaterial() {
        return this.material;
    }

    public void setCurrentMaterial(VideoMaterial videoMaterial) {
        if (videoMaterial == null) {
            return;
        }
        this.material = videoMaterial;
    }
}
