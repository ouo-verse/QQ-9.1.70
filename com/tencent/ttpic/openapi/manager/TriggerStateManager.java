package com.tencent.ttpic.openapi.manager;

import com.tencent.ttpic.openapi.PTDetectInfo;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum TriggerStateManager {
    INSTANCE;

    private static final String TAG = TriggerStateManager.class.getSimpleName();
    private static PTDetectInfo mDetectInfo;

    public static TriggerStateManager getInstance() {
        return INSTANCE;
    }

    public PTDetectInfo getPTDetectInfo() {
        return mDetectInfo;
    }

    public void setPTDetectInfo(PTDetectInfo pTDetectInfo) {
        mDetectInfo = pTDetectInfo;
    }

    public void clear() {
    }

    public void reset() {
    }
}
