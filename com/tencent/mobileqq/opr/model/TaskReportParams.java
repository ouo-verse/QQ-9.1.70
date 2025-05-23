package com.tencent.mobileqq.opr.model;

import androidx.annotation.Keep;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/opr/model/TaskReportParams;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "queueWaitingTimeMs", "executeTimeMs", "(III)V", "getExecuteTimeMs", "()I", "getQueueWaitingTimeMs", "getTaskId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "opr_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final /* data */ class TaskReportParams {
    static IPatchRedirector $redirector_;
    private final int executeTimeMs;
    private final int queueWaitingTimeMs;
    private final int taskId;

    public TaskReportParams(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.taskId = i3;
        this.queueWaitingTimeMs = i16;
        this.executeTimeMs = i17;
    }

    public static /* synthetic */ TaskReportParams copy$default(TaskReportParams taskReportParams, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            i3 = taskReportParams.taskId;
        }
        if ((i18 & 2) != 0) {
            i16 = taskReportParams.queueWaitingTimeMs;
        }
        if ((i18 & 4) != 0) {
            i17 = taskReportParams.executeTimeMs;
        }
        return taskReportParams.copy(i3, i16, i17);
    }

    public final int component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.taskId;
    }

    public final int component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.queueWaitingTimeMs;
    }

    public final int component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.executeTimeMs;
    }

    @NotNull
    public final TaskReportParams copy(int taskId, int queueWaitingTimeMs, int executeTimeMs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TaskReportParams) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(taskId), Integer.valueOf(queueWaitingTimeMs), Integer.valueOf(executeTimeMs));
        }
        return new TaskReportParams(taskId, queueWaitingTimeMs, executeTimeMs);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskReportParams)) {
            return false;
        }
        TaskReportParams taskReportParams = (TaskReportParams) other;
        if (this.taskId == taskReportParams.taskId && this.queueWaitingTimeMs == taskReportParams.queueWaitingTimeMs && this.executeTimeMs == taskReportParams.executeTimeMs) {
            return true;
        }
        return false;
    }

    public final int getExecuteTimeMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.executeTimeMs;
    }

    public final int getQueueWaitingTimeMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.queueWaitingTimeMs;
    }

    public final int getTaskId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.taskId;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return (((this.taskId * 31) + this.queueWaitingTimeMs) * 31) + this.executeTimeMs;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "TaskReportParams(taskId=" + this.taskId + ", queueWaitingTimeMs=" + this.queueWaitingTimeMs + ", executeTimeMs=" + this.executeTimeMs + ')';
    }
}
