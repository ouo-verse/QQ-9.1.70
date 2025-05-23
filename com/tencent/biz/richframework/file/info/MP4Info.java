package com.tencent.biz.richframework.file.info;

import com.tencent.biz.richframework.media.MediaType;

/* loaded from: classes5.dex */
public class MP4Info implements IFileTypeInfo {
    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getFileExtension() {
        return "mp4";
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String[] getHeaders() {
        return new String[]{"667479706D703432", "6674797033677035", "667479704D534E56", "6674797069736F6D"};
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getMIMEType() {
        return "mp4";
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
