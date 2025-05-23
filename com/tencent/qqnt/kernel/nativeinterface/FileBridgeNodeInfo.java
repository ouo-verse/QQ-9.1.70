package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FileBridgeNodeInfo {
    public long creationTime;
    public long downloadProgress;
    public long downloadSpeed;
    public long fileSize;
    public long lastModificationTime;
    public String localSavePath;
    public String fileId = "";
    public FileBridgeNodeType nodeType = FileBridgeNodeType.values()[0];
    public FileBridgeFileType fileType = FileBridgeFileType.values()[0];
    public FileBridgeDirectoryType dirType = FileBridgeDirectoryType.values()[0];
    public String pathOnDesktop = "";
    public String name = "";
    public FileBridgeDownloadState downloadState = FileBridgeDownloadState.values()[0];
    public ArrayList<FileBridgeSearchHitInfo> searchHitInfo = new ArrayList<>();

    public long getCreationTime() {
        return this.creationTime;
    }

    public FileBridgeDirectoryType getDirType() {
        return this.dirType;
    }

    public long getDownloadProgress() {
        return this.downloadProgress;
    }

    public long getDownloadSpeed() {
        return this.downloadSpeed;
    }

    public FileBridgeDownloadState getDownloadState() {
        return this.downloadState;
    }

    public String getFileId() {
        return this.fileId;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public FileBridgeFileType getFileType() {
        return this.fileType;
    }

    public long getLastModificationTime() {
        return this.lastModificationTime;
    }

    public String getLocalSavePath() {
        return this.localSavePath;
    }

    public String getName() {
        return this.name;
    }

    public FileBridgeNodeType getNodeType() {
        return this.nodeType;
    }

    public String getPathOnDesktop() {
        return this.pathOnDesktop;
    }

    public ArrayList<FileBridgeSearchHitInfo> getSearchHitInfo() {
        return this.searchHitInfo;
    }
}
