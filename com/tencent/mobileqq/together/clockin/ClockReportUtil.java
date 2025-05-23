package com.tencent.mobileqq.together.clockin;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.ReportMethodProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ClockReportUtil {
    static {
        UserAction.registerTunnel(new TunnelInfo("0AND07OPTZ3OVEUJ"));
    }

    public static void a(final String str, final HashMap<String, String> hashMap) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.together.clockin.ClockReportUtil.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ReportMethodProxy.onUserActionToTunnel("0AND07OPTZ3OVEUJ", str, true, -1L, -1L, hashMap, true, true);
                } catch (Throwable th5) {
                    QLog.e("ClockReportUtil", 1, th5, new Object[0]);
                }
            }
        }, 128, null, true);
    }
}
