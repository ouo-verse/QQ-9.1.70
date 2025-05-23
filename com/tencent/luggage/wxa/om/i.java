package com.tencent.luggage.wxa.om;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {
    public static boolean a(String str) {
        e.d(g.e(str));
        w.b("MicroMsg.Audio.IndexBitMgr", "isQQAudioCacheValid pMusic is null!'");
        return false;
    }

    public static boolean b(String str) {
        if (h.d(str) && h.e(str) > 0) {
            return true;
        }
        return false;
    }
}
