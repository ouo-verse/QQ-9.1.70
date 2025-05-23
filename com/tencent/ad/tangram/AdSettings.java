package com.tencent.ad.tangram;

import com.tencent.ad.tangram.annotation.AdKeep;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdSettings {
    private static boolean isTestMode = false;

    public static boolean isTestMode() {
        return isTestMode;
    }

    public static void setTestMode(boolean z16) {
        isTestMode = z16;
    }
}
