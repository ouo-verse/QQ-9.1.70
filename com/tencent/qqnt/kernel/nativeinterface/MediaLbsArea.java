package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MediaLbsArea {
    public long endShootTime;
    public int lbsPhotoNum;
    public int photoNum;
    public long startShootTime;
    public boolean userConfirmed;
    public StLBS lbsInfo = new StLBS();
    public String desc = "";
    public String sceneryName = "";

    public String getDesc() {
        return this.desc;
    }

    public long getEndShootTime() {
        return this.endShootTime;
    }

    public StLBS getLbsInfo() {
        return this.lbsInfo;
    }

    public int getLbsPhotoNum() {
        return this.lbsPhotoNum;
    }

    public int getPhotoNum() {
        return this.photoNum;
    }

    public String getSceneryName() {
        return this.sceneryName;
    }

    public long getStartShootTime() {
        return this.startShootTime;
    }

    public boolean getUserConfirmed() {
        return this.userConfirmed;
    }
}
