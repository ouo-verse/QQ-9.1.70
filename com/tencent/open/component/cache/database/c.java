package com.tencent.open.component.cache.database;

import android.content.Context;
import com.tencent.open.component.cache.database.b;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    protected static c f341136d;

    /* renamed from: a, reason: collision with root package name */
    protected Context f341137a;

    /* renamed from: b, reason: collision with root package name */
    protected final HashMap<String, b> f341138b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    protected b.InterfaceC9276b f341139c = new a();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements b.InterfaceC9276b {
        a() {
        }
    }

    protected c(Context context) {
        this.f341137a = context.getApplicationContext();
    }

    public static c b(Context context) {
        c cVar;
        c cVar2 = f341136d;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (c.class) {
            if (f341136d == null) {
                f341136d = new c(context);
            }
            cVar = f341136d;
        }
        return cVar;
    }

    public b a(Class<? extends com.tencent.open.component.cache.database.a> cls, long j3, String str) throws RuntimeException {
        b bVar;
        synchronized (this.f341138b) {
            if (this.f341137a != null) {
                if (str != null) {
                    bVar = this.f341138b.get(AbstractDbCacheManager.s(j3, str));
                    if (bVar == null) {
                        bVar = new b(this.f341137a, cls, j3, str);
                        bVar.C(this.f341139c);
                        this.f341138b.put(bVar.r(), bVar);
                    }
                } else {
                    throw new RuntimeException("invalid table name");
                }
            } else {
                throw new RuntimeException("call initiate(Context context) before this");
            }
        }
        return bVar;
    }
}
