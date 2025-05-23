package com.tencent.mapsdk.internal;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class kk<Key, Value> {

    /* renamed from: a, reason: collision with root package name */
    private int f148982a;

    /* renamed from: b, reason: collision with root package name */
    private kk<Key, Value>.a f148983b;

    /* renamed from: c, reason: collision with root package name */
    private kk<Key, Value>.a f148984c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<Key, kk<Key, Value>.a> f148985d = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        Key f148986a;

        /* renamed from: b, reason: collision with root package name */
        Value f148987b;

        /* renamed from: c, reason: collision with root package name */
        kk<Key, Value>.a f148988c;

        /* renamed from: d, reason: collision with root package name */
        kk<Key, Value>.a f148989d;

        /* synthetic */ a(kk kkVar, Object obj, Object obj2, byte b16) {
            this(obj, obj2);
        }

        a(Key key, Value value) {
            this.f148986a = key;
            this.f148987b = value;
        }
    }

    kk(int i3) {
        this.f148982a = i3;
    }

    private void a(Key key, Value value) {
        if (this.f148985d.containsKey(key)) {
            kk<Key, Value>.a aVar = this.f148983b;
            while (true) {
                if (aVar == null) {
                    aVar = null;
                    break;
                } else if (aVar.f148986a.equals(key)) {
                    break;
                } else {
                    aVar = aVar.f148989d;
                }
            }
            if (aVar != null) {
                a((a) aVar);
                return;
            }
            return;
        }
        if (this.f148985d.size() >= this.f148982a) {
            a();
        }
        kk<Key, Value>.a aVar2 = new a(this, key, value, (byte) 0);
        kk<Key, Value>.a aVar3 = this.f148984c;
        if (aVar3 == null) {
            this.f148984c = aVar2;
            this.f148983b = aVar2;
        } else {
            aVar3.f148989d = aVar2;
            aVar2.f148988c = aVar3;
            this.f148984c = aVar2;
        }
        this.f148985d.put(key, aVar2);
    }

    private boolean b(Key key) {
        return this.f148985d.remove(key) != null;
    }

    private boolean c() {
        return this.f148985d.isEmpty();
    }

    private int d() {
        return this.f148985d.size();
    }

    private void e() {
        this.f148985d.clear();
        this.f148984c = null;
        this.f148983b = null;
    }

    public final String toString() {
        StringBuilder sb5 = new StringBuilder();
        kk<Key, Value>.a aVar = this.f148983b;
        if (aVar.f148988c != null) {
            System.out.println("header\u7684pre\u4e0d\u4e3aNULL!");
        }
        sb5.append("header: \n");
        while (aVar != null) {
            sb5.append(aVar.f148986a + "->");
            aVar = aVar.f148989d;
        }
        sb5.append("\ntail: \n");
        kk<Key, Value>.a aVar2 = this.f148984c;
        if (aVar2.f148989d != null) {
            System.out.println("tail\u7684next\u4e0d\u4e3aNULL!");
        }
        while (aVar2 != null) {
            sb5.append(aVar2.f148986a + "<-");
            aVar2 = aVar2.f148988c;
        }
        sb5.append("\n");
        return sb5.toString();
    }

    private boolean b() {
        return a();
    }

    private kk<Key, Value>.a c(Key key) {
        for (kk<Key, Value>.a aVar = this.f148983b; aVar != null; aVar = aVar.f148989d) {
            if (aVar.f148986a.equals(key)) {
                return aVar;
            }
        }
        return null;
    }

    private boolean a() {
        kk<Key, Value>.a aVar = this.f148983b;
        kk<Key, Value>.a aVar2 = aVar.f148989d;
        this.f148983b = aVar2;
        aVar2.f148988c = null;
        Key key = aVar.f148986a;
        return (key == null || this.f148985d.remove(key) == null) ? false : true;
    }

    private Value a(Key key) {
        kk<Key, Value>.a aVar = this.f148985d.get(key);
        if (aVar == null) {
            return null;
        }
        a((a) aVar);
        return aVar.f148987b;
    }

    private void a(kk<Key, Value>.a aVar) {
        kk<Key, Value>.a aVar2;
        if (aVar == null || (aVar2 = this.f148984c) == aVar) {
            return;
        }
        kk<Key, Value>.a aVar3 = this.f148983b;
        if (aVar3 == aVar) {
            kk<Key, Value>.a aVar4 = aVar3.f148989d;
            this.f148983b = aVar4;
            aVar4.f148988c = null;
        } else {
            kk<Key, Value>.a aVar5 = aVar.f148988c;
            aVar5.f148989d = aVar.f148989d;
            aVar.f148989d.f148988c = aVar5;
        }
        aVar2.f148989d = aVar;
        aVar.f148988c = aVar2;
        this.f148984c = aVar;
        aVar.f148989d = null;
    }
}
