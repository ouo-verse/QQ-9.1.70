package com.tencent.qqlive.module.videoreport.dtreport.time.app;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatSpUtils;
import com.tencent.qqlive.module.videoreport.utils.SPUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AppHeartBeatSpUtils {
    public static synchronized void clearSessionHeartBeat() {
        synchronized (AppHeartBeatSpUtils.class) {
            HeartBeatSpUtils.clearLastHeartBeat(SPUtils.LAST_APP_HEART_BEAT_MAP);
        }
    }

    public static Map<String, Object> getLastHeartBeatMap() {
        return HeartBeatSpUtils.getLastHeartBeat(SPUtils.LAST_APP_HEART_BEAT_MAP);
    }

    public static void removeSessionHeartBeat(String str) {
        saveSessionLastHeartBeat(str, "");
    }

    public static synchronized void saveSessionLastHeartBeat(String str, String str2) {
        synchronized (AppHeartBeatSpUtils.class) {
            Map lastHeartBeatMap = getLastHeartBeatMap();
            if (lastHeartBeatMap == null) {
                lastHeartBeatMap = new HashMap();
            }
            if (TextUtils.isEmpty(str2)) {
                if (!lastHeartBeatMap.containsKey(str)) {
                    return;
                } else {
                    lastHeartBeatMap.remove(str);
                }
            } else {
                lastHeartBeatMap.put(str, str2);
            }
            saveSessionLastHeartBeat(lastHeartBeatMap);
        }
    }

    public static synchronized void saveSessionLastHeartBeat(Map<String, Object> map) {
        synchronized (AppHeartBeatSpUtils.class) {
            HeartBeatSpUtils.saveLastHeartBeat(SPUtils.LAST_APP_HEART_BEAT_MAP, map);
        }
    }
}
