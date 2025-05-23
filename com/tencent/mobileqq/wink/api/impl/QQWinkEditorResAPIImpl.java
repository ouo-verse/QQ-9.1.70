package com.tencent.mobileqq.wink.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager;
import com.tencent.mobileqq.wink.inference.WinkInferenceResManager;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J6\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J \u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0016\u0010!\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004H\u0016J\u0012\u0010$\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0016J\u0012\u0010*\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010+\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0016J\b\u0010,\u001a\u00020\u0002H\u0016\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/QQWinkEditorResAPIImpl;", "Lcom/tencent/mobileqq/wink/api/IQQWinkEditorResAPI;", "", "requestWangZheTabData", "", "", CoverDBCacheData.URLS, "downloadUrlAndSaveToSystem", "", "isDisableMagicStudioDownload", "url", "dirPath", WadlProxyConsts.PARAM_FILENAME, "Ljava/lang/ref/WeakReference;", "Li83/d;", "listener", "isImage", "downloadPagOrImage", "requestJson", "exportAiPaintVideoAsync", "Lcom/tencent/mobileqq/wink/api/IQQWinkEditorResAPI$AiPaintResponseListener;", "getExportAiPaintVideoResult", AppConstants.Key.KEY_QZONE_VIDEO_URL, "savePath", "Lcom/tencent/mobileqq/wink/api/IQQWinkEditorResAPI$DownloadAiPaintVideoListener;", "downloadListener", "downloadAiPaintVideo", "publishAiPaintVideo", "decodeAiPaintReq", "clearAiPaintVideoCacheFiles", "preloadAiPaintRes", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfoList", "requestProfileResourceMeta4QZone", "Landroid/os/Bundle;", "params", "fetchWinkNewAlbumRes", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "module", "", "callbackId", "asyncGetWinkNewAlbumRes", "fetchWinkNewAlbumTextRes", "asyncGetWinkNewAlbumTextRes", "preLoadWinkInferenceRes", "<init>", "()V", "Companion", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QQWinkEditorResAPIImpl implements IQQWinkEditorResAPI {

    @NotNull
    private static final String TAG = "QQWinkEditorResAPIImpl";

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/api/impl/QQWinkEditorResAPIImpl$b", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "netResp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "netReq", "", "l", "l1", "onUpdateProgeress", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<i83.d> f317971d;

        b(WeakReference<i83.d> weakReference) {
            this.f317971d = weakReference;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(@NotNull NetResp netResp) {
            Intrinsics.checkNotNullParameter(netResp, "netResp");
            if (netResp.mResult == 0) {
                i83.d dVar = this.f317971d.get();
                if (dVar != null) {
                    String str = netResp.mReq.mOutPath;
                    Intrinsics.checkNotNullExpressionValue(str, "netResp.mReq.mOutPath");
                    dVar.onResult(true, str);
                    return;
                }
                return;
            }
            i83.d dVar2 = this.f317971d.get();
            if (dVar2 != null) {
                dVar2.onResult(false, "");
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(@NotNull NetReq netReq, long l3, long l16) {
            Intrinsics.checkNotNullParameter(netReq, "netReq");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadPagOrImage$lambda$1(String dirPath, String fileName, boolean z16, WeakReference listener, String url) {
        Intrinsics.checkNotNullParameter(dirPath, "$dirPath");
        Intrinsics.checkNotNullParameter(fileName, "$fileName");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(url, "$url");
        try {
            File file = new File(dirPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = dirPath + fileName;
            File file2 = new File(str);
            if (file2.exists() && !z16) {
                i83.d dVar = (i83.d) listener.get();
                if (dVar != null) {
                    dVar.onResult(true, str);
                    return;
                }
                return;
            }
            if (file2.exists()) {
                file2.delete();
            }
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mReqUrl = url;
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mOutPath = str;
            httpNetReq.mContinuErrorLimit = 2;
            httpNetReq.mCallback = new b(listener);
            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(httpNetReq);
        } catch (Exception e16) {
            w53.b.d(TAG, "downloadPagOrImage", e16);
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void asyncGetWinkNewAlbumRes(@NotNull QIPCModule module, int callbackId) {
        Intrinsics.checkNotNullParameter(module, "module");
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void asyncGetWinkNewAlbumTextRes(@NotNull QIPCModule module, int callbackId) {
        Intrinsics.checkNotNullParameter(module, "module");
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void clearAiPaintVideoCacheFiles() {
        WinkAiPaintNativeExportManager.f322863a.F();
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void decodeAiPaintReq(@NotNull String requestJson, @NotNull IQQWinkEditorResAPI.AiPaintResponseListener listener) {
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        Intrinsics.checkNotNullParameter(listener, "listener");
        WinkAiPaintNativeExportManager.f322863a.J(requestJson, listener);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void downloadAiPaintVideo(@NotNull String videoUrl, @NotNull String savePath, @NotNull IQQWinkEditorResAPI.DownloadAiPaintVideoListener downloadListener) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        Intrinsics.checkNotNullParameter(downloadListener, "downloadListener");
        WinkAiPaintNativeExportManager.f322863a.M(videoUrl, savePath, downloadListener);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void downloadPagOrImage(@NotNull final String url, @NotNull final String dirPath, @NotNull final String fileName, @NotNull final WeakReference<i83.d> listener, final boolean isImage) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                QQWinkEditorResAPIImpl.downloadPagOrImage$lambda$1(dirPath, fileName, isImage, listener, url);
            }
        }, 64, null, false);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void downloadUrlAndSaveToSystem(@NotNull List<String> urls) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        MagicStudioDataSource.f323652a.D(urls);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void exportAiPaintVideoAsync(@NotNull String requestJson) {
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        WinkAiPaintNativeExportManager.f322863a.P(requestJson);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void getExportAiPaintVideoResult(@NotNull String requestJson, @NotNull IQQWinkEditorResAPI.AiPaintResponseListener listener) {
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        Intrinsics.checkNotNullParameter(listener, "listener");
        WinkAiPaintNativeExportManager.f322863a.V(requestJson, listener);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public boolean isDisableMagicStudioDownload() {
        return QzoneConfig.isNotSkipMagicStudioSafeCheck();
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void preLoadWinkInferenceRes() {
        WinkInferenceResManager.f322940a.I();
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void preloadAiPaintRes(@NotNull String requestJson) {
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        WinkAiPaintNativeExportManager.f322863a.a0(requestJson);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void publishAiPaintVideo(@NotNull String requestJson, @NotNull IQQWinkEditorResAPI.AiPaintResponseListener listener) {
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        Intrinsics.checkNotNullParameter(listener, "listener");
        WinkAiPaintNativeExportManager.f322863a.b0(requestJson, listener);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void requestProfileResourceMeta4QZone(@NotNull List<? extends LocalMediaInfo> localMediaInfoList) {
        Intrinsics.checkNotNullParameter(localMediaInfoList, "localMediaInfoList");
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intent intent = new Intent(applicationContext, (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass());
        intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 13);
        intent.putExtra(IWinkEditorResourceAPI.QZONE_A_KEY_LOCALMEDIAINFOS, (Serializable) localMediaInfoList);
        applicationContext.startService(intent);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void requestWangZheTabData() {
        sa3.b.f433595a.c();
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void fetchWinkNewAlbumRes(@Nullable Bundle params) {
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI
    public void fetchWinkNewAlbumTextRes(@Nullable Bundle params) {
    }
}
