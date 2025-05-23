package com.tencent.biz.richframework.file.info;

import com.tencent.biz.richframework.media.MediaType;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IFileTypeInfo {
    String getFileExtension();

    String[] getHeaders();

    String getMIMEType();

    MediaType getMediaType();

    boolean isSysAlbumSupported();
}
