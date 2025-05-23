package com.tencent.biz.richframework.file.info;

import com.tencent.biz.richframework.media.MediaType;
import com.tencent.xweb.FileReaderHelper;

/* loaded from: classes5.dex */
public class MP3Info implements IFileTypeInfo {
    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getFileExtension() {
        return FileReaderHelper.MP3_EXT;
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String[] getHeaders() {
        return new String[]{"494433"};
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getMIMEType() {
        return FileReaderHelper.MP3_EXT;
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public MediaType getMediaType() {
        return MediaType.AUDIO;
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public boolean isSysAlbumSupported() {
        return false;
    }
}
