package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProMVPFeed {
    public long createTime;
    public long lastModifiedTime;
    public int type;

    /* renamed from: id, reason: collision with root package name */
    public String f359299id = "";
    public String title = "";
    public GProMVPUser poster = new GProMVPUser();
    public GProMVPFeedContent content = new GProMVPFeedContent();
    public GProMVPComments hotComments = new GProMVPComments();
    public GProMVPFeedStat stat = new GProMVPFeedStat();
    public GProMVPChannelInfo channelInfo = new GProMVPChannelInfo();
    public GProMVPFeedStatus status = new GProMVPFeedStatus();
    public GProMVPFeedFeature feature = new GProMVPFeedFeature();
    public byte[] oldProtoStfeed = new byte[0];

    public GProMVPChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public GProMVPFeedContent getContent() {
        return this.content;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public GProMVPFeedFeature getFeature() {
        return this.feature;
    }

    public GProMVPComments getHotComments() {
        return this.hotComments;
    }

    public String getId() {
        return this.f359299id;
    }

    public long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public byte[] getOldProtoStfeed() {
        return this.oldProtoStfeed;
    }

    public GProMVPUser getPoster() {
        return this.poster;
    }

    public GProMVPFeedStat getStat() {
        return this.stat;
    }

    public GProMVPFeedStatus getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProMVPFeed{id=" + this.f359299id + ",title=" + this.title + ",poster=" + this.poster + ",createTime=" + this.createTime + ",lastModifiedTime=" + this.lastModifiedTime + ",type=" + this.type + ",content=" + this.content + ",hotComments=" + this.hotComments + ",stat=" + this.stat + ",channelInfo=" + this.channelInfo + ",status=" + this.status + ",feature=" + this.feature + ",oldProtoStfeed=" + this.oldProtoStfeed + ",}";
    }
}
