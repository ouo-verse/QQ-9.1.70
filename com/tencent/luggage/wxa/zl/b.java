package com.tencent.luggage.wxa.zl;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.ol.q;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public a f146732a;

    public abstract View a();

    public final com.tencent.luggage.wxa.zf.c a(Class cls) {
        a b16 = b(false);
        if (b16 == null || !cls.isInstance(b16.getPicker())) {
            return null;
        }
        return b16.getPicker();
    }

    public final com.tencent.luggage.wxa.zf.c b(Class cls) {
        w.a("MicroMsg.AppBrandBottomPickerInvokeHandler", "" + cls.getSimpleName());
        a c16 = c();
        if (c16 == null) {
            return null;
        }
        try {
            c16.setPickerImpl((com.tencent.luggage.wxa.zf.c) cls.getDeclaredConstructor(Context.class).newInstance(c16.getContext()));
            return c16.getPicker();
        } catch (Exception unused) {
            return null;
        }
    }

    public final a c() {
        a b16 = b(true);
        this.f146732a = b16;
        return b16;
    }

    public a a(Context context) {
        return new a(context);
    }

    public final a b(boolean z16) {
        q b16;
        a aVar = this.f146732a;
        if (aVar != null) {
            return aVar;
        }
        View a16 = a();
        if (a16 == null || (b16 = q.b(a16)) == null) {
            return null;
        }
        a c16 = a.c(b16);
        if (c16 == null && z16) {
            c16 = a(a16.getContext());
        }
        b16.a((View) c16, true);
        return c16;
    }

    public final a b() {
        return this.f146732a;
    }
}
