package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.Map;

/* loaded from: classes13.dex */
public class GuildTriggerPublishOperationEvent extends SimpleBaseEvent {
    private boolean isEdit;
    private boolean isMileStoneFeed;
    private boolean isNewFeed;
    public int mBusinessType;
    private String mJson;
    private String mMainTaskId;
    public Map<String, LocalMediaInfo> mediaInfoMap;
    public boolean showSuccessToast = true;
    public boolean showFailToast = true;
    private boolean mIsPersonalGuildToBeCreated = false;

    public int getBusinessType() {
        return this.mBusinessType;
    }

    public String getJson() {
        return this.mJson;
    }

    public String getMainTaskId() {
        return this.mMainTaskId;
    }

    public boolean isEdit() {
        return this.isEdit;
    }

    public boolean isMileStoneFeed() {
        return this.isMileStoneFeed;
    }

    public boolean isNewFeed() {
        return this.isNewFeed;
    }

    public boolean isPersonalGuildToBeCreated() {
        return this.mIsPersonalGuildToBeCreated;
    }

    public void setBusinessType(int i3) {
        this.mBusinessType = i3;
    }

    public void setIsEdit(boolean z16) {
        this.isEdit = z16;
    }

    public void setJson(String str) {
        this.mJson = str;
    }

    public void setMainTaskId(String str) {
        this.mMainTaskId = str;
    }

    public void setMileStoneFeed(boolean z16) {
        this.isMileStoneFeed = z16;
    }

    public void setNewFeed(boolean z16) {
        this.isNewFeed = z16;
    }

    public void setPersonalGuildToBeCreated(boolean z16) {
        this.mIsPersonalGuildToBeCreated = z16;
    }

    public String toString() {
        Integer num;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GuildTriggerPublishOperationEvent{mMainTaskId='");
        sb5.append(this.mMainTaskId);
        sb5.append(", mIsEdit=");
        sb5.append(this.isEdit);
        sb5.append(", mIsPersonalGuildToBeCreated=");
        sb5.append(this.mIsPersonalGuildToBeCreated);
        sb5.append(", mIsNewFeed=");
        sb5.append(this.isNewFeed);
        sb5.append(", mJson.length=");
        String str = this.mJson;
        if (str != null) {
            num = Integer.valueOf(str.length());
        } else {
            num = null;
        }
        sb5.append(num);
        return sb5.toString();
    }
}
