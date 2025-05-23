package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStRelationInfo {
    public long imBitMap;
    public boolean isBlock;
    public boolean isBlocked;
    public boolean isFriend;
    public boolean isUncare;
    public int relation;
    public int relationState;
    public int score;
    public String idd = "";
    public byte[] busiData = new byte[0];

    public byte[] getBusiData() {
        return this.busiData;
    }

    public String getIdd() {
        return this.idd;
    }

    public long getImBitMap() {
        return this.imBitMap;
    }

    public boolean getIsBlock() {
        return this.isBlock;
    }

    public boolean getIsBlocked() {
        return this.isBlocked;
    }

    public boolean getIsFriend() {
        return this.isFriend;
    }

    public boolean getIsUncare() {
        return this.isUncare;
    }

    public int getRelation() {
        return this.relation;
    }

    public int getRelationState() {
        return this.relationState;
    }

    public int getScore() {
        return this.score;
    }

    public String toString() {
        return "GProStRelationInfo{idd=" + this.idd + ",relation=" + this.relation + ",busiData=" + this.busiData + ",relationState=" + this.relationState + ",score=" + this.score + ",isBlock=" + this.isBlock + ",isBlocked=" + this.isBlocked + ",isFriend=" + this.isFriend + ",isUncare=" + this.isUncare + ",imBitMap=" + this.imBitMap + ",}";
    }
}
