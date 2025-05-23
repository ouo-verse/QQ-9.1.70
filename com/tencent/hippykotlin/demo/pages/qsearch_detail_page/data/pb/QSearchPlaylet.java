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

/* loaded from: classes32.dex */
public final class QSearchPlaylet implements ISSOReqModel, ISSORspModel<QSearchPlaylet> {
    public final QSearchText describe;
    public final QSearchPicture mainPic;
    public QSearchButton moreButton;
    public final QSearchButton playButton;
    public List<QSearchButton> playletButton;
    public final QSearchText subTitle;
    public final QSearchText title;

    public QSearchPlaylet(QSearchPicture qSearchPicture, QSearchText qSearchText, QSearchText qSearchText2, QSearchText qSearchText3, QSearchButton qSearchButton, List<QSearchButton> list, QSearchButton qSearchButton2) {
        this.mainPic = qSearchPicture;
        this.title = qSearchText;
        this.subTitle = qSearchText2;
        this.describe = qSearchText3;
        this.playButton = qSearchButton;
        this.playletButton = list;
        this.moreButton = qSearchButton2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        QSearchPicture qSearchPicture = this.mainPic;
        if (qSearchPicture != null) {
            eVar.v("main_pic", qSearchPicture.encode());
        }
        QSearchText qSearchText = this.title;
        if (qSearchText != null) {
            eVar.v("title", qSearchText.encode());
        }
        QSearchText qSearchText2 = this.subTitle;
        if (qSearchText2 != null) {
            eVar.v("sub_title", qSearchText2.encode());
        }
        QSearchText qSearchText3 = this.describe;
        if (qSearchText3 != null) {
            eVar.v("describe", qSearchText3.encode());
        }
        QSearchButton qSearchButton = this.playButton;
        if (qSearchButton != null) {
            eVar.v("play_button", qSearchButton.encode());
        }
        QSearchButton qSearchButton2 = this.moreButton;
        if (qSearchButton2 != null) {
            eVar.v("more_button", qSearchButton2.encode());
        }
        b bVar = new b();
        List<QSearchButton> list = this.playletButton;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t(((QSearchButton) it.next()).encode());
            }
        }
        eVar.v("playlet_button", bVar);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchPlaylet decode(e eVar) {
        ArrayList arrayList;
        List list;
        List list2;
        e m3 = eVar.m("main_pic");
        QSearchPicture decode = m3 != null ? new QSearchPicture(null, null, 0, 0, null, 31, null).decode(m3) : null;
        e m16 = eVar.m("title");
        QSearchText m17 = m16 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m16) : null;
        e m18 = eVar.m("sub_title");
        QSearchText m19 = m18 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m18) : null;
        e m26 = eVar.m("describe");
        QSearchText m27 = m26 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m26) : null;
        e m28 = eVar.m("play_button");
        QSearchButton decode2 = m28 != null ? new QSearchButton(null, null, null, 0, 15, null).decode(m28) : null;
        b l3 = eVar.l("playlet_button");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    QSearchButton qSearchButton = new QSearchButton(null, null, null, 0, 15, null);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList.add(qSearchButton.decode((e) d16));
                }
            }
        } else {
            arrayList = null;
        }
        e m29 = eVar.m("more_button");
        QSearchButton decode3 = m29 != null ? new QSearchButton(null, null, null, 0, 15, null).decode(m29) : null;
        if (arrayList != null) {
            list2 = CollectionsKt___CollectionsKt.toList(arrayList);
            list = list2;
        } else {
            list = null;
        }
        return new QSearchPlaylet(decode, m17, m19, m27, decode2, list, decode3);
    }
}
