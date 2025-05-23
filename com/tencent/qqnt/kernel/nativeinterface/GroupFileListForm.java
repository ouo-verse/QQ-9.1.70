package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupFileListForm {
    public int fileCount;
    public String folderId;
    public int showOnlinedocFolder;
    public int sortOrder;
    public GroupFileSortType sortType;
    public int startIndex;

    public GroupFileListForm() {
        this.sortType = GroupFileSortType.values()[0];
    }

    public int getFileCount() {
        return this.fileCount;
    }

    public String getFolderId() {
        return this.folderId;
    }

    public int getShowOnlinedocFolder() {
        return this.showOnlinedocFolder;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public GroupFileSortType getSortType() {
        return this.sortType;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public GroupFileListForm(String str, GroupFileSortType groupFileSortType, int i3, int i16, int i17, int i18) {
        GroupFileSortType groupFileSortType2 = GroupFileSortType.values()[0];
        this.folderId = str;
        this.sortType = groupFileSortType;
        this.fileCount = i3;
        this.startIndex = i16;
        this.sortOrder = i17;
        this.showOnlinedocFolder = i18;
    }
}
