package com.tencent.luggage.wxa.id;

import android.os.Debug;
import android.util.Base64;
import com.tencent.luggage.wxa.hn.hc;
import com.tencent.luggage.wxa.hn.ic;
import com.tencent.luggage.wxa.hn.yb;
import com.tencent.luggage.wxa.mc.k0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static e f130086a;

    /* renamed from: b, reason: collision with root package name */
    public static int f130087b;

    /* renamed from: c, reason: collision with root package name */
    public static String f130088c;

    public static boolean a(int i3) {
        return (i3 & 1) != 0;
    }

    public static f b(String str) {
        w.d("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", str);
        f fVar = new f();
        if (!w0.c(str)) {
            try {
                JSONObject c16 = com.tencent.luggage.wxa.xa.g.c(str);
                fVar.f130051a = c16.optBoolean("open_remote", false);
                fVar.f130052b = c16.optString(AudienceReportConst.ROOM_ID);
                fVar.f130053c = c16.optString("wxpkg_info");
                fVar.f130054d = c16.optString("qrcode_id");
                fVar.f130055e = c16.optInt("remote_network_type", 1);
                fVar.f130057g = c16.optBoolean("disable_url_check", true);
                fVar.f130056f = c16.optInt("remote_proxy_port", 9976);
                fVar.f130058h = c16.optInt("remote_support_compress_algo");
                try {
                    JSONObject c17 = com.tencent.luggage.wxa.xa.g.c(c16.optString("debug_launch_info"));
                    if (c17 != null) {
                        int optInt = c17.optInt("debug_type", -1);
                        w.d("MicroMsg.RemoteDebugUtil", "debug_type:%d", Integer.valueOf(optInt));
                        if (optInt != -1) {
                            fVar.f130059i = optInt;
                        }
                    } else {
                        w.b("MicroMsg.RemoteDebugUtil", "debug_launch_info obj is null");
                    }
                } catch (Exception e16) {
                    w.b("MicroMsg.RemoteDebugUtil", "parse debug_launch_info %s", e16);
                }
            } catch (Exception e17) {
                w.b("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", e17);
            }
        }
        return fVar;
    }

    public static ByteBuffer a(com.tencent.luggage.wxa.fn.b bVar) {
        try {
            return ByteBuffer.wrap(bVar.b());
        } catch (IOException e16) {
            w.f("MicroMsg.RemoteDebugUtil", e16.getMessage());
            return ByteBuffer.allocate(0);
        }
    }

    public static String a() {
        if (w0.c(f130088c)) {
            f130088c = new Random(System.currentTimeMillis()).nextInt() + "-" + f130087b;
        }
        return f130088c + "-" + System.currentTimeMillis();
    }

    public static h a(com.tencent.luggage.wxa.fn.b bVar, e eVar, String str) {
        ic icVar = new ic();
        try {
            byte[] b16 = bVar.b();
            if (b16.length > 256 && eVar != null && eVar.E()) {
                byte[] a16 = com.tencent.luggage.wxa.y8.j.a(b16);
                icVar.f127894g = com.tencent.luggage.wxa.fn.c.a(a16);
                icVar.f127895h = 1;
                w.g("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", Integer.valueOf(b16.length), Integer.valueOf(a16.length));
            } else {
                icVar.f127894g = com.tencent.luggage.wxa.fn.c.a(b16);
            }
        } catch (IOException e16) {
            w.b("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", e16);
        }
        if (eVar == null) {
            Debug.waitForDebugger();
            w.b("MicroMsg.RemoteDebugUtil", "env = null ");
        }
        icVar.f127891d = eVar.s();
        if (eVar.f() == 0) {
            icVar.f127892e = 0;
        } else {
            icVar.f127892e = (int) (System.currentTimeMillis() - eVar.f());
        }
        eVar.F();
        icVar.f127893f = str;
        w.a("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", Integer.valueOf(icVar.f127891d));
        h hVar = new h();
        hVar.a();
        hVar.f130064c = icVar.f127894g.b();
        hVar.f130063b = icVar;
        return hVar;
    }

    public static void b(int i3) {
        f130087b = i3;
    }

    public static com.tencent.luggage.wxa.fn.c b(com.tencent.luggage.wxa.fn.b bVar) {
        try {
            return com.tencent.luggage.wxa.fn.c.a(bVar.b());
        } catch (IOException e16) {
            w.f("MicroMsg.RemoteDebugUtil", e16.getMessage());
            return com.tencent.luggage.wxa.fn.c.a(new byte[0]);
        }
    }

    public static hc a(int i3, com.tencent.luggage.wxa.fn.b bVar) {
        hc hcVar = new hc();
        hcVar.f127796d = i3;
        hcVar.f127797e = a();
        hcVar.f127798f = b(bVar);
        return hcVar;
    }

    public static boolean a(e eVar, hc hcVar, yb ybVar, com.tencent.mm.plugin.appbrand.debugger.a aVar, i iVar) {
        if (hcVar == null) {
            w.f("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
            return false;
        }
        int i3 = hcVar.f127796d;
        if (ybVar == null) {
            w.h("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", Integer.valueOf(i3));
            return false;
        }
        if (i3 == 1006) {
            if (-50011 == ybVar.f129091d) {
                eVar.a(true);
            } else {
                boolean y16 = eVar.y();
                eVar.a(false);
                if (y16) {
                    iVar.m();
                }
            }
        }
        if (ybVar.f129091d == 0) {
            return true;
        }
        w.d("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", Integer.valueOf(i3), hcVar.f127797e, Integer.valueOf(ybVar.f129091d), ybVar.f129092e);
        aVar.a(i3, ybVar);
        return false;
    }

    public static String a(String str, com.tencent.luggage.wxa.c5.e eVar) {
        if (!eVar.R1()) {
            return "";
        }
        String c16 = k0.c(eVar, str + ".map");
        if (w0.c(c16)) {
            return "";
        }
        try {
            return String.format("\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,%s", new String(Base64.encode(c16.getBytes(), 2), "utf-8"));
        } catch (UnsupportedEncodingException e16) {
            w.b("MicroMsg.RemoteDebugUtil", "execGameExternalScript Base64.encode %s", e16.getMessage());
            return "";
        }
    }

    public static boolean a(String str) {
        return b(str).f130059i == 1;
    }
}
