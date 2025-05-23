package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProContentRecommendRobot implements Serializable {
    public long robotUin;
    public int type;
    long serialVersionUID = 1;
    public GProImageBasicInfo picInfo = new GProImageBasicInfo();
    public String schema = "";
    public String uid = "";
    public String nickName = "";
    public String desc = "";
    public String buttonName = "";
    public byte[] extra = new byte[0];
    public String appId = "";

    public String getAppId() {
        return this.appId;
    }

    public String getButtonName() {
        return this.buttonName;
    }

    public String getDesc() {
        return this.desc;
    }

    public byte[] getExtra() {
        return this.extra;
    }

    public String getNickName() {
        return this.nickName;
    }

    public GProImageBasicInfo getPicInfo() {
        return this.picInfo;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String getSchema() {
        return this.schema;
    }

    public int getType() {
        return this.type;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "GProContentRecommendRobot{robotUin=" + this.robotUin + ",picInfo=" + this.picInfo + ",schema=" + this.schema + ",uid=" + this.uid + ",nickName=" + this.nickName + ",desc=" + this.desc + ",type=" + this.type + ",buttonName=" + this.buttonName + ",extra=" + this.extra + ",appId=" + this.appId + ",}";
    }
}
