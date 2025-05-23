package com.xiaomi.push;

import android.content.Context;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class cb {

    /* renamed from: a, reason: collision with root package name */
    private final String f388360a = "power_consumption_stats";

    /* renamed from: b, reason: collision with root package name */
    private final String f388361b = "off_up_ct";

    /* renamed from: c, reason: collision with root package name */
    private final String f388362c = "off_dn_ct";

    /* renamed from: d, reason: collision with root package name */
    private final String f388363d = "off_ping_ct";

    /* renamed from: e, reason: collision with root package name */
    private final String f388364e = "off_pong_ct";

    /* renamed from: f, reason: collision with root package name */
    private final String f388365f = "off_dur";

    /* renamed from: g, reason: collision with root package name */
    private final String f388366g = "on_up_ct";

    /* renamed from: h, reason: collision with root package name */
    private final String f388367h = "on_dn_ct";

    /* renamed from: i, reason: collision with root package name */
    private final String f388368i = "on_ping_ct";

    /* renamed from: j, reason: collision with root package name */
    private final String f388369j = "on_pong_ct";

    /* renamed from: k, reason: collision with root package name */
    private final String f388370k = "on_dur";

    /* renamed from: l, reason: collision with root package name */
    private final String f388371l = "start_time";

    /* renamed from: m, reason: collision with root package name */
    private final String f388372m = "end_time";

    /* renamed from: n, reason: collision with root package name */
    private final String f388373n = "xmsf_vc";

    /* renamed from: o, reason: collision with root package name */
    private final String f388374o = "android_vc";

    /* renamed from: p, reason: collision with root package name */
    private final String f388375p = "uuid";

    public void a(Context context, ca caVar) {
        if (caVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("off_up_ct", Integer.valueOf(caVar.a()));
        hashMap.put("off_dn_ct", Integer.valueOf(caVar.e()));
        hashMap.put("off_ping_ct", Integer.valueOf(caVar.i()));
        hashMap.put("off_pong_ct", Integer.valueOf(caVar.m()));
        hashMap.put("off_dur", Long.valueOf(caVar.b()));
        hashMap.put("on_up_ct", Integer.valueOf(caVar.q()));
        hashMap.put("on_dn_ct", Integer.valueOf(caVar.s()));
        hashMap.put("on_ping_ct", Integer.valueOf(caVar.u()));
        hashMap.put("on_pong_ct", Integer.valueOf(caVar.w()));
        hashMap.put("on_dur", Long.valueOf(caVar.f()));
        hashMap.put("start_time", Long.valueOf(caVar.j()));
        hashMap.put("end_time", Long.valueOf(caVar.n()));
        hashMap.put("xmsf_vc", Integer.valueOf(caVar.y()));
        hashMap.put("android_vc", Integer.valueOf(caVar.A()));
        hashMap.put("uuid", com.xiaomi.push.service.av.d(context));
        dv.b().a("power_consumption_stats", hashMap);
    }
}
