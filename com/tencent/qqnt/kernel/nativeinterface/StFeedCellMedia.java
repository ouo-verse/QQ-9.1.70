package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StFeedCellMedia {
    public int albumUploadNum;
    public long batchId;
    public int uploadNum;
    public ArrayList<StMedia> mediaItems = new ArrayList<>();
    public String albumName = "";
    public String albumId = "";
    public StImage albumCover = new StImage();

    public StImage getAlbumCover() {
        return this.albumCover;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public int getAlbumUploadNum() {
        return this.albumUploadNum;
    }

    public long getBatchId() {
        return this.batchId;
    }

    public ArrayList<StMedia> getMediaItems() {
        return this.mediaItems;
    }

    public int getUploadNum() {
        return this.uploadNum;
    }

    public void setAlbumCover(StImage stImage) {
        this.albumCover = stImage;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public void setAlbumUploadNum(int i3) {
        this.albumUploadNum = i3;
    }

    public void setBatchId(long j3) {
        this.batchId = j3;
    }

    public void setMediaItems(ArrayList<StMedia> arrayList) {
        this.mediaItems = arrayList;
    }

    public void setUploadNum(int i3) {
        this.uploadNum = i3;
    }
}
