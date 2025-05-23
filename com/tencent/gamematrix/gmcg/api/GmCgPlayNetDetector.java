package com.tencent.gamematrix.gmcg.api;

/* loaded from: classes6.dex */
public interface GmCgPlayNetDetector {
    void restartDetector();

    void setPlayDetectorListener(GmCgPlayDetectorListener gmCgPlayDetectorListener);

    void startDetector();

    void stopDetector();
}
