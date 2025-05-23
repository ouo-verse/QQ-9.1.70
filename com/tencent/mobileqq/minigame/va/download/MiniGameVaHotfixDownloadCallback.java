package com.tencent.mobileqq.minigame.va.download;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/download/MiniGameVaHotfixDownloadCallback;", "Lcs3/b;", "", "totalSize", "", "onDownloadStart", "", "state", "onDownloadPaused", "onDownloadComplete", "errorCode", "onDownloadFail", "progress", "onDownloadProgress", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "appInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "getAppInfo", "()Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "setAppInfo", "(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)V", "<init>", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniGameVaHotfixDownloadCallback implements cs3.b {
    private static final String TAG = "MiniGameVaHotfixDownloadCallback";
    private MiniAppInfo appInfo;

    public final MiniAppInfo getAppInfo() {
        return this.appInfo;
    }

    @Override // cs3.b
    public void onDownloadComplete(int state) {
        QLog.d(TAG, 2, "onDownloadComplete state" + state);
        Bundle bundle = new Bundle();
        bundle.putInt(VirtualAppProxy.KEY_DOWNLOAD_STATUS, 3);
        AppLoaderFactory.g().getMiniServer().sendCmdToMiniProcess(1004, bundle, this.appInfo, null);
    }

    @Override // cs3.b
    public void onDownloadFail(int errorCode) {
        QLog.d(TAG, 2, "onDownloadFail errorCode" + errorCode);
        Bundle bundle = new Bundle();
        bundle.putInt(VirtualAppProxy.KEY_DOWNLOAD_STATUS, 4);
        bundle.putInt("errorCode", errorCode);
        AppLoaderFactory.g().getMiniServer().sendCmdToMiniProcess(1004, bundle, this.appInfo, null);
    }

    @Override // cs3.b
    public void onDownloadPaused(int state) {
        QLog.d(TAG, 2, "onDownloadPaused state" + state);
        Bundle bundle = new Bundle();
        bundle.putInt(VirtualAppProxy.KEY_DOWNLOAD_STATUS, 2);
        AppLoaderFactory.g().getMiniServer().sendCmdToMiniProcess(1004, bundle, this.appInfo, null);
    }

    @Override // cs3.b
    public void onDownloadProgress(int progress, long totalSize) {
        QLog.d(TAG, 2, "onDownloadProgress progress" + progress + " totalSize:" + totalSize);
        Bundle bundle = new Bundle();
        bundle.putInt(VirtualAppProxy.KEY_DOWNLOAD_STATUS, 1);
        bundle.putInt("progress", progress);
        bundle.putLong(VirtualAppProxy.KEY_PKG_SIZE, totalSize);
        AppLoaderFactory.g().getMiniServer().sendCmdToMiniProcess(1004, bundle, this.appInfo, null);
    }

    @Override // cs3.b
    public void onDownloadStart(long totalSize) {
        QLog.d(TAG, 2, "onDownloadStart totalSize" + totalSize);
        Bundle bundle = new Bundle();
        bundle.putInt(VirtualAppProxy.KEY_DOWNLOAD_STATUS, 1);
        bundle.putLong(VirtualAppProxy.KEY_PKG_SIZE, totalSize);
        AppLoaderFactory.g().getMiniServer().sendCmdToMiniProcess(1004, bundle, this.appInfo, null);
    }

    public final void setAppInfo(MiniAppInfo miniAppInfo) {
        this.appInfo = miniAppInfo;
    }
}
