package com.tencent.hippykotlin.demo.pages.nearby.base.utils;

import java.util.Iterator;
import r25.b;
import r25.c;
import s35.af;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class StrangerUtilsKt {
    public static final String getAvatarDressFrameUrl(af afVar) {
        Object obj;
        c cVar;
        String str;
        Iterator<T> it = afVar.f433210f0.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((b) obj).f430598d == 1001) {
                break;
            }
        }
        b bVar = (b) obj;
        return (bVar == null || (cVar = bVar.f430600f) == null || (str = cVar.f430604h) == null) ? "" : str;
    }

    public static final String getUserId(af afVar, int i3) {
        if (i3 == 1) {
            return afVar.f433205d;
        }
        if (i3 != 2) {
            return String.valueOf(afVar.f433207e);
        }
        return String.valueOf(afVar.f433207e);
    }
}
