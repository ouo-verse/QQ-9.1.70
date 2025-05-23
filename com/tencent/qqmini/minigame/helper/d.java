package com.tencent.qqmini.minigame.helper;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0006\u0018\u00010\u0004H\u0016J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqmini/minigame/helper/d;", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "", "", "headers", "", "onDownloadHeadersReceived", "", "progress", "", "totalBytesWritten", "totalBytesExpectedToWrite", "onDownloadProgress", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public abstract class d implements DownloaderProxy.DownloadListener {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
    public void onDownloadHeadersReceived(int statusCode, @Nullable Map<String, List<String>> headers) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
    public void onDownloadProgress(float progress, long totalBytesWritten, long totalBytesExpectedToWrite) {
    }
}
