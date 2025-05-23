package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FileList {
    public int depth;
    public boolean isCache;
    public boolean isEnd;
    public String parentId = "";
    public ArrayList<File> fileList = new ArrayList<>();
    public byte[] paginationInfo = new byte[0];

    public int getDepth() {
        return this.depth;
    }

    public ArrayList<File> getFileList() {
        return this.fileList;
    }

    public boolean getIsCache() {
        return this.isCache;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public byte[] getPaginationInfo() {
        return this.paginationInfo;
    }

    public String getParentId() {
        return this.parentId;
    }
}
