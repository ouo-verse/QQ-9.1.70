package com.tencent.luggage.wxa.aa;

import com.tencent.luggage.wxa.tn.w;
import java.io.File;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static boolean a() {
        try {
            return new File(com.tencent.luggage.wxa.db.a.l()).canWrite();
        } catch (Exception e16) {
            w.a("MicroMsg.CUtil", e16, "summer isSDCardAvail 1 e: " + e16.getMessage() + " SDCARD_ROOT: " + com.tencent.luggage.wxa.db.a.l(), new Object[0]);
            return false;
        }
    }
}
