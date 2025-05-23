package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes31.dex */
public final class QPlusCrowdOption implements ISSOReqModel, ISSORspModel<QPlusCrowdOption> {
    public final ArrayList<Long> creatorIds;
    public final ArrayList<Long> qqGroupIds;

    public /* synthetic */ QPlusCrowdOption() {
        this(null, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<Long> arrayList = this.qqGroupIds;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.s(((Number) it.next()).longValue());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "qq_group_ids", bVar);
        ArrayList<Long> arrayList2 = this.creatorIds;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3.s(((Number) it5.next()).longValue());
            }
        }
        eVar.v("creator_ids", m3);
        return eVar;
    }

    public QPlusCrowdOption(ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
        this.qqGroupIds = arrayList;
        this.creatorIds = arrayList2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCrowdOption decode(e eVar) {
        ArrayList arrayList;
        b l3 = eVar.l("qq_group_ids");
        ArrayList arrayList2 = null;
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                arrayList.add(Long.valueOf(l3.m(i3)));
            }
        } else {
            arrayList = null;
        }
        b l16 = eVar.l("creator_ids");
        if (l16 != null) {
            arrayList2 = new ArrayList();
            int c17 = l16.c();
            for (int i16 = 0; i16 < c17; i16++) {
                arrayList2.add(Long.valueOf(l16.m(i16)));
            }
        }
        return new QPlusCrowdOption(arrayList, arrayList2);
    }
}
