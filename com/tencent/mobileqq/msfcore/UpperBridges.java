package com.tencent.mobileqq.msfcore;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface UpperBridges {
    @Nullable
    BeaconBridge getBeaconBridge();

    @Nullable
    ILogger getLogger();

    @Nullable
    IMSFCallbackBridge getMSFCallbackBridge();
}
