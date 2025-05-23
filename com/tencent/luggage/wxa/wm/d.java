package com.tencent.luggage.wxa.wm;

import android.text.TextUtils;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.om.g;
import com.tencent.luggage.wxa.om.i;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {
    public static void a(com.tencent.luggage.wxa.rb.d dVar) {
        if (dVar == null) {
            w.b("MicroMsg.Music.MusicUrlParser", "GetShakeMusicUrl, musicWrapper is null");
            return;
        }
        boolean l3 = h0.l(z.c());
        boolean k3 = h0.k(z.c());
        com.tencent.luggage.wxa.dn.a aVar = new com.tencent.luggage.wxa.dn.a();
        String str = w0.c(dVar.f139447i) ? dVar.f139449k : dVar.f139447i;
        String str2 = dVar.f139448j;
        String a16 = e.a(str, str2, l3, aVar);
        w.d("MicroMsg.Music.MusicUrlParser", "parsePlayUrl mSrc:%s", a16);
        w.d("MicroMsg.Music.MusicUrlParser", "songWifiUrl:%s", dVar.f139447i);
        w.d("MicroMsg.Music.MusicUrlParser", "isWifi:%d, isQQMusic:%d", Integer.valueOf(l3 ? 1 : 0), Integer.valueOf(aVar.f124395a ? 1 : 0));
        boolean z16 = l3 ? aVar.f124395a : false;
        if (!k3) {
            w.d("MicroMsg.Music.MusicUrlParser", "isNetConnected false, detect right Url to play");
            String a17 = e.a(str, str2, true, aVar);
            String a18 = e.a(str, str2, false, aVar);
            if ((a17 == null || !a17.equals(a18)) && !c.a(dVar)) {
                if (c.a(dVar.f139439a)) {
                    w.d("MicroMsg.Music.MusicUrlParser", "use qqMusicPlayer");
                    if (!a(a17)) {
                        if (a(a18)) {
                            a17 = a18;
                        }
                    }
                } else {
                    if (!a(dVar, true)) {
                        a17 = a(dVar, false) ? a18 : "";
                    }
                    w.d("MicroMsg.Music.MusicUrlParser", "use musicPlayer");
                }
                if (!TextUtils.isEmpty(a17) && !a17.equals(a16)) {
                    w.d("MicroMsg.Music.MusicUrlParser", "reset the mSrc :%s", a17);
                    a16 = a17;
                }
            }
            a17 = "";
            if (!TextUtils.isEmpty(a17)) {
                w.d("MicroMsg.Music.MusicUrlParser", "reset the mSrc :%s", a17);
                a16 = a17;
            }
        }
        dVar.T = a16;
        g.a(a16, z16);
    }

    public static boolean a(String str) {
        return i.b(str);
    }

    public static boolean a(com.tencent.luggage.wxa.rb.d dVar, boolean z16) {
        v vVar = new v(b.a(b.a(dVar), z16));
        return vVar.e() && vVar.s() > 0;
    }
}
