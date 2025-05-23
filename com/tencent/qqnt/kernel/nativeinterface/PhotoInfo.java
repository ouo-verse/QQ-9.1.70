package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PhotoInfo {
    public StMedia media = new StMedia();
    public String albumId = "";
    public String albumName = "";
    public StUser albumOwner = new StUser();

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public StUser getAlbumOwner() {
        return this.albumOwner;
    }

    public StMedia getMedia() {
        return this.media;
    }
}
