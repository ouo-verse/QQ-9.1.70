package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CreateGroupClientInfo {
    public int appId;
    public int pubNo;
    public byte[] stringInstId = new byte[0];
    public int version;

    public int getAppId() {
        return this.appId;
    }

    public int getPubNo() {
        return this.pubNo;
    }

    public byte[] getStringInstId() {
        return this.stringInstId;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        return "CreateGroupClientInfo{pubNo=" + this.pubNo + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",appId=" + this.appId + ",stringInstId=" + this.stringInstId + ",}";
    }
}
