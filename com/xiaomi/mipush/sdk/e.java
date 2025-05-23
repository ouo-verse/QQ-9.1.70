package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gk;
import com.xiaomi.push.service.ah;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class e implements com.xiaomi.mipush.sdk.a {

    /* renamed from: e, reason: collision with root package name */
    private static volatile e f388051e;

    /* renamed from: a, reason: collision with root package name */
    private Context f388052a;

    /* renamed from: b, reason: collision with root package name */
    private n f388053b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f388054c = false;

    /* renamed from: d, reason: collision with root package name */
    private Map<d, com.xiaomi.mipush.sdk.a> f388055d = new HashMap();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f388057a;

        static {
            int[] iArr = new int[d.values().length];
            f388057a = iArr;
            try {
                iArr[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f388057a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f388057a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f388057a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    e(Context context) {
        this.f388052a = context.getApplicationContext();
    }

    public static e c(Context context) {
        if (f388051e == null) {
            synchronized (e.class) {
                if (f388051e == null) {
                    f388051e = new e(context);
                }
            }
        }
        return f388051e;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        com.xiaomi.mipush.sdk.a b16;
        d dVar;
        com.xiaomi.mipush.sdk.a b17;
        d dVar2;
        com.xiaomi.mipush.sdk.a b18;
        d dVar3;
        com.xiaomi.mipush.sdk.a b19;
        n nVar = this.f388053b;
        if (nVar != null) {
            if (nVar.d()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("ASSEMBLE_PUSH : ");
                sb5.append(" HW user switch : " + this.f388053b.d() + " HW online switch : " + f.g(this.f388052a, d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + x.c(this.f388052a));
                jz4.c.m(sb5.toString());
            }
            if (this.f388053b.d()) {
                Context context = this.f388052a;
                d dVar4 = d.ASSEMBLE_PUSH_HUAWEI;
                if (f.g(context, dVar4) && x.c(this.f388052a)) {
                    if (!h(dVar4)) {
                        g(dVar4, ae.a(this.f388052a, dVar4));
                    }
                    jz4.c.z("hw manager add to list");
                    if (this.f388053b.b()) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("ASSEMBLE_PUSH : ");
                        sb6.append(" FCM user switch : " + this.f388053b.b() + " FCM online switch : " + f.g(this.f388052a, d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + x.d(this.f388052a));
                        jz4.c.m(sb6.toString());
                    }
                    if (this.f388053b.b()) {
                        Context context2 = this.f388052a;
                        d dVar5 = d.ASSEMBLE_PUSH_FCM;
                        if (f.g(context2, dVar5) && x.d(this.f388052a)) {
                            if (!h(dVar5)) {
                                g(dVar5, ae.a(this.f388052a, dVar5));
                            }
                            jz4.c.z("fcm manager add to list");
                            if (this.f388053b.a()) {
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("ASSEMBLE_PUSH : ");
                                sb7.append(" COS user switch : " + this.f388053b.a() + " COS online switch : " + f.g(this.f388052a, d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + x.e(this.f388052a));
                                jz4.c.m(sb7.toString());
                            }
                            if (this.f388053b.a()) {
                                Context context3 = this.f388052a;
                                d dVar6 = d.ASSEMBLE_PUSH_COS;
                                if (f.g(context3, dVar6) && x.e(this.f388052a)) {
                                    g(dVar6, ae.a(this.f388052a, dVar6));
                                    if (this.f388053b.c()) {
                                        Context context4 = this.f388052a;
                                        d dVar7 = d.ASSEMBLE_PUSH_FTOS;
                                        if (f.g(context4, dVar7) && x.f(this.f388052a)) {
                                            g(dVar7, ae.a(this.f388052a, dVar7));
                                            return;
                                        }
                                    }
                                    dVar3 = d.ASSEMBLE_PUSH_FTOS;
                                    if (!h(dVar3) && (b19 = b(dVar3)) != null) {
                                        f(dVar3);
                                        b19.unregister();
                                        return;
                                    }
                                    return;
                                }
                            }
                            dVar2 = d.ASSEMBLE_PUSH_COS;
                            if (h(dVar2) && (b18 = b(dVar2)) != null) {
                                f(dVar2);
                                b18.unregister();
                            }
                            if (this.f388053b.c()) {
                            }
                            dVar3 = d.ASSEMBLE_PUSH_FTOS;
                            if (!h(dVar3)) {
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    dVar = d.ASSEMBLE_PUSH_FCM;
                    if (h(dVar) && (b17 = b(dVar)) != null) {
                        f(dVar);
                        b17.unregister();
                    }
                    if (this.f388053b.a()) {
                    }
                    if (this.f388053b.a()) {
                    }
                    dVar2 = d.ASSEMBLE_PUSH_COS;
                    if (h(dVar2)) {
                        f(dVar2);
                        b18.unregister();
                    }
                    if (this.f388053b.c()) {
                    }
                    dVar3 = d.ASSEMBLE_PUSH_FTOS;
                    if (!h(dVar3)) {
                    }
                }
            }
            d dVar8 = d.ASSEMBLE_PUSH_HUAWEI;
            if (h(dVar8) && (b16 = b(dVar8)) != null) {
                f(dVar8);
                b16.unregister();
            }
            if (this.f388053b.b()) {
            }
            if (this.f388053b.b()) {
            }
            dVar = d.ASSEMBLE_PUSH_FCM;
            if (h(dVar)) {
                f(dVar);
                b17.unregister();
            }
            if (this.f388053b.a()) {
            }
            if (this.f388053b.a()) {
            }
            dVar2 = d.ASSEMBLE_PUSH_COS;
            if (h(dVar2)) {
            }
            if (this.f388053b.c()) {
            }
            dVar3 = d.ASSEMBLE_PUSH_FTOS;
            if (!h(dVar3)) {
            }
        }
    }

    public com.xiaomi.mipush.sdk.a b(d dVar) {
        return this.f388055d.get(dVar);
    }

    public void e(n nVar) {
        this.f388053b = nVar;
        this.f388054c = ah.d(this.f388052a).m(gk.AggregatePushSwitch.a(), true);
        if (this.f388053b.d() || this.f388053b.b() || this.f388053b.a() || this.f388053b.c()) {
            ah.d(this.f388052a).j(new ah.a(101, "assemblePush") { // from class: com.xiaomi.mipush.sdk.e.1
                @Override // com.xiaomi.push.service.ah.a
                protected void e() {
                    boolean m3 = ah.d(e.this.f388052a).m(gk.AggregatePushSwitch.a(), true);
                    if (e.this.f388054c != m3) {
                        e.this.f388054c = m3;
                        f.l(e.this.f388052a);
                    }
                }
            });
        }
    }

    public void f(d dVar) {
        this.f388055d.remove(dVar);
    }

    public void g(d dVar, com.xiaomi.mipush.sdk.a aVar) {
        if (aVar != null) {
            if (this.f388055d.containsKey(dVar)) {
                this.f388055d.remove(dVar);
            }
            this.f388055d.put(dVar, aVar);
        }
    }

    public boolean h(d dVar) {
        return this.f388055d.containsKey(dVar);
    }

    public boolean k(d dVar) {
        int i3 = a.f388057a[dVar.ordinal()];
        boolean z16 = false;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return false;
                    }
                } else {
                    n nVar = this.f388053b;
                    if (nVar != null) {
                        z16 = nVar.a();
                    }
                }
                n nVar2 = this.f388053b;
                if (nVar2 != null) {
                    return nVar2.c();
                }
                return z16;
            }
            n nVar3 = this.f388053b;
            if (nVar3 == null) {
                return false;
            }
            return nVar3.b();
        }
        n nVar4 = this.f388053b;
        if (nVar4 == null) {
            return false;
        }
        return nVar4.d();
    }

    @Override // com.xiaomi.mipush.sdk.a
    public void register() {
        jz4.c.m("ASSEMBLE_PUSH : assemble push register");
        if (this.f388055d.size() <= 0) {
            d();
        }
        if (this.f388055d.size() > 0) {
            for (com.xiaomi.mipush.sdk.a aVar : this.f388055d.values()) {
                if (aVar != null) {
                    aVar.register();
                }
            }
            f.f(this.f388052a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.a
    public void unregister() {
        jz4.c.m("ASSEMBLE_PUSH : assemble push unregister");
        for (com.xiaomi.mipush.sdk.a aVar : this.f388055d.values()) {
            if (aVar != null) {
                aVar.unregister();
            }
        }
        this.f388055d.clear();
    }
}
