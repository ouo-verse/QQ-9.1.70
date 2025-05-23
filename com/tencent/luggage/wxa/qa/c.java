package com.tencent.luggage.wxa.qa;

import android.os.Parcel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f138548a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    public static final List f138549b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    public static final Map f138550c = new HashMap();

    public static a a(String str) {
        a aVar;
        synchronized (f138548a) {
            aVar = (a) f138550c.get(str);
        }
        return aVar;
    }

    public static a a(Object obj) {
        synchronized (f138548a) {
            for (a aVar : f138549b) {
                if (aVar.a(obj)) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public static Object a(String str, Parcel parcel) {
        a a16 = a(str);
        if (a16 != null) {
            return a16.a(parcel);
        }
        com.tencent.luggage.wxa.ta.c.e("Luggage.ObjectTypeTransfer", "Get transferClass '%s' return null", str);
        return null;
    }

    public static void a(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (f138548a) {
            List list = f138549b;
            if (list.contains(aVar)) {
                return;
            }
            f138550c.put(aVar.getName(), aVar);
            list.add(aVar);
        }
    }
}
