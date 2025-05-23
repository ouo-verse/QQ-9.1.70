package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class af implements e {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Integer> f387874a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, Long> f387875b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<String, String> f387876c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static af f387877d;

    /* renamed from: e, reason: collision with root package name */
    private Context f387878e;

    /* renamed from: f, reason: collision with root package name */
    private e f387879f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f387880g;

    af(Context context) {
        this.f387880g = false;
        this.f387878e = context;
        this.f387880g = a(context);
        u.d("SystemCache", "init status is " + this.f387880g + ";  curCache is " + this.f387879f);
    }

    public static synchronized af b(Context context) {
        af afVar;
        synchronized (af.class) {
            if (f387877d == null) {
                f387877d = new af(context.getApplicationContext());
            }
            afVar = f387877d;
        }
        return afVar;
    }

    public final void a() {
        ae aeVar = new ae();
        if (aeVar.a(this.f387878e)) {
            aeVar.a();
            u.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.e
    public final void b(String str, String str2) {
        e eVar;
        f387876c.put(str, str2);
        if (!this.f387880g || (eVar = this.f387879f) == null) {
            return;
        }
        eVar.b(str, str2);
    }

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        ac acVar = new ac();
        this.f387879f = acVar;
        boolean a16 = acVar.a(context);
        if (!a16) {
            ae aeVar = new ae();
            this.f387879f = aeVar;
            a16 = aeVar.a(context);
        }
        if (!a16) {
            this.f387879f = null;
        }
        return a16;
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        e eVar;
        String str3 = f387876c.get(str);
        return (str3 != null || (eVar = this.f387879f) == null) ? str3 : eVar.a(str, str2);
    }
}
