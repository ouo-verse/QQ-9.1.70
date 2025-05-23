package com.tencent.mobileqq.activity.aio;

import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ei;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
class AIOTimeReporter$1 implements Runnable {
    final /* synthetic */ e this$0;

    @Override // java.lang.Runnable
    public void run() {
        HashMap<String, String> hashMap;
        d b16 = d.b();
        e.c(null, b16.a());
        if (ei.f307722b <= 0) {
            e.d(null);
            return;
        }
        int b17 = e.b(null);
        String str = "";
        if (b17 != 1) {
            if (b17 != 2) {
                if (b17 != 3) {
                    return;
                }
                int i3 = b16.f178345a;
                if (i3 != 0) {
                    if (i3 == 1) {
                        str = !e.a(null).equalsIgnoreCase("0") ? e.f178644k : e.f178645l;
                    }
                } else {
                    str = !e.a(null).equalsIgnoreCase("0") ? e.f178642i : e.f178643j;
                }
            } else {
                int i16 = b16.f178345a;
                if (i16 != 0) {
                    if (i16 == 1) {
                        str = !e.a(null).equalsIgnoreCase("0") ? e.f178640g : e.f178641h;
                    }
                } else {
                    str = !e.a(null).equalsIgnoreCase("0") ? e.f178638e : e.f178639f;
                }
            }
        } else {
            int i17 = b16.f178345a;
            if (i17 != 0) {
                if (i17 == 1) {
                    str = !e.a(null).equalsIgnoreCase("0") ? e.f178636c : e.f178637d;
                }
            } else {
                str = !e.a(null).equalsIgnoreCase("0") ? e.f178634a : e.f178635b;
            }
        }
        if (HardCoderManager.getInstance().isSupported()) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("hcState", String.valueOf(HardCoderManager.getInstance().getState()));
            hashMap2.put("model", DeviceInfoMonitor.getModel());
            hashMap = hashMap2;
        } else {
            hashMap = null;
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, ei.f307722b, 0L, hashMap, "");
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.aio.AIOTimeReporter", 4, "reportAIOTime: " + str + " cost : " + ei.f307722b);
        }
        e.d(null);
    }
}
