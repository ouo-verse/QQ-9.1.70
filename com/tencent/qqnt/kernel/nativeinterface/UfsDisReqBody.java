package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisReqBody {
    public int business;
    public int fromType;
    public int ignoreGender;
    public byte[] version = new byte[0];

    public int getBusiness() {
        return this.business;
    }

    public int getFromType() {
        return this.fromType;
    }

    public int getIgnoreGender() {
        return this.ignoreGender;
    }

    public byte[] getVersion() {
        return this.version;
    }

    public String toString() {
        return "UfsDisReqBody{fromType=" + this.fromType + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",business=" + this.business + ",ignoreGender=" + this.ignoreGender + ",}";
    }
}
