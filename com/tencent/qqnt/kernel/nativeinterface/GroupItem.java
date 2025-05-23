package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupItem {
    public GroupFileInfo fileInfo;
    public GroupFolderInfo folderInfo;
    public long peerId;
    public GroupItemType type;

    public GroupItem() {
        this.type = GroupItemType.values()[0];
    }

    public GroupFileInfo getFileInfo() {
        return this.fileInfo;
    }

    public GroupFolderInfo getFolderInfo() {
        return this.folderInfo;
    }

    public long getPeerId() {
        return this.peerId;
    }

    public GroupItemType getType() {
        return this.type;
    }

    public GroupItem(long j3, GroupItemType groupItemType, GroupFolderInfo groupFolderInfo, GroupFileInfo groupFileInfo) {
        GroupItemType groupItemType2 = GroupItemType.values()[0];
        this.peerId = j3;
        this.type = groupItemType;
        this.folderInfo = groupFolderInfo;
        this.fileInfo = groupFileInfo;
    }
}
