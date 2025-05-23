package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStPrePullCacheFeed {
    public long createTime;
    public String idd = "";
    public GProStUser poster = new GProStUser();
    public ArrayList<GProBytesEntry> busiTranparentList = new ArrayList<>();

    public ArrayList<GProBytesEntry> getBusiTranparentList() {
        return this.busiTranparentList;
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

    public String toString() {
        return "GProStPrePullCacheFeed{idd=" + this.idd + ",poster=" + this.poster + ",createTime=" + this.createTime + ",busiTranparentList=" + this.busiTranparentList + ",}";
    }
}
