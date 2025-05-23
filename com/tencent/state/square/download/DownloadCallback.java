package com.tencent.state.square.download;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/download/DownloadCallback;", "", "onTaskFailed", "", "source", "Lcom/tencent/state/square/download/Source;", "response", "Lcom/tencent/state/square/download/TaskResponse;", "onTaskProgress", "progress", "Lcom/tencent/state/square/download/TaskProgress;", "onTaskStart", "onTaskSuccess", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface DownloadCallback {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static void onTaskProgress(@NotNull DownloadCallback downloadCallback, @NotNull Source source, @NotNull TaskResponse response, @NotNull TaskProgress progress) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(progress, "progress");
        }

        public static void onTaskStart(@NotNull DownloadCallback downloadCallback, @NotNull Source source, @NotNull TaskResponse response) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(response, "response");
        }
    }

    void onTaskFailed(@NotNull Source source, @NotNull TaskResponse response);

    void onTaskProgress(@NotNull Source source, @NotNull TaskResponse response, @NotNull TaskProgress progress);

    void onTaskStart(@NotNull Source source, @NotNull TaskResponse response);

    void onTaskSuccess(@NotNull Source source, @NotNull TaskResponse response);
}
