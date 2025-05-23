package com.tencent.biz.videostory.support;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VideoStoryDataBean implements Serializable {
    private static final long serialVersionUID = -1;
    private String filterId;
    private int filterType;
    private boolean isLandTakePicToVideo;
    private boolean isTakePicToVideo;
    private String lensId;
    private String lensTabId;
    private long musciPlayTime;
    private int musicType;
    private String stickerId;
    private long videoDuration;
    private String wordId;
    private String watermarkId = "";
    private String songMid = "";

    public String getFilterId() {
        return this.filterId;
    }

    public int getFilterType() {
        return this.filterType;
    }

    public String getLensId() {
        return this.lensId;
    }

    public String getLensTabId() {
        return this.lensTabId;
    }

    public long getMusciPlayTime() {
        return this.musciPlayTime;
    }

    public int getMusicType() {
        return this.musicType;
    }

    public String getSongMid() {
        return this.songMid;
    }

    public String getStickerId() {
        return this.stickerId;
    }

    public boolean getTakePicToVideo() {
        return this.isTakePicToVideo;
    }

    public long getVideoDuration() {
        return this.videoDuration;
    }

    public String getWatermarkId() {
        return this.watermarkId;
    }

    public String getWordId() {
        return this.wordId;
    }

    public boolean isLandTakePicToVideo() {
        return this.isLandTakePicToVideo;
    }

    public void setFilterId(String str) {
        this.filterId = str;
    }

    public void setFilterType(int i3) {
        this.filterType = i3;
    }

    public void setLandTakePicToVideo(boolean z16) {
        this.isLandTakePicToVideo = z16;
    }

    public void setLensId(String str) {
        this.lensId = str;
    }

    public void setLensTabId(String str) {
        this.lensTabId = str;
    }

    public void setMusciPlayTime(long j3) {
        this.musciPlayTime = j3;
    }

    public void setMusicType(int i3) {
        this.musicType = i3;
    }

    public void setSongMid(String str) {
        this.songMid = str;
    }

    public void setStickerId(String str) {
        this.stickerId = str;
    }

    public void setTakePicToVideo(boolean z16) {
        this.isTakePicToVideo = z16;
    }

    public void setVideoDuration(long j3) {
        this.videoDuration = j3;
    }

    public void setWatermarkId(String str) {
        this.watermarkId = str;
    }

    public void setWordId(String str) {
        this.wordId = str;
    }
}
