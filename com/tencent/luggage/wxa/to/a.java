package com.tencent.luggage.wxa.to;

import com.tencent.luggage.wxa.yo.d;
import com.tencent.luggage.wxa.yo.e;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public LinkedList f141773a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    public d f141774b;

    /* renamed from: c, reason: collision with root package name */
    public e f141775c;

    public a(d dVar) {
        com.tencent.luggage.wxa.er.a.a(dVar);
        this.f141774b = dVar;
        this.f141775c = new e(dVar, null);
    }

    public synchronized b a(b bVar) {
        if (bVar == null) {
            return null;
        }
        this.f141773a.add(bVar);
        return bVar;
    }

    public synchronized void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f141773a.remove(bVar);
    }

    public synchronized LinkedList a() {
        return b();
    }

    public LinkedList b() {
        return new LinkedList(this.f141773a);
    }
}
