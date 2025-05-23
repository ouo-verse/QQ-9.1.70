package com.tencent.bugly.common.utils;

/* compiled from: P */
/* loaded from: classes5.dex */
public enum DebugConfig {
    INSTANCE;

    private boolean debugMode = false;

    DebugConfig() {
    }

    public boolean inDebugMode() {
        return this.debugMode;
    }

    public void setDebugMode(boolean z16) {
        this.debugMode = z16;
    }
}
