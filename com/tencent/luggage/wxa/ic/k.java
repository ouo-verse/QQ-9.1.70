package com.tencent.luggage.wxa.ic;

import androidx.collection.ArrayMap;
import com.tencent.luggage.wxa.lj.j;
import com.tencent.luggage.wxa.tn.w0;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: q, reason: collision with root package name */
    public static final Map f129896q = new ArrayMap();

    /* renamed from: r, reason: collision with root package name */
    public static final k f129897r = new k();

    /* renamed from: a, reason: collision with root package name */
    public volatile String f129898a;

    /* renamed from: e, reason: collision with root package name */
    public volatile String f129902e;

    /* renamed from: f, reason: collision with root package name */
    public volatile String f129903f;

    /* renamed from: g, reason: collision with root package name */
    public volatile String f129904g;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f129899b = new AtomicInteger();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f129900c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public j.b f129901d = null;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f129905h = false;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f129906i = false;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f129907j = false;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f129908k = false;

    /* renamed from: l, reason: collision with root package name */
    public volatile boolean f129909l = false;

    /* renamed from: m, reason: collision with root package name */
    public volatile int f129910m = -1;

    /* renamed from: n, reason: collision with root package name */
    public volatile int f129911n = 0;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f129912o = false;

    /* renamed from: p, reason: collision with root package name */
    public volatile boolean f129913p = false;

    public static k a(String str) {
        k kVar;
        if (w0.c(str)) {
            return null;
        }
        Map map = f129896q;
        synchronized (map) {
            kVar = (k) map.get(str);
        }
        return kVar;
    }

    public static k b(String str) {
        k a16 = a(str);
        if (a16 == null) {
            return f129897r;
        }
        return a16;
    }
}
