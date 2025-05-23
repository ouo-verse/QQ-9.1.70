package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import org.json.JSONException;
import org.slf4j.Logger;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f36974a;

    /* renamed from: b, reason: collision with root package name */
    private final GrsBaseInfo f36975b;

    /* renamed from: c, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.a f36976c;

    public b(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo) {
        this.f36974a = context;
        this.f36975b = grsBaseInfo;
        this.f36976c = aVar;
    }

    public String a(boolean z16) {
        String str;
        String str2 = com.huawei.hms.framework.network.grs.a.a(this.f36976c.a().a("geoipCountryCode", ""), "geoip.countrycode").get(Logger.ROOT_LOGGER_NAME);
        com.huawei.hms.framework.common.Logger.i("GeoipCountry", "geoIpCountry is: " + str2);
        String a16 = this.f36976c.a().a("geoipCountryCodetime", "0");
        long j3 = 0;
        if (!TextUtils.isEmpty(a16) && a16.matches("\\d+")) {
            try {
                j3 = Long.parseLong(a16);
            } catch (NumberFormatException e16) {
                com.huawei.hms.framework.common.Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e16);
            }
        }
        if (TextUtils.isEmpty(str2) || com.huawei.hms.framework.network.grs.h.e.a(Long.valueOf(j3))) {
            com.huawei.hms.framework.network.grs.g.k.c cVar = new com.huawei.hms.framework.network.grs.g.k.c(this.f36975b, this.f36974a);
            cVar.a("geoip.countrycode");
            com.huawei.hms.framework.network.grs.e.c c16 = this.f36976c.c();
            if (c16 != null) {
                try {
                    str = i.a(c16.a("services", ""), cVar.c());
                } catch (JSONException e17) {
                    com.huawei.hms.framework.common.Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e17.getMessage()));
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    c16.b("services", str);
                }
            }
            if (z16) {
                d a17 = this.f36976c.b().a(cVar, "geoip.countrycode", c16);
                if (a17 != null) {
                    str2 = com.huawei.hms.framework.network.grs.a.a(a17.j(), "geoip.countrycode").get(Logger.ROOT_LOGGER_NAME);
                }
                com.huawei.hms.framework.common.Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + str2);
            } else {
                com.huawei.hms.framework.common.Logger.i("GeoipCountry", "async request to query geoip.countrycode");
                this.f36976c.b().a(cVar, null, "geoip.countrycode", c16);
            }
        }
        return str2;
    }
}
