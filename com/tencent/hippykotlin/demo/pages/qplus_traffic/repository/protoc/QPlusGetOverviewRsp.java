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
public final class QPlusGetOverviewRsp implements ISSOReqModel, ISSORspModel<QPlusGetOverviewRsp> {
    public final ArrayList<QPlusOverviewData> overviewDatas;

    public QPlusGetOverviewRsp() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusGetOverviewRsp decode(e eVar) {
        b l3 = eVar.l("overview_datas");
        ArrayList arrayList = null;
        if (l3 != null) {
            ArrayList arrayList2 = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    QPlusOverviewData qPlusOverviewData = new QPlusOverviewData(null, null);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList2.add(qPlusOverviewData.decode((e) d16));
                }
            }
            arrayList = arrayList2;
        }
        return new QPlusGetOverviewRsp(arrayList);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<QPlusOverviewData> arrayList = this.overviewDatas;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusOverviewData) it.next()).encode());
            }
        }
        eVar.v("overview_datas", bVar);
        return eVar;
    }

    public QPlusGetOverviewRsp(ArrayList<QPlusOverviewData> arrayList) {
        this.overviewDatas = arrayList;
    }

    public /* synthetic */ QPlusGetOverviewRsp(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }
}
