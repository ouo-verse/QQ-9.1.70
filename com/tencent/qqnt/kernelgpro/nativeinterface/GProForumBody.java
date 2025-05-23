package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProForumBody {
    public int everyHours;
    public ArrayList<GProForumChannel> forumChannel;
    public String requestId;
    public long updateTime;

    public GProForumBody() {
        this.forumChannel = new ArrayList<>();
        this.requestId = "";
    }

    public int getEveryHours() {
        return this.everyHours;
    }

    public ArrayList<GProForumChannel> getForumChannel() {
        return this.forumChannel;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String toString() {
        return "GProForumBody{forumChannel=" + this.forumChannel + ",updateTime=" + this.updateTime + ",everyHours=" + this.everyHours + ",requestId=" + this.requestId + ",}";
    }

    public GProForumBody(ArrayList<GProForumChannel> arrayList, long j3, int i3, String str) {
        new ArrayList();
        this.forumChannel = arrayList;
        this.updateTime = j3;
        this.everyHours = i3;
        this.requestId = str;
    }
}
