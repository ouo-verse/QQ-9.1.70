package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.luggage.wxa.c5.e;
import com.tencent.luggage.wxa.p5.f;
import com.tencent.luggage.wxa.tc.c;
import com.tencent.luggage.wxa.tc.h;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AppBrandOnBackgroundFetchDataEvent extends p {
    private static final int CTRL_INDEX = 523;
    private static final String NAME = "onBackgroundFetchData";

    public static void a(final e eVar) {
        final String appId = eVar.getAppId();
        new IListener<h>(eVar.T()) { // from class: com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandOnBackgroundFetchDataEvent.1
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(h hVar) {
                if (StringUtils.equals(eVar.S().k(), hVar.e())) {
                    AppBrandOnBackgroundFetchDataEvent.a(appId, hVar.d());
                    return false;
                }
                return false;
            }
        }.alive();
    }

    public static void a(String str, c cVar) {
        if (cVar != null && !w0.c(str)) {
            a(str, cVar.f141214a, cVar.f141215b, cVar.f141218e, cVar.f141216c, cVar.f141217d, cVar.f141219f, cVar.f141220g);
        } else {
            w.f("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "dispatch, parcel is null or appid is null");
        }
    }

    public static void a(String str, String str2, int i3, String str3, String str4, String str5, int i16, long j3) {
        if (!w0.c(str2) && !w0.c(str3)) {
            f b16 = com.tencent.luggage.wxa.p6.h.b(str);
            if (b16 == null || b16.w0() || b16.t0()) {
                w.h("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "dispatch but runtime is null or destroyed, username:%s, appId:%s, fetchType:%d, updateTime:%d", str2, str, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, Long.valueOf(j3));
            hashMap.put("path", str4);
            hashMap.put("query", str5);
            hashMap.put("scene", Integer.valueOf(i16));
            hashMap.put("fetchedData", str3);
            hashMap.put("fetchType", i3 == 0 ? "pre" : "peroid");
            w.d("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "AppBrandOnBackgroundFetchDataEvent dispatch to runtime, username:%s, appId:%s, fetch type:%d, timestamp:%d", str2, str, Integer.valueOf(i3), Long.valueOf(j3));
            AppBrandOnBackgroundFetchDataEvent appBrandOnBackgroundFetchDataEvent = new AppBrandOnBackgroundFetchDataEvent();
            appBrandOnBackgroundFetchDataEvent.setData(hashMap);
            b16.b(j3, appBrandOnBackgroundFetchDataEvent);
            return;
        }
        w.f("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "username or data is null");
    }
}
