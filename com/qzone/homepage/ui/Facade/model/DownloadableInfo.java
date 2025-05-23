package com.qzone.homepage.ui.Facade.model;

import NS_MOBILE_CUSTOM.CustomFileInfo;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DownloadableInfo implements SmartParcelable {

    @NeedParcel
    public String fileMd5;

    @NeedParcel
    public int fileSize;

    @NeedParcel
    public int fileType;

    @NeedParcel
    public String fileUrl;

    @NeedParcel
    public int imageHeight;

    @NeedParcel
    public int imageWidth;

    public static DownloadableInfo createDownloadableInfo(CustomFileInfo customFileInfo) {
        if (customFileInfo == null) {
            return null;
        }
        DownloadableInfo downloadableInfo = new DownloadableInfo();
        downloadableInfo.fileType = customFileInfo.iFileType;
        downloadableInfo.fileUrl = customFileInfo.strFileUrl;
        downloadableInfo.imageHeight = customFileInfo.iImageHeight;
        downloadableInfo.imageWidth = customFileInfo.iImageWidth;
        downloadableInfo.fileMd5 = customFileInfo.strFileMd5;
        downloadableInfo.fileSize = customFileInfo.iFileSize;
        return downloadableInfo;
    }
}
