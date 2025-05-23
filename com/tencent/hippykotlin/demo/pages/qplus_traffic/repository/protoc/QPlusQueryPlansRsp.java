package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusQueryPlansRsp implements ISSOReqModel, ISSORspModel<QPlusQueryPlansRsp> {
    public final String cookie;
    public final ArrayList<QPlusPlanItem> planItems;

    public QPlusQueryPlansRsp() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<QPlusPlanItem> arrayList = this.planItems;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusPlanItem) it.next()).encode());
            }
        }
        eVar.v("plan_items", bVar);
        eVar.v("cookie", this.cookie);
        return eVar;
    }

    public QPlusQueryPlansRsp(ArrayList<QPlusPlanItem> arrayList, String str) {
        this.planItems = arrayList;
        this.cookie = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusQueryPlansRsp decode(e eVar) {
        ArrayList arrayList;
        b l3 = eVar.l("plan_items");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    QPlusPlanItem qPlusPlanItem = new QPlusPlanItem(null, 0, null, null, 0, null, null, null, null, 511, null);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList.add(qPlusPlanItem.decode((e) d16));
                }
            }
        } else {
            arrayList = null;
        }
        return new QPlusQueryPlansRsp(arrayList, eVar.q("cookie", ""));
    }

    public /* synthetic */ QPlusQueryPlansRsp(ArrayList arrayList, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, "");
    }
}
