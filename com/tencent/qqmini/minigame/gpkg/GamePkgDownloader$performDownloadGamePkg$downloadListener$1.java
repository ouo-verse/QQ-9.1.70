package com.tencent.qqmini.minigame.gpkg;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/qqmini/minigame/gpkg/GamePkgDownloader$performDownloadGamePkg$downloadListener$1", "Lcom/tencent/qqmini/minigame/helper/d;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "errorMsg", "", "onDownloadFailed", "filePath", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult;", "result", "onDownloadSucceed", "", "progress", "", "totalBytesWritten", "totalBytesExpectedToWrite", "onDownloadProgress", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class GamePkgDownloader$performDownloadGamePkg$downloadListener$1 extends com.tencent.qqmini.minigame.helper.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GamePkgDownloadHandler f346420a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f346421b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MiniAppInfo f346422c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f346423d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ File f346424e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f346425f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GamePkgDownloader$performDownloadGamePkg$downloadListener$1(GamePkgDownloadHandler gamePkgDownloadHandler, long j3, MiniAppInfo miniAppInfo, String str, File file, String str2) {
        this.f346420a = gamePkgDownloadHandler;
        this.f346421b = j3;
        this.f346422c = miniAppInfo;
        this.f346423d = str;
        this.f346424e = file;
        this.f346425f = str2;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
    public void onDownloadFailed(int statusCode, @Nullable String errorMsg) {
        this.f346420a.g("download fail, code=" + statusCode + ", errorMsg=" + errorMsg);
    }

    @Override // com.tencent.qqmini.minigame.helper.d, com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
    public void onDownloadProgress(float progress, long totalBytesWritten, long totalBytesExpectedToWrite) {
        int i3;
        if (totalBytesExpectedToWrite == 0 && (i3 = this.f346422c.fileSize) > 0) {
            totalBytesExpectedToWrite = i3;
            if (totalBytesExpectedToWrite > totalBytesWritten) {
                progress = (((float) totalBytesWritten) * 1.0f) / ((float) totalBytesExpectedToWrite);
            }
        }
        this.f346420a.h(progress, totalBytesExpectedToWrite);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
    public void onDownloadSucceed(int statusCode, @Nullable String filePath, @Nullable DownloaderProxy.DownloadListener.DownloadResult result) {
        final long currentTimeMillis = System.currentTimeMillis() - this.f346421b;
        ThreadManager.runNetTask(new Runnable() { // from class: com.tencent.qqmini.minigame.gpkg.GamePkgDownloader$performDownloadGamePkg$downloadListener$1$onDownloadSucceed$1
            @Override // java.lang.Runnable
            public final void run() {
                GamePkgDownloader.f346415a.h(GamePkgDownloader$performDownloadGamePkg$downloadListener$1.this.f346422c, currentTimeMillis);
            }
        });
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        try {
            booleanRef.element = WxapkgUnpacker.unpackSync(GpkgManager.getGpkgFilePath(this.f346423d), this.f346424e.getAbsolutePath());
        } catch (IOException e16) {
            QMLog.e("GamePkgDownloader", "onGamePkgDownloadSuccess: unpack failed.", e16);
        }
        if (booleanRef.element) {
            if (c.d(this.f346422c)) {
                GamePkgDownloader.f346415a.l(this.f346424e, this.f346425f);
            }
            this.f346420a.i(this.f346422c);
        } else {
            this.f346420a.g("download success, but unpack failed.");
        }
        ThreadManager.runNetTask(new Runnable() { // from class: com.tencent.qqmini.minigame.gpkg.GamePkgDownloader$performDownloadGamePkg$downloadListener$1$onDownloadSucceed$2
            @Override // java.lang.Runnable
            public final void run() {
                GamePkgDownloader.f346415a.i(GamePkgDownloader$performDownloadGamePkg$downloadListener$1.this.f346422c, booleanRef.element);
            }
        });
    }
}
