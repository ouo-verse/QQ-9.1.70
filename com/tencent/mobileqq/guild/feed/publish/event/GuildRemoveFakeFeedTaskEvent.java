package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildRemoveFakeFeedTaskEvent extends SimpleBaseEvent {
    private String mMainTaskId;
    private List<String> mMainTaskIdList;

    public String getMainTaskId() {
        return this.mMainTaskId;
    }

    public List<String> getMainTaskIdList() {
        return this.mMainTaskIdList;
    }

    public void setMainTaskId(String str) {
        this.mMainTaskId = str;
    }

    public void setMainTaskIdList(List<String> list) {
        this.mMainTaskIdList = list;
    }
}
