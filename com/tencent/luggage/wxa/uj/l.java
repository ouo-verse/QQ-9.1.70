package com.tencent.luggage.wxa.uj;

import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uj.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f142509a = new l();

    /* renamed from: b, reason: collision with root package name */
    public static final f0 f142510b = f0.e("MicroMsg.PhoneItemsManager");

    public final List a(List list, List list2) {
        boolean z16;
        if (list == null) {
            return null;
        }
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                k kVar = (k) it.next();
                if (kVar.i()) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        k kVar2 = (k) it5.next();
                        if (Intrinsics.areEqual(kVar.f(), kVar2.f())) {
                            kVar2.a(true);
                            z16 = true;
                            break;
                        }
                    }
                }
            }
        }
        z16 = false;
        if (!z16 && list.size() >= 1) {
            ((k) list.get(0)).a(true);
        }
        w.g("MicroMsg.PhoneItemsManager", "init oldphoneItems:%s", list2);
        w.g("MicroMsg.PhoneItemsManager", "init phoneItems:%s", list);
        return list;
    }

    public final List a() {
        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray(f142510b.getString("PhoneItemsManager#PhoneItems", "{}"));
        } catch (Exception e16) {
            w.b("MicroMsg.PhoneItemsManager", "e:%s", e16);
            jSONArray = null;
        }
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                k.a aVar = k.f142498k;
                String string = jSONArray.getString(i3);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                k a16 = aVar.a(string);
                if (a16 != null) {
                    arrayList.add(a16);
                }
            }
        }
        w.a("MicroMsg.PhoneItemsManager", "get %s", String.valueOf(jSONArray));
        return arrayList;
    }

    public final void a(List list) {
        if (list == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(((k) it.next()).k());
        }
        f0 f0Var = f142510b;
        f0Var.putString("PhoneItemsManager#PhoneItems", jSONArray.toString());
        f0Var.commit();
        w.a("MicroMsg.PhoneItemsManager", "savePhoneNumbers %s", jSONArray.toString());
    }

    public final void a(k kVar) {
        List<k> a16 = a();
        if (kVar != null) {
            Iterator it = a16.iterator();
            while (it.hasNext()) {
                ((k) it.next()).a(false);
            }
            for (k kVar2 : a16) {
                if (Intrinsics.areEqual(kVar.f(), kVar2.f())) {
                    kVar2.a(true);
                }
            }
        }
        a(a16);
        w.g("MicroMsg.PhoneItemsManager", "uninit phoneItems:%s", a16);
    }
}
