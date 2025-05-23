package com.tencent.state.status;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/status/FinishStatusInfo;", "", "finish", "", "taskInfo", "Lcom/tencent/state/status/PanelStatusTaskInfo;", "(ZLcom/tencent/state/status/PanelStatusTaskInfo;)V", "getFinish", "()Z", "setFinish", "(Z)V", "getTaskInfo", "()Lcom/tencent/state/status/PanelStatusTaskInfo;", "setTaskInfo", "(Lcom/tencent/state/status/PanelStatusTaskInfo;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class FinishStatusInfo {
    private boolean finish;
    private PanelStatusTaskInfo taskInfo;

    public FinishStatusInfo() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getFinish() {
        return this.finish;
    }

    /* renamed from: component2, reason: from getter */
    public final PanelStatusTaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public final FinishStatusInfo copy(boolean finish, PanelStatusTaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        return new FinishStatusInfo(finish, taskInfo);
    }

    public final boolean getFinish() {
        return this.finish;
    }

    public final PanelStatusTaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.finish;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        PanelStatusTaskInfo panelStatusTaskInfo = this.taskInfo;
        return i3 + (panelStatusTaskInfo != null ? panelStatusTaskInfo.hashCode() : 0);
    }

    public final void setFinish(boolean z16) {
        this.finish = z16;
    }

    public final void setTaskInfo(PanelStatusTaskInfo panelStatusTaskInfo) {
        Intrinsics.checkNotNullParameter(panelStatusTaskInfo, "<set-?>");
        this.taskInfo = panelStatusTaskInfo;
    }

    public String toString() {
        return "FinishStatusInfo(finish=" + this.finish + ", taskInfo=" + this.taskInfo + ")";
    }

    public FinishStatusInfo(boolean z16, PanelStatusTaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        this.finish = z16;
        this.taskInfo = taskInfo;
    }

    public /* synthetic */ FinishStatusInfo(boolean z16, PanelStatusTaskInfo panelStatusTaskInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? new PanelStatusTaskInfo(0, 0, null, null, 0, 31, null) : panelStatusTaskInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FinishStatusInfo)) {
            return false;
        }
        FinishStatusInfo finishStatusInfo = (FinishStatusInfo) other;
        return this.finish == finishStatusInfo.finish && Intrinsics.areEqual(this.taskInfo, finishStatusInfo.taskInfo);
    }

    public static /* synthetic */ FinishStatusInfo copy$default(FinishStatusInfo finishStatusInfo, boolean z16, PanelStatusTaskInfo panelStatusTaskInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = finishStatusInfo.finish;
        }
        if ((i3 & 2) != 0) {
            panelStatusTaskInfo = finishStatusInfo.taskInfo;
        }
        return finishStatusInfo.copy(z16, panelStatusTaskInfo);
    }
}
