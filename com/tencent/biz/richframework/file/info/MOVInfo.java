package com.tencent.biz.richframework.file.info;

import com.tencent.biz.richframework.media.MediaType;
import com.tencent.mobileqq.utils.FileUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MOVInfo implements IFileTypeInfo {
    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getFileExtension() {
        return FileUtils.FILE_TYPE_MOV;
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String[] getHeaders() {
        return new String[]{"000000146674797071742020", "6674797071742020", "6D6F6F76"};
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getMIMEType() {
        return "quicktime";
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
