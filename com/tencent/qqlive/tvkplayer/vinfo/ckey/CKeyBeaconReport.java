package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.BeaconAdapter;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CKeyBeaconReport {
    public static String BeaconAppKey = "000000CYDQ3IT5FF";
    private static BeaconInterface mBeaconInterface = null;
    private static boolean mCloseReport = false;
    private String mChannel;
    private String mVersion;

    public CKeyBeaconReport(String str, String str2, BeaconInterface beaconInterface) {
        this.mVersion = str;
        this.mChannel = str2;
        mBeaconInterface = beaconInterface;
    }

    public static String getQIMEI() {
        BeaconInterface beaconInterface = mBeaconInterface;
        if (beaconInterface != null) {
            return beaconInterface.getQIMEI();
        }
        return "";
    }

    public static Properties getRequiredReportValue() {
        BeaconInterface beaconInterface = mBeaconInterface;
        if (beaconInterface != null && beaconInterface.getRequiredReportValue() != null) {
            return mBeaconInterface.getRequiredReportValue();
        }
        return new Properties();
    }

    private static Map<String, String> propertyToMap(Properties properties) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry entry : properties.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                concurrentHashMap.put(key.toString(), "");
            } else {
                concurrentHashMap.put(key.toString(), value.toString());
            }
        }
        return concurrentHashMap;
    }

    public static void setSwitchReport(boolean z16) {
        mCloseReport = !z16;
    }

    public static void trackCustomKVEvent(Context context, String str, Properties properties) {
        if (mCloseReport) {
            return;
        }
        BeaconAdapter.onUserActionToTunnel(context, BeaconAppKey, str, true, -1L, -1L, propertyToMap(properties), true, false);
        BeaconInterface beaconInterface = mBeaconInterface;
        if (beaconInterface != null) {
            beaconInterface.trackCustomKVEvent(str, propertyToMap(properties));
        }
    }

    public void CKeyBeaconReportInit(Context context) {
        BeaconAdapter.registerTunnel(context, BeaconAppKey, this.mVersion, this.mChannel);
    }
}
