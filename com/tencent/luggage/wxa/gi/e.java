package com.tencent.luggage.wxa.gi;

import com.tencent.luggage.wxa.hi.i;
import com.tencent.luggage.wxa.hi.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joor.Reflect;
import org.joor.ReflectException;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static Map f126768a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static Map f126769b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static Map f126770c = new HashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements i.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f126771a;

        public a(List list) {
            this.f126771a = list;
        }

        @Override // com.tencent.luggage.wxa.hi.i.b
        public void a(i iVar) {
            com.tencent.luggage.wxa.hi.b a16 = iVar.a();
            if (a16 == null) {
                return;
            }
            this.f126771a.add(new k(a16, iVar.b()));
        }
    }

    public static String a(Class cls) {
        String name = cls.getName();
        if (f126768a.containsKey(name)) {
            return (String) f126768a.get(name);
        }
        try {
            String str = (String) cls.getDeclaredField("NAME").get(null);
            f126768a.put(name, str);
            return str;
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return null;
        }
    }

    public static i b(Class cls, String str) {
        i a16;
        String str2 = cls.getName() + "\u2014" + str;
        if (f126770c.containsKey(str2)) {
            return (i) f126770c.get(str2);
        }
        try {
            List list = (List) Reflect.on((Class<?>) cls).get("sStepNodes");
            if (list == null || (a16 = i.a(list, str)) == null) {
                return null;
            }
            f126770c.put(str2, a16);
            return a16;
        } catch (ReflectException unused) {
            return null;
        }
    }

    public static List a(Class cls, String str) {
        String str2 = cls.getName() + "_" + str;
        if (f126769b.containsKey(str2)) {
            return (List) f126769b.get(str2);
        }
        ArrayList arrayList = new ArrayList();
        a(cls, new a(arrayList), str);
        f126769b.put(str2, arrayList);
        return arrayList;
    }

    public static void a(Class cls, i.b bVar, String str) {
        i.a(b(cls, str), bVar);
    }
}
