package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.startup.step.InitSkin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchVerticalDetail implements ISSOReqModel, ISSORspModel<QSearchVerticalDetail> {
    public final List<QSearchLabel> bottomLabel;
    public final QSearchButton button;
    public final QSearchIcon icon;
    public final QSearchIcon littleIcon;
    public final QSearchText subTitle;
    public final List<QSearchIcon> tags;
    public final QSearchText title;
    public final List<QSearchLabel> topLabel;

    public QSearchVerticalDetail(QSearchIcon qSearchIcon, QSearchIcon qSearchIcon2, QSearchText qSearchText, List<QSearchIcon> list, QSearchText qSearchText2, List<QSearchLabel> list2, List<QSearchLabel> list3, QSearchButton qSearchButton) {
        this.icon = qSearchIcon;
        this.littleIcon = qSearchIcon2;
        this.title = qSearchText;
        this.tags = list;
        this.subTitle = qSearchText2;
        this.topLabel = list2;
        this.bottomLabel = list3;
        this.button = qSearchButton;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        QSearchIcon qSearchIcon = this.icon;
        if (qSearchIcon != null) {
            eVar.v("icon", qSearchIcon.encode());
        }
        QSearchIcon qSearchIcon2 = this.littleIcon;
        if (qSearchIcon2 != null) {
            eVar.v("little_icon", qSearchIcon2.encode());
        }
        QSearchText qSearchText = this.title;
        if (qSearchText != null) {
            eVar.v("title", qSearchText.encode());
        }
        b bVar = new b();
        List<QSearchIcon> list = this.tags;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t(((QSearchIcon) it.next()).encode());
            }
        }
        eVar.v(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, bVar);
        QSearchText qSearchText2 = this.subTitle;
        if (qSearchText2 != null) {
            eVar.v("sub_title", qSearchText2.encode());
        }
        b bVar2 = new b();
        List<QSearchLabel> list2 = this.topLabel;
        if (list2 != null) {
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                bVar2.t(((QSearchLabel) it5.next()).encode());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "top_label", bVar2);
        List<QSearchLabel> list3 = this.bottomLabel;
        if (list3 != null) {
            Iterator<T> it6 = list3.iterator();
            while (it6.hasNext()) {
                m3.t(((QSearchLabel) it6.next()).encode());
            }
        }
        eVar.v("bottom_label", m3);
        QSearchButton qSearchButton = this.button;
        if (qSearchButton != null) {
            eVar.v("button", qSearchButton.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchVerticalDetail decode(e eVar) {
        QSearchIcon qSearchIcon;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        b bVar;
        String str;
        int i3;
        b bVar2;
        int i16;
        e m3 = eVar.m("icon");
        if (m3 != null) {
            int i17 = 0;
            qSearchIcon = new QSearchIcon(null, null, null, null, 0L, null, null, null, 0, i17, i17, null, 0, InitSkin.DRAWABLE_COUNT, null).decode(m3);
        } else {
            qSearchIcon = null;
        }
        e m16 = eVar.m("little_icon");
        QSearchIcon decode = m16 != null ? new QSearchIcon(null, null, null, null, 0L, null, null, null, 0, 0, 0, null, 0, InitSkin.DRAWABLE_COUNT, null).decode(m16) : null;
        e m17 = eVar.m("title");
        int i18 = 15;
        QSearchText m18 = m17 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m17) : null;
        b l3 = eVar.l(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
        String str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject";
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i19 = 0; i19 < c16; i19++) {
                Object d16 = l3.d(i19);
                if (d16 != null) {
                    QSearchIcon qSearchIcon2 = new QSearchIcon(null, null, null, null, 0L, null, null, null, 0, 0, 0, null, 0, InitSkin.DRAWABLE_COUNT, null);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList.add(qSearchIcon2.decode((e) d16));
                }
            }
        } else {
            arrayList = null;
        }
        e m19 = eVar.m("sub_title");
        QSearchText m26 = m19 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m19) : null;
        b l16 = eVar.l("top_label");
        if (l16 != null) {
            arrayList2 = new ArrayList();
            int c17 = l16.c();
            int i26 = 0;
            while (i26 < c17) {
                Object d17 = l16.d(i26);
                if (d17 != null) {
                    Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d17;
                    bVar2 = l16;
                    e m27 = eVar2.m("text");
                    i16 = c17;
                    QSearchText m28 = m27 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, i18, m27) : null;
                    e m29 = eVar2.m("icon");
                    arrayList2.add(new QSearchLabel(m28, m29 != null ? new QSearchIcon(null, null, null, null, 0L, null, null, null, 0, 0, 0, null, 0, InitSkin.DRAWABLE_COUNT, null).decode(m29) : null, eVar2.k(TtmlNode.TAG_LAYOUT, 0)));
                } else {
                    bVar2 = l16;
                    i16 = c17;
                }
                i26++;
                l16 = bVar2;
                c17 = i16;
                i18 = 15;
            }
        } else {
            arrayList2 = null;
        }
        b l17 = eVar.l("bottom_label");
        if (l17 != null) {
            arrayList3 = new ArrayList();
            int c18 = l17.c();
            int i27 = 0;
            while (i27 < c18) {
                Object d18 = l17.d(i27);
                if (d18 != null) {
                    Intrinsics.checkNotNull(d18, str2);
                    e eVar3 = (e) d18;
                    bVar = l17;
                    e m36 = eVar3.m("text");
                    str = str2;
                    i3 = c18;
                    QSearchText m37 = m36 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m36) : null;
                    e m38 = eVar3.m("icon");
                    arrayList3.add(new QSearchLabel(m37, m38 != null ? new QSearchIcon(null, null, null, null, 0L, null, null, null, 0, 0, 0, null, 0, InitSkin.DRAWABLE_COUNT, null).decode(m38) : null, eVar3.k(TtmlNode.TAG_LAYOUT, 0)));
                } else {
                    bVar = l17;
                    str = str2;
                    i3 = c18;
                }
                i27++;
                l17 = bVar;
                str2 = str;
                c18 = i3;
            }
        } else {
            arrayList3 = null;
        }
        e m39 = eVar.m("button");
        QSearchButton decode2 = m39 != null ? new QSearchButton(null, null, null, 0, 15, null).decode(m39) : null;
        if (arrayList != null) {
            list6 = CollectionsKt___CollectionsKt.toList(arrayList);
            list = list6;
        } else {
            list = null;
        }
        if (arrayList2 != null) {
            list5 = CollectionsKt___CollectionsKt.toList(arrayList2);
            list2 = list5;
        } else {
            list2 = null;
        }
        if (arrayList3 != null) {
            list4 = CollectionsKt___CollectionsKt.toList(arrayList3);
            list3 = list4;
        } else {
            list3 = null;
        }
        return new QSearchVerticalDetail(qSearchIcon, decode, m18, list, m26, list2, list3, decode2);
    }
}
