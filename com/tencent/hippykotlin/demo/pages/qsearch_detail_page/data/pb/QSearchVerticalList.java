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
public final class QSearchVerticalList implements ISSOReqModel, ISSORspModel<QSearchVerticalList> {
    public final QSearchButton button;
    public final List<QSearchListDetail> list;
    public final QSearchText subTitle;
    public final QSearchText title;

    public QSearchVerticalList(QSearchText qSearchText, QSearchText qSearchText2, QSearchButton qSearchButton, List<QSearchListDetail> list) {
        this.title = qSearchText;
        this.subTitle = qSearchText2;
        this.button = qSearchButton;
        this.list = list;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        QSearchText qSearchText = this.title;
        if (qSearchText != null) {
            eVar.v("title", qSearchText.encode());
        }
        QSearchText qSearchText2 = this.subTitle;
        if (qSearchText2 != null) {
            eVar.v("sub_title", qSearchText2.encode());
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
    public final QSearchVerticalList decode(e eVar) {
        ArrayList arrayList;
        e m3 = eVar.m("title");
        QSearchText m16 = m3 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m3) : null;
        e m17 = eVar.m("sub_title");
        QSearchText m18 = m17 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m17) : null;
        e m19 = eVar.m("button");
        QSearchButton decode = m19 != null ? new QSearchButton(null, null, null, 0, 15, null).decode(m19) : null;
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
        return new QSearchVerticalList(m16, m18, decode, arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null);
    }
}
