package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AppId {
    public long addTs;
    public long addUin;
    public long appid;
    public int source;

    public long getAddTs() {
        return this.addTs;
    }

    public long getAddUin() {
        return this.addUin;
    }

    public long getAppid() {
        return this.appid;
    }

    public int getSource() {
        return this.source;
    }

    public String toString() {
        return "AppId{appid=" + this.appid + ",source=" + this.source + ",addTs=" + this.addTs + ",addUin=" + this.addUin + ",}";
    }
}
