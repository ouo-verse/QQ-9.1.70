package com.tencent.qqmini.minigame.utils;

import android.text.TextUtils;
import com.tencent.luggage.wxa.gg.g;
import com.tencent.luggage.wxa.ig.h;
import com.tencent.luggage.wxa.ig.k;
import com.tencent.luggage.wxa.ig.m;
import com.tencent.luggage.wxa.ig.n;
import com.tencent.luggage.wxa.ig.o;
import com.tencent.luggage.wxa.ig.q;
import com.tencent.luggage.wxa.ig.u;
import com.tencent.luggage.wxa.ig.y;
import com.tencent.luggage.wxa.jg.l;
import com.tencent.luggage.wxa.jg.s;
import com.tencent.luggage.wxa.jg.t;
import com.tencent.luggage.wxa.jg.w;
import com.tencent.luggage.wxa.jg.x;
import com.tencent.luggage.wxa.nf.f;
import com.tencent.luggage.wxa.of.a;
import com.tencent.luggage.wxa.pf.a;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.minigame.plugins.ImmersiveJsPlugin;
import com.tencent.qqmini.minigame.plugins.OrientationJsPlugin;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.plugins.BannerAdPlugin;
import com.tencent.qqmini.sdk.plugins.BatteryJsPlugin;
import com.tencent.qqmini.sdk.plugins.InputJsPlugin;
import com.tencent.qqmini.sdk.plugins.NetworkJsPlugin;
import com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LogFilterUtil {
    public static final Map<String, Set<String>> DEFAULT_BLACK_LIST;
    public static final Map<String, Set<String>> DEFAULT_WHITE_LIST;
    private static final String TAG = "LogFilterUtil";
    private static Map<String, Set<String>> mLogBlackList;
    private static Map<String, Set<String>> mLogWhiteList;

    static {
        HashMap hashMap = new HashMap();
        DEFAULT_WHITE_LIST = hashMap;
        HashMap hashMap2 = new HashMap();
        DEFAULT_BLACK_LIST = hashMap2;
        hashMap.put(InnerAudioPlugin.EVENT_ON_AUDIO_STATE_CHANGE, new HashSet<String>() { // from class: com.tencent.qqmini.minigame.utils.LogFilterUtil.1
            {
                add("error");
            }
        });
        hashMap.put(f.b.NAME, new HashSet<String>() { // from class: com.tencent.qqmini.minigame.utils.LogFilterUtil.2
            {
                add("error");
                add("open");
                add("close");
            }
        });
        hashMap.put(a.b.NAME, new HashSet<String>() { // from class: com.tencent.qqmini.minigame.utils.LogFilterUtil.3
            {
                add("fail");
                add("success");
            }
        });
        hashMap.put(a.b.NAME, new HashSet<String>() { // from class: com.tencent.qqmini.minigame.utils.LogFilterUtil.4
            {
                add("fail");
                add("success");
            }
        });
        hashMap2.put("createAudioInstance", null);
        hashMap2.put("setAudioState", null);
        hashMap2.put("getAudioState", null);
        hashMap2.put("operateAudio", null);
        hashMap2.put("destroyAudioInstance", null);
        hashMap2.put(InnerAudioPlugin.EVENT_ON_AUDIO_STATE_CHANGE, null);
        hashMap2.put(InnerAudioPlugin.API_SET_INNER_AUDIO_OPTION, null);
        hashMap2.put("getAvailableAudioSources", null);
        hashMap2.put("loadFont", null);
        hashMap2.put("getTextLineHeight", null);
        hashMap2.put("showKeyboard", null);
        hashMap2.put("hideKeyboard", null);
        hashMap2.put(InputJsPlugin.EVENT_UPDATE_KEYBOARD, null);
        hashMap2.put(InputJsPlugin.ON_KEYBOARD_INPUT_CALLBACK, null);
        hashMap2.put(InputJsPlugin.ON_KEYBOARD_CONFIRM_CALLBACK, null);
        hashMap2.put(InputJsPlugin.ON_KEYBOARD_COMPLETE_CALLBACK, null);
        hashMap2.put(OrientationJsPlugin.EVENT_ORIENTATION_CHANGE, null);
        hashMap2.put("reportDataToDC", null);
        hashMap2.put("reportRealtimeAction", null);
        hashMap2.put("api_report", null);
        hashMap2.put("insertVideoPlayer", null);
        hashMap2.put("updateVideoPlayer", null);
        hashMap2.put("removeVideoPlayer", null);
        hashMap2.put("operateVideoPlayer", null);
        hashMap2.put("login", null);
        hashMap2.put("refreshSession", null);
        hashMap2.put(com.tencent.luggage.wxa.gg.c.NAME, null);
        hashMap2.put(com.tencent.luggage.wxa.gg.d.NAME, null);
        hashMap2.put(com.tencent.luggage.wxa.gg.a.NAME, null);
        hashMap2.put(g.NAME, null);
        hashMap2.put("getShareInfo", null);
        hashMap2.put("profile", null);
        hashMap2.put("navigateToMiniProgramConfig", null);
        hashMap2.put("recordOffLineResourceState", null);
        hashMap2.put(com.tencent.luggage.wxa.v6.g.NAME, null);
        hashMap2.put("authorize", null);
        hashMap2.put("operateWXData", null);
        hashMap2.put("reportSubmitForm", null);
        hashMap2.put(PluginConst.DataJsPluginConst.API_GET_NATIVE_USER_INFO, null);
        hashMap2.put(PluginConst.DataJsPluginConst.API_GET_USERINFO_OPENDATA, null);
        hashMap2.put("getQua", null);
        hashMap2.put("notifyNative", null);
        hashMap2.put("getStoreAppList", null);
        hashMap2.put("wnsRequest", null);
        hashMap2.put("getNetworkType", null);
        hashMap2.put(NetworkJsPlugin.EVENT_NETWORK_STATE_CHANGE, null);
        hashMap2.put(UIJsPlugin.EVENT_SHOW_TOAST, null);
        hashMap2.put(UIJsPlugin.EVENT_HIDE_TOAST, null);
        hashMap2.put(UIJsPlugin.EVENT_SHOW_LOADING, null);
        hashMap2.put(UIJsPlugin.EVENT_HIDE_LOADING, null);
        hashMap2.put(UIJsPlugin.EVENT_SHOW_MODAL, null);
        hashMap2.put("showActionSheet", null);
        hashMap2.put("setScreenBrightness", null);
        hashMap2.put(l.NAME, null);
        hashMap2.put(t.NAME, null);
        hashMap2.put("getBatteryInfo", null);
        hashMap2.put(BatteryJsPlugin.EVENT_GET_BATTERY_SYNC, null);
        hashMap2.put("getClipboardData", null);
        hashMap2.put(s.NAME, null);
        hashMap2.put(com.tencent.luggage.wxa.fg.b.NAME, null);
        hashMap2.put(com.tencent.luggage.wxa.fg.c.NAME, null);
        hashMap2.put(com.tencent.luggage.wxa.fg.e.NAME, null);
        hashMap2.put(com.tencent.luggage.wxa.fg.d.NAME, null);
        hashMap2.put(x.NAME, null);
        hashMap2.put(w.NAME, null);
        hashMap2.put(SensorJsPlugin.EVENT_ACCELEROMETER_STATE_CHANGE, null);
        hashMap2.put(SensorJsPlugin.EVENT_COMPASS_STATE_CHANGE, null);
        hashMap2.put(SensorJsPlugin.EVENT_GYROSCOPE_STATE_CHANGE, null);
        hashMap2.put(SensorJsPlugin.EVENT_DEVICE_MOTION_STATE_CHANGE, null);
        hashMap2.put(com.tencent.luggage.wxa.ig.t.NAME, null);
        hashMap2.put(u.NAME, null);
        hashMap2.put(com.tencent.luggage.wxa.ig.x.NAME, null);
        hashMap2.put(y.NAME, null);
        hashMap2.put(com.tencent.luggage.wxa.ig.g.NAME, null);
        hashMap2.put(h.NAME, null);
        hashMap2.put(m.NAME, null);
        hashMap2.put(q.NAME, null);
        hashMap2.put(n.NAME, null);
        hashMap2.put(o.NAME, null);
        hashMap2.put(k.NAME, null);
        hashMap2.put(com.tencent.luggage.wxa.ig.w.NAME, null);
        hashMap2.put(PluginConst.OuterJsPluginConst.API_AD_CREATE_REWARDED_VIDEO_AD, null);
        hashMap2.put(PluginConst.OuterJsPluginConst.API_AD_OPERATE_REWARDED_VIDEO_AD, null);
        hashMap2.put(RewardedVideoAdPlugin.EVENT_REWARDED_VIDEO_STATE_CHANGE, null);
        hashMap2.put(BannerAdPlugin.API_AD_CREATE_BANNER_AD, null);
        hashMap2.put(BannerAdPlugin.API_AD_OPERATE_BANNER_AD, null);
        hashMap2.put(BannerAdPlugin.API_AD_UPDATE_BANNER_AD_SIZE, null);
        hashMap2.put(BannerAdPlugin.EVENT_BANNER_AD_STATE_CHANGE, null);
        hashMap2.put(BannerAdPlugin.EVENT_BANNER_AD_SHOW_DONE, null);
        hashMap2.put("setEnableDebug", null);
        hashMap2.put(MiniSDKConst.ON_APP_LOW_MEMORY, null);
        hashMap2.put(ImmersiveJsPlugin.API_SET_STATUS_BAR_STYLE, null);
        hashMap2.put("setMenuStyle", null);
        hashMap2.put("getOpenDataContext", null);
        hashMap2.put("onMessage", null);
        hashMap2.put(a.b.NAME, null);
        hashMap2.put(f.b.NAME, null);
        hashMap2.put(a.b.NAME, null);
    }

    public static Map<String, Set<String>> getLogBlackList() {
        if (mLogBlackList == null) {
            mLogBlackList = new HashMap(DEFAULT_BLACK_LIST);
            String config = WnsConfig.getConfig("qqtriton", "MiniGameAPILogBlackList");
            GameLog.getInstance().i(TAG, "wns config black list: " + config);
            Set<String> parseConfigString2Set = parseConfigString2Set(config);
            if (parseConfigString2Set != null) {
                for (String str : parseConfigString2Set) {
                    if (!TextUtils.isEmpty(str)) {
                        mLogBlackList.put(str, null);
                    }
                }
            }
        }
        return mLogBlackList;
    }

    public static Map<String, Set<String>> getLogWhiteList() {
        if (mLogWhiteList == null) {
            mLogWhiteList = new HashMap(DEFAULT_WHITE_LIST);
            String config = WnsConfig.getConfig("qqtriton", "MiniGameAPILogWhiteList");
            GameLog.getInstance().i(TAG, "wns config white list: " + config);
            Set<String> parseConfigString2Set = parseConfigString2Set(config);
            if (parseConfigString2Set != null) {
                for (String str : parseConfigString2Set) {
                    if (!TextUtils.isEmpty(str)) {
                        mLogWhiteList.put(str, null);
                    }
                }
            }
        }
        return mLogWhiteList;
    }

    private static Set<String> parseConfigString2Set(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        String[] split = str.split(",");
        if (split != null && split.length > 0) {
            for (String str2 : split) {
                String trim = str2.trim();
                if (!TextUtils.isEmpty(trim)) {
                    hashSet.add(trim);
                }
            }
        }
        return hashSet;
    }
}
