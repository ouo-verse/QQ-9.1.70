package com.tencent.biz.richframework.video.rfw.player.stinfo;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWStVideo {
    private int mDuration;
    private int mFileSize;
    private int mHeight;
    private boolean mIsHdrVideo;
    private int mIsQuic;
    private float mMediaQualityScore;
    private int mOrientation;
    private int mTransStatus;
    private int mVideoPrior;
    private int mVideoRate;
    private int mWidth;
    private String mFileId = "";
    private String mPlayUrl = "";
    private List<RFWStVideoUrl> mVecVideoUrl = new ArrayList();
    private String mVideoMD5 = "";

    public int getDuration() {
        return this.mDuration;
    }

    public String getFileId() {
        if (TextUtils.isEmpty(this.mFileId)) {
            this.mFileId = this.mPlayUrl;
        }
        return this.mFileId;
    }

    public int getFileSize() {
        return this.mFileSize;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public float getMediaQualityScore() {
        return this.mMediaQualityScore;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public String getPlayUrl() {
        return this.mPlayUrl;
    }

    public int getTransStatus() {
        return this.mTransStatus;
    }

    public List<RFWStVideoUrl> getVecVideoUrl() {
        return this.mVecVideoUrl;
    }

    public String getVideoMD5() {
        return this.mVideoMD5;
    }

    public int getVideoPrior() {
        return this.mVideoPrior;
    }

    public int getVideoRate() {
        return this.mVideoRate;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isHdrVideo() {
        return this.mIsHdrVideo;
    }

    public int isQuic() {
        return this.mIsQuic;
    }

    public RFWStVideo setDuration(int i3) {
        this.mDuration = i3;
        return this;
    }

    public RFWStVideo setFileId(String str) {
        this.mFileId = str;
        return this;
    }

    public RFWStVideo setFileSize(int i3) {
        this.mFileSize = i3;
        return this;
    }

    public RFWStVideo setHdrVideo(boolean z16) {
        this.mIsHdrVideo = z16;
        return this;
    }

    public RFWStVideo setHeight(int i3) {
        this.mHeight = i3;
        return this;
    }

    public RFWStVideo setMediaQualityScore(float f16) {
        this.mMediaQualityScore = f16;
        return this;
    }

    public RFWStVideo setOrientation(int i3) {
        this.mOrientation = i3;
        return this;
    }

    public RFWStVideo setPlayUrl(String str) {
        this.mPlayUrl = str;
        return this;
    }

    public RFWStVideo setQuic(int i3) {
        this.mIsQuic = i3;
        return this;
    }

    public RFWStVideo setTransStatus(int i3) {
        this.mTransStatus = i3;
        return this;
    }

    public RFWStVideo setVecVideoUrl(List<RFWStVideoUrl> list) {
        this.mVecVideoUrl = list;
        return this;
    }

    public RFWStVideo setVideoMD5(String str) {
        this.mVideoMD5 = str;
        return this;
    }

    public RFWStVideo setVideoPrior(int i3) {
        this.mVideoPrior = i3;
        return this;
    }

    public RFWStVideo setVideoRate(int i3) {
        this.mVideoRate = i3;
        return this;
    }

    public RFWStVideo setWidth(int i3) {
        this.mWidth = i3;
        return this;
    }
}
