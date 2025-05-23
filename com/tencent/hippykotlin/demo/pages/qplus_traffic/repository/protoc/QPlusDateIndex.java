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
public final class QPlusDateIndex implements ISSOReqModel, ISSORspModel<QPlusDateIndex> {
    public final int dateType;
    public final ArrayList<QPlusIndex> indexs;

    public QPlusDateIndex() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("date_type", this.dateType);
        b bVar = new b();
        ArrayList<QPlusIndex> arrayList = this.indexs;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusIndex) it.next()).encode());
            }
        }
        eVar.v("indexs", bVar);
        return eVar;
    }

    public QPlusDateIndex(int i3, ArrayList<QPlusIndex> arrayList) {
        this.dateType = i3;
        this.indexs = arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusDateIndex decode(e eVar) {
        ArrayList arrayList;
        int k3 = eVar.k("date_type", 0);
        b l3 = eVar.l("indexs");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new QPlusIndex(eVar2.q("index_name", ""), eVar2.k("cnt", 0)));
                }
            }
        } else {
            arrayList = null;
        }
        return new QPlusDateIndex(k3, arrayList);
    }

    public /* synthetic */ QPlusDateIndex(int i3, ArrayList arrayList, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, null);
    }
}
