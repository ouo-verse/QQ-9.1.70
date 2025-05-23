package com.tencent.qqlive.tvkplayer.report.api;

import com.tencent.qqlive.tvkplayer.api.ITVKBeaconDataReporter;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKBeaconReport {
    private static final String BEACON_APPKEY = "0AND0F8T5N4N7QT0";
    private static final String TAG = "TVKPlayer[TVKBeaconReport]";
    private static ITVKBeaconDataReporter sBeaconDataReporter;

    private static Map<String, String> propertyToMap(Properties properties) {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : properties.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                hashMap.put(key.toString(), "");
            } else {
                hashMap.put(key.toString(), value.toString());
            }
        }
        return hashMap;
    }

    public static void setBeaconDataReporter(ITVKBeaconDataReporter iTVKBeaconDataReporter) {
        sBeaconDataReporter = iTVKBeaconDataReporter;
    }

    public static void trackCustomKVEvent(String str, Properties properties) {
        trackCustomKVEvent(str, propertyToMap(properties));
    }

    public static void trackCustomKVEvent(String str, Map<String, String> map) {
        ITVKBeaconDataReporter iTVKBeaconDataReporter;
        if (TVKCommParams.isPreviewMode() || (iTVKBeaconDataReporter = sBeaconDataReporter) == null) {
            return;
        }
        iTVKBeaconDataReporter.trackCustomKVEvent(BEACON_APPKEY, str, map);
    }
}
