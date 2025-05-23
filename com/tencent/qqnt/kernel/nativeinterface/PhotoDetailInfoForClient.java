package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PhotoDetailInfoForClient {
    public PhotoDetailInfo detailInfo = new PhotoDetailInfo();
    public String localFilePath;
    public String localThumbPath;

    public PhotoDetailInfo getDetailInfo() {
        return this.detailInfo;
    }

    public String getLocalFilePath() {
        return this.localFilePath;
    }

    public String getLocalThumbPath() {
        return this.localThumbPath;
    }
}
