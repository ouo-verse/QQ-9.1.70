package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import com.tencent.qqlive.ona.protocol.jce.AdVideoItem;
import java.util.HashMap;
import java.util.Map;
import kt3.j;
import pw2.w;
import pw2.y;
import sv2.a;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class a {

    /* renamed from: b, reason: collision with root package name */
    protected Context f303573b;

    /* renamed from: a, reason: collision with root package name */
    protected Map<String, Object> f303572a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private int f303574c = -1;

    public a(Context context) {
        this.f303573b = context;
    }

    private void a(Object obj) {
        Map<String, String> d16;
        if ((obj instanceof AdOrderItem) && (d16 = gw2.b.d(((AdOrderItem) obj).vrReportMap)) != null) {
            this.f303572a.putAll(d16);
        }
    }

    private boolean c(boolean z16) {
        if (z16) {
            return true;
        }
        Context context = this.f303573b;
        if (context != null) {
            return y.k(context);
        }
        return false;
    }

    private boolean e(int i3) {
        int i16 = this.f303574c;
        if ((i16 == 4 && i3 == 9) || i16 == i3) {
            return true;
        }
        return false;
    }

    protected abstract long b(j jVar);

    public void d(View view) {
        Map<String, Object> g16 = w.g(view);
        if (g16 != null) {
            g16.remove("eid");
            this.f303572a.putAll(g16);
        }
    }

    protected abstract void f(int i3, sv2.a aVar);

    public void g(@NonNull com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.e eVar) {
        long j3;
        String str;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.d dVar = eVar.f303609f;
        if (dVar == null) {
            return;
        }
        AdVideoItem adVideoItem = dVar.f303594a;
        if (adVideoItem != null) {
            j3 = adVideoItem.duration;
        } else {
            j3 = 0;
        }
        a.C11255a c11255a = new a.C11255a();
        if (adVideoItem != null) {
            str = adVideoItem.vid;
        } else {
            str = "";
        }
        a.C11255a c16 = c11255a.b(str).c(dVar.f303596c);
        boolean z16 = true;
        a.C11255a g16 = c16.d(1).e(dVar.f303595b).f(dVar.f303595b).m(dVar.f303595b).p(j3).k(eVar.f303608e).j(c(eVar.f303608e)).g(eVar.f303604a);
        if (4 != eVar.f303605b) {
            z16 = false;
        }
        a.C11255a i3 = g16.q(z16).o(dVar.f303598e).i(eVar.f303607d);
        j jVar = dVar.f303597d;
        if (jVar != null) {
            i3.h(jVar.e()).n(jVar.h()).l(b(jVar));
        }
        a(eVar.f303606c);
        f(eVar.f303605b, i3.a());
    }

    public void h(@NonNull com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.e eVar) {
        if (e(eVar.f303605b)) {
            return;
        }
        this.f303574c = eVar.f303605b;
        g(eVar);
    }
}
