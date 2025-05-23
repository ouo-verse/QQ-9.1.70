package com.huawei.agconnect;

import com.tencent.mobileqq.app.LocaleManager;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class AGCRoutePolicy {
    private final int route;
    public static final AGCRoutePolicy UNKNOWN = new AGCRoutePolicy(0);
    public static final AGCRoutePolicy CHINA = new AGCRoutePolicy(1);
    public static final AGCRoutePolicy GERMANY = new AGCRoutePolicy(2);
    public static final AGCRoutePolicy RUSSIA = new AGCRoutePolicy(3);
    public static final AGCRoutePolicy SINGAPORE = new AGCRoutePolicy(4);

    AGCRoutePolicy(int i3) {
        this.route = i3;
    }

    private int hash(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AGCRoutePolicy.class == obj.getClass() && this.route == ((AGCRoutePolicy) obj).route) {
            return true;
        }
        return false;
    }

    public String getRouteName() {
        int i3 = this.route;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return "UNKNOWN";
                    }
                    return "SG";
                }
                return "RU";
            }
            return "DE";
        }
        return LocaleManager.MOBILE_COUNTRY_CODE_CN_STR;
    }

    public int hashCode() {
        return hash(Integer.valueOf(this.route));
    }
}
