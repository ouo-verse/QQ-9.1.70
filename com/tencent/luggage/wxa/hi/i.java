package com.tencent.luggage.wxa.hi;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final e f127208a;

    /* renamed from: b, reason: collision with root package name */
    public List f127209b;

    /* renamed from: c, reason: collision with root package name */
    public final String f127210c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends h {
        public a() {
            super(2, 0, 0, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(i iVar);
    }

    public i(e eVar, String str) {
        this.f127208a = eVar;
        this.f127210c = str;
    }

    public i a(e eVar) {
        if (!b(this.f127208a)) {
            w.b("StepNode", "addChild but not a node group");
            return null;
        }
        if (this.f127209b == null) {
            this.f127209b = new ArrayList();
        }
        i iVar = new i(eVar, !w0.c(this.f127210c) ? String.format("%s%s%d", this.f127210c, this.f127208a.getType() == 3 ? "-" : ".", Integer.valueOf(this.f127209b.size() + 1)) : String.format("%d", Integer.valueOf(this.f127209b.size() + 1)));
        this.f127209b.add(iVar);
        return iVar;
    }

    public String b() {
        return this.f127210c;
    }

    public static boolean b(e eVar) {
        return eVar.getType() == 3 || eVar.getType() == 2;
    }

    public void a(i iVar) {
        if (!b(this.f127208a)) {
            w.b("StepNode", "addChild but not a node group");
            return;
        }
        if (this.f127209b == null) {
            this.f127209b = new ArrayList();
        }
        this.f127209b.add(iVar);
    }

    public com.tencent.luggage.wxa.hi.b a() {
        e eVar = this.f127208a;
        if (eVar instanceof com.tencent.luggage.wxa.hi.b) {
            return (com.tencent.luggage.wxa.hi.b) eVar;
        }
        return null;
    }

    public static void a(i iVar, b bVar) {
        if (iVar == null || bVar == null) {
            return;
        }
        bVar.a(iVar);
        List list = iVar.f127209b;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            a((i) list.get(i3), bVar);
        }
    }

    public static i a(List list, String str) {
        i iVar = new i(new a(), "");
        iVar.a(new i((e) list.get(0), ""));
        HashMap hashMap = new HashMap();
        for (int i3 = 1; i3 < list.size() - 1; i3++) {
            e eVar = (e) list.get(i3);
            int c16 = eVar.c();
            if (c16 <= 0) {
                int e16 = eVar.e();
                i iVar2 = new i(eVar, "");
                iVar.a(iVar2);
                hashMap.put(Integer.valueOf(e16), iVar2);
            } else {
                i iVar3 = (i) hashMap.get(Integer.valueOf(c16));
                if (iVar3 != null && (w0.c(eVar.a()) || w0.c(str) || str.equals(eVar.a()))) {
                    i a16 = iVar3.a(eVar);
                    if (b(eVar)) {
                        hashMap.put(Integer.valueOf(eVar.e()), a16);
                    }
                }
            }
        }
        iVar.a(new i((e) list.get(list.size() - 1), ""));
        return iVar;
    }
}
