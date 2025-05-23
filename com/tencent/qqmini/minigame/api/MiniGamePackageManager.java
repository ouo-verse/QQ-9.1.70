package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.GamePluginPackage;
import com.tencent.qqmini.minigame.action.GetGameInfoManager;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.gpkg.a;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqmini/minigame/api/MiniGamePackageManager;", "", "()V", "TAG", "", "createGamePackage", "Lcom/tencent/qqmini/minigame/api/MiniGamePackage;", "miniAppContext", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class MiniGamePackageManager {
    public static final MiniGamePackageManager INSTANCE = new MiniGamePackageManager();
    private static final String TAG = "MiniGamePackageManager";

    MiniGamePackageManager() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x01aa, code lost:
    
        if (r1 != null) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0106  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MiniGamePackage createGamePackage(@NotNull IMiniAppContext miniAppContext) {
        GamePackage.Orientation orientation;
        GamePackage.Environment environment;
        boolean z16;
        Map mapOf;
        String account;
        boolean z17;
        LogProxy logProxy;
        int i3;
        DebugInfo debugInfo;
        MiniGamePluginInfo miniGamePluginInfo;
        List<? extends GamePluginPackage> emptyList;
        Intrinsics.checkParameterIsNotNull(miniAppContext, "miniAppContext");
        GameInfoManager obtain = GetGameInfoManager.obtain(miniAppContext);
        if (obtain == null) {
            Intrinsics.throwNpe();
        }
        MiniAppInfo miniAppInfo = obtain.getMiniAppInfo();
        if (miniAppInfo == null) {
            Intrinsics.throwNpe();
        }
        MiniGamePkg miniGamePkg = obtain.getMiniGamePkg();
        if (miniGamePkg == null) {
            Intrinsics.throwNpe();
        }
        a aVar = miniGamePkg.mGameConfigJson;
        Intrinsics.checkExpressionValueIsNotNull(aVar, "pkg.mGameConfigJson");
        if (aVar.a()) {
            orientation = GamePackage.Orientation.LANDSCAPE;
        } else {
            orientation = GamePackage.Orientation.PORTRAIT;
        }
        GamePackage.Orientation orientation2 = orientation;
        String verTypeStr = miniAppInfo.getVerTypeStr();
        if (verTypeStr != null) {
            int hashCode = verTypeStr.hashCode();
            if (hashCode != 110628630) {
                if (hashCode == 1559690845 && verTypeStr.equals("develop")) {
                    environment = GamePackage.Environment.DEVELOP;
                }
            } else if (verTypeStr.equals("trial")) {
                environment = GamePackage.Environment.TRIAL;
            }
            GamePackage.Environment environment2 = environment;
            MiniAppProxy proxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            HashMap hashMap = new HashMap();
            z16 = false;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("appId", miniAppInfo.appId), TuplesKt.to("icon", miniAppInfo.iconUrl));
            hashMap.put("accountInfo", mapOf);
            MiniAppEnv g16 = MiniAppEnv.g();
            Intrinsics.checkExpressionValueIsNotNull(g16, "MiniAppEnv.g()");
            String simpleDeviceInfo = QUAUtil.getSimpleDeviceInfo(g16.getContext());
            Intrinsics.checkExpressionValueIsNotNull(simpleDeviceInfo, "QUAUtil.getSimpleDeviceI\u2026o(MiniAppEnv.g().context)");
            hashMap.put("deviceinfo", simpleDeviceInfo);
            String str = miniAppInfo.version;
            Intrinsics.checkExpressionValueIsNotNull(str, "info.version");
            hashMap.put("miniapp_version", str);
            String qua = QUAUtil.getQUA();
            Intrinsics.checkExpressionValueIsNotNull(qua, "QUAUtil.getQUA()");
            hashMap.put("sdk_version", qua);
            Intrinsics.checkExpressionValueIsNotNull(proxy, "proxy");
            String appName = proxy.getAppName();
            Intrinsics.checkExpressionValueIsNotNull(appName, "proxy.appName");
            hashMap.put("source_app", appName);
            LoginManager loginManager = LoginManager.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(loginManager, "LoginManager.getInstance()");
            account = loginManager.getAccount();
            if (account == null) {
                account = "";
            }
            if (account.length() != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                QMLog.e(TAG, "get account empty.");
            }
            hashMap.put("miniapp_verType", Integer.valueOf(miniAppInfo.verType));
            logProxy = (LogProxy) ProxyManager.get(LogProxy.class);
            if (logProxy == null) {
                i3 = logProxy.getUinReportLogLevel();
            } else {
                i3 = 3;
            }
            hashMap.put("qqLogLevel", Integer.valueOf(i3));
            hashMap.put("source_uin", account);
            String appVersion = proxy.getAppVersion();
            Intrinsics.checkExpressionValueIsNotNull(appVersion, "proxy.appVersion");
            hashMap.put("source_version", appVersion);
            String loginType = QUAUtil.getLoginType();
            Intrinsics.checkExpressionValueIsNotNull(loginType, "QUAUtil.getLoginType()");
            hashMap.put("source_uin_platform", loginType);
            debugInfo = miniAppInfo.debugInfo;
            if (debugInfo != null && debugInfo.valid() && miniAppInfo.launchParam.scene == 1011) {
                z16 = true;
            }
            hashMap.put("enableFrameProfile", Boolean.valueOf(z16));
            miniGamePluginInfo = miniAppInfo.miniGamePluginInfo;
            if (miniGamePluginInfo != null) {
                GamePluginPackage.Companion companion = GamePluginPackage.INSTANCE;
                String str2 = miniGamePluginInfo.name;
                Intrinsics.checkExpressionValueIsNotNull(str2, "it.name");
                String str3 = miniGamePluginInfo.f348088id;
                Intrinsics.checkExpressionValueIsNotNull(str3, "it.id");
                String str4 = miniGamePluginInfo.version;
                Intrinsics.checkExpressionValueIsNotNull(str4, "it.version");
                emptyList = CollectionsKt__CollectionsJVMKt.listOf(companion.create(str2, str3, str4, new File(ApkgManager.getGpkgPluginFolderPath(miniGamePluginInfo))));
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            List<? extends GamePluginPackage> list = emptyList;
            GamePackage.Companion companion2 = GamePackage.INSTANCE;
            String str5 = miniAppInfo.appId;
            Intrinsics.checkExpressionValueIsNotNull(str5, "info.appId");
            String str6 = miniAppInfo.name;
            Intrinsics.checkExpressionValueIsNotNull(str6, "info.name");
            File file = new File(ApkgManager.getApkgFolderPath(miniAppInfo));
            String str7 = miniGamePkg.mConfigStr;
            Intrinsics.checkExpressionValueIsNotNull(str7, "pkg.mConfigStr");
            String str8 = miniAppInfo.version;
            Intrinsics.checkExpressionValueIsNotNull(str8, "info.version");
            return new MiniGamePackage(companion2.create(str5, str6, file, str7, orientation2, str8, environment2, hashMap, list, new MiniGamePackageManager$createGamePackage$gamePackage$1(miniGamePkg)), miniGamePkg.mGameConfigJson.f346446b);
        }
        environment = GamePackage.Environment.RELEASE;
        GamePackage.Environment environment22 = environment;
        MiniAppProxy proxy2 = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        HashMap hashMap2 = new HashMap();
        z16 = false;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("appId", miniAppInfo.appId), TuplesKt.to("icon", miniAppInfo.iconUrl));
        hashMap2.put("accountInfo", mapOf);
        MiniAppEnv g162 = MiniAppEnv.g();
        Intrinsics.checkExpressionValueIsNotNull(g162, "MiniAppEnv.g()");
        String simpleDeviceInfo2 = QUAUtil.getSimpleDeviceInfo(g162.getContext());
        Intrinsics.checkExpressionValueIsNotNull(simpleDeviceInfo2, "QUAUtil.getSimpleDeviceI\u2026o(MiniAppEnv.g().context)");
        hashMap2.put("deviceinfo", simpleDeviceInfo2);
        String str9 = miniAppInfo.version;
        Intrinsics.checkExpressionValueIsNotNull(str9, "info.version");
        hashMap2.put("miniapp_version", str9);
        String qua2 = QUAUtil.getQUA();
        Intrinsics.checkExpressionValueIsNotNull(qua2, "QUAUtil.getQUA()");
        hashMap2.put("sdk_version", qua2);
        Intrinsics.checkExpressionValueIsNotNull(proxy2, "proxy");
        String appName2 = proxy2.getAppName();
        Intrinsics.checkExpressionValueIsNotNull(appName2, "proxy.appName");
        hashMap2.put("source_app", appName2);
        LoginManager loginManager2 = LoginManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(loginManager2, "LoginManager.getInstance()");
        account = loginManager2.getAccount();
        if (account == null) {
        }
        if (account.length() != 0) {
        }
        if (z17) {
        }
        hashMap2.put("miniapp_verType", Integer.valueOf(miniAppInfo.verType));
        logProxy = (LogProxy) ProxyManager.get(LogProxy.class);
        if (logProxy == null) {
        }
        hashMap2.put("qqLogLevel", Integer.valueOf(i3));
        hashMap2.put("source_uin", account);
        String appVersion2 = proxy2.getAppVersion();
        Intrinsics.checkExpressionValueIsNotNull(appVersion2, "proxy.appVersion");
        hashMap2.put("source_version", appVersion2);
        String loginType2 = QUAUtil.getLoginType();
        Intrinsics.checkExpressionValueIsNotNull(loginType2, "QUAUtil.getLoginType()");
        hashMap2.put("source_uin_platform", loginType2);
        debugInfo = miniAppInfo.debugInfo;
        if (debugInfo != null) {
            z16 = true;
        }
        hashMap2.put("enableFrameProfile", Boolean.valueOf(z16));
        miniGamePluginInfo = miniAppInfo.miniGamePluginInfo;
        if (miniGamePluginInfo != null) {
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        List<? extends GamePluginPackage> list2 = emptyList;
        GamePackage.Companion companion22 = GamePackage.INSTANCE;
        String str52 = miniAppInfo.appId;
        Intrinsics.checkExpressionValueIsNotNull(str52, "info.appId");
        String str62 = miniAppInfo.name;
        Intrinsics.checkExpressionValueIsNotNull(str62, "info.name");
        File file2 = new File(ApkgManager.getApkgFolderPath(miniAppInfo));
        String str72 = miniGamePkg.mConfigStr;
        Intrinsics.checkExpressionValueIsNotNull(str72, "pkg.mConfigStr");
        String str82 = miniAppInfo.version;
        Intrinsics.checkExpressionValueIsNotNull(str82, "info.version");
        return new MiniGamePackage(companion22.create(str52, str62, file2, str72, orientation2, str82, environment22, hashMap2, list2, new MiniGamePackageManager$createGamePackage$gamePackage$1(miniGamePkg)), miniGamePkg.mGameConfigJson.f346446b);
    }
}
