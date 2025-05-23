package com.tencent.qfsmonet.api.module;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IMonetModule {
    public static final String SINGLE_INPUT_COLOR_BLINDNESS = "MonetColorBlindnessModule";
    public static final String SINGLE_INPUT_COLOR_CORRECT = "MonetColorCorrectionModule";
    public static final String SINGLE_INPUT_DENOISE_TME = "MonetTMEDenoiseModule";
    public static final String SINGLE_INPUT_GAUSSIAN_BLUR_VIDEO_LAYOUT = "MonetGaussianBlurVideoOverlayModule";
    public static final String SINGLE_INPUT_MODULE_CHAIN = "MonetModuleChain";
    public static final String SINGLE_INPUT_PATCH = "MonetPatchModule";
    public static final String SINGLE_INPUT_SDR_ENHANCE = "MonetSDREnhanceModule";
    public static final String SINGLE_INPUT_SUPER_RESOLUTION = "MonetSuperResolutionModule";
    public static final String SINGLE_INPUT_SUPER_RESOLUTION_TME = "MonetTMESuperResolutionModule";
    public static final String SINGLE_INPUT_VR_PANORAMA = "MonetVRPanoramaModule";

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface MonetModuleType {
    }

    String getModuleType();
}
