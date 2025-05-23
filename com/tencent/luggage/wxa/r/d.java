package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.q.l;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public final l f139042a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends o {
        public a(String str) {
            super(str);
        }
    }

    public d(l lVar) {
        this.f139042a = lVar;
    }

    public final void a(com.tencent.luggage.wxa.n0.l lVar, long j3) {
        if (a(lVar)) {
            b(lVar, j3);
        }
    }

    public abstract boolean a(com.tencent.luggage.wxa.n0.l lVar);

    public abstract void b(com.tencent.luggage.wxa.n0.l lVar, long j3);
}
