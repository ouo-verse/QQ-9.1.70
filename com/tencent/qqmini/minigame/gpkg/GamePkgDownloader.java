package com.tencent.qqmini.minigame.gpkg;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.qqmini.minigame.gpkg.GamePkgDownloadHandler;
import com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u001a\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqmini/minigame/gpkg/GamePkgDownloader;", "", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "gameConfig", "", "ignoreProgress", "Lcom/tencent/qqmini/sdk/launcher/ipc/MiniCmdCallback;", "cmdCallback", "", "d", "Lcom/tencent/qqmini/minigame/gpkg/GamePkgDownloadHandler;", "handler", "e", "f", "Ljava/io/File;", "gamePkgDir", "j", "Lcom/tencent/qqmini/sdk/launcher/model/MiniGamePluginInfo;", "pluginInfo", "pluginSaveDir", "k", "", "downloadCost", h.F, "isUnpack", "i", "pkgDir", "", "url", "l", "newUrl", "g", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class GamePkgDownloader {

    /* renamed from: a, reason: collision with root package name */
    public static final GamePkgDownloader f346415a = new GamePkgDownloader();

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqmini/minigame/gpkg/GamePkgDownloader$a", "Lcom/tencent/qqmini/minigame/helper/d;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "errorMsg", "", "onDownloadFailed", "filePath", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult;", "result", "onDownloadSucceed", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class a extends com.tencent.qqmini.minigame.helper.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GamePkgDownloadHandler f346416a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f346417b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MiniGamePluginInfo f346418c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ File f346419d;

        a(GamePkgDownloadHandler gamePkgDownloadHandler, File file, MiniGamePluginInfo miniGamePluginInfo, File file2) {
            this.f346416a = gamePkgDownloadHandler;
            this.f346417b = file;
            this.f346418c = miniGamePluginInfo;
            this.f346419d = file2;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadFailed(int statusCode, @Nullable String errorMsg) {
            this.f346416a.j("download fail, statusCode=" + statusCode + ", errorMsg=" + errorMsg);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadSucceed(int statusCode, @Nullable String filePath, @Nullable DownloaderProxy.DownloadListener.DownloadResult result) {
            if (!this.f346417b.exists()) {
                this.f346416a.j("download file not exists, code=" + statusCode);
                return;
            }
            if (((int) this.f346417b.length()) != this.f346418c.packageSize) {
                this.f346416a.j("download file size not match. expectSize=" + this.f346418c.packageSize + ", saveSize=" + this.f346417b.length());
                return;
            }
            if (WxapkgUnpacker.unpackSync(this.f346417b.getAbsolutePath(), this.f346419d.getAbsolutePath())) {
                this.f346416a.k();
            } else {
                this.f346416a.j("unpack plugin failed.");
            }
        }
    }

    GamePkgDownloader() {
    }

    @JvmStatic
    public static final void d(@NotNull MiniAppInfo gameConfig, boolean ignoreProgress, @Nullable MiniCmdCallback cmdCallback) {
        Intrinsics.checkParameterIsNotNull(gameConfig, "gameConfig");
        GamePkgDownloadHandler.Companion companion = GamePkgDownloadHandler.INSTANCE;
        String str = gameConfig.appId;
        Intrinsics.checkExpressionValueIsNotNull(str, "gameConfig.appId");
        GamePkgDownloadHandler b16 = companion.b(str);
        if (cmdCallback != null) {
            b16.b(ignoreProgress, cmdCallback);
        }
        if (b16.d()) {
            QMLog.i("GamePkgDownloader", "downloadGamePkg: appId=" + gameConfig.appId + ", downloading, return.");
            return;
        }
        b16.f();
        GamePkgDownloader gamePkgDownloader = f346415a;
        gamePkgDownloader.e(gameConfig, b16);
        gamePkgDownloader.f(gameConfig, b16);
    }

    private final void e(MiniAppInfo gameConfig, GamePkgDownloadHandler handler) {
        File b16 = c.b(gameConfig);
        if (c.d(gameConfig) && !g(gameConfig.downloadUrl, b16)) {
            FileUtils.deleteFile(b16);
            QMLog.i("GamePkgDownloader", "downloadGamePkgIfNeed\uff1adelete gamePkg, verType=" + gameConfig.verType);
        }
        if (c.f(b16)) {
            QMLog.i("GamePkgDownloader", "downloadGamePkgIfNeed: " + gameConfig + " pkg exists.");
            handler.i(gameConfig);
            return;
        }
        j(b16, gameConfig, handler);
    }

    private final void f(MiniAppInfo gameConfig, GamePkgDownloadHandler handler) {
        MiniGamePluginInfo miniGamePluginInfo = gameConfig.miniGamePluginInfo;
        if (miniGamePluginInfo == null) {
            QMLog.i("GamePkgDownloader", "downloadGamePluginIfNeed: appId=" + gameConfig.appId + ", no plugin.");
            handler.k();
            return;
        }
        File c16 = c.c(miniGamePluginInfo);
        if (c.g(c16)) {
            QMLog.i("GamePkgDownloader", "downloadGamePluginIfNeed: appId=" + gameConfig.appId + ", plugin=" + miniGamePluginInfo.name + " exists.");
            handler.k();
            return;
        }
        k(miniGamePluginInfo, c16, handler);
    }

    private final boolean g(String newUrl, File gamePkgDir) {
        boolean z16;
        if (newUrl != null && newUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        try {
            return new File(gamePkgDir, MD5Utils.toMD5(newUrl)).exists();
        } catch (IOException e16) {
            QMLog.e("GamePkgDownloader", "isTheSameDebugPkg: failed, newUrl=" + newUrl, e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(MiniAppInfo gameConfig, long downloadCost) {
        MiniReportManager.reportEventType(gameConfig, 620, null, null, null, 0, "1", downloadCost, null);
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).reportTrafficFlow(1, "downloadMainPkg", "SDK#GpkgManager", gameConfig.downloadUrl, gameConfig.fileSize / 1024);
        MiniReportManager.reportEventType(gameConfig, 621, "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(MiniAppInfo gameConfig, boolean isUnpack) {
        MiniReportManager.reportEventType(gameConfig, 622, null, null, null, !isUnpack ? 1 : 0, "1", 0L, null);
        if (!isUnpack) {
            SDKMiniProgramLpReportDC04239.reportForSDK(gameConfig, "1", null, "page_view", "load_fail", "unpkg_fail", "");
            MiniAppReportManager2.reportPageView("2launch_fail", "unpkg_fail", null, gameConfig);
        }
    }

    private final void j(File gamePkgDir, MiniAppInfo gameConfig, GamePkgDownloadHandler handler) {
        boolean z16;
        boolean endsWith$default;
        QMLog.i("GamePkgDownloader", "performDownloadGamePkg: name=" + gameConfig.name + ", begin download.");
        FileUtils.deleteFile(gamePkgDir);
        long currentTimeMillis = System.currentTimeMillis();
        String str = gameConfig.downloadUrl;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            handler.g("downloadUrl get null.");
            return;
        }
        if (str != null) {
            String lowerCase = str.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
            String str2 = ".zip";
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".zip", false, 2, null);
            if (!endsWith$default) {
                str2 = GpkgManager.SUFFIX_TQAPKG;
            }
            MiniReportManager.reportEventType(gameConfig, 619, "1");
            String str3 = gamePkgDir + gameConfig.appId + util.base64_pad_url + gameConfig.versionId + str2;
            ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).download(str, null, str3, 60, new GamePkgDownloader$performDownloadGamePkg$downloadListener$1(handler, currentTimeMillis, gameConfig, str3, gamePkgDir, str));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final void k(MiniGamePluginInfo pluginInfo, File pluginSaveDir, GamePkgDownloadHandler handler) {
        QMLog.i("GamePkgDownloader", "performDownloadGamePlugin: plugin=" + pluginInfo.name + ", begin download.");
        FileUtils.deleteFile(pluginSaveDir);
        File file = new File(ApkgManager.RootPath.getGamePkgRoot(), "gapk_plugin_" + pluginInfo.f348088id + GpkgManager.SUFFIX_WXAPKG);
        ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).download(pluginInfo.url, null, file.getAbsolutePath(), 60, new a(handler, file, pluginInfo, pluginSaveDir));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(File pkgDir, String url) {
        try {
            new File(pkgDir, MD5Utils.toMD5(url)).createNewFile();
        } catch (IOException e16) {
            QMLog.e("GamePkgDownloader", "writeUrlMd5ToDebugPkg: failed, url=" + url, e16);
        }
    }
}
