package com.tencent.qqmini.minigame.plugins;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.qqmini.minigame.GameJsService;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.gpkg.g;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.core.utils.URLUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.BrotliUtil;
import com.tencent.qqmini.sdk.utils.OpenDataDomainUtil;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/GameFileJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "", "timeCost", "", AdMetricTag.RESPONSE_CODE, "", "url", "", "reportDownloadWithCache", "Ljava/io/File;", "subPkgFile", "", "needDecompress", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "onLoadSubpackageSuccess", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "miniAppContext", "onCreate", "downloadWithCache", "loadSubpackageFile", "Lcom/tencent/qqmini/sdk/core/manager/MiniAppFileManager;", MosaicConstants$JsProperty.PROP_FILE_MANAGER, "Lcom/tencent/qqmini/sdk/core/manager/MiniAppFileManager;", "<init>", "()V", "Companion", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class GameFileJsPlugin extends BaseJsPlugin {
    private static final String TAG = "GameFileJsPlugin";
    private MiniAppFileManager fileManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0023 A[Catch: Exception -> 0x001d, TryCatch #0 {Exception -> 0x001d, blocks: (B:20:0x000b, B:6:0x0023, B:8:0x0029, B:13:0x0031, B:17:0x006a), top: B:19:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029 A[Catch: Exception -> 0x001d, TryCatch #0 {Exception -> 0x001d, blocks: (B:20:0x000b, B:6:0x0023, B:8:0x0029, B:13:0x0031, B:17:0x006a), top: B:19:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onLoadSubpackageSuccess(File subPkgFile, boolean needDecompress, RequestEvent req) {
        byte[] a16;
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z17 = true;
        if (needDecompress) {
            try {
                String absolutePath = subPkgFile.getAbsolutePath();
                Intrinsics.checkExpressionValueIsNotNull(absolutePath, "subPkgFile.absolutePath");
                a16 = BrotliUtil.a(absolutePath);
                if (a16 != null) {
                    z16 = true;
                    if (a16 == null) {
                        a16 = FileUtils.fileToBytes(subPkgFile);
                    }
                    if (a16 != null) {
                        if (a16.length != 0) {
                            z17 = false;
                        }
                        if (!z17) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("hasDecompressed", z16);
                            NativeBuffer.packNativeBuffer(req.jsService, a16, NativeBuffer.TYPE_BUFFER_NATIVE, "data", jSONObject);
                            QMLog.i(TAG, "loadSubpackageFile: read pkg file cost=" + (System.currentTimeMillis() - currentTimeMillis));
                            req.ok(jSONObject);
                            return;
                        }
                    }
                    req.fail("read subPkg file failed.");
                    QMLog.e(TAG, "read subPkg file failed, path=" + subPkgFile.getAbsolutePath());
                }
            } catch (Exception e16) {
                req.fail("loadSubpackageFile failed, system error.");
                QMLog.e(TAG, "onLoadSubpackageSuccess: exception.", e16);
                return;
            }
        } else {
            a16 = null;
        }
        z16 = false;
        if (a16 == null) {
        }
        if (a16 != null) {
        }
        req.fail("read subPkg file failed.");
        QMLog.e(TAG, "read subPkg file failed, path=" + subPkgFile.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportDownloadWithCache(long timeCost, int responseCode, String url) {
        String str;
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (this.mIsMiniGame) {
            str = "1";
        } else {
            str = "0";
        }
        MiniReportManager.reportEventType(miniAppInfo, 1044, null, null, null, responseCode, str, timeCost, url);
    }

    @JsEvent({"downloadWithCache"})
    @Nullable
    public final String downloadWithCache(@NotNull final RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.GameFileJsPlugin$downloadWithCache$doDownload$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z16;
                MiniAppFileManager miniAppFileManager;
                try {
                    JSONObject jSONObject = new JSONObject(req.jsonParams);
                    final long currentTimeMillis = System.currentTimeMillis();
                    final String optString = jSONObject.optString("url");
                    if (URLUtil.isValidUrl(optString)) {
                        z16 = ((BaseJsPlugin) GameFileJsPlugin.this).mIsMiniGame;
                        if (z16) {
                            IJsService iJsService = req.jsService;
                            if (iJsService != null) {
                                if (((GameJsService) iJsService).getContextType() == ScriptContextType.OPEN_DATA && !OpenDataDomainUtil.getInstance().isDomainValid(optString)) {
                                    req.fail("invalid url");
                                    return;
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type com.tencent.qqmini.minigame.GameJsService");
                            }
                        }
                        miniAppFileManager = GameFileJsPlugin.this.fileManager;
                        if (miniAppFileManager == null) {
                            Intrinsics.throwNpe();
                        }
                        final String tmpPathByUrl = miniAppFileManager.getTmpPathByUrl(optString);
                        ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).download(optString, null, tmpPathByUrl, 60, new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.minigame.plugins.GameFileJsPlugin$downloadWithCache$doDownload$1.1
                            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                            public void onDownloadFailed(int statusCode, @NotNull String errorMsg) {
                                Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                QMLog.i("GameFileJsPlugin", "doDownloadWithCache failed [timecost = " + currentTimeMillis2 + "ms], url:" + optString);
                                req.fail(errorMsg);
                                GameFileJsPlugin gameFileJsPlugin = GameFileJsPlugin.this;
                                String url = optString;
                                Intrinsics.checkExpressionValueIsNotNull(url, "url");
                                gameFileJsPlugin.reportDownloadWithCache(currentTimeMillis2, statusCode, url);
                            }

                            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                            public void onDownloadHeadersReceived(int statusCode, @NotNull Map<String, ? extends List<String>> headers) {
                                Intrinsics.checkParameterIsNotNull(headers, "headers");
                            }

                            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                            public void onDownloadSucceed(int statusCode, @NotNull String filePath, @NotNull DownloaderProxy.DownloadListener.DownloadResult result) {
                                MiniAppFileManager miniAppFileManager2;
                                Intrinsics.checkParameterIsNotNull(filePath, "filePath");
                                Intrinsics.checkParameterIsNotNull(result, "result");
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                QMLog.i("GameFileJsPlugin", "doDownloadWithCache success [timecost = " + currentTimeMillis2 + "ms] url:" + optString + ", save to file:" + tmpPathByUrl);
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, result.httpStatusCode);
                                    miniAppFileManager2 = GameFileJsPlugin.this.fileManager;
                                    if (miniAppFileManager2 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    jSONObject2.put("tempFilePath", miniAppFileManager2.getWxFilePath(tmpPathByUrl));
                                    req.ok(jSONObject2);
                                    GameFileJsPlugin gameFileJsPlugin = GameFileJsPlugin.this;
                                    String url = optString;
                                    Intrinsics.checkExpressionValueIsNotNull(url, "url");
                                    gameFileJsPlugin.reportDownloadWithCache(currentTimeMillis2, statusCode, url);
                                } catch (JSONException e16) {
                                    QMLog.i("GameFileJsPlugin", "doDownloadWithCache exception, url:" + optString, e16);
                                    req.fail("download exception");
                                }
                            }

                            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                            public void onDownloadProgress(float progress, long totalBytesWritten, long totalBytesExpectedToWrite) {
                            }
                        });
                        return;
                    }
                    req.fail("invalid url");
                } catch (JSONException unused) {
                    req.fail("downloadWithCache exception");
                }
            }
        });
        return "";
    }

    @JsEvent({"loadSubpackageFile"})
    public final void loadSubpackageFile(@NotNull final RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.GameFileJsPlugin$loadSubpackageFile$1

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqmini/minigame/plugins/GameFileJsPlugin$loadSubpackageFile$1$a", "Lcom/tencent/qqmini/minigame/gpkg/g;", "", "errorMsg", "", "onFail", "subPkgPath", "onSuccess", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
            /* loaded from: classes23.dex */
            public static final class a implements g {

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ String f346590b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f346591c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f346592d;

                a(String str, String str2, boolean z16) {
                    this.f346590b = str;
                    this.f346591c = str2;
                    this.f346592d = z16;
                }

                @Override // com.tencent.qqmini.minigame.gpkg.g
                public void onFail(@NotNull String errorMsg) {
                    Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
                    QMLog.e("GameFileJsPlugin", "loadSubPkg=" + this.f346590b + ", failed, error=" + errorMsg);
                    req.fail(errorMsg);
                }

                @Override // com.tencent.qqmini.minigame.gpkg.g
                public void onProgress(float f16, long j3) {
                    g.a.a(this, f16, j3);
                }

                @Override // com.tencent.qqmini.minigame.gpkg.g
                public void onSuccess(@NotNull String subPkgPath) {
                    Intrinsics.checkParameterIsNotNull(subPkgPath, "subPkgPath");
                    QMLog.i("GameFileJsPlugin", "loadSubpackageFile: load pkg cost=" + (System.currentTimeMillis() - currentTimeMillis));
                    File file = new File(subPkgPath, this.f346591c);
                    if (!file.exists()) {
                        req.fail("subPkg file not exists.");
                        QMLog.e("GameFileJsPlugin", "subPkg file not exists, subPkg=" + this.f346590b + ", path=" + this.f346591c);
                        return;
                    }
                    GameFileJsPlugin$loadSubpackageFile$1 gameFileJsPlugin$loadSubpackageFile$1 = GameFileJsPlugin$loadSubpackageFile$1.this;
                    GameFileJsPlugin.this.onLoadSubpackageSuccess(file, this.f346592d, req);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x008a  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                IMiniAppContext iMiniAppContext;
                MiniGamePkg miniGamePkg;
                boolean z16;
                iMiniAppContext = ((BaseJsPlugin) GameFileJsPlugin.this).mMiniAppContext;
                if (!(iMiniAppContext instanceof GameRuntime)) {
                    req.fail("get game context failed.");
                    return;
                }
                GameInfoManager gameInfoManager = ((GameRuntime) iMiniAppContext).getGameInfoManager();
                if (gameInfoManager != null) {
                    miniGamePkg = gameInfoManager.getMiniGamePkg();
                } else {
                    miniGamePkg = null;
                }
                if (miniGamePkg == null) {
                    req.fail("get game package failed.");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(req.jsonParams);
                    String optString = jSONObject.optString("name");
                    String optString2 = jSONObject.optString("path");
                    boolean z17 = false;
                    boolean optBoolean = jSONObject.optBoolean("needDecompress", false);
                    QMLog.d("GameFileJsPlugin", "loadSubpackageFile: subPkgName=" + optString + ", path=" + optString2 + ", needDecompress=" + optBoolean);
                    if (optString != null && optString.length() != 0) {
                        z16 = false;
                        if (!z16) {
                            if (optString2 == null || optString2.length() == 0) {
                                z17 = true;
                            }
                            if (!z17) {
                                miniGamePkg.loadGameSubPackage(optString, new a(optString, optString2, optBoolean));
                                return;
                            }
                        }
                        req.fail("params invalid.");
                    }
                    z16 = true;
                    if (!z16) {
                    }
                    req.fail("params invalid.");
                } catch (Exception e16) {
                    QMLog.e("GameFileJsPlugin", "loadSubpackageFile: error, params=" + req.jsonParams + ", exception=", e16);
                }
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(@Nullable IMiniAppContext miniAppContext) {
        super.onCreate(miniAppContext);
        if (this.mMiniAppInfo != null) {
            MiniAppFileManager miniAppFileManager = (MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class);
            this.fileManager = miniAppFileManager;
            if (miniAppFileManager == null) {
                Intrinsics.throwNpe();
            }
            miniAppFileManager.setStorageLimit(this.mMiniAppInfo.usrFileSizeLimit);
        }
    }
}
