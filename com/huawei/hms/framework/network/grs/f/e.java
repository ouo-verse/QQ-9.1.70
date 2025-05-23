package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36960a = "e";

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f36961b = Collections.unmodifiableSet(new a(16));

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends HashSet<String> {
        a(int i3) {
            super(i3);
            add("ser_country");
            add("reg_country");
            add("issue_country");
            add("geo_ip");
        }
    }

    private static String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z16) {
        String str2;
        StringBuilder sb5;
        String str3;
        String serCountry = grsBaseInfo.getSerCountry();
        String regCountry = grsBaseInfo.getRegCountry();
        String issueCountry = grsBaseInfo.getIssueCountry();
        for (String str4 : str.split(">")) {
            if (f36961b.contains(str4.trim())) {
                if ("ser_country".equals(str4.trim()) && !TextUtils.isEmpty(serCountry) && !"UNKNOWN".equals(serCountry)) {
                    str2 = f36960a;
                    sb5 = new StringBuilder();
                    str3 = "current route_by is serCountry and routerCountry is: ";
                } else {
                    if ("reg_country".equals(str4.trim()) && !TextUtils.isEmpty(regCountry) && !"UNKNOWN".equals(regCountry)) {
                        Logger.i(f36960a, "current route_by is regCountry and routerCountry is: " + regCountry);
                        return regCountry;
                    }
                    if ("issue_country".equals(str4.trim()) && !TextUtils.isEmpty(issueCountry) && !"UNKNOWN".equals(issueCountry)) {
                        Logger.i(f36960a, "current route_by is issueCountry and routerCountry is: " + issueCountry);
                        return issueCountry;
                    }
                    if ("geo_ip".equals(str4.trim())) {
                        serCountry = new com.huawei.hms.framework.network.grs.g.b(context, aVar, grsBaseInfo).a(z16);
                        str2 = f36960a;
                        sb5 = new StringBuilder();
                        str3 = "current route_by is geo_ip and routerCountry is: ";
                    }
                }
                sb5.append(str3);
                sb5.append(serCountry);
                Logger.i(str2, sb5.toString());
                return serCountry;
            }
        }
        return "";
    }

    public static String b(Context context, com.huawei.hms.framework.network.grs.e.a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            Logger.w(f36960a, "routeBy must be not empty string or null.");
            return null;
        }
        if (!"no_route".equals(str) && !"unconditional".equals(str)) {
            return a(context, aVar, str, grsBaseInfo, z16);
        }
        Logger.v(f36960a, "routeBy equals NO_ROUTE_POLICY");
        return "no_route_country";
    }
}
