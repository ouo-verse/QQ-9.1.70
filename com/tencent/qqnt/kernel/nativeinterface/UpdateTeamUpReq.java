package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UpdateTeamUpReq {
    public int joinType;
    public String teamId = "";
    public String title = "";
    public String content = "";
    public ArrayList<TeamUpImage> images = new ArrayList<>();

    public String getContent() {
        return this.content;
    }

    public ArrayList<TeamUpImage> getImages() {
        return this.images;
    }

    public int getJoinType() {
        return this.joinType;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "UpdateTeamUpReq{teamId=" + this.teamId + ",title=" + this.title + ",content=" + this.content + ",images=" + this.images + ",joinType=" + this.joinType + ",}";
    }
}
