package com.tencent.luggage.wxa.tc;

import android.text.TextUtils;
import com.tencent.luggage.wxa.hn.e0;
import com.tencent.luggage.wxa.hn.f0;
import com.tencent.luggage.wxa.hn.t7;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g implements i {

    /* renamed from: a, reason: collision with root package name */
    public final String f141234a;

    public g(String str) {
        this.f141234a = str;
    }

    @Override // com.tencent.luggage.wxa.tc.i
    public void a(List list, List list2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f0 f0Var = (f0) it.next();
            e0 a16 = a(list2, f0Var);
            if (f0Var.f127590f != 0 || a16 == null) {
                w.h("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi success, but app(%s) failed to fetch data", f0Var.f127588d);
            } else {
                a(a16, f0Var);
            }
        }
    }

    public final e0 a(List list, f0 f0Var) {
        if (f0Var == null || w0.c(f0Var.f127588d) || list == null || list.isEmpty()) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e0 e0Var = (e0) it.next();
            if (f0Var.f127588d.equalsIgnoreCase(e0Var.f127530d)) {
                return e0Var;
            }
        }
        return null;
    }

    public final void a(e0 e0Var, f0 f0Var) {
        if (e0Var != null && f0Var != null) {
            if (!w0.c(f0Var.f127588d) && !w0.c(f0Var.f127589e)) {
                long c16 = w0.c();
                String str = f0Var.f127588d;
                String str2 = f0Var.f127589e;
                int i3 = e0Var.f127531e;
                t7 t7Var = e0Var.f127532f;
                String str3 = t7Var != null ? t7Var.f128739d : null;
                String str4 = t7Var != null ? t7Var.f128740e : null;
                int i16 = t7Var != null ? t7Var.f128741f : 1000;
                String str5 = str3;
                if (!m.a().a(str, i3, str2, str3, str4, i16, c16)) {
                    w.b("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, save data fail");
                    return;
                }
                if (w0.c(e0Var.f127534h)) {
                    return;
                }
                c cVar = new c();
                cVar.f141214a = str;
                cVar.f141215b = i3;
                cVar.f141218e = str2;
                cVar.f141216c = str5;
                cVar.f141217d = str4;
                cVar.f141219f = i16;
                cVar.f141220g = c16;
                w.d("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData success, send data event to app(%s), appId:%s", e0Var.f127530d, e0Var.f127534h);
                if (TextUtils.isEmpty(this.f141234a)) {
                    return;
                }
                new h(this.f141234a, cVar).c();
                return;
            }
            w.f("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, no username or data in response");
            return;
        }
        w.f("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, request item or response item is null");
    }

    @Override // com.tencent.luggage.wxa.tc.i
    public void a(int i3) {
        w.b("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi fail, type(%d)", Integer.valueOf(i3));
    }
}
