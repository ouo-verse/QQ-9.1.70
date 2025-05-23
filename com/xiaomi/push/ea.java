package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.service.am;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
class ea {
    public static void a(am.b bVar, String str, ep epVar) {
        String str2;
        String b16;
        cr crVar = new cr();
        if (!TextUtils.isEmpty(bVar.f389607c)) {
            crVar.k(bVar.f389607c);
        }
        if (!TextUtils.isEmpty(bVar.f389610f)) {
            crVar.t(bVar.f389610f);
        }
        if (!TextUtils.isEmpty(bVar.f389611g)) {
            crVar.w(bVar.f389611g);
        }
        if (bVar.f389609e) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        crVar.n(str2);
        if (!TextUtils.isEmpty(bVar.f389608d)) {
            crVar.q(bVar.f389608d);
        } else {
            crVar.q("XIAOMI-SASL");
        }
        eb ebVar = new eb();
        ebVar.B(bVar.f389606b);
        ebVar.h(Integer.parseInt(bVar.f389612h));
        ebVar.v(bVar.f389605a);
        ebVar.l("BIND", null);
        ebVar.k(ebVar.D());
        jz4.c.m("[Slim]: bind id=" + ebVar.D());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.f389607c);
        hashMap.put("chid", bVar.f389612h);
        hashMap.put("from", bVar.f389606b);
        hashMap.put("id", ebVar.D());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f389609e) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (!TextUtils.isEmpty(bVar.f389610f)) {
            hashMap.put("client_attrs", bVar.f389610f);
        } else {
            hashMap.put("client_attrs", "");
        }
        if (!TextUtils.isEmpty(bVar.f389611g)) {
            hashMap.put("cloud_attrs", bVar.f389611g);
        } else {
            hashMap.put("cloud_attrs", "");
        }
        if (!bVar.f389608d.equals("XIAOMI-PASS") && !bVar.f389608d.equals("XMPUSH-PASS")) {
            bVar.f389608d.equals("XIAOMI-SASL");
            b16 = null;
        } else {
            b16 = ab.b(bVar.f389608d, null, hashMap, bVar.f389613i);
        }
        crVar.z(b16);
        ebVar.n(crVar.h(), null);
        epVar.w(ebVar);
    }

    public static void b(String str, String str2, ep epVar) {
        eb ebVar = new eb();
        ebVar.B(str2);
        ebVar.h(Integer.parseInt(str));
        ebVar.l("UBND", null);
        epVar.w(ebVar);
    }
}
