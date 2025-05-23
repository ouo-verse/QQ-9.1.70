package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqmini/minigame/api/MiniDownloader;", "Lcom/tencent/mobileqq/triton/utils/Downloader;", "()V", "download", "", "url", "", "toPath", "Ljava/io/File;", "listener", "Lcom/tencent/mobileqq/triton/utils/Downloader$Listener;", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class MiniDownloader implements Downloader {
    public static final MiniDownloader INSTANCE = new MiniDownloader();

    MiniDownloader() {
    }

    @Override // com.tencent.mobileqq.triton.utils.Downloader
    public void download(@NotNull String url, @NotNull File toPath, @NotNull final Downloader.Listener listener) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(toPath, "toPath");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).download(url, null, toPath.getAbsolutePath(), 30, new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.minigame.api.MiniDownloader$download$1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadFailed(int statusCode, @Nullable String errorMsg) {
                Downloader.Listener listener2 = Downloader.Listener.this;
                if (errorMsg == null) {
                    errorMsg = "unknown failure";
                }
                listener2.onFail(errorMsg);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadProgress(float progress, long totalBytesWritten, long totalBytesExpectedToWrite) {
                Downloader.Listener.this.onProgress(totalBytesExpectedToWrite, totalBytesWritten);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadSucceed(int statusCode, @Nullable String filePath, @Nullable DownloaderProxy.DownloadListener.DownloadResult result) {
                Downloader.Listener.this.onSuccess();
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadHeadersReceived(int statusCode, @Nullable Map<String, List<String>> headers) {
            }
        });
    }
}
