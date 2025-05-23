package com.tencent.luggage.wxa.uc;

import com.tencent.luggage.wxa.fd.b;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static void a(com.tencent.luggage.wxa.c5.e eVar) {
        boolean z16;
        boolean z17;
        if (eVar != null && !w0.c(eVar.getAppId()) && eVar.E() != null) {
            String appId = eVar.getAppId();
            com.tencent.luggage.wxa.fd.b E = eVar.E();
            boolean a16 = e.a.a(eVar.j0().a());
            boolean contains = E.h().contains("location");
            f0.e("appbrand_background_config").b(String.format("%s_location_background_required", appId), contains);
            boolean contains2 = E.h().contains(QQPermissionConstants.Permission.BLUE_TOOTH_GROUP);
            f0.e("appbrand_background_config").b(String.format("%s_bluetooth_background_required", appId), contains2);
            b.f b16 = E.b(AuthorizeCenter.SCOPE_USER_LOCATION);
            if (b16 != null && !w0.c(b16.f125650b)) {
                f0.e("appbrand_background_config").b(String.format("%s_permission_location_desc", appId), b16.f125650b);
                z16 = true;
            } else {
                f0.e("appbrand_background_config").remove(String.format("%s_permission_location_desc", appId));
                z16 = false;
            }
            b.f b17 = E.b("scope.bluetooth");
            if (b17 != null && !w0.c(b17.f125650b)) {
                f0.e("appbrand_background_config").b(String.format("%s_permission_bluetooth_desc", appId), b17.f125650b);
                z17 = true;
            } else {
                f0.e("appbrand_background_config").remove(String.format("%s_permission_bluetooth_desc", appId));
                z17 = false;
            }
            w.d("MicroMsg.AppBrandBackgroundConfigStorage", "updateBackgroundConfigs, appId:%s, isDebug:%s, isLocationBackgroundRequired:%s, isBluetoothBackgroundRequired:%s, hasPermissionLocationDesc:%s, hasPermissionLocationDesc:%s", appId, Boolean.valueOf(a16), Boolean.valueOf(contains), Boolean.valueOf(contains2), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        w.d("MicroMsg.AppBrandBackgroundConfigStorage", "updateBackgroundConfigs, runtime or appId or appConfig is null");
    }

    public static String b(String str) {
        if (w0.c(str)) {
            return null;
        }
        return f0.e("appbrand_background_config").a(String.format("%s_permission_location_desc", str), "");
    }

    public static boolean c(String str) {
        if (w0.c(str)) {
            return false;
        }
        return f0.e("appbrand_background_config").a(String.format("%s_bluetooth_background_required", str), false);
    }

    public static boolean d(String str) {
        if (w0.c(str)) {
            return false;
        }
        return f0.e("appbrand_background_config").a(String.format("%s_location_background_required", str), false);
    }

    public static String a(String str) {
        if (w0.c(str)) {
            return null;
        }
        return f0.e("appbrand_background_config").a(String.format("%s_permission_bluetooth_desc", str), "");
    }
}
