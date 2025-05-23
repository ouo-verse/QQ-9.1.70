package com.qq.e.comm.plugin.base.ad.clickcomponent.a;

import android.text.TextUtils;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.a.a;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: c, reason: collision with root package name */
    private final Object f38533c;

    /* renamed from: d, reason: collision with root package name */
    private String f38534d;

    public c(String str) {
        super(str);
        this.f38533c = new Object();
    }

    private JSONObject b(final ClickInfo clickInfo) {
        JSONObject jSONObject;
        Throwable th5;
        final Exchanger exchanger = new Exchanger();
        a(new a.InterfaceC0279a() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.a.c.1
            @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.a.a.InterfaceC0279a
            public void a(int i3, JSONObject jSONObject2) {
                if (i3 != 200 && i3 != 302) {
                    com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(clickInfo, -6, "DownloadCgi", -5001);
                }
                try {
                    GDTLogger.d("click cgi call back " + jSONObject2);
                    exchanger.exchange(jSONObject2, 4000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th6) {
                    GDTLogger.e("[getPkgUrlADSync]", th6);
                }
                ClickInfo clickInfo2 = clickInfo;
                StatTracer.instantReport(clickInfo2 == null ? null : clickInfo2.n());
            }

            @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.a.a.InterfaceC0279a
            public void a(Exception exc) {
                com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(clickInfo, -6, "DownloadCgi", -3001);
            }
        });
        a(this.f38525a);
        try {
            jSONObject = (JSONObject) exchanger.exchange(null, 4000L, TimeUnit.MILLISECONDS);
        } catch (Throwable th6) {
            jSONObject = null;
            th5 = th6;
        }
        try {
            GDTLogger.d("[getPkgUrlADSync] exchange over ");
        } catch (Throwable th7) {
            th5 = th7;
            GDTLogger.e("[getPkgUrlADSync] exchange over ", th5);
            return jSONObject;
        }
        return jSONObject;
    }

    public String a(ClickInfo clickInfo) {
        if (TextUtils.isEmpty(this.f38525a)) {
            return null;
        }
        synchronized (this.f38533c) {
            try {
                if (!TextUtils.isEmpty(this.f38534d)) {
                    return this.f38534d;
                }
                String e16 = y.e(b(clickInfo), "apkUrl");
                this.f38534d = e16;
                return e16;
            } catch (Throwable th5) {
                GDTLogger.e("[getResult] ", th5);
                return null;
            }
        }
    }
}
