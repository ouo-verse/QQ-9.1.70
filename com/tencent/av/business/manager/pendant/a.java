package com.tencent.av.business.manager.pendant;

import com.tencent.avcore.util.AVCoreLog;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import java.math.BigDecimal;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static void a() {
        long j3;
        int i3;
        try {
            HashMap hashMap = new HashMap();
            boolean m3 = ea.m();
            int[] l3 = ea.l();
            long n3 = ea.n();
            if (!m3 && l3[1] <= 0) {
                CapturePtvTemplateManager.e().h(false);
                ea.z2();
            }
            if (n3 > 0) {
                j3 = (System.currentTimeMillis() - n3) / 1000;
            } else {
                j3 = -1;
            }
            int i16 = l3[0];
            if ((i16 <= 0 && l3[1] <= 0) || i16 > (i3 = l3[1])) {
                return;
            }
            BigDecimal bigDecimal = new BigDecimal((i16 * 1.0f) / i3);
            hashMap.put("filter_download", String.valueOf(l3[0]));
            hashMap.put("filter_total", String.valueOf(l3[1]));
            hashMap.put("filter_ratio", String.valueOf(bigDecimal.setScale(2, 4).floatValue()));
            hashMap.put("filter_spacing", String.valueOf(j3));
            if (QLog.isColorLevel()) {
                QLog.d("DailyReport", 2, "reportAVPendantDownloadInfo filter_download = " + l3[0] + ",filter_total = " + l3[1] + ",filter_spacing" + j3);
            }
            boolean onUserAction = UserAction.onUserAction("AVFunChatExpression", true, -1L, -1L, hashMap, true);
            UserAction.flushObjectsToDB(true);
            AVCoreLog.printColorLog("AVEffectPendantReport", "reportAVPendantDownloadInfo, filter_download[" + ((String) hashMap.get("filter_download")) + "], filter_total[" + ((String) hashMap.get("filter_total")) + "],filter_total[" + ((String) hashMap.get("filter_ratio")) + "],filter_ratio[" + ((String) hashMap.get("filter_spacing")) + "], lastUserTime = " + n3 + "    ret[" + onUserAction + "]");
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("AVEffectPendantReport", 2, "reportAVPendantDownloadInfo", th5);
            }
        }
    }
}
