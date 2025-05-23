package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProCmd0x10c3Filter {
    public boolean needAttaContendId;
    public int needMemberFeedNum;
    public int shareCopywriting;

    public GProCmd0x10c3Filter() {
    }

    public boolean getNeedAttaContendId() {
        return this.needAttaContendId;
    }

    public int getNeedMemberFeedNum() {
        return this.needMemberFeedNum;
    }

    public int getShareCopywriting() {
        return this.shareCopywriting;
    }

    public void setNeedAttaContendId(boolean z16) {
        this.needAttaContendId = z16;
    }

    public void setNeedMemberFeedNum(int i3) {
        this.needMemberFeedNum = i3;
    }

    public void setShareCopywriting(int i3) {
        this.shareCopywriting = i3;
    }

    public String toString() {
        return "GProCmd0x10c3Filter{shareCopywriting=" + this.shareCopywriting + ",needMemberFeedNum=" + this.needMemberFeedNum + ",needAttaContendId=" + this.needAttaContendId + ",}";
    }

    public GProCmd0x10c3Filter(int i3) {
        this.shareCopywriting = i3;
    }
}
