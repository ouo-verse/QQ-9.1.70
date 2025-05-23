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

/* loaded from: classes32.dex */
public final class UnifySearchProvince implements ISSOReqModel, ISSORspModel<UnifySearchProvince> {
    public final int cityId;
    public final List<UnifySearchCity> citys;
    public final String name;

    public UnifySearchProvince() {
        this(null, null, 0, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b a16 = o.a(eVar, "name", this.name);
        List<UnifySearchCity> list = this.citys;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                a16.t(((UnifySearchCity) it.next()).encode());
            }
        }
        eVar.v("citys", a16);
        eVar.t(PoiDbManager.COL_POI_CITY_ID, this.cityId);
        return eVar;
    }

    public UnifySearchProvince(String str, List<UnifySearchCity> list, int i3) {
        this.name = str;
        this.citys = list;
        this.cityId = i3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchProvince decode(e eVar) {
        int i3;
        ArrayList arrayList;
        String str;
        b bVar;
        int i16;
        ArrayList arrayList2;
        String str2;
        int i17;
        String str3 = "name";
        String q16 = eVar.q("name", "");
        b l3 = eVar.l("citys");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            int i18 = 0;
            while (i18 < c16) {
                Object d16 = l3.d(i18);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    String q17 = eVar2.q(str3, "");
                    b l16 = eVar2.l("districts_new");
                    if (l16 != null) {
                        arrayList2 = new ArrayList();
                        int c17 = l16.c();
                        int i19 = 0;
                        while (i19 < c17) {
                            b bVar2 = l3;
                            Object d17 = l16.d(i19);
                            if (d17 != null) {
                                Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                e eVar3 = (e) d17;
                                i17 = c17;
                                str2 = str3;
                                arrayList2.add(new UnifySearchDistrict(eVar3.q(str3, ""), eVar3.k(PoiDbManager.COL_POI_CITY_ID, 0)));
                            } else {
                                str2 = str3;
                                i17 = c17;
                            }
                            i19++;
                            l3 = bVar2;
                            c17 = i17;
                            str3 = str2;
                        }
                        str = str3;
                        bVar = l3;
                        i16 = 0;
                    } else {
                        str = str3;
                        bVar = l3;
                        i16 = 0;
                        arrayList2 = null;
                    }
                    arrayList.add(new UnifySearchCity(q17, arrayList2 != null ? CollectionsKt___CollectionsKt.toList(arrayList2) : null, eVar2.k(PoiDbManager.COL_POI_CITY_ID, i16)));
                } else {
                    str = str3;
                    bVar = l3;
                }
                i18++;
                l3 = bVar;
                str3 = str;
            }
            i3 = 0;
        } else {
            i3 = 0;
            arrayList = null;
        }
        return new UnifySearchProvince(q16, arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null, eVar.k(PoiDbManager.COL_POI_CITY_ID, i3));
    }

    public /* synthetic */ UnifySearchProvince(String str, List list, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, 0);
    }
}
