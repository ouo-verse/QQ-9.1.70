package com.tencent.biz.richframework.file.info;

import android.os.Build;
import com.tencent.biz.richframework.media.MediaType;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AVIFInfo implements IFileTypeInfo {
    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getFileExtension() {
        return "avif";
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String[] getHeaders() {
        return new String[]{"6674797061766966"};
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public String getMIMEType() {
        return "avif";
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public MediaType getMediaType() {
        return MediaType.IMAGE;
    }

    @Override // com.tencent.biz.richframework.file.info.IFileTypeInfo
    public boolean isSysAlbumSupported() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }
}
