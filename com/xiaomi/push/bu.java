package com.xiaomi.push;

import android.content.Context;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bu {

    /* renamed from: a, reason: collision with root package name */
    private final String f388310a = "disconnection_event";

    /* renamed from: b, reason: collision with root package name */
    private final String f388311b = "count";

    /* renamed from: c, reason: collision with root package name */
    private final String f388312c = "host";

    /* renamed from: d, reason: collision with root package name */
    private final String f388313d = TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_NETWORK_STATE;

    /* renamed from: e, reason: collision with root package name */
    private final String f388314e = "reason";

    /* renamed from: f, reason: collision with root package name */
    private final String f388315f = "ping_interval";

    /* renamed from: g, reason: collision with root package name */
    private final String f388316g = "network_type";

    /* renamed from: h, reason: collision with root package name */
    private final String f388317h = "wifi_digest";

    /* renamed from: i, reason: collision with root package name */
    private final String f388318i = "duration";

    /* renamed from: j, reason: collision with root package name */
    private final String f388319j = "disconnect_time";

    /* renamed from: k, reason: collision with root package name */
    private final String f388320k = "connect_time";

    /* renamed from: l, reason: collision with root package name */
    private final String f388321l = "xmsf_vc";

    /* renamed from: m, reason: collision with root package name */
    private final String f388322m = "android_vc";

    /* renamed from: n, reason: collision with root package name */
    private final String f388323n = "uuid";

    public void a(Context context, List<bo> list) {
        if (list != null && list.size() != 0) {
            bm.g("upload size = " + list.size());
            String d16 = com.xiaomi.push.service.av.d(context);
            for (bo boVar : list) {
                HashMap hashMap = new HashMap();
                hashMap.put("count", Integer.valueOf(boVar.a()));
                hashMap.put("host", boVar.c());
                hashMap.put(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_NETWORK_STATE, Integer.valueOf(boVar.g()));
                hashMap.put("reason", Integer.valueOf(boVar.m()));
                hashMap.put("ping_interval", Long.valueOf(boVar.b()));
                hashMap.put("network_type", Integer.valueOf(boVar.q()));
                hashMap.put("wifi_digest", boVar.i());
                hashMap.put("connected_network_type", Integer.valueOf(boVar.u()));
                hashMap.put("duration", Long.valueOf(boVar.h()));
                hashMap.put("disconnect_time", Long.valueOf(boVar.n()));
                hashMap.put("connect_time", Long.valueOf(boVar.r()));
                hashMap.put("xmsf_vc", Integer.valueOf(boVar.w()));
                hashMap.put("android_vc", Integer.valueOf(boVar.y()));
                hashMap.put("uuid", d16);
                dv.b().a("disconnection_event", hashMap);
            }
        }
    }
}
