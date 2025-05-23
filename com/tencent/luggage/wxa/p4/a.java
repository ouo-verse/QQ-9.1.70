package com.tencent.luggage.wxa.p4;

import android.content.Context;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import b31.z;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kj.x;
import com.tencent.luggage.wxa.tn.w;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends com.tencent.luggage.wxa.m4.a implements x {
    public a(@NonNull com.tencent.luggage.wxa.m4.b bVar) {
        super(bVar);
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public /* synthetic */ void a(com.tencent.luggage.wxa.kl.b bVar) {
        z.a(this, bVar);
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public boolean b() {
        return false;
    }

    public void h() {
        for (Object obj : s()) {
            if (obj instanceof com.tencent.luggage.wxa.mj.c) {
                ((com.tencent.luggage.wxa.mj.c) obj).onBackground();
            }
        }
    }

    public void o() {
        for (Object obj : s()) {
            if (obj instanceof com.tencent.luggage.wxa.mj.c) {
                ((com.tencent.luggage.wxa.mj.c) obj).onForeground();
            }
        }
    }

    public final String u() {
        com.tencent.luggage.wxa.xd.d t16 = t();
        if (t16 == null) {
            w.a("Luggage.AbstractPageViewRenderer", new Throwable(), "getAppId", new Object[0]);
            return null;
        }
        return t16.getAppId();
    }

    public Context v() {
        Context context = ((com.tencent.luggage.wxa.m4.b) t()).getContext();
        if (context == null) {
            return com.tencent.luggage.wxa.tn.z.c();
        }
        return context;
    }

    public com.tencent.luggage.wxa.c5.e w() {
        com.tencent.luggage.wxa.m4.b bVar = (com.tencent.luggage.wxa.m4.b) t();
        if (bVar == null) {
            return null;
        }
        return bVar.getRuntime();
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public void a(com.tencent.luggage.wxa.wj.c cVar) {
    }

    public final com.tencent.luggage.wxa.h1.b b(Class cls) {
        return ((com.tencent.luggage.wxa.m4.b) t()).b(cls);
    }

    public void a(Map map, k1 k1Var) {
    }

    public void a() {
        for (Object obj : s()) {
            if (obj instanceof com.tencent.luggage.wxa.mj.c) {
                ((com.tencent.luggage.wxa.mj.c) obj).onDestroy();
            }
        }
        super.r();
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public void a(Configuration configuration) {
        for (Object obj : s()) {
            if (obj instanceof com.tencent.luggage.wxa.mj.c) {
                ((com.tencent.luggage.wxa.mj.c) obj).onConfigurationChanged(configuration);
            }
        }
    }

    public void m() {
    }
}
