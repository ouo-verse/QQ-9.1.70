package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.minigame.manager.FileDownloadManager;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import java.util.Map;

/* compiled from: P */
@ProxyService(proxy = DownloaderProxy.class)
/* loaded from: classes34.dex */
public class u extends DownloaderProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy
    public void abort(String str) {
        FileDownloadManager.abort(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy
    public boolean download(String str, Map<String, String> map, String str2, int i3, DownloaderProxy.DownloadListener downloadListener) {
        return FileDownloadManager.download(str, map, str2, i3, downloadListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy
    public void loadMiniGameSo(final String str, final DownloaderProxy.SoLoadListener soLoadListener) {
        if (str.equals("lamemp3")) {
            FileDownloadManager.getLameMp3SoDownloadPath(soLoadListener);
        } else {
            SoLoadManager.getInstance().download(str, new OnLoadListener() { // from class: com.tencent.qqmini.proxyimpl.t
                @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
                public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                    u.b(str, soLoadListener, i3, loadExtResult);
                }
            });
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy
    public boolean miniAppDownload(boolean z16, String str, Map<String, String> map, String str2, int i3, long j3, DownloaderProxy.DownloadListener downloadListener) {
        return FileDownloadManager.miniAppDownload(z16, str, map, str2, i3, j3, downloadListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy
    public void preConnectDownloadHost() {
        FileDownloadManager.preConnectDownloader();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, DownloaderProxy.SoLoadListener soLoadListener, int i3, LoadExtResult loadExtResult) {
        if (i3 == 0) {
            String soLoadPath = loadExtResult.getSoLoadPath(str);
            if (QLog.isDebugVersion()) {
                QLog.i("DownloaderProxyImpl", 4, "loadMiniGameSo: version=" + loadExtResult.getVer() + ";path=" + soLoadPath);
            }
            soLoadListener.onSuccess(soLoadPath);
            return;
        }
        soLoadListener.onFail(i3);
    }
}
