package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class RecentContactFetchParam {
    public AnchorPointContactInfo anchorPointContact;
    public int count;
    public boolean fetchOld;
    public int listType;

    public RecentContactFetchParam() {
        this.anchorPointContact = new AnchorPointContactInfo();
    }

    public AnchorPointContactInfo getAnchorPointContact() {
        return this.anchorPointContact;
    }

    public int getCount() {
        return this.count;
    }

    public boolean getFetchOld() {
        return this.fetchOld;
    }

    public int getListType() {
        return this.listType;
    }

    public String toString() {
        return "RecentContactFetchParam{listType=" + this.listType + ",fetchOld=" + this.fetchOld + ",count=" + this.count + ",anchorPointContact=" + this.anchorPointContact + ",}";
    }

    public RecentContactFetchParam(int i3, boolean z16, int i16, AnchorPointContactInfo anchorPointContactInfo) {
        new AnchorPointContactInfo();
        this.listType = i3;
        this.fetchOld = z16;
        this.count = i16;
        this.anchorPointContact = anchorPointContactInfo;
    }
}
