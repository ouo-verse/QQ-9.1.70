package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class ImportMsgFilePath {
    public String filePath;
    public int pathType;

    public ImportMsgFilePath() {
        this.filePath = "";
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getPathType() {
        return this.pathType;
    }

    public String toString() {
        return "ImportMsgFilePath{pathType=" + this.pathType + ",filePath=" + this.filePath + ",}";
    }

    public ImportMsgFilePath(int i3, String str) {
        this.pathType = i3;
        this.filePath = str;
    }
}
