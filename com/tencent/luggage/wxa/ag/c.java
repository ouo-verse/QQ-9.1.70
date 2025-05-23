package com.tencent.luggage.wxa.ag;

import com.tencent.luggage.wxa.ag.b;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static b.a a(com.tencent.luggage.wxa.xa.h hVar) {
        com.tencent.luggage.wxa.xa.h c16 = hVar.c("pictureInPictureInitPosition");
        if (c16 == null) {
            return null;
        }
        b.a aVar = new b.a();
        aVar.f121391a = !c16.optString("alignment", "right").equals("left");
        double optDouble = c16.optDouble("y", 1.0d);
        aVar.f121392b = optDouble;
        if (optDouble < 0.0d || optDouble > 1.0d) {
            aVar.f121392b = 1.0d;
        }
        return aVar;
    }

    public static b.EnumC6005b b(com.tencent.luggage.wxa.xa.h hVar) {
        String optString = hVar.optString("pictureInPictureMode", null);
        if (optString == null) {
            return null;
        }
        return b.EnumC6005b.a(optString);
    }

    public static Boolean c(com.tencent.luggage.wxa.xa.h hVar) {
        if (hVar.has("pictureInPictureShowProgress")) {
            return Boolean.valueOf(hVar.optBoolean("pictureInPictureShowProgress", false));
        }
        return null;
    }
}
