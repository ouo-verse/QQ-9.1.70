package com.tencent.rdelivery.reshub.download;

import com.tencent.raft.standard.net.IRDownload;
import com.tencent.rdelivery.reshub.core.g;
import java.util.Map;
import jz3.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0011\u0010\u0012J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J<\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bR\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/rdelivery/reshub/download/c;", "", "", "Lcom/tencent/raft/standard/net/IRDownload$DownloadPriority;", "b", "", "url", "path", "Lcom/tencent/raft/standard/net/IRDownload$IDownloadCallback;", "callback", "priority", "", "extraInfo", "", "a", "Ljava/lang/String;", "resId", "<init>", "(Ljava/lang/String;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String resId;

    public c(@NotNull String resId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        this.resId = resId;
    }

    private final IRDownload.DownloadPriority b(long j3) {
        if (j3 == 2) {
            return IRDownload.DownloadPriority.Highest;
        }
        if (j3 == 1) {
            return IRDownload.DownloadPriority.High;
        }
        if (j3 == 0) {
            return IRDownload.DownloadPriority.Normal;
        }
        if (j3 == -1) {
            return IRDownload.DownloadPriority.Low;
        }
        return IRDownload.DownloadPriority.Normal;
    }

    public final void a(@NotNull String url, @NotNull String path, @NotNull IRDownload.IDownloadCallback callback, long priority, @Nullable Map<String, String> extraInfo) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        b bVar = new b(this.resId);
        DownloadingTaskManager.f364485b.f(bVar);
        bVar.d(g.e().downloadWithUrl(url, path, b(priority), new a(callback, bVar), extraInfo));
        if (bVar.getRTask() == null) {
            d.i("ResHubFileDownloader", "DownloadDelegate Not Returns DownloadTask.");
        }
    }
}
