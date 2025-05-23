package com.tencent.superplayer.report;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.NetworkUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.report.reportv1.BeaconAdapter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class SPBeaconReporter {
    public static final String APP_KEY = "00000U7O8S3BLETM";
    private static final String TAG = ".SPBeaconReporter";
    private static String sTpdlVersion;
    private static Map<String, String> sampleRates = new HashMap();

    private static boolean checkSample(String str, Map<String, String> map) {
        String str2;
        float parseFloat;
        if (map.containsKey("param_sceneId")) {
            str2 = sampleRates.get(str + "_" + map.get("param_sceneId"));
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = sampleRates.get(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                parseFloat = Float.parseFloat(str2);
            } catch (Exception unused) {
                LogUtil.e(TAG, "checkSample error sampleRateStr:" + str2);
                return true;
            }
        } else {
            parseFloat = 1.0f;
        }
        if (Math.random() < parseFloat) {
            return true;
        }
        return false;
    }

    public static void init(SuperPlayerSdkOption superPlayerSdkOption) {
        BeaconAdapter.registerTunnel(APP_KEY, SuperPlayerSDKMgr.getSDKVersion(), "superPlayer");
        com.tencent.superplayer.datatransport.b.c().b(new com.tencent.superplayer.datatransport.a() { // from class: com.tencent.superplayer.report.SPBeaconReporter.1
            @Override // com.tencent.superplayer.datatransport.a
            public void onDownloadInfoReportUpdate(String str) {
                SPDownloadEvent parseEvent = SPDownloadEvent.parseEvent(str);
                if (parseEvent.needReport()) {
                    LogUtil.d(SPBeaconReporter.TAG, "spDownloadEvent report, name:" + parseEvent.getEventName() + " map:" + parseEvent.getDataMap());
                    SPBeaconReporter.report(parseEvent.getEventName(), parseEvent.getDataMap());
                }
            }

            @Override // com.tencent.superplayer.datatransport.a
            public void onQuicQualityReportUpdate(String str) {
                SPQuicInfoEvent parseEvent = SPQuicInfoEvent.parseEvent(str);
                if (parseEvent.needReport()) {
                    SPBeaconReporter.report(parseEvent.getEventName(), parseEvent.getDataMap());
                }
            }
        });
        Map<String, String> map = superPlayerSdkOption.superSampleConfig;
        sampleRates = map;
        if (map == null) {
            sampleRates = new HashMap();
        }
    }

    public static void report(String str, Map<String, String> map) {
        report(str, map, false);
    }

    public static void report(final String str, Map<String, String> map, boolean z16) {
        final HashMap hashMap = new HashMap(map);
        if (z16 || checkSample(str, map)) {
            ThreadUtil.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.superplayer.report.SPBeaconReporter.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!TextUtils.isEmpty(str) && !hashMap.isEmpty()) {
                        if (!TextUtils.isEmpty(SuperPlayerSDKMgr.getUid())) {
                            hashMap.put("param_uin", SuperPlayerSDKMgr.getUid());
                        }
                        hashMap.put(j.I0, String.valueOf(NetworkUtil.getNetWorkType()));
                        hashMap.put("param_appId", String.valueOf(SuperPlayerSDKMgr.getPlatform()));
                        if (SPBeaconReporter.sTpdlVersion == null && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
                            String unused = SPBeaconReporter.sTpdlVersion = TPDownloadProxyNative.getInstance().getNativeVersion();
                        }
                        hashMap.put("param_tpdlVersion", SPBeaconReporter.sTpdlVersion);
                        Map<String, String> globalReportMap = SuperPlayerSDKMgr.getGlobalReportMap();
                        if (globalReportMap != null) {
                            hashMap.putAll(globalReportMap);
                        }
                        LogUtil.d(SPBeaconReporter.TAG, "report eventName=" + str + ", dataMap=" + hashMap);
                        BeaconAdapter.onUserActionToTunnel(SPBeaconReporter.APP_KEY, str, true, -1L, -1L, hashMap, true, true);
                        return;
                    }
                    LogUtil.e(SPBeaconReporter.TAG, "report failed for eventName:" + str + ", dataMap:" + hashMap);
                }
            });
        }
    }
}
