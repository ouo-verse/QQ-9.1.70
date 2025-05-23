package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStRecomForward {
    public long createTime;
    public int type;
    public String idd = "";
    public String title = "";
    public String subtitle = "";
    public GProStUser poster = new GProStUser();
    public byte[] busiData = new byte[0];

    public byte[] getBusiData() {
        return this.busiData;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getIdd() {
        return this.idd;
    }

    public GProStUser getPoster() {
        return this.poster;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProStRecomForward{idd=" + this.idd + ",title=" + this.title + ",subtitle=" + this.subtitle + ",poster=" + this.poster + ",createTime=" + this.createTime + ",type=" + this.type + ",busiData=" + this.busiData + ",}";
    }
}
