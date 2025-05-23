package com.tencent.gamecenter.wadl.sdk.downloader.d.d;

import com.tencent.gamecenter.wadl.sdk.common.c.b.f;
import com.tencent.gamecenter.wadl.sdk.common.d.h;
import com.tencent.gamecenter.wadl.sdk.common.d.k.b.e.d;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {
    public static final void a(String str, long j3, com.tencent.gamecenter.wadl.sdk.downloader.d.b bVar, int i3, boolean z16) {
        com.tencent.gamecenter.wadl.sdk.common.d.k.b.a aVar = new com.tencent.gamecenter.wadl.sdk.common.d.k.b.a();
        d dVar = new d();
        dVar.f107217a = str;
        dVar.f107219c = j3;
        dVar.f107218b = z16 ? 1 : 0;
        aVar.a("resScheduleInfo", dVar.a());
        com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-downloader-ResSchedulerHttp", "HttpResScheduler req:" + new String(aVar.a()));
        f c16 = com.tencent.gamecenter.wadl.sdk.common.c.b.d.a("https://yun-hl.3g.qq.com/halleycloud", false, null, aVar.a(), i3, g.a(), false).c();
        com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-downloader-ResSchedulerHttp", "HttpResScheduler rsp code:" + c16.f107097a + ",httpStatus:" + c16.f107099c);
        if (c16.f107099c == 200 && c16.f107097a == 0) {
            byte[] bArr = c16.f107100d;
            if (!g.a(bArr)) {
                try {
                    String str2 = new String(bArr);
                    JSONObject jSONObject = new JSONObject(str2);
                    com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-downloader-ResSchedulerHttp", "HttpResScheduler rspData:" + str2);
                    b bVar2 = new b(jSONObject.optJSONObject("ResDispatch"), str);
                    if (bVar2.f107368a) {
                        bVar.a(str, bVar2.f107376i, bVar2.f107370c, bVar2.f107371d, bVar2.f107372e, bVar2.f107375h, bVar2.f107373f, bVar2.f107377j);
                    } else {
                        bVar.a(str, -1, "client parse json data failed");
                    }
                } catch (Throwable th5) {
                    bVar.a(str, -1, "server push json data failed");
                    th5.printStackTrace();
                }
            }
        } else {
            bVar.a(str, c16.f107097a, c16.f107098b);
        }
        h.e().a(2);
    }
}
