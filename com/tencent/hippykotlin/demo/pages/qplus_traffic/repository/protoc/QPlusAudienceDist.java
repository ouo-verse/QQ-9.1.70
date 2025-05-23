package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusAudienceDist implements ISSOReqModel, ISSORspModel<QPlusAudienceDist> {
    public final ArrayList<QPlusFeatureDist> ageDist;
    public final ArrayList<QPlusFeatureDist> cityDist;
    public final ArrayList<QPlusFeatureDist> sexDist;

    public QPlusAudienceDist(ArrayList<QPlusFeatureDist> arrayList, ArrayList<QPlusFeatureDist> arrayList2, ArrayList<QPlusFeatureDist> arrayList3) {
        this.ageDist = arrayList;
        this.sexDist = arrayList2;
        this.cityDist = arrayList3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<QPlusFeatureDist> arrayList = this.ageDist;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusFeatureDist) it.next()).encode());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "age_dist", bVar);
        ArrayList<QPlusFeatureDist> arrayList2 = this.sexDist;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3.t(((QPlusFeatureDist) it5.next()).encode());
            }
        }
        b m16 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "sex_dist", m3);
        ArrayList<QPlusFeatureDist> arrayList3 = this.cityDist;
        if (arrayList3 != null) {
            Iterator<T> it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                m16.t(((QPlusFeatureDist) it6.next()).encode());
            }
        }
        eVar.v("city_dist", m16);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusAudienceDist decode(e eVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        b l3 = eVar.l("age_dist");
        ArrayList arrayList3 = null;
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new QPlusFeatureDist(eVar2.q("feature_name", ""), eVar2.k("percent", 0)));
                }
            }
        } else {
            arrayList = null;
        }
        b l16 = eVar.l("sex_dist");
        if (l16 != null) {
            arrayList2 = new ArrayList();
            int c17 = l16.c();
            for (int i16 = 0; i16 < c17; i16++) {
                Object d17 = l16.d(i16);
                if (d17 != null) {
                    Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar3 = (e) d17;
                    arrayList2.add(new QPlusFeatureDist(eVar3.q("feature_name", ""), eVar3.k("percent", 0)));
                }
            }
        } else {
            arrayList2 = null;
        }
        b l17 = eVar.l("city_dist");
        if (l17 != null) {
            arrayList3 = new ArrayList();
            int c18 = l17.c();
            for (int i17 = 0; i17 < c18; i17++) {
                Object d18 = l17.d(i17);
                if (d18 != null) {
                    Intrinsics.checkNotNull(d18, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar4 = (e) d18;
                    arrayList3.add(new QPlusFeatureDist(eVar4.q("feature_name", ""), eVar4.k("percent", 0)));
                }
            }
        }
        return new QPlusAudienceDist(arrayList, arrayList2, arrayList3);
    }
}
