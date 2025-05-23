package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FileSetSimpleInfo {
    public int expireLeftTime;
    public boolean isLocalCreate;
    public long totalFileCount;
    public long totalFileSize;
    public String fileSetId = "";
    public String name = "";
    public Permission permission = new Permission();
    public Picture cover = new Picture();
    public ArrayList<Uploader> uploaders = new ArrayList<>();
    public FileSetListType transferType = FileSetListType.values()[0];
    public String localCoverPath = "";

    public Picture getCover() {
        return this.cover;
    }

    public int getExpireLeftTime() {
        return this.expireLeftTime;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public boolean getIsLocalCreate() {
        return this.isLocalCreate;
    }

    public String getLocalCoverPath() {
        return this.localCoverPath;
    }

    public String getName() {
        return this.name;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public long getTotalFileCount() {
        return this.totalFileCount;
    }

    public long getTotalFileSize() {
        return this.totalFileSize;
    }

    public FileSetListType getTransferType() {
        return this.transferType;
    }

    public ArrayList<Uploader> getUploaders() {
        return this.uploaders;
    }
}
