package com.tencent.av;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoSocketReconnectReporter {
    public static void a() {
        final int i3 = com.tencent.av.ui.funchat.record.e.a().f75884p;
        final int a16 = com.tencent.biz.common.util.g.a(BaseApplication.getContext());
        if (QLog.isColorLevel()) {
            QLog.d("VideoSocketReconnectReporter", 2, String.format("reportSocketReconRequest policyType=%s netType=%s", Integer.valueOf(i3), Integer.valueOf(a16)));
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.VideoSocketReconnectReporter.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("policy_type", String.valueOf(i3));
                hashMap.put("net_type", String.valueOf(a16));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "av_socket_recon_request2", true, 0L, 0L, hashMap, "");
            }
        }, 5, null, false);
    }

    public static void b(final long j3) {
        final int i3 = com.tencent.av.ui.funchat.record.e.a().f75884p;
        final int a16 = com.tencent.biz.common.util.g.a(BaseApplication.getContext());
        if (QLog.isColorLevel()) {
            QLog.d("VideoSocketReconnectReporter", 2, String.format("reportSocketReconResult policyType=%s netType=%s timeCost=%s", Integer.valueOf(i3), Integer.valueOf(a16), Long.valueOf(j3)));
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.VideoSocketReconnectReporter.2
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("policy_type", String.valueOf(i3));
                hashMap.put("net_type", String.valueOf(a16));
                hashMap.put("time_cost", String.valueOf(j3));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "av_socket_recon_result2", true, 0L, 0L, hashMap, "");
            }
        }, 5, null, false);
    }
}
