package com.tencent.luggage.wxa.wm;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qm.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static boolean a(int i3) {
        if (i3 != 0 && i3 != 1 && i3 != 4 && i3 != 5 && i3 != 14) {
            switch (i3) {
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                    break;
                default:
                    com.tencent.luggage.wxa.qm.b h16 = k.h();
                    return h16 != null && h16.f(i3);
            }
        }
        return true;
    }

    public static boolean a(com.tencent.luggage.wxa.rb.d dVar) {
        if (dVar == null || TextUtils.isEmpty(dVar.L)) {
            return false;
        }
        w.a("MicroMsg.Music.MusicPlayerSupport", "protocol:%s", dVar.L);
        return TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_HLS.equalsIgnoreCase(dVar.L);
    }
}
