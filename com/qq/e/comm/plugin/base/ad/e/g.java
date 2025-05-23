package com.qq.e.comm.plugin.base.ad.e;

import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.e.b;
import com.qq.e.comm.plugin.k.af;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g {
    public static void a(String str, int i3, com.qq.e.comm.plugin.base.ad.model.f fVar, com.qq.e.comm.plugin.base.ad.model.a aVar, String str2, b.a aVar2) {
        if (fVar == null) {
            return;
        }
        b.a(str, i3, str2, aVar, aVar2);
    }

    public static void a(View view, com.qq.e.comm.plugin.base.ad.model.f fVar, String str, ClickInfo.e eVar, int i3, int i16) {
        a(view, fVar, str, eVar, i3, i16, null);
    }

    public static void a(View view, com.qq.e.comm.plugin.base.ad.model.f fVar, String str, ClickInfo.e eVar, int i3, int i16, com.qq.e.comm.plugin.base.adevent.a aVar) {
        com.qq.e.comm.plugin.base.ad.clickcomponent.e eVar2 = new com.qq.e.comm.plugin.base.ad.clickcomponent.e(new WeakReference(view));
        eVar2.a(str);
        eVar2.a(i3);
        eVar2.b(i16);
        eVar2.a(aVar);
        ClickInfo.c cVar = new ClickInfo.c(fVar.u(), fVar.t(), fVar.s());
        com.qq.e.comm.plugin.base.ad.clickcomponent.c.a(new ClickInfo.b().a(fVar).a(cVar).a(eVar2).a(eVar).a(com.qq.e.comm.plugin.j.c.a(fVar.s(), Constants.KEYS.DOWNLOAD_CONFIRM, 0)).a());
    }

    public static void a(ClickInfo clickInfo) {
        com.qq.e.comm.plugin.base.ad.clickcomponent.c.a(clickInfo);
    }

    public static void a(com.qq.e.comm.plugin.base.ad.model.f fVar) {
        String q16 = fVar.q();
        if (TextUtils.isEmpty(q16)) {
            com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
            bVar.a(fVar.s()).b(fVar.f()).c(fVar.y());
            cVar.a("posId", fVar.s());
            StatTracer.trackEvent(60502, 0, bVar, cVar);
            return;
        }
        af.a(com.qq.e.comm.plugin.k.b.b(q16));
    }

    public static String a(String str, long j3) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis() - j3;
        GDTLogger.d("play exposure diff = " + currentTimeMillis);
        return str.replace("__TIME_DIFF__", String.valueOf(currentTimeMillis));
    }
}
