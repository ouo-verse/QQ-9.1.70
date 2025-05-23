package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupRobotBaseInfo {
    public long robotUin;
    public String robotName = "";
    public String robotAvatar = "";
    public String robotDesc = "";

    public String getRobotAvatar() {
        return this.robotAvatar;
    }

    public String getRobotDesc() {
        return this.robotDesc;
    }

    public String getRobotName() {
        return this.robotName;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String toString() {
        return "GroupRobotBaseInfo{robotUin=" + this.robotUin + ",robotName=" + this.robotName + ",robotAvatar=" + this.robotAvatar + ",robotDesc=" + this.robotDesc + ",}";
    }
}
