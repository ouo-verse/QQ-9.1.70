package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusProfileOption implements ISSOReqModel, ISSORspModel<QPlusProfileOption> {
    public final ArrayList<QPlusAgeRange> ageRanges;
    public final ArrayList<QPlusCity> cities;
    public final QPlusCrowdOption crowdOption;
    public final QPlusPortraitOption portraitOption;
    public final int sexType;
    public final ArrayList<QPlusTag> tags;

    public QPlusProfileOption(int i3, ArrayList<QPlusAgeRange> arrayList, ArrayList<QPlusCity> arrayList2, ArrayList<QPlusTag> arrayList3, QPlusCrowdOption qPlusCrowdOption, QPlusPortraitOption qPlusPortraitOption) {
        this.sexType = i3;
        this.ageRanges = arrayList;
        this.cities = arrayList2;
        this.tags = arrayList3;
        this.crowdOption = qPlusCrowdOption;
        this.portraitOption = qPlusPortraitOption;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("sex_type", this.sexType);
        b bVar = new b();
        ArrayList<QPlusAgeRange> arrayList = this.ageRanges;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusAgeRange) it.next()).encode());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "age_ranges", bVar);
        ArrayList<QPlusCity> arrayList2 = this.cities;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3.t(((QPlusCity) it5.next()).encode());
            }
        }
        b m16 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "cities", m3);
        ArrayList<QPlusTag> arrayList3 = this.tags;
        if (arrayList3 != null) {
            Iterator<T> it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                m16.t(((QPlusTag) it6.next()).encode());
            }
        }
        eVar.v(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, m16);
        QPlusCrowdOption qPlusCrowdOption = this.crowdOption;
        if (qPlusCrowdOption != null) {
            eVar.v("crowd_option", qPlusCrowdOption.encode());
        }
        QPlusPortraitOption qPlusPortraitOption = this.portraitOption;
        if (qPlusPortraitOption != null) {
            eVar.v("portrait_option", qPlusPortraitOption.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusProfileOption decode(e eVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        QPlusCrowdOption qPlusCrowdOption;
        QPlusPortraitOption qPlusPortraitOption;
        ArrayList arrayList4;
        ArrayList arrayList5;
        int k3 = eVar.k("sex_type", 0);
        b l3 = eVar.l("age_ranges");
        ArrayList arrayList6 = null;
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new QPlusAgeRange(eVar2.k("from", 0), eVar2.k("to", 0)));
                }
            }
        } else {
            arrayList = null;
        }
        b l16 = eVar.l("cities");
        if (l16 != null) {
            arrayList2 = new ArrayList();
            int c17 = l16.c();
            for (int i16 = 0; i16 < c17; i16++) {
                Object d17 = l16.d(i16);
                if (d17 != null) {
                    Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar3 = (e) d17;
                    arrayList2.add(new QPlusCity(eVar3.k("city_code", 0), eVar3.k("city_level", 0)));
                }
            }
        } else {
            arrayList2 = null;
        }
        b l17 = eVar.l(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
        if (l17 != null) {
            arrayList3 = new ArrayList();
            int c18 = l17.c();
            for (int i17 = 0; i17 < c18; i17++) {
                Object d18 = l17.d(i17);
                if (d18 != null) {
                    Intrinsics.checkNotNull(d18, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList3.add(new QPlusTag(((e) d18).q("tag_name", "")));
                }
            }
        } else {
            arrayList3 = null;
        }
        e m3 = eVar.m("crowd_option");
        if (m3 != null) {
            b l18 = m3.l("qq_group_ids");
            if (l18 != null) {
                arrayList4 = new ArrayList();
                int c19 = l18.c();
                for (int i18 = 0; i18 < c19; i18++) {
                    arrayList4.add(Long.valueOf(l18.m(i18)));
                }
            } else {
                arrayList4 = null;
            }
            b l19 = m3.l("creator_ids");
            if (l19 != null) {
                arrayList5 = new ArrayList();
                int c26 = l19.c();
                for (int i19 = 0; i19 < c26; i19++) {
                    arrayList5.add(Long.valueOf(l19.m(i19)));
                }
            } else {
                arrayList5 = null;
            }
            qPlusCrowdOption = new QPlusCrowdOption(arrayList4, arrayList5);
        } else {
            qPlusCrowdOption = null;
        }
        e m16 = eVar.m("portrait_option");
        if (m16 != null) {
            b l26 = m16.l("portrait_url");
            if (l26 != null) {
                arrayList6 = new ArrayList();
                int c27 = l26.c();
                for (int i26 = 0; i26 < c27; i26++) {
                    String o16 = l26.o(i26);
                    if (o16 != null) {
                        arrayList6.add(o16);
                    }
                }
            }
            qPlusPortraitOption = new QPlusPortraitOption(arrayList6);
        } else {
            qPlusPortraitOption = null;
        }
        return new QPlusProfileOption(k3, arrayList, arrayList2, arrayList3, qPlusCrowdOption, qPlusPortraitOption);
    }
}
