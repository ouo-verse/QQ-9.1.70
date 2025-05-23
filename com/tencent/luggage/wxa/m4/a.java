package com.tencent.luggage.wxa.m4;

import android.util.Log;
import com.tencent.luggage.wxa.tn.w;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f134072a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f134073b = new HashMap(2);

    public a(com.tencent.luggage.wxa.xd.d dVar) {
        this.f134072a = dVar;
    }

    public final void a(Class cls, Object obj) {
        synchronized (this.f134073b) {
            this.f134073b.put(cls, obj);
        }
    }

    public final void r() {
        synchronized (this.f134073b) {
            this.f134073b.clear();
        }
        synchronized (this) {
            w.h("Luggage.AppBrandLogicFactory", "cleanup stack:%s", Log.getStackTraceString(new Throwable()));
            this.f134072a = null;
        }
    }

    public final Collection s() {
        LinkedList linkedList;
        synchronized (this.f134073b) {
            linkedList = new LinkedList(this.f134073b.values());
        }
        return linkedList;
    }

    public final synchronized com.tencent.luggage.wxa.xd.d t() {
        return this.f134072a;
    }

    public Object a(Class cls) {
        synchronized (this.f134073b) {
            Object cast = cls.cast(this.f134073b.get(cls));
            if (cast != null) {
                return cast;
            }
            for (Object obj : this.f134073b.values()) {
                if (cls.isInstance(obj)) {
                    return cls.cast(obj);
                }
            }
            return null;
        }
    }

    public void a(a aVar) {
        synchronized (this.f134073b) {
            this.f134073b.putAll(aVar.f134073b);
        }
    }
}
