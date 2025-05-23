package com.tencent.hippy.qq.api;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyConfig {
    public static final long DEFAULT_UPDATE_HIPPY_INTERVAL = 120;
    public long checkUpdateGap = 120;
    public int isGameCenterPredrawHippy = 0;
    public int isGameCenterPreloadHippy = 0;
    public int isGameCenterLoadHippyInToolProcess = 0;

    public boolean isGameCenterLoadHippyInToolProcess() {
        if (this.isGameCenterLoadHippyInToolProcess == 1) {
            return true;
        }
        return false;
    }

    public boolean isGameCenterPredrawHippy() {
        if (this.isGameCenterPredrawHippy == 1) {
            return true;
        }
        return false;
    }

    public boolean isGameCenterPreloadHippy() {
        if (this.isGameCenterPreloadHippy == 1) {
            return true;
        }
        return false;
    }
}
