package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TeamUpTeamDetail implements Serializable {
    public long createTime;
    public long endTime;
    public long groupId;
    public boolean hasCreatedGroup;
    public boolean isJoined;
    public int joinLimit;
    public int joinType;
    public int joinedCnt;
    public long newGroupId;
    public int status;
    public int templateId;
    long serialVersionUID = 1;
    public String teamId = "";
    public String title = "";
    public String content = "";
    public ArrayList<TeamUpImage> images = new ArrayList<>();
    public TeamUpUser creator = new TeamUpUser();

    public String getContent() {
        return this.content;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public TeamUpUser getCreator() {
        return this.creator;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public boolean getHasCreatedGroup() {
        return this.hasCreatedGroup;
    }

    public ArrayList<TeamUpImage> getImages() {
        return this.images;
    }

    public boolean getIsJoined() {
        return this.isJoined;
    }

    public int getJoinLimit() {
        return this.joinLimit;
    }

    public int getJoinType() {
        return this.joinType;
    }

    public int getJoinedCnt() {
        return this.joinedCnt;
    }

    public long getNewGroupId() {
        return this.newGroupId;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "TeamUpTeamDetail{teamId=" + this.teamId + ",groupId=" + this.groupId + ",title=" + this.title + ",content=" + this.content + ",createTime=" + this.createTime + ",endTime=" + this.endTime + ",images=" + this.images + ",templateId=" + this.templateId + ",joinType=" + this.joinType + ",joinLimit=" + this.joinLimit + ",joinedCnt=" + this.joinedCnt + ",status=" + this.status + ",creator=" + this.creator + ",isJoined=" + this.isJoined + ",hasCreatedGroup=" + this.hasCreatedGroup + ",newGroupId=" + this.newGroupId + ",}";
    }
}
