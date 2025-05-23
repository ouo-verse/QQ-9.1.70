package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildPublishTaskChangeBean;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildModifyUploadTaskEvent extends SimpleBaseEvent {

    @GuildModifyTaskFlag
    public static final int FLAG_INIT = 0;

    @GuildModifyTaskFlag
    public static final int FLAG_TASK_LIST_CHANGE = 1;

    @GuildModifyTaskFlag
    public static final int FLAG_TASK_SINGLE_DELETE = 2;
    private GuildPublishTaskChangeBean changeBean;

    @GuildModifyTaskFlag
    private int flag;
    private String mainTaskId;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public @interface GuildModifyTaskFlag {
    }

    public GuildModifyUploadTaskEvent() {
        this.flag = 0;
    }

    public GuildPublishTaskChangeBean getChangeBean() {
        return this.changeBean;
    }

    public int getFlag() {
        return this.flag;
    }

    public String getMainTaskId() {
        return this.mainTaskId;
    }

    public void setChangeBean(GuildPublishTaskChangeBean guildPublishTaskChangeBean) {
        this.changeBean = guildPublishTaskChangeBean;
    }

    public void setFlag(int i3) {
        this.flag = i3;
    }

    public void setMainTaskId(String str) {
        this.mainTaskId = str;
    }

    public String toString() {
        return "GuildModifyUploadTaskEvent{mainTaskId='" + this.mainTaskId + "', changeBean=" + this.changeBean + ", flag=" + this.flag + '}';
    }

    public GuildModifyUploadTaskEvent(@GuildModifyTaskFlag int i3, String str, GuildPublishTaskChangeBean guildPublishTaskChangeBean) {
        this.flag = i3;
        this.changeBean = guildPublishTaskChangeBean;
        this.mainTaskId = str;
    }
}
