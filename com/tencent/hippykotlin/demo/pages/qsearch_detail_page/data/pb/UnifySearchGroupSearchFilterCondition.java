package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchGroupSearchFilterCondition implements ISSOReqModel, ISSORspModel<UnifySearchGroupSearchFilterCondition> {
    public final List<UnifySearchProvince> geoInfo;
    public final List<UnifySearchGroupContentRankType> groupContentRankType;
    public final List<String> tags;

    public UnifySearchGroupSearchFilterCondition(List<String> list, List<UnifySearchProvince> list2, List<UnifySearchGroupContentRankType> list3) {
        this.tags = list;
        this.geoInfo = list2;
        this.groupContentRankType = list3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        List<String> list = this.tags;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t((String) it.next());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, ComicCancelRedPointPopItemData.JSON_KEY_TAGS, bVar);
        List<UnifySearchProvince> list2 = this.geoInfo;
        if (list2 != null) {
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                m3.t(((UnifySearchProvince) it5.next()).encode());
            }
        }
        b m16 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "geo_info", m3);
        List<UnifySearchGroupContentRankType> list3 = this.groupContentRankType;
        if (list3 != null) {
            Iterator<T> it6 = list3.iterator();
            while (it6.hasNext()) {
                m16.t(((UnifySearchGroupContentRankType) it6.next()).encode());
            }
        }
        eVar.v("group_content_rank_type", m16);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchGroupSearchFilterCondition decode(e eVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        b l3 = eVar.l(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                String o16 = l3.o(i3);
                if (o16 != null) {
                    arrayList.add(o16);
                }
            }
        } else {
            arrayList = null;
        }
        b l16 = eVar.l("geo_info");
        if (l16 != null) {
            arrayList2 = new ArrayList();
            int c17 = l16.c();
            for (int i16 = 0; i16 < c17; i16++) {
                Object d16 = l16.d(i16);
                if (d16 != null) {
                    UnifySearchProvince unifySearchProvince = new UnifySearchProvince(null, null, 0, 7, null);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList2.add(unifySearchProvince.decode((e) d16));
                }
            }
        } else {
            arrayList2 = null;
        }
        b l17 = eVar.l("group_content_rank_type");
        if (l17 != null) {
            arrayList3 = new ArrayList();
            int c18 = l17.c();
            for (int i17 = 0; i17 < c18; i17++) {
                Object d17 = l17.d(i17);
                if (d17 != null) {
                    Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d17;
                    arrayList3.add(new UnifySearchGroupContentRankType(eVar2.k("rank_type_id", 0), eVar2.q("rank_type_text", "")));
                }
            }
        } else {
            arrayList3 = null;
        }
        return new UnifySearchGroupSearchFilterCondition(arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null, arrayList2 != null ? CollectionsKt___CollectionsKt.toList(arrayList2) : null, arrayList3 != null ? CollectionsKt___CollectionsKt.toList(arrayList3) : null);
    }
}
