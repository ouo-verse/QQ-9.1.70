package com.tencent.state.square.download;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/download/TaskResponse;", "", "source", "Lcom/tencent/state/square/download/Source;", "result", "Ljava/io/File;", "(Lcom/tencent/state/square/download/Source;Ljava/io/File;)V", "contentLength", "", "getContentLength", "()J", "setContentLength", "(J)V", "errorCode", "", "getErrorCode", "()I", "setErrorCode", "(I)V", "getResult", "()Ljava/io/File;", "getSource", "()Lcom/tencent/state/square/download/Source;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class TaskResponse {
    private long contentLength;
    private int errorCode;

    @NotNull
    private final File result;

    @NotNull
    private final Source source;

    public TaskResponse(@NotNull Source source, @NotNull File result) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(result, "result");
        this.source = source;
        this.result = result;
        this.contentLength = -1L;
    }

    public static /* synthetic */ TaskResponse copy$default(TaskResponse taskResponse, Source source, File file, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            source = taskResponse.source;
        }
        if ((i3 & 2) != 0) {
            file = taskResponse.result;
        }
        return taskResponse.copy(source, file);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final File getResult() {
        return this.result;
    }

    @NotNull
    public final TaskResponse copy(@NotNull Source source, @NotNull File result) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(result, "result");
        return new TaskResponse(source, result);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof TaskResponse) {
                TaskResponse taskResponse = (TaskResponse) other;
                if (!Intrinsics.areEqual(this.source, taskResponse.source) || !Intrinsics.areEqual(this.result, taskResponse.result)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getContentLength() {
        return this.contentLength;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final File getResult() {
        return this.result;
    }

    @NotNull
    public final Source getSource() {
        return this.source;
    }

    public int hashCode() {
        int i3;
        Source source = this.source;
        int i16 = 0;
        if (source != null) {
            i3 = source.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        File file = this.result;
        if (file != null) {
            i16 = file.hashCode();
        }
        return i17 + i16;
    }

    public final void setContentLength(long j3) {
        this.contentLength = j3;
    }

    public final void setErrorCode(int i3) {
        this.errorCode = i3;
    }

    @NotNull
    public String toString() {
        return "TaskResponse(source=" + this.source + ", result=" + this.result + ")";
    }
}
