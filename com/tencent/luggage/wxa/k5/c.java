package com.tencent.luggage.wxa.k5;

import com.tencent.luggage.wxa.hn.fi;
import com.tencent.luggage.wxa.hn.gi;
import com.tencent.luggage.wxa.hn.n9;
import com.tencent.luggage.wxa.k5.b;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f131439a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f131440b;

    public c(fi usageInfo) {
        ArrayList arrayList;
        boolean z16;
        b.c cVar;
        Intrinsics.checkNotNullParameter(usageInfo, "usageInfo");
        ArrayList arrayList2 = new ArrayList();
        this.f131440b = arrayList2;
        gi giVar = usageInfo.f127650d;
        Intrinsics.checkNotNullExpressionValue(giVar, "usageInfo.wxa_item");
        arrayList2.add(new b.a(giVar));
        LinkedList<n9> linkedList = usageInfo.f127650d.f127728g;
        if (linkedList != null) {
            for (n9 n9Var : linkedList) {
                if (n9Var != null) {
                    ArrayList arrayList3 = this.f131440b;
                    gi giVar2 = usageInfo.f127650d;
                    Intrinsics.checkNotNullExpressionValue(giVar2, "usageInfo.wxa_item");
                    arrayList3.add(new b.c(new com.tencent.luggage.wxa.i5.h(giVar2, null, n9Var)));
                }
            }
        }
        LinkedList<gi> linkedList2 = usageInfo.f127651e;
        if (linkedList2 != null) {
            for (gi giVar3 : linkedList2) {
                if (giVar3 != null) {
                    LinkedList<n9> scope_item_list = giVar3.f127728g;
                    if (scope_item_list != null) {
                        Intrinsics.checkNotNullExpressionValue(scope_item_list, "scope_item_list");
                        arrayList = new ArrayList();
                        for (n9 n9Var2 : scope_item_list) {
                            if (n9Var2 != null) {
                                gi giVar4 = usageInfo.f127650d;
                                Intrinsics.checkNotNullExpressionValue(giVar4, "usageInfo.wxa_item");
                                cVar = new b.c(new com.tencent.luggage.wxa.i5.h(giVar4, giVar3, n9Var2));
                            } else {
                                cVar = null;
                            }
                            if (cVar != null) {
                                arrayList.add(cVar);
                            }
                        }
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null && !arrayList.isEmpty()) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        ArrayList arrayList4 = this.f131440b;
                        String str = giVar3.f127726e;
                        if (str == null) {
                            str = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str, "pluginUseItem.nick_name ?: \"\"");
                        }
                        arrayList4.add(new b.C6357b(str));
                        this.f131440b.addAll(arrayList);
                    }
                }
            }
        }
        this.f131439a = this.f131440b.size();
    }

    public final int a() {
        return this.f131439a;
    }

    public final b a(int i3) {
        Object obj = this.f131440b.get(i3);
        Intrinsics.checkNotNullExpressionValue(obj, "flattenList[index]");
        return (b) obj;
    }
}
