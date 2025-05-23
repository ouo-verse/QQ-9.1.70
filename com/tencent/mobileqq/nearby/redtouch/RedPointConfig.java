package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import java.io.Serializable;

/* loaded from: classes15.dex */
public class RedPointConfig implements Serializable {
    private static final long serialVersionUID = 1;
    public int bindLevel;
    public int passThroughLevel;
    public int priority;
    public int redPointId;
    public int taskId;

    public String toString() {
        return MiniAppGetGameTaskTicketServlet.KEY_TASKID + ":" + this.taskId + "|redPointId:" + this.redPointId + "|passThroughLevel:" + this.passThroughLevel + "|bindLevel:" + this.bindLevel + "|priority:" + this.priority;
    }
}
