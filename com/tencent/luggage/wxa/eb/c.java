package com.tencent.luggage.wxa.eb;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f124603a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final String f124604b = "MicroMsg.GLObjectFactory";

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f124605c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f124606d = new HashMap();

    public static final d a(boolean z16, long j3) {
        d dVar = new d(z16, j3);
        f124605c.put(Integer.valueOf(dVar.hashCode()), new WeakReference(dVar));
        return dVar;
    }

    public final a a(long j3) {
        a aVar = new a(j3);
        f124606d.put(Integer.valueOf(aVar.hashCode()), new WeakReference(aVar));
        return aVar;
    }
}
