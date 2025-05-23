package com.qq.e.comm.plugin.base.ad.clickcomponent.a;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.a.a;
import com.qq.e.comm.plugin.k.ay;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: c, reason: collision with root package name */
    private final Object f38528c;

    /* renamed from: d, reason: collision with root package name */
    private Pair<String, String> f38529d;

    public b(String str) {
        super(str);
        this.f38528c = new Object();
    }

    private JSONObject b(final ClickInfo clickInfo) {
        JSONObject jSONObject;
        Throwable th5;
        String c16 = ay.c(this.f38525a, "acttype", "1");
        final Exchanger exchanger = new Exchanger();
        com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_START, clickInfo, 1, 0);
        a(new a.InterfaceC0279a() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.a.b.1
            @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.a.a.InterfaceC0279a
            public void a(int i3, JSONObject jSONObject2) {
                if (i3 != 200 && i3 != 302) {
                    com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_FAILED, clickInfo, 1, i3);
                } else {
                    com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_SUCCESS, clickInfo, 1, i3);
                }
                try {
                    GDTLogger.d("click cgi call back " + jSONObject2);
                    exchanger.exchange(jSONObject2, 4000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
                ClickInfo clickInfo2 = clickInfo;
                StatTracer.instantReport(clickInfo2 == null ? null : clickInfo2.n());
            }

            @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.a.a.InterfaceC0279a
            public void a(Exception exc) {
                com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_FAILED, clickInfo, 1, 0);
                ClickInfo clickInfo2 = clickInfo;
                StatTracer.instantReport(clickInfo2 == null ? null : clickInfo2.n());
            }
        });
        a(c16);
        try {
            jSONObject = (JSONObject) exchanger.exchange(null, 4000L, TimeUnit.MILLISECONDS);
        } catch (Throwable th6) {
            jSONObject = null;
            th5 = th6;
        }
        try {
            GDTLogger.d("click cgi call back exchange over ");
        } catch (Throwable th7) {
            th5 = th7;
            th5.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.a.a
    public void a() {
        a(ay.c(this.f38525a, "rsptype", "1"));
    }

    public Pair<String, String> a(ClickInfo clickInfo) {
        if (TextUtils.isEmpty(this.f38525a)) {
            return null;
        }
        synchronized (this.f38528c) {
            Pair<String, String> pair = this.f38529d;
            if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first)) {
                return this.f38529d;
            }
            try {
                JSONObject b16 = b(clickInfo);
                if (y.a(b16) && b16.opt("data") != null) {
                    GDTLogger.d("click cgi jsonResult " + b16);
                    JSONObject jSONObject = new JSONObject(b16.opt("data").toString());
                    Pair<String, String> pair2 = new Pair<>(jSONObject.optString("clickid"), jSONObject.optString("dstlink"));
                    this.f38529d = pair2;
                    return pair2;
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            return null;
        }
    }
}
