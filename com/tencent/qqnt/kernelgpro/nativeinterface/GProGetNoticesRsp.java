package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetNoticesRsp {
    public boolean isFinish;
    public int totalNum;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public ArrayList<GProStNotice> notices = new ArrayList<>();
    public String attachInfo = "";

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
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
        return "GProGetNoticesRsp{extInfo=" + this.extInfo + ",notices=" + this.notices + ",totalNum=" + this.totalNum + ",isFinish=" + this.isFinish + ",attachInfo=" + this.attachInfo + ",}";
    }
}
