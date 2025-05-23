package com.tencent.luggage.wxa.fa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static a f125587c;

    /* renamed from: a, reason: collision with root package name */
    public final d f125588a = new C6203a();

    /* renamed from: b, reason: collision with root package name */
    public final e f125589b = new b();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.fa.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6203a implements d {
        public C6203a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements e {
        public b() {
        }
    }

    public static a a() {
        if (f125587c == null) {
            synchronized (a.class) {
                if (f125587c == null) {
                    f125587c = new a();
                }
            }
        }
        return f125587c;
    }

    public void b(Object obj, int i3) {
        boolean z16 = obj instanceof Fragment;
    }

    public void c(Object obj, boolean z16) {
        boolean z17 = obj instanceof Activity;
    }

    public void b(Object obj, boolean z16) {
        boolean z17 = obj instanceof Fragment;
    }

    public void b(Object obj, Intent intent) {
        c.a(obj);
    }

    public void a(Object obj, boolean z16) {
        boolean z17 = obj instanceof Fragment;
    }

    public void a(Object obj, int i3) {
        if (obj instanceof Context) {
            boolean z16 = obj instanceof Activity;
        }
    }

    public void a(Object obj, Intent intent) {
        c.a(obj);
    }

    public void a(Object obj, Intent[] intentArr) {
        c.a(obj);
    }

    public void a(Object obj) {
        boolean z16 = obj instanceof Activity;
    }

    public void a(Map map, com.tencent.luggage.wxa.ia.b bVar) {
        com.tencent.luggage.wxa.ia.a.a(map, bVar);
    }

    public Object a(String str, String str2, String str3, String str4, String str5, String str6, Object obj, Object[] objArr) {
        return com.tencent.luggage.wxa.ia.a.a(str, str2, str3, str4, str5, str6, obj, objArr);
    }
}
