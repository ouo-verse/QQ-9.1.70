package com.tencent.mobileqq.wink.edit.bean;

import java.io.Serializable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class AEFilterExtendBean implements Serializable {
    private Map<String, String> adjustParams;
    private float defaultEffectAlpha = 1.0f;
    private float glowStrength = 0.0f;
    private String lutID;
    private String motionID;

    public Map<String, String> getAdjustParams() {
        return this.adjustParams;
    }

    public float getDefaultEffectAlpha() {
        return this.defaultEffectAlpha;
    }

    public float getGlowStrength() {
        return this.glowStrength;
    }

    public String getLutID() {
        return this.lutID;
    }

    public String getMotionID() {
        return this.motionID;
    }
}
