package com.tencent.luggage.wxa.eo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public final Map f125014a = new ConcurrentHashMap(64);

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f125015b = {null};

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f125016c = {null};

    /* renamed from: d, reason: collision with root package name */
    public f f125017d = null;

    public abstract c a(Class cls);

    public abstract Iterable a(com.tencent.luggage.wxa.fo.a aVar);

    public final c b(Class cls) {
        c cVar = (c) this.f125014a.get(cls);
        if (cVar != null) {
            return cVar;
        }
        f fVar = this.f125017d;
        if (fVar != null) {
            try {
                cVar = fVar.b(cls);
            } catch (h unused) {
            }
            if (cVar != null) {
                this.f125014a.put(cls, (d) cVar);
                return cVar;
            }
        }
        c a16 = a(cls);
        if (a16 != null) {
            this.f125014a.put(cls, (d) a16);
        }
        return a16;
    }

    public final Iterable b(com.tencent.luggage.wxa.fo.a aVar) {
        Iterable b16;
        f fVar = this.f125017d;
        return (fVar == null || (b16 = fVar.b(aVar)) == null) ? a(aVar) : b16;
    }
}
