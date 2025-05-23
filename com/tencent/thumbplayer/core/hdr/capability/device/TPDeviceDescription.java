package com.tencent.thumbplayer.core.hdr.capability.device;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes26.dex */
public class TPDeviceDescription {
    private String mDeviceModel;
    private String mDeviceName;
    private String mReason;

    public TPDeviceDescription(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        this.mDeviceModel = str;
        this.mDeviceName = str2;
        this.mReason = str3;
    }

    @NonNull
    public String getDeviceModel() {
        return this.mDeviceModel;
    }

    @Nullable
    public String getDeviceName() {
        return this.mDeviceName;
    }

    @Nullable
    public String getReason() {
        return this.mReason;
    }
}
