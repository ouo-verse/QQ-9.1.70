package com.tencent.mobileqq.opr.model;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/opr/model/TaskExtendResult;", "", "taskReportParams", "Lcom/tencent/mobileqq/opr/model/TaskReportParams;", "photoSize", "", "(Lcom/tencent/mobileqq/opr/model/TaskReportParams;I)V", "getPhotoSize", "()I", "setPhotoSize", "(I)V", "getTaskReportParams", "()Lcom/tencent/mobileqq/opr/model/TaskReportParams;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "opr_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final /* data */ class TaskExtendResult {
    static IPatchRedirector $redirector_;
    private int photoSize;

    @Nullable
    private final TaskReportParams taskReportParams;

    public TaskExtendResult(@Nullable TaskReportParams taskReportParams, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) taskReportParams, i3);
        } else {
            this.taskReportParams = taskReportParams;
            this.photoSize = i3;
        }
    }

    public static /* synthetic */ TaskExtendResult copy$default(TaskExtendResult taskExtendResult, TaskReportParams taskReportParams, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            taskReportParams = taskExtendResult.taskReportParams;
        }
        if ((i16 & 2) != 0) {
            i3 = taskExtendResult.photoSize;
        }
        return taskExtendResult.copy(taskReportParams, i3);
    }

    @Nullable
    public final TaskReportParams component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TaskReportParams) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.taskReportParams;
    }

    public final int component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.photoSize;
    }

    @NotNull
    public final TaskExtendResult copy(@Nullable TaskReportParams taskReportParams, int photoSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TaskExtendResult) iPatchRedirector.redirect((short) 8, (Object) this, (Object) taskReportParams, photoSize);
        }
        return new TaskExtendResult(taskReportParams, photoSize);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskExtendResult)) {
            return false;
        }
        TaskExtendResult taskExtendResult = (TaskExtendResult) other;
        if (Intrinsics.areEqual(this.taskReportParams, taskExtendResult.taskReportParams) && this.photoSize == taskExtendResult.photoSize) {
            return true;
        }
        return false;
    }

    public final int getPhotoSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.photoSize;
    }

    @Nullable
    public final TaskReportParams getTaskReportParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TaskReportParams) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.taskReportParams;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        TaskReportParams taskReportParams = this.taskReportParams;
        if (taskReportParams == null) {
            hashCode = 0;
        } else {
            hashCode = taskReportParams.hashCode();
        }
        return (hashCode * 31) + this.photoSize;
    }

    public final void setPhotoSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.photoSize = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "TaskExtendResult(taskReportParams=" + this.taskReportParams + ", photoSize=" + this.photoSize + ')';
    }

    public /* synthetic */ TaskExtendResult(TaskReportParams taskReportParams, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(taskReportParams, (i16 & 2) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, taskReportParams, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
