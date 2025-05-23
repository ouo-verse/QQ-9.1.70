package com.tencent.state.square.download;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000e\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/square/download/TaskProgress;", "", "()V", "data", "", "getData", "()[B", "setData", "([B)V", "progress", "", HippyQQPagView.FunctionName.GET_PROGRESS, "()J", HippyQQPagView.FunctionName.SET_PROGRESS, "(J)V", "size", "", "getSize", "()I", "setSize", "(I)V", "tmpFile", "Ljava/io/File;", "getTmpFile", "()Ljava/io/File;", "setTmpFile", "(Ljava/io/File;)V", "total", "getTotal", "setTotal", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class TaskProgress {

    @Nullable
    private byte[] data;
    private long progress;
    private int size;

    @Nullable
    private File tmpFile;
    private long total;

    @Nullable
    public final byte[] getData() {
        return this.data;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final int getSize() {
        return this.size;
    }

    @Nullable
    public final File getTmpFile() {
        return this.tmpFile;
    }

    public final long getTotal() {
        return this.total;
    }

    public final void setData(@Nullable byte[] bArr) {
        this.data = bArr;
    }

    public final void setProgress(long j3) {
        this.progress = j3;
    }

    public final void setSize(int i3) {
        this.size = i3;
    }

    public final void setTmpFile(@Nullable File file) {
        this.tmpFile = file;
    }

    public final void setTotal(long j3) {
        this.total = j3;
    }
}
