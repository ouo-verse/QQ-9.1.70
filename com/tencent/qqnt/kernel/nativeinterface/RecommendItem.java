package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RecommendItem implements Serializable {
    long serialVersionUID = 1;
    public AlbumInfo album = new AlbumInfo();

    public AlbumInfo getAlbum() {
        return this.album;
    }
}
