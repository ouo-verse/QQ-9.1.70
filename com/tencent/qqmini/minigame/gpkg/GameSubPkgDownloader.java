package com.tencent.qqmini.minigame.gpkg;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.qqmini.minigame.gpkg.d;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J0\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J2\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000eH\u0002J0\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010!\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u000e\u0010#\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqmini/minigame/gpkg/GameSubPkgDownloader;", "", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "appInfo", "Lcom/tencent/qqmini/sdk/launcher/model/SubPkgInfo;", "subPkgInfo", "", "subRoot", "Lcom/tencent/qqmini/sdk/launcher/ipc/MiniCmdCallback;", "cmdCallback", "", "b", "Lorg/json/JSONObject;", "gameJson", "", "f", "name2RootMap", "g", "", "subPkgInfoList", "i", "miniAppInfo", "Ljava/io/File;", "gamePkgDir", "Lcom/tencent/qqmini/minigame/gpkg/d;", "handler", h.F, "c", "", "fileSize", "downloadUrl", "", "hasUnpack", "j", "d", "e", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class GameSubPkgDownloader {

    /* renamed from: a, reason: collision with root package name */
    public static final GameSubPkgDownloader f346428a = new GameSubPkgDownloader();

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/qqmini/minigame/gpkg/GameSubPkgDownloader$a", "Lcom/tencent/qqmini/minigame/helper/d;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "errorMsg", "", "onDownloadFailed", "filePath", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult;", "result", "onDownloadSucceed", "", "progress", "", "totalBytesWritten", "totalBytesExpectedToWrite", "onDownloadProgress", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class a extends com.tencent.qqmini.minigame.helper.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f346429a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MiniAppInfo f346430b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ File f346431c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ File f346432d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f346433e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SubPkgInfo f346434f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ File f346435g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f346436h;

        a(d dVar, MiniAppInfo miniAppInfo, File file, File file2, String str, SubPkgInfo subPkgInfo, File file3, String str2) {
            this.f346429a = dVar;
            this.f346430b = miniAppInfo;
            this.f346431c = file;
            this.f346432d = file2;
            this.f346433e = str;
            this.f346434f = subPkgInfo;
            this.f346435g = file3;
            this.f346436h = str2;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadFailed(int statusCode, @Nullable String errorMsg) {
            this.f346429a.f("downloadFail, code=" + statusCode + ", msg=" + errorMsg);
            MiniReportManager.reportEventType(this.f346430b, 614, null, null, null, statusCode, "1", 0L, null);
        }

        @Override // com.tencent.qqmini.minigame.helper.d, com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadProgress(float progress, long totalBytesWritten, long totalBytesExpectedToWrite) {
            int i3;
            if (totalBytesExpectedToWrite == 0 && (i3 = this.f346434f.fileSize) > 0) {
                totalBytesExpectedToWrite = i3;
                if (totalBytesExpectedToWrite > totalBytesWritten) {
                    progress = (((float) totalBytesWritten) * 1.0f) / ((float) totalBytesExpectedToWrite);
                }
            }
            this.f346429a.g(progress, totalBytesExpectedToWrite);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadSucceed(int statusCode, @Nullable String filePath, @Nullable DownloaderProxy.DownloadListener.DownloadResult result) {
            boolean z16;
            try {
                z16 = WxapkgUnpacker.unpackSync(GpkgManager.getGpkgFilePath(this.f346431c.getAbsolutePath()), this.f346432d.getAbsolutePath(), this.f346433e, true);
            } catch (IOException e16) {
                QMLog.e("GameSubPkgDownloader", "onSubPkgDownloadSuccess: unpack failed.", e16);
                z16 = false;
            }
            if (z16) {
                d dVar = this.f346429a;
                String str = this.f346434f.subPkgName;
                Intrinsics.checkExpressionValueIsNotNull(str, "subPkgInfo.subPkgName");
                String absolutePath = this.f346435g.getAbsolutePath();
                Intrinsics.checkExpressionValueIsNotNull(absolutePath, "subPkgDir.absolutePath");
                dVar.h(str, absolutePath);
            } else {
                this.f346429a.f("download success, but unpack failed.");
            }
            GameSubPkgDownloader.f346428a.j(this.f346430b, this.f346434f.fileSize, this.f346436h, z16);
        }
    }

    GameSubPkgDownloader() {
    }

    @JvmStatic
    public static final void b(@NotNull MiniAppInfo appInfo, @NotNull SubPkgInfo subPkgInfo, @NotNull String subRoot, @Nullable MiniCmdCallback cmdCallback) {
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        Intrinsics.checkParameterIsNotNull(subPkgInfo, "subPkgInfo");
        Intrinsics.checkParameterIsNotNull(subRoot, "subRoot");
        d.Companion companion = d.INSTANCE;
        GameSubPkgDownloader gameSubPkgDownloader = f346428a;
        d b16 = companion.b(gameSubPkgDownloader.c(appInfo, subPkgInfo));
        if (cmdCallback != null) {
            b16.b(cmdCallback);
        }
        if (b16.c()) {
            QMLog.i("GameSubPkgDownloader", "downloadSubPkg: " + subPkgInfo.subPkgName + " is downloading, return.");
            return;
        }
        b16.d();
        File b17 = c.b(appInfo);
        File file = new File(b17, subRoot);
        if (c.h(file)) {
            QMLog.i("GameSubPkgDownloader", "downloadSubPkg: appId=" + appInfo.appId + ", name=" + subPkgInfo.subPkgName + " valid, do need download.");
            String str = subPkgInfo.subPkgName;
            Intrinsics.checkExpressionValueIsNotNull(str, "subPkgInfo.subPkgName");
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "subPkgDir.absolutePath");
            b16.h(str, absolutePath);
            return;
        }
        QMLog.i("GameSubPkgDownloader", "downloadSubPkg: begin download subPkg=" + subPkgInfo.subPkgName + ", subRoot=" + subRoot);
        gameSubPkgDownloader.h(appInfo, b17, subRoot, subPkgInfo, b16);
    }

    private final String c(MiniAppInfo appInfo, SubPkgInfo subPkgInfo) {
        return appInfo.appId + util.base64_pad_url + subPkgInfo.getPureSubPkgName();
    }

    private final String d(String downloadUrl) {
        boolean endsWith$default;
        if (downloadUrl != null) {
            String lowerCase = downloadUrl.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".zip", false, 2, null);
            if (endsWith$default) {
                return ".zip";
            }
            return GpkgManager.SUFFIX_TQAPKG;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final Map<String, String> f(JSONObject gameJson) {
        boolean z16;
        HashMap hashMap = new HashMap();
        JSONArray optJSONArray = gameJson.optJSONArray("subpackages");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("name");
                    String optString2 = optJSONObject.optString("root");
                    boolean z17 = true;
                    if (optString != null && optString.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        if (optString2 != null && optString2.length() != 0) {
                            z17 = false;
                        }
                        if (!z17) {
                            hashMap.put(optString, optString2);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    private final Map<String, String> g(Map<String, String> name2RootMap, JSONObject gameJson) {
        boolean z16;
        HashMap hashMap = new HashMap();
        JSONArray optJSONArray = gameJson.optJSONArray("parallelPreloadSubpackages");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("name");
                    boolean z17 = true;
                    if (optString != null && optString.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        String str = name2RootMap.get(optString);
                        if (str != null && str.length() != 0) {
                            z17 = false;
                        }
                        if (z17) {
                            QMLog.e("GameSubPkgDownloader", "parseParallelPreloadSubpackages: cannot find root, name=" + optString);
                        } else {
                            hashMap.put(optString, str);
                        }
                    }
                }
            }
            return hashMap;
        }
        QMLog.i("GameSubPkgDownloader", "parallelPreloadSubpackages: no config.");
        return hashMap;
    }

    private final void h(MiniAppInfo miniAppInfo, File gamePkgDir, String subRoot, SubPkgInfo subPkgInfo, d handler) {
        boolean z16;
        File file = new File(gamePkgDir, subRoot);
        FileUtils.deleteFile(file);
        String str = subPkgInfo.downloadUrl;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            handler.f("get downloadUrl null.");
            return;
        }
        File file2 = new File(ApkgManager.getPkgRoot(miniAppInfo), miniAppInfo.appId + util.base64_pad_url + miniAppInfo.versionId + util.base64_pad_url + System.nanoTime() + d(str));
        ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).download(str, null, file2.getAbsolutePath(), 60, new a(handler, miniAppInfo, file2, gamePkgDir, subRoot, subPkgInfo, file, str));
        MiniReportManager.reportEventType(miniAppInfo, 613, "1");
    }

    private final void i(MiniAppInfo appInfo, List<? extends SubPkgInfo> subPkgInfoList, Map<String, String> name2RootMap) {
        HashMap hashMap = new HashMap(subPkgInfoList.size());
        for (SubPkgInfo subPkgInfo : subPkgInfoList) {
            String pureSubPkgName = subPkgInfo.getPureSubPkgName();
            Intrinsics.checkExpressionValueIsNotNull(pureSubPkgName, "subPkgInfo.pureSubPkgName");
            hashMap.put(pureSubPkgName, subPkgInfo);
        }
        for (Map.Entry<String, String> entry : name2RootMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            SubPkgInfo subPkgInfo2 = (SubPkgInfo) hashMap.get(key);
            if (subPkgInfo2 != null) {
                b(appInfo, subPkgInfo2, value, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(final MiniAppInfo appInfo, final int fileSize, final String downloadUrl, final boolean hasUnpack) {
        ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.gpkg.GameSubPkgDownloader$reportAfterDownloadSuccess$1
            @Override // java.lang.Runnable
            public final void run() {
                MiniReportManager.reportEventType(MiniAppInfo.this, 614, "1");
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).reportTrafficFlow(1, "downloadSubPkg", "SDK#GpkgManager", downloadUrl, fileSize / 1024);
                MiniReportManager.reportEventType(MiniAppInfo.this, 616, null, null, null, !hasUnpack ? 1 : 0, "1", 0L, null);
            }
        });
    }

    public final void e(@NotNull MiniAppInfo appInfo) {
        String str;
        boolean z16;
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        List<SubPkgInfo> list = appInfo.subpkgs;
        if (list != null && !list.isEmpty()) {
            try {
                str = FileUtils.readFileToString(new File(c.b(appInfo), MiniGamePkg.NAME_CONFIG_JSON));
            } catch (IOException e16) {
                QMLog.e("GameSubPkgDownloader", "parallelPreloadSubpackages: read game.json failed.", e16);
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Map<String, String> f16 = f(jSONObject);
                if (f16.isEmpty()) {
                    QMLog.i("GameSubPkgDownloader", "parallelPreloadSubpackages: cannot find subPackages.");
                    return;
                } else {
                    i(appInfo, list, g(f16, jSONObject));
                    return;
                }
            } catch (JSONException e17) {
                QMLog.e("GameSubPkgDownloader", "parallelPreloadSubpackages: parse subpackages failed, json=" + str + '.', e17);
                return;
            }
        }
        QMLog.i("GameSubPkgDownloader", "parallelPreloadSubpackages: subPkgInfoList empty.");
    }
}
