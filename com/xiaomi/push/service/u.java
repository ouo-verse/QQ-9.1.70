package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.xiaomi.push.bx;
import com.xiaomi.push.df;
import com.xiaomi.push.eb;
import com.xiaomi.push.ez;
import com.xiaomi.push.fb;
import com.xiaomi.push.fc;
import com.xiaomi.push.fi;
import com.xiaomi.push.fo;
import com.xiaomi.push.fv;
import com.xiaomi.push.ge;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.hu;
import com.xiaomi.push.hz;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class u {
    public static Intent a(byte[] bArr, long j3) {
        hb d16 = d(bArr);
        if (d16 == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j3));
        intent.setPackage(d16.f389250b);
        return intent;
    }

    public static hb b(Context context, hb hbVar) {
        return c(context, hbVar, null);
    }

    public static hb c(Context context, hb hbVar, Map<String, String> map) {
        String str;
        gv gvVar = new gv();
        gvVar.b(hbVar.m376a());
        gs m375a = hbVar.m375a();
        if (m375a != null) {
            gvVar.a(m375a.m341a());
            gvVar.a(m375a.m339a());
            if (!TextUtils.isEmpty(m375a.m346b())) {
                gvVar.c(m375a.m346b());
            }
        }
        gvVar.a(fv.b(context, hbVar));
        hb d16 = w.d(hbVar.b(), hbVar.m376a(), gvVar, gf.AckMessage);
        gs m375a2 = hbVar.m375a();
        if (m375a2 != null) {
            m375a2 = ac.a(m375a2.m340a());
            Map<String, String> m342a = m375a2.m342a();
            if (m342a != null) {
                str = m342a.get("channel_id");
            } else {
                str = null;
            }
            m375a2.a("mat", Long.toString(System.currentTimeMillis()));
            m375a2.a("cs", String.valueOf(f.b(context, hbVar.f389250b, str)));
        }
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str2 : map.keySet()) {
                        m375a2.a(str2, map.get(str2));
                    }
                }
            } catch (Throwable th5) {
                jz4.c.B("error adding params to ack message :" + th5);
            }
        }
        d16.a(m375a2);
        return d16;
    }

    public static hb d(byte[] bArr) {
        hb hbVar = new hb();
        try {
            fv.d(hbVar, bArr);
            return hbVar;
        } catch (Throwable th5) {
            jz4.c.q(th5);
            return null;
        }
    }

    public static void e(Context context, hb hbVar, byte[] bArr) {
        try {
            x.c r16 = x.r(context, hbVar, bArr);
            if (r16.f389847b > 0 && !TextUtils.isEmpty(r16.f389846a)) {
                fo.j(context, r16.f389846a, r16.f389847b, true, false, System.currentTimeMillis());
            }
            if (hz.j(context) && bc.f(context, hbVar, r16.f389848c)) {
                bc.b(context, hbVar);
                jz4.c.m("consume this broadcast by tts");
            } else {
                u(context, hbVar, bArr);
            }
        } catch (Exception e16) {
            jz4.c.m("notify push msg error " + e16);
            e16.printStackTrace();
        }
    }

    private static void i(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public void a() {
                try {
                    w.i(xMPushService, w.c(hbVar.b(), hbVar.m376a()));
                } catch (fi e16) {
                    jz4.c.q(e16);
                    xMPushService.a(10, e16);
                }
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String e() {
                return "send app absent message.";
            }
        });
    }

    private static void j(final XMPushService xMPushService, final hb hbVar, final he heVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.7
            @Override // com.xiaomi.push.service.XMPushService.j
            public void a() {
                try {
                    gw gwVar = new gw();
                    gwVar.c(gp.CancelPushMessageACK.f24750a);
                    gwVar.a(heVar.m390a());
                    gwVar.a(heVar.a());
                    gwVar.b(heVar.b());
                    gwVar.e(heVar.d());
                    gwVar.a(0L);
                    gwVar.d("success clear push message.");
                    w.i(xMPushService, w.n(hbVar.b(), hbVar.m376a(), gwVar, gf.Notification));
                } catch (fi e16) {
                    jz4.c.B("clear push message. " + e16);
                    xMPushService.a(10, e16);
                }
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String e() {
                return "send ack message for clear push message.";
            }
        });
    }

    private static void k(final XMPushService xMPushService, final hb hbVar, final String str) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.5
            @Override // com.xiaomi.push.service.XMPushService.j
            public void a() {
                try {
                    hb b16 = u.b(xMPushService, hbVar);
                    b16.m375a().a("absent_target_package", str);
                    w.i(xMPushService, b16);
                } catch (fi e16) {
                    jz4.c.q(e16);
                    xMPushService.a(10, e16);
                }
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String e() {
                return "send app absent ack message for message.";
            }
        });
    }

    private static void l(final XMPushService xMPushService, final hb hbVar, final String str, final String str2) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.6
            @Override // com.xiaomi.push.service.XMPushService.j
            public void a() {
                try {
                    hb b16 = u.b(xMPushService, hbVar);
                    b16.f24802a.a("error", str);
                    b16.f24802a.a("reason", str2);
                    w.i(xMPushService, b16);
                } catch (fi e16) {
                    jz4.c.q(e16);
                    xMPushService.a(10, e16);
                }
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String e() {
                return "send wrong message ack for message.";
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0452  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m(XMPushService xMPushService, String str, byte[] bArr, Intent intent) {
        byte b16;
        he heVar;
        hb d16 = d(bArr);
        gs m375a = d16.m375a();
        hq hqVar = null;
        String str2 = null;
        if (bArr != null) {
            bx.f(d16.b(), xMPushService.getApplicationContext(), null, d16.a(), bArr.length);
        }
        if (y(d16) && q(xMPushService, str)) {
            if (x.a0(d16)) {
                df.a(xMPushService.getApplicationContext()).g(d16.b(), x.P(d16), m375a.m341a(), "5");
            }
            x(xMPushService, d16);
            return;
        }
        if (s(d16) && !q(xMPushService, str) && !w(d16)) {
            if (x.a0(d16)) {
                df.a(xMPushService.getApplicationContext()).g(d16.b(), x.P(d16), m375a.m341a(), "6");
            }
            z(xMPushService, d16);
            return;
        }
        if ((x.J(d16) && com.xiaomi.push.g.p(xMPushService, d16.f389250b)) || p(xMPushService, intent)) {
            boolean z16 = false;
            if (gf.Registration == d16.a()) {
                String b17 = d16.b();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(b17, d16.f24804a);
                edit.commit();
                hg a16 = ar.a(d16);
                if (a16.a() == 0 && !TextUtils.isEmpty(a16.b())) {
                    ar.c(xMPushService, b17, a16.b());
                } else {
                    jz4.c.B("read regSecret failed");
                }
                ax.a(xMPushService).i(b17);
                ax.a(xMPushService).j(b17);
                df.a(xMPushService.getApplicationContext()).f(b17, "E100003", m375a.m341a(), 6003, null);
                if (!TextUtils.isEmpty(m375a.m341a())) {
                    intent.putExtra("messageId", m375a.m341a());
                    intent.putExtra("eventMessageType", 6000);
                }
            }
            if (x.Y(d16)) {
                df.a(xMPushService.getApplicationContext()).e(d16.b(), x.P(d16), m375a.m341a(), 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m375a.m341a())) {
                    intent.putExtra("messageId", m375a.m341a());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (x.U(d16)) {
                df.a(xMPushService.getApplicationContext()).e(d16.b(), x.P(d16), m375a.m341a(), 2001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m375a.m341a())) {
                    intent.putExtra("messageId", m375a.m341a());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (x.J(d16)) {
                df.a(xMPushService.getApplicationContext()).e(d16.b(), x.P(d16), m375a.m341a(), 3001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m375a.m341a())) {
                    intent.putExtra("messageId", m375a.m341a());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (m375a != null && !TextUtils.isEmpty(m375a.m349c()) && !TextUtils.isEmpty(m375a.d()) && m375a.f389178b != 1 && !x.H(xMPushService, d16.f389250b, x.L(m375a.m342a()))) {
                Map<String, String> map = m375a.f24766a;
                if (map != null) {
                    str2 = map.get("jobkey");
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = m375a.m341a();
                }
                if (be.a(xMPushService, d16.f389250b, str2)) {
                    df.a(xMPushService.getApplicationContext()).j(d16.b(), x.P(d16), m375a.m341a(), "1:" + str2);
                    jz4.c.m("drop a duplicate message, key=" + str2);
                } else if (hz.j(xMPushService) && bc.g(d16)) {
                    jz4.c.m("receive pull down message");
                } else {
                    e(xMPushService, d16, bArr);
                }
                v(xMPushService, d16);
            } else if ("com.xiaomi.xmsf".contains(d16.f389250b) && !d16.m383b() && m375a != null && m375a.m342a() != null && m375a.m342a().containsKey("ab")) {
                v(xMPushService, d16);
                jz4.c.z("receive abtest message. ack it." + m375a.m341a());
            } else if (t(xMPushService, str, d16, m375a)) {
                if (m375a != null && !TextUtils.isEmpty(m375a.m341a())) {
                    if (x.U(d16)) {
                        df.a(xMPushService.getApplicationContext()).f(d16.b(), x.P(d16), m375a.m341a(), 2002, null);
                    } else if (x.J(d16)) {
                        df.a(xMPushService.getApplicationContext()).g(d16.b(), x.P(d16), m375a.m341a(), "7");
                    } else if (x.Y(d16)) {
                        df.a(xMPushService.getApplicationContext()).g(d16.b(), x.P(d16), m375a.m341a(), "8");
                    } else if (x.Z(d16)) {
                        df.a(xMPushService.getApplicationContext()).f(d16.b(), "E100003", m375a.m341a(), 6004, null);
                    }
                }
                if (gf.Notification == d16.f389249a) {
                    try {
                        hqVar = ai.a(xMPushService, d16);
                    } catch (hu e16) {
                        jz4.c.B("receive a message which action string is not valid. " + e16);
                    }
                    if (hqVar == null) {
                        jz4.c.B("receiving an un-recognized notification message. " + d16.f389249a);
                        b16 = false;
                        if (b16 != false && (hqVar instanceof he)) {
                            heVar = (he) hqVar;
                            if (!gp.CancelPushMessage.f24750a.equals(heVar.f389261d) && heVar.m391a() != null) {
                                String str3 = heVar.m391a().get(r.M);
                                int i3 = -2;
                                if (!TextUtils.isEmpty(str3)) {
                                    try {
                                        i3 = Integer.parseInt(str3);
                                    } catch (NumberFormatException e17) {
                                        jz4.c.m("parse notifyId from STRING to INT failed: " + e17);
                                    }
                                }
                                if (i3 >= -1) {
                                    jz4.c.m("try to retract a message by notifyId=" + i3);
                                    x.y(xMPushService, d16.f389250b, i3);
                                } else {
                                    String str4 = heVar.m391a().get(r.K);
                                    String str5 = heVar.m391a().get(r.L);
                                    jz4.c.m("try to retract a message by title&description.");
                                    x.B(xMPushService, d16.f389250b, str4, str5);
                                }
                                if (m375a != null && m375a.m342a() != null && hz.j(xMPushService) && "pulldown".equals(k.i(m375a.m342a()))) {
                                    bc.d(d16);
                                }
                                j(xMPushService, d16, heVar);
                            } else if (gp.SettingAppNotificationPermission.f24750a.equals(heVar.c())) {
                                if (hz.j(xMPushService)) {
                                    bc.c(xMPushService, d16, heVar);
                                }
                            }
                            if (z16) {
                                jz4.c.m("broadcast passthrough message.");
                                xMPushService.sendBroadcast(intent, w.g(d16.f389250b));
                            }
                        }
                    } else {
                        b16 = true;
                        if (b16 != false) {
                            heVar = (he) hqVar;
                            if (!gp.CancelPushMessage.f24750a.equals(heVar.f389261d)) {
                            }
                            if (gp.SettingAppNotificationPermission.f24750a.equals(heVar.c())) {
                            }
                        }
                    }
                }
                z16 = true;
                if (z16) {
                }
            } else {
                df.a(xMPushService.getApplicationContext()).g(d16.b(), x.P(d16), m375a.m341a(), "9");
            }
            if (d16.a() == gf.UnRegistration && !"com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                xMPushService.stopSelf();
                return;
            }
            return;
        }
        if (!com.xiaomi.push.g.p(xMPushService, d16.f389250b)) {
            if (x.a0(d16)) {
                df.a(xMPushService.getApplicationContext()).i(d16.b(), x.P(d16), m375a.m341a(), "2");
            }
            i(xMPushService, d16);
        } else {
            jz4.c.m("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (x.a0(d16)) {
                df.a(xMPushService.getApplicationContext()).i(d16.b(), x.P(d16), m375a.m341a(), "3");
            }
        }
    }

    private static void n(XMPushService xMPushService, byte[] bArr, long j3) {
        o(xMPushService, bArr, j3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void o(XMPushService xMPushService, byte[] bArr, long j3, Map<String, String> map) {
        byte[] bArr2;
        String t16;
        gf gfVar;
        String str;
        Map<String, String> m342a;
        Map<String, String> m342a2;
        byte[] e16;
        hb d16 = d(bArr);
        if (d16 == null) {
            return;
        }
        if (TextUtils.isEmpty(d16.f389250b)) {
            jz4.c.m("receive a mipush message without package name");
            return;
        }
        gs m375a = d16.m375a();
        if (m375a != null && map != null && !map.isEmpty() && (m342a2 = m375a.m342a()) != null && !m342a2.isEmpty()) {
            boolean z16 = false;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (m342a2.containsKey(entry.getKey())) {
                    m342a2.put(entry.getKey(), entry.getValue());
                    z16 = true;
                }
            }
            if (z16 && (e16 = fv.e(d16)) != null && e16.length > 0) {
                bArr2 = e16;
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                Intent a16 = a(bArr2, valueOf.longValue());
                t16 = x.t(d16);
                fo.j(xMPushService, t16, j3, true, true, System.currentTimeMillis());
                if (m375a != null && m375a.m341a() != null) {
                    jz4.c.D(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", d16.m376a(), m.b(m375a.m341a()), d16.a()));
                }
                if (m375a != null) {
                    m375a.a("mrt", Long.toString(valueOf.longValue()));
                }
                gfVar = gf.SendMessage;
                String str2 = "";
                if (gfVar != d16.a() && ax.a(xMPushService).c(d16.f389250b) && !x.J(d16)) {
                    if (m375a != null) {
                        str2 = m375a.m341a();
                        if (x.a0(d16)) {
                            df.a(xMPushService.getApplicationContext()).g(d16.b(), x.P(d16), str2, "1");
                        }
                    }
                    jz4.c.m("Drop a message for unregistered, msgid=" + str2);
                    k(xMPushService, d16, d16.f389250b);
                    return;
                }
                if (gfVar != d16.a() && ax.a(xMPushService).g(d16.f389250b) && !x.J(d16)) {
                    if (m375a != null) {
                        str2 = m375a.m341a();
                        if (x.a0(d16)) {
                            df.a(xMPushService.getApplicationContext()).g(d16.b(), x.P(d16), str2, "2");
                        }
                    }
                    jz4.c.m("Drop a message for push closed, msgid=" + str2);
                    k(xMPushService, d16, d16.f389250b);
                    return;
                }
                if (gfVar != d16.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), d16.f389250b)) {
                    jz4.c.m("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + d16.f389250b);
                    l(xMPushService, d16, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + d16.f389250b);
                    if (m375a != null && x.a0(d16)) {
                        df.a(xMPushService.getApplicationContext()).g(d16.b(), x.P(d16), m375a.m341a(), "3");
                        return;
                    }
                    return;
                }
                if (gfVar != d16.a() && ge.c() == 999) {
                    str = t16;
                    if (ge.l(xMPushService, str)) {
                        jz4.c.m("Receive the uninstalled dual app message");
                        try {
                            w.i(xMPushService, w.c(str, d16.m376a()));
                            jz4.c.m("uninstall " + str + " msg sent");
                        } catch (fi e17) {
                            jz4.c.B("Fail to send Message: " + e17.getMessage());
                            xMPushService.a(10, e17);
                        }
                        x.x(xMPushService, str);
                        return;
                    }
                } else {
                    str = t16;
                }
                if (m375a == null && (m342a = m375a.m342a()) != null && m342a.containsKey("hide") && "true".equalsIgnoreCase(m342a.get("hide"))) {
                    v(xMPushService, d16);
                    return;
                }
                m(xMPushService, str, bArr2, a16);
            }
        }
        bArr2 = bArr;
        Long valueOf2 = Long.valueOf(System.currentTimeMillis());
        Intent a162 = a(bArr2, valueOf2.longValue());
        t16 = x.t(d16);
        fo.j(xMPushService, t16, j3, true, true, System.currentTimeMillis());
        if (m375a != null) {
            jz4.c.D(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", d16.m376a(), m.b(m375a.m341a()), d16.a()));
        }
        if (m375a != null) {
        }
        gfVar = gf.SendMessage;
        String str22 = "";
        if (gfVar != d16.a()) {
        }
        if (gfVar != d16.a()) {
        }
        if (gfVar != d16.a()) {
        }
        if (gfVar != d16.a()) {
        }
        str = t16;
        if (m375a == null) {
        }
        m(xMPushService, str, bArr2, a162);
    }

    private static boolean p(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean q(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> queryIntentServices = InstalledAppListMonitor.queryIntentServices(packageManager, intent, 32);
            if (queryBroadcastReceivers.isEmpty()) {
                if (queryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e16) {
            jz4.c.q(e16);
            return false;
        }
    }

    public static boolean r(Context context, String str, byte[] bArr) {
        if (!com.xiaomi.push.g.l(context, str)) {
            return false;
        }
        Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
        intent.putExtra("mipush_payload", bArr);
        intent.setPackage(str);
        try {
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                return false;
            }
            jz4.c.m("broadcast message arrived.");
            context.sendBroadcast(intent, w.g(str));
            return true;
        } catch (Exception e16) {
            jz4.c.m("meet error when broadcast message arrived. " + e16);
            return false;
        }
    }

    private static boolean s(hb hbVar) {
        if ("com.xiaomi.xmsf".equals(hbVar.f389250b) && hbVar.m375a() != null && hbVar.m375a().m342a() != null && hbVar.m375a().m342a().containsKey("miui_package_name")) {
            return true;
        }
        return false;
    }

    private static boolean t(XMPushService xMPushService, String str, hb hbVar, gs gsVar) {
        boolean z16 = true;
        if (gsVar != null && gsVar.m342a() != null && gsVar.m342a().containsKey("__check_alive") && gsVar.m342a().containsKey("__awake")) {
            he heVar = new he();
            heVar.b(hbVar.m376a());
            heVar.d(str);
            heVar.c(gp.AwakeSystemApp.f24750a);
            heVar.a(gsVar.m341a());
            heVar.f24813a = new HashMap();
            boolean l3 = com.xiaomi.push.g.l(xMPushService.getApplicationContext(), str);
            heVar.f24813a.put("app_running", Boolean.toString(l3));
            if (!l3) {
                boolean parseBoolean = Boolean.parseBoolean(gsVar.m342a().get("__awake"));
                heVar.f24813a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z16 = false;
                }
            }
            try {
                w.i(xMPushService, w.d(hbVar.b(), hbVar.m376a(), heVar, gf.Notification));
            } catch (fi e16) {
                jz4.c.q(e16);
            }
        }
        return z16;
    }

    private static void u(Context context, hb hbVar, byte[] bArr) {
        if (x.J(hbVar)) {
            return;
        }
        String t16 = x.t(hbVar);
        if (!TextUtils.isEmpty(t16) && !r(context, t16, bArr)) {
            df.a(context).i(t16, x.P(hbVar), hbVar.m375a().m341a(), "1");
        }
    }

    private static void v(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.2
            @Override // com.xiaomi.push.service.XMPushService.j
            public void a() {
                Map<String, String> a16;
                try {
                    if (hz.j(xMPushService)) {
                        try {
                            a16 = bc.a(xMPushService, hbVar);
                        } catch (Throwable th5) {
                            jz4.c.B("error creating params for ack message :" + th5);
                        }
                        w.i(xMPushService, u.c(xMPushService, hbVar, a16));
                    }
                    a16 = null;
                    w.i(xMPushService, u.c(xMPushService, hbVar, a16));
                } catch (fi e16) {
                    jz4.c.B("error sending ack message :" + e16);
                    xMPushService.a(10, e16);
                }
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String e() {
                return "send ack message for message.";
            }
        });
    }

    private static boolean w(hb hbVar) {
        Map<String, String> m342a = hbVar.m375a().m342a();
        if (m342a != null && m342a.containsKey("notify_effect")) {
            return true;
        }
        return false;
    }

    private static void x(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.3
            @Override // com.xiaomi.push.service.XMPushService.j
            public void a() {
                try {
                    hb b16 = u.b(xMPushService, hbVar);
                    b16.m375a().a("message_obsleted", "1");
                    w.i(xMPushService, b16);
                } catch (fi e16) {
                    jz4.c.q(e16);
                    xMPushService.a(10, e16);
                }
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String e() {
                return "send ack message for obsleted message.";
            }
        });
    }

    private static boolean y(hb hbVar) {
        if (hbVar.m375a() != null && hbVar.m375a().m342a() != null) {
            return "1".equals(hbVar.m375a().m342a().get("obslete_ads_message"));
        }
        return false;
    }

    private static void z(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.4
            @Override // com.xiaomi.push.service.XMPushService.j
            public void a() {
                try {
                    hb b16 = u.b(xMPushService, hbVar);
                    b16.m375a().a("miui_message_unrecognized", "1");
                    w.i(xMPushService, b16);
                } catch (fi e16) {
                    jz4.c.q(e16);
                    xMPushService.a(10, e16);
                }
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String e() {
                return "send ack message for unrecognized new miui message.";
            }
        });
    }

    public void f(Context context, am.b bVar, boolean z16, int i3, String str) {
        au b16;
        if (!z16 && (b16 = av.b(context)) != null && "token-expired".equals(str)) {
            av.c(context, b16.f389669f, b16.f389667d, b16.f389668e);
        }
    }

    public void g(XMPushService xMPushService, eb ebVar, am.b bVar) {
        HashMap hashMap;
        try {
            byte[] q16 = ebVar.q(bVar.f389613i);
            if (ak.b(ebVar)) {
                hashMap = new HashMap();
                hashMap.put("t_im", String.valueOf(ebVar.s()));
                hashMap.put("t_rt", String.valueOf(ebVar.b()));
            } else {
                hashMap = null;
            }
            o(xMPushService, q16, ebVar.x(), hashMap);
        } catch (IllegalArgumentException e16) {
            jz4.c.q(e16);
        }
    }

    public void h(XMPushService xMPushService, fc fcVar, am.b bVar) {
        if (fcVar instanceof fb) {
            fb fbVar = (fb) fcVar;
            ez b16 = fbVar.b(ReportConstant.COSTREPORT_PREFIX);
            if (b16 != null) {
                try {
                    n(xMPushService, aa.h(aa.g(bVar.f389613i, fbVar.l()), b16.k()), fo.b(fcVar.f()));
                    return;
                } catch (IllegalArgumentException e16) {
                    jz4.c.q(e16);
                    return;
                }
            }
            return;
        }
        jz4.c.m("not a mipush message");
    }
}
