package com.tencent.biz.richframework.file.info;

import com.tencent.biz.richframework.media.MediaType;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;

/* loaded from: classes5.dex */
public class PNGInfo implements IFileTypeInfo {
    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getFileExtension() {
        return "png";
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String[] getHeaders() {
        return new String[]{HippyImageInfo.IMAGE_FLAG_PNG};
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getMIMEType() {
        return "png";
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public MediaType getMediaType() {
        return MediaType.IMAGE;
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public boolean isSysAlbumSupported() {
        return true;
    }
}
