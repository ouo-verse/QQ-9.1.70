package com.tencent.luggage.wxa.xd;

import org.joor.Reflect;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class c {
    private static final String TAG = "MicroMsg.AppBrand.BaseJsApi";
    private String mCachedApiName;

    public c() {
        boolean z16;
        if (com.tencent.luggage.wxa.tn.e.f141559a && getName() == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        com.tencent.luggage.wxa.er.a.b("Must declare NAME in subclasses", z16);
    }

    public final String getName() {
        if (com.tencent.luggage.wxa.tn.w0.c(this.mCachedApiName)) {
            try {
                this.mCachedApiName = (String) Reflect.on(getClass()).field("NAME").get();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b(TAG, "getName exp = %s", com.tencent.luggage.wxa.tn.w0.a((Throwable) e16));
            }
        }
        return this.mCachedApiName;
    }
}
