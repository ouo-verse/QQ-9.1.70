package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GameTeamUpBanner {
    public boolean isMulti;
    public long teamLeader;
    public int teamMaxNum;
    public int teamNum;
    public String url = "";
    public String singleGroupText = "";
    public String multiGroupText = "";

    public boolean getIsMulti() {
        return this.isMulti;
    }

    public String getMultiGroupText() {
        return this.multiGroupText;
    }

    public String getSingleGroupText() {
        return this.singleGroupText;
    }

    public long getTeamLeader() {
        return this.teamLeader;
    }

    public int getTeamMaxNum() {
        return this.teamMaxNum;
    }

    public int getTeamNum() {
        return this.teamNum;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GameTeamUpBanner{isMulti=" + this.isMulti + JefsClass.INDEX_URL + this.url + ",teamLeader=" + this.teamLeader + ",teamNum=" + this.teamNum + ",teamMaxNum=" + this.teamMaxNum + ",singleGroupText=" + this.singleGroupText + ",multiGroupText=" + this.multiGroupText + ",}";
    }
}
