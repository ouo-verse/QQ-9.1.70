package com.tencent.qqlive.module.videoreport.detection;

import android.app.Activity;

/* loaded from: classes22.dex */
public class DefaultPolicy implements IDetectionPolicy {
    @Override // com.tencent.qqlive.module.videoreport.detection.IDetectionPolicy
    public boolean isAbleToDetect(Activity activity) {
        return true;
    }
}
