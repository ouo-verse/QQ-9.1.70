package com.tencent.thumbplayer.report.reportv1;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.mobileqq.perf.block.ReportMethodProxy;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class BeaconAdapter {
    private static String TAG = "BeaconAdapter";
    private static boolean beaconEnable = false;
    public static String beacon_log_host = "";
    public static String beacon_policy_host = "";
    private static boolean is4XVersion = false;
    private static String qimei36;

    static {
        try {
            if (sdkVersionBiggerThanThat(UserAction.getSDKVersion(), "3.1.2")) {
                beaconEnable = true;
            }
            if (sdkVersionBiggerThanThat(UserAction.getSDKVersion(), "4.1.0")) {
                is4XVersion = true;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static String getQIMEI() {
        String str = qimei36;
        if (str != null) {
            return str;
        }
        String str2 = "";
        if (!beaconEnable) {
            return "";
        }
        try {
            if (is4XVersion) {
                str2 = UserAction.getQimeiNew();
            }
            if (TextUtils.isEmpty(str2)) {
                return UserAction.getQIMEI();
            }
            return str2;
        } catch (Throwable th5) {
            TPLogUtil.e(TAG, "getQIMEI() error=" + th5.getMessage());
            return "";
        }
    }

    public static void initUserAction(Context context, String str, BeaconConfig beaconConfig) {
        if (!beaconEnable) {
            return;
        }
        if (is4XVersion) {
            BeaconReport.getInstance().start(context, str, beaconConfig);
        } else {
            UserAction.initUserAction(context);
        }
    }

    public static void onUserActionToTunnel(String str, String str2, boolean z16, long j3, long j16, Map<String, String> map, boolean z17, boolean z18) {
        if (!beaconEnable) {
            return;
        }
        if (is4XVersion) {
            BeaconEvent.Builder builder = BeaconEvent.builder();
            if (!TextUtils.isEmpty(str)) {
                builder.withAppKey(str);
            }
            if (map == null) {
                map = new HashMap<>();
            }
            builder.withCode(str2);
            builder.withIsSucceed(z16);
            if (z17) {
                builder.withType(EventType.REALTIME);
            }
            builder.withParams(map);
            BeaconReport.getInstance().report(builder.build());
            return;
        }
        ReportMethodProxy.onUserActionToTunnel(str, str2, z16, j3, j16, map, z17, z18);
    }

    public static void registerTunnel(String str, String str2, String str3) {
        if (!beaconEnable) {
            return;
        }
        if (is4XVersion) {
            TPLogUtil.w(TAG, "registerTunnel method is do nothing.");
        } else {
            UserAction.registerTunnel(new TunnelInfo(str, str2, str3));
        }
    }

    private static boolean sdkVersionBiggerThanThat(String str, String str2) {
        if (str.compareTo(str2) >= 0) {
            return true;
        }
        return false;
    }

    public static void setQIMEI(String str) {
        qimei36 = str;
    }
}
