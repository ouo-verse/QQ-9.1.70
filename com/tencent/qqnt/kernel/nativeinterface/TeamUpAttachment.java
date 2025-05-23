package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TeamUpAttachment {
    public int attachmentType;
    public TeamUpImageInfo img = new TeamUpImageInfo();

    public int getAttachmentType() {
        return this.attachmentType;
    }

    public TeamUpImageInfo getImg() {
        return this.img;
    }

    public String toString() {
        return "TeamUpAttachment{attachmentType=" + this.attachmentType + ",img=" + this.img + ",}";
    }
}
