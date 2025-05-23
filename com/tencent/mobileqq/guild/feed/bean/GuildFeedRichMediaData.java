package com.tencent.mobileqq.guild.feed.bean;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedRichMediaData implements Serializable {
    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_VIDEO = 1;

    /* renamed from: id, reason: collision with root package name */
    public String f218324id;
    private int mCurrentPosition;
    private String mPageId;
    private int mRenderHeight;
    private int mRenderWidth;
    private GProStImage mStImage;
    private GProStVideo mStVideo;
    private int mType;
    private String mPosterId = "";
    private String mPosterNick = "";
    private String mPosterAvatar = "";
    private String mFeedTitle = "";
    private boolean mLoadOriginal = false;
    private boolean mVideoScreenPlay = true;

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public String getFeedTitle() {
        return this.mFeedTitle;
    }

    public GProStImage getImage() {
        if (this.mStImage == null) {
            this.mStImage = new GProStImage();
        }
        return this.mStImage;
    }

    public String getPageId() {
        String str = this.mPageId;
        if (str == null) {
            return "";
        }
        return str;
    }

    public String getPosterAvatar() {
        return this.mPosterAvatar;
    }

    public String getPosterId() {
        return this.mPosterId;
    }

    public String getPosterNick() {
        return this.mPosterNick;
    }

    public int getRenderHeight() {
        return this.mRenderHeight;
    }

    public int getRenderWidth() {
        return this.mRenderWidth;
    }

    public int getType() {
        return this.mType;
    }

    public GProStVideo getVideo() {
        if (this.mStVideo == null) {
            this.mStVideo = new GProStVideo();
        }
        return this.mStVideo;
    }

    public boolean isLoadOriginal() {
        return this.mLoadOriginal;
    }

    public boolean isVideoScreenPlay() {
        return this.mVideoScreenPlay;
    }

    public void setCurrentPlayPosition(int i3) {
        this.mCurrentPosition = i3;
    }

    public void setFeedTitle(String str) {
        this.mFeedTitle = str;
    }

    public void setImage(GProStImage gProStImage) {
        if (gProStImage != null) {
            this.mStImage = gProStImage;
        }
    }

    public void setLoadOriginal() {
        this.mLoadOriginal = true;
    }

    public void setPageId(String str) {
        this.mPageId = str;
    }

    public void setPosterAvatar(String str) {
        this.mPosterAvatar = str;
    }

    public void setPosterId(String str) {
        this.mPosterId = str;
    }

    public void setPosterNick(String str) {
        this.mPosterNick = str;
    }

    public void setRenderWH(int i3, int i16) {
        this.mRenderWidth = i3;
        this.mRenderHeight = i16;
    }

    public void setType(int i3) {
        this.mType = i3;
    }

    public void setVideo(GProStVideo gProStVideo) {
        if (gProStVideo != null) {
            this.mStVideo = gProStVideo;
        }
    }

    public void setVideoScreenPlay(boolean z16) {
        this.mVideoScreenPlay = z16;
    }

    public String toString() {
        return "GuildFeedRichMediaData{id='" + this.f218324id + "', mType=" + this.mType + ", mPageId='" + this.mPageId + "', mCurrentPosition=" + this.mCurrentPosition + ", mPosterId='" + this.mPosterId + "', mFeedTitle='" + this.mFeedTitle + "'}";
    }
}
