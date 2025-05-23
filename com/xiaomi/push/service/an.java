package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.eb;
import com.xiaomi.push.fa;
import com.xiaomi.push.fb;
import com.xiaomi.push.fc;
import com.xiaomi.push.fq;
import com.xiaomi.push.hz;
import com.xiaomi.push.service.am;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes28.dex */
public class an {

    /* renamed from: a, reason: collision with root package name */
    private u f389641a = new u();

    public static String c(am.b bVar) {
        if (!"9".equals(bVar.f389612h)) {
            return bVar.f389605a + ".permission.MIPUSH_RECEIVE";
        }
        return bVar.f389605a + ".permission.MIMC_RECEIVE";
    }

    private static void e(Context context, Intent intent, am.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, c(bVar));
        }
    }

    am.b a(eb ebVar) {
        Collection<am.b> f16 = am.c().f(Integer.toString(ebVar.a()));
        if (f16.isEmpty()) {
            return null;
        }
        Iterator<am.b> it = f16.iterator();
        if (f16.size() == 1) {
            return it.next();
        }
        String F = ebVar.F();
        while (it.hasNext()) {
            am.b next = it.next();
            if (TextUtils.equals(F, next.f389606b)) {
                return next;
            }
        }
        return null;
    }

    am.b b(fc fcVar) {
        Collection<am.b> f16 = am.c().f(fcVar.m());
        if (f16.isEmpty()) {
            return null;
        }
        Iterator<am.b> it = f16.iterator();
        if (f16.size() == 1) {
            return it.next();
        }
        String q16 = fcVar.q();
        String o16 = fcVar.o();
        while (it.hasNext()) {
            am.b next = it.next();
            if (TextUtils.equals(q16, next.f389606b) || TextUtils.equals(o16, next.f389606b)) {
                return next;
            }
        }
        return null;
    }

    @SuppressLint({"WrongConstant"})
    public void d(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.service_started");
            if (hz.r()) {
                intent.addFlags(16777216);
            }
            jz4.c.m("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
            intent.setPackage("com.android.mms");
            context.sendBroadcast(intent);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void f(Context context, am.b bVar, int i3) {
        if (!"5".equalsIgnoreCase(bVar.f389612h)) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.channel_closed");
            intent.setPackage(bVar.f389605a);
            intent.putExtra(r.f389792s, bVar.f389612h);
            intent.putExtra("ext_reason", i3);
            intent.putExtra(r.f389789p, bVar.f389606b);
            intent.putExtra(r.F, bVar.f389614j);
            if (bVar.f389622r != null && "9".equals(bVar.f389612h)) {
                try {
                    bVar.f389622r.send(Message.obtain(null, 17, intent));
                    return;
                } catch (RemoteException unused) {
                    bVar.f389622r = null;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("peer may died: ");
                    String str = bVar.f389606b;
                    sb5.append(str.substring(str.lastIndexOf(64)));
                    jz4.c.m(sb5.toString());
                    return;
                }
            }
            jz4.c.m(String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.f389612h, bVar.f389605a, Integer.valueOf(i3)));
            e(context, intent, bVar);
        }
    }

    public void g(Context context, am.b bVar, String str, String str2) {
        if (bVar == null) {
            jz4.c.B("error while notify kick by server!");
            return;
        }
        if ("5".equalsIgnoreCase(bVar.f389612h)) {
            jz4.c.B("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.f389605a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.f389612h);
        intent.putExtra(r.f389789p, bVar.f389606b);
        intent.putExtra(r.F, bVar.f389614j);
        jz4.c.m(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.f389612h, bVar.f389605a, str2));
        e(context, intent, bVar);
    }

    @SuppressLint({"DefaultLocale"})
    public void h(Context context, am.b bVar, boolean z16, int i3, String str) {
        if ("5".equalsIgnoreCase(bVar.f389612h)) {
            this.f389641a.f(context, bVar, z16, i3, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f389605a);
        intent.putExtra("ext_succeeded", z16);
        if (!z16) {
            intent.putExtra("ext_reason", i3);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.f389612h);
        intent.putExtra(r.f389789p, bVar.f389606b);
        intent.putExtra(r.F, bVar.f389614j);
        jz4.c.m(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.f389612h, bVar.f389605a, Boolean.valueOf(z16), Integer.valueOf(i3)));
        e(context, intent, bVar);
    }

    public void i(XMPushService xMPushService, String str, eb ebVar) {
        am.b a16 = a(ebVar);
        if (a16 == null) {
            jz4.c.B("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.f389641a.g(xMPushService, ebVar, a16);
            return;
        }
        String str2 = a16.f389605a;
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.new_msg");
        intent.setPackage(str2);
        intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_raw_packet", ebVar.q(a16.f389613i));
        intent.putExtra(r.F, a16.f389614j);
        intent.putExtra(r.f389797x, a16.f389613i);
        if (ak.a(ebVar)) {
            intent.putExtra("ext_downward_pkt_id", ebVar.D());
        }
        if (a16.f389622r != null) {
            try {
                a16.f389622r.send(Message.obtain(null, 17, intent));
                jz4.c.m("message was sent by messenger for chid=" + str);
                return;
            } catch (RemoteException unused) {
                a16.f389622r = null;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("peer may died: ");
                String str3 = a16.f389606b;
                sb5.append(str3.substring(str3.lastIndexOf(64)));
                jz4.c.m(sb5.toString());
            }
        }
        if (!"com.xiaomi.xmsf".equals(str2)) {
            jz4.c.m(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", a16.f389612h, a16.f389605a, ebVar.D()));
            if (ak.a(ebVar)) {
                at.a().c(ebVar.D(), SystemClock.elapsedRealtime());
            }
            e(xMPushService, intent, a16);
        }
    }

    public void j(XMPushService xMPushService, String str, fc fcVar) {
        String str2;
        am.b b16 = b(fcVar);
        if (b16 == null) {
            jz4.c.B("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.f389641a.h(xMPushService, fcVar, b16);
            return;
        }
        String str3 = b16.f389605a;
        if (fcVar instanceof fb) {
            str2 = "com.xiaomi.push.new_msg";
        } else if (fcVar instanceof fa) {
            str2 = "com.xiaomi.push.new_iq";
        } else if (fcVar instanceof fq) {
            str2 = "com.xiaomi.push.new_pres";
        } else {
            jz4.c.B("unknown packet type, drop it");
            return;
        }
        Intent intent = new Intent();
        intent.setAction(str2);
        intent.setPackage(str3);
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_packet", fcVar.a());
        intent.putExtra(r.F, b16.f389614j);
        intent.putExtra(r.f389797x, b16.f389613i);
        jz4.c.m(String.format("[Bcst] notify packet arrival. %s,%s,%s", b16.f389612h, b16.f389605a, fcVar.l()));
        if ("3".equalsIgnoreCase(str)) {
            intent.putExtra(r.f389793t, fcVar.f388830j);
            intent.putExtra(r.f389794u, System.currentTimeMillis());
        }
        e(xMPushService, intent, b16);
    }
}
