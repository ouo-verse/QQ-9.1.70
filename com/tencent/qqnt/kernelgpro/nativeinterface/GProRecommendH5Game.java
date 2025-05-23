package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendH5Game implements Serializable {
    public GProRecommendGameInfo game;
    public ArrayList<GProRecommendMsg> members;
    public long readyExpireTime;
    long serialVersionUID;
    public long teamId;
    public int teamStatus;

    public GProRecommendH5Game() {
        this.serialVersionUID = 1L;
        this.game = new GProRecommendGameInfo();
        this.members = new ArrayList<>();
    }

    public GProRecommendGameInfo getGame() {
        return this.game;
    }

    public ArrayList<GProRecommendMsg> getMembers() {
        return this.members;
    }

    public long getReadyExpireTime() {
        return this.readyExpireTime;
    }

    public long getTeamId() {
        return this.teamId;
    }

    public int getTeamStatus() {
        return this.teamStatus;
    }

    public String toString() {
        return "GProRecommendH5Game{teamId=" + this.teamId + ",teamStatus=" + this.teamStatus + ",game=" + this.game + ",members=" + this.members + ",readyExpireTime=" + this.readyExpireTime + ",}";
    }

    public GProRecommendH5Game(long j3, int i3, GProRecommendGameInfo gProRecommendGameInfo, ArrayList<GProRecommendMsg> arrayList, long j16) {
        this.serialVersionUID = 1L;
        this.game = new GProRecommendGameInfo();
        new ArrayList();
        this.teamId = j3;
        this.teamStatus = i3;
        this.game = gProRecommendGameInfo;
        this.members = arrayList;
        this.readyExpireTime = j16;
    }
}
