package com.tencent.qq.minibox.api.metadream;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\bg\u0018\u00002\u00020\u0001:\u0001\u001cJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u0006H&J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H&J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\fH&J\b\u0010\u0015\u001a\u00020\fH&J\b\u0010\u0016\u001a\u00020\u0006H&J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\fH&J\b\u0010\u0019\u001a\u00020\fH&J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qq/minibox/api/metadream/IMiniBoxVADownloadTipsDelegate;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isWifi", "", VirtualAppProxy.KEY_GAME_ID, "", "showDownloadView", "Lcom/tencent/qq/minibox/api/metadream/IMiniBoxVADownloadTipsDelegate$a;", "clickListener", "setOperateClickListener", "updateWifiState", "", "state", "updateState", "resetDownloadProcess", "process", "", "downloadedSize", VirtualAppProxy.KEY_PKG_SIZE, "updateDownloadProcess", "getProcess", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "visibility", "updateVisibility", "getVisibility", "versionCode", "setGameVersionCode", "a", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IMiniBoxVADownloadTipsDelegate extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qq/minibox/api/metadream/IMiniBoxVADownloadTipsDelegate$a;", "", "", "onStartDownloadClick", "onStopClick", "onContinueClick", "onCancelClick", "onRestartClick", "onRetryClick", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface a {
        void onCancelClick();

        void onContinueClick();

        void onRestartClick();

        void onRetryClick();

        void onStartDownloadClick();

        void onStopClick();
    }

    int getProcess();

    int getVisibility();

    void onDestroy();

    void resetDownloadProcess();

    void setGameVersionCode(@Nullable String versionCode);

    void setOperateClickListener(@NotNull a clickListener);

    void showDownloadView(boolean isWifi, @Nullable String gameId);

    void updateDownloadProcess(int process);

    void updateDownloadProcess(int process, long downloadedSize, long pkgSize);

    void updateState(int state);

    void updateVisibility(int visibility);

    void updateWifiState(boolean isWifi);
}
