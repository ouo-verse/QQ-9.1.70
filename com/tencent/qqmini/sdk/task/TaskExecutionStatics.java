package com.tencent.qqmini.sdk.task;

import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001'BO\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012\u00a8\u0006("}, d2 = {"Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "", "name", "", "runDurationMs", "", "totalRunDurationMs", "status", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics$Status;", "message", "subSteps", "", "startTime", "(Ljava/lang/String;JJLcom/tencent/qqmini/sdk/task/TaskExecutionStatics$Status;Ljava/lang/String;Ljava/util/List;J)V", "getMessage", "()Ljava/lang/String;", "getName", "getRunDurationMs", "()J", "getStartTime", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics$Status;", "getSubSteps", "()Ljava/util/List;", "getTotalRunDurationMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "Status", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final /* data */ class TaskExecutionStatics {

    @NotNull
    private final String message;

    @NotNull
    private final String name;
    private final long runDurationMs;
    private final long startTime;

    @NotNull
    private final Status status;

    @NotNull
    private final List<TaskExecutionStatics> subSteps;
    private final long totalRunDurationMs;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics$Status;", "", "(Ljava/lang/String;I)V", "WAIT", DebugCoroutineInfoImplKt.RUNNING, "SUCCESS", Tracker.FAIL, "CACHED", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public enum Status {
        WAIT,
        RUNNING,
        SUCCESS,
        FAIL,
        CACHED
    }

    @JvmOverloads
    public TaskExecutionStatics(@NotNull String str, long j3) {
        this(str, j3, 0L, null, null, null, 0L, 124, null);
    }

    public static /* synthetic */ TaskExecutionStatics copy$default(TaskExecutionStatics taskExecutionStatics, String str, long j3, long j16, Status status, String str2, List list, long j17, int i3, Object obj) {
        String str3;
        long j18;
        long j19;
        Status status2;
        String str4;
        List list2;
        long j26;
        if ((i3 & 1) != 0) {
            str3 = taskExecutionStatics.name;
        } else {
            str3 = str;
        }
        if ((i3 & 2) != 0) {
            j18 = taskExecutionStatics.runDurationMs;
        } else {
            j18 = j3;
        }
        if ((i3 & 4) != 0) {
            j19 = taskExecutionStatics.totalRunDurationMs;
        } else {
            j19 = j16;
        }
        if ((i3 & 8) != 0) {
            status2 = taskExecutionStatics.status;
        } else {
            status2 = status;
        }
        if ((i3 & 16) != 0) {
            str4 = taskExecutionStatics.message;
        } else {
            str4 = str2;
        }
        if ((i3 & 32) != 0) {
            list2 = taskExecutionStatics.subSteps;
        } else {
            list2 = list;
        }
        if ((i3 & 64) != 0) {
            j26 = taskExecutionStatics.startTime;
        } else {
            j26 = j17;
        }
        return taskExecutionStatics.copy(str3, j18, j19, status2, str4, list2, j26);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final long getRunDurationMs() {
        return this.runDurationMs;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTotalRunDurationMs() {
        return this.totalRunDurationMs;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final List<TaskExecutionStatics> component6() {
        return this.subSteps;
    }

    /* renamed from: component7, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final TaskExecutionStatics copy(@NotNull String name, long runDurationMs, long totalRunDurationMs, @NotNull Status status, @NotNull String message, @NotNull List<TaskExecutionStatics> subSteps, long startTime) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(status, "status");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(subSteps, "subSteps");
        return new TaskExecutionStatics(name, runDurationMs, totalRunDurationMs, status, message, subSteps, startTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof TaskExecutionStatics) {
                TaskExecutionStatics taskExecutionStatics = (TaskExecutionStatics) other;
                if (!Intrinsics.areEqual(this.name, taskExecutionStatics.name) || this.runDurationMs != taskExecutionStatics.runDurationMs || this.totalRunDurationMs != taskExecutionStatics.totalRunDurationMs || !Intrinsics.areEqual(this.status, taskExecutionStatics.status) || !Intrinsics.areEqual(this.message, taskExecutionStatics.message) || !Intrinsics.areEqual(this.subSteps, taskExecutionStatics.subSteps) || this.startTime != taskExecutionStatics.startTime) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final long getRunDurationMs() {
        return this.runDurationMs;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final Status getStatus() {
        return this.status;
    }

    @NotNull
    public final List<TaskExecutionStatics> getSubSteps() {
        return this.subSteps;
    }

    public final long getTotalRunDurationMs() {
        return this.totalRunDurationMs;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.name;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        long j3 = this.runDurationMs;
        int i19 = ((i3 * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j16 = this.totalRunDurationMs;
        int i26 = (i19 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        Status status = this.status;
        if (status != null) {
            i16 = status.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i17 = str2.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        List<TaskExecutionStatics> list = this.subSteps;
        if (list != null) {
            i18 = list.hashCode();
        }
        int i29 = (i28 + i18) * 31;
        long j17 = this.startTime;
        return i29 + ((int) (j17 ^ (j17 >>> 32)));
    }

    @NotNull
    public String toString() {
        return "TaskExecutionStatics(name=" + this.name + ", runDurationMs=" + this.runDurationMs + ", totalRunDurationMs=" + this.totalRunDurationMs + ", status=" + this.status + ", message=" + this.message + ", subSteps=" + this.subSteps + ", startTime=" + this.startTime + ")";
    }

    @JvmOverloads
    public TaskExecutionStatics(@NotNull String str, long j3, long j16) {
        this(str, j3, j16, null, null, null, 0L, 120, null);
    }

    @JvmOverloads
    public TaskExecutionStatics(@NotNull String str, long j3, long j16, @NotNull Status status) {
        this(str, j3, j16, status, null, null, 0L, 112, null);
    }

    @JvmOverloads
    public TaskExecutionStatics(@NotNull String str, long j3, long j16, @NotNull Status status, @NotNull String str2) {
        this(str, j3, j16, status, str2, null, 0L, 96, null);
    }

    @JvmOverloads
    public TaskExecutionStatics(@NotNull String str, long j3, long j16, @NotNull Status status, @NotNull String str2, @NotNull List<TaskExecutionStatics> list) {
        this(str, j3, j16, status, str2, list, 0L, 64, null);
    }

    @JvmOverloads
    public TaskExecutionStatics(@NotNull String name, long j3, long j16, @NotNull Status status, @NotNull String message, @NotNull List<TaskExecutionStatics> subSteps, long j17) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(status, "status");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(subSteps, "subSteps");
        this.name = name;
        this.runDurationMs = j3;
        this.totalRunDurationMs = j16;
        this.status = status;
        this.message = message;
        this.subSteps = subSteps;
        this.startTime = j17;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TaskExecutionStatics(String str, long j3, long j16, Status status, String str2, List list, long j17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, r5, r7, r8, r9, (i3 & 64) != 0 ? 0L : j17);
        List list2;
        List emptyList;
        long j18 = (i3 & 4) != 0 ? j3 : j16;
        Status status2 = (i3 & 8) != 0 ? Status.SUCCESS : status;
        String str3 = (i3 & 16) != 0 ? "" : str2;
        if ((i3 & 32) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
    }
}
