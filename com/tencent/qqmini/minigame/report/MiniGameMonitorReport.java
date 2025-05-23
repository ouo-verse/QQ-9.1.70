package com.tencent.qqmini.minigame.report;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.qqmini.minigame.manager.EnginePackageManager;
import com.tencent.qqmini.minigame.ui.GameUIProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniGameMonitorReport {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum MiniGameLaunchErrorType {
        SUCCESS,
        DOWNLOAD_JSSDK_ERROR,
        LOAD_JSSDK_ERROR,
        DOWNLOAD_MAIN_PACKAGE_ERROR,
        LOAD_MAIN_PACKAGE_ERROR,
        DOWNLOAD_ENGINE_PLUGIN_ERROR,
        FIRST_FRAME_ERROR
    }

    private static TaskExecutionStatics a(TaskExecutionStatics taskExecutionStatics, String str) {
        if (taskExecutionStatics != null && str != null) {
            if (str.equals(taskExecutionStatics.getName())) {
                return taskExecutionStatics;
            }
            List<TaskExecutionStatics> subSteps = taskExecutionStatics.getSubSteps();
            if (subSteps != null) {
                for (int i3 = 0; i3 < subSteps.size(); i3++) {
                    TaskExecutionStatics a16 = a(subSteps.get(i3), str);
                    if (a16 != null) {
                        return a16;
                    }
                }
            }
        }
        return null;
    }

    private static String b(GameUIProxy gameUIProxy) {
        String str;
        MiniAppInfo f16 = f(gameUIProxy);
        if (f16 == null || (str = f16.appId) == null) {
            return "";
        }
        return str;
    }

    private static String c(GameUIProxy gameUIProxy) {
        if (gameUIProxy == null) {
            return "";
        }
        return gameUIProxy.getGameRoundId();
    }

    private static String d(GameUIProxy gameUIProxy) {
        String str;
        MiniAppInfo f16 = f(gameUIProxy);
        if (f16 == null || (str = f16.version) == null) {
            return "";
        }
        return str;
    }

    private static String e(GameUIProxy gameUIProxy) {
        if (gameUIProxy != null && gameUIProxy.getGameRuntime() != null) {
            return gameUIProxy.getGameRuntime().getJsVersion();
        }
        return "";
    }

    private static MiniAppInfo f(GameUIProxy gameUIProxy) {
        if (gameUIProxy == null) {
            return null;
        }
        if (gameUIProxy.getMiniAppInfo() != null) {
            return gameUIProxy.getMiniAppInfo();
        }
        Activity activity = gameUIProxy.getActivity();
        if (activity == null || activity.getIntent() == null) {
            return null;
        }
        return (MiniAppInfo) activity.getIntent().getParcelableExtra(IPCConst.KEY_APPINFO);
    }

    protected static void g(GameUIProxy gameUIProxy, Map<String, String> map) {
        if (map == null) {
            return;
        }
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        map.put("JSSDKVersion", e(gameUIProxy));
        map.put(EnginePackageManager.TRITON_ONLINE_VERSION, i(gameUIProxy));
        map.put("gameVersion", d(gameUIProxy));
        map.put("QUA", miniAppProxy.getPlatformQUA());
        String account = miniAppProxy.getAccount();
        map.put("QQUin", account);
        map.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, miniAppProxy.getPlatformId());
        map.put(DKEngine.GlobalKey.NET_WORK_TYPE, MiniProgramReportHelper.getNetworkType());
        String b16 = b(gameUIProxy);
        map.put("gameRoundId", c(gameUIProxy) + "_" + b16 + "_" + account);
        map.put("scene", String.valueOf(h(gameUIProxy)));
        if (!map.containsKey("appId")) {
            map.put("appId", b16);
        }
    }

    private static int h(GameUIProxy gameUIProxy) {
        LaunchParam launchParam;
        MiniAppInfo f16 = f(gameUIProxy);
        if (f16 != null && (launchParam = f16.launchParam) != null) {
            return launchParam.scene;
        }
        return 0;
    }

    private static String i(GameUIProxy gameUIProxy) {
        if (gameUIProxy != null && gameUIProxy.getGameRuntime() != null) {
            return gameUIProxy.getGameRuntime().getTritonVersion();
        }
        return "";
    }

    private static boolean j(GameUIProxy gameUIProxy) {
        MiniAppInfo f16 = f(gameUIProxy);
        if (f16 != null && f16.miniGamePluginInfo != null) {
            return true;
        }
        return false;
    }

    private static void k(TaskExecutionStatics taskExecutionStatics, HashMap<String, String> hashMap) {
        TaskExecutionStatics a16 = a(taskExecutionStatics, "LaunchGame");
        if (a16 != null && a16.getSubSteps() != null && a16.getSubSteps().size() > 0) {
            List<TaskExecutionStatics> subSteps = a16.getSubSteps();
            long startTime = subSteps.get(0).getStartTime();
            long runDurationMs = subSteps.get(0).getRunDurationMs() + startTime;
            for (int i3 = 1; i3 < subSteps.size(); i3++) {
                TaskExecutionStatics taskExecutionStatics2 = subSteps.get(i3);
                if (taskExecutionStatics2.getStartTime() < startTime) {
                    startTime = taskExecutionStatics2.getStartTime();
                } else if (taskExecutionStatics2.getStartTime() + taskExecutionStatics2.getRunDurationMs() > runDurationMs) {
                    runDurationMs = taskExecutionStatics2.getStartTime() + taskExecutionStatics2.getRunDurationMs();
                }
            }
            m(hashMap, "runMainPackageCost", runDurationMs - startTime);
            m(hashMap, "runMainPackageStartTime", startTime);
            m(hashMap, "runMainPackageEndTime", runDurationMs);
        }
    }

    private static void l(GameUIProxy gameUIProxy, HashMap<String, String> hashMap, long j3, long j16) {
        String str;
        if (gameUIProxy != null && gameUIProxy.getGameRuntime() != null) {
            int loadingAdStatus = gameUIProxy.getGameRuntime().getLoadingAdStatus();
            boolean z16 = true;
            if (loadingAdStatus != 2) {
                if (loadingAdStatus != 3) {
                    z16 = false;
                } else if (gameUIProxy.getLoadingAdCloseTime() > j3) {
                    j3 = gameUIProxy.getLoadingAdCloseTime();
                }
            } else {
                j3 = 0;
            }
            hashMap.put("gameVisibleTime", String.valueOf(j3));
            if (j3 > 0) {
                hashMap.put("gameVisibleCost", String.valueOf(j3 - j16));
            }
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("hasLaunchAd", str);
        }
    }

    private static void m(Map<String, String> map, String str, long j3) {
        map.put(str, String.valueOf(j3));
    }

    public static void n(GameUIProxy gameUIProxy, String str, int i3, String str2, boolean z16) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", String.valueOf(i3));
        hashMap.put("message", str2);
        g(gameUIProxy, hashMap);
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).reportBeacon(ChannelProxy.BeaconReportCategory.MINI_GAME, str, hashMap, z16, false);
    }

    public static void o(GameUIProxy gameUIProxy, String str, Map<String, String> map, boolean z16) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        g(gameUIProxy, hashMap);
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).reportBeacon(ChannelProxy.BeaconReportCategory.MINI_GAME, str, hashMap, z16, false);
    }

    public static void p(GameUIProxy gameUIProxy, TaskExecutionStatics taskExecutionStatics, long j3, long j16) {
        long j17;
        long j18;
        int i3;
        MiniGamePluginInfo miniGamePluginInfo;
        long j19;
        HashMap hashMap = new HashMap();
        TaskExecutionStatics a16 = a(taskExecutionStatics, "StartActivity");
        long j26 = 0;
        if (a16 != null && a16.getStartTime() > 0) {
            j17 = a16.getStartTime();
            m(hashMap, "createActivityCost", a16.getRunDurationMs());
            m(hashMap, "createActivityStartTime", a16.getStartTime());
            m(hashMap, "createActivityEndTime", a16.getStartTime() + a16.getRunDurationMs());
        } else {
            j17 = j3;
        }
        TaskExecutionStatics a17 = a(taskExecutionStatics, "DownloadGpkg");
        if (a17 != null && a17.getStartTime() > 0) {
            m(hashMap, "isNeedDownMainPackage", 1L);
            m(hashMap, "downloadMainPackageCost", a17.getTotalRunDurationMs());
            m(hashMap, "downloadMainPackageStartTime", a17.getStartTime());
            m(hashMap, "downloadMainPackageEndTime", a17.getStartTime() + a17.getTotalRunDurationMs());
        } else {
            m(hashMap, "isNeedDownMainPackage", 0L);
        }
        TaskExecutionStatics a18 = a(taskExecutionStatics, "DownloadPlugin");
        if (a18 != null && a18.getStartTime() > 0) {
            m(hashMap, "isNeedDownPlugin", 1L);
            m(hashMap, "downloadPluginCost", a18.getTotalRunDurationMs());
            m(hashMap, "downloadPluginStartTime", a18.getStartTime());
            m(hashMap, "downloadPluginEndTime", a18.getStartTime() + a18.getTotalRunDurationMs());
        } else {
            m(hashMap, "isNeedDownPlugin", 0L);
        }
        if (j(gameUIProxy)) {
            j18 = 1;
        } else {
            j18 = 0;
        }
        m(hashMap, "isNeedPlugin", j18);
        TaskExecutionStatics a19 = a(taskExecutionStatics, "LoadSo");
        if (a19 != null && a19.getStartTime() > 0) {
            m(hashMap, "loadSoCost", a19.getRunDurationMs());
            m(hashMap, "loadSoStartTime", a19.getStartTime());
            m(hashMap, "loadSoEndTime", a19.getStartTime() + a19.getRunDurationMs());
        }
        TaskExecutionStatics a26 = a(taskExecutionStatics, "LoadEngineScript");
        if (a26 != null && a26.getStartTime() > 0) {
            m(hashMap, "runJSSDKCost", a26.getRunDurationMs());
            m(hashMap, "runJSSDKStartTime", a26.getStartTime());
            m(hashMap, "runJSSDKEndTime", a26.getStartTime() + a26.getRunDurationMs());
        }
        k(taskExecutionStatics, hashMap);
        m(hashMap, "closeGameTime", System.currentTimeMillis());
        m(hashMap, "launchStartTime", j17);
        if (j16 > 0) {
            m(hashMap, "launchEndTime", j16);
            m(hashMap, "launchCost", j16 - j17);
        } else {
            m(hashMap, "launchEndTime", 0L);
            m(hashMap, "launchCost", 0L);
        }
        l(gameUIProxy, hashMap, j16, j17);
        if (gameUIProxy != null) {
            if (gameUIProxy.isFromPreload()) {
                j19 = 1;
            } else {
                j19 = 0;
            }
            m(hashMap, "isJSSDKPreload", j19);
        }
        if (((QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class)) != null) {
            m(hashMap, "device_level", r0.getDeviceLevel());
        }
        MiniAppInfo f16 = f(gameUIProxy);
        if (f16 != null && (miniGamePluginInfo = f16.miniGamePluginInfo) != null && "UnityPlugin".equals(miniGamePluginInfo.name)) {
            i3 = 5;
        } else {
            i3 = 0;
        }
        m(hashMap, "gameEngineFlag", i3);
        if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
            j26 = 1;
        }
        m(hashMap, "debugFlag", j26);
        o(gameUIProxy, "minigame_launch_andriod", hashMap, true);
    }

    public static void q(MiniAppInfo miniAppInfo, @NonNull HashMap<String, String> hashMap, boolean z16, boolean z17) {
        String str;
        GameUIProxy gameUIProxy = GameUIProxy.getGameUIProxy(miniAppInfo);
        if (gameUIProxy == null) {
            return;
        }
        if (z17) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("isHitSample", str);
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null) {
            hashMap.put("device_level", qQCustomizedProxy.getDeviceLevel() + "");
        }
        if (z16) {
            o(gameUIProxy, "minigame_network_request_start_andriod", hashMap, false);
        } else {
            o(gameUIProxy, "minigame_network_request_andriod", hashMap, false);
        }
    }
}
