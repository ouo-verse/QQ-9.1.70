package com.tencent.mobileqq.minigame.api;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.utils.Downloader;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/QQMiniDownloader;", "Lcom/tencent/mobileqq/triton/utils/Downloader;", "()V", "download", "", "url", "", "toPath", "Ljava/io/File;", "listener", "Lcom/tencent/mobileqq/triton/utils/Downloader$Listener;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQMiniDownloader implements Downloader {
    public static final QQMiniDownloader INSTANCE = new QQMiniDownloader();

    QQMiniDownloader() {
    }

    @Override // com.tencent.mobileqq.triton.utils.Downloader
    public void download(String url, File toPath, final Downloader.Listener listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(toPath, "toPath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        MiniappDownloadUtil.getInstance().download(url, toPath.getAbsolutePath(), true, new Downloader.DownloadListener() { // from class: com.tencent.mobileqq.minigame.api.QQMiniDownloader$download$1
            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadCanceled(String p06) {
                Downloader.Listener.this.onFail("cancled " + p06);
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadFailed(String p06, DownloadResult p16) {
                Downloader.Listener.this.onFail("failed " + p06 + " " + p16);
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadProgress(String p06, long all, float percent) {
                Downloader.Listener.this.onProgress(((float) all) * percent, all);
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadSucceed(String p06, DownloadResult p16) {
                Downloader.Listener.this.onSuccess();
            }
        }, Downloader.DownloadMode.FastMode, null);
        GameLog.getInstance().i("[download]", "from:" + url + ", to:" + toPath);
    }
}
