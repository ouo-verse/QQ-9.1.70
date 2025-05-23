package com.tencent.mobileqq.guild.feed.launcher;

import com.tencent.mobileqq.guild.feed.data.GProStFeedMemoryKeepSerializer;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedFullScreenBean extends GuildFeedBaseInitBean {
    private int mCurrentVideoPos;
    private int mPos;
    private GProStFeedMemoryKeepSerializer mStFeedWrapper;
    private GProStVideo mStVideo;

    public int getCurrentVideoPos() {
        return this.mCurrentVideoPos;
    }

    public int getDataPosInList() {
        return this.mPos;
    }

    public GProStFeed getFeed() {
        if (this.mStFeedWrapper == null) {
            this.mStFeedWrapper = new GProStFeedMemoryKeepSerializer(new GProStFeed());
        }
        return this.mStFeedWrapper.getStFeed();
    }

    public GProStVideo getVideo() {
        if (this.mStVideo == null) {
            this.mStVideo = new GProStVideo();
        }
        return this.mStVideo;
    }

    public void setFeed(GProStFeed gProStFeed) {
        if (gProStFeed != null) {
            this.mStFeedWrapper = new GProStFeedMemoryKeepSerializer(gProStFeed);
        }
    }

    public void setVideo(GProStVideo gProStVideo) {
        if (gProStVideo != null) {
            this.mStVideo = gProStVideo;
        }
    }

    public void setVideoCurrentPosition(int i3) {
        this.mCurrentVideoPos = i3;
    }

    public int setFeedPos(int i3) {
        return i3;
    }
}
