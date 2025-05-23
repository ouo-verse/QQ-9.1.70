package com.tencent.minibox.proxy;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u0017\u001a\u00020\u0005H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/minibox/proxy/MiniBoxProxy;", "", "downloadFile", "", "url", "", "targetPath", "callback", "Lcom/tencent/minibox/proxy/IDownloadCallback;", "getExecutorProxy", "Lcom/tencent/minibox/proxy/ExecutorProxy;", "getHostInfoProxy", "Lcom/tencent/minibox/proxy/HostInfoProxy;", "getHostNotifyProxy", "Lcom/tencent/minibox/proxy/HostNotifyProxy;", "getLogProxy", "Lcom/tencent/minibox/proxy/LogProxy;", "getMiniBoxGameUpgradeProxy", "Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy;", "getPermissionProxy", "Lcom/tencent/minibox/proxy/PermissionProxy;", "getReportProxy", "Lcom/tencent/minibox/proxy/ReportProxy;", "getUin", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public interface MiniBoxProxy {
    void downloadFile(@NotNull String url, @NotNull String targetPath, @NotNull IDownloadCallback callback);

    @Nullable
    ExecutorProxy getExecutorProxy();

    @Nullable
    HostInfoProxy getHostInfoProxy();

    @Nullable
    HostNotifyProxy getHostNotifyProxy();

    @Nullable
    LogProxy getLogProxy();

    @Nullable
    MiniBoxGameUpgradeProxy getMiniBoxGameUpgradeProxy();

    @Nullable
    PermissionProxy getPermissionProxy();

    @Nullable
    ReportProxy getReportProxy();

    @NotNull
    String getUin();
}
