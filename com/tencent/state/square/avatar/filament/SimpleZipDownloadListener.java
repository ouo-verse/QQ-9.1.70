package com.tencent.state.square.avatar.filament;

import com.tencent.state.square.IDownloadListener;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J(\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/avatar/filament/SimpleZipDownloadListener;", "Lcom/tencent/state/square/IDownloadListener;", "()V", "onDownloadFinish", "", "tempFile", "Ljava/io/File;", "onTaskProgress", "tmpFile", "data", "", "size", "", "progress", "", "onTaskResponse", "contentLength", "onTaskStart", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class SimpleZipDownloadListener implements IDownloadListener {
    @Override // com.tencent.state.square.IDownloadListener
    public boolean onTaskCheckFile(File file) {
        return IDownloadListener.DefaultImpls.onTaskCheckFile(this, file);
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onTaskProgress(File tmpFile, byte[] data, int size, long progress) {
        Intrinsics.checkNotNullParameter(tmpFile, "tmpFile");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onTaskStart() {
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onDownloadFinish(File tempFile) {
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onTaskResponse(long contentLength) {
    }
}
