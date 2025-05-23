package com.tencent.qqmini.sdk.launcher.utils;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.launcher.model.StartupReportData;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0014\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001dH\u0007J\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020!H\u0003J\u0010\u0010+\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J(\u0010,\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020$H\u0007J\u0010\u00100\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\"\u00101\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u001b2\b\b\u0002\u00103\u001a\u00020\u001bH\u0007J*\u00101\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u001b2\b\b\u0002\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020$H\u0007J\u0012\u00105\u001a\u00020'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J*\u00106\u001a\u00020'2\u0006\u0010\"\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004H\u0007J\u0010\u00109\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J*\u0010:\u001a\u00020'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010-\u001a\u00020$2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004H\u0007J\"\u0010=\u001a\u00020'2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020$H\u0002J\u0018\u0010>\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020$H\u0007J(\u0010@\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020$2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u001bH\u0007J\u0018\u0010D\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010E\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u001a\u0010F\u001a\u00020'2\u0006\u0010\"\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u0018\u0010G\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006H"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/utils/StartupReportUtil;", "", "()V", "EVENT_AD_SHOW", "", "EVENT_APKG_DOWNLOAD", "EVENT_APP_INFO", "EVENT_BEGIN", "EVENT_CAN_PLAY", "EVENT_CREATED_ROLE", "EVENT_DELETE", "EVENT_ENGINE_LOAD", "EVENT_INIT_ENV", "EVENT_LOADING_BEGIN", "EVENT_PRIVACY_AGREE", "EVENT_PRIVACY_HAS_AGREED", "EVENT_PRIVACY_REJECT", "EVENT_PRIVACY_SHOW", "EVENT_REPORT_CUSTOM_EVENT", "EVENT_SHOW", "EVENT_START_UI", "EVENT_UNITY_SHOW", "KEY_STARTUP_FLAG", "KEY_STARTUP_ID", "generateId", "appId", "getGameEngineFlag", "", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "getModeFromReportData", "reportData", "getReportData", "Lcom/tencent/qqmini/sdk/launcher/model/StartupReportData;", AdMetricTag.EVENT_NAME, "relativeTime", "", "getViaFromReportData", "markPaused", "", "appInfo", "report", "param", "reportAdShow", "reportApkgDownload", "costTime", "state", "size", "reportAppInfo", "reportBegin", "scene", "appInfoFlag", "eventTime", "reportCanPlay", "reportCustomEvent", "eventId", "data", "reportDelete", "reportEngineLoad", "jsLibVersion", "tritonVersion", "reportEvent", "reportInitEnv", QCircleWeakNetReporter.KEY_COST, "reportLoading", "isPreload", "", "flag", "reportShow", "reportStartUI", "reportStartUpEvent", "reportUnityShow", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class StartupReportUtil {

    @NotNull
    public static final String EVENT_AD_SHOW = "minigame_startup_ad_show";

    @NotNull
    public static final String EVENT_APKG_DOWNLOAD = "minigame_startup_apkg_download";

    @NotNull
    public static final String EVENT_APP_INFO = "minigame_startup_appinfo";

    @NotNull
    public static final String EVENT_BEGIN = "minigame_startup_begin";

    @NotNull
    public static final String EVENT_CAN_PLAY = "minigame_startup_canplay";

    @NotNull
    public static final String EVENT_CREATED_ROLE = "minigame_startup_created_role";

    @NotNull
    public static final String EVENT_DELETE = "minigame_startup_delete";

    @NotNull
    public static final String EVENT_ENGINE_LOAD = "minigame_startup_engine_load";

    @NotNull
    public static final String EVENT_INIT_ENV = "minigame_startup_init_env";

    @NotNull
    public static final String EVENT_LOADING_BEGIN = "minigame_startup_loading_begin";

    @NotNull
    public static final String EVENT_PRIVACY_AGREE = "minigame_startup_privacy_agree";

    @NotNull
    public static final String EVENT_PRIVACY_HAS_AGREED = "minigame_startup_privacy_has_agreed";

    @NotNull
    public static final String EVENT_PRIVACY_REJECT = "minigame_startup_privacy_reject";

    @NotNull
    public static final String EVENT_PRIVACY_SHOW = "minigame_startup_privacy_show";

    @NotNull
    public static final String EVENT_REPORT_CUSTOM_EVENT = "minigame_startup_report_event";

    @NotNull
    public static final String EVENT_SHOW = "minigame_startup_show";

    @NotNull
    public static final String EVENT_START_UI = "minigame_startup_startui";

    @NotNull
    public static final String EVENT_UNITY_SHOW = "minigame_startup_unity_show";
    public static final StartupReportUtil INSTANCE = new StartupReportUtil();

    @NotNull
    public static final String KEY_STARTUP_FLAG = "key_minigame_startup_flag";

    @NotNull
    public static final String KEY_STARTUP_ID = "key_minigame_startup_id";

    StartupReportUtil() {
    }

    @JvmStatic
    @NotNull
    public static final String generateId(@NotNull String appId) {
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        return System.currentTimeMillis() + util.base64_pad_url + ((int) (Math.random() * 1000)) + util.base64_pad_url + appId;
    }

    private final int getGameEngineFlag(MiniAppInfo miniAppInfo) {
        MiniGamePluginInfo miniGamePluginInfo = miniAppInfo.miniGamePluginInfo;
        if (miniGamePluginInfo != null && Intrinsics.areEqual("UnityPlugin", miniGamePluginInfo.name)) {
            return 5;
        }
        return 0;
    }

    private final String getModeFromReportData(String reportData) {
        boolean z16;
        List<String> groupValues;
        if (reportData != null && reportData.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        try {
            MatchResult find$default = Regex.find$default(new Regex("mode=([^&]*)"), reportData, 0, 2, null);
            if (find$default == null || (groupValues = find$default.getGroupValues()) == null) {
                return null;
            }
            return groupValues.get(1);
        } catch (Exception unused) {
            return null;
        }
    }

    private final StartupReportData getReportData(StartupReportData reportData, String eventName, long relativeTime, MiniAppInfo miniAppInfo) {
        boolean z16;
        StartupReportData copy = StartupReportData.INSTANCE.copy(reportData);
        copy.setEventName(eventName);
        copy.setRelativeTime(relativeTime);
        copy.setEventTime(System.currentTimeMillis());
        copy.setVersionType(miniAppInfo.verType);
        String str = miniAppInfo.versionId;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        copy.setVersionId(str);
        String viaFromReportData = getViaFromReportData(miniAppInfo.launchParam.reportData);
        if (viaFromReportData != null && viaFromReportData.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            String str3 = miniAppInfo.via;
            if (str3 == null) {
                str3 = "";
            }
            copy.setVia(str3);
        } else {
            copy.setVia(viaFromReportData);
        }
        String modeFromReportData = getModeFromReportData(miniAppInfo.launchParam.reportData);
        if (modeFromReportData == null) {
            modeFromReportData = "";
        }
        copy.setMode(modeFromReportData);
        String str4 = miniAppInfo.launchParam.reportData;
        if (str4 != null) {
            str2 = str4;
        }
        copy.setExtReportData(str2);
        return copy;
    }

    private final String getViaFromReportData(String reportData) {
        boolean z16;
        List<String> groupValues;
        if (reportData != null && reportData.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        try {
            MatchResult find$default = Regex.find$default(new Regex("via=([^&]*)"), reportData, 0, 2, null);
            if (find$default == null || (groupValues = find$default.getGroupValues()) == null) {
                return null;
            }
            return groupValues.get(1);
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    public static final void markPaused(@Nullable MiniAppInfo appInfo) {
        LaunchParam launchParam;
        StartupReportData startupReportData;
        if (appInfo != null && (launchParam = appInfo.launchParam) != null && (startupReportData = launchParam.startupReportData) != null) {
            startupReportData.setHasPaused(true);
        }
    }

    @JvmStatic
    private static final void report(StartupReportData param) {
        boolean z16;
        QQCustomizedProxy qQCustomizedProxy;
        if (param.getEventTime() == 0) {
            param.setEventTime(System.currentTimeMillis());
        }
        if (param.getStartupId().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        AppLoaderFactory g16 = AppLoaderFactory.g();
        Intrinsics.checkExpressionValueIsNotNull(g16, "AppLoaderFactory.g()");
        IProxyManager proxyManager = g16.getProxyManager();
        if (proxyManager != null && (qQCustomizedProxy = (QQCustomizedProxy) proxyManager.get(QQCustomizedProxy.class)) != null) {
            qQCustomizedProxy.reportStartup(param);
        }
    }

    @JvmStatic
    public static final void reportAdShow(@NotNull MiniAppInfo miniAppInfo) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        StartupReportData startupReportData = miniAppInfo.launchParam.startupReportData;
        if (startupReportData != null) {
            startupReportData.setAdFlag(1);
        }
        reportEvent$default(INSTANCE, EVENT_AD_SHOW, miniAppInfo, 0L, 4, null);
    }

    @JvmStatic
    public static final void reportApkgDownload(@NotNull MiniAppInfo miniAppInfo, long costTime, int state, long size) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        StartupReportData startupReportData = miniAppInfo.launchParam.startupReportData;
        if (startupReportData != null) {
            startupReportData.setApkgSize(size);
            startupReportData.setApkgState(state);
        }
        INSTANCE.reportEvent(EVENT_APKG_DOWNLOAD, miniAppInfo, costTime);
    }

    @JvmStatic
    public static final void reportAppInfo(@NotNull MiniAppInfo miniAppInfo) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        StartupReportData startupReportData = miniAppInfo.launchParam.startupReportData;
        if (startupReportData != null) {
            startupReportData.setGameEngineFlag(INSTANCE.getGameEngineFlag(miniAppInfo));
            startupReportData.setAppType(miniAppInfo.isEngineTypeMiniGame() ? 1 : 0);
        }
        reportEvent$default(INSTANCE, EVENT_APP_INFO, miniAppInfo, 0L, 4, null);
    }

    @JvmStatic
    @NotNull
    public static final StartupReportData reportBegin(@NotNull String appId, int scene, int appInfoFlag) {
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        return reportBegin(appId, scene, appInfoFlag, System.currentTimeMillis());
    }

    public static /* synthetic */ StartupReportData reportBegin$default(String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        return reportBegin(str, i3, i16);
    }

    @JvmStatic
    public static final void reportCanPlay(@Nullable MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        reportEvent$default(INSTANCE, EVENT_CAN_PLAY, miniAppInfo, 0L, 4, null);
    }

    @JvmStatic
    public static final void reportCustomEvent(@NotNull String eventName, @Nullable MiniAppInfo miniAppInfo, @NotNull String eventId, @NotNull String data) {
        StartupReportData startupReportData;
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        Intrinsics.checkParameterIsNotNull(eventId, "eventId");
        Intrinsics.checkParameterIsNotNull(data, "data");
        if (miniAppInfo != null && (startupReportData = miniAppInfo.launchParam.startupReportData) != null) {
            StartupReportData reportData = INSTANCE.getReportData(startupReportData, eventName, 0L, miniAppInfo);
            reportData.setReportEventKey(eventId);
            reportData.setReportEventValue(data);
            report(reportData);
        }
    }

    @JvmStatic
    public static final void reportDelete(@NotNull MiniAppInfo miniAppInfo) {
        String startupId;
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        StartupReportData startupReportData = miniAppInfo.launchParam.startupReportData;
        if (startupReportData != null && (startupId = startupReportData.getStartupId()) != null) {
            StartupReportData startupReportData2 = new StartupReportData();
            startupReportData2.setStartupId(startupId);
            startupReportData2.setEventName(EVENT_DELETE);
            report(startupReportData2);
            miniAppInfo.launchParam.startupReportData = null;
        }
    }

    @JvmStatic
    public static final void reportEngineLoad(@Nullable MiniAppInfo miniAppInfo, long costTime, @NotNull String jsLibVersion, @NotNull String tritonVersion) {
        Intrinsics.checkParameterIsNotNull(jsLibVersion, "jsLibVersion");
        Intrinsics.checkParameterIsNotNull(tritonVersion, "tritonVersion");
        if (miniAppInfo == null) {
            return;
        }
        StartupReportData startupReportData = miniAppInfo.launchParam.startupReportData;
        if (startupReportData != null) {
            startupReportData.setJsLibVersion(jsLibVersion);
            startupReportData.setTritonVersion(tritonVersion);
        }
        INSTANCE.reportEvent(EVENT_ENGINE_LOAD, miniAppInfo, costTime);
    }

    private final void reportEvent(String eventName, MiniAppInfo miniAppInfo, long relativeTime) {
        StartupReportData startupReportData = miniAppInfo.launchParam.startupReportData;
        if (startupReportData != null) {
            report(getReportData(startupReportData, eventName, relativeTime, miniAppInfo));
        }
    }

    static /* synthetic */ void reportEvent$default(StartupReportUtil startupReportUtil, String str, MiniAppInfo miniAppInfo, long j3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j3 = 0;
        }
        startupReportUtil.reportEvent(str, miniAppInfo, j3);
    }

    @JvmStatic
    public static final void reportInitEnv(@NotNull MiniAppInfo miniAppInfo, long cost) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        StartupReportData startupReportData = miniAppInfo.launchParam.startupReportData;
        if (startupReportData != null) {
            startupReportData.setGameEngineFlag(INSTANCE.getGameEngineFlag(miniAppInfo));
        }
        INSTANCE.reportEvent(EVENT_INIT_ENV, miniAppInfo, cost);
    }

    @JvmStatic
    public static final void reportLoading(@NotNull MiniAppInfo miniAppInfo, long cost, boolean isPreload, int flag) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        StartupReportData startupReportData = miniAppInfo.launchParam.startupReportData;
        if (startupReportData != null) {
            startupReportData.setPreloadFlag(isPreload ? 1 : 0);
            startupReportData.setStartupFlag(flag);
        }
        INSTANCE.reportEvent(EVENT_LOADING_BEGIN, miniAppInfo, cost);
    }

    @JvmStatic
    public static final void reportShow(@NotNull MiniAppInfo miniAppInfo, long relativeTime) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        StartupReportUtil startupReportUtil = INSTANCE;
        if (relativeTime < 0) {
            relativeTime = 0;
        }
        startupReportUtil.reportEvent(EVENT_SHOW, miniAppInfo, relativeTime);
    }

    @JvmStatic
    public static final void reportStartUI(@NotNull MiniAppInfo miniAppInfo) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        StartupReportData startupReportData = miniAppInfo.launchParam.startupReportData;
        if (startupReportData != null) {
            startupReportData.setGameEngineFlag(INSTANCE.getGameEngineFlag(miniAppInfo));
            startupReportData.setAppType(miniAppInfo.isEngineTypeMiniGame() ? 1 : 0);
        }
        if (miniAppInfo.isEngineTypeMiniGame()) {
            reportEvent$default(INSTANCE, EVENT_START_UI, miniAppInfo, 0L, 4, null);
        } else {
            reportDelete(miniAppInfo);
        }
    }

    @JvmStatic
    public static final void reportStartUpEvent(@NotNull String eventName, @Nullable MiniAppInfo miniAppInfo) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        if (miniAppInfo != null) {
            reportEvent$default(INSTANCE, eventName, miniAppInfo, 0L, 4, null);
        }
    }

    @JvmStatic
    public static final void reportUnityShow(@NotNull MiniAppInfo miniAppInfo, int costTime) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        INSTANCE.reportEvent(EVENT_UNITY_SHOW, miniAppInfo, costTime);
    }

    @JvmStatic
    @NotNull
    public static final StartupReportData reportBegin(@NotNull String appId, int scene, int appInfoFlag, long eventTime) {
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        StartupReportData startupReportData = new StartupReportData();
        startupReportData.setEventName(EVENT_BEGIN);
        startupReportData.setEventTime(eventTime);
        startupReportData.setAppId(appId);
        startupReportData.setAppInfoFlag(appInfoFlag);
        startupReportData.setStartupScene(scene);
        startupReportData.setStartupId(generateId(appId));
        report(startupReportData);
        return startupReportData;
    }

    public static /* synthetic */ StartupReportData reportBegin$default(String str, int i3, int i16, long j3, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        return reportBegin(str, i3, i16, j3);
    }
}
