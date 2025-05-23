package org.light.utils;

import org.light.bean.DyeColorInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightDyeUtil {
    private long nativePtr;

    private native int nativeDestroy();

    private native int nativeInitInstance();

    private native DyeColorInfo nativeSetupWithKtxPath(String str, boolean z16);

    private native int nativeUpdateClusterColor(DyeColorInfo dyeColorInfo, String str);

    public int destroy() {
        return nativeDestroy();
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public int initInstance() {
        return nativeInitInstance();
    }

    public void setNativePtr(long j3) {
        this.nativePtr = j3;
    }

    public DyeColorInfo setupWithKtxPath(String str, boolean z16) {
        if (str != null && !str.isEmpty()) {
            return nativeSetupWithKtxPath(str, z16);
        }
        return null;
    }

    public int updateClusterColor(DyeColorInfo dyeColorInfo, String str) {
        if (dyeColorInfo != null && str != null && !str.isEmpty()) {
            return nativeUpdateClusterColor(dyeColorInfo, str);
        }
        return -1;
    }
}
