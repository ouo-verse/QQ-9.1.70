package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobtoCreateInfo {
    public boolean allowJumpProfile;
    public long createUin;
    public String createName = "";
    public String createUid = "";
    public ArrayList<CreatorIdentity> creatorIdentity = new ArrayList<>();

    public boolean getAllowJumpProfile() {
        return this.allowJumpProfile;
    }

    public String getCreateName() {
        return this.createName;
    }

    public String getCreateUid() {
        return this.createUid;
    }

    public long getCreateUin() {
        return this.createUin;
    }

    public ArrayList<CreatorIdentity> getCreatorIdentity() {
        return this.creatorIdentity;
    }

    public String toString() {
        return "RobtoCreateInfo{createName=" + this.createName + ",createUid=" + this.createUid + ",createUin=" + this.createUin + ",allowJumpProfile=" + this.allowJumpProfile + ",creatorIdentity=" + this.creatorIdentity + ",}";
    }
}
