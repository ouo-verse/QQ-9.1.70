package com.tencent.halley.downloader.e.a;

import android.os.SystemClock;
import com.tencent.halley.common.b.a.c;
import com.tencent.halley.common.b.a.f;
import com.tencent.halley.common.d.h;
import com.tencent.halley.common.utils.d;
import com.tencent.halley.common.utils.j;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    public static final void a(String str, long j3, com.tencent.halley.downloader.e.b bVar, int i3, boolean z16) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.tencent.halley.common.d.b.b.b.a aVar = new com.tencent.halley.common.d.b.b.b.a();
        aVar.f113489a = str;
        aVar.f113491c = j3;
        aVar.f113490b = z16 ? 1 : 0;
        com.tencent.halley.common.d.b.b.a aVar2 = new com.tencent.halley.common.d.b.b.a();
        aVar2.a("resScheduleInfo", aVar.a());
        d.a("halley-downloader-ResSchedulerHttp", "HttpResScheduler req:" + new String(aVar2.a()));
        c a16 = c.a("https://yun-hl.3g.qq.com/halleycloud", null, aVar2.a(), i3, j.h(), h.d().f());
        a16.f113309q = "res_sche";
        f b16 = a16.b();
        d.a("halley-downloader-ResSchedulerHttp", "HttpResScheduler rsp code:" + b16.f113322a + ",httpStatus:" + b16.f113324c);
        if (b16.f113324c == 200 && b16.f113322a == 0) {
            a(b16.f113325d, str, bVar);
        } else {
            bVar.a(str, b16.f113322a, b16.f113323b);
        }
        a16.f113296l = SystemClock.elapsedRealtime() - elapsedRealtime;
        a16.a(false);
        h.d().a(2);
    }

    private static void a(byte[] bArr, String str, com.tencent.halley.downloader.e.b bVar) {
        if (j.a(bArr)) {
            return;
        }
        try {
            String str2 = new String(bArr);
            JSONObject jSONObject = new JSONObject(str2);
            d.a("halley-downloader-ResSchedulerHttp", "HttpResScheduler rspData:".concat(str2));
            b bVar2 = new b(jSONObject.optJSONObject("ResDispatch"), str);
            if (bVar2.f113725a) {
                bVar.a(str, bVar2);
            } else {
                bVar.a(str, -1, "client parse json data failed");
            }
        } catch (Throwable th5) {
            bVar.a(str, -1, "server push json data failed");
            th5.printStackTrace();
        }
    }
}
