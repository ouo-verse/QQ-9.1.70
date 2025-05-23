package com.tencent.state.square.download;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.state.square.download.SquareDownloader;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\nH\u00c6\u0003J7\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\bH\u00d6\u0001J\t\u0010#\u001a\u00020\u0011H\u00d6\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/state/square/download/TaskRequest;", "", "source", "Lcom/tencent/state/square/download/Source;", "callback", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/state/square/download/DownloadCallback;", "priority", "", "reporter", "Lcom/tencent/state/square/download/SquareDownloader$Reporter;", "(Lcom/tencent/state/square/download/Source;Ljava/util/concurrent/CopyOnWriteArrayList;ILcom/tencent/state/square/download/SquareDownloader$Reporter;)V", "getCallback", "()Ljava/util/concurrent/CopyOnWriteArrayList;", IECSearchBar.METHOD_SET_CALLBACK, "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "key", "", "getKey", "()Ljava/lang/String;", "getPriority", "()I", "getReporter", "()Lcom/tencent/state/square/download/SquareDownloader$Reporter;", "getSource", "()Lcom/tencent/state/square/download/Source;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class TaskRequest {

    @NotNull
    private CopyOnWriteArrayList<DownloadCallback> callback;

    @NotNull
    private final String key;
    private final int priority;

    @NotNull
    private final SquareDownloader.Reporter reporter;

    @NotNull
    private final Source source;

    public TaskRequest(@NotNull Source source, @NotNull CopyOnWriteArrayList<DownloadCallback> callback, int i3, @NotNull SquareDownloader.Reporter reporter) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.source = source;
        this.callback = callback;
        this.priority = i3;
        this.reporter = reporter;
        this.key = source.getRemoteUrl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskRequest copy$default(TaskRequest taskRequest, Source source, CopyOnWriteArrayList copyOnWriteArrayList, int i3, SquareDownloader.Reporter reporter, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            source = taskRequest.source;
        }
        if ((i16 & 2) != 0) {
            copyOnWriteArrayList = taskRequest.callback;
        }
        if ((i16 & 4) != 0) {
            i3 = taskRequest.priority;
        }
        if ((i16 & 8) != 0) {
            reporter = taskRequest.reporter;
        }
        return taskRequest.copy(source, copyOnWriteArrayList, i3, reporter);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    @NotNull
    public final CopyOnWriteArrayList<DownloadCallback> component2() {
        return this.callback;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final SquareDownloader.Reporter getReporter() {
        return this.reporter;
    }

    @NotNull
    public final TaskRequest copy(@NotNull Source source, @NotNull CopyOnWriteArrayList<DownloadCallback> callback, int priority, @NotNull SquareDownloader.Reporter reporter) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        return new TaskRequest(source, callback, priority, reporter);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof TaskRequest) {
                TaskRequest taskRequest = (TaskRequest) other;
                if (!Intrinsics.areEqual(this.source, taskRequest.source) || !Intrinsics.areEqual(this.callback, taskRequest.callback) || this.priority != taskRequest.priority || !Intrinsics.areEqual(this.reporter, taskRequest.reporter)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final CopyOnWriteArrayList<DownloadCallback> getCallback() {
        return this.callback;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public final int getPriority() {
        return this.priority;
    }

    @NotNull
    public final SquareDownloader.Reporter getReporter() {
        return this.reporter;
    }

    @NotNull
    public final Source getSource() {
        return this.source;
    }

    public int hashCode() {
        int i3;
        int i16;
        Source source = this.source;
        int i17 = 0;
        if (source != null) {
            i3 = source.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        CopyOnWriteArrayList<DownloadCallback> copyOnWriteArrayList = this.callback;
        if (copyOnWriteArrayList != null) {
            i16 = copyOnWriteArrayList.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (((i18 + i16) * 31) + this.priority) * 31;
        SquareDownloader.Reporter reporter = this.reporter;
        if (reporter != null) {
            i17 = reporter.hashCode();
        }
        return i19 + i17;
    }

    public final void setCallback(@NotNull CopyOnWriteArrayList<DownloadCallback> copyOnWriteArrayList) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        this.callback = copyOnWriteArrayList;
    }

    @NotNull
    public String toString() {
        return "TaskRequest(source=" + this.source + ", callback=" + this.callback + ", priority=" + this.priority + ", reporter=" + this.reporter + ")";
    }

    public /* synthetic */ TaskRequest(Source source, CopyOnWriteArrayList copyOnWriteArrayList, int i3, SquareDownloader.Reporter reporter, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(source, copyOnWriteArrayList, i3, (i16 & 8) != 0 ? new SquareDownloader.Reporter() : reporter);
    }
}
