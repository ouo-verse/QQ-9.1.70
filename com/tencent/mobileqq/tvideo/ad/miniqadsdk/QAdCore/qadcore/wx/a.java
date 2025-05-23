package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx;

import com.tencent.qqlive.ona.protocol.jce.AdOpenMiniProgramItem;
import com.tencent.qqlive.ona.protocol.jce.AdUrlItem;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    public static d a(AdOpenMiniProgramItem adOpenMiniProgramItem, String str) {
        return b(adOpenMiniProgramItem, str, 0);
    }

    public static d b(AdOpenMiniProgramItem adOpenMiniProgramItem, String str, int i3) {
        if (adOpenMiniProgramItem == null) {
            return null;
        }
        String a16 = b.a("MiniProgram".equals(str), adOpenMiniProgramItem.token, adOpenMiniProgramItem.adTraceData, null);
        d dVar = new d();
        dVar.c(str);
        f fVar = new f();
        String str2 = "";
        fVar.i("");
        fVar.h(adOpenMiniProgramItem.appName);
        AdUrlItem adUrlItem = adOpenMiniProgramItem.urlItem;
        if (adUrlItem != null) {
            str2 = adUrlItem.url;
        }
        fVar.g(str2);
        fVar.f(i3);
        fVar.e(a16);
        dVar.d(fVar);
        return dVar;
    }
}
