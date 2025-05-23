package cooperation.qqcircle.relation.entitys;

import feedcloud.FeedCloudMeta$StRelationInfo;

/* compiled from: P */
/* loaded from: classes28.dex */
public class NewRelationInfo {
    private int mGroupFlag = 0;
    private String mGroupId = "";
    private FeedCloudMeta$StRelationInfo mRelationInfo;

    public int getGroupFlag() {
        return this.mGroupFlag;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public FeedCloudMeta$StRelationInfo getRelationInfo() {
        return this.mRelationInfo;
    }

    public void setGroupFlag(int i3) {
        this.mGroupFlag = i3;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public void setRelationInfo(FeedCloudMeta$StRelationInfo feedCloudMeta$StRelationInfo) {
        this.mRelationInfo = feedCloudMeta$StRelationInfo;
    }
}
