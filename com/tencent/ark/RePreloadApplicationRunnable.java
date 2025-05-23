package com.tencent.ark;

/* loaded from: classes3.dex */
public class RePreloadApplicationRunnable implements Runnable {
    private String mAppName;

    public RePreloadApplicationRunnable(String str) {
        this.mAppName = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArkAppPreloader.releasePreloadApplicationAndReload(this.mAppName);
    }
}
