package com.tencent.comic.webbundle;

import android.os.Build;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tenpay.proxy.dlg.location.QbAddrData;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WebBundleReportUtils {

    /* renamed from: a, reason: collision with root package name */
    public static String f99493a = "0";

    /* renamed from: b, reason: collision with root package name */
    public static String f99494b = "1";

    /* renamed from: c, reason: collision with root package name */
    public static String f99495c = "3";

    /* renamed from: d, reason: collision with root package name */
    public static String f99496d = "4";

    public static void a(final String str, final String str2, final int i3, final int i16, final int i17, final int i18, final String str3, final String str4, final String str5, final String str6) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.comic.webbundle.WebBundleReportUtils.1
            @Override // java.lang.Runnable
            public void run() {
                String str7;
                String str8 = Build.BRAND;
                String str9 = "";
                if (str8 == null) {
                    str8 = "";
                }
                if (DeviceInfoMonitor.getModel() == null) {
                    str7 = "";
                } else {
                    str7 = Build.BOARD;
                }
                String str10 = Build.VERSION.RELEASE;
                if (str10 == null) {
                    str10 = "";
                }
                int netWorkType = HttpUtil.getNetWorkType();
                if (netWorkType == -1) {
                    str9 = " UNKNOWN";
                } else if (netWorkType == 1) {
                    str9 = Global.TRACKING_WIFI;
                } else if (netWorkType == 2) {
                    str9 = "2G";
                } else if (netWorkType == 3) {
                    str9 = "3G";
                } else if (netWorkType == 4) {
                    str9 = "4G";
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str8);
                stringBuffer.append(QbAddrData.DATA_SPLITER);
                stringBuffer.append(str7);
                stringBuffer.append(QbAddrData.DATA_SPLITER);
                stringBuffer.append(str10);
                stringBuffer.append(QbAddrData.DATA_SPLITER);
                stringBuffer.append(str9);
                stringBuffer.append(QbAddrData.DATA_SPLITER);
                stringBuffer.append(str);
                stringBuffer.append(QbAddrData.DATA_SPLITER);
                stringBuffer.append(str2);
                stringBuffer.append(QbAddrData.DATA_SPLITER);
                stringBuffer.append(i3);
                stringBuffer.append(QbAddrData.DATA_SPLITER);
                stringBuffer.append(i16);
                stringBuffer.append(QbAddrData.DATA_SPLITER);
                stringBuffer.append(i17);
                stringBuffer.append(QbAddrData.DATA_SPLITER);
                stringBuffer.append(i18);
                stringBuffer.append(QbAddrData.DATA_SPLITER);
                stringBuffer.append(str3);
                stringBuffer.append(QbAddrData.DATA_SPLITER);
                stringBuffer.append(str4);
                stringBuffer.append(QbAddrData.DATA_SPLITER);
                stringBuffer.append(str5);
                stringBuffer.append(QbAddrData.DATA_SPLITER);
                stringBuffer.append(str6);
                DcReportUtil.c(null, "sendtdbank|b_sng_qqvip_sng_qq_comic|sng_mobileqq_times_statistics", stringBuffer.toString(), true);
            }
        }, 5, null, false);
    }

    public static void b(String str, boolean z16, String str2) {
        String str3;
        if (z16) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        a("hybrid", "webBundle_open", 0, 0, 0, 0, str, str3, str2, "");
    }
}
