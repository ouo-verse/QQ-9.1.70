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
public final class QPlusOverviewData implements ISSOReqModel, ISSORspModel<QPlusOverviewData> {
    public final ArrayList<QPlusDateIndex> dateIndexs;
    public final QPlusViewTab viewTab;

    public QPlusOverviewData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        QPlusViewTab qPlusViewTab = this.viewTab;
        if (qPlusViewTab != null) {
            eVar.v("view_tab", qPlusViewTab.encode());
        }
        b bVar = new b();
        ArrayList<QPlusDateIndex> arrayList = this.dateIndexs;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusDateIndex) it.next()).encode());
            }
        }
        eVar.v("date_indexs", bVar);
        return eVar;
    }

    public QPlusOverviewData(QPlusViewTab qPlusViewTab, ArrayList<QPlusDateIndex> arrayList) {
        this.viewTab = qPlusViewTab;
        this.dateIndexs = arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusOverviewData decode(e eVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        e m3 = eVar.m("view_tab");
        QPlusViewTab qPlusViewTab = m3 != null ? new QPlusViewTab(m3.k("content_type", 0), m3.q("tab_name", "")) : null;
        b l3 = eVar.l("date_indexs");
        if (l3 != null) {
            ArrayList arrayList3 = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    int k3 = eVar2.k("date_type", 0);
                    b l16 = eVar2.l("indexs");
                    if (l16 != null) {
                        arrayList2 = new ArrayList();
                        int c17 = l16.c();
                        for (int i16 = 0; i16 < c17; i16++) {
                            Object d17 = l16.d(i16);
                            if (d17 != null) {
                                Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                e eVar3 = (e) d17;
                                arrayList2.add(new QPlusIndex(eVar3.q("index_name", ""), eVar3.k("cnt", 0)));
                            }
                        }
                    } else {
                        arrayList2 = null;
                    }
                    arrayList3.add(new QPlusDateIndex(k3, arrayList2));
                }
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        return new QPlusOverviewData(qPlusViewTab, arrayList);
    }

    public /* synthetic */ QPlusOverviewData(QPlusViewTab qPlusViewTab, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }
}
