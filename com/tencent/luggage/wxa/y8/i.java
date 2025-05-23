package com.tencent.luggage.wxa.y8;

import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class i {
    public static String a(String str, boolean z16) {
        try {
            String b16 = x.b(str, z16);
            if (b16 != null) {
                w.d("MicroMsg.VFSFileOpEx", "exportExternalPath:%s to realPath:%s", str, b16);
                return b16;
            }
            return str;
        } catch (Throwable th5) {
            w.a("MicroMsg.VFSFileOpEx", th5, "exportExternalPath failed", new Object[0]);
            return str;
        }
    }
}
