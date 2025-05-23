package com.qzone.preview.service;

import cooperation.qzone.model.PhotoParam;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAlbumRequestBuilder {
    public PhotoParam photoParam;
    public long uin;
    public String cellId = "";
    public String albumId = "";
    public String photoId = "";
    public int reqType = 0;
    public int fetchLeft = 0;
    public int fetchRight = 0;
    public String url = "";
    public long albumType = 0;
    public int getPhotoExType = 0;
    public long sharer = 0;
    public int startIndex = 0;
    public int endIndex = 0;
    public long firstStartTimeStamp = 0;
    public long startTime = 0;
    public long endTime = 0;
    public int direction = 0;
    public String groupId = "";
    public long uploadUin = 0;
    public String lloc = "";
    public int sort = 1;
    public String bigUrl = "";
    public HashMap<Integer, String> busiParam = new HashMap<>();
    public int getComment = 0;
    public int entranceType = 0;

    public QZoneAlbumRequestBuilder setAlbumId(String str) {
        this.albumId = str;
        return this;
    }

    public QZoneAlbumRequestBuilder setAlbumType(long j3) {
        this.albumType = j3;
        return this;
    }

    public QZoneAlbumRequestBuilder setBigUrl(String str) {
        this.bigUrl = str;
        return this;
    }

    public QZoneAlbumRequestBuilder setBusiParam(HashMap<Integer, String> hashMap) {
        this.busiParam = hashMap;
        return this;
    }

    public QZoneAlbumRequestBuilder setCellId(String str) {
        this.cellId = str;
        return this;
    }

    public QZoneAlbumRequestBuilder setDirection(int i3) {
        this.direction = i3;
        return this;
    }

    public QZoneAlbumRequestBuilder setEndIndex(int i3) {
        this.endIndex = i3;
        return this;
    }

    public QZoneAlbumRequestBuilder setEndTime(long j3) {
        this.endTime = j3;
        return this;
    }

    public QZoneAlbumRequestBuilder setEntranceType(int i3) {
        this.entranceType = i3;
        return this;
    }

    public QZoneAlbumRequestBuilder setFetchLeft(int i3) {
        this.fetchLeft = i3;
        return this;
    }

    public QZoneAlbumRequestBuilder setFetchRight(int i3) {
        this.fetchRight = i3;
        return this;
    }

    public QZoneAlbumRequestBuilder setFirstStartTimeStamp(long j3) {
        this.firstStartTimeStamp = j3;
        return this;
    }

    public QZoneAlbumRequestBuilder setGetComment(int i3) {
        this.getComment = i3;
        return this;
    }

    public QZoneAlbumRequestBuilder setGroupId(String str) {
        this.groupId = str;
        return this;
    }

    public QZoneAlbumRequestBuilder setLloc(String str) {
        this.lloc = str;
        return this;
    }

    public QZoneAlbumRequestBuilder setPhotoExType(int i3) {
        this.getPhotoExType = i3;
        return this;
    }

    public QZoneAlbumRequestBuilder setPhotoId(String str) {
        this.photoId = str;
        return this;
    }

    public QZoneAlbumRequestBuilder setPhotoParam(PhotoParam photoParam) {
        this.photoParam = photoParam;
        return this;
    }

    public QZoneAlbumRequestBuilder setRequestType(int i3) {
        this.reqType = i3;
        return this;
    }

    public QZoneAlbumRequestBuilder setSharer(long j3) {
        this.sharer = j3;
        return this;
    }

    public QZoneAlbumRequestBuilder setSort(int i3) {
        this.sort = i3;
        return this;
    }

    public QZoneAlbumRequestBuilder setStartIndex(int i3) {
        this.startIndex = i3;
        return this;
    }

    public QZoneAlbumRequestBuilder setStartTime(long j3) {
        this.startTime = j3;
        return this;
    }

    public QZoneAlbumRequestBuilder setUin(long j3) {
        this.uin = j3;
        return this;
    }

    public QZoneAlbumRequestBuilder setUploadUin(long j3) {
        this.uploadUin = j3;
        return this;
    }

    public QZoneAlbumRequestBuilder setUrl(String str) {
        this.url = str;
        return this;
    }
}
