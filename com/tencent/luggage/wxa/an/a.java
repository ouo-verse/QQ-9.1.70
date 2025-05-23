package com.tencent.luggage.wxa.an;

import android.app.Activity;
import android.os.Handler;
import com.tencent.luggage.wxa.bn.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum a {
    IML;

    public c a(Activity activity, com.tencent.luggage.wxa.bn.c cVar, d dVar, Handler handler) {
        if (cVar != null && dVar != null) {
            if ((cVar.c() & 1) != 0 && com.tencent.luggage.wxa.jp.a.b(z.c())) {
                return new b(new WeakReference(activity), cVar, dVar, handler);
            }
            w.b("MicroMsg.SoterControllerFactory", "hy: no matching: %d", Byte.valueOf(cVar.c()));
            return null;
        }
        w.b("MicroMsg.SoterControllerFactory", "hy: reqmodel or resp model is null");
        return null;
    }
}
