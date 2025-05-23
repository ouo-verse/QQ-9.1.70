package com.tencent.biz.richframework.file.info;

import com.tencent.biz.richframework.media.MediaType;

/* loaded from: classes5.dex */
public class MPEGInfo implements IFileTypeInfo {
    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getFileExtension() {
        return "mpeg";
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String[] getHeaders() {
        return new String[]{"000001BA", "000001B3"};
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getMIMEType() {
        return "mpeg";
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
