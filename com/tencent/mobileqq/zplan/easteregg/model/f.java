package com.tencent.mobileqq.zplan.easteregg.model;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H&R\u001c\u0010\r\u001a\u00020\u00058&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/model/f;", "", "task", "", "b", "", "seq", "a", "c", "getTaskId", "()J", "setTaskId", "(J)V", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface f {
    boolean a(long seq);

    boolean b(@NotNull f task);

    boolean c(@NotNull f task);

    long getTaskId();
}
