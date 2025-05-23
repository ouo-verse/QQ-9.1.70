package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStFeedAbstract implements Serializable {
    public long createTime;
    public int fuelNum;
    public int type;
    long serialVersionUID = 1;
    public String idd = "";
    public String title = "";
    public GProStUser poster = new GProStUser();
    public GProStImage pic = new GProStImage();
    public GProStVideo video = new GProStVideo();
    public String content = "";
    public ArrayList<GProStImage> images = new ArrayList<>();
    public GProStFeedCount countInfo = new GProStFeedCount();

    public String getContent() {
        return this.content;
    }

    public GProStFeedCount getCountInfo() {
        return this.countInfo;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public int getFuelNum() {
        return this.fuelNum;
    }

    public String getIdd() {
        return this.idd;
    }

    public ArrayList<GProStImage> getImages() {
        return this.images;
    }

    public GProStImage getPic() {
        return this.pic;
    }

    public GProStUser getPoster() {
        return this.poster;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public GProStVideo getVideo() {
        return this.video;
    }

    public String toString() {
        return "GProStFeedAbstract{idd=" + this.idd + ",title=" + this.title + ",poster=" + this.poster + ",pic=" + this.pic + ",type=" + this.type + ",createTime=" + this.createTime + ",video=" + this.video + ",fuelNum=" + this.fuelNum + ",content=" + this.content + ",images=" + this.images + ",countInfo=" + this.countInfo + ",}";
    }
}
