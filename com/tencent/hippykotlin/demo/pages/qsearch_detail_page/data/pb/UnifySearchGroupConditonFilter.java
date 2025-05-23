package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.weiyun.poi.PoiDbManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchGroupConditonFilter implements ISSOReqModel, ISSORspModel<UnifySearchGroupConditonFilter> {
    public UnifySearchGeoInfo geoInfo;
    public int groupRankType;
    public List<String> tags;

    public /* synthetic */ UnifySearchGroupConditonFilter() {
        this(0, null, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("group_rank_type", this.groupRankType);
        b bVar = new b();
        List<String> list = this.tags;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t((String) it.next());
            }
        }
        eVar.v(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, bVar);
        UnifySearchGeoInfo unifySearchGeoInfo = this.geoInfo;
        if (unifySearchGeoInfo != null) {
            eVar.v("geo_info", unifySearchGeoInfo.encode());
        }
        return eVar;
    }

    public UnifySearchGroupConditonFilter(int i3, List<String> list, UnifySearchGeoInfo unifySearchGeoInfo) {
        this.groupRankType = i3;
        this.tags = list;
        this.geoInfo = unifySearchGeoInfo;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchGroupConditonFilter decode(e eVar) {
        ArrayList arrayList;
        int k3 = eVar.k("group_rank_type", 0);
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
        e m3 = eVar.m("geo_info");
        return new UnifySearchGroupConditonFilter(k3, arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null, m3 != null ? new UnifySearchGeoInfo(m3.k(PoiDbManager.COL_POI_CITY_ID, 0)) : null);
    }
}
