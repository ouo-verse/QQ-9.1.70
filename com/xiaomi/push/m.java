package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes28.dex */
class m implements j {

    /* renamed from: a, reason: collision with root package name */
    private Context f389451a;

    /* renamed from: b, reason: collision with root package name */
    private Class<?> f389452b;

    /* renamed from: c, reason: collision with root package name */
    private Object f389453c;

    /* renamed from: d, reason: collision with root package name */
    private Method f389454d = null;

    /* renamed from: e, reason: collision with root package name */
    private Method f389455e = null;

    /* renamed from: f, reason: collision with root package name */
    private Method f389456f = null;

    /* renamed from: g, reason: collision with root package name */
    private Method f389457g = null;

    public m(Context context) {
        this.f389451a = context;
        c(context);
    }

    private String b(Context context, Method method) {
        Object obj = this.f389453c;
        if (obj != null && method != null) {
            try {
                Object invoke = method.invoke(obj, context);
                if (invoke != null) {
                    return (String) invoke;
                }
                return null;
            } catch (Exception e16) {
                jz4.c.o("miui invoke error", e16);
                return null;
            }
        }
        return null;
    }

    private void c(Context context) {
        try {
            Class<?> c16 = ii.c(context, "com.android.id.impl.IdProviderImpl");
            this.f389452b = c16;
            this.f389453c = c16.newInstance();
            this.f389455e = this.f389452b.getMethod(com.tencent.luggage.wxa.q2.e.NAME, Context.class);
        } catch (Exception e16) {
            jz4.c.o("miui load class error", e16);
        }
    }

    @Override // com.xiaomi.push.j
    /* renamed from: a */
    public boolean mo299a() {
        return (this.f389452b == null || this.f389453c == null) ? false : true;
    }

    @Override // com.xiaomi.push.j
    public String a() {
        return b(this.f389451a, this.f389455e);
    }
}
