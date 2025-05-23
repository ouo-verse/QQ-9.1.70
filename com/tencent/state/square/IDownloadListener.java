package com.tencent.state.square;

import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J(\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0013H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0005H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/IDownloadListener;", "", "onDownloadFinish", "", "tempFile", "Ljava/io/File;", "onTaskCheckFile", "", "onTaskFailed", "errorCode", "", "errorMessage", "", "onTaskProgress", "tmpFile", "data", "", "size", "progress", "", "onTaskResponse", "contentLength", "onTaskStart", "onTaskSuccess", "resultFile", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface IDownloadListener {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static boolean onTaskCheckFile(@NotNull IDownloadListener iDownloadListener, @Nullable File file) {
            return true;
        }
    }

    void onDownloadFinish(@Nullable File tempFile);

    boolean onTaskCheckFile(@Nullable File tempFile);

    void onTaskFailed(int errorCode, @NotNull String errorMessage);

    void onTaskProgress(@NotNull File tmpFile, @NotNull byte[] data, int size, long progress);

    void onTaskResponse(long contentLength);

    void onTaskStart();

    void onTaskSuccess(@NotNull File resultFile);
}
