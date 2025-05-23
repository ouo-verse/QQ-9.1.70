package com.qzone.publish.business.model;

import com.tencent.component.annotation.NeedParcel;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NetworkImageInfo extends LocalImageInfo {

    @NeedParcel
    private AlbumPhotoInfo mPicInfo;

    public AlbumPhotoInfo getPicInfo() {
        return this.mPicInfo;
    }

    public void setPicInfo(AlbumPhotoInfo albumPhotoInfo) {
        this.mPicInfo = albumPhotoInfo;
    }
}
