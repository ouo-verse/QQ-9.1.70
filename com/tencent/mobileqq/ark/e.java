package com.tencent.mobileqq.ark;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, a> f199479a = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        Object a(int i3, Object obj);
    }

    public static Object a(int i3, String str, Object obj, Object obj2) {
        a aVar = f199479a.get(str);
        if (aVar != null) {
            return aVar.a(i3, obj);
        }
        return obj2;
    }
}
