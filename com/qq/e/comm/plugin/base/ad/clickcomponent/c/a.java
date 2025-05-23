package com.qq.e.comm.plugin.base.ad.clickcomponent.c;

import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.k.ay;
import com.qq.e.comm.plugin.k.d;
import com.qq.e.comm.plugin.k.y;
import org.json.JSONObject;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static int a(ClickInfo clickInfo) {
        if (clickInfo == null || !y.a(clickInfo.j()) || clickInfo.d() == null) {
            return -1;
        }
        int p16 = clickInfo.d().p();
        if (p16 == 12) {
            return c(clickInfo);
        }
        if (p16 == 25) {
            return e(clickInfo);
        }
        if (p16 == 46) {
            return d(clickInfo);
        }
        if (p16 != 1000) {
            return -2;
        }
        return f(clickInfo);
    }

    public static boolean b(ClickInfo clickInfo) {
        return com.qq.e.comm.plugin.k.b.a(clickInfo.d());
    }

    private static int c(ClickInfo clickInfo) {
        JSONObject j3 = clickInfo.j();
        if (b(j3)) {
            return 101;
        }
        if (h(clickInfo)) {
            return 102;
        }
        if (g(clickInfo)) {
            return 103;
        }
        if (d.d(j3)) {
            return 104;
        }
        return d(j3) ? 105 : -100;
    }

    private static int d(ClickInfo clickInfo) {
        JSONObject j3 = clickInfo.j();
        if (com.qq.e.comm.plugin.k.b.c(j3)) {
            return 301;
        }
        return e(j3) ? 302 : -300;
    }

    private static int e(ClickInfo clickInfo) {
        if (b(clickInfo.j())) {
            return 201;
        }
        return d(clickInfo.j()) ? 202 : -200;
    }

    private static int f(ClickInfo clickInfo) {
        JSONObject j3 = clickInfo.j();
        if (c(j3)) {
            return 401;
        }
        if (a(j3)) {
            return 402;
        }
        if (b(j3)) {
            return 403;
        }
        if (g(clickInfo)) {
            return 404;
        }
        if (d(j3)) {
            return 405;
        }
        return LightConstants.ErrorCode.TEMPLATE_JSON_EMPTY;
    }

    private static boolean g(ClickInfo clickInfo) {
        int e16 = com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.e(clickInfo);
        if (e16 != 2 && e16 != 3) {
            return false;
        }
        return true;
    }

    private static boolean h(ClickInfo clickInfo) {
        if (com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.a(clickInfo.j()) && com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.a(clickInfo)) {
            return true;
        }
        return false;
    }

    private static boolean b(JSONObject jSONObject) {
        return ay.b(jSONObject.optString("customized_invoke_url"));
    }

    private static boolean e(JSONObject jSONObject) {
        return jSONObject.optInt("wx_minigame_jump_type") == 2;
    }

    private static boolean d(JSONObject jSONObject) {
        return !d.a(jSONObject) || d.e(jSONObject);
    }

    private static boolean a(JSONObject jSONObject) {
        return com.qq.e.comm.plugin.k.b.f(jSONObject);
    }

    private static boolean c(JSONObject jSONObject) {
        return com.qq.e.comm.plugin.k.b.d(jSONObject);
    }
}
