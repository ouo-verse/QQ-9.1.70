package com.tencent.biz.richframework.file.info;

import com.tencent.biz.richframework.media.MediaType;
import com.tencent.mobileqq.utils.FileUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class WMVInfo implements IFileTypeInfo {
    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getFileExtension() {
        return FileUtils.FILE_TYPE_WMV;
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String[] getHeaders() {
        return new String[]{"3026B2758E66CF11"};
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getMIMEType() {
        return "x-ms-wmv";
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public MediaType getMediaType() {
        return MediaType.VIDEO;
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public boolean isSysAlbumSupported() {
        return false;
    }
}
