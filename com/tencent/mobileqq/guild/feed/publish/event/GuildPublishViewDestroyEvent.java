package com.tencent.mobileqq.guild.feed.publish.event;

import com.google.gson.annotations.SerializedName;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;

/* loaded from: classes13.dex */
public class GuildPublishViewDestroyEvent extends SimpleBaseEvent {

    @SerializedName(MiniAppGetGameTaskTicketServlet.KEY_TASKID)
    private String taskId;

    public GuildPublishViewDestroyEvent(String str) {
        this.taskId = "";
        if (str != null) {
            this.taskId = str;
        }
    }

    public String getTaskId() {
        return this.taskId;
    }
}
