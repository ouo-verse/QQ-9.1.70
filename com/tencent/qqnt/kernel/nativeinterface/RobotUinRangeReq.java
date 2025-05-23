package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotUinRangeReq {
    public int aioKeywordVersion;
    public long justFetchMsgConfig;
    public int type;
    public int version;

    public RobotUinRangeReq() {
    }

    public int getAioKeywordVersion() {
        return this.aioKeywordVersion;
    }

    public long getJustFetchMsgConfig() {
        return this.justFetchMsgConfig;
    }

    public int getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        return "RobotUinRangeReq{justFetchMsgConfig=" + this.justFetchMsgConfig + ",type=" + this.type + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",aioKeywordVersion=" + this.aioKeywordVersion + ",}";
    }

    public RobotUinRangeReq(long j3, int i3, int i16, int i17) {
        this.justFetchMsgConfig = j3;
        this.type = i3;
        this.version = i16;
        this.aioKeywordVersion = i17;
    }
}
