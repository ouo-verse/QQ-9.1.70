package com.tencent.mobileqq.utils;

import android.util.Log;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ej {
    public static boolean a() {
        return ei.f307721a.containsKey("AIO_Start_cost");
    }

    public static final void b(String str, String str2) {
        long b16 = ei.b(str, str2);
        if (b16 != -1) {
            StringBuilder P = com.tencent.mobileqq.activity.aio.l.P();
            P.append(str);
            P.append(", cost=");
            P.append(b16);
            P.append("|");
            P.append(ChatFragment.F);
            P.append("|");
            P.append(com.tencent.mobileqq.activity.aio.c.f178325h);
            String sb5 = P.toString();
            if (QLog.isColorLevel()) {
                QLog.i("AutoMonitor", 2, sb5);
            } else {
                Log.i("AutoMonitor", sb5);
            }
        }
    }
}
