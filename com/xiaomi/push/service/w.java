package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bx;
import com.xiaomi.push.eb;
import com.xiaomi.push.ep;
import com.xiaomi.push.fc;
import com.xiaomi.push.fi;
import com.xiaomi.push.fv;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.gu;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hq;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.ay;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public final class w {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a implements am.b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ XMPushService f389834a;

        a(XMPushService xMPushService) {
            this.f389834a = xMPushService;
        }

        @Override // com.xiaomi.push.service.am.b.d
        public void a(am.c cVar, am.c cVar2, int i3) {
            if (cVar2 == am.c.binded) {
                az.d(this.f389834a, true);
                az.c(this.f389834a);
            } else if (cVar2 == am.c.unbind) {
                jz4.c.m("onChange unbind");
                az.a(this.f389834a, 70000001, " the push is not connected.");
            }
        }
    }

    static eb a(XMPushService xMPushService, byte[] bArr) {
        hb hbVar = new hb();
        try {
            fv.d(hbVar, bArr);
            return b(av.b(xMPushService), xMPushService, hbVar);
        } catch (hu e16) {
            jz4.c.q(e16);
            return null;
        }
    }

    static eb b(au auVar, Context context, hb hbVar) {
        try {
            eb ebVar = new eb();
            ebVar.h(5);
            ebVar.B(auVar.f389664a);
            ebVar.v(f(hbVar));
            ebVar.l("SECMSG", "message");
            String str = auVar.f389664a;
            hbVar.f24803a.f24774a = str.substring(0, str.indexOf("@"));
            hbVar.f24803a.f389192c = str.substring(str.indexOf("/") + 1);
            ebVar.n(fv.e(hbVar), auVar.f389666c);
            ebVar.m((short) 1);
            jz4.c.m("try send mi push message. packagename:" + hbVar.f389250b + " action:" + hbVar.f389249a);
            return ebVar;
        } catch (NullPointerException e16) {
            jz4.c.q(e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static hb c(String str, String str2) {
        he heVar = new he();
        heVar.b(str2);
        heVar.c("package uninstalled");
        heVar.a(fc.k());
        heVar.a(false);
        return d(str, str2, heVar, gf.Notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends hq<T, ?>> hb d(String str, String str2, T t16, gf gfVar) {
        return e(str, str2, t16, gfVar, true);
    }

    private static <T extends hq<T, ?>> hb e(String str, String str2, T t16, gf gfVar, boolean z16) {
        byte[] e16 = fv.e(t16);
        hb hbVar = new hb();
        gu guVar = new gu();
        guVar.f389190a = 5L;
        guVar.f24774a = "fakeid";
        hbVar.a(guVar);
        hbVar.a(ByteBuffer.wrap(e16));
        hbVar.a(gfVar);
        hbVar.b(z16);
        hbVar.b(str);
        hbVar.a(false);
        hbVar.a(str2);
        return hbVar;
    }

    private static String f(hb hbVar) {
        Map<String, String> map;
        gs gsVar = hbVar.f24802a;
        if (gsVar != null && (map = gsVar.f24769b) != null) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hbVar.f389250b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(XMPushService xMPushService) {
        au b16 = av.b(xMPushService.getApplicationContext());
        if (b16 != null) {
            am.b a16 = av.b(xMPushService.getApplicationContext()).a(xMPushService);
            jz4.c.m("prepare account. " + a16.f389605a);
            j(xMPushService, a16);
            am.c().l(a16);
            k(xMPushService, b16, 172800);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(XMPushService xMPushService, hb hbVar) {
        bx.e(hbVar.b(), xMPushService.getApplicationContext(), hbVar, -1);
        ep m454a = xMPushService.m454a();
        if (m454a != null) {
            if (m454a.q()) {
                eb b16 = b(av.b(xMPushService), xMPushService, hbVar);
                if (b16 != null) {
                    m454a.w(b16);
                    return;
                }
                return;
            }
            throw new fi("Don't support XMPP connection.");
        }
        throw new fi("try send msg while connection is null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(XMPushService xMPushService, am.b bVar) {
        bVar.h(null);
        bVar.i(new a(xMPushService));
    }

    private static void k(final XMPushService xMPushService, final au auVar, int i3) {
        ay.c(xMPushService).f(new ay.a("MSAID", i3) { // from class: com.xiaomi.push.service.w.1
            @Override // com.xiaomi.push.service.ay.a
            void a(ay ayVar) {
                com.xiaomi.push.q a16 = com.xiaomi.push.q.a(xMPushService);
                String d16 = ayVar.d("MSAID", "msaid");
                String a17 = a16.a();
                if (!TextUtils.isEmpty(a17) && !TextUtils.equals(d16, a17)) {
                    ayVar.g("MSAID", "msaid", a17);
                    he heVar = new he();
                    heVar.b(auVar.f389667d);
                    heVar.c(gp.ClientInfoUpdate.f24750a);
                    heVar.a(m.a());
                    heVar.a(new HashMap());
                    a16.d(heVar.m391a());
                    byte[] e16 = fv.e(w.d(xMPushService.getPackageName(), auVar.f389667d, heVar, gf.Notification));
                    XMPushService xMPushService2 = xMPushService;
                    xMPushService2.a(xMPushService2.getPackageName(), e16, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(XMPushService xMPushService, String str, byte[] bArr) {
        bx.g(str, xMPushService.getApplicationContext(), bArr);
        ep m454a = xMPushService.m454a();
        if (m454a != null) {
            if (m454a.q()) {
                eb a16 = a(xMPushService, bArr);
                if (a16 != null) {
                    m454a.w(a16);
                    return;
                } else {
                    az.b(xMPushService, str, bArr, 70000003, "not a valid message");
                    return;
                }
            }
            throw new fi("Don't support XMPP connection.");
        }
        throw new fi("try send msg while connection is null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static hb m(String str, String str2) {
        he heVar = new he();
        heVar.b(str2);
        heVar.c(gp.AppDataCleared.f24750a);
        heVar.a(m.a());
        heVar.a(false);
        return d(str, str2, heVar, gf.Notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends hq<T, ?>> hb n(String str, String str2, T t16, gf gfVar) {
        return e(str, str2, t16, gfVar, false);
    }
}
