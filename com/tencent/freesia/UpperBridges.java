package com.tencent.freesia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface UpperBridges {
    @Nullable
    BeaconBridge getBeaconBridge();

    @NonNull
    String getCurrentUin();

    @Nullable
    CustomRuleBridge getCustomRuleBridge();

    @NonNull
    DeviceInfo getDeviceInfo();

    @Nullable
    HTTPBridge getHTTPBridge();

    @Nullable
    KVBridge getKVBridge(@NonNull String str);

    @NonNull
    String getLargeFileRootDir();

    @Nullable
    ILogger getLogger();

    @Nullable
    MSFServletBridge getMSFBridge();

    @Nullable
    ConfigParserBridge getParserBridge();

    @Nullable
    Tick getTick();

    boolean isLogin();
}
