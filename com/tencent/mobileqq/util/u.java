package com.tencent.mobileqq.util;

import com.tencent.mobileqq.app.identity.IDelayReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes20.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, HashMap<String, String>> f306796a;

    public static synchronized boolean a() {
        synchronized (u.class) {
            Map<String, HashMap<String, String>> map = f306796a;
            boolean z16 = false;
            if (map == null) {
                return false;
            }
            Set<String> keySet = map.keySet();
            if (keySet != null) {
                if (!keySet.isEmpty()) {
                    z16 = true;
                }
            }
            return z16;
        }
    }

    public static synchronized void b(List<IDelayReporter> list) {
        boolean z16;
        synchronized (u.class) {
            Map<String, HashMap<String, String>> map = f306796a;
            if (map == null) {
                return;
            }
            for (String str : map.keySet()) {
                HashMap<String, String> hashMap = f306796a.get(str);
                Iterator<IDelayReporter> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().processReport(str, hashMap)) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    QLog.e("DelayReportUtils", 1, "no reporter for this event : ", str);
                }
            }
            f306796a.clear();
            f306796a = null;
        }
    }
}
