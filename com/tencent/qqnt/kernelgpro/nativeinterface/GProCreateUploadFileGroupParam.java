package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProCreateUploadFileGroupParam implements Serializable {
    long serialVersionUID = 1;
    public GProUploadFileGroupInfo fileGroupInfo = new GProUploadFileGroupInfo();
    public ArrayList<GProUploadFileInfo> fileParams = new ArrayList<>();

    public GProUploadFileGroupInfo getFileGroupInfo() {
        return this.fileGroupInfo;
    }

    public ArrayList<GProUploadFileInfo> getFileParams() {
        return this.fileParams;
    }

    public String toString() {
        return "GProCreateUploadFileGroupParam{fileGroupInfo=" + this.fileGroupInfo + ",fileParams=" + this.fileParams + ",}";
    }
}
