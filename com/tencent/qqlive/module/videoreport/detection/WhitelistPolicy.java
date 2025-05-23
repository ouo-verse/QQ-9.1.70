package com.tencent.qqlive.module.videoreport.detection;

import android.app.Activity;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public class WhitelistPolicy implements IDetectionPolicy {
    private static final Set<Activity> WHITELIST = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addWhitelist(Activity activity) {
        if (activity != null) {
            WHITELIST.add(activity);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.detection.IDetectionPolicy
    public boolean isAbleToDetect(Activity activity) {
        return WHITELIST.contains(activity);
    }
}
