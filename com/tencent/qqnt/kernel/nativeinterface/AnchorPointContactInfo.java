package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class AnchorPointContactInfo {
    public long contactId;
    public int pos;
    public long sortField;

    public AnchorPointContactInfo() {
    }

    public long getContactId() {
        return this.contactId;
    }

    public int getPos() {
        return this.pos;
    }

    public long getSortField() {
        return this.sortField;
    }

    public String toString() {
        return "AnchorPointContactInfo{contactId=" + this.contactId + ",sortField=" + this.sortField + ",pos=" + this.pos + ",}";
    }

    public AnchorPointContactInfo(long j3, long j16, int i3) {
        this.contactId = j3;
        this.sortField = j16;
        this.pos = i3;
    }
}
