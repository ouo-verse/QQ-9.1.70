package com.tencent.luggage.wxa.fd;

import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class m0 {
    public static boolean a(n0 n0Var) {
        if (w0.c(n0Var.f138467f)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaAttrSyncUtils", "invalid appID in contact(%s)", n0Var.f138465d);
            return true;
        }
        if (n0Var.h() == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaAttrSyncUtils", "NULL versionInfo(%s) in contact(%s)", n0Var.B, n0Var.f138465d);
            return true;
        }
        if (n0Var.f() != null && !TextUtils.isEmpty(n0Var.f().f125866d)) {
            if (n0Var.h().f125922c != 0 || n0Var.h().f125920a > 0) {
                return false;
            }
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaAttrSyncUtils", "invalid versionInfo(%s) in contact(%s)", n0Var.B, n0Var.f138465d);
            return true;
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaAttrSyncUtils", "invalid appInfo(%s) in contact(%s)", n0Var.f138487z, n0Var.f138465d);
        return true;
    }

    public static boolean b(n0 n0Var) {
        try {
            long a16 = com.tencent.luggage.wxa.pc.c.f137487a.a(n0Var.f138465d);
            if (a16 <= 0 || a16 < n0Var.N) {
                return false;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.WxaAttrSyncUtils", "isContactMarkedAsInvalid (%s) returns true, treated as invalid until %d, attrs lastSyncTimestamp %d", n0Var.f138465d, Long.valueOf(a16), Long.valueOf(n0Var.N));
            return true;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.WxaAttrSyncUtils", e16, "caught crash", new Object[0]);
            return false;
        }
    }
}
