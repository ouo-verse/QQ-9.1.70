package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetFeedNoticesRsp {
    public boolean isFinish;
    public int totalNum;
    public ArrayList<GProStNotice> notices = new ArrayList<>();
    public String attachInfo = "";

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public boolean getIsFinish() {
        return this.isFinish;
    }

    public ArrayList<GProStNotice> getNotices() {
        return this.notices;
    }

    public int getTotalNum() {
        return this.totalNum;
    }

    public String toString() {
        return "GProGetFeedNoticesRsp{notices=" + this.notices + ",totalNum=" + this.totalNum + ",isFinish=" + this.isFinish + ",attachInfo=" + this.attachInfo + ",}";
    }
}
