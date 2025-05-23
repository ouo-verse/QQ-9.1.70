package com.tencent.luggage.wxa.tc;

import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.hn.e0;
import com.tencent.luggage.wxa.hn.t7;
import com.tencent.luggage.wxa.hn.ve;
import com.tencent.luggage.wxa.hn.we;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xo.e;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static void a(String str, String str2, int i3, String str3, int i16, i iVar) {
        if (w0.c(str2)) {
            w.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, username is null");
            return;
        }
        a a16 = a(str2);
        if (a16 != null && !a16.f141210a) {
            w.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, app(%s_v%d) can not pre fetch data", str2, Integer.valueOf(i3));
        } else {
            com.tencent.luggage.wxa.ap.b b16 = b(str3);
            a(str, str2, (String) b16.b(), (String) b16.c(), i16, iVar);
        }
    }

    public static com.tencent.luggage.wxa.ap.b b(String str) {
        String str2 = null;
        if (!w0.c(str)) {
            int lastIndexOf = str.lastIndexOf(63);
            if (lastIndexOf > 0) {
                String substring = str.substring(0, lastIndexOf);
                if (lastIndexOf < str.length() - 1) {
                    str2 = str.substring(lastIndexOf + 1);
                }
                str = substring;
            }
        } else {
            str = null;
        }
        return com.tencent.luggage.wxa.ap.j.a(str, str2);
    }

    public static void a(String str, String str2, String str3, String str4, int i3, i iVar) {
        w.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, app(%s) pre fetch data start, path:%s, query:%s, scene:%d", str2, str3, str4, Integer.valueOf(i3));
        e0 e0Var = new e0();
        e0Var.f127534h = str;
        e0Var.f127530d = str2;
        e0Var.f127531e = 0;
        t7 t7Var = new t7();
        e0Var.f127532f = t7Var;
        t7Var.f128741f = i3;
        if (!w0.c(str3)) {
            e0Var.f127532f.f128739d = str3;
        }
        if (!w0.c(str4)) {
            e0Var.f127532f.f128740e = str4;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(e0Var);
        a(0, linkedList, iVar);
    }

    public static void a(final int i3, List list, final i iVar) {
        if (list != null && !list.isEmpty() && iVar != null) {
            w.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, size:%d", Integer.valueOf(list.size()));
            final ve veVar = new ve();
            veVar.f128918e.addAll(list);
            ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxabusiness/fetchdata", null, veVar, we.class).a(new e.c() { // from class: com.tencent.luggage.wxa.tc.k
                @Override // com.tencent.luggage.wxa.xo.e.c
                public final void a(Object obj) {
                    b.a(i.this, veVar, i3, (we) obj);
                }
            }).a(new e.a() { // from class: com.tencent.luggage.wxa.tc.l
                @Override // com.tencent.luggage.wxa.xo.e.a
                public final void a(Object obj) {
                    b.a(i.this, i3, obj);
                }
            });
            return;
        }
        w.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, requestList or callback is null");
    }

    public static /* synthetic */ void a(i iVar, ve veVar, int i3, we weVar) {
        LinkedList linkedList = weVar.f128972e;
        if (linkedList != null && !linkedList.isEmpty()) {
            w.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data success");
            iVar.a(weVar.f128972e, veVar.f128918e);
        } else {
            w.b("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:data is null");
            iVar.a(i3);
        }
    }

    public static /* synthetic */ void a(i iVar, int i3, Object obj) {
        w.b("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:request fail");
        iVar.a(i3);
    }

    public static a a(String str) {
        n0 b16 = o0.a().b(str, new String[0]);
        if (b16 == null) {
            return null;
        }
        a aVar = new a();
        aVar.f141210a = b16.g().f125894a.I;
        aVar.f141211b = b16.g().f125894a.J;
        aVar.f141212c = b16.g().f125894a.K;
        aVar.f141213d = b16.g().f125894a.L;
        return aVar;
    }
}
