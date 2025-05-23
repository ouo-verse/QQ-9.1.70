package com.tencent.qqmini.sdk.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniGameEnv;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {
    public static String a(String str) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf(63)) != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    private static boolean b() {
        double random = Math.random() * 10000.0d;
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        if (miniAppProxy == null || miniAppProxy.isDebugVersion() || miniAppProxy.isGrayVersion()) {
            random = Math.random() * 100.0d;
        }
        if (random <= 1.0d) {
            return true;
        }
        return false;
    }

    private static void c(MiniAppInfo miniAppInfo, @NonNull HashMap<String, String> hashMap, boolean z16, boolean z17) {
        IMiniGameEnv miniGameEnv = MiniAppEnv.g().getMiniGameEnv();
        if (miniGameEnv != null) {
            miniGameEnv.getMiniGameReporter().reportNetRequest(miniAppInfo, hashMap, z16, z17);
        }
    }

    public static void d(MiniAppInfo miniAppInfo, String str, String str2, int i3, long j3, long j16) {
        if (miniAppInfo != null && miniAppInfo.isEngineTypeMiniGame()) {
            HashMap hashMap = new HashMap();
            hashMap.put("requestUrlWithoutQuery", a(str2));
            hashMap.put("requestType", str);
            hashMap.put("requestLength", String.valueOf(j3));
            hashMap.put("requestCost", String.valueOf(j16));
            hashMap.put("requestResult", String.valueOf(i3));
            c(miniAppInfo, hashMap, false, false);
        }
    }

    public static void e(MiniAppInfo miniAppInfo, String str, String str2, String str3) {
        if (miniAppInfo != null && miniAppInfo.isEngineTypeMiniGame()) {
            HashMap hashMap = new HashMap();
            hashMap.put("requestType", str);
            hashMap.put("requestUrlWithoutQuery", a(str2));
            hashMap.put("requestErrorMsg", str3);
            hashMap.put("requestResult", "-1");
            c(miniAppInfo, hashMap, false, false);
        }
    }

    public static boolean f(MiniAppInfo miniAppInfo, String str, String str2) {
        if (miniAppInfo == null || !miniAppInfo.isEngineTypeMiniGame() || !b()) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("requestType", str);
        hashMap.put("requestUrlWithoutQuery", a(str2));
        c(miniAppInfo, hashMap, true, true);
        return true;
    }

    public static void g(MiniAppInfo miniAppInfo, String str, String str2, long j3, long j16) {
        if (miniAppInfo != null && miniAppInfo.isEngineTypeMiniGame()) {
            HashMap hashMap = new HashMap();
            hashMap.put("requestUrlWithoutQuery", a(str2));
            hashMap.put("requestType", str);
            hashMap.put("requestLength", String.valueOf(j3));
            hashMap.put("requestCost", String.valueOf(j16));
            hashMap.put("requestResult", "0");
            c(miniAppInfo, hashMap, false, true);
        }
    }

    public static void h(MiniAppInfo miniAppInfo) {
        String str;
        int i3;
        if (miniAppInfo != null) {
            str = miniAppInfo.appId;
        } else {
            str = "";
        }
        if (miniAppInfo != null) {
            i3 = miniAppInfo.engineType;
        } else {
            i3 = -1;
        }
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put(TagName.ENGINE_TYPE, String.valueOf(i3));
        hashMap.put("QUA", miniAppProxy.getPlatformQUA());
        hashMap.put("QQUin", miniAppProxy.getAccount());
        hashMap.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, miniAppProxy.getPlatformId());
        hashMap.put(DKEngine.GlobalKey.NET_WORK_TYPE, MiniProgramReportHelper.getNetworkType());
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).reportBeacon(ChannelProxy.BeaconReportCategory.MINI_GAME, "minigame_entry_launch_start_activity_andriod", hashMap, true, false);
    }
}
