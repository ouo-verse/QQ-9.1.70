package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchHorizontalList implements ISSOReqModel, ISSORspModel<QSearchHorizontalList> {
    public final QSearchButton button;
    public final List<QSearchListDetail> list;
    public final int listType;
    public final QSearchText title;

    public QSearchHorizontalList(int i3, QSearchText qSearchText, QSearchButton qSearchButton, List<QSearchListDetail> list) {
        this.listType = i3;
        this.title = qSearchText;
        this.button = qSearchButton;
        this.list = list;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("list_type", this.listType);
        QSearchText qSearchText = this.title;
        if (qSearchText != null) {
            eVar.v("title", qSearchText.encode());
        }
        QSearchButton qSearchButton = this.button;
        if (qSearchButton != null) {
            eVar.v("button", qSearchButton.encode());
        }
        b bVar = new b();
        List<QSearchListDetail> list = this.list;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t(((QSearchListDetail) it.next()).encode());
            }
        }
        eVar.v("list", bVar);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchHorizontalList decode(e eVar) {
        ArrayList arrayList;
        int k3 = eVar.k("list_type", 0);
        e m3 = eVar.m("title");
        QSearchText m16 = m3 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m3) : null;
        e m17 = eVar.m("button");
        QSearchButton decode = m17 != null ? new QSearchButton(null, null, null, 0, 15, null).decode(m17) : null;
        b l3 = eVar.l("list");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    QSearchListDetail qSearchListDetail = new QSearchListDetail(null, null, null, null, null, null, 63, null);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList.add(qSearchListDetail.decode((e) d16));
                }
            }
        } else {
            arrayList = null;
        }
        return new QSearchHorizontalList(k3, m16, decode, arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null);
    }
}
