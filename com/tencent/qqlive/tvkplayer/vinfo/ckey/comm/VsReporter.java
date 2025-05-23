package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyBeaconReport;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyGuard;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VsReporter {
    public static final String GUARD_JAR_VERSION = "guard_jar_version";
    public static final String GUARD_SO_VERSION = "guard_so_version";
    private static final String TAG = "VsReporter";
    public static final String VS_JAR_VERSION = "vs_jar_version";
    public static final String VS_REP_BSGUID = "vs_bsguid";
    public static final String VS_REP_ECODE = "vs_ecode";
    public static final String VS_REP_PKG = "vs_pkgmame";
    public static final String VS_REP_PLAT = "vs_platform";
    public static final String VS_REP_QIMEI = "vs_qimei";
    public static final String VS_REP_SDT = "vs_sdtfrom";
    public static final String VS_REP_VSGUID = "vs_vsguid";
    public static final String VS_REP_VSKEY = "vs_vskey";
    public static final String VS_SO_VERSION = "vs_so_version";

    public static void propInit(Properties properties, String str, String str2, String str3, String str4, String str5) {
        if (str == null) {
            str = "nil";
        }
        properties.put(VS_REP_PLAT, str);
        if (str2 == null) {
            str2 = "nil";
        }
        properties.put(VS_REP_SDT, str2);
        if (str3 == null) {
            str3 = "nil";
        }
        properties.put(VS_REP_VSGUID, str3);
        if (str4 == null) {
            str4 = "nil";
        }
        properties.put(VS_REP_BSGUID, str4);
        if (str5 != null && !str5.isEmpty()) {
            properties.put(VS_REP_QIMEI, str5);
        } else {
            properties.put(VS_REP_QIMEI, "0");
        }
        CKeyFacade.instance();
        properties.put(VS_SO_VERSION, CKeyFacade.getSoVersion());
        CKeyFacade.instance();
        properties.put(VS_JAR_VERSION, CKeyFacade.getJarVersion());
        properties.put(GUARD_SO_VERSION, CKeyGuard.getSoVersion());
        properties.put(GUARD_JAR_VERSION, CKeyGuard.getJarVersion());
        properties.put("vs_uin", CKeyFacade.instance().getmUin());
        properties.put("vs_openid", CKeyFacade.instance().getmOpenID());
        properties.put("vs_vuid", CKeyFacade.instance().getmVuid());
        properties.put("vs_extinfo", CKeyFacade.instance().getmExtInfo());
    }

    public static void reportCKey(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8, String str9, String str10, long j3, String str11, String str12, String str13, String str14) {
        Properties requiredReportValue = CKeyBeaconReport.getRequiredReportValue();
        propInit(requiredReportValue, str, str2, str4, str5, str6);
        requiredReportValue.put("bs_platform", str8);
        requiredReportValue.put("bs_sdtfrom", str9);
        requiredReportValue.put("bs_vid", str10);
        requiredReportValue.put("bs_time", String.valueOf(j3));
        requiredReportValue.put("com/tencent/qqlive/ckey", str11);
        requiredReportValue.put("vs_caller", str12);
        requiredReportValue.put("bs_extinfo", str13);
        requiredReportValue.put("bs_guard", str14);
        CKeyBeaconReport.trackCustomKVEvent(context, "vs_ckey", requiredReportValue);
    }

    public static void reportInit(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7) {
        Properties requiredReportValue = CKeyBeaconReport.getRequiredReportValue();
        propInit(requiredReportValue, str, str2, str4, str5, str6);
        CKeyBeaconReport.trackCustomKVEvent(context, "vs_init", requiredReportValue);
    }

    public static void reportSign(Context context, String str, String str2, String str3, String str4, String str5, int i3) {
        Properties requiredReportValue = CKeyBeaconReport.getRequiredReportValue();
        propInit(requiredReportValue, str, str2, str3, str4, str5);
        requiredReportValue.put("bs_ts", String.valueOf(i3));
        CKeyBeaconReport.trackCustomKVEvent(context, "vs_taskenc", requiredReportValue);
    }

    public static void reportTaskEncrypt(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i3, int i16, int i17, int i18, int i19) {
        Properties requiredReportValue = CKeyBeaconReport.getRequiredReportValue();
        propInit(requiredReportValue, str, str2, str3, str4, str5);
        requiredReportValue.put("bs_seq", str6);
        requiredReportValue.put("bs_vid", str7);
        requiredReportValue.put("bs_omgid", str8);
        requiredReportValue.put("bs_guid", str9);
        requiredReportValue.put("bs_uin", str10);
        requiredReportValue.put("bs_type", String.valueOf(i3));
        requiredReportValue.put("bs_sys", String.valueOf(i16));
        requiredReportValue.put("bs_taskid", String.valueOf(i17));
        requiredReportValue.put("bs_ts", String.valueOf(i18));
        requiredReportValue.put("bs_rand", String.valueOf(i19));
        CKeyBeaconReport.trackCustomKVEvent(context, "vs_taskenc", requiredReportValue);
    }
}
