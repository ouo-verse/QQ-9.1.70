package com.tencent.aelight.camera.ae.flashshow.enhance;

import com.tencent.aelight.camera.struct.editor.EnhanceConfig;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class SEVideoEnhanceConfig {
    public static final int DEFAULT_DEBLUR_AVERGE_SCORE = 58;
    public static final float DEFAULT_DEBLUR_BIAS = 5.0f;
    public static final int DEFAULT_MAX_DELOGO_FRAME_RATE = 50;
    public List<Devices> devices;
    public List<Levels> levels;
    public List<EnhanceConfig.SharpenStrength> sharpenStrengths;
    public int deblurAverageScore = 58;
    public float blurBias = 5.0f;
    public int maxDelogoFrameRate = 50;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class Devices {
        String deviceModel;
        int enableDelogo;
        int enableHDR;
        int extraMaxDuration;
        int hdrType;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class Levels {
        int deviceLevel;
        int enableDelogo;
        int enableHDR;
        int extraMaxDuration;
        int hdrType;
    }
}
