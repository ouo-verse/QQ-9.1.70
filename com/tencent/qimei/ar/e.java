package com.tencent.qimei.ar;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qimei.ai.i;
import com.tencent.qimei.as.a;
import com.tencent.qimei.foundation.net.protocol.CMD;
import com.tencent.qimei.sdk.QimeiSDK;
import com.tencent.qimei.uin.U;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final String f343102a;

    /* renamed from: c, reason: collision with root package name */
    public final c f343104c;

    /* renamed from: b, reason: collision with root package name */
    public volatile AtomicBoolean f343103b = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public f f343105d = null;

    public e(c cVar, String str) {
        this.f343104c = cVar;
        this.f343102a = str;
    }

    public void a(String str, boolean z16) {
        try {
            d.f343101a.put(this.f343102a, str);
            if (z16) {
                String str2 = this.f343102a;
                Integer num = com.tencent.qimei.ag.c.f342971c;
                QimeiSDK.getInstance(str2).getQimei(new com.tencent.qimei.ag.b(str2, str));
                com.tencent.qimei.aa.f b16 = com.tencent.qimei.aa.f.b(this.f343102a);
                try {
                    str = Base64.encodeToString(com.tencent.qimei.f.a.a(str.getBytes("UTF-8"), com.tencent.qimei.f.a.a("s_d").getBytes("UTF-8"), 1), 2);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                b16.a("s_d", str);
                com.tencent.qimei.aa.f.b(this.f343102a).a("s_s_t", System.currentTimeMillis());
            }
        } catch (Throwable th5) {
            com.tencent.qimei.ad.c.a(th5);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        this.f343103b.set(true);
        String str2 = this.f343102a;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("1", a.c.J.a(d.a(a.a(str2).f343094b.f343146r)));
            str = jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            com.tencent.qimei.ad.c.a("STRATEGY", "The parameter to get QM strategy is empty,cancel reqpuest", new Object[0]);
            a();
        }
        String str3 = this.f343102a;
        CMD cmd = CMD.QM_SETTING;
        com.tencent.qimei.x.c cVar = new com.tencent.qimei.x.c(U.a(str3, cmd.b(), str, cmd.a()));
        if (cVar.c()) {
            try {
                a(cVar.a(), true);
                c cVar2 = this.f343104c;
                cVar2.getClass();
                synchronized (c.f343097e) {
                    cVar2.f343100c = true;
                }
                a();
            } catch (Throwable th5) {
                com.tencent.qimei.ad.c.a(th5);
            }
            com.tencent.qimei.ad.c.b("STRATEGY", "query strategy success", new Object[0]);
            return;
        }
        a();
        com.tencent.qimei.ad.c.a("STRATEGY", "query strategy failed,response err code is %s", cVar.b());
    }

    public final void a() {
        com.tencent.qimei.t.a.a().a(TimeUnit.MILLISECONDS.convert(1L, TimeUnit.DAYS), this);
        f fVar = this.f343105d;
        if (fVar != null) {
            com.tencent.qimei.ai.e eVar = (com.tencent.qimei.ai.e) fVar;
            eVar.getQimei(new i(eVar));
        }
        this.f343103b.set(false);
    }
}
