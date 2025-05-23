package com.tencent.qcircle.weseevideo.composition.effectnode;

import com.tencent.aekit.api.standard.filter.AEAdjust;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.qcircle.weseevideo.composition.filter.MotionBlurFilter;
import com.tencent.qcircle.weseevideo.composition.filter.VignettingFilter2;
import com.tencent.ttpic.openapi.config.AdjustRealConfig;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class EnhancedAEAdjust extends AEAdjust {
    private boolean mHasMotionBlur;
    private VignettingFilter2 mVignettingFilter2 = new VignettingFilter2();
    private MotionBlurFilter mMotionBlurFilter = new MotionBlurFilter();

    private float parseFloat(HashMap<String, String> hashMap, String str) {
        String str2 = hashMap.get(str);
        if (str2 == null) {
            return 0.0f;
        }
        return Float.parseFloat(str2);
    }

    private int parseInteger(HashMap<String, String> hashMap, String str) {
        String str2 = hashMap.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.parseInt(str2);
    }

    private void setMotionBlurLevel(HashMap<String, String> hashMap) {
        this.mHasMotionBlur = false;
        this.mMotionBlurFilter.resetParameters();
        if (hashMap != null && parseFloat(hashMap, "motionBlurSize") > 0.0f) {
            this.mHasMotionBlur = true;
            this.mMotionBlurFilter.setParameters(parseFloat(hashMap, "motionBlurSize"), parseFloat(hashMap, "motionBlurAreaCenterX"), parseFloat(hashMap, "motionBlurAreaCenterY"), parseFloat(hashMap, "motionBlurAreaHorizontalAxis"), parseFloat(hashMap, "motionBlurAreaVerticalAxis"), parseInteger(hashMap, "motionBlurNumSamples"), parseFloat(hashMap, "motionBlurAreaGradientRatio"), parseInteger(hashMap, "motionBlurAngle"));
        }
    }

    private void setVignettingLevel(HashMap<String, String> hashMap) {
        VignettingFilter2 vignettingFilter2 = this.mVignettingFilter2;
        if (vignettingFilter2 != null) {
            vignettingFilter2.setAlpha(0.0f);
            if (hashMap != null) {
                float parseFloat = parseFloat(hashMap, "vignettingValue");
                if (parseFloat > 0.0f) {
                    this.mVignettingFilter2.setAlpha(parseFloat / 100.0f);
                }
            }
        }
    }

    public void apply() {
        if (!this.mIsApplied) {
            VignettingFilter2 vignettingFilter2 = this.mVignettingFilter2;
            if (vignettingFilter2 != null) {
                vignettingFilter2.applyFilterChain(true, 0.0f, 0.0f);
            }
            MotionBlurFilter motionBlurFilter = this.mMotionBlurFilter;
            if (motionBlurFilter != null) {
                motionBlurFilter.applyFilterChain(true, 0.0f, 0.0f);
            }
        }
        super.apply();
    }

    public void clear() {
        VignettingFilter2 vignettingFilter2 = this.mVignettingFilter2;
        if (vignettingFilter2 != null) {
            vignettingFilter2.clearGLSLSelf();
            this.mVignettingFilter2 = null;
        }
        MotionBlurFilter motionBlurFilter = this.mMotionBlurFilter;
        if (motionBlurFilter != null) {
            motionBlurFilter.clearGLSLSelf();
            this.mMotionBlurFilter = null;
        }
        super.clear();
    }

    public Frame render(Frame frame) {
        Frame render = super.render(frame);
        if (getAlpha() == 0.0f) {
            return render;
        }
        Frame render2 = this.mVignettingFilter2.render(render);
        if (render != render2) {
            render.unlock();
        }
        if (!this.mHasMotionBlur) {
            return render2;
        }
        Frame render3 = this.mMotionBlurFilter.render(render2);
        if (render2 != render3) {
            render2.unlock();
        }
        return render3;
    }

    public void setAdjustParams(HashMap<String, String> hashMap) {
        for (AdjustRealConfig.TYPE type : AdjustRealConfig.TYPE.values()) {
            setAdjustLevel(type, 0);
        }
        super.setAdjustParams(hashMap);
        setVignettingLevel(hashMap);
        setMotionBlurLevel(hashMap);
    }
}
