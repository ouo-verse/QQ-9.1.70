package com.tencent.thumbplayer.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.thumbplayer.api.report.ITPBeaconDataReporter;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.report.reportv1.BeaconAdapter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPBeaconReportWrapper {
    private static final String APP_KEY = "00000GODBG3702Y1";
    private static final String TAG = "TPBeaconReportWrapper";

    public static void init(Context context) {
        TPLogUtil.i(TAG, "Beacon sdk init.");
        if (!TextUtils.isEmpty(BeaconAdapter.beacon_policy_host) && !TextUtils.isEmpty(BeaconAdapter.beacon_log_host)) {
            UserAction.setReportDomain(BeaconAdapter.beacon_policy_host, BeaconAdapter.beacon_log_host);
        }
        BeaconAdapter.registerTunnel(APP_KEY, "", "");
    }

    public static void trackCustomKVEvent(String str, String str2, Map<String, String> map) {
        BeaconAdapter.onUserActionToTunnel(str2, str, true, -1L, -1L, map, true, true);
    }

    public static void trackCustomKVEvent(String str, Map<String, String> map) {
        trackCustomKVEvent(str, APP_KEY, map);
    }

    public static void trackCustomKVEvent(String str, ITPReportProperties iTPReportProperties) {
        HashMap hashMap = new HashMap();
        iTPReportProperties.propertiesToMap(hashMap);
        trackCustomKVEvent(str, APP_KEY, hashMap);
    }

    public static void setBeaconDataReporter(ITPBeaconDataReporter iTPBeaconDataReporter) {
    }
}
