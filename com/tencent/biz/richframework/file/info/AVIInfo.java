package com.tencent.biz.richframework.file.info;

import com.tencent.biz.richframework.media.MediaType;
import com.tencent.mobileqq.utils.FileUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AVIInfo implements IFileTypeInfo {
    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getFileExtension() {
        return FileUtils.FILE_TYPE_AVI;
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String[] getHeaders() {
        return new String[]{"41564920"};
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getMIMEType() {
        return "x-msvideo";
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public MediaType getMediaType() {
        return MediaType.VIDEO;
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public boolean isSysAlbumSupported() {
        return true;
    }
}
