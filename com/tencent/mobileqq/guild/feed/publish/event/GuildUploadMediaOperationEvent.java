package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildUploadMediaOperationEvent extends SimpleBaseEvent {
    private String mMainTaskId;
    private boolean mNeedSwitchThread = true;
    private boolean mOriginalPic;
    private Map<String, LocalMediaInfo> mTaskIdLocalMediaInfoMap;

    public String getMainTaskId() {
        return this.mMainTaskId;
    }

    public boolean getNeedSwitchThread() {
        return this.mNeedSwitchThread;
    }

    public boolean getOriginalPic() {
        return this.mOriginalPic;
    }

    public Map<String, LocalMediaInfo> getTaskIdLocalMediaInfoMap() {
        return this.mTaskIdLocalMediaInfoMap;
    }

    public void setMainTaskId(String str) {
        this.mMainTaskId = str;
    }

    public void setNeedSwitchThread(boolean z16) {
        this.mNeedSwitchThread = z16;
    }

    public void setOriginalPic(boolean z16) {
        this.mOriginalPic = z16;
    }

    public void setTaskIdLocalMediaInfoMap(Map<String, LocalMediaInfo> map) {
        this.mTaskIdLocalMediaInfoMap = map;
    }

    public String toString() {
        return "GuildUploadMediaOperationEvent{mMainTaskId='" + this.mMainTaskId + "', mTaskIdLocalMediaInfoMap=" + this.mTaskIdLocalMediaInfoMap + "} " + super.toString();
    }
}
