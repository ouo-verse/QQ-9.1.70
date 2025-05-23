package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TeamUpMemberInfo {
    public int joinGroupStatus;
    public long joinTime;
    public long uin;
    public String nick = "";
    public TeamUpApplicationMaterial material = new TeamUpApplicationMaterial();

    public int getJoinGroupStatus() {
        return this.joinGroupStatus;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public TeamUpApplicationMaterial getMaterial() {
        return this.material;
    }

    public String getNick() {
        return this.nick;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "TeamUpMemberInfo{uin=" + this.uin + ",nick=" + this.nick + ",joinTime=" + this.joinTime + ",material=" + this.material + ",joinGroupStatus=" + this.joinGroupStatus + ",}";
    }
}
