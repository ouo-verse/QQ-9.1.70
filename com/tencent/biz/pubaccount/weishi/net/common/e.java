package com.tencent.biz.pubaccount.weishi.net.common;

import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e<T extends JceStruct> {

    /* renamed from: a, reason: collision with root package name */
    private final WSServiceExecutor<T> f80945a;

    e(g<T> gVar) {
        WSServiceExecutor<T> wSServiceExecutor = new WSServiceExecutor<>();
        this.f80945a = wSServiceExecutor;
        wSServiceExecutor.l(gVar);
    }

    public static <T extends JceStruct> e<T> a(g<T> gVar) {
        return new e<>(gVar);
    }

    public <E> void b(b<T, E> bVar) {
        this.f80945a.i(bVar);
    }
}
