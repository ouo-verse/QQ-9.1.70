package com.tencent.state.square;

import com.tencent.state.square.IDownloadListener;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/DefaultDownloadListener;", "Lcom/tencent/state/square/IDownloadListener;", "()V", "onDownloadFinish", "", "tempFile", "Ljava/io/File;", "onTaskFailed", "errorCode", "", "errorMessage", "", "onTaskProgress", "tmpFile", "data", "", "size", "progress", "", "onTaskResponse", "contentLength", "onTaskStart", "onTaskSuccess", "resultFile", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public abstract class DefaultDownloadListener implements IDownloadListener {
    @Override // com.tencent.state.square.IDownloadListener
    public boolean onTaskCheckFile(@Nullable File file) {
        return IDownloadListener.DefaultImpls.onTaskCheckFile(this, file);
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onTaskFailed(int errorCode, @NotNull String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onTaskProgress(@NotNull File tmpFile, @NotNull byte[] data, int size, long progress) {
        Intrinsics.checkNotNullParameter(tmpFile, "tmpFile");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onTaskSuccess(@NotNull File resultFile) {
        Intrinsics.checkNotNullParameter(resultFile, "resultFile");
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onTaskStart() {
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onDownloadFinish(@Nullable File tempFile) {
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onTaskResponse(long contentLength) {
    }
}
