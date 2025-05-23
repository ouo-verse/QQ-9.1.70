package com.tencent.ads.monitor.a;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ads.data.AdItem;
import com.tencent.ads.monitor.AdMonitor;
import com.tencent.ads.monitor.PingService;
import com.tencent.ads.monitor.b;
import com.tencent.ads.monitor.e;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f61667a = "AdStepPing";

    private static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        int indexOf = str.indexOf("&l=");
        if (indexOf < 0) {
            indexOf = str.indexOf("?l=");
        }
        if (indexOf < 0) {
            return str;
        }
        int indexOf2 = str.indexOf(ContainerUtils.FIELD_DELIMITER, indexOf + 1);
        if (indexOf2 < 0) {
            return String.valueOf(str.substring(0, indexOf + 3)) + str2;
        }
        return String.valueOf(str.substring(0, indexOf + 3)) + str2 + str.substring(indexOf2);
    }

    private static void b(AdMonitor adMonitor, AdItem adItem, int i3) {
        Log.d(f61667a, "doStepPing: " + i3);
        if (i3 > 0 && adMonitor != null) {
            if (i3 != 200 && i3 != 201) {
                if (i3 != 207) {
                    if (i3 != 208 && i3 != 300) {
                        if (i3 == 301) {
                            a(adMonitor, adItem, i3);
                            return;
                        } else if (i3 != 605) {
                            switch (i3) {
                                case 203:
                                case 205:
                                    break;
                                case 204:
                                    break;
                                default:
                                    return;
                            }
                        }
                    }
                }
                if (adMonitor.getCurrentAdItemIndex() != 0) {
                    return;
                }
            }
            a(adMonitor, adItem, i3);
        }
    }

    public static void a(AdMonitor adMonitor, AdItem adItem, int i3) {
        Log.d(f61667a, "Step200: " + i3);
        if (adItem == null || adMonitor == null) {
            return;
        }
        Map a16 = b.a(adMonitor, adItem.getLcount());
        a16.put("t", "0");
        a16.put("step", "200");
        a16.put("l", String.valueOf(i3));
        a16.put("real_adid", adMonitor.getAId());
        e eVar = new e();
        eVar.i();
        String a17 = adItem.getReportItem().a();
        String valueOf = String.valueOf(i3);
        if (!TextUtils.isEmpty(a17) && !TextUtils.isEmpty(valueOf)) {
            int indexOf = a17.indexOf("&l=");
            if (indexOf < 0) {
                indexOf = a17.indexOf("?l=");
            }
            if (indexOf >= 0) {
                int indexOf2 = a17.indexOf(ContainerUtils.FIELD_DELIMITER, indexOf + 1);
                if (indexOf2 < 0) {
                    a17 = String.valueOf(a17.substring(0, indexOf + 3)) + valueOf;
                } else {
                    a17 = String.valueOf(a17.substring(0, indexOf + 3)) + valueOf + a17.substring(indexOf2);
                }
            }
        }
        eVar.a(a17);
        eVar.d(adMonitor.getRequestId());
        eVar.a(a16);
        eVar.l();
        PingService.getInstance().doPing(eVar);
    }
}
