package com.tencent.luggage.wxa.n3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final j0 f135200a = new j0();

    /* renamed from: b, reason: collision with root package name */
    public static final List f135201b = new ArrayList();

    public static final List a() {
        List list = f135201b;
        synchronized (list) {
        }
        return list;
    }

    public static final void a(String appId, String str, String str2) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        List list = f135201b;
        synchronized (list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.k0.d.a(it.next());
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
