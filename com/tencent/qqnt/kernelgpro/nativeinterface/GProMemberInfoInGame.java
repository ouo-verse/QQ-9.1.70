package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMemberInfoInGame implements Serializable {
    public int gameIdentity;
    public int gameStatus;
    public long gameStatusUpdateTimestampMs;
    public int gradeLevel;
    public long joinTimestampMs;
    public long roomId;
    public long tinyId;
    long serialVersionUID = 1;
    public String nickName = "";
    public String heroName = "";
    public String heroPic = "";
    public String record = "";
    public String schema = "";
    public ArrayList<String> goodHeroIconList = new ArrayList<>();
    public String honorIcon = "";
    public String honorDesc = "";
    public String identityDesc = "";
    public String backgroundPic = "";
    public String gradeLevelIcon = "";

    public String getBackgroundPic() {
        return this.backgroundPic;
    }

    public int getGameIdentity() {
        return this.gameIdentity;
    }

    public int getGameStatus() {
        return this.gameStatus;
    }

    public long getGameStatusUpdateTimestampMs() {
        return this.gameStatusUpdateTimestampMs;
    }

    public ArrayList<String> getGoodHeroIconList() {
        return this.goodHeroIconList;
    }

    public int getGradeLevel() {
        return this.gradeLevel;
    }

    public String getGradeLevelIcon() {
        return this.gradeLevelIcon;
    }

    public String getHeroName() {
        return this.heroName;
    }

    public String getHeroPic() {
        return this.heroPic;
    }

    public String getHonorDesc() {
        return this.honorDesc;
    }

    public String getHonorIcon() {
        return this.honorIcon;
    }

    public String getIdentityDesc() {
        return this.identityDesc;
    }

    public long getJoinTimestampMs() {
        return this.joinTimestampMs;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getRecord() {
        return this.record;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String getSchema() {
        return this.schema;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProMemberInfoInGame{tinyId=" + this.tinyId + ",roomId=" + this.roomId + ",nickName=" + this.nickName + ",heroName=" + this.heroName + ",heroPic=" + this.heroPic + ",gameStatus=" + this.gameStatus + ",record=" + this.record + ",joinTimestampMs=" + this.joinTimestampMs + ",gameIdentity=" + this.gameIdentity + ",gameStatusUpdateTimestampMs=" + this.gameStatusUpdateTimestampMs + ",schema=" + this.schema + ",goodHeroIconList=" + this.goodHeroIconList + ",honorIcon=" + this.honorIcon + ",honorDesc=" + this.honorDesc + ",identityDesc=" + this.identityDesc + ",gradeLevel=" + this.gradeLevel + ",backgroundPic=" + this.backgroundPic + ",gradeLevelIcon=" + this.gradeLevelIcon + ",}";
    }
}
