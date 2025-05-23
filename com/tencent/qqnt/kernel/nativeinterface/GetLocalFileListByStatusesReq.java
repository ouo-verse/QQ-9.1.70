package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetLocalFileListByStatusesReq {
    public String fileSetId = "";
    public String parentId = "";
    public String indexPath = "";
    public FileFilterType filterType = FileFilterType.values()[0];

    public String getFileSetId() {
        return this.fileSetId;
    }

    public FileFilterType getFilterType() {
        return this.filterType;
    }

    public String getIndexPath() {
        return this.indexPath;
    }

    public String getParentId() {
        return this.parentId;
    }
}
