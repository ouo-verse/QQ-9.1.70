package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.weiyun.poi.PoiDbManager;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchCity implements ISSOReqModel, ISSORspModel<UnifySearchCity> {
    public final int cityId;
    public final List<UnifySearchDistrict> districtsNew;
    public final String name;

    public UnifySearchCity() {
        this(null, null, 0, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b a16 = o.a(eVar, "name", this.name);
        List<UnifySearchDistrict> list = this.districtsNew;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                a16.t(((UnifySearchDistrict) it.next()).encode());
            }
        }
        eVar.v("districts_new", a16);
        eVar.t(PoiDbManager.COL_POI_CITY_ID, this.cityId);
        return eVar;
    }

    public UnifySearchCity(String str, List<UnifySearchDistrict> list, int i3) {
        this.name = str;
        this.districtsNew = list;
        this.cityId = i3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchCity decode(e eVar) {
        ArrayList arrayList;
        String q16 = eVar.q("name", "");
        b l3 = eVar.l("districts_new");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new UnifySearchDistrict(eVar2.q("name", ""), eVar2.k(PoiDbManager.COL_POI_CITY_ID, 0)));
                }
            }
        } else {
            arrayList = null;
        }
        return new UnifySearchCity(q16, arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null, eVar.k(PoiDbManager.COL_POI_CITY_ID, 0));
    }

    public /* synthetic */ UnifySearchCity(String str, List list, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, 0);
    }
}
