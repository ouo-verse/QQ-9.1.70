package com.qzone.reborn.layer.share;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes37.dex */
public class QZoneDeletePhotoBean implements Serializable {
    public String albumId = "";
    public ArrayList<String> photoIdList;
    public ArrayList<String> videoIdList;

    public QZoneDeletePhotoBean setAlbumId(String str) {
        this.albumId = str;
        return this;
    }

    public QZoneDeletePhotoBean setPhotoIdList(ArrayList<String> arrayList) {
        this.photoIdList = arrayList;
        return this;
    }

    public QZoneDeletePhotoBean setVideoIdList(ArrayList<String> arrayList) {
        this.videoIdList = arrayList;
        return this;
    }
}
