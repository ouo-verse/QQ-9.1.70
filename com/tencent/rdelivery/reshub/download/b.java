package com.tencent.rdelivery.reshub.download;

import com.tencent.raft.standard.net.IRDownload;
import jz3.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R$\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/rdelivery/reshub/download/b;", "", "", "a", "()Z", "Lcom/tencent/raft/standard/net/IRDownload$IRDownloadTask;", "Lcom/tencent/raft/standard/net/IRDownload$IRDownloadTask;", "b", "()Lcom/tencent/raft/standard/net/IRDownload$IRDownloadTask;", "d", "(Lcom/tencent/raft/standard/net/IRDownload$IRDownloadTask;)V", "rTask", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "resId", "<init>", "(Ljava/lang/String;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile IRDownload.IRDownloadTask rTask;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String resId;

    public b(@NotNull String resId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        this.resId = resId;
    }

    public final boolean a() {
        IRDownload.IRDownloadTask iRDownloadTask = this.rTask;
        if (iRDownloadTask != null) {
            return iRDownloadTask.cancel();
        }
        d.i("ResHubDownloadingTask", "No DownloadTask, Cannot Cancel.");
        return false;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final IRDownload.IRDownloadTask getRTask() {
        return this.rTask;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getResId() {
        return this.resId;
    }

    public final void d(@Nullable IRDownload.IRDownloadTask iRDownloadTask) {
        this.rTask = iRDownloadTask;
    }
}
