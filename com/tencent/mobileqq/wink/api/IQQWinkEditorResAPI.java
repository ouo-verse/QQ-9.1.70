package com.tencent.mobileqq.wink.api;

import android.os.Bundle;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001:\u0002-.J\b\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\b\u0010\t\u001a\u00020\bH&J6\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\bH&J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0005H&J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0014H&J \u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0014H&J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0014H&J\b\u0010\u001d\u001a\u00020\u0002H&J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0005H&J\u0016\u0010!\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004H&J\u0012\u0010$\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"H&J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H&J\u0012\u0010*\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"H&J\u0018\u0010+\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H&J\b\u0010,\u001a\u00020\u0002H&\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IQQWinkEditorResAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "requestWangZheTabData", "", "", CoverDBCacheData.URLS, "downloadUrlAndSaveToSystem", "", "isDisableMagicStudioDownload", "url", "dirPath", WadlProxyConsts.PARAM_FILENAME, "Ljava/lang/ref/WeakReference;", "Li83/d;", "listener", "isImage", "downloadPagOrImage", "requestJson", "exportAiPaintVideoAsync", "Lcom/tencent/mobileqq/wink/api/IQQWinkEditorResAPI$AiPaintResponseListener;", "getExportAiPaintVideoResult", AppConstants.Key.KEY_QZONE_VIDEO_URL, "savePath", "Lcom/tencent/mobileqq/wink/api/IQQWinkEditorResAPI$DownloadAiPaintVideoListener;", "downloadListener", "downloadAiPaintVideo", "publishAiPaintVideo", "decodeAiPaintReq", "clearAiPaintVideoCacheFiles", "preloadAiPaintRes", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfoList", "requestProfileResourceMeta4QZone", "Landroid/os/Bundle;", "params", "fetchWinkNewAlbumRes", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "module", "", "callbackId", "asyncGetWinkNewAlbumRes", "fetchWinkNewAlbumTextRes", "asyncGetWinkNewAlbumTextRes", "preLoadWinkInferenceRes", "AiPaintResponseListener", "DownloadAiPaintVideoListener", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IQQWinkEditorResAPI extends QRouteApi {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IQQWinkEditorResAPI$AiPaintResponseListener;", "", "onResponse", "", "jsBridgeCallback", "", "responseStr", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public interface AiPaintResponseListener {
        void onResponse(@Nullable String jsBridgeCallback, @Nullable String responseStr);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IQQWinkEditorResAPI$DownloadAiPaintVideoListener;", "", "onDownloaded", "", "errorCode", "", "errorMsg", "", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public interface DownloadAiPaintVideoListener {
        void onDownloaded(int errorCode, @NotNull String errorMsg);
    }

    void asyncGetWinkNewAlbumRes(@NotNull QIPCModule module, int callbackId);

    void asyncGetWinkNewAlbumTextRes(@NotNull QIPCModule module, int callbackId);

    void clearAiPaintVideoCacheFiles();

    void decodeAiPaintReq(@NotNull String requestJson, @NotNull AiPaintResponseListener listener);

    void downloadAiPaintVideo(@NotNull String videoUrl, @NotNull String savePath, @NotNull DownloadAiPaintVideoListener downloadListener);

    void downloadPagOrImage(@NotNull String url, @NotNull String dirPath, @NotNull String fileName, @NotNull WeakReference<i83.d> listener, boolean isImage);

    void downloadUrlAndSaveToSystem(@NotNull List<String> urls);

    void exportAiPaintVideoAsync(@NotNull String requestJson);

    void fetchWinkNewAlbumRes(@Nullable Bundle params);

    void fetchWinkNewAlbumTextRes(@Nullable Bundle params);

    void getExportAiPaintVideoResult(@NotNull String requestJson, @NotNull AiPaintResponseListener listener);

    boolean isDisableMagicStudioDownload();

    void preLoadWinkInferenceRes();

    void preloadAiPaintRes(@NotNull String requestJson);

    void publishAiPaintVideo(@NotNull String requestJson, @NotNull AiPaintResponseListener listener);

    void requestProfileResourceMeta4QZone(@NotNull List<? extends LocalMediaInfo> localMediaInfoList);

    void requestWangZheTabData();
}
